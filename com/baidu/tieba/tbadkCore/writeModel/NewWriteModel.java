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
import com.baidu.tieba.ah;
import com.baidu.tieba.b35;
import com.baidu.tieba.cr4;
import com.baidu.tieba.d55;
import com.baidu.tieba.eh;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fr8;
import com.baidu.tieba.gr8;
import com.baidu.tieba.hr8;
import com.baidu.tieba.jv4;
import com.baidu.tieba.l95;
import com.baidu.tieba.lw8;
import com.baidu.tieba.mr8;
import com.baidu.tieba.mu4;
import com.baidu.tieba.nr7;
import com.baidu.tieba.nr8;
import com.baidu.tieba.nw7;
import com.baidu.tieba.op8;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pp8;
import com.baidu.tieba.pq8;
import com.baidu.tieba.py4;
import com.baidu.tieba.r9;
import com.baidu.tieba.rr7;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ty7;
import com.baidu.tieba.wy7;
import com.baidu.tieba.xi;
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
    public r9<?> e;
    public SpanGroupManager f;
    public String g;
    public boolean h;
    public boolean i;
    public pp8 j;
    public pq8.c k;

    /* loaded from: classes6.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b35 b35Var, WriteData writeData, AntiData antiData);
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

    /* loaded from: classes6.dex */
    public class e extends BdAsyncTask<Integer, Integer, nr8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public op8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public rr7 e;
        public nr7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes6.dex */
        public class a implements pp8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0430a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ nr8 a;
                public final /* synthetic */ a b;

                public RunnableC0430a(a aVar, nr8 nr8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, nr8Var};
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
                    this.a = nr8Var;
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

            @Override // com.baidu.tieba.pp8.e
            public void a(nr8 nr8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr8Var) == null) {
                    eh.b(new RunnableC0430a(this, nr8Var));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements pp8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes6.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ nr8 a;
                public final /* synthetic */ b b;

                public a(b bVar, nr8 nr8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, nr8Var};
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
                    this.a = nr8Var;
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

            @Override // com.baidu.tieba.pp8.e
            public void a(nr8 nr8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr8Var) == null) {
                    eh.b(new a(this, nr8Var));
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
                wy7 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = ty7.a((TbPageContext) this.b.g.e, this.a)) != null) {
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, rr7.class);
            if (runTask != null) {
                this.e = (rr7) runTask.getData();
            }
            rr7 rr7Var = this.e;
            if (rr7Var != null) {
                this.f = rr7Var.get();
            }
            setPriority(3);
            hr8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public nr8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                cr4.b(AlbumActivityConfig.FROM_WRITE, "task");
                if (this.d) {
                    return null;
                }
                l95.e(this.g.b.getContent());
                hr8.a("doInBackground() start");
                hr8.a("发帖：任务后台执行 开始 doInBackground");
                op8 op8Var = new op8();
                this.a = op8Var;
                op8Var.l(this.g.f);
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
                    cr4.b(AlbumActivityConfig.FROM_WRITE, "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    nr8 nr8Var = new nr8();
                    if (this.a.i()) {
                        nr8Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        nr8Var.f(errorData.getError_code());
                        nr8Var.h(errorData.getError_msg());
                        nr8Var.g(errorData.getError_data());
                    } else {
                        nr8Var.i(true);
                        nr8Var.f(this.a.f());
                        nr8Var.h(this.a.h());
                    }
                    nr8Var.j(this.c);
                    return nr8Var;
                }
            }
            return (nr8) invokeL.objValue;
        }

        public final void c(mr8 mr8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mr8Var) != null) || pq8.a(mr8Var.f(), AuthTokenData.parse(this.c), this.g.k)) {
                return;
            }
            if (!mr8Var.y()) {
                if (!mr8Var.B()) {
                    if (!lw8.d(mr8Var.f())) {
                        if (mr8Var.z()) {
                            b35 b35Var = new b35();
                            b35Var.f(this.c);
                            if (b35Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(b35Var.b());
                                this.g.b.setVcodeUrl(b35Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.X(mr8Var, null, b35Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (mr8Var.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.X(mr8Var, accessState, null, newWriteModel2.b);
                            return;
                        } else if (mr8Var.A()) {
                            this.g.W(mr8Var);
                            return;
                        } else {
                            this.g.W(mr8Var);
                            return;
                        }
                    }
                    this.g.U(mr8Var);
                    this.g.W(mr8Var);
                    return;
                }
                this.g.V(mr8Var);
                this.g.W(mr8Var);
                return;
            }
            this.g.W(mr8Var);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                op8 op8Var = this.a;
                if (op8Var != null) {
                    op8Var.d();
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
        public void onPostExecute(nr8 nr8Var) {
            int i;
            int i2;
            int i3;
            mr8 mr8Var;
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
            d55 d55Var;
            IconStampData iconStampData;
            VideoEasterEggData videoEasterEggData2;
            String str14;
            String str15;
            VideoEasterEggData videoEasterEggData3;
            d55 d55Var2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, nr8Var) == null) {
                super.onPostExecute(nr8Var);
                if (nr8Var == null) {
                    return;
                }
                this.c = nr8Var.d();
                this.a.k(this.g.b, nr8Var);
                hr8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                fr8.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!nr8Var.e() && this.c != null) {
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
                if (!nr8Var.e() && this.c != null) {
                    hr8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (xi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1165);
                    }
                    mr8Var = new mr8(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !mr8Var.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    hr8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    mr8Var = new mr8(g.getError_code(), g.getError_msg(), null);
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
                                mr8Var.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    hr8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    mr8Var = new mr8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        mu4 mu4Var = new mu4();
                        mu4Var.a = optJSONObject.optString("block_content");
                        mu4Var.b = optJSONObject.optString("block_cancel");
                        mu4Var.c = optJSONObject.optString("block_confirm");
                        mr8Var.Q(mu4Var);
                    }
                    hr8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0289);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    mr8Var = new mr8(g.getError_code(), error_msg2, this.a.e());
                    hr8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    mr8Var = new mr8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c81), null);
                    hr8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (mr8Var.w()) {
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
                        d55Var = null;
                        iconStampData = null;
                    } else {
                        str10 = jSONObject3.optString("msg");
                        str12 = jSONObject3.optString("pre_msg");
                        String optString = jSONObject3.optString("color_msg");
                        String optString2 = jSONObject3.optString("tid");
                        String optString3 = jSONObject3.optString("pid");
                        str5 = jSONObject3.optString("video_id");
                        str6 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = nw7.a(jSONObject3);
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
                            d55Var2 = new d55();
                            d55Var2.p(optJSONObject6);
                        } else {
                            d55Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        d55 d55Var3 = d55Var2;
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
                            mr8Var.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str3 = optString;
                        str8 = optString3;
                        customDialogData = a2;
                        videoEasterEggData = videoEasterEggData4;
                        d55Var = d55Var3;
                        iconStampData = iconStampData3;
                        obj = "pid";
                        str4 = str15;
                        str7 = optString2;
                        obj2 = "tid";
                        str9 = str16;
                    }
                    if (StringUtils.isNull(str10)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str10 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1165);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    mr8Var.G(str10);
                    mr8Var.N(str12);
                    mr8Var.E(str3);
                    mr8Var.P(str4);
                    mr8Var.O(str9);
                    mr8Var.S(str7);
                    mr8Var.M(str8);
                    mr8Var.L(i5);
                    mr8Var.I(str11);
                    mr8Var.H(str13);
                    mr8Var.C(customDialogData);
                    mr8Var.V(str5);
                    mr8Var.K(str6);
                    mr8Var.F(contriInfo);
                    mr8Var.U(videoEasterEggData2);
                    mr8Var.D(d55Var);
                    mr8Var.J(iconStampData);
                }
                cr4.b(AlbumActivityConfig.FROM_WRITE, "result*" + nr8Var.e());
                cr4.b(AlbumActivityConfig.FROM_WRITE, "code*" + mr8Var.f() + " " + mr8Var.g());
                cr4.e(AlbumActivityConfig.FROM_WRITE);
                hr8.a("doInBackground end");
                hr8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                hr8.a("onPostExecute start");
                hr8.a("发帖： onPostExecute");
                this.g.a = null;
                if (mr8Var.f() != 0) {
                    ey4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", mr8Var.f(), mr8Var.g(), obj2, mr8Var.s(), obj, mr8Var.m());
                }
                if (!this.d) {
                    if (mr8Var.w()) {
                        hr8.a("onPostExecute error");
                        c(mr8Var);
                        nr7 nr7Var = this.f;
                        if (nr7Var != null) {
                            nr7Var.h(mr8Var.a, mr8Var.g());
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
                        hr8.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(mr8Var.n()) && !StringUtils.isNull(mr8Var.d())) {
                                i4 = mr8Var.n();
                                h = mr8Var.d();
                            } else if (StringUtils.isNull(mr8Var.h()) && StringUtils.isNull(mr8Var.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(mr8Var.f(), mr8Var.g(), str, str2, mr8Var.p(), mr8Var.o());
                                postWriteCallBackData.setThreadId(mr8Var.s());
                                postWriteCallBackData.setPostId(mr8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(mr8Var.l());
                                postWriteCallBackData.setErrorString(mr8Var.g());
                                postWriteCallBackData.setActivityDialog(mr8Var.a());
                                postWriteCallBackData.setVideoid(mr8Var.v());
                                postWriteCallBackData.setInviteesNumber(mr8Var.k());
                                postWriteCallBackData.setContriInfo(mr8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(mr8Var.u());
                                postWriteCallBackData.setmAdverSegmentData(mr8Var.b());
                                postWriteCallBackData.setIconStampData(mr8Var.j());
                                postWriteCallBackData.setToast(mr8Var.t());
                                b35 b35Var = new b35();
                                b35Var.f(this.c);
                                if (this.g.b == null && gr8.k().i() != null && !z2) {
                                    gr8.k().C(this.g.b.getForumId());
                                    gr8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, gr8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    gr8.k().z(false);
                                } else if (this.g.b == null && this.g.h) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.i) {
                                    gr8.k().C(this.g.b.getForumId());
                                    gr8.k().D(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog == null && mr8Var.j() == null) {
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
                                            ah.a().postDelayed(new c(this, activityDialog), 1000L);
                                        }
                                    }
                                    ah.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, b35Var, this.g.b, mr8Var.c());
                            } else {
                                i4 = mr8Var.i();
                                h = mr8Var.h();
                            }
                            str = i4;
                            str2 = h;
                            postWriteCallBackData = new PostWriteCallBackData(mr8Var.f(), mr8Var.g(), str, str2, mr8Var.p(), mr8Var.o());
                            postWriteCallBackData.setThreadId(mr8Var.s());
                            postWriteCallBackData.setPostId(mr8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(mr8Var.l());
                            postWriteCallBackData.setErrorString(mr8Var.g());
                            postWriteCallBackData.setActivityDialog(mr8Var.a());
                            postWriteCallBackData.setVideoid(mr8Var.v());
                            postWriteCallBackData.setInviteesNumber(mr8Var.k());
                            postWriteCallBackData.setContriInfo(mr8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(mr8Var.u());
                            postWriteCallBackData.setmAdverSegmentData(mr8Var.b());
                            postWriteCallBackData.setIconStampData(mr8Var.j());
                            postWriteCallBackData.setToast(mr8Var.t());
                            b35 b35Var2 = new b35();
                            b35Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                gr8.k().C(this.g.b.getForumId());
                                gr8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog == null) {
                            }
                            this.g.c.callback(true, postWriteCallBackData, b35Var2, this.g.b, mr8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (mr8Var.j() == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z3)));
                        }
                        nr7 nr7Var2 = this.f;
                        if (nr7Var2 != null) {
                            nr7Var2.c();
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757, null));
                        }
                    }
                    hr8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                hr8.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, jv4Var};
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
            this.a = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.a.dismiss();
                this.b.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, jv4Var};
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
            this.a = jv4Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
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
    public class c extends pq8.c {
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

        @Override // com.baidu.tieba.pq8.c
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

        @Override // com.baidu.tieba.pq8.c
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

        @Override // com.baidu.tieba.pq8.c
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

        @Override // com.baidu.tieba.pq8.c
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

    public final void U(mr8 mr8Var) {
        r9<?> r9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, mr8Var) == null) && (r9Var = this.e) != null && mr8Var != null && !(this.c instanceof gr8)) {
            lw8.e(r9Var.getPageActivity(), mr8Var.g());
            mr8Var.G(null);
        }
    }

    public final void W(mr8 mr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mr8Var) == null) {
            X(mr8Var, null, null, this.b);
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

    public void c0(@Nullable r9<?> r9Var) {
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
            hr8.a("发帖：开始上传");
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
            if (writeData3 != null && writeData3.isNewWritePage()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param2.param(TiebaStatic.Params.OBJ_PARAM3, i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            cr4.d(AlbumActivityConfig.FROM_WRITE);
            cr4.b(AlbumActivityConfig.FROM_WRITE, "start");
            if (this.a == null) {
                if (gr8.k().i() != null && (writeData = this.b) != null && !writeData.isNotFakePost()) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, S());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, gr8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.j == null) {
                    this.j = new pp8(this.e);
                }
                this.a = new e(this);
                hr8.a("dealPost()");
                fr8.l(this.b);
                this.a.execute(new Integer[0]);
            }
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
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !py4.k().h("original_img_up_tip", false)) {
                py4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                r9<?> r9Var = this.e;
                if (r9Var == null) {
                    R();
                    return true;
                }
                jv4 jv4Var = new jv4(r9Var.getPageActivity());
                jv4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d59);
                jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f026b, new a(this, jv4Var));
                jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this, jv4Var));
                jv4Var.create(this.e);
                jv4Var.show();
            } else {
                R();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V(mr8 mr8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mr8Var) == null) && this.e != null && mr8Var != null && mr8Var.c() != null && mr8Var.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), mr8Var.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void X(mr8 mr8Var, AccessState accessState, b35 b35Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048583, this, mr8Var, accessState, b35Var, writeData) == null) && mr8Var != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(mr8Var.f(), mr8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(mr8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(mr8Var.q());
            this.c.callback(false, postWriteCallBackData, b35Var, writeData, mr8Var.c());
        }
    }
}
