package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
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
import d.a.c.e.p.j;
import d.a.o0.r.q.j1;
import d.a.o0.r.q.u1;
import d.a.o0.r.s.a;
import d.a.o0.s.c.i0;
import d.a.p0.h3.i0.a;
import d.a.p0.h3.n0.f;
import d.a.p0.x1.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f21232e;

    /* renamed from: f  reason: collision with root package name */
    public d f21233f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f21234g;

    /* renamed from: h  reason: collision with root package name */
    public String f21235h;

    /* renamed from: i  reason: collision with root package name */
    public String f21236i;
    public byte[] j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public d.a.c.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public f.c s;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f21237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f21238f;

        public a(NewWriteModel newWriteModel, d.a.o0.r.s.a aVar) {
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
            this.f21238f = newWriteModel;
            this.f21237e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21237e.dismiss();
                this.f21238f.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f21239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f21240f;

        public b(NewWriteModel newWriteModel, d.a.o0.r.s.a aVar) {
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
            this.f21240f = newWriteModel;
            this.f21239e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21239e.dismiss();
                this.f21240f.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f21241a;

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
            this.f21241a = newWriteModel;
        }

        @Override // d.a.p0.h3.n0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f21241a.f21234g == null || TextUtils.isEmpty(str)) {
                    if (this.f21241a.m != null) {
                        this.f21241a.m.callback(false, null, null, this.f21241a.f21234g, null);
                        return;
                    }
                    return;
                }
                this.f21241a.f21232e = null;
                this.f21241a.f21234g.setAuthSid(str);
                this.f21241a.l0();
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f21241a.f21234g == null || TextUtils.isEmpty(str)) {
                    if (this.f21241a.m != null) {
                        this.f21241a.m.callback(false, null, null, this.f21241a.f21234g, null);
                        return;
                    }
                    return;
                }
                this.f21241a.f21232e = null;
                this.f21241a.f21234g.setAuthSid(str);
                this.f21241a.l0();
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f21241a.f21234g != null) {
                    this.f21241a.f21234g.setAuthSid(null);
                }
                if (this.f21241a.m != null) {
                    this.f21241a.m.callback(false, null, null, this.f21241a.f21234g, null);
                }
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f21241a.f21234g != null) {
                    this.f21241a.f21232e = null;
                    this.f21241a.f21234g.setAuthSid(null);
                    this.f21241a.l0();
                } else if (this.f21241a.m != null) {
                    this.f21241a.m.callback(false, null, null, this.f21241a.f21234g, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f21242a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.p0.h3.i0.a f21243b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f21244c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f21245d;

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
            this.f21245d = newWriteModel;
            this.f21242a = false;
            this.f21243b = new d.a.p0.h3.i0.a();
            this.f21244c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f21245d.f21236i);
                if (this.f21242a) {
                    return null;
                }
                if (this.f21245d.j == null || this.f21245d.j.length <= 0) {
                    if (TextUtils.isEmpty(this.f21245d.f21236i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f21245d.f21235h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f21245d.f21236i));
                    if (TextUtils.isEmpty(this.f21245d.f21235h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f21245d;
                    return newWriteModel.W(newWriteModel.f21235h, this.f21243b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f21245d.j);
                this.f21244c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f21245d.f21235h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f21245d.f21235h)) {
                    Bitmap bitmap = this.f21244c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f21244c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f21245d;
                return newWriteModel2.W(newWriteModel2.f21235h, this.f21243b);
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
                if (this.f21242a) {
                    return;
                }
                if (this.f21245d.k != null) {
                    this.f21245d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f21244c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f21244c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f21242a = true;
                d.a.p0.h3.i0.a aVar = this.f21243b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f21245d.k != null) {
                    this.f21245d.k.a(null, true);
                }
                Bitmap bitmap = this.f21244c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f21244c.recycle();
                }
                super.cancel();
                this.f21245d.f21233f = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z, String str, i0 i0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class h extends BdAsyncTask<Integer, Integer, d.a.p0.h3.q0.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.p0.h3.i0.a f21246a;

        /* renamed from: b  reason: collision with root package name */
        public String f21247b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21248c;

        /* renamed from: d  reason: collision with root package name */
        public k f21249d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.p0.x1.g f21250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f21251f;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f21252e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f21253f;

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
                this.f21253f = hVar;
                this.f21252e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.p0.h2.j.c.a((TbPageContext) this.f21253f.f21251f.o, this.f21252e).show();
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
            this.f21251f = newWriteModel;
            this.f21246a = null;
            this.f21247b = null;
            this.f21248c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f21249d = (k) runTask.getData();
            }
            k kVar = this.f21249d;
            if (kVar != null) {
                this.f21250e = kVar.get();
            }
            setPriority(3);
            d.a.p0.h3.q0.b.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x02f9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d.a.p0.h3.q0.f doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            d.a.p0.h3.q0.f fVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            d.a.o0.t.a aVar;
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
                if (this.f21248c) {
                    return null;
                }
                d.a.o0.a0.d.c(this.f21251f.f21234g.getContent());
                d.a.p0.h3.q0.b.a("doInBackground() start");
                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground");
                d.a.p0.h3.i0.a aVar2 = new d.a.p0.h3.i0.a();
                this.f21246a = aVar2;
                aVar2.j(this.f21251f.q);
                this.f21246a.k(this.f21251f.r);
                this.f21246a.l(this.f21250e);
                this.f21246a.i(this.f21251f.p);
                this.f21247b = this.f21246a.h(this.f21251f.f21234g, this.f21251f.n);
                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.f21246a.d();
                if (this.f21246a.e() && this.f21247b != null) {
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.f21246a.c();
                    String error_msg = d2.getError_msg();
                    if (d.a.c.e.p.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    fVar = new d.a.p0.h3.q0.f(d2.getError_code(), error_msg, c2);
                    if (this.f21251f.f21234g != null && this.f21251f.f21234g.isHasImages() && !fVar.s()) {
                        this.f21251f.f21234g.deleteUploadedTempImages();
                    }
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    fVar = new d.a.p0.h3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f21247b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f21247b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i2 = 0; i2 < length; i2++) {
                                    arrayList.add(jSONArray.optString(i2));
                                }
                                fVar.K(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    fVar = new d.a.p0.h3.q0.f(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f21247b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f21247b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                u1 u1Var = new u1();
                                u1Var.f52784a = optJSONObject2.optString("block_content");
                                u1Var.f52785b = optJSONObject2.optString("block_cancel");
                                u1Var.f52786c = optJSONObject2.optString("block_confirm");
                                fVar.J(u1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    fVar = new d.a.p0.h3.q0.f(d2.getError_code(), error_msg2, this.f21246a.c());
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    fVar = new d.a.p0.h3.q0.f(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!fVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f21247b != null) {
                            JSONObject jSONObject = new JSONObject(this.f21247b);
                            String optString = jSONObject.optString("msg");
                            try {
                                str4 = jSONObject.optString("pre_msg");
                            } catch (JSONException e4) {
                                e = e4;
                                str3 = optString;
                                aVar = null;
                                str = null;
                                str2 = null;
                                str4 = null;
                            }
                            try {
                                str5 = jSONObject.optString("color_msg");
                                try {
                                    str6 = jSONObject.optString("tid");
                                } catch (JSONException e5) {
                                    e = e5;
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
                                    fVar.C(str3);
                                    fVar.I(str4);
                                    fVar.A(str5);
                                    fVar.L(str6);
                                    fVar.H(str7);
                                    fVar.G(r6);
                                    fVar.E(str2);
                                    fVar.D(str);
                                    fVar.y(customDialogData);
                                    fVar.N(str8);
                                    fVar.B(contriInfo);
                                    fVar.M(videoEasterEggData);
                                    fVar.z(aVar);
                                    fVar.F(iconStampData);
                                    d.a.p0.h3.q0.b.a("doInBackground end");
                                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                            } catch (JSONException e6) {
                                e = e6;
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
                                fVar.C(str3);
                                fVar.I(str4);
                                fVar.A(str5);
                                fVar.L(str6);
                                fVar.H(str7);
                                fVar.G(r6);
                                fVar.E(str2);
                                fVar.D(str);
                                fVar.y(customDialogData);
                                fVar.N(str8);
                                fVar.B(contriInfo);
                                fVar.M(videoEasterEggData);
                                fVar.z(aVar);
                                fVar.F(iconStampData);
                                d.a.p0.h3.q0.b.a("doInBackground end");
                                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                            try {
                                str7 = jSONObject.optString("pid");
                            } catch (JSONException e7) {
                                e = e7;
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
                                fVar.C(str3);
                                fVar.I(str4);
                                fVar.A(str5);
                                fVar.L(str6);
                                fVar.H(str7);
                                fVar.G(r6);
                                fVar.E(str2);
                                fVar.D(str);
                                fVar.y(customDialogData);
                                fVar.N(str8);
                                fVar.B(contriInfo);
                                fVar.M(videoEasterEggData);
                                fVar.z(aVar);
                                fVar.F(iconStampData);
                                d.a.p0.h3.q0.b.a("doInBackground end");
                                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                            try {
                                str8 = jSONObject.optString("video_id");
                                try {
                                    customDialogData = d.a.p0.h2.b.a(jSONObject);
                                    try {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                        r6 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
                                        JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                        if (optJSONObject4 != null) {
                                            str2 = optJSONObject4.optString("pre_msg");
                                            try {
                                                str = optJSONObject4.optString("color_msg");
                                            } catch (JSONException e8) {
                                                e = e8;
                                                str3 = optString;
                                                aVar = null;
                                                str = null;
                                                videoEasterEggData = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                fVar.C(str3);
                                                fVar.I(str4);
                                                fVar.A(str5);
                                                fVar.L(str6);
                                                fVar.H(str7);
                                                fVar.G(r6);
                                                fVar.E(str2);
                                                fVar.D(str);
                                                fVar.y(customDialogData);
                                                fVar.N(str8);
                                                fVar.B(contriInfo);
                                                fVar.M(videoEasterEggData);
                                                fVar.z(aVar);
                                                fVar.F(iconStampData);
                                                d.a.p0.h3.q0.b.a("doInBackground end");
                                                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return fVar;
                                            }
                                        } else {
                                            str = null;
                                            str2 = null;
                                        }
                                    } catch (JSONException e9) {
                                        e = e9;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e10) {
                                    e = e10;
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
                                    fVar.C(str3);
                                    fVar.I(str4);
                                    fVar.A(str5);
                                    fVar.L(str6);
                                    fVar.H(str7);
                                    fVar.G(r6);
                                    fVar.E(str2);
                                    fVar.D(str);
                                    fVar.y(customDialogData);
                                    fVar.N(str8);
                                    fVar.B(contriInfo);
                                    fVar.M(videoEasterEggData);
                                    fVar.z(aVar);
                                    fVar.F(iconStampData);
                                    d.a.p0.h3.q0.b.a("doInBackground end");
                                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                                try {
                                    contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                                    JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                                    if (optJSONObject5 != null) {
                                        videoEasterEggData = new VideoEasterEggData();
                                        try {
                                            videoEasterEggData.parseJson(optJSONObject5);
                                        } catch (JSONException e11) {
                                            e = e11;
                                            str3 = optString;
                                            aVar = null;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            fVar.C(str3);
                                            fVar.I(str4);
                                            fVar.A(str5);
                                            fVar.L(str6);
                                            fVar.H(str7);
                                            fVar.G(r6);
                                            fVar.E(str2);
                                            fVar.D(str);
                                            fVar.y(customDialogData);
                                            fVar.N(str8);
                                            fVar.B(contriInfo);
                                            fVar.M(videoEasterEggData);
                                            fVar.z(aVar);
                                            fVar.F(iconStampData);
                                            d.a.p0.h3.q0.b.a("doInBackground end");
                                            d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
                                        }
                                    } else {
                                        videoEasterEggData = null;
                                    }
                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                    if (optJSONObject6 != null) {
                                        aVar = new d.a.o0.t.a();
                                        try {
                                            aVar.i(optJSONObject6);
                                        } catch (JSONException e12) {
                                            e = e12;
                                            str3 = optString;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            fVar.C(str3);
                                            fVar.I(str4);
                                            fVar.A(str5);
                                            fVar.L(str6);
                                            fVar.H(str7);
                                            fVar.G(r6);
                                            fVar.E(str2);
                                            fVar.D(str);
                                            fVar.y(customDialogData);
                                            fVar.N(str8);
                                            fVar.B(contriInfo);
                                            fVar.M(videoEasterEggData);
                                            fVar.z(aVar);
                                            fVar.F(iconStampData);
                                            d.a.p0.h3.q0.b.a("doInBackground end");
                                            d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
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
                                        } catch (JSONException e13) {
                                            jSONException = e13;
                                            iconStampData = iconStampData2;
                                            str3 = optString;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            fVar.C(str3);
                                            fVar.I(str4);
                                            fVar.A(str5);
                                            fVar.L(str6);
                                            fVar.H(str7);
                                            fVar.G(r6);
                                            fVar.E(str2);
                                            fVar.D(str);
                                            fVar.y(customDialogData);
                                            fVar.N(str8);
                                            fVar.B(contriInfo);
                                            fVar.M(videoEasterEggData);
                                            fVar.z(aVar);
                                            fVar.F(iconStampData);
                                            d.a.p0.h3.q0.b.a("doInBackground end");
                                            d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return fVar;
                                        }
                                    } else {
                                        str3 = optString;
                                        iconStampData = null;
                                    }
                                } catch (JSONException e14) {
                                    e = e14;
                                    str3 = optString;
                                    aVar = null;
                                    videoEasterEggData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    fVar.C(str3);
                                    fVar.I(str4);
                                    fVar.A(str5);
                                    fVar.L(str6);
                                    fVar.H(str7);
                                    fVar.G(r6);
                                    fVar.E(str2);
                                    fVar.D(str);
                                    fVar.y(customDialogData);
                                    fVar.N(str8);
                                    fVar.B(contriInfo);
                                    fVar.M(videoEasterEggData);
                                    fVar.z(aVar);
                                    fVar.F(iconStampData);
                                    d.a.p0.h3.q0.b.a("doInBackground end");
                                    d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return fVar;
                                }
                            } catch (JSONException e15) {
                                e = e15;
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
                                fVar.C(str3);
                                fVar.I(str4);
                                fVar.A(str5);
                                fVar.L(str6);
                                fVar.H(str7);
                                fVar.G(r6);
                                fVar.E(str2);
                                fVar.D(str);
                                fVar.y(customDialogData);
                                fVar.N(str8);
                                fVar.B(contriInfo);
                                fVar.M(videoEasterEggData);
                                fVar.z(aVar);
                                fVar.F(iconStampData);
                                d.a.p0.h3.q0.b.a("doInBackground end");
                                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
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
                    fVar.C(str3);
                    fVar.I(str4);
                    fVar.A(str5);
                    fVar.L(str6);
                    fVar.H(str7);
                    fVar.G(r6);
                    fVar.E(str2);
                    fVar.D(str);
                    fVar.y(customDialogData);
                    fVar.N(str8);
                    fVar.B(contriInfo);
                    fVar.M(videoEasterEggData);
                    fVar.z(aVar);
                    fVar.F(iconStampData);
                }
                d.a.p0.h3.q0.b.a("doInBackground end");
                d.a.p0.h3.q0.b.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return fVar;
            }
            return (d.a.p0.h3.q0.f) invokeL.objValue;
        }

        public final void c(d.a.p0.h3.q0.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || d.a.p0.h3.n0.f.a(fVar.f(), AuthTokenData.parse(this.f21247b), this.f21251f.s)) {
                return;
            }
            if (fVar.u()) {
                this.f21251f.b0(fVar);
            } else if (fVar.x()) {
                this.f21251f.a0(fVar);
                this.f21251f.b0(fVar);
            } else if (d.a.p0.r3.a.c(fVar.f())) {
                this.f21251f.Z(fVar);
                this.f21251f.b0(fVar);
            } else if (fVar.v()) {
                i0 i0Var = new i0();
                i0Var.e(this.f21247b);
                if (i0Var.c() == null || this.f21251f.f21234g == null) {
                    return;
                }
                this.f21251f.f21234g.setVcodeMD5(i0Var.b());
                this.f21251f.f21234g.setVcodeUrl(i0Var.c());
                NewWriteModel newWriteModel = this.f21251f;
                newWriteModel.c0(fVar, null, i0Var, newWriteModel.f21234g);
            } else if (fVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f21247b);
                NewWriteModel newWriteModel2 = this.f21251f;
                newWriteModel2.c0(fVar, accessState, null, newWriteModel2.f21234g);
            } else if (fVar.w()) {
                this.f21251f.b0(fVar);
            } else {
                this.f21251f.b0(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f21248c = true;
                d.a.p0.h3.i0.a aVar = this.f21246a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f21251f.m != null) {
                    this.f21251f.m.callback(false, null, null, this.f21251f.f21234g, null);
                } else if (this.f21251f.l != null) {
                    this.f21251f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f21251f.f21232e = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x01e2, code lost:
            if (r5 != 7) goto L58;
         */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(d.a.p0.h3.q0.f fVar) {
            String i2;
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                super.onPostExecute(fVar);
                d.a.p0.h3.q0.b.a("onPostExecute start");
                d.a.p0.h3.q0.b.a("发帖： onPostExecute");
                this.f21251f.f21232e = null;
                if (fVar != null && fVar.f() != 0) {
                    d.a.o0.r.z.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", fVar.f(), fVar.g(), "tid", fVar.p(), "pid", fVar.l());
                }
                if (!this.f21248c && fVar != null) {
                    if (fVar.s()) {
                        d.a.p0.h3.q0.b.a("onPostExecute error");
                        c(fVar);
                        d.a.p0.x1.g gVar = this.f21250e;
                        if (gVar != null) {
                            gVar.h(fVar.f58207a, fVar.g());
                        }
                    } else {
                        d.a.p0.h3.q0.b.a("onPostExecute success");
                        if (this.f21251f.m == null) {
                            if (this.f21251f.l != null) {
                                this.f21251f.l.a(true, fVar.g(), null, null, fVar.c());
                            }
                        } else {
                            if (!StringUtils.isNull(fVar.m()) && !StringUtils.isNull(fVar.d())) {
                                i2 = fVar.m();
                                h2 = fVar.d();
                            } else if (StringUtils.isNull(fVar.h()) && StringUtils.isNull(fVar.i())) {
                                i2 = null;
                                h2 = null;
                            } else {
                                i2 = fVar.i();
                                h2 = fVar.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), i2, h2);
                            postWriteCallBackData.setThreadId(fVar.p());
                            postWriteCallBackData.setPostId(fVar.l());
                            postWriteCallBackData.setIsCopyTWZhibo(fVar.k());
                            postWriteCallBackData.setErrorString(fVar.g());
                            postWriteCallBackData.setActivityDialog(fVar.a());
                            postWriteCallBackData.setVideoid(fVar.r());
                            postWriteCallBackData.setContriInfo(fVar.e());
                            if (this.f21251f.f21234g != null) {
                                postWriteCallBackData.setProZone(this.f21251f.f21234g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f21251f.f21234g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(fVar.q());
                            postWriteCallBackData.setmAdverSegmentData(fVar.b());
                            postWriteCallBackData.setIconStampData(fVar.j());
                            i0 i0Var = new i0();
                            i0Var.e(this.f21247b);
                            if (this.f21251f.f21234g != null && !this.f21251f.f21234g.isWork() && d.a.p0.h3.q0.a.g().f() != null) {
                                d.a.p0.h3.q0.a.g().s(this.f21251f.f21234g.getForumId());
                                d.a.p0.h3.q0.a.g().t(this.f21251f.f21234g.getForumName());
                                if (this.f21251f.f21234g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f21251f.f21234g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, d.a.p0.h3.q0.a.g().f()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                d.a.p0.h3.q0.a.g().q(null);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && fVar.j() == null) {
                                if (this.f21251f.f21234g != null) {
                                    int type = this.f21251f.f21234g.getType();
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
                                d.a.c.e.m.e.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f21251f.m.callback(true, postWriteCallBackData, i0Var, this.f21251f.f21234g, fVar.c());
                        }
                        if (this.f21251f.f21234g != null && !this.f21251f.f21234g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(fVar.j() == null)));
                        }
                        d.a.p0.x1.g gVar2 = this.f21250e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                    }
                    d.a.p0.h3.q0.b.a("发帖： onPostExecute 完全结束");
                    return;
                }
                d.a.p0.h3.q0.b.a("发帖： onPostExecute isCanceled");
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f21232e = null;
        this.f21233f = null;
        this.f21234g = null;
        this.f21235h = null;
        this.f21236i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = baseFragmentActivity.getPageContext();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dVar = this.f21233f) == null || dVar.isCancelled()) {
            return;
        }
        this.f21233f.cancel();
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WriteData writeData = this.f21234g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f21234g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f21232e == null) {
            if (d.a.p0.h3.q0.a.g().f() != null && (writeData = this.f21234g) != null && !writeData.isWork()) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, X());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, d.a.p0.h3.q0.a.g().f()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f21232e = new h(this);
            d.a.p0.h3.q0.b.a("dealPost()");
            this.f21232e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult W(String str, d.a.p0.h3.i0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(d.a.o0.b0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21234g : (WriteData) invokeV.objValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpanGroupManager spanGroupManager = this.q;
            if (spanGroupManager != null) {
                this.r = spanGroupManager.t();
            } else {
                this.r = null;
            }
        }
    }

    public final void Z(d.a.p0.h3.q0.f fVar) {
        d.a.c.a.f<?> fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || (fVar2 = this.o) == null || fVar == null || (this.m instanceof d.a.p0.h3.q0.a)) {
            return;
        }
        d.a.p0.r3.a.d(fVar2.getPageActivity(), fVar.g());
        fVar.C(null);
    }

    public final void a0(d.a.p0.h3.q0.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || this.o == null || fVar == null || fVar.c() == null || fVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), fVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void b0(d.a.p0.h3.q0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            c0(fVar, null, null, this.f21234g);
        }
    }

    public final void c0(d.a.p0.h3.q0.f fVar, AccessState accessState, i0 i0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048586, this, fVar, accessState, i0Var, writeData) == null) || fVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.f(), fVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(fVar.o());
            postWriteCallBackData.setReplyPrivacyTip(fVar.n());
            this.m.callback(false, postWriteCallBackData, i0Var, writeData, fVar.c());
            return;
        }
        f fVar2 = this.l;
        if (fVar2 != null) {
            fVar2.a(false, fVar.g(), i0Var, writeData, fVar.c());
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h hVar = this.f21232e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f21232e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f21234g, null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            h hVar = this.f21232e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f21232e.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.n = z;
        }
    }

    public void e0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void f0(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bArr, str) == null) {
            this.j = bArr;
            this.f21236i = str;
        }
    }

    public void g0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void h0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void i0(@Nullable d.a.c.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f21234g == null) {
                return false;
            }
            d.a.p0.h3.q0.b.a("发帖：开始上传");
            this.f21234g.startPublish();
            j1.h(this.f21234g, 0).f(true);
            V();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f21233f == null) {
            d dVar = new d(this);
            this.f21233f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f21234g == null) {
                return false;
            }
            if (j.z() && !j.H() && this.f21234g.getWriteImagesInfo() != null && this.f21234g.getWriteImagesInfo().size() != 0 && this.f21234g.getWriteImagesInfo().isOriginalImg() && !d.a.o0.r.d0.b.j().g("original_img_up_tip", false)) {
                d.a.o0.r.d0.b.j().t("original_img_up_tip", true);
                d.a.c.a.f<?> fVar = this.o;
                if (fVar == null) {
                    V();
                    return true;
                }
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(fVar.getPageActivity());
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

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, spanGroupManager) == null) {
            this.q = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, writeData) == null) {
            this.f21234g = writeData;
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f21232e = null;
        this.f21233f = null;
        this.f21234g = null;
        this.f21235h = null;
        this.f21236i = null;
        this.j = null;
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f21232e = null;
        this.f21233f = null;
        this.f21234g = null;
        this.f21235h = null;
        this.f21236i = null;
        this.j = null;
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
        this.f21232e = null;
        this.f21233f = null;
        this.f21234g = null;
        this.f21235h = null;
        this.f21236i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = null;
    }
}
