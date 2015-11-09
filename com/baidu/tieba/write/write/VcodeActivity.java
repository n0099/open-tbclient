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
    private WriteData dqL = null;
    private TextView dom = null;
    private ImageView aCk = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b dqZ = null;
    private a dra = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener crt = null;
    private RelativeLayout brS = null;
    private TextView aPB = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dqV = new u(this);
    private final View.OnClickListener dqW = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.vcode_activity);
        initUI();
        initData(bundle);
        mA(this.dqL.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.crt = new w(this);
        if (bundle != null) {
            this.dqL = (WriteData) bundle.getSerializable("model");
        } else {
            this.dqL = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dqL != null && this.dqL.getType() == 3) {
            if (this.dqZ != null) {
                this.dqZ.cancel();
            }
            if (this.dra != null) {
                this.dra.cancel();
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
        if (this.dqZ != null) {
            this.dqZ.cancel();
        }
        if (this.dra != null) {
            this.dra.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dqL);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.an.e(this.brS, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.an.i((View) this.dom, i.e.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.an.ct(i);
        } else {
            i2 = -12895429;
        }
        this.aPB.setTextColor(i2);
    }

    private void initUI() {
        this.brS = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aPB = (TextView) findViewById(i.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dqV);
        this.dom = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dqW);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dom.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dom.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(i.f.input);
        this.aCk = (ImageView) findViewById(i.f.vcode_image);
        this.aCk.setImageDrawable(null);
        this.aCk.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(String str) {
        if (this.dra != null) {
            this.dra.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aCk.setImageDrawable(null);
        this.dra = new a(this, null);
        this.dra.setPriority(3);
        this.dra.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
        private com.baidu.tbadk.core.util.w afm = null;
        private String ddT = null;
        private WriteData drd;

        public b(WriteData writeData) {
            this.drd = null;
            this.drd = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            if (this.drd != null) {
                this.afm = new com.baidu.tbadk.core.util.w();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.drd.getImagesCodeForPost();
                if (this.drd.getType() == 3) {
                    this.afm.o("newVcode", "1");
                    this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.drd.getContent()) + imagesCodeForPost);
                    this.afm.o(PayVcodeActivityConfig.VCODE_MD5, this.drd.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afm.o("vcode", editable);
                    }
                    this.afm.o("tag", "11");
                    this.afm.uh().uZ().mIsNeedTbs = true;
                    this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.drd.getContent()) + imagesCodeForPost);
                    this.afm.setUrl(com.baidu.tieba.tbadkCore.d.a.dbq);
                    this.afm.o(ImageViewerConfig.FORUM_NAME, this.drd.getForumName());
                    this.afm.o("title", this.drd.getTitle());
                    this.afm.o("apiKey", this.drd.getShareApiKey());
                    this.afm.o("appName", this.drd.getShareAppName());
                    this.afm.o("signKey", this.drd.getShareSignKey());
                    this.afm.o("summary_title", this.drd.getShareSummaryTitle());
                    this.afm.o("summary_content", this.drd.getShareSummaryContent());
                    this.afm.o("summary_img", this.drd.getShareSummaryImg());
                    this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.drd.getShareSummaryImgWidth()));
                    this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.drd.getShareSummaryImgHeight()));
                    this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.drd.getShareSummaryImgType());
                    this.afm.o("referUrl", this.drd.getShareReferUrl());
                } else {
                    this.afm.o("anonymous", "0");
                    this.afm.o(ImageViewerConfig.FORUM_ID, this.drd.getForumId());
                    this.afm.o("kw", this.drd.getForumName());
                    this.afm.o("new_vcode", "1");
                    if (this.drd.getVideoInfo() == null) {
                        str = String.valueOf(this.drd.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.drd.getContent()) + videoInfo.buildWriteContent(this.drd.getForumName()) + imagesCodeForPost;
                    }
                    if (this.drd.getType() == 6 && this.drd.getVoteInfo() != null) {
                        if (this.drd.getWriteImagesInfo() != null) {
                            this.drd.getVoteInfo().setServerImageCode(this.drd.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.drd.getVoteInfo().buildWriteContent();
                    }
                    this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.drd.getIsBaobaoImageUploaded()) {
                        this.afm.o("tail_type", String.valueOf(a.C0076a.dbt));
                        this.afm.o("tail_content", this.drd.getBaobaoContent());
                        this.drd.setBabaoPosted(true);
                    } else {
                        this.drd.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afm, this.drd);
                    this.afm.o("vcode_md5", this.drd.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.afm.o("vcode", editable);
                    }
                    this.afm.uh().uZ().mIsNeedTbs = true;
                    if (this.drd.getVoice() != null) {
                        this.afm.o("voice_md5", this.drd.getVoice());
                        this.afm.o("during_time", String.valueOf(this.drd.getVoiceDuringTime()));
                    }
                    if (this.drd.getType() == 0) {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afm.o("title", this.drd.getTitle());
                        this.afm.o("is_ntitle", this.drd.isNoTitle() ? "1" : "0");
                        if (this.drd.getCategoryFrom() >= 0) {
                            this.afm.o("fromCategoryId", String.valueOf(this.drd.getCategoryFrom()));
                        }
                        if (this.drd.getCategoryTo() >= 0) {
                            this.afm.o("toCategoryId", String.valueOf(this.drd.getCategoryTo()));
                        }
                        if (this.drd.getLiveCardData() != null) {
                            this.afm.o("group_id", String.valueOf(this.drd.getLiveCardData().getGroupId()));
                            this.afm.o("start_time", String.valueOf(this.drd.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                            this.afm.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.drd.getType() == 6) {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afm.o("title", this.drd.getTitle());
                        this.afm.o("is_ntitle", this.drd.isNoTitle() ? "1" : "0");
                        this.afm.o("thread_type", String.valueOf(36));
                    } else if (this.drd.getType() == 4) {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.afm.o("title", this.drd.getTitle());
                        this.afm.o("is_ntitle", "0");
                        this.afm.o("thread_type", String.valueOf(33));
                        this.afm.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.afm.o("tid", this.drd.getThreadId());
                        this.afm.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.drd.getType() == 2) {
                            this.afm.o("quote_id", String.valueOf(this.drd.getFloor()));
                            this.afm.o("floor_num", String.valueOf(this.drd.getFloorNum()));
                            this.afm.o(WriteActivityConfig.IS_ADDITION, this.drd.isAddition() ? "1" : "0");
                            if (this.drd.getRepostId() != null) {
                                this.afm.o("repostid", this.drd.getRepostId());
                            }
                        } else if (this.drd.getType() == 5) {
                            this.afm.o("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.drd.getType() == 1 && com.baidu.tbadk.editortools.c.b.AW().getStatus() == 1) {
                            this.afm.o("ptype", "4");
                        }
                    }
                }
                this.ddT = this.afm.tG();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dqZ = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.afm != null) {
                this.afm.gJ();
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
            VcodeActivity.this.dqZ = null;
            if (this.afm != null) {
                if (this.afm.uh().va().qT()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.ddT);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.ddT).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                        }
                        if (this.drd.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.R(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.drd.deleteUploadedTempImages();
                        if (this.drd != null && this.drd.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.awN();
                        }
                    } else if ((this.drd.isHasImages() || this.drd.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.drd.getContent()) + this.drd.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                    } else if (this.drd.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.ddT).optString("tid");
                    } catch (JSONException e3) {
                        str2 = "";
                        e = e3;
                    }
                    try {
                        str3 = new JSONObject(this.ddT).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        if (postWriteCallBackData != null) {
                            XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.drd.getForumId(), this.drd.getVideoInfo().getVideoUrl(), this.drd.getForumName());
                        }
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        VcodeActivity.this.setResult(-1, intent);
                        if (this.drd.getLiveCardData() != null) {
                        }
                        VcodeActivity.this.finish();
                        super.onPostExecute(lVar);
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    if (postWriteCallBackData != null && this.drd != null && this.drd.getVideoInfo() != null) {
                        XiaoyingUtil.reportEvent(str2, postWriteCallBackData.getPostId(), this.drd.getForumId(), this.drd.getVideoInfo().getVideoUrl(), this.drd.getForumName());
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.drd.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.drd.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.drd.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.drd.getContent()) + this.drd.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error));
                } else {
                    if (this.afm.ul() == 5 || this.afm.ul() == 6) {
                        com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                        lVar2.parserJson(this.ddT);
                        if (lVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.dqL.setVcodeMD5(lVar2.getVcode_md5());
                            VcodeActivity.this.dqL.setVcodeUrl(lVar2.getVcode_pic_url());
                            VcodeActivity.this.mA(VcodeActivity.this.dqL.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.afm.getErrorString());
                }
            }
            super.onPostExecute(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.w Tj;
        private volatile boolean aOS;
        com.baidu.tbadk.coreExtra.data.l drc;

        private a() {
            this.Tj = null;
            this.drc = null;
            this.aOS = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dra = null;
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            this.aOS = true;
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
                this.Tj = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Tj.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.dqL.getForumId());
                this.Tj.o("kw", VcodeActivity.this.dqL.getForumName());
                this.Tj.o("new_vcode", "1");
                this.Tj.o("title", VcodeActivity.this.dqL.getTitle());
                this.Tj.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.dqL.getContent());
                if (VcodeActivity.this.dqL.getType() == 0) {
                    this.Tj.o("pub_type", "1");
                    if (VcodeActivity.this.dqL.getCategoryFrom() >= 0) {
                        this.Tj.o("fromCategoryId", String.valueOf(VcodeActivity.this.dqL.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.dqL.getCategoryTo() >= 0) {
                        this.Tj.o("toCategoryId", String.valueOf(VcodeActivity.this.dqL.getCategoryTo()));
                    }
                } else {
                    this.Tj.o("pub_type", "2");
                    this.Tj.o("tid", VcodeActivity.this.dqL.getThreadId());
                }
                String tG = this.Tj.tG();
                if (!this.Tj.uh().va().qT()) {
                    return null;
                }
                this.drc = new com.baidu.tbadk.coreExtra.data.l();
                this.drc.parserJson(tG);
                str = this.drc.getVcode_pic_url();
            }
            if (this.aOS) {
                return null;
            }
            this.Tj = new com.baidu.tbadk.core.util.w(str);
            return com.baidu.tbadk.core.util.c.N(this.Tj.tH());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.dra = null;
            if (bitmap != null) {
                VcodeActivity.this.aCk.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.drc != null) {
                VcodeActivity.this.dqL.setVcodeMD5(this.drc.getVcode_md5());
                VcodeActivity.this.dqL.setVcodeUrl(this.drc.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
