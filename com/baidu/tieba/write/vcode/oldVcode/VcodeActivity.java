package com.baidu.tieba.write.vcode.oldVcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.e;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData gie = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b gif = null;
    private a gig = null;
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
        if (this.gie != null) {
            sn(this.gie.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.gie = (WriteData) bundle.getSerializable("model");
        } else {
            this.gie = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gie != null && this.gie.getType() == 3) {
            if (this.gif != null) {
                this.gif.cancel();
            }
            if (this.gig != null) {
                this.gig.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gif != null) {
            this.gif.cancel();
        }
        if (this.gig != null) {
            this.gig.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.gie);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        as.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        as.j(this.mPost, w.g.s_navbar_button_bg);
        as.i(this.mPost, w.e.cp_cont_g);
        if (i == 1) {
            i2 = as.cL(i);
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
    public void sn(String str) {
        if (this.gig != null) {
            this.gig.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.gig = new a(this, null);
        this.gig.setPriority(3);
        this.gig.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData gii;
        private ab mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.gii = null;
            this.gii = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.gii != null) {
                this.mNetwork = new ab();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.gii.getImagesCodeForPost();
                if (this.gii.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n("content", String.valueOf(this.gii.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.gii.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.uV().vR().mIsNeedTbs = true;
                    this.mNetwork.n("content", String.valueOf(this.gii.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fNa);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.gii.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gii.getTitle());
                    this.mNetwork.n("apiKey", this.gii.getShareApiKey());
                    this.mNetwork.n("appName", this.gii.getShareAppName());
                    this.mNetwork.n("signKey", this.gii.getShareSignKey());
                    this.mNetwork.n("summary_title", this.gii.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.gii.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.gii.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.gii.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.gii.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.gii.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.gii.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.gii.getForumId());
                    this.mNetwork.n("kw", this.gii.getForumName());
                    this.mNetwork.n("can_no_forum", this.gii.isCanNoForum() ? "1" : "0");
                    this.mNetwork.n("is_feedback", this.gii.isUserFeedback() ? "1" : "0");
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.gii.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.gii.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.gii.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.gii.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.gii.getGraffitiWriteCode();
                    }
                    if (this.gii.getType() == 6 && this.gii.getVoteInfo() != null) {
                        if (this.gii.getWriteImagesInfo() != null) {
                            this.gii.getVoteInfo().setServerImageCode(this.gii.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.gii.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n("content", str);
                    e.a(this.mNetwork, this.gii);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.gii.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.uV().vR().mIsNeedTbs = true;
                    if (this.gii.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.gii.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.gii.getVoiceDuringTime()));
                    }
                    if (this.gii.getType() == 0 || this.gii.getType() == 7) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        if (this.gii.getType() == 0) {
                            this.mNetwork.n("transform_forums", this.gii.getTransmitForumData());
                            this.mNetwork.n(IntentConfig.CALL_FROM, this.gii.getCallFrom());
                            if (this.gii.getRecommendExt() != null) {
                                this.mNetwork.n("recommend_ext", this.gii.getRecommendExt());
                            }
                        }
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gii.getTitle());
                        this.mNetwork.n("is_ntitle", this.gii.isNoTitle() ? "1" : "0");
                        if (this.gii.getType() == 7) {
                            this.mNetwork.n("is_bottle", String.valueOf(1));
                        }
                        if (this.gii.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.gii.getCategoryFrom()));
                        }
                        if (this.gii.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.gii.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.ff().C(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(C.getLatitude())) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(C.getLongitude()));
                        }
                    } else if (this.gii.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gii.getTitle());
                        this.mNetwork.n("is_ntitle", this.gii.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.gii.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gii.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.gii.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.gii.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.gii.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.gii.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.gii.isAddition() ? "1" : "0");
                            if (this.gii.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.gii.getRepostId());
                            }
                            this.mNetwork.n("v_fid", this.gii.getVForumId());
                            this.mNetwork.n("v_fname", this.gii.getVForumName());
                        } else if (this.gii.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.gii.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.gii.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.gii.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.Dc().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                            this.mNetwork.n("v_fid", this.gii.getVForumId());
                            this.mNetwork.n("v_fname", this.gii.getVForumName());
                        }
                    }
                }
                this.mRetData = this.mNetwork.uy();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gif = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fr();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cb A[Catch: JSONException -> 0x0169, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0169, blocks: (B:26:0x00a4, B:28:0x00cb), top: B:82:0x00a4 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x028b  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(q qVar) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            JSONObject optJSONObject;
            JSONException jSONException;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.gif = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.uV().vS().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.gie);
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str8 = jSONObject.optString(AddFriendActivityConfig.MSG);
                            try {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                if (optJSONObject2 != null) {
                                    str9 = optJSONObject2.optString("pre_msg");
                                    if (StringUtils.isNull(str9)) {
                                        str9 = null;
                                    }
                                    try {
                                        str10 = optJSONObject2.optString("color_msg");
                                        if (StringUtils.isNull(str10)) {
                                            str10 = null;
                                        }
                                    } catch (JSONException e) {
                                        str7 = str9;
                                        str6 = str8;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        str8 = str6;
                                        str9 = str7;
                                        str10 = null;
                                        if (StringUtils.isNull(str8)) {
                                        }
                                        if (this.gii.getType() != 3) {
                                            e.c(VcodeActivity.this.getActivity(), str8, str9, str10);
                                        }
                                        this.gii.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        str4 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.mRetData);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString(Info.kBaiduPIDKey);
                                        str3 = jSONObject2.optString(AddFriendActivityConfig.MSG);
                                        str4 = com.baidu.tieba.pb.d.G(jSONObject2);
                                        optJSONObject = jSONObject2.optJSONObject("twzhibo_info");
                                        if (optJSONObject == null) {
                                        }
                                        postWriteCallBackData.setThreadId(str5);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        postWriteCallBackData.setNickNameActivityMoney(str4);
                                        if (!TextUtils.isEmpty(str4)) {
                                        }
                                        Intent intent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                                        intent.putExtras(bundle);
                                        VcodeActivity.this.setResult(-1, intent);
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(qVar);
                                    }
                                } else {
                                    str10 = null;
                                    str9 = null;
                                }
                            } catch (JSONException e2) {
                                str6 = str8;
                                jSONException = e2;
                                str7 = null;
                            }
                        } catch (JSONException e3) {
                            jSONException = e3;
                            str6 = null;
                            str7 = null;
                        }
                        if (StringUtils.isNull(str8)) {
                            str8 = TbadkCoreApplication.m9getInst().getString(w.l.send_success);
                        }
                        if (this.gii.getType() != 3 && this.gii.getType() != 7) {
                            e.c(VcodeActivity.this.getActivity(), str8, str9, str10);
                        }
                        this.gii.deleteUploadedTempImages();
                    } else if (this.gii.isHasImages() && j.isEmpty(String.valueOf(this.gii.getContent()) + this.gii.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                    } else if (this.gii.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    str4 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.mRetData);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString(Info.kBaiduPIDKey);
                        str3 = jSONObject22.optString(AddFriendActivityConfig.MSG);
                        str4 = com.baidu.tieba.pb.d.G(jSONObject22);
                        optJSONObject = jSONObject22.optJSONObject("twzhibo_info");
                        if (optJSONObject == null) {
                            i = optJSONObject.optInt("is_copytwzhibo", 0);
                            str5 = str;
                        } else {
                            i = 0;
                            str5 = str;
                        }
                    } catch (JSONException e4) {
                        String str11 = str4;
                        e4.printStackTrace();
                        str5 = str;
                        str2 = str2;
                        str3 = str3;
                        str4 = str11;
                        i = 0;
                    }
                    postWriteCallBackData2.setThreadId(str5);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str3);
                    postWriteCallBackData2.setNickNameActivityMoney(str4);
                    if (!TextUtils.isEmpty(str4)) {
                        com.baidu.tieba.pb.d.O(2000, str4);
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData2);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    VcodeActivity.this.finish();
                } else if (this.gii.isHasImages() && j.isEmpty(String.valueOf(this.gii.getContent()) + this.gii.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                } else {
                    if (this.mNetwork.uZ() == 5 || this.mNetwork.uZ() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null && VcodeActivity.this.gie != null) {
                            VcodeActivity.this.gie.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.gie.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.sn(VcodeActivity.this.gie.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.gii != null && this.mNetwork.uZ() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.uZ(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.gii, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.uZ() != 227001) {
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
        volatile ab mNetWork;

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
            VcodeActivity.this.gig = null;
            if (this.mNetWork != null) {
                this.mNetWork.fr();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.gie == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.gie.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.gie.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.gie.getTitle());
                this.mNetWork.n("content", VcodeActivity.this.gie.getContent());
                if (VcodeActivity.this.gie.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.gie.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.gie.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.gie.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.gie.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.gie.getThreadId());
                }
                String uy = this.mNetWork.uy();
                if (!this.mNetWork.uV().vS().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(uy);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new ab(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.tP());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.gig = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.gie != null) {
                VcodeActivity.this.gie.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.gie.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
