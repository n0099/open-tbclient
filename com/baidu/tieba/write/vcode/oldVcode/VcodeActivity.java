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
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.t.c.m0;
import c.a.r0.t3.s0.g;
import c.a.r0.t3.s0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_ID = "forum_id";
    public static final String IS_AD = "is_ad";
    public static final String KEY_NAME_SHOW = "name_show";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isVcodeCheckSuccess;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public EditText mEdit;
    public e mGetImageTask;
    public ImageView mImage;
    public TextView mInfo;
    public InputMethodManager mInputManager;
    public WriteData mModel;
    public NavigationBar mNavigationBar;
    public RelativeLayout mParent;
    public TextView mPost;
    public f mPostThreadTask;
    public ProgressBar mProgressBar;
    public final View.OnClickListener onBackListener;
    public final View.OnClickListener onPostListener;

    /* loaded from: classes11.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50863e;

        public a(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50863e = vcodeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50863e.destroyWaitingDialog();
                if (this.f50863e.mPostThreadTask != null) {
                    this.f50863e.mPostThreadTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50864e;

        public b(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50864e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50864e.finish();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50865e;

        public c(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50865e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VcodeActivity vcodeActivity = this.f50865e;
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, this.f50865e.mEdit);
                this.f50865e.showDialog();
                if (this.f50865e.mPostThreadTask != null) {
                    this.f50865e.mPostThreadTask.cancel();
                }
                this.f50865e.isVcodeCheckSuccess = false;
                VcodeActivity vcodeActivity2 = this.f50865e;
                VcodeActivity vcodeActivity3 = this.f50865e;
                vcodeActivity2.mPostThreadTask = new f(vcodeActivity3, vcodeActivity3.mModel);
                this.f50865e.mPostThreadTask.setPriority(3);
                this.f50865e.mPostThreadTask.execute(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50866e;

        public d(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50866e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50866e.refreshImage((String) null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public m0 f50867b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f50868c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50869d;

        public e(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50869d = vcodeActivity;
            this.a = null;
            this.f50867b = null;
            this.f50868c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.f50869d.mModel == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.a.addPostData("fid", this.f50869d.mModel.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f50869d.mModel.getForumName());
                    this.a.addPostData("new_vcode", "1");
                    this.a.addPostData("title", this.f50869d.mModel.getTitle());
                    this.a.addPostData("content", this.f50869d.mModel.getContent());
                    if (this.f50869d.mModel.getType() == 0) {
                        this.a.addPostData("pub_type", "1");
                        if (this.f50869d.mModel.getCategoryFrom() >= 0) {
                            this.a.addPostData("fromCategoryId", String.valueOf(this.f50869d.mModel.getCategoryFrom()));
                        }
                        if (this.f50869d.mModel.getCategoryTo() >= 0) {
                            this.a.addPostData("toCategoryId", String.valueOf(this.f50869d.mModel.getCategoryTo()));
                        }
                    } else {
                        this.a.addPostData("pub_type", "2");
                        this.a.addPostData("tid", this.f50869d.mModel.getThreadId());
                    }
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    m0 m0Var = new m0();
                    this.f50867b = m0Var;
                    m0Var.e(postNetData);
                    str = this.f50867b.c();
                }
                if (this.f50868c) {
                    return null;
                }
                this.a = new NetWork(str);
                return BitmapHelper.Bytes2Bitmap(this.a.getNetData());
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50869d.mGetImageTask = null;
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.f50868c = true;
                this.f50869d.mProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.f50869d.mGetImageTask = null;
                if (bitmap != null) {
                    this.f50869d.mImage.setImageBitmap(bitmap);
                }
                this.f50869d.mProgressBar.setVisibility(8);
                if (this.f50867b != null && this.f50869d.mModel != null) {
                    this.f50869d.mModel.setVcodeMD5(this.f50867b.b());
                    this.f50869d.mModel.setVcodeUrl(this.f50867b.c());
                }
                super.onPostExecute((e) bitmap);
            }
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }
    }

    /* loaded from: classes11.dex */
    public class f extends BdAsyncTask<Integer, Integer, m0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f50870b;

        /* renamed from: c  reason: collision with root package name */
        public String f50871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f50872d;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f50873e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f50874f;

            public a(f fVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50874f = fVar;
                this.f50873e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.q2.t.c.a(this.f50874f.f50872d.getPageContext(), this.f50873e).show();
                }
            }
        }

        public f(VcodeActivity vcodeActivity, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50872d = vcodeActivity;
            this.a = null;
            this.f50870b = null;
            this.f50871c = null;
            this.a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public m0 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Address j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.a == null) {
                    return null;
                }
                this.f50870b = new NetWork();
                String obj = this.f50872d.mEdit.getText().toString();
                String imagesCodeForPost = this.a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.f50870b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.a.getType() == 3) {
                    this.f50870b.addPostData("newVcode", "1");
                    this.f50870b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.f50870b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f50870b.addPostData("vcode", obj);
                    }
                    this.f50870b.addPostData("tag", "11");
                    this.f50870b.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f50870b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.f50870b.setUrl(c.a.r0.t3.k0.a.m);
                    this.f50870b.addPostData("fname", this.a.getForumName());
                    this.f50870b.addPostData("title", this.a.getTitle());
                    this.f50870b.addPostData("apiKey", this.a.getShareApiKey());
                    this.f50870b.addPostData("appName", this.a.getShareAppName());
                    this.f50870b.addPostData("signKey", this.a.getShareSignKey());
                    this.f50870b.addPostData("summary_title", this.a.getShareSummaryTitle());
                    this.f50870b.addPostData("summary_content", this.a.getShareSummaryContent());
                    this.f50870b.addPostData("summary_img", this.a.getShareSummaryImg());
                    this.f50870b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.a.getShareSummaryImgWidth()));
                    this.f50870b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.a.getShareSummaryImgHeight()));
                    this.f50870b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.a.getShareSummaryImgType());
                    this.f50870b.addPostData("referUrl", this.a.getShareReferUrl());
                } else {
                    this.f50870b.addPostData("anonymous", "0");
                    this.f50870b.addPostData("fid", this.a.getForumId());
                    this.f50870b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a.getForumName());
                    if (this.a.getProZone() >= 0) {
                        this.f50870b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.a.getProZone()));
                    }
                    this.f50870b.addPostData("can_no_forum", this.a.isCanNoForum() ? "1" : "0");
                    this.f50870b.addPostData("is_feedback", this.a.isUserFeedback() ? "1" : "0");
                    this.f50870b.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.a.getSpanGroupString()) ? this.a.getContent() : this.a.getSpanGroupString();
                    VideoInfo videoInfo = this.a.getVideoInfo();
                    if (videoInfo != null && videoInfo.hasUpload()) {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    } else {
                        str = content + imagesCodeForPost;
                    }
                    this.f50870b.addPostData("content", c.a.r0.x0.a.c(str));
                    m.a(this.f50870b, this.a);
                    this.f50870b.addPostData("vcode_md5", this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f50870b.addPostData("vcode", obj);
                    }
                    this.f50870b.getNetContext().getRequest().mIsNeedTbs = true;
                    if (this.a.getVoice() != null) {
                        this.f50870b.addPostData("voice_md5", this.a.getVoice());
                        this.f50870b.addPostData("during_time", String.valueOf(this.a.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.a.getTopicId())) {
                        this.f50870b.addPostData("topic_id", this.a.getTopicId());
                    }
                    if (this.a.getType() != 0 && this.a.getType() != 9 && this.a.getType() != 7) {
                        if (this.a.getType() == 6) {
                            this.f50870b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f50870b.addPostData("title", this.a.getTitle());
                            this.f50870b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                            this.f50870b.addPostData("thread_type", String.valueOf(36));
                        } else if (this.a.getType() == 4) {
                            this.f50870b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f50870b.addPostData("title", this.a.getTitle());
                            this.f50870b.addPostData("is_ntitle", "0");
                            this.f50870b.addPostData("thread_type", String.valueOf(33));
                            this.f50870b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else {
                            this.f50870b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                            this.f50870b.addPostData("tid", this.a.getThreadId());
                            this.f50870b.addPostData("is_ad", this.f50872d.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                            if (this.a.getBaijiahaoData() != null) {
                                this.f50870b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                                this.f50870b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                                this.f50870b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                                this.f50870b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            }
                            if (this.a.getType() == 2) {
                                this.f50870b.addPostData("quote_id", String.valueOf(this.a.getFloor()));
                                this.f50870b.addPostData("floor_num", String.valueOf(this.a.getFloorNum()));
                                this.f50870b.addPostData("is_addition", this.a.isAddition() ? "1" : "0");
                                if (this.a.getRepostId() != null) {
                                    this.f50870b.addPostData("repostid", this.a.getRepostId());
                                }
                                this.f50870b.addPostData("v_fid", this.a.getVForumId());
                                this.f50870b.addPostData("v_fname", this.a.getVForumName());
                            } else if (this.a.getType() == 5) {
                                this.f50870b.addPostData("is_twzhibo_thread", String.valueOf(1));
                            } else if (this.a.getType() == 1) {
                                this.f50870b.addPostData("is_barrage", !this.a.isBarrage() ? "0" : "1");
                                this.f50870b.addPostData("barrage_time", String.valueOf(this.a.getBarrageTime()));
                                if (c.a.q0.x.x.a.a().b() == 1) {
                                    this.f50870b.addPostData("ptype", "4");
                                }
                                this.f50870b.addPostData("v_fid", this.a.getVForumId());
                                this.f50870b.addPostData("v_fname", this.a.getVForumName());
                            }
                        }
                    } else {
                        this.f50870b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.a.getType() == 0 || this.a.getType() == 9) {
                            this.f50870b.addPostData("transform_forums", this.a.getTransmitForumData());
                            this.f50870b.addPostData(IntentConfig.CALL_FROM, this.a.getStatisticFrom() + "");
                            if (this.a.getRecommendExt() != null) {
                                this.f50870b.addPostData("recommend_ext", this.a.getRecommendExt());
                            }
                        }
                        this.f50870b.addPostData("title", this.a.getTitle());
                        this.f50870b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                        if (this.a.getType() == 7) {
                            this.f50870b.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.a.getCategoryFrom() >= 0) {
                            this.f50870b.addPostData("fromCategoryId", String.valueOf(this.a.getCategoryFrom()));
                        }
                        if (this.a.getCategoryTo() >= 0) {
                            this.f50870b.addPostData("toCategoryId", String.valueOf(this.a.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(this.f50872d.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (j2 = c.a.d.f.i.a.n().j(false)) != null) {
                            this.f50870b.addPostData("lbs", String.valueOf(j2.getLatitude()) + "," + String.valueOf(j2.getLongitude()));
                        }
                        if (this.a.isShareThread()) {
                            this.f50870b.addPostData("is_share", "1");
                            this.f50870b.addPostData("from_tid", this.a.getOriginalThreadId());
                        }
                        if (this.a.isShareThread()) {
                            if (this.a.getOriBaijiahaoData() != null) {
                                this.f50870b.addPostData("ori_ugc_nid", this.a.getOriBaijiahaoData().oriUgcNid);
                                this.f50870b.addPostData("ori_ugc_vid", this.a.getOriBaijiahaoData().oriUgcVid);
                                this.f50870b.addPostData("ori_ugc_tid", this.a.getOriBaijiahaoData().oriUgcTid);
                                this.f50870b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.a.getBaijiahaoData() != null) {
                            this.f50870b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                            this.f50870b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            this.f50870b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                            this.f50870b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                        }
                        if (this.a.getTabId() > 0) {
                            this.f50870b.addPostData("tab_name", this.a.getTabName());
                            this.f50870b.addPostData("tab_id", String.valueOf(this.a.getTabId()));
                            this.f50870b.addPostData(FrsCommonTabFragment.IS_GENERAL_TAB, String.valueOf(this.a.getIsGeneralTab()));
                        }
                    }
                }
                if (this.f50870b.getNetContext() != null && this.f50870b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f50870b.getNetContext().getRequest().getNetWorkParam()));
                }
                this.f50871c = this.f50870b.postNetData();
                return null;
            }
            return (m0) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0185, code lost:
            if (r0 != 7) goto L67;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0125 A[Catch: JSONException -> 0x012d, TRY_LEAVE, TryCatch #7 {JSONException -> 0x012d, blocks: (B:52:0x011d, B:54:0x0125), top: B:167:0x011d }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x016d  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01b5  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(m0 m0Var) {
            JSONArray jSONArray;
            PostWriteCallBackData postWriteCallBackData;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            CustomDialogData customDialogData;
            WriteData writeData;
            JSONObject jSONObject;
            JSONObject optJSONObject;
            String str4;
            String str5;
            String str6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m0Var) == null) {
                String str7 = "";
                this.f50872d.closeLoadingDialog();
                this.f50872d.mPostThreadTask = null;
                NetWork netWork = this.f50870b;
                if (netWork != null) {
                    int i2 = 0;
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.f50871c);
                        if (errorData.error_code == 0) {
                            this.f50872d.isVcodeCheckSuccess = true;
                            try {
                                JSONObject jSONObject2 = new JSONObject(this.f50871c);
                                str4 = jSONObject2.optString("msg");
                                try {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("exp");
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
                                            if (this.a.getType() != 3) {
                                                m.b(this.f50872d.getActivity(), str4, str5, str6);
                                            }
                                            this.a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            jSONObject = new JSONObject(this.f50871c);
                                            String str8 = jSONObject.optString("tid");
                                            str2 = jSONObject.optString("pid");
                                            try {
                                                str3 = jSONObject.optString("msg");
                                                str7 = jSONObject.optString("video_id");
                                                customDialogData = c.a.r0.q2.b.a(jSONObject);
                                            } catch (JSONException e3) {
                                                e = e3;
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
                                                postWriteCallBackData.setIsCopyTWZhibo(i2);
                                                postWriteCallBackData.setErrorString(str3);
                                                postWriteCallBackData.setVideoid(str7);
                                                writeData = this.a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent.putExtras(bundle);
                                                this.f50872d.setResult(-1, intent);
                                                if (this.a != null) {
                                                }
                                                this.f50872d.finish();
                                                super.onPostExecute(m0Var);
                                            }
                                            try {
                                                optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                                if (optJSONObject != null) {
                                                }
                                            } catch (JSONException e4) {
                                                e = e4;
                                                jSONException = e;
                                                str = str7;
                                                str7 = str8;
                                                jSONException.printStackTrace();
                                                str8 = str7;
                                                str7 = str;
                                                postWriteCallBackData.setThreadId(str8);
                                                postWriteCallBackData.setPostId(str2);
                                                postWriteCallBackData.setIsCopyTWZhibo(i2);
                                                postWriteCallBackData.setErrorString(str3);
                                                postWriteCallBackData.setVideoid(str7);
                                                writeData = this.a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent2 = new Intent();
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent2.putExtras(bundle2);
                                                this.f50872d.setResult(-1, intent2);
                                                if (this.a != null) {
                                                }
                                                this.f50872d.finish();
                                                super.onPostExecute(m0Var);
                                            }
                                            postWriteCallBackData.setThreadId(str8);
                                            postWriteCallBackData.setPostId(str2);
                                            postWriteCallBackData.setIsCopyTWZhibo(i2);
                                            postWriteCallBackData.setErrorString(str3);
                                            postWriteCallBackData.setVideoid(str7);
                                            writeData = this.a;
                                            if (writeData != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData);
                                            if (customDialogData != null) {
                                            }
                                            Intent intent22 = new Intent();
                                            Bundle bundle22 = new Bundle();
                                            bundle22.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent22.putExtras(bundle22);
                                            this.f50872d.setResult(-1, intent22);
                                            if (this.a != null) {
                                                g.j().A(this.a.getForumId());
                                                g.j().B(this.a.getForumName());
                                                if (!k.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, g.j().h()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                                g.j().v(null);
                                            }
                                            this.f50872d.finish();
                                            super.onPostExecute(m0Var);
                                        }
                                    } else {
                                        str6 = null;
                                        str5 = null;
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    str5 = null;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                str4 = null;
                                str5 = null;
                            }
                            if (StringUtils.isNull(str4)) {
                                str4 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                            }
                            if (this.a.getType() != 3 && this.a.getType() != 7) {
                                m.b(this.f50872d.getActivity(), str4, str5, str6);
                            }
                            this.a.deleteUploadedTempImages();
                        } else {
                            if (this.a.isHasImages()) {
                                if (k.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                    this.f50872d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                                }
                            }
                            if (this.a.getType() != 3) {
                                this.f50872d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            jSONObject = new JSONObject(this.f50871c);
                            String str82 = jSONObject.optString("tid");
                            try {
                                str2 = jSONObject.optString("pid");
                                str3 = jSONObject.optString("msg");
                                try {
                                    str7 = jSONObject.optString("video_id");
                                    customDialogData = c.a.r0.q2.b.a(jSONObject);
                                    optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                    if (optJSONObject != null) {
                                        i2 = optJSONObject.optInt("is_copytwzhibo", 0);
                                    }
                                } catch (JSONException e7) {
                                    e = e7;
                                    customDialogData = null;
                                }
                            } catch (JSONException e8) {
                                e = e8;
                                str2 = "";
                                str3 = str2;
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
                        postWriteCallBackData.setIsCopyTWZhibo(i2);
                        postWriteCallBackData.setErrorString(str3);
                        postWriteCallBackData.setVideoid(str7);
                        writeData = this.a;
                        if (writeData != null) {
                            postWriteCallBackData.setProZone(writeData.getProZone());
                        }
                        postWriteCallBackData.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            WriteData writeData2 = this.a;
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
                            c.a.d.f.m.e.a().postDelayed(new a(this, customDialogData), 2000L);
                        }
                        Intent intent222 = new Intent();
                        Bundle bundle222 = new Bundle();
                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent222.putExtras(bundle222);
                        this.f50872d.setResult(-1, intent222);
                        if (this.a != null && g.j().h() != null) {
                            g.j().A(this.a.getForumId());
                            g.j().B(this.a.getForumName());
                            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && this.a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, g.j().h()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                            g.j().v(null);
                        }
                        this.f50872d.finish();
                    } else {
                        if (this.a.isHasImages()) {
                            if (k.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                this.f50872d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                            }
                        }
                        if (this.f50870b.getServerErrorCode() != 5 && this.f50870b.getServerErrorCode() != 6) {
                            if (this.a != null && this.f50870b.getServerErrorCode() == 227001) {
                                AccessState accessState = new AccessState();
                                accessState.parserJson(this.f50871c);
                                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.f50870b.getServerErrorCode(), this.f50870b.getErrorString(), null, null);
                                postWriteCallBackData2.setAccessState(accessState);
                                this.f50872d.getActivity().setVisible(false);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f50872d.getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, this.a, postWriteCallBackData2.getAccessState())));
                            } else if (this.f50870b.getServerErrorCode() == 220009) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.f50870b.getErrorString()));
                                this.f50872d.finish();
                            } else if (this.f50870b.getServerErrorCode() == 220015) {
                                PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                                if (this.f50871c != null) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(this.f50871c);
                                        postWriteCallBackData3.setErrorString(jSONObject3.optString("msg"));
                                        postWriteCallBackData3.setThreadId(jSONObject3.optString("tid"));
                                        postWriteCallBackData3.setPostId(jSONObject3.optString("pid"));
                                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("info");
                                        if (optJSONObject3 != null && (jSONArray = optJSONObject3.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                            int length = jSONArray.length();
                                            ArrayList<String> arrayList = new ArrayList<>();
                                            for (int i3 = 0; i3 < length; i3++) {
                                                arrayList.add(jSONArray.optString(i3));
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
                                this.f50872d.setResult(0, intent3);
                                this.f50872d.finish();
                            }
                        } else {
                            m0 m0Var2 = new m0();
                            m0Var2.e(this.f50871c);
                            if (m0Var2.c() != null && this.f50872d.mModel != null) {
                                this.f50872d.mModel.setVcodeMD5(m0Var2.b());
                                this.f50872d.mModel.setVcodeUrl(m0Var2.c());
                                VcodeActivity vcodeActivity = this.f50872d;
                                vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                            }
                            this.f50872d.mEdit.setText((CharSequence) null);
                        }
                        if (this.f50870b.getServerErrorCode() != 227001 && this.f50870b.getServerErrorCode() == 220015) {
                            this.f50872d.showToast(this.f50870b.getErrorString());
                        }
                    }
                }
                super.onPostExecute(m0Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f50872d.mPostThreadTask = null;
                this.f50872d.closeLoadingDialog();
                NetWork netWork = this.f50870b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }
    }

    public VcodeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mModel = null;
        this.mPost = null;
        this.mImage = null;
        this.mEdit = null;
        this.mProgressBar = null;
        this.mPostThreadTask = null;
        this.mGetImageTask = null;
        this.mInputManager = null;
        this.mDialogCancelListener = null;
        this.mParent = null;
        this.mInfo = null;
        this.mNavigationBar = null;
        this.isVcodeCheckSuccess = false;
        this.onBackListener = new b(this);
        this.onPostListener = new c(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bundle) == null) {
            this.mDialogCancelListener = new a(this);
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
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mParent = (RelativeLayout) findViewById(R.id.parent);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mInfo = (TextView) findViewById(R.id.info);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.onPostListener);
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), R.dimen.ds16);
            this.mPost.setLayoutParams(layoutParams);
            this.mEdit = (EditText) findViewById(R.id.input);
            ImageView imageView = (ImageView) findViewById(R.id.vcode_image);
            this.mImage = imageView;
            imageView.setImageDrawable(null);
            this.mImage.setOnClickListener(new d(this));
            this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            c.a.q0.s.g0.a aVar = new c.a.q0.s.g0.a(getPageContext());
            this.mWaitingDialog = aVar;
            aVar.i(R.string.sending);
            this.mWaitingDialog.e(this.mDialogCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.g(false);
            this.mWaitingDialog.h(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 12006) {
                    setResult(-1, intent);
                }
            } else if (i3 == 0 && i2 == 12006) {
                setResult(0, intent);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBgColor(this.mParent, i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundResource(this.mPost, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mPost, R.color.CAM_X0111);
            this.mInfo.setTextColor((i2 == 1 || i2 == 4) ? SkinManager.getCommentTextColor(i2) : -12895429);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.vcode_activity);
            initUI();
            initData(bundle);
            WriteData writeData = this.mModel;
            if (writeData != null) {
                refreshImage(writeData.getVcodeUrl());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.mModel));
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
            c.a.q0.s.b0.b.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
