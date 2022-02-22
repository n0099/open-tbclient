package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.t0.s.r.l1;
import c.a.t0.s.r.w1;
import c.a.t0.s.t.a;
import c.a.t0.t.c.o0;
import c.a.u0.a4.j;
import c.a.u0.j2.k;
import c.a.u0.z3.l0.a;
import c.a.u0.z3.q0.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.mutiprocess.replay.ReplayEvent;
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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f48411e;

    /* renamed from: f  reason: collision with root package name */
    public d f48412f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f48413g;

    /* renamed from: h  reason: collision with root package name */
    public String f48414h;

    /* renamed from: i  reason: collision with root package name */
    public String f48415i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f48416j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public c.a.d.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public boolean s;
    public boolean t;
    public f.c u;

    /* loaded from: classes13.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s.t.a f48417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48418f;

        public a(NewWriteModel newWriteModel, c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48418f = newWriteModel;
            this.f48417e = aVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48417e.dismiss();
                this.f48418f.X();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s.t.a f48419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48420f;

        public b(NewWriteModel newWriteModel, c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48420f = newWriteModel;
            this.f48419e = aVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48419e.dismiss();
                this.f48420f.cancel();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c extends f.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteModel;
        }

        @Override // c.a.u0.z3.q0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.f48413g == null || TextUtils.isEmpty(str)) {
                    if (this.a.m != null) {
                        this.a.m.callback(false, null, null, this.a.f48413g, null);
                        return;
                    }
                    return;
                }
                this.a.f48411e = null;
                this.a.f48413g.setAuthSid(str);
                this.a.p0();
            }
        }

        @Override // c.a.u0.z3.q0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.f48413g == null || TextUtils.isEmpty(str)) {
                    if (this.a.m != null) {
                        this.a.m.callback(false, null, null, this.a.f48413g, null);
                        return;
                    }
                    return;
                }
                this.a.f48411e = null;
                this.a.f48413g.setAuthSid(str);
                this.a.p0();
            }
        }

        @Override // c.a.u0.z3.q0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.f48413g != null) {
                    this.a.f48413g.setAuthSid(null);
                }
                if (this.a.m != null) {
                    this.a.m.callback(false, null, null, this.a.f48413g, null);
                }
            }
        }

        @Override // c.a.u0.z3.q0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f48413g != null) {
                    this.a.f48411e = null;
                    this.a.f48413g.setAuthSid(null);
                    this.a.p0();
                } else if (this.a.m != null) {
                    this.a.m.callback(false, null, null, this.a.f48413g, null);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.u0.z3.l0.a f48421b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f48422c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48423d;

        public d(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48423d = newWriteModel;
            this.a = false;
            this.f48421b = new c.a.u0.z3.l0.a();
            this.f48422c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f48423d.f48415i);
                if (this.a) {
                    return null;
                }
                if (this.f48423d.f48416j == null || this.f48423d.f48416j.length <= 0) {
                    if (TextUtils.isEmpty(this.f48423d.f48415i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f48423d.f48414h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f48423d.f48415i));
                    if (TextUtils.isEmpty(this.f48423d.f48414h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f48423d;
                    return newWriteModel.Y(newWriteModel.f48414h, this.f48421b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f48423d.f48416j);
                this.f48422c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f48423d.f48414h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f48423d.f48414h)) {
                    Bitmap bitmap = this.f48422c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f48422c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f48423d;
                return newWriteModel2.Y(newWriteModel2.f48414h, this.f48421b);
            }
            return (ImageUploadResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageUploadResult) == null) {
                super.onPostExecute(imageUploadResult);
                if (this.a) {
                    return;
                }
                if (this.f48423d.k != null) {
                    this.f48423d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f48422c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f48422c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                c.a.u0.z3.l0.a aVar = this.f48421b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f48423d.k != null) {
                    this.f48423d.k.a(null, true);
                }
                Bitmap bitmap = this.f48422c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f48422c.recycle();
                }
                super.cancel();
                this.f48423d.f48412f = null;
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes13.dex */
    public interface f {
        void a(boolean z, String str, o0 o0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes13.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o0 o0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes13.dex */
    public class h extends BdAsyncTask<Integer, Integer, c.a.u0.z3.t0.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.u0.z3.l0.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f48424b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48425c;

        /* renamed from: d  reason: collision with root package name */
        public k f48426d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.u0.j2.g f48427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48428f;

        /* loaded from: classes13.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f48429e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f48430f;

            public a(h hVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48430f = hVar;
                this.f48429e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u0.u2.t.c.a((TbPageContext) this.f48430f.f48428f.o, this.f48429e).show();
                }
            }
        }

        public h(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48428f = newWriteModel;
            this.a = null;
            this.f48424b = null;
            this.f48425c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f48426d = (k) runTask.getData();
            }
            k kVar = this.f48426d;
            if (kVar != null) {
                this.f48427e = kVar.get();
            }
            setPriority(3);
            c.a.u0.z3.t0.c.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0302  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c.a.u0.z3.t0.g doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            c.a.u0.z3.t0.g gVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            c.a.t0.u.a aVar;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            CustomDialogData customDialogData;
            VideoEasterEggData videoEasterEggData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                if (this.f48425c) {
                    return null;
                }
                c.a.t0.c0.d.c(this.f48428f.f48413g.getContent());
                c.a.u0.z3.t0.c.a("doInBackground() start");
                c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground");
                c.a.u0.z3.l0.a aVar2 = new c.a.u0.z3.l0.a();
                this.a = aVar2;
                aVar2.j(this.f48428f.q);
                this.a.k(this.f48428f.r);
                this.a.l(this.f48427e);
                this.a.i(this.f48428f.p);
                this.f48424b = this.a.h(this.f48428f.f48413g, this.f48428f.n);
                c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.a.d();
                c.a.u0.z3.t0.a.c(this.f48428f.f48413g, d2);
                if (this.a.e() && this.f48424b != null) {
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.a.c();
                    String error_msg = d2.getError_msg();
                    if (m.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(j.send_success);
                    }
                    gVar = new c.a.u0.z3.t0.g(d2.getError_code(), error_msg, c2);
                    if (this.f48428f.f48413g != null && this.f48428f.f48413g.isHasImages() && !gVar.s()) {
                        this.f48428f.f48413g.deleteUploadedTempImages();
                    }
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    gVar = new c.a.u0.z3.t0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f48424b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f48424b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i2 = 0; i2 < length; i2++) {
                                    arrayList.add(jSONArray.optString(i2));
                                }
                                gVar.K(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    gVar = new c.a.u0.z3.t0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f48424b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f48424b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                w1 w1Var = new w1();
                                w1Var.a = optJSONObject2.optString("block_content");
                                w1Var.f13986b = optJSONObject2.optString("block_cancel");
                                w1Var.f13987c = optJSONObject2.optString("block_confirm");
                                gVar.J(w1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(j.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(j.send_error);
                        }
                    }
                    gVar = new c.a.u0.z3.t0.g(d2.getError_code(), error_msg2, this.a.c());
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    gVar = new c.a.u0.z3.t0.g(-17, TbadkCoreApplication.getInst().getApp().getString(j.neterror), null);
                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!gVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f48424b != null) {
                            JSONObject jSONObject = new JSONObject(this.f48424b);
                            String optString = jSONObject.optString("msg");
                            try {
                                str4 = jSONObject.optString("pre_msg");
                                try {
                                    str5 = jSONObject.optString("color_msg");
                                    try {
                                        str6 = jSONObject.optString("tid");
                                    } catch (JSONException e4) {
                                        e = e4;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        customDialogData = null;
                                        videoEasterEggData = null;
                                        jSONException = e;
                                        iconStampData = null;
                                        jSONException.printStackTrace();
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        gVar.C(str3);
                                        gVar.I(str4);
                                        gVar.A(str5);
                                        gVar.L(str6);
                                        gVar.H(str7);
                                        gVar.G(r6);
                                        gVar.E(str2);
                                        gVar.D(str);
                                        gVar.y(customDialogData);
                                        gVar.N(str8);
                                        gVar.B(contriInfo);
                                        gVar.M(videoEasterEggData);
                                        gVar.z(aVar);
                                        gVar.F(iconStampData);
                                        c.a.u0.z3.t0.c.a("doInBackground end");
                                        c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return gVar;
                                    }
                                    try {
                                        str7 = jSONObject.optString("pid");
                                    } catch (JSONException e5) {
                                        e = e5;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                        str7 = null;
                                        str8 = null;
                                        customDialogData = null;
                                        videoEasterEggData = null;
                                        jSONException = e;
                                        iconStampData = null;
                                        jSONException.printStackTrace();
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        gVar.C(str3);
                                        gVar.I(str4);
                                        gVar.A(str5);
                                        gVar.L(str6);
                                        gVar.H(str7);
                                        gVar.G(r6);
                                        gVar.E(str2);
                                        gVar.D(str);
                                        gVar.y(customDialogData);
                                        gVar.N(str8);
                                        gVar.B(contriInfo);
                                        gVar.M(videoEasterEggData);
                                        gVar.z(aVar);
                                        gVar.F(iconStampData);
                                        c.a.u0.z3.t0.c.a("doInBackground end");
                                        c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return gVar;
                                    }
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                        try {
                                            customDialogData = c.a.u0.u2.b.a(jSONObject);
                                            try {
                                                JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                                r6 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                                                JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                                if (optJSONObject4 != null) {
                                                    str2 = optJSONObject4.optString("pre_msg");
                                                    try {
                                                        str = optJSONObject4.optString("color_msg");
                                                    } catch (JSONException e6) {
                                                        e = e6;
                                                        str3 = optString;
                                                        aVar = null;
                                                        str = null;
                                                        videoEasterEggData = null;
                                                        jSONException = e;
                                                        iconStampData = null;
                                                        jSONException.printStackTrace();
                                                        if (StringUtils.isNull(str3)) {
                                                        }
                                                        gVar.C(str3);
                                                        gVar.I(str4);
                                                        gVar.A(str5);
                                                        gVar.L(str6);
                                                        gVar.H(str7);
                                                        gVar.G(r6);
                                                        gVar.E(str2);
                                                        gVar.D(str);
                                                        gVar.y(customDialogData);
                                                        gVar.N(str8);
                                                        gVar.B(contriInfo);
                                                        gVar.M(videoEasterEggData);
                                                        gVar.z(aVar);
                                                        gVar.F(iconStampData);
                                                        c.a.u0.z3.t0.c.a("doInBackground end");
                                                        c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                        return gVar;
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
                                                        } catch (JSONException e7) {
                                                            e = e7;
                                                            str3 = optString;
                                                            aVar = null;
                                                            jSONException = e;
                                                            iconStampData = null;
                                                            jSONException.printStackTrace();
                                                            if (StringUtils.isNull(str3)) {
                                                            }
                                                            gVar.C(str3);
                                                            gVar.I(str4);
                                                            gVar.A(str5);
                                                            gVar.L(str6);
                                                            gVar.H(str7);
                                                            gVar.G(r6);
                                                            gVar.E(str2);
                                                            gVar.D(str);
                                                            gVar.y(customDialogData);
                                                            gVar.N(str8);
                                                            gVar.B(contriInfo);
                                                            gVar.M(videoEasterEggData);
                                                            gVar.z(aVar);
                                                            gVar.F(iconStampData);
                                                            c.a.u0.z3.t0.c.a("doInBackground end");
                                                            c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return gVar;
                                                        }
                                                    } else {
                                                        videoEasterEggData = null;
                                                    }
                                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                                    if (optJSONObject6 != null) {
                                                        aVar = new c.a.t0.u.a();
                                                        try {
                                                            aVar.p(optJSONObject6);
                                                        } catch (JSONException e8) {
                                                            e = e8;
                                                            str3 = optString;
                                                            jSONException = e;
                                                            iconStampData = null;
                                                            jSONException.printStackTrace();
                                                            if (StringUtils.isNull(str3)) {
                                                            }
                                                            gVar.C(str3);
                                                            gVar.I(str4);
                                                            gVar.A(str5);
                                                            gVar.L(str6);
                                                            gVar.H(str7);
                                                            gVar.G(r6);
                                                            gVar.E(str2);
                                                            gVar.D(str);
                                                            gVar.y(customDialogData);
                                                            gVar.N(str8);
                                                            gVar.B(contriInfo);
                                                            gVar.M(videoEasterEggData);
                                                            gVar.z(aVar);
                                                            gVar.F(iconStampData);
                                                            c.a.u0.z3.t0.c.a("doInBackground end");
                                                            c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return gVar;
                                                        }
                                                    } else {
                                                        aVar = null;
                                                    }
                                                    JSONObject optJSONObject7 = jSONObject.optJSONObject("icon_stamp_info");
                                                    if (optJSONObject7 != null) {
                                                        IconStampData iconStampData2 = new IconStampData();
                                                        try {
                                                            iconStampData2.parseJson(optJSONObject7);
                                                            iconStampData = iconStampData2;
                                                            str3 = optString;
                                                        } catch (JSONException e9) {
                                                            jSONException = e9;
                                                            iconStampData = iconStampData2;
                                                            str3 = optString;
                                                            jSONException.printStackTrace();
                                                            if (StringUtils.isNull(str3)) {
                                                            }
                                                            gVar.C(str3);
                                                            gVar.I(str4);
                                                            gVar.A(str5);
                                                            gVar.L(str6);
                                                            gVar.H(str7);
                                                            gVar.G(r6);
                                                            gVar.E(str2);
                                                            gVar.D(str);
                                                            gVar.y(customDialogData);
                                                            gVar.N(str8);
                                                            gVar.B(contriInfo);
                                                            gVar.M(videoEasterEggData);
                                                            gVar.z(aVar);
                                                            gVar.F(iconStampData);
                                                            c.a.u0.z3.t0.c.a("doInBackground end");
                                                            c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return gVar;
                                                        }
                                                    } else {
                                                        str3 = optString;
                                                        iconStampData = null;
                                                    }
                                                } catch (JSONException e10) {
                                                    e = e10;
                                                    str3 = optString;
                                                    aVar = null;
                                                    videoEasterEggData = null;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    gVar.C(str3);
                                                    gVar.I(str4);
                                                    gVar.A(str5);
                                                    gVar.L(str6);
                                                    gVar.H(str7);
                                                    gVar.G(r6);
                                                    gVar.E(str2);
                                                    gVar.D(str);
                                                    gVar.y(customDialogData);
                                                    gVar.N(str8);
                                                    gVar.B(contriInfo);
                                                    gVar.M(videoEasterEggData);
                                                    gVar.z(aVar);
                                                    gVar.F(iconStampData);
                                                    c.a.u0.z3.t0.c.a("doInBackground end");
                                                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return gVar;
                                                }
                                            } catch (JSONException e11) {
                                                e = e11;
                                                str3 = optString;
                                                aVar = null;
                                                str = null;
                                                str2 = null;
                                            }
                                        } catch (JSONException e12) {
                                            e = e12;
                                            str3 = optString;
                                            aVar = null;
                                            str = null;
                                            str2 = null;
                                            customDialogData = null;
                                            videoEasterEggData = null;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            gVar.C(str3);
                                            gVar.I(str4);
                                            gVar.A(str5);
                                            gVar.L(str6);
                                            gVar.H(str7);
                                            gVar.G(r6);
                                            gVar.E(str2);
                                            gVar.D(str);
                                            gVar.y(customDialogData);
                                            gVar.N(str8);
                                            gVar.B(contriInfo);
                                            gVar.M(videoEasterEggData);
                                            gVar.z(aVar);
                                            gVar.F(iconStampData);
                                            c.a.u0.z3.t0.c.a("doInBackground end");
                                            c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return gVar;
                                        }
                                    } catch (JSONException e13) {
                                        e = e13;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                        str8 = null;
                                        customDialogData = null;
                                        videoEasterEggData = null;
                                        jSONException = e;
                                        iconStampData = null;
                                        jSONException.printStackTrace();
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        gVar.C(str3);
                                        gVar.I(str4);
                                        gVar.A(str5);
                                        gVar.L(str6);
                                        gVar.H(str7);
                                        gVar.G(r6);
                                        gVar.E(str2);
                                        gVar.D(str);
                                        gVar.y(customDialogData);
                                        gVar.N(str8);
                                        gVar.B(contriInfo);
                                        gVar.M(videoEasterEggData);
                                        gVar.z(aVar);
                                        gVar.F(iconStampData);
                                        c.a.u0.z3.t0.c.a("doInBackground end");
                                        c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return gVar;
                                    }
                                } catch (JSONException e14) {
                                    e = e14;
                                    str3 = optString;
                                    aVar = null;
                                    str = null;
                                    str2 = null;
                                    str5 = null;
                                    str6 = null;
                                    str7 = null;
                                    str8 = null;
                                    customDialogData = null;
                                    videoEasterEggData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    gVar.C(str3);
                                    gVar.I(str4);
                                    gVar.A(str5);
                                    gVar.L(str6);
                                    gVar.H(str7);
                                    gVar.G(r6);
                                    gVar.E(str2);
                                    gVar.D(str);
                                    gVar.y(customDialogData);
                                    gVar.N(str8);
                                    gVar.B(contriInfo);
                                    gVar.M(videoEasterEggData);
                                    gVar.z(aVar);
                                    gVar.F(iconStampData);
                                    c.a.u0.z3.t0.c.a("doInBackground end");
                                    c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return gVar;
                                }
                            } catch (JSONException e15) {
                                e = e15;
                                str3 = optString;
                                aVar = null;
                                str = null;
                                str2 = null;
                                str4 = null;
                            }
                        } else {
                            iconStampData = null;
                            aVar = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            customDialogData = null;
                            videoEasterEggData = null;
                        }
                    } catch (JSONException e16) {
                        jSONException = e16;
                        iconStampData = null;
                        aVar = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        customDialogData = null;
                        videoEasterEggData = null;
                    }
                    if (StringUtils.isNull(str3)) {
                        str3 = TbadkCoreApplication.getInst().getString(j.send_success);
                    }
                    gVar.C(str3);
                    gVar.I(str4);
                    gVar.A(str5);
                    gVar.L(str6);
                    gVar.H(str7);
                    gVar.G(r6);
                    gVar.E(str2);
                    gVar.D(str);
                    gVar.y(customDialogData);
                    gVar.N(str8);
                    gVar.B(contriInfo);
                    gVar.M(videoEasterEggData);
                    gVar.z(aVar);
                    gVar.F(iconStampData);
                }
                c.a.u0.z3.t0.c.a("doInBackground end");
                c.a.u0.z3.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return gVar;
            }
            return (c.a.u0.z3.t0.g) invokeL.objValue;
        }

        public final void c(c.a.u0.z3.t0.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.u0.z3.q0.f.a(gVar.f(), AuthTokenData.parse(this.f48424b), this.f48428f.u)) {
                return;
            }
            if (gVar.u()) {
                this.f48428f.d0(gVar);
            } else if (gVar.x()) {
                this.f48428f.c0(gVar);
                this.f48428f.d0(gVar);
            } else if (c.a.u0.j4.a.c(gVar.f())) {
                this.f48428f.b0(gVar);
                this.f48428f.d0(gVar);
            } else if (gVar.v()) {
                o0 o0Var = new o0();
                o0Var.e(this.f48424b);
                if (o0Var.c() == null || this.f48428f.f48413g == null) {
                    return;
                }
                this.f48428f.f48413g.setVcodeMD5(o0Var.b());
                this.f48428f.f48413g.setVcodeUrl(o0Var.c());
                NewWriteModel newWriteModel = this.f48428f;
                newWriteModel.e0(gVar, null, o0Var, newWriteModel.f48413g);
            } else if (gVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f48424b);
                NewWriteModel newWriteModel2 = this.f48428f;
                newWriteModel2.e0(gVar, accessState, null, newWriteModel2.f48413g);
            } else if (gVar.w()) {
                this.f48428f.d0(gVar);
            } else {
                this.f48428f.d0(gVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f48425c = true;
                c.a.u0.z3.l0.a aVar = this.a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f48428f.m != null) {
                    this.f48428f.m.callback(false, null, null, this.f48428f.f48413g, null);
                } else if (this.f48428f.l != null) {
                    this.f48428f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f48428f.f48411e = null;
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
        public void onPostExecute(c.a.u0.z3.t0.g gVar) {
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
                super.onPostExecute(gVar);
                c.a.u0.z3.t0.c.a("onPostExecute start");
                c.a.u0.z3.t0.c.a("发帖： onPostExecute");
                String str = null;
                this.f48428f.f48411e = null;
                if (gVar != null && gVar.f() != 0) {
                    c.a.t0.s.d0.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", gVar.f(), gVar.g(), "tid", gVar.p(), "pid", gVar.l());
                }
                if (!this.f48425c && gVar != null) {
                    if (!gVar.s()) {
                        int type = this.f48428f.f48413g != null ? this.f48428f.f48413g.getType() : Integer.MIN_VALUE;
                        c.a.u0.z3.t0.c.a("onPostExecute success");
                        if (this.f48428f.m == null) {
                            if (this.f48428f.l != null) {
                                this.f48428f.l.a(true, gVar.g(), null, null, gVar.c());
                            }
                        } else {
                            if (!StringUtils.isNull(gVar.m()) && !StringUtils.isNull(gVar.d())) {
                                str = gVar.m();
                                h2 = gVar.d();
                            } else if (StringUtils.isNull(gVar.h()) && StringUtils.isNull(gVar.i())) {
                                h2 = null;
                            } else {
                                str = gVar.i();
                                h2 = gVar.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.f(), gVar.g(), str, h2);
                            postWriteCallBackData.setThreadId(gVar.p());
                            postWriteCallBackData.setPostId(gVar.l());
                            postWriteCallBackData.setIsCopyTWZhibo(gVar.k());
                            postWriteCallBackData.setErrorString(gVar.g());
                            postWriteCallBackData.setActivityDialog(gVar.a());
                            postWriteCallBackData.setVideoid(gVar.r());
                            postWriteCallBackData.setContriInfo(gVar.e());
                            if (this.f48428f.f48413g != null) {
                                postWriteCallBackData.setProZone(this.f48428f.f48413g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f48428f.f48413g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(gVar.q());
                            postWriteCallBackData.setmAdverSegmentData(gVar.b());
                            postWriteCallBackData.setIconStampData(gVar.j());
                            o0 o0Var = new o0();
                            o0Var.e(this.f48424b);
                            if (this.f48428f.f48413g == null || c.a.u0.z3.t0.b.k().i() == null) {
                                if (this.f48428f.f48413g == null || !this.f48428f.s) {
                                    if (this.f48428f.f48413g != null && this.f48428f.t) {
                                        c.a.u0.z3.t0.b.k().C(this.f48428f.f48413g.getForumId());
                                        c.a.u0.z3.t0.b.k().D(this.f48428f.f48413g.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f48428f.f48413g.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f48428f.f48413g;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                c.a.u0.z3.t0.b.k().C(this.f48428f.f48413g.getForumId());
                                c.a.u0.z3.t0.b.k().D(this.f48428f.f48413g.getForumName());
                                if (this.f48428f.f48413g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f48428f.f48413g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.u0.z3.t0.b.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                c.a.u0.z3.t0.b.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && gVar.j() == null) {
                                if (this.f48428f.f48413g != null) {
                                    int type2 = this.f48428f.f48413g.getType();
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
                                c.a.d.f.m.e.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f48428f.m.callback(true, postWriteCallBackData, o0Var, this.f48428f.f48413g, gVar.c());
                        }
                        if (this.f48428f.f48413g != null && !this.f48428f.f48413g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(gVar.j() == null)));
                        }
                        c.a.u0.j2.g gVar2 = this.f48427e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (!TbadkCoreApplication.getInst().isMainProcess(true) && (type == 1 || type == 2)) {
                                c.a.t0.k0.h.i(new ReplayEvent());
                            } else if (type == 1 || type == 2) {
                                if (TbSingleton.getInstance().showStampMissionDialog && c.a.t0.b.d.t0()) {
                                    c.a.u0.w3.b.r().A(0, 3);
                                    c.a.u0.w3.b.r().G();
                                }
                                c.a.u0.w3.b.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                        }
                    } else {
                        c.a.u0.z3.t0.c.a("onPostExecute error");
                        c(gVar);
                        c.a.u0.j2.g gVar3 = this.f48427e;
                        if (gVar3 != null) {
                            gVar3.h(gVar.a, gVar.g());
                        }
                    }
                    c.a.u0.z3.t0.c.a("发帖： onPostExecute 完全结束");
                    return;
                }
                c.a.u0.z3.t0.c.a("发帖： onPostExecute isCanceled");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f48411e = null;
        this.f48412f = null;
        this.f48413g = null;
        this.f48414h = null;
        this.f48415i = null;
        this.f48416j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = baseFragmentActivity.getPageContext();
    }

    public void V() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f48412f) == null || dVar.isCancelled()) {
            return;
        }
        this.f48412f.cancel();
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.f48413g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f48413g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f48411e == null) {
            if (c.a.u0.z3.t0.b.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, Z());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, c.a.u0.z3.t0.b.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f48411e = new h(this);
            c.a.u0.z3.t0.c.a("dealPost()");
            c.a.u0.z3.t0.a.l(this.f48413g);
            this.f48411e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult Y(String str, c.a.u0.z3.l0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(c.a.t0.d0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48413g : (WriteData) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpanGroupManager spanGroupManager = this.q;
            if (spanGroupManager != null) {
                this.r = spanGroupManager.E();
            } else {
                this.r = null;
            }
        }
    }

    public final void b0(c.a.u0.z3.t0.g gVar) {
        c.a.d.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || (fVar = this.o) == null || gVar == null || (this.m instanceof c.a.u0.z3.t0.b)) {
            return;
        }
        c.a.u0.j4.a.d(fVar.getPageActivity(), gVar.g());
        gVar.C(null);
    }

    public final void c0(c.a.u0.z3.t0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || this.o == null || gVar == null || gVar.c() == null || gVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), gVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h hVar = this.f48411e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f48411e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f48413g, null);
                return;
            }
            f fVar = this.l;
            if (fVar != null) {
                fVar.a(false, null, null, null, null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            h hVar = this.f48411e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f48411e.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d0(c.a.u0.z3.t0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            e0(gVar, null, null, this.f48413g);
        }
    }

    public final void e0(c.a.u0.z3.t0.g gVar, AccessState accessState, o0 o0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, gVar, accessState, o0Var, writeData) == null) || gVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.f(), gVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(gVar.o());
            postWriteCallBackData.setReplyPrivacyTip(gVar.n());
            this.m.callback(false, postWriteCallBackData, o0Var, writeData, gVar.c());
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, gVar.g(), o0Var, writeData, gVar.c());
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.t = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.n = z;
        }
    }

    public void h0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void i0(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bArr, str) == null) {
            this.f48416j = bArr;
            this.f48415i = str;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.s = z;
        }
    }

    public void k0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void l0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            this.m = gVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m0(@Nullable c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            if (fVar != null) {
                this.o = fVar;
                this.unique_id = fVar.getUniqueId();
                return;
            }
            this.o = null;
            this.unique_id = null;
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f48413g == null) {
                return false;
            }
            c.a.u0.z3.t0.c.a("发帖：开始上传");
            this.f48413g.startPublish();
            l1.g(this.f48413g, 0).f(true);
            X();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f48412f == null) {
            d dVar = new d(this);
            this.f48412f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.f48413g == null) {
                return false;
            }
            if (l.z() && !l.H() && this.f48413g.getWriteImagesInfo() != null && this.f48413g.getWriteImagesInfo().size() != 0 && this.f48413g.getWriteImagesInfo().isOriginalImg() && !c.a.t0.s.j0.b.k().h("original_img_up_tip", false)) {
                c.a.t0.s.j0.b.k().u("original_img_up_tip", true);
                c.a.d.a.f<?> fVar = this.o;
                if (fVar == null) {
                    X();
                    return true;
                }
                c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(fVar.getPageActivity());
                aVar.setMessageId(j.original_img_up_no_wifi_tip);
                aVar.setPositiveButton(j.alert_yes_button, new a(this, aVar));
                aVar.setNegativeButton(j.cancel, new b(this, aVar));
                aVar.create(this.o);
                aVar.show();
            } else {
                X();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, spanGroupManager) == null) {
            this.q = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, writeData) == null) {
            this.f48413g = writeData;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48411e = null;
        this.f48412f = null;
        this.f48413g = null;
        this.f48414h = null;
        this.f48415i = null;
        this.f48416j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = baseActivity.getPageContext();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f48411e = null;
        this.f48412f = null;
        this.f48413g = null;
        this.f48414h = null;
        this.f48415i = null;
        this.f48416j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = tbPageContext;
    }

    public NewWriteModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48411e = null;
        this.f48412f = null;
        this.f48413g = null;
        this.f48414h = null;
        this.f48415i = null;
        this.f48416j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = null;
    }
}
