package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.repackage.ez4;
import com.repackage.ho8;
import com.repackage.ht4;
import com.repackage.hx4;
import com.repackage.k35;
import com.repackage.ni;
import com.repackage.nj8;
import com.repackage.nq4;
import com.repackage.oi;
import com.repackage.oj8;
import com.repackage.pj8;
import com.repackage.qg;
import com.repackage.sk7;
import com.repackage.sp7;
import com.repackage.tj8;
import com.repackage.tp4;
import com.repackage.wh8;
import com.repackage.wk7;
import com.repackage.wr7;
import com.repackage.ws4;
import com.repackage.xi8;
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
    public wh8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public xi8.c l;

    /* loaded from: classes4.dex */
    public class a implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, nq4Var};
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
            this.a = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, nq4Var};
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
            this.a = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.dismiss();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16).param("obj_type", this.b.b != null ? this.b.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends xi8.c {
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

        @Override // com.repackage.xi8.c
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
                this.a.f0();
            }
        }

        @Override // com.repackage.xi8.c
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
                this.a.f0();
            }
        }

        @Override // com.repackage.xi8.c
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

        @Override // com.repackage.xi8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.a = null;
                    this.a.b.setAuthSid(null);
                    this.a.f0();
                } else if (this.a.d != null) {
                    this.a.d.callback(false, null, null, this.a.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, String str, hx4 hx4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, tj8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wh8 a;
        public String b;
        public boolean c;
        public wk7 d;
        public sk7 e;
        public final /* synthetic */ NewWriteModel f;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ f b;

            public a(f fVar, CustomDialogData customDialogData) {
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
                    wr7.a((TbPageContext) this.b.f.f, this.a).show();
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
            this.f = newWriteModel;
            this.a = null;
            this.b = null;
            this.c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, wk7.class);
            if (runTask != null) {
                this.d = (wk7) runTask.getData();
            }
            wk7 wk7Var = this.d;
            if (wk7Var != null) {
                this.e = wk7Var.get();
            }
            setPriority(3);
            pj8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0360  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public tj8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            tj8 tj8Var;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            ez4 ez4Var;
            String str;
            String str2;
            String str3;
            VideoEasterEggData videoEasterEggData;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            CustomDialogData customDialogData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.c) {
                    return null;
                }
                k35.e(this.f.b.getContent());
                pj8.a("doInBackground() start");
                pj8.a("发帖：任务后台执行 开始 doInBackground");
                wh8 wh8Var = new wh8();
                this.a = wh8Var;
                wh8Var.i(this.f.h);
                this.a.j(this.f.i);
                this.a.k(this.e);
                this.a.h(this.f.g);
                this.b = this.a.g(this.f.b, this.f.e);
                pj8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d = this.a.d();
                nj8.c(this.f.b, d);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", (!this.a.e() || this.b == null) ? 19 : 18).param("obj_type", this.f.b != null ? this.f.b.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (this.a.e() && this.b != null) {
                    pj8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c = this.a.c();
                    String error_msg = d.getError_msg();
                    if (oi.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1122);
                    }
                    tj8Var = new tj8(d.getError_code(), error_msg, c);
                    if (this.f.b != null && this.f.b.isHasImages() && !tj8Var.s()) {
                        this.f.b.deleteUploadedTempImages();
                    }
                    pj8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d != null && d.error_code == 220015) {
                    tj8Var = new tj8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                tj8Var.K(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    pj8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d != null && d.error_code == 238010) {
                    tj8Var = new tj8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                tp4 tp4Var = new tp4();
                                tp4Var.a = optJSONObject2.optString("block_content");
                                tp4Var.b = optJSONObject2.optString("block_cancel");
                                tp4Var.c = optJSONObject2.optString("block_confirm");
                                tj8Var.J(tp4Var);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    pj8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d != null && d.error_code != 0) {
                    String error_msg2 = d.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f027c);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1117);
                        }
                    }
                    tj8Var = new tj8(d.getError_code(), error_msg2, this.a.c());
                    pj8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    tj8Var = new tj8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c37), null);
                    pj8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!tj8Var.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.b != null) {
                            JSONObject jSONObject = new JSONObject(this.b);
                            String optString = jSONObject.optString("msg");
                            try {
                                str4 = jSONObject.optString("pre_msg");
                                try {
                                    str5 = jSONObject.optString("color_msg");
                                } catch (JSONException e3) {
                                    e = e3;
                                    str3 = optString;
                                    ez4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    str5 = null;
                                    str6 = null;
                                    str7 = null;
                                    str8 = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    tj8Var.C(str3);
                                    tj8Var.I(str4);
                                    tj8Var.A(str5);
                                    tj8Var.L(str6);
                                    tj8Var.H(str7);
                                    tj8Var.G(r7);
                                    tj8Var.E(str2);
                                    tj8Var.D(str);
                                    tj8Var.y(customDialogData);
                                    tj8Var.N(str8);
                                    tj8Var.B(contriInfo);
                                    tj8Var.M(videoEasterEggData);
                                    tj8Var.z(ez4Var);
                                    tj8Var.F(iconStampData);
                                    pj8.a("doInBackground end");
                                    pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return tj8Var;
                                }
                                try {
                                    str6 = jSONObject.optString("tid");
                                } catch (JSONException e4) {
                                    e = e4;
                                    str3 = optString;
                                    ez4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    str6 = null;
                                    str7 = null;
                                    str8 = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    tj8Var.C(str3);
                                    tj8Var.I(str4);
                                    tj8Var.A(str5);
                                    tj8Var.L(str6);
                                    tj8Var.H(str7);
                                    tj8Var.G(r7);
                                    tj8Var.E(str2);
                                    tj8Var.D(str);
                                    tj8Var.y(customDialogData);
                                    tj8Var.N(str8);
                                    tj8Var.B(contriInfo);
                                    tj8Var.M(videoEasterEggData);
                                    tj8Var.z(ez4Var);
                                    tj8Var.F(iconStampData);
                                    pj8.a("doInBackground end");
                                    pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return tj8Var;
                                }
                                try {
                                    str7 = jSONObject.optString("pid");
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                    } catch (JSONException e5) {
                                        e = e5;
                                        str3 = optString;
                                        ez4Var = null;
                                        str = null;
                                        str2 = null;
                                        videoEasterEggData = null;
                                        str8 = null;
                                        customDialogData = null;
                                        jSONException = e;
                                        iconStampData = null;
                                        jSONException.printStackTrace();
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        tj8Var.C(str3);
                                        tj8Var.I(str4);
                                        tj8Var.A(str5);
                                        tj8Var.L(str6);
                                        tj8Var.H(str7);
                                        tj8Var.G(r7);
                                        tj8Var.E(str2);
                                        tj8Var.D(str);
                                        tj8Var.y(customDialogData);
                                        tj8Var.N(str8);
                                        tj8Var.B(contriInfo);
                                        tj8Var.M(videoEasterEggData);
                                        tj8Var.z(ez4Var);
                                        tj8Var.F(iconStampData);
                                        pj8.a("doInBackground end");
                                        pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return tj8Var;
                                    }
                                } catch (JSONException e6) {
                                    e = e6;
                                    str3 = optString;
                                    ez4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    str7 = null;
                                    str8 = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    tj8Var.C(str3);
                                    tj8Var.I(str4);
                                    tj8Var.A(str5);
                                    tj8Var.L(str6);
                                    tj8Var.H(str7);
                                    tj8Var.G(r7);
                                    tj8Var.E(str2);
                                    tj8Var.D(str);
                                    tj8Var.y(customDialogData);
                                    tj8Var.N(str8);
                                    tj8Var.B(contriInfo);
                                    tj8Var.M(videoEasterEggData);
                                    tj8Var.z(ez4Var);
                                    tj8Var.F(iconStampData);
                                    pj8.a("doInBackground end");
                                    pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return tj8Var;
                                }
                                try {
                                    customDialogData = sp7.a(jSONObject);
                                    try {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                        r7 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                                        JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                        if (optJSONObject4 != null) {
                                            str2 = optJSONObject4.optString("pre_msg");
                                            try {
                                                str = optJSONObject4.optString("color_msg");
                                            } catch (JSONException e7) {
                                                e = e7;
                                                str3 = optString;
                                                ez4Var = null;
                                                str = null;
                                                videoEasterEggData = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                tj8Var.C(str3);
                                                tj8Var.I(str4);
                                                tj8Var.A(str5);
                                                tj8Var.L(str6);
                                                tj8Var.H(str7);
                                                tj8Var.G(r7);
                                                tj8Var.E(str2);
                                                tj8Var.D(str);
                                                tj8Var.y(customDialogData);
                                                tj8Var.N(str8);
                                                tj8Var.B(contriInfo);
                                                tj8Var.M(videoEasterEggData);
                                                tj8Var.z(ez4Var);
                                                tj8Var.F(iconStampData);
                                                pj8.a("doInBackground end");
                                                pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return tj8Var;
                                            }
                                        } else {
                                            str = null;
                                            str2 = null;
                                        }
                                    } catch (JSONException e8) {
                                        e = e8;
                                        str3 = optString;
                                        ez4Var = null;
                                        str = null;
                                        str2 = null;
                                    }
                                    try {
                                        contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                                        JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                                        if (optJSONObject5 != null) {
                                            videoEasterEggData = new VideoEasterEggData();
                                            try {
                                                videoEasterEggData.parseJson(optJSONObject5);
                                            } catch (JSONException e9) {
                                                e = e9;
                                                str3 = optString;
                                                ez4Var = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                tj8Var.C(str3);
                                                tj8Var.I(str4);
                                                tj8Var.A(str5);
                                                tj8Var.L(str6);
                                                tj8Var.H(str7);
                                                tj8Var.G(r7);
                                                tj8Var.E(str2);
                                                tj8Var.D(str);
                                                tj8Var.y(customDialogData);
                                                tj8Var.N(str8);
                                                tj8Var.B(contriInfo);
                                                tj8Var.M(videoEasterEggData);
                                                tj8Var.z(ez4Var);
                                                tj8Var.F(iconStampData);
                                                pj8.a("doInBackground end");
                                                pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return tj8Var;
                                            }
                                        } else {
                                            videoEasterEggData = null;
                                        }
                                        JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                        if (optJSONObject6 != null) {
                                            ez4Var = new ez4();
                                            try {
                                                ez4Var.p(optJSONObject6);
                                            } catch (JSONException e10) {
                                                e = e10;
                                                str3 = optString;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                tj8Var.C(str3);
                                                tj8Var.I(str4);
                                                tj8Var.A(str5);
                                                tj8Var.L(str6);
                                                tj8Var.H(str7);
                                                tj8Var.G(r7);
                                                tj8Var.E(str2);
                                                tj8Var.D(str);
                                                tj8Var.y(customDialogData);
                                                tj8Var.N(str8);
                                                tj8Var.B(contriInfo);
                                                tj8Var.M(videoEasterEggData);
                                                tj8Var.z(ez4Var);
                                                tj8Var.F(iconStampData);
                                                pj8.a("doInBackground end");
                                                pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return tj8Var;
                                            }
                                        } else {
                                            ez4Var = null;
                                        }
                                        JSONObject optJSONObject7 = jSONObject.optJSONObject("icon_stamp_info");
                                        if (optJSONObject7 != null) {
                                            IconStampData iconStampData2 = new IconStampData();
                                            try {
                                                iconStampData2.parseJson(optJSONObject7);
                                                iconStampData = iconStampData2;
                                                str3 = optString;
                                            } catch (JSONException e11) {
                                                jSONException = e11;
                                                iconStampData = iconStampData2;
                                                str3 = optString;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                tj8Var.C(str3);
                                                tj8Var.I(str4);
                                                tj8Var.A(str5);
                                                tj8Var.L(str6);
                                                tj8Var.H(str7);
                                                tj8Var.G(r7);
                                                tj8Var.E(str2);
                                                tj8Var.D(str);
                                                tj8Var.y(customDialogData);
                                                tj8Var.N(str8);
                                                tj8Var.B(contriInfo);
                                                tj8Var.M(videoEasterEggData);
                                                tj8Var.z(ez4Var);
                                                tj8Var.F(iconStampData);
                                                pj8.a("doInBackground end");
                                                pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return tj8Var;
                                            }
                                        } else {
                                            str3 = optString;
                                            iconStampData = null;
                                        }
                                    } catch (JSONException e12) {
                                        e = e12;
                                        str3 = optString;
                                        ez4Var = null;
                                        videoEasterEggData = null;
                                        jSONException = e;
                                        iconStampData = null;
                                        jSONException.printStackTrace();
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        tj8Var.C(str3);
                                        tj8Var.I(str4);
                                        tj8Var.A(str5);
                                        tj8Var.L(str6);
                                        tj8Var.H(str7);
                                        tj8Var.G(r7);
                                        tj8Var.E(str2);
                                        tj8Var.D(str);
                                        tj8Var.y(customDialogData);
                                        tj8Var.N(str8);
                                        tj8Var.B(contriInfo);
                                        tj8Var.M(videoEasterEggData);
                                        tj8Var.z(ez4Var);
                                        tj8Var.F(iconStampData);
                                        pj8.a("doInBackground end");
                                        pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return tj8Var;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
                                    str3 = optString;
                                    ez4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    tj8Var.C(str3);
                                    tj8Var.I(str4);
                                    tj8Var.A(str5);
                                    tj8Var.L(str6);
                                    tj8Var.H(str7);
                                    tj8Var.G(r7);
                                    tj8Var.E(str2);
                                    tj8Var.D(str);
                                    tj8Var.y(customDialogData);
                                    tj8Var.N(str8);
                                    tj8Var.B(contriInfo);
                                    tj8Var.M(videoEasterEggData);
                                    tj8Var.z(ez4Var);
                                    tj8Var.F(iconStampData);
                                    pj8.a("doInBackground end");
                                    pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return tj8Var;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str3 = optString;
                                ez4Var = null;
                                str = null;
                                str2 = null;
                                videoEasterEggData = null;
                                str4 = null;
                            }
                        } else {
                            iconStampData = null;
                            ez4Var = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                            videoEasterEggData = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            customDialogData = null;
                        }
                    } catch (JSONException e15) {
                        jSONException = e15;
                        iconStampData = null;
                        ez4Var = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                        videoEasterEggData = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        customDialogData = null;
                    }
                    if (StringUtils.isNull(str3)) {
                        str3 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1122);
                    }
                    tj8Var.C(str3);
                    tj8Var.I(str4);
                    tj8Var.A(str5);
                    tj8Var.L(str6);
                    tj8Var.H(str7);
                    tj8Var.G(r7);
                    tj8Var.E(str2);
                    tj8Var.D(str);
                    tj8Var.y(customDialogData);
                    tj8Var.N(str8);
                    tj8Var.B(contriInfo);
                    tj8Var.M(videoEasterEggData);
                    tj8Var.z(ez4Var);
                    tj8Var.F(iconStampData);
                }
                pj8.a("doInBackground end");
                pj8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return tj8Var;
            }
            return (tj8) invokeL.objValue;
        }

        public final void c(tj8 tj8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tj8Var) == null) || xi8.a(tj8Var.f(), AuthTokenData.parse(this.b), this.f.l)) {
                return;
            }
            if (tj8Var.u()) {
                this.f.X(tj8Var);
            } else if (tj8Var.x()) {
                this.f.W(tj8Var);
                this.f.X(tj8Var);
            } else if (ho8.d(tj8Var.f())) {
                this.f.V(tj8Var);
                this.f.X(tj8Var);
            } else if (tj8Var.v()) {
                hx4 hx4Var = new hx4();
                hx4Var.e(this.b);
                if (hx4Var.c() == null || this.f.b == null) {
                    return;
                }
                this.f.b.setVcodeMD5(hx4Var.b());
                this.f.b.setVcodeUrl(hx4Var.c());
                NewWriteModel newWriteModel = this.f;
                newWriteModel.Y(tj8Var, null, hx4Var, newWriteModel.b);
            } else if (tj8Var.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.b);
                NewWriteModel newWriteModel2 = this.f;
                newWriteModel2.Y(tj8Var, accessState, null, newWriteModel2.b);
            } else if (tj8Var.w()) {
                this.f.X(tj8Var);
            } else {
                this.f.X(tj8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                wh8 wh8Var = this.a;
                if (wh8Var != null) {
                    wh8Var.b();
                }
                if (this.f.d != null) {
                    this.f.d.callback(false, null, null, this.f.b, null);
                } else if (this.f.c != null) {
                    this.f.c.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x025c, code lost:
            if (r5 != 7) goto L59;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(tj8 tj8Var) {
            String h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tj8Var) == null) {
                super.onPostExecute(tj8Var);
                pj8.a("onPostExecute start");
                pj8.a("发帖： onPostExecute");
                String str = null;
                this.f.a = null;
                if (tj8Var != null && tj8Var.f() != 0) {
                    ws4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", tj8Var.f(), tj8Var.g(), "tid", tj8Var.p(), "pid", tj8Var.l());
                }
                if (!this.c && tj8Var != null) {
                    if (!tj8Var.s()) {
                        if (this.f.b != null) {
                            this.f.b.getType();
                        }
                        pj8.a("onPostExecute success");
                        if (this.f.d == null) {
                            if (this.f.c != null) {
                                this.f.c.a(true, tj8Var.g(), null, null, tj8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(tj8Var.m()) && !StringUtils.isNull(tj8Var.d())) {
                                str = tj8Var.m();
                                h = tj8Var.d();
                            } else if (StringUtils.isNull(tj8Var.h()) && StringUtils.isNull(tj8Var.i())) {
                                h = null;
                            } else {
                                str = tj8Var.i();
                                h = tj8Var.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(tj8Var.f(), tj8Var.g(), str, h);
                            postWriteCallBackData.setThreadId(tj8Var.p());
                            postWriteCallBackData.setPostId(tj8Var.l());
                            postWriteCallBackData.setIsCopyTWZhibo(tj8Var.k());
                            postWriteCallBackData.setErrorString(tj8Var.g());
                            postWriteCallBackData.setActivityDialog(tj8Var.a());
                            postWriteCallBackData.setVideoid(tj8Var.r());
                            postWriteCallBackData.setContriInfo(tj8Var.e());
                            if (this.f.b != null) {
                                postWriteCallBackData.setProZone(this.f.b.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f.b.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(tj8Var.q());
                            postWriteCallBackData.setmAdverSegmentData(tj8Var.b());
                            postWriteCallBackData.setIconStampData(tj8Var.j());
                            hx4 hx4Var = new hx4();
                            hx4Var.e(this.b);
                            if (this.f.b == null || oj8.k().i() == null) {
                                if (this.f.b == null || !this.f.j) {
                                    if (this.f.b != null && this.f.k) {
                                        oj8.k().C(this.f.b.getForumId());
                                        oj8.k().D(this.f.b.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                oj8.k().C(this.f.b.getForumId());
                                oj8.k().D(this.f.b.getForumName());
                                if (this.f.b.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f.b;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, oj8.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                oj8.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && tj8Var.j() == null) {
                                if (this.f.b != null) {
                                    int type = this.f.b.getType();
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
                                qg.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f.d.callback(true, postWriteCallBackData, hx4Var, this.f.b, tj8Var.c());
                        }
                        if (this.f.b != null && !this.f.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(tj8Var.j() == null)));
                        }
                        sk7 sk7Var = this.e;
                        if (sk7Var != null) {
                            sk7Var.c();
                        }
                    } else {
                        pj8.a("onPostExecute error");
                        c(tj8Var);
                        sk7 sk7Var2 = this.e;
                        if (sk7Var2 != null) {
                            sk7Var2.h(tj8Var.a, tj8Var.g());
                        }
                    }
                    pj8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                pj8.a("发帖： onPostExecute isCanceled");
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
        this.l = new c(this);
        this.f = baseFragmentActivity.getPageContext();
    }

    public boolean R() {
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

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a == null) {
            if (oj8.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, T());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, oj8.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.a = new f(this);
            pj8.a("dealPost()");
            nj8.l(this.b);
            this.a.execute(new Integer[0]);
        }
    }

    public WriteData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (WriteData) invokeV.objValue;
    }

    public void U() {
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

    public final void V(tj8 tj8Var) {
        d9<?> d9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tj8Var) == null) || (d9Var = this.f) == null || tj8Var == null || (this.d instanceof oj8)) {
            return;
        }
        ho8.e(d9Var.getPageActivity(), tj8Var.g());
        tj8Var.C(null);
    }

    public final void W(tj8 tj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tj8Var) == null) || this.f == null || tj8Var == null || tj8Var.c() == null || tj8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), tj8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void X(tj8 tj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tj8Var) == null) {
            Y(tj8Var, null, null, this.b);
        }
    }

    public final void Y(tj8 tj8Var, AccessState accessState, hx4 hx4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, tj8Var, accessState, hx4Var, writeData) == null) || tj8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(tj8Var.f(), tj8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(tj8Var.o());
            postWriteCallBackData.setReplyPrivacyTip(tj8Var.n());
            this.d.callback(false, postWriteCallBackData, hx4Var, writeData, tj8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, tj8Var.g(), hx4Var, writeData, tj8Var.c());
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    public void c0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            f fVar = this.a;
            if (fVar == null || fVar.isCancelled()) {
                return false;
            }
            this.a.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0(@Nullable d9<?> d9Var) {
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

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            pj8.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            S();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (ni.z() && !ni.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !ht4.k().h("original_img_up_tip", false)) {
                ht4.k().u("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                TiebaStatic.log(param.param("obj_type", writeData != null ? writeData.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d9<?> d9Var = this.f;
                if (d9Var == null) {
                    StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
                    WriteData writeData2 = this.b;
                    TiebaStatic.log(param2.param("obj_type", writeData2 != null ? writeData2.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    S();
                    return true;
                }
                nq4 nq4Var = new nq4(d9Var.getPageActivity());
                nq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d0b);
                nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new a(this, nq4Var));
                nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this, nq4Var));
                nq4Var.create(this.f);
                nq4Var.show();
            } else {
                StatisticItem param3 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
                WriteData writeData3 = this.b;
                TiebaStatic.log(param3.param("obj_type", writeData3 != null ? writeData3.getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                S();
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
        this.l = new c(this);
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
        this.l = new c(this);
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
        this.l = new c(this);
        this.f = null;
    }
}
