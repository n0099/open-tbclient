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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData gef = null;
    private TextView flI = null;
    private ImageView aTb = null;
    private EditText eIb = null;
    private ProgressBar mProgressBar = null;
    private b geg = null;
    private a geh = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener eIl = null;
    private RelativeLayout cUo = null;
    private TextView bLd = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener gei = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener gej = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.vcode_activity);
        initUI();
        initData(bundle);
        sA(this.gef.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.eIl = new c(this);
        if (bundle != null) {
            this.gef = (WriteData) bundle.getSerializable("model");
        } else {
            this.gef = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gef != null && this.gef.getType() == 3) {
            if (this.geg != null) {
                this.geg.cancel();
            }
            if (this.geh != null) {
                this.geh.cancel();
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
        if (this.geg != null) {
            this.geg.cancel();
        }
        if (this.geh != null) {
            this.geh.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.gef);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        av.g(this.cUo, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.flI, r.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = av.cK(i);
        } else {
            i2 = -12895429;
        }
        this.bLd.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(r.j.sending), true, false, this.eIl);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.cUo = (RelativeLayout) findViewById(r.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.bLd = (TextView) findViewById(r.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.gei);
        this.flI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.send), this.gej);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flI.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.e.ds16);
        this.flI.setLayoutParams(layoutParams);
        this.eIb = (EditText) findViewById(r.g.input);
        this.aTb = (ImageView) findViewById(r.g.vcode_image);
        this.aTb.setImageDrawable(null);
        this.aTb.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(r.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA(String str) {
        if (this.geh != null) {
            this.geh.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aTb.setImageDrawable(null);
        this.geh = new a(this, null);
        this.geh.setPriority(3);
        this.geh.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, s> {
        private ab aiu = null;
        private String fyj = null;
        private WriteData gem;

        public b(WriteData writeData) {
            this.gem = null;
            this.gem = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public s doInBackground(Integer... numArr) {
            String str;
            Address B;
            if (this.gem != null) {
                this.aiu = new ab();
                String editable = VcodeActivity.this.eIb.getText().toString();
                String imagesCodeForPost = this.gem.getImagesCodeForPost();
                if (this.gem.getType() == 3) {
                    this.aiu.n("newVcode", "1");
                    this.aiu.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.gem.getContent()) + imagesCodeForPost);
                    this.aiu.n(PayVcodeActivityConfig.VCODE_MD5, this.gem.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiu.n("vcode", editable);
                    }
                    this.aiu.n("tag", "11");
                    this.aiu.uS().vN().mIsNeedTbs = true;
                    this.aiu.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.gem.getContent()) + imagesCodeForPost);
                    this.aiu.setUrl(com.baidu.tieba.tbadkCore.c.a.fvW);
                    this.aiu.n(ImageViewerConfig.FORUM_NAME, this.gem.getForumName());
                    this.aiu.n(VrPlayerActivityConfig.TITLE, this.gem.getTitle());
                    this.aiu.n("apiKey", this.gem.getShareApiKey());
                    this.aiu.n("appName", this.gem.getShareAppName());
                    this.aiu.n("signKey", this.gem.getShareSignKey());
                    this.aiu.n("summary_title", this.gem.getShareSummaryTitle());
                    this.aiu.n("summary_content", this.gem.getShareSummaryContent());
                    this.aiu.n("summary_img", this.gem.getShareSummaryImg());
                    this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.gem.getShareSummaryImgWidth()));
                    this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.gem.getShareSummaryImgHeight()));
                    this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.gem.getShareSummaryImgType());
                    this.aiu.n("referUrl", this.gem.getShareReferUrl());
                } else {
                    this.aiu.n("anonymous", "0");
                    this.aiu.n("fid", this.gem.getForumId());
                    this.aiu.n("kw", this.gem.getForumName());
                    this.aiu.n("new_vcode", "1");
                    VideoInfo videoInfo = this.gem.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.gem.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.gem.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.gem.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.gem.getGraffitiWriteCode();
                    }
                    if (this.gem.getType() == 6 && this.gem.getVoteInfo() != null) {
                        if (this.gem.getWriteImagesInfo() != null) {
                            this.gem.getVoteInfo().setServerImageCode(this.gem.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.gem.getVoteInfo().buildWriteContent();
                    }
                    this.aiu.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.gem.getIsBaobaoImageUploaded()) {
                        this.aiu.n("tail_type", String.valueOf(a.b.fwd));
                        this.aiu.n("tail_content", this.gem.getBaobaoContent());
                        this.gem.setBabaoPosted(true);
                    } else {
                        this.gem.setBabaoPosted(false);
                    }
                    f.a(this.aiu, this.gem);
                    this.aiu.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.gem.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiu.n("vcode", editable);
                    }
                    this.aiu.uS().vN().mIsNeedTbs = true;
                    if (this.gem.getVoice() != null) {
                        this.aiu.n("voice_md5", this.gem.getVoice());
                        this.aiu.n("during_time", String.valueOf(this.gem.getVoiceDuringTime()));
                    }
                    if (this.gem.getType() == 0) {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiu.n(VrPlayerActivityConfig.TITLE, this.gem.getTitle());
                        this.aiu.n("is_ntitle", this.gem.isNoTitle() ? "1" : "0");
                        if (this.gem.getCategoryFrom() >= 0) {
                            this.aiu.n("fromCategoryId", String.valueOf(this.gem.getCategoryFrom()));
                        }
                        if (this.gem.getCategoryTo() >= 0) {
                            this.aiu.n("toCategoryId", String.valueOf(this.gem.getCategoryTo()));
                        }
                        String hiAlbumId = this.gem.getHiAlbumId();
                        if (hiAlbumId != null) {
                            this.aiu.n("17hi_album_id", hiAlbumId);
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (B = com.baidu.adp.lib.e.a.dU().B(false)) != null) {
                            this.aiu.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                        }
                    } else if (this.gem.getType() == 6) {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiu.n(VrPlayerActivityConfig.TITLE, this.gem.getTitle());
                        this.aiu.n("is_ntitle", this.gem.isNoTitle() ? "1" : "0");
                        this.aiu.n("thread_type", String.valueOf(36));
                    } else if (this.gem.getType() == 4) {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiu.n(VrPlayerActivityConfig.TITLE, this.gem.getTitle());
                        this.aiu.n("is_ntitle", "0");
                        this.aiu.n("thread_type", String.valueOf(33));
                        this.aiu.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.gem.getType() == 7) {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiu.n(VrPlayerActivityConfig.TITLE, this.gem.getTitle());
                        this.aiu.n("is_ntitle", this.gem.isNoTitle() ? "1" : "0");
                        this.aiu.n("product_id", new StringBuilder(String.valueOf(this.gem.productId)).toString());
                    } else {
                        this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aiu.n("tid", this.gem.getThreadId());
                        this.aiu.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.gem.getType() == 2) {
                            this.aiu.n("quote_id", String.valueOf(this.gem.getFloor()));
                            this.aiu.n("floor_num", String.valueOf(this.gem.getFloorNum()));
                            this.aiu.n("is_addition", this.gem.isAddition() ? "1" : "0");
                            if (this.gem.getRepostId() != null) {
                                this.aiu.n("repostid", this.gem.getRepostId());
                            }
                        } else if (this.gem.getType() == 5) {
                            this.aiu.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.gem.getType() == 1) {
                            this.aiu.n("is_barrage", this.gem.isBarrage() ? "1" : "0");
                            this.aiu.n("barrage_time", String.valueOf(this.gem.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.e.b.Dh().getStatus() == 1) {
                                this.aiu.n("ptype", "4");
                            }
                        }
                    }
                }
                this.fyj = this.aiu.uu();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.geg = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aiu != null) {
                this.aiu.eg();
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
            VcodeActivity.this.geg = null;
            if (this.aiu != null) {
                if (this.aiu.uS().vO().oF()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.fyj);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.gef);
                        try {
                            str2 = new JSONObject(this.fyj).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m9getInst().getString(r.j.send_success);
                        }
                        if (this.gem.getType() != 3) {
                            f.S(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.gem.deleteUploadedTempImages();
                        if (this.gem != null && this.gem.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.bjd();
                        }
                    } else if ((this.gem.isHasImages() || this.gem.getIsBaobao()) && j.isEmpty(String.valueOf(this.gem.getContent()) + this.gem.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                    } else if (this.gem.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.fyj).optString("tid");
                        str4 = new JSONObject(this.fyj).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.fyj).optJSONObject("twzhibo_info");
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
                } else if (this.gem.isHasImages() && j.isEmpty(String.valueOf(this.gem.getContent()) + this.gem.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                } else {
                    if (this.aiu.uW() == 5 || this.aiu.uW() == 6) {
                        s sVar2 = new s();
                        sVar2.parserJson(this.fyj);
                        if (sVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.gef.setVcodeMD5(sVar2.getVcode_md5());
                            VcodeActivity.this.gef.setVcodeUrl(sVar2.getVcode_pic_url());
                            VcodeActivity.this.sA(VcodeActivity.this.gef.getVcodeUrl());
                        }
                        VcodeActivity.this.eIb.setText((CharSequence) null);
                    } else if (this.gem != null && this.aiu.uW() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.fyj);
                        PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.aiu.uW(), this.aiu.getErrorString(), null, null);
                        postWriteCallBackData2.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.gem, postWriteCallBackData2.getAccessState())));
                    }
                    if (this.aiu.uW() != 227001) {
                        VcodeActivity.this.showToast(this.aiu.getErrorString());
                    }
                }
            }
            super.onPostExecute(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile ab NY;
        private volatile boolean bKx;
        s gel;

        private a() {
            this.NY = null;
            this.gel = null;
            this.bKx = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.geh = null;
            if (this.NY != null) {
                this.NY.eg();
            }
            this.bKx = true;
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
                this.NY = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.NY.n("fid", VcodeActivity.this.gef.getForumId());
                this.NY.n("kw", VcodeActivity.this.gef.getForumName());
                this.NY.n("new_vcode", "1");
                this.NY.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.gef.getTitle());
                this.NY.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.gef.getContent());
                if (VcodeActivity.this.gef.getType() == 0) {
                    this.NY.n("pub_type", "1");
                    if (VcodeActivity.this.gef.getCategoryFrom() >= 0) {
                        this.NY.n("fromCategoryId", String.valueOf(VcodeActivity.this.gef.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.gef.getCategoryTo() >= 0) {
                        this.NY.n("toCategoryId", String.valueOf(VcodeActivity.this.gef.getCategoryTo()));
                    }
                } else {
                    this.NY.n("pub_type", "2");
                    this.NY.n("tid", VcodeActivity.this.gef.getThreadId());
                }
                String uu = this.NY.uu();
                if (!this.NY.uS().vO().oF()) {
                    return null;
                }
                this.gel = new s();
                this.gel.parserJson(uu);
                str = this.gel.getVcode_pic_url();
            }
            if (this.bKx) {
                return null;
            }
            this.NY = new ab(str);
            return BitmapHelper.Bytes2Bitmap(this.NY.uv());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.geh = null;
            if (bitmap != null) {
                VcodeActivity.this.aTb.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.gel != null) {
                VcodeActivity.this.gef.setVcodeMD5(this.gel.getVcode_md5());
                VcodeActivity.this.gef.setVcodeUrl(this.gel.getVcode_pic_url());
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
