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
    private WriteData dcE = null;
    private TextView dbc = null;
    private ImageView aEa = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b dcS = null;
    private a dcT = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ckj = null;
    private RelativeLayout boe = null;
    private TextView aQm = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dcO = new u(this);
    private final View.OnClickListener dcP = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.vcode_activity);
        initUI();
        initData(bundle);
        lL(this.dcE.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.ckj = new w(this);
        if (bundle != null) {
            this.dcE = (WriteData) bundle.getSerializable("model");
        } else {
            this.dcE = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dcE != null && this.dcE.getType() == 3) {
            if (this.dcS != null) {
                this.dcS.cancel();
            }
            if (this.dcT != null) {
                this.dcT.cancel();
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
        if (this.dcS != null) {
            this.dcS.cancel();
        }
        if (this.dcT != null) {
            this.dcT.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dcE);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.e(this.boe, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.al.g(this.dbc, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.al.cr(i);
        } else {
            i2 = -12895429;
        }
        this.aQm.setTextColor(i2);
    }

    private void initUI() {
        this.boe = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aQm = (TextView) findViewById(i.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dcO);
        this.dbc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dcP);
        this.mEdit = (EditText) findViewById(i.f.input);
        this.aEa = (ImageView) findViewById(i.f.vcode_image);
        this.aEa.setImageDrawable(null);
        this.aEa.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(String str) {
        if (this.dcT != null) {
            this.dcT.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aEa.setImageDrawable(null);
        this.dcT = new a(this, null);
        this.dcT.setPriority(3);
        this.dcT.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
        private com.baidu.tbadk.core.util.v afT = null;
        private String cTD = null;
        private WriteData dcW;

        public b(WriteData writeData) {
            this.dcW = null;
            this.dcW = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            if (this.dcW != null) {
                this.afT = new com.baidu.tbadk.core.util.v();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.dcW.getImagesCodeForPost();
                if (this.dcW.getType() == 3) {
                    this.afT.o("newVcode", "1");
                    this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dcW.getContent()) + imagesCodeForPost);
                    this.afT.o("vcodeMd5", this.dcW.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afT.o("vcode", editable);
                    }
                    this.afT.o("tag", "11");
                    this.afT.uj().uZ().mIsNeedTbs = true;
                    this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dcW.getContent()) + imagesCodeForPost);
                    this.afT.setUrl(com.baidu.tieba.tbadkCore.d.a.cRC);
                    this.afT.o(ImageViewerConfig.FORUM_NAME, this.dcW.getForumName());
                    this.afT.o("title", this.dcW.getTitle());
                    this.afT.o("apiKey", this.dcW.getShareApiKey());
                    this.afT.o("appName", this.dcW.getShareAppName());
                    this.afT.o("signKey", this.dcW.getShareSignKey());
                    this.afT.o("summary_title", this.dcW.getShareSummaryTitle());
                    this.afT.o("summary_content", this.dcW.getShareSummaryContent());
                    this.afT.o("summary_img", this.dcW.getShareSummaryImg());
                    this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dcW.getShareSummaryImgWidth()));
                    this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dcW.getShareSummaryImgHeight()));
                    this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dcW.getShareSummaryImgType());
                    this.afT.o("referUrl", this.dcW.getShareReferUrl());
                } else {
                    this.afT.o("anonymous", "0");
                    this.afT.o(ImageViewerConfig.FORUM_ID, this.dcW.getForumId());
                    this.afT.o("kw", this.dcW.getForumName());
                    this.afT.o("new_vcode", "1");
                    if (this.dcW.getVideoInfo() == null) {
                        str = String.valueOf(this.dcW.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.dcW.getContent()) + videoInfo.buildWriteContent(this.dcW.getForumName()) + imagesCodeForPost;
                    }
                    this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.dcW.getIsBaobaoImageUploaded()) {
                        this.afT.o("tail_type", String.valueOf(a.C0072a.cRF));
                        this.afT.o(TailEditActivityConfig.TAIL_CONTENT, this.dcW.getBaobaoContent());
                        this.dcW.setBabaoPosted(true);
                    } else {
                        this.dcW.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, this.dcW);
                    this.afT.o("vcode_md5", this.dcW.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afT.o("vcode", editable);
                    }
                    this.afT.uj().uZ().mIsNeedTbs = true;
                    if (this.dcW.getVoice() != null) {
                        this.afT.o("voice_md5", this.dcW.getVoice());
                        this.afT.o("during_time", String.valueOf(this.dcW.getVoiceDuringTime()));
                    }
                    if (this.dcW.getType() == 0) {
                        this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afT.o("title", this.dcW.getTitle());
                        this.afT.o("is_ntitle", this.dcW.isNoTitle() ? "1" : "0");
                        if (this.dcW.getLiveCardData() != null) {
                            this.afT.o("group_id", String.valueOf(this.dcW.getLiveCardData().getGroupId()));
                            this.afT.o("start_time", String.valueOf(this.dcW.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                            this.afT.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.dcW.getType() == 4) {
                        this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afT.o("title", this.dcW.getTitle());
                        this.afT.o("is_ntitle", "0");
                        this.afT.o("thread_type", String.valueOf(33));
                        this.afT.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afT.o("tid", this.dcW.getThreadId());
                        this.afT.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.dcW.getType() == 2) {
                            this.afT.o("quote_id", String.valueOf(this.dcW.getFloor()));
                            this.afT.o("floor_num", String.valueOf(this.dcW.getFloorNum()));
                            this.afT.o(WriteActivityConfig.IS_ADDITION, this.dcW.isAddition() ? "1" : "0");
                            if (this.dcW.getRepostId() != null) {
                                this.afT.o("repostid", this.dcW.getRepostId());
                            }
                        } else if (this.dcW.getType() == 5) {
                            this.afT.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
                this.cTD = this.afT.tI();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dcS = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afT != null) {
                this.afT.gJ();
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
            VcodeActivity.this.dcS = null;
            if (this.afT != null) {
                if (this.afT.uj().va().qZ()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.cTD);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.cTD).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                        }
                        if (this.dcW.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.c.Q(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.dcW.deleteUploadedTempImages();
                        if (this.dcW != null && this.dcW.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.atL();
                        }
                    } else if ((this.dcW.isHasImages() || this.dcW.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dcW.getContent()) + this.dcW.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                    } else if (this.dcW.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.cTD).optString("tid");
                    } catch (JSONException e3) {
                        str2 = "";
                        e = e3;
                    }
                    try {
                        str3 = new JSONObject(this.cTD).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        if (postWriteCallBackData != null) {
                            XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.dcW.getForumId(), this.dcW.getVideoInfo().getVideoUrl(), this.dcW.getForumName());
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        VcodeActivity.this.setResult(-1, intent);
                        if (this.dcW.getLiveCardData() != null) {
                        }
                        VcodeActivity.this.finish();
                        super.onPostExecute(lVar);
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    if (postWriteCallBackData != null && this.dcW != null && this.dcW.getVideoInfo() != null) {
                        XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.dcW.getForumId(), this.dcW.getVideoInfo().getVideoUrl(), this.dcW.getForumName());
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.dcW.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dcW.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.dcW.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dcW.getContent()) + this.dcW.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                } else {
                    if (this.afT.un() == 5 || this.afT.un() == 6) {
                        com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                        lVar2.parserJson(this.cTD);
                        if (lVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.dcE.setVcodeMD5(lVar2.getVcode_md5());
                            VcodeActivity.this.dcE.setVcodeUrl(lVar2.getVcode_pic_url());
                            VcodeActivity.this.lL(VcodeActivity.this.dcE.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afT.getErrorString());
                }
            }
            super.onPostExecute(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.v Tv;
        private volatile boolean aPE;
        com.baidu.tbadk.coreExtra.data.l dcV;

        private a() {
            this.Tv = null;
            this.dcV = null;
            this.aPE = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dcT = null;
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            this.aPE = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.Tv = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Tv.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.dcE.getForumId());
                this.Tv.o("kw", VcodeActivity.this.dcE.getForumName());
                this.Tv.o("new_vcode", "1");
                this.Tv.o("title", VcodeActivity.this.dcE.getTitle());
                this.Tv.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.dcE.getContent());
                if (VcodeActivity.this.dcE.getType() == 0) {
                    this.Tv.o("pub_type", "1");
                } else {
                    this.Tv.o("pub_type", "2");
                    this.Tv.o("tid", VcodeActivity.this.dcE.getThreadId());
                }
                String tI = this.Tv.tI();
                if (!this.Tv.uj().va().qZ()) {
                    return null;
                }
                this.dcV = new com.baidu.tbadk.coreExtra.data.l();
                this.dcV.parserJson(tI);
                str = this.dcV.getVcode_pic_url();
            }
            if (this.aPE) {
                return null;
            }
            this.Tv = new com.baidu.tbadk.core.util.v(str);
            return com.baidu.tbadk.core.util.c.N(this.Tv.tJ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.dcT = null;
            if (bitmap != null) {
                VcodeActivity.this.aEa.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.dcV != null) {
                VcodeActivity.this.dcE.setVcodeMD5(this.dcV.getVcode_md5());
                VcodeActivity.this.dcE.setVcodeUrl(this.dcV.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
