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
    private WriteData fcQ = null;
    private TextView faj = null;
    private ImageView aIH = null;
    private EditText dwo = null;
    private ProgressBar mProgressBar = null;
    private b fcR = null;
    private a fcS = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener dwy = null;
    private RelativeLayout bZp = null;
    private TextView bbr = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener fcT = new v(this);
    private final View.OnClickListener fcU = new w(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.vcode_activity);
        nq();
        initData(bundle);
        pp(this.fcQ.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.dwy = new x(this);
        if (bundle != null) {
            this.fcQ = (WriteData) bundle.getSerializable("model");
        } else {
            this.fcQ = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fcQ != null && this.fcQ.getType() == 3) {
            if (this.fcR != null) {
                this.fcR.cancel();
            }
            if (this.fcS != null) {
                this.fcS.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fcR != null) {
            this.fcR.cancel();
        }
        if (this.fcS != null) {
            this.fcS.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fcQ);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.at.g(this.bZp, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.faj, t.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.at.cx(i);
        } else {
            i2 = -12895429;
        }
        this.bbr.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, false, this.dwy);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void nq() {
        this.bZp = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.bbr = (TextView) findViewById(t.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fcT);
        this.faj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.fcU);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.faj.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.faj.setLayoutParams(layoutParams);
        this.dwo = (EditText) findViewById(t.g.input);
        this.aIH = (ImageView) findViewById(t.g.vcode_image);
        this.aIH.setImageDrawable(null);
        this.aIH.setOnClickListener(new y(this));
        this.mProgressBar = (ProgressBar) findViewById(t.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(String str) {
        if (this.fcS != null) {
            this.fcS.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aIH.setImageDrawable(null);
        this.fcS = new a(this, null);
        this.fcS.setPriority(3);
        this.fcS.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.o> {
        private com.baidu.tbadk.core.util.ab aeI = null;
        private String evP = null;
        private WriteData fcX;

        public b(WriteData writeData) {
            this.fcX = null;
            this.fcX = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.o doInBackground(Integer... numArr) {
            String str;
            Address x;
            if (this.fcX != null) {
                this.aeI = new com.baidu.tbadk.core.util.ab();
                String editable = VcodeActivity.this.dwo.getText().toString();
                String imagesCodeForPost = this.fcX.getImagesCodeForPost();
                if (this.fcX.getType() == 3) {
                    this.aeI.n("newVcode", "1");
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fcX.getContent()) + imagesCodeForPost);
                    this.aeI.n(PayVcodeActivityConfig.VCODE_MD5, this.fcX.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aeI.n("vcode", editable);
                    }
                    this.aeI.n("tag", "11");
                    this.aeI.tA().uu().mIsNeedTbs = true;
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fcX.getContent()) + imagesCodeForPost);
                    this.aeI.setUrl(com.baidu.tieba.tbadkCore.c.a.etD);
                    this.aeI.n(ImageViewerConfig.FORUM_NAME, this.fcX.getForumName());
                    this.aeI.n("title", this.fcX.getTitle());
                    this.aeI.n("apiKey", this.fcX.getShareApiKey());
                    this.aeI.n("appName", this.fcX.getShareAppName());
                    this.aeI.n("signKey", this.fcX.getShareSignKey());
                    this.aeI.n("summary_title", this.fcX.getShareSummaryTitle());
                    this.aeI.n("summary_content", this.fcX.getShareSummaryContent());
                    this.aeI.n("summary_img", this.fcX.getShareSummaryImg());
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fcX.getShareSummaryImgWidth()));
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fcX.getShareSummaryImgHeight()));
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fcX.getShareSummaryImgType());
                    this.aeI.n("referUrl", this.fcX.getShareReferUrl());
                } else {
                    this.aeI.n("anonymous", "0");
                    this.aeI.n("fid", this.fcX.getForumId());
                    this.aeI.n("kw", this.fcX.getForumName());
                    this.aeI.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fcX.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fcX.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fcX.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fcX.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fcX.getGraffitiWriteCode();
                    }
                    if (this.fcX.getType() == 6 && this.fcX.getVoteInfo() != null) {
                        if (this.fcX.getWriteImagesInfo() != null) {
                            this.fcX.getVoteInfo().setServerImageCode(this.fcX.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fcX.getVoteInfo().buildWriteContent();
                    }
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.fcX.getIsBaobaoImageUploaded()) {
                        this.aeI.n("tail_type", String.valueOf(a.b.etK));
                        this.aeI.n("tail_content", this.fcX.getBaobaoContent());
                        this.fcX.setBabaoPosted(true);
                    } else {
                        this.fcX.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.aeI, this.fcX);
                    this.aeI.n(CommonVcodeActivityConfig.VCODE_MD5, this.fcX.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aeI.n("vcode", editable);
                    }
                    this.aeI.tA().uu().mIsNeedTbs = true;
                    if (this.fcX.getVoice() != null) {
                        this.aeI.n("voice_md5", this.fcX.getVoice());
                        this.aeI.n("during_time", String.valueOf(this.fcX.getVoiceDuringTime()));
                    }
                    if (this.fcX.getType() == 0) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcX.getTitle());
                        this.aeI.n("is_ntitle", this.fcX.isNoTitle() ? "1" : "0");
                        if (this.fcX.getCategoryFrom() >= 0) {
                            this.aeI.n("fromCategoryId", String.valueOf(this.fcX.getCategoryFrom()));
                        }
                        if (this.fcX.getCategoryTo() >= 0) {
                            this.aeI.n("toCategoryId", String.valueOf(this.fcX.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m11getInst().getIsLocationOn() && (x = com.baidu.adp.lib.e.a.cZ().x(false)) != null) {
                            this.aeI.n("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                        }
                    } else if (this.fcX.getType() == 6) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcX.getTitle());
                        this.aeI.n("is_ntitle", this.fcX.isNoTitle() ? "1" : "0");
                        this.aeI.n("thread_type", String.valueOf(36));
                    } else if (this.fcX.getType() == 4) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcX.getTitle());
                        this.aeI.n("is_ntitle", "0");
                        this.aeI.n("thread_type", String.valueOf(33));
                        this.aeI.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aeI.n("tid", this.fcX.getThreadId());
                        this.aeI.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fcX.getType() == 2) {
                            this.aeI.n("quote_id", String.valueOf(this.fcX.getFloor()));
                            this.aeI.n("floor_num", String.valueOf(this.fcX.getFloorNum()));
                            this.aeI.n(WriteActivityConfig.IS_ADDITION, this.fcX.isAddition() ? "1" : "0");
                            if (this.fcX.getRepostId() != null) {
                                this.aeI.n("repostid", this.fcX.getRepostId());
                            }
                        } else if (this.fcX.getType() == 5) {
                            this.aeI.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fcX.getType() == 1 && com.baidu.tbadk.editortools.d.b.BC().getStatus() == 1) {
                            this.aeI.n("ptype", "4");
                        }
                    }
                }
                this.evP = this.aeI.tc();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fcR = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aeI != null) {
                this.aeI.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.o oVar) {
            String str;
            int i;
            String str2;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.fcR = null;
            if (this.aeI != null) {
                if (this.aeI.tA().uv().nZ()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.evP);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.fcQ);
                        try {
                            str2 = new JSONObject(this.evP).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m11getInst().getString(t.j.send_success);
                        }
                        if (this.fcX.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.P(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.fcX.deleteUploadedTempImages();
                        if (this.fcX != null && this.fcX.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aTf();
                        }
                    } else if ((this.fcX.isHasImages() || this.fcX.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.fcX.getContent()) + this.fcX.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m11getInst().getString(t.j.img_upload_error));
                    } else if (this.fcX.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.evP).optString("tid");
                        str4 = new JSONObject(this.evP).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.evP).optJSONObject("twzhibo_info");
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
                } else if (this.fcX.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.fcX.getContent()) + this.fcX.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m11getInst().getString(t.j.img_upload_error));
                } else {
                    if (this.aeI.tE() == 5 || this.aeI.tE() == 6) {
                        com.baidu.tbadk.coreExtra.data.o oVar2 = new com.baidu.tbadk.coreExtra.data.o();
                        oVar2.parserJson(this.evP);
                        if (oVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fcQ.setVcodeMD5(oVar2.getVcode_md5());
                            VcodeActivity.this.fcQ.setVcodeUrl(oVar2.getVcode_pic_url());
                            VcodeActivity.this.pp(VcodeActivity.this.fcQ.getVcodeUrl());
                        }
                        VcodeActivity.this.dwo.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.aeI.getErrorString());
                }
            }
            super.onPostExecute(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.ab LL;
        private volatile boolean baL;
        com.baidu.tbadk.coreExtra.data.o fcW;

        private a() {
            this.LL = null;
            this.fcW = null;
            this.baL = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fcS = null;
            if (this.LL != null) {
                this.LL.dl();
            }
            this.baL = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.LL = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.LL.n("fid", VcodeActivity.this.fcQ.getForumId());
                this.LL.n("kw", VcodeActivity.this.fcQ.getForumName());
                this.LL.n("new_vcode", "1");
                this.LL.n("title", VcodeActivity.this.fcQ.getTitle());
                this.LL.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fcQ.getContent());
                if (VcodeActivity.this.fcQ.getType() == 0) {
                    this.LL.n("pub_type", "1");
                    if (VcodeActivity.this.fcQ.getCategoryFrom() >= 0) {
                        this.LL.n("fromCategoryId", String.valueOf(VcodeActivity.this.fcQ.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fcQ.getCategoryTo() >= 0) {
                        this.LL.n("toCategoryId", String.valueOf(VcodeActivity.this.fcQ.getCategoryTo()));
                    }
                } else {
                    this.LL.n("pub_type", "2");
                    this.LL.n("tid", VcodeActivity.this.fcQ.getThreadId());
                }
                String tc = this.LL.tc();
                if (!this.LL.tA().uv().nZ()) {
                    return null;
                }
                this.fcW = new com.baidu.tbadk.coreExtra.data.o();
                this.fcW.parserJson(tc);
                str = this.fcW.getVcode_pic_url();
            }
            if (this.baL) {
                return null;
            }
            this.LL = new com.baidu.tbadk.core.util.ab(str);
            return BitmapHelper.Bytes2Bitmap(this.LL.td());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fcS = null;
            if (bitmap != null) {
                VcodeActivity.this.aIH.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.fcW != null) {
                VcodeActivity.this.fcQ.setVcodeMD5(this.fcW.getVcode_md5());
                VcodeActivity.this.fcQ.setVcodeUrl(this.fcW.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
