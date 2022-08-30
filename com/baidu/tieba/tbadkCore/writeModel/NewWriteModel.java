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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
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
import com.baidu.tieba.cn8;
import com.baidu.tieba.cr4;
import com.baidu.tieba.d9;
import com.baidu.tieba.dn8;
import com.baidu.tieba.ds8;
import com.baidu.tieba.dz4;
import com.baidu.tieba.en8;
import com.baidu.tieba.f15;
import com.baidu.tieba.iu4;
import com.baidu.tieba.jn8;
import com.baidu.tieba.kn8;
import com.baidu.tieba.ml8;
import com.baidu.tieba.mm8;
import com.baidu.tieba.mn7;
import com.baidu.tieba.ms7;
import com.baidu.tieba.nl8;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pi;
import com.baidu.tieba.qi;
import com.baidu.tieba.qn7;
import com.baidu.tieba.ru7;
import com.baidu.tieba.sg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tu4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wr4;
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
    public f a;
    public WriteData b;
    public d c;
    public e d;
    public boolean e;
    public d9<?> f;
    public ml8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public nl8 l;
    public mm8.c m;

    /* loaded from: classes5.dex */
    public class a implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.dismiss();
                this.b.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends mm8.c {
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

        @Override // com.baidu.tieba.mm8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.d != null) {
                        this.a.d.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.g0();
            }
        }

        @Override // com.baidu.tieba.mm8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.d != null) {
                        this.a.d.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.g0();
            }
        }

        @Override // com.baidu.tieba.mm8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.b != null) {
                    this.a.b.setAuthSid(null);
                }
                if (this.a.d != null) {
                    this.a.d.callback(false, null, null, this.a.b, null);
                }
            }
        }

        @Override // com.baidu.tieba.mm8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.a = null;
                    this.a.b.setAuthSid(null);
                    this.a.g0();
                } else if (this.a.d != null) {
                    this.a.d.callback(false, null, null, this.a.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z, String str, dz4 dz4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, dz4 dz4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Integer, Integer, kn8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ml8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public qn7 e;
        public mn7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes5.dex */
        public class a implements nl8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0407a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ kn8 a;
                public final /* synthetic */ a b;

                public RunnableC0407a(a aVar, kn8 kn8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, kn8Var};
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
                    this.a = kn8Var;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

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

            @Override // com.baidu.tieba.nl8.e
            public void a(kn8 kn8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, kn8Var) == null) {
                    wg.b(new RunnableC0407a(this, kn8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements nl8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ kn8 a;
                public final /* synthetic */ b b;

                public a(b bVar, kn8 kn8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, kn8Var};
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
                    this.a = kn8Var;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

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

            @Override // com.baidu.tieba.nl8.e
            public void a(kn8 kn8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, kn8Var) == null) {
                    wg.b(new a(this, kn8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
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
                    ru7.a((TbPageContext) this.b.g.f, this.a).show();
                }
            }
        }

        public f(NewWriteModel newWriteModel) {
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, qn7.class);
            if (runTask != null) {
                this.e = (qn7) runTask.getData();
            }
            qn7 qn7Var = this.e;
            if (qn7Var != null) {
                this.f = qn7Var.get();
            }
            setPriority(3);
            en8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public kn8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.d) {
                    return null;
                }
                p55.e(this.g.b.getContent());
                en8.a("doInBackground() start");
                en8.a("发帖：任务后台执行 开始 doInBackground");
                ml8 ml8Var = new ml8();
                this.a = ml8Var;
                ml8Var.o(this.g.h);
                this.a.p(this.g.i);
                this.a.q(this.f);
                this.a.n(this.g.g);
                if (!this.a.s(this.g.b)) {
                    if (!this.a.r(this.g.b)) {
                        String l = this.a.l(this.g.b, this.g.e);
                        this.b = l;
                        if (l != null) {
                            try {
                                this.c = new JSONObject(this.b);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                        }
                        kn8 kn8Var = new kn8();
                        if (this.a.j()) {
                            kn8Var.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.c);
                            kn8Var.f(errorData.getError_code());
                            kn8Var.h(errorData.getError_msg());
                            kn8Var.g(errorData.getError_data());
                        } else {
                            kn8Var.i(true);
                            kn8Var.f(this.a.g());
                            kn8Var.h(this.a.i());
                        }
                        kn8Var.j(this.c);
                        return kn8Var;
                    }
                    this.b = this.a.b(this.g.l, this.g.b, this.g.e, new b(this));
                    return null;
                }
                this.b = this.a.c(this.g.l, this.g.b, this.g.e, new a(this));
                return null;
            }
            return (kn8) invokeL.objValue;
        }

        public final void c(jn8 jn8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jn8Var) == null) || mm8.a(jn8Var.f(), AuthTokenData.parse(this.c), this.g.m)) {
                return;
            }
            if (jn8Var.x()) {
                this.g.Y(jn8Var);
            } else if (jn8Var.A()) {
                this.g.X(jn8Var);
                this.g.Y(jn8Var);
            } else if (ds8.d(jn8Var.f())) {
                this.g.W(jn8Var);
                this.g.Y(jn8Var);
            } else if (jn8Var.y()) {
                dz4 dz4Var = new dz4();
                dz4Var.f(this.c);
                if (dz4Var.c() == null || this.g.b == null) {
                    return;
                }
                this.g.b.setVcodeMD5(dz4Var.b());
                this.g.b.setVcodeUrl(dz4Var.c());
                NewWriteModel newWriteModel = this.g;
                newWriteModel.Z(jn8Var, null, dz4Var, newWriteModel.b);
            } else if (jn8Var.w()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.c);
                NewWriteModel newWriteModel2 = this.g;
                newWriteModel2.Z(jn8Var, accessState, null, newWriteModel2.b);
            } else if (jn8Var.z()) {
                this.g.Y(jn8Var);
            } else {
                this.g.Y(jn8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                ml8 ml8Var = this.a;
                if (ml8Var != null) {
                    ml8Var.e();
                }
                if (this.g.d != null) {
                    this.g.d.callback(false, null, null, this.g.b, null);
                } else if (this.g.c != null) {
                    this.g.c.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x05b7, code lost:
            if (r7 != 9) goto L103;
         */
        /* JADX WARN: Removed duplicated region for block: B:133:0x046e  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x05a2  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(kn8 kn8Var) {
            jn8 jn8Var;
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
            int i2;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            IconStampData iconStampData;
            f15 f15Var;
            VideoEasterEggData videoEasterEggData2;
            int i3;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            f15 f15Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, kn8Var) == null) {
                super.onPostExecute(kn8Var);
                if (kn8Var == null) {
                    return;
                }
                this.c = kn8Var.d();
                this.a.m(this.g.b, kn8Var);
                en8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData h2 = this.a.h();
                cn8.c(this.g.b, h2);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, h2.getError_code()).param("obj_locate", (kn8Var.e() || this.c == null) ? 19 : 18).param("obj_type", this.g.b != null ? this.g.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!kn8Var.e() && this.c != null) {
                    en8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData f = this.a.f();
                    String error_msg = h2.getError_msg();
                    if (qi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1113);
                    }
                    jn8Var = new jn8(h2.getError_code(), error_msg, f);
                    if (this.g.b != null && this.g.b.isHasImages() && !jn8Var.v()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    en8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (h2 != null && h2.error_code == 220015) {
                    jn8Var = new jn8(h2.getError_code(), h2.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i4 = 0; i4 < length; i4++) {
                                    arrayList.add(jSONArray.optString(i4));
                                }
                                jn8Var.Q(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    en8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (h2 != null && h2.error_code == 238010) {
                    jn8Var = new jn8(h2.getError_code(), h2.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        cr4 cr4Var = new cr4();
                        cr4Var.a = optJSONObject.optString("block_content");
                        cr4Var.b = optJSONObject.optString("block_cancel");
                        cr4Var.c = optJSONObject.optString("block_confirm");
                        jn8Var.P(cr4Var);
                    }
                    en8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (h2 != null && h2.error_code != 0) {
                    String error_msg2 = h2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (h2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0284);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1107);
                        }
                    }
                    jn8Var = new jn8(h2.getError_code(), error_msg2, this.a.f());
                    en8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    jn8Var = new jn8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c40), null);
                    en8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (jn8Var.v()) {
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
                        CustomDialogData a2 = ms7.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        int optInt = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str16 = optJSONObject4.optString("pre_msg");
                            str17 = optJSONObject4.optString("color_msg");
                            str15 = optJSONObject4.optString("question_msg");
                            i3 = optInt;
                            str14 = optJSONObject4.optString("question_exp");
                        } else {
                            i3 = optInt;
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
                            f15Var2 = new f15();
                            f15Var2.p(optJSONObject6);
                        } else {
                            f15Var2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        if (optJSONObject7 != null) {
                            IconStampData iconStampData2 = new IconStampData();
                            iconStampData2.parseJson(optJSONObject7);
                            str3 = optString4;
                            customDialogData = a2;
                            obj2 = "tid";
                            str13 = optString2;
                            str6 = optString3;
                            str10 = optString5;
                            obj = "pid";
                            str12 = str16;
                            str4 = str17;
                            str9 = optString7;
                            str11 = optString;
                            str8 = optString6;
                            i2 = i3;
                            f15Var = f15Var2;
                            iconStampData = iconStampData2;
                            str5 = str18;
                            str7 = str15;
                            videoEasterEggData = videoEasterEggData4;
                        } else {
                            str7 = str15;
                            str3 = optString4;
                            customDialogData = a2;
                            videoEasterEggData = videoEasterEggData4;
                            obj2 = "tid";
                            str13 = optString2;
                            str6 = optString3;
                            str10 = optString5;
                            obj = "pid";
                            str12 = str16;
                            str4 = str17;
                            str9 = optString7;
                            str11 = optString;
                            str8 = optString6;
                            i2 = i3;
                            iconStampData = null;
                            f15Var = f15Var2;
                            str5 = str18;
                        }
                    } else {
                        obj = "pid";
                        obj2 = "tid";
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        videoEasterEggData = null;
                        customDialogData = null;
                        i2 = 0;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        iconStampData = null;
                        f15Var = null;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1113);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    jn8Var.F(str11);
                    jn8Var.M(str13);
                    jn8Var.D(str6);
                    jn8Var.O(str7);
                    jn8Var.N(str5);
                    jn8Var.R(str3);
                    jn8Var.L(str10);
                    jn8Var.K(i2);
                    jn8Var.H(str12);
                    jn8Var.G(str4);
                    jn8Var.B(customDialogData);
                    jn8Var.T(str8);
                    jn8Var.J(str9);
                    jn8Var.E(contriInfo);
                    jn8Var.S(videoEasterEggData2);
                    jn8Var.C(f15Var);
                    jn8Var.I(iconStampData);
                }
                en8.a("doInBackground end");
                en8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                en8.a("onPostExecute start");
                en8.a("发帖： onPostExecute");
                this.g.a = null;
                if (jn8Var.f() != 0) {
                    iu4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", jn8Var.f(), jn8Var.g(), obj2, jn8Var.s(), obj, jn8Var.m());
                }
                if (!this.d) {
                    if (!jn8Var.v()) {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        en8.a("onPostExecute success");
                        if (this.g.d == null) {
                            if (this.g.c != null) {
                                this.g.c.a(true, jn8Var.g(), null, null, jn8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(jn8Var.n()) && !StringUtils.isNull(jn8Var.d())) {
                                i = jn8Var.n();
                                h = jn8Var.d();
                            } else if (!StringUtils.isNull(jn8Var.h()) || !StringUtils.isNull(jn8Var.i())) {
                                i = jn8Var.i();
                                h = jn8Var.h();
                            } else {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(jn8Var.f(), jn8Var.g(), str, str2, jn8Var.p(), jn8Var.o());
                                postWriteCallBackData.setThreadId(jn8Var.s());
                                postWriteCallBackData.setPostId(jn8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(jn8Var.l());
                                postWriteCallBackData.setErrorString(jn8Var.g());
                                postWriteCallBackData.setActivityDialog(jn8Var.a());
                                postWriteCallBackData.setVideoid(jn8Var.u());
                                postWriteCallBackData.setInviteesNumber(jn8Var.k());
                                postWriteCallBackData.setContriInfo(jn8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(jn8Var.t());
                                postWriteCallBackData.setmAdverSegmentData(jn8Var.b());
                                postWriteCallBackData.setIconStampData(jn8Var.j());
                                dz4 dz4Var = new dz4();
                                dz4Var.f(this.c);
                                if (this.g.b != null || dn8.k().i() == null) {
                                    if (this.g.b != null || !this.g.j) {
                                        if (this.g.b != null && this.g.k) {
                                            dn8.k().C(this.g.b.getForumId());
                                            dn8.k().D(this.g.b.getForumName());
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                        }
                                    } else {
                                        if (this.g.b.getVideoInfo() != null) {
                                            postWriteCallBackData.writeDataForVideo = this.g.b;
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                    }
                                } else {
                                    dn8.k().C(this.g.b.getForumId());
                                    dn8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, dn8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    dn8.k().z(false);
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && jn8Var.j() == null) {
                                    if (this.g.b != null) {
                                        int type = this.g.b.getType();
                                        if (type != 0) {
                                            if (type == 1 || type == 2) {
                                                activityDialog.type = 1;
                                            } else if (type != 6) {
                                            }
                                        }
                                        activityDialog.type = 2;
                                    }
                                    sg.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.d.callback(true, postWriteCallBackData, dz4Var, this.g.b, jn8Var.c());
                            }
                            str2 = h;
                            str = i;
                            postWriteCallBackData = new PostWriteCallBackData(jn8Var.f(), jn8Var.g(), str, str2, jn8Var.p(), jn8Var.o());
                            postWriteCallBackData.setThreadId(jn8Var.s());
                            postWriteCallBackData.setPostId(jn8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(jn8Var.l());
                            postWriteCallBackData.setErrorString(jn8Var.g());
                            postWriteCallBackData.setActivityDialog(jn8Var.a());
                            postWriteCallBackData.setVideoid(jn8Var.u());
                            postWriteCallBackData.setInviteesNumber(jn8Var.k());
                            postWriteCallBackData.setContriInfo(jn8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(jn8Var.t());
                            postWriteCallBackData.setmAdverSegmentData(jn8Var.b());
                            postWriteCallBackData.setIconStampData(jn8Var.j());
                            dz4 dz4Var2 = new dz4();
                            dz4Var2.f(this.c);
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                                dn8.k().C(this.g.b.getForumId());
                                dn8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                sg.a().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.d.callback(true, postWriteCallBackData, dz4Var2, this.g.b, jn8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(jn8Var.j() == null)));
                        }
                        mn7 mn7Var = this.f;
                        if (mn7Var != null) {
                            mn7Var.c();
                        }
                    } else {
                        en8.a("onPostExecute error");
                        c(jn8Var);
                        mn7 mn7Var2 = this.f;
                        if (mn7Var2 != null) {
                            mn7Var2.h(jn8Var.a, jn8Var.g());
                        }
                    }
                    en8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                en8.a("发帖： onPostExecute isCanceled");
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
    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.m = new c(this);
        this.f = baseFragmentActivity.getPageContext();
    }

    public boolean S() {
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

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData = this.b;
            TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (this.a == null) {
                if (dn8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, U());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, dn8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.l == null) {
                    this.l = new nl8(this.f);
                }
                this.a = new f(this);
                en8.a("dealPost()");
                cn8.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public WriteData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (WriteData) invokeV.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                this.i = spanGroupManager.G();
            } else {
                this.i = null;
            }
        }
    }

    public final void W(jn8 jn8Var) {
        d9<?> d9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jn8Var) == null) || (d9Var = this.f) == null || jn8Var == null || (this.d instanceof dn8)) {
            return;
        }
        ds8.e(d9Var.getPageActivity(), jn8Var.g());
        jn8Var.F(null);
    }

    public final void X(jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jn8Var) == null) || this.f == null || jn8Var == null || jn8Var.c() == null || jn8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), jn8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void Y(jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jn8Var) == null) {
            Z(jn8Var, null, null, this.b);
        }
    }

    public final void Z(jn8 jn8Var, AccessState accessState, dz4 dz4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, jn8Var, accessState, dz4Var, writeData) == null) || jn8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(jn8Var.f(), jn8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(jn8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(jn8Var.q());
            this.d.callback(false, postWriteCallBackData, dz4Var, writeData, jn8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, jn8Var.g(), dz4Var, writeData, jn8Var.c());
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f fVar = this.a;
            if (fVar != null && !fVar.isCancelled()) {
                this.a.cancel();
                return;
            }
            e eVar = this.d;
            if (eVar != null) {
                eVar.callback(false, null, null, this.b, null);
                return;
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(false, null, null, null, null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            f fVar = this.a;
            if (fVar == null || fVar.isCancelled()) {
                return false;
            }
            this.a.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public void e0(@Nullable d9<?> d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, d9Var) == null) {
            if (d9Var != null) {
                this.f = d9Var;
                this.unique_id = d9Var.getUniqueId();
                return;
            }
            this.f = null;
            this.unique_id = null;
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            en8.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            T();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (pi.z() && !pi.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !tu4.k().h("original_img_up_tip", false)) {
                tu4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d9<?> d9Var = this.f;
                if (d9Var == null) {
                    T();
                    return true;
                }
                wr4 wr4Var = new wr4(d9Var.getPageActivity());
                wr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d15);
                wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0266, new a(this, wr4Var));
                wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new b(this, wr4Var));
                wr4Var.create(this.f);
                wr4Var.show();
            } else {
                T();
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
            this.h = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, writeData) == null) {
            this.b = writeData;
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.m = new c(this);
        this.f = baseActivity.getPageContext();
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.m = new c(this);
        this.f = tbPageContext;
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
        this.d = null;
        this.e = false;
        this.m = new c(this);
        this.f = null;
    }
}
