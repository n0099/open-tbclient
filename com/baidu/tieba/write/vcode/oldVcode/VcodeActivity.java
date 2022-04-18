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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr7;
import com.repackage.en8;
import com.repackage.gf;
import com.repackage.gl8;
import com.repackage.gt7;
import com.repackage.i25;
import com.repackage.ni;
import com.repackage.ni8;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.qt4;
import com.repackage.qx4;
import com.repackage.t86;
import com.repackage.xt4;
import com.repackage.ym8;
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
        public final /* synthetic */ VcodeActivity a;

        public a(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcodeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                if (this.a.mPostThreadTask != null) {
                    this.a.mPostThreadTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VcodeActivity a;

        public b(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VcodeActivity a;

        public c(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VcodeActivity vcodeActivity = this.a;
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.mInputManager, this.a.mEdit);
                this.a.showDialog();
                if (this.a.mPostThreadTask != null) {
                    this.a.mPostThreadTask.cancel();
                }
                this.a.isVcodeCheckSuccess = false;
                VcodeActivity vcodeActivity2 = this.a;
                VcodeActivity vcodeActivity3 = this.a;
                vcodeActivity2.mPostThreadTask = new f(vcodeActivity3, vcodeActivity3.mModel);
                this.a.mPostThreadTask.setPriority(3);
                this.a.mPostThreadTask.execute(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VcodeActivity a;

        public d(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcodeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.refreshImage((String) null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public qx4 b;
        public volatile boolean c;
        public final /* synthetic */ VcodeActivity d;

        public e(VcodeActivity vcodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vcodeActivity;
            this.a = null;
            this.b = null;
            this.c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.d.mModel == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.a.addPostData("fid", this.d.mModel.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.d.mModel.getForumName());
                    this.a.addPostData("new_vcode", "1");
                    this.a.addPostData("title", this.d.mModel.getTitle());
                    this.a.addPostData("content", this.d.mModel.getContent());
                    if (this.d.mModel.getType() == 0) {
                        this.a.addPostData("pub_type", "1");
                        if (this.d.mModel.getCategoryFrom() >= 0) {
                            this.a.addPostData("fromCategoryId", String.valueOf(this.d.mModel.getCategoryFrom()));
                        }
                        if (this.d.mModel.getCategoryTo() >= 0) {
                            this.a.addPostData("toCategoryId", String.valueOf(this.d.mModel.getCategoryTo()));
                        }
                    } else {
                        this.a.addPostData("pub_type", "2");
                        this.a.addPostData("tid", this.d.mModel.getThreadId());
                    }
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    qx4 qx4Var = new qx4();
                    this.b = qx4Var;
                    qx4Var.e(postNetData);
                    str = this.b.c();
                }
                if (this.c) {
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
                this.d.mGetImageTask = null;
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.c = true;
                this.d.mProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.d.mGetImageTask = null;
                if (bitmap != null) {
                    this.d.mImage.setImageBitmap(bitmap);
                }
                this.d.mProgressBar.setVisibility(8);
                if (this.b != null && this.d.mModel != null) {
                    this.d.mModel.setVcodeMD5(this.b.b());
                    this.d.mModel.setVcodeUrl(this.b.c());
                }
                super.onPostExecute((e) bitmap);
            }
        }

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, qx4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteData a;
        public NetWork b;
        public String c;
        public final /* synthetic */ VcodeActivity d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ f b;

            public a(f fVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gt7.a(this.b.d.getPageContext(), this.a).show();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vcodeActivity;
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public qx4 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Address j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.a == null) {
                    return null;
                }
                this.b = new NetWork();
                String obj = this.d.mEdit.getText().toString();
                String imagesCodeForPost = this.a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                if (this.a.getType() == 3) {
                    this.b.addPostData("newVcode", "1");
                    this.b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.b.addPostData(PayVcodeActivityConfig.VCODE_MD5, this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.b.addPostData("vcode", obj);
                    }
                    this.b.addPostData("tag", "11");
                    this.b.getNetContext().getRequest().mIsNeedTbs = true;
                    this.b.addPostData("content", this.a.getContent() + imagesCodeForPost);
                    this.b.setUrl(gl8.m);
                    this.b.addPostData("fname", this.a.getForumName());
                    this.b.addPostData("title", this.a.getTitle());
                    this.b.addPostData("apiKey", this.a.getShareApiKey());
                    this.b.addPostData("appName", this.a.getShareAppName());
                    this.b.addPostData("signKey", this.a.getShareSignKey());
                    this.b.addPostData("summary_title", this.a.getShareSummaryTitle());
                    this.b.addPostData("summary_content", this.a.getShareSummaryContent());
                    this.b.addPostData("summary_img", this.a.getShareSummaryImg());
                    this.b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.a.getShareSummaryImgWidth()));
                    this.b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.a.getShareSummaryImgHeight()));
                    this.b.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.a.getShareSummaryImgType());
                    this.b.addPostData("referUrl", this.a.getShareReferUrl());
                } else {
                    this.b.addPostData("anonymous", "0");
                    this.b.addPostData("fid", this.a.getForumId());
                    this.b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a.getForumName());
                    if (this.a.getProZone() >= 0) {
                        this.b.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(this.a.getProZone()));
                    }
                    this.b.addPostData("can_no_forum", this.a.isCanNoForum() ? "1" : "0");
                    this.b.addPostData("is_feedback", this.a.isUserFeedback() ? "1" : "0");
                    this.b.addPostData("new_vcode", "1");
                    String content = TextUtils.isEmpty(this.a.getSpanGroupString()) ? this.a.getContent() : this.a.getSpanGroupString();
                    VideoInfo videoInfo = this.a.getVideoInfo();
                    if (videoInfo != null && videoInfo.hasUpload()) {
                        str = content + videoInfo.buildContent() + imagesCodeForPost;
                    } else if (this.a.isRichTextEditorMode()) {
                        StringBuilder sb = new StringBuilder();
                        for (Object obj2 : this.a.getServerRichContentData()) {
                            if (obj2 instanceof String) {
                                sb.append(obj2);
                            } else if (obj2 instanceof ImageFileInfo) {
                                ImageFileInfo imageFileInfo = (ImageFileInfo) obj2;
                                if (imageFileInfo.isAlreadyUploadedToServer()) {
                                    sb.append("\n");
                                    sb.append(imageFileInfo.getServerImageCode());
                                }
                            }
                        }
                        str = sb.toString();
                    } else {
                        str = content + imagesCodeForPost;
                    }
                    this.b.addPostData("content", t86.c(str));
                    en8.a(this.b, this.a);
                    this.b.addPostData("vcode_md5", this.a.getVcodeMD5());
                    if (obj.length() > 0) {
                        this.b.addPostData("vcode", obj);
                    }
                    this.b.getNetContext().getRequest().mIsNeedTbs = true;
                    if (this.a.getVoice() != null) {
                        this.b.addPostData("voice_md5", this.a.getVoice());
                        this.b.addPostData("during_time", String.valueOf(this.a.getVoiceDuringTime()));
                    }
                    if (!TextUtils.isEmpty(this.a.getTopicId())) {
                        this.b.addPostData("topic_id", this.a.getTopicId());
                    }
                    this.b.addPostData("is_pictxt", this.a.isRichTextEditorMode() ? "1" : "0");
                    if (this.a.getType() != 0 && this.a.getType() != 9 && this.a.getType() != 7) {
                        if (this.a.getType() == 6) {
                            this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.b.addPostData("title", this.a.getTitle());
                            this.b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                            this.b.addPostData("thread_type", String.valueOf(36));
                        } else if (this.a.getType() == 4) {
                            this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                            this.b.addPostData("title", this.a.getTitle());
                            this.b.addPostData("is_ntitle", "0");
                            this.b.addPostData("thread_type", String.valueOf(33));
                            this.b.addPostData("is_twzhibo_thread", String.valueOf(1));
                        } else {
                            this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                            this.b.addPostData("tid", this.a.getThreadId());
                            this.b.addPostData("is_ad", this.d.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                            if (this.a.getBaijiahaoData() != null) {
                                this.b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                                this.b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                                this.b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                                this.b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            }
                            if (this.a.getType() == 2) {
                                this.b.addPostData("quote_id", String.valueOf(this.a.getFloor()));
                                this.b.addPostData("floor_num", String.valueOf(this.a.getFloorNum()));
                                this.b.addPostData("is_addition", this.a.isAddition() ? "1" : "0");
                                if (this.a.getRepostId() != null) {
                                    this.b.addPostData("repostid", this.a.getRepostId());
                                }
                                if (this.a.getReSubPostId() != null) {
                                    this.b.addPostData("sub_post_id", this.a.getReSubPostId());
                                }
                                this.b.addPostData("v_fid", this.a.getVForumId());
                                this.b.addPostData("v_fname", this.a.getVForumName());
                            } else if (this.a.getType() == 5) {
                                this.b.addPostData("is_twzhibo_thread", String.valueOf(1));
                            } else if (this.a.getType() == 1) {
                                this.b.addPostData("is_barrage", !this.a.isBarrage() ? "0" : "1");
                                this.b.addPostData("barrage_time", String.valueOf(this.a.getBarrageTime()));
                                if (i25.a().b() == 1) {
                                    this.b.addPostData("ptype", "4");
                                }
                                this.b.addPostData("v_fid", this.a.getVForumId());
                                this.b.addPostData("v_fname", this.a.getVForumName());
                            }
                        }
                    } else {
                        this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                        if (this.a.getType() == 0 || this.a.getType() == 9) {
                            this.b.addPostData("transform_forums", this.a.getTransmitForumData());
                            this.b.addPostData(IntentConfig.CALL_FROM, this.a.getStatisticFrom() + "");
                            if (this.a.getRecommendExt() != null) {
                                this.b.addPostData("recommend_ext", this.a.getRecommendExt());
                            }
                        }
                        this.b.addPostData("title", this.a.getTitle());
                        this.b.addPostData("is_ntitle", this.a.isNoTitle() ? "1" : "0");
                        if (this.a.getType() == 7) {
                            this.b.addPostData("is_bottle", String.valueOf(1));
                        }
                        if (this.a.getCategoryFrom() >= 0) {
                            this.b.addPostData("fromCategoryId", String.valueOf(this.a.getCategoryFrom()));
                        }
                        if (this.a.getCategoryTo() >= 0) {
                            this.b.addPostData("toCategoryId", String.valueOf(this.a.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(this.d.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.getInst().getIsLocationOn() && (j = gf.n().j(false)) != null) {
                            this.b.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                        }
                        if (this.a.isShareThread()) {
                            this.b.addPostData("is_share", "1");
                            this.b.addPostData("from_tid", this.a.getOriginalThreadId());
                        }
                        if (this.a.isShareThread()) {
                            if (this.a.getOriBaijiahaoData() != null) {
                                this.b.addPostData("ori_ugc_nid", this.a.getOriBaijiahaoData().oriUgcNid);
                                this.b.addPostData("ori_ugc_vid", this.a.getOriBaijiahaoData().oriUgcVid);
                                this.b.addPostData("ori_ugc_tid", this.a.getOriBaijiahaoData().oriUgcTid);
                                this.b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getOriBaijiahaoData().oriUgcType));
                            }
                        } else if (this.a.getBaijiahaoData() != null) {
                            this.b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                            this.b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                            this.b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                            this.b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                        }
                        if (this.a.getTabId() > 0) {
                            this.b.addPostData("tab_name", this.a.getTabName());
                            this.b.addPostData("tab_id", String.valueOf(this.a.getTabId()));
                            this.b.addPostData("is_general_tab", String.valueOf(this.a.getIsGeneralTab()));
                        }
                    }
                }
                if (this.b.getNetContext() != null && this.b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.b.getNetContext().getRequest().getNetWorkParam()));
                }
                this.c = this.b.postNetData();
                return null;
            }
            return (qx4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x01bf, code lost:
            if (r0 != 7) goto L79;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0164 A[Catch: JSONException -> 0x016c, TRY_LEAVE, TryCatch #5 {JSONException -> 0x016c, blocks: (B:65:0x0152, B:67:0x0164), top: B:174:0x0152 }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x019b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01a7  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(qx4 qx4Var) {
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
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qx4Var) == null) {
                String str7 = "";
                this.d.closeLoadingDialog();
                CustomDialogData customDialogData = null;
                this.d.mPostThreadTask = null;
                NetWork netWork = this.b;
                if (netWork != null) {
                    int i = 0;
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        if (errorData.error_code == 0) {
                            this.d.isVcodeCheckSuccess = true;
                            try {
                                JSONObject jSONObject = new JSONObject(this.c);
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
                                        } catch (JSONException e) {
                                            e = e;
                                            e.printStackTrace();
                                            str6 = null;
                                            if (StringUtils.isNull(str4)) {
                                            }
                                            if (this.a.getType() != 3) {
                                                en8.b(this.d.getActivity(), str4, str5, str6);
                                            }
                                            writeData2 = this.a;
                                            if (writeData2 != null) {
                                                if (TbSingleton.getInstance().showStampMissionDialog) {
                                                    ni8.r().A(0, 3);
                                                    ni8.r().G();
                                                }
                                                ni8.r().z(StampMission.Type.REPLAY_THREAD);
                                            }
                                            this.a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            JSONObject jSONObject2 = new JSONObject(this.c);
                                            String str8 = jSONObject2.optString("tid");
                                            try {
                                                str2 = jSONObject2.optString("pid");
                                                try {
                                                    str3 = jSONObject2.optString("msg");
                                                } catch (JSONException e2) {
                                                    e = e2;
                                                    str3 = "";
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
                                                    this.d.setResult(-1, intent);
                                                    if (this.a != null) {
                                                        ym8.k().C(this.a.getForumId());
                                                        ym8.k().D(this.a.getForumName());
                                                        if (!ni.isEmpty(postWriteCallBackData.getVideoid())) {
                                                            postWriteCallBackData.writeDataForVideo = this.a;
                                                        }
                                                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, ym8.k().i()));
                                                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                                    }
                                                    this.d.finish();
                                                    super.onPostExecute(qx4Var);
                                                }
                                            } catch (JSONException e3) {
                                                e = e3;
                                                str2 = "";
                                                str3 = str2;
                                            }
                                            try {
                                                str7 = jSONObject2.optString("video_id");
                                                customDialogData = cr7.a(jSONObject2);
                                                optJSONObject = jSONObject2.optJSONObject("twzhibo_info");
                                                if (optJSONObject != null) {
                                                }
                                            } catch (JSONException e4) {
                                                jSONException = e4;
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
                                                this.d.setResult(-1, intent2);
                                                if (this.a != null) {
                                                }
                                                this.d.finish();
                                                super.onPostExecute(qx4Var);
                                            }
                                            postWriteCallBackData.setThreadId(str8);
                                            postWriteCallBackData.setPostId(str2);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
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
                                            this.d.setResult(-1, intent22);
                                            if (this.a != null) {
                                            }
                                            this.d.finish();
                                            super.onPostExecute(qx4Var);
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
                                str4 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10ec);
                            }
                            if (this.a.getType() != 3 && this.a.getType() != 7) {
                                en8.b(this.d.getActivity(), str4, str5, str6);
                            }
                            writeData2 = this.a;
                            if (writeData2 != null && ((writeData2.getType() == 1 || this.a.getType() == 2) && TbadkCoreApplication.isLogin())) {
                                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                                    ni8.r().A(0, 3);
                                    ni8.r().G();
                                }
                                ni8.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                            this.a.deleteUploadedTempImages();
                        } else {
                            if (this.a.isHasImages()) {
                                if (ni.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                    this.d.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c7));
                                }
                            }
                            if (this.a.getType() != 3) {
                                this.d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            JSONObject jSONObject22 = new JSONObject(this.c);
                            String str82 = jSONObject22.optString("tid");
                            str2 = jSONObject22.optString("pid");
                            str3 = jSONObject22.optString("msg");
                            str7 = jSONObject22.optString("video_id");
                            customDialogData = cr7.a(jSONObject22);
                            optJSONObject = jSONObject22.optJSONObject("twzhibo_info");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("is_copytwzhibo", 0);
                            }
                        } catch (JSONException e7) {
                            jSONException = e7;
                            str = "";
                            str2 = str;
                            str3 = str2;
                        }
                        postWriteCallBackData.setThreadId(str82);
                        postWriteCallBackData.setPostId(str2);
                        postWriteCallBackData.setIsCopyTWZhibo(i);
                        postWriteCallBackData.setErrorString(str3);
                        postWriteCallBackData.setVideoid(str7);
                        writeData = this.a;
                        if (writeData != null) {
                            postWriteCallBackData.setProZone(writeData.getProZone());
                        }
                        postWriteCallBackData.setActivityDialog(customDialogData);
                        if (customDialogData != null) {
                            WriteData writeData3 = this.a;
                            if (writeData3 != null) {
                                int type = writeData3.getType();
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
                            pg.a().postDelayed(new a(this, customDialogData), 2000L);
                        }
                        Intent intent222 = new Intent();
                        Bundle bundle222 = new Bundle();
                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent222.putExtras(bundle222);
                        this.d.setResult(-1, intent222);
                        if (this.a != null && ym8.k().i() != null) {
                            ym8.k().C(this.a.getForumId());
                            ym8.k().D(this.a.getForumName());
                            if (!ni.isEmpty(postWriteCallBackData.getVideoid()) && this.a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, ym8.k().i()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        }
                        this.d.finish();
                    } else {
                        if (this.a.isHasImages()) {
                            if (ni.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                this.d.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c7));
                            }
                        }
                        if (this.b.getServerErrorCode() != 5 && this.b.getServerErrorCode() != 6) {
                            if (this.a != null && this.b.getServerErrorCode() == 227001) {
                                AccessState accessState = new AccessState();
                                accessState.parserJson(this.c);
                                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(this.b.getServerErrorCode(), this.b.getErrorString(), null, null);
                                postWriteCallBackData2.setAccessState(accessState);
                                this.d.getActivity().setVisible(false);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.d.getActivity(), 12006, this.a, postWriteCallBackData2.getAccessState())));
                            } else if (this.b.getServerErrorCode() == 220009) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2016554, this.b.getErrorString()));
                                this.d.finish();
                            } else if (this.b.getServerErrorCode() == 220015) {
                                PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                                if (this.c != null) {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(this.c);
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
                                    } catch (JSONException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                Intent intent3 = new Intent();
                                Bundle bundle3 = new Bundle();
                                bundle3.putSerializable("post_write_callback_data", postWriteCallBackData3);
                                intent3.putExtras(bundle3);
                                this.d.setResult(0, intent3);
                                this.d.finish();
                            }
                        } else {
                            qx4 qx4Var2 = new qx4();
                            qx4Var2.e(this.c);
                            if (qx4Var2.c() != null && this.d.mModel != null) {
                                this.d.mModel.setVcodeMD5(qx4Var2.b());
                                this.d.mModel.setVcodeUrl(qx4Var2.c());
                                VcodeActivity vcodeActivity = this.d;
                                vcodeActivity.refreshImage(vcodeActivity.mModel.getVcodeUrl());
                            }
                            this.d.mEdit.setText((CharSequence) null);
                        }
                        if (this.b.getServerErrorCode() != 227001 && this.b.getServerErrorCode() == 220015) {
                            this.d.showToast(this.b.getErrorString());
                        }
                    }
                }
                super.onPostExecute(qx4Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d.mPostThreadTask = null;
                this.d.closeLoadingDialog();
                NetWork netWork = this.b;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.mInfo = (TextView) findViewById(R.id.obfuscated_res_0x7f090ef0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f10df), this.onPostListener);
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.mPost.setLayoutParams(layoutParams);
            this.mEdit = (EditText) findViewById(R.id.obfuscated_res_0x7f090ef9);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922d1);
            this.mImage = imageView;
            imageView.setImageDrawable(null);
            this.mImage.setOnClickListener(new d(this));
            this.mProgressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09191d);
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
            xt4 xt4Var = new xt4(getPageContext());
            this.mWaitingDialog = xt4Var;
            xt4Var.i(R.string.obfuscated_res_0x7f0f10ef);
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBgColor(this.mParent, i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.mPost, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mPost, (int) R.color.CAM_X0111);
            this.mInfo.setTextColor((i == 1 || i == 4) ? SkinManager.getCommentTextColor(i) : -12895429);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0863);
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
            qt4.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
