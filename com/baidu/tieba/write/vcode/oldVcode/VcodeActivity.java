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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.t.c.n0;
import c.a.t0.p4.g;
import c.a.t0.p4.j;
import c.a.t0.w3.s0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes13.dex */
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

    /* loaded from: classes13.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49667e;

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
            this.f49667e = vcodeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f49667e.destroyWaitingDialog();
                if (this.f49667e.mPostThreadTask != null) {
                    this.f49667e.mPostThreadTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49668e;

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
            this.f49668e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49668e.finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49669e;

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
            this.f49669e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VcodeActivity vcodeActivity = this.f49669e;
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, this.f49669e.mEdit);
                this.f49669e.showDialog();
                if (this.f49669e.mPostThreadTask != null) {
                    this.f49669e.mPostThreadTask.cancel();
                }
                this.f49669e.isVcodeCheckSuccess = false;
                VcodeActivity vcodeActivity2 = this.f49669e;
                VcodeActivity vcodeActivity3 = this.f49669e;
                vcodeActivity2.mPostThreadTask = new f(vcodeActivity3, vcodeActivity3.mModel);
                this.f49669e.mPostThreadTask.setPriority(3);
                this.f49669e.mPostThreadTask.execute(0);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49670e;

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
            this.f49670e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49670e.refreshImage((String) null);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public n0 f49671b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f49672c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49673d;

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
            this.f49673d = vcodeActivity;
            this.a = null;
            this.f49671b = null;
            this.f49672c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.f49673d.mModel == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.a.addPostData("fid", this.f49673d.mModel.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f49673d.mModel.getForumName());
                    this.a.addPostData("new_vcode", "1");
                    this.a.addPostData("title", this.f49673d.mModel.getTitle());
                    this.a.addPostData("content", this.f49673d.mModel.getContent());
                    if (this.f49673d.mModel.getType() == 0) {
                        this.a.addPostData("pub_type", "1");
                        if (this.f49673d.mModel.getCategoryFrom() >= 0) {
                            this.a.addPostData("fromCategoryId", String.valueOf(this.f49673d.mModel.getCategoryFrom()));
                        }
                        if (this.f49673d.mModel.getCategoryTo() >= 0) {
                            this.a.addPostData("toCategoryId", String.valueOf(this.f49673d.mModel.getCategoryTo()));
                        }
                    } else {
                        this.a.addPostData("pub_type", "2");
                        this.a.addPostData("tid", this.f49673d.mModel.getThreadId());
                    }
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    n0 n0Var = new n0();
                    this.f49671b = n0Var;
                    n0Var.e(postNetData);
                    str = this.f49671b.c();
                }
                if (this.f49672c) {
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
                this.f49673d.mGetImageTask = null;
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.f49672c = true;
                this.f49673d.mProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.f49673d.mGetImageTask = null;
                if (bitmap != null) {
                    this.f49673d.mImage.setImageBitmap(bitmap);
                }
                this.f49673d.mProgressBar.setVisibility(8);
                if (this.f49671b != null && this.f49673d.mModel != null) {
                    this.f49673d.mModel.setVcodeMD5(this.f49671b.b());
                    this.f49673d.mModel.setVcodeUrl(this.f49671b.c());
                }
                super.onPostExecute((e) bitmap);
            }
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }
    }

    /* loaded from: classes13.dex */
    public class f extends BdAsyncTask<Integer, Integer, n0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f49674b;

        /* renamed from: c  reason: collision with root package name */
        public String f49675c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f49676d;

        /* loaded from: classes13.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f49677e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f49678f;

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
                this.f49678f = fVar;
                this.f49677e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t0.s2.t.c.a(this.f49678f.f49676d.getPageContext(), this.f49677e).show();
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
            this.f49676d = vcodeActivity;
            this.a = null;
            this.f49674b = null;
            this.f49675c = null;
            this.a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public n0 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Address j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.a == null) {
                    return null;
                }
                this.f49674b = new NetWork();
                String obj = this.f49676d.mEdit.getText().toString();
                String imagesCodeForPost = this.a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.f49674b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.a.getType() == 3) {
                    this.f49674b.addPostData("newVcode", "1");
                    this.f49674b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.f49674b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f49674b.addPostData("vcode", obj);
                    }
                    this.f49674b.addPostData("tag", "11");
                    this.f49674b.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f49674b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.f49674b.setUrl(c.a.t0.w3.k0.a.m);
                    this.f49674b.addPostData("fname", this.a.getForumName());
                    this.f49674b.addPostData("title", this.a.getTitle());
                    this.f49674b.addPostData("apiKey", this.a.getShareApiKey());
                    this.f49674b.addPostData("appName", this.a.getShareAppName());
                    this.f49674b.addPostData("signKey", this.a.getShareSignKey());
                    this.f49674b.addPostData("summary_title", this.a.getShareSummaryTitle());
                    this.f49674b.addPostData("summary_content", this.a.getShareSummaryContent());
                    this.f49674b.addPostData("summary_img", this.a.getShareSummaryImg());
                    this.f49674b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.a.getShareSummaryImgWidth()));
                    this.f49674b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.a.getShareSummaryImgHeight()));
                    this.f49674b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.a.getShareSummaryImgType());
                    this.f49674b.addPostData("referUrl", this.a.getShareReferUrl());
                } else {
                    this.f49674b.addPostData("anonymous", "0");
                    this.f49674b.addPostData("fid", this.a.getForumId());
                    this.f49674b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a.getForumName());
                    if (this.a.getProZone() >= 0) {
                        this.f49674b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.a.getProZone()));
                    }
                    this.f49674b.addPostData("can_no_forum", this.a.isCanNoForum() ? "1" : "0");
                    this.f49674b.addPostData("is_feedback", this.a.isUserFeedback() ? "1" : "0");
                    this.f49674b.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.a.getSpanGroupString()) ? this.a.getContent() : this.a.getSpanGroupString();
                    VideoInfo videoInfo = this.a.getVideoInfo();
                    if (videoInfo != null && videoInfo.hasUpload()) {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    } else {
                        str = content + imagesCodeForPost;
                    }
                    this.f49674b.addPostData("content", c.a.t0.x0.a.c(str));
                    h.a(this.f49674b, this.a);
                    this.f49674b.addPostData("vcode_md5", this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f49674b.addPostData("vcode", obj);
                    }
                    this.f49674b.getNetContext().getRequest().mIsNeedTbs = true;
                    if (this.a.getVoice() != null) {
                        this.f49674b.addPostData("voice_md5", this.a.getVoice());
                        this.f49674b.addPostData("during_time", String.valueOf(this.a.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.a.getTopicId())) {
                        this.f49674b.addPostData("topic_id", this.a.getTopicId());
                    }
                    if (this.a.getType() != 0 && this.a.getType() != 9 && this.a.getType() != 7) {
                        if (this.a.getType() == 6) {
                            this.f49674b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f49674b.addPostData("title", this.a.getTitle());
                            this.f49674b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                            this.f49674b.addPostData("thread_type", String.valueOf(36));
                        } else if (this.a.getType() == 4) {
                            this.f49674b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f49674b.addPostData("title", this.a.getTitle());
                            this.f49674b.addPostData("is_ntitle", "0");
                            this.f49674b.addPostData("thread_type", String.valueOf(33));
                            this.f49674b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else {
                            this.f49674b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                            this.f49674b.addPostData("tid", this.a.getThreadId());
                            this.f49674b.addPostData("is_ad", this.f49676d.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                            if (this.a.getBaijiahaoData() != null) {
                                this.f49674b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                                this.f49674b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                                this.f49674b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                                this.f49674b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            }
                            if (this.a.getType() == 2) {
                                this.f49674b.addPostData("quote_id", String.valueOf(this.a.getFloor()));
                                this.f49674b.addPostData("floor_num", String.valueOf(this.a.getFloorNum()));
                                this.f49674b.addPostData("is_addition", this.a.isAddition() ? "1" : "0");
                                if (this.a.getRepostId() != null) {
                                    this.f49674b.addPostData("repostid", this.a.getRepostId());
                                }
                                this.f49674b.addPostData("v_fid", this.a.getVForumId());
                                this.f49674b.addPostData("v_fname", this.a.getVForumName());
                            } else if (this.a.getType() == 5) {
                                this.f49674b.addPostData("is_twzhibo_thread", String.valueOf(1));
                            } else if (this.a.getType() == 1) {
                                this.f49674b.addPostData("is_barrage", !this.a.isBarrage() ? "0" : "1");
                                this.f49674b.addPostData("barrage_time", String.valueOf(this.a.getBarrageTime()));
                                if (c.a.s0.x.y.a.a().b() == 1) {
                                    this.f49674b.addPostData("ptype", "4");
                                }
                                this.f49674b.addPostData("v_fid", this.a.getVForumId());
                                this.f49674b.addPostData("v_fname", this.a.getVForumName());
                            }
                        }
                    } else {
                        this.f49674b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.a.getType() == 0 || this.a.getType() == 9) {
                            this.f49674b.addPostData("transform_forums", this.a.getTransmitForumData());
                            this.f49674b.addPostData(IntentConfig.CALL_FROM, this.a.getStatisticFrom() + "");
                            if (this.a.getRecommendExt() != null) {
                                this.f49674b.addPostData("recommend_ext", this.a.getRecommendExt());
                            }
                        }
                        this.f49674b.addPostData("title", this.a.getTitle());
                        this.f49674b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                        if (this.a.getType() == 7) {
                            this.f49674b.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.a.getCategoryFrom() >= 0) {
                            this.f49674b.addPostData("fromCategoryId", String.valueOf(this.a.getCategoryFrom()));
                        }
                        if (this.a.getCategoryTo() >= 0) {
                            this.f49674b.addPostData("toCategoryId", String.valueOf(this.a.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(this.f49676d.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (j2 = c.a.d.f.i.a.n().j(false)) != null) {
                            this.f49674b.addPostData("lbs", String.valueOf(j2.getLatitude()) + "," + String.valueOf(j2.getLongitude()));
                        }
                        if (this.a.isShareThread()) {
                            this.f49674b.addPostData("is_share", "1");
                            this.f49674b.addPostData("from_tid", this.a.getOriginalThreadId());
                        }
                        if (this.a.isShareThread()) {
                            if (this.a.getOriBaijiahaoData() != null) {
                                this.f49674b.addPostData("ori_ugc_nid", this.a.getOriBaijiahaoData().oriUgcNid);
                                this.f49674b.addPostData("ori_ugc_vid", this.a.getOriBaijiahaoData().oriUgcVid);
                                this.f49674b.addPostData("ori_ugc_tid", this.a.getOriBaijiahaoData().oriUgcTid);
                                this.f49674b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.a.getBaijiahaoData() != null) {
                            this.f49674b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                            this.f49674b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            this.f49674b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                            this.f49674b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                        }
                        if (this.a.getTabId() > 0) {
                            this.f49674b.addPostData("tab_name", this.a.getTabName());
                            this.f49674b.addPostData("tab_id", String.valueOf(this.a.getTabId()));
                            this.f49674b.addPostData(FrsCommonTabFragment.IS_GENERAL_TAB, String.valueOf(this.a.getIsGeneralTab()));
                        }
                    }
                }
                if (this.f49674b.getNetContext() != null && this.f49674b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f49674b.getNetContext().getRequest().getNetWorkParam()));
                }
                this.f49675c = this.f49674b.postNetData();
                return null;
            }
            return (n0) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0180, code lost:
            if (r0 != 7) goto L64;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0125 A[Catch: JSONException -> 0x012d, TRY_LEAVE, TryCatch #5 {JSONException -> 0x012d, blocks: (B:51:0x0113, B:53:0x0125), top: B:159:0x0113 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01b0  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(n0 n0Var) {
            JSONArray jSONArray;
            PostWriteCallBackData postWriteCallBackData;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            WriteData writeData;
            JSONObject optJSONObject;
            String str4;
            String str5;
            String str6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n0Var) == null) {
                String str7 = "";
                this.f49676d.closeLoadingDialog();
                CustomDialogData customDialogData = null;
                this.f49676d.mPostThreadTask = null;
                NetWork netWork = this.f49674b;
                if (netWork != null) {
                    int i2 = 0;
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.f49675c);
                        if (errorData.error_code == 0) {
                            this.f49676d.isVcodeCheckSuccess = true;
                            try {
                                JSONObject jSONObject = new JSONObject(this.f49675c);
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
                                            if (this.a.getType() != 3) {
                                                h.b(this.f49676d.getActivity(), str4, str5, str6);
                                            }
                                            this.a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            JSONObject jSONObject2 = new JSONObject(this.f49675c);
                                            String str8 = jSONObject2.optString("tid");
                                            try {
                                                str2 = jSONObject2.optString("pid");
                                                try {
                                                    str3 = jSONObject2.optString("msg");
                                                } catch (JSONException e3) {
                                                    e = e3;
                                                    str3 = "";
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
                                                    this.f49676d.setResult(-1, intent);
                                                    if (this.a != null) {
                                                    }
                                                    this.f49676d.finish();
                                                    super.onPostExecute(n0Var);
                                                }
                                            } catch (JSONException e4) {
                                                e = e4;
                                                str2 = "";
                                                str3 = str2;
                                            }
                                            try {
                                                str7 = jSONObject2.optString("video_id");
                                                customDialogData = c.a.t0.s2.b.a(jSONObject2);
                                                optJSONObject = jSONObject2.optJSONObject("twzhibo_info");
                                                if (optJSONObject != null) {
                                                }
                                            } catch (JSONException e5) {
                                                jSONException = e5;
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
                                                this.f49676d.setResult(-1, intent2);
                                                if (this.a != null) {
                                                }
                                                this.f49676d.finish();
                                                super.onPostExecute(n0Var);
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
                                            this.f49676d.setResult(-1, intent22);
                                            if (this.a != null) {
                                                c.a.t0.w3.s0.b.k().C(this.a.getForumId());
                                                c.a.t0.w3.s0.b.k().D(this.a.getForumName());
                                                if (!m.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.t0.w3.s0.b.k().i()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                            }
                                            this.f49676d.finish();
                                            super.onPostExecute(n0Var);
                                        }
                                    } else {
                                        str6 = null;
                                        str5 = null;
                                    }
                                } catch (JSONException e6) {
                                    e = e6;
                                    str5 = null;
                                }
                            } catch (JSONException e7) {
                                e = e7;
                                str4 = null;
                                str5 = null;
                            }
                            if (StringUtils.isNull(str4)) {
                                str4 = TbadkCoreApplication.getInst().getString(j.send_success);
                            }
                            if (this.a.getType() != 3 && this.a.getType() != 7) {
                                h.b(this.f49676d.getActivity(), str4, str5, str6);
                            }
                            this.a.deleteUploadedTempImages();
                        } else {
                            if (this.a.isHasImages()) {
                                if (m.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                    this.f49676d.showToast(TbadkCoreApplication.getInst().getString(j.img_upload_error));
                                }
                            }
                            if (this.a.getType() != 3) {
                                this.f49676d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            JSONObject jSONObject22 = new JSONObject(this.f49675c);
                            String str82 = jSONObject22.optString("tid");
                            str2 = jSONObject22.optString("pid");
                            str3 = jSONObject22.optString("msg");
                            str7 = jSONObject22.optString("video_id");
                            customDialogData = c.a.t0.s2.b.a(jSONObject22);
                            optJSONObject = jSONObject22.optJSONObject("twzhibo_info");
                            if (optJSONObject != null) {
                                i2 = optJSONObject.optInt("is_copytwzhibo", 0);
                            }
                        } catch (JSONException e8) {
                            jSONException = e8;
                            str = "";
                            str2 = str;
                            str3 = str2;
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
                        this.f49676d.setResult(-1, intent222);
                        if (this.a != null && c.a.t0.w3.s0.b.k().i() != null) {
                            c.a.t0.w3.s0.b.k().C(this.a.getForumId());
                            c.a.t0.w3.s0.b.k().D(this.a.getForumName());
                            if (!m.isEmpty(postWriteCallBackData.getVideoid()) && this.a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, c.a.t0.w3.s0.b.k().i()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        }
                        this.f49676d.finish();
                    } else {
                        if (this.a.isHasImages()) {
                            if (m.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                this.f49676d.showToast(TbadkCoreApplication.getInst().getString(j.img_upload_error));
                            }
                        }
                        if (this.f49674b.getServerErrorCode() != 5 && this.f49674b.getServerErrorCode() != 6) {
                            if (this.a != null && this.f49674b.getServerErrorCode() == 227001) {
                                AccessState accessState = new AccessState();
                                accessState.parserJson(this.f49675c);
                                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.f49674b.getServerErrorCode(), this.f49674b.getErrorString(), null, null);
                                postWriteCallBackData2.setAccessState(accessState);
                                this.f49676d.getActivity().setVisible(false);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f49676d.getActivity(), 12006, this.a, postWriteCallBackData2.getAccessState())));
                            } else if (this.f49674b.getServerErrorCode() == 220009) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.f49674b.getErrorString()));
                                this.f49676d.finish();
                            } else if (this.f49674b.getServerErrorCode() == 220015) {
                                PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                                if (this.f49675c != null) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(this.f49675c);
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
                                    } catch (JSONException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                Intent intent3 = new Intent();
                                Bundle bundle3 = new Bundle();
                                bundle3.putSerializable("post_write_callback_data", postWriteCallBackData3);
                                intent3.putExtras(bundle3);
                                this.f49676d.setResult(0, intent3);
                                this.f49676d.finish();
                            }
                        } else {
                            n0 n0Var2 = new n0();
                            n0Var2.e(this.f49675c);
                            if (n0Var2.c() != null && this.f49676d.mModel != null) {
                                this.f49676d.mModel.setVcodeMD5(n0Var2.b());
                                this.f49676d.mModel.setVcodeUrl(n0Var2.c());
                                VcodeActivity vcodeActivity = this.f49676d;
                                vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                            }
                            this.f49676d.mEdit.setText((CharSequence) null);
                        }
                        if (this.f49674b.getServerErrorCode() != 227001 && this.f49674b.getServerErrorCode() == 220015) {
                            this.f49676d.showToast(this.f49674b.getErrorString());
                        }
                    }
                }
                super.onPostExecute(n0Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f49676d.mPostThreadTask = null;
                this.f49676d.closeLoadingDialog();
                NetWork netWork = this.f49674b;
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
            this.mParent = (RelativeLayout) findViewById(g.parent);
            this.mNavigationBar = (NavigationBar) findViewById(g.view_navigation_bar);
            this.mInfo = (TextView) findViewById(g.info);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(j.send), this.onPostListener);
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = n.f(getPageContext().getPageActivity(), c.a.t0.p4.e.ds16);
            this.mPost.setLayoutParams(layoutParams);
            this.mEdit = (EditText) findViewById(g.input);
            ImageView imageView = (ImageView) findViewById(g.vcode_image);
            this.mImage = imageView;
            imageView.setImageDrawable(null);
            this.mImage.setOnClickListener(new d(this));
            this.mProgressBar = (ProgressBar) findViewById(g.progress);
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
            c.a.s0.s.j0.a aVar = new c.a.s0.s.j0.a(getPageContext());
            this.mWaitingDialog = aVar;
            aVar.i(j.sending);
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
            SkinManager.setBackgroundResource(this.mPost, c.a.t0.p4.f.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mPost, c.a.t0.p4.d.CAM_X0111);
            this.mInfo.setTextColor((i2 == 1 || i2 == 4) ? SkinManager.getCommentTextColor(i2) : -12895429);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(c.a.t0.p4.h.vcode_activity);
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
            c.a.s0.s.d0.b.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
