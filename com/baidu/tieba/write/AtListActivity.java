package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.FriendData;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.data.SuggestData;
import com.baidu.tieba.model.AtListModel;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.HashMap;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity {
    private static final String NAME = "name";
    private EditText mEditText = null;
    private Button mDelete = null;
    private Button mBack = null;
    private ListView mListView = null;
    private Handler mHandler = new Handler();
    private AtSuggestTask mAtSuggestTask = null;
    private FreindListTask mFreindListTask = null;
    private AtListModel mModel = null;
    private AtListAdapter mAdapter = null;
    private String mPreEditString = null;
    private ProgressBar mProgress = null;
    private Runnable mSuggestRunnable = new Runnable() { // from class: com.baidu.tieba.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.refreshData(AtListActivity.this.mEditText.getText().toString());
        }
    };
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.write.AtListActivity.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                int start = AtListActivity.this.mListView.getFirstVisiblePosition();
                int end = AtListActivity.this.mListView.getLastVisiblePosition();
                for (int i = start; i <= end; i++) {
                    if (i < AtListActivity.this.mAdapter.getCount()) {
                        MetaData data = (MetaData) AtListActivity.this.mAdapter.getItem(i);
                        if (data != null && data.getPortrait() != null) {
                            AtListActivity.this.mAdapter.getImageLoader().loadFriendPhoto(data.getPortrait(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.write.AtListActivity.2.1
                                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                    ImageView view = (ImageView) AtListActivity.this.mListView.findViewWithTag(imageUrl);
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

    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, AtListActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    public static String getName(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.at_list_activity);
        initData(savedInstanceState);
        initUI();
        refreshData(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mAtSuggestTask != null) {
            this.mAtSuggestTask.cancel();
        }
        if (this.mFreindListTask != null) {
            this.mFreindListTask.cancel();
        }
        this.mHandler.removeCallbacks(this.mSuggestRunnable);
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        if (this.mAdapter != null) {
            this.mAdapter.releaseProgressBar();
            if (this.mAdapter.getImageLoader() != null) {
                this.mAdapter.getImageLoader().cancelAllAsyncTask();
            }
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mEditText = (EditText) findViewById(R.id.at_search_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.AtListActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (text != null) {
                    if (!text.equals(AtListActivity.this.mPreEditString)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.mSuggestRunnable);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.mSuggestRunnable, 300L);
                    }
                    if (text.length() > 0) {
                        AtListActivity.this.mDelete.setVisibility(0);
                    } else {
                        AtListActivity.this.mDelete.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                AtListActivity.this.mPreEditString = AtListActivity.this.mEditText.getText().toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AtListActivity.this.finish();
            }
        });
        this.mDelete = (Button) findViewById(R.id.at_search_del);
        this.mDelete.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.AtListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
        this.mListView = (ListView) findViewById(R.id.list);
        this.mAdapter = new AtListAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.AtListActivity.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                MetaData data = (MetaData) AtListActivity.this.mAdapter.getItem(arg2);
                if (data != null) {
                    Intent intent = new Intent();
                    intent.putExtra("name", data.getName_show());
                    AtListActivity.this.setResult(-1, intent);
                    AtListActivity.this.finish();
                }
            }
        });
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.AtListActivity.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.mGetImageRunnble);
                AtListActivity.this.mHandler.postDelayed(AtListActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData(String str) {
        if (!isFinishing()) {
            this.mAdapter.setData(null);
            if (this.mAtSuggestTask != null) {
                this.mAtSuggestTask.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.mModel.getFriendData() != null) {
                    this.mAdapter.setData(this.mModel.getFriendData().getFriendList());
                } else {
                    this.mAdapter.setData(null);
                    if (this.mFreindListTask == null) {
                        this.mFreindListTask = new FreindListTask(this, null);
                        this.mFreindListTask.execute("");
                    }
                }
            } else {
                this.mAtSuggestTask = new AtSuggestTask(this, null);
                this.mAtSuggestTask.execute(str);
                if (this.mFreindListTask == null && this.mModel.getFriendData() == null) {
                    this.mFreindListTask = new FreindListTask(this, null);
                    this.mFreindListTask.execute("");
                }
            }
            this.mAdapter.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle savedInstanceState) {
        this.mModel = new AtListModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AtSuggestTask extends AsyncTask<String, Integer, SuggestData> {
        private NetWork mNetwork;
        private String mString;

        private AtSuggestTask() {
            this.mNetwork = null;
            this.mString = null;
        }

        /* synthetic */ AtSuggestTask(AtListActivity atListActivity, AtSuggestTask atSuggestTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        public void cancel() {
            AtListActivity.this.mAtSuggestTask = null;
            this.mString = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SuggestData doInBackground(String... arg0) {
            this.mString = arg0[0];
            this.mNetwork = new NetWork();
            SuggestData data = null;
            if (this.mString != null && this.mString.length() > 0) {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/u/follow/sug");
                this.mNetwork.addPostData("uid", TiebaApplication.getCurrentAccount());
                this.mNetwork.addPostData("q", this.mString);
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    data = new SuggestData();
                    FriendData friend = AtListActivity.this.mModel.getFriendData();
                    if (friend != null) {
                        data.parserSuggestJson(ret, friend.getFriendHash());
                    } else {
                        data.parserSuggestJson(ret, (HashMap<String, String>) null);
                    }
                }
            }
            return data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SuggestData result) {
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.isRequestSuccess() && this.mString != null && AtListActivity.this.mEditText.getText().toString().equals(this.mString)) {
                AtListActivity.this.mModel.setSuggestData(result);
                AtListActivity.this.mAdapter.setData(result.getSuggestList());
                AtListActivity.this.mAdapter.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            }
            super.onPostExecute((AtSuggestTask) result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FreindListTask extends AsyncTask<String, Integer, FriendData> {
        private NetWork mNetwork;

        private FreindListTask() {
            this.mNetwork = null;
        }

        /* synthetic */ FreindListTask(AtListActivity atListActivity, FreindListTask freindListTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            AtListActivity.this.mFreindListTask = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public FriendData doInBackground(String... arg0) {
            this.mNetwork = new NetWork();
            this.mNetwork.setUrl("http://c.tieba.baidu.com/c/u/follow/list");
            String ret = this.mNetwork.postNetData();
            if (!this.mNetwork.isRequestSuccess()) {
                return null;
            }
            FriendData data = new FriendData();
            data.parserFreindJson(ret);
            return data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(FriendData result) {
            AtListActivity.this.mFreindListTask = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.isRequestSuccess()) {
                AtListActivity.this.mModel.setFriendData(result);
                if (AtListActivity.this.mAdapter != null) {
                    if (AtListActivity.this.mEditText.getText().toString().length() != 0) {
                        if (AtListActivity.this.mModel.getSuggestData() != null) {
                            AtListActivity.this.mModel.getSuggestData().refreshSugguestPhto(result.getFriendHash());
                            AtListActivity.this.mAdapter.notifyDataSetInvalidated();
                        }
                    } else {
                        AtListActivity.this.mAdapter.setData(result.getFriendList());
                        AtListActivity.this.mAdapter.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            }
            super.onPostExecute((FreindListTask) result);
        }
    }
}
