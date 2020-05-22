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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.NetWorkErr;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData lVe = null;
    private TextView laz = null;
    private ImageView eNj = null;
    private EditText gdP = null;
    private ProgressBar mProgressBar = null;
    private b lVf = null;
    private a lVg = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener heh = null;
    private RelativeLayout isn = null;
    private TextView hcm = null;
    protected NavigationBar mNavigationBar = null;
    private boolean lRc = false;
    private final View.OnClickListener lVh = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener lVi = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.gdP);
            VcodeActivity.this.showDialog();
            if (VcodeActivity.this.lVf != null) {
                VcodeActivity.this.lVf.cancel();
            }
            VcodeActivity.this.lRc = false;
            VcodeActivity.this.lVf = new b(VcodeActivity.this.lVe);
            VcodeActivity.this.lVf.setPriority(3);
            VcodeActivity.this.lVf.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.lVe != null) {
            Ot(this.lVe.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.lVf != null) {
                    VcodeActivity.this.lVf.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.lVe = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.lVe = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lVe != null && this.lVe.getType() == 3) {
            if (this.lVf != null) {
                this.lVf.cancel();
            }
            if (this.lVg != null) {
                this.lVg.cancel();
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
        if (this.lVf != null) {
            this.lVf.cancel();
        }
        if (this.lVg != null) {
            this.lVg.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.lVe));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        am.setBgColor(this.isn, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setBackgroundResource(this.laz, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.laz, (int) R.color.cp_cont_g);
        if (i == 1 || i == 4) {
            commentTextColor = am.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.hcm.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.heh);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.isn = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.hcm = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.lVh);
        this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.lVi);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laz.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.laz.setLayoutParams(layoutParams);
        this.gdP = (EditText) findViewById(R.id.input);
        this.eNj = (ImageView) findViewById(R.id.vcode_image);
        this.eNj.setImageDrawable(null);
        this.eNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.Ot(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ot(String str) {
        if (this.lVg != null) {
            this.lVg.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.eNj.setImageDrawable(null);
        this.lVg = new a();
        this.lVg.setPriority(3);
        this.lVg.execute(str);
    }

    /* loaded from: classes2.dex */
    private class b extends BdAsyncTask<Integer, Integer, aa> {
        private WriteData lab;
        private x mNetwork = null;
        private String loX = null;

        public b(WriteData writeData) {
            this.lab = null;
            this.lab = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public aa doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.lab != null) {
                this.mNetwork = new x();
                String obj = VcodeActivity.this.gdP.getText().toString();
                String imagesCodeForPost = this.lab.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.lab.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.lab.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.lab.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", "11");
                    this.mNetwork.aUA().aVa().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.lab.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.lmb);
                    this.mNetwork.addPostData("fname", this.lab.getForumName());
                    this.mNetwork.addPostData("title", this.lab.getTitle());
                    this.mNetwork.addPostData("apiKey", this.lab.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.lab.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.lab.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.lab.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.lab.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.lab.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.lab.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.lab.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lab.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.lab.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.lab.getForumId());
                    this.mNetwork.addPostData("kw", this.lab.getForumName());
                    if (this.lab.getProZone() >= 0) {
                        this.mNetwork.addPostData("pro_zone", String.valueOf(this.lab.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.lab.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.lab.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    VideoInfo videoInfo = this.lab.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = this.lab.getContent() + imagesCodeForPost;
                    } else {
                        str = this.lab.getContent() + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.DP(str));
                    c.a(this.mNetwork, this.lab);
                    this.mNetwork.addPostData("vcode_md5", this.lab.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.aUA().aVa().mIsNeedTbs = true;
                    if (this.lab.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.lab.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.lab.getVoiceDuringTime()));
                    }
                    if (this.lab.getType() == 0 || this.lab.getType() == 9 || this.lab.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.lab.getType() == 0 || this.lab.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.lab.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.lab.getCallFrom());
                            if (this.lab.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.lab.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.lab.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.lab.isNoTitle() ? "1" : "0");
                        if (this.lab.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.lab.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.lab.getCategoryFrom()));
                        }
                        if (this.lab.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.lab.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.kq().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                        }
                        if (this.lab.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.lab.getOriginalThreadId());
                        }
                        if (this.lab.isShareThread()) {
                            if (this.lab.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.lab.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.lab.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.lab.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lab.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.lab.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.lab.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.lab.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.lab.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lab.getBaijiahaoData().oriUgcType));
                        }
                        if (this.lab.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.lab.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.lab.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.lab.getIsGeneralTab()));
                        }
                    } else if (this.lab.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.lab.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.lab.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.lab.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.lab.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.lab.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.lab.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.lab.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.lab.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lab.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.lab.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.lab.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.lab.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.lab.getFloorNum()));
                            this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, this.lab.isAddition() ? "1" : "0");
                            if (this.lab.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.lab.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.lab.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.lab.getVForumName());
                        } else if (this.lab.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.lab.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.lab.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.lab.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.bds().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.lab.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.lab.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.aUA() != null && this.mNetwork.aUA().aVa() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.aUA().aVa().aVe()));
                }
                this.loX = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.lVf = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0384  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d0 A[Catch: JSONException -> 0x036e, TRY_LEAVE, TryCatch #3 {JSONException -> 0x036e, blocks: (B:27:0x00c7, B:29:0x00d0), top: B:121:0x00c7 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f7  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(aa aaVar) {
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
            VcodeActivity.this.lVf = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.loX);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.lRc = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.loX);
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
                                        if (this.lab.getType() != 3) {
                                            c.f(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.lab.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.loX);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString("pid");
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.b.dv(jSONObject2);
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
                                            if (this.lab != null) {
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
                                            super.onPostExecute(aaVar);
                                        }
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        if (this.lab != null) {
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
                                        super.onPostExecute(aaVar);
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
                            str10 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                        }
                        if (this.lab.getType() != 3 && this.lab.getType() != 7) {
                            c.f(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.lab.deleteUploadedTempImages();
                    } else if (this.lab.isHasImages() && k.isEmpty(this.lab.getContent() + this.lab.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.lab.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.loX);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.b.dv(jSONObject22);
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
                    if (this.lab != null) {
                        postWriteCallBackData2.setProZone(this.lab.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.lab != null) {
                            switch (this.lab.getType()) {
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
                        e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
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
                } else if (this.lab.isHasImages() && k.isEmpty(this.lab.getContent() + this.lab.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        aa aaVar2 = new aa();
                        aaVar2.parserJson(this.loX);
                        if (aaVar2.getVcode_pic_url() != null && VcodeActivity.this.lVe != null) {
                            VcodeActivity.this.lVe.setVcodeMD5(aaVar2.getVcode_md5());
                            VcodeActivity.this.lVe.setVcodeUrl(aaVar2.getVcode_pic_url());
                            VcodeActivity.this.Ot(VcodeActivity.this.lVe.getVcodeUrl());
                        }
                        VcodeActivity.this.gdP.setText((CharSequence) null);
                    } else if (this.lab != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.loX);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.lab, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.loX != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.loX);
                                postWriteCallBackData4.setErrorString(jSONObject3.optString("msg"));
                                postWriteCallBackData4.setThreadId(jSONObject3.optString("tid"));
                                postWriteCallBackData4.setPostId(jSONObject3.optString("pid"));
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
                    if (this.mNetwork.getServerErrorCode() != 227001 && this.mNetwork.getServerErrorCode() == 220015) {
                        VcodeActivity.this.showToast(this.mNetwork.getErrorString());
                    }
                }
            }
            super.onPostExecute(aaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile x bth;
        aa lVk;
        private volatile boolean mCanceled;

        private a() {
            this.bth = null;
            this.lVk = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.lVg = null;
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.lVe == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.bth = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.bth.addPostData("fid", VcodeActivity.this.lVe.getForumId());
                this.bth.addPostData("kw", VcodeActivity.this.lVe.getForumName());
                this.bth.addPostData("new_vcode", "1");
                this.bth.addPostData("title", VcodeActivity.this.lVe.getTitle());
                this.bth.addPostData("content", VcodeActivity.this.lVe.getContent());
                if (VcodeActivity.this.lVe.getType() == 0) {
                    this.bth.addPostData("pub_type", "1");
                    if (VcodeActivity.this.lVe.getCategoryFrom() >= 0) {
                        this.bth.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.lVe.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.lVe.getCategoryTo() >= 0) {
                        this.bth.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.lVe.getCategoryTo()));
                    }
                } else {
                    this.bth.addPostData("pub_type", "2");
                    this.bth.addPostData("tid", VcodeActivity.this.lVe.getThreadId());
                }
                String postNetData = this.bth.postNetData();
                if (!this.bth.aUA().aVb().isRequestSuccess()) {
                    return null;
                }
                this.lVk = new aa();
                this.lVk.parserJson(postNetData);
                str = this.lVk.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.bth = new x(str);
            return BitmapHelper.Bytes2Bitmap(this.bth.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.lVg = null;
            if (bitmap != null) {
                VcodeActivity.this.eNj.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.lVk != null && VcodeActivity.this.lVe != null) {
                VcodeActivity.this.lVe.setVcodeMD5(this.lVk.getVcode_md5());
                VcodeActivity.this.lVe.setVcodeUrl(this.lVk.getVcode_pic_url());
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
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    setResult(-1, intent);
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
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
