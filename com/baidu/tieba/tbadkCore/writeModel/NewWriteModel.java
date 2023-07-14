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
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
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
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.R;
import com.baidu.tieba.afa;
import com.baidu.tieba.b15;
import com.baidu.tieba.b99;
import com.baidu.tieba.bfa;
import com.baidu.tieba.cda;
import com.baidu.tieba.cfa;
import com.baidu.tieba.da5;
import com.baidu.tieba.dda;
import com.baidu.tieba.dea;
import com.baidu.tieba.dh;
import com.baidu.tieba.f99;
import com.baidu.tieba.fn5;
import com.baidu.tieba.jg9;
import com.baidu.tieba.l9;
import com.baidu.tieba.mg9;
import com.baidu.tieba.p45;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.s95;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tea;
import com.baidu.tieba.uea;
import com.baidu.tieba.ve5;
import com.baidu.tieba.vea;
import com.baidu.tieba.vka;
import com.baidu.tieba.xi;
import com.baidu.tieba.yd9;
import com.baidu.tieba.zg;
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
    public l9<?> e;
    public boolean f;
    public boolean g;
    public dda h;
    public dea.c i;

    /* loaded from: classes8.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class e extends BdAsyncTask<Integer, Integer, cfa> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public cda a;
        public String b;
        public JSONObject c;
        public boolean d;
        public f99 e;
        public b99 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes8.dex */
        public class a implements dda.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0486a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cfa a;
                public final /* synthetic */ a b;

                public RunnableC0486a(a aVar, cfa cfaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, cfaVar};
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
                    this.a = cfaVar;
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

            @Override // com.baidu.tieba.dda.e
            public void a(cfa cfaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cfaVar) == null) {
                    dh.g(new RunnableC0486a(this, cfaVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements dda.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cfa a;
                public final /* synthetic */ b b;

                public a(b bVar, cfa cfaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, cfaVar};
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
                    this.a = cfaVar;
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

            @Override // com.baidu.tieba.dda.e
            public void a(cfa cfaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cfaVar) == null) {
                    dh.g(new a(this, cfaVar));
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
                mg9 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = jg9.a((TbPageContext) this.b.g.e, this.a)) != null) {
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, f99.class);
            if (runTask != null) {
                this.e = (f99) runTask.getData();
            }
            f99 f99Var = this.e;
            if (f99Var != null) {
                this.f = f99Var.get();
            }
            setPriority(3);
            vea.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public cfa doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                b15.b("write", DownloadStatisticConstants.UBC_VALUE_TASK);
                if (this.d) {
                    return null;
                }
                fn5.e(this.g.b.getContent());
                vea.a("doInBackground() start");
                vea.a("发帖：任务后台执行 开始 doInBackground");
                cda cdaVar = new cda();
                this.a = cdaVar;
                cdaVar.l(this.f);
                if (this.a.n(this.g.b)) {
                    this.b = this.a.b(this.g.h, this.g.b, this.g.d, new a(this));
                    return null;
                } else if (this.a.m(this.g.b)) {
                    this.b = this.a.a(this.g.h, this.g.b, this.g.d, new b(this));
                    return null;
                } else {
                    this.b = this.a.j(this.g.b, this.g.d);
                    b15.b("write", "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    cfa cfaVar = new cfa();
                    if (this.a.i()) {
                        cfaVar.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        cfaVar.f(errorData.getError_code());
                        cfaVar.h(errorData.getError_msg());
                        cfaVar.g(errorData.getError_data());
                    } else {
                        cfaVar.i(true);
                        cfaVar.f(this.a.f());
                        cfaVar.h(this.a.h());
                    }
                    cfaVar.j(this.c);
                    return cfaVar;
                }
            }
            return (cfa) invokeL.objValue;
        }

        public final void c(afa afaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, afaVar) != null) || dea.a(afaVar.f(), AuthTokenData.parse(this.c), this.g.i)) {
                return;
            }
            if (!afaVar.y()) {
                if (!afaVar.B()) {
                    if (!vka.d(afaVar.f())) {
                        if (afaVar.z()) {
                            ve5 ve5Var = new ve5();
                            ve5Var.f(this.c);
                            if (ve5Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(ve5Var.b());
                                this.g.b.setVcodeUrl(ve5Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.p0(afaVar, null, ve5Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (afaVar.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.p0(afaVar, accessState, null, newWriteModel2.b);
                            return;
                        } else if (afaVar.A()) {
                            this.g.o0(afaVar);
                            return;
                        } else {
                            this.g.o0(afaVar);
                            return;
                        }
                    }
                    this.g.m0(afaVar);
                    this.g.o0(afaVar);
                    return;
                }
                this.g.n0(afaVar);
                this.g.o0(afaVar);
                return;
            }
            this.g.o0(afaVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                cda cdaVar = this.a;
                if (cdaVar != null) {
                    cdaVar.d();
                }
                if (this.g.c != null) {
                    this.g.c.callback(false, null, null, this.g.b, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:149:0x04eb  */
        /* JADX WARN: Removed duplicated region for block: B:178:0x05fe  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(cfa cfaVar) {
            int i;
            int i2;
            int i3;
            afa afaVar;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
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
            AdverSegmentData adverSegmentData;
            IconStampData iconStampData;
            VideoEasterEggData videoEasterEggData2;
            String str14;
            String str15;
            VideoEasterEggData videoEasterEggData3;
            AdverSegmentData adverSegmentData2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cfaVar) == null) {
                super.onPostExecute(cfaVar);
                if (cfaVar == null) {
                    return;
                }
                this.c = cfaVar.d();
                this.a.k(this.g.b, cfaVar);
                vea.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                tea.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!cfaVar.e() && this.c != null) {
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
                if (!cfaVar.e() && this.c != null) {
                    vea.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (xi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    afaVar = new afa(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !afaVar.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    vea.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    afaVar = new afa(g.getError_code(), g.getError_msg(), null);
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
                                afaVar.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    vea.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    afaVar = new afa(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        p45 p45Var = new p45();
                        p45Var.a = optJSONObject.optString("block_content");
                        p45Var.b = optJSONObject.optString("block_cancel");
                        p45Var.c = optJSONObject.optString("block_confirm");
                        afaVar.Q(p45Var);
                    }
                    vea.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f134f);
                        }
                    }
                    afaVar = new afa(g.getError_code(), error_msg2, this.a.e());
                    vea.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    afaVar = new afa(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0e1f), null);
                    vea.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (afaVar.w()) {
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
                        adverSegmentData = null;
                        iconStampData = null;
                    } else {
                        str10 = jSONObject3.optString("msg");
                        str12 = jSONObject3.optString("pre_msg");
                        String optString = jSONObject3.optString("color_msg");
                        String optString2 = jSONObject3.optString("tid");
                        String optString3 = jSONObject3.optString("pid");
                        str5 = jSONObject3.optString("video_id");
                        str6 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = yd9.a(jSONObject3);
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
                            afaVar.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str3 = optString;
                        str8 = optString3;
                        customDialogData = a2;
                        videoEasterEggData = videoEasterEggData4;
                        adverSegmentData = adverSegmentData3;
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
                    afaVar.G(str10);
                    afaVar.N(str12);
                    afaVar.E(str3);
                    afaVar.P(str4);
                    afaVar.O(str9);
                    afaVar.S(str7);
                    afaVar.M(str8);
                    afaVar.L(i5);
                    afaVar.I(str11);
                    afaVar.H(str13);
                    afaVar.C(customDialogData);
                    afaVar.V(str5);
                    afaVar.K(str6);
                    afaVar.F(contriInfo);
                    afaVar.U(videoEasterEggData2);
                    afaVar.D(adverSegmentData);
                    afaVar.J(iconStampData);
                }
                b15.b("write", "result*" + cfaVar.e());
                b15.b("write", "code*" + afaVar.f() + " " + afaVar.g());
                b15.e("write");
                vea.a("doInBackground end");
                vea.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                vea.a("onPostExecute start");
                vea.a("发帖： onPostExecute");
                this.g.a = null;
                if (afaVar.f() != 0) {
                    s95.a("write", 0L, 0, "write_result", afaVar.f(), afaVar.g(), obj2, afaVar.s(), obj, afaVar.m());
                }
                if (!this.d) {
                    if (this.g.b != null) {
                        z = this.g.b.isReplyResultNotificationH5;
                    } else {
                        z = false;
                    }
                    if (afaVar.w()) {
                        vea.a("onPostExecute error");
                        c(afaVar);
                        b99 b99Var = this.f;
                        if (b99Var != null) {
                            b99Var.h(afaVar.a, afaVar.g());
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
                        vea.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(afaVar.n()) && !StringUtils.isNull(afaVar.d())) {
                                i4 = afaVar.n();
                                h = afaVar.d();
                            } else if (StringUtils.isNull(afaVar.h()) && StringUtils.isNull(afaVar.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(afaVar.f(), afaVar.g(), str, str2, afaVar.p(), afaVar.o());
                                postWriteCallBackData.setThreadId(afaVar.s());
                                postWriteCallBackData.setPostId(afaVar.m());
                                postWriteCallBackData.setIsCopyTWZhibo(afaVar.l());
                                postWriteCallBackData.setErrorString(afaVar.g());
                                postWriteCallBackData.setActivityDialog(afaVar.a());
                                postWriteCallBackData.setVideoid(afaVar.v());
                                postWriteCallBackData.setInviteesNumber(afaVar.k());
                                postWriteCallBackData.setContriInfo(afaVar.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(afaVar.u());
                                postWriteCallBackData.setmAdverSegmentData(afaVar.b());
                                postWriteCallBackData.setIconStampData(afaVar.j());
                                postWriteCallBackData.setToast(afaVar.t());
                                ve5 ve5Var = new ve5();
                                ve5Var.f(this.c);
                                if (this.g.b == null && bfa.a() != null && !z3) {
                                    bfa.l(this.g.b.getForumId());
                                    bfa.m(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, bfa.a()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    bfa.k(false);
                                } else if (this.g.b == null && this.g.f) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.g) {
                                    bfa.l(this.g.b.getForumId());
                                    bfa.m(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && afaVar.j() == null) {
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
                                    zg.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, ve5Var, this.g.b, afaVar.c());
                            } else {
                                i4 = afaVar.i();
                                h = afaVar.h();
                            }
                            str = i4;
                            str2 = h;
                            postWriteCallBackData = new PostWriteCallBackData(afaVar.f(), afaVar.g(), str, str2, afaVar.p(), afaVar.o());
                            postWriteCallBackData.setThreadId(afaVar.s());
                            postWriteCallBackData.setPostId(afaVar.m());
                            postWriteCallBackData.setIsCopyTWZhibo(afaVar.l());
                            postWriteCallBackData.setErrorString(afaVar.g());
                            postWriteCallBackData.setActivityDialog(afaVar.a());
                            postWriteCallBackData.setVideoid(afaVar.v());
                            postWriteCallBackData.setInviteesNumber(afaVar.k());
                            postWriteCallBackData.setContriInfo(afaVar.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(afaVar.u());
                            postWriteCallBackData.setmAdverSegmentData(afaVar.b());
                            postWriteCallBackData.setIconStampData(afaVar.j());
                            postWriteCallBackData.setToast(afaVar.t());
                            ve5 ve5Var2 = new ve5();
                            ve5Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                bfa.l(this.g.b.getForumId());
                                bfa.m(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                zg.a().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.c.callback(true, postWriteCallBackData, ve5Var2, this.g.b, afaVar.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (afaVar.j() == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z4)));
                        }
                        b99 b99Var2 = this.f;
                        if (b99Var2 != null) {
                            b99Var2.c();
                        }
                        if (z2) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921786, null));
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921805, 1));
                        }
                    }
                    vea.a("发帖： onPostExecute 完全结束");
                    return;
                }
                vea.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, p55Var};
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
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                this.a.dismiss();
                this.b.k0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, p55Var};
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
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
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
    public class c extends dea.c {
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

        @Override // com.baidu.tieba.dea.c
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
                this.a.w0();
            }
        }

        @Override // com.baidu.tieba.dea.c
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
                this.a.w0();
            }
        }

        @Override // com.baidu.tieba.dea.c
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

        @Override // com.baidu.tieba.dea.c
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
                this.a.w0();
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
                super((l9) newInitContext.callArgs[0]);
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
                super((l9) newInitContext.callArgs[0]);
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

    public final void m0(afa afaVar) {
        l9<?> l9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, afaVar) == null) && (l9Var = this.e) != null && afaVar != null && !(this.c instanceof uea)) {
            vka.e(l9Var.getPageActivity(), afaVar.g());
            afaVar.G(null);
        }
    }

    public final void o0(afa afaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, afaVar) == null) {
            p0(afaVar, null, null, this.b);
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.g = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f = z;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, writeData) == null) {
            this.b = writeData;
        }
    }

    public void t0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void u0(@Nullable l9<?> l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, l9Var) == null) {
            if (l9Var != null) {
                this.e = l9Var;
                this.unique_id = l9Var.getUniqueId();
                return;
            }
            this.e = null;
            this.unique_id = null;
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

    public boolean j0() {
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

    public WriteData l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (WriteData) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                return false;
            }
            vea.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            k0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void k0() {
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
            b15.d("write");
            b15.b("write", "start");
            if (this.a == null) {
                if (bfa.a() != null && (writeData = this.b) != null && !writeData.isNotFakePost()) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, l0());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, bfa.a()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.h == null) {
                    this.h = new dda(this.e);
                }
                this.a = new e(this);
                vea.a("dealPost()");
                tea.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public final void n0(afa afaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, afaVar) == null) && this.e != null && afaVar != null && afaVar.c() != null && afaVar.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), afaVar.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void p0(afa afaVar, AccessState accessState, ve5 ve5Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048585, this, afaVar, accessState, ve5Var, writeData) == null) && afaVar != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(afaVar.f(), afaVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(afaVar.r());
            postWriteCallBackData.setReplyPrivacyTip(afaVar.q());
            this.c.callback(false, postWriteCallBackData, ve5Var, writeData, afaVar.c());
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !da5.p().l("original_img_up_tip", false)) {
                da5.p().A("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                l9<?> l9Var = this.e;
                if (l9Var == null) {
                    k0();
                    return true;
                }
                p55 p55Var = new p55(l9Var.getPageActivity());
                p55Var.setMessageId(R.string.original_img_up_no_wifi_tip);
                p55Var.setPositiveButton(R.string.alert_yes_button, new a(this, p55Var));
                p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this, p55Var));
                p55Var.create(this.e);
                p55Var.show();
            } else {
                k0();
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
