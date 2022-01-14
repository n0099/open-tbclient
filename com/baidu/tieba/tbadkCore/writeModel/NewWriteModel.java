package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.s0.s.q.l1;
import c.a.s0.s.q.w1;
import c.a.s0.s.s.a;
import c.a.s0.t.c.n0;
import c.a.t0.h2.k;
import c.a.t0.w3.k0.a;
import c.a.t0.w3.p0.f;
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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f48230e;

    /* renamed from: f  reason: collision with root package name */
    public d f48231f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f48232g;

    /* renamed from: h  reason: collision with root package name */
    public String f48233h;

    /* renamed from: i  reason: collision with root package name */
    public String f48234i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f48235j;
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

    /* loaded from: classes12.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f48236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48237f;

        public a(NewWriteModel newWriteModel, c.a.s0.s.s.a aVar) {
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
            this.f48237f = newWriteModel;
            this.f48236e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48236e.dismiss();
                this.f48237f.X();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f48238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48239f;

        public b(NewWriteModel newWriteModel, c.a.s0.s.s.a aVar) {
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
            this.f48239f = newWriteModel;
            this.f48238e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48238e.dismiss();
                this.f48239f.cancel();
            }
        }
    }

    /* loaded from: classes12.dex */
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

        @Override // c.a.t0.w3.p0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.f48232g == null || TextUtils.isEmpty(str)) {
                    if (this.a.m != null) {
                        this.a.m.callback(false, null, null, this.a.f48232g, null);
                        return;
                    }
                    return;
                }
                this.a.f48230e = null;
                this.a.f48232g.setAuthSid(str);
                this.a.p0();
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.f48232g == null || TextUtils.isEmpty(str)) {
                    if (this.a.m != null) {
                        this.a.m.callback(false, null, null, this.a.f48232g, null);
                        return;
                    }
                    return;
                }
                this.a.f48230e = null;
                this.a.f48232g.setAuthSid(str);
                this.a.p0();
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.f48232g != null) {
                    this.a.f48232g.setAuthSid(null);
                }
                if (this.a.m != null) {
                    this.a.m.callback(false, null, null, this.a.f48232g, null);
                }
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f48232g != null) {
                    this.a.f48230e = null;
                    this.a.f48232g.setAuthSid(null);
                    this.a.p0();
                } else if (this.a.m != null) {
                    this.a.m.callback(false, null, null, this.a.f48232g, null);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.t0.w3.k0.a f48240b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f48241c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48242d;

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
            this.f48242d = newWriteModel;
            this.a = false;
            this.f48240b = new c.a.t0.w3.k0.a();
            this.f48241c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f48242d.f48234i);
                if (this.a) {
                    return null;
                }
                if (this.f48242d.f48235j == null || this.f48242d.f48235j.length <= 0) {
                    if (TextUtils.isEmpty(this.f48242d.f48234i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f48242d.f48233h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f48242d.f48234i));
                    if (TextUtils.isEmpty(this.f48242d.f48233h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f48242d;
                    return newWriteModel.Y(newWriteModel.f48233h, this.f48240b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f48242d.f48235j);
                this.f48241c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f48242d.f48233h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f48242d.f48233h)) {
                    Bitmap bitmap = this.f48241c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f48241c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f48242d;
                return newWriteModel2.Y(newWriteModel2.f48233h, this.f48240b);
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
                if (this.f48242d.k != null) {
                    this.f48242d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f48241c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f48241c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                c.a.t0.w3.k0.a aVar = this.f48240b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f48242d.k != null) {
                    this.f48242d.k.a(null, true);
                }
                Bitmap bitmap = this.f48241c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f48241c.recycle();
                }
                super.cancel();
                this.f48242d.f48231f = null;
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(boolean z, String str, n0 n0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes12.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes12.dex */
    public class h extends BdAsyncTask<Integer, Integer, c.a.t0.w3.s0.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.t0.w3.k0.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f48243b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48244c;

        /* renamed from: d  reason: collision with root package name */
        public k f48245d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.h2.g f48246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f48247f;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f48248e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f48249f;

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
                this.f48249f = hVar;
                this.f48248e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t0.s2.t.c.a((TbPageContext) this.f48249f.f48247f.o, this.f48248e).show();
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
            this.f48247f = newWriteModel;
            this.a = null;
            this.f48243b = null;
            this.f48244c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f48245d = (k) runTask.getData();
            }
            k kVar = this.f48245d;
            if (kVar != null) {
                this.f48246e = kVar.get();
            }
            setPriority(3);
            c.a.t0.w3.s0.c.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0302  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c.a.t0.w3.s0.g doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            c.a.t0.w3.s0.g gVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            c.a.s0.u.a aVar;
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
                if (this.f48244c) {
                    return null;
                }
                c.a.s0.c0.d.c(this.f48247f.f48232g.getContent());
                c.a.t0.w3.s0.c.a("doInBackground() start");
                c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground");
                c.a.t0.w3.k0.a aVar2 = new c.a.t0.w3.k0.a();
                this.a = aVar2;
                aVar2.j(this.f48247f.q);
                this.a.k(this.f48247f.r);
                this.a.l(this.f48246e);
                this.a.i(this.f48247f.p);
                this.f48243b = this.a.h(this.f48247f.f48232g, this.f48247f.n);
                c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.a.d();
                c.a.t0.w3.s0.a.c(this.f48247f.f48232g, d2);
                if (this.a.e() && this.f48243b != null) {
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.a.c();
                    String error_msg = d2.getError_msg();
                    if (m.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    gVar = new c.a.t0.w3.s0.g(d2.getError_code(), error_msg, c2);
                    if (this.f48247f.f48232g != null && this.f48247f.f48232g.isHasImages() && !gVar.s()) {
                        this.f48247f.f48232g.deleteUploadedTempImages();
                    }
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    gVar = new c.a.t0.w3.s0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f48243b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f48243b).optJSONObject("info");
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
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    gVar = new c.a.t0.w3.s0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f48243b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f48243b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                w1 w1Var = new w1();
                                w1Var.a = optJSONObject2.optString("block_content");
                                w1Var.f13521b = optJSONObject2.optString("block_cancel");
                                w1Var.f13522c = optJSONObject2.optString("block_confirm");
                                gVar.J(w1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    gVar = new c.a.t0.w3.s0.g(d2.getError_code(), error_msg2, this.a.c());
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    gVar = new c.a.t0.w3.s0.g(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!gVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f48243b != null) {
                            JSONObject jSONObject = new JSONObject(this.f48243b);
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
                                        c.a.t0.w3.s0.c.a("doInBackground end");
                                        c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        c.a.t0.w3.s0.c.a("doInBackground end");
                                        c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return gVar;
                                    }
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                        try {
                                            customDialogData = c.a.t0.s2.b.a(jSONObject);
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
                                                        c.a.t0.w3.s0.c.a("doInBackground end");
                                                        c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            c.a.t0.w3.s0.c.a("doInBackground end");
                                                            c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return gVar;
                                                        }
                                                    } else {
                                                        videoEasterEggData = null;
                                                    }
                                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                                    if (optJSONObject6 != null) {
                                                        aVar = new c.a.s0.u.a();
                                                        try {
                                                            aVar.o(optJSONObject6);
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
                                                            c.a.t0.w3.s0.c.a("doInBackground end");
                                                            c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            c.a.t0.w3.s0.c.a("doInBackground end");
                                                            c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                    c.a.t0.w3.s0.c.a("doInBackground end");
                                                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                            c.a.t0.w3.s0.c.a("doInBackground end");
                                            c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        c.a.t0.w3.s0.c.a("doInBackground end");
                                        c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                    c.a.t0.w3.s0.c.a("doInBackground end");
                                    c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                        str3 = TbadkCoreApplication.getInst().getString(R.string.send_success);
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
                c.a.t0.w3.s0.c.a("doInBackground end");
                c.a.t0.w3.s0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return gVar;
            }
            return (c.a.t0.w3.s0.g) invokeL.objValue;
        }

        public final void c(c.a.t0.w3.s0.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.t0.w3.p0.f.a(gVar.f(), AuthTokenData.parse(this.f48243b), this.f48247f.u)) {
                return;
            }
            if (gVar.u()) {
                this.f48247f.d0(gVar);
            } else if (gVar.x()) {
                this.f48247f.c0(gVar);
                this.f48247f.d0(gVar);
            } else if (c.a.t0.g4.a.c(gVar.f())) {
                this.f48247f.b0(gVar);
                this.f48247f.d0(gVar);
            } else if (gVar.v()) {
                n0 n0Var = new n0();
                n0Var.e(this.f48243b);
                if (n0Var.c() == null || this.f48247f.f48232g == null) {
                    return;
                }
                this.f48247f.f48232g.setVcodeMD5(n0Var.b());
                this.f48247f.f48232g.setVcodeUrl(n0Var.c());
                NewWriteModel newWriteModel = this.f48247f;
                newWriteModel.e0(gVar, null, n0Var, newWriteModel.f48232g);
            } else if (gVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f48243b);
                NewWriteModel newWriteModel2 = this.f48247f;
                newWriteModel2.e0(gVar, accessState, null, newWriteModel2.f48232g);
            } else if (gVar.w()) {
                this.f48247f.d0(gVar);
            } else {
                this.f48247f.d0(gVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f48244c = true;
                c.a.t0.w3.k0.a aVar = this.a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f48247f.m != null) {
                    this.f48247f.m.callback(false, null, null, this.f48247f.f48232g, null);
                } else if (this.f48247f.l != null) {
                    this.f48247f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f48247f.f48230e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x024b, code lost:
            if (r5 != 7) goto L56;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(c.a.t0.w3.s0.g gVar) {
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
                super.onPostExecute(gVar);
                c.a.t0.w3.s0.c.a("onPostExecute start");
                c.a.t0.w3.s0.c.a("发帖： onPostExecute");
                String str = null;
                this.f48247f.f48230e = null;
                if (gVar != null && gVar.f() != 0) {
                    c.a.s0.s.b0.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", gVar.f(), gVar.g(), "tid", gVar.p(), "pid", gVar.l());
                }
                if (!this.f48244c && gVar != null) {
                    if (gVar.s()) {
                        c.a.t0.w3.s0.c.a("onPostExecute error");
                        c(gVar);
                        c.a.t0.h2.g gVar2 = this.f48246e;
                        if (gVar2 != null) {
                            gVar2.h(gVar.a, gVar.g());
                        }
                    } else {
                        c.a.t0.w3.s0.c.a("onPostExecute success");
                        if (this.f48247f.m == null) {
                            if (this.f48247f.l != null) {
                                this.f48247f.l.a(true, gVar.g(), null, null, gVar.c());
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
                            if (this.f48247f.f48232g != null) {
                                postWriteCallBackData.setProZone(this.f48247f.f48232g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f48247f.f48232g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(gVar.q());
                            postWriteCallBackData.setmAdverSegmentData(gVar.b());
                            postWriteCallBackData.setIconStampData(gVar.j());
                            n0 n0Var = new n0();
                            n0Var.e(this.f48243b);
                            if (this.f48247f.f48232g == null || c.a.t0.w3.s0.b.k().i() == null) {
                                if (this.f48247f.f48232g == null || !this.f48247f.s) {
                                    if (this.f48247f.f48232g != null && this.f48247f.t) {
                                        c.a.t0.w3.s0.b.k().C(this.f48247f.f48232g.getForumId());
                                        c.a.t0.w3.s0.b.k().D(this.f48247f.f48232g.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f48247f.f48232g.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f48247f.f48232g;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                c.a.t0.w3.s0.b.k().C(this.f48247f.f48232g.getForumId());
                                c.a.t0.w3.s0.b.k().D(this.f48247f.f48232g.getForumName());
                                if (this.f48247f.f48232g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f48247f.f48232g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.t0.w3.s0.b.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                c.a.t0.w3.s0.b.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && gVar.j() == null) {
                                if (this.f48247f.f48232g != null) {
                                    int type = this.f48247f.f48232g.getType();
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
                                c.a.d.f.m.e.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f48247f.m.callback(true, postWriteCallBackData, n0Var, this.f48247f.f48232g, gVar.c());
                        }
                        if (this.f48247f.f48232g != null && !this.f48247f.f48232g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(gVar.j() == null)));
                        }
                        c.a.t0.h2.g gVar3 = this.f48246e;
                        if (gVar3 != null) {
                            gVar3.c();
                        }
                    }
                    c.a.t0.w3.s0.c.a("发帖： onPostExecute 完全结束");
                    return;
                }
                c.a.t0.w3.s0.c.a("发帖： onPostExecute isCanceled");
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
        this.f48230e = null;
        this.f48231f = null;
        this.f48232g = null;
        this.f48233h = null;
        this.f48234i = null;
        this.f48235j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = baseFragmentActivity.getPageContext();
    }

    public void V() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f48231f) == null || dVar.isCancelled()) {
            return;
        }
        this.f48231f.cancel();
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.f48232g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f48232g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f48230e == null) {
            if (c.a.t0.w3.s0.b.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, Z());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, c.a.t0.w3.s0.b.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f48230e = new h(this);
            c.a.t0.w3.s0.c.a("dealPost()");
            c.a.t0.w3.s0.a.l(this.f48232g);
            this.f48230e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult Y(String str, c.a.t0.w3.k0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(c.a.s0.d0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48232g : (WriteData) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpanGroupManager spanGroupManager = this.q;
            if (spanGroupManager != null) {
                this.r = spanGroupManager.C();
            } else {
                this.r = null;
            }
        }
    }

    public final void b0(c.a.t0.w3.s0.g gVar) {
        c.a.d.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || (fVar = this.o) == null || gVar == null || (this.m instanceof c.a.t0.w3.s0.b)) {
            return;
        }
        c.a.t0.g4.a.d(fVar.getPageActivity(), gVar.g());
        gVar.C(null);
    }

    public final void c0(c.a.t0.w3.s0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || this.o == null || gVar == null || gVar.c() == null || gVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), gVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h hVar = this.f48230e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f48230e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f48232g, null);
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
            h hVar = this.f48230e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f48230e.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d0(c.a.t0.w3.s0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            e0(gVar, null, null, this.f48232g);
        }
    }

    public final void e0(c.a.t0.w3.s0.g gVar, AccessState accessState, n0 n0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, gVar, accessState, n0Var, writeData) == null) || gVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.f(), gVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(gVar.o());
            postWriteCallBackData.setReplyPrivacyTip(gVar.n());
            this.m.callback(false, postWriteCallBackData, n0Var, writeData, gVar.c());
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, gVar.g(), n0Var, writeData, gVar.c());
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
            this.f48235j = bArr;
            this.f48234i = str;
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
            if (this.f48232g == null) {
                return false;
            }
            c.a.t0.w3.s0.c.a("发帖：开始上传");
            this.f48232g.startPublish();
            l1.g(this.f48232g, 0).f(true);
            X();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f48231f == null) {
            d dVar = new d(this);
            this.f48231f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.f48232g == null) {
                return false;
            }
            if (l.z() && !l.H() && this.f48232g.getWriteImagesInfo() != null && this.f48232g.getWriteImagesInfo().size() != 0 && this.f48232g.getWriteImagesInfo().isOriginalImg() && !c.a.s0.s.h0.b.k().h("original_img_up_tip", false)) {
                c.a.s0.s.h0.b.k().u("original_img_up_tip", true);
                c.a.d.a.f<?> fVar = this.o;
                if (fVar == null) {
                    X();
                    return true;
                }
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(fVar.getPageActivity());
                aVar.setMessageId(R.string.original_img_up_no_wifi_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new a(this, aVar));
                aVar.setNegativeButton(R.string.cancel, new b(this, aVar));
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
            this.f48232g = writeData;
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
        this.f48230e = null;
        this.f48231f = null;
        this.f48232g = null;
        this.f48233h = null;
        this.f48234i = null;
        this.f48235j = null;
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
        this.f48230e = null;
        this.f48231f = null;
        this.f48232g = null;
        this.f48233h = null;
        this.f48234i = null;
        this.f48235j = null;
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
        this.f48230e = null;
        this.f48231f = null;
        this.f48232g = null;
        this.f48233h = null;
        this.f48234i = null;
        this.f48235j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = new c(this);
        this.o = null;
    }
}
