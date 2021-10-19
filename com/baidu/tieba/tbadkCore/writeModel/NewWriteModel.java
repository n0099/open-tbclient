package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.s.q.l1;
import c.a.q0.s.q.w1;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l0;
import c.a.r0.a2.k;
import c.a.r0.k3.j0.a;
import c.a.r0.k3.o0.f;
import c.a.r0.k3.r0.l;
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
/* loaded from: classes7.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f57232e;

    /* renamed from: f  reason: collision with root package name */
    public d f57233f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f57234g;

    /* renamed from: h  reason: collision with root package name */
    public String f57235h;

    /* renamed from: i  reason: collision with root package name */
    public String f57236i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f57237j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public c.a.e.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public f.c s;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f57238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f57239f;

        public a(NewWriteModel newWriteModel, c.a.q0.s.s.a aVar) {
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
            this.f57239f = newWriteModel;
            this.f57238e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57238e.dismiss();
                this.f57239f.V();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f57240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f57241f;

        public b(NewWriteModel newWriteModel, c.a.q0.s.s.a aVar) {
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
            this.f57241f = newWriteModel;
            this.f57240e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f57240e.dismiss();
                this.f57241f.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f57242a;

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
            this.f57242a = newWriteModel;
        }

        @Override // c.a.r0.k3.o0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f57242a.f57234g == null || TextUtils.isEmpty(str)) {
                    if (this.f57242a.m != null) {
                        this.f57242a.m.callback(false, null, null, this.f57242a.f57234g, null);
                        return;
                    }
                    return;
                }
                this.f57242a.f57232e = null;
                this.f57242a.f57234g.setAuthSid(str);
                this.f57242a.l0();
            }
        }

        @Override // c.a.r0.k3.o0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f57242a.f57234g == null || TextUtils.isEmpty(str)) {
                    if (this.f57242a.m != null) {
                        this.f57242a.m.callback(false, null, null, this.f57242a.f57234g, null);
                        return;
                    }
                    return;
                }
                this.f57242a.f57232e = null;
                this.f57242a.f57234g.setAuthSid(str);
                this.f57242a.l0();
            }
        }

        @Override // c.a.r0.k3.o0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f57242a.f57234g != null) {
                    this.f57242a.f57234g.setAuthSid(null);
                }
                if (this.f57242a.m != null) {
                    this.f57242a.m.callback(false, null, null, this.f57242a.f57234g, null);
                }
            }
        }

        @Override // c.a.r0.k3.o0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f57242a.f57234g != null) {
                    this.f57242a.f57232e = null;
                    this.f57242a.f57234g.setAuthSid(null);
                    this.f57242a.l0();
                } else if (this.f57242a.m != null) {
                    this.f57242a.m.callback(false, null, null, this.f57242a.f57234g, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57243a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r0.k3.j0.a f57244b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f57245c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f57246d;

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
            this.f57246d = newWriteModel;
            this.f57243a = false;
            this.f57244b = new c.a.r0.k3.j0.a();
            this.f57245c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f57246d.f57236i);
                if (this.f57243a) {
                    return null;
                }
                if (this.f57246d.f57237j == null || this.f57246d.f57237j.length <= 0) {
                    if (TextUtils.isEmpty(this.f57246d.f57236i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f57246d.f57235h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f57246d.f57236i));
                    if (TextUtils.isEmpty(this.f57246d.f57235h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f57246d;
                    return newWriteModel.W(newWriteModel.f57235h, this.f57244b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f57246d.f57237j);
                this.f57245c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f57246d.f57235h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f57246d.f57235h)) {
                    Bitmap bitmap = this.f57245c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f57245c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f57246d;
                return newWriteModel2.W(newWriteModel2.f57235h, this.f57244b);
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
                if (this.f57243a) {
                    return;
                }
                if (this.f57246d.k != null) {
                    this.f57246d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f57245c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f57245c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f57243a = true;
                c.a.r0.k3.j0.a aVar = this.f57244b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f57246d.k != null) {
                    this.f57246d.k.a(null, true);
                }
                Bitmap bitmap = this.f57245c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f57245c.recycle();
                }
                super.cancel();
                this.f57246d.f57233f = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(boolean z, String str, l0 l0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes7.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<Integer, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.r0.k3.j0.a f57247a;

        /* renamed from: b  reason: collision with root package name */
        public String f57248b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57249c;

        /* renamed from: d  reason: collision with root package name */
        public k f57250d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.a2.g f57251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f57252f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f57253e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f57254f;

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
                this.f57254f = hVar;
                this.f57253e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.k2.j.c.a((TbPageContext) this.f57254f.f57252f.o, this.f57253e).show();
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
            this.f57252f = newWriteModel;
            this.f57247a = null;
            this.f57248b = null;
            this.f57249c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f57250d = (k) runTask.getData();
            }
            k kVar = this.f57250d;
            if (kVar != null) {
                this.f57251e = kVar.get();
            }
            setPriority(3);
            c.a.r0.k3.r0.h.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0302  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public l doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            l lVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            c.a.q0.u.a aVar;
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
                if (this.f57249c) {
                    return null;
                }
                c.a.q0.c0.d.c(this.f57252f.f57234g.getContent());
                c.a.r0.k3.r0.h.a("doInBackground() start");
                c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground");
                c.a.r0.k3.j0.a aVar2 = new c.a.r0.k3.j0.a();
                this.f57247a = aVar2;
                aVar2.j(this.f57252f.q);
                this.f57247a.k(this.f57252f.r);
                this.f57247a.l(this.f57251e);
                this.f57247a.i(this.f57252f.p);
                this.f57248b = this.f57247a.h(this.f57252f.f57234g, this.f57252f.n);
                c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.f57247a.d();
                c.a.r0.k3.r0.d.c(this.f57252f.f57234g, d2);
                if (this.f57247a.e() && this.f57248b != null) {
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.f57247a.c();
                    String error_msg = d2.getError_msg();
                    if (c.a.e.e.p.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    lVar = new l(d2.getError_code(), error_msg, c2);
                    if (this.f57252f.f57234g != null && this.f57252f.f57234g.isHasImages() && !lVar.s()) {
                        this.f57252f.f57234g.deleteUploadedTempImages();
                    }
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f57248b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f57248b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i2 = 0; i2 < length; i2++) {
                                    arrayList.add(jSONArray.optString(i2));
                                }
                                lVar.K(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f57248b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f57248b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                w1 w1Var = new w1();
                                w1Var.f14359a = optJSONObject2.optString("block_content");
                                w1Var.f14360b = optJSONObject2.optString("block_cancel");
                                w1Var.f14361c = optJSONObject2.optString("block_confirm");
                                lVar.J(w1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    lVar = new l(d2.getError_code(), error_msg2, this.f57247a.c());
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    lVar = new l(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!lVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f57248b != null) {
                            JSONObject jSONObject = new JSONObject(this.f57248b);
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
                                        lVar.C(str3);
                                        lVar.I(str4);
                                        lVar.A(str5);
                                        lVar.L(str6);
                                        lVar.H(str7);
                                        lVar.G(r6);
                                        lVar.E(str2);
                                        lVar.D(str);
                                        lVar.y(customDialogData);
                                        lVar.N(str8);
                                        lVar.B(contriInfo);
                                        lVar.M(videoEasterEggData);
                                        lVar.z(aVar);
                                        lVar.F(iconStampData);
                                        c.a.r0.k3.r0.h.a("doInBackground end");
                                        c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return lVar;
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
                                        lVar.C(str3);
                                        lVar.I(str4);
                                        lVar.A(str5);
                                        lVar.L(str6);
                                        lVar.H(str7);
                                        lVar.G(r6);
                                        lVar.E(str2);
                                        lVar.D(str);
                                        lVar.y(customDialogData);
                                        lVar.N(str8);
                                        lVar.B(contriInfo);
                                        lVar.M(videoEasterEggData);
                                        lVar.z(aVar);
                                        lVar.F(iconStampData);
                                        c.a.r0.k3.r0.h.a("doInBackground end");
                                        c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return lVar;
                                    }
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                        try {
                                            customDialogData = c.a.r0.k2.b.a(jSONObject);
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
                                                        lVar.C(str3);
                                                        lVar.I(str4);
                                                        lVar.A(str5);
                                                        lVar.L(str6);
                                                        lVar.H(str7);
                                                        lVar.G(r6);
                                                        lVar.E(str2);
                                                        lVar.D(str);
                                                        lVar.y(customDialogData);
                                                        lVar.N(str8);
                                                        lVar.B(contriInfo);
                                                        lVar.M(videoEasterEggData);
                                                        lVar.z(aVar);
                                                        lVar.F(iconStampData);
                                                        c.a.r0.k3.r0.h.a("doInBackground end");
                                                        c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                        return lVar;
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
                                                            lVar.C(str3);
                                                            lVar.I(str4);
                                                            lVar.A(str5);
                                                            lVar.L(str6);
                                                            lVar.H(str7);
                                                            lVar.G(r6);
                                                            lVar.E(str2);
                                                            lVar.D(str);
                                                            lVar.y(customDialogData);
                                                            lVar.N(str8);
                                                            lVar.B(contriInfo);
                                                            lVar.M(videoEasterEggData);
                                                            lVar.z(aVar);
                                                            lVar.F(iconStampData);
                                                            c.a.r0.k3.r0.h.a("doInBackground end");
                                                            c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return lVar;
                                                        }
                                                    } else {
                                                        videoEasterEggData = null;
                                                    }
                                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                                    if (optJSONObject6 != null) {
                                                        aVar = new c.a.q0.u.a();
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
                                                            lVar.C(str3);
                                                            lVar.I(str4);
                                                            lVar.A(str5);
                                                            lVar.L(str6);
                                                            lVar.H(str7);
                                                            lVar.G(r6);
                                                            lVar.E(str2);
                                                            lVar.D(str);
                                                            lVar.y(customDialogData);
                                                            lVar.N(str8);
                                                            lVar.B(contriInfo);
                                                            lVar.M(videoEasterEggData);
                                                            lVar.z(aVar);
                                                            lVar.F(iconStampData);
                                                            c.a.r0.k3.r0.h.a("doInBackground end");
                                                            c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return lVar;
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
                                                            lVar.C(str3);
                                                            lVar.I(str4);
                                                            lVar.A(str5);
                                                            lVar.L(str6);
                                                            lVar.H(str7);
                                                            lVar.G(r6);
                                                            lVar.E(str2);
                                                            lVar.D(str);
                                                            lVar.y(customDialogData);
                                                            lVar.N(str8);
                                                            lVar.B(contriInfo);
                                                            lVar.M(videoEasterEggData);
                                                            lVar.z(aVar);
                                                            lVar.F(iconStampData);
                                                            c.a.r0.k3.r0.h.a("doInBackground end");
                                                            c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return lVar;
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
                                                    lVar.C(str3);
                                                    lVar.I(str4);
                                                    lVar.A(str5);
                                                    lVar.L(str6);
                                                    lVar.H(str7);
                                                    lVar.G(r6);
                                                    lVar.E(str2);
                                                    lVar.D(str);
                                                    lVar.y(customDialogData);
                                                    lVar.N(str8);
                                                    lVar.B(contriInfo);
                                                    lVar.M(videoEasterEggData);
                                                    lVar.z(aVar);
                                                    lVar.F(iconStampData);
                                                    c.a.r0.k3.r0.h.a("doInBackground end");
                                                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return lVar;
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
                                            lVar.C(str3);
                                            lVar.I(str4);
                                            lVar.A(str5);
                                            lVar.L(str6);
                                            lVar.H(str7);
                                            lVar.G(r6);
                                            lVar.E(str2);
                                            lVar.D(str);
                                            lVar.y(customDialogData);
                                            lVar.N(str8);
                                            lVar.B(contriInfo);
                                            lVar.M(videoEasterEggData);
                                            lVar.z(aVar);
                                            lVar.F(iconStampData);
                                            c.a.r0.k3.r0.h.a("doInBackground end");
                                            c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return lVar;
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
                                        lVar.C(str3);
                                        lVar.I(str4);
                                        lVar.A(str5);
                                        lVar.L(str6);
                                        lVar.H(str7);
                                        lVar.G(r6);
                                        lVar.E(str2);
                                        lVar.D(str);
                                        lVar.y(customDialogData);
                                        lVar.N(str8);
                                        lVar.B(contriInfo);
                                        lVar.M(videoEasterEggData);
                                        lVar.z(aVar);
                                        lVar.F(iconStampData);
                                        c.a.r0.k3.r0.h.a("doInBackground end");
                                        c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return lVar;
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
                                    lVar.C(str3);
                                    lVar.I(str4);
                                    lVar.A(str5);
                                    lVar.L(str6);
                                    lVar.H(str7);
                                    lVar.G(r6);
                                    lVar.E(str2);
                                    lVar.D(str);
                                    lVar.y(customDialogData);
                                    lVar.N(str8);
                                    lVar.B(contriInfo);
                                    lVar.M(videoEasterEggData);
                                    lVar.z(aVar);
                                    lVar.F(iconStampData);
                                    c.a.r0.k3.r0.h.a("doInBackground end");
                                    c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return lVar;
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
                    lVar.C(str3);
                    lVar.I(str4);
                    lVar.A(str5);
                    lVar.L(str6);
                    lVar.H(str7);
                    lVar.G(r6);
                    lVar.E(str2);
                    lVar.D(str);
                    lVar.y(customDialogData);
                    lVar.N(str8);
                    lVar.B(contriInfo);
                    lVar.M(videoEasterEggData);
                    lVar.z(aVar);
                    lVar.F(iconStampData);
                }
                c.a.r0.k3.r0.h.a("doInBackground end");
                c.a.r0.k3.r0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return lVar;
            }
            return (l) invokeL.objValue;
        }

        public final void c(l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) || c.a.r0.k3.o0.f.a(lVar.f(), AuthTokenData.parse(this.f57248b), this.f57252f.s)) {
                return;
            }
            if (lVar.u()) {
                this.f57252f.b0(lVar);
            } else if (lVar.x()) {
                this.f57252f.a0(lVar);
                this.f57252f.b0(lVar);
            } else if (c.a.r0.u3.a.c(lVar.f())) {
                this.f57252f.Z(lVar);
                this.f57252f.b0(lVar);
            } else if (lVar.v()) {
                l0 l0Var = new l0();
                l0Var.e(this.f57248b);
                if (l0Var.c() == null || this.f57252f.f57234g == null) {
                    return;
                }
                this.f57252f.f57234g.setVcodeMD5(l0Var.b());
                this.f57252f.f57234g.setVcodeUrl(l0Var.c());
                NewWriteModel newWriteModel = this.f57252f;
                newWriteModel.c0(lVar, null, l0Var, newWriteModel.f57234g);
            } else if (lVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f57248b);
                NewWriteModel newWriteModel2 = this.f57252f;
                newWriteModel2.c0(lVar, accessState, null, newWriteModel2.f57234g);
            } else if (lVar.w()) {
                this.f57252f.b0(lVar);
            } else {
                this.f57252f.b0(lVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f57249c = true;
                c.a.r0.k3.j0.a aVar = this.f57247a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f57252f.m != null) {
                    this.f57252f.m.callback(false, null, null, this.f57252f.f57234g, null);
                } else if (this.f57252f.l != null) {
                    this.f57252f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f57252f.f57232e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x01dd, code lost:
            if (r5 != 7) goto L56;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(l lVar) {
            String i2;
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
                super.onPostExecute(lVar);
                c.a.r0.k3.r0.h.a("onPostExecute start");
                c.a.r0.k3.r0.h.a("发帖： onPostExecute");
                this.f57252f.f57232e = null;
                if (lVar != null && lVar.f() != 0) {
                    c.a.q0.s.z.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", lVar.f(), lVar.g(), "tid", lVar.p(), "pid", lVar.l());
                }
                if (!this.f57249c && lVar != null) {
                    if (lVar.s()) {
                        c.a.r0.k3.r0.h.a("onPostExecute error");
                        c(lVar);
                        c.a.r0.a2.g gVar = this.f57251e;
                        if (gVar != null) {
                            gVar.h(lVar.f21312a, lVar.g());
                        }
                    } else {
                        c.a.r0.k3.r0.h.a("onPostExecute success");
                        if (this.f57252f.m == null) {
                            if (this.f57252f.l != null) {
                                this.f57252f.l.a(true, lVar.g(), null, null, lVar.c());
                            }
                        } else {
                            if (!StringUtils.isNull(lVar.m()) && !StringUtils.isNull(lVar.d())) {
                                i2 = lVar.m();
                                h2 = lVar.d();
                            } else if (StringUtils.isNull(lVar.h()) && StringUtils.isNull(lVar.i())) {
                                i2 = null;
                                h2 = null;
                            } else {
                                i2 = lVar.i();
                                h2 = lVar.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(lVar.f(), lVar.g(), i2, h2);
                            postWriteCallBackData.setThreadId(lVar.p());
                            postWriteCallBackData.setPostId(lVar.l());
                            postWriteCallBackData.setIsCopyTWZhibo(lVar.k());
                            postWriteCallBackData.setErrorString(lVar.g());
                            postWriteCallBackData.setActivityDialog(lVar.a());
                            postWriteCallBackData.setVideoid(lVar.r());
                            postWriteCallBackData.setContriInfo(lVar.e());
                            if (this.f57252f.f57234g != null) {
                                postWriteCallBackData.setProZone(this.f57252f.f57234g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f57252f.f57234g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(lVar.q());
                            postWriteCallBackData.setmAdverSegmentData(lVar.b());
                            postWriteCallBackData.setIconStampData(lVar.j());
                            l0 l0Var = new l0();
                            l0Var.e(this.f57248b);
                            if (this.f57252f.f57234g != null && c.a.r0.k3.r0.g.j().h() != null) {
                                c.a.r0.k3.r0.g.j().A(this.f57252f.f57234g.getForumId());
                                c.a.r0.k3.r0.g.j().B(this.f57252f.f57234g.getForumName());
                                if (this.f57252f.f57234g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f57252f.f57234g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.r0.k3.r0.g.j().h()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                c.a.r0.k3.r0.g.j().v(null);
                                c.a.r0.k3.r0.g.j().y(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && lVar.j() == null) {
                                if (this.f57252f.f57234g != null) {
                                    int type = this.f57252f.f57234g.getType();
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
                                c.a.e.e.m.e.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f57252f.m.callback(true, postWriteCallBackData, l0Var, this.f57252f.f57234g, lVar.c());
                        }
                        if (this.f57252f.f57234g != null && !this.f57252f.f57234g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(lVar.j() == null)));
                        }
                        c.a.r0.a2.g gVar2 = this.f57251e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                    }
                    c.a.r0.k3.r0.h.a("发帖： onPostExecute 完全结束");
                    return;
                }
                c.a.r0.k3.r0.h.a("发帖： onPostExecute isCanceled");
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f57232e = null;
        this.f57233f = null;
        this.f57234g = null;
        this.f57235h = null;
        this.f57236i = null;
        this.f57237j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = baseFragmentActivity.getPageContext();
    }

    public void T() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f57233f) == null || dVar.isCancelled()) {
            return;
        }
        this.f57233f.cancel();
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.f57234g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f57234g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f57232e == null) {
            if (c.a.r0.k3.r0.g.j().h() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, X());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, c.a.r0.k3.r0.g.j().h()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f57232e = new h(this);
            c.a.r0.k3.r0.h.a("dealPost()");
            c.a.r0.k3.r0.d.l(this.f57234g);
            this.f57232e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult W(String str, c.a.r0.k3.j0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(c.a.q0.d0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57234g : (WriteData) invokeV.objValue;
    }

    public void Y() {
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

    public final void Z(l lVar) {
        c.a.e.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) || (fVar = this.o) == null || lVar == null || (this.m instanceof c.a.r0.k3.r0.g)) {
            return;
        }
        c.a.r0.u3.a.d(fVar.getPageActivity(), lVar.g());
        lVar.C(null);
    }

    public final void a0(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) || this.o == null || lVar == null || lVar.c() == null || lVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), lVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void b0(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) {
            c0(lVar, null, null, this.f57234g);
        }
    }

    public final void c0(l lVar, AccessState accessState, l0 l0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, lVar, accessState, l0Var, writeData) == null) || lVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(lVar.f(), lVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(lVar.o());
            postWriteCallBackData.setReplyPrivacyTip(lVar.n());
            this.m.callback(false, postWriteCallBackData, l0Var, writeData, lVar.c());
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, lVar.g(), l0Var, writeData, lVar.c());
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h hVar = this.f57232e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f57232e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f57234g, null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            h hVar = this.f57232e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f57232e.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.n = z;
        }
    }

    public void e0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void f0(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bArr, str) == null) {
            this.f57237j = bArr;
            this.f57236i = str;
        }
    }

    public void g0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void h0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void i0(@Nullable c.a.e.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            if (fVar != null) {
                this.o = fVar;
                this.unique_id = fVar.getUniqueId();
                return;
            }
            this.o = null;
            this.unique_id = null;
        }
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f57234g == null) {
                return false;
            }
            c.a.r0.k3.r0.h.a("发帖：开始上传");
            this.f57234g.startPublish();
            l1.h(this.f57234g, 0).f(true);
            V();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.f57233f == null) {
            d dVar = new d(this);
            this.f57233f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f57234g == null) {
                return false;
            }
            if (j.z() && !j.H() && this.f57234g.getWriteImagesInfo() != null && this.f57234g.getWriteImagesInfo().size() != 0 && this.f57234g.getWriteImagesInfo().isOriginalImg() && !c.a.q0.s.d0.b.j().g("original_img_up_tip", false)) {
                c.a.q0.s.d0.b.j().t("original_img_up_tip", true);
                c.a.e.a.f<?> fVar = this.o;
                if (fVar == null) {
                    V();
                    return true;
                }
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(fVar.getPageActivity());
                aVar.setMessageId(R.string.original_img_up_no_wifi_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new a(this, aVar));
                aVar.setNegativeButton(R.string.cancel, new b(this, aVar));
                aVar.create(this.o);
                aVar.show();
            } else {
                V();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, spanGroupManager) == null) {
            this.q = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, writeData) == null) {
            this.f57234g = writeData;
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57232e = null;
        this.f57233f = null;
        this.f57234g = null;
        this.f57235h = null;
        this.f57236i = null;
        this.f57237j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f57232e = null;
        this.f57233f = null;
        this.f57234g = null;
        this.f57235h = null;
        this.f57236i = null;
        this.f57237j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
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
        this.f57232e = null;
        this.f57233f = null;
        this.f57234g = null;
        this.f57235h = null;
        this.f57236i = null;
        this.f57237j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = null;
    }
}
