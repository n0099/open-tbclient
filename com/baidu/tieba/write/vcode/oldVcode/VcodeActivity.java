package com.baidu.tieba.write.vcode.oldVcode;

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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData nbn = null;
    private TextView kOV = null;
    private ImageView fqJ = null;
    private EditText lrB = null;
    private ProgressBar mProgressBar = null;
    private b nbo = null;
    private a nbp = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hQL = null;
    private RelativeLayout jnW = null;
    private TextView hOQ = null;
    protected NavigationBar mNavigationBar = null;
    private boolean mXe = false;
    private final View.OnClickListener nbq = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener nbr = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.lrB);
            VcodeActivity.this.NY();
            if (VcodeActivity.this.nbo != null) {
                VcodeActivity.this.nbo.cancel();
            }
            VcodeActivity.this.mXe = false;
            VcodeActivity.this.nbo = new b(VcodeActivity.this.nbn);
            VcodeActivity.this.nbo.setPriority(3);
            VcodeActivity.this.nbo.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.nbn != null) {
            Tl(this.nbn.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.hQL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.nbo != null) {
                    VcodeActivity.this.nbo.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.nbn = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.nbn = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nbn != null && this.nbn.getType() == 3) {
            if (this.nbo != null) {
                this.nbo.cancel();
            }
            if (this.nbp != null) {
                this.nbp.cancel();
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
        if (this.nbo != null) {
            this.nbo.cancel();
        }
        if (this.nbp != null) {
            this.nbp.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.nbn));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        ap.setBgColor(this.jnW, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.kOV, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.kOV, R.color.cp_cont_g);
        if (i == 1 || i == 4) {
            commentTextColor = ap.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.hOQ.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NY() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.hQL);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.jnW = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.hOQ = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.nbq);
        this.kOV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.nbr);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kOV.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.kOV.setLayoutParams(layoutParams);
        this.lrB = (EditText) findViewById(R.id.input);
        this.fqJ = (ImageView) findViewById(R.id.vcode_image);
        this.fqJ.setImageDrawable(null);
        this.fqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.Tl(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl(String str) {
        if (this.nbp != null) {
            this.nbp.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.fqJ.setImageDrawable(null);
        this.nbp = new a();
        this.nbp.setPriority(3);
        this.nbp.execute(str);
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<Integer, Integer, ah> {
        private WriteData mdW;
        private aa mNetwork = null;
        private String msG = null;

        public b(WriteData writeData) {
            this.mdW = null;
            this.mdW = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public ah doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.mdW != null) {
                this.mNetwork = new aa();
                String obj = VcodeActivity.this.lrB.getText().toString();
                String imagesCodeForPost = this.mdW.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.mdW.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.mdW.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.mdW.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", "11");
                    this.mNetwork.bjL().bkq().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.mdW.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.mpP);
                    this.mNetwork.addPostData("fname", this.mdW.getForumName());
                    this.mNetwork.addPostData("title", this.mdW.getTitle());
                    this.mNetwork.addPostData("apiKey", this.mdW.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.mdW.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.mdW.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.mdW.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.mdW.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.mdW.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.mdW.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.mdW.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mdW.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.mdW.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.mdW.getForumId());
                    this.mNetwork.addPostData("kw", this.mdW.getForumName());
                    if (this.mdW.getProZone() >= 0) {
                        this.mNetwork.addPostData("pro_zone", String.valueOf(this.mdW.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.mdW.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.mdW.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.mdW.getSpanGroupString()) ? this.mdW.getContent() : this.mdW.getSpanGroupString();
                    VideoInfo videoInfo = this.mdW.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = content + imagesCodeForPost;
                    } else {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.Ia(str));
                    c.a(this.mNetwork, this.mdW);
                    this.mNetwork.addPostData("vcode_md5", this.mdW.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.bjL().bkq().mIsNeedTbs = true;
                    if (this.mdW.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.mdW.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.mdW.getVoiceDuringTime()));
                    }
                    if (this.mdW.getType() == 0 || this.mdW.getType() == 9 || this.mdW.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.mdW.getType() == 0 || this.mdW.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.mdW.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.mdW.getCallFrom());
                            if (this.mdW.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.mdW.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.mdW.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.mdW.isNoTitle() ? "1" : "0");
                        if (this.mdW.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.mdW.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.mdW.getCategoryFrom()));
                        }
                        if (this.mdW.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.mdW.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.mj().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                        }
                        if (this.mdW.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.mdW.getOriginalThreadId());
                        }
                        if (this.mdW.isShareThread()) {
                            if (this.mdW.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.mdW.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.mdW.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.mdW.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mdW.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.mdW.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.mdW.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.mdW.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.mdW.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mdW.getBaijiahaoData().oriUgcType));
                        }
                        if (this.mdW.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.mdW.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.mdW.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.mdW.getIsGeneralTab()));
                        }
                    } else if (this.mdW.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.mdW.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.mdW.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.mdW.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.mdW.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.mdW.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.mdW.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.mdW.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.mdW.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mdW.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.mdW.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.mdW.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.mdW.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.mdW.getFloorNum()));
                            this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, this.mdW.isAddition() ? "1" : "0");
                            if (this.mdW.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.mdW.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.mdW.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.mdW.getVForumName());
                        } else if (this.mdW.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.mdW.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.mdW.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.mdW.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.bsY().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.mdW.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.mdW.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.bjL() != null && this.mNetwork.bjL().bkq() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.bjL().bkq().bku()));
                }
                this.msG = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.nbo = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
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
        public void onPostExecute(ah ahVar) {
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
            VcodeActivity.this.nbo = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.msG);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.mXe = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.msG);
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
                                        if (this.mdW.getType() != 3) {
                                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.mdW.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.msG);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString("pid");
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.b.ef(jSONObject2);
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
                                            if (this.mdW != null) {
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
                                            super.onPostExecute(ahVar);
                                        }
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        if (this.mdW != null) {
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
                                        super.onPostExecute(ahVar);
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
                        if (this.mdW.getType() != 3 && this.mdW.getType() != 7) {
                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.mdW.deleteUploadedTempImages();
                    } else if (this.mdW.isHasImages() && k.isEmpty(this.mdW.getContent() + this.mdW.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.mdW.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.msG);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.b.ef(jSONObject22);
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
                    if (this.mdW != null) {
                        postWriteCallBackData2.setProZone(this.mdW.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.mdW != null) {
                            switch (this.mdW.getType()) {
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
                        e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
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
                } else if (this.mdW.isHasImages() && k.isEmpty(this.mdW.getContent() + this.mdW.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        ah ahVar2 = new ah();
                        ahVar2.parserJson(this.msG);
                        if (ahVar2.getVcode_pic_url() != null && VcodeActivity.this.nbn != null) {
                            VcodeActivity.this.nbn.setVcodeMD5(ahVar2.getVcode_md5());
                            VcodeActivity.this.nbn.setVcodeUrl(ahVar2.getVcode_pic_url());
                            VcodeActivity.this.Tl(VcodeActivity.this.nbn.getVcodeUrl());
                        }
                        VcodeActivity.this.lrB.setText((CharSequence) null);
                    } else if (this.mdW != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.msG);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.mdW, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.msG != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.msG);
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
            super.onPostExecute(ahVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile aa bGb;
        private volatile boolean mCanceled;
        ah nbt;

        private a() {
            this.bGb = null;
            this.nbt = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.nbp = null;
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.nbn == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.bGb = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.bGb.addPostData("fid", VcodeActivity.this.nbn.getForumId());
                this.bGb.addPostData("kw", VcodeActivity.this.nbn.getForumName());
                this.bGb.addPostData("new_vcode", "1");
                this.bGb.addPostData("title", VcodeActivity.this.nbn.getTitle());
                this.bGb.addPostData("content", VcodeActivity.this.nbn.getContent());
                if (VcodeActivity.this.nbn.getType() == 0) {
                    this.bGb.addPostData("pub_type", "1");
                    if (VcodeActivity.this.nbn.getCategoryFrom() >= 0) {
                        this.bGb.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.nbn.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.nbn.getCategoryTo() >= 0) {
                        this.bGb.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.nbn.getCategoryTo()));
                    }
                } else {
                    this.bGb.addPostData("pub_type", "2");
                    this.bGb.addPostData("tid", VcodeActivity.this.nbn.getThreadId());
                }
                String postNetData = this.bGb.postNetData();
                if (!this.bGb.bjL().bkr().isRequestSuccess()) {
                    return null;
                }
                this.nbt = new ah();
                this.nbt.parserJson(postNetData);
                str = this.nbt.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.bGb = new aa(str);
            return BitmapHelper.Bytes2Bitmap(this.bGb.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.nbp = null;
            if (bitmap != null) {
                VcodeActivity.this.fqJ.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.nbt != null && VcodeActivity.this.nbn != null) {
                VcodeActivity.this.nbn.setVcodeMD5(this.nbt.getVcode_md5());
                VcodeActivity.this.nbn.setVcodeUrl(this.nbt.getVcode_pic_url());
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
