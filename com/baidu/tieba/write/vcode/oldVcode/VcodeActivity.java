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
    private WriteData fPi = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b fPj = null;
    private a fPk = null;
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
        if (this.fPi != null) {
            ra(this.fPi.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.fPi = (WriteData) bundle.getSerializable("model");
        } else {
            this.fPi = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fPi != null && this.fPi.getType() == 3) {
            if (this.fPj != null) {
                this.fPj.cancel();
            }
            if (this.fPk != null) {
                this.fPk.cancel();
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
        if (this.fPj != null) {
            this.fPj.cancel();
        }
        if (this.fPk != null) {
            this.fPk.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fPi);
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
            i2 = aq.cI(i);
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
    public void ra(String str) {
        if (this.fPk != null) {
            this.fPk.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.fPk = new a(this, null);
        this.fPk.setPriority(3);
        this.fPk.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fPm;
        private z mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.fPm = null;
            this.fPm = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.fPm != null) {
                this.mNetwork = new z();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.fPm.getImagesCodeForPost();
                if (this.fPm.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n("content", String.valueOf(this.fPm.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.fPm.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.uJ().vD().mIsNeedTbs = true;
                    this.mNetwork.n("content", String.valueOf(this.fPm.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fvd);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.fPm.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fPm.getTitle());
                    this.mNetwork.n("apiKey", this.fPm.getShareApiKey());
                    this.mNetwork.n("appName", this.fPm.getShareAppName());
                    this.mNetwork.n("signKey", this.fPm.getShareSignKey());
                    this.mNetwork.n("summary_title", this.fPm.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.fPm.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.fPm.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fPm.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fPm.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fPm.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.fPm.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.fPm.getForumId());
                    this.mNetwork.n("kw", this.fPm.getForumName());
                    this.mNetwork.n("can_no_forum", this.fPm.isCanNoForum() ? "1" : "0");
                    this.mNetwork.n("is_feedback", this.fPm.isUserFeedback() ? "1" : "0");
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fPm.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fPm.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fPm.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fPm.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fPm.getGraffitiWriteCode();
                    }
                    if (this.fPm.getType() == 6 && this.fPm.getVoteInfo() != null) {
                        if (this.fPm.getWriteImagesInfo() != null) {
                            this.fPm.getVoteInfo().setServerImageCode(this.fPm.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fPm.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n("content", str);
                    e.a(this.mNetwork, this.fPm);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fPm.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.uJ().vD().mIsNeedTbs = true;
                    if (this.fPm.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.fPm.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.fPm.getVoiceDuringTime()));
                    }
                    if (this.fPm.getType() == 0 || this.fPm.getType() == 7) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        if (this.fPm.getType() == 0) {
                            this.mNetwork.n("transform_forums", this.fPm.getTransmitForumData());
                            this.mNetwork.n(IntentConfig.CALL_FROM, this.fPm.getCallFrom());
                            if (this.fPm.getRecommendExt() != null) {
                                this.mNetwork.n("recommend_ext", this.fPm.getRecommendExt());
                            }
                        }
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fPm.getTitle());
                        this.mNetwork.n("is_ntitle", this.fPm.isNoTitle() ? "1" : "0");
                        if (this.fPm.getType() == 7) {
                            this.mNetwork.n("is_bottle", String.valueOf(1));
                        }
                        if (this.fPm.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.fPm.getCategoryFrom()));
                        }
                        if (this.fPm.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.fPm.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.fg().C(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(C.getLatitude())) + "," + String.valueOf(C.getLongitude()));
                        }
                    } else if (this.fPm.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fPm.getTitle());
                        this.mNetwork.n("is_ntitle", this.fPm.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.fPm.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fPm.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.fPm.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fPm.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.fPm.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.fPm.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.fPm.isAddition() ? "1" : "0");
                            if (this.fPm.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.fPm.getRepostId());
                            }
                            this.mNetwork.n("v_fid", this.fPm.getVForumId());
                            this.mNetwork.n("v_fname", this.fPm.getVForumName());
                        } else if (this.fPm.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fPm.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.fPm.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.fPm.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.CO().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                            this.mNetwork.n("v_fid", this.fPm.getVForumId());
                            this.mNetwork.n("v_fname", this.fPm.getVForumName());
                        }
                    }
                }
                this.mRetData = this.mNetwork.ul();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fPj = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[Catch: JSONException -> 0x0162, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0162, blocks: (B:30:0x00b2, B:32:0x00d3), top: B:80:0x00b2 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0281  */
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
            VcodeActivity.this.fPj = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.uJ().vE().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.fPi);
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
                                        if (this.fPm.getType() != 3) {
                                            e.c(VcodeActivity.this.getActivity(), str6, str7, str8);
                                        }
                                        this.fPm.deleteUploadedTempImages();
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
                        if (this.fPm.getType() != 3 && this.fPm.getType() != 7 && (this.fPm.getType() != 0 || this.fPm.isUserFeedback())) {
                            e.c(VcodeActivity.this.getActivity(), str6, str7, str8);
                        }
                        this.fPm.deleteUploadedTempImages();
                    } else if (this.fPm.isHasImages() && j.isEmpty(String.valueOf(this.fPm.getContent()) + this.fPm.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                    } else if (this.fPm.getType() != 3) {
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
                } else if (this.fPm.isHasImages() && j.isEmpty(String.valueOf(this.fPm.getContent()) + this.fPm.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                } else {
                    if (this.mNetwork.uN() == 5 || this.mNetwork.uN() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null && VcodeActivity.this.fPi != null) {
                            VcodeActivity.this.fPi.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fPi.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.ra(VcodeActivity.this.fPi.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.fPm != null && this.mNetwork.uN() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.uN(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fPm, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.uN() != 227001) {
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
            VcodeActivity.this.fPk = null;
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
            if (VcodeActivity.this.fPi == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.fPi.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.fPi.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fPi.getTitle());
                this.mNetWork.n("content", VcodeActivity.this.fPi.getContent());
                if (VcodeActivity.this.fPi.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.fPi.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.fPi.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fPi.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.fPi.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.fPi.getThreadId());
                }
                String ul = this.mNetWork.ul();
                if (!this.mNetWork.uJ().vE().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(ul);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.um());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fPk = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.fPi != null) {
                VcodeActivity.this.fPi.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.fPi.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
