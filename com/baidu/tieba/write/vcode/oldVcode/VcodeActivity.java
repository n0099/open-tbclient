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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.s.c.i0;
import d.a.p0.h3.q0.g;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22642e;

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
            this.f22642e = vcodeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f22642e.destroyWaitingDialog();
                if (this.f22642e.mPostThreadTask != null) {
                    this.f22642e.mPostThreadTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22643e;

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
            this.f22643e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22643e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22644e;

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
            this.f22644e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VcodeActivity vcodeActivity = this.f22644e;
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, this.f22644e.mEdit);
                this.f22644e.showDialog();
                if (this.f22644e.mPostThreadTask != null) {
                    this.f22644e.mPostThreadTask.cancel();
                }
                this.f22644e.isVcodeCheckSuccess = false;
                VcodeActivity vcodeActivity2 = this.f22644e;
                VcodeActivity vcodeActivity3 = this.f22644e;
                vcodeActivity2.mPostThreadTask = new f(vcodeActivity3, vcodeActivity3.mModel);
                this.f22644e.mPostThreadTask.setPriority(3);
                this.f22644e.mPostThreadTask.execute(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22645e;

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
            this.f22645e = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22645e.refreshImage((String) null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f22646a;

        /* renamed from: b  reason: collision with root package name */
        public i0 f22647b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f22648c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22649d;

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
            this.f22649d = vcodeActivity;
            this.f22646a = null;
            this.f22647b = null;
            this.f22648c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.f22649d.mModel == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.f22646a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.f22646a.addPostData("fid", this.f22649d.mModel.getForumId());
                    this.f22646a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f22649d.mModel.getForumName());
                    this.f22646a.addPostData("new_vcode", "1");
                    this.f22646a.addPostData("title", this.f22649d.mModel.getTitle());
                    this.f22646a.addPostData("content", this.f22649d.mModel.getContent());
                    if (this.f22649d.mModel.getType() == 0) {
                        this.f22646a.addPostData("pub_type", "1");
                        if (this.f22649d.mModel.getCategoryFrom() >= 0) {
                            this.f22646a.addPostData("fromCategoryId", String.valueOf(this.f22649d.mModel.getCategoryFrom()));
                        }
                        if (this.f22649d.mModel.getCategoryTo() >= 0) {
                            this.f22646a.addPostData("toCategoryId", String.valueOf(this.f22649d.mModel.getCategoryTo()));
                        }
                    } else {
                        this.f22646a.addPostData("pub_type", "2");
                        this.f22646a.addPostData("tid", this.f22649d.mModel.getThreadId());
                    }
                    String postNetData = this.f22646a.postNetData();
                    if (!this.f22646a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    i0 i0Var = new i0();
                    this.f22647b = i0Var;
                    i0Var.e(postNetData);
                    str = this.f22647b.c();
                }
                if (this.f22648c) {
                    return null;
                }
                this.f22646a = new NetWork(str);
                return BitmapHelper.Bytes2Bitmap(this.f22646a.getNetData());
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f22649d.mGetImageTask = null;
                if (this.f22646a != null) {
                    this.f22646a.cancelNetConnect();
                }
                this.f22648c = true;
                this.f22649d.mProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.f22649d.mGetImageTask = null;
                if (bitmap != null) {
                    this.f22649d.mImage.setImageBitmap(bitmap);
                }
                this.f22649d.mProgressBar.setVisibility(8);
                if (this.f22647b != null && this.f22649d.mModel != null) {
                    this.f22649d.mModel.setVcodeMD5(this.f22647b.b());
                    this.f22649d.mModel.setVcodeUrl(this.f22647b.c());
                }
                super.onPostExecute((e) bitmap);
            }
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, i0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WriteData f22650a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f22651b;

        /* renamed from: c  reason: collision with root package name */
        public String f22652c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VcodeActivity f22653d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f22654e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f22655f;

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
                this.f22655f = fVar;
                this.f22654e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.p0.h2.j.c.a(this.f22655f.f22653d.getPageContext(), this.f22654e).show();
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
            this.f22653d = vcodeActivity;
            this.f22650a = null;
            this.f22651b = null;
            this.f22652c = null;
            this.f22650a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public i0 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Address h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.f22650a == null) {
                    return null;
                }
                this.f22651b = new NetWork();
                String obj = this.f22653d.mEdit.getText().toString();
                String imagesCodeForPost = this.f22650a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.f22651b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.f22650a.getType() == 3) {
                    this.f22651b.addPostData("newVcode", "1");
                    this.f22651b.addPostData("content", this.f22650a.getContent() + imagesCodeForPost);
                    this.f22651b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.f22650a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f22651b.addPostData("vcode", obj);
                    }
                    this.f22651b.addPostData("tag", "11");
                    this.f22651b.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f22651b.addPostData("content", this.f22650a.getContent() + imagesCodeForPost);
                    this.f22651b.setUrl(d.a.p0.h3.i0.a.m);
                    this.f22651b.addPostData("fname", this.f22650a.getForumName());
                    this.f22651b.addPostData("title", this.f22650a.getTitle());
                    this.f22651b.addPostData("apiKey", this.f22650a.getShareApiKey());
                    this.f22651b.addPostData("appName", this.f22650a.getShareAppName());
                    this.f22651b.addPostData("signKey", this.f22650a.getShareSignKey());
                    this.f22651b.addPostData("summary_title", this.f22650a.getShareSummaryTitle());
                    this.f22651b.addPostData("summary_content", this.f22650a.getShareSummaryContent());
                    this.f22651b.addPostData("summary_img", this.f22650a.getShareSummaryImg());
                    this.f22651b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.f22650a.getShareSummaryImgWidth()));
                    this.f22651b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.f22650a.getShareSummaryImgHeight()));
                    this.f22651b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.f22650a.getShareSummaryImgType());
                    this.f22651b.addPostData("referUrl", this.f22650a.getShareReferUrl());
                } else {
                    this.f22651b.addPostData("anonymous", "0");
                    this.f22651b.addPostData("fid", this.f22650a.getForumId());
                    this.f22651b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f22650a.getForumName());
                    if (this.f22650a.getProZone() >= 0) {
                        this.f22651b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.f22650a.getProZone()));
                    }
                    this.f22651b.addPostData("can_no_forum", this.f22650a.isCanNoForum() ? "1" : "0");
                    this.f22651b.addPostData("is_feedback", this.f22650a.isUserFeedback() ? "1" : "0");
                    this.f22651b.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.f22650a.getSpanGroupString()) ? this.f22650a.getContent() : this.f22650a.getSpanGroupString();
                    VideoInfo videoInfo = this.f22650a.getVideoInfo();
                    if (videoInfo != null && videoInfo.hasUpload()) {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    } else {
                        str = content + imagesCodeForPost;
                    }
                    this.f22651b.addPostData("content", d.a.p0.o0.a.b(str));
                    g.a(this.f22651b, this.f22650a);
                    this.f22651b.addPostData("vcode_md5", this.f22650a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.f22651b.addPostData("vcode", obj);
                    }
                    this.f22651b.getNetContext().getRequest().mIsNeedTbs = true;
                    if (this.f22650a.getVoice() != null) {
                        this.f22651b.addPostData("voice_md5", this.f22650a.getVoice());
                        this.f22651b.addPostData("during_time", String.valueOf(this.f22650a.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.f22650a.getTopicId())) {
                        this.f22651b.addPostData("topic_id", this.f22650a.getTopicId());
                    }
                    if (this.f22650a.getType() != 0 && this.f22650a.getType() != 9 && this.f22650a.getType() != 7) {
                        if (this.f22650a.getType() == 6) {
                            this.f22651b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f22651b.addPostData("title", this.f22650a.getTitle());
                            this.f22651b.addPostData("is_ntitle", this.f22650a.isNoTitle() ? "1" : "0");
                            this.f22651b.addPostData("thread_type", String.valueOf(36));
                        } else if (this.f22650a.getType() == 4) {
                            this.f22651b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.f22651b.addPostData("title", this.f22650a.getTitle());
                            this.f22651b.addPostData("is_ntitle", "0");
                            this.f22651b.addPostData("thread_type", String.valueOf(33));
                            this.f22651b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else {
                            this.f22651b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                            this.f22651b.addPostData("tid", this.f22650a.getThreadId());
                            this.f22651b.addPostData("is_ad", this.f22653d.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                            if (this.f22650a.getBaijiahaoData() != null) {
                                this.f22651b.addPostData("ori_ugc_nid", this.f22650a.getBaijiahaoData().oriUgcNid);
                                this.f22651b.addPostData("ori_ugc_tid", this.f22650a.getBaijiahaoData().oriUgcTid);
                                this.f22651b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22650a.getBaijiahaoData().oriUgcType));
                                this.f22651b.addPostData("ori_ugc_vid", this.f22650a.getBaijiahaoData().oriUgcVid);
                            }
                            if (this.f22650a.getType() == 2) {
                                this.f22651b.addPostData("quote_id", String.valueOf(this.f22650a.getFloor()));
                                this.f22651b.addPostData("floor_num", String.valueOf(this.f22650a.getFloorNum()));
                                this.f22651b.addPostData("is_addition", this.f22650a.isAddition() ? "1" : "0");
                                if (this.f22650a.getRepostId() != null) {
                                    this.f22651b.addPostData("repostid", this.f22650a.getRepostId());
                                }
                                this.f22651b.addPostData("v_fid", this.f22650a.getVForumId());
                                this.f22651b.addPostData("v_fname", this.f22650a.getVForumName());
                            } else if (this.f22650a.getType() == 5) {
                                this.f22651b.addPostData("is_twzhibo_thread", String.valueOf(1));
                            } else if (this.f22650a.getType() == 1) {
                                this.f22651b.addPostData("is_barrage", !this.f22650a.isBarrage() ? "0" : "1");
                                this.f22651b.addPostData("barrage_time", String.valueOf(this.f22650a.getBarrageTime()));
                                if (d.a.o0.w.w.a.a().b() == 1) {
                                    this.f22651b.addPostData("ptype", "4");
                                }
                                this.f22651b.addPostData("v_fid", this.f22650a.getVForumId());
                                this.f22651b.addPostData("v_fname", this.f22650a.getVForumName());
                            }
                        }
                    } else {
                        this.f22651b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.f22650a.getType() == 0 || this.f22650a.getType() == 9) {
                            this.f22651b.addPostData("transform_forums", this.f22650a.getTransmitForumData());
                            this.f22651b.addPostData(IntentConfig.CALL_FROM, this.f22650a.getStatisticFrom() + "");
                            if (this.f22650a.getRecommendExt() != null) {
                                this.f22651b.addPostData("recommend_ext", this.f22650a.getRecommendExt());
                            }
                        }
                        this.f22651b.addPostData("title", this.f22650a.getTitle());
                        this.f22651b.addPostData("is_ntitle", this.f22650a.isNoTitle() ? "1" : "0");
                        if (this.f22650a.getType() == 7) {
                            this.f22651b.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.f22650a.getCategoryFrom() >= 0) {
                            this.f22651b.addPostData("fromCategoryId", String.valueOf(this.f22650a.getCategoryFrom()));
                        }
                        if (this.f22650a.getCategoryTo() >= 0) {
                            this.f22651b.addPostData("toCategoryId", String.valueOf(this.f22650a.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(this.f22653d.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (h2 = d.a.c.e.i.a.l().h(false)) != null) {
                            this.f22651b.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                        }
                        if (this.f22650a.isShareThread()) {
                            this.f22651b.addPostData("is_share", "1");
                            this.f22651b.addPostData("from_tid", this.f22650a.getOriginalThreadId());
                        }
                        if (this.f22650a.isShareThread()) {
                            if (this.f22650a.getOriBaijiahaoData() != null) {
                                this.f22651b.addPostData("ori_ugc_nid", this.f22650a.getOriBaijiahaoData().oriUgcNid);
                                this.f22651b.addPostData("ori_ugc_vid", this.f22650a.getOriBaijiahaoData().oriUgcVid);
                                this.f22651b.addPostData("ori_ugc_tid", this.f22650a.getOriBaijiahaoData().oriUgcTid);
                                this.f22651b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22650a.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.f22650a.getBaijiahaoData() != null) {
                            this.f22651b.addPostData("ori_ugc_nid", this.f22650a.getBaijiahaoData().oriUgcNid);
                            this.f22651b.addPostData("ori_ugc_vid", this.f22650a.getBaijiahaoData().oriUgcVid);
                            this.f22651b.addPostData("ori_ugc_tid", this.f22650a.getBaijiahaoData().oriUgcTid);
                            this.f22651b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f22650a.getBaijiahaoData().oriUgcType));
                        }
                        if (this.f22650a.getTabId() > 0) {
                            this.f22651b.addPostData("tab_name", this.f22650a.getTabName());
                            this.f22651b.addPostData("tab_id", String.valueOf(this.f22650a.getTabId()));
                            this.f22651b.addPostData("is_general_tab", String.valueOf(this.f22650a.getIsGeneralTab()));
                        }
                    }
                }
                if (this.f22651b.getNetContext() != null && this.f22651b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f22651b.getNetContext().getRequest().getNetWorkParam()));
                }
                this.f22652c = this.f22651b.postNetData();
                return null;
            }
            return (i0) invokeL.objValue;
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
        public void onPostExecute(i0 i0Var) {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var) == null) {
                String str7 = "";
                this.f22653d.closeLoadingDialog();
                this.f22653d.mPostThreadTask = null;
                NetWork netWork = this.f22651b;
                if (netWork != null) {
                    int i2 = 0;
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.f22652c);
                        if (errorData.error_code == 0) {
                            this.f22653d.isVcodeCheckSuccess = true;
                            try {
                                JSONObject jSONObject2 = new JSONObject(this.f22652c);
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
                                            if (this.f22650a.getType() != 3) {
                                                g.b(this.f22653d.getActivity(), str4, str5, str6);
                                            }
                                            this.f22650a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            jSONObject = new JSONObject(this.f22652c);
                                            String str8 = jSONObject.optString("tid");
                                            str2 = jSONObject.optString("pid");
                                            try {
                                                str3 = jSONObject.optString("msg");
                                                str7 = jSONObject.optString("video_id");
                                                customDialogData = d.a.p0.h2.b.a(jSONObject);
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
                                                writeData = this.f22650a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent.putExtras(bundle);
                                                this.f22653d.setResult(-1, intent);
                                                if (this.f22650a != null) {
                                                }
                                                this.f22653d.finish();
                                                super.onPostExecute(i0Var);
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
                                                writeData = this.f22650a;
                                                if (writeData != null) {
                                                }
                                                postWriteCallBackData.setActivityDialog(customDialogData);
                                                if (customDialogData != null) {
                                                }
                                                Intent intent2 = new Intent();
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                                intent2.putExtras(bundle2);
                                                this.f22653d.setResult(-1, intent2);
                                                if (this.f22650a != null) {
                                                }
                                                this.f22653d.finish();
                                                super.onPostExecute(i0Var);
                                            }
                                            postWriteCallBackData.setThreadId(str8);
                                            postWriteCallBackData.setPostId(str2);
                                            postWriteCallBackData.setIsCopyTWZhibo(i2);
                                            postWriteCallBackData.setErrorString(str3);
                                            postWriteCallBackData.setVideoid(str7);
                                            writeData = this.f22650a;
                                            if (writeData != null) {
                                            }
                                            postWriteCallBackData.setActivityDialog(customDialogData);
                                            if (customDialogData != null) {
                                            }
                                            Intent intent22 = new Intent();
                                            Bundle bundle22 = new Bundle();
                                            bundle22.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent22.putExtras(bundle22);
                                            this.f22653d.setResult(-1, intent22);
                                            if (this.f22650a != null) {
                                                d.a.p0.h3.q0.a.g().s(this.f22650a.getForumId());
                                                d.a.p0.h3.q0.a.g().t(this.f22650a.getForumName());
                                                if (!k.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.f22650a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, d.a.p0.h3.q0.a.g().f()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                                d.a.p0.h3.q0.a.g().q(null);
                                            }
                                            this.f22653d.finish();
                                            super.onPostExecute(i0Var);
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
                            if (this.f22650a.getType() != 3 && this.f22650a.getType() != 7) {
                                g.b(this.f22653d.getActivity(), str4, str5, str6);
                            }
                            this.f22650a.deleteUploadedTempImages();
                        } else {
                            if (this.f22650a.isHasImages()) {
                                if (k.isEmpty(this.f22650a.getContent() + this.f22650a.getImagesCodeForPost())) {
                                    this.f22653d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                                }
                            }
                            if (this.f22650a.getType() != 3) {
                                this.f22653d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            jSONObject = new JSONObject(this.f22652c);
                            String str82 = jSONObject.optString("tid");
                            try {
                                str2 = jSONObject.optString("pid");
                                str3 = jSONObject.optString("msg");
                                try {
                                    str7 = jSONObject.optString("video_id");
                                    customDialogData = d.a.p0.h2.b.a(jSONObject);
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
                        writeData = this.f22650a;
                        if (writeData != null) {
                            postWriteCallBackData.setProZone(writeData.getProZone());
                        }
                        postWriteCallBackData.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            WriteData writeData2 = this.f22650a;
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
                            d.a.c.e.m.e.a().postDelayed(new a(this, customDialogData), 2000L);
                        }
                        Intent intent222 = new Intent();
                        Bundle bundle222 = new Bundle();
                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent222.putExtras(bundle222);
                        this.f22653d.setResult(-1, intent222);
                        if (this.f22650a != null && d.a.p0.h3.q0.a.g().f() != null) {
                            d.a.p0.h3.q0.a.g().s(this.f22650a.getForumId());
                            d.a.p0.h3.q0.a.g().t(this.f22650a.getForumName());
                            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && this.f22650a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.f22650a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, d.a.p0.h3.q0.a.g().f()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                            d.a.p0.h3.q0.a.g().q(null);
                        }
                        this.f22653d.finish();
                    } else {
                        if (this.f22650a.isHasImages()) {
                            if (k.isEmpty(this.f22650a.getContent() + this.f22650a.getImagesCodeForPost())) {
                                this.f22653d.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                            }
                        }
                        if (this.f22651b.getServerErrorCode() != 5 && this.f22651b.getServerErrorCode() != 6) {
                            if (this.f22650a != null && this.f22651b.getServerErrorCode() == 227001) {
                                AccessState accessState = new AccessState();
                                accessState.parserJson(this.f22652c);
                                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.f22651b.getServerErrorCode(), this.f22651b.getErrorString(), null, null);
                                postWriteCallBackData2.setAccessState(accessState);
                                this.f22653d.getActivity().setVisible(false);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f22653d.getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, this.f22650a, postWriteCallBackData2.getAccessState())));
                            } else if (this.f22651b.getServerErrorCode() == 220009) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.f22651b.getErrorString()));
                                this.f22653d.finish();
                            } else if (this.f22651b.getServerErrorCode() == 220015) {
                                PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                                if (this.f22652c != null) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(this.f22652c);
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
                                this.f22653d.setResult(0, intent3);
                                this.f22653d.finish();
                            }
                        } else {
                            i0 i0Var2 = new i0();
                            i0Var2.e(this.f22652c);
                            if (i0Var2.c() != null && this.f22653d.mModel != null) {
                                this.f22653d.mModel.setVcodeMD5(i0Var2.b());
                                this.f22653d.mModel.setVcodeUrl(i0Var2.c());
                                VcodeActivity vcodeActivity = this.f22653d;
                                vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                            }
                            this.f22653d.mEdit.setText((CharSequence) null);
                        }
                        if (this.f22651b.getServerErrorCode() != 227001 && this.f22651b.getServerErrorCode() == 220015) {
                            this.f22653d.showToast(this.f22651b.getErrorString());
                        }
                    }
                }
                super.onPostExecute(i0Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f22653d.mPostThreadTask = null;
                this.f22653d.closeLoadingDialog();
                NetWork netWork = this.f22651b;
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
            d.a.o0.r.f0.a aVar = new d.a.o0.r.f0.a(getPageContext());
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
            d.a.o0.r.a0.b.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
