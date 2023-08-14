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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.c05;
import com.baidu.tieba.df9;
import com.baidu.tieba.jd5;
import com.baidu.tieba.lj5;
import com.baidu.tieba.m17;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.vb9;
import com.baidu.tieba.vda;
import com.baidu.tieba.wba;
import com.baidu.tieba.wda;
import com.baidu.tieba.xda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WriteData a;
    public TextView b;
    public ImageView c;
    public EditText d;
    public ProgressBar e;
    public f f;
    public e g;
    public InputMethodManager h;
    public DialogInterface.OnCancelListener i;
    public RelativeLayout j;
    public TextView k;
    public NavigationBar l;
    public wba m;
    public final View.OnClickListener n;
    public final View.OnClickListener o;

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<Integer, Integer, vda> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WriteData a;
        public NetWork b;
        public String c;
        public JSONObject d;
        public final /* synthetic */ VcodeActivity e;

        /* loaded from: classes8.dex */
        public class a implements wba.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.wba.e
            public void a(vda vdaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vdaVar) == null) {
                    this.a.onPostExecute(vdaVar);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements wba.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.wba.e
            public void a(vda vdaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vdaVar) == null) {
                    this.a.onPostExecute(vdaVar);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ f b;

            public c(f fVar, CustomDialogData customDialogData) {
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
                    df9.a(this.b.e.getPageContext(), this.a).show();
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
            this.e = vcodeActivity;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = writeData;
        }

        public final void b(wba.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                c05.b("write", "postP");
                if (this.e.m != null && this.b != null) {
                    c05.b("write", "postR");
                    wba wbaVar = this.e.m;
                    wbaVar.e(eVar);
                    wbaVar.b(this.b);
                }
            }
        }

        public final void c(wba.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                c05.b("write", "threadP");
                if (this.e.m != null && this.b != null) {
                    c05.b("write", "threadR");
                    wba wbaVar = this.e.m;
                    wbaVar.e(eVar);
                    wbaVar.c(this.b);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.f = null;
                this.e.closeLoadingDialog();
                NetWork netWork = this.b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public vda doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            String toServerContent;
            String str2;
            String str3;
            String str4;
            Address address;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, numArr)) == null) {
                c05.b("write", DownloadStatisticConstants.UBC_VALUE_TASK);
                if (this.a == null) {
                    return null;
                }
                this.b = new NetWork();
                String obj = this.e.d.getText().toString();
                String imagesCodeForPost = this.a.getImagesCodeForPost();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    this.b.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                String str5 = "0";
                this.b.addPostData("anonymous", "0");
                this.b.addPostData("fid", this.a.getForumId());
                this.b.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a.getForumName());
                this.b.addPostData("pro_zone", "0");
                NetWork netWork = this.b;
                if (!this.a.isCanNoForum()) {
                    str = "0";
                } else {
                    str = "1";
                }
                netWork.addPostData("can_no_forum", str);
                this.b.addPostData("is_feedback", "0");
                this.b.addPostData("new_vcode", "1");
                if (TextUtils.isEmpty(this.a.getToServerContent())) {
                    toServerContent = this.a.getContent();
                } else {
                    toServerContent = this.a.getToServerContent();
                }
                VideoInfo videoInfo = this.a.getVideoInfo();
                if (videoInfo != null && videoInfo.hasUpload()) {
                    str2 = toServerContent + videoInfo.buildContent() + imagesCodeForPost;
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
                    str2 = sb.toString();
                } else {
                    str2 = toServerContent + imagesCodeForPost;
                }
                this.b.addPostData("content", m17.c(str2));
                wda.a(this.b, this.a);
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
                NetWork netWork2 = this.b;
                if (!this.a.isRichTextEditorMode()) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                netWork2.addPostData("is_pictxt", str3);
                if (this.a.isAddThread()) {
                    this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                    this.b.addPostData("transform_forums", this.a.getTransmitForumData());
                    this.b.addPostData(IntentConfig.CALL_FROM, this.a.getStatisticFrom() + "");
                    this.b.addPostData("title", this.a.getTitle());
                    NetWork netWork3 = this.b;
                    if (this.a.isNoTitle()) {
                        str5 = "1";
                    }
                    netWork3.addPostData("is_ntitle", str5);
                    if (TbadkCoreApplication.getInst().getIsLocationOn() && (address = BdLocationMananger.getInstance().getAddress(false)) != null) {
                        this.b.addPostData("lbs", address.getLatitude() + "," + address.getLongitude());
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
                } else {
                    this.b.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS);
                    this.b.addPostData("tid", this.a.getThreadId());
                    NetWork netWork4 = this.b;
                    if (!this.e.getIntent().getBooleanExtra("is_ad", false)) {
                        str4 = "0";
                    } else {
                        str4 = "1";
                    }
                    netWork4.addPostData("is_ad", str4);
                    if (this.a.getBaijiahaoData() != null) {
                        this.b.addPostData("ori_ugc_nid", this.a.getBaijiahaoData().oriUgcNid);
                        this.b.addPostData("ori_ugc_tid", this.a.getBaijiahaoData().oriUgcTid);
                        this.b.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.a.getBaijiahaoData().oriUgcType));
                        this.b.addPostData("ori_ugc_vid", this.a.getBaijiahaoData().oriUgcVid);
                    }
                    if (this.a.getType() == 2) {
                        this.b.addPostData("quote_id", String.valueOf(this.a.getFloor()));
                        this.b.addPostData("floor_num", String.valueOf(this.a.getFloorNum()));
                        NetWork netWork5 = this.b;
                        if (this.a.isAddition()) {
                            str5 = "1";
                        }
                        netWork5.addPostData("is_addition", str5);
                        if (this.a.getRepostId() != null) {
                            this.b.addPostData("repostid", this.a.getRepostId());
                        }
                        if (this.a.getReSubPostId() != null) {
                            this.b.addPostData("sub_post_id", this.a.getReSubPostId());
                        }
                        this.b.addPostData("v_fid", this.a.getVForumId());
                        this.b.addPostData("v_fname", this.a.getVForumName());
                    } else if (this.a.getType() == 1) {
                        this.b.addPostData("is_barrage", "0");
                        this.b.addPostData("barrage_time", "0");
                        if (lj5.a().b() == 1) {
                            this.b.addPostData("ptype", "4");
                        }
                        this.b.addPostData("v_fid", this.a.getVForumId());
                        this.b.addPostData("v_fname", this.a.getVForumName());
                    }
                }
                if (this.b.getNetContext() != null && this.b.getNetContext().getRequest() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.b.getNetContext().getRequest()));
                }
                if (g(this.a)) {
                    c(new a(this));
                    return null;
                } else if (f(this.a)) {
                    b(new b(this));
                    return null;
                } else {
                    c05.b("write", "json");
                    this.c = this.b.postNetData();
                    c05.b("write", "jsonRES");
                    try {
                        if (this.c != null) {
                            this.d = new JSONObject(this.c);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    vda vdaVar = new vda();
                    NetWork netWork6 = this.b;
                    if (netWork6 != null) {
                        if (netWork6.getNetContext().getResponse().isRequestSuccess()) {
                            vdaVar.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.d);
                            vdaVar.f(errorData.getError_code());
                            vdaVar.h(errorData.getError_msg());
                            vdaVar.g(errorData.getError_data());
                        } else {
                            vdaVar.i(true);
                            vdaVar.f(this.b.getServerErrorCode());
                            vdaVar.h(this.b.getErrorString());
                        }
                    }
                    vdaVar.j(this.d);
                    return vdaVar;
                }
            }
            return (vda) invokeL.objValue;
        }

        public final boolean f(WriteData writeData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, writeData)) == null) {
                if (writeData == null) {
                    return false;
                }
                int type = writeData.getType();
                if (type != 1 && type != 2) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean g(WriteData writeData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, writeData)) == null) {
                if (writeData == null) {
                    return false;
                }
                return writeData.isAddThread();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
            if (com.baidu.adp.lib.util.StringUtils.isNull(r1) == false) goto L85;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x012e A[Catch: Exception -> 0x0136, TRY_LEAVE, TryCatch #5 {Exception -> 0x0136, blocks: (B:48:0x011c, B:50:0x012e), top: B:148:0x011c }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01a5  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(vda vdaVar) {
            JSONArray jSONArray;
            String str;
            String str2;
            String str3;
            PostWriteCallBackData postWriteCallBackData;
            String str4;
            String str5;
            String str6;
            CustomDialogData customDialogData;
            String str7;
            JSONObject jSONObject;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, vdaVar) == null) {
                String str8 = "";
                if (vdaVar == null) {
                    return;
                }
                c05.b("write", "result*" + vdaVar.e());
                this.e.closeLoadingDialog();
                CustomDialogData customDialogData2 = null;
                this.e.f = null;
                this.d = vdaVar.d();
                int i = 0;
                if (!vdaVar.e()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.d);
                    if (errorData.error_code == 0) {
                        try {
                            JSONObject jSONObject2 = this.d;
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
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        str3 = null;
                                        if (StringUtils.isNull(str)) {
                                        }
                                        if (this.a.isAddThread()) {
                                        }
                                        this.a.deleteUploadedTempImages();
                                        postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        jSONObject = this.d;
                                        String str9 = jSONObject.optString("tid");
                                        str4 = jSONObject.optString("pid");
                                        try {
                                            str5 = jSONObject.optString("msg");
                                        } catch (Exception e2) {
                                            e = e2;
                                            str5 = "";
                                            str6 = str5;
                                            str8 = str9;
                                            customDialogData = null;
                                            str7 = str6;
                                            e.printStackTrace();
                                            CustomDialogData customDialogData3 = customDialogData;
                                            str9 = str8;
                                            str8 = str7;
                                            customDialogData2 = customDialogData3;
                                            postWriteCallBackData.setThreadId(str9);
                                            postWriteCallBackData.setPostId(str4);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str5);
                                            postWriteCallBackData.setVideoid(str6);
                                            postWriteCallBackData.setInviteesNumber(str8);
                                            postWriteCallBackData.setActivityDialog(customDialogData2);
                                            if (customDialogData2 != null) {
                                            }
                                            Intent intent = new Intent();
                                            Bundle bundle = new Bundle();
                                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent.putExtras(bundle);
                                            this.e.setResult(-1, intent);
                                            if (this.a != null) {
                                                WriteMsgHolder.setLastForumId(this.a.getForumId());
                                                WriteMsgHolder.setLastForumName(this.a.getForumName());
                                                if (!bi.isEmpty(postWriteCallBackData.getVideoid())) {
                                                    postWriteCallBackData.writeDataForVideo = this.a;
                                                }
                                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                            }
                                            this.e.finish();
                                            c05.b("write", "code*" + vdaVar.a() + " " + vdaVar.c());
                                            c05.e("write");
                                            super.onPostExecute(vdaVar);
                                        }
                                        try {
                                            str6 = jSONObject.optString("video_id");
                                        } catch (Exception e3) {
                                            e = e3;
                                            str6 = "";
                                            str8 = str9;
                                            customDialogData = null;
                                            str7 = str6;
                                            e.printStackTrace();
                                            CustomDialogData customDialogData32 = customDialogData;
                                            str9 = str8;
                                            str8 = str7;
                                            customDialogData2 = customDialogData32;
                                            postWriteCallBackData.setThreadId(str9);
                                            postWriteCallBackData.setPostId(str4);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str5);
                                            postWriteCallBackData.setVideoid(str6);
                                            postWriteCallBackData.setInviteesNumber(str8);
                                            postWriteCallBackData.setActivityDialog(customDialogData2);
                                            if (customDialogData2 != null) {
                                            }
                                            Intent intent2 = new Intent();
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent2.putExtras(bundle2);
                                            this.e.setResult(-1, intent2);
                                            if (this.a != null) {
                                            }
                                            this.e.finish();
                                            c05.b("write", "code*" + vdaVar.a() + " " + vdaVar.c());
                                            c05.e("write");
                                            super.onPostExecute(vdaVar);
                                        }
                                        try {
                                            str8 = jSONObject.optString("invitees_number");
                                            customDialogData2 = vb9.a(jSONObject);
                                            optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                            if (optJSONObject != null) {
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            CustomDialogData customDialogData4 = customDialogData2;
                                            str7 = str8;
                                            str8 = str9;
                                            customDialogData = customDialogData4;
                                            e.printStackTrace();
                                            CustomDialogData customDialogData322 = customDialogData;
                                            str9 = str8;
                                            str8 = str7;
                                            customDialogData2 = customDialogData322;
                                            postWriteCallBackData.setThreadId(str9);
                                            postWriteCallBackData.setPostId(str4);
                                            postWriteCallBackData.setIsCopyTWZhibo(i);
                                            postWriteCallBackData.setErrorString(str5);
                                            postWriteCallBackData.setVideoid(str6);
                                            postWriteCallBackData.setInviteesNumber(str8);
                                            postWriteCallBackData.setActivityDialog(customDialogData2);
                                            if (customDialogData2 != null) {
                                            }
                                            Intent intent22 = new Intent();
                                            Bundle bundle22 = new Bundle();
                                            bundle22.putSerializable("post_write_callback_data", postWriteCallBackData);
                                            intent22.putExtras(bundle22);
                                            this.e.setResult(-1, intent22);
                                            if (this.a != null) {
                                            }
                                            this.e.finish();
                                            c05.b("write", "code*" + vdaVar.a() + " " + vdaVar.c());
                                            c05.e("write");
                                            super.onPostExecute(vdaVar);
                                        }
                                        postWriteCallBackData.setThreadId(str9);
                                        postWriteCallBackData.setPostId(str4);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        postWriteCallBackData.setErrorString(str5);
                                        postWriteCallBackData.setVideoid(str6);
                                        postWriteCallBackData.setInviteesNumber(str8);
                                        postWriteCallBackData.setActivityDialog(customDialogData2);
                                        if (customDialogData2 != null) {
                                        }
                                        Intent intent222 = new Intent();
                                        Bundle bundle222 = new Bundle();
                                        bundle222.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent222.putExtras(bundle222);
                                        this.e.setResult(-1, intent222);
                                        if (this.a != null) {
                                        }
                                        this.e.finish();
                                        c05.b("write", "code*" + vdaVar.a() + " " + vdaVar.c());
                                        c05.e("write");
                                        super.onPostExecute(vdaVar);
                                    }
                                } else {
                                    str3 = null;
                                    str2 = null;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str2 = null;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = null;
                            str2 = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.send_success);
                            xda.a(this.e.a, this.a.getThreadId());
                        }
                        if (this.a.isAddThread()) {
                            wda.b(this.e.getActivity(), str, str2, str3);
                        }
                        this.a.deleteUploadedTempImages();
                    } else {
                        if (this.a.isHasImages()) {
                            if (bi.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                                this.e.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                            }
                        }
                        this.e.showToast(errorData.getError_msg());
                    }
                    postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    try {
                        jSONObject = this.d;
                        String str92 = jSONObject.optString("tid");
                        try {
                            str4 = jSONObject.optString("pid");
                            str5 = jSONObject.optString("msg");
                            str6 = jSONObject.optString("video_id");
                            str8 = jSONObject.optString("invitees_number");
                            customDialogData2 = vb9.a(jSONObject);
                            optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("is_copytwzhibo", 0);
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str4 = "";
                            str5 = str4;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        str4 = "";
                        str5 = str4;
                        str6 = str5;
                    }
                    postWriteCallBackData.setThreadId(str92);
                    postWriteCallBackData.setPostId(str4);
                    postWriteCallBackData.setIsCopyTWZhibo(i);
                    postWriteCallBackData.setErrorString(str5);
                    postWriteCallBackData.setVideoid(str6);
                    postWriteCallBackData.setInviteesNumber(str8);
                    postWriteCallBackData.setActivityDialog(customDialogData2);
                    if (customDialogData2 != null) {
                        WriteData writeData = this.a;
                        if (writeData != null) {
                            if (writeData.isAddThread()) {
                                customDialogData2.type = 2;
                            } else {
                                customDialogData2.type = 1;
                            }
                        }
                        SafeHandler.getInst().postDelayed(new c(this, customDialogData2), 2000L);
                    }
                    Intent intent2222 = new Intent();
                    Bundle bundle2222 = new Bundle();
                    bundle2222.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2222.putExtras(bundle2222);
                    this.e.setResult(-1, intent2222);
                    if (this.a != null && WriteMsgHolder.getCurrentWriteActivityFromTag() != null) {
                        WriteMsgHolder.setLastForumId(this.a.getForumId());
                        WriteMsgHolder.setLastForumName(this.a.getForumName());
                        if (!bi.isEmpty(postWriteCallBackData.getVideoid()) && this.a.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = this.a;
                        }
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage2.setOrginalMessage(new CustomMessage(2001383, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                    this.e.finish();
                } else {
                    if (this.a.isHasImages()) {
                        if (bi.isEmpty(this.a.getContent() + this.a.getImagesCodeForPost())) {
                            this.e.showToast(TbadkCoreApplication.getInst().getString(R.string.img_upload_error));
                        }
                    }
                    if (vdaVar.a() != 5 && vdaVar.a() != 6) {
                        if (this.a != null && vdaVar.a() == 227001) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.d);
                            PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(vdaVar.a(), vdaVar.c(), null, null);
                            postWriteCallBackData2.setAccessState(accessState);
                            this.e.getActivity().setVisible(false);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.e.getActivity(), 12006, this.a, postWriteCallBackData2.getAccessState())));
                        } else if (vdaVar.a() == 220009) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016554, vdaVar.c()));
                            this.e.finish();
                        } else if (vdaVar.a() == 220015) {
                            PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(NetWorkErr.ERROR_CONTENT_WITH_SENSITIVE_WORD, null, null, null);
                            JSONObject jSONObject3 = this.d;
                            if (jSONObject3 != null) {
                                try {
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
                                } catch (JSONException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            Intent intent3 = new Intent();
                            Bundle bundle3 = new Bundle();
                            bundle3.putSerializable("post_write_callback_data", postWriteCallBackData3);
                            intent3.putExtras(bundle3);
                            this.e.setResult(0, intent3);
                            this.e.finish();
                        }
                    } else {
                        jd5 jd5Var = new jd5();
                        jd5Var.f(this.d);
                        if (jd5Var.c() != null && this.e.a != null) {
                            this.e.a.setVcodeMD5(jd5Var.b());
                            this.e.a.setVcodeUrl(jd5Var.c());
                            VcodeActivity vcodeActivity = this.e;
                            vcodeActivity.K1(vcodeActivity.a.getVcodeUrl());
                        }
                        this.e.d.setText((CharSequence) null);
                    }
                    if (vdaVar.a() != 227001 && vdaVar.a() == 220015) {
                        this.e.showToast(vdaVar.c());
                    }
                }
                c05.b("write", "code*" + vdaVar.a() + " " + vdaVar.c());
                c05.e("write");
                super.onPostExecute(vdaVar);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                if (this.a.f != null) {
                    this.a.f.cancel();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                vcodeActivity.HidenSoftKeyPad(vcodeActivity.h, this.a.d);
                this.a.L1();
                if (this.a.f != null) {
                    this.a.f.cancel();
                }
                if (this.a.m == null) {
                    this.a.m = new wba(this.a.getPageContext());
                }
                VcodeActivity vcodeActivity2 = this.a;
                VcodeActivity vcodeActivity3 = this.a;
                vcodeActivity2.f = new f(vcodeActivity3, vcodeActivity3.a);
                this.a.f.setPriority(3);
                this.a.f.execute(0);
                c05.d("write");
                c05.b("write", "startvcode");
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.K1(null);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public jd5 b;
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

        public /* synthetic */ e(VcodeActivity vcodeActivity, a aVar) {
            this(vcodeActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.d.a == null) {
                    return null;
                }
                String str = strArr[0];
                if (str == null || str.length() <= 0) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.a.addPostData("fid", this.d.a.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.d.a.getForumName());
                    this.a.addPostData("new_vcode", "1");
                    this.a.addPostData("title", this.d.a.getTitle());
                    this.a.addPostData("content", this.d.a.getContent());
                    this.a.addPostData("pub_type", "2");
                    this.a.addPostData("tid", this.d.a.getThreadId());
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                        return null;
                    }
                    jd5 jd5Var = new jd5();
                    this.b = jd5Var;
                    jd5Var.e(postNetData);
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
                this.d.g = null;
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.c = true;
                this.d.e.setVisibility(8);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.d.g = null;
                if (bitmap != null) {
                    this.d.c.setImageBitmap(bitmap);
                }
                this.d.e.setVisibility(8);
                if (this.b != null && this.d.a != null) {
                    this.d.a.setVcodeMD5(this.b.b());
                    this.d.a.setVcodeUrl(this.b.c());
                }
                super.onPostExecute((e) bitmap);
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = new b(this);
        this.o = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d09c8);
            J1();
            I1(bundle);
            WriteData writeData = this.a;
            if (writeData != null) {
                K1(writeData.getVcodeUrl());
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            bundle.putSerializable("model", OrmObject.jsonStrWithObject(this.a));
            super.onSaveInstanceState(bundle);
        }
    }

    public final void I1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.i = new a(this);
            if (bundle != null) {
                String string = bundle.getString("model");
                if (!StringUtils.isNull(string)) {
                    this.a = (WriteData) OrmObject.objectWithJsonStr(string, WriteData.class);
                }
            } else {
                this.a = (WriteData) getIntent().getSerializableExtra("model");
            }
            this.h = (InputMethodManager) getSystemService("input_method");
        }
    }

    public final void K1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e eVar = this.g;
            if (eVar != null) {
                eVar.cancel();
            }
            this.e.setVisibility(0);
            this.c.setImageDrawable(null);
            e eVar2 = new e(this, null);
            this.g = eVar2;
            eVar2.setPriority(3);
            this.g.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBgColor(this.j, i);
            this.l.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0111);
            if (i == 4) {
                i2 = SkinManager.getCommentTextColor(i);
            } else {
                i2 = -12895429;
            }
            this.k.setTextColor(i2);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a32);
            this.l = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09111f);
            this.l.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.n);
            TextView addTextButton = this.l.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f1350), this.o);
            this.b = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.b.setLayoutParams(layoutParams);
            this.d = (EditText) findViewById(R.id.obfuscated_res_0x7f091128);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092878);
            this.c = imageView;
            imageView.setImageDrawable(null);
            this.c.setOnClickListener(new d(this));
            this.e = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091d64);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(getPageContext());
            this.mWaitingDialog = blueCircleProgressDialog;
            blueCircleProgressDialog.setTipString(R.string.obfuscated_res_0x7f0f1363);
            this.mWaitingDialog.setCancelListener(this.i);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            f fVar = this.f;
            if (fVar != null) {
                fVar.cancel();
            }
            e eVar = this.g;
            if (eVar != null) {
                eVar.cancel();
            }
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
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
}
