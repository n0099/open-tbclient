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
    private WriteData dow = null;
    private TextView dme = null;
    private ImageView aDf = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b doK = null;
    private a doL = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cpM = null;
    private RelativeLayout brd = null;
    private TextView aPi = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener doG = new u(this);
    private final View.OnClickListener doH = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.vcode_activity);
        initUI();
        initData(bundle);
        mt(this.dow.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cpM = new w(this);
        if (bundle != null) {
            this.dow = (WriteData) bundle.getSerializable("model");
        } else {
            this.dow = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dow != null && this.dow.getType() == 3) {
            if (this.doK != null) {
                this.doK.cancel();
            }
            if (this.doL != null) {
                this.doL.cancel();
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
        if (this.doK != null) {
            this.doK.cancel();
        }
        if (this.doL != null) {
            this.doL.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dow);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.e(this.brd, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.am.i((View) this.dme, i.e.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.am.ct(i);
        } else {
            i2 = -12895429;
        }
        this.aPi.setTextColor(i2);
    }

    private void initUI() {
        this.brd = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aPi = (TextView) findViewById(i.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.doG);
        this.dme = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.doH);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dme.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dme.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(i.f.input);
        this.aDf = (ImageView) findViewById(i.f.vcode_image);
        this.aDf.setImageDrawable(null);
        this.aDf.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(String str) {
        if (this.doL != null) {
            this.doL.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aDf.setImageDrawable(null);
        this.doL = new a(this, null);
        this.doL.setPriority(3);
        this.doL.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
        private com.baidu.tbadk.core.util.w afg = null;
        private String dbj = null;
        private WriteData doO;

        public b(WriteData writeData) {
            this.doO = null;
            this.doO = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            if (this.doO != null) {
                this.afg = new com.baidu.tbadk.core.util.w();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.doO.getImagesCodeForPost();
                if (this.doO.getType() == 3) {
                    this.afg.o("newVcode", "1");
                    this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.doO.getContent()) + imagesCodeForPost);
                    this.afg.o(PayVcodeActivityConfig.VCODE_MD5, this.doO.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afg.o("vcode", editable);
                    }
                    this.afg.o("tag", "11");
                    this.afg.uh().uX().mIsNeedTbs = true;
                    this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.doO.getContent()) + imagesCodeForPost);
                    this.afg.setUrl(com.baidu.tieba.tbadkCore.d.a.cZg);
                    this.afg.o(ImageViewerConfig.FORUM_NAME, this.doO.getForumName());
                    this.afg.o("title", this.doO.getTitle());
                    this.afg.o("apiKey", this.doO.getShareApiKey());
                    this.afg.o("appName", this.doO.getShareAppName());
                    this.afg.o("signKey", this.doO.getShareSignKey());
                    this.afg.o("summary_title", this.doO.getShareSummaryTitle());
                    this.afg.o("summary_content", this.doO.getShareSummaryContent());
                    this.afg.o("summary_img", this.doO.getShareSummaryImg());
                    this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.doO.getShareSummaryImgWidth()));
                    this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.doO.getShareSummaryImgHeight()));
                    this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.doO.getShareSummaryImgType());
                    this.afg.o("referUrl", this.doO.getShareReferUrl());
                } else {
                    this.afg.o("anonymous", "0");
                    this.afg.o(ImageViewerConfig.FORUM_ID, this.doO.getForumId());
                    this.afg.o("kw", this.doO.getForumName());
                    this.afg.o("new_vcode", "1");
                    if (this.doO.getVideoInfo() == null) {
                        str = String.valueOf(this.doO.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.doO.getContent()) + videoInfo.buildWriteContent(this.doO.getForumName()) + imagesCodeForPost;
                    }
                    if (this.doO.getType() == 6 && this.doO.getVoteInfo() != null) {
                        if (this.doO.getWriteImagesInfo() != null) {
                            this.doO.getVoteInfo().setServerImageCode(this.doO.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.doO.getVoteInfo().buildWriteContent();
                    }
                    this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.doO.getIsBaobaoImageUploaded()) {
                        this.afg.o("tail_type", String.valueOf(a.C0075a.cZj));
                        this.afg.o("tail_content", this.doO.getBaobaoContent());
                        this.doO.setBabaoPosted(true);
                    } else {
                        this.doO.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afg, this.doO);
                    this.afg.o("vcode_md5", this.doO.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afg.o("vcode", editable);
                    }
                    this.afg.uh().uX().mIsNeedTbs = true;
                    if (this.doO.getVoice() != null) {
                        this.afg.o("voice_md5", this.doO.getVoice());
                        this.afg.o("during_time", String.valueOf(this.doO.getVoiceDuringTime()));
                    }
                    if (this.doO.getType() == 0) {
                        this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afg.o("title", this.doO.getTitle());
                        this.afg.o("is_ntitle", this.doO.isNoTitle() ? "1" : "0");
                        if (this.doO.getLiveCardData() != null) {
                            this.afg.o("group_id", String.valueOf(this.doO.getLiveCardData().getGroupId()));
                            this.afg.o("start_time", String.valueOf(this.doO.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                            this.afg.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.doO.getType() == 6) {
                        this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afg.o("title", this.doO.getTitle());
                        this.afg.o("is_ntitle", this.doO.isNoTitle() ? "1" : "0");
                        this.afg.o("thread_type", String.valueOf(36));
                    } else if (this.doO.getType() == 4) {
                        this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afg.o("title", this.doO.getTitle());
                        this.afg.o("is_ntitle", "0");
                        this.afg.o("thread_type", String.valueOf(33));
                        this.afg.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afg.o("tid", this.doO.getThreadId());
                        this.afg.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.doO.getType() == 2) {
                            this.afg.o("quote_id", String.valueOf(this.doO.getFloor()));
                            this.afg.o("floor_num", String.valueOf(this.doO.getFloorNum()));
                            this.afg.o(WriteActivityConfig.IS_ADDITION, this.doO.isAddition() ? "1" : "0");
                            if (this.doO.getRepostId() != null) {
                                this.afg.o("repostid", this.doO.getRepostId());
                            }
                        } else if (this.doO.getType() == 5) {
                            this.afg.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
                this.dbj = this.afg.tG();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.doK = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afg != null) {
                this.afg.gJ();
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
            VcodeActivity.this.doK = null;
            if (this.afg != null) {
                if (this.afg.uh().uY().qV()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.dbj);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.dbj).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                        }
                        if (this.doO.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.Q(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.doO.deleteUploadedTempImages();
                        if (this.doO != null && this.doO.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.awb();
                        }
                    } else if ((this.doO.isHasImages() || this.doO.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.doO.getContent()) + this.doO.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                    } else if (this.doO.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.dbj).optString("tid");
                    } catch (JSONException e3) {
                        str2 = "";
                        e = e3;
                    }
                    try {
                        str3 = new JSONObject(this.dbj).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        if (postWriteCallBackData != null) {
                            XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.doO.getForumId(), this.doO.getVideoInfo().getVideoUrl(), this.doO.getForumName());
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        VcodeActivity.this.setResult(-1, intent);
                        if (this.doO.getLiveCardData() != null) {
                        }
                        VcodeActivity.this.finish();
                        super.onPostExecute(lVar);
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    if (postWriteCallBackData != null && this.doO != null && this.doO.getVideoInfo() != null) {
                        XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.doO.getForumId(), this.doO.getVideoInfo().getVideoUrl(), this.doO.getForumName());
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.doO.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.doO.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.doO.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.doO.getContent()) + this.doO.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                } else {
                    if (this.afg.ul() == 5 || this.afg.ul() == 6) {
                        com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                        lVar2.parserJson(this.dbj);
                        if (lVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.dow.setVcodeMD5(lVar2.getVcode_md5());
                            VcodeActivity.this.dow.setVcodeUrl(lVar2.getVcode_pic_url());
                            VcodeActivity.this.mt(VcodeActivity.this.dow.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afg.getErrorString());
                }
            }
            super.onPostExecute(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.w Th;
        private volatile boolean aOz;
        com.baidu.tbadk.coreExtra.data.l doN;

        private a() {
            this.Th = null;
            this.doN = null;
            this.aOz = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.doL = null;
            if (this.Th != null) {
                this.Th.gJ();
            }
            this.aOz = true;
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
                this.Th = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Th.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.dow.getForumId());
                this.Th.o("kw", VcodeActivity.this.dow.getForumName());
                this.Th.o("new_vcode", "1");
                this.Th.o("title", VcodeActivity.this.dow.getTitle());
                this.Th.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.dow.getContent());
                if (VcodeActivity.this.dow.getType() == 0) {
                    this.Th.o("pub_type", "1");
                } else {
                    this.Th.o("pub_type", "2");
                    this.Th.o("tid", VcodeActivity.this.dow.getThreadId());
                }
                String tG = this.Th.tG();
                if (!this.Th.uh().uY().qV()) {
                    return null;
                }
                this.doN = new com.baidu.tbadk.coreExtra.data.l();
                this.doN.parserJson(tG);
                str = this.doN.getVcode_pic_url();
            }
            if (this.aOz) {
                return null;
            }
            this.Th = new com.baidu.tbadk.core.util.w(str);
            return com.baidu.tbadk.core.util.c.N(this.Th.tH());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.doL = null;
            if (bitmap != null) {
                VcodeActivity.this.aDf.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.doN != null) {
                VcodeActivity.this.dow.setVcodeMD5(this.doN.getVcode_md5());
                VcodeActivity.this.dow.setVcodeUrl(this.doN.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
