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
    private WriteData doW = null;
    private TextView dmE = null;
    private ImageView aDq = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b dpl = null;
    private a dpm = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cpX = null;
    private RelativeLayout bro = null;
    private TextView aPt = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dpg = new u(this);
    private final View.OnClickListener dph = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.vcode_activity);
        initUI();
        initData(bundle);
        mw(this.doW.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cpX = new w(this);
        if (bundle != null) {
            this.doW = (WriteData) bundle.getSerializable("model");
        } else {
            this.doW = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.doW != null && this.doW.getType() == 3) {
            if (this.dpl != null) {
                this.dpl.cancel();
            }
            if (this.dpm != null) {
                this.dpm.cancel();
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
        if (this.dpl != null) {
            this.dpl.cancel();
        }
        if (this.dpm != null) {
            this.dpm.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.doW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.an.e(this.bro, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.an.i((View) this.dmE, i.e.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.an.ct(i);
        } else {
            i2 = -12895429;
        }
        this.aPt.setTextColor(i2);
    }

    private void initUI() {
        this.bro = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aPt = (TextView) findViewById(i.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dpg);
        this.dmE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dph);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmE.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dmE.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(i.f.input);
        this.aDq = (ImageView) findViewById(i.f.vcode_image);
        this.aDq.setImageDrawable(null);
        this.aDq.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(String str) {
        if (this.dpm != null) {
            this.dpm.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aDq.setImageDrawable(null);
        this.dpm = new a(this, null);
        this.dpm.setPriority(3);
        this.dpm.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
        private com.baidu.tbadk.core.util.w afh = null;
        private String dbJ = null;
        private WriteData dpp;

        public b(WriteData writeData) {
            this.dpp = null;
            this.dpp = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            if (this.dpp != null) {
                this.afh = new com.baidu.tbadk.core.util.w();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.dpp.getImagesCodeForPost();
                if (this.dpp.getType() == 3) {
                    this.afh.o("newVcode", "1");
                    this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dpp.getContent()) + imagesCodeForPost);
                    this.afh.o(PayVcodeActivityConfig.VCODE_MD5, this.dpp.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afh.o("vcode", editable);
                    }
                    this.afh.o("tag", "11");
                    this.afh.ue().uV().mIsNeedTbs = true;
                    this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dpp.getContent()) + imagesCodeForPost);
                    this.afh.setUrl(com.baidu.tieba.tbadkCore.d.a.cZG);
                    this.afh.o(ImageViewerConfig.FORUM_NAME, this.dpp.getForumName());
                    this.afh.o("title", this.dpp.getTitle());
                    this.afh.o("apiKey", this.dpp.getShareApiKey());
                    this.afh.o("appName", this.dpp.getShareAppName());
                    this.afh.o("signKey", this.dpp.getShareSignKey());
                    this.afh.o("summary_title", this.dpp.getShareSummaryTitle());
                    this.afh.o("summary_content", this.dpp.getShareSummaryContent());
                    this.afh.o("summary_img", this.dpp.getShareSummaryImg());
                    this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dpp.getShareSummaryImgWidth()));
                    this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dpp.getShareSummaryImgHeight()));
                    this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dpp.getShareSummaryImgType());
                    this.afh.o("referUrl", this.dpp.getShareReferUrl());
                } else {
                    this.afh.o("anonymous", "0");
                    this.afh.o(ImageViewerConfig.FORUM_ID, this.dpp.getForumId());
                    this.afh.o("kw", this.dpp.getForumName());
                    this.afh.o("new_vcode", "1");
                    if (this.dpp.getVideoInfo() == null) {
                        str = String.valueOf(this.dpp.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.dpp.getContent()) + videoInfo.buildWriteContent(this.dpp.getForumName()) + imagesCodeForPost;
                    }
                    if (this.dpp.getType() == 6 && this.dpp.getVoteInfo() != null) {
                        if (this.dpp.getWriteImagesInfo() != null) {
                            this.dpp.getVoteInfo().setServerImageCode(this.dpp.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.dpp.getVoteInfo().buildWriteContent();
                    }
                    this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.dpp.getIsBaobaoImageUploaded()) {
                        this.afh.o("tail_type", String.valueOf(a.C0075a.cZJ));
                        this.afh.o("tail_content", this.dpp.getBaobaoContent());
                        this.dpp.setBabaoPosted(true);
                    } else {
                        this.dpp.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afh, this.dpp);
                    this.afh.o("vcode_md5", this.dpp.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afh.o("vcode", editable);
                    }
                    this.afh.ue().uV().mIsNeedTbs = true;
                    if (this.dpp.getVoice() != null) {
                        this.afh.o("voice_md5", this.dpp.getVoice());
                        this.afh.o("during_time", String.valueOf(this.dpp.getVoiceDuringTime()));
                    }
                    if (this.dpp.getType() == 0) {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afh.o("title", this.dpp.getTitle());
                        this.afh.o("is_ntitle", this.dpp.isNoTitle() ? "1" : "0");
                        if (this.dpp.getLiveCardData() != null) {
                            this.afh.o("group_id", String.valueOf(this.dpp.getLiveCardData().getGroupId()));
                            this.afh.o("start_time", String.valueOf(this.dpp.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                            this.afh.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.dpp.getType() == 6) {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afh.o("title", this.dpp.getTitle());
                        this.afh.o("is_ntitle", this.dpp.isNoTitle() ? "1" : "0");
                        this.afh.o("thread_type", String.valueOf(36));
                    } else if (this.dpp.getType() == 4) {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afh.o("title", this.dpp.getTitle());
                        this.afh.o("is_ntitle", "0");
                        this.afh.o("thread_type", String.valueOf(33));
                        this.afh.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afh.o("tid", this.dpp.getThreadId());
                        this.afh.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.dpp.getType() == 2) {
                            this.afh.o("quote_id", String.valueOf(this.dpp.getFloor()));
                            this.afh.o("floor_num", String.valueOf(this.dpp.getFloorNum()));
                            this.afh.o(WriteActivityConfig.IS_ADDITION, this.dpp.isAddition() ? "1" : "0");
                            if (this.dpp.getRepostId() != null) {
                                this.afh.o("repostid", this.dpp.getRepostId());
                            }
                        } else if (this.dpp.getType() == 5) {
                            this.afh.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
                this.dbJ = this.afh.tD();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dpl = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afh != null) {
                this.afh.gJ();
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
            VcodeActivity.this.dpl = null;
            if (this.afh != null) {
                if (this.afh.ue().uW().qS()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.dbJ);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.dbJ).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                        }
                        if (this.dpp.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.Q(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.dpp.deleteUploadedTempImages();
                        if (this.dpp != null && this.dpp.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.awf();
                        }
                    } else if ((this.dpp.isHasImages() || this.dpp.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dpp.getContent()) + this.dpp.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                    } else if (this.dpp.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.dbJ).optString("tid");
                    } catch (JSONException e3) {
                        str2 = "";
                        e = e3;
                    }
                    try {
                        str3 = new JSONObject(this.dbJ).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        if (postWriteCallBackData != null) {
                            XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.dpp.getForumId(), this.dpp.getVideoInfo().getVideoUrl(), this.dpp.getForumName());
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        VcodeActivity.this.setResult(-1, intent);
                        if (this.dpp.getLiveCardData() != null) {
                        }
                        VcodeActivity.this.finish();
                        super.onPostExecute(lVar);
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    if (postWriteCallBackData != null && this.dpp != null && this.dpp.getVideoInfo() != null) {
                        XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.dpp.getForumId(), this.dpp.getVideoInfo().getVideoUrl(), this.dpp.getForumName());
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.dpp.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dpp.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.dpp.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dpp.getContent()) + this.dpp.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                } else {
                    if (this.afh.ui() == 5 || this.afh.ui() == 6) {
                        com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                        lVar2.parserJson(this.dbJ);
                        if (lVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.doW.setVcodeMD5(lVar2.getVcode_md5());
                            VcodeActivity.this.doW.setVcodeUrl(lVar2.getVcode_pic_url());
                            VcodeActivity.this.mw(VcodeActivity.this.doW.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afh.getErrorString());
                }
            }
            super.onPostExecute(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.w Ti;
        private volatile boolean aOK;
        com.baidu.tbadk.coreExtra.data.l dpo;

        private a() {
            this.Ti = null;
            this.dpo = null;
            this.aOK = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dpm = null;
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            this.aOK = true;
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
                this.Ti = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Ti.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.doW.getForumId());
                this.Ti.o("kw", VcodeActivity.this.doW.getForumName());
                this.Ti.o("new_vcode", "1");
                this.Ti.o("title", VcodeActivity.this.doW.getTitle());
                this.Ti.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.doW.getContent());
                if (VcodeActivity.this.doW.getType() == 0) {
                    this.Ti.o("pub_type", "1");
                } else {
                    this.Ti.o("pub_type", "2");
                    this.Ti.o("tid", VcodeActivity.this.doW.getThreadId());
                }
                String tD = this.Ti.tD();
                if (!this.Ti.ue().uW().qS()) {
                    return null;
                }
                this.dpo = new com.baidu.tbadk.coreExtra.data.l();
                this.dpo.parserJson(tD);
                str = this.dpo.getVcode_pic_url();
            }
            if (this.aOK) {
                return null;
            }
            this.Ti = new com.baidu.tbadk.core.util.w(str);
            return com.baidu.tbadk.core.util.c.N(this.Ti.tE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.dpm = null;
            if (bitmap != null) {
                VcodeActivity.this.aDq.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.dpo != null) {
                VcodeActivity.this.doW.setVcodeMD5(this.dpo.getVcode_md5());
                VcodeActivity.this.doW.setVcodeUrl(this.dpo.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
