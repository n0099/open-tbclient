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
    private WriteData obH = null;
    private TextView lPY = null;
    private ImageView giH = null;
    private EditText msT = null;
    private ProgressBar mProgressBar = null;
    private b obI = null;
    private a obJ = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private RelativeLayout ltF = null;
    private TextView iUe = null;
    protected NavigationBar mNavigationBar = null;
    private boolean nYa = false;
    private final View.OnClickListener obK = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener obL = new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.msT);
            VcodeActivity.this.SY();
            if (VcodeActivity.this.obI != null) {
                VcodeActivity.this.obI.cancel();
            }
            VcodeActivity.this.nYa = false;
            VcodeActivity.this.obI = new b(VcodeActivity.this.obH);
            VcodeActivity.this.obI.setPriority(3);
            VcodeActivity.this.obI.execute(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        if (this.obH != null) {
            Vq(this.obH.getVcodeUrl());
        }
    }

    private void initData(Bundle bundle) {
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                VcodeActivity.this.destroyWaitingDialog();
                if (VcodeActivity.this.obI != null) {
                    VcodeActivity.this.obI.cancel();
                }
            }
        };
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.obH = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.obH = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.obH != null && this.obH.getType() == 3) {
            if (this.obI != null) {
                this.obI.cancel();
            }
            if (this.obJ != null) {
                this.obJ.cancel();
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
        if (this.obI != null) {
            this.obI.cancel();
        }
        if (this.obJ != null) {
            this.obJ.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.obH));
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int commentTextColor;
        super.onChangeSkinType(i);
        ao.setBgColor(this.ltF, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundResource(this.lPY, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.lPY, R.color.CAM_X0111);
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
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.obK);
        this.lPY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.obL);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPY.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.lPY.setLayoutParams(layoutParams);
        this.msT = (EditText) findViewById(R.id.input);
        this.giH = (ImageView) findViewById(R.id.vcode_image);
        this.giH.setImageDrawable(null);
        this.giH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.oldVcode.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VcodeActivity.this.Vq(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq(String str) {
        if (this.obJ != null) {
            this.obJ.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.giH.setImageDrawable(null);
        this.obJ = new a();
        this.obJ.setPriority(3);
        this.obJ.execute(str);
    }

    /* loaded from: classes8.dex */
    private class b extends BdAsyncTask<Integer, Integer, ah> {
        private WriteData ngH;
        private z mNetwork = null;
        private String nvX = null;

        public b(WriteData writeData) {
            this.ngH = null;
            this.ngH = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public ah doInBackground(Integer... numArr) {
            String str;
            Address address;
            if (this.ngH != null) {
                this.mNetwork = new z();
                String obj = VcodeActivity.this.msT.getText().toString();
                String imagesCodeForPost = this.ngH.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.ngH.getType() == 3) {
                    this.mNetwork.addPostData("newVcode", "1");
                    this.mNetwork.addPostData("content", this.ngH.getContent() + imagesCodeForPost);
                    this.mNetwork.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.ngH.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.addPostData("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mNetwork.bvR().bwA().mIsNeedTbs = true;
                    this.mNetwork.addPostData("content", this.ngH.getContent() + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.nsJ);
                    this.mNetwork.addPostData("fname", this.ngH.getForumName());
                    this.mNetwork.addPostData("title", this.ngH.getTitle());
                    this.mNetwork.addPostData("apiKey", this.ngH.getShareApiKey());
                    this.mNetwork.addPostData("appName", this.ngH.getShareAppName());
                    this.mNetwork.addPostData("signKey", this.ngH.getShareSignKey());
                    this.mNetwork.addPostData("summary_title", this.ngH.getShareSummaryTitle());
                    this.mNetwork.addPostData("summary_content", this.ngH.getShareSummaryContent());
                    this.mNetwork.addPostData("summary_img", this.ngH.getShareSummaryImg());
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.ngH.getShareSummaryImgWidth()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.ngH.getShareSummaryImgHeight()));
                    this.mNetwork.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ngH.getShareSummaryImgType());
                    this.mNetwork.addPostData("referUrl", this.ngH.getShareReferUrl());
                } else {
                    this.mNetwork.addPostData("anonymous", "0");
                    this.mNetwork.addPostData("fid", this.ngH.getForumId());
                    this.mNetwork.addPostData("kw", this.ngH.getForumName());
                    if (this.ngH.getProZone() >= 0) {
                        this.mNetwork.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.ngH.getProZone()));
                    }
                    this.mNetwork.addPostData("can_no_forum", this.ngH.isCanNoForum() ? "1" : "0");
                    this.mNetwork.addPostData("is_feedback", this.ngH.isUserFeedback() ? "1" : "0");
                    this.mNetwork.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.ngH.getSpanGroupString()) ? this.ngH.getContent() : this.ngH.getSpanGroupString();
                    VideoInfo videoInfo = this.ngH.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = content + imagesCodeForPost;
                    } else {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    this.mNetwork.addPostData("content", com.baidu.tieba.face.a.JR(str));
                    g.a(this.mNetwork, this.ngH);
                    this.mNetwork.addPostData("vcode_md5", this.ngH.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.mNetwork.addPostData("vcode", obj);
                    }
                    this.mNetwork.bvR().bwA().mIsNeedTbs = true;
                    if (this.ngH.getVoice() != null) {
                        this.mNetwork.addPostData("voice_md5", this.ngH.getVoice());
                        this.mNetwork.addPostData("during_time", String.valueOf(this.ngH.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.ngH.getTopicId())) {
                        this.mNetwork.addPostData("topic_id", this.ngH.getTopicId());
                    }
                    if (this.ngH.getType() == 0 || this.ngH.getType() == 9 || this.ngH.getType() == 7) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.ngH.getType() == 0 || this.ngH.getType() == 9) {
                            this.mNetwork.addPostData("transform_forums", this.ngH.getTransmitForumData());
                            this.mNetwork.addPostData("call_from", this.ngH.getStatisticFrom() + "");
                            if (this.ngH.getRecommendExt() != null) {
                                this.mNetwork.addPostData("recommend_ext", this.ngH.getRecommendExt());
                            }
                        }
                        this.mNetwork.addPostData("title", this.ngH.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.ngH.isNoTitle() ? "1" : "0");
                        if (this.ngH.getType() == 7) {
                            this.mNetwork.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.ngH.getCategoryFrom() >= 0) {
                            this.mNetwork.addPostData("fromCategoryId", String.valueOf(this.ngH.getCategoryFrom()));
                        }
                        if (this.ngH.getCategoryTo() >= 0) {
                            this.mNetwork.addPostData("toCategoryId", String.valueOf(this.ngH.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (address = com.baidu.adp.lib.c.a.lI().getAddress(false)) != null) {
                            this.mNetwork.addPostData("lbs", String.valueOf(address.getLatitude()) + "," + String.valueOf(address.getLongitude()));
                        }
                        if (this.ngH.isShareThread()) {
                            this.mNetwork.addPostData("is_share", "1");
                            this.mNetwork.addPostData("from_tid", this.ngH.getOriginalThreadId());
                        }
                        if (this.ngH.isShareThread()) {
                            if (this.ngH.getOriBaijiahaoData() != null) {
                                this.mNetwork.addPostData("ori_ugc_nid", this.ngH.getOriBaijiahaoData().oriUgcNid);
                                this.mNetwork.addPostData("ori_ugc_vid", this.ngH.getOriBaijiahaoData().oriUgcVid);
                                this.mNetwork.addPostData("ori_ugc_tid", this.ngH.getOriBaijiahaoData().oriUgcTid);
                                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngH.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.ngH.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.ngH.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_vid", this.ngH.getBaijiahaoData().oriUgcVid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.ngH.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngH.getBaijiahaoData().oriUgcType));
                        }
                        if (this.ngH.getTabId() > 0) {
                            this.mNetwork.addPostData("tab_name", this.ngH.getTabName());
                            this.mNetwork.addPostData("tab_id", String.valueOf(this.ngH.getTabId()));
                            this.mNetwork.addPostData("is_general_tab", String.valueOf(this.ngH.getIsGeneralTab()));
                        }
                    } else if (this.ngH.getType() == 6) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.ngH.getTitle());
                        this.mNetwork.addPostData("is_ntitle", this.ngH.isNoTitle() ? "1" : "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(36));
                    } else if (this.ngH.getType() == 4) {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.addPostData("title", this.ngH.getTitle());
                        this.mNetwork.addPostData("is_ntitle", "0");
                        this.mNetwork.addPostData("thread_type", String.valueOf(33));
                        this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.addPostData("tid", this.ngH.getThreadId());
                        this.mNetwork.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.ngH.getBaijiahaoData() != null) {
                            this.mNetwork.addPostData("ori_ugc_nid", this.ngH.getBaijiahaoData().oriUgcNid);
                            this.mNetwork.addPostData("ori_ugc_tid", this.ngH.getBaijiahaoData().oriUgcTid);
                            this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.ngH.getBaijiahaoData().oriUgcType));
                            this.mNetwork.addPostData("ori_ugc_vid", this.ngH.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.ngH.getType() == 2) {
                            this.mNetwork.addPostData("quote_id", String.valueOf(this.ngH.getFloor()));
                            this.mNetwork.addPostData("floor_num", String.valueOf(this.ngH.getFloorNum()));
                            this.mNetwork.addPostData("is_addition", this.ngH.isAddition() ? "1" : "0");
                            if (this.ngH.getRepostId() != null) {
                                this.mNetwork.addPostData("repostid", this.ngH.getRepostId());
                            }
                            this.mNetwork.addPostData("v_fid", this.ngH.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.ngH.getVForumName());
                        } else if (this.ngH.getType() == 5) {
                            this.mNetwork.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.ngH.getType() == 1) {
                            this.mNetwork.addPostData("is_barrage", this.ngH.isBarrage() ? "1" : "0");
                            this.mNetwork.addPostData("barrage_time", String.valueOf(this.ngH.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.bFm().getStatus() == 1) {
                                this.mNetwork.addPostData("ptype", "4");
                            }
                            this.mNetwork.addPostData("v_fid", this.ngH.getVForumId());
                            this.mNetwork.addPostData("v_fname", this.ngH.getVForumName());
                        }
                    }
                }
                if (this.mNetwork.bvR() != null && this.mNetwork.bvR().bwA() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO, this.mNetwork.bvR().bwA().bwE()));
                }
                this.nvX = this.mNetwork.postNetData();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.obI = null;
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
            VcodeActivity.this.obI = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.bvR().bwB().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.nvX);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.nYa = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.nvX);
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
                                        if (this.ngH.getType() != 3) {
                                            g.i(VcodeActivity.this.getActivity(), str2, str, str3);
                                        }
                                        this.ngH.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        String str4 = "";
                                        String str5 = "";
                                        String str6 = "";
                                        String str7 = "";
                                        JSONObject jSONObject2 = new JSONObject(this.nvX);
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
                                            if (this.ngH != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData);
                                            if (customDialogData != null) {
                                            }
                                            Intent intent = new Intent();
                                            Bundle bundle = new Bundle();
                                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent.putExtras(bundle);
                                            VcodeActivity.this.setResult(-1, intent);
                                            if (this.ngH != null) {
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
                                        if (this.ngH != null) {
                                        }
                                        postWriteCallBackData.setActivityDialog(customDialogData);
                                        if (customDialogData != null) {
                                        }
                                        Intent intent2 = new Intent();
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent2.putExtras(bundle2);
                                        VcodeActivity.this.setResult(-1, intent2);
                                        if (this.ngH != null) {
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
                        if (this.ngH.getType() != 3 && this.ngH.getType() != 7) {
                            g.i(VcodeActivity.this.getActivity(), str2, str, str3);
                        }
                        this.ngH.deleteUploadedTempImages();
                    } else if (this.ngH.isHasImages() && k.isEmpty(this.ngH.getContent() + this.ngH.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                    } else if (this.ngH.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    String str42 = "";
                    String str52 = "";
                    String str62 = "";
                    String str72 = "";
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.nvX);
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
                        if (this.ngH != null) {
                            postWriteCallBackData2.setProZone(this.ngH.getProZone());
                        }
                        postWriteCallBackData2.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            if (this.ngH != null) {
                                switch (this.ngH.getType()) {
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
                        if (this.ngH != null && com.baidu.tieba.tbadkCore.writeModel.a.dQB().dQI() != null) {
                            com.baidu.tieba.tbadkCore.writeModel.a.dQB().TP(this.ngH.getForumId());
                            com.baidu.tieba.tbadkCore.writeModel.a.dQB().TQ(this.ngH.getForumName());
                            if (!at.isEmpty(postWriteCallBackData2.getVideoid()) && this.ngH.getVideoInfo() != null) {
                                postWriteCallBackData2.writeDataForVideo = this.ngH;
                            }
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData2);
                            customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dQB().dQI()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                            com.baidu.tieba.tbadkCore.writeModel.a.dQB().D(null);
                        }
                        VcodeActivity.this.finish();
                    }
                    i = 0;
                    postWriteCallBackData2.setThreadId(str42);
                    postWriteCallBackData2.setPostId(str52);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    postWriteCallBackData2.setErrorString(str62);
                    postWriteCallBackData2.setVideoid(str72);
                    if (this.ngH != null) {
                    }
                    postWriteCallBackData2.setActivityDialog(customDialogData);
                    if (customDialogData != null) {
                    }
                    Intent intent222 = new Intent();
                    Bundle bundle222 = new Bundle();
                    bundle222.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent222.putExtras(bundle222);
                    VcodeActivity.this.setResult(-1, intent222);
                    if (this.ngH != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dQB().TP(this.ngH.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dQB().TQ(this.ngH.getForumName());
                        if (!at.isEmpty(postWriteCallBackData2.getVideoid())) {
                            postWriteCallBackData2.writeDataForVideo = this.ngH;
                        }
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData2);
                        customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dQB().dQI()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        com.baidu.tieba.tbadkCore.writeModel.a.dQB().D(null);
                    }
                    VcodeActivity.this.finish();
                } else if (this.ngH.isHasImages() && k.isEmpty(this.ngH.getContent() + this.ngH.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                } else {
                    if (this.mNetwork.getServerErrorCode() == 5 || this.mNetwork.getServerErrorCode() == 6) {
                        ah ahVar2 = new ah();
                        ahVar2.parserJson(this.nvX);
                        if (ahVar2.getVcode_pic_url() != null && VcodeActivity.this.obH != null) {
                            VcodeActivity.this.obH.setVcodeMD5(ahVar2.getVcode_md5());
                            VcodeActivity.this.obH.setVcodeUrl(ahVar2.getVcode_pic_url());
                            VcodeActivity.this.Vq(VcodeActivity.this.obH.getVcodeUrl());
                        }
                        VcodeActivity.this.msT.setText((CharSequence) null);
                    } else if (this.ngH != null && this.mNetwork.getServerErrorCode() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.nvX);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.getServerErrorCode(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, this.ngH, postWriteCallBackData3.getAccessState())));
                    } else if (this.mNetwork.getServerErrorCode() == 220009) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_UEG_VALIDATE_TIPS, this.mNetwork.getErrorString()));
                        VcodeActivity.this.finish();
                    } else if (this.mNetwork.getServerErrorCode() == 220015) {
                        PostWriteCallBackData postWriteCallBackData4 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                        if (this.nvX != null) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(this.nvX);
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
        ah obN;

        private a() {
            this.cmJ = null;
            this.obN = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.obJ = null;
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
            if (VcodeActivity.this.obH == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.cmJ.addPostData("fid", VcodeActivity.this.obH.getForumId());
                this.cmJ.addPostData("kw", VcodeActivity.this.obH.getForumName());
                this.cmJ.addPostData("new_vcode", "1");
                this.cmJ.addPostData("title", VcodeActivity.this.obH.getTitle());
                this.cmJ.addPostData("content", VcodeActivity.this.obH.getContent());
                if (VcodeActivity.this.obH.getType() == 0) {
                    this.cmJ.addPostData("pub_type", "1");
                    if (VcodeActivity.this.obH.getCategoryFrom() >= 0) {
                        this.cmJ.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.obH.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.obH.getCategoryTo() >= 0) {
                        this.cmJ.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.obH.getCategoryTo()));
                    }
                } else {
                    this.cmJ.addPostData("pub_type", "2");
                    this.cmJ.addPostData("tid", VcodeActivity.this.obH.getThreadId());
                }
                String postNetData = this.cmJ.postNetData();
                if (!this.cmJ.bvR().bwB().isRequestSuccess()) {
                    return null;
                }
                this.obN = new ah();
                this.obN.parserJson(postNetData);
                str = this.obN.getVcode_pic_url();
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
            VcodeActivity.this.obJ = null;
            if (bitmap != null) {
                VcodeActivity.this.giH.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.obN != null && VcodeActivity.this.obH != null) {
                VcodeActivity.this.obH.setVcodeMD5(this.obN.getVcode_md5());
                VcodeActivity.this.obH.setVcodeUrl(this.obN.getVcode_pic_url());
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
