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
import com.repackage.d9;
import com.repackage.dp8;
import com.repackage.dr4;
import com.repackage.e05;
import com.repackage.gy4;
import com.repackage.jk8;
import com.repackage.jq4;
import com.repackage.kk8;
import com.repackage.kl7;
import com.repackage.kq7;
import com.repackage.lk8;
import com.repackage.n45;
import com.repackage.ni;
import com.repackage.nt4;
import com.repackage.oi;
import com.repackage.ol7;
import com.repackage.os7;
import com.repackage.pk8;
import com.repackage.qg;
import com.repackage.qk8;
import com.repackage.ri8;
import com.repackage.si8;
import com.repackage.tj8;
import com.repackage.yt4;
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
    public ri8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public si8 l;
    public tj8.c m;

    /* loaded from: classes4.dex */
    public class a implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
                this.b.U();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends tj8.c {
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

        @Override // com.repackage.tj8.c
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
                this.a.h0();
            }
        }

        @Override // com.repackage.tj8.c
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
                this.a.h0();
            }
        }

        @Override // com.repackage.tj8.c
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

        @Override // com.repackage.tj8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.a = null;
                    this.a.b.setAuthSid(null);
                    this.a.h0();
                } else if (this.a.d != null) {
                    this.a.d.callback(false, null, null, this.a.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, String str, gy4 gy4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, gy4 gy4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, qk8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ri8 a;
        public String b;
        public JSONObject c;
        public boolean d;
        public ol7 e;
        public kl7 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes4.dex */
        public class a implements si8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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

            @Override // com.repackage.si8.e
            public void a(qk8 qk8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, qk8Var) == null) {
                    this.a.onPostExecute(qk8Var);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements si8.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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

            @Override // com.repackage.si8.e
            public void a(qk8 qk8Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, qk8Var) == null) {
                    this.a.onPostExecute(qk8Var);
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
                    os7.a((TbPageContext) this.b.g.f, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
            if (runTask != null) {
                this.e = (ol7) runTask.getData();
            }
            ol7 ol7Var = this.e;
            if (ol7Var != null) {
                this.f = ol7Var.get();
            }
            setPriority(3);
            lk8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public qk8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.d) {
                    return null;
                }
                n45.e(this.g.b.getContent());
                lk8.a("doInBackground() start");
                lk8.a("发帖：任务后台执行 开始 doInBackground");
                ri8 ri8Var = new ri8();
                this.a = ri8Var;
                ri8Var.o(this.g.h);
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
                        qk8 qk8Var = new qk8();
                        if (this.a.j()) {
                            qk8Var.i(false);
                            ErrorData errorData = new ErrorData();
                            errorData.parserJson(this.c);
                            qk8Var.f(errorData.getError_code());
                            qk8Var.h(errorData.getError_msg());
                            qk8Var.g(errorData.getError_data());
                        } else {
                            qk8Var.i(true);
                            qk8Var.f(this.a.g());
                            qk8Var.h(this.a.i());
                        }
                        qk8Var.j(this.c);
                        return qk8Var;
                    }
                    this.b = this.a.b(this.g.l, this.g.b, this.g.e, new b(this));
                    return null;
                }
                this.b = this.a.c(this.g.l, this.g.b, this.g.e, new a(this));
                return null;
            }
            return (qk8) invokeL.objValue;
        }

        public final void c(pk8 pk8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk8Var) == null) || tj8.a(pk8Var.f(), AuthTokenData.parse(this.c), this.g.m)) {
                return;
            }
            if (pk8Var.u()) {
                this.g.Z(pk8Var);
            } else if (pk8Var.x()) {
                this.g.Y(pk8Var);
                this.g.Z(pk8Var);
            } else if (dp8.d(pk8Var.f())) {
                this.g.X(pk8Var);
                this.g.Z(pk8Var);
            } else if (pk8Var.v()) {
                gy4 gy4Var = new gy4();
                gy4Var.f(this.c);
                if (gy4Var.c() == null || this.g.b == null) {
                    return;
                }
                this.g.b.setVcodeMD5(gy4Var.b());
                this.g.b.setVcodeUrl(gy4Var.c());
                NewWriteModel newWriteModel = this.g;
                newWriteModel.a0(pk8Var, null, gy4Var, newWriteModel.b);
            } else if (pk8Var.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.c);
                NewWriteModel newWriteModel2 = this.g;
                newWriteModel2.a0(pk8Var, accessState, null, newWriteModel2.b);
            } else if (pk8Var.w()) {
                this.g.Z(pk8Var);
            } else {
                this.g.Z(pk8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                ri8 ri8Var = this.a;
                if (ri8Var != null) {
                    ri8Var.e();
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
        /* JADX WARN: Code restructure failed: missing block: B:170:0x0548, code lost:
            if (r6 != 7) goto L106;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(qk8 qk8Var) {
            pk8 pk8Var;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            String i;
            String h;
            String str;
            e05 e05Var;
            int i2;
            VideoEasterEggData videoEasterEggData;
            String str2;
            CustomDialogData customDialogData;
            String str3;
            String str4;
            String str5;
            String str6;
            IconStampData iconStampData;
            String str7;
            String str8;
            String str9;
            VideoEasterEggData videoEasterEggData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, qk8Var) == null) {
                super.onPostExecute(qk8Var);
                if (qk8Var == null) {
                    return;
                }
                this.c = qk8Var.d();
                this.a.m(this.g.b, qk8Var);
                lk8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData h2 = this.a.h();
                jk8.c(this.g.b, h2);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", (!this.a.j() || this.c == null) ? 19 : 18).param("obj_type", this.g.b != null ? this.g.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!qk8Var.e() && this.c != null) {
                    lk8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData f = this.a.f();
                    String error_msg = h2.getError_msg();
                    if (oi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10d5);
                    }
                    pk8Var = new pk8(h2.getError_code(), error_msg, f);
                    if (this.g.b != null && this.g.b.isHasImages() && !pk8Var.s()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    lk8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (h2 != null && h2.error_code == 220015) {
                    pk8Var = new pk8(h2.getError_code(), h2.getError_msg(), null);
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
                                pk8Var.K(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    lk8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (h2 != null && h2.error_code == 238010) {
                    pk8Var = new pk8(h2.getError_code(), h2.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        jq4 jq4Var = new jq4();
                        jq4Var.a = optJSONObject.optString("block_content");
                        jq4Var.b = optJSONObject.optString("block_cancel");
                        jq4Var.c = optJSONObject.optString("block_confirm");
                        pk8Var.J(jq4Var);
                    }
                    lk8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (h2 != null && h2.error_code != 0) {
                    String error_msg2 = h2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (h2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f027f);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10ca);
                        }
                    }
                    pk8Var = new pk8(h2.getError_code(), error_msg2, this.a.f());
                    lk8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    pk8Var = new pk8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c17), null);
                    lk8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (pk8Var.s()) {
                    obj = "pid";
                    obj2 = "tid";
                } else {
                    ContriInfo contriInfo = new ContriInfo();
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 != null) {
                        str4 = jSONObject3.optString("msg");
                        str6 = jSONObject3.optString("pre_msg");
                        str7 = jSONObject3.optString("color_msg");
                        str8 = jSONObject3.optString("tid");
                        String optString = jSONObject3.optString("pid");
                        String optString2 = jSONObject3.optString("video_id");
                        CustomDialogData a2 = kq7.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        int optInt = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str5 = optJSONObject4.optString("pre_msg");
                            str9 = optJSONObject4.optString("color_msg");
                        } else {
                            str9 = null;
                            str5 = null;
                        }
                        contriInfo.parseJson(jSONObject3.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("star_info");
                        if (optJSONObject5 != null) {
                            videoEasterEggData2 = new VideoEasterEggData();
                            videoEasterEggData2.parseJson(optJSONObject5);
                        } else {
                            videoEasterEggData2 = null;
                        }
                        JSONObject optJSONObject6 = jSONObject3.optJSONObject("advertisement");
                        int i4 = optInt;
                        if (optJSONObject6 != null) {
                            e05Var = new e05();
                            e05Var.p(optJSONObject6);
                        } else {
                            e05Var = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        if (optJSONObject7 != null) {
                            iconStampData = new IconStampData();
                            iconStampData.parseJson(optJSONObject7);
                            str3 = str9;
                        } else {
                            str3 = str9;
                            iconStampData = null;
                        }
                        str2 = optString2;
                        videoEasterEggData = videoEasterEggData2;
                        i2 = i4;
                        obj = "pid";
                        str = optString;
                        obj2 = "tid";
                        customDialogData = a2;
                    } else {
                        obj = "pid";
                        obj2 = "tid";
                        str = null;
                        e05Var = null;
                        i2 = 0;
                        videoEasterEggData = null;
                        str2 = null;
                        customDialogData = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        iconStampData = null;
                        str7 = null;
                        str8 = null;
                    }
                    if (StringUtils.isNull(str4)) {
                        str4 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d5);
                    }
                    pk8Var.C(str4);
                    pk8Var.I(str6);
                    pk8Var.A(str7);
                    pk8Var.L(str8);
                    pk8Var.H(str);
                    pk8Var.G(i2);
                    pk8Var.E(str5);
                    pk8Var.D(str3);
                    pk8Var.y(customDialogData);
                    pk8Var.N(str2);
                    pk8Var.B(contriInfo);
                    pk8Var.M(videoEasterEggData);
                    pk8Var.z(e05Var);
                    pk8Var.F(iconStampData);
                }
                lk8.a("doInBackground end");
                lk8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                lk8.a("onPostExecute start");
                lk8.a("发帖： onPostExecute");
                this.g.a = null;
                if (pk8Var.f() != 0) {
                    nt4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", pk8Var.f(), pk8Var.g(), obj2, pk8Var.p(), obj, pk8Var.l());
                }
                if (!this.d) {
                    if (!pk8Var.s()) {
                        if (this.g.b != null) {
                            this.g.b.getType();
                        }
                        lk8.a("onPostExecute success");
                        if (this.g.d == null) {
                            z = false;
                            if (this.g.c != null) {
                                this.g.c.a(true, pk8Var.g(), null, null, pk8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(pk8Var.m()) && !StringUtils.isNull(pk8Var.d())) {
                                i = pk8Var.m();
                                h = pk8Var.d();
                            } else if (StringUtils.isNull(pk8Var.h()) && StringUtils.isNull(pk8Var.i())) {
                                h = null;
                                i = null;
                            } else {
                                i = pk8Var.i();
                                h = pk8Var.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(pk8Var.f(), pk8Var.g(), i, h);
                            postWriteCallBackData.setThreadId(pk8Var.p());
                            postWriteCallBackData.setPostId(pk8Var.l());
                            postWriteCallBackData.setIsCopyTWZhibo(pk8Var.k());
                            postWriteCallBackData.setErrorString(pk8Var.g());
                            postWriteCallBackData.setActivityDialog(pk8Var.a());
                            postWriteCallBackData.setVideoid(pk8Var.r());
                            postWriteCallBackData.setContriInfo(pk8Var.e());
                            if (this.g.b != null) {
                                postWriteCallBackData.setProZone(this.g.b.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(pk8Var.q());
                            postWriteCallBackData.setmAdverSegmentData(pk8Var.b());
                            postWriteCallBackData.setIconStampData(pk8Var.j());
                            gy4 gy4Var = new gy4();
                            gy4Var.f(this.c);
                            if (this.g.b == null || kk8.k().i() == null) {
                                z = false;
                                if (this.g.b == null || !this.g.j) {
                                    if (this.g.b != null && this.g.k) {
                                        kk8.k().C(this.g.b.getForumId());
                                        kk8.k().D(this.g.b.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                kk8.k().C(this.g.b.getForumId());
                                kk8.k().D(this.g.b.getForumName());
                                if (this.g.b.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.g.b;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, kk8.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                z = false;
                                kk8.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && pk8Var.j() == null) {
                                if (this.g.b != null) {
                                    int type = this.g.b.getType();
                                    if (type != 0) {
                                        if (type == 1 || type == 2) {
                                            activityDialog.type = 1;
                                        } else if (type != 4) {
                                            if (type != 9) {
                                                if (type != 6) {
                                                }
                                            }
                                        }
                                    }
                                    activityDialog.type = 2;
                                }
                                qg.a().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.d.callback(true, postWriteCallBackData, gy4Var, this.g.b, pk8Var.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (pk8Var.j() == null) {
                                z = true;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z)));
                        }
                        kl7 kl7Var = this.f;
                        if (kl7Var != null) {
                            kl7Var.c();
                        }
                    } else {
                        lk8.a("onPostExecute error");
                        c(pk8Var);
                        kl7 kl7Var2 = this.f;
                        if (kl7Var2 != null) {
                            kl7Var2.h(pk8Var.a, pk8Var.g());
                        }
                    }
                    lk8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                lk8.a("发帖： onPostExecute isCanceled");
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

    public boolean T() {
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

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData = this.b;
            TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (this.a == null) {
                if (kk8.k().i() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, V());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, kk8.k().i()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.l == null) {
                    this.l = new si8(this.f);
                }
                this.a = new f(this);
                lk8.a("dealPost()");
                jk8.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public WriteData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (WriteData) invokeV.objValue;
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                this.i = spanGroupManager.E();
            } else {
                this.i = null;
            }
        }
    }

    public final void X(pk8 pk8Var) {
        d9<?> d9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pk8Var) == null) || (d9Var = this.f) == null || pk8Var == null || (this.d instanceof kk8)) {
            return;
        }
        dp8.e(d9Var.getPageActivity(), pk8Var.g());
        pk8Var.C(null);
    }

    public final void Y(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pk8Var) == null) || this.f == null || pk8Var == null || pk8Var.c() == null || pk8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), pk8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void Z(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pk8Var) == null) {
            a0(pk8Var, null, null, this.b);
        }
    }

    public final void a0(pk8 pk8Var, AccessState accessState, gy4 gy4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, pk8Var, accessState, gy4Var, writeData) == null) || pk8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(pk8Var.f(), pk8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(pk8Var.o());
            postWriteCallBackData.setReplyPrivacyTip(pk8Var.n());
            this.d.callback(false, postWriteCallBackData, gy4Var, writeData, pk8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, pk8Var.g(), gy4Var, writeData, pk8Var.c());
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e = z;
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            f fVar = this.a;
            if (fVar == null || fVar.isCancelled()) {
                return false;
            }
            this.a.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.j = z;
        }
    }

    public void e0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public void f0(@Nullable d9<?> d9Var) {
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

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            lk8.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            U();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (ni.z() && !ni.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !yt4.k().h("original_img_up_tip", false)) {
                yt4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d9<?> d9Var = this.f;
                if (d9Var == null) {
                    U();
                    return true;
                }
                dr4 dr4Var = new dr4(d9Var.getPageActivity());
                dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0ceb);
                dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0262, new a(this, dr4Var));
                dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this, dr4Var));
                dr4Var.create(this.f);
                dr4Var.show();
            } else {
                U();
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
