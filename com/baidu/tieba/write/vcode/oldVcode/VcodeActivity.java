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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.t.c.k0;
import c.a.q0.i3.r0.g;
import c.a.q0.i3.r0.m;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58652e;

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
            this.f58652e = vcodeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f58652e.destroyWaitingDialog();
                if (this.f58652e.mPostThreadTask != null) {
                    this.f58652e.mPostThreadTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58653e;

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
            this.f58653e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58653e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58654e;

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
            this.f58654e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VcodeActivity vcodeActivity = this.f58654e;
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, this.f58654e.mEdit);
                this.f58654e.showDialog();
                if (this.f58654e.mPostThreadTask != null) {
                    this.f58654e.mPostThreadTask.cancel();
                }
                this.f58654e.isVcodeCheckSuccess = false;
                VcodeActivity vcodeActivity2 = this.f58654e;
                VcodeActivity vcodeActivity3 = this.f58654e;
                vcodeActivity2.mPostThreadTask = new f(vcodeActivity3, vcodeActivity3.mModel);
                this.f58654e.mPostThreadTask.setPriority(3);
                this.f58654e.mPostThreadTask.execute(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58655e;

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
            this.f58655e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58655e.refreshImage((String) null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f58656a;

        /* renamed from: b  reason: collision with root package name */
        public k0 f58657b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f58658c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58659d;

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
            this.f58659d = vcodeActivity;
            this.f58656a = null;
            this.f58657b = null;
            this.f58658c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.f58659d.mModel == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.f58656a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.f58656a.addPostData("fid", this.f58659d.mModel.getForumId());
                    this.f58656a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f58659d.mModel.getForumName());
                    this.f58656a.addPostData("new_vcode", "1");
                    this.f58656a.addPostData("title", this.f58659d.mModel.getTitle());
                    this.f58656a.addPostData("content", this.f58659d.mModel.getContent());
                    if (this.f58659d.mModel.getType() == 0) {
                        this.f58656a.addPostData("pub_type", "1");
                        if (this.f58659d.mModel.getCategoryFrom() >= 0) {
                            this.f58656a.addPostData("fromCategoryId", String.valueOf(this.f58659d.mModel.getCategoryFrom()));
                        }
                        if (this.f58659d.mModel.getCategoryTo() >= 0) {
                            this.f58656a.addPostData("toCategoryId", String.valueOf(this.f58659d.mModel.getCategoryTo()));
                        }
                    } else {
                        this.f58656a.addPostData("pub_type", "2");
                        this.f58656a.addPostData("tid", this.f58659d.mModel.getThreadId());
                    }
                    String postNetData = this.f58656a.postNetData();
                    if (!this.f58656a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    k0 k0Var = new k0();
                    this.f58657b = k0Var;
                    k0Var.e(postNetData);
                    str = this.f58657b.c();
                }
                if (this.f58658c) {
                    return null;
                }
                this.f58656a = new NetWork(str);
                return BitmapHelper.Bytes2Bitmap(this.f58656a.getNetData());
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f58659d.mGetImageTask = null;
                if (this.f58656a != null) {
                    this.f58656a.cancelNetConnect();
                }
                this.f58658c = true;
                this.f58659d.mProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.f58659d.mGetImageTask = null;
                if (bitmap != null) {
                    this.f58659d.mImage.setImageBitmap(bitmap);
                }
                this.f58659d.mProgressBar.setVisibility(8);
                if (this.f58657b != null && this.f58659d.mModel != null) {
                    this.f58659d.mModel.setVcodeMD5(this.f58657b.b());
                    this.f58659d.mModel.setVcodeUrl(this.f58657b.c());
                }
                super.onPostExecute((e) bitmap);
            }
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<Integer, Integer, k0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WriteData f58660a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f58661b;

        /* renamed from: c  reason: collision with root package name */
        public String f58662c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f58663d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f58664e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f58665f;

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
                this.f58665f = fVar;
                this.f58664e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.i2.j.c.a(this.f58665f.f58663d.getPageContext(), this.f58664e).show();
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
            this.f58663d = vcodeActivity;
            this.f58660a = null;
            this.f58661b = null;
            this.f58662c = null;
            this.f58660a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public k0 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Address h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.f58660a == null) {
                    return null;
                }
                this.f58661b = new NetWork();
                String obj = this.f58663d.mEdit.getText().toString();
                String imagesCodeForPost = this.f58660a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.f58661b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.f58660a.getType() == 3) {
                    this.f58661b.addPostData("newVcode", "1");
                    this.f58661b.addPostData("content", this.f58660a.getContent() + imagesCodeForPost);
                    this.f58661b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.f58660a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f58661b.addPostData("vcode", obj);
                    }
                    this.f58661b.addPostData("tag", "11");
                    this.f58661b.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f58661b.addPostData("content", this.f58660a.getContent() + imagesCodeForPost);
                    this.f58661b.setUrl(c.a.q0.i3.j0.a.m);
                    this.f58661b.addPostData("fname", this.f58660a.getForumName());
                    this.f58661b.addPostData("title", this.f58660a.getTitle());
                    this.f58661b.addPostData("apiKey", this.f58660a.getShareApiKey());
                    this.f58661b.addPostData("appName", this.f58660a.getShareAppName());
                    this.f58661b.addPostData("signKey", this.f58660a.getShareSignKey());
                    this.f58661b.addPostData("summary_title", this.f58660a.getShareSummaryTitle());
                    this.f58661b.addPostData("summary_content", this.f58660a.getShareSummaryContent());
                    this.f58661b.addPostData("summary_img", this.f58660a.getShareSummaryImg());
                    this.f58661b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.f58660a.getShareSummaryImgWidth()));
                    this.f58661b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.f58660a.getShareSummaryImgHeight()));
                    this.f58661b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.f58660a.getShareSummaryImgType());
                    this.f58661b.addPostData("referUrl", this.f58660a.getShareReferUrl());
                } else {
                    this.f58661b.addPostData("anonymous", "0");
                    this.f58661b.addPostData("fid", this.f58660a.getForumId());
                    this.f58661b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f58660a.getForumName());
                    if (this.f58660a.getProZone() >= 0) {
                        this.f58661b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.f58660a.getProZone()));
                    }
                    this.f58661b.addPostData("can_no_forum", this.f58660a.isCanNoForum() ? "1" : "0");
                    this.f58661b.addPostData("is_feedback", this.f58660a.isUserFeedback() ? "1" : "0");
                    this.f58661b.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.f58660a.getSpanGroupString()) ? this.f58660a.getContent() : this.f58660a.getSpanGroupString();
                    VideoInfo videoInfo = this.f58660a.getVideoInfo();
                    if (videoInfo != null && videoInfo.hasUpload()) {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    } else {
                        str = content + imagesCodeForPost;
                    }
                    this.f58661b.addPostData("content", c.a.q0.p0.a.b(str));
                    m.a(this.f58661b, this.f58660a);
                    this.f58661b.addPostData("vcode_md5", this.f58660a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f58661b.addPostData("vcode", obj);
                    }
                    this.f58661b.getNetContext().getRequest().mIsNeedTbs = true;
                    if (this.f58660a.getVoice() != null) {
                        this.f58661b.addPostData("voice_md5", this.f58660a.getVoice());
                        this.f58661b.addPostData("during_time", String.valueOf(this.f58660a.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.f58660a.getTopicId())) {
                        this.f58661b.addPostData("topic_id", this.f58660a.getTopicId());
                    }
                    if (this.f58660a.getType() != 0 && this.f58660a.getType() != 9 && this.f58660a.getType() != 7) {
                        if (this.f58660a.getType() == 6) {
                            this.f58661b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f58661b.addPostData("title", this.f58660a.getTitle());
                            this.f58661b.addPostData("is_ntitle", this.f58660a.isNoTitle() ? "1" : "0");
                            this.f58661b.addPostData("thread_type", String.valueOf(36));
                        } else if (this.f58660a.getType() == 4) {
                            this.f58661b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f58661b.addPostData("title", this.f58660a.getTitle());
                            this.f58661b.addPostData("is_ntitle", "0");
                            this.f58661b.addPostData("thread_type", String.valueOf(33));
                            this.f58661b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else {
                            this.f58661b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                            this.f58661b.addPostData("tid", this.f58660a.getThreadId());
                            this.f58661b.addPostData("is_ad", this.f58663d.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                            if (this.f58660a.getBaijiahaoData() != null) {
                                this.f58661b.addPostData("ori_ugc_nid", this.f58660a.getBaijiahaoData().oriUgcNid);
                                this.f58661b.addPostData("ori_ugc_tid", this.f58660a.getBaijiahaoData().oriUgcTid);
                                this.f58661b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f58660a.getBaijiahaoData().oriUgcType));
                                this.f58661b.addPostData("ori_ugc_vid", this.f58660a.getBaijiahaoData().oriUgcVid);
                            }
                            if (this.f58660a.getType() == 2) {
                                this.f58661b.addPostData("quote_id", String.valueOf(this.f58660a.getFloor()));
                                this.f58661b.addPostData("floor_num", String.valueOf(this.f58660a.getFloorNum()));
                                this.f58661b.addPostData("is_addition", this.f58660a.isAddition() ? "1" : "0");
                                if (this.f58660a.getRepostId() != null) {
                                    this.f58661b.addPostData("repostid", this.f58660a.getRepostId());
                                }
                                this.f58661b.addPostData("v_fid", this.f58660a.getVForumId());
                                this.f58661b.addPostData("v_fname", this.f58660a.getVForumName());
                            } else if (this.f58660a.getType() == 5) {
                                this.f58661b.addPostData("is_twzhibo_thread", String.valueOf(1));
                            } else if (this.f58660a.getType() == 1) {
                                this.f58661b.addPostData("is_barrage", !this.f58660a.isBarrage() ? "0" : "1");
                                this.f58661b.addPostData("barrage_time", String.valueOf(this.f58660a.getBarrageTime()));
                                if (c.a.p0.x.w.a.a().b() == 1) {
                                    this.f58661b.addPostData("ptype", "4");
                                }
                                this.f58661b.addPostData("v_fid", this.f58660a.getVForumId());
                                this.f58661b.addPostData("v_fname", this.f58660a.getVForumName());
                            }
                        }
                    } else {
                        this.f58661b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.f58660a.getType() == 0 || this.f58660a.getType() == 9) {
                            this.f58661b.addPostData("transform_forums", this.f58660a.getTransmitForumData());
                            this.f58661b.addPostData(IntentConfig.CALL_FROM, this.f58660a.getStatisticFrom() + "");
                            if (this.f58660a.getRecommendExt() != null) {
                                this.f58661b.addPostData("recommend_ext", this.f58660a.getRecommendExt());
                            }
                        }
                        this.f58661b.addPostData("title", this.f58660a.getTitle());
                        this.f58661b.addPostData("is_ntitle", this.f58660a.isNoTitle() ? "1" : "0");
                        if (this.f58660a.getType() == 7) {
                            this.f58661b.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.f58660a.getCategoryFrom() >= 0) {
                            this.f58661b.addPostData("fromCategoryId", String.valueOf(this.f58660a.getCategoryFrom()));
                        }
                        if (this.f58660a.getCategoryTo() >= 0) {
                            this.f58661b.addPostData("toCategoryId", String.valueOf(this.f58660a.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(this.f58663d.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (h2 = c.a.e.e.i.a.l().h(false)) != null) {
                            this.f58661b.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                        }
                        if (this.f58660a.isShareThread()) {
                            this.f58661b.addPostData("is_share", "1");
                            this.f58661b.addPostData("from_tid", this.f58660a.getOriginalThreadId());
                        }
                        if (this.f58660a.isShareThread()) {
                            if (this.f58660a.getOriBaijiahaoData() != null) {
                                this.f58661b.addPostData("ori_ugc_nid", this.f58660a.getOriBaijiahaoData().oriUgcNid);
                                this.f58661b.addPostData("ori_ugc_vid", this.f58660a.getOriBaijiahaoData().oriUgcVid);
                                this.f58661b.addPostData("ori_ugc_tid", this.f58660a.getOriBaijiahaoData().oriUgcTid);
                                this.f58661b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f58660a.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.f58660a.getBaijiahaoData() != null) {
                            this.f58661b.addPostData("ori_ugc_nid", this.f58660a.getBaijiahaoData().oriUgcNid);
                            this.f58661b.addPostData("ori_ugc_vid", this.f58660a.getBaijiahaoData().oriUgcVid);
                            this.f58661b.addPostData("ori_ugc_tid", this.f58660a.getBaijiahaoData().oriUgcTid);
                            this.f58661b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f58660a.getBaijiahaoData().oriUgcType));
                        }
                        if (this.f58660a.getTabId() > 0) {
                            this.f58661b.addPostData("tab_name", this.f58660a.getTabName());
                            this.f58661b.addPostData("tab_id", String.valueOf(this.f58660a.getTabId()));
                            this.f58661b.addPostData(FrsCommonTabFragment.IS_GENERAL_TAB, String.valueOf(this.f58660a.getIsGeneralTab()));
                        }
                    }
                }
                if (this.f58661b.getNetContext() != null && this.f58661b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f58661b.getNetContext().getRequest().getNetWorkParam()));
                }
                this.f58662c = this.f58661b.postNetData();
                return null;
            }
            return (k0) invokeL.objValue;
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
        public void onPostExecute(k0 k0Var) {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k0Var) == null) {
                String str7 = "";
                this.f58663d.closeLoadingDialog();
                this.f58663d.mPostThreadTask = null;
                NetWork netWork = this.f58661b;
                if (netWork != null) {
                    int i2 = 0;
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.f58662c);
                        if (errorData.error_code == 0) {
                            this.f58663d.isVcodeCheckSuccess = true;
                            try {
                                JSONObject jSONObject2 = new JSONObject(this.f58662c);
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
                                            if (this.f58660a.getType() != 3) {
                                                m.b(this.f58663d.getActivity(), str4, str5, str6);
                                            }
                                            this.f58660a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            jSONObject = new JSONObject(this.f58662c);
                                            String str8 = jSONObject.optString("tid");
                                            str2 = jSONObject.optString("pid");
                                            try {
                                                str3 = jSONObject.optString("msg");
                                                str7 = jSONObject.optString("video_id");
                                                customDialogData = c.a.q0.i2.b.a(jSONObject);
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
                                                writeData = this.f58660a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent.putExtras(bundle);
                                                this.f58663d.setResult(-1, intent);
                                                if (this.f58660a != null) {
                                                }
                                                this.f58663d.finish();
                                                super.onPostExecute(k0Var);
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
                                                writeData = this.f58660a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent2 = new Intent();
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent2.putExtras(bundle2);
                                                this.f58663d.setResult(-1, intent2);
                                                if (this.f58660a != null) {
                                                }
                                                this.f58663d.finish();
                                                super.onPostExecute(k0Var);
                                            }
                                            postWriteCallBackData.setThreadId(str8);
                                            postWriteCallBackData.setPostId(str2);
                                            postWriteCallBackData.setIsCopyTWZhibo(i2);
                                            postWriteCallBackData.setErrorString(str3);
                                            postWriteCallBackData.setVideoid(str7);
                                            writeData = this.f58660a;
                                            if (writeData != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData);
                                            if (customDialogData != null) {
                                            }
                                            Intent intent22 = new Intent();
                                            Bundle bundle22 = new Bundle();
                                            bundle22.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent22.putExtras(bundle22);
                                            this.f58663d.setResult(-1, intent22);
                                            if (this.f58660a != null) {
                                                g.g().s(this.f58660a.getForumId());
                                                g.g().t(this.f58660a.getForumName());
                                                if (!k.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.f58660a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, g.g().f()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                                g.g().q(null);
                                            }
                                            this.f58663d.finish();
                                            super.onPostExecute(k0Var);
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
                            if (this.f58660a.getType() != 3 && this.f58660a.getType() != 7) {
                                m.b(this.f58663d.getActivity(), str4, str5, str6);
                            }
                            this.f58660a.deleteUploadedTempImages();
                        } else {
                            if (this.f58660a.isHasImages()) {
                                if (k.isEmpty(this.f58660a.getContent() + this.f58660a.getImagesCodeForPost())) {
                                    this.f58663d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                                }
                            }
                            if (this.f58660a.getType() != 3) {
                                this.f58663d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            jSONObject = new JSONObject(this.f58662c);
                            String str82 = jSONObject.optString("tid");
                            try {
                                str2 = jSONObject.optString("pid");
                                str3 = jSONObject.optString("msg");
                                try {
                                    str7 = jSONObject.optString("video_id");
                                    customDialogData = c.a.q0.i2.b.a(jSONObject);
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
                        writeData = this.f58660a;
                        if (writeData != null) {
                            postWriteCallBackData.setProZone(writeData.getProZone());
                        }
                        postWriteCallBackData.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            WriteData writeData2 = this.f58660a;
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
                            c.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 2000L);
                        }
                        Intent intent222 = new Intent();
                        Bundle bundle222 = new Bundle();
                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent222.putExtras(bundle222);
                        this.f58663d.setResult(-1, intent222);
                        if (this.f58660a != null && g.g().f() != null) {
                            g.g().s(this.f58660a.getForumId());
                            g.g().t(this.f58660a.getForumName());
                            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && this.f58660a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.f58660a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, g.g().f()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                            g.g().q(null);
                        }
                        this.f58663d.finish();
                    } else {
                        if (this.f58660a.isHasImages()) {
                            if (k.isEmpty(this.f58660a.getContent() + this.f58660a.getImagesCodeForPost())) {
                                this.f58663d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                            }
                        }
                        if (this.f58661b.getServerErrorCode() != 5 && this.f58661b.getServerErrorCode() != 6) {
                            if (this.f58660a != null && this.f58661b.getServerErrorCode() == 227001) {
                                AccessState accessState = new AccessState();
                                accessState.parserJson(this.f58662c);
                                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.f58661b.getServerErrorCode(), this.f58661b.getErrorString(), null, null);
                                postWriteCallBackData2.setAccessState(accessState);
                                this.f58663d.getActivity().setVisible(false);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f58663d.getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, this.f58660a, postWriteCallBackData2.getAccessState())));
                            } else if (this.f58661b.getServerErrorCode() == 220009) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.f58661b.getErrorString()));
                                this.f58663d.finish();
                            } else if (this.f58661b.getServerErrorCode() == 220015) {
                                PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                                if (this.f58662c != null) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(this.f58662c);
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
                                this.f58663d.setResult(0, intent3);
                                this.f58663d.finish();
                            }
                        } else {
                            k0 k0Var2 = new k0();
                            k0Var2.e(this.f58662c);
                            if (k0Var2.c() != null && this.f58663d.mModel != null) {
                                this.f58663d.mModel.setVcodeMD5(k0Var2.b());
                                this.f58663d.mModel.setVcodeUrl(k0Var2.c());
                                VcodeActivity vcodeActivity = this.f58663d;
                                vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                            }
                            this.f58663d.mEdit.setText((CharSequence) null);
                        }
                        if (this.f58661b.getServerErrorCode() != 227001 && this.f58661b.getServerErrorCode() == 220015) {
                            this.f58663d.showToast(this.f58661b.getErrorString());
                        }
                    }
                }
                super.onPostExecute(k0Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f58663d.mPostThreadTask = null;
                this.f58663d.closeLoadingDialog();
                NetWork netWork = this.f58661b;
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
            layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
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
            c.a.p0.s.f0.a aVar = new c.a.p0.s.f0.a(getPageContext());
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
            c.a.p0.s.a0.b.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
