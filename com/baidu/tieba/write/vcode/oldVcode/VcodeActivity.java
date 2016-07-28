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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.e;
import com.baidu.tieba.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData fRR = null;
    private TextView faO = null;
    private ImageView aMY = null;
    private EditText ezv = null;
    private ProgressBar mProgressBar = null;
    private b fRS = null;
    private a fRT = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ezF = null;
    private RelativeLayout cHo = null;
    private TextView bzA = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener fRU = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener fRV = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.vcode_activity);
        initUI();
        initData(bundle);
        rB(this.fRR.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.ezF = new c(this);
        if (bundle != null) {
            this.fRR = (WriteData) bundle.getSerializable("model");
        } else {
            this.fRR = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fRR != null && this.fRR.getType() == 3) {
            if (this.fRS != null) {
                this.fRS.cancel();
            }
            if (this.fRT != null) {
                this.fRT.cancel();
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
        if (this.fRS != null) {
            this.fRS.cancel();
        }
        if (this.fRT != null) {
            this.fRT.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fRR);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        av.g(this.cHo, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.faO, u.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = av.cx(i);
        } else {
            i2 = -12895429;
        }
        this.bzA.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(u.j.sending), true, false, this.ezF);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.cHo = (RelativeLayout) findViewById(u.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.bzA = (TextView) findViewById(u.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fRU);
        this.faO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(u.j.send), this.fRV);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.faO.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), u.e.ds16);
        this.faO.setLayoutParams(layoutParams);
        this.ezv = (EditText) findViewById(u.g.input);
        this.aMY = (ImageView) findViewById(u.g.vcode_image);
        this.aMY.setImageDrawable(null);
        this.aMY.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(u.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(String str) {
        if (this.fRT != null) {
            this.fRT.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aMY.setImageDrawable(null);
        this.fRT = new a(this, null);
        this.fRT.setPriority(3);
        this.fRT.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, p> {
        private WriteData fRY;
        private ab afX = null;
        private String fnI = null;

        public b(WriteData writeData) {
            this.fRY = null;
            this.fRY = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public p doInBackground(Integer... numArr) {
            String str;
            Address z;
            if (this.fRY != null) {
                this.afX = new ab();
                String editable = VcodeActivity.this.ezv.getText().toString();
                String imagesCodeForPost = this.fRY.getImagesCodeForPost();
                if (this.fRY.getType() == 3) {
                    this.afX.n("newVcode", "1");
                    this.afX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fRY.getContent()) + imagesCodeForPost);
                    this.afX.n(PayVcodeActivityConfig.VCODE_MD5, this.fRY.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afX.n("vcode", editable);
                    }
                    this.afX.n("tag", "11");
                    this.afX.tx().uu().mIsNeedTbs = true;
                    this.afX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fRY.getContent()) + imagesCodeForPost);
                    this.afX.setUrl(com.baidu.tieba.tbadkCore.c.a.flw);
                    this.afX.n(ImageViewerConfig.FORUM_NAME, this.fRY.getForumName());
                    this.afX.n("title", this.fRY.getTitle());
                    this.afX.n("apiKey", this.fRY.getShareApiKey());
                    this.afX.n("appName", this.fRY.getShareAppName());
                    this.afX.n("signKey", this.fRY.getShareSignKey());
                    this.afX.n("summary_title", this.fRY.getShareSummaryTitle());
                    this.afX.n("summary_content", this.fRY.getShareSummaryContent());
                    this.afX.n("summary_img", this.fRY.getShareSummaryImg());
                    this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fRY.getShareSummaryImgWidth()));
                    this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fRY.getShareSummaryImgHeight()));
                    this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fRY.getShareSummaryImgType());
                    this.afX.n("referUrl", this.fRY.getShareReferUrl());
                } else {
                    this.afX.n("anonymous", "0");
                    this.afX.n("fid", this.fRY.getForumId());
                    this.afX.n("kw", this.fRY.getForumName());
                    this.afX.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fRY.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fRY.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fRY.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fRY.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fRY.getGraffitiWriteCode();
                    }
                    if (this.fRY.getType() == 6 && this.fRY.getVoteInfo() != null) {
                        if (this.fRY.getWriteImagesInfo() != null) {
                            this.fRY.getVoteInfo().setServerImageCode(this.fRY.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fRY.getVoteInfo().buildWriteContent();
                    }
                    this.afX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.fRY.getIsBaobaoImageUploaded()) {
                        this.afX.n("tail_type", String.valueOf(a.b.flD));
                        this.afX.n("tail_content", this.fRY.getBaobaoContent());
                        this.fRY.setBabaoPosted(true);
                    } else {
                        this.fRY.setBabaoPosted(false);
                    }
                    e.a(this.afX, this.fRY);
                    this.afX.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fRY.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afX.n("vcode", editable);
                    }
                    this.afX.tx().uu().mIsNeedTbs = true;
                    if (this.fRY.getVoice() != null) {
                        this.afX.n("voice_md5", this.fRY.getVoice());
                        this.afX.n("during_time", String.valueOf(this.fRY.getVoiceDuringTime()));
                    }
                    if (this.fRY.getType() == 0) {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afX.n("title", this.fRY.getTitle());
                        this.afX.n("is_ntitle", this.fRY.isNoTitle() ? "1" : "0");
                        if (this.fRY.getCategoryFrom() >= 0) {
                            this.afX.n("fromCategoryId", String.valueOf(this.fRY.getCategoryFrom()));
                        }
                        if (this.fRY.getCategoryTo() >= 0) {
                            this.afX.n("toCategoryId", String.valueOf(this.fRY.getCategoryTo()));
                        }
                        String hiAlbumId = this.fRY.getHiAlbumId();
                        if (hiAlbumId != null) {
                            this.afX.n("17hi_album_id", hiAlbumId);
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m10getInst().getIsLocationOn() && (z = com.baidu.adp.lib.e.a.cZ().z(false)) != null) {
                            this.afX.n("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                        }
                    } else if (this.fRY.getType() == 6) {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afX.n("title", this.fRY.getTitle());
                        this.afX.n("is_ntitle", this.fRY.isNoTitle() ? "1" : "0");
                        this.afX.n("thread_type", String.valueOf(36));
                    } else if (this.fRY.getType() == 4) {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afX.n("title", this.fRY.getTitle());
                        this.afX.n("is_ntitle", "0");
                        this.afX.n("thread_type", String.valueOf(33));
                        this.afX.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.fRY.getType() == 7) {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afX.n("title", this.fRY.getTitle());
                        this.afX.n("is_ntitle", this.fRY.isNoTitle() ? "1" : "0");
                        this.afX.n("product_id", new StringBuilder(String.valueOf(this.fRY.productId)).toString());
                    } else {
                        this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afX.n("tid", this.fRY.getThreadId());
                        this.afX.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fRY.getType() == 2) {
                            this.afX.n("quote_id", String.valueOf(this.fRY.getFloor()));
                            this.afX.n("floor_num", String.valueOf(this.fRY.getFloorNum()));
                            this.afX.n("is_addition", this.fRY.isAddition() ? "1" : "0");
                            if (this.fRY.getRepostId() != null) {
                                this.afX.n("repostid", this.fRY.getRepostId());
                            }
                        } else if (this.fRY.getType() == 5) {
                            this.afX.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fRY.getType() == 1 && com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                            this.afX.n("ptype", "4");
                        }
                    }
                }
                this.fnI = this.afX.sZ();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fRS = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afX != null) {
                this.afX.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(p pVar) {
            String str;
            int i;
            String str2;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.fRS = null;
            if (this.afX != null) {
                if (this.afX.tx().uv().nJ()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.fnI);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.fRR);
                        try {
                            str2 = new JSONObject(this.fnI).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m10getInst().getString(u.j.send_success);
                        }
                        if (this.fRY.getType() != 3) {
                            e.P(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.fRY.deleteUploadedTempImages();
                        if (this.fRY != null && this.fRY.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.beN();
                        }
                    } else if ((this.fRY.isHasImages() || this.fRY.getIsBaobao()) && j.isEmpty(String.valueOf(this.fRY.getContent()) + this.fRY.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m10getInst().getString(u.j.img_upload_error));
                    } else if (this.fRY.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.fnI).optString("tid");
                        str4 = new JSONObject(this.fnI).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.fnI).optJSONObject("twzhibo_info");
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
                } else if (this.fRY.isHasImages() && j.isEmpty(String.valueOf(this.fRY.getContent()) + this.fRY.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m10getInst().getString(u.j.img_upload_error));
                } else {
                    if (this.afX.tB() == 5 || this.afX.tB() == 6) {
                        p pVar2 = new p();
                        pVar2.parserJson(this.fnI);
                        if (pVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fRR.setVcodeMD5(pVar2.getVcode_md5());
                            VcodeActivity.this.fRR.setVcodeUrl(pVar2.getVcode_pic_url());
                            VcodeActivity.this.rB(VcodeActivity.this.fRR.getVcodeUrl());
                        }
                        VcodeActivity.this.ezv.setText((CharSequence) null);
                    } else if (this.fRY != null && this.afX.tB() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.fnI);
                        PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.afX.tB(), this.afX.getErrorString(), null, null);
                        postWriteCallBackData2.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fRY, postWriteCallBackData2.getAccessState())));
                    }
                    if (this.afX.tB() != 227001) {
                        VcodeActivity.this.showToast(this.afX.getErrorString());
                    }
                }
            }
            super.onPostExecute(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile ab LI;
        private volatile boolean byU;
        p fRX;

        private a() {
            this.LI = null;
            this.fRX = null;
            this.byU = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fRT = null;
            if (this.LI != null) {
                this.LI.dl();
            }
            this.byU = true;
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
                this.LI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.LI.n("fid", VcodeActivity.this.fRR.getForumId());
                this.LI.n("kw", VcodeActivity.this.fRR.getForumName());
                this.LI.n("new_vcode", "1");
                this.LI.n("title", VcodeActivity.this.fRR.getTitle());
                this.LI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fRR.getContent());
                if (VcodeActivity.this.fRR.getType() == 0) {
                    this.LI.n("pub_type", "1");
                    if (VcodeActivity.this.fRR.getCategoryFrom() >= 0) {
                        this.LI.n("fromCategoryId", String.valueOf(VcodeActivity.this.fRR.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fRR.getCategoryTo() >= 0) {
                        this.LI.n("toCategoryId", String.valueOf(VcodeActivity.this.fRR.getCategoryTo()));
                    }
                } else {
                    this.LI.n("pub_type", "2");
                    this.LI.n("tid", VcodeActivity.this.fRR.getThreadId());
                }
                String sZ = this.LI.sZ();
                if (!this.LI.tx().uv().nJ()) {
                    return null;
                }
                this.fRX = new p();
                this.fRX.parserJson(sZ);
                str = this.fRX.getVcode_pic_url();
            }
            if (this.byU) {
                return null;
            }
            this.LI = new ab(str);
            return BitmapHelper.Bytes2Bitmap(this.LI.ta());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fRT = null;
            if (bitmap != null) {
                VcodeActivity.this.aMY.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.fRX != null) {
                VcodeActivity.this.fRR.setVcodeMD5(this.fRX.getVcode_md5());
                VcodeActivity.this.fRR.setVcodeUrl(this.fRX.getVcode_pic_url());
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
