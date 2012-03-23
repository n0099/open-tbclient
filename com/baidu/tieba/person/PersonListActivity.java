package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.data.PageData;
import com.baidu.tieba.data.PersonListData;
import com.baidu.tieba.model.PersonListModel;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.write.AtListAdapter;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity {
    public static final String TAG_FOLLOW = "follow";
    public static final String TAG_ID = "un";
    public static final String TAG_PAGE = "pn";
    private PersonListModel mModel;
    private Button mBack = null;
    private ListView mListView = null;
    private ProgressBar mProgress = null;
    private TextView mTitle = null;
    private AtListAdapter mAdapter = null;
    private Handler mHandler = new Handler();
    private PersonListTask mTask = null;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.person.PersonListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                int start = PersonListActivity.this.mListView.getFirstVisiblePosition();
                int end = PersonListActivity.this.mListView.getLastVisiblePosition();
                for (int i = start; i <= end; i++) {
                    if (i < PersonListActivity.this.mAdapter.getCount()) {
                        MetaData data = (MetaData) PersonListActivity.this.mAdapter.getItem(i);
                        if (data != null && data.getPortrait() != null) {
                            PersonListActivity.this.mAdapter.getImageLoader().loadFriendPhoto(data.getPortrait(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.person.PersonListActivity.1.1
                                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                    ImageView view = (ImageView) PersonListActivity.this.mListView.findViewWithTag(imageUrl);
                                    if (view != null && bitmap != null) {
                                        view.setImageBitmap(bitmap);
                                        view.setTag(null);
                                    }
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "mGetImageRunnble.run", ex.getMessage());
            }
        }
    };

    public static void startActivity(Activity activity, boolean isFollow, String id) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (isFollow) {
            intent.putExtra(TAG_FOLLOW, true);
        }
        intent.putExtra("un", id);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_activity);
        InitData(savedInstanceState);
        InitUI();
        startGetNetData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        if (this.mAdapter != null) {
            if (this.mAdapter.getImageLoader() != null) {
                this.mAdapter.getImageLoader().cancelAllAsyncTask();
            }
            this.mAdapter = null;
        }
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mAdapter != null) {
            this.mAdapter.releaseProgressBar();
        }
        super.onDestroy();
    }

    private void InitData(Bundle savedInstanceState) {
        this.mModel = new PersonListModel();
        if (savedInstanceState != null) {
            this.mModel.setIsFollow(savedInstanceState.getBoolean(TAG_FOLLOW, false));
            this.mModel.setId(savedInstanceState.getString("un"));
            return;
        }
        Intent intent = getIntent();
        this.mModel.setIsFollow(intent.getBooleanExtra(TAG_FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("un"));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(TAG_FOLLOW, this.mModel.getIsFollow());
        outState.putString("un", this.mModel.getId());
    }

    private void InitUI() {
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mTitle = (TextView) findViewById(R.id.titel_text);
        if (this.mModel.getIsFollow()) {
            this.mTitle.setText(R.string.attention);
        } else {
            this.mTitle.setText(R.string.fans);
        }
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PersonListActivity.this.finish();
            }
        });
        this.mAdapter = new AtListAdapter(this);
        this.mAdapter.setData(this.mModel.getData().getUserList());
        this.mListView = (ListView) findViewById(R.id.list);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.person.PersonListActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                if (id != -1) {
                    MetaData data = (MetaData) PersonListActivity.this.mAdapter.getItem(position);
                    if (data != null && data.getId() != null) {
                        PersonInfoActivity.startActivity(PersonListActivity.this, data.getId(), data.getName_show());
                        return;
                    }
                    return;
                }
                PersonListActivity.this.startGetNetData(true);
            }
        });
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.person.PersonListActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                PersonListActivity.this.mHandler.removeCallbacks(PersonListActivity.this.mGetImageRunnble);
                PersonListActivity.this.mHandler.postDelayed(PersonListActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetNetData(boolean more) {
        if (this.mTask == null) {
            if (!more) {
                this.mProgress.setVisibility(0);
                this.mTask = new PersonListTask(this.mModel.getId(), this.mModel.getIsFollow(), 0);
                this.mTask.execute(new String[0]);
                return;
            }
            if (this.mAdapter != null) {
                this.mAdapter.setisProcessMore(true);
                this.mAdapter.notifyDataSetChanged();
            }
            this.mTask = new PersonListTask(this.mModel.getId(), this.mModel.getIsFollow(), this.mModel.getData().getPage().getCurrent_page() + 1);
            this.mTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PersonListTask extends AsyncTask<String, Integer, PersonListData> {
        private String mId;
        private boolean mIsFollow;
        private NetWork mNetwork = null;
        private int mPage;

        public PersonListTask(String id, boolean isFollow, int page) {
            this.mId = id;
            this.mIsFollow = isFollow;
            this.mPage = page;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            if (PersonListActivity.this.mAdapter != null) {
                PersonListActivity.this.mAdapter.setisProcessMore(false);
                PersonListActivity.this.mAdapter.notifyDataSetChanged();
            }
            PersonListActivity.this.mProgress.setVisibility(8);
            PersonListActivity.this.mTask = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public PersonListData doInBackground(String... arg0) {
            this.mNetwork = new NetWork();
            if (this.mIsFollow) {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/u/follow/page");
            } else {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/u/fans/page");
            }
            if (this.mId != null) {
                this.mNetwork.addPostData("un", this.mId);
            }
            if (this.mPage != 0) {
                this.mNetwork.addPostData(PersonListActivity.TAG_PAGE, String.valueOf(this.mPage));
            }
            String ret = this.mNetwork.postNetData();
            if (!this.mNetwork.isRequestSuccess()) {
                return null;
            }
            PersonListData data = new PersonListData();
            data.parserJson(ret);
            return data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(PersonListData result) {
            PersonListActivity.this.mProgress.setVisibility(8);
            PersonListActivity.this.mTask = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    if (PersonListActivity.this.mModel != null && result != null) {
                        PersonListActivity.this.mModel.getData().getUserList().addAll(result.getUserList());
                        PersonListActivity.this.mModel.getData().setPage(result.getPage());
                        if (PersonListActivity.this.mAdapter != null) {
                            PageData page = PersonListActivity.this.mModel.getData().getPage();
                            if (page == null || page.getHave_more() != 1) {
                                PersonListActivity.this.mAdapter.setHasMore(false);
                            } else {
                                PersonListActivity.this.mAdapter.setHasMore(true);
                            }
                            PersonListActivity.this.mAdapter.setisProcessMore(false);
                            PersonListActivity.this.mAdapter.notifyDataSetChanged();
                        }
                        if (!this.mIsFollow) {
                            TiebaApplication.app.setMsgFans(0L);
                        }
                    }
                } else {
                    PersonListActivity.this.showToast(this.mNetwork.getErrorString());
                }
                super.onPostExecute((PersonListTask) result);
            }
        }
    }
}
