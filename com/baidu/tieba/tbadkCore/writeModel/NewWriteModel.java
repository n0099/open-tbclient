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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.mutiprocess.replay.ReplayEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a55;
import com.repackage.b9;
import com.repackage.bj8;
import com.repackage.dq4;
import com.repackage.eh8;
import com.repackage.fi8;
import com.repackage.hj7;
import com.repackage.ji;
import com.repackage.jp4;
import com.repackage.ki;
import com.repackage.lj7;
import com.repackage.lo7;
import com.repackage.me8;
import com.repackage.mg;
import com.repackage.ns4;
import com.repackage.pq7;
import com.repackage.ry4;
import com.repackage.v25;
import com.repackage.vi8;
import com.repackage.wi8;
import com.repackage.ww4;
import com.repackage.xi8;
import com.repackage.ys4;
import com.repackage.zn8;
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
    public b9<?> f;
    public eh8.c g;
    public SpanGroupManager h;
    public String i;
    public boolean j;
    public boolean k;
    public fi8.c l;

    /* loaded from: classes4.dex */
    public class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, dq4Var};
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
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
                this.b.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, dq4Var};
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
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends fi8.c {
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

        @Override // com.repackage.fi8.c
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
                this.a.e0();
            }
        }

        @Override // com.repackage.fi8.c
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
                this.a.e0();
            }
        }

        @Override // com.repackage.fi8.c
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

        @Override // com.repackage.fi8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null) {
                    this.a.a = null;
                    this.a.b.setAuthSid(null);
                    this.a.e0();
                } else if (this.a.d != null) {
                    this.a.d.callback(false, null, null, this.a.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, String str, ww4 ww4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Integer, Integer, bj8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public eh8 a;
        public String b;
        public boolean c;
        public lj7 d;
        public hj7 e;
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
                    pq7.a((TbPageContext) this.b.f.f, this.a).show();
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lj7.class);
            if (runTask != null) {
                this.d = (lj7) runTask.getData();
            }
            lj7 lj7Var = this.d;
            if (lj7Var != null) {
                this.e = lj7Var.get();
            }
            setPriority(3);
            xi8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x030c  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public bj8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            bj8 bj8Var;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            ry4 ry4Var;
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
                v25.e(this.f.b.getContent());
                xi8.a("doInBackground() start");
                xi8.a("发帖：任务后台执行 开始 doInBackground");
                eh8 eh8Var = new eh8();
                this.a = eh8Var;
                eh8Var.i(this.f.h);
                this.a.j(this.f.i);
                this.a.k(this.e);
                this.a.h(this.f.g);
                this.b = this.a.g(this.f.b, this.f.e);
                xi8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d = this.a.d();
                vi8.c(this.f.b, d);
                if (this.a.e() && this.b != null) {
                    xi8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c = this.a.c();
                    String error_msg = d.getError_msg();
                    if (ki.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f1117);
                    }
                    bj8Var = new bj8(d.getError_code(), error_msg, c);
                    if (this.f.b != null && this.f.b.isHasImages() && !bj8Var.s()) {
                        this.f.b.deleteUploadedTempImages();
                    }
                    xi8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d != null && d.error_code == 220015) {
                    bj8Var = new bj8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                bj8Var.K(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    xi8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d != null && d.error_code == 238010) {
                    bj8Var = new bj8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                jp4 jp4Var = new jp4();
                                jp4Var.a = optJSONObject2.optString("block_content");
                                jp4Var.b = optJSONObject2.optString("block_cancel");
                                jp4Var.c = optJSONObject2.optString("block_confirm");
                                bj8Var.J(jp4Var);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    xi8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d != null && d.error_code != 0) {
                    String error_msg2 = d.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f027c);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f110c);
                        }
                    }
                    bj8Var = new bj8(d.getError_code(), error_msg2, this.a.c());
                    xi8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    bj8Var = new bj8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c33), null);
                    xi8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!bj8Var.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.b != null) {
                            JSONObject jSONObject = new JSONObject(this.b);
                            String optString = jSONObject.optString("msg");
                            try {
                                str4 = jSONObject.optString("pre_msg");
                            } catch (JSONException e3) {
                                e = e3;
                                str3 = optString;
                                ry4Var = null;
                                str = null;
                                str2 = null;
                                videoEasterEggData = null;
                                str4 = null;
                            }
                            try {
                                str5 = jSONObject.optString("color_msg");
                            } catch (JSONException e4) {
                                e = e4;
                                str3 = optString;
                                ry4Var = null;
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
                                bj8Var.C(str3);
                                bj8Var.I(str4);
                                bj8Var.A(str5);
                                bj8Var.L(str6);
                                bj8Var.H(str7);
                                bj8Var.G(r7);
                                bj8Var.E(str2);
                                bj8Var.D(str);
                                bj8Var.y(customDialogData);
                                bj8Var.N(str8);
                                bj8Var.B(contriInfo);
                                bj8Var.M(videoEasterEggData);
                                bj8Var.z(ry4Var);
                                bj8Var.F(iconStampData);
                                xi8.a("doInBackground end");
                                xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return bj8Var;
                            }
                            try {
                                str6 = jSONObject.optString("tid");
                                try {
                                    str7 = jSONObject.optString("pid");
                                } catch (JSONException e5) {
                                    e = e5;
                                    str3 = optString;
                                    ry4Var = null;
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
                                    bj8Var.C(str3);
                                    bj8Var.I(str4);
                                    bj8Var.A(str5);
                                    bj8Var.L(str6);
                                    bj8Var.H(str7);
                                    bj8Var.G(r7);
                                    bj8Var.E(str2);
                                    bj8Var.D(str);
                                    bj8Var.y(customDialogData);
                                    bj8Var.N(str8);
                                    bj8Var.B(contriInfo);
                                    bj8Var.M(videoEasterEggData);
                                    bj8Var.z(ry4Var);
                                    bj8Var.F(iconStampData);
                                    xi8.a("doInBackground end");
                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return bj8Var;
                                }
                                try {
                                    str8 = jSONObject.optString("video_id");
                                } catch (JSONException e6) {
                                    e = e6;
                                    str3 = optString;
                                    ry4Var = null;
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
                                    bj8Var.C(str3);
                                    bj8Var.I(str4);
                                    bj8Var.A(str5);
                                    bj8Var.L(str6);
                                    bj8Var.H(str7);
                                    bj8Var.G(r7);
                                    bj8Var.E(str2);
                                    bj8Var.D(str);
                                    bj8Var.y(customDialogData);
                                    bj8Var.N(str8);
                                    bj8Var.B(contriInfo);
                                    bj8Var.M(videoEasterEggData);
                                    bj8Var.z(ry4Var);
                                    bj8Var.F(iconStampData);
                                    xi8.a("doInBackground end");
                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return bj8Var;
                                }
                                try {
                                    customDialogData = lo7.a(jSONObject);
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
                                                ry4Var = null;
                                                str = null;
                                                videoEasterEggData = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                bj8Var.C(str3);
                                                bj8Var.I(str4);
                                                bj8Var.A(str5);
                                                bj8Var.L(str6);
                                                bj8Var.H(str7);
                                                bj8Var.G(r7);
                                                bj8Var.E(str2);
                                                bj8Var.D(str);
                                                bj8Var.y(customDialogData);
                                                bj8Var.N(str8);
                                                bj8Var.B(contriInfo);
                                                bj8Var.M(videoEasterEggData);
                                                bj8Var.z(ry4Var);
                                                bj8Var.F(iconStampData);
                                                xi8.a("doInBackground end");
                                                xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return bj8Var;
                                            }
                                        } else {
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
                                                } catch (JSONException e8) {
                                                    e = e8;
                                                    str3 = optString;
                                                    ry4Var = null;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    bj8Var.C(str3);
                                                    bj8Var.I(str4);
                                                    bj8Var.A(str5);
                                                    bj8Var.L(str6);
                                                    bj8Var.H(str7);
                                                    bj8Var.G(r7);
                                                    bj8Var.E(str2);
                                                    bj8Var.D(str);
                                                    bj8Var.y(customDialogData);
                                                    bj8Var.N(str8);
                                                    bj8Var.B(contriInfo);
                                                    bj8Var.M(videoEasterEggData);
                                                    bj8Var.z(ry4Var);
                                                    bj8Var.F(iconStampData);
                                                    xi8.a("doInBackground end");
                                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return bj8Var;
                                                }
                                            } else {
                                                videoEasterEggData = null;
                                            }
                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                            if (optJSONObject6 != null) {
                                                ry4Var = new ry4();
                                                try {
                                                    ry4Var.p(optJSONObject6);
                                                } catch (JSONException e9) {
                                                    e = e9;
                                                    str3 = optString;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    bj8Var.C(str3);
                                                    bj8Var.I(str4);
                                                    bj8Var.A(str5);
                                                    bj8Var.L(str6);
                                                    bj8Var.H(str7);
                                                    bj8Var.G(r7);
                                                    bj8Var.E(str2);
                                                    bj8Var.D(str);
                                                    bj8Var.y(customDialogData);
                                                    bj8Var.N(str8);
                                                    bj8Var.B(contriInfo);
                                                    bj8Var.M(videoEasterEggData);
                                                    bj8Var.z(ry4Var);
                                                    bj8Var.F(iconStampData);
                                                    xi8.a("doInBackground end");
                                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return bj8Var;
                                                }
                                            } else {
                                                ry4Var = null;
                                            }
                                            JSONObject optJSONObject7 = jSONObject.optJSONObject("icon_stamp_info");
                                            if (optJSONObject7 != null) {
                                                IconStampData iconStampData2 = new IconStampData();
                                                try {
                                                    iconStampData2.parseJson(optJSONObject7);
                                                    iconStampData = iconStampData2;
                                                    str3 = optString;
                                                } catch (JSONException e10) {
                                                    jSONException = e10;
                                                    iconStampData = iconStampData2;
                                                    str3 = optString;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    bj8Var.C(str3);
                                                    bj8Var.I(str4);
                                                    bj8Var.A(str5);
                                                    bj8Var.L(str6);
                                                    bj8Var.H(str7);
                                                    bj8Var.G(r7);
                                                    bj8Var.E(str2);
                                                    bj8Var.D(str);
                                                    bj8Var.y(customDialogData);
                                                    bj8Var.N(str8);
                                                    bj8Var.B(contriInfo);
                                                    bj8Var.M(videoEasterEggData);
                                                    bj8Var.z(ry4Var);
                                                    bj8Var.F(iconStampData);
                                                    xi8.a("doInBackground end");
                                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return bj8Var;
                                                }
                                            } else {
                                                str3 = optString;
                                                iconStampData = null;
                                            }
                                        } catch (JSONException e11) {
                                            e = e11;
                                            str3 = optString;
                                            ry4Var = null;
                                            videoEasterEggData = null;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            bj8Var.C(str3);
                                            bj8Var.I(str4);
                                            bj8Var.A(str5);
                                            bj8Var.L(str6);
                                            bj8Var.H(str7);
                                            bj8Var.G(r7);
                                            bj8Var.E(str2);
                                            bj8Var.D(str);
                                            bj8Var.y(customDialogData);
                                            bj8Var.N(str8);
                                            bj8Var.B(contriInfo);
                                            bj8Var.M(videoEasterEggData);
                                            bj8Var.z(ry4Var);
                                            bj8Var.F(iconStampData);
                                            xi8.a("doInBackground end");
                                            xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return bj8Var;
                                        }
                                    } catch (JSONException e12) {
                                        e = e12;
                                        str3 = optString;
                                        ry4Var = null;
                                        str = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
                                    str3 = optString;
                                    ry4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    bj8Var.C(str3);
                                    bj8Var.I(str4);
                                    bj8Var.A(str5);
                                    bj8Var.L(str6);
                                    bj8Var.H(str7);
                                    bj8Var.G(r7);
                                    bj8Var.E(str2);
                                    bj8Var.D(str);
                                    bj8Var.y(customDialogData);
                                    bj8Var.N(str8);
                                    bj8Var.B(contriInfo);
                                    bj8Var.M(videoEasterEggData);
                                    bj8Var.z(ry4Var);
                                    bj8Var.F(iconStampData);
                                    xi8.a("doInBackground end");
                                    xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return bj8Var;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str3 = optString;
                                ry4Var = null;
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
                                bj8Var.C(str3);
                                bj8Var.I(str4);
                                bj8Var.A(str5);
                                bj8Var.L(str6);
                                bj8Var.H(str7);
                                bj8Var.G(r7);
                                bj8Var.E(str2);
                                bj8Var.D(str);
                                bj8Var.y(customDialogData);
                                bj8Var.N(str8);
                                bj8Var.B(contriInfo);
                                bj8Var.M(videoEasterEggData);
                                bj8Var.z(ry4Var);
                                bj8Var.F(iconStampData);
                                xi8.a("doInBackground end");
                                xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return bj8Var;
                            }
                        } else {
                            iconStampData = null;
                            ry4Var = null;
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
                        ry4Var = null;
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
                        str3 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1117);
                    }
                    bj8Var.C(str3);
                    bj8Var.I(str4);
                    bj8Var.A(str5);
                    bj8Var.L(str6);
                    bj8Var.H(str7);
                    bj8Var.G(r7);
                    bj8Var.E(str2);
                    bj8Var.D(str);
                    bj8Var.y(customDialogData);
                    bj8Var.N(str8);
                    bj8Var.B(contriInfo);
                    bj8Var.M(videoEasterEggData);
                    bj8Var.z(ry4Var);
                    bj8Var.F(iconStampData);
                }
                xi8.a("doInBackground end");
                xi8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return bj8Var;
            }
            return (bj8) invokeL.objValue;
        }

        public final void c(bj8 bj8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bj8Var) == null) || fi8.a(bj8Var.f(), AuthTokenData.parse(this.b), this.f.l)) {
                return;
            }
            if (bj8Var.u()) {
                this.f.W(bj8Var);
            } else if (bj8Var.x()) {
                this.f.V(bj8Var);
                this.f.W(bj8Var);
            } else if (zn8.d(bj8Var.f())) {
                this.f.U(bj8Var);
                this.f.W(bj8Var);
            } else if (bj8Var.v()) {
                ww4 ww4Var = new ww4();
                ww4Var.e(this.b);
                if (ww4Var.c() == null || this.f.b == null) {
                    return;
                }
                this.f.b.setVcodeMD5(ww4Var.b());
                this.f.b.setVcodeUrl(ww4Var.c());
                NewWriteModel newWriteModel = this.f;
                newWriteModel.X(bj8Var, null, ww4Var, newWriteModel.b);
            } else if (bj8Var.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.b);
                NewWriteModel newWriteModel2 = this.f;
                newWriteModel2.X(bj8Var, accessState, null, newWriteModel2.b);
            } else if (bj8Var.w()) {
                this.f.W(bj8Var);
            } else {
                this.f.W(bj8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                eh8 eh8Var = this.a;
                if (eh8Var != null) {
                    eh8Var.b();
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
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0265, code lost:
            if (r9 != 7) goto L59;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(bj8 bj8Var) {
            String h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bj8Var) == null) {
                super.onPostExecute(bj8Var);
                xi8.a("onPostExecute start");
                xi8.a("发帖： onPostExecute");
                String str = null;
                this.f.a = null;
                if (bj8Var != null && bj8Var.f() != 0) {
                    ns4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bj8Var.f(), bj8Var.g(), "tid", bj8Var.p(), "pid", bj8Var.l());
                }
                if (!this.c && bj8Var != null) {
                    if (!bj8Var.s()) {
                        int type = this.f.b != null ? this.f.b.getType() : Integer.MIN_VALUE;
                        xi8.a("onPostExecute success");
                        if (this.f.d == null) {
                            if (this.f.c != null) {
                                this.f.c.a(true, bj8Var.g(), null, null, bj8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(bj8Var.m()) && !StringUtils.isNull(bj8Var.d())) {
                                str = bj8Var.m();
                                h = bj8Var.d();
                            } else if (StringUtils.isNull(bj8Var.h()) && StringUtils.isNull(bj8Var.i())) {
                                h = null;
                            } else {
                                str = bj8Var.i();
                                h = bj8Var.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bj8Var.f(), bj8Var.g(), str, h);
                            postWriteCallBackData.setThreadId(bj8Var.p());
                            postWriteCallBackData.setPostId(bj8Var.l());
                            postWriteCallBackData.setIsCopyTWZhibo(bj8Var.k());
                            postWriteCallBackData.setErrorString(bj8Var.g());
                            postWriteCallBackData.setActivityDialog(bj8Var.a());
                            postWriteCallBackData.setVideoid(bj8Var.r());
                            postWriteCallBackData.setContriInfo(bj8Var.e());
                            if (this.f.b != null) {
                                postWriteCallBackData.setProZone(this.f.b.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f.b.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(bj8Var.q());
                            postWriteCallBackData.setmAdverSegmentData(bj8Var.b());
                            postWriteCallBackData.setIconStampData(bj8Var.j());
                            ww4 ww4Var = new ww4();
                            ww4Var.e(this.b);
                            if (this.f.b == null || wi8.k().i() == null) {
                                if (this.f.b == null || !this.f.j) {
                                    if (this.f.b != null && this.f.k) {
                                        wi8.k().C(this.f.b.getForumId());
                                        wi8.k().D(this.f.b.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                wi8.k().C(this.f.b.getForumId());
                                wi8.k().D(this.f.b.getForumName());
                                if (this.f.b.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f.b;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, wi8.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                wi8.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && bj8Var.j() == null) {
                                if (this.f.b != null) {
                                    int type2 = this.f.b.getType();
                                    if (type2 != 0) {
                                        if (type2 == 1 || type2 == 2) {
                                            activityDialog.type = 1;
                                        } else if (type2 != 4) {
                                            if (type2 != 9) {
                                                if (type2 != 6) {
                                                }
                                            }
                                        }
                                    }
                                    activityDialog.type = 2;
                                }
                                mg.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f.d.callback(true, postWriteCallBackData, ww4Var, this.f.b, bj8Var.c());
                        }
                        if (this.f.b != null && !this.f.b.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(bj8Var.j() == null)));
                        }
                        hj7 hj7Var = this.e;
                        if (hj7Var != null) {
                            hj7Var.c();
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (!TbadkCoreApplication.getInst().isMainProcess(true) && (type == 1 || type == 2)) {
                                a55.i(new ReplayEvent());
                            } else if (type == 1 || type == 2) {
                                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                                    me8.r().A(0, 3);
                                    me8.r().G();
                                }
                                me8.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                        }
                    } else {
                        xi8.a("onPostExecute error");
                        c(bj8Var);
                        hj7 hj7Var2 = this.e;
                        if (hj7Var2 != null) {
                            hj7Var2.h(bj8Var.a, bj8Var.g());
                        }
                    }
                    xi8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                xi8.a("发帖： onPostExecute isCanceled");
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
                super((b9) newInitContext.callArgs[0]);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a == null) {
            if (wi8.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, S());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, wi8.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.a = new f(this);
            xi8.a("dealPost()");
            vi8.l(this.b);
            this.a.execute(new Integer[0]);
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
            SpanGroupManager spanGroupManager = this.h;
            if (spanGroupManager != null) {
                this.i = spanGroupManager.E();
            } else {
                this.i = null;
            }
        }
    }

    public final void U(bj8 bj8Var) {
        b9<?> b9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bj8Var) == null) || (b9Var = this.f) == null || bj8Var == null || (this.d instanceof wi8)) {
            return;
        }
        zn8.e(b9Var.getPageActivity(), bj8Var.g());
        bj8Var.C(null);
    }

    public final void V(bj8 bj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bj8Var) == null) || this.f == null || bj8Var == null || bj8Var.c() == null || bj8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.f.getPageActivity(), bj8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void W(bj8 bj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bj8Var) == null) {
            X(bj8Var, null, null, this.b);
        }
    }

    public final void X(bj8 bj8Var, AccessState accessState, ww4 ww4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, bj8Var, accessState, ww4Var, writeData) == null) || bj8Var == null) {
            return;
        }
        if (this.d != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bj8Var.f(), bj8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(bj8Var.o());
            postWriteCallBackData.setReplyPrivacyTip(bj8Var.n());
            this.d.callback(false, postWriteCallBackData, ww4Var, writeData, bj8Var.c());
            return;
        }
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(false, bj8Var.g(), ww4Var, writeData, bj8Var.c());
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e = z;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    public void b0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public void c0(@Nullable b9<?> b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b9Var) == null) {
            if (b9Var != null) {
                this.f = b9Var;
                this.unique_id = b9Var.getUniqueId();
                return;
            }
            this.f = null;
            this.unique_id = null;
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            f fVar = this.a;
            if (fVar == null || fVar.isCancelled()) {
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
            xi8.a("发帖：开始上传");
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
                return false;
            }
            if (ji.z() && !ji.H() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !ys4.k().h("original_img_up_tip", false)) {
                ys4.k().u("original_img_up_tip", true);
                b9<?> b9Var = this.f;
                if (b9Var == null) {
                    R();
                    return true;
                }
                dq4 dq4Var = new dq4(b9Var.getPageActivity());
                dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d06);
                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new a(this, dq4Var));
                dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this, dq4Var));
                dq4Var.create(this.f);
                dq4Var.show();
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
                super((b9) newInitContext.callArgs[0]);
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
                super((b9) newInitContext.callArgs[0]);
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
