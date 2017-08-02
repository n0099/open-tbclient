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
import com.baidu.tieba.pb.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData gCa = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b gCb = null;
    private a gCc = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private RelativeLayout mParent = null;
    private TextView mInfo = null;
    protected NavigationBar mNavigationBar = null;
    private boolean gyA = false;
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
            if (VcodeActivity.this.gCb != null) {
                VcodeActivity.this.gCb.cancel();
            }
            VcodeActivity.this.gyA = false;
            VcodeActivity.this.gCb = new b(VcodeActivity.this.gCa);
            VcodeActivity.this.gCb.setPriority(3);
            VcodeActivity.this.gCb.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.vcode_activity);
        initUI();
        initData(bundle);
        if (this.gCa != null) {
            sT(this.gCa.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.gCb != null) {
                    VcodeActivity.this.gCb.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.gCa = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.gCa = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gCa != null && this.gCa.getType() == 3) {
            if (this.gCb != null) {
                this.gCb.cancel();
            }
            if (this.gCc != null) {
                this.gCc.cancel();
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
        if (this.gCa != null && this.gCa.getIsStory() == 1) {
            br brVar = new br();
            brVar.ZQ = this.gCa;
            brVar.ZT = this.gyA;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_VCODE_CHECK_INFO, brVar));
        }
        if (this.gCb != null) {
            this.gCb.cancel();
        }
        if (this.gCc != null) {
            this.gCc.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.gCa));
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
            i2 = ai.cN(i);
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
                VcodeActivity.this.sT(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(d.h.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT(String str) {
        if (this.gCc != null) {
            this.gCc.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.gCc = new a();
        this.gCc.setPriority(3);
        this.gCc.execute(str);
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData gCe;
        private w mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.gCe = null;
            this.gCe = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.gCe == null) {
                return null;
            }
            this.mNetwork = new w();
            String obj = VcodeActivity.this.mEdit.getText().toString();
            String imagesCodeForPost = this.gCe.getImagesCodeForPost();
            if (this.gCe.getType() == 3) {
                this.mNetwork.n("newVcode", "1");
                this.mNetwork.n("content", this.gCe.getContent() + imagesCodeForPost);
                this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.gCe.getVcodeMD5());
                if (obj.length() > 0) {
                    this.mNetwork.n("vcode", obj);
                }
                this.mNetwork.n("tag", "11");
                this.mNetwork.vb().vX().mIsNeedTbs = true;
                this.mNetwork.n("content", this.gCe.getContent() + imagesCodeForPost);
                this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.ghy);
                this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.gCe.getForumName());
                this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gCe.getTitle());
                this.mNetwork.n("apiKey", this.gCe.getShareApiKey());
                this.mNetwork.n("appName", this.gCe.getShareAppName());
                this.mNetwork.n("signKey", this.gCe.getShareSignKey());
                this.mNetwork.n("summary_title", this.gCe.getShareSummaryTitle());
                this.mNetwork.n("summary_content", this.gCe.getShareSummaryContent());
                this.mNetwork.n("summary_img", this.gCe.getShareSummaryImg());
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.gCe.getShareSummaryImgWidth()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.gCe.getShareSummaryImgHeight()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.gCe.getShareSummaryImgType());
                this.mNetwork.n("referUrl", this.gCe.getShareReferUrl());
            } else {
                this.mNetwork.n("anonymous", "0");
                this.mNetwork.n("fid", this.gCe.getForumId());
                this.mNetwork.n("kw", this.gCe.getForumName());
                this.mNetwork.n("can_no_forum", this.gCe.isCanNoForum() ? "1" : "0");
                this.mNetwork.n("is_feedback", this.gCe.isUserFeedback() ? "1" : "0");
                this.mNetwork.n("new_vcode", "1");
                VideoInfo videoInfo = this.gCe.getVideoInfo();
                if (videoInfo == null || !videoInfo.hasUpload()) {
                    str = this.gCe.getContent() + imagesCodeForPost;
                } else {
                    str = this.gCe.getContent() + videoInfo.buildContent() + imagesCodeForPost;
                }
                if (!StringUtils.isNull(this.gCe.getGraffitiWriteCode())) {
                    str = str + this.gCe.getGraffitiWriteCode();
                }
                if (this.gCe.getType() == 6 && this.gCe.getVoteInfo() != null) {
                    if (this.gCe.getWriteImagesInfo() != null) {
                        this.gCe.getVoteInfo().setServerImageCode(this.gCe.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.gCe.getVoteInfo().buildWriteContent();
                }
                this.mNetwork.n("content", str);
                c.a(this.mNetwork, this.gCe);
                this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.gCe.getVcodeMD5());
                if (obj.length() > 0) {
                    this.mNetwork.n("vcode", obj);
                }
                this.mNetwork.vb().vX().mIsNeedTbs = true;
                if (this.gCe.getVoice() != null) {
                    this.mNetwork.n("voice_md5", this.gCe.getVoice());
                    this.mNetwork.n("during_time", String.valueOf(this.gCe.getVoiceDuringTime()));
                }
                if (this.gCe.getType() == 0 || this.gCe.getType() == 9 || this.gCe.getType() == 7) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    if (this.gCe.getType() == 0 || this.gCe.getType() == 9) {
                        this.mNetwork.n("transform_forums", this.gCe.getTransmitForumData());
                        this.mNetwork.n(IntentConfig.CALL_FROM, this.gCe.getCallFrom());
                        if (this.gCe.getRecommendExt() != null) {
                            this.mNetwork.n("recommend_ext", this.gCe.getRecommendExt());
                        }
                    }
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gCe.getTitle());
                    this.mNetwork.n("is_ntitle", this.gCe.isNoTitle() ? "1" : "0");
                    if (this.gCe.getType() == 7) {
                        this.mNetwork.n("is_bottle", String.valueOf(1));
                    }
                    if (this.gCe.getCategoryFrom() >= 0) {
                        this.mNetwork.n("fromCategoryId", String.valueOf(this.gCe.getCategoryFrom()));
                    }
                    if (this.gCe.getCategoryTo() >= 0) {
                        this.mNetwork.n("toCategoryId", String.valueOf(this.gCe.getCategoryTo()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.fd().C(false)) != null) {
                        this.mNetwork.n("lbs", String.valueOf(C.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(C.getLongitude()));
                    }
                    if (VcodeActivity.this.gCa.getIsStory() == 1) {
                        this.mNetwork.n("is_story", "1");
                    }
                } else if (this.gCe.getType() == 6) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gCe.getTitle());
                    this.mNetwork.n("is_ntitle", this.gCe.isNoTitle() ? "1" : "0");
                    this.mNetwork.n("thread_type", String.valueOf(36));
                } else if (this.gCe.getType() == 4) {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.gCe.getTitle());
                    this.mNetwork.n("is_ntitle", "0");
                    this.mNetwork.n("thread_type", String.valueOf(33));
                    this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                    this.mNetwork.n("tid", this.gCe.getThreadId());
                    this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.gCe.getType() == 2) {
                        this.mNetwork.n("quote_id", String.valueOf(this.gCe.getFloor()));
                        this.mNetwork.n("floor_num", String.valueOf(this.gCe.getFloorNum()));
                        this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.gCe.isAddition() ? "1" : "0");
                        if (this.gCe.getRepostId() != null) {
                            this.mNetwork.n("repostid", this.gCe.getRepostId());
                        }
                        this.mNetwork.n("v_fid", this.gCe.getVForumId());
                        this.mNetwork.n("v_fname", this.gCe.getVForumName());
                    } else if (this.gCe.getType() == 5) {
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else if (this.gCe.getType() == 1) {
                        this.mNetwork.n("is_barrage", this.gCe.isBarrage() ? "1" : "0");
                        this.mNetwork.n("barrage_time", String.valueOf(this.gCe.getBarrageTime()));
                        if (com.baidu.tbadk.editortools.pb.a.Do().getStatus() == 1) {
                            this.mNetwork.n("ptype", "4");
                        }
                        this.mNetwork.n("v_fid", this.gCe.getVForumId());
                        this.mNetwork.n("v_fname", this.gCe.getVForumName());
                    }
                }
            }
            this.mRetData = this.mNetwork.uE();
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.gCb = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e8 A[Catch: JSONException -> 0x02b0, TRY_LEAVE, TryCatch #3 {JSONException -> 0x02b0, blocks: (B:31:0x00df, B:33:0x00e8), top: B:100:0x00df }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x02c6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(q qVar) {
            String str;
            String str2;
            String str3;
            CustomDialogData customDialogData;
            String str4;
            String str5;
            String str6;
            JSONException jSONException;
            String str7;
            CustomDialogData customDialogData2;
            int i;
            JSONException jSONException2;
            String str8;
            String str9;
            String str10;
            String str11;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.gCb = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.vb().vY().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.gyA = true;
                        com.baidu.tieba.graffiti.b.b(VcodeActivity.this.gCa);
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str10 = jSONObject.optString(AddFriendActivityConfig.MSG);
                            try {
                                JSONObject optJSONObject = jSONObject.optJSONObject("exp");
                                if (optJSONObject != null) {
                                    str8 = optJSONObject.optString("pre_msg");
                                    if (StringUtils.isNull(str8)) {
                                        str8 = null;
                                    }
                                    try {
                                        str11 = optJSONObject.optString("color_msg");
                                        if (StringUtils.isNull(str11)) {
                                            str11 = null;
                                        }
                                    } catch (JSONException e) {
                                        str9 = str10;
                                        jSONException2 = e;
                                        jSONException2.printStackTrace();
                                        str10 = str9;
                                        str11 = null;
                                        if (StringUtils.isNull(str10)) {
                                            str10 = TbadkCoreApplication.getInst().getString(d.l.send_success);
                                        }
                                        if (this.gCe.getType() != 3) {
                                            c.c(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.gCe.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.mRetData);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString(Info.kBaiduPIDKey);
                                        str3 = jSONObject2.optString(AddFriendActivityConfig.MSG);
                                        customDialogData2 = com.baidu.tieba.pb.c.H(jSONObject2);
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("twzhibo_info");
                                        if (optJSONObject2 == null) {
                                        }
                                        str7 = str;
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        postWriteCallBackData.setActivityDialog(customDialogData2);
                                        if (customDialogData2 != null) {
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
                                    str11 = null;
                                    str8 = null;
                                }
                            } catch (JSONException e2) {
                                str8 = null;
                                str9 = str10;
                                jSONException2 = e2;
                            }
                        } catch (JSONException e3) {
                            jSONException2 = e3;
                            str8 = null;
                            str9 = null;
                        }
                        if (StringUtils.isNull(str10) && this.gCe.getIsStory() != 1) {
                            str10 = TbadkCoreApplication.getInst().getString(d.l.send_success);
                        }
                        if (this.gCe.getType() != 3 && this.gCe.getType() != 7 && this.gCe.getIsStory() != 1) {
                            c.c(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.gCe.deleteUploadedTempImages();
                    } else if (this.gCe.isHasImages() && j.isEmpty(this.gCe.getContent() + this.gCe.getImagesCodeForPost())) {
                        if (this.gCe.getIsStory() != 1) {
                            VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.l.img_upload_error));
                        }
                    } else if (this.gCe.getType() != 3 && this.gCe.getIsStory() != 1) {
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
                        customDialogData2 = com.baidu.tieba.pb.c.H(jSONObject22);
                    } catch (JSONException e4) {
                        customDialogData = null;
                        str4 = str3;
                        str5 = str2;
                        str6 = str;
                        jSONException = e4;
                    }
                    try {
                        JSONObject optJSONObject22 = jSONObject22.optJSONObject("twzhibo_info");
                        i = optJSONObject22 == null ? optJSONObject22.optInt("is_copytwzhibo", 0) : 0;
                        str7 = str;
                    } catch (JSONException e5) {
                        customDialogData = customDialogData2;
                        str4 = str3;
                        str5 = str2;
                        str6 = str;
                        jSONException = e5;
                        jSONException.printStackTrace();
                        str7 = str6;
                        str2 = str5;
                        str3 = str4;
                        customDialogData2 = customDialogData;
                        i = 0;
                        postWriteCallBackData2.setThreadId(str7);
                        postWriteCallBackData2.setPostId(str2);
                        postWriteCallBackData2.setIsCopyTWZhibo(i);
                        postWriteCallBackData2.setErrorString(str3);
                        postWriteCallBackData2.setActivityDialog(customDialogData2);
                        if (customDialogData2 != null) {
                        }
                        Intent intent2 = new Intent();
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData2);
                        intent2.putExtras(bundle2);
                        VcodeActivity.this.setResult(-1, intent2);
                        VcodeActivity.this.finish();
                        super.onPostExecute(qVar);
                    }
                    postWriteCallBackData2.setThreadId(str7);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str3);
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        com.baidu.tieba.pb.c.a(2000, customDialogData2);
                    }
                    Intent intent22 = new Intent();
                    Bundle bundle22 = new Bundle();
                    bundle22.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData2);
                    intent22.putExtras(bundle22);
                    VcodeActivity.this.setResult(-1, intent22);
                    VcodeActivity.this.finish();
                } else if (this.gCe.isHasImages() && j.isEmpty(this.gCe.getContent() + this.gCe.getImagesCodeForPost())) {
                    if (this.gCe.getIsStory() != 1) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.l.img_upload_error));
                    }
                } else {
                    if (this.mNetwork.vf() == 5 || this.mNetwork.vf() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null && VcodeActivity.this.gCa != null) {
                            VcodeActivity.this.gCa.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.gCa.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.sT(VcodeActivity.this.gCa.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.gCe != null && this.mNetwork.vf() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.vf(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.gCe, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.vf() != 227001) {
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
            VcodeActivity.this.gCc = null;
            if (this.mNetWork != null) {
                this.mNetWork.fp();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.gCa == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new w(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.gCa.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.gCa.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.gCa.getTitle());
                this.mNetWork.n("content", VcodeActivity.this.gCa.getContent());
                if (VcodeActivity.this.gCa.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.gCa.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.gCa.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.gCa.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.gCa.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.gCa.getThreadId());
                }
                String uE = this.mNetWork.uE();
                if (!this.mNetWork.vb().vY().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(uE);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new w(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.tV());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.gCc = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.gCa != null) {
                VcodeActivity.this.gCa.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.gCa.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
