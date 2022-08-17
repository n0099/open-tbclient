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
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ar4;
import com.repackage.az4;
import com.repackage.bn8;
import com.repackage.cn8;
import com.repackage.d9;
import com.repackage.el8;
import com.repackage.em8;
import com.repackage.en7;
import com.repackage.es7;
import com.repackage.fl8;
import com.repackage.gu4;
import com.repackage.in7;
import com.repackage.j55;
import com.repackage.ju7;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.rg;
import com.repackage.ru4;
import com.repackage.um8;
import com.repackage.ur4;
import com.repackage.ur8;
import com.repackage.vg;
import com.repackage.vm8;
import com.repackage.wm8;
import com.repackage.z05;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
    public el8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public fl8 l;
    public em8.c m;

    /* loaded from: classes4.dex */
    public class a implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, ur4Var};
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
            this.a = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.dismiss();
                this.b.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, ur4Var};
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
            this.a = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends em8.c {
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

        @Override // com.repackage.em8.c
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

        @Override // com.repackage.em8.c
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

        @Override // com.repackage.em8.c
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

        @Override // com.repackage.em8.c
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

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, String str, az4 az4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, cn8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public el8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public in7 e;
        public en7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes4.dex */
        public class a implements fl8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0257a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cn8 a;
                public final /* synthetic */ a b;

                public RunnableC0257a(a aVar, cn8 cn8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, cn8Var};
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
                    this.a = cn8Var;
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

            @Override // com.repackage.fl8.e
            public void a(cn8 cn8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cn8Var) == null) {
                    vg.b(new RunnableC0257a(this, cn8Var));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements fl8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* loaded from: classes4.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cn8 a;
                public final /* synthetic */ b b;

                public a(b bVar, cn8 cn8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, cn8Var};
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
                    this.a = cn8Var;
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

            @Override // com.repackage.fl8.e
            public void a(cn8 cn8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cn8Var) == null) {
                    vg.b(new a(this, cn8Var));
                }
            }
        }

        /* loaded from: classes4.dex */
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
                    ju7.a((TbPageContext) this.b.g.f, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, in7.class);
            if (runTask != null) {
                this.e = (in7) runTask.getData();
            }
            in7 in7Var = this.e;
            if (in7Var != null) {
                this.f = in7Var.get();
            }
            setPriority(3);
            wm8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public cn8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.d) {
                    return null;
                }
                j55.e(this.g.b.getContent());
                wm8.a("doInBackground() start");
                wm8.a("发帖：任务后台执行 开始 doInBackground");
                el8 el8Var = new el8();
                this.a = el8Var;
                el8Var.o(this.g.h);
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
                        cn8 cn8Var = new cn8();
                        if (this.a.j()) {
                            cn8Var.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.c);
                            cn8Var.f(errorData.getError_code());
                            cn8Var.h(errorData.getError_msg());
                            cn8Var.g(errorData.getError_data());
                        } else {
                            cn8Var.i(true);
                            cn8Var.f(this.a.g());
                            cn8Var.h(this.a.i());
                        }
                        cn8Var.j(this.c);
                        return cn8Var;
                    }
                    this.b = this.a.b(this.g.l, this.g.b, this.g.e, new b(this));
                    return null;
                }
                this.b = this.a.c(this.g.l, this.g.b, this.g.e, new a(this));
                return null;
            }
            return (cn8) invokeL.objValue;
        }

        public final void c(bn8 bn8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bn8Var) == null) || em8.a(bn8Var.f(), AuthTokenData.parse(this.c), this.g.m)) {
                return;
            }
            if (bn8Var.x()) {
                this.g.Y(bn8Var);
            } else if (bn8Var.A()) {
                this.g.X(bn8Var);
                this.g.Y(bn8Var);
            } else if (ur8.d(bn8Var.f())) {
                this.g.W(bn8Var);
                this.g.Y(bn8Var);
            } else if (bn8Var.y()) {
                az4 az4Var = new az4();
                az4Var.f(this.c);
                if (az4Var.c() == null || this.g.b == null) {
                    return;
                }
                this.g.b.setVcodeMD5(az4Var.b());
                this.g.b.setVcodeUrl(az4Var.c());
                NewWriteModel newWriteModel = this.g;
                newWriteModel.Z(bn8Var, null, az4Var, newWriteModel.b);
            } else if (bn8Var.w()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.c);
                NewWriteModel newWriteModel2 = this.g;
                newWriteModel2.Z(bn8Var, accessState, null, newWriteModel2.b);
            } else if (bn8Var.z()) {
                this.g.Y(bn8Var);
            } else {
                this.g.Y(bn8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                el8 el8Var = this.a;
                if (el8Var != null) {
                    el8Var.e();
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
        public void onPostExecute(cn8 cn8Var) {
            bn8 bn8Var;
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
            z05 z05Var;
            VideoEasterEggData videoEasterEggData2;
            int i3;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            z05 z05Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cn8Var) == null) {
                super.onPostExecute(cn8Var);
                if (cn8Var == null) {
                    return;
                }
                this.c = cn8Var.d();
                this.a.m(this.g.b, cn8Var);
                wm8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData h2 = this.a.h();
                um8.c(this.g.b, h2);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, h2.getError_code()).param("obj_locate", (cn8Var.e() || this.c == null) ? 19 : 18).param("obj_type", this.g.b != null ? this.g.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!cn8Var.e() && this.c != null) {
                    wm8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData f = this.a.f();
                    String error_msg = h2.getError_msg();
                    if (pi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1110);
                    }
                    bn8Var = new bn8(h2.getError_code(), error_msg, f);
                    if (this.g.b != null && this.g.b.isHasImages() && !bn8Var.v()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    wm8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (h2 != null && h2.error_code == 220015) {
                    bn8Var = new bn8(h2.getError_code(), h2.getError_msg(), null);
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
                                bn8Var.Q(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    wm8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (h2 != null && h2.error_code == 238010) {
                    bn8Var = new bn8(h2.getError_code(), h2.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        ar4 ar4Var = new ar4();
                        ar4Var.a = optJSONObject.optString("block_content");
                        ar4Var.b = optJSONObject.optString("block_cancel");
                        ar4Var.c = optJSONObject.optString("block_confirm");
                        bn8Var.P(ar4Var);
                    }
                    wm8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (h2 != null && h2.error_code != 0) {
                    String error_msg2 = h2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (h2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0283);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1104);
                        }
                    }
                    bn8Var = new bn8(h2.getError_code(), error_msg2, this.a.f());
                    wm8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    bn8Var = new bn8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c3d), null);
                    wm8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (bn8Var.v()) {
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
                        CustomDialogData a2 = es7.a(jSONObject3);
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
                            z05Var2 = new z05();
                            z05Var2.p(optJSONObject6);
                        } else {
                            z05Var2 = null;
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
                            z05Var = z05Var2;
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
                            z05Var = z05Var2;
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
                        z05Var = null;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1110);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    bn8Var.F(str11);
                    bn8Var.M(str13);
                    bn8Var.D(str6);
                    bn8Var.O(str7);
                    bn8Var.N(str5);
                    bn8Var.R(str3);
                    bn8Var.L(str10);
                    bn8Var.K(i2);
                    bn8Var.H(str12);
                    bn8Var.G(str4);
                    bn8Var.B(customDialogData);
                    bn8Var.T(str8);
                    bn8Var.J(str9);
                    bn8Var.E(contriInfo);
                    bn8Var.S(videoEasterEggData2);
                    bn8Var.C(z05Var);
                    bn8Var.I(iconStampData);
                }
                wm8.a("doInBackground end");
                wm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                wm8.a("onPostExecute start");
                wm8.a("发帖： onPostExecute");
                this.g.a = null;
                if (bn8Var.f() != 0) {
                    gu4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bn8Var.f(), bn8Var.g(), obj2, bn8Var.s(), obj, bn8Var.m());
                }
                if (!this.d) {
                    if (!bn8Var.v()) {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        wm8.a("onPostExecute success");
                        if (this.g.d == null) {
                            if (this.g.c != null) {
                                this.g.c.a(true, bn8Var.g(), null, null, bn8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(bn8Var.n()) && !StringUtils.isNull(bn8Var.d())) {
                                i = bn8Var.n();
                                h = bn8Var.d();
                            } else if (!StringUtils.isNull(bn8Var.h()) || !StringUtils.isNull(bn8Var.i())) {
                                i = bn8Var.i();
                                h = bn8Var.h();
                            } else {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(bn8Var.f(), bn8Var.g(), str, str2, bn8Var.p(), bn8Var.o());
                                postWriteCallBackData.setThreadId(bn8Var.s());
                                postWriteCallBackData.setPostId(bn8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(bn8Var.l());
                                postWriteCallBackData.setErrorString(bn8Var.g());
                                postWriteCallBackData.setActivityDialog(bn8Var.a());
                                postWriteCallBackData.setVideoid(bn8Var.u());
                                postWriteCallBackData.setInviteesNumber(bn8Var.k());
                                postWriteCallBackData.setContriInfo(bn8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(bn8Var.t());
                                postWriteCallBackData.setmAdverSegmentData(bn8Var.b());
                                postWriteCallBackData.setIconStampData(bn8Var.j());
                                az4 az4Var = new az4();
                                az4Var.f(this.c);
                                if (this.g.b != null || vm8.k().i() == null) {
                                    if (this.g.b != null || !this.g.j) {
                                        if (this.g.b != null && this.g.k) {
                                            vm8.k().C(this.g.b.getForumId());
                                            vm8.k().D(this.g.b.getForumName());
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                        }
                                    } else {
                                        if (this.g.b.getVideoInfo() != null) {
                                            postWriteCallBackData.writeDataForVideo = this.g.b;
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                    }
                                } else {
                                    vm8.k().C(this.g.b.getForumId());
                                    vm8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, vm8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    vm8.k().z(false);
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && bn8Var.j() == null) {
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
                                    rg.a().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.d.callback(true, postWriteCallBackData, az4Var, this.g.b, bn8Var.c());
                            }
                            str2 = h;
                            str = i;
                            postWriteCallBackData = new PostWriteCallBackData(bn8Var.f(), bn8Var.g(), str, str2, bn8Var.p(), bn8Var.o());
                            postWriteCallBackData.setThreadId(bn8Var.s());
                            postWriteCallBackData.setPostId(bn8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(bn8Var.l());
                            postWriteCallBackData.setErrorString(bn8Var.g());
                            postWriteCallBackData.setActivityDialog(bn8Var.a());
                            postWriteCallBackData.setVideoid(bn8Var.u());
                            postWriteCallBackData.setInviteesNumber(bn8Var.k());
                            postWriteCallBackData.setContriInfo(bn8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(bn8Var.t());
                            postWriteCallBackData.setmAdverSegmentData(bn8Var.b());
                            postWriteCallBackData.setIconStampData(bn8Var.j());
                            az4 az4Var2 = new az4();
                            az4Var2.f(this.c);
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                                vm8.k().C(this.g.b.getForumId());
                                vm8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                rg.a().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.d.callback(true, postWriteCallBackData, az4Var2, this.g.b, bn8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(bn8Var.j() == null)));
                        }
                        en7 en7Var = this.f;
                        if (en7Var != null) {
                            en7Var.c();
                        }
                    } else {
                        wm8.a("onPostExecute error");
                        c(bn8Var);
                        en7 en7Var2 = this.f;
                        if (en7Var2 != null) {
                            en7Var2.h(bn8Var.a, bn8Var.g());
                        }
                    }
                    wm8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                wm8.a("发帖： onPostExecute isCanceled");
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
                if (vm8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, U());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, vm8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.l == null) {
                    this.l = new fl8(this.f);
                }
                this.a = new f(this);
                wm8.a("dealPost()");
                um8.l(this.b);
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

    public final void W(bn8 bn8Var) {
        d9<?> d9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bn8Var) == null) || (d9Var = this.f) == null || bn8Var == null || (this.d instanceof vm8)) {
            return;
        }
        ur8.e(d9Var.getPageActivity(), bn8Var.g());
        bn8Var.F(null);
    }

    public final void X(bn8 bn8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bn8Var) == null) || this.f == null || bn8Var == null || bn8Var.c() == null || bn8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), bn8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void Y(bn8 bn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bn8Var) == null) {
            Z(bn8Var, null, null, this.b);
        }
    }

    public final void Z(bn8 bn8Var, AccessState accessState, az4 az4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, bn8Var, accessState, az4Var, writeData) == null) || bn8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bn8Var.f(), bn8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(bn8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(bn8Var.q());
            this.d.callback(false, postWriteCallBackData, az4Var, writeData, bn8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, bn8Var.g(), az4Var, writeData, bn8Var.c());
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
            wm8.a("发帖：开始上传");
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
            if (oi.z() && !oi.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !ru4.k().h("original_img_up_tip", false)) {
                ru4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d9<?> d9Var = this.f;
                if (d9Var == null) {
                    T();
                    return true;
                }
                ur4 ur4Var = new ur4(d9Var.getPageActivity());
                ur4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d12);
                ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0265, new a(this, ur4Var));
                ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new b(this, ur4Var));
                ur4Var.create(this.f);
                ur4Var.show();
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
