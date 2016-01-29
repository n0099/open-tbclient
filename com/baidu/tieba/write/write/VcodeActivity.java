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
    private WriteData esg = null;
    private TextView epw = null;
    private ImageView aJB = null;
    private EditText cYq = null;
    private ProgressBar mProgressBar = null;
    private b esv = null;
    private a esw = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cYA = null;
    private RelativeLayout bOs = null;
    private TextView baT = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener esr = new u(this);
    private final View.OnClickListener ess = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.vcode_activity);
        qD();
        initData(bundle);
        nM(this.esg.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cYA = new w(this);
        if (bundle != null) {
            this.esg = (WriteData) bundle.getSerializable("model");
        } else {
            this.esg = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.esg != null && this.esg.getType() == 3) {
            if (this.esv != null) {
                this.esv.cancel();
            }
            if (this.esw != null) {
                this.esw.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esv != null) {
            this.esv.cancel();
        }
        if (this.esw != null) {
            this.esw.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.esg);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ar.g(this.bOs, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ar.k(this.epw, t.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ar.cL(i);
        } else {
            i2 = -12895429;
        }
        this.baT.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, false, this.cYA);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void qD() {
        this.bOs = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.baT = (TextView) findViewById(t.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.esr);
        this.epw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.ess);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.epw.setLayoutParams(layoutParams);
        this.cYq = (EditText) findViewById(t.g.input);
        this.aJB = (ImageView) findViewById(t.g.vcode_image);
        this.aJB.setImageDrawable(null);
        this.aJB.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(t.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(String str) {
        if (this.esw != null) {
            this.esw.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aJB.setImageDrawable(null);
        this.esw = new a(this, null);
        this.esw.setPriority(3);
        this.esw.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.n> {
        private com.baidu.tbadk.core.util.aa aiG = null;
        private String dZO = null;
        private WriteData esz;

        public b(WriteData writeData) {
            this.esz = null;
            this.esz = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(Integer... numArr) {
            String str;
            Address y;
            if (this.esz != null) {
                this.aiG = new com.baidu.tbadk.core.util.aa();
                String editable = VcodeActivity.this.cYq.getText().toString();
                String imagesCodeForPost = this.esz.getImagesCodeForPost();
                if (this.esz.getType() == 3) {
                    this.aiG.p("newVcode", "1");
                    this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.esz.getContent()) + imagesCodeForPost);
                    this.aiG.p(PayVcodeActivityConfig.VCODE_MD5, this.esz.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiG.p("vcode", editable);
                    }
                    this.aiG.p("tag", "11");
                    this.aiG.vB().wv().mIsNeedTbs = true;
                    this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.esz.getContent()) + imagesCodeForPost);
                    this.aiG.setUrl(com.baidu.tieba.tbadkCore.c.a.dXF);
                    this.aiG.p(ImageViewerConfig.FORUM_NAME, this.esz.getForumName());
                    this.aiG.p("title", this.esz.getTitle());
                    this.aiG.p("apiKey", this.esz.getShareApiKey());
                    this.aiG.p("appName", this.esz.getShareAppName());
                    this.aiG.p("signKey", this.esz.getShareSignKey());
                    this.aiG.p("summary_title", this.esz.getShareSummaryTitle());
                    this.aiG.p("summary_content", this.esz.getShareSummaryContent());
                    this.aiG.p("summary_img", this.esz.getShareSummaryImg());
                    this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.esz.getShareSummaryImgWidth()));
                    this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.esz.getShareSummaryImgHeight()));
                    this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.esz.getShareSummaryImgType());
                    this.aiG.p("referUrl", this.esz.getShareReferUrl());
                } else {
                    this.aiG.p("anonymous", "0");
                    this.aiG.p(ImageViewerConfig.FORUM_ID, this.esz.getForumId());
                    this.aiG.p("kw", this.esz.getForumName());
                    this.aiG.p("new_vcode", "1");
                    VideoInfo videoInfo = this.esz.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.esz.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.esz.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (this.esz.getType() == 6 && this.esz.getVoteInfo() != null) {
                        if (this.esz.getWriteImagesInfo() != null) {
                            this.esz.getVoteInfo().setServerImageCode(this.esz.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.esz.getVoteInfo().buildWriteContent();
                    }
                    this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.esz.getIsBaobaoImageUploaded()) {
                        this.aiG.p("tail_type", String.valueOf(a.b.dXM));
                        this.aiG.p("tail_content", this.esz.getBaobaoContent());
                        this.esz.setBabaoPosted(true);
                    } else {
                        this.esz.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.aiG, this.esz);
                    this.aiG.p("vcode_md5", this.esz.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiG.p("vcode", editable);
                    }
                    this.aiG.vB().wv().mIsNeedTbs = true;
                    if (this.esz.getVoice() != null) {
                        this.aiG.p("voice_md5", this.esz.getVoice());
                        this.aiG.p("during_time", String.valueOf(this.esz.getVoiceDuringTime()));
                    }
                    if (this.esz.getType() == 0) {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiG.p("title", this.esz.getTitle());
                        this.aiG.p("is_ntitle", this.esz.isNoTitle() ? "1" : "0");
                        if (this.esz.getCategoryFrom() >= 0) {
                            this.aiG.p("fromCategoryId", String.valueOf(this.esz.getCategoryFrom()));
                        }
                        if (this.esz.getCategoryTo() >= 0) {
                            this.aiG.p("toCategoryId", String.valueOf(this.esz.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gL().y(false)) != null) {
                            this.aiG.p("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.esz.getType() == 6) {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiG.p("title", this.esz.getTitle());
                        this.aiG.p("is_ntitle", this.esz.isNoTitle() ? "1" : "0");
                        this.aiG.p("thread_type", String.valueOf(36));
                    } else if (this.esz.getType() == 4) {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiG.p("title", this.esz.getTitle());
                        this.aiG.p("is_ntitle", "0");
                        this.aiG.p("thread_type", String.valueOf(33));
                        this.aiG.p("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aiG.p("tid", this.esz.getThreadId());
                        this.aiG.p("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.esz.getType() == 2) {
                            this.aiG.p("quote_id", String.valueOf(this.esz.getFloor()));
                            this.aiG.p("floor_num", String.valueOf(this.esz.getFloorNum()));
                            this.aiG.p(WriteActivityConfig.IS_ADDITION, this.esz.isAddition() ? "1" : "0");
                            if (this.esz.getRepostId() != null) {
                                this.aiG.p("repostid", this.esz.getRepostId());
                            }
                        } else if (this.esz.getType() == 5) {
                            this.aiG.p("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.esz.getType() == 1 && com.baidu.tbadk.editortools.d.b.Da().getStatus() == 1) {
                            this.aiG.p("ptype", "4");
                        }
                    }
                }
                this.dZO = this.aiG.uZ();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.esv = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aiG != null) {
                this.aiG.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            String str;
            String str2;
            int i;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.esv = null;
            if (this.aiG != null) {
                if (this.aiG.vB().ww().rl()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.dZO);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.dZO).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(t.j.send_success);
                        }
                        if (this.esz.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.Y(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.esz.deleteUploadedTempImages();
                        if (this.esz != null && this.esz.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aLM();
                        }
                    } else if ((this.esz.isHasImages() || this.esz.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.esz.getContent()) + this.esz.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error));
                    } else if (this.esz.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.dZO).optString("tid");
                        str4 = new JSONObject(this.dZO).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.dZO).optJSONObject("twzhibo_info");
                        if (optJSONObject != null) {
                            i = optJSONObject.optInt("is_copytwzhibo", 0);
                            str2 = str3;
                        } else {
                            i = 0;
                            str2 = str3;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str2 = str3;
                        str4 = str4;
                        i = 0;
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str4);
                    postWriteCallBackData.setIsCopyTWZhibo(i);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    VcodeActivity.this.setResult(-1, intent);
                    VcodeActivity.this.finish();
                } else if (this.esz.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.esz.getContent()) + this.esz.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error));
                } else {
                    if (this.aiG.vF() == 5 || this.aiG.vF() == 6) {
                        com.baidu.tbadk.coreExtra.data.n nVar2 = new com.baidu.tbadk.coreExtra.data.n();
                        nVar2.parserJson(this.dZO);
                        if (nVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.esg.setVcodeMD5(nVar2.getVcode_md5());
                            VcodeActivity.this.esg.setVcodeUrl(nVar2.getVcode_pic_url());
                            VcodeActivity.this.nM(VcodeActivity.this.esg.getVcodeUrl());
                        }
                        VcodeActivity.this.cYq.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.aiG.getErrorString());
                }
            }
            super.onPostExecute(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.aa Ty;
        private volatile boolean bal;
        com.baidu.tbadk.coreExtra.data.n esy;

        private a() {
            this.Ty = null;
            this.esy = null;
            this.bal = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.esw = null;
            if (this.Ty != null) {
                this.Ty.gT();
            }
            this.bal = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.Ty = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Ty.p(ImageViewerConfig.FORUM_ID, VcodeActivity.this.esg.getForumId());
                this.Ty.p("kw", VcodeActivity.this.esg.getForumName());
                this.Ty.p("new_vcode", "1");
                this.Ty.p("title", VcodeActivity.this.esg.getTitle());
                this.Ty.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.esg.getContent());
                if (VcodeActivity.this.esg.getType() == 0) {
                    this.Ty.p("pub_type", "1");
                    if (VcodeActivity.this.esg.getCategoryFrom() >= 0) {
                        this.Ty.p("fromCategoryId", String.valueOf(VcodeActivity.this.esg.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.esg.getCategoryTo() >= 0) {
                        this.Ty.p("toCategoryId", String.valueOf(VcodeActivity.this.esg.getCategoryTo()));
                    }
                } else {
                    this.Ty.p("pub_type", "2");
                    this.Ty.p("tid", VcodeActivity.this.esg.getThreadId());
                }
                String uZ = this.Ty.uZ();
                if (!this.Ty.vB().ww().rl()) {
                    return null;
                }
                this.esy = new com.baidu.tbadk.coreExtra.data.n();
                this.esy.parserJson(uZ);
                str = this.esy.getVcode_pic_url();
            }
            if (this.bal) {
                return null;
            }
            this.Ty = new com.baidu.tbadk.core.util.aa(str);
            return BitmapHelper.Bytes2Bitmap(this.Ty.va());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.esw = null;
            if (bitmap != null) {
                VcodeActivity.this.aJB.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.esy != null) {
                VcodeActivity.this.esg.setVcodeMD5(this.esy.getVcode_md5());
                VcodeActivity.this.esg.setVcodeUrl(this.esy.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
