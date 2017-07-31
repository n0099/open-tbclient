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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData gDl = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b gDm = null;
    private a gDn = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private RelativeLayout mParent = null;
    private TextView mInfo = null;
    protected NavigationBar mNavigationBar = null;
    private boolean gzL = false;
    private final View.OnClickListener onBackListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener onPostListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.mEdit);
            VcodeActivity.this.showDialog();
            if (VcodeActivity.this.gDm != null) {
                VcodeActivity.this.gDm.cancel();
            }
            VcodeActivity.this.gzL = false;
            VcodeActivity.this.gDm = new b(VcodeActivity.this.gDl);
            VcodeActivity.this.gDm.setPriority(3);
            VcodeActivity.this.gDm.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.vcode_activity);
        initUI();
        initData(bundle);
        if (this.gDl != null) {
            sY(this.gDl.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.gDm != null) {
                    VcodeActivity.this.gDm.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.gDl = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.gDl = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gDl != null && this.gDl.getType() == 3) {
            if (this.gDm != null) {
                this.gDm.cancel();
            }
            if (this.gDn != null) {
                this.gDn.cancel();
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
        if (this.gDl != null && this.gDl.getIsStory() == 1) {
            br brVar = new br();
            brVar.abm = this.gDl;
            brVar.abp = this.gzL;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, brVar));
        }
        if (this.gDm != null) {
            this.gDm.cancel();
        }
        if (this.gDn != null) {
            this.gDn.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.gDl));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        ai.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.j(this.mPost, d.g.s_navbar_button_bg);
        ai.i(this.mPost, d.e.cp_cont_g);
        if (i == 1) {
            i2 = ai.cP(i);
        } else {
            i2 = -12895429;
        }
        this.mInfo.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(d.l.sending), true, false, this.mDialogCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mInfo = (TextView) findViewById(d.h.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.l.send), this.onPostListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(d.h.input);
        this.mImage = (ImageView) findViewById(d.h.vcode_image);
        this.mImage.setImageDrawable(null);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.sY(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(d.h.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(String str) {
        if (this.gDn != null) {
            this.gDn.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.gDn = new a();
        this.gDn.setPriority(3);
        this.gDn.execute(str);
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData gDp;
        private w mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.gDp = null;
            this.gDp = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.gDp == null) {
                return null;
            }
            this.mNetwork = new w();
            String obj = VcodeActivity.this.mEdit.getText().toString();
            String imagesCodeForPost = this.gDp.getImagesCodeForPost();
            if (this.gDp.getType() == 3) {
                this.mNetwork.n("newVcode", "1");
                this.mNetwork.n("content", this.gDp.getContent() + imagesCodeForPost);
                this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.gDp.getVcodeMD5());
                if (obj.length() > 0) {
                    this.mNetwork.n("vcode", obj);
                }
                this.mNetwork.n("tag", "11");
                this.mNetwork.vl().wh().mIsNeedTbs = true;
                this.mNetwork.n("content", this.gDp.getContent() + imagesCodeForPost);
                this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.giK);
                this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.gDp.getForumName());
                this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gDp.getTitle());
                this.mNetwork.n("apiKey", this.gDp.getShareApiKey());
                this.mNetwork.n("appName", this.gDp.getShareAppName());
                this.mNetwork.n("signKey", this.gDp.getShareSignKey());
                this.mNetwork.n("summary_title", this.gDp.getShareSummaryTitle());
                this.mNetwork.n("summary_content", this.gDp.getShareSummaryContent());
                this.mNetwork.n("summary_img", this.gDp.getShareSummaryImg());
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.gDp.getShareSummaryImgWidth()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.gDp.getShareSummaryImgHeight()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.gDp.getShareSummaryImgType());
                this.mNetwork.n("referUrl", this.gDp.getShareReferUrl());
            } else {
                this.mNetwork.n("anonymous", "0");
                this.mNetwork.n("fid", this.gDp.getForumId());
                this.mNetwork.n("kw", this.gDp.getForumName());
                this.mNetwork.n("can_no_forum", this.gDp.isCanNoForum() ? "1" : "0");
                this.mNetwork.n("is_feedback", this.gDp.isUserFeedback() ? "1" : "0");
                this.mNetwork.n("new_vcode", "1");
                VideoInfo videoInfo = this.gDp.getVideoInfo();
                if (videoInfo == null || !videoInfo.hasUpload()) {
                    str = this.gDp.getContent() + imagesCodeForPost;
                } else {
                    str = this.gDp.getContent() + videoInfo.buildContent() + imagesCodeForPost;
                }
                if (!StringUtils.isNull(this.gDp.getGraffitiWriteCode())) {
                    str = str + this.gDp.getGraffitiWriteCode();
                }
                if (this.gDp.getType() == 6 && this.gDp.getVoteInfo() != null) {
                    if (this.gDp.getWriteImagesInfo() != null) {
                        this.gDp.getVoteInfo().setServerImageCode(this.gDp.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.gDp.getVoteInfo().buildWriteContent();
                }
                this.mNetwork.n("content", str);
                c.a(this.mNetwork, this.gDp);
                this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.gDp.getVcodeMD5());
                if (obj.length() > 0) {
                    this.mNetwork.n("vcode", obj);
                }
                this.mNetwork.vl().wh().mIsNeedTbs = true;
                if (this.gDp.getVoice() != null) {
                    this.mNetwork.n("voice_md5", this.gDp.getVoice());
                    this.mNetwork.n("during_time", String.valueOf(this.gDp.getVoiceDuringTime()));
                }
                if (this.gDp.getType() == 0 || this.gDp.getType() == 9 || this.gDp.getType() == 7) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    if (this.gDp.getType() == 0 || this.gDp.getType() == 9) {
                        this.mNetwork.n("transform_forums", this.gDp.getTransmitForumData());
                        this.mNetwork.n(IntentConfig.CALL_FROM, this.gDp.getCallFrom());
                        if (this.gDp.getRecommendExt() != null) {
                            this.mNetwork.n("recommend_ext", this.gDp.getRecommendExt());
                        }
                    }
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gDp.getTitle());
                    this.mNetwork.n("is_ntitle", this.gDp.isNoTitle() ? "1" : "0");
                    if (this.gDp.getType() == 7) {
                        this.mNetwork.n("is_bottle", String.valueOf(1));
                    }
                    if (this.gDp.getCategoryFrom() >= 0) {
                        this.mNetwork.n("fromCategoryId", String.valueOf(this.gDp.getCategoryFrom()));
                    }
                    if (this.gDp.getCategoryTo() >= 0) {
                        this.mNetwork.n("toCategoryId", String.valueOf(this.gDp.getCategoryTo()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.fo().C(false)) != null) {
                        this.mNetwork.n("lbs", String.valueOf(C.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(C.getLongitude()));
                    }
                    if (VcodeActivity.this.gDl.getIsStory() == 1) {
                        this.mNetwork.n("is_story", "1");
                    }
                } else if (this.gDp.getType() == 6) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gDp.getTitle());
                    this.mNetwork.n("is_ntitle", this.gDp.isNoTitle() ? "1" : "0");
                    this.mNetwork.n("thread_type", String.valueOf(36));
                } else if (this.gDp.getType() == 4) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gDp.getTitle());
                    this.mNetwork.n("is_ntitle", "0");
                    this.mNetwork.n("thread_type", String.valueOf(33));
                    this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                    this.mNetwork.n("tid", this.gDp.getThreadId());
                    this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.gDp.getType() == 2) {
                        this.mNetwork.n("quote_id", String.valueOf(this.gDp.getFloor()));
                        this.mNetwork.n("floor_num", String.valueOf(this.gDp.getFloorNum()));
                        this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.gDp.isAddition() ? "1" : "0");
                        if (this.gDp.getRepostId() != null) {
                            this.mNetwork.n("repostid", this.gDp.getRepostId());
                        }
                        this.mNetwork.n("v_fid", this.gDp.getVForumId());
                        this.mNetwork.n("v_fname", this.gDp.getVForumName());
                    } else if (this.gDp.getType() == 5) {
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.gDp.getType() == 1) {
                        this.mNetwork.n("is_barrage", this.gDp.isBarrage() ? "1" : "0");
                        this.mNetwork.n("barrage_time", String.valueOf(this.gDp.getBarrageTime()));
                        if (com.baidu.tbadk.editortools.pb.a.Dw().getStatus() == 1) {
                            this.mNetwork.n("ptype", "4");
                        }
                        this.mNetwork.n("v_fid", this.gDp.getVForumId());
                        this.mNetwork.n("v_fname", this.gDp.getVForumName());
                    }
                }
            }
            this.mRetData = this.mNetwork.uO();
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gDm = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00eb A[Catch: JSONException -> 0x019a, TRY_LEAVE, TryCatch #1 {JSONException -> 0x019a, blocks: (B:30:0x00c2, B:32:0x00eb), top: B:92:0x00c2 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02c4  */
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
            JSONException jSONException;
            String str6;
            String str7;
            String str8;
            String str9;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.gDm = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.gzL = true;
                        com.baidu.tieba.graffiti.b.b(VcodeActivity.this.gDl);
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str8 = jSONObject.optString(AddFriendActivityConfig.MSG);
                            try {
                                JSONObject optJSONObject = jSONObject.optJSONObject("exp");
                                if (optJSONObject != null) {
                                    str6 = optJSONObject.optString("pre_msg");
                                    if (StringUtils.isNull(str6)) {
                                        str6 = null;
                                    }
                                    try {
                                        str9 = optJSONObject.optString("color_msg");
                                        if (StringUtils.isNull(str9)) {
                                            str9 = null;
                                        }
                                    } catch (JSONException e) {
                                        str7 = str8;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        str8 = str7;
                                        str9 = null;
                                        if (StringUtils.isNull(str8)) {
                                            str8 = TbadkCoreApplication.getInst().getString(d.l.send_success);
                                        }
                                        if (this.gDp.getType() != 3) {
                                            c.c(VcodeActivity.this.getActivity(), str8, str6, str9);
                                        }
                                        this.gDp.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        str4 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.mRetData);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString(Info.kBaiduPIDKey);
                                        str3 = jSONObject2.optString(AddFriendActivityConfig.MSG);
                                        str4 = com.baidu.tieba.pb.c.H(jSONObject2);
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("twzhibo_info");
                                        if (optJSONObject2 == null) {
                                        }
                                        str5 = str;
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
                                    str9 = null;
                                    str6 = null;
                                }
                            } catch (JSONException e2) {
                                str6 = null;
                                str7 = str8;
                                jSONException = e2;
                            }
                        } catch (JSONException e3) {
                            jSONException = e3;
                            str6 = null;
                            str7 = null;
                        }
                        if (StringUtils.isNull(str8) && this.gDp.getIsStory() != 1) {
                            str8 = TbadkCoreApplication.getInst().getString(d.l.send_success);
                        }
                        if (this.gDp.getType() != 3 && this.gDp.getType() != 7 && this.gDp.getIsStory() != 1) {
                            c.c(VcodeActivity.this.getActivity(), str8, str6, str9);
                        }
                        this.gDp.deleteUploadedTempImages();
                    } else if (this.gDp.isHasImages() && j.isEmpty(this.gDp.getContent() + this.gDp.getImagesCodeForPost())) {
                        if (this.gDp.getIsStory() != 1) {
                            VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.l.img_upload_error));
                        }
                    } else if (this.gDp.getType() != 3 && this.gDp.getIsStory() != 1) {
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
                        str4 = com.baidu.tieba.pb.c.H(jSONObject22);
                        JSONObject optJSONObject22 = jSONObject22.optJSONObject("twzhibo_info");
                        i = optJSONObject22 == null ? optJSONObject22.optInt("is_copytwzhibo", 0) : 0;
                        str5 = str;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        str5 = str;
                        str2 = str2;
                        str3 = str3;
                        str4 = str4;
                        i = 0;
                    }
                    postWriteCallBackData2.setThreadId(str5);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str3);
                    postWriteCallBackData2.setNickNameActivityMoney(str4);
                    if (!TextUtils.isEmpty(str4)) {
                        com.baidu.tieba.pb.c.Q(2000, str4);
                    }
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData2);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    VcodeActivity.this.finish();
                } else if (this.gDp.isHasImages() && j.isEmpty(this.gDp.getContent() + this.gDp.getImagesCodeForPost())) {
                    if (this.gDp.getIsStory() != 1) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.l.img_upload_error));
                    }
                } else {
                    if (this.mNetwork.vp() == 5 || this.mNetwork.vp() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null && VcodeActivity.this.gDl != null) {
                            VcodeActivity.this.gDl.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.gDl.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.sY(VcodeActivity.this.gDl.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.gDp != null && this.mNetwork.vp() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.vp(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.gDp, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.vp() != 227001) {
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
        volatile w mNetWork;

        private a() {
            this.mNetWork = null;
            this.mInfoData = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gDn = null;
            if (this.mNetWork != null) {
                this.mNetWork.fA();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.gDl == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new w(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.gDl.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.gDl.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.gDl.getTitle());
                this.mNetWork.n("content", VcodeActivity.this.gDl.getContent());
                if (VcodeActivity.this.gDl.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.gDl.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.gDl.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.gDl.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.gDl.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.gDl.getThreadId());
                }
                String uO = this.mNetWork.uO();
                if (!this.mNetWork.vl().wi().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(uO);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new w(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.uf());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.gDn = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.gDl != null) {
                VcodeActivity.this.gDl.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.gDl.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
