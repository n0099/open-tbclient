package com.baidu.tieba.write.vcode.oldVcode;

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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData jqn = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b jqo = null;
    private a jqp = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private RelativeLayout mParent = null;
    private TextView mInfo = null;
    protected NavigationBar mNavigationBar = null;
    private boolean jms = false;
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
            if (VcodeActivity.this.jqo != null) {
                VcodeActivity.this.jqo.cancel();
            }
            VcodeActivity.this.jms = false;
            VcodeActivity.this.jqo = new b(VcodeActivity.this.jqn);
            VcodeActivity.this.jqo.setPriority(3);
            VcodeActivity.this.jqo.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.vcode_activity);
        initUI();
        initData(bundle);
        if (this.jqn != null) {
            Ex(this.jqn.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.jqo != null) {
                    VcodeActivity.this.jqo.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.jqn = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.jqn = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jqn != null && this.jqn.getType() == 3) {
            if (this.jqo != null) {
                this.jqo.cancel();
            }
            if (this.jqp != null) {
                this.jqp.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jqo != null) {
            this.jqo.cancel();
        }
        if (this.jqp != null) {
            this.jqp.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.jqn));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        al.g(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.mPost, d.f.s_navbar_button_bg);
        al.j(this.mPost, d.C0277d.cp_cont_g);
        if (i == 1) {
            i2 = al.hm(i);
        } else {
            i2 = -12895429;
        }
        this.mInfo.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.b(getPageContext());
        this.mWaitingDialog.hF(d.j.sending);
        this.mWaitingDialog.e(this.mDialogCancelListener);
        this.mWaitingDialog.dK(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.dJ(true);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mInfo = (TextView) findViewById(d.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.send), this.onPostListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(d.g.input);
        this.mImage = (ImageView) findViewById(d.g.vcode_image);
        this.mImage.setImageDrawable(null);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.Ex(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(d.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex(String str) {
        if (this.jqp != null) {
            this.jqp.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.jqp = new a();
        this.jqp.setPriority(3);
        this.jqp.execute(str);
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<Integer, Integer, x> {
        private WriteData mData;
        private com.baidu.tbadk.core.util.x mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.mData = null;
            this.mData = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public x doInBackground(Integer... numArr) {
            String str;
            Address af;
            if (this.mData != null) {
                this.mNetwork = new com.baidu.tbadk.core.util.x();
                String obj = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.mData.getImagesCodeForPost();
                if (this.mData.getType() == 3) {
                    this.mNetwork.x("newVcode", "1");
                    this.mNetwork.x("content", this.mData.getContent() + imagesCodeForPost);
                    this.mNetwork.x(PayVcodeActivityConfig.VCODE_MD5, this.mData.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.x("vcode", obj);
                    }
                    this.mNetwork.x("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mNetwork.acE().adC().mIsNeedTbs = true;
                    this.mNetwork.x("content", this.mData.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.iGT);
                    this.mNetwork.x(ImageViewerConfig.FORUM_NAME, this.mData.getForumName());
                    this.mNetwork.x("title", this.mData.getTitle());
                    this.mNetwork.x("apiKey", this.mData.getShareApiKey());
                    this.mNetwork.x("appName", this.mData.getShareAppName());
                    this.mNetwork.x("signKey", this.mData.getShareSignKey());
                    this.mNetwork.x("summary_title", this.mData.getShareSummaryTitle());
                    this.mNetwork.x("summary_content", this.mData.getShareSummaryContent());
                    this.mNetwork.x("summary_img", this.mData.getShareSummaryImg());
                    this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.mData.getShareSummaryImgWidth()));
                    this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.mData.getShareSummaryImgHeight()));
                    this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mData.getShareSummaryImgType());
                    this.mNetwork.x("referUrl", this.mData.getShareReferUrl());
                } else {
                    this.mNetwork.x("anonymous", "0");
                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mData.getForumId());
                    this.mNetwork.x("kw", this.mData.getForumName());
                    if (this.mData.getProZone() >= 0) {
                        this.mNetwork.x("pro_zone", String.valueOf(this.mData.getProZone()));
                    }
                    this.mNetwork.x("can_no_forum", this.mData.isCanNoForum() ? "1" : "0");
                    this.mNetwork.x("is_feedback", this.mData.isUserFeedback() ? "1" : "0");
                    this.mNetwork.x("new_vcode", "1");
                    VideoInfo videoInfo = this.mData.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = this.mData.getContent() + imagesCodeForPost;
                    } else {
                        str = this.mData.getContent() + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.x("content", str);
                    c.a(this.mNetwork, this.mData);
                    this.mNetwork.x("vcode_md5", this.mData.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.x("vcode", obj);
                    }
                    this.mNetwork.acE().adC().mIsNeedTbs = true;
                    if (this.mData.getVoice() != null) {
                        this.mNetwork.x("voice_md5", this.mData.getVoice());
                        this.mNetwork.x("during_time", String.valueOf(this.mData.getVoiceDuringTime()));
                    }
                    if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                            this.mNetwork.x("transform_forums", this.mData.getTransmitForumData());
                            this.mNetwork.x(IntentConfig.CALL_FROM, this.mData.getCallFrom());
                            if (this.mData.getRecommendExt() != null) {
                                this.mNetwork.x("recommend_ext", this.mData.getRecommendExt());
                            }
                        }
                        this.mNetwork.x("title", this.mData.getTitle());
                        this.mNetwork.x("is_ntitle", this.mData.isNoTitle() ? "1" : "0");
                        if (this.mData.getType() == 7) {
                            this.mNetwork.x("is_bottle", String.valueOf(1));
                        }
                        if (this.mData.getCategoryFrom() >= 0) {
                            this.mNetwork.x("fromCategoryId", String.valueOf(this.mData.getCategoryFrom()));
                        }
                        if (this.mData.getCategoryTo() >= 0) {
                            this.mNetwork.x("toCategoryId", String.valueOf(this.mData.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (af = com.baidu.adp.lib.d.a.iW().af(false)) != null) {
                            this.mNetwork.x("lbs", String.valueOf(af.getLatitude()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(af.getLongitude()));
                        }
                    } else if (this.mData.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.x("title", this.mData.getTitle());
                        this.mNetwork.x("is_ntitle", this.mData.isNoTitle() ? "1" : "0");
                        this.mNetwork.x("thread_type", String.valueOf(36));
                    } else if (this.mData.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.x("title", this.mData.getTitle());
                        this.mNetwork.x("is_ntitle", "0");
                        this.mNetwork.x("thread_type", String.valueOf(33));
                        this.mNetwork.x("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.x("tid", this.mData.getThreadId());
                        this.mNetwork.x("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.mData.getType() == 2) {
                            this.mNetwork.x("quote_id", String.valueOf(this.mData.getFloor()));
                            this.mNetwork.x("floor_num", String.valueOf(this.mData.getFloorNum()));
                            this.mNetwork.x(WriteActivityConfig.IS_ADDITION, this.mData.isAddition() ? "1" : "0");
                            if (this.mData.getRepostId() != null) {
                                this.mNetwork.x("repostid", this.mData.getRepostId());
                            }
                            this.mNetwork.x("v_fid", this.mData.getVForumId());
                            this.mNetwork.x("v_fname", this.mData.getVForumName());
                        } else if (this.mData.getType() == 5) {
                            this.mNetwork.x("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.mData.getType() == 1) {
                            this.mNetwork.x("is_barrage", this.mData.isBarrage() ? "1" : "0");
                            this.mNetwork.x("barrage_time", String.valueOf(this.mData.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.amm().getStatus() == 1) {
                                this.mNetwork.x("ptype", "4");
                            }
                            this.mNetwork.x("v_fid", this.mData.getVForumId());
                            this.mNetwork.x("v_fname", this.mData.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.acE() != null && this.mNetwork.acE().adC() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.mNetwork.acE().adC().adF()));
                }
                this.mRetData = this.mNetwork.acg();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.jqo = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[Catch: JSONException -> 0x036b, TRY_LEAVE, TryCatch #3 {JSONException -> 0x036b, blocks: (B:27:0x00c6, B:29:0x00cf), top: B:121:0x00c6 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(x xVar) {
            JSONArray jSONArray;
            String str;
            String str2;
            String str3;
            CustomDialogData customDialogData;
            String str4;
            String str5;
            String str6;
            JSONException jSONException;
            String str7;
            final CustomDialogData customDialogData2;
            int i;
            JSONException jSONException2;
            String str8;
            String str9;
            String str10;
            String str11;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.jqo = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.jms = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str10 = jSONObject.optString("msg");
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
                                        }
                                        if (this.mData.getType() != 3) {
                                            c.f(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.mData.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.mRetData);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString(Info.kBaiduPIDKey);
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.b.bB(jSONObject2);
                                        try {
                                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("twzhibo_info");
                                            if (optJSONObject2 == null) {
                                            }
                                            str7 = str;
                                        } catch (JSONException e2) {
                                            customDialogData = customDialogData2;
                                            str4 = str3;
                                            str5 = str2;
                                            str6 = str;
                                            jSONException = e2;
                                            jSONException.printStackTrace();
                                            str7 = str6;
                                            str2 = str5;
                                            str3 = str4;
                                            customDialogData2 = customDialogData;
                                            i = 0;
                                            postWriteCallBackData.setThreadId(str7);
                                            postWriteCallBackData.setPostId(str2);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str3);
                                            if (this.mData != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData2);
                                            if (customDialogData2 != null) {
                                            }
                                            Intent intent = new Intent();
                                            Bundle bundle = new Bundle();
                                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent.putExtras(bundle);
                                            VcodeActivity.this.setResult(-1, intent);
                                            VcodeActivity.this.finish();
                                            super.onPostExecute(xVar);
                                        }
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        if (this.mData != null) {
                                        }
                                        postWriteCallBackData.setActivityDialog(customDialogData2);
                                        if (customDialogData2 != null) {
                                        }
                                        Intent intent2 = new Intent();
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent2.putExtras(bundle2);
                                        VcodeActivity.this.setResult(-1, intent2);
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(xVar);
                                    }
                                } else {
                                    str11 = null;
                                    str8 = null;
                                }
                            } catch (JSONException e3) {
                                str8 = null;
                                str9 = str10;
                                jSONException2 = e3;
                            }
                        } catch (JSONException e4) {
                            jSONException2 = e4;
                            str8 = null;
                            str9 = null;
                        }
                        if (StringUtils.isNull(str10)) {
                            str10 = TbadkCoreApplication.getInst().getString(d.j.send_success);
                        }
                        if (this.mData.getType() != 3 && this.mData.getType() != 7) {
                            c.f(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.mData.deleteUploadedTempImages();
                    } else if (this.mData.isHasImages() && k.isEmpty(this.mData.getContent() + this.mData.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.j.img_upload_error));
                    } else if (this.mData.getType() != 3) {
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
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.b.bB(jSONObject22);
                        JSONObject optJSONObject22 = jSONObject22.optJSONObject("twzhibo_info");
                        i = optJSONObject22 == null ? optJSONObject22.optInt("is_copytwzhibo", 0) : 0;
                        str7 = str;
                    } catch (JSONException e5) {
                        customDialogData = null;
                        str4 = str3;
                        str5 = str2;
                        str6 = str;
                        jSONException = e5;
                    }
                    postWriteCallBackData2.setThreadId(str7);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str3);
                    if (this.mData != null) {
                        postWriteCallBackData2.setProZone(this.mData.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.mData != null) {
                            switch (this.mData.getType()) {
                                case 0:
                                case 4:
                                case 6:
                                case 7:
                                case 9:
                                    customDialogData2.type = 2;
                                    break;
                                case 1:
                                case 2:
                                    customDialogData2.type = 1;
                                    break;
                            }
                        }
                        e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tieba.pb.interactionpopupwindow.c.a(VcodeActivity.this.getPageContext(), customDialogData2).show();
                            }
                        }, 2000L);
                    }
                    Intent intent22 = new Intent();
                    Bundle bundle22 = new Bundle();
                    bundle22.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent22.putExtras(bundle22);
                    VcodeActivity.this.setResult(-1, intent22);
                    VcodeActivity.this.finish();
                } else if (this.mData.isHasImages() && k.isEmpty(this.mData.getContent() + this.mData.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.j.img_upload_error));
                } else {
                    if (this.mNetwork.acI() == 5 || this.mNetwork.acI() == 6) {
                        x xVar2 = new x();
                        xVar2.parserJson(this.mRetData);
                        if (xVar2.getVcode_pic_url() != null && VcodeActivity.this.jqn != null) {
                            VcodeActivity.this.jqn.setVcodeMD5(xVar2.getVcode_md5());
                            VcodeActivity.this.jqn.setVcodeUrl(xVar2.getVcode_pic_url());
                            VcodeActivity.this.Ex(VcodeActivity.this.jqn.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.mData != null && this.mNetwork.acI() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.acI(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, this.mData, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.acI() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.acI() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(220015, null, null, null);
                        if (this.mRetData != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.mRetData);
                                postWriteCallBackData4.setErrorString(jSONObject3.optString("msg"));
                                postWriteCallBackData4.setThreadId(jSONObject3.optString("tid"));
                                postWriteCallBackData4.setPostId(jSONObject3.optString(Info.kBaiduPIDKey));
                                JSONObject optJSONObject3 = jSONObject3.optJSONObject("info");
                                if (optJSONObject3 != null && (jSONArray = optJSONObject3.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                    int length = jSONArray.length();
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    for (int i2 = 0; i2 < length; i2++) {
                                        arrayList.add(jSONArray.optString(i2));
                                    }
                                    postWriteCallBackData4.setSensitiveWords(arrayList);
                                }
                            } catch (JSONException e6) {
                                e6.printStackTrace();
                            }
                        }
                        Intent intent3 = new Intent();
                        Bundle bundle3 = new Bundle();
                        bundle3.putSerializable("post_write_callback_data", postWriteCallBackData4);
                        intent3.putExtras(bundle3);
                        VcodeActivity.this.setResult(0, intent3);
                        VcodeActivity.this.finish();
                    }
                    if (this.mNetwork.acI() != 227001 && this.mNetwork.acI() == 220015) {
                        VcodeActivity.this.showToast(this.mNetwork.getErrorString());
                    }
                }
            }
            super.onPostExecute(xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        x mInfoData;
        volatile com.baidu.tbadk.core.util.x mNetWork;

        private a() {
            this.mNetWork = null;
            this.mInfoData = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.jqp = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.jqn == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetWork.x(ImageViewerConfig.FORUM_ID, VcodeActivity.this.jqn.getForumId());
                this.mNetWork.x("kw", VcodeActivity.this.jqn.getForumName());
                this.mNetWork.x("new_vcode", "1");
                this.mNetWork.x("title", VcodeActivity.this.jqn.getTitle());
                this.mNetWork.x("content", VcodeActivity.this.jqn.getContent());
                if (VcodeActivity.this.jqn.getType() == 0) {
                    this.mNetWork.x("pub_type", "1");
                    if (VcodeActivity.this.jqn.getCategoryFrom() >= 0) {
                        this.mNetWork.x("fromCategoryId", String.valueOf(VcodeActivity.this.jqn.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.jqn.getCategoryTo() >= 0) {
                        this.mNetWork.x("toCategoryId", String.valueOf(VcodeActivity.this.jqn.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.x("pub_type", "2");
                    this.mNetWork.x("tid", VcodeActivity.this.jqn.getThreadId());
                }
                String acg = this.mNetWork.acg();
                if (!this.mNetWork.acE().adD().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new x();
                this.mInfoData.parserJson(acg);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new com.baidu.tbadk.core.util.x(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.ach());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.jqp = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null && VcodeActivity.this.jqn != null) {
                VcodeActivity.this.jqn.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.jqn.setVcodeUrl(this.mInfoData.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    setResult(-1, intent);
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    setResult(0, intent);
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
