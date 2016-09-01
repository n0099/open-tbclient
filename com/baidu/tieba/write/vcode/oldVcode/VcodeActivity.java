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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData gbW = null;
    private TextView fjc = null;
    private ImageView aSs = null;
    private EditText eFX = null;
    private ProgressBar mProgressBar = null;
    private b gbX = null;
    private a gbY = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener eGh = null;
    private RelativeLayout cSU = null;
    private TextView bLc = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener gbZ = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener gca = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.vcode_activity);
        initUI();
        initData(bundle);
        sl(this.gbW.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.eGh = new c(this);
        if (bundle != null) {
            this.gbW = (WriteData) bundle.getSerializable("model");
        } else {
            this.gbW = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gbW != null && this.gbW.getType() == 3) {
            if (this.gbX != null) {
                this.gbX.cancel();
            }
            if (this.gbY != null) {
                this.gbY.cancel();
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
        if (this.gbX != null) {
            this.gbX.cancel();
        }
        if (this.gbY != null) {
            this.gbY.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.gbW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        av.g(this.cSU, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.fjc, t.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = av.cK(i);
        } else {
            i2 = -12895429;
        }
        this.bLc.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, false, this.eGh);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.cSU = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.bLc = (TextView) findViewById(t.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gbZ);
        this.fjc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.gca);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjc.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), t.e.ds16);
        this.fjc.setLayoutParams(layoutParams);
        this.eFX = (EditText) findViewById(t.g.input);
        this.aSs = (ImageView) findViewById(t.g.vcode_image);
        this.aSs.setImageDrawable(null);
        this.aSs.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(t.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(String str) {
        if (this.gbY != null) {
            this.gbY.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aSs.setImageDrawable(null);
        this.gbY = new a(this, null);
        this.gbY.setPriority(3);
        this.gbY.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, s> {
        private ab aiS = null;
        private String fvC = null;
        private WriteData gcd;

        public b(WriteData writeData) {
            this.gcd = null;
            this.gcd = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public s doInBackground(Integer... numArr) {
            String str;
            Address B;
            if (this.gcd != null) {
                this.aiS = new ab();
                String editable = VcodeActivity.this.eFX.getText().toString();
                String imagesCodeForPost = this.gcd.getImagesCodeForPost();
                if (this.gcd.getType() == 3) {
                    this.aiS.n("newVcode", "1");
                    this.aiS.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.gcd.getContent()) + imagesCodeForPost);
                    this.aiS.n(PayVcodeActivityConfig.VCODE_MD5, this.gcd.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiS.n("vcode", editable);
                    }
                    this.aiS.n("tag", "11");
                    this.aiS.uD().vz().mIsNeedTbs = true;
                    this.aiS.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.gcd.getContent()) + imagesCodeForPost);
                    this.aiS.setUrl(com.baidu.tieba.tbadkCore.c.a.ftq);
                    this.aiS.n(ImageViewerConfig.FORUM_NAME, this.gcd.getForumName());
                    this.aiS.n(VrPlayerActivityConfig.TITLE, this.gcd.getTitle());
                    this.aiS.n("apiKey", this.gcd.getShareApiKey());
                    this.aiS.n("appName", this.gcd.getShareAppName());
                    this.aiS.n("signKey", this.gcd.getShareSignKey());
                    this.aiS.n("summary_title", this.gcd.getShareSummaryTitle());
                    this.aiS.n("summary_content", this.gcd.getShareSummaryContent());
                    this.aiS.n("summary_img", this.gcd.getShareSummaryImg());
                    this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.gcd.getShareSummaryImgWidth()));
                    this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.gcd.getShareSummaryImgHeight()));
                    this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.gcd.getShareSummaryImgType());
                    this.aiS.n("referUrl", this.gcd.getShareReferUrl());
                } else {
                    this.aiS.n("anonymous", "0");
                    this.aiS.n("fid", this.gcd.getForumId());
                    this.aiS.n("kw", this.gcd.getForumName());
                    this.aiS.n("new_vcode", "1");
                    VideoInfo videoInfo = this.gcd.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.gcd.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.gcd.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.gcd.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.gcd.getGraffitiWriteCode();
                    }
                    if (this.gcd.getType() == 6 && this.gcd.getVoteInfo() != null) {
                        if (this.gcd.getWriteImagesInfo() != null) {
                            this.gcd.getVoteInfo().setServerImageCode(this.gcd.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.gcd.getVoteInfo().buildWriteContent();
                    }
                    this.aiS.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.gcd.getIsBaobaoImageUploaded()) {
                        this.aiS.n("tail_type", String.valueOf(a.b.ftx));
                        this.aiS.n("tail_content", this.gcd.getBaobaoContent());
                        this.gcd.setBabaoPosted(true);
                    } else {
                        this.gcd.setBabaoPosted(false);
                    }
                    f.a(this.aiS, this.gcd);
                    this.aiS.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.gcd.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiS.n("vcode", editable);
                    }
                    this.aiS.uD().vz().mIsNeedTbs = true;
                    if (this.gcd.getVoice() != null) {
                        this.aiS.n("voice_md5", this.gcd.getVoice());
                        this.aiS.n("during_time", String.valueOf(this.gcd.getVoiceDuringTime()));
                    }
                    if (this.gcd.getType() == 0) {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiS.n(VrPlayerActivityConfig.TITLE, this.gcd.getTitle());
                        this.aiS.n("is_ntitle", this.gcd.isNoTitle() ? "1" : "0");
                        if (this.gcd.getCategoryFrom() >= 0) {
                            this.aiS.n("fromCategoryId", String.valueOf(this.gcd.getCategoryFrom()));
                        }
                        if (this.gcd.getCategoryTo() >= 0) {
                            this.aiS.n("toCategoryId", String.valueOf(this.gcd.getCategoryTo()));
                        }
                        String hiAlbumId = this.gcd.getHiAlbumId();
                        if (hiAlbumId != null) {
                            this.aiS.n("17hi_album_id", hiAlbumId);
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (B = com.baidu.adp.lib.e.a.dU().B(false)) != null) {
                            this.aiS.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                        }
                    } else if (this.gcd.getType() == 6) {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiS.n(VrPlayerActivityConfig.TITLE, this.gcd.getTitle());
                        this.aiS.n("is_ntitle", this.gcd.isNoTitle() ? "1" : "0");
                        this.aiS.n("thread_type", String.valueOf(36));
                    } else if (this.gcd.getType() == 4) {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiS.n(VrPlayerActivityConfig.TITLE, this.gcd.getTitle());
                        this.aiS.n("is_ntitle", "0");
                        this.aiS.n("thread_type", String.valueOf(33));
                        this.aiS.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.gcd.getType() == 7) {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiS.n(VrPlayerActivityConfig.TITLE, this.gcd.getTitle());
                        this.aiS.n("is_ntitle", this.gcd.isNoTitle() ? "1" : "0");
                        this.aiS.n("product_id", new StringBuilder(String.valueOf(this.gcd.productId)).toString());
                    } else {
                        this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aiS.n("tid", this.gcd.getThreadId());
                        this.aiS.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.gcd.getType() == 2) {
                            this.aiS.n("quote_id", String.valueOf(this.gcd.getFloor()));
                            this.aiS.n("floor_num", String.valueOf(this.gcd.getFloorNum()));
                            this.aiS.n("is_addition", this.gcd.isAddition() ? "1" : "0");
                            if (this.gcd.getRepostId() != null) {
                                this.aiS.n("repostid", this.gcd.getRepostId());
                            }
                        } else if (this.gcd.getType() == 5) {
                            this.aiS.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.gcd.getType() == 1) {
                            this.aiS.n("is_barrage", this.gcd.isBarrage() ? "1" : "0");
                            this.aiS.n("barrage_time", String.valueOf(this.gcd.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.d.b.Dh().getStatus() == 1) {
                                this.aiS.n("ptype", "4");
                            }
                        }
                    }
                }
                this.fvC = this.aiS.ue();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gbX = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aiS != null) {
                this.aiS.eg();
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
            VcodeActivity.this.gbX = null;
            if (this.aiS != null) {
                if (this.aiS.uD().vA().oE()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.fvC);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.gbW);
                        try {
                            str2 = new JSONObject(this.fvC).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m9getInst().getString(t.j.send_success);
                        }
                        if (this.gcd.getType() != 3) {
                            f.S(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.gcd.deleteUploadedTempImages();
                        if (this.gcd != null && this.gcd.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.bis();
                        }
                    } else if ((this.gcd.isHasImages() || this.gcd.getIsBaobao()) && j.isEmpty(String.valueOf(this.gcd.getContent()) + this.gcd.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(t.j.img_upload_error));
                    } else if (this.gcd.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.fvC).optString("tid");
                        str4 = new JSONObject(this.fvC).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.fvC).optJSONObject("twzhibo_info");
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
                } else if (this.gcd.isHasImages() && j.isEmpty(String.valueOf(this.gcd.getContent()) + this.gcd.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(t.j.img_upload_error));
                } else {
                    if (this.aiS.uH() == 5 || this.aiS.uH() == 6) {
                        s sVar2 = new s();
                        sVar2.parserJson(this.fvC);
                        if (sVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.gbW.setVcodeMD5(sVar2.getVcode_md5());
                            VcodeActivity.this.gbW.setVcodeUrl(sVar2.getVcode_pic_url());
                            VcodeActivity.this.sl(VcodeActivity.this.gbW.getVcodeUrl());
                        }
                        VcodeActivity.this.eFX.setText((CharSequence) null);
                    } else if (this.gcd != null && this.aiS.uH() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.fvC);
                        PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.aiS.uH(), this.aiS.getErrorString(), null, null);
                        postWriteCallBackData2.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.gcd, postWriteCallBackData2.getAccessState())));
                    }
                    if (this.aiS.uH() != 227001) {
                        VcodeActivity.this.showToast(this.aiS.getErrorString());
                    }
                }
            }
            super.onPostExecute(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile ab NX;
        private volatile boolean bKw;
        s gcc;

        private a() {
            this.NX = null;
            this.gcc = null;
            this.bKw = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gbY = null;
            if (this.NX != null) {
                this.NX.eg();
            }
            this.bKw = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.NX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.NX.n("fid", VcodeActivity.this.gbW.getForumId());
                this.NX.n("kw", VcodeActivity.this.gbW.getForumName());
                this.NX.n("new_vcode", "1");
                this.NX.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.gbW.getTitle());
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.gbW.getContent());
                if (VcodeActivity.this.gbW.getType() == 0) {
                    this.NX.n("pub_type", "1");
                    if (VcodeActivity.this.gbW.getCategoryFrom() >= 0) {
                        this.NX.n("fromCategoryId", String.valueOf(VcodeActivity.this.gbW.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.gbW.getCategoryTo() >= 0) {
                        this.NX.n("toCategoryId", String.valueOf(VcodeActivity.this.gbW.getCategoryTo()));
                    }
                } else {
                    this.NX.n("pub_type", "2");
                    this.NX.n("tid", VcodeActivity.this.gbW.getThreadId());
                }
                String ue = this.NX.ue();
                if (!this.NX.uD().vA().oE()) {
                    return null;
                }
                this.gcc = new s();
                this.gcc.parserJson(ue);
                str = this.gcc.getVcode_pic_url();
            }
            if (this.bKw) {
                return null;
            }
            this.NX = new ab(str);
            return BitmapHelper.Bytes2Bitmap(this.NX.uf());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.gbY = null;
            if (bitmap != null) {
                VcodeActivity.this.aSs.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.gcc != null) {
                VcodeActivity.this.gbW.setVcodeMD5(this.gcc.getVcode_md5());
                VcodeActivity.this.gbW.setVcodeUrl(this.gcc.getVcode_pic_url());
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
