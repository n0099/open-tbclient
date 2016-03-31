package com.baidu.tieba.write.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData eMc = null;
    private TextView eJs = null;
    private ImageView aMx = null;
    private EditText dsS = null;
    private ProgressBar mProgressBar = null;
    private b eMd = null;
    private a eMe = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener dtc = null;
    private RelativeLayout bYK = null;
    private TextView bfD = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener eMf = new v(this);
    private final View.OnClickListener eMg = new w(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.vcode_activity);
        pU();
        initData(bundle);
        pb(this.eMc.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.dtc = new x(this);
        if (bundle != null) {
            this.eMc = (WriteData) bundle.getSerializable("model");
        } else {
            this.eMc = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eMc != null && this.eMc.getType() == 3) {
            if (this.eMd != null) {
                this.eMd.cancel();
            }
            if (this.eMe != null) {
                this.eMe.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eMd != null) {
            this.eMd.cancel();
        }
        if (this.eMe != null) {
            this.eMe.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.eMc);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.at.g(this.bYK, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.eJs, t.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.at.cO(i);
        } else {
            i2 = -12895429;
        }
        this.bfD.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, false, this.dtc);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void pU() {
        this.bYK = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.bfD = (TextView) findViewById(t.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eMf);
        this.eJs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.eMg);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.eJs.setLayoutParams(layoutParams);
        this.dsS = (EditText) findViewById(t.g.input);
        this.aMx = (ImageView) findViewById(t.g.vcode_image);
        this.aMx.setImageDrawable(null);
        this.aMx.setOnClickListener(new y(this));
        this.mProgressBar = (ProgressBar) findViewById(t.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(String str) {
        if (this.eMe != null) {
            this.eMe.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aMx.setImageDrawable(null);
        this.eMe = new a(this, null);
        this.eMe.setPriority(3);
        this.eMe.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.n> {
        private WriteData eMj;
        private com.baidu.tbadk.core.util.ab aiW = null;
        private String esG = null;

        public b(WriteData writeData) {
            this.eMj = null;
            this.eMj = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(Integer... numArr) {
            String str;
            Address x;
            if (this.eMj != null) {
                this.aiW = new com.baidu.tbadk.core.util.ab();
                String editable = VcodeActivity.this.dsS.getText().toString();
                String imagesCodeForPost = this.eMj.getImagesCodeForPost();
                if (this.eMj.getType() == 3) {
                    this.aiW.p("newVcode", "1");
                    this.aiW.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.eMj.getContent()) + imagesCodeForPost);
                    this.aiW.p(PayVcodeActivityConfig.VCODE_MD5, this.eMj.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiW.p("vcode", editable);
                    }
                    this.aiW.p("tag", "11");
                    this.aiW.vU().wO().mIsNeedTbs = true;
                    this.aiW.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.eMj.getContent()) + imagesCodeForPost);
                    this.aiW.setUrl(com.baidu.tieba.tbadkCore.c.a.eqr);
                    this.aiW.p(ImageViewerConfig.FORUM_NAME, this.eMj.getForumName());
                    this.aiW.p("title", this.eMj.getTitle());
                    this.aiW.p("apiKey", this.eMj.getShareApiKey());
                    this.aiW.p("appName", this.eMj.getShareAppName());
                    this.aiW.p("signKey", this.eMj.getShareSignKey());
                    this.aiW.p("summary_title", this.eMj.getShareSummaryTitle());
                    this.aiW.p("summary_content", this.eMj.getShareSummaryContent());
                    this.aiW.p("summary_img", this.eMj.getShareSummaryImg());
                    this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.eMj.getShareSummaryImgWidth()));
                    this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.eMj.getShareSummaryImgHeight()));
                    this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.eMj.getShareSummaryImgType());
                    this.aiW.p("referUrl", this.eMj.getShareReferUrl());
                } else {
                    this.aiW.p("anonymous", "0");
                    this.aiW.p("fid", this.eMj.getForumId());
                    this.aiW.p("kw", this.eMj.getForumName());
                    this.aiW.p("new_vcode", "1");
                    VideoInfo videoInfo = this.eMj.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.eMj.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.eMj.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.eMj.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.eMj.getGraffitiWriteCode();
                    }
                    if (this.eMj.getType() == 6 && this.eMj.getVoteInfo() != null) {
                        if (this.eMj.getWriteImagesInfo() != null) {
                            this.eMj.getVoteInfo().setServerImageCode(this.eMj.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.eMj.getVoteInfo().buildWriteContent();
                    }
                    this.aiW.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.eMj.getIsBaobaoImageUploaded()) {
                        this.aiW.p("tail_type", String.valueOf(a.b.eqy));
                        this.aiW.p("tail_content", this.eMj.getBaobaoContent());
                        this.eMj.setBabaoPosted(true);
                    } else {
                        this.eMj.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.aiW, this.eMj);
                    this.aiW.p(CommonVcodeActivityConfig.VCODE_MD5, this.eMj.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiW.p("vcode", editable);
                    }
                    this.aiW.vU().wO().mIsNeedTbs = true;
                    if (this.eMj.getVoice() != null) {
                        this.aiW.p("voice_md5", this.eMj.getVoice());
                        this.aiW.p("during_time", String.valueOf(this.eMj.getVoiceDuringTime()));
                    }
                    if (this.eMj.getType() == 0) {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiW.p("title", this.eMj.getTitle());
                        this.aiW.p("is_ntitle", this.eMj.isNoTitle() ? "1" : "0");
                        if (this.eMj.getCategoryFrom() >= 0) {
                            this.aiW.p("fromCategoryId", String.valueOf(this.eMj.getCategoryFrom()));
                        }
                        if (this.eMj.getCategoryTo() >= 0) {
                            this.aiW.p("toCategoryId", String.valueOf(this.eMj.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (x = com.baidu.adp.lib.e.a.gL().x(false)) != null) {
                            this.aiW.p("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                        }
                    } else if (this.eMj.getType() == 6) {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiW.p("title", this.eMj.getTitle());
                        this.aiW.p("is_ntitle", this.eMj.isNoTitle() ? "1" : "0");
                        this.aiW.p("thread_type", String.valueOf(36));
                    } else if (this.eMj.getType() == 4) {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiW.p("title", this.eMj.getTitle());
                        this.aiW.p("is_ntitle", "0");
                        this.aiW.p("thread_type", String.valueOf(33));
                        this.aiW.p("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aiW.p("tid", this.eMj.getThreadId());
                        this.aiW.p("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.eMj.getType() == 2) {
                            this.aiW.p("quote_id", String.valueOf(this.eMj.getFloor()));
                            this.aiW.p("floor_num", String.valueOf(this.eMj.getFloorNum()));
                            this.aiW.p(WriteActivityConfig.IS_ADDITION, this.eMj.isAddition() ? "1" : "0");
                            if (this.eMj.getRepostId() != null) {
                                this.aiW.p("repostid", this.eMj.getRepostId());
                            }
                        } else if (this.eMj.getType() == 5) {
                            this.aiW.p("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.eMj.getType() == 1 && com.baidu.tbadk.editortools.d.b.DI().getStatus() == 1) {
                            this.aiW.p("ptype", "4");
                        }
                    }
                }
                this.esG = this.aiW.vw();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.eMd = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aiW != null) {
                this.aiW.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            String str;
            int i;
            String str2;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.eMd = null;
            if (this.aiW != null) {
                if (this.aiW.vU().wP().qC()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.esG);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.eMc);
                        try {
                            str2 = new JSONObject(this.esG).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m411getInst().getString(t.j.send_success);
                        }
                        if (this.eMj.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.P(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.eMj.deleteUploadedTempImages();
                        if (this.eMj != null && this.eMj.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aSG();
                        }
                    } else if ((this.eMj.isHasImages() || this.eMj.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.eMj.getContent()) + this.eMj.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error));
                    } else if (this.eMj.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.esG).optString("tid");
                        str4 = new JSONObject(this.esG).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.esG).optJSONObject("twzhibo_info");
                        if (optJSONObject != null) {
                            i = optJSONObject.optInt("is_copytwzhibo", 0);
                            str = str3;
                        } else {
                            i = 0;
                            str = str3;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str = str3;
                        str4 = str4;
                        i = 0;
                    }
                    postWriteCallBackData.setThreadId(str);
                    postWriteCallBackData.setPostId(str4);
                    postWriteCallBackData.setIsCopyTWZhibo(i);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    VcodeActivity.this.setResult(-1, intent);
                    VcodeActivity.this.finish();
                } else if (this.eMj.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.eMj.getContent()) + this.eMj.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error));
                } else {
                    if (this.aiW.vY() == 5 || this.aiW.vY() == 6) {
                        com.baidu.tbadk.coreExtra.data.n nVar2 = new com.baidu.tbadk.coreExtra.data.n();
                        nVar2.parserJson(this.esG);
                        if (nVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.eMc.setVcodeMD5(nVar2.getVcode_md5());
                            VcodeActivity.this.eMc.setVcodeUrl(nVar2.getVcode_pic_url());
                            VcodeActivity.this.pb(VcodeActivity.this.eMc.getVcodeUrl());
                        }
                        VcodeActivity.this.dsS.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.aiW.getErrorString());
                }
            }
            super.onPostExecute(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.ab QV;
        private volatile boolean beW;
        com.baidu.tbadk.coreExtra.data.n eMi;

        private a() {
            this.QV = null;
            this.eMi = null;
            this.beW = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.eMe = null;
            if (this.QV != null) {
                this.QV.gX();
            }
            this.beW = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.QV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.QV.p("fid", VcodeActivity.this.eMc.getForumId());
                this.QV.p("kw", VcodeActivity.this.eMc.getForumName());
                this.QV.p("new_vcode", "1");
                this.QV.p("title", VcodeActivity.this.eMc.getTitle());
                this.QV.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.eMc.getContent());
                if (VcodeActivity.this.eMc.getType() == 0) {
                    this.QV.p("pub_type", "1");
                    if (VcodeActivity.this.eMc.getCategoryFrom() >= 0) {
                        this.QV.p("fromCategoryId", String.valueOf(VcodeActivity.this.eMc.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.eMc.getCategoryTo() >= 0) {
                        this.QV.p("toCategoryId", String.valueOf(VcodeActivity.this.eMc.getCategoryTo()));
                    }
                } else {
                    this.QV.p("pub_type", "2");
                    this.QV.p("tid", VcodeActivity.this.eMc.getThreadId());
                }
                String vw = this.QV.vw();
                if (!this.QV.vU().wP().qC()) {
                    return null;
                }
                this.eMi = new com.baidu.tbadk.coreExtra.data.n();
                this.eMi.parserJson(vw);
                str = this.eMi.getVcode_pic_url();
            }
            if (this.beW) {
                return null;
            }
            this.QV = new com.baidu.tbadk.core.util.ab(str);
            return BitmapHelper.Bytes2Bitmap(this.QV.vx());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.eMe = null;
            if (bitmap != null) {
                VcodeActivity.this.aMx.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.eMi != null) {
                VcodeActivity.this.eMc.setVcodeMD5(this.eMi.getVcode_md5());
                VcodeActivity.this.eMc.setVcodeUrl(this.eMi.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
