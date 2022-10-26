package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.R;
import com.baidu.tieba.e25;
import com.baidu.tieba.ej;
import com.baidu.tieba.f45;
import com.baidu.tieba.hh;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kp8;
import com.baidu.tieba.kq4;
import com.baidu.tieba.lh;
import com.baidu.tieba.lp8;
import com.baidu.tieba.m85;
import com.baidu.tieba.mp8;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pu4;
import com.baidu.tieba.r9;
import com.baidu.tieba.rp8;
import com.baidu.tieba.ru8;
import com.baidu.tieba.sp8;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tp7;
import com.baidu.tieba.tu7;
import com.baidu.tieba.un8;
import com.baidu.tieba.uo8;
import com.baidu.tieba.ux4;
import com.baidu.tieba.vn8;
import com.baidu.tieba.vt4;
import com.baidu.tieba.xp7;
import com.baidu.tieba.zw7;
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
/* loaded from: classes5.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public WriteData b;
    public d c;
    public boolean d;
    public r9 e;
    public SpanGroupManager f;
    public String g;
    public boolean h;
    public boolean i;
    public vn8 j;
    public uo8.c k;

    /* loaded from: classes5.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, e25 e25Var, WriteData writeData, AntiData antiData);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public un8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public xp7 e;
        public tp7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes5.dex */
        public class a implements vn8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0407a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ sp8 a;
                public final /* synthetic */ a b;

                public RunnableC0407a(a aVar, sp8 sp8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, sp8Var};
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
                    this.a = sp8Var;
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

            @Override // com.baidu.tieba.vn8.e
            public void a(sp8 sp8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sp8Var) == null) {
                    lh.b(new RunnableC0407a(this, sp8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements vn8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ sp8 a;
                public final /* synthetic */ b b;

                public a(b bVar, sp8 sp8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, sp8Var};
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
                    this.a = sp8Var;
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

            @Override // com.baidu.tieba.vn8.e
            public void a(sp8 sp8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sp8Var) == null) {
                    lh.b(new a(this, sp8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
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
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    zw7.a((TbPageContext) this.b.g.e, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, xp7.class);
            if (runTask != null) {
                this.e = (xp7) runTask.getData();
            }
            xp7 xp7Var = this.e;
            if (xp7Var != null) {
                this.f = xp7Var.get();
            }
            setPriority(3);
            mp8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public sp8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                kq4.b(AlbumActivityConfig.FROM_WRITE, "task");
                if (this.d) {
                    return null;
                }
                m85.e(this.g.b.getContent());
                mp8.a("doInBackground() start");
                mp8.a("发帖：任务后台执行 开始 doInBackground");
                un8 un8Var = new un8();
                this.a = un8Var;
                un8Var.l(this.g.f);
                this.a.m(this.g.g);
                this.a.n(this.f);
                if (this.a.p(this.g.b)) {
                    this.b = this.a.b(this.g.j, this.g.b, this.g.d, new a(this));
                    return null;
                } else if (this.a.o(this.g.b)) {
                    this.b = this.a.a(this.g.j, this.g.b, this.g.d, new b(this));
                    return null;
                } else {
                    this.b = this.a.j(this.g.b, this.g.d);
                    kq4.b(AlbumActivityConfig.FROM_WRITE, "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    sp8 sp8Var = new sp8();
                    if (this.a.i()) {
                        sp8Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        sp8Var.f(errorData.getError_code());
                        sp8Var.h(errorData.getError_msg());
                        sp8Var.g(errorData.getError_data());
                    } else {
                        sp8Var.i(true);
                        sp8Var.f(this.a.f());
                        sp8Var.h(this.a.h());
                    }
                    sp8Var.j(this.c);
                    return sp8Var;
                }
            }
            return (sp8) invokeL.objValue;
        }

        public final void c(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp8Var) != null) || uo8.a(rp8Var.f(), AuthTokenData.parse(this.c), this.g.k)) {
                return;
            }
            if (!rp8Var.y()) {
                if (!rp8Var.B()) {
                    if (!ru8.d(rp8Var.f())) {
                        if (rp8Var.z()) {
                            e25 e25Var = new e25();
                            e25Var.f(this.c);
                            if (e25Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(e25Var.b());
                                this.g.b.setVcodeUrl(e25Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.X(rp8Var, null, e25Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (rp8Var.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.X(rp8Var, accessState, null, newWriteModel2.b);
                            return;
                        } else if (rp8Var.A()) {
                            this.g.W(rp8Var);
                            return;
                        } else {
                            this.g.W(rp8Var);
                            return;
                        }
                    }
                    this.g.U(rp8Var);
                    this.g.W(rp8Var);
                    return;
                }
                this.g.V(rp8Var);
                this.g.W(rp8Var);
                return;
            }
            this.g.W(rp8Var);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                un8 un8Var = this.a;
                if (un8Var != null) {
                    un8Var.d();
                }
                if (this.g.c != null) {
                    this.g.c.callback(false, null, null, this.g.b, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:144:0x04c9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(sp8 sp8Var) {
            int i;
            int i2;
            int i3;
            rp8 rp8Var;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            String i4;
            String h;
            String str;
            String str2;
            PostWriteCallBackData postWriteCallBackData;
            CustomDialogData activityDialog;
            String str3;
            String str4;
            String str5;
            VideoEasterEggData videoEasterEggData;
            CustomDialogData customDialogData;
            String str6;
            int i5;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            IconStampData iconStampData;
            f45 f45Var;
            VideoEasterEggData videoEasterEggData2;
            int i6;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            f45 f45Var2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sp8Var) == null) {
                super.onPostExecute(sp8Var);
                if (sp8Var == null) {
                    return;
                }
                this.c = sp8Var.d();
                this.a.k(this.g.b, sp8Var);
                mp8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                kp8.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!sp8Var.e() && this.c != null) {
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
                if (!sp8Var.e() && this.c != null) {
                    mp8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (ej.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1143);
                    }
                    rp8Var = new rp8(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !rp8Var.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    mp8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    rp8Var = new rp8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList arrayList = new ArrayList();
                                for (int i7 = 0; i7 < length; i7++) {
                                    arrayList.add(jSONArray.optString(i7));
                                }
                                rp8Var.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    mp8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    rp8Var = new rp8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        vt4 vt4Var = new vt4();
                        vt4Var.a = optJSONObject.optString("block_content");
                        vt4Var.b = optJSONObject.optString("block_cancel");
                        vt4Var.c = optJSONObject.optString("block_confirm");
                        rp8Var.Q(vt4Var);
                    }
                    mp8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0288);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    rp8Var = new rp8(g.getError_code(), error_msg2, this.a.e());
                    mp8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    rp8Var = new rp8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c68), null);
                    mp8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (rp8Var.w()) {
                    obj = "pid";
                    obj2 = "tid";
                } else {
                    ContriInfo contriInfo = new ContriInfo();
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 == null) {
                        obj = "pid";
                        obj2 = "tid";
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        videoEasterEggData = null;
                        customDialogData = null;
                        str6 = null;
                        i5 = 0;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        iconStampData = null;
                        f45Var = null;
                    } else {
                        String optString = jSONObject3.optString("msg");
                        String optString2 = jSONObject3.optString("pre_msg");
                        String optString3 = jSONObject3.optString("color_msg");
                        String optString4 = jSONObject3.optString("tid");
                        String optString5 = jSONObject3.optString("pid");
                        String optString6 = jSONObject3.optString("video_id");
                        String optString7 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = tu7.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        if (optJSONObject3 != null) {
                            i6 = optJSONObject3.optInt("is_copytwzhibo", 0);
                        } else {
                            i6 = 0;
                        }
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str16 = optJSONObject4.optString("pre_msg");
                            str17 = optJSONObject4.optString("color_msg");
                            str15 = optJSONObject4.optString("question_msg");
                            str14 = optJSONObject4.optString("question_exp");
                        } else {
                            str14 = null;
                            str15 = null;
                            str16 = null;
                            str17 = null;
                        }
                        contriInfo.parseJson(jSONObject3.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("star_info");
                        String str18 = str14;
                        if (optJSONObject5 != null) {
                            videoEasterEggData3 = new VideoEasterEggData();
                            videoEasterEggData3.parseJson(optJSONObject5);
                        } else {
                            videoEasterEggData3 = null;
                        }
                        JSONObject optJSONObject6 = jSONObject3.optJSONObject("advertisement");
                        VideoEasterEggData videoEasterEggData4 = videoEasterEggData3;
                        if (optJSONObject6 != null) {
                            f45Var2 = new f45();
                            f45Var2.p(optJSONObject6);
                        } else {
                            f45Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        f45 f45Var3 = f45Var2;
                        if (optJSONObject7 != null) {
                            iconStampData2 = new IconStampData();
                            iconStampData2.parseJson(optJSONObject7);
                        } else {
                            iconStampData2 = null;
                        }
                        if (jSONObject3.has(DI.TOAST_NAME)) {
                            iconStampData3 = iconStampData2;
                            BdToastData bdToastData = new BdToastData();
                            bdToastData.parserJson(jSONObject3.optJSONObject(DI.TOAST_NAME));
                            rp8Var.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str7 = optString6;
                        str9 = optString7;
                        str3 = optString4;
                        str6 = optString5;
                        customDialogData = a2;
                        str4 = str18;
                        f45Var = f45Var3;
                        iconStampData = iconStampData3;
                        obj2 = "tid";
                        str8 = optString3;
                        obj = "pid";
                        str5 = str17;
                        str13 = optString2;
                        str12 = str16;
                        str11 = optString;
                        str10 = str15;
                        i5 = i6;
                        videoEasterEggData = videoEasterEggData4;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1143);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    rp8Var.G(str11);
                    rp8Var.N(str13);
                    rp8Var.E(str8);
                    rp8Var.P(str10);
                    rp8Var.O(str4);
                    rp8Var.S(str3);
                    rp8Var.M(str6);
                    rp8Var.L(i5);
                    rp8Var.I(str12);
                    rp8Var.H(str5);
                    rp8Var.C(customDialogData);
                    rp8Var.V(str7);
                    rp8Var.K(str9);
                    rp8Var.F(contriInfo);
                    rp8Var.U(videoEasterEggData2);
                    rp8Var.D(f45Var);
                    rp8Var.J(iconStampData);
                }
                kq4.b(AlbumActivityConfig.FROM_WRITE, "result*" + sp8Var.e());
                kq4.b(AlbumActivityConfig.FROM_WRITE, "code*" + rp8Var.f() + " " + rp8Var.g());
                kq4.e(AlbumActivityConfig.FROM_WRITE);
                mp8.a("doInBackground end");
                mp8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                mp8.a("onPostExecute start");
                mp8.a("发帖： onPostExecute");
                this.g.a = null;
                if (rp8Var.f() != 0) {
                    jx4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", rp8Var.f(), rp8Var.g(), obj2, rp8Var.s(), obj, rp8Var.m());
                }
                if (!this.d) {
                    if (rp8Var.w()) {
                        mp8.a("onPostExecute error");
                        c(rp8Var);
                        tp7 tp7Var = this.f;
                        if (tp7Var != null) {
                            tp7Var.h(rp8Var.a, rp8Var.g());
                        }
                    } else {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        mp8.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(rp8Var.n()) && !StringUtils.isNull(rp8Var.d())) {
                                i4 = rp8Var.n();
                                h = rp8Var.d();
                            } else if (StringUtils.isNull(rp8Var.h()) && StringUtils.isNull(rp8Var.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(rp8Var.f(), rp8Var.g(), str, str2, rp8Var.p(), rp8Var.o());
                                postWriteCallBackData.setThreadId(rp8Var.s());
                                postWriteCallBackData.setPostId(rp8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(rp8Var.l());
                                postWriteCallBackData.setErrorString(rp8Var.g());
                                postWriteCallBackData.setActivityDialog(rp8Var.a());
                                postWriteCallBackData.setVideoid(rp8Var.v());
                                postWriteCallBackData.setInviteesNumber(rp8Var.k());
                                postWriteCallBackData.setContriInfo(rp8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(rp8Var.u());
                                postWriteCallBackData.setmAdverSegmentData(rp8Var.b());
                                postWriteCallBackData.setIconStampData(rp8Var.j());
                                postWriteCallBackData.setToast(rp8Var.t());
                                e25 e25Var = new e25();
                                e25Var.f(this.c);
                                if (this.g.b == null && lp8.k().i() != null) {
                                    lp8.k().C(this.g.b.getForumId());
                                    lp8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, lp8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    lp8.k().z(false);
                                } else if (this.g.b == null && this.g.h) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.i) {
                                    lp8.k().C(this.g.b.getForumId());
                                    lp8.k().D(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog == null && rp8Var.j() == null) {
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
                                            hh.a().postDelayed(new c(this, activityDialog), 1000L);
                                        }
                                    }
                                    hh.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, e25Var, this.g.b, rp8Var.c());
                            } else {
                                i4 = rp8Var.i();
                                h = rp8Var.h();
                            }
                            str2 = h;
                            str = i4;
                            postWriteCallBackData = new PostWriteCallBackData(rp8Var.f(), rp8Var.g(), str, str2, rp8Var.p(), rp8Var.o());
                            postWriteCallBackData.setThreadId(rp8Var.s());
                            postWriteCallBackData.setPostId(rp8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(rp8Var.l());
                            postWriteCallBackData.setErrorString(rp8Var.g());
                            postWriteCallBackData.setActivityDialog(rp8Var.a());
                            postWriteCallBackData.setVideoid(rp8Var.v());
                            postWriteCallBackData.setInviteesNumber(rp8Var.k());
                            postWriteCallBackData.setContriInfo(rp8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(rp8Var.u());
                            postWriteCallBackData.setmAdverSegmentData(rp8Var.b());
                            postWriteCallBackData.setIconStampData(rp8Var.j());
                            postWriteCallBackData.setToast(rp8Var.t());
                            e25 e25Var2 = new e25();
                            e25Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                lp8.k().C(this.g.b.getForumId());
                                lp8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog == null) {
                            }
                            this.g.c.callback(true, postWriteCallBackData, e25Var2, this.g.b, rp8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (rp8Var.j() == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z)));
                        }
                        tp7 tp7Var2 = this.f;
                        if (tp7Var2 != null) {
                            tp7Var2.c();
                        }
                    }
                    mp8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                mp8.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, pu4Var};
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
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
                this.b.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, pu4Var};
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
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
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

    /* loaded from: classes5.dex */
    public class c extends uo8.c {
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

        @Override // com.baidu.tieba.uo8.c
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
                this.a.e0();
            }
        }

        @Override // com.baidu.tieba.uo8.c
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
                this.a.e0();
            }
        }

        @Override // com.baidu.tieba.uo8.c
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

        @Override // com.baidu.tieba.uo8.c
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
                this.a.e0();
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
        this.k = new c(this);
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.k = new c(this);
        this.e = baseActivity.getPageContext();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewWriteModel(TbPageContext tbPageContext) {
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.k = new c(this);
        this.e = tbPageContext;
    }

    public final void U(rp8 rp8Var) {
        r9 r9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, rp8Var) == null) && (r9Var = this.e) != null && rp8Var != null && !(this.c instanceof lp8)) {
            ru8.e(r9Var.getPageActivity(), rp8Var.g());
            rp8Var.G(null);
        }
    }

    public final void W(rp8 rp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rp8Var) == null) {
            X(rp8Var, null, null, this.b);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.i = z;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.d = z;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h = z;
        }
    }

    public void b0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void c0(r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, r9Var) == null) {
            if (r9Var != null) {
                this.e = r9Var;
                this.unique_id = r9Var.getUniqueId();
                return;
            }
            this.e = null;
            this.unique_id = null;
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, spanGroupManager) == null) {
            this.f = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, writeData) == null) {
            this.b = writeData;
        }
    }

    public boolean Q() {
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

    public WriteData S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (WriteData) invokeV.objValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpanGroupManager spanGroupManager = this.f;
            if (spanGroupManager != null) {
                this.g = spanGroupManager.E();
            } else {
                this.g = null;
            }
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            e eVar = this.a;
            if (eVar != null && !eVar.isCancelled()) {
                this.a.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            mp8.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            R();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData = this.b;
            if (writeData != null) {
                i = writeData.getType();
            } else {
                i = -1;
            }
            StatisticItem param2 = param.param("obj_type", i);
            WriteData writeData2 = this.b;
            if (writeData2 != null && writeData2.isNewWritePage()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param2.param(TiebaStatic.Params.OBJ_PARAM3, i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            kq4.d(AlbumActivityConfig.FROM_WRITE);
            kq4.b(AlbumActivityConfig.FROM_WRITE, "start");
            if (this.a == null) {
                if (lp8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, S());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, lp8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.j == null) {
                    this.j = new vn8(this.e);
                }
                this.a = new e(this);
                mp8.a("dealPost()");
                kp8.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public final void V(rp8 rp8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, rp8Var) == null) && this.e != null && rp8Var != null && rp8Var.c() != null && rp8Var.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), rp8Var.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void X(rp8 rp8Var, AccessState accessState, e25 e25Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048583, this, rp8Var, accessState, e25Var, writeData) == null) && rp8Var != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(rp8Var.f(), rp8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(rp8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(rp8Var.q());
            this.c.callback(false, postWriteCallBackData, e25Var, writeData, rp8Var.c());
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !ux4.k().h("original_img_up_tip", false)) {
                ux4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                r9 r9Var = this.e;
                if (r9Var == null) {
                    R();
                    return true;
                }
                pu4 pu4Var = new pu4(r9Var.getPageActivity());
                pu4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d40);
                pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new a(this, pu4Var));
                pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this, pu4Var));
                pu4Var.create(this.e);
                pu4Var.show();
            } else {
                R();
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
