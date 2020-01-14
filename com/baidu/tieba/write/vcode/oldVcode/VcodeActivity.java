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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData kPu = null;
    private TextView jWf = null;
    private ImageView dTY = null;
    private EditText fgP = null;
    private ProgressBar mProgressBar = null;
    private b kPv = null;
    private a kPw = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gdj = null;
    private RelativeLayout hpY = null;
    private TextView gbm = null;
    protected NavigationBar mNavigationBar = null;
    private boolean kLP = false;
    private final View.OnClickListener kPx = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener kPy = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.fgP);
            VcodeActivity.this.showDialog();
            if (VcodeActivity.this.kPv != null) {
                VcodeActivity.this.kPv.cancel();
            }
            VcodeActivity.this.kLP = false;
            VcodeActivity.this.kPv = new b(VcodeActivity.this.kPu);
            VcodeActivity.this.kPv.setPriority(3);
            VcodeActivity.this.kPv.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.kPu != null) {
            KJ(this.kPu.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.kPv != null) {
                    VcodeActivity.this.kPv.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.kPu = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.kPu = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kPu != null && this.kPu.getType() == 3) {
            if (this.kPv != null) {
                this.kPv.cancel();
            }
            if (this.kPw != null) {
                this.kPw.cancel();
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
        if (this.kPv != null) {
            this.kPv.cancel();
        }
        if (this.kPw != null) {
            this.kPw.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.kPu));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        am.setBgColor(this.hpY, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setBackgroundResource(this.jWf, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.jWf, (int) R.color.cp_cont_g);
        if (i == 1 || i == 4) {
            commentTextColor = am.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.gbm.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.gdj);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.hpY = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.gbm = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.kPx);
        this.jWf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.kPy);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jWf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.jWf.setLayoutParams(layoutParams);
        this.fgP = (EditText) findViewById(R.id.input);
        this.dTY = (ImageView) findViewById(R.id.vcode_image);
        this.dTY.setImageDrawable(null);
        this.dTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.KJ(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KJ(String str) {
        if (this.kPw != null) {
            this.kPw.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.dTY.setImageDrawable(null);
        this.kPw = new a();
        this.kPw.setPriority(3);
        this.kPw.execute(str);
    }

    /* loaded from: classes11.dex */
    private class b extends BdAsyncTask<Integer, Integer, z> {
        private WriteData jVI;
        private x mNetwork = null;
        private String kjt = null;

        public b(WriteData writeData) {
            this.jVI = null;
            this.jVI = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public z doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.jVI != null) {
                this.mNetwork = new x();
                String obj = VcodeActivity.this.fgP.getText().toString();
                String imagesCodeForPost = this.jVI.getImagesCodeForPost();
                if (this.jVI.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.jVI.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.jVI.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", "11");
                    this.mNetwork.aDU().aEu().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.jVI.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.kgF);
                    this.mNetwork.addPostData("fname", this.jVI.getForumName());
                    this.mNetwork.addPostData("title", this.jVI.getTitle());
                    this.mNetwork.addPostData("apiKey", this.jVI.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.jVI.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.jVI.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.jVI.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.jVI.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.jVI.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.jVI.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.jVI.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.jVI.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.jVI.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.jVI.getForumId());
                    this.mNetwork.addPostData("kw", this.jVI.getForumName());
                    if (this.jVI.getProZone() >= 0) {
                        this.mNetwork.addPostData("pro_zone", String.valueOf(this.jVI.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.jVI.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.jVI.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    VideoInfo videoInfo = this.jVI.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = this.jVI.getContent() + imagesCodeForPost;
                    } else {
                        str = this.jVI.getContent() + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.Aa(str));
                    c.a(this.mNetwork, this.jVI);
                    this.mNetwork.addPostData("vcode_md5", this.jVI.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.aDU().aEu().mIsNeedTbs = true;
                    if (this.jVI.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.jVI.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.jVI.getVoiceDuringTime()));
                    }
                    if (this.jVI.getType() == 0 || this.jVI.getType() == 9 || this.jVI.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.jVI.getType() == 0 || this.jVI.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.jVI.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.jVI.getCallFrom());
                            if (this.jVI.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.jVI.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.jVI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.jVI.isNoTitle() ? "1" : "0");
                        if (this.jVI.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.jVI.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.jVI.getCategoryFrom()));
                        }
                        if (this.jVI.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.jVI.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.fK().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
                        }
                        if (this.jVI.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.jVI.getOriginalThreadId());
                        }
                        if (this.jVI.isShareThread()) {
                            if (this.jVI.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.jVI.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.jVI.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.jVI.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.jVI.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.jVI.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.jVI.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.jVI.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.jVI.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.jVI.getBaijiahaoData().oriUgcType));
                        }
                    } else if (this.jVI.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.jVI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.jVI.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.jVI.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.jVI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.jVI.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.jVI.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.jVI.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.jVI.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.jVI.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.jVI.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.jVI.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.jVI.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.jVI.getFloorNum()));
                            this.mNetwork.addPostData(WriteActivityConfig.IS_ADDITION, this.jVI.isAddition() ? "1" : "0");
                            if (this.jVI.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.jVI.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.jVI.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.jVI.getVForumName());
                        } else if (this.jVI.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.jVI.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.jVI.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.jVI.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.aMr().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.jVI.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.jVI.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.aDU() != null && this.mNetwork.aDU().aEu() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.aDU().aEu().aEx()));
                }
                this.kjt = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.kPv = null;
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
        public void onPostExecute(z zVar) {
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
            VcodeActivity.this.kPv = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.kjt);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.kLP = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.kjt);
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
                                        if (this.jVI.getType() != 3) {
                                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                                        }
                                        this.jVI.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str3 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.kjt);
                                        str = jSONObject2.optString("tid");
                                        str2 = jSONObject2.optString("pid");
                                        str3 = jSONObject2.optString("msg");
                                        customDialogData2 = com.baidu.tieba.pb.c.dd(jSONObject2);
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
                                            if (this.jVI != null) {
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
                                            super.onPostExecute(zVar);
                                        }
                                        postWriteCallBackData.setThreadId(str7);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        if (this.jVI != null) {
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
                                        super.onPostExecute(zVar);
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
                        if (this.jVI.getType() != 3 && this.jVI.getType() != 7) {
                            c.g(VcodeActivity.this.getActivity(), str10, str8, str11);
                        }
                        this.jVI.deleteUploadedTempImages();
                    } else if (this.jVI.isHasImages() && k.isEmpty(this.jVI.getContent() + this.jVI.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.jVI.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    str3 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.kjt);
                        str = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        customDialogData2 = com.baidu.tieba.pb.c.dd(jSONObject22);
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
                    if (this.jVI != null) {
                        postWriteCallBackData2.setProZone(this.jVI.getProZone());
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        if (this.jVI != null) {
                            switch (this.jVI.getType()) {
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
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
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
                } else if (this.jVI.isHasImages() && k.isEmpty(this.jVI.getContent() + this.jVI.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        z zVar2 = new z();
                        zVar2.parserJson(this.kjt);
                        if (zVar2.getVcode_pic_url() != null && VcodeActivity.this.kPu != null) {
                            VcodeActivity.this.kPu.setVcodeMD5(zVar2.getVcode_md5());
                            VcodeActivity.this.kPu.setVcodeUrl(zVar2.getVcode_pic_url());
                            VcodeActivity.this.KJ(VcodeActivity.this.kPu.getVcodeUrl());
                        }
                        VcodeActivity.this.fgP.setText((CharSequence) null);
                    } else if (this.jVI != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.kjt);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.jVI, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.kjt != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.kjt);
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
            super.onPostExecute(zVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile x cHA;
        z kPA;
        private volatile boolean mCanceled;

        private a() {
            this.cHA = null;
            this.kPA = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.kPw = null;
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.kPu == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.cHA.addPostData("fid", VcodeActivity.this.kPu.getForumId());
                this.cHA.addPostData("kw", VcodeActivity.this.kPu.getForumName());
                this.cHA.addPostData("new_vcode", "1");
                this.cHA.addPostData("title", VcodeActivity.this.kPu.getTitle());
                this.cHA.addPostData("content", VcodeActivity.this.kPu.getContent());
                if (VcodeActivity.this.kPu.getType() == 0) {
                    this.cHA.addPostData("pub_type", "1");
                    if (VcodeActivity.this.kPu.getCategoryFrom() >= 0) {
                        this.cHA.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.kPu.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.kPu.getCategoryTo() >= 0) {
                        this.cHA.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.kPu.getCategoryTo()));
                    }
                } else {
                    this.cHA.addPostData("pub_type", "2");
                    this.cHA.addPostData("tid", VcodeActivity.this.kPu.getThreadId());
                }
                String postNetData = this.cHA.postNetData();
                if (!this.cHA.aDU().aEv().isRequestSuccess()) {
                    return null;
                }
                this.kPA = new z();
                this.kPA.parserJson(postNetData);
                str = this.kPA.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.cHA = new x(str);
            return BitmapHelper.Bytes2Bitmap(this.cHA.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.kPw = null;
            if (bitmap != null) {
                VcodeActivity.this.dTY.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.kPA != null && VcodeActivity.this.kPu != null) {
                VcodeActivity.this.kPu.setVcodeMD5(this.kPA.getVcode_md5());
                VcodeActivity.this.kPu.setVcodeUrl(this.kPA.getVcode_pic_url());
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
