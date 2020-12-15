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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData nYO = null;
    private TextView lKM = null;
    private ImageView fZa = null;
    private EditText mnI = null;
    private ProgressBar mProgressBar = null;
    private b nYP = null;
    private a nYQ = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iJO = null;
    private RelativeLayout kjG = null;
    private TextView iHT = null;
    protected NavigationBar mNavigationBar = null;
    private boolean nUG = false;
    private final View.OnClickListener nYR = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener nYS = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.mnI);
            VcodeActivity.this.RU();
            if (VcodeActivity.this.nYP != null) {
                VcodeActivity.this.nYP.cancel();
            }
            VcodeActivity.this.nUG = false;
            VcodeActivity.this.nYP = new b(VcodeActivity.this.nYO);
            VcodeActivity.this.nYP.setPriority(3);
            VcodeActivity.this.nYP.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.nYO != null) {
            VP(this.nYO.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.nYP != null) {
                    VcodeActivity.this.nYP.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.nYO = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.nYO = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nYO != null && this.nYO.getType() == 3) {
            if (this.nYP != null) {
                this.nYP.cancel();
            }
            if (this.nYQ != null) {
                this.nYQ.cancel();
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
        if (this.nYP != null) {
            this.nYP.cancel();
        }
        if (this.nYQ != null) {
            this.nYQ.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.nYO));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        ap.setBgColor(this.kjG, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.lKM, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.lKM, R.color.CAM_X0111);
        if (i == 1 || i == 4) {
            commentTextColor = ap.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.iHT.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RU() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.iJO);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.kjG = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iHT = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.nYR);
        this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.nYS);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKM.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.lKM.setLayoutParams(layoutParams);
        this.mnI = (EditText) findViewById(R.id.input);
        this.fZa = (ImageView) findViewById(R.id.vcode_image);
        this.fZa.setImageDrawable(null);
        this.fZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.VP(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP(String str) {
        if (this.nYQ != null) {
            this.nYQ.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.fZa.setImageDrawable(null);
        this.nYQ = new a();
        this.nYQ.setPriority(3);
        this.nYQ.execute(str);
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<Integer, Integer, ah> {
        private WriteData nbe;
        private aa mNetwork = null;
        private String nqa = null;

        public b(WriteData writeData) {
            this.nbe = null;
            this.nbe = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public ah doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.nbe != null) {
                this.mNetwork = new aa();
                String obj = VcodeActivity.this.mnI.getText().toString();
                String imagesCodeForPost = this.nbe.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.nbe.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.nbe.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.nbe.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", "11");
                    this.mNetwork.btv().bue().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.nbe.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.nmY);
                    this.mNetwork.addPostData("fname", this.nbe.getForumName());
                    this.mNetwork.addPostData("title", this.nbe.getTitle());
                    this.mNetwork.addPostData("apiKey", this.nbe.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.nbe.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.nbe.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.nbe.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.nbe.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.nbe.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.nbe.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.nbe.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.nbe.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.nbe.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.nbe.getForumId());
                    this.mNetwork.addPostData("kw", this.nbe.getForumName());
                    if (this.nbe.getProZone() >= 0) {
                        this.mNetwork.addPostData("pro_zone", String.valueOf(this.nbe.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.nbe.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.nbe.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.nbe.getSpanGroupString()) ? this.nbe.getContent() : this.nbe.getSpanGroupString();
                    VideoInfo videoInfo = this.nbe.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = content + imagesCodeForPost;
                    } else {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.JU(str));
                    c.a(this.mNetwork, this.nbe);
                    this.mNetwork.addPostData("vcode_md5", this.nbe.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.btv().bue().mIsNeedTbs = true;
                    if (this.nbe.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.nbe.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.nbe.getVoiceDuringTime()));
                    }
                    if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.nbe.getType() == 0 || this.nbe.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.nbe.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.nbe.getCallFrom());
                            if (this.nbe.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.nbe.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.nbe.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.nbe.isNoTitle() ? "1" : "0");
                        if (this.nbe.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.nbe.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.nbe.getCategoryFrom()));
                        }
                        if (this.nbe.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.nbe.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.mk().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                        }
                        if (this.nbe.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.nbe.getOriginalThreadId());
                        }
                        if (this.nbe.isShareThread()) {
                            if (this.nbe.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.nbe.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.nbe.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.nbe.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.nbe.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.nbe.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.nbe.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.nbe.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.nbe.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.nbe.getBaijiahaoData().oriUgcType));
                        }
                        if (this.nbe.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.nbe.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.nbe.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.nbe.getIsGeneralTab()));
                        }
                    } else if (this.nbe.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.nbe.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.nbe.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.nbe.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.nbe.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.nbe.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.nbe.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.nbe.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.nbe.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.nbe.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.nbe.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.nbe.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.nbe.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.nbe.getFloorNum()));
                            this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, this.nbe.isAddition() ? "1" : "0");
                            if (this.nbe.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.nbe.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.nbe.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.nbe.getVForumName());
                        } else if (this.nbe.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.nbe.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.nbe.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.nbe.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.bCQ().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.nbe.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.nbe.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.btv() != null && this.mNetwork.btv().bue() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.btv().bue().bui()));
                }
                this.nqa = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.nYP = null;
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
            VcodeActivity.this.nYP = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.nqa);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.nUG = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.nqa);
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
                                        if (this.nbe.getType() != 3) {
                                            c.h(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.nbe.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.nqa);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString("pid");
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.b.er(jSONObject2);
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
                                            if (this.nbe != null) {
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
                                        if (this.nbe != null) {
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
                        if (this.nbe.getType() != 3 && this.nbe.getType() != 7) {
                            c.h(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.nbe.deleteUploadedTempImages();
                    } else if (this.nbe.isHasImages() && k.isEmpty(this.nbe.getContent() + this.nbe.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.nbe.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.nqa);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.b.er(jSONObject22);
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
                    if (this.nbe != null) {
                        postWriteCallBackData2.setProZone(this.nbe.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.nbe != null) {
                            switch (this.nbe.getType()) {
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
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
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
                } else if (this.nbe.isHasImages() && k.isEmpty(this.nbe.getContent() + this.nbe.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        ah ahVar2 = new ah();
                        ahVar2.parserJson(this.nqa);
                        if (ahVar2.getVcode_pic_url() != null && VcodeActivity.this.nYO != null) {
                            VcodeActivity.this.nYO.setVcodeMD5(ahVar2.getVcode_md5());
                            VcodeActivity.this.nYO.setVcodeUrl(ahVar2.getVcode_pic_url());
                            VcodeActivity.this.VP(VcodeActivity.this.nYO.getVcodeUrl());
                        }
                        VcodeActivity.this.mnI.setText((CharSequence) null);
                    } else if (this.nbe != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.nqa);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.nbe, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.nqa != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.nqa);
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
        volatile aa cfI;
        private volatile boolean mCanceled;
        ah nYU;

        private a() {
            this.cfI = null;
            this.nYU = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.nYQ = null;
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.nYO == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.cfI.addPostData("fid", VcodeActivity.this.nYO.getForumId());
                this.cfI.addPostData("kw", VcodeActivity.this.nYO.getForumName());
                this.cfI.addPostData("new_vcode", "1");
                this.cfI.addPostData("title", VcodeActivity.this.nYO.getTitle());
                this.cfI.addPostData("content", VcodeActivity.this.nYO.getContent());
                if (VcodeActivity.this.nYO.getType() == 0) {
                    this.cfI.addPostData("pub_type", "1");
                    if (VcodeActivity.this.nYO.getCategoryFrom() >= 0) {
                        this.cfI.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.nYO.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.nYO.getCategoryTo() >= 0) {
                        this.cfI.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.nYO.getCategoryTo()));
                    }
                } else {
                    this.cfI.addPostData("pub_type", "2");
                    this.cfI.addPostData("tid", VcodeActivity.this.nYO.getThreadId());
                }
                String postNetData = this.cfI.postNetData();
                if (!this.cfI.btv().buf().isRequestSuccess()) {
                    return null;
                }
                this.nYU = new ah();
                this.nYU.parserJson(postNetData);
                str = this.nYU.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.cfI = new aa(str);
            return BitmapHelper.Bytes2Bitmap(this.cfI.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.nYQ = null;
            if (bitmap != null) {
                VcodeActivity.this.fZa.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.nYU != null && VcodeActivity.this.nYO != null) {
                VcodeActivity.this.nYO.setVcodeMD5(this.nYU.getVcode_md5());
                VcodeActivity.this.nYO.setVcodeUrl(this.nYU.getVcode_pic_url());
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
