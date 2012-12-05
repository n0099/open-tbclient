package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.model.PersonChangeModel;
import com.baidu.tieba.model.PersonInfoModel;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity {
    public static final int REQUEST_MARK = 102;
    public static final int REQUSET_CHANGE = 101;
    public static final int REQUSET_MY_BAR = 103;
    public static final String TAG_ID = "un";
    public static final String TAG_NAME = "name";
    public static final String TAG_SELF = "self";
    public static final String TAG_TAB_PAGE = "tab_page";
    private Button mBack = null;
    private Button mChange = null;
    private ImageView mPhoto = null;
    private TextView mName = null;
    private ImageView mSex = null;
    private TextView mIntro = null;
    private ListView mList = null;
    private Button mHome = null;
    private Button mRefresh = null;
    private TextView mTitleText = null;
    private PersonInfoAdapter mAdapter = null;
    private PersonInfoModel mModel = null;
    private View.OnClickListener mClickListener = null;
    private getInfoAsyncTask mGetInfoTask = null;
    private ProgressBar mProgress = null;
    private ProgressBar mProgressAttention = null;
    private LinearLayout mAttention = null;
    private TextView mAttentionText = null;
    private AttentionAsyncTask mAttentionTask = null;
    private BroadcastReceiver FansNumReceiver = null;

    public static void startActivity(Context context, String id, String name) {
        startActivityNewTask(context, id, name, false);
    }

    public static void startActivityNewTask(Context context, String id, String name, boolean newTask) {
        if (id != null && id.length() > 0 && !id.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", id);
            intent.putExtra(TAG_NAME, name);
            if (TiebaApplication.getCurrentAccount() != null && TiebaApplication.getCurrentAccount().equals(id)) {
                intent.putExtra(TAG_SELF, true);
            } else {
                intent.putExtra(TAG_SELF, false);
            }
            intent.putExtra(TAG_TAB_PAGE, false);
            if (newTask) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_info_activity);
        InitData(savedInstanceState);
        InitUI();
        DatabaseService.setMarkNumState(true);
        if (this.mModel.getIsSelf()) {
            getUserData(true, true);
        } else {
            getUserData(false, true);
        }
    }

    private void InitData(Bundle savedInstanceState) {
        this.mModel = new PersonInfoModel(this);
        if (savedInstanceState != null) {
            this.mModel.setIsSelf(savedInstanceState.getBoolean(TAG_SELF, true));
            this.mModel.setId(savedInstanceState.getString("un"));
            this.mModel.setName(savedInstanceState.getString(TAG_NAME));
            this.mModel.setTabPage(savedInstanceState.getBoolean(TAG_TAB_PAGE, false));
        } else {
            Intent intent = getIntent();
            this.mModel.setIsSelf(intent.getBooleanExtra(TAG_SELF, true));
            this.mModel.setId(intent.getStringExtra("un"));
            this.mModel.setName(intent.getStringExtra(TAG_NAME));
            this.mModel.setTabPage(intent.getBooleanExtra(TAG_TAB_PAGE, false));
        }
        if (this.mModel.getIsSelf()) {
            IntentFilter filter_dynamic = new IntentFilter();
            this.FansNumReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.person.PersonInfoActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent2) {
                    long num = intent2.getLongExtra(Config.BROADCAST_FANS_NUM, 0L);
                    if (PersonInfoActivity.this.mModel != null) {
                        PersonInfoActivity.this.mModel.setNotify_fans(num);
                    }
                    if (PersonInfoActivity.this.mAdapter != null) {
                        PersonInfoActivity.this.mAdapter.notifyDataSetChanged();
                    }
                }
            };
            filter_dynamic.addAction(Config.BROADCAST_NOTIFY);
            registerReceiver(this.FansNumReceiver, filter_dynamic);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(TAG_SELF, this.mModel.getIsSelf());
        outState.putString("un", this.mModel.getId());
        outState.putBoolean(TAG_TAB_PAGE, this.mModel.isTabPage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        if (this.mModel.getIsSelf()) {
            this.mModel.setNotify_fans(TiebaApplication.app.getMsgFans());
            if (DatabaseService.getMarkNumState().booleanValue()) {
                int num = DatabaseService.getMarkDataNum();
                this.mModel.setMark(num);
            }
            this.mAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserData(boolean from_db, boolean error_hint) {
        if (this.mGetInfoTask == null) {
            this.mGetInfoTask = new getInfoAsyncTask(this, null);
            this.mGetInfoTask.execute(Boolean.valueOf(from_db), Boolean.valueOf(error_hint));
        }
    }

    private void InitUI() {
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgressAttention = (ProgressBar) findViewById(R.id.attention_progress);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.person.PersonInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != PersonInfoActivity.this.mBack) {
                    if (view != PersonInfoActivity.this.mHome) {
                        if (view == PersonInfoActivity.this.mChange) {
                            if (PersonInfoActivity.this.mModel.getUser() != null) {
                                PersonChangeModel data = new PersonChangeModel();
                                data.setName(PersonInfoActivity.this.mModel.getUser().getName_show());
                                data.setIntro(PersonInfoActivity.this.mModel.getUser().getIntro());
                                data.setSex(PersonInfoActivity.this.mModel.getUser().getSex());
                                data.setPortrait(PersonInfoActivity.this.mModel.getUser().getPortrait());
                                PersonChangeActivity.startActivityForResult(PersonInfoActivity.this, 101, data);
                                return;
                            }
                            return;
                        } else if (view != PersonInfoActivity.this.mAttention) {
                            if (PersonInfoActivity.this.mRefresh == view) {
                                PersonInfoActivity.this.mProgress.setVisibility(0);
                                PersonInfoActivity.this.getUserData(false, true);
                                return;
                            }
                            return;
                        } else if (PersonInfoActivity.this.mModel.getUser() != null && PersonInfoActivity.this.mAttentionTask == null) {
                            PersonInfoActivity.this.mAttentionTask = new AttentionAsyncTask(PersonInfoActivity.this, null);
                            if (PersonInfoActivity.this.mModel.getUser().getHave_attention() == 1) {
                                PersonInfoActivity.this.mAttentionTask.execute(1);
                                return;
                            } else {
                                PersonInfoActivity.this.mAttentionTask.execute(0);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    MainTabActivity.startActivity(PersonInfoActivity.this, MainTabActivity.GOTO_RECOMMEND);
                    return;
                }
                PersonInfoActivity.this.finish();
            }
        };
        this.mTitleText = (TextView) findViewById(R.id.titel_text);
        if (this.mModel.getIsSelf()) {
            this.mTitleText.setText(R.string.person_info);
        } else if (this.mModel.getUser() == null) {
            this.mTitleText.setText(this.mModel.getName());
        }
        this.mPhoto = (ImageView) findViewById(R.id.photo);
        this.mChange = (Button) findViewById(R.id.change);
        this.mChange.setOnClickListener(this.mClickListener);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(this.mClickListener);
        this.mHome = (Button) findViewById(R.id.home);
        this.mHome.setOnClickListener(this.mClickListener);
        this.mRefresh = (Button) findViewById(R.id.refresh);
        this.mRefresh.setOnClickListener(this.mClickListener);
        if (this.mModel.getIsSelf()) {
            this.mChange.setVisibility(0);
            if (this.mModel.isTabPage()) {
                this.mBack.setVisibility(4);
                this.mHome.setVisibility(8);
                this.mRefresh.setVisibility(0);
            } else {
                this.mBack.setVisibility(0);
                this.mHome.setVisibility(0);
                this.mRefresh.setVisibility(8);
            }
        } else {
            this.mBack.setVisibility(0);
            this.mChange.setVisibility(8);
            this.mHome.setVisibility(0);
            this.mRefresh.setVisibility(8);
        }
        this.mAdapter = new PersonInfoAdapter(this);
        this.mAdapter.setData(this.mModel);
        this.mList = (ListView) findViewById(R.id.list);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.person.PersonInfoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                if (id == 0) {
                    EditBarActivity.startActivity(PersonInfoActivity.this, 103);
                } else if (id == 1) {
                    EditMarkActivity.startActivityForResult(PersonInfoActivity.this, 102);
                } else if (id == 2) {
                    PersonListActivity.startActivity(PersonInfoActivity.this, true, TiebaApplication.getCurrentAccount());
                } else if (id == 3) {
                    PersonListActivity.startActivity(PersonInfoActivity.this, false, TiebaApplication.getCurrentAccount());
                }
            }
        });
        this.mName = (TextView) findViewById(R.id.name);
        if (this.mModel.getUser() == null) {
            this.mName.setText(this.mModel.getName());
        }
        this.mSex = (ImageView) findViewById(R.id.sex);
        this.mIntro = (TextView) findViewById(R.id.intro);
        this.mAttention = (LinearLayout) findViewById(R.id.attention);
        if (this.mModel.getIsSelf()) {
            this.mAttention.setVisibility(8);
            this.mChange.setVisibility(0);
        } else {
            this.mChange.setVisibility(8);
            this.mAttention.setVisibility(8);
        }
        this.mAttentionText = (TextView) findViewById(R.id.attention_text);
        this.mAttention.setOnClickListener(this.mClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI() {
        this.mAdapter.notifyDataSetChanged();
        if (this.mModel != null && this.mModel.getUser() != null) {
            this.mName.setText(this.mModel.getUser().getName_show());
            if (this.mModel.getUser().getSex() == 1) {
                this.mSex.setImageResource(R.drawable.male);
            } else {
                this.mSex.setImageResource(R.drawable.female);
            }
            this.mIntro.setText(this.mModel.getUser().getIntro());
            if (!this.mModel.getIsSelf()) {
                this.mTitleText.setText(this.mModel.getUser().getName_show());
            }
            refreshAttention();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAttention() {
        if (!this.mModel.getIsSelf()) {
            if (this.mModel.getUser() != null) {
                this.mAttention.setVisibility(0);
                if (this.mModel.getUser().getHave_attention() == 1) {
                    this.mAttention.setBackgroundResource(R.drawable.attention_cancel);
                    this.mAttentionText.setText(R.string.attention_cancel);
                    return;
                }
                this.mAttention.setBackgroundResource(R.drawable.attention);
                this.mAttentionText.setText(R.string.attention);
                return;
            }
            this.mAttention.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPhoto() {
        String url;
        if (this.mModel != null && this.mModel.getUser() != null && (url = this.mModel.getUser().getPortrait()) != null && url.length() > 0) {
            Bitmap photo = this.mModel.getImageLoader().getPhoto(url);
            if (photo == null) {
                this.mModel.getImageLoader().loadFriendPhotoByNet(url, new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.person.PersonInfoActivity.4
                    @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                    public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                        if (bitmap != null) {
                            PersonInfoActivity.this.mPhoto.setImageBitmap(bitmap);
                        }
                    }
                });
            } else {
                this.mPhoto.setImageBitmap(photo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mGetInfoTask != null) {
            this.mGetInfoTask.cancel();
        }
        if (this.mAttentionTask != null) {
            this.mAttentionTask.cancel();
        }
        if (this.mModel.getImageLoader() != null) {
            this.mModel.getImageLoader().cancelAllAsyncTask();
        }
        if (this.mModel.getIsSelf()) {
            unregisterReceiver(this.FansNumReceiver);
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mProgressAttention != null) {
            this.mProgressAttention.setVisibility(8);
        }
        DatabaseService.setMarkNumState(true);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 101) {
            onResultRefresh(data);
        }
    }

    private void onResultRefresh(Intent intent) {
        PersonChangeModel person = (PersonChangeModel) intent.getSerializableExtra("data");
        if (person != null && this.mModel.getUser() != null) {
            this.mModel.getUser().setSex(person.getSex());
            this.mModel.getUser().setName(person.getName());
            this.mModel.getUser().setIntro(person.getIntro());
            if (person.getPhotoChanged()) {
                this.mPhoto.setImageResource(R.drawable.person_photo);
                if (this.mModel.getUser() != null) {
                    this.mModel.getImageLoader().removePhoto(this.mModel.getUser().getPortrait());
                }
            }
            refreshUI();
            getPhoto();
        }
        getUserData(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class getInfoAsyncTask extends AsyncTask<Boolean, UserData, UserData> {
        private boolean mErrorHint;
        private volatile boolean mIscancel;
        private NetWork mNetwork;

        private getInfoAsyncTask() {
            this.mNetwork = null;
            this.mIscancel = false;
            this.mErrorHint = false;
        }

        /* synthetic */ getInfoAsyncTask(PersonInfoActivity personInfoActivity, getInfoAsyncTask getinfoasynctask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public UserData doInBackground(Boolean... params) {
            String data;
            UserData info = null;
            boolean from_db = params[0].booleanValue();
            this.mErrorHint = params[1].booleanValue();
            try {
                if (PersonInfoActivity.this.mModel.getIsSelf() && from_db && (data = DatabaseService.getPersonData()) != null) {
                    UserData user = new UserData();
                    user.parserJson(data);
                    publishProgress(user);
                    this.mErrorHint = false;
                }
                if (this.mIscancel || PersonInfoActivity.this.mModel == null || PersonInfoActivity.this.mModel.getId() == null) {
                    return null;
                }
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/u/user/profile");
                this.mNetwork.addPostData("uid", PersonInfoActivity.this.mModel.getId());
                String ret = this.mNetwork.postNetData();
                if (!this.mNetwork.isRequestSuccess()) {
                    return null;
                }
                UserData info2 = new UserData();
                try {
                    JSONObject json = new JSONObject(ret);
                    JSONObject json_user = json.optJSONObject("user");
                    info2.parserJson(json_user);
                    if (PersonInfoActivity.this.mModel.getIsSelf()) {
                        DatabaseService.cashPersonData(json_user.toString());
                        return info2;
                    }
                    return info2;
                } catch (Exception e) {
                    ex = e;
                    info = info2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return info;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(UserData... values) {
            super.onProgressUpdate((Object[]) values);
            UserData user = values[0];
            PersonInfoActivity.this.mProgress.setVisibility(8);
            if (user != null) {
                PersonInfoActivity.this.mModel.setUser(user);
                PersonInfoActivity.this.refreshUI();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(UserData result) {
            super.onPostExecute((getInfoAsyncTask) result);
            PersonInfoActivity.this.mGetInfoTask = null;
            PersonInfoActivity.this.mProgress.setVisibility(8);
            if (result != null) {
                PersonInfoActivity.this.mModel.setUser(result);
                PersonInfoActivity.this.mModel.getImageLoader().removePhoto(result.getPortrait());
                PersonInfoActivity.this.refreshUI();
                PersonInfoActivity.this.getPhoto();
            } else if (this.mNetwork != null && this.mErrorHint) {
                PersonInfoActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (PersonInfoActivity.this.mModel != null && PersonInfoActivity.this.mModel.getUser() == null) {
                PersonInfoActivity.this.mProgress.setVisibility(0);
            }
        }

        public void cancel() {
            this.mIscancel = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            PersonInfoActivity.this.mProgress.setVisibility(8);
            PersonInfoActivity.this.mGetInfoTask = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes.dex */
    private class AttentionAsyncTask extends AsyncTask<Integer, Integer, String> {
        private NetWork mNetwork;

        private AttentionAsyncTask() {
            this.mNetwork = null;
        }

        /* synthetic */ AttentionAsyncTask(PersonInfoActivity personInfoActivity, AttentionAsyncTask attentionAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Integer... params) {
            try {
                int type = params[0].intValue();
                if (PersonInfoActivity.this.mModel != null && PersonInfoActivity.this.mModel.getUser() != null) {
                    this.mNetwork = new NetWork();
                    if (type == 0) {
                        this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/user/follow");
                    } else {
                        this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/user/unfollow");
                    }
                    this.mNetwork.addPostData("portrait", PersonInfoActivity.this.mModel.getUser().getPortrait());
                    this.mNetwork.setIsNeedTbs(true);
                    this.mNetwork.postNetData();
                    return null;
                }
                return null;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((AttentionAsyncTask) result);
            PersonInfoActivity.this.mAttentionTask = null;
            PersonInfoActivity.this.mProgressAttention.setVisibility(8);
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    if (PersonInfoActivity.this.mModel.getUser() != null) {
                        if (PersonInfoActivity.this.mModel.getUser().getHave_attention() == 1) {
                            PersonInfoActivity.this.mModel.getUser().setHave_attention(0);
                        } else {
                            PersonInfoActivity.this.mModel.getUser().setHave_attention(1);
                        }
                    }
                    PersonInfoActivity.this.refreshAttention();
                    PersonInfoActivity.this.showToast(PersonInfoActivity.this.getString(R.string.success));
                    return;
                }
                PersonInfoActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (PersonInfoActivity.this.mModel != null && PersonInfoActivity.this.mModel.getUser() != null) {
                PersonInfoActivity.this.mProgressAttention.setVisibility(0);
            }
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            PersonInfoActivity.this.mProgressAttention.setVisibility(8);
            PersonInfoActivity.this.mAttentionTask = null;
            super.cancel(true);
        }
    }
}
