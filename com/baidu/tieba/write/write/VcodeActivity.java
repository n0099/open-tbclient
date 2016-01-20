package com.baidu.tieba.write.write;

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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData dXn = null;
    private TextView dUR = null;
    private ImageView aIx = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b dXC = null;
    private a dXD = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cPd = null;
    private RelativeLayout bKF = null;
    private TextView aYE = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dXy = new u(this);
    private final View.OnClickListener dXz = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.vcode_activity);
        initUI();
        initData(bundle);
        nv(this.dXn.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cPd = new w(this);
        if (bundle != null) {
            this.dXn = (WriteData) bundle.getSerializable("model");
        } else {
            this.dXn = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dXn != null && this.dXn.getType() == 3) {
            if (this.dXC != null) {
                this.dXC.cancel();
            }
            if (this.dXD != null) {
                this.dXD.cancel();
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
        if (this.dXC != null) {
            this.dXC.cancel();
        }
        if (this.dXD != null) {
            this.dXD.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dXn);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.e(this.bKF, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.as.i((View) this.dUR, n.f.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.as.cu(i);
        } else {
            i2 = -12895429;
        }
        this.aYE.setTextColor(i2);
    }

    private void initUI() {
        this.bKF = (RelativeLayout) findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.aYE = (TextView) findViewById(n.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dXy);
        this.dUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.j.send), this.dXz);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.dUR.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(n.g.input);
        this.aIx = (ImageView) findViewById(n.g.vcode_image);
        this.aIx.setImageDrawable(null);
        this.aIx.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(n.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(String str) {
        if (this.dXD != null) {
            this.dXD.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aIx.setImageDrawable(null);
        this.dXD = new a(this, null);
        this.dXD.setPriority(3);
        this.dXD.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.n> {
        private com.baidu.tbadk.core.util.ab ahV = null;
        private String dJJ = null;
        private WriteData dXG;

        public b(WriteData writeData) {
            this.dXG = null;
            this.dXG = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(Integer... numArr) {
            String str;
            Address y;
            if (this.dXG != null) {
                this.ahV = new com.baidu.tbadk.core.util.ab();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.dXG.getImagesCodeForPost();
                if (this.dXG.getType() == 3) {
                    this.ahV.o("newVcode", "1");
                    this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dXG.getContent()) + imagesCodeForPost);
                    this.ahV.o(PayVcodeActivityConfig.VCODE_MD5, this.dXG.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.ahV.o("vcode", editable);
                    }
                    this.ahV.o("tag", "11");
                    this.ahV.uw().vp().mIsNeedTbs = true;
                    this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dXG.getContent()) + imagesCodeForPost);
                    this.ahV.setUrl(com.baidu.tieba.tbadkCore.c.a.dHI);
                    this.ahV.o(ImageViewerConfig.FORUM_NAME, this.dXG.getForumName());
                    this.ahV.o("title", this.dXG.getTitle());
                    this.ahV.o("apiKey", this.dXG.getShareApiKey());
                    this.ahV.o("appName", this.dXG.getShareAppName());
                    this.ahV.o("signKey", this.dXG.getShareSignKey());
                    this.ahV.o("summary_title", this.dXG.getShareSummaryTitle());
                    this.ahV.o("summary_content", this.dXG.getShareSummaryContent());
                    this.ahV.o("summary_img", this.dXG.getShareSummaryImg());
                    this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dXG.getShareSummaryImgWidth()));
                    this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dXG.getShareSummaryImgHeight()));
                    this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dXG.getShareSummaryImgType());
                    this.ahV.o("referUrl", this.dXG.getShareReferUrl());
                } else {
                    this.ahV.o("anonymous", "0");
                    this.ahV.o(ImageViewerConfig.FORUM_ID, this.dXG.getForumId());
                    this.ahV.o("kw", this.dXG.getForumName());
                    this.ahV.o("new_vcode", "1");
                    VideoInfo videoInfo = this.dXG.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.dXG.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.dXG.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (this.dXG.getType() == 6 && this.dXG.getVoteInfo() != null) {
                        if (this.dXG.getWriteImagesInfo() != null) {
                            this.dXG.getVoteInfo().setServerImageCode(this.dXG.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.dXG.getVoteInfo().buildWriteContent();
                    }
                    this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.dXG.getIsBaobaoImageUploaded()) {
                        this.ahV.o("tail_type", String.valueOf(a.C0081a.dHM));
                        this.ahV.o("tail_content", this.dXG.getBaobaoContent());
                        this.dXG.setBabaoPosted(true);
                    } else {
                        this.dXG.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.ahV, this.dXG);
                    this.ahV.o("vcode_md5", this.dXG.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.ahV.o("vcode", editable);
                    }
                    this.ahV.uw().vp().mIsNeedTbs = true;
                    if (this.dXG.getVoice() != null) {
                        this.ahV.o("voice_md5", this.dXG.getVoice());
                        this.ahV.o("during_time", String.valueOf(this.dXG.getVoiceDuringTime()));
                    }
                    if (this.dXG.getType() == 0) {
                        this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ahV.o("title", this.dXG.getTitle());
                        this.ahV.o("is_ntitle", this.dXG.isNoTitle() ? "1" : "0");
                        if (this.dXG.getCategoryFrom() >= 0) {
                            this.ahV.o("fromCategoryId", String.valueOf(this.dXG.getCategoryFrom()));
                        }
                        if (this.dXG.getCategoryTo() >= 0) {
                            this.ahV.o("toCategoryId", String.valueOf(this.dXG.getCategoryTo()));
                        }
                        if (this.dXG.getLiveCardData() != null) {
                            this.ahV.o("group_id", String.valueOf(this.dXG.getLiveCardData().getGroupId()));
                            this.ahV.o("start_time", String.valueOf(this.dXG.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gD().y(false)) != null) {
                            this.ahV.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.dXG.getType() == 6) {
                        this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ahV.o("title", this.dXG.getTitle());
                        this.ahV.o("is_ntitle", this.dXG.isNoTitle() ? "1" : "0");
                        this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, String.valueOf(36));
                    } else if (this.dXG.getType() == 4) {
                        this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.ahV.o("title", this.dXG.getTitle());
                        this.ahV.o("is_ntitle", "0");
                        this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, String.valueOf(33));
                        this.ahV.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.ahV.o("tid", this.dXG.getThreadId());
                        this.ahV.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.dXG.getType() == 2) {
                            this.ahV.o("quote_id", String.valueOf(this.dXG.getFloor()));
                            this.ahV.o("floor_num", String.valueOf(this.dXG.getFloorNum()));
                            this.ahV.o(WriteActivityConfig.IS_ADDITION, this.dXG.isAddition() ? "1" : "0");
                            if (this.dXG.getRepostId() != null) {
                                this.ahV.o("repostid", this.dXG.getRepostId());
                            }
                        } else if (this.dXG.getType() == 5) {
                            this.ahV.o("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.dXG.getType() == 1 && com.baidu.tbadk.editortools.d.b.BK().getStatus() == 1) {
                            this.ahV.o("ptype", "4");
                        }
                    }
                }
                this.dJJ = this.ahV.tV();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dXC = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.ahV != null) {
                this.ahV.gL();
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
            VcodeActivity.this.dXC = null;
            if (this.ahV != null) {
                if (this.ahV.uw().vq().qO()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.dJJ);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.dJJ).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(n.j.send_success);
                        }
                        if (this.dXG.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.R(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.dXG.deleteUploadedTempImages();
                        if (this.dXG != null && this.dXG.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aEG();
                        }
                    } else if ((this.dXG.isHasImages() || this.dXG.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dXG.getContent()) + this.dXG.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(n.j.img_upload_error));
                    } else if (this.dXG.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    String str4 = "";
                    try {
                        str3 = new JSONObject(this.dJJ).optString("tid");
                        str4 = new JSONObject(this.dJJ).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject = new JSONObject(this.dJJ).optJSONObject("twzhibo_info");
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
                    if (this.dXG.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dXG.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.dXG.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dXG.getContent()) + this.dXG.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(n.j.img_upload_error));
                } else {
                    if (this.ahV.uA() == 5 || this.ahV.uA() == 6) {
                        com.baidu.tbadk.coreExtra.data.n nVar2 = new com.baidu.tbadk.coreExtra.data.n();
                        nVar2.parserJson(this.dJJ);
                        if (nVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.dXn.setVcodeMD5(nVar2.getVcode_md5());
                            VcodeActivity.this.dXn.setVcodeUrl(nVar2.getVcode_pic_url());
                            VcodeActivity.this.nv(VcodeActivity.this.dXn.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.ahV.getErrorString());
                }
            }
            super.onPostExecute(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.ab Ua;
        private volatile boolean aXX;
        com.baidu.tbadk.coreExtra.data.n dXF;

        private a() {
            this.Ua = null;
            this.dXF = null;
            this.aXX = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dXD = null;
            if (this.Ua != null) {
                this.Ua.gL();
            }
            this.aXX = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.Ua = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Ua.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.dXn.getForumId());
                this.Ua.o("kw", VcodeActivity.this.dXn.getForumName());
                this.Ua.o("new_vcode", "1");
                this.Ua.o("title", VcodeActivity.this.dXn.getTitle());
                this.Ua.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.dXn.getContent());
                if (VcodeActivity.this.dXn.getType() == 0) {
                    this.Ua.o("pub_type", "1");
                    if (VcodeActivity.this.dXn.getCategoryFrom() >= 0) {
                        this.Ua.o("fromCategoryId", String.valueOf(VcodeActivity.this.dXn.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.dXn.getCategoryTo() >= 0) {
                        this.Ua.o("toCategoryId", String.valueOf(VcodeActivity.this.dXn.getCategoryTo()));
                    }
                } else {
                    this.Ua.o("pub_type", "2");
                    this.Ua.o("tid", VcodeActivity.this.dXn.getThreadId());
                }
                String tV = this.Ua.tV();
                if (!this.Ua.uw().vq().qO()) {
                    return null;
                }
                this.dXF = new com.baidu.tbadk.coreExtra.data.n();
                this.dXF.parserJson(tV);
                str = this.dXF.getVcode_pic_url();
            }
            if (this.aXX) {
                return null;
            }
            this.Ua = new com.baidu.tbadk.core.util.ab(str);
            return com.baidu.tbadk.core.util.c.N(this.Ua.tW());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.dXD = null;
            if (bitmap != null) {
                VcodeActivity.this.aIx.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.dXF != null) {
                VcodeActivity.this.dXn.setVcodeMD5(this.dXF.getVcode_md5());
                VcodeActivity.this.dXn.setVcodeUrl(this.dXF.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
