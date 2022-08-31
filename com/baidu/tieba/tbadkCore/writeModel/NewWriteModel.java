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
import com.baidu.tieba.an8;
import com.baidu.tieba.bn8;
import com.baidu.tieba.br4;
import com.baidu.tieba.bs8;
import com.baidu.tieba.bz4;
import com.baidu.tieba.cn8;
import com.baidu.tieba.d15;
import com.baidu.tieba.d9;
import com.baidu.tieba.hn8;
import com.baidu.tieba.hu4;
import com.baidu.tieba.in8;
import com.baidu.tieba.kl8;
import com.baidu.tieba.km8;
import com.baidu.tieba.kn7;
import com.baidu.tieba.ks7;
import com.baidu.tieba.ll8;
import com.baidu.tieba.n55;
import com.baidu.tieba.on7;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pi;
import com.baidu.tieba.pu7;
import com.baidu.tieba.qi;
import com.baidu.tieba.sg;
import com.baidu.tieba.su4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.vr4;
import com.baidu.tieba.wg;
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
    public kl8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public ll8 l;
    public km8.c m;

    /* loaded from: classes5.dex */
    public class a implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, vr4Var};
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
            this.a = vr4Var;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.a.dismiss();
                this.b.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, vr4Var};
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
            this.a = vr4Var;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends km8.c {
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

        @Override // com.baidu.tieba.km8.c
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

        @Override // com.baidu.tieba.km8.c
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

        @Override // com.baidu.tieba.km8.c
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

        @Override // com.baidu.tieba.km8.c
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
        void a(boolean z, String str, bz4 bz4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, bz4 bz4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Integer, Integer, in8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kl8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public on7 e;
        public kn7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes5.dex */
        public class a implements ll8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0411a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ in8 a;
                public final /* synthetic */ a b;

                public RunnableC0411a(a aVar, in8 in8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, in8Var};
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
                    this.a = in8Var;
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

            @Override // com.baidu.tieba.ll8.e
            public void a(in8 in8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, in8Var) == null) {
                    wg.b(new RunnableC0411a(this, in8Var));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ll8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* loaded from: classes5.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ in8 a;
                public final /* synthetic */ b b;

                public a(b bVar, in8 in8Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, in8Var};
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
                    this.a = in8Var;
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

            @Override // com.baidu.tieba.ll8.e
            public void a(in8 in8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, in8Var) == null) {
                    wg.b(new a(this, in8Var));
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
                    pu7.a((TbPageContext) this.b.g.f, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, on7.class);
            if (runTask != null) {
                this.e = (on7) runTask.getData();
            }
            on7 on7Var = this.e;
            if (on7Var != null) {
                this.f = on7Var.get();
            }
            setPriority(3);
            cn8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public in8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.d) {
                    return null;
                }
                n55.e(this.g.b.getContent());
                cn8.a("doInBackground() start");
                cn8.a("发帖：任务后台执行 开始 doInBackground");
                kl8 kl8Var = new kl8();
                this.a = kl8Var;
                kl8Var.o(this.g.h);
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
                        in8 in8Var = new in8();
                        if (this.a.j()) {
                            in8Var.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.c);
                            in8Var.f(errorData.getError_code());
                            in8Var.h(errorData.getError_msg());
                            in8Var.g(errorData.getError_data());
                        } else {
                            in8Var.i(true);
                            in8Var.f(this.a.g());
                            in8Var.h(this.a.i());
                        }
                        in8Var.j(this.c);
                        return in8Var;
                    }
                    this.b = this.a.b(this.g.l, this.g.b, this.g.e, new b(this));
                    return null;
                }
                this.b = this.a.c(this.g.l, this.g.b, this.g.e, new a(this));
                return null;
            }
            return (in8) invokeL.objValue;
        }

        public final void c(hn8 hn8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hn8Var) == null) || km8.a(hn8Var.f(), AuthTokenData.parse(this.c), this.g.m)) {
                return;
            }
            if (hn8Var.x()) {
                this.g.Y(hn8Var);
            } else if (hn8Var.A()) {
                this.g.X(hn8Var);
                this.g.Y(hn8Var);
            } else if (bs8.d(hn8Var.f())) {
                this.g.W(hn8Var);
                this.g.Y(hn8Var);
            } else if (hn8Var.y()) {
                bz4 bz4Var = new bz4();
                bz4Var.f(this.c);
                if (bz4Var.c() == null || this.g.b == null) {
                    return;
                }
                this.g.b.setVcodeMD5(bz4Var.b());
                this.g.b.setVcodeUrl(bz4Var.c());
                NewWriteModel newWriteModel = this.g;
                newWriteModel.Z(hn8Var, null, bz4Var, newWriteModel.b);
            } else if (hn8Var.w()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.c);
                NewWriteModel newWriteModel2 = this.g;
                newWriteModel2.Z(hn8Var, accessState, null, newWriteModel2.b);
            } else if (hn8Var.z()) {
                this.g.Y(hn8Var);
            } else {
                this.g.Y(hn8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                kl8 kl8Var = this.a;
                if (kl8Var != null) {
                    kl8Var.e();
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
        public void onPostExecute(in8 in8Var) {
            hn8 hn8Var;
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
            d15 d15Var;
            VideoEasterEggData videoEasterEggData2;
            int i3;
            String str14;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            d15 d15Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, in8Var) == null) {
                super.onPostExecute(in8Var);
                if (in8Var == null) {
                    return;
                }
                this.c = in8Var.d();
                this.a.m(this.g.b, in8Var);
                cn8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData h2 = this.a.h();
                an8.c(this.g.b, h2);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, h2.getError_code()).param("obj_locate", (in8Var.e() || this.c == null) ? 19 : 18).param("obj_type", this.g.b != null ? this.g.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!in8Var.e() && this.c != null) {
                    cn8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData f = this.a.f();
                    String error_msg = h2.getError_msg();
                    if (qi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1113);
                    }
                    hn8Var = new hn8(h2.getError_code(), error_msg, f);
                    if (this.g.b != null && this.g.b.isHasImages() && !hn8Var.v()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    cn8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (h2 != null && h2.error_code == 220015) {
                    hn8Var = new hn8(h2.getError_code(), h2.getError_msg(), null);
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
                                hn8Var.Q(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    cn8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (h2 != null && h2.error_code == 238010) {
                    hn8Var = new hn8(h2.getError_code(), h2.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        br4 br4Var = new br4();
                        br4Var.a = optJSONObject.optString("block_content");
                        br4Var.b = optJSONObject.optString("block_cancel");
                        br4Var.c = optJSONObject.optString("block_confirm");
                        hn8Var.P(br4Var);
                    }
                    cn8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (h2 != null && h2.error_code != 0) {
                    String error_msg2 = h2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (h2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0284);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1107);
                        }
                    }
                    hn8Var = new hn8(h2.getError_code(), error_msg2, this.a.f());
                    cn8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    hn8Var = new hn8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c40), null);
                    cn8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (hn8Var.v()) {
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
                        CustomDialogData a2 = ks7.a(jSONObject3);
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
                            d15Var2 = new d15();
                            d15Var2.p(optJSONObject6);
                        } else {
                            d15Var2 = null;
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
                            d15Var = d15Var2;
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
                            d15Var = d15Var2;
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
                        d15Var = null;
                    }
                    if (StringUtils.isNull(str11)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str11 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1113);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    hn8Var.F(str11);
                    hn8Var.M(str13);
                    hn8Var.D(str6);
                    hn8Var.O(str7);
                    hn8Var.N(str5);
                    hn8Var.R(str3);
                    hn8Var.L(str10);
                    hn8Var.K(i2);
                    hn8Var.H(str12);
                    hn8Var.G(str4);
                    hn8Var.B(customDialogData);
                    hn8Var.T(str8);
                    hn8Var.J(str9);
                    hn8Var.E(contriInfo);
                    hn8Var.S(videoEasterEggData2);
                    hn8Var.C(d15Var);
                    hn8Var.I(iconStampData);
                }
                cn8.a("doInBackground end");
                cn8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                cn8.a("onPostExecute start");
                cn8.a("发帖： onPostExecute");
                this.g.a = null;
                if (hn8Var.f() != 0) {
                    hu4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", hn8Var.f(), hn8Var.g(), obj2, hn8Var.s(), obj, hn8Var.m());
                }
                if (!this.d) {
                    if (!hn8Var.v()) {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        cn8.a("onPostExecute success");
                        if (this.g.d == null) {
                            if (this.g.c != null) {
                                this.g.c.a(true, hn8Var.g(), null, null, hn8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(hn8Var.n()) && !StringUtils.isNull(hn8Var.d())) {
                                i = hn8Var.n();
                                h = hn8Var.d();
                            } else if (!StringUtils.isNull(hn8Var.h()) || !StringUtils.isNull(hn8Var.i())) {
                                i = hn8Var.i();
                                h = hn8Var.h();
                            } else {
                                str = null;
                                str2 = null;
                                postWriteCallBackData = new PostWriteCallBackData(hn8Var.f(), hn8Var.g(), str, str2, hn8Var.p(), hn8Var.o());
                                postWriteCallBackData.setThreadId(hn8Var.s());
                                postWriteCallBackData.setPostId(hn8Var.m());
                                postWriteCallBackData.setIsCopyTWZhibo(hn8Var.l());
                                postWriteCallBackData.setErrorString(hn8Var.g());
                                postWriteCallBackData.setActivityDialog(hn8Var.a());
                                postWriteCallBackData.setVideoid(hn8Var.u());
                                postWriteCallBackData.setInviteesNumber(hn8Var.k());
                                postWriteCallBackData.setContriInfo(hn8Var.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setProZone(this.g.b.getProZone());
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(hn8Var.t());
                                postWriteCallBackData.setmAdverSegmentData(hn8Var.b());
                                postWriteCallBackData.setIconStampData(hn8Var.j());
                                bz4 bz4Var = new bz4();
                                bz4Var.f(this.c);
                                if (this.g.b != null || bn8.k().i() == null) {
                                    if (this.g.b != null || !this.g.j) {
                                        if (this.g.b != null && this.g.k) {
                                            bn8.k().C(this.g.b.getForumId());
                                            bn8.k().D(this.g.b.getForumName());
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                        }
                                    } else {
                                        if (this.g.b.getVideoInfo() != null) {
                                            postWriteCallBackData.writeDataForVideo = this.g.b;
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                    }
                                } else {
                                    bn8.k().C(this.g.b.getForumId());
                                    bn8.k().D(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, bn8.k().i()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    bn8.k().z(false);
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && hn8Var.j() == null) {
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
                                this.g.d.callback(true, postWriteCallBackData, bz4Var, this.g.b, hn8Var.c());
                            }
                            str2 = h;
                            str = i;
                            postWriteCallBackData = new PostWriteCallBackData(hn8Var.f(), hn8Var.g(), str, str2, hn8Var.p(), hn8Var.o());
                            postWriteCallBackData.setThreadId(hn8Var.s());
                            postWriteCallBackData.setPostId(hn8Var.m());
                            postWriteCallBackData.setIsCopyTWZhibo(hn8Var.l());
                            postWriteCallBackData.setErrorString(hn8Var.g());
                            postWriteCallBackData.setActivityDialog(hn8Var.a());
                            postWriteCallBackData.setVideoid(hn8Var.u());
                            postWriteCallBackData.setInviteesNumber(hn8Var.k());
                            postWriteCallBackData.setContriInfo(hn8Var.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(hn8Var.t());
                            postWriteCallBackData.setmAdverSegmentData(hn8Var.b());
                            postWriteCallBackData.setIconStampData(hn8Var.j());
                            bz4 bz4Var2 = new bz4();
                            bz4Var2.f(this.c);
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                            }
                            if (this.g.b != null) {
                                bn8.k().C(this.g.b.getForumId());
                                bn8.k().D(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                sg.a().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.d.callback(true, postWriteCallBackData, bz4Var2, this.g.b, hn8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(hn8Var.j() == null)));
                        }
                        kn7 kn7Var = this.f;
                        if (kn7Var != null) {
                            kn7Var.c();
                        }
                    } else {
                        cn8.a("onPostExecute error");
                        c(hn8Var);
                        kn7 kn7Var2 = this.f;
                        if (kn7Var2 != null) {
                            kn7Var2.h(hn8Var.a, hn8Var.g());
                        }
                    }
                    cn8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                cn8.a("发帖： onPostExecute isCanceled");
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
                if (bn8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, U());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, bn8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.l == null) {
                    this.l = new ll8(this.f);
                }
                this.a = new f(this);
                cn8.a("dealPost()");
                an8.l(this.b);
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

    public final void W(hn8 hn8Var) {
        d9<?> d9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hn8Var) == null) || (d9Var = this.f) == null || hn8Var == null || (this.d instanceof bn8)) {
            return;
        }
        bs8.e(d9Var.getPageActivity(), hn8Var.g());
        hn8Var.F(null);
    }

    public final void X(hn8 hn8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, hn8Var) == null) || this.f == null || hn8Var == null || hn8Var.c() == null || hn8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), hn8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void Y(hn8 hn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hn8Var) == null) {
            Z(hn8Var, null, null, this.b);
        }
    }

    public final void Z(hn8 hn8Var, AccessState accessState, bz4 bz4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, hn8Var, accessState, bz4Var, writeData) == null) || hn8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(hn8Var.f(), hn8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(hn8Var.r());
            postWriteCallBackData.setReplyPrivacyTip(hn8Var.q());
            this.d.callback(false, postWriteCallBackData, bz4Var, writeData, hn8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, hn8Var.g(), bz4Var, writeData, hn8Var.c());
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
            cn8.a("发帖：开始上传");
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
            if (pi.z() && !pi.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !su4.k().h("original_img_up_tip", false)) {
                su4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d9<?> d9Var = this.f;
                if (d9Var == null) {
                    T();
                    return true;
                }
                vr4 vr4Var = new vr4(d9Var.getPageActivity());
                vr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d15);
                vr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0266, new a(this, vr4Var));
                vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new b(this, vr4Var));
                vr4Var.create(this.f);
                vr4Var.show();
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
