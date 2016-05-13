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
    private WriteData fcP = null;
    private TextView fai = null;
    private ImageView aIH = null;
    private EditText dwo = null;
    private ProgressBar mProgressBar = null;
    private b fcQ = null;
    private a fcR = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener dwy = null;
    private RelativeLayout bZp = null;
    private TextView bbr = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener fcS = new v(this);
    private final View.OnClickListener fcT = new w(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.vcode_activity);
        nq();
        initData(bundle);
        pp(this.fcP.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.dwy = new x(this);
        if (bundle != null) {
            this.fcP = (WriteData) bundle.getSerializable("model");
        } else {
            this.fcP = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fcP != null && this.fcP.getType() == 3) {
            if (this.fcQ != null) {
                this.fcQ.cancel();
            }
            if (this.fcR != null) {
                this.fcR.cancel();
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
        if (this.fcQ != null) {
            this.fcQ.cancel();
        }
        if (this.fcR != null) {
            this.fcR.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fcP);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.at.g(this.bZp, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.fai, t.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.at.cw(i);
        } else {
            i2 = -12895429;
        }
        this.bbr.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, false, this.dwy);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void nq() {
        this.bZp = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.bbr = (TextView) findViewById(t.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fcS);
        this.fai = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.fcT);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fai.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.fai.setLayoutParams(layoutParams);
        this.dwo = (EditText) findViewById(t.g.input);
        this.aIH = (ImageView) findViewById(t.g.vcode_image);
        this.aIH.setImageDrawable(null);
        this.aIH.setOnClickListener(new y(this));
        this.mProgressBar = (ProgressBar) findViewById(t.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(String str) {
        if (this.fcR != null) {
            this.fcR.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aIH.setImageDrawable(null);
        this.fcR = new a(this, null);
        this.fcR.setPriority(3);
        this.fcR.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.o> {
        private com.baidu.tbadk.core.util.ab aeI = null;
        private String evP = null;
        private WriteData fcW;

        public b(WriteData writeData) {
            this.fcW = null;
            this.fcW = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.o doInBackground(Integer... numArr) {
            String str;
            Address x;
            if (this.fcW != null) {
                this.aeI = new com.baidu.tbadk.core.util.ab();
                String editable = VcodeActivity.this.dwo.getText().toString();
                String imagesCodeForPost = this.fcW.getImagesCodeForPost();
                if (this.fcW.getType() == 3) {
                    this.aeI.n("newVcode", "1");
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fcW.getContent()) + imagesCodeForPost);
                    this.aeI.n(PayVcodeActivityConfig.VCODE_MD5, this.fcW.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aeI.n("vcode", editable);
                    }
                    this.aeI.n("tag", "11");
                    this.aeI.tB().uv().mIsNeedTbs = true;
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fcW.getContent()) + imagesCodeForPost);
                    this.aeI.setUrl(com.baidu.tieba.tbadkCore.c.a.etD);
                    this.aeI.n(ImageViewerConfig.FORUM_NAME, this.fcW.getForumName());
                    this.aeI.n("title", this.fcW.getTitle());
                    this.aeI.n("apiKey", this.fcW.getShareApiKey());
                    this.aeI.n("appName", this.fcW.getShareAppName());
                    this.aeI.n("signKey", this.fcW.getShareSignKey());
                    this.aeI.n("summary_title", this.fcW.getShareSummaryTitle());
                    this.aeI.n("summary_content", this.fcW.getShareSummaryContent());
                    this.aeI.n("summary_img", this.fcW.getShareSummaryImg());
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fcW.getShareSummaryImgWidth()));
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fcW.getShareSummaryImgHeight()));
                    this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fcW.getShareSummaryImgType());
                    this.aeI.n("referUrl", this.fcW.getShareReferUrl());
                } else {
                    this.aeI.n("anonymous", "0");
                    this.aeI.n("fid", this.fcW.getForumId());
                    this.aeI.n("kw", this.fcW.getForumName());
                    this.aeI.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fcW.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fcW.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fcW.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fcW.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fcW.getGraffitiWriteCode();
                    }
                    if (this.fcW.getType() == 6 && this.fcW.getVoteInfo() != null) {
                        if (this.fcW.getWriteImagesInfo() != null) {
                            this.fcW.getVoteInfo().setServerImageCode(this.fcW.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fcW.getVoteInfo().buildWriteContent();
                    }
                    this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.fcW.getIsBaobaoImageUploaded()) {
                        this.aeI.n("tail_type", String.valueOf(a.b.etK));
                        this.aeI.n("tail_content", this.fcW.getBaobaoContent());
                        this.fcW.setBabaoPosted(true);
                    } else {
                        this.fcW.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.aeI, this.fcW);
                    this.aeI.n(CommonVcodeActivityConfig.VCODE_MD5, this.fcW.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aeI.n("vcode", editable);
                    }
                    this.aeI.tB().uv().mIsNeedTbs = true;
                    if (this.fcW.getVoice() != null) {
                        this.aeI.n("voice_md5", this.fcW.getVoice());
                        this.aeI.n("during_time", String.valueOf(this.fcW.getVoiceDuringTime()));
                    }
                    if (this.fcW.getType() == 0) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcW.getTitle());
                        this.aeI.n("is_ntitle", this.fcW.isNoTitle() ? "1" : "0");
                        if (this.fcW.getCategoryFrom() >= 0) {
                            this.aeI.n("fromCategoryId", String.valueOf(this.fcW.getCategoryFrom()));
                        }
                        if (this.fcW.getCategoryTo() >= 0) {
                            this.aeI.n("toCategoryId", String.valueOf(this.fcW.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m11getInst().getIsLocationOn() && (x = com.baidu.adp.lib.e.a.cZ().x(false)) != null) {
                            this.aeI.n("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                        }
                    } else if (this.fcW.getType() == 6) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcW.getTitle());
                        this.aeI.n("is_ntitle", this.fcW.isNoTitle() ? "1" : "0");
                        this.aeI.n("thread_type", String.valueOf(36));
                    } else if (this.fcW.getType() == 4) {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aeI.n("title", this.fcW.getTitle());
                        this.aeI.n("is_ntitle", "0");
                        this.aeI.n("thread_type", String.valueOf(33));
                        this.aeI.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aeI.n("tid", this.fcW.getThreadId());
                        this.aeI.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fcW.getType() == 2) {
                            this.aeI.n("quote_id", String.valueOf(this.fcW.getFloor()));
                            this.aeI.n("floor_num", String.valueOf(this.fcW.getFloorNum()));
                            this.aeI.n(WriteActivityConfig.IS_ADDITION, this.fcW.isAddition() ? "1" : "0");
                            if (this.fcW.getRepostId() != null) {
                                this.aeI.n("repostid", this.fcW.getRepostId());
                            }
                        } else if (this.fcW.getType() == 5) {
                            this.aeI.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fcW.getType() == 1 && com.baidu.tbadk.editortools.d.b.BD().getStatus() == 1) {
                            this.aeI.n("ptype", "4");
                        }
                    }
                }
                this.evP = this.aeI.td();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fcQ = null;
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
            VcodeActivity.this.fcQ = null;
            if (this.aeI != null) {
                if (this.aeI.tB().uw().nZ()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.evP);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.fcP);
                        try {
                            str2 = new JSONObject(this.evP).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m11getInst().getString(t.j.send_success);
                        }
                        if (this.fcW.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.P(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.fcW.deleteUploadedTempImages();
                        if (this.fcW != null && this.fcW.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aTl();
                        }
                    } else if ((this.fcW.isHasImages() || this.fcW.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.fcW.getContent()) + this.fcW.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m11getInst().getString(t.j.img_upload_error));
                    } else if (this.fcW.getType() != 3) {
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
                } else if (this.fcW.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.fcW.getContent()) + this.fcW.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m11getInst().getString(t.j.img_upload_error));
                } else {
                    if (this.aeI.tF() == 5 || this.aeI.tF() == 6) {
                        com.baidu.tbadk.coreExtra.data.o oVar2 = new com.baidu.tbadk.coreExtra.data.o();
                        oVar2.parserJson(this.evP);
                        if (oVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fcP.setVcodeMD5(oVar2.getVcode_md5());
                            VcodeActivity.this.fcP.setVcodeUrl(oVar2.getVcode_pic_url());
                            VcodeActivity.this.pp(VcodeActivity.this.fcP.getVcodeUrl());
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
        com.baidu.tbadk.coreExtra.data.o fcV;

        private a() {
            this.LL = null;
            this.fcV = null;
            this.baL = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fcR = null;
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
                this.LL.n("fid", VcodeActivity.this.fcP.getForumId());
                this.LL.n("kw", VcodeActivity.this.fcP.getForumName());
                this.LL.n("new_vcode", "1");
                this.LL.n("title", VcodeActivity.this.fcP.getTitle());
                this.LL.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fcP.getContent());
                if (VcodeActivity.this.fcP.getType() == 0) {
                    this.LL.n("pub_type", "1");
                    if (VcodeActivity.this.fcP.getCategoryFrom() >= 0) {
                        this.LL.n("fromCategoryId", String.valueOf(VcodeActivity.this.fcP.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fcP.getCategoryTo() >= 0) {
                        this.LL.n("toCategoryId", String.valueOf(VcodeActivity.this.fcP.getCategoryTo()));
                    }
                } else {
                    this.LL.n("pub_type", "2");
                    this.LL.n("tid", VcodeActivity.this.fcP.getThreadId());
                }
                String td = this.LL.td();
                if (!this.LL.tB().uw().nZ()) {
                    return null;
                }
                this.fcV = new com.baidu.tbadk.coreExtra.data.o();
                this.fcV.parserJson(td);
                str = this.fcV.getVcode_pic_url();
            }
            if (this.baL) {
                return null;
            }
            this.LL = new com.baidu.tbadk.core.util.ab(str);
            return BitmapHelper.Bytes2Bitmap(this.LL.te());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fcR = null;
            if (bitmap != null) {
                VcodeActivity.this.aIH.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.fcV != null) {
                VcodeActivity.this.fcP.setVcodeMD5(this.fcV.getVcode_md5());
                VcodeActivity.this.fcP.setVcodeUrl(this.fcV.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
