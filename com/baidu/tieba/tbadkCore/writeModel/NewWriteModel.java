package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.o0.s.q.k1;
import c.a.o0.s.q.v1;
import c.a.o0.s.s.a;
import c.a.o0.t.c.k0;
import c.a.p0.i3.i0.a;
import c.a.p0.i3.n0.f;
import c.a.p0.i3.q0.l;
import c.a.p0.y1.k;
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
    public h f56856e;

    /* renamed from: f  reason: collision with root package name */
    public d f56857f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f56858g;

    /* renamed from: h  reason: collision with root package name */
    public String f56859h;

    /* renamed from: i  reason: collision with root package name */
    public String f56860i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f56861j;
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
        public final /* synthetic */ c.a.o0.s.s.a f56862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f56863f;

        public a(NewWriteModel newWriteModel, c.a.o0.s.s.a aVar) {
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
            this.f56863f = newWriteModel;
            this.f56862e = aVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f56862e.dismiss();
                this.f56863f.V();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.a f56864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f56865f;

        public b(NewWriteModel newWriteModel, c.a.o0.s.s.a aVar) {
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
            this.f56865f = newWriteModel;
            this.f56864e = aVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f56864e.dismiss();
                this.f56865f.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f56866a;

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
            this.f56866a = newWriteModel;
        }

        @Override // c.a.p0.i3.n0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f56866a.f56858g == null || TextUtils.isEmpty(str)) {
                    if (this.f56866a.m != null) {
                        this.f56866a.m.callback(false, null, null, this.f56866a.f56858g, null);
                        return;
                    }
                    return;
                }
                this.f56866a.f56856e = null;
                this.f56866a.f56858g.setAuthSid(str);
                this.f56866a.l0();
            }
        }

        @Override // c.a.p0.i3.n0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f56866a.f56858g == null || TextUtils.isEmpty(str)) {
                    if (this.f56866a.m != null) {
                        this.f56866a.m.callback(false, null, null, this.f56866a.f56858g, null);
                        return;
                    }
                    return;
                }
                this.f56866a.f56856e = null;
                this.f56866a.f56858g.setAuthSid(str);
                this.f56866a.l0();
            }
        }

        @Override // c.a.p0.i3.n0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f56866a.f56858g != null) {
                    this.f56866a.f56858g.setAuthSid(null);
                }
                if (this.f56866a.m != null) {
                    this.f56866a.m.callback(false, null, null, this.f56866a.f56858g, null);
                }
            }
        }

        @Override // c.a.p0.i3.n0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f56866a.f56858g != null) {
                    this.f56866a.f56856e = null;
                    this.f56866a.f56858g.setAuthSid(null);
                    this.f56866a.l0();
                } else if (this.f56866a.m != null) {
                    this.f56866a.m.callback(false, null, null, this.f56866a.f56858g, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56867a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.i3.i0.a f56868b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f56869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f56870d;

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
            this.f56870d = newWriteModel;
            this.f56867a = false;
            this.f56868b = new c.a.p0.i3.i0.a();
            this.f56869c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f56870d.f56860i);
                if (this.f56867a) {
                    return null;
                }
                if (this.f56870d.f56861j == null || this.f56870d.f56861j.length <= 0) {
                    if (TextUtils.isEmpty(this.f56870d.f56860i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f56870d.f56859h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f56870d.f56860i));
                    if (TextUtils.isEmpty(this.f56870d.f56859h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f56870d;
                    return newWriteModel.W(newWriteModel.f56859h, this.f56868b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f56870d.f56861j);
                this.f56869c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f56870d.f56859h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f56870d.f56859h)) {
                    Bitmap bitmap = this.f56869c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f56869c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f56870d;
                return newWriteModel2.W(newWriteModel2.f56859h, this.f56868b);
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
                if (this.f56867a) {
                    return;
                }
                if (this.f56870d.k != null) {
                    this.f56870d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f56869c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f56869c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f56867a = true;
                c.a.p0.i3.i0.a aVar = this.f56868b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f56870d.k != null) {
                    this.f56870d.k.a(null, true);
                }
                Bitmap bitmap = this.f56869c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f56869c.recycle();
                }
                super.cancel();
                this.f56870d.f56857f = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(boolean z, String str, k0 k0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes7.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<Integer, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.p0.i3.i0.a f56871a;

        /* renamed from: b  reason: collision with root package name */
        public String f56872b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56873c;

        /* renamed from: d  reason: collision with root package name */
        public k f56874d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.y1.g f56875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f56876f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f56877e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f56878f;

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
                this.f56878f = hVar;
                this.f56877e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.i2.j.c.a((TbPageContext) this.f56878f.f56876f.o, this.f56877e).show();
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
            this.f56876f = newWriteModel;
            this.f56871a = null;
            this.f56872b = null;
            this.f56873c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f56874d = (k) runTask.getData();
            }
            k kVar = this.f56874d;
            if (kVar != null) {
                this.f56875e = kVar.get();
            }
            setPriority(3);
            c.a.p0.i3.q0.h.a("发帖：任务创建：PostThreadTask");
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
            c.a.o0.u.a aVar;
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
                if (this.f56873c) {
                    return null;
                }
                c.a.o0.b0.d.c(this.f56876f.f56858g.getContent());
                c.a.p0.i3.q0.h.a("doInBackground() start");
                c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground");
                c.a.p0.i3.i0.a aVar2 = new c.a.p0.i3.i0.a();
                this.f56871a = aVar2;
                aVar2.j(this.f56876f.q);
                this.f56871a.k(this.f56876f.r);
                this.f56871a.l(this.f56875e);
                this.f56871a.i(this.f56876f.p);
                this.f56872b = this.f56871a.h(this.f56876f.f56858g, this.f56876f.n);
                c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.f56871a.d();
                c.a.p0.i3.q0.d.c(this.f56876f.f56858g, d2);
                if (this.f56871a.e() && this.f56872b != null) {
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.f56871a.c();
                    String error_msg = d2.getError_msg();
                    if (c.a.e.e.p.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    lVar = new l(d2.getError_code(), error_msg, c2);
                    if (this.f56876f.f56858g != null && this.f56876f.f56858g.isHasImages() && !lVar.s()) {
                        this.f56876f.f56858g.deleteUploadedTempImages();
                    }
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f56872b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f56872b).optJSONObject("info");
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
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f56872b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f56872b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                v1 v1Var = new v1();
                                v1Var.f14059a = optJSONObject2.optString("block_content");
                                v1Var.f14060b = optJSONObject2.optString("block_cancel");
                                v1Var.f14061c = optJSONObject2.optString("block_confirm");
                                lVar.J(v1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    lVar = new l(d2.getError_code(), error_msg2, this.f56871a.c());
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    lVar = new l(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!lVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f56872b != null) {
                            JSONObject jSONObject = new JSONObject(this.f56872b);
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
                                        c.a.p0.i3.q0.h.a("doInBackground end");
                                        c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        c.a.p0.i3.q0.h.a("doInBackground end");
                                        c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return lVar;
                                    }
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                        try {
                                            customDialogData = c.a.p0.i2.b.a(jSONObject);
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
                                                        c.a.p0.i3.q0.h.a("doInBackground end");
                                                        c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            c.a.p0.i3.q0.h.a("doInBackground end");
                                                            c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return lVar;
                                                        }
                                                    } else {
                                                        videoEasterEggData = null;
                                                    }
                                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                                    if (optJSONObject6 != null) {
                                                        aVar = new c.a.o0.u.a();
                                                        try {
                                                            aVar.i(optJSONObject6);
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
                                                            c.a.p0.i3.q0.h.a("doInBackground end");
                                                            c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            c.a.p0.i3.q0.h.a("doInBackground end");
                                                            c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                    c.a.p0.i3.q0.h.a("doInBackground end");
                                                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                            c.a.p0.i3.q0.h.a("doInBackground end");
                                            c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        c.a.p0.i3.q0.h.a("doInBackground end");
                                        c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                    c.a.p0.i3.q0.h.a("doInBackground end");
                                    c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                c.a.p0.i3.q0.h.a("doInBackground end");
                c.a.p0.i3.q0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return lVar;
            }
            return (l) invokeL.objValue;
        }

        public final void c(l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) || c.a.p0.i3.n0.f.a(lVar.f(), AuthTokenData.parse(this.f56872b), this.f56876f.s)) {
                return;
            }
            if (lVar.u()) {
                this.f56876f.b0(lVar);
            } else if (lVar.x()) {
                this.f56876f.a0(lVar);
                this.f56876f.b0(lVar);
            } else if (c.a.p0.s3.a.c(lVar.f())) {
                this.f56876f.Z(lVar);
                this.f56876f.b0(lVar);
            } else if (lVar.v()) {
                k0 k0Var = new k0();
                k0Var.e(this.f56872b);
                if (k0Var.c() == null || this.f56876f.f56858g == null) {
                    return;
                }
                this.f56876f.f56858g.setVcodeMD5(k0Var.b());
                this.f56876f.f56858g.setVcodeUrl(k0Var.c());
                NewWriteModel newWriteModel = this.f56876f;
                newWriteModel.c0(lVar, null, k0Var, newWriteModel.f56858g);
            } else if (lVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f56872b);
                NewWriteModel newWriteModel2 = this.f56876f;
                newWriteModel2.c0(lVar, accessState, null, newWriteModel2.f56858g);
            } else if (lVar.w()) {
                this.f56876f.b0(lVar);
            } else {
                this.f56876f.b0(lVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f56873c = true;
                c.a.p0.i3.i0.a aVar = this.f56871a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f56876f.m != null) {
                    this.f56876f.m.callback(false, null, null, this.f56876f.f56858g, null);
                } else if (this.f56876f.l != null) {
                    this.f56876f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f56876f.f56856e = null;
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
        public void onPostExecute(l lVar) {
            String i2;
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
                super.onPostExecute(lVar);
                c.a.p0.i3.q0.h.a("onPostExecute start");
                c.a.p0.i3.q0.h.a("发帖： onPostExecute");
                this.f56876f.f56856e = null;
                if (lVar != null && lVar.f() != 0) {
                    c.a.o0.s.z.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", lVar.f(), lVar.g(), "tid", lVar.p(), "pid", lVar.l());
                }
                if (!this.f56873c && lVar != null) {
                    if (lVar.s()) {
                        c.a.p0.i3.q0.h.a("onPostExecute error");
                        c(lVar);
                        c.a.p0.y1.g gVar = this.f56875e;
                        if (gVar != null) {
                            gVar.h(lVar.f20220a, lVar.g());
                        }
                    } else {
                        c.a.p0.i3.q0.h.a("onPostExecute success");
                        if (this.f56876f.m == null) {
                            if (this.f56876f.l != null) {
                                this.f56876f.l.a(true, lVar.g(), null, null, lVar.c());
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
                            if (this.f56876f.f56858g != null) {
                                postWriteCallBackData.setProZone(this.f56876f.f56858g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f56876f.f56858g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(lVar.q());
                            postWriteCallBackData.setmAdverSegmentData(lVar.b());
                            postWriteCallBackData.setIconStampData(lVar.j());
                            k0 k0Var = new k0();
                            k0Var.e(this.f56872b);
                            if (this.f56876f.f56858g != null && !this.f56876f.f56858g.isWork() && c.a.p0.i3.q0.g.g().f() != null) {
                                c.a.p0.i3.q0.g.g().s(this.f56876f.f56858g.getForumId());
                                c.a.p0.i3.q0.g.g().t(this.f56876f.f56858g.getForumName());
                                if (this.f56876f.f56858g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f56876f.f56858g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.p0.i3.q0.g.g().f()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                c.a.p0.i3.q0.g.g().q(null);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && lVar.j() == null) {
                                if (this.f56876f.f56858g != null) {
                                    int type = this.f56876f.f56858g.getType();
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
                            this.f56876f.m.callback(true, postWriteCallBackData, k0Var, this.f56876f.f56858g, lVar.c());
                        }
                        if (this.f56876f.f56858g != null && !this.f56876f.f56858g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(lVar.j() == null)));
                        }
                        c.a.p0.y1.g gVar2 = this.f56875e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                    }
                    c.a.p0.i3.q0.h.a("发帖： onPostExecute 完全结束");
                    return;
                }
                c.a.p0.i3.q0.h.a("发帖： onPostExecute isCanceled");
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
        this.f56856e = null;
        this.f56857f = null;
        this.f56858g = null;
        this.f56859h = null;
        this.f56860i = null;
        this.f56861j = null;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dVar = this.f56857f) == null || dVar.isCancelled()) {
            return;
        }
        this.f56857f.cancel();
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WriteData writeData = this.f56858g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f56858g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f56856e == null) {
            if (c.a.p0.i3.q0.g.g().f() != null && (writeData = this.f56858g) != null && !writeData.isWork()) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, X());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, c.a.p0.i3.q0.g.g().f()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f56856e = new h(this);
            c.a.p0.i3.q0.h.a("dealPost()");
            c.a.p0.i3.q0.d.l(this.f56858g);
            this.f56856e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult W(String str, c.a.p0.i3.i0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(c.a.o0.c0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56858g : (WriteData) invokeV.objValue;
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

    public final void Z(l lVar) {
        c.a.e.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) || (fVar = this.o) == null || lVar == null || (this.m instanceof c.a.p0.i3.q0.g)) {
            return;
        }
        c.a.p0.s3.a.d(fVar.getPageActivity(), lVar.g());
        lVar.C(null);
    }

    public final void a0(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) || this.o == null || lVar == null || lVar.c() == null || lVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.o.getPageActivity(), lVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void b0(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            c0(lVar, null, null, this.f56858g);
        }
    }

    public final void c0(l lVar, AccessState accessState, k0 k0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048586, this, lVar, accessState, k0Var, writeData) == null) || lVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(lVar.f(), lVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(lVar.o());
            postWriteCallBackData.setReplyPrivacyTip(lVar.n());
            this.m.callback(false, postWriteCallBackData, k0Var, writeData, lVar.c());
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, lVar.g(), k0Var, writeData, lVar.c());
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h hVar = this.f56856e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f56856e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f56858g, null);
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
            h hVar = this.f56856e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f56856e.cancel();
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
            this.f56861j = bArr;
            this.f56860i = str;
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

    public void i0(@Nullable c.a.e.a.f<?> fVar) {
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
            if (this.f56858g == null) {
                return false;
            }
            c.a.p0.i3.q0.h.a("发帖：开始上传");
            this.f56858g.startPublish();
            k1.h(this.f56858g, 0).f(true);
            V();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f56857f == null) {
            d dVar = new d(this);
            this.f56857f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f56858g == null) {
                return false;
            }
            if (j.z() && !j.H() && this.f56858g.getWriteImagesInfo() != null && this.f56858g.getWriteImagesInfo().size() != 0 && this.f56858g.getWriteImagesInfo().isOriginalImg() && !c.a.o0.s.d0.b.j().g("original_img_up_tip", false)) {
                c.a.o0.s.d0.b.j().t("original_img_up_tip", true);
                c.a.e.a.f<?> fVar = this.o;
                if (fVar == null) {
                    V();
                    return true;
                }
                c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(fVar.getPageActivity());
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
            this.f56858g = writeData;
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
        this.f56856e = null;
        this.f56857f = null;
        this.f56858g = null;
        this.f56859h = null;
        this.f56860i = null;
        this.f56861j = null;
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
        this.f56856e = null;
        this.f56857f = null;
        this.f56858g = null;
        this.f56859h = null;
        this.f56860i = null;
        this.f56861j = null;
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
        this.f56856e = null;
        this.f56857f = null;
        this.f56858g = null;
        this.f56859h = null;
        this.f56860i = null;
        this.f56861j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = null;
    }
}
