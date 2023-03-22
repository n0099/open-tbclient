package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.b35;
import com.baidu.tieba.ca5;
import com.baidu.tieba.cz4;
import com.baidu.tieba.de9;
import com.baidu.tieba.ee9;
import com.baidu.tieba.fc9;
import com.baidu.tieba.fe9;
import com.baidu.tieba.gc9;
import com.baidu.tieba.gd9;
import com.baidu.tieba.gi;
import com.baidu.tieba.jg;
import com.baidu.tieba.jh8;
import com.baidu.tieba.m35;
import com.baidu.tieba.ne5;
import com.baidu.tieba.ng;
import com.baidu.tieba.nj9;
import com.baidu.tieba.oc8;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pj8;
import com.baidu.tieba.qv4;
import com.baidu.tieba.sc8;
import com.baidu.tieba.sj8;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.wd9;
import com.baidu.tieba.x75;
import com.baidu.tieba.xd9;
import com.baidu.tieba.yd9;
import com.baidu.tieba.zz4;
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
/* loaded from: classes6.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public WriteData b;
    public d c;
    public boolean d;
    public a9<?> e;
    public boolean f;
    public boolean g;
    public gc9 h;
    public gd9.c i;

    /* loaded from: classes6.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e extends BdAsyncTask<Integer, Integer, fe9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fc9 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public sc8 e;
        public oc8 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes6.dex */
        public class a implements gc9.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0432a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ fe9 a;
                public final /* synthetic */ a b;

                public RunnableC0432a(a aVar, fe9 fe9Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, fe9Var};
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
                    this.a = fe9Var;
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

            @Override // com.baidu.tieba.gc9.e
            public void a(fe9 fe9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fe9Var) == null) {
                    ng.e(new RunnableC0432a(this, fe9Var));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements gc9.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes6.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ fe9 a;
                public final /* synthetic */ b b;

                public a(b bVar, fe9 fe9Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, fe9Var};
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
                    this.a = fe9Var;
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

            @Override // com.baidu.tieba.gc9.e
            public void a(fe9 fe9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fe9Var) == null) {
                    ng.e(new a(this, fe9Var));
                }
            }
        }

        /* loaded from: classes6.dex */
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
                sj8 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = pj8.a((TbPageContext) this.b.g.e, this.a)) != null) {
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, sc8.class);
            if (runTask != null) {
                this.e = (sc8) runTask.getData();
            }
            sc8 sc8Var = this.e;
            if (sc8Var != null) {
                this.f = sc8Var.get();
            }
            setPriority(3);
            yd9.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public fe9 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                qv4.b("write", "task");
                if (this.d) {
                    return null;
                }
                ne5.e(this.g.b.getContent());
                yd9.a("doInBackground() start");
                yd9.a("发帖：任务后台执行 开始 doInBackground");
                fc9 fc9Var = new fc9();
                this.a = fc9Var;
                fc9Var.l(this.f);
                if (this.a.n(this.g.b)) {
                    this.b = this.a.b(this.g.h, this.g.b, this.g.d, new a(this));
                    return null;
                } else if (this.a.m(this.g.b)) {
                    this.b = this.a.a(this.g.h, this.g.b, this.g.d, new b(this));
                    return null;
                } else {
                    this.b = this.a.j(this.g.b, this.g.d);
                    qv4.b("write", "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    fe9 fe9Var = new fe9();
                    if (this.a.i()) {
                        fe9Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        fe9Var.f(errorData.getError_code());
                        fe9Var.h(errorData.getError_msg());
                        fe9Var.g(errorData.getError_data());
                    } else {
                        fe9Var.i(true);
                        fe9Var.f(this.a.f());
                        fe9Var.h(this.a.h());
                    }
                    fe9Var.j(this.c);
                    return fe9Var;
                }
            }
            return (fe9) invokeL.objValue;
        }

        public final void c(de9 de9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, de9Var) != null) || gd9.a(de9Var.f(), AuthTokenData.parse(this.c), this.g.i)) {
                return;
            }
            if (!de9Var.y()) {
                if (!de9Var.B()) {
                    if (!nj9.d(de9Var.f())) {
                        if (de9Var.z()) {
                            x75 x75Var = new x75();
                            x75Var.f(this.c);
                            if (x75Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(x75Var.b());
                                this.g.b.setVcodeUrl(x75Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.l0(de9Var, null, x75Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (de9Var.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.l0(de9Var, accessState, null, newWriteModel2.b);
                            return;
                        } else if (de9Var.A()) {
                            this.g.k0(de9Var);
                            return;
                        } else {
                            this.g.k0(de9Var);
                            return;
                        }
                    }
                    this.g.i0(de9Var);
                    this.g.k0(de9Var);
                    return;
                }
                this.g.j0(de9Var);
                this.g.k0(de9Var);
                return;
            }
            this.g.k0(de9Var);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                fc9 fc9Var = this.a;
                if (fc9Var != null) {
                    fc9Var.d();
                }
                if (this.g.c != null) {
                    this.g.c.callback(false, null, null, this.g.b, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:145:0x04de  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(fe9 fe9Var) {
            int i;
            int i2;
            int i3;
            de9 de9Var;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            boolean z2;
            boolean z3;
            String i4;
            String h;
            String str;
            String str2;
            PostWriteCallBackData postWriteCallBackData;
            CustomDialogData activityDialog;
            VideoEasterEggData videoEasterEggData;
            String str3;
            String str4;
            int i5;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            CustomDialogData customDialogData;
            String str10;
            String str11;
            String str12;
            String str13;
            ca5 ca5Var;
            IconStampData iconStampData;
            VideoEasterEggData videoEasterEggData2;
            String str14;
            String str15;
            VideoEasterEggData videoEasterEggData3;
            ca5 ca5Var2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fe9Var) == null) {
                super.onPostExecute(fe9Var);
                if (fe9Var == null) {
                    return;
                }
                this.c = fe9Var.d();
                this.a.k(this.g.b, fe9Var);
                yd9.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                wd9.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!fe9Var.e() && this.c != null) {
                    i = 18;
                } else {
                    i = 19;
                }
                StatisticItem param2 = param.param("obj_locate", i);
                if (this.g.b != null) {
                    i2 = this.g.b.getType();
                } else {
                    i2 = -1;
                }
                StatisticItem param3 = param2.param("obj_type", i2);
                if (this.g.b != null && this.g.b.isNewWritePage()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                TiebaStatic.log(param3.param(TiebaStatic.Params.OBJ_PARAM3, i3).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!fe9Var.e() && this.c != null) {
                    yd9.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (gi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    de9Var = new de9(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !de9Var.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    yd9.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    de9Var = new de9(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i6 = 0; i6 < length; i6++) {
                                    arrayList.add(jSONArray.optString(i6));
                                }
                                de9Var.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    yd9.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    de9Var = new de9(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        cz4 cz4Var = new cz4();
                        cz4Var.a = optJSONObject.optString("block_content");
                        cz4Var.b = optJSONObject.optString("block_cancel");
                        cz4Var.c = optJSONObject.optString("block_confirm");
                        de9Var.Q(cz4Var);
                    }
                    yd9.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f11ea);
                        }
                    }
                    de9Var = new de9(g.getError_code(), error_msg2, this.a.e());
                    yd9.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    de9Var = new de9(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0d1f), null);
                    yd9.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (de9Var.w()) {
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
                        i5 = 0;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        customDialogData = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        ca5Var = null;
                        iconStampData = null;
                    } else {
                        str10 = jSONObject3.optString("msg");
                        str12 = jSONObject3.optString("pre_msg");
                        String optString = jSONObject3.optString("color_msg");
                        String optString2 = jSONObject3.optString("tid");
                        String optString3 = jSONObject3.optString("pid");
                        str5 = jSONObject3.optString("video_id");
                        str6 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = jh8.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        if (optJSONObject3 != null) {
                            i5 = optJSONObject3.optInt("is_copytwzhibo", 0);
                        } else {
                            i5 = 0;
                        }
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str11 = optJSONObject4.optString("pre_msg");
                            str13 = optJSONObject4.optString("color_msg");
                            str15 = optJSONObject4.optString("question_msg");
                            str14 = optJSONObject4.optString("question_exp");
                        } else {
                            str14 = null;
                            str15 = null;
                            str11 = null;
                            str13 = null;
                        }
                        contriInfo.parseJson(jSONObject3.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("star_info");
                        String str16 = str14;
                        if (optJSONObject5 != null) {
                            videoEasterEggData3 = new VideoEasterEggData();
                            videoEasterEggData3.parseJson(optJSONObject5);
                        } else {
                            videoEasterEggData3 = null;
                        }
                        JSONObject optJSONObject6 = jSONObject3.optJSONObject("advertisement");
                        VideoEasterEggData videoEasterEggData4 = videoEasterEggData3;
                        if (optJSONObject6 != null) {
                            ca5Var2 = new ca5();
                            ca5Var2.q(optJSONObject6);
                        } else {
                            ca5Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        ca5 ca5Var3 = ca5Var2;
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
                            de9Var.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str3 = optString;
                        str8 = optString3;
                        customDialogData = a2;
                        videoEasterEggData = videoEasterEggData4;
                        ca5Var = ca5Var3;
                        iconStampData = iconStampData3;
                        obj = "pid";
                        str4 = str15;
                        str7 = optString2;
                        obj2 = "tid";
                        str9 = str16;
                    }
                    if (StringUtils.isNull(str10)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str10 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    de9Var.G(str10);
                    de9Var.N(str12);
                    de9Var.E(str3);
                    de9Var.P(str4);
                    de9Var.O(str9);
                    de9Var.S(str7);
                    de9Var.M(str8);
                    de9Var.L(i5);
                    de9Var.I(str11);
                    de9Var.H(str13);
                    de9Var.C(customDialogData);
                    de9Var.V(str5);
                    de9Var.K(str6);
                    de9Var.F(contriInfo);
                    de9Var.U(videoEasterEggData2);
                    de9Var.D(ca5Var);
                    de9Var.J(iconStampData);
                }
                qv4.b("write", "result*" + fe9Var.e());
                qv4.b("write", "code*" + de9Var.f() + " " + de9Var.g());
                qv4.e("write");
                yd9.a("doInBackground end");
                yd9.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                yd9.a("onPostExecute start");
                yd9.a("发帖： onPostExecute");
                this.g.a = null;
                if (de9Var.f() != 0) {
                    b35.a("write", 0L, 0, "write_result", de9Var.f(), de9Var.g(), obj2, de9Var.s(), obj, de9Var.m());
                }
                if (!this.d) {
                    if (de9Var.w()) {
                        yd9.a("onPostExecute error");
                        c(de9Var);
                        oc8 oc8Var = this.f;
                        if (oc8Var != null) {
                            oc8Var.h(de9Var.a, de9Var.g());
                        }
                    } else {
                        if (this.g.b != null) {
                            this.g.b.getType();
                            boolean isNotificationH5 = this.g.b.isNotificationH5();
                            z2 = this.g.b.isNotFakePost();
                            z = isNotificationH5;
                        } else {
                            z = false;
                            z2 = false;
                        }
                        yd9.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(de9Var.n()) && !StringUtils.isNull(de9Var.d())) {
                                i4 = de9Var.n();
                                h = de9Var.d();
                            } else if (StringUtils.isNull(de9Var.h()) && StringUtils.isNull(de9Var.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(de9Var.f(), de9Var.g(), str, str2, de9Var.p(), de9Var.o());
                                postWriteCallBackData.setThreadId(de9Var.s());
                                postWriteCallBackData.setPostId(de9Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(de9Var.l());
                                postWriteCallBackData.setErrorString(de9Var.g());
                                postWriteCallBackData.setActivityDialog(de9Var.a());
                                postWriteCallBackData.setVideoid(de9Var.v());
                                postWriteCallBackData.setInviteesNumber(de9Var.k());
                                postWriteCallBackData.setContriInfo(de9Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(de9Var.u());
                                postWriteCallBackData.setmAdverSegmentData(de9Var.b());
                                postWriteCallBackData.setIconStampData(de9Var.j());
                                postWriteCallBackData.setToast(de9Var.t());
                                x75 x75Var = new x75();
                                x75Var.f(this.c);
                                if (this.g.b == null && ee9.a() != null && !z2) {
                                    ee9.l(this.g.b.getForumId());
                                    ee9.m(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, ee9.a()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    ee9.k(false);
                                } else if (this.g.b == null && this.g.f) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.g) {
                                    ee9.l(this.g.b.getForumId());
                                    ee9.m(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog == null && de9Var.j() == null) {
                                    if (this.g.b != null) {
                                        int type = this.g.b.getType();
                                        if (type != 1 && type != 2) {
                                            if (type != 9) {
                                                switch (type) {
                                                }
                                            }
                                            activityDialog.type = 2;
                                        } else {
                                            z3 = true;
                                            activityDialog.type = 1;
                                            jg.a().postDelayed(new c(this, activityDialog), 1000L);
                                        }
                                    }
                                    z3 = true;
                                    jg.a().postDelayed(new c(this, activityDialog), 1000L);
                                } else {
                                    z3 = true;
                                }
                                this.g.c.callback(true, postWriteCallBackData, x75Var, this.g.b, de9Var.c());
                            } else {
                                i4 = de9Var.i();
                                h = de9Var.h();
                            }
                            str = i4;
                            str2 = h;
                            postWriteCallBackData = new PostWriteCallBackData(de9Var.f(), de9Var.g(), str, str2, de9Var.p(), de9Var.o());
                            postWriteCallBackData.setThreadId(de9Var.s());
                            postWriteCallBackData.setPostId(de9Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(de9Var.l());
                            postWriteCallBackData.setErrorString(de9Var.g());
                            postWriteCallBackData.setActivityDialog(de9Var.a());
                            postWriteCallBackData.setVideoid(de9Var.v());
                            postWriteCallBackData.setInviteesNumber(de9Var.k());
                            postWriteCallBackData.setContriInfo(de9Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(de9Var.u());
                            postWriteCallBackData.setmAdverSegmentData(de9Var.b());
                            postWriteCallBackData.setIconStampData(de9Var.j());
                            postWriteCallBackData.setToast(de9Var.t());
                            x75 x75Var2 = new x75();
                            x75Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                ee9.l(this.g.b.getForumId());
                                ee9.m(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog == null) {
                            }
                            z3 = true;
                            this.g.c.callback(true, postWriteCallBackData, x75Var2, this.g.b, de9Var.c());
                        } else {
                            z3 = true;
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (de9Var.j() != null) {
                                z3 = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z3)));
                        }
                        oc8 oc8Var2 = this.f;
                        if (oc8Var2 != null) {
                            oc8Var2.c();
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921786, null));
                        }
                    }
                    yd9.a("发帖： onPostExecute 完全结束");
                    return;
                }
                yd9.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, zz4Var};
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
            this.a = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.dismiss();
                this.b.g0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, zz4Var};
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
            this.a = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
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

    /* loaded from: classes6.dex */
    public class c extends gd9.c {
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

        @Override // com.baidu.tieba.gd9.c
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
                this.a.s0();
            }
        }

        @Override // com.baidu.tieba.gd9.c
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
                this.a.s0();
            }
        }

        @Override // com.baidu.tieba.gd9.c
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

        @Override // com.baidu.tieba.gd9.c
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
                this.a.s0();
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
                super((a9) newInitContext.callArgs[0]);
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
                super((a9) newInitContext.callArgs[0]);
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

    public final void i0(de9 de9Var) {
        a9<?> a9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, de9Var) == null) && (a9Var = this.e) != null && de9Var != null && !(this.c instanceof xd9)) {
            nj9.e(a9Var.getPageActivity(), de9Var.g());
            de9Var.G(null);
        }
    }

    public final void k0(de9 de9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, de9Var) == null) {
            l0(de9Var, null, null, this.b);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.g = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f = z;
        }
    }

    public void p0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void q0(@Nullable a9<?> a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, a9Var) == null) {
            if (a9Var != null) {
                this.e = a9Var;
                this.unique_id = a9Var.getUniqueId();
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

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e eVar = this.a;
            if (eVar != null && !eVar.isCancelled()) {
                this.a.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public WriteData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (WriteData) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            yd9.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            g0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g0() {
        int i;
        int i2;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData2 = this.b;
            if (writeData2 != null) {
                i = writeData2.getType();
            } else {
                i = -1;
            }
            StatisticItem param2 = param.param("obj_type", i);
            WriteData writeData3 = this.b;
            if (writeData3 != null && writeData3.isNewWritePage()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param2.param(TiebaStatic.Params.OBJ_PARAM3, i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            qv4.d("write");
            qv4.b("write", "start");
            if (this.a == null) {
                if (ee9.a() != null && (writeData = this.b) != null && !writeData.isNotFakePost()) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, h0());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, ee9.a()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.h == null) {
                    this.h = new gc9(this.e);
                }
                this.a = new e(this);
                yd9.a("dealPost()");
                wd9.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public final void j0(de9 de9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, de9Var) == null) && this.e != null && de9Var != null && de9Var.c() != null && de9Var.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), de9Var.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void l0(de9 de9Var, AccessState accessState, x75 x75Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, de9Var, accessState, x75Var, writeData) == null) && de9Var != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(de9Var.f(), de9Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(de9Var.r());
            postWriteCallBackData.setReplyPrivacyTip(de9Var.q());
            this.c.callback(false, postWriteCallBackData, x75Var, writeData, de9Var.c());
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !m35.m().i("original_img_up_tip", false)) {
                m35.m().w("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                a9<?> a9Var = this.e;
                if (a9Var == null) {
                    g0();
                    return true;
                }
                zz4 zz4Var = new zz4(a9Var.getPageActivity());
                zz4Var.setMessageId(R.string.original_img_up_no_wifi_tip);
                zz4Var.setPositiveButton(R.string.alert_yes_button, new a(this, zz4Var));
                zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new b(this, zz4Var));
                zz4Var.create(this.e);
                zz4Var.show();
            } else {
                g0();
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
