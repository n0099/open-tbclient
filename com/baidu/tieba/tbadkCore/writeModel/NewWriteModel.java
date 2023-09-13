package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.R;
import com.baidu.tieba.ae5;
import com.baidu.tieba.aja;
import com.baidu.tieba.bl9;
import com.baidu.tieba.ch9;
import com.baidu.tieba.ei;
import com.baidu.tieba.hc9;
import com.baidu.tieba.iqa;
import com.baidu.tieba.lc9;
import com.baidu.tieba.mg;
import com.baidu.tieba.n05;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.qja;
import com.baidu.tieba.rja;
import com.baidu.tieba.sja;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.wja;
import com.baidu.tieba.x35;
import com.baidu.tieba.xha;
import com.baidu.tieba.xja;
import com.baidu.tieba.y45;
import com.baidu.tieba.yha;
import com.baidu.tieba.yk9;
import com.baidu.tieba.ym5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public WriteData b;
    public d c;
    public boolean d;
    public BdPageContext<?> e;
    public boolean f;
    public boolean g;
    public yha h;
    public aja.c i;

    /* loaded from: classes8.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-484724078, "Lcom/baidu/tieba/tbadkCore/writeModel/NewWriteModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-484724078, "Lcom/baidu/tieba/tbadkCore/writeModel/NewWriteModel;");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class e extends BdAsyncTask<Integer, Integer, xja> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xha a;
        public String b;
        public JSONObject c;
        public boolean d;
        public lc9 e;
        public hc9 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes8.dex */
        public class a implements yha.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0484a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ xja a;
                public final /* synthetic */ a b;

                public RunnableC0484a(a aVar, xja xjaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, xjaVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = xjaVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.yha.e
            public void a(xja xjaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, xjaVar) == null) {
                    mg.g(new RunnableC0484a(this, xjaVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements yha.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ xja a;
                public final /* synthetic */ b b;

                public a(b bVar, xja xjaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, xjaVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = bVar;
                    this.a = xjaVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.yha.e
            public void a(xja xjaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, xjaVar) == null) {
                    mg.g(new a(this, xjaVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ e b;

            public c(e eVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                bl9 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = yk9.a((TbPageContext) this.b.g.e, this.a)) != null) {
                    a.show();
                }
            }
        }

        public e(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = newWriteModel;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lc9.class);
            if (runTask != null) {
                this.e = (lc9) runTask.getData();
            }
            lc9 lc9Var = this.e;
            if (lc9Var != null) {
                this.f = lc9Var.get();
            }
            setPriority(3);
            sja.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public xja doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                n05.b("write", DownloadStatisticConstants.UBC_VALUE_TASK);
                if (this.d) {
                    return null;
                }
                ym5.e(this.g.b.getContent());
                sja.a("doInBackground() start");
                sja.a("发帖：任务后台执行 开始 doInBackground");
                xha xhaVar = new xha();
                this.a = xhaVar;
                xhaVar.l(this.f);
                if (this.a.n(this.g.b)) {
                    this.b = this.a.b(this.g.h, this.g.b, this.g.d, new a(this));
                    return null;
                } else if (this.a.m(this.g.b)) {
                    this.b = this.a.a(this.g.h, this.g.b, this.g.d, new b(this));
                    return null;
                } else {
                    this.b = this.a.j(this.g.b, this.g.d);
                    n05.b("write", "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    xja xjaVar = new xja();
                    if (this.a.i()) {
                        xjaVar.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        xjaVar.f(errorData.getError_code());
                        xjaVar.h(errorData.getError_msg());
                        xjaVar.g(errorData.getError_data());
                    } else {
                        xjaVar.i(true);
                        xjaVar.f(this.a.f());
                        xjaVar.h(this.a.h());
                    }
                    xjaVar.j(this.c);
                    return xjaVar;
                }
            }
            return (xja) invokeL.objValue;
        }

        public final void c(wja wjaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wjaVar) != null) || aja.a(wjaVar.f(), AuthTokenData.parse(this.c), this.g.i)) {
                return;
            }
            if (!wjaVar.y()) {
                if (!wjaVar.B()) {
                    if (!iqa.d(wjaVar.f())) {
                        if (wjaVar.z()) {
                            ae5 ae5Var = new ae5();
                            ae5Var.f(this.c);
                            if (ae5Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(ae5Var.b());
                                this.g.b.setVcodeUrl(ae5Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.g0(wjaVar, null, ae5Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (wjaVar.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.g0(wjaVar, accessState, null, newWriteModel2.b);
                            return;
                        } else if (wjaVar.A()) {
                            this.g.f0(wjaVar);
                            return;
                        } else {
                            this.g.f0(wjaVar);
                            return;
                        }
                    }
                    this.g.d0(wjaVar);
                    this.g.f0(wjaVar);
                    return;
                }
                this.g.e0(wjaVar);
                this.g.f0(wjaVar);
                return;
            }
            this.g.f0(wjaVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                xha xhaVar = this.a;
                if (xhaVar != null) {
                    xhaVar.d();
                }
                if (this.g.c != null) {
                    this.g.c.callback(false, null, null, this.g.b, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:153:0x04fa  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x060d  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(xja xjaVar) {
            int i;
            int i2;
            int i3;
            int i4;
            wja wjaVar;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String i5;
            String h;
            String str;
            String str2;
            PostWriteCallBackData postWriteCallBackData;
            CustomDialogData activityDialog;
            VideoEasterEggData videoEasterEggData;
            String str3;
            String str4;
            int i6;
            String str5;
            String str6;
            String str7;
            String str8;
            CustomDialogData customDialogData;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            AdverSegmentData adverSegmentData;
            IconStampData iconStampData;
            VideoEasterEggData videoEasterEggData2;
            String str14;
            String str15;
            String str16;
            VideoEasterEggData videoEasterEggData3;
            AdverSegmentData adverSegmentData2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, xjaVar) == null) {
                super.onPostExecute(xjaVar);
                if (xjaVar == null) {
                    return;
                }
                this.c = xjaVar.d();
                this.a.k(this.g.b, xjaVar);
                sja.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                qja.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3);
                if (UbsABTestHelper.isNewWrite()) {
                    i = 2;
                } else {
                    i = 1;
                }
                StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_TO, i).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!xjaVar.e() && this.c != null) {
                    i2 = 18;
                } else {
                    i2 = 19;
                }
                StatisticItem param3 = param2.param("obj_locate", i2);
                if (this.g.b != null) {
                    i3 = this.g.b.getType();
                } else {
                    i3 = -1;
                }
                StatisticItem param4 = param3.param("obj_type", i3);
                if (this.g.b != null && this.g.b.isNewWritePage()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                TiebaStatic.log(param4.param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!xjaVar.e() && this.c != null) {
                    sja.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (ei.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    wjaVar = new wja(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !wjaVar.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    sja.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    wjaVar = new wja(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i7 = 0; i7 < length; i7++) {
                                    arrayList.add(jSONArray.optString(i7));
                                }
                                wjaVar.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    sja.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    wjaVar = new wja(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        x35 x35Var = new x35();
                        x35Var.a = optJSONObject.optString("block_content");
                        x35Var.b = optJSONObject.optString("block_cancel");
                        x35Var.c = optJSONObject.optString("block_confirm");
                        wjaVar.Q(x35Var);
                    }
                    sja.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1379);
                        }
                    }
                    wjaVar = new wja(g.getError_code(), error_msg2, this.a.e());
                    sja.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    wjaVar = new wja(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0e40), null);
                    sja.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (wjaVar.w()) {
                    obj = "pid";
                    obj2 = "tid";
                } else {
                    ContriInfo contriInfo = new ContriInfo();
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 == null) {
                        obj = "pid";
                        obj2 = "tid";
                        videoEasterEggData = null;
                        str3 = null;
                        str4 = null;
                        i6 = 0;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        customDialogData = null;
                        str9 = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        adverSegmentData = null;
                        iconStampData = null;
                    } else {
                        str11 = jSONObject3.optString("msg");
                        str13 = jSONObject3.optString("pre_msg");
                        String optString = jSONObject3.optString("color_msg");
                        String optString2 = jSONObject3.optString("tid");
                        String optString3 = jSONObject3.optString("pid");
                        str6 = jSONObject3.optString("video_id");
                        str7 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = ch9.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        if (optJSONObject3 != null) {
                            i6 = optJSONObject3.optInt("is_copytwzhibo", 0);
                        } else {
                            i6 = 0;
                        }
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str12 = optJSONObject4.optString("pre_msg");
                            str15 = optJSONObject4.optString("color_msg");
                            str16 = optJSONObject4.optString("question_msg");
                            str14 = optJSONObject4.optString("question_exp");
                        } else {
                            str14 = null;
                            str15 = null;
                            str16 = null;
                            str12 = null;
                        }
                        contriInfo.parseJson(jSONObject3.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("star_info");
                        String str17 = str14;
                        if (optJSONObject5 != null) {
                            videoEasterEggData3 = new VideoEasterEggData();
                            videoEasterEggData3.parseJson(optJSONObject5);
                        } else {
                            videoEasterEggData3 = null;
                        }
                        JSONObject optJSONObject6 = jSONObject3.optJSONObject("advertisement");
                        VideoEasterEggData videoEasterEggData4 = videoEasterEggData3;
                        if (optJSONObject6 != null) {
                            adverSegmentData2 = new AdverSegmentData();
                            adverSegmentData2.parseJSONObject(optJSONObject6);
                        } else {
                            adverSegmentData2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        AdverSegmentData adverSegmentData3 = adverSegmentData2;
                        if (optJSONObject7 != null) {
                            iconStampData2 = new IconStampData();
                            iconStampData2.parseJson(optJSONObject7);
                        } else {
                            iconStampData2 = null;
                        }
                        if (jSONObject3.has("toast")) {
                            iconStampData3 = iconStampData2;
                            BdToastData bdToastData = new BdToastData();
                            bdToastData.parserJson(jSONObject3.optJSONObject("toast"));
                            wjaVar.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str10 = str15;
                        str3 = optString;
                        str5 = optString2;
                        customDialogData = a2;
                        videoEasterEggData = videoEasterEggData4;
                        adverSegmentData = adverSegmentData3;
                        iconStampData = iconStampData3;
                        obj = "pid";
                        str4 = str16;
                        obj2 = "tid";
                        str8 = optString3;
                        str9 = str17;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    wjaVar.G(str11);
                    wjaVar.N(str13);
                    wjaVar.E(str3);
                    wjaVar.P(str4);
                    wjaVar.O(str9);
                    wjaVar.S(str5);
                    wjaVar.M(str8);
                    wjaVar.L(i6);
                    wjaVar.I(str12);
                    wjaVar.H(str10);
                    wjaVar.C(customDialogData);
                    wjaVar.V(str6);
                    wjaVar.K(str7);
                    wjaVar.F(contriInfo);
                    wjaVar.U(videoEasterEggData2);
                    wjaVar.D(adverSegmentData);
                    wjaVar.J(iconStampData);
                }
                n05.b("write", "result*" + xjaVar.e());
                n05.b("write", "code*" + wjaVar.f() + " " + wjaVar.g());
                n05.e("write");
                sja.a("doInBackground end");
                sja.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                sja.a("onPostExecute start");
                sja.a("发帖： onPostExecute");
                this.g.a = null;
                if (wjaVar.f() != 0) {
                    Logger.addLog("write", 0L, 0, "write_result", wjaVar.f(), wjaVar.g(), obj2, wjaVar.s(), obj, wjaVar.m());
                }
                if (!this.d) {
                    if (this.g.b != null) {
                        z = this.g.b.isReplyResultNotificationH5;
                    } else {
                        z = false;
                    }
                    if (wjaVar.w()) {
                        sja.a("onPostExecute error");
                        c(wjaVar);
                        hc9 hc9Var = this.f;
                        if (hc9Var != null) {
                            hc9Var.h(wjaVar.a, wjaVar.g());
                        }
                    } else {
                        if (this.g.b != null) {
                            this.g.b.getType();
                            z2 = this.g.b.isNotificationH5();
                            z3 = this.g.b.isNotFakePost();
                        } else {
                            z2 = false;
                            z3 = false;
                        }
                        sja.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(wjaVar.n()) && !StringUtils.isNull(wjaVar.d())) {
                                i5 = wjaVar.n();
                                h = wjaVar.d();
                            } else if (StringUtils.isNull(wjaVar.h()) && StringUtils.isNull(wjaVar.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(wjaVar.f(), wjaVar.g(), str, str2, wjaVar.p(), wjaVar.o());
                                postWriteCallBackData.setThreadId(wjaVar.s());
                                postWriteCallBackData.setPostId(wjaVar.m());
                                postWriteCallBackData.setIsCopyTWZhibo(wjaVar.l());
                                postWriteCallBackData.setErrorString(wjaVar.g());
                                postWriteCallBackData.setActivityDialog(wjaVar.a());
                                postWriteCallBackData.setVideoid(wjaVar.v());
                                postWriteCallBackData.setInviteesNumber(wjaVar.k());
                                postWriteCallBackData.setContriInfo(wjaVar.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(wjaVar.u());
                                postWriteCallBackData.setmAdverSegmentData(wjaVar.b());
                                postWriteCallBackData.setIconStampData(wjaVar.j());
                                postWriteCallBackData.setToast(wjaVar.t());
                                ae5 ae5Var = new ae5();
                                ae5Var.f(this.c);
                                if (this.g.b == null && WriteMsgHolder.getCurrentWriteActivityFromTag() != null && !z3) {
                                    WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                    WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    WriteMsgHolder.setFromPersonCenter(false);
                                } else if (this.g.b == null && this.g.f) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.g) {
                                    WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                    WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && wjaVar.j() == null) {
                                    if (this.g.b != null) {
                                        int type = this.g.b.getType();
                                        if (type != 1 && type != 2) {
                                            if (type != 9) {
                                                switch (type) {
                                                }
                                            }
                                            activityDialog.type = 2;
                                        } else {
                                            activityDialog.type = 1;
                                        }
                                    }
                                    SafeHandler.getInst().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, ae5Var, this.g.b, wjaVar.c());
                            } else {
                                i5 = wjaVar.i();
                                h = wjaVar.h();
                            }
                            str = i5;
                            str2 = h;
                            postWriteCallBackData = new PostWriteCallBackData(wjaVar.f(), wjaVar.g(), str, str2, wjaVar.p(), wjaVar.o());
                            postWriteCallBackData.setThreadId(wjaVar.s());
                            postWriteCallBackData.setPostId(wjaVar.m());
                            postWriteCallBackData.setIsCopyTWZhibo(wjaVar.l());
                            postWriteCallBackData.setErrorString(wjaVar.g());
                            postWriteCallBackData.setActivityDialog(wjaVar.a());
                            postWriteCallBackData.setVideoid(wjaVar.v());
                            postWriteCallBackData.setInviteesNumber(wjaVar.k());
                            postWriteCallBackData.setContriInfo(wjaVar.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(wjaVar.u());
                            postWriteCallBackData.setmAdverSegmentData(wjaVar.b());
                            postWriteCallBackData.setIconStampData(wjaVar.j());
                            postWriteCallBackData.setToast(wjaVar.t());
                            ae5 ae5Var2 = new ae5();
                            ae5Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                SafeHandler.getInst().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.c.callback(true, postWriteCallBackData, ae5Var2, this.g.b, wjaVar.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (wjaVar.j() == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z4)));
                        }
                        hc9 hc9Var2 = this.f;
                        if (hc9Var2 != null) {
                            hc9Var2.c();
                        }
                        if (z2) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921786, null));
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921805, 1));
                        }
                    }
                    sja.a("发帖： onPostExecute 完全结束");
                    return;
                }
                sja.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, y45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newWriteModel;
            this.a = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.dismiss();
                this.b.b0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, y45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newWriteModel;
            this.a = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.dismiss();
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16);
                if (this.b.b != null) {
                    i = this.b.b.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends aja.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteModel a;

        public c(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteModel;
        }

        @Override // com.baidu.tieba.aja.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.n0();
            }
        }

        @Override // com.baidu.tieba.aja.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.n0();
            }
        }

        @Override // com.baidu.tieba.aja.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.b != null) {
                    this.a.b.setAuthSid(null);
                }
                if (this.a.c != null) {
                    this.a.c.callback(false, null, null, this.a.b, null);
                }
            }
        }

        @Override // com.baidu.tieba.aja.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b == null) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(null);
                this.a.n0();
            }
        }
    }

    public NewWriteModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = baseActivity.getPageContext();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = tbPageContext;
    }

    public final void d0(wja wjaVar) {
        BdPageContext<?> bdPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, wjaVar) == null) && (bdPageContext = this.e) != null && wjaVar != null && !(this.c instanceof rja)) {
            iqa.e(bdPageContext.getPageActivity(), wjaVar.g());
            wjaVar.G(null);
        }
    }

    public final void f0(wja wjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wjaVar) == null) {
            g0(wjaVar, null, null, this.b);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
        }
    }

    public void k0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void l0(@Nullable BdPageContext<?> bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdPageContext) == null) {
            if (bdPageContext != null) {
                this.e = bdPageContext;
                this.unique_id = bdPageContext.getUniqueId();
                return;
            }
            this.e = null;
            this.unique_id = null;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, writeData) == null) {
            this.b = writeData;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.b;
            if (writeData == null) {
                return true;
            }
            if (writeData.getWriteImagesInfo() != null) {
                i = this.b.getWriteImagesInfo().size() + 0;
            } else {
                i = 0;
            }
            if (i <= MAX_IMG_NUM) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public WriteData c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (WriteData) invokeV.objValue;
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e eVar = this.a;
            if (eVar != null && !eVar.isCancelled()) {
                this.a.cancel();
                return;
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.callback(false, null, null, this.b, null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.a;
            if (eVar != null && !eVar.isCancelled()) {
                this.a.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            sja.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            b0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b0() {
        int i;
        int i2;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData2 = this.b;
            if (writeData2 != null) {
                i = writeData2.getType();
            } else {
                i = -1;
            }
            StatisticItem param2 = param.param("obj_type", i);
            WriteData writeData3 = this.b;
            int i3 = 1;
            if (writeData3 != null && writeData3.isNewWritePage()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            StatisticItem param3 = param2.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            if (UbsABTestHelper.isNewWrite()) {
                i3 = 2;
            }
            TiebaStatic.log(param3.param(TiebaStatic.Params.OBJ_TO, i3).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            n05.d("write");
            n05.b("write", "start");
            if (this.a == null) {
                if (WriteMsgHolder.getCurrentWriteActivityFromTag() != null && (writeData = this.b) != null && !writeData.isNotFakePost()) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, c0());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.h == null) {
                    this.h = new yha(this.e);
                }
                this.a = new e(this);
                sja.a("dealPost()");
                qja.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !SharedPrefHelper.getInstance().getBoolean("original_img_up_tip", false)) {
                SharedPrefHelper.getInstance().putBoolean("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                BdPageContext<?> bdPageContext = this.e;
                if (bdPageContext == null) {
                    b0();
                    return true;
                }
                y45 y45Var = new y45(bdPageContext.getPageActivity());
                y45Var.setMessageId(R.string.original_img_up_no_wifi_tip);
                y45Var.setPositiveButton(R.string.alert_yes_button, new a(this, y45Var));
                y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this, y45Var));
                y45Var.create(this.e);
                y45Var.show();
            } else {
                b0();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e0(wja wjaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, wjaVar) == null) && this.e != null && wjaVar != null && wjaVar.c() != null && wjaVar.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), wjaVar.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void g0(wja wjaVar, AccessState accessState, ae5 ae5Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wjaVar, accessState, ae5Var, writeData) == null) && wjaVar != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(wjaVar.f(), wjaVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(wjaVar.r());
            postWriteCallBackData.setReplyPrivacyTip(wjaVar.q());
            this.c.callback(false, postWriteCallBackData, ae5Var, writeData, wjaVar.c());
        }
    }
}
