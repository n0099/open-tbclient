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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
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
    private WriteData fFQ = null;
    private TextView fFm = null;
    private ImageView aMe = null;
    private EditText eeG = null;
    private ProgressBar mProgressBar = null;
    private b fFR = null;
    private a fFS = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener eeQ = null;
    private RelativeLayout cEz = null;
    private TextView bxm = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener fFT = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener fFU = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.vcode_activity);
        nl();
        initData(bundle);
        qR(this.fFQ.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.eeQ = new c(this);
        if (bundle != null) {
            this.fFQ = (WriteData) bundle.getSerializable("model");
        } else {
            this.fFQ = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fFQ != null && this.fFQ.getType() == 3) {
            if (this.fFR != null) {
                this.fFR.cancel();
            }
            if (this.fFS != null) {
                this.fFS.cancel();
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
        if (this.fFR != null) {
            this.fFR.cancel();
        }
        if (this.fFS != null) {
            this.fFS.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fFQ);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        av.g(this.cEz, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.fFm, u.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = av.cx(i);
        } else {
            i2 = -12895429;
        }
        this.bxm.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(u.j.sending), true, false, this.eeQ);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void nl() {
        this.cEz = (RelativeLayout) findViewById(u.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.bxm = (TextView) findViewById(u.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fFT);
        this.fFm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(u.j.send), this.fFU);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fFm.getLayoutParams();
        layoutParams.rightMargin = k.c(getPageContext().getPageActivity(), u.e.ds16);
        this.fFm.setLayoutParams(layoutParams);
        this.eeG = (EditText) findViewById(u.g.input);
        this.aMe = (ImageView) findViewById(u.g.vcode_image);
        this.aMe.setImageDrawable(null);
        this.aMe.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(u.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR(String str) {
        if (this.fFS != null) {
            this.fFS.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aMe.setImageDrawable(null);
        this.fFS = new a(this, null);
        this.fFS.setPriority(3);
        this.fFS.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, p> {
        private WriteData fFX;
        private ab afj = null;
        private String faF = null;

        public b(WriteData writeData) {
            this.fFX = null;
            this.fFX = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public p doInBackground(Integer... numArr) {
            String str;
            Address x;
            if (this.fFX != null) {
                this.afj = new ab();
                String editable = VcodeActivity.this.eeG.getText().toString();
                String imagesCodeForPost = this.fFX.getImagesCodeForPost();
                if (this.fFX.getType() == 3) {
                    this.afj.n("newVcode", "1");
                    this.afj.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fFX.getContent()) + imagesCodeForPost);
                    this.afj.n(PayVcodeActivityConfig.VCODE_MD5, this.fFX.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afj.n("vcode", editable);
                    }
                    this.afj.n("tag", "11");
                    this.afj.ty().uu().mIsNeedTbs = true;
                    this.afj.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fFX.getContent()) + imagesCodeForPost);
                    this.afj.setUrl(com.baidu.tieba.tbadkCore.c.a.eYt);
                    this.afj.n(ImageViewerConfig.FORUM_NAME, this.fFX.getForumName());
                    this.afj.n("title", this.fFX.getTitle());
                    this.afj.n("apiKey", this.fFX.getShareApiKey());
                    this.afj.n("appName", this.fFX.getShareAppName());
                    this.afj.n("signKey", this.fFX.getShareSignKey());
                    this.afj.n("summary_title", this.fFX.getShareSummaryTitle());
                    this.afj.n("summary_content", this.fFX.getShareSummaryContent());
                    this.afj.n("summary_img", this.fFX.getShareSummaryImg());
                    this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fFX.getShareSummaryImgWidth()));
                    this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fFX.getShareSummaryImgHeight()));
                    this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fFX.getShareSummaryImgType());
                    this.afj.n("referUrl", this.fFX.getShareReferUrl());
                } else {
                    this.afj.n("anonymous", "0");
                    this.afj.n("fid", this.fFX.getForumId());
                    this.afj.n("kw", this.fFX.getForumName());
                    this.afj.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fFX.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fFX.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fFX.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fFX.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fFX.getGraffitiWriteCode();
                    }
                    if (this.fFX.getType() == 6 && this.fFX.getVoteInfo() != null) {
                        if (this.fFX.getWriteImagesInfo() != null) {
                            this.fFX.getVoteInfo().setServerImageCode(this.fFX.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fFX.getVoteInfo().buildWriteContent();
                    }
                    this.afj.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.fFX.getIsBaobaoImageUploaded()) {
                        this.afj.n("tail_type", String.valueOf(a.b.eYA));
                        this.afj.n("tail_content", this.fFX.getBaobaoContent());
                        this.fFX.setBabaoPosted(true);
                    } else {
                        this.fFX.setBabaoPosted(false);
                    }
                    e.a(this.afj, this.fFX);
                    this.afj.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fFX.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afj.n("vcode", editable);
                    }
                    this.afj.ty().uu().mIsNeedTbs = true;
                    if (this.fFX.getVoice() != null) {
                        this.afj.n("voice_md5", this.fFX.getVoice());
                        this.afj.n("during_time", String.valueOf(this.fFX.getVoiceDuringTime()));
                    }
                    if (this.fFX.getType() == 0) {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afj.n("title", this.fFX.getTitle());
                        this.afj.n("is_ntitle", this.fFX.isNoTitle() ? "1" : "0");
                        if (this.fFX.getCategoryFrom() >= 0) {
                            this.afj.n("fromCategoryId", String.valueOf(this.fFX.getCategoryFrom()));
                        }
                        if (this.fFX.getCategoryTo() >= 0) {
                            this.afj.n("toCategoryId", String.valueOf(this.fFX.getCategoryTo()));
                        }
                        String hiAlbumId = this.fFX.getHiAlbumId();
                        if (hiAlbumId != null) {
                            this.afj.n("17hi_album_id", hiAlbumId);
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (x = com.baidu.adp.lib.e.a.da().x(false)) != null) {
                            this.afj.n("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                        }
                    } else if (this.fFX.getType() == 6) {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afj.n("title", this.fFX.getTitle());
                        this.afj.n("is_ntitle", this.fFX.isNoTitle() ? "1" : "0");
                        this.afj.n("thread_type", String.valueOf(36));
                    } else if (this.fFX.getType() == 4) {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afj.n("title", this.fFX.getTitle());
                        this.afj.n("is_ntitle", "0");
                        this.afj.n("thread_type", String.valueOf(33));
                        this.afj.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.fFX.getType() == 7) {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afj.n("title", this.fFX.getTitle());
                        this.afj.n("is_ntitle", this.fFX.isNoTitle() ? "1" : "0");
                        this.afj.n("product_id", new StringBuilder(String.valueOf(this.fFX.productId)).toString());
                    } else {
                        this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afj.n("tid", this.fFX.getThreadId());
                        this.afj.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fFX.getType() == 2) {
                            this.afj.n("quote_id", String.valueOf(this.fFX.getFloor()));
                            this.afj.n("floor_num", String.valueOf(this.fFX.getFloorNum()));
                            this.afj.n("is_addition", this.fFX.isAddition() ? "1" : "0");
                            if (this.fFX.getRepostId() != null) {
                                this.afj.n("repostid", this.fFX.getRepostId());
                            }
                        } else if (this.fFX.getType() == 5) {
                            this.afj.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fFX.getType() == 1 && com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                            this.afj.n("ptype", "4");
                        }
                    }
                }
                this.faF = this.afj.ta();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fFR = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afj != null) {
                this.afj.dm();
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
            VcodeActivity.this.fFR = null;
            if (this.afj != null) {
                if (this.afj.ty().uv().nU()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.faF);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.fFQ);
                        try {
                            str2 = new JSONObject(this.faF).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.m9getInst().getString(u.j.send_success);
                        }
                        if (this.fFX.getType() != 3) {
                            e.P(VcodeActivity.this.getPageContext().getPageActivity(), str2);
                        }
                        this.fFX.deleteUploadedTempImages();
                        if (this.fFX != null && this.fFX.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.bby();
                        }
                    } else if ((this.fFX.isHasImages() || this.fFX.getIsBaobao()) && j.isEmpty(String.valueOf(this.fFX.getContent()) + this.fFX.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(u.j.img_upload_error));
                    } else if (this.fFX.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.faF).optString("tid");
                        str4 = new JSONObject(this.faF).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.faF).optJSONObject("twzhibo_info");
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
                } else if (this.fFX.isHasImages() && j.isEmpty(String.valueOf(this.fFX.getContent()) + this.fFX.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(u.j.img_upload_error));
                } else {
                    if (this.afj.tC() == 5 || this.afj.tC() == 6) {
                        p pVar2 = new p();
                        pVar2.parserJson(this.faF);
                        if (pVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fFQ.setVcodeMD5(pVar2.getVcode_md5());
                            VcodeActivity.this.fFQ.setVcodeUrl(pVar2.getVcode_pic_url());
                            VcodeActivity.this.qR(VcodeActivity.this.fFQ.getVcodeUrl());
                        }
                        VcodeActivity.this.eeG.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afj.getErrorString());
                }
            }
            super.onPostExecute(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile ab LK;
        private volatile boolean bwG;
        p fFW;

        private a() {
            this.LK = null;
            this.fFW = null;
            this.bwG = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fFS = null;
            if (this.LK != null) {
                this.LK.dm();
            }
            this.bwG = true;
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
                this.LK = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.LK.n("fid", VcodeActivity.this.fFQ.getForumId());
                this.LK.n("kw", VcodeActivity.this.fFQ.getForumName());
                this.LK.n("new_vcode", "1");
                this.LK.n("title", VcodeActivity.this.fFQ.getTitle());
                this.LK.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fFQ.getContent());
                if (VcodeActivity.this.fFQ.getType() == 0) {
                    this.LK.n("pub_type", "1");
                    if (VcodeActivity.this.fFQ.getCategoryFrom() >= 0) {
                        this.LK.n("fromCategoryId", String.valueOf(VcodeActivity.this.fFQ.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fFQ.getCategoryTo() >= 0) {
                        this.LK.n("toCategoryId", String.valueOf(VcodeActivity.this.fFQ.getCategoryTo()));
                    }
                } else {
                    this.LK.n("pub_type", "2");
                    this.LK.n("tid", VcodeActivity.this.fFQ.getThreadId());
                }
                String ta = this.LK.ta();
                if (!this.LK.ty().uv().nU()) {
                    return null;
                }
                this.fFW = new p();
                this.fFW.parserJson(ta);
                str = this.fFW.getVcode_pic_url();
            }
            if (this.bwG) {
                return null;
            }
            this.LK = new ab(str);
            return BitmapHelper.Bytes2Bitmap(this.LK.tb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fFS = null;
            if (bitmap != null) {
                VcodeActivity.this.aMe.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.fFW != null) {
                VcodeActivity.this.fFQ.setVcodeMD5(this.fFW.getVcode_md5());
                VcodeActivity.this.fFQ.setVcodeUrl(this.fFW.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
