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
import com.baidu.tbadk.core.atomData.TailEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData cTH = null;
    private TextView cSp = null;
    private ImageView aCs = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b cTV = null;
    private a cTW = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cjo = null;
    private RelativeLayout bnG = null;
    private TextView aPY = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cTR = new u(this);
    private final View.OnClickListener cTS = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.vcode_activity);
        initUI();
        initData(bundle);
        fK(this.cTH.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cjo = new w(this);
        if (bundle != null) {
            this.cTH = (WriteData) bundle.getSerializable("model");
        } else {
            this.cTH = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cTH != null && this.cTH.getType() == 3) {
            if (this.cTV != null) {
                this.cTV.cancel();
            }
            if (this.cTW != null) {
                this.cTW.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cTV != null) {
            this.cTV.cancel();
        }
        if (this.cTW != null) {
            this.cTW.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cTH);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.e(this.bnG, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.al.g(this.cSp, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.al.cn(i);
        } else {
            i2 = -12895429;
        }
        this.aPY.setTextColor(i2);
    }

    private void initUI() {
        this.bnG = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aPY = (TextView) findViewById(i.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cTR);
        this.cSp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.C0057i.send), this.cTS);
        this.mEdit = (EditText) findViewById(i.f.input);
        this.aCs = (ImageView) findViewById(i.f.vcode_image);
        this.aCs.setImageDrawable(null);
        this.aCs.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (this.cTW != null) {
            this.cTW.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aCs.setImageDrawable(null);
        this.cTW = new a(this, null);
        this.cTW.setPriority(3);
        this.cTW.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
        private WriteData cTZ;
        private com.baidu.tbadk.core.util.v afJ = null;
        private String aGk = null;

        public b(WriteData writeData) {
            this.cTZ = null;
            this.cTZ = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            if (this.cTZ != null) {
                this.afJ = new com.baidu.tbadk.core.util.v();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.cTZ.getImagesCodeForPost();
                if (this.cTZ.getType() == 3) {
                    this.afJ.o("newVcode", "1");
                    this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cTZ.getContent()) + imagesCodeForPost);
                    this.afJ.o("vcodeMd5", this.cTZ.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afJ.o("vcode", editable);
                    }
                    this.afJ.o("tag", "11");
                    this.afJ.ue().uV().mIsNeedTbs = true;
                    this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cTZ.getContent()) + imagesCodeForPost);
                    this.afJ.setUrl(com.baidu.tieba.tbadkCore.d.a.cJc);
                    this.afJ.o(ImageViewerConfig.FORUM_NAME, this.cTZ.getForumName());
                    this.afJ.o("title", this.cTZ.getTitle());
                    this.afJ.o("apiKey", this.cTZ.getShareApiKey());
                    this.afJ.o("appName", this.cTZ.getShareAppName());
                    this.afJ.o("signKey", this.cTZ.getShareSignKey());
                    this.afJ.o("summary_title", this.cTZ.getShareSummaryTitle());
                    this.afJ.o("summary_content", this.cTZ.getShareSummaryContent());
                    this.afJ.o("summary_img", this.cTZ.getShareSummaryImg());
                    this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cTZ.getShareSummaryImgWidth()));
                    this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cTZ.getShareSummaryImgHeight()));
                    this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cTZ.getShareSummaryImgType());
                    this.afJ.o("referUrl", this.cTZ.getShareReferUrl());
                } else {
                    this.afJ.o("anonymous", "0");
                    this.afJ.o(ImageViewerConfig.FORUM_ID, this.cTZ.getForumId());
                    this.afJ.o("kw", this.cTZ.getForumName());
                    this.afJ.o("new_vcode", "1");
                    if (this.cTZ.getVideoInfo() == null) {
                        str = String.valueOf(this.cTZ.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.cTZ.getContent()) + videoInfo.buildWriteContent(this.cTZ.getForumName()) + imagesCodeForPost;
                    }
                    this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.cTZ.getIsBaobaoImageUploaded()) {
                        this.afJ.o("tail_type", String.valueOf(a.C0070a.cJf));
                        this.afJ.o(TailEditActivityConfig.TAIL_CONTENT, this.cTZ.getBaobaoContent());
                        this.cTZ.setBabaoPosted(true);
                    } else {
                        this.cTZ.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, this.cTZ);
                    this.afJ.o("vcode_md5", this.cTZ.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afJ.o("vcode", editable);
                    }
                    this.afJ.ue().uV().mIsNeedTbs = true;
                    if (this.cTZ.getVoice() != null) {
                        this.afJ.o("voice_md5", this.cTZ.getVoice());
                        this.afJ.o("during_time", String.valueOf(this.cTZ.getVoiceDuringTime()));
                    }
                    if (this.cTZ.getType() == 0) {
                        this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afJ.o("title", this.cTZ.getTitle());
                        this.afJ.o("is_ntitle", this.cTZ.isNoTitle() ? "1" : "0");
                        if (this.cTZ.getLiveCardData() != null) {
                            this.afJ.o("group_id", String.valueOf(this.cTZ.getLiveCardData().getGroupId()));
                            this.afJ.o("start_time", String.valueOf(this.cTZ.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gF().y(false)) != null) {
                            this.afJ.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else {
                        this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afJ.o("tid", this.cTZ.getThreadId());
                        this.afJ.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.cTZ.getType() == 2) {
                            this.afJ.o("quote_id", String.valueOf(this.cTZ.getFloor()));
                            this.afJ.o("floor_num", String.valueOf(this.cTZ.getFloorNum()));
                            this.afJ.o(WriteActivityConfig.IS_ADDITION, this.cTZ.isAddition() ? "1" : "0");
                            if (this.cTZ.getRepostId() != null) {
                                this.afJ.o("repostid", this.cTZ.getRepostId());
                            }
                        }
                    }
                }
                this.aGk = this.afJ.tD();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.cTV = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afJ != null) {
                this.afJ.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            String str;
            String str2;
            JSONException e;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.cTV = null;
            if (this.afJ != null) {
                if (this.afJ.ue().uW().rb()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.aGk);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.aGk).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(i.C0057i.send_success);
                        }
                        if (this.cTZ.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.c.Q(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.cTZ.deleteUploadedTempImages();
                        if (this.cTZ != null && this.cTZ.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.apy();
                        }
                    } else if ((this.cTZ.isHasImages() || this.cTZ.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cTZ.getContent()) + this.cTZ.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.C0057i.img_upload_error));
                    } else if (this.cTZ.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.aGk).optString("tid");
                    } catch (JSONException e3) {
                        str2 = "";
                        e = e3;
                    }
                    try {
                        str3 = new JSONObject(this.aGk).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        if (postWriteCallBackData != null) {
                            XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.cTZ.getForumId(), this.cTZ.getVideoInfo().getVideoUrl(), this.cTZ.getForumName());
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        VcodeActivity.this.setResult(-1, intent);
                        if (this.cTZ.getLiveCardData() != null) {
                        }
                        VcodeActivity.this.finish();
                        super.onPostExecute(lVar);
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    if (postWriteCallBackData != null && this.cTZ != null && this.cTZ.getVideoInfo() != null) {
                        XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.cTZ.getForumId(), this.cTZ.getVideoInfo().getVideoUrl(), this.cTZ.getForumName());
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.cTZ.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cTZ.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.cTZ.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cTZ.getContent()) + this.cTZ.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.C0057i.img_upload_error));
                } else {
                    if (this.afJ.ui() == 5 || this.afJ.ui() == 6) {
                        com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                        lVar2.parserJson(this.aGk);
                        if (lVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.cTH.setVcodeMD5(lVar2.getVcode_md5());
                            VcodeActivity.this.cTH.setVcodeUrl(lVar2.getVcode_pic_url());
                            VcodeActivity.this.fK(VcodeActivity.this.cTH.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afJ.getErrorString());
                }
            }
            super.onPostExecute(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.v Tu;
        private volatile boolean aGi;
        com.baidu.tbadk.coreExtra.data.l cTY;

        private a() {
            this.Tu = null;
            this.cTY = null;
            this.aGi = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.cTW = null;
            if (this.Tu != null) {
                this.Tu.gM();
            }
            this.aGi = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Tu.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.cTH.getForumId());
                this.Tu.o("kw", VcodeActivity.this.cTH.getForumName());
                this.Tu.o("new_vcode", "1");
                this.Tu.o("title", VcodeActivity.this.cTH.getTitle());
                this.Tu.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.cTH.getContent());
                if (VcodeActivity.this.cTH.getType() == 0) {
                    this.Tu.o("pub_type", "1");
                } else {
                    this.Tu.o("pub_type", "2");
                    this.Tu.o("tid", VcodeActivity.this.cTH.getThreadId());
                }
                String tD = this.Tu.tD();
                if (!this.Tu.ue().uW().rb()) {
                    return null;
                }
                this.cTY = new com.baidu.tbadk.coreExtra.data.l();
                this.cTY.parserJson(tD);
                str = this.cTY.getVcode_pic_url();
            }
            if (this.aGi) {
                return null;
            }
            this.Tu = new com.baidu.tbadk.core.util.v(str);
            return com.baidu.tbadk.core.util.c.N(this.Tu.tE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.cTW = null;
            if (bitmap != null) {
                VcodeActivity.this.aCs.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.cTY != null) {
                VcodeActivity.this.cTH.setVcodeMD5(this.cTY.getVcode_md5());
                VcodeActivity.this.cTH.setVcodeUrl(this.cTY.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
