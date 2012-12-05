package com.baidu.tieba.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrsHeaderView {
    private Activity mContext;
    private ImageView mDivider;
    private String mForumId;
    private String mForumName;
    private LinearLayout mLikeButton;
    private ProgressBar mLikeProgress;
    private TextView mLikeText;
    private View.OnClickListener mOnClickListener;
    private View mParent;
    private LinearLayout mSignButton;
    private ProgressBar mSignProgress;
    private TextView mSignText;
    private Button mSwitchImageButton;
    private Button mSwitchListButton;
    private PAGE mType;
    private int mHaveLike = 0;
    private int mHaveSign = 0;
    private SignAsyncTask mSignTask = null;
    private LikeAsyncTask mLikeTask = null;
    private boolean mCanSign = false;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    public FrsHeaderView(Activity context, PAGE type, String name, String id) {
        this.mLikeButton = null;
        this.mSignButton = null;
        this.mLikeText = null;
        this.mSignText = null;
        this.mSwitchListButton = null;
        this.mSwitchImageButton = null;
        this.mSignProgress = null;
        this.mLikeProgress = null;
        this.mDivider = null;
        this.mOnClickListener = null;
        this.mParent = null;
        this.mContext = null;
        this.mType = PAGE.FRS_LIST;
        this.mForumName = null;
        this.mForumId = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.FrsHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v != FrsHeaderView.this.mLikeButton) {
                    if (v != FrsHeaderView.this.mSignButton) {
                        if (v != FrsHeaderView.this.mSwitchListButton) {
                            if (v == FrsHeaderView.this.mSwitchImageButton && FrsHeaderView.this.mType != PAGE.FRS_IMAGE) {
                                TiebaApplication.app.addFrsImageForum(FrsHeaderView.this.mForumName);
                                FrsImageActivity.startAcitivity(FrsHeaderView.this.mContext, FrsHeaderView.this.mForumName, null, 0);
                                FrsHeaderView.this.mContext.finish();
                                return;
                            }
                            return;
                        } else if (FrsHeaderView.this.mType != PAGE.FRS_LIST) {
                            TiebaApplication.app.delFrsImageForum(FrsHeaderView.this.mForumName);
                            FrsActivity.startAcitivity(FrsHeaderView.this.mContext, FrsHeaderView.this.mForumName, null);
                            FrsHeaderView.this.mContext.finish();
                            return;
                        } else {
                            return;
                        }
                    }
                    FrsHeaderView.this.startSignTask();
                    return;
                }
                FrsHeaderView.this.startLikeTask();
            }
        };
        this.mContext = context;
        this.mType = type;
        this.mForumName = name;
        this.mForumId = id;
        LayoutInflater mInflater = LayoutInflater.from(context);
        this.mParent = mInflater.inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.mParent.setVisibility(8);
        }
        this.mLikeButton = (LinearLayout) this.mParent.findViewById(R.id.like_button);
        this.mSignButton = (LinearLayout) this.mParent.findViewById(R.id.sign_button);
        this.mLikeText = (TextView) this.mParent.findViewById(R.id.like_text);
        this.mSignText = (TextView) this.mParent.findViewById(R.id.sign_text);
        this.mSignProgress = (ProgressBar) this.mParent.findViewById(R.id.sign_progress);
        this.mLikeProgress = (ProgressBar) this.mParent.findViewById(R.id.like_progress);
        this.mSwitchListButton = (Button) this.mParent.findViewById(R.id.switch_list);
        this.mSwitchImageButton = (Button) this.mParent.findViewById(R.id.switch_image);
        this.mLikeButton.setOnClickListener(this.mOnClickListener);
        this.mSignButton.setOnClickListener(this.mOnClickListener);
        this.mSwitchListButton.setOnClickListener(this.mOnClickListener);
        this.mSwitchImageButton.setOnClickListener(this.mOnClickListener);
        this.mDivider = (ImageView) this.mParent.findViewById(R.id.divider);
        if (this.mType == PAGE.FRS_LIST) {
            this.mSwitchListButton.setBackgroundResource(R.drawable.frs_list_select);
        } else {
            this.mSwitchImageButton.setBackgroundResource(R.drawable.frs_image_select);
        }
    }

    public void startLikeTask() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity(this.mContext, this.mContext.getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_LIKE);
        } else if (this.mHaveLike == 0 && this.mLikeTask == null) {
            this.mLikeTask = new LikeAsyncTask(this, null);
            this.mLikeTask.execute(new Object[0]);
        }
    }

    public void startSignTask() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity(this.mContext, this.mContext.getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_SIGN);
        } else if (this.mHaveSign == 0 && this.mSignTask == null) {
            this.mSignTask = new SignAsyncTask(this, null);
            this.mSignTask.execute(new Object[0]);
        }
    }

    public View getView() {
        return this.mParent;
    }

    public void setNoSwitch() {
        this.mSwitchListButton.setVisibility(8);
        this.mSwitchImageButton.setVisibility(8);
    }

    public void setForum(String name, String id) {
        this.mForumName = name;
        this.mForumId = id;
        this.mParent.setVisibility(0);
    }

    public void setHaveLike(int like, String level_name, int level) {
        this.mHaveLike = like;
        Resources r = this.mContext.getResources();
        if (like == 0) {
            Drawable dr = r.getDrawable(R.drawable.add_love);
            if (dr instanceof BitmapDrawable) {
                Bitmap bm = ((BitmapDrawable) dr).getBitmap();
                ((BitmapDrawable) dr).setBounds(0, 0, bm.getWidth(), bm.getHeight());
            }
            this.mLikeText.setCompoundDrawables(dr, null, null, null);
            this.mLikeText.setTextColor(r.getColor(R.color.frs_like_enable));
            this.mLikeText.setText(this.mContext.getString(R.string.ilike));
            return;
        }
        this.mLikeText.setCompoundDrawables(null, null, null, null);
        if (level_name == null) {
            this.mLikeText.setTextColor(r.getColor(R.color.frs_likesign_disable));
            this.mLikeText.setText(this.mContext.getString(R.string.iliked));
            return;
        }
        this.mLikeText.setTextColor(r.getColor(R.color.frs_like_level_name));
        String display = String.valueOf(level_name) + "  " + String.valueOf(level) + this.mContext.getString(R.string.grade);
        SpannableString str = new SpannableString(display);
        int start = level_name.length();
        str.setSpan(new ForegroundColorSpan(r.getColor(R.color.frs_like_level)), start + "  ".length(), display.length(), 33);
        this.mLikeText.setText(str);
    }

    public void setHaveSign(int sign) {
        this.mHaveSign = sign;
        Resources r = this.mContext.getResources();
        if (sign == 0) {
            Drawable dr = r.getDrawable(R.drawable.my_icon_sign);
            if (dr instanceof BitmapDrawable) {
                Bitmap bm = ((BitmapDrawable) dr).getBitmap();
                ((BitmapDrawable) dr).setBounds(0, 0, bm.getWidth(), bm.getHeight());
            }
            this.mSignText.setCompoundDrawables(dr, null, null, null);
            this.mSignText.setTextColor(r.getColor(R.color.frs_sign_enable));
            this.mSignText.setText(this.mContext.getString(R.string.sign));
            return;
        }
        this.mSignText.setCompoundDrawables(null, null, null, null);
        this.mSignText.setTextColor(r.getColor(R.color.frs_likesign_disable));
        this.mSignText.setText(this.mContext.getString(R.string.signed));
    }

    public void canSign(boolean canSign) {
        this.mCanSign = canSign;
        if (this.mCanSign) {
            this.mDivider.setVisibility(0);
            this.mSignButton.setVisibility(0);
            return;
        }
        this.mDivider.setVisibility(8);
        this.mSignButton.setVisibility(8);
    }

    public void release() {
        if (this.mSignTask != null) {
            this.mSignTask.cancel();
        }
        if (this.mLikeTask != null) {
            this.mLikeTask.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SignAsyncTask extends AsyncTask<Object, Integer, SignData> {
        private volatile boolean mHaveSign;
        private volatile NetWork mNetwork;

        private SignAsyncTask() {
            this.mNetwork = null;
            this.mHaveSign = false;
        }

        /* synthetic */ SignAsyncTask(FrsHeaderView frsHeaderView, SignAsyncTask signAsyncTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            FrsHeaderView.this.mSignProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public SignData doInBackground(Object... arg0) {
            SignData data = null;
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/sign");
                this.mNetwork.addPostData("kw", FrsHeaderView.this.mForumName);
                this.mNetwork.addPostData("fid", FrsHeaderView.this.mForumId);
                this.mNetwork.setIsNeedTbs(true);
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    if (this.mNetwork.isRequestSuccess()) {
                        SignData data2 = new SignData();
                        try {
                            data2.parserJson(ret);
                            data = data2;
                        } catch (Exception e) {
                            ex = e;
                            data = data2;
                            TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                            return data;
                        }
                    } else if (this.mNetwork.getErrorCode() == 160002) {
                        this.mHaveSign = true;
                    }
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return data;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            FrsHeaderView.this.mSignTask = null;
            FrsHeaderView.this.mSignProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SignData data) {
            FrsHeaderView.this.mSignTask = null;
            FrsHeaderView.this.mSignProgress.setVisibility(8);
            if (this.mHaveSign) {
                FrsHeaderView.this.setHaveSign(1);
            } else if (data == null) {
                if (this.mNetwork != null) {
                    UtilHelper.showToast(FrsHeaderView.this.mContext, this.mNetwork.getErrorString());
                }
            } else {
                FrsHeaderView.this.setHaveSign(1);
                StringBuilder builder = new StringBuilder(100);
                if (FrsHeaderView.this.mHaveLike == 0) {
                    builder.append(FrsHeaderView.this.mContext.getString(R.string.sign_success));
                    builder.append("!\n");
                    builder.append(String.format(FrsHeaderView.this.mContext.getString(R.string.sign_user), Integer.valueOf(data.getUserSignRank())));
                    UtilHelper.showToast(FrsHeaderView.this.mContext, builder.toString());
                    return;
                }
                builder.append(FrsHeaderView.this.mContext.getString(R.string.sign_success));
                builder.append(",");
                builder.append(String.format(FrsHeaderView.this.mContext.getString(R.string.sign_point), Integer.valueOf(data.getBonusPoint())));
                builder.append("!\n");
                builder.append(String.format(FrsHeaderView.this.mContext.getString(R.string.sign_user), Integer.valueOf(data.getUserSignRank())));
                UtilHelper.showToast(FrsHeaderView.this.mContext, builder.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LikeAsyncTask extends AsyncTask<Object, Integer, Boolean> {
        private volatile boolean mHaveLike;
        private volatile int mLevel;
        private volatile String mLevelName;
        private volatile NetWork mNetwork;

        private LikeAsyncTask() {
            this.mNetwork = null;
            this.mHaveLike = false;
            this.mLevel = 0;
            this.mLevelName = null;
        }

        /* synthetic */ LikeAsyncTask(FrsHeaderView frsHeaderView, LikeAsyncTask likeAsyncTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            FrsHeaderView.this.mLikeProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... params) {
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/like");
                this.mNetwork.addPostData("kw", FrsHeaderView.this.mForumName);
                this.mNetwork.addPostData("fid", FrsHeaderView.this.mForumId);
                this.mNetwork.setIsNeedTbs(true);
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    if (this.mNetwork.isRequestSuccess()) {
                        getLevel(ret);
                        return true;
                    } else if (this.mNetwork.getErrorCode() == 22) {
                        getLevel(ret);
                        this.mHaveLike = true;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
            return false;
        }

        private void getLevel(String ret) {
            try {
                JSONObject json = new JSONObject(ret);
                JSONObject info = json.optJSONObject(LoginActivity.INFO);
                this.mLevel = info.optInt("level_id");
                this.mLevelName = info.optString("level_name");
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "getLevel", e.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean data) {
            FrsHeaderView.this.mLikeProgress.setVisibility(8);
            FrsHeaderView.this.mLikeTask = null;
            if (this.mHaveLike) {
                FrsHeaderView.this.setHaveLike(1, this.mLevelName, this.mLevel);
                UtilHelper.showToast(FrsHeaderView.this.mContext, this.mNetwork.getErrorString());
            } else if (!data.booleanValue()) {
                UtilHelper.showToast(FrsHeaderView.this.mContext, this.mNetwork.getErrorString());
            } else {
                FrsHeaderView.this.setHaveLike(1, this.mLevelName, this.mLevel);
                UtilHelper.showToast(FrsHeaderView.this.mContext, FrsHeaderView.this.mContext.getString(R.string.like_success));
            }
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            FrsHeaderView.this.mLikeProgress.setVisibility(8);
            FrsHeaderView.this.mLikeTask = null;
            super.cancel(true);
        }
    }
}
