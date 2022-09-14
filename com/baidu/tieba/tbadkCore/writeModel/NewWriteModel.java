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
import com.baidu.tieba.au4;
import com.baidu.tieba.aw7;
import com.baidu.tieba.bx4;
import com.baidu.tieba.dj;
import com.baidu.tieba.gh;
import com.baidu.tieba.gt4;
import com.baidu.tieba.kh;
import com.baidu.tieba.l15;
import com.baidu.tieba.m35;
import com.baidu.tieba.oo8;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.po8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.qw4;
import com.baidu.tieba.r9;
import com.baidu.tieba.st8;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.uo7;
import com.baidu.tieba.ut7;
import com.baidu.tieba.v75;
import com.baidu.tieba.vo8;
import com.baidu.tieba.vp4;
import com.baidu.tieba.wo8;
import com.baidu.tieba.ym8;
import com.baidu.tieba.yn8;
import com.baidu.tieba.yo7;
import com.baidu.tieba.zm8;
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
    public r9<?> e;
    public SpanGroupManager f;
    public String g;
    public boolean h;
    public boolean i;
    public zm8 j;
    public yn8.c k;

    /* loaded from: classes5.dex */
    public class a implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, au4Var};
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
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.dismiss();
                this.b.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, au4Var};
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
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends yn8.c {
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

        @Override // com.baidu.tieba.yn8.c
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

        @Override // com.baidu.tieba.yn8.c
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

        @Override // com.baidu.tieba.yn8.c
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

        @Override // com.baidu.tieba.yn8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.a = null;
                    this.a.b.setAuthSid(null);
                    this.a.e0();
                } else if (this.a.c != null) {
                    this.a.c.callback(false, null, null, this.a.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<Integer, Integer, wo8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ym8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public yo7 e;
        public uo7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes5.dex */
        public class a implements zm8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0420a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ wo8 a;
                public final /* synthetic */ a b;

                public RunnableC0420a(a aVar, wo8 wo8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, wo8Var};
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
                    this.a = wo8Var;
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

            @Override // com.baidu.tieba.zm8.e
            public void a(wo8 wo8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wo8Var) == null) {
                    kh.b(new RunnableC0420a(this, wo8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements zm8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ wo8 a;
                public final /* synthetic */ b b;

                public a(b bVar, wo8 wo8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, wo8Var};
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
                    this.a = wo8Var;
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

            @Override // com.baidu.tieba.zm8.e
            public void a(wo8 wo8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wo8Var) == null) {
                    kh.b(new a(this, wo8Var));
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
                    aw7.a((TbPageContext) this.b.g.e, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, yo7.class);
            if (runTask != null) {
                this.e = (yo7) runTask.getData();
            }
            yo7 yo7Var = this.e;
            if (yo7Var != null) {
                this.f = yo7Var.get();
            }
            setPriority(3);
            qo8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public wo8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                vp4.b(AlbumActivityConfig.FROM_WRITE, "task");
                if (this.d) {
                    return null;
                }
                v75.e(this.g.b.getContent());
                qo8.a("doInBackground() start");
                qo8.a("发帖：任务后台执行 开始 doInBackground");
                ym8 ym8Var = new ym8();
                this.a = ym8Var;
                ym8Var.l(this.g.f);
                this.a.m(this.g.g);
                this.a.n(this.f);
                if (!this.a.p(this.g.b)) {
                    if (!this.a.o(this.g.b)) {
                        this.b = this.a.j(this.g.b, this.g.d);
                        vp4.b(AlbumActivityConfig.FROM_WRITE, "jsonRES");
                        try {
                            if (this.b != null) {
                                this.c = new JSONObject(this.b);
                            }
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        wo8 wo8Var = new wo8();
                        if (this.a.i()) {
                            wo8Var.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.c);
                            wo8Var.f(errorData.getError_code());
                            wo8Var.h(errorData.getError_msg());
                            wo8Var.g(errorData.getError_data());
                        } else {
                            wo8Var.i(true);
                            wo8Var.f(this.a.f());
                            wo8Var.h(this.a.h());
                        }
                        wo8Var.j(this.c);
                        return wo8Var;
                    }
                    this.b = this.a.a(this.g.j, this.g.b, this.g.d, new b(this));
                    return null;
                }
                this.b = this.a.b(this.g.j, this.g.b, this.g.d, new a(this));
                return null;
            }
            return (wo8) invokeL.objValue;
        }

        public final void c(vo8 vo8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vo8Var) == null) || yn8.a(vo8Var.f(), AuthTokenData.parse(this.c), this.g.k)) {
                return;
            }
            if (vo8Var.y()) {
                this.g.W(vo8Var);
            } else if (vo8Var.B()) {
                this.g.V(vo8Var);
                this.g.W(vo8Var);
            } else if (st8.d(vo8Var.f())) {
                this.g.U(vo8Var);
                this.g.W(vo8Var);
            } else if (vo8Var.z()) {
                l15 l15Var = new l15();
                l15Var.f(this.c);
                if (l15Var.c() == null || this.g.b == null) {
                    return;
                }
                this.g.b.setVcodeMD5(l15Var.b());
                this.g.b.setVcodeUrl(l15Var.c());
                NewWriteModel newWriteModel = this.g;
                newWriteModel.X(vo8Var, null, l15Var, newWriteModel.b);
            } else if (vo8Var.x()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.c);
                NewWriteModel newWriteModel2 = this.g;
                newWriteModel2.X(vo8Var, accessState, null, newWriteModel2.b);
            } else if (vo8Var.A()) {
                this.g.W(vo8Var);
            } else {
                this.g.W(vo8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                ym8 ym8Var = this.a;
                if (ym8Var != null) {
                    ym8Var.d();
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
        public void onPostExecute(wo8 wo8Var) {
            vo8 vo8Var;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            String i;
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
            int i2;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            IconStampData iconStampData;
            m35 m35Var;
            VideoEasterEggData videoEasterEggData2;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            m35 m35Var2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wo8Var) == null) {
                super.onPostExecute(wo8Var);
                if (wo8Var == null) {
                    return;
                }
                this.c = wo8Var.d();
                this.a.k(this.g.b, wo8Var);
                qo8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                oo8.c(this.g.b, g);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code()).param("obj_locate", (wo8Var.e() || this.c == null) ? 19 : 18).param("obj_type", this.g.b != null ? this.g.b.getType() : -1).param(TiebaStatic.Params.OBJ_PARAM3, (this.g.b == null || !this.g.b.isNewWritePage()) ? 0 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!wo8Var.e() && this.c != null) {
                    qo8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (dj.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1130);
                    }
                    vo8Var = new vo8(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !vo8Var.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    qo8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    vo8Var = new vo8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i3 = 0; i3 < length; i3++) {
                                    arrayList.add(jSONArray.optString(i3));
                                }
                                vo8Var.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    qo8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    vo8Var = new vo8(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        gt4 gt4Var = new gt4();
                        gt4Var.a = optJSONObject.optString("block_content");
                        gt4Var.b = optJSONObject.optString("block_cancel");
                        gt4Var.c = optJSONObject.optString("block_confirm");
                        vo8Var.Q(gt4Var);
                    }
                    qo8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0288);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    vo8Var = new vo8(g.getError_code(), error_msg2, this.a.e());
                    qo8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    vo8Var = new vo8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c59), null);
                    qo8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (vo8Var.w()) {
                    obj = "pid";
                    obj2 = "tid";
                } else {
                    ContriInfo contriInfo = new ContriInfo();
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 != null) {
                        String optString = jSONObject3.optString("msg");
                        String optString2 = jSONObject3.optString("pre_msg");
                        String optString3 = jSONObject3.optString("color_msg");
                        String optString4 = jSONObject3.optString("tid");
                        String optString5 = jSONObject3.optString("pid");
                        String optString6 = jSONObject3.optString("video_id");
                        String optString7 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = ut7.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        int optInt = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
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
                            m35Var2 = new m35();
                            m35Var2.p(optJSONObject6);
                        } else {
                            m35Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        m35 m35Var3 = m35Var2;
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
                            vo8Var.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str7 = optString6;
                        str9 = optString7;
                        str3 = optString4;
                        str6 = optString5;
                        customDialogData = a2;
                        str4 = str18;
                        m35Var = m35Var3;
                        iconStampData = iconStampData3;
                        obj2 = "tid";
                        str8 = optString3;
                        obj = "pid";
                        str5 = str17;
                        str13 = optString2;
                        str12 = str16;
                        str11 = optString;
                        str10 = str15;
                        i2 = optInt;
                        videoEasterEggData = videoEasterEggData4;
                    } else {
                        obj = "pid";
                        obj2 = "tid";
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        videoEasterEggData = null;
                        customDialogData = null;
                        str6 = null;
                        i2 = 0;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        iconStampData = null;
                        m35Var = null;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1130);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    vo8Var.G(str11);
                    vo8Var.N(str13);
                    vo8Var.E(str8);
                    vo8Var.P(str10);
                    vo8Var.O(str4);
                    vo8Var.S(str3);
                    vo8Var.M(str6);
                    vo8Var.L(i2);
                    vo8Var.I(str12);
                    vo8Var.H(str5);
                    vo8Var.C(customDialogData);
                    vo8Var.V(str7);
                    vo8Var.K(str9);
                    vo8Var.F(contriInfo);
                    vo8Var.U(videoEasterEggData2);
                    vo8Var.D(m35Var);
                    vo8Var.J(iconStampData);
                }
                vp4.b(AlbumActivityConfig.FROM_WRITE, "result*" + wo8Var.e());
                vp4.b(AlbumActivityConfig.FROM_WRITE, "code*" + vo8Var.f() + " " + vo8Var.g());
                vp4.e(AlbumActivityConfig.FROM_WRITE);
                qo8.a("doInBackground end");
                qo8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                qo8.a("onPostExecute start");
                qo8.a("发帖： onPostExecute");
                this.g.a = null;
                if (vo8Var.f() != 0) {
                    qw4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", vo8Var.f(), vo8Var.g(), obj2, vo8Var.s(), obj, vo8Var.m());
                }
                if (!this.d) {
                    if (!vo8Var.w()) {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        qo8.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(vo8Var.n()) && !StringUtils.isNull(vo8Var.d())) {
                                i = vo8Var.n();
                                h = vo8Var.d();
                            } else if (!StringUtils.isNull(vo8Var.h()) || !StringUtils.isNull(vo8Var.i())) {
                                i = vo8Var.i();
                                h = vo8Var.h();
                            } else {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(vo8Var.f(), vo8Var.g(), str, str2, vo8Var.p(), vo8Var.o());
                                postWriteCallBackData.setThreadId(vo8Var.s());
                                postWriteCallBackData.setPostId(vo8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(vo8Var.l());
                                postWriteCallBackData.setErrorString(vo8Var.g());
                                postWriteCallBackData.setActivityDialog(vo8Var.a());
                                postWriteCallBackData.setVideoid(vo8Var.v());
                                postWriteCallBackData.setInviteesNumber(vo8Var.k());
                                postWriteCallBackData.setContriInfo(vo8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(vo8Var.u());
                                postWriteCallBackData.setmAdverSegmentData(vo8Var.b());
                                postWriteCallBackData.setIconStampData(vo8Var.j());
                                postWriteCallBackData.setToast(vo8Var.t());
                                l15 l15Var = new l15();
                                l15Var.f(this.c);
                                if (this.g.b != null || po8.k().i() == null) {
                                    if (this.g.b != null || !this.g.h) {
                                        if (this.g.b != null && this.g.i) {
                                            po8.k().C(this.g.b.getForumId());
                                            po8.k().D(this.g.b.getForumName());
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                        }
                                    } else {
                                        if (this.g.b.getVideoInfo() != null) {
                                            postWriteCallBackData.writeDataForVideo = this.g.b;
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                    }
                                } else {
                                    po8.k().C(this.g.b.getForumId());
                                    po8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, po8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    po8.k().z(false);
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog == null && vo8Var.j() == null) {
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
                                            gh.a().postDelayed(new c(this, activityDialog), 1000L);
                                        }
                                    }
                                    gh.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, l15Var, this.g.b, vo8Var.c());
                            }
                            str2 = h;
                            str = i;
                            postWriteCallBackData = new PostWriteCallBackData(vo8Var.f(), vo8Var.g(), str, str2, vo8Var.p(), vo8Var.o());
                            postWriteCallBackData.setThreadId(vo8Var.s());
                            postWriteCallBackData.setPostId(vo8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(vo8Var.l());
                            postWriteCallBackData.setErrorString(vo8Var.g());
                            postWriteCallBackData.setActivityDialog(vo8Var.a());
                            postWriteCallBackData.setVideoid(vo8Var.v());
                            postWriteCallBackData.setInviteesNumber(vo8Var.k());
                            postWriteCallBackData.setContriInfo(vo8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(vo8Var.u());
                            postWriteCallBackData.setmAdverSegmentData(vo8Var.b());
                            postWriteCallBackData.setIconStampData(vo8Var.j());
                            postWriteCallBackData.setToast(vo8Var.t());
                            l15 l15Var2 = new l15();
                            l15Var2.f(this.c);
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                                po8.k().C(this.g.b.getForumId());
                                po8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog == null) {
                            }
                            this.g.c.callback(true, postWriteCallBackData, l15Var2, this.g.b, vo8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(vo8Var.j() == null)));
                        }
                        uo7 uo7Var = this.f;
                        if (uo7Var != null) {
                            uo7Var.c();
                        }
                    } else {
                        qo8.a("onPostExecute error");
                        c(vo8Var);
                        uo7 uo7Var2 = this.f;
                        if (uo7Var2 != null) {
                            uo7Var2.h(vo8Var.a, vo8Var.g());
                        }
                    }
                    qo8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                qo8.a("发帖： onPostExecute isCanceled");
            }
        }
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

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.b;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.b.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData = this.b;
            StatisticItem param2 = param.param("obj_type", writeData != null ? writeData.getType() : -1);
            WriteData writeData2 = this.b;
            TiebaStatic.log(param2.param(TiebaStatic.Params.OBJ_PARAM3, (writeData2 == null || !writeData2.isNewWritePage()) ? 0 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            vp4.d(AlbumActivityConfig.FROM_WRITE);
            vp4.b(AlbumActivityConfig.FROM_WRITE, "start");
            if (this.a == null) {
                if (po8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, S());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, po8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.j == null) {
                    this.j = new zm8(this.e);
                }
                this.a = new e(this);
                qo8.a("dealPost()");
                oo8.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public WriteData S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (WriteData) invokeV.objValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpanGroupManager spanGroupManager = this.f;
            if (spanGroupManager != null) {
                this.g = spanGroupManager.G();
            } else {
                this.g = null;
            }
        }
    }

    public final void U(vo8 vo8Var) {
        r9<?> r9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, vo8Var) == null) || (r9Var = this.e) == null || vo8Var == null || (this.c instanceof po8)) {
            return;
        }
        st8.e(r9Var.getPageActivity(), vo8Var.g());
        vo8Var.G(null);
    }

    public final void V(vo8 vo8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vo8Var) == null) || this.e == null || vo8Var == null || vo8Var.c() == null || vo8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.e.getPageActivity(), vo8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void W(vo8 vo8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vo8Var) == null) {
            X(vo8Var, null, null, this.b);
        }
    }

    public final void X(vo8 vo8Var, AccessState accessState, l15 l15Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, vo8Var, accessState, l15Var, writeData) == null) || vo8Var == null || this.c == null) {
            return;
        }
        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(vo8Var.f(), vo8Var.g(), null, null);
        postWriteCallBackData.setAccessState(accessState);
        postWriteCallBackData.setSensitiveWords(vo8Var.r());
        postWriteCallBackData.setReplyPrivacyTip(vo8Var.q());
        this.c.callback(false, postWriteCallBackData, l15Var, writeData, vo8Var.c());
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
            if (eVar == null || eVar.isCancelled()) {
                return false;
            }
            this.a.cancel();
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
            qo8.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            R();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !bx4.k().h("original_img_up_tip", false)) {
                bx4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                r9<?> r9Var = this.e;
                if (r9Var == null) {
                    R();
                    return true;
                }
                au4 au4Var = new au4(r9Var.getPageActivity());
                au4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d2f);
                au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new a(this, au4Var));
                au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this, au4Var));
                au4Var.create(this.e);
                au4Var.show();
            } else {
                R();
            }
            return true;
        }
        return invokeV.booleanValue;
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
}
