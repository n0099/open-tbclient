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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.tencent.connect.common.Constants;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.s.c.h0;
import d.b.j0.d3.q0.g;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    public static final String FORUM_ID = "forum_id";
    public static final String IS_AD = "is_ad";
    public static final String KEY_NAME_SHOW = "name_show";
    public WriteData mModel = null;
    public TextView mPost = null;
    public ImageView mImage = null;
    public EditText mEdit = null;
    public ProgressBar mProgressBar = null;
    public f mPostThreadTask = null;
    public e mGetImageTask = null;
    public InputMethodManager mInputManager = null;
    public DialogInterface.OnCancelListener mDialogCancelListener = null;
    public RelativeLayout mParent = null;
    public TextView mInfo = null;
    public NavigationBar mNavigationBar = null;
    public boolean isVcodeCheckSuccess = false;
    public final View.OnClickListener onBackListener = new b();
    public final View.OnClickListener onPostListener = new c();

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            VcodeActivity.this.destroyWaitingDialog();
            if (VcodeActivity.this.mPostThreadTask != null) {
                VcodeActivity.this.mPostThreadTask.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity vcodeActivity = VcodeActivity.this;
            vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, VcodeActivity.this.mEdit);
            VcodeActivity.this.showDialog();
            if (VcodeActivity.this.mPostThreadTask != null) {
                VcodeActivity.this.mPostThreadTask.cancel();
            }
            VcodeActivity.this.isVcodeCheckSuccess = false;
            VcodeActivity vcodeActivity2 = VcodeActivity.this;
            VcodeActivity vcodeActivity3 = VcodeActivity.this;
            vcodeActivity2.mPostThreadTask = new f(vcodeActivity3.mModel);
            VcodeActivity.this.mPostThreadTask.setPriority(3);
            VcodeActivity.this.mPostThreadTask.execute(0);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VcodeActivity.this.refreshImage((String) null);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f22034a;

        /* renamed from: b  reason: collision with root package name */
        public h0 f22035b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f22036c;

        public e() {
            this.f22034a = null;
            this.f22035b = null;
            this.f22036c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            if (VcodeActivity.this.mModel == null) {
                return null;
            }
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.f22034a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.f22034a.addPostData("fid", VcodeActivity.this.mModel.getForumId());
                this.f22034a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, VcodeActivity.this.mModel.getForumName());
                this.f22034a.addPostData("new_vcode", "1");
                this.f22034a.addPostData("title", VcodeActivity.this.mModel.getTitle());
                this.f22034a.addPostData("content", VcodeActivity.this.mModel.getContent());
                if (VcodeActivity.this.mModel.getType() == 0) {
                    this.f22034a.addPostData("pub_type", "1");
                    if (VcodeActivity.this.mModel.getCategoryFrom() >= 0) {
                        this.f22034a.addPostData("fromCategoryId", String.valueOf(VcodeActivity.this.mModel.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.mModel.getCategoryTo() >= 0) {
                        this.f22034a.addPostData("toCategoryId", String.valueOf(VcodeActivity.this.mModel.getCategoryTo()));
                    }
                } else {
                    this.f22034a.addPostData("pub_type", "2");
                    this.f22034a.addPostData("tid", VcodeActivity.this.mModel.getThreadId());
                }
                String postNetData = this.f22034a.postNetData();
                if (!this.f22034a.getNetContext().getResponse().isRequestSuccess()) {
                    return null;
                }
                h0 h0Var = new h0();
                this.f22035b = h0Var;
                h0Var.e(postNetData);
                str = this.f22035b.c();
            }
            if (this.f22036c) {
                return null;
            }
            this.f22034a = new NetWork(str);
            return BitmapHelper.Bytes2Bitmap(this.f22034a.getNetData());
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.mGetImageTask = null;
            if (this.f22034a != null) {
                this.f22034a.cancelNetConnect();
            }
            this.f22036c = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.mGetImageTask = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.f22035b != null && VcodeActivity.this.mModel != null) {
                VcodeActivity.this.mModel.setVcodeMD5(this.f22035b.b());
                VcodeActivity.this.mModel.setVcodeUrl(this.f22035b.c());
            }
            super.onPostExecute((e) bitmap);
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Integer, Integer, h0> {

        /* renamed from: a  reason: collision with root package name */
        public WriteData f22038a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f22039b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f22040c = null;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f22042e;

            public a(CustomDialogData customDialogData) {
                this.f22042e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.j0.d2.j.c.a(VcodeActivity.this.getPageContext(), this.f22042e).show();
            }
        }

        public f(WriteData writeData) {
            this.f22038a = null;
            this.f22038a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public h0 doInBackground(Integer... numArr) {
            String str;
            Address h2;
            if (this.f22038a == null) {
                return null;
            }
            this.f22039b = new NetWork();
            String obj = VcodeActivity.this.mEdit.getText().toString();
            String imagesCodeForPost = this.f22038a.getImagesCodeForPost();
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.f22039b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (this.f22038a.getType() == 3) {
                this.f22039b.addPostData("newVcode", "1");
                this.f22039b.addPostData("content", this.f22038a.getContent() + imagesCodeForPost);
                this.f22039b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.f22038a.getVcodeMD5());
                if (obj.length() > 0) {
                    this.f22039b.addPostData("vcode", obj);
                }
                this.f22039b.addPostData("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                this.f22039b.getNetContext().getRequest().mIsNeedTbs = true;
                this.f22039b.addPostData("content", this.f22038a.getContent() + imagesCodeForPost);
                this.f22039b.setUrl(d.b.j0.d3.i0.a.m);
                this.f22039b.addPostData("fname", this.f22038a.getForumName());
                this.f22039b.addPostData("title", this.f22038a.getTitle());
                this.f22039b.addPostData("apiKey", this.f22038a.getShareApiKey());
                this.f22039b.addPostData("appName", this.f22038a.getShareAppName());
                this.f22039b.addPostData("signKey", this.f22038a.getShareSignKey());
                this.f22039b.addPostData("summary_title", this.f22038a.getShareSummaryTitle());
                this.f22039b.addPostData("summary_content", this.f22038a.getShareSummaryContent());
                this.f22039b.addPostData("summary_img", this.f22038a.getShareSummaryImg());
                this.f22039b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.f22038a.getShareSummaryImgWidth()));
                this.f22039b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.f22038a.getShareSummaryImgHeight()));
                this.f22039b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.f22038a.getShareSummaryImgType());
                this.f22039b.addPostData("referUrl", this.f22038a.getShareReferUrl());
            } else {
                this.f22039b.addPostData("anonymous", "0");
                this.f22039b.addPostData("fid", this.f22038a.getForumId());
                this.f22039b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f22038a.getForumName());
                if (this.f22038a.getProZone() >= 0) {
                    this.f22039b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.f22038a.getProZone()));
                }
                this.f22039b.addPostData("can_no_forum", this.f22038a.isCanNoForum() ? "1" : "0");
                this.f22039b.addPostData("is_feedback", this.f22038a.isUserFeedback() ? "1" : "0");
                this.f22039b.addPostData("new_vcode", "1");
                String content = TextUtils.isEmpty(this.f22038a.getSpanGroupString()) ? this.f22038a.getContent() : this.f22038a.getSpanGroupString();
                VideoInfo videoInfo = this.f22038a.getVideoInfo();
                if (videoInfo != null && videoInfo.hasUpload()) {
                    str = content + videoInfo.buildContent() + imagesCodeForPost;
                } else {
                    str = content + imagesCodeForPost;
                }
                this.f22039b.addPostData("content", d.b.j0.k0.a.b(str));
                g.a(this.f22039b, this.f22038a);
                this.f22039b.addPostData("vcode_md5", this.f22038a.getVcodeMD5());
                if (obj.length() > 0) {
                    this.f22039b.addPostData("vcode", obj);
                }
                this.f22039b.getNetContext().getRequest().mIsNeedTbs = true;
                if (this.f22038a.getVoice() != null) {
                    this.f22039b.addPostData("voice_md5", this.f22038a.getVoice());
                    this.f22039b.addPostData("during_time", String.valueOf(this.f22038a.getVoiceDuringTime()));
                }
                if (!TextUtils.isEmpty(this.f22038a.getTopicId())) {
                    this.f22039b.addPostData("topic_id", this.f22038a.getTopicId());
                }
                if (this.f22038a.getType() != 0 && this.f22038a.getType() != 9 && this.f22038a.getType() != 7) {
                    if (this.f22038a.getType() == 6) {
                        this.f22039b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.f22039b.addPostData("title", this.f22038a.getTitle());
                        this.f22039b.addPostData("is_ntitle", this.f22038a.isNoTitle() ? "1" : "0");
                        this.f22039b.addPostData("thread_type", String.valueOf(36));
                    } else if (this.f22038a.getType() == 4) {
                        this.f22039b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        this.f22039b.addPostData("title", this.f22038a.getTitle());
                        this.f22039b.addPostData("is_ntitle", "0");
                        this.f22039b.addPostData("thread_type", String.valueOf(33));
                        this.f22039b.addPostData("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.f22039b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                        this.f22039b.addPostData("tid", this.f22038a.getThreadId());
                        this.f22039b.addPostData("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.f22038a.getBaijiahaoData() != null) {
                            this.f22039b.addPostData("ori_ugc_nid", this.f22038a.getBaijiahaoData().oriUgcNid);
                            this.f22039b.addPostData("ori_ugc_tid", this.f22038a.getBaijiahaoData().oriUgcTid);
                            this.f22039b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22038a.getBaijiahaoData().oriUgcType));
                            this.f22039b.addPostData("ori_ugc_vid", this.f22038a.getBaijiahaoData().oriUgcVid);
                        }
                        if (this.f22038a.getType() == 2) {
                            this.f22039b.addPostData("quote_id", String.valueOf(this.f22038a.getFloor()));
                            this.f22039b.addPostData("floor_num", String.valueOf(this.f22038a.getFloorNum()));
                            this.f22039b.addPostData("is_addition", this.f22038a.isAddition() ? "1" : "0");
                            if (this.f22038a.getRepostId() != null) {
                                this.f22039b.addPostData("repostid", this.f22038a.getRepostId());
                            }
                            this.f22039b.addPostData("v_fid", this.f22038a.getVForumId());
                            this.f22039b.addPostData("v_fname", this.f22038a.getVForumName());
                        } else if (this.f22038a.getType() == 5) {
                            this.f22039b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.f22038a.getType() == 1) {
                            this.f22039b.addPostData("is_barrage", !this.f22038a.isBarrage() ? "0" : "1");
                            this.f22039b.addPostData("barrage_time", String.valueOf(this.f22038a.getBarrageTime()));
                            if (d.b.i0.w.w.a.a().b() == 1) {
                                this.f22039b.addPostData("ptype", "4");
                            }
                            this.f22039b.addPostData("v_fid", this.f22038a.getVForumId());
                            this.f22039b.addPostData("v_fname", this.f22038a.getVForumName());
                        }
                    }
                } else {
                    this.f22039b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    if (this.f22038a.getType() == 0 || this.f22038a.getType() == 9) {
                        this.f22039b.addPostData("transform_forums", this.f22038a.getTransmitForumData());
                        this.f22039b.addPostData(IntentConfig.CALL_FROM, this.f22038a.getStatisticFrom() + "");
                        if (this.f22038a.getRecommendExt() != null) {
                            this.f22039b.addPostData("recommend_ext", this.f22038a.getRecommendExt());
                        }
                    }
                    this.f22039b.addPostData("title", this.f22038a.getTitle());
                    this.f22039b.addPostData("is_ntitle", this.f22038a.isNoTitle() ? "1" : "0");
                    if (this.f22038a.getType() == 7) {
                        this.f22039b.addPostData("is_bottle", String.valueOf(1));
                    }
                    if (this.f22038a.getCategoryFrom() >= 0) {
                        this.f22039b.addPostData("fromCategoryId", String.valueOf(this.f22038a.getCategoryFrom()));
                    }
                    if (this.f22038a.getCategoryTo() >= 0) {
                        this.f22039b.addPostData("toCategoryId", String.valueOf(this.f22038a.getCategoryTo()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (h2 = d.b.c.e.i.a.l().h(false)) != null) {
                        this.f22039b.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                    }
                    if (this.f22038a.isShareThread()) {
                        this.f22039b.addPostData("is_share", "1");
                        this.f22039b.addPostData("from_tid", this.f22038a.getOriginalThreadId());
                    }
                    if (this.f22038a.isShareThread()) {
                        if (this.f22038a.getOriBaijiahaoData() != null) {
                            this.f22039b.addPostData("ori_ugc_nid", this.f22038a.getOriBaijiahaoData().oriUgcNid);
                            this.f22039b.addPostData("ori_ugc_vid", this.f22038a.getOriBaijiahaoData().oriUgcVid);
                            this.f22039b.addPostData("ori_ugc_tid", this.f22038a.getOriBaijiahaoData().oriUgcTid);
                            this.f22039b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22038a.getOriBaijiahaoData().oriUgcType));
                        }
                    } else if (this.f22038a.getBaijiahaoData() != null) {
                        this.f22039b.addPostData("ori_ugc_nid", this.f22038a.getBaijiahaoData().oriUgcNid);
                        this.f22039b.addPostData("ori_ugc_vid", this.f22038a.getBaijiahaoData().oriUgcVid);
                        this.f22039b.addPostData("ori_ugc_tid", this.f22038a.getBaijiahaoData().oriUgcTid);
                        this.f22039b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22038a.getBaijiahaoData().oriUgcType));
                    }
                    if (this.f22038a.getTabId() > 0) {
                        this.f22039b.addPostData("tab_name", this.f22038a.getTabName());
                        this.f22039b.addPostData("tab_id", String.valueOf(this.f22038a.getTabId()));
                        this.f22039b.addPostData("is_general_tab", String.valueOf(this.f22038a.getIsGeneralTab()));
                    }
                }
            }
            if (this.f22039b.getNetContext() != null && this.f22039b.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f22039b.getNetContext().getRequest().getNetWorkParam()));
            }
            this.f22040c = this.f22039b.postNetData();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0181, code lost:
            if (r0 != 7) goto L64;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0121 A[Catch: JSONException -> 0x0129, TRY_LEAVE, TryCatch #5 {JSONException -> 0x0129, blocks: (B:50:0x0119, B:52:0x0121), top: B:158:0x0119 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01b1  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(h0 h0Var) {
            JSONArray jSONArray;
            PostWriteCallBackData postWriteCallBackData;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            CustomDialogData customDialogData;
            WriteData writeData;
            JSONObject optJSONObject;
            String str4;
            String str5;
            String str6;
            String str7 = "";
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.mPostThreadTask = null;
            NetWork netWork = this.f22039b;
            if (netWork != null) {
                int i = 0;
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.f22040c);
                    if (errorData.error_code == 0) {
                        VcodeActivity.this.isVcodeCheckSuccess = true;
                        try {
                            JSONObject jSONObject = new JSONObject(this.f22040c);
                            str4 = jSONObject.optString("msg");
                            try {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                if (optJSONObject2 != null) {
                                    str5 = optJSONObject2.optString("pre_msg");
                                    if (StringUtils.isNull(str5)) {
                                        str5 = null;
                                    }
                                    try {
                                        str6 = optJSONObject2.optString("color_msg");
                                    } catch (JSONException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        str6 = null;
                                        if (StringUtils.isNull(str4)) {
                                        }
                                        if (this.f22038a.getType() != 3) {
                                            g.b(VcodeActivity.this.getActivity(), str4, str5, str6);
                                        }
                                        this.f22038a.deleteUploadedTempImages();
                                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        JSONObject jSONObject2 = new JSONObject(this.f22040c);
                                        String str8 = jSONObject2.optString("tid");
                                        try {
                                            str2 = jSONObject2.optString("pid");
                                            try {
                                                str3 = jSONObject2.optString("msg");
                                                try {
                                                    str7 = jSONObject2.optString("video_id");
                                                    customDialogData = d.b.j0.d2.b.a(jSONObject2);
                                                    try {
                                                        optJSONObject = jSONObject2.optJSONObject("twzhibo_info");
                                                        if (optJSONObject != null) {
                                                        }
                                                    } catch (JSONException e3) {
                                                        e = e3;
                                                        jSONException = e;
                                                        str = str7;
                                                        str7 = str8;
                                                        jSONException.printStackTrace();
                                                        str8 = str7;
                                                        str7 = str;
                                                        postWriteCallBackData.setThreadId(str8);
                                                        postWriteCallBackData.setPostId(str2);
                                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                                        postWriteCallBackData.setErrorString(str3);
                                                        postWriteCallBackData.setVideoid(str7);
                                                        writeData = this.f22038a;
                                                        if (writeData != null) {
                                                        }
                                                        postWriteCallBackData.setActivityDialog(customDialogData);
                                                        if (customDialogData != null) {
                                                        }
                                                        Intent intent = new Intent();
                                                        Bundle bundle = new Bundle();
                                                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                        intent.putExtras(bundle);
                                                        VcodeActivity.this.setResult(-1, intent);
                                                        if (this.f22038a != null) {
                                                        }
                                                        VcodeActivity.this.finish();
                                                        super.onPostExecute(h0Var);
                                                    }
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                    customDialogData = null;
                                                }
                                            } catch (JSONException e5) {
                                                e = e5;
                                                str3 = "";
                                                customDialogData = null;
                                                str7 = str8;
                                                jSONException = e;
                                                str = str3;
                                                jSONException.printStackTrace();
                                                str8 = str7;
                                                str7 = str;
                                                postWriteCallBackData.setThreadId(str8);
                                                postWriteCallBackData.setPostId(str2);
                                                postWriteCallBackData.setIsCopyTWZhibo(i);
                                                postWriteCallBackData.setErrorString(str3);
                                                postWriteCallBackData.setVideoid(str7);
                                                writeData = this.f22038a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent2 = new Intent();
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent2.putExtras(bundle2);
                                                VcodeActivity.this.setResult(-1, intent2);
                                                if (this.f22038a != null) {
                                                    d.b.j0.d3.q0.a.f().q(this.f22038a.getForumId());
                                                    d.b.j0.d3.q0.a.f().r(this.f22038a.getForumName());
                                                    if (!k.isEmpty(postWriteCallBackData.getVideoid())) {
                                                        postWriteCallBackData.writeDataForVideo = this.f22038a;
                                                    }
                                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, d.b.j0.d3.q0.a.f().e()));
                                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                                    d.b.j0.d3.q0.a.f().o(null);
                                                }
                                                VcodeActivity.this.finish();
                                                super.onPostExecute(h0Var);
                                            }
                                        } catch (JSONException e6) {
                                            e = e6;
                                            str2 = "";
                                            str3 = str2;
                                        }
                                        postWriteCallBackData.setThreadId(str8);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str3);
                                        postWriteCallBackData.setVideoid(str7);
                                        writeData = this.f22038a;
                                        if (writeData != null) {
                                        }
                                        postWriteCallBackData.setActivityDialog(customDialogData);
                                        if (customDialogData != null) {
                                        }
                                        Intent intent22 = new Intent();
                                        Bundle bundle22 = new Bundle();
                                        bundle22.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent22.putExtras(bundle22);
                                        VcodeActivity.this.setResult(-1, intent22);
                                        if (this.f22038a != null) {
                                        }
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(h0Var);
                                    }
                                } else {
                                    str6 = null;
                                    str5 = null;
                                }
                            } catch (JSONException e7) {
                                e = e7;
                                str5 = null;
                            }
                        } catch (JSONException e8) {
                            e = e8;
                            str4 = null;
                            str5 = null;
                        }
                        if (StringUtils.isNull(str4)) {
                            str4 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                        }
                        if (this.f22038a.getType() != 3 && this.f22038a.getType() != 7) {
                            g.b(VcodeActivity.this.getActivity(), str4, str5, str6);
                        }
                        this.f22038a.deleteUploadedTempImages();
                    } else {
                        if (this.f22038a.isHasImages()) {
                            if (k.isEmpty(this.f22038a.getContent() + this.f22038a.getImagesCodeForPost())) {
                                VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                            }
                        }
                        if (this.f22038a.getType() != 3) {
                            VcodeActivity.this.showToast(errorData.getError_msg());
                        }
                    }
                    postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    try {
                        JSONObject jSONObject22 = new JSONObject(this.f22040c);
                        String str82 = jSONObject22.optString("tid");
                        str2 = jSONObject22.optString("pid");
                        str3 = jSONObject22.optString("msg");
                        str7 = jSONObject22.optString("video_id");
                        customDialogData = d.b.j0.d2.b.a(jSONObject22);
                        optJSONObject = jSONObject22.optJSONObject("twzhibo_info");
                        if (optJSONObject != null) {
                            i = optJSONObject.optInt("is_copytwzhibo", 0);
                        }
                    } catch (JSONException e9) {
                        jSONException = e9;
                        str = "";
                        str2 = str;
                        str3 = str2;
                        customDialogData = null;
                    }
                    postWriteCallBackData.setThreadId(str82);
                    postWriteCallBackData.setPostId(str2);
                    postWriteCallBackData.setIsCopyTWZhibo(i);
                    postWriteCallBackData.setErrorString(str3);
                    postWriteCallBackData.setVideoid(str7);
                    writeData = this.f22038a;
                    if (writeData != null) {
                        postWriteCallBackData.setProZone(writeData.getProZone());
                    }
                    postWriteCallBackData.setActivityDialog(customDialogData);
                    if (customDialogData != null) {
                        WriteData writeData2 = this.f22038a;
                        if (writeData2 != null) {
                            int type = writeData2.getType();
                            if (type != 0) {
                                if (type == 1 || type == 2) {
                                    customDialogData.type = 1;
                                } else if (type != 4) {
                                    if (type != 9) {
                                        if (type != 6) {
                                        }
                                    }
                                }
                            }
                            customDialogData.type = 2;
                        }
                        d.b.c.e.m.e.a().postDelayed(new a(customDialogData), 2000L);
                    }
                    Intent intent222 = new Intent();
                    Bundle bundle222 = new Bundle();
                    bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent222.putExtras(bundle222);
                    VcodeActivity.this.setResult(-1, intent222);
                    if (this.f22038a != null && d.b.j0.d3.q0.a.f().e() != null) {
                        d.b.j0.d3.q0.a.f().q(this.f22038a.getForumId());
                        d.b.j0.d3.q0.a.f().r(this.f22038a.getForumName());
                        if (!k.isEmpty(postWriteCallBackData.getVideoid()) && this.f22038a.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = this.f22038a;
                        }
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, d.b.j0.d3.q0.a.f().e()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        d.b.j0.d3.q0.a.f().o(null);
                    }
                    VcodeActivity.this.finish();
                } else {
                    if (this.f22038a.isHasImages()) {
                        if (k.isEmpty(this.f22038a.getContent() + this.f22038a.getImagesCodeForPost())) {
                            VcodeActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                        }
                    }
                    if (this.f22039b.getServerErrorCode() != 5 && this.f22039b.getServerErrorCode() != 6) {
                        if (this.f22038a != null && this.f22039b.getServerErrorCode() == 227001) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.f22040c);
                            PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.f22039b.getServerErrorCode(), this.f22039b.getErrorString(), null, null);
                            postWriteCallBackData2.setAccessState(accessState);
                            VcodeActivity.this.getActivity().setVisible(false);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.f22038a, postWriteCallBackData2.getAccessState())));
                        } else if (this.f22039b.getServerErrorCode() == 220009) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.f22039b.getErrorString()));
                            VcodeActivity.this.finish();
                        } else if (this.f22039b.getServerErrorCode() == 220015) {
                            PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                            if (this.f22040c != null) {
                                try {
                                    JSONObject jSONObject3 = new JSONObject(this.f22040c);
                                    postWriteCallBackData3.setErrorString(jSONObject3.optString("msg"));
                                    postWriteCallBackData3.setThreadId(jSONObject3.optString("tid"));
                                    postWriteCallBackData3.setPostId(jSONObject3.optString("pid"));
                                    JSONObject optJSONObject3 = jSONObject3.optJSONObject("info");
                                    if (optJSONObject3 != null && (jSONArray = optJSONObject3.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                        int length = jSONArray.length();
                                        ArrayList<String> arrayList = new ArrayList<>();
                                        for (int i2 = 0; i2 < length; i2++) {
                                            arrayList.add(jSONArray.optString(i2));
                                        }
                                        postWriteCallBackData3.setSensitiveWords(arrayList);
                                    }
                                } catch (JSONException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            Intent intent3 = new Intent();
                            Bundle bundle3 = new Bundle();
                            bundle3.putSerializable("post_write_callback_data", postWriteCallBackData3);
                            intent3.putExtras(bundle3);
                            VcodeActivity.this.setResult(0, intent3);
                            VcodeActivity.this.finish();
                        }
                    } else {
                        h0 h0Var2 = new h0();
                        h0Var2.e(this.f22040c);
                        if (h0Var2.c() != null && VcodeActivity.this.mModel != null) {
                            VcodeActivity.this.mModel.setVcodeMD5(h0Var2.b());
                            VcodeActivity.this.mModel.setVcodeUrl(h0Var2.c());
                            VcodeActivity vcodeActivity = VcodeActivity.this;
                            vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    if (this.f22039b.getServerErrorCode() != 227001 && this.f22039b.getServerErrorCode() == 220015) {
                        VcodeActivity.this.showToast(this.f22039b.getErrorString());
                    }
                }
            }
            super.onPostExecute(h0Var);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.mPostThreadTask = null;
            VcodeActivity.this.closeLoadingDialog();
            NetWork netWork = this.f22039b;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new a();
        if (bundle != null) {
            String string = bundle.getString("model");
            if (!StringUtils.isNull(string)) {
                this.mModel = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
            }
        } else {
            this.mModel = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mInfo = (TextView) findViewById(R.id.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.onPostListener);
        this.mPost = addTextButton;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(R.id.input);
        ImageView imageView = (ImageView) findViewById(R.id.vcode_image);
        this.mImage = imageView;
        imageView.setImageDrawable(null);
        this.mImage.setOnClickListener(new d());
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String str) {
        e eVar = this.mGetImageTask;
        if (eVar != null) {
            eVar.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        e eVar2 = new e(this, null);
        this.mGetImageTask = eVar2;
        eVar2.setPriority(3);
        this.mGetImageTask.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        d.b.i0.r.f0.a aVar = new d.b.i0.r.f0.a(getPageContext());
        this.mWaitingDialog = aVar;
        aVar.i(R.string.sending);
        this.mWaitingDialog.e(this.mDialogCancelListener);
        this.mWaitingDialog.d(false);
        this.mWaitingDialog.g(false);
        this.mWaitingDialog.h(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12006) {
                setResult(-1, intent);
            }
        } else if (i2 == 0 && i == 12006) {
            setResult(0, intent);
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBgColor(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setBackgroundResource(this.mPost, R.drawable.s_navbar_button_bg);
        SkinManager.setViewTextColor(this.mPost, R.color.CAM_X0111);
        this.mInfo.setTextColor((i == 1 || i == 4) ? SkinManager.getCommentTextColor(i) : -12895429);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        initUI();
        initData(bundle);
        WriteData writeData = this.mModel;
        if (writeData != null) {
            refreshImage(writeData.getVcodeUrl());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.mPostThreadTask;
        if (fVar != null) {
            fVar.cancel();
        }
        e eVar = this.mGetImageTask;
        if (eVar != null) {
            eVar.cancel();
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.mModel));
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        WriteData writeData = this.mModel;
        if (writeData == null || writeData.getType() != 3) {
            return;
        }
        f fVar = this.mPostThreadTask;
        if (fVar != null) {
            fVar.cancel();
        }
        e eVar = this.mGetImageTask;
        if (eVar != null) {
            eVar.cancel();
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        d.b.i0.r.a0.b.g(getPageContext().getPageActivity(), 200, false);
        finish();
    }
}
