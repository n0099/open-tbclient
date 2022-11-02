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
import com.baidu.tieba.aw8;
import com.baidu.tieba.br4;
import com.baidu.tieba.br8;
import com.baidu.tieba.cr7;
import com.baidu.tieba.cr8;
import com.baidu.tieba.cw7;
import com.baidu.tieba.dh;
import com.baidu.tieba.dp8;
import com.baidu.tieba.ep8;
import com.baidu.tieba.eq8;
import com.baidu.tieba.f95;
import com.baidu.tieba.gr7;
import com.baidu.tieba.iv4;
import com.baidu.tieba.iy7;
import com.baidu.tieba.ky4;
import com.baidu.tieba.lu4;
import com.baidu.tieba.ly7;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.r9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.uq8;
import com.baidu.tieba.vq8;
import com.baidu.tieba.w25;
import com.baidu.tieba.wi;
import com.baidu.tieba.wq8;
import com.baidu.tieba.y45;
import com.baidu.tieba.zg;
import com.baidu.tieba.zx4;
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
    public ep8 j;
    public eq8.c k;

    /* loaded from: classes6.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w25 w25Var, WriteData writeData, AntiData antiData);
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
    public class e extends BdAsyncTask<Integer, Integer, cr8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dp8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public gr7 e;
        public cr7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes6.dex */
        public class a implements ep8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0424a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cr8 a;
                public final /* synthetic */ a b;

                public RunnableC0424a(a aVar, cr8 cr8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, cr8Var};
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
                    this.a = cr8Var;
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

            @Override // com.baidu.tieba.ep8.e
            public void a(cr8 cr8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr8Var) == null) {
                    dh.b(new RunnableC0424a(this, cr8Var));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ep8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes6.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cr8 a;
                public final /* synthetic */ b b;

                public a(b bVar, cr8 cr8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, cr8Var};
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
                    this.a = cr8Var;
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

            @Override // com.baidu.tieba.ep8.e
            public void a(cr8 cr8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr8Var) == null) {
                    dh.b(new a(this, cr8Var));
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
                ly7 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = iy7.a((TbPageContext) this.b.g.e, this.a)) != null) {
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, gr7.class);
            if (runTask != null) {
                this.e = (gr7) runTask.getData();
            }
            gr7 gr7Var = this.e;
            if (gr7Var != null) {
                this.f = gr7Var.get();
            }
            setPriority(3);
            wq8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public cr8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                br4.b(AlbumActivityConfig.FROM_WRITE, "task");
                if (this.d) {
                    return null;
                }
                f95.e(this.g.b.getContent());
                wq8.a("doInBackground() start");
                wq8.a("发帖：任务后台执行 开始 doInBackground");
                dp8 dp8Var = new dp8();
                this.a = dp8Var;
                dp8Var.l(this.g.f);
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
                    br4.b(AlbumActivityConfig.FROM_WRITE, "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    cr8 cr8Var = new cr8();
                    if (this.a.i()) {
                        cr8Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        cr8Var.f(errorData.getError_code());
                        cr8Var.h(errorData.getError_msg());
                        cr8Var.g(errorData.getError_data());
                    } else {
                        cr8Var.i(true);
                        cr8Var.f(this.a.f());
                        cr8Var.h(this.a.h());
                    }
                    cr8Var.j(this.c);
                    return cr8Var;
                }
            }
            return (cr8) invokeL.objValue;
        }

        public final void c(br8 br8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, br8Var) != null) || eq8.a(br8Var.f(), AuthTokenData.parse(this.c), this.g.k)) {
                return;
            }
            if (!br8Var.y()) {
                if (!br8Var.B()) {
                    if (!aw8.d(br8Var.f())) {
                        if (br8Var.z()) {
                            w25 w25Var = new w25();
                            w25Var.f(this.c);
                            if (w25Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(w25Var.b());
                                this.g.b.setVcodeUrl(w25Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.X(br8Var, null, w25Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (br8Var.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.X(br8Var, accessState, null, newWriteModel2.b);
                            return;
                        } else if (br8Var.A()) {
                            this.g.W(br8Var);
                            return;
                        } else {
                            this.g.W(br8Var);
                            return;
                        }
                    }
                    this.g.U(br8Var);
                    this.g.W(br8Var);
                    return;
                }
                this.g.V(br8Var);
                this.g.W(br8Var);
                return;
            }
            this.g.W(br8Var);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                dp8 dp8Var = this.a;
                if (dp8Var != null) {
                    dp8Var.d();
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
        public void onPostExecute(cr8 cr8Var) {
            int i;
            int i2;
            int i3;
            br8 br8Var;
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
            y45 y45Var;
            VideoEasterEggData videoEasterEggData2;
            int i6;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            y45 y45Var2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cr8Var) == null) {
                super.onPostExecute(cr8Var);
                if (cr8Var == null) {
                    return;
                }
                this.c = cr8Var.d();
                this.a.k(this.g.b, cr8Var);
                wq8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                uq8.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!cr8Var.e() && this.c != null) {
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
                if (!cr8Var.e() && this.c != null) {
                    wq8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (wi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f115f);
                    }
                    br8Var = new br8(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !br8Var.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    wq8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    br8Var = new br8(g.getError_code(), g.getError_msg(), null);
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
                                br8Var.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    wq8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    br8Var = new br8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        lu4 lu4Var = new lu4();
                        lu4Var.a = optJSONObject.optString("block_content");
                        lu4Var.b = optJSONObject.optString("block_cancel");
                        lu4Var.c = optJSONObject.optString("block_confirm");
                        br8Var.Q(lu4Var);
                    }
                    wq8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0289);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    br8Var = new br8(g.getError_code(), error_msg2, this.a.e());
                    wq8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    br8Var = new br8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c7f), null);
                    wq8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (br8Var.w()) {
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
                        y45Var = null;
                    } else {
                        String optString = jSONObject3.optString("msg");
                        String optString2 = jSONObject3.optString("pre_msg");
                        String optString3 = jSONObject3.optString("color_msg");
                        String optString4 = jSONObject3.optString("tid");
                        String optString5 = jSONObject3.optString("pid");
                        String optString6 = jSONObject3.optString("video_id");
                        String optString7 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = cw7.a(jSONObject3);
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
                            y45Var2 = new y45();
                            y45Var2.p(optJSONObject6);
                        } else {
                            y45Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        y45 y45Var3 = y45Var2;
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
                            br8Var.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str7 = optString6;
                        str9 = optString7;
                        str3 = optString4;
                        str6 = optString5;
                        customDialogData = a2;
                        str4 = str18;
                        y45Var = y45Var3;
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
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f115f);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    br8Var.G(str11);
                    br8Var.N(str13);
                    br8Var.E(str8);
                    br8Var.P(str10);
                    br8Var.O(str4);
                    br8Var.S(str3);
                    br8Var.M(str6);
                    br8Var.L(i5);
                    br8Var.I(str12);
                    br8Var.H(str5);
                    br8Var.C(customDialogData);
                    br8Var.V(str7);
                    br8Var.K(str9);
                    br8Var.F(contriInfo);
                    br8Var.U(videoEasterEggData2);
                    br8Var.D(y45Var);
                    br8Var.J(iconStampData);
                }
                br4.b(AlbumActivityConfig.FROM_WRITE, "result*" + cr8Var.e());
                br4.b(AlbumActivityConfig.FROM_WRITE, "code*" + br8Var.f() + " " + br8Var.g());
                br4.e(AlbumActivityConfig.FROM_WRITE);
                wq8.a("doInBackground end");
                wq8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                wq8.a("onPostExecute start");
                wq8.a("发帖： onPostExecute");
                this.g.a = null;
                if (br8Var.f() != 0) {
                    zx4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", br8Var.f(), br8Var.g(), obj2, br8Var.s(), obj, br8Var.m());
                }
                if (!this.d) {
                    if (br8Var.w()) {
                        wq8.a("onPostExecute error");
                        c(br8Var);
                        cr7 cr7Var = this.f;
                        if (cr7Var != null) {
                            cr7Var.h(br8Var.a, br8Var.g());
                        }
                    } else {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        wq8.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(br8Var.n()) && !StringUtils.isNull(br8Var.d())) {
                                i4 = br8Var.n();
                                h = br8Var.d();
                            } else if (StringUtils.isNull(br8Var.h()) && StringUtils.isNull(br8Var.i())) {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(br8Var.f(), br8Var.g(), str, str2, br8Var.p(), br8Var.o());
                                postWriteCallBackData.setThreadId(br8Var.s());
                                postWriteCallBackData.setPostId(br8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(br8Var.l());
                                postWriteCallBackData.setErrorString(br8Var.g());
                                postWriteCallBackData.setActivityDialog(br8Var.a());
                                postWriteCallBackData.setVideoid(br8Var.v());
                                postWriteCallBackData.setInviteesNumber(br8Var.k());
                                postWriteCallBackData.setContriInfo(br8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(br8Var.u());
                                postWriteCallBackData.setmAdverSegmentData(br8Var.b());
                                postWriteCallBackData.setIconStampData(br8Var.j());
                                postWriteCallBackData.setToast(br8Var.t());
                                w25 w25Var = new w25();
                                w25Var.f(this.c);
                                if (this.g.b == null && vq8.k().i() != null) {
                                    vq8.k().C(this.g.b.getForumId());
                                    vq8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, vq8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    vq8.k().z(false);
                                } else if (this.g.b == null && this.g.h) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.i) {
                                    vq8.k().C(this.g.b.getForumId());
                                    vq8.k().D(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog == null && br8Var.j() == null) {
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
                                            zg.a().postDelayed(new c(this, activityDialog), 1000L);
                                        }
                                    }
                                    zg.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, w25Var, this.g.b, br8Var.c());
                            } else {
                                i4 = br8Var.i();
                                h = br8Var.h();
                            }
                            str2 = h;
                            str = i4;
                            postWriteCallBackData = new PostWriteCallBackData(br8Var.f(), br8Var.g(), str, str2, br8Var.p(), br8Var.o());
                            postWriteCallBackData.setThreadId(br8Var.s());
                            postWriteCallBackData.setPostId(br8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(br8Var.l());
                            postWriteCallBackData.setErrorString(br8Var.g());
                            postWriteCallBackData.setActivityDialog(br8Var.a());
                            postWriteCallBackData.setVideoid(br8Var.v());
                            postWriteCallBackData.setInviteesNumber(br8Var.k());
                            postWriteCallBackData.setContriInfo(br8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(br8Var.u());
                            postWriteCallBackData.setmAdverSegmentData(br8Var.b());
                            postWriteCallBackData.setIconStampData(br8Var.j());
                            postWriteCallBackData.setToast(br8Var.t());
                            w25 w25Var2 = new w25();
                            w25Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                vq8.k().C(this.g.b.getForumId());
                                vq8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog == null) {
                            }
                            this.g.c.callback(true, postWriteCallBackData, w25Var2, this.g.b, br8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (br8Var.j() == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z)));
                        }
                        cr7 cr7Var2 = this.f;
                        if (cr7Var2 != null) {
                            cr7Var2.c();
                        }
                    }
                    wq8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                wq8.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, iv4Var};
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
            this.a = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.a.dismiss();
                this.b.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, iv4Var};
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
            this.a = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
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
    public class c extends eq8.c {
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

        @Override // com.baidu.tieba.eq8.c
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

        @Override // com.baidu.tieba.eq8.c
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

        @Override // com.baidu.tieba.eq8.c
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

        @Override // com.baidu.tieba.eq8.c
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

    public final void U(br8 br8Var) {
        r9<?> r9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, br8Var) == null) && (r9Var = this.e) != null && br8Var != null && !(this.c instanceof vq8)) {
            aw8.e(r9Var.getPageActivity(), br8Var.g());
            br8Var.G(null);
        }
    }

    public final void W(br8 br8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, br8Var) == null) {
            X(br8Var, null, null, this.b);
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
            wq8.a("发帖：开始上传");
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
            br4.d(AlbumActivityConfig.FROM_WRITE);
            br4.b(AlbumActivityConfig.FROM_WRITE, "start");
            if (this.a == null) {
                if (vq8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, S());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, vq8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.j == null) {
                    this.j = new ep8(this.e);
                }
                this.a = new e(this);
                wq8.a("dealPost()");
                uq8.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public final void V(br8 br8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, br8Var) == null) && this.e != null && br8Var != null && br8Var.c() != null && br8Var.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), br8Var.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void X(br8 br8Var, AccessState accessState, w25 w25Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048583, this, br8Var, accessState, w25Var, writeData) == null) && br8Var != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(br8Var.f(), br8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(br8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(br8Var.q());
            this.c.callback(false, postWriteCallBackData, w25Var, writeData, br8Var.c());
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
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !ky4.k().h("original_img_up_tip", false)) {
                ky4.k().u("original_img_up_tip", true);
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
                iv4 iv4Var = new iv4(r9Var.getPageActivity());
                iv4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d57);
                iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f026b, new a(this, iv4Var));
                iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this, iv4Var));
                iv4Var.create(this.e);
                iv4Var.show();
            } else {
                R();
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
