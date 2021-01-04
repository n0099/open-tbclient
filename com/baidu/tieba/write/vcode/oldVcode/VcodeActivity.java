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
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData obI = null;
    private TextView lPZ = null;
    private ImageView giH = null;
    private EditText msU = null;
    private ProgressBar mProgressBar = null;
    private b obJ = null;
    private a obK = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private RelativeLayout ltF = null;
    private TextView iUe = null;
    protected NavigationBar mNavigationBar = null;
    private boolean nYb = false;
    private final View.OnClickListener obL = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener obM = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.msU);
            VcodeActivity.this.SY();
            if (VcodeActivity.this.obJ != null) {
                VcodeActivity.this.obJ.cancel();
            }
            VcodeActivity.this.nYb = false;
            VcodeActivity.this.obJ = new b(VcodeActivity.this.obI);
            VcodeActivity.this.obJ.setPriority(3);
            VcodeActivity.this.obJ.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.obI != null) {
            Vr(this.obI.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.obJ != null) {
                    VcodeActivity.this.obJ.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.obI = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.obI = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.obI != null && this.obI.getType() == 3) {
            if (this.obJ != null) {
                this.obJ.cancel();
            }
            if (this.obK != null) {
                this.obK.cancel();
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
        if (this.obJ != null) {
            this.obJ.cancel();
        }
        if (this.obK != null) {
            this.obK.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.obI));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        ao.setBgColor(this.ltF, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundResource(this.lPZ, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lPZ, R.color.CAM_X0111);
        if (i == 1 || i == 4) {
            commentTextColor = ao.getCommentTextColor(i);
        } else {
            commentTextColor = -12895429;
        }
        this.iUe.setTextColor(commentTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY() {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mWaitingDialog.setTipString(R.string.sending);
        this.mWaitingDialog.setCancelListener(this.iVZ);
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    private void initUI() {
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iUe = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.obL);
        this.lPZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.obM);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPZ.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.lPZ.setLayoutParams(layoutParams);
        this.msU = (EditText) findViewById(R.id.input);
        this.giH = (ImageView) findViewById(R.id.vcode_image);
        this.giH.setImageDrawable(null);
        this.giH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.Vr(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr(String str) {
        if (this.obK != null) {
            this.obK.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.giH.setImageDrawable(null);
        this.obK = new a();
        this.obK.setPriority(3);
        this.obK.execute(str);
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Integer, Integer, ah> {
        private WriteData ngI;
        private z mNetwork = null;
        private String nvY = null;

        public b(WriteData writeData) {
            this.ngI = null;
            this.ngI = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public ah doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.ngI != null) {
                this.mNetwork = new z();
                String obj = VcodeActivity.this.msU.getText().toString();
                String imagesCodeForPost = this.ngI.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.ngI.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.ngI.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.ngI.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mNetwork.bvQ().bwz().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.ngI.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.nsK);
                    this.mNetwork.addPostData("fname", this.ngI.getForumName());
                    this.mNetwork.addPostData("title", this.ngI.getTitle());
                    this.mNetwork.addPostData("apiKey", this.ngI.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.ngI.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.ngI.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.ngI.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.ngI.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.ngI.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.ngI.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.ngI.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ngI.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.ngI.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.ngI.getForumId());
                    this.mNetwork.addPostData("kw", this.ngI.getForumName());
                    if (this.ngI.getProZone() >= 0) {
                        this.mNetwork.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.ngI.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.ngI.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.ngI.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.ngI.getSpanGroupString()) ? this.ngI.getContent() : this.ngI.getSpanGroupString();
                    VideoInfo videoInfo = this.ngI.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = content + imagesCodeForPost;
                    } else {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.JS(str));
                    g.a(this.mNetwork, this.ngI);
                    this.mNetwork.addPostData("vcode_md5", this.ngI.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.bvQ().bwz().mIsNeedTbs = true;
                    if (this.ngI.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.ngI.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.ngI.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.ngI.getTopicId())) {
                        this.mNetwork.addPostData("topic_id", this.ngI.getTopicId());
                    }
                    if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.ngI.getType() == 0 || this.ngI.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.ngI.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.ngI.getStatisticFrom() + "");
                            if (this.ngI.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.ngI.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.ngI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.ngI.isNoTitle() ? "1" : "0");
                        if (this.ngI.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.ngI.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.ngI.getCategoryFrom()));
                        }
                        if (this.ngI.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.ngI.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.lI().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                        }
                        if (this.ngI.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.ngI.getOriginalThreadId());
                        }
                        if (this.ngI.isShareThread()) {
                            if (this.ngI.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.ngI.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.ngI.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.ngI.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngI.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.ngI.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.ngI.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.ngI.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.ngI.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngI.getBaijiahaoData().oriUgcType));
                        }
                        if (this.ngI.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.ngI.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.ngI.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.ngI.getIsGeneralTab()));
                        }
                    } else if (this.ngI.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.ngI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.ngI.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.ngI.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.ngI.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.ngI.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.ngI.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.ngI.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.ngI.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngI.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.ngI.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.ngI.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.ngI.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.ngI.getFloorNum()));
                            this.mNetwork.addPostData("is_addition", this.ngI.isAddition() ? "1" : "0");
                            if (this.ngI.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.ngI.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.ngI.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.ngI.getVForumName());
                        } else if (this.ngI.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.ngI.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.ngI.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.ngI.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.bFl().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.ngI.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.ngI.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.bvQ() != null && this.mNetwork.bvQ().bwz() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.bvQ().bwz().bwD()));
                }
                this.nvY = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.obJ = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d9 A[Catch: JSONException -> 0x03d2, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03d2, blocks: (B:27:0x00d0, B:29:0x00d9), top: B:124:0x00d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(ah ahVar) {
            JSONArray jSONArray;
            final CustomDialogData customDialogData;
            int i;
            JSONObject optJSONObject;
            String str;
            String str2;
            String str3;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.obJ = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.nvY);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.nYb = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.nvY);
                            str2 = jSONObject.optString("msg");
                            try {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                if (optJSONObject2 != null) {
                                    str = optJSONObject2.optString("pre_msg");
                                    if (StringUtils.isNull(str)) {
                                        str = null;
                                    }
                                    try {
                                        str3 = optJSONObject2.optString("color_msg");
                                    } catch (JSONException e) {
                                        e = e;
                                        e.printStackTrace();
                                        str3 = null;
                                        if (StringUtils.isNull(str2)) {
                                        }
                                        if (this.ngI.getType() != 3) {
                                            g.i(VcodeActivity.this.getActivity(), str2, str, str3);
                                        }
                                        this.ngI.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        String str4 = "";
                                        String str5 = "";
                                        String str6 = "";
                                        String str7 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.nvY);
                                        str4 = jSONObject2.optString("tid");
                                        str5 = jSONObject2.optString("pid");
                                        str6 = jSONObject2.optString("msg");
                                        str7 = jSONObject2.optString("video_id");
                                        customDialogData = com.baidu.tieba.pb.b.eF(jSONObject2);
                                        try {
                                            optJSONObject = jSONObject2.optJSONObject("twzhibo_info");
                                            if (optJSONObject != null) {
                                            }
                                        } catch (JSONException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            i = 0;
                                            postWriteCallBackData.setThreadId(str4);
                                            postWriteCallBackData.setPostId(str5);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str6);
                                            postWriteCallBackData.setVideoid(str7);
                                            if (this.ngI != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData);
                                            if (customDialogData != null) {
                                            }
                                            Intent intent = new Intent();
                                            Bundle bundle = new Bundle();
                                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent.putExtras(bundle);
                                            VcodeActivity.this.setResult(-1, intent);
                                            if (this.ngI != null) {
                                            }
                                            VcodeActivity.this.finish();
                                            super.onPostExecute(ahVar);
                                        }
                                        i = 0;
                                        postWriteCallBackData.setThreadId(str4);
                                        postWriteCallBackData.setPostId(str5);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str6);
                                        postWriteCallBackData.setVideoid(str7);
                                        if (this.ngI != null) {
                                        }
                                        postWriteCallBackData.setActivityDialog(customDialogData);
                                        if (customDialogData != null) {
                                        }
                                        Intent intent2 = new Intent();
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent2.putExtras(bundle2);
                                        VcodeActivity.this.setResult(-1, intent2);
                                        if (this.ngI != null) {
                                        }
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(ahVar);
                                    }
                                } else {
                                    str3 = null;
                                    str = null;
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                str = null;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            str = null;
                            str2 = null;
                        }
                        if (StringUtils.isNull(str2)) {
                            str2 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                        }
                        if (this.ngI.getType() != 3 && this.ngI.getType() != 7) {
                            g.i(VcodeActivity.this.getActivity(), str2, str, str3);
                        }
                        this.ngI.deleteUploadedTempImages();
                    } else if (this.ngI.isHasImages() && k.isEmpty(this.ngI.getContent() + this.ngI.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.ngI.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    String str42 = "";
                    String str52 = "";
                    String str62 = "";
                    String str72 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.nvY);
                        str42 = jSONObject22.optString("tid");
                        str52 = jSONObject22.optString("pid");
                        str62 = jSONObject22.optString("msg");
                        str72 = jSONObject22.optString("video_id");
                        customDialogData = com.baidu.tieba.pb.b.eF(jSONObject22);
                        optJSONObject = jSONObject22.optJSONObject("twzhibo_info");
                    } catch (JSONException e5) {
                        e = e5;
                        customDialogData = null;
                    }
                    if (optJSONObject != null) {
                        i = optJSONObject.optInt("is_copytwzhibo", 0);
                        postWriteCallBackData2.setThreadId(str42);
                        postWriteCallBackData2.setPostId(str52);
                        postWriteCallBackData2.setIsCopyTWZhibo(i);
                        postWriteCallBackData2.setErrorString(str62);
                        postWriteCallBackData2.setVideoid(str72);
                        if (this.ngI != null) {
                            postWriteCallBackData2.setProZone(this.ngI.getProZone());
                        }
                        postWriteCallBackData2.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            if (this.ngI != null) {
                                switch (this.ngI.getType()) {
                                    case 0:
                                    case 4:
                                    case 6:
                                    case 7:
                                    case 9:
                                        customDialogData.type = 2;
                                        break;
                                    case 1:
                                    case 2:
                                        customDialogData.type = 1;
                                        break;
                                }
                            }
                            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.a(VcodeActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 2000L);
                        }
                        Intent intent22 = new Intent();
                        Bundle bundle22 = new Bundle();
                        bundle22.putSerializable("post_write_callback_data", postWriteCallBackData2);
                        intent22.putExtras(bundle22);
                        VcodeActivity.this.setResult(-1, intent22);
                        if (this.ngI != null && com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH() != null) {
                            com.baidu.tieba.tbadkCore.writeModel.a.dQA().TQ(this.ngI.getForumId());
                            com.baidu.tieba.tbadkCore.writeModel.a.dQA().TR(this.ngI.getForumName());
                            if (!at.isEmpty(postWriteCallBackData2.getVideoid()) && this.ngI.getVideoInfo() != null) {
                                postWriteCallBackData2.writeDataForVideo = this.ngI;
                            }
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData2);
                            customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            com.baidu.tieba.tbadkCore.writeModel.a.dQA().D(null);
                        }
                        VcodeActivity.this.finish();
                    }
                    i = 0;
                    postWriteCallBackData2.setThreadId(str42);
                    postWriteCallBackData2.setPostId(str52);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str62);
                    postWriteCallBackData2.setVideoid(str72);
                    if (this.ngI != null) {
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData);
                    if (customDialogData != null) {
                    }
                    Intent intent222 = new Intent();
                    Bundle bundle222 = new Bundle();
                    bundle222.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent222.putExtras(bundle222);
                    VcodeActivity.this.setResult(-1, intent222);
                    if (this.ngI != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().TQ(this.ngI.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().TR(this.ngI.getForumName());
                        if (!at.isEmpty(postWriteCallBackData2.getVideoid())) {
                            postWriteCallBackData2.writeDataForVideo = this.ngI;
                        }
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData2);
                        customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().D(null);
                    }
                    VcodeActivity.this.finish();
                } else if (this.ngI.isHasImages() && k.isEmpty(this.ngI.getContent() + this.ngI.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        ah ahVar2 = new ah();
                        ahVar2.parserJson(this.nvY);
                        if (ahVar2.getVcode_pic_url() != null && VcodeActivity.this.obI != null) {
                            VcodeActivity.this.obI.setVcodeMD5(ahVar2.getVcode_md5());
                            VcodeActivity.this.obI.setVcodeUrl(ahVar2.getVcode_pic_url());
                            VcodeActivity.this.Vr(VcodeActivity.this.obI.getVcodeUrl());
                        }
                        VcodeActivity.this.msU.setText((CharSequence) null);
                    } else if (this.ngI != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.nvY);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.ngI, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.nvY != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.nvY);
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
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile z cmJ;
        private volatile boolean mCanceled;
        ah obO;

        private a() {
            this.cmJ = null;
            this.obO = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.obK = null;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.obI == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.cmJ.addPostData("fid", VcodeActivity.this.obI.getForumId());
                this.cmJ.addPostData("kw", VcodeActivity.this.obI.getForumName());
                this.cmJ.addPostData("new_vcode", "1");
                this.cmJ.addPostData("title", VcodeActivity.this.obI.getTitle());
                this.cmJ.addPostData("content", VcodeActivity.this.obI.getContent());
                if (VcodeActivity.this.obI.getType() == 0) {
                    this.cmJ.addPostData("pub_type", "1");
                    if (VcodeActivity.this.obI.getCategoryFrom() >= 0) {
                        this.cmJ.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.obI.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.obI.getCategoryTo() >= 0) {
                        this.cmJ.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.obI.getCategoryTo()));
                    }
                } else {
                    this.cmJ.addPostData("pub_type", "2");
                    this.cmJ.addPostData("tid", VcodeActivity.this.obI.getThreadId());
                }
                String postNetData = this.cmJ.postNetData();
                if (!this.cmJ.bvQ().bwA().isRequestSuccess()) {
                    return null;
                }
                this.obO = new ah();
                this.obO.parserJson(postNetData);
                str = this.obO.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.cmJ = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.cmJ.getNetData());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.obK = null;
            if (bitmap != null) {
                VcodeActivity.this.giH.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.obO != null && VcodeActivity.this.obI != null) {
                VcodeActivity.this.obI.setVcodeMD5(this.obO.getVcode_md5());
                VcodeActivity.this.obI.setVcodeUrl(this.obO.getVcode_pic_url());
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
