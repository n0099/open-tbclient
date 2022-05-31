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
import com.repackage.at4;
import com.repackage.cj8;
import com.repackage.eh8;
import com.repackage.gf;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.lo7;
import com.repackage.me8;
import com.repackage.mg;
import com.repackage.o66;
import com.repackage.pq7;
import com.repackage.t15;
import com.repackage.ts4;
import com.repackage.wi8;
import com.repackage.ww4;
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
        public ww4 b;
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
                    ww4 ww4Var = new ww4();
                    this.b = ww4Var;
                    ww4Var.e(postNetData);
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
    public class f extends BdAsyncTask<Integer, Integer, ww4> {
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
                    pq7.a(this.b.d.getPageContext(), this.a).show();
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
        public ww4 doInBackground(Integer... numArr) {
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
                    this.b.setUrl(eh8.m);
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
                    this.b.addPostData("content", o66.c(str));
                    cj8.a(this.b, this.a);
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
                                this.b.addPostData("is_barrage", this.a.isBarrage() ? "1" : "0");
                                this.b.addPostData("barrage_time", String.valueOf(this.a.getBarrageTime()));
                                if (t15.a().b() == 1) {
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
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.b.getNetContext().getRequest()));
                }
                this.c = this.b.postNetData();
                return null;
            }
            return (ww4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r0) == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x01ba, code lost:
            if (r0 != 7) goto L48;
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x01ea  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x015f A[Catch: JSONException -> 0x0167, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0167, blocks: (B:64:0x014d, B:66:0x015f), top: B:171:0x014d }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01a2  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(ww4 ww4Var) {
            JSONArray jSONArray;
            String str;
            String str2;
            String str3;
            WriteData writeData;
            PostWriteCallBackData postWriteCallBackData;
            JSONException jSONException;
            String str4;
            String str5;
            String str6;
            String str7;
            WriteData writeData2;
            JSONObject jSONObject;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ww4Var) == null) {
                String str8 = "";
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
                            try {
                                JSONObject jSONObject2 = new JSONObject(this.c);
                                str = jSONObject2.optString("msg");
                                try {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("exp");
                                    if (optJSONObject2 != null) {
                                        str2 = optJSONObject2.optString("pre_msg");
                                        if (StringUtils.isNull(str2)) {
                                            str2 = null;
                                        }
                                        try {
                                            str3 = optJSONObject2.optString("color_msg");
                                        } catch (JSONException e) {
                                            e = e;
                                            e.printStackTrace();
                                            str3 = null;
                                            if (StringUtils.isNull(str)) {
                                            }
                                            if (this.a.getType() != 3) {
                                                cj8.b(this.d.getActivity(), str, str2, str3);
                                            }
                                            writeData = this.a;
                                            if (writeData != null) {
                                                if (TbSingleton.getInstance().showStampMissionDialog) {
                                                    me8.r().A(0, 3);
                                                    me8.r().G();
                                                }
                                                me8.r().z(StampMission.Type.REPLAY_THREAD);
                                            }
                                            this.a.deleteUploadedTempImages();
                                            postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                            jSONObject = new JSONObject(this.c);
                                            str7 = jSONObject.optString("tid");
                                            try {
                                                str5 = jSONObject.optString("pid");
                                                str6 = jSONObject.optString("msg");
                                            } catch (JSONException e2) {
                                                e = e2;
                                                str5 = "";
                                                str6 = str5;
                                            }
                                            try {
                                                str8 = jSONObject.optString("video_id");
                                                customDialogData = lo7.a(jSONObject);
                                                optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                                if (optJSONObject != null) {
                                                }
                                            } catch (JSONException e3) {
                                                jSONException = e3;
                                                str4 = str8;
                                                str8 = str7;
                                                jSONException.printStackTrace();
                                                str7 = str8;
                                                str8 = str4;
                                                postWriteCallBackData.setThreadId(str7);
                                                postWriteCallBackData.setPostId(str5);
                                                postWriteCallBackData.setIsCopyTWZhibo(i);
                                                postWriteCallBackData.setErrorString(str6);
                                                postWriteCallBackData.setVideoid(str8);
                                                writeData2 = this.a;
                                                if (writeData2 != null) {
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
                                                }
                                                this.d.finish();
                                                super.onPostExecute(ww4Var);
                                            }
                                            postWriteCallBackData.setThreadId(str7);
                                            postWriteCallBackData.setPostId(str5);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str6);
                                            postWriteCallBackData.setVideoid(str8);
                                            writeData2 = this.a;
                                            if (writeData2 != null) {
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
                                                wi8.k().C(this.a.getForumId());
                                                wi8.k().D(this.a.getForumName());
                                                if (!ki.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, wi8.k().i()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                            }
                                            this.d.finish();
                                            super.onPostExecute(ww4Var);
                                        }
                                    } else {
                                        str3 = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e4) {
                                    e = e4;
                                    str2 = null;
                                }
                            } catch (JSONException e5) {
                                e = e5;
                                str = null;
                                str2 = null;
                            }
                            if (StringUtils.isNull(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1117);
                            }
                            if (this.a.getType() != 3 && this.a.getType() != 7) {
                                cj8.b(this.d.getActivity(), str, str2, str3);
                            }
                            writeData = this.a;
                            if (writeData != null && ((writeData.getType() == 1 || this.a.getType() == 2) && TbadkCoreApplication.isLogin())) {
                                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                                    me8.r().A(0, 3);
                                    me8.r().G();
                                }
                                me8.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                            this.a.deleteUploadedTempImages();
                        } else {
                            if (this.a.isHasImages()) {
                                if (ki.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                    this.d.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08d3));
                                }
                            }
                            if (this.a.getType() != 3) {
                                this.d.showToast(errorData.getError_msg());
                            }
                        }
                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                        try {
                            jSONObject = new JSONObject(this.c);
                            str7 = jSONObject.optString("tid");
                            str5 = jSONObject.optString("pid");
                        } catch (JSONException e6) {
                            jSONException = e6;
                            str4 = "";
                            str5 = str4;
                            str6 = str5;
                        }
                        try {
                            str6 = jSONObject.optString("msg");
                            str8 = jSONObject.optString("video_id");
                            customDialogData = lo7.a(jSONObject);
                            optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("is_copytwzhibo", 0);
                            }
                        } catch (JSONException e7) {
                            e = e7;
                            str6 = "";
                            str8 = str7;
                            jSONException = e;
                            str4 = str6;
                            jSONException.printStackTrace();
                            str7 = str8;
                            str8 = str4;
                            postWriteCallBackData.setThreadId(str7);
                            postWriteCallBackData.setPostId(str5);
                            postWriteCallBackData.setIsCopyTWZhibo(i);
                            postWriteCallBackData.setErrorString(str6);
                            postWriteCallBackData.setVideoid(str8);
                            writeData2 = this.a;
                            if (writeData2 != null) {
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
                            super.onPostExecute(ww4Var);
                        }
                        postWriteCallBackData.setThreadId(str7);
                        postWriteCallBackData.setPostId(str5);
                        postWriteCallBackData.setIsCopyTWZhibo(i);
                        postWriteCallBackData.setErrorString(str6);
                        postWriteCallBackData.setVideoid(str8);
                        writeData2 = this.a;
                        if (writeData2 != null) {
                            postWriteCallBackData.setProZone(writeData2.getProZone());
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
                            mg.a().postDelayed(new a(this, customDialogData), 2000L);
                        }
                        Intent intent222 = new Intent();
                        Bundle bundle222 = new Bundle();
                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent222.putExtras(bundle222);
                        this.d.setResult(-1, intent222);
                        if (this.a != null && wi8.k().i() != null) {
                            wi8.k().C(this.a.getForumId());
                            wi8.k().D(this.a.getForumName());
                            if (!ki.isEmpty(postWriteCallBackData.getVideoid()) && this.a.getVideoInfo() != null) {
                                postWriteCallBackData.writeDataForVideo = this.a;
                            }
                            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                            customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, wi8.k().i()));
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                        }
                        this.d.finish();
                    } else {
                        if (this.a.isHasImages()) {
                            if (ki.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                this.d.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08d3));
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
                            ww4 ww4Var2 = new ww4();
                            ww4Var2.e(this.c);
                            if (ww4Var2.c() != null && this.d.mModel != null) {
                                this.d.mModel.setVcodeMD5(ww4Var2.b());
                                this.d.mModel.setVcodeUrl(ww4Var2.c());
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
                super.onPostExecute(ww4Var);
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
        this.onBackListener = new b(this);
        this.onPostListener = new c(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09161e);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mInfo = (TextView) findViewById(R.id.obfuscated_res_0x7f090ec2);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f1109), this.onPostListener);
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = li.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.mPost.setLayoutParams(layoutParams);
            this.mEdit = (EditText) findViewById(R.id.obfuscated_res_0x7f090ecb);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922cc);
            this.mImage = imageView;
            imageView.setImageDrawable(null);
            this.mImage.setOnClickListener(new d(this));
            this.mProgressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091927);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            at4 at4Var = new at4(getPageContext());
            this.mWaitingDialog = at4Var;
            at4Var.i(R.string.obfuscated_res_0x7f0f111a);
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
            setContentView(R.layout.obfuscated_res_0x7f0d084d);
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
            ts4.g(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }
}
