package com.baidu.tieba.write.vcode.oldVcode;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData glJ = null;
    private TextView fsR = null;
    private ImageView aVc = null;
    private EditText eOA = null;
    private ProgressBar mProgressBar = null;
    private b glK = null;
    private a glL = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener eOK = null;
    private RelativeLayout cZW = null;
    private TextView bNW = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener glM = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener glN = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.vcode_activity);
        initUI();
        initData(bundle);
        sW(this.glJ.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.eOK = new c(this);
        if (bundle != null) {
            this.glJ = (WriteData) bundle.getSerializable("model");
        } else {
            this.glJ = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.glJ != null && this.glJ.getType() == 3) {
            if (this.glK != null) {
                this.glK.cancel();
            }
            if (this.glL != null) {
                this.glL.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.glK != null) {
            this.glK.cancel();
        }
        if (this.glL != null) {
            this.glL.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.glJ);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        at.g(this.cZW, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        at.k(this.fsR, r.f.s_navbar_button_bg);
        at.j((View) this.fsR, r.d.cp_cont_g);
        if (i == 1) {
            i2 = at.cL(i);
        } else {
            i2 = -12895429;
        }
        this.bNW.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(r.j.sending), true, false, this.eOK);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.cZW = (RelativeLayout) findViewById(r.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.bNW = (TextView) findViewById(r.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.glM);
        this.fsR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.send), this.glN);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsR.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.e.ds16);
        this.fsR.setLayoutParams(layoutParams);
        this.eOA = (EditText) findViewById(r.g.input);
        this.aVc = (ImageView) findViewById(r.g.vcode_image);
        this.aVc.setImageDrawable(null);
        this.aVc.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(r.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(String str) {
        if (this.glL != null) {
            this.glL.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aVc.setImageDrawable(null);
        this.glL = new a(this, null);
        this.glL.setPriority(3);
        this.glL.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, s> {
        private z ajm = null;
        private String fFJ = null;
        private WriteData glQ;

        public b(WriteData writeData) {
            this.glQ = null;
            this.glQ = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public s doInBackground(Integer... numArr) {
            String str;
            Address B;
            if (this.glQ != null) {
                this.ajm = new z();
                String editable = VcodeActivity.this.eOA.getText().toString();
                String imagesCodeForPost = this.glQ.getImagesCodeForPost();
                if (this.glQ.getType() == 3) {
                    this.ajm.n("newVcode", "1");
                    this.ajm.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.glQ.getContent()) + imagesCodeForPost);
                    this.ajm.n(PayVcodeActivityConfig.VCODE_MD5, this.glQ.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.ajm.n("vcode", editable);
                    }
                    this.ajm.n("tag", "11");
                    this.ajm.uW().vR().mIsNeedTbs = true;
                    this.ajm.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.glQ.getContent()) + imagesCodeForPost);
                    this.ajm.setUrl(com.baidu.tieba.tbadkCore.c.a.fDe);
                    this.ajm.n(ImageViewerConfig.FORUM_NAME, this.glQ.getForumName());
                    this.ajm.n(VrPlayerActivityConfig.TITLE, this.glQ.getTitle());
                    this.ajm.n("apiKey", this.glQ.getShareApiKey());
                    this.ajm.n("appName", this.glQ.getShareAppName());
                    this.ajm.n("signKey", this.glQ.getShareSignKey());
                    this.ajm.n("summary_title", this.glQ.getShareSummaryTitle());
                    this.ajm.n("summary_content", this.glQ.getShareSummaryContent());
                    this.ajm.n("summary_img", this.glQ.getShareSummaryImg());
                    this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.glQ.getShareSummaryImgWidth()));
                    this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.glQ.getShareSummaryImgHeight()));
                    this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.glQ.getShareSummaryImgType());
                    this.ajm.n("referUrl", this.glQ.getShareReferUrl());
                } else {
                    this.ajm.n("anonymous", "0");
                    this.ajm.n("fid", this.glQ.getForumId());
                    this.ajm.n("kw", this.glQ.getForumName());
                    this.ajm.n("new_vcode", "1");
                    VideoInfo videoInfo = this.glQ.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.glQ.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.glQ.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.glQ.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.glQ.getGraffitiWriteCode();
                    }
                    if (this.glQ.getType() == 6 && this.glQ.getVoteInfo() != null) {
                        if (this.glQ.getWriteImagesInfo() != null) {
                            this.glQ.getVoteInfo().setServerImageCode(this.glQ.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.glQ.getVoteInfo().buildWriteContent();
                    }
                    this.ajm.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    f.a(this.ajm, this.glQ);
                    this.ajm.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.glQ.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.ajm.n("vcode", editable);
                    }
                    this.ajm.uW().vR().mIsNeedTbs = true;
                    if (this.glQ.getVoice() != null) {
                        this.ajm.n("voice_md5", this.glQ.getVoice());
                        this.ajm.n("during_time", String.valueOf(this.glQ.getVoiceDuringTime()));
                    }
                    if (this.glQ.getType() == 0) {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ajm.n(VrPlayerActivityConfig.TITLE, this.glQ.getTitle());
                        this.ajm.n("is_ntitle", this.glQ.isNoTitle() ? "1" : "0");
                        if (this.glQ.getCategoryFrom() >= 0) {
                            this.ajm.n("fromCategoryId", String.valueOf(this.glQ.getCategoryFrom()));
                        }
                        if (this.glQ.getCategoryTo() >= 0) {
                            this.ajm.n("toCategoryId", String.valueOf(this.glQ.getCategoryTo()));
                        }
                        String hiAlbumId = this.glQ.getHiAlbumId();
                        if (hiAlbumId != null) {
                            this.ajm.n("17hi_album_id", hiAlbumId);
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (B = com.baidu.adp.lib.e.a.dU().B(false)) != null) {
                            this.ajm.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                        }
                    } else if (this.glQ.getType() == 6) {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ajm.n(VrPlayerActivityConfig.TITLE, this.glQ.getTitle());
                        this.ajm.n("is_ntitle", this.glQ.isNoTitle() ? "1" : "0");
                        this.ajm.n("thread_type", String.valueOf(36));
                    } else if (this.glQ.getType() == 4) {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ajm.n(VrPlayerActivityConfig.TITLE, this.glQ.getTitle());
                        this.ajm.n("is_ntitle", "0");
                        this.ajm.n("thread_type", String.valueOf(33));
                        this.ajm.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.glQ.getType() == 7) {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ajm.n(VrPlayerActivityConfig.TITLE, this.glQ.getTitle());
                        this.ajm.n("is_ntitle", this.glQ.isNoTitle() ? "1" : "0");
                        this.ajm.n("product_id", new StringBuilder(String.valueOf(this.glQ.productId)).toString());
                    } else {
                        this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.ajm.n("tid", this.glQ.getThreadId());
                        this.ajm.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.glQ.getType() == 2) {
                            this.ajm.n("quote_id", String.valueOf(this.glQ.getFloor()));
                            this.ajm.n("floor_num", String.valueOf(this.glQ.getFloorNum()));
                            this.ajm.n("is_addition", this.glQ.isAddition() ? "1" : "0");
                            if (this.glQ.getRepostId() != null) {
                                this.ajm.n("repostid", this.glQ.getRepostId());
                            }
                        } else if (this.glQ.getType() == 5) {
                            this.ajm.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.glQ.getType() == 1) {
                            this.ajm.n("is_barrage", this.glQ.isBarrage() ? "1" : "0");
                            this.ajm.n("barrage_time", String.valueOf(this.glQ.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.e.b.Dp().getStatus() == 1) {
                                this.ajm.n("ptype", "4");
                            }
                        }
                    }
                }
                this.fFJ = this.ajm.uy();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.glK = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.ajm != null) {
                this.ajm.eg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(s sVar) {
            String str;
            int i;
            String str2;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.glK = null;
            if (this.ajm != null) {
                if (this.ajm.uW().vS().oH()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.fFJ);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.glJ);
                        try {
                            str2 = new JSONObject(this.fFJ).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m9getInst().getString(r.j.send_success);
                        }
                        if (this.glQ.getType() != 3) {
                            f.T(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.glQ.deleteUploadedTempImages();
                    } else if (this.glQ.isHasImages() && j.isEmpty(String.valueOf(this.glQ.getContent()) + this.glQ.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                    } else if (this.glQ.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.fFJ).optString("tid");
                        str4 = new JSONObject(this.fFJ).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.fFJ).optJSONObject("twzhibo_info");
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
                } else if (this.glQ.isHasImages() && j.isEmpty(String.valueOf(this.glQ.getContent()) + this.glQ.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                } else {
                    if (this.ajm.va() == 5 || this.ajm.va() == 6) {
                        s sVar2 = new s();
                        sVar2.parserJson(this.fFJ);
                        if (sVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.glJ.setVcodeMD5(sVar2.getVcode_md5());
                            VcodeActivity.this.glJ.setVcodeUrl(sVar2.getVcode_pic_url());
                            VcodeActivity.this.sW(VcodeActivity.this.glJ.getVcodeUrl());
                        }
                        VcodeActivity.this.eOA.setText((CharSequence) null);
                    } else if (this.glQ != null && this.ajm.va() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.fFJ);
                        PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.ajm.va(), this.ajm.getErrorString(), null, null);
                        postWriteCallBackData2.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.glQ, postWriteCallBackData2.getAccessState())));
                    }
                    if (this.ajm.va() != 227001) {
                        VcodeActivity.this.showToast(this.ajm.getErrorString());
                    }
                }
            }
            super.onPostExecute(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile z Ob;
        private volatile boolean bNq;
        s glP;

        private a() {
            this.Ob = null;
            this.glP = null;
            this.bNq = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.glL = null;
            if (this.Ob != null) {
                this.Ob.eg();
            }
            this.bNq = true;
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
                this.Ob = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Ob.n("fid", VcodeActivity.this.glJ.getForumId());
                this.Ob.n("kw", VcodeActivity.this.glJ.getForumName());
                this.Ob.n("new_vcode", "1");
                this.Ob.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.glJ.getTitle());
                this.Ob.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.glJ.getContent());
                if (VcodeActivity.this.glJ.getType() == 0) {
                    this.Ob.n("pub_type", "1");
                    if (VcodeActivity.this.glJ.getCategoryFrom() >= 0) {
                        this.Ob.n("fromCategoryId", String.valueOf(VcodeActivity.this.glJ.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.glJ.getCategoryTo() >= 0) {
                        this.Ob.n("toCategoryId", String.valueOf(VcodeActivity.this.glJ.getCategoryTo()));
                    }
                } else {
                    this.Ob.n("pub_type", "2");
                    this.Ob.n("tid", VcodeActivity.this.glJ.getThreadId());
                }
                String uy = this.Ob.uy();
                if (!this.Ob.uW().vS().oH()) {
                    return null;
                }
                this.glP = new s();
                this.glP.parserJson(uy);
                str = this.glP.getVcode_pic_url();
            }
            if (this.bNq) {
                return null;
            }
            this.Ob = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.Ob.uz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.glL = null;
            if (bitmap != null) {
                VcodeActivity.this.aVc.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.glP != null) {
                VcodeActivity.this.glJ.setVcodeMD5(this.glP.getVcode_md5());
                VcodeActivity.this.glJ.setVcodeUrl(this.glP.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12006:
                    setResult(-1, intent);
                    break;
            }
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }
}
