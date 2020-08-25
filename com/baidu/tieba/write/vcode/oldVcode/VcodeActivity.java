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
import com.baidu.tbadk.coreExtra.data.ag;
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
    private WriteData mRd = null;
    private TextView kGp = null;
    private ImageView fnA = null;
    private EditText gIp = null;
    private ProgressBar mProgressBar = null;
    private b mRe = null;
    private a mRf = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener hJE = null;
    private RelativeLayout jfk = null;
    private TextView hHJ = null;
    protected NavigationBar mNavigationBar = null;
    private boolean mMP = false;
    private final View.OnClickListener mRg = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener mRh = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.gIp);
            VcodeActivity.this.Nv();
            if (VcodeActivity.this.mRe != null) {
                VcodeActivity.this.mRe.cancel();
            }
            VcodeActivity.this.mMP = false;
            VcodeActivity.this.mRe = new b(VcodeActivity.this.mRd);
            VcodeActivity.this.mRe.setPriority(3);
            VcodeActivity.this.mRe.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.mRd != null) {
            SL(this.mRd.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.mRe != null) {
                    VcodeActivity.this.mRe.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.mRd = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.mRd = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mRd != null && this.mRd.getType() == 3) {
            if (this.mRe != null) {
                this.mRe.cancel();
            }
            if (this.mRf != null) {
                this.mRf.cancel();
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
        if (this.mRe != null) {
            this.mRe.cancel();
        }
        if (this.mRf != null) {
            this.mRf.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.mRd));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        ap.setBgColor(this.jfk, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.kGp, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.kGp, R.color.cp_cont_g);
        if (i == 1 || i == 4) {
            commentTextColor = ap.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.hHJ.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.hJE);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.jfk = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.hHJ = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mRg);
        this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.mRh);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGp.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.kGp.setLayoutParams(layoutParams);
        this.gIp = (EditText) findViewById(R.id.input);
        this.fnA = (ImageView) findViewById(R.id.vcode_image);
        this.fnA.setImageDrawable(null);
        this.fnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.SL(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SL(String str) {
        if (this.mRf != null) {
            this.mRf.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.fnA.setImageDrawable(null);
        this.mRf = new a();
        this.mRf.setPriority(3);
        this.mRf.execute(str);
    }

    /* loaded from: classes3.dex */
    private class b extends BdAsyncTask<Integer, Integer, ag> {
        private WriteData lUg;
        private aa mNetwork = null;
        private String miS = null;

        public b(WriteData writeData) {
            this.lUg = null;
            this.lUg = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public ag doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.lUg != null) {
                this.mNetwork = new aa();
                String obj = VcodeActivity.this.gIp.getText().toString();
                String imagesCodeForPost = this.lUg.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.lUg.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.lUg.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.lUg.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", "11");
                    this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.lUg.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.mga);
                    this.mNetwork.addPostData("fname", this.lUg.getForumName());
                    this.mNetwork.addPostData("title", this.lUg.getTitle());
                    this.mNetwork.addPostData("apiKey", this.lUg.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.lUg.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.lUg.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.lUg.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.lUg.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.lUg.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.lUg.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.lUg.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.lUg.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.lUg.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.lUg.getForumId());
                    this.mNetwork.addPostData("kw", this.lUg.getForumName());
                    if (this.lUg.getProZone() >= 0) {
                        this.mNetwork.addPostData("pro_zone", String.valueOf(this.lUg.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.lUg.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.lUg.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.lUg.getSpanGroupString()) ? this.lUg.getContent() : this.lUg.getSpanGroupString();
                    VideoInfo videoInfo = this.lUg.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = content + imagesCodeForPost;
                    } else {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.HC(str));
                    c.a(this.mNetwork, this.lUg);
                    this.mNetwork.addPostData("vcode_md5", this.lUg.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                    if (this.lUg.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.lUg.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.lUg.getVoiceDuringTime()));
                    }
                    if (this.lUg.getType() == 0 || this.lUg.getType() == 9 || this.lUg.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.lUg.getType() == 0 || this.lUg.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.lUg.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.lUg.getCallFrom());
                            if (this.lUg.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.lUg.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.lUg.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.lUg.isNoTitle() ? "1" : "0");
                        if (this.lUg.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.lUg.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.lUg.getCategoryFrom()));
                        }
                        if (this.lUg.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.lUg.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.mf().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                        }
                        if (this.lUg.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.lUg.getOriginalThreadId());
                        }
                        if (this.lUg.isShareThread()) {
                            if (this.lUg.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.lUg.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.lUg.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.lUg.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lUg.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.lUg.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.lUg.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.lUg.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.lUg.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lUg.getBaijiahaoData().oriUgcType));
                        }
                        if (this.lUg.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.lUg.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.lUg.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.lUg.getIsGeneralTab()));
                        }
                    } else if (this.lUg.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.lUg.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.lUg.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.lUg.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.lUg.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.lUg.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.lUg.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.lUg.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.lUg.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.lUg.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.lUg.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.lUg.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.lUg.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.lUg.getFloorNum()));
                            this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, this.lUg.isAddition() ? "1" : "0");
                            if (this.lUg.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.lUg.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.lUg.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.lUg.getVForumName());
                        } else if (this.lUg.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.lUg.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.lUg.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.lUg.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.brT().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.lUg.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.lUg.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.biQ() != null && this.mNetwork.biQ().bjv() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.biQ().bjv().bjz()));
                }
                this.miS = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.mRe = null;
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
        public void onPostExecute(ag agVar) {
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
            VcodeActivity.this.mRe = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.miS);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.mMP = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.miS);
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
                                        if (this.lUg.getType() != 3) {
                                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.lUg.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.miS);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString("pid");
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.b.dX(jSONObject2);
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
                                            if (this.lUg != null) {
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
                                            super.onPostExecute(agVar);
                                        }
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        if (this.lUg != null) {
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
                                        super.onPostExecute(agVar);
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
                        if (this.lUg.getType() != 3 && this.lUg.getType() != 7) {
                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.lUg.deleteUploadedTempImages();
                    } else if (this.lUg.isHasImages() && k.isEmpty(this.lUg.getContent() + this.lUg.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.lUg.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.miS);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.b.dX(jSONObject22);
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
                    if (this.lUg != null) {
                        postWriteCallBackData2.setProZone(this.lUg.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.lUg != null) {
                            switch (this.lUg.getType()) {
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
                        e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
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
                } else if (this.lUg.isHasImages() && k.isEmpty(this.lUg.getContent() + this.lUg.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        ag agVar2 = new ag();
                        agVar2.parserJson(this.miS);
                        if (agVar2.getVcode_pic_url() != null && VcodeActivity.this.mRd != null) {
                            VcodeActivity.this.mRd.setVcodeMD5(agVar2.getVcode_md5());
                            VcodeActivity.this.mRd.setVcodeUrl(agVar2.getVcode_pic_url());
                            VcodeActivity.this.SL(VcodeActivity.this.mRd.getVcodeUrl());
                        }
                        VcodeActivity.this.gIp.setText((CharSequence) null);
                    } else if (this.lUg != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.miS);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.lUg, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.miS != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.miS);
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
            super.onPostExecute(agVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile aa bDY;
        private volatile boolean mCanceled;
        ag mRj;

        private a() {
            this.bDY = null;
            this.mRj = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.mRf = null;
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
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
            if (VcodeActivity.this.mRd == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.bDY.addPostData("fid", VcodeActivity.this.mRd.getForumId());
                this.bDY.addPostData("kw", VcodeActivity.this.mRd.getForumName());
                this.bDY.addPostData("new_vcode", "1");
                this.bDY.addPostData("title", VcodeActivity.this.mRd.getTitle());
                this.bDY.addPostData("content", VcodeActivity.this.mRd.getContent());
                if (VcodeActivity.this.mRd.getType() == 0) {
                    this.bDY.addPostData("pub_type", "1");
                    if (VcodeActivity.this.mRd.getCategoryFrom() >= 0) {
                        this.bDY.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.mRd.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.mRd.getCategoryTo() >= 0) {
                        this.bDY.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.mRd.getCategoryTo()));
                    }
                } else {
                    this.bDY.addPostData("pub_type", "2");
                    this.bDY.addPostData("tid", VcodeActivity.this.mRd.getThreadId());
                }
                String postNetData = this.bDY.postNetData();
                if (!this.bDY.biQ().bjw().isRequestSuccess()) {
                    return null;
                }
                this.mRj = new ag();
                this.mRj.parserJson(postNetData);
                str = this.mRj.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.bDY = new aa(str);
            return BitmapHelper.Bytes2Bitmap(this.bDY.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.mRf = null;
            if (bitmap != null) {
                VcodeActivity.this.fnA.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mRj != null && VcodeActivity.this.mRd != null) {
                VcodeActivity.this.mRd.setVcodeMD5(this.mRj.getVcode_md5());
                VcodeActivity.this.mRd.setVcodeUrl(this.mRj.getVcode_pic_url());
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
