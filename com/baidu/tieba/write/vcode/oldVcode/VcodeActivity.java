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
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.e;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData fXe = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b fXf = null;
    private a fXg = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private RelativeLayout mParent = null;
    private TextView mInfo = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener onBackListener = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener onPostListener = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.vcode_activity);
        initUI();
        initData(bundle);
        if (this.fXe != null) {
            ro(this.fXe.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.fXe = (WriteData) bundle.getSerializable("model");
        } else {
            this.fXe = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fXe != null && this.fXe.getType() == 3) {
            if (this.fXf != null) {
                this.fXf.cancel();
            }
            if (this.fXg != null) {
                this.fXg.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fXf != null) {
            this.fXf.cancel();
        }
        if (this.fXg != null) {
            this.fXg.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fXe);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        aq.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aq.j(this.mPost, w.g.s_navbar_button_bg);
        aq.i(this.mPost, w.e.cp_cont_g);
        if (i == 1) {
            i2 = aq.cJ(i);
        } else {
            i2 = -12895429;
        }
        this.mInfo.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(w.l.sending), true, false, this.mDialogCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mInfo = (TextView) findViewById(w.h.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.send), this.onPostListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(w.h.input);
        this.mImage = (ImageView) findViewById(w.h.vcode_image);
        this.mImage.setImageDrawable(null);
        this.mImage.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(w.h.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(String str) {
        if (this.fXg != null) {
            this.fXg.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.fXg = new a(this, null);
        this.fXg.setPriority(3);
        this.fXg.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fXi;
        private z mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.fXi = null;
            this.fXi = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.fXi != null) {
                this.mNetwork = new z();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.fXi.getImagesCodeForPost();
                if (this.fXi.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n("content", String.valueOf(this.fXi.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.fXi.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.uF().vA().mIsNeedTbs = true;
                    this.mNetwork.n("content", String.valueOf(this.fXi.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fCV);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.fXi.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fXi.getTitle());
                    this.mNetwork.n("apiKey", this.fXi.getShareApiKey());
                    this.mNetwork.n("appName", this.fXi.getShareAppName());
                    this.mNetwork.n("signKey", this.fXi.getShareSignKey());
                    this.mNetwork.n("summary_title", this.fXi.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.fXi.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.fXi.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fXi.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fXi.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fXi.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.fXi.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.fXi.getForumId());
                    this.mNetwork.n("kw", this.fXi.getForumName());
                    this.mNetwork.n("can_no_forum", this.fXi.isCanNoForum() ? "1" : "0");
                    this.mNetwork.n("is_feedback", this.fXi.isUserFeedback() ? "1" : "0");
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fXi.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fXi.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fXi.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fXi.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fXi.getGraffitiWriteCode();
                    }
                    if (this.fXi.getType() == 6 && this.fXi.getVoteInfo() != null) {
                        if (this.fXi.getWriteImagesInfo() != null) {
                            this.fXi.getVoteInfo().setServerImageCode(this.fXi.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fXi.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n("content", str);
                    e.a(this.mNetwork, this.fXi);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fXi.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.uF().vA().mIsNeedTbs = true;
                    if (this.fXi.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.fXi.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.fXi.getVoiceDuringTime()));
                    }
                    if (this.fXi.getType() == 0 || this.fXi.getType() == 7) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        if (this.fXi.getType() == 0) {
                            this.mNetwork.n("transform_forums", this.fXi.getTransmitForumData());
                            this.mNetwork.n(IntentConfig.CALL_FROM, this.fXi.getCallFrom());
                            if (this.fXi.getRecommendExt() != null) {
                                this.mNetwork.n("recommend_ext", this.fXi.getRecommendExt());
                            }
                        }
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fXi.getTitle());
                        this.mNetwork.n("is_ntitle", this.fXi.isNoTitle() ? "1" : "0");
                        if (this.fXi.getType() == 7) {
                            this.mNetwork.n("is_bottle", String.valueOf(1));
                        }
                        if (this.fXi.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.fXi.getCategoryFrom()));
                        }
                        if (this.fXi.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.fXi.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.fg().C(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(C.getLatitude())) + "," + String.valueOf(C.getLongitude()));
                        }
                    } else if (this.fXi.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fXi.getTitle());
                        this.mNetwork.n("is_ntitle", this.fXi.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.fXi.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fXi.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.fXi.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fXi.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.fXi.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.fXi.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.fXi.isAddition() ? "1" : "0");
                            if (this.fXi.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.fXi.getRepostId());
                            }
                            this.mNetwork.n("v_fid", this.fXi.getVForumId());
                            this.mNetwork.n("v_fname", this.fXi.getVForumName());
                        } else if (this.fXi.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fXi.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.fXi.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.fXi.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.CI().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                            this.mNetwork.n("v_fid", this.fXi.getVForumId());
                            this.mNetwork.n("v_fname", this.fXi.getVForumName());
                        }
                    }
                }
                this.mRetData = this.mNetwork.ug();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fXf = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d5 A[Catch: JSONException -> 0x0164, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0164, blocks: (B:30:0x00b2, B:32:0x00d5), top: B:80:0x00b2 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0283  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(q qVar) {
            String str;
            String str2;
            String str3;
            int i;
            JSONException jSONException;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.fXf = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.uF().vB().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.fXe);
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str6 = jSONObject.optString(AddFriendActivityConfig.MSG);
                            try {
                                JSONObject optJSONObject = jSONObject.optJSONObject("exp");
                                if (optJSONObject != null) {
                                    str7 = optJSONObject.optString("pre_msg");
                                    if (StringUtils.isNull(str7)) {
                                        str7 = null;
                                    }
                                    try {
                                        str8 = optJSONObject.optString("color_msg");
                                        if (StringUtils.isNull(str8)) {
                                            str8 = null;
                                        }
                                    } catch (JSONException e) {
                                        str5 = str7;
                                        str4 = str6;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        str6 = str4;
                                        str7 = str5;
                                        str8 = null;
                                        if (StringUtils.isNull(str6)) {
                                        }
                                        if (this.fXi.getType() != 3) {
                                            e.c(VcodeActivity.this.getActivity(), str6, str7, str8);
                                        }
                                        this.fXi.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.mRetData);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString(Info.kBaiduPIDKey);
                                        str3 = jSONObject2.optString(AddFriendActivityConfig.MSG);
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("twzhibo_info");
                                        if (optJSONObject2 == null) {
                                        }
                                        postWriteCallBackData.setThreadId(str);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        Intent intent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent.putExtras(bundle);
                                        VcodeActivity.this.setResult(-1, intent);
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(qVar);
                                    }
                                } else {
                                    str8 = null;
                                    str7 = null;
                                }
                            } catch (JSONException e2) {
                                str4 = str6;
                                jSONException = e2;
                                str5 = null;
                            }
                        } catch (JSONException e3) {
                            jSONException = e3;
                            str4 = null;
                            str5 = null;
                        }
                        if (StringUtils.isNull(str6)) {
                            str6 = TbadkCoreApplication.m9getInst().getString(w.l.send_success);
                        }
                        if (this.fXi.getType() != 3 && this.fXi.getType() != 7 && (this.fXi.getType() != 0 || this.fXi.isUserFeedback())) {
                            e.c(VcodeActivity.this.getActivity(), str6, str7, str8);
                        }
                        this.fXi.deleteUploadedTempImages();
                    } else if (this.fXi.isHasImages() && j.isEmpty(String.valueOf(this.fXi.getContent()) + this.fXi.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                    } else if (this.fXi.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.mRetData);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString(Info.kBaiduPIDKey);
                        str3 = jSONObject22.optString(AddFriendActivityConfig.MSG);
                        JSONObject optJSONObject22 = jSONObject22.optJSONObject("twzhibo_info");
                        i = optJSONObject22 == null ? optJSONObject22.optInt("is_copytwzhibo", 0) : 0;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        str = str;
                        str2 = str2;
                        str3 = str3;
                        i = 0;
                    }
                    postWriteCallBackData2.setThreadId(str);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str3);
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    VcodeActivity.this.finish();
                } else if (this.fXi.isHasImages() && j.isEmpty(String.valueOf(this.fXi.getContent()) + this.fXi.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                } else {
                    if (this.mNetwork.uJ() == 5 || this.mNetwork.uJ() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null && VcodeActivity.this.fXe != null) {
                            VcodeActivity.this.fXe.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fXe.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.ro(VcodeActivity.this.fXe.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.fXi != null && this.mNetwork.uJ() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.uJ(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fXi, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.uJ() != 227001) {
                        VcodeActivity.this.showToast(this.mNetwork.getErrorString());
                    }
                }
            }
            super.onPostExecute(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        q mInfoData;
        volatile z mNetWork;

        private a() {
            this.mNetWork = null;
            this.mInfoData = null;
            this.mCanceled = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fXg = null;
            if (this.mNetWork != null) {
                this.mNetWork.fs();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.fXe == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.fXe.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.fXe.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fXe.getTitle());
                this.mNetWork.n("content", VcodeActivity.this.fXe.getContent());
                if (VcodeActivity.this.fXe.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.fXe.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.fXe.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fXe.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.fXe.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.fXe.getThreadId());
                }
                String ug = this.mNetWork.ug();
                if (!this.mNetWork.uF().vB().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(ug);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.uh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fXg = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.fXe != null) {
                VcodeActivity.this.fXe.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.fXe.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
