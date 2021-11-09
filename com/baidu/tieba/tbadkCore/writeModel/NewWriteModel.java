package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.q0.s.q.l1;
import b.a.q0.s.q.w1;
import b.a.q0.s.s.a;
import b.a.q0.t.c.m0;
import b.a.r0.a2.k;
import b.a.r0.l3.k0.a;
import b.a.r0.l3.p0.f;
import b.a.r0.l3.s0.l;
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
/* loaded from: classes9.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f54301e;

    /* renamed from: f  reason: collision with root package name */
    public d f54302f;

    /* renamed from: g  reason: collision with root package name */
    public WriteData f54303g;

    /* renamed from: h  reason: collision with root package name */
    public String f54304h;

    /* renamed from: i  reason: collision with root package name */
    public String f54305i;
    public byte[] j;
    public e k;
    public f l;
    public g m;
    public boolean n;
    public b.a.e.a.f<?> o;
    public a.c p;
    public SpanGroupManager q;
    public String r;
    public f.c s;

    /* loaded from: classes9.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f54306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f54307f;

        public a(NewWriteModel newWriteModel, b.a.q0.s.s.a aVar) {
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
            this.f54307f = newWriteModel;
            this.f54306e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f54306e.dismiss();
                this.f54307f.V();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f54308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f54309f;

        public b(NewWriteModel newWriteModel, b.a.q0.s.s.a aVar) {
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
            this.f54309f = newWriteModel;
            this.f54308e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f54308e.dismiss();
                this.f54309f.cancel();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f54310a;

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
            this.f54310a = newWriteModel;
        }

        @Override // b.a.r0.l3.p0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f54310a.f54303g == null || TextUtils.isEmpty(str)) {
                    if (this.f54310a.m != null) {
                        this.f54310a.m.callback(false, null, null, this.f54310a.f54303g, null);
                        return;
                    }
                    return;
                }
                this.f54310a.f54301e = null;
                this.f54310a.f54303g.setAuthSid(str);
                this.f54310a.l0();
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f54310a.f54303g == null || TextUtils.isEmpty(str)) {
                    if (this.f54310a.m != null) {
                        this.f54310a.m.callback(false, null, null, this.f54310a.f54303g, null);
                        return;
                    }
                    return;
                }
                this.f54310a.f54301e = null;
                this.f54310a.f54303g.setAuthSid(str);
                this.f54310a.l0();
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f54310a.f54303g != null) {
                    this.f54310a.f54303g.setAuthSid(null);
                }
                if (this.f54310a.m != null) {
                    this.f54310a.m.callback(false, null, null, this.f54310a.f54303g, null);
                }
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f54310a.f54303g != null) {
                    this.f54310a.f54301e = null;
                    this.f54310a.f54303g.setAuthSid(null);
                    this.f54310a.l0();
                } else if (this.f54310a.m != null) {
                    this.f54310a.m.callback(false, null, null, this.f54310a.f54303g, null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f54311a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.l3.k0.a f54312b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f54313c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f54314d;

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
            this.f54314d = newWriteModel;
            this.f54311a = false;
            this.f54312b = new b.a.r0.l3.k0.a();
            this.f54313c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f54314d.f54305i);
                if (this.f54311a) {
                    return null;
                }
                if (this.f54314d.j == null || this.f54314d.j.length <= 0) {
                    if (TextUtils.isEmpty(this.f54314d.f54305i) || !isLocalImagePath) {
                        return null;
                    }
                    this.f54314d.f54304h = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f54314d.f54305i));
                    if (TextUtils.isEmpty(this.f54314d.f54304h)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f54314d;
                    return newWriteModel.W(newWriteModel.f54304h, this.f54312b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f54314d.j);
                this.f54313c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f54314d.f54304h = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f54314d.f54304h)) {
                    Bitmap bitmap = this.f54313c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f54313c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f54314d;
                return newWriteModel2.W(newWriteModel2.f54304h, this.f54312b);
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
                if (this.f54311a) {
                    return;
                }
                if (this.f54314d.k != null) {
                    this.f54314d.k.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f54313c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f54313c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f54311a = true;
                b.a.r0.l3.k0.a aVar = this.f54312b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f54314d.k != null) {
                    this.f54314d.k.a(null, true);
                }
                Bitmap bitmap = this.f54313c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f54313c.recycle();
                }
                super.cancel();
                this.f54314d.f54302f = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(boolean z, String str, m0 m0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes9.dex */
    public class h extends BdAsyncTask<Integer, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.r0.l3.k0.a f54315a;

        /* renamed from: b  reason: collision with root package name */
        public String f54316b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f54317c;

        /* renamed from: d  reason: collision with root package name */
        public k f54318d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.a2.g f54319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f54320f;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f54321e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f54322f;

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
                this.f54322f = hVar;
                this.f54321e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.r0.k2.t.c.a((TbPageContext) this.f54322f.f54320f.o, this.f54321e).show();
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
            this.f54320f = newWriteModel;
            this.f54315a = null;
            this.f54316b = null;
            this.f54317c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f54318d = (k) runTask.getData();
            }
            k kVar = this.f54318d;
            if (kVar != null) {
                this.f54319e = kVar.get();
            }
            setPriority(3);
            b.a.r0.l3.s0.h.a("发帖：任务创建：PostThreadTask");
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
            b.a.q0.u.a aVar;
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
                if (this.f54317c) {
                    return null;
                }
                b.a.q0.c0.d.c(this.f54320f.f54303g.getContent());
                b.a.r0.l3.s0.h.a("doInBackground() start");
                b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground");
                b.a.r0.l3.k0.a aVar2 = new b.a.r0.l3.k0.a();
                this.f54315a = aVar2;
                aVar2.j(this.f54320f.q);
                this.f54315a.k(this.f54320f.r);
                this.f54315a.l(this.f54319e);
                this.f54315a.i(this.f54320f.p);
                this.f54316b = this.f54315a.h(this.f54320f.f54303g, this.f54320f.n);
                b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.f54315a.d();
                b.a.r0.l3.s0.d.c(this.f54320f.f54303g, d2);
                if (this.f54315a.e() && this.f54316b != null) {
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.f54315a.c();
                    String error_msg = d2.getError_msg();
                    if (b.a.e.e.p.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    lVar = new l(d2.getError_code(), error_msg, c2);
                    if (this.f54320f.f54303g != null && this.f54320f.f54303g.isHasImages() && !lVar.s()) {
                        this.f54320f.f54303g.deleteUploadedTempImages();
                    }
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f54316b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f54316b).optJSONObject("info");
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
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    lVar = new l(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f54316b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f54316b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                w1 w1Var = new w1();
                                w1Var.f13472a = optJSONObject2.optString("block_content");
                                w1Var.f13473b = optJSONObject2.optString("block_cancel");
                                w1Var.f13474c = optJSONObject2.optString("block_confirm");
                                lVar.J(w1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    lVar = new l(d2.getError_code(), error_msg2, this.f54315a.c());
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    lVar = new l(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!lVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f54316b != null) {
                            JSONObject jSONObject = new JSONObject(this.f54316b);
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
                                        b.a.r0.l3.s0.h.a("doInBackground end");
                                        b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        b.a.r0.l3.s0.h.a("doInBackground end");
                                        b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                        return lVar;
                                    }
                                    try {
                                        str8 = jSONObject.optString("video_id");
                                        try {
                                            customDialogData = b.a.r0.k2.b.a(jSONObject);
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
                                                        b.a.r0.l3.s0.h.a("doInBackground end");
                                                        b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            b.a.r0.l3.s0.h.a("doInBackground end");
                                                            b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                            return lVar;
                                                        }
                                                    } else {
                                                        videoEasterEggData = null;
                                                    }
                                                    JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                                    if (optJSONObject6 != null) {
                                                        aVar = new b.a.q0.u.a();
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
                                                            b.a.r0.l3.s0.h.a("doInBackground end");
                                                            b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                            b.a.r0.l3.s0.h.a("doInBackground end");
                                                            b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                    b.a.r0.l3.s0.h.a("doInBackground end");
                                                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                            b.a.r0.l3.s0.h.a("doInBackground end");
                                            b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                        b.a.r0.l3.s0.h.a("doInBackground end");
                                        b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                    b.a.r0.l3.s0.h.a("doInBackground end");
                                    b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                b.a.r0.l3.s0.h.a("doInBackground end");
                b.a.r0.l3.s0.h.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return lVar;
            }
            return (l) invokeL.objValue;
        }

        public final void c(l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) || b.a.r0.l3.p0.f.a(lVar.f(), AuthTokenData.parse(this.f54316b), this.f54320f.s)) {
                return;
            }
            if (lVar.u()) {
                this.f54320f.b0(lVar);
            } else if (lVar.x()) {
                this.f54320f.a0(lVar);
                this.f54320f.b0(lVar);
            } else if (b.a.r0.v3.a.c(lVar.f())) {
                this.f54320f.Z(lVar);
                this.f54320f.b0(lVar);
            } else if (lVar.v()) {
                m0 m0Var = new m0();
                m0Var.e(this.f54316b);
                if (m0Var.c() == null || this.f54320f.f54303g == null) {
                    return;
                }
                this.f54320f.f54303g.setVcodeMD5(m0Var.b());
                this.f54320f.f54303g.setVcodeUrl(m0Var.c());
                NewWriteModel newWriteModel = this.f54320f;
                newWriteModel.c0(lVar, null, m0Var, newWriteModel.f54303g);
            } else if (lVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f54316b);
                NewWriteModel newWriteModel2 = this.f54320f;
                newWriteModel2.c0(lVar, accessState, null, newWriteModel2.f54303g);
            } else if (lVar.w()) {
                this.f54320f.b0(lVar);
            } else {
                this.f54320f.b0(lVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f54317c = true;
                b.a.r0.l3.k0.a aVar = this.f54315a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f54320f.m != null) {
                    this.f54320f.m.callback(false, null, null, this.f54320f.f54303g, null);
                } else if (this.f54320f.l != null) {
                    this.f54320f.l.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f54320f.f54301e = null;
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
                b.a.r0.l3.s0.h.a("onPostExecute start");
                b.a.r0.l3.s0.h.a("发帖： onPostExecute");
                this.f54320f.f54301e = null;
                if (lVar != null && lVar.f() != 0) {
                    b.a.q0.s.a0.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", lVar.f(), lVar.g(), "tid", lVar.p(), "pid", lVar.l());
                }
                if (!this.f54317c && lVar != null) {
                    if (lVar.s()) {
                        b.a.r0.l3.s0.h.a("onPostExecute error");
                        c(lVar);
                        b.a.r0.a2.g gVar = this.f54319e;
                        if (gVar != null) {
                            gVar.h(lVar.f20877a, lVar.g());
                        }
                    } else {
                        b.a.r0.l3.s0.h.a("onPostExecute success");
                        if (this.f54320f.m == null) {
                            if (this.f54320f.l != null) {
                                this.f54320f.l.a(true, lVar.g(), null, null, lVar.c());
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
                            if (this.f54320f.f54303g != null) {
                                postWriteCallBackData.setProZone(this.f54320f.f54303g.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f54320f.f54303g.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(lVar.q());
                            postWriteCallBackData.setmAdverSegmentData(lVar.b());
                            postWriteCallBackData.setIconStampData(lVar.j());
                            m0 m0Var = new m0();
                            m0Var.e(this.f54316b);
                            if (this.f54320f.f54303g != null && b.a.r0.l3.s0.g.j().h() != null) {
                                b.a.r0.l3.s0.g.j().A(this.f54320f.f54303g.getForumId());
                                b.a.r0.l3.s0.g.j().B(this.f54320f.f54303g.getForumName());
                                if (this.f54320f.f54303g.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f54320f.f54303g;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, b.a.r0.l3.s0.g.j().h()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                b.a.r0.l3.s0.g.j().v(null);
                                b.a.r0.l3.s0.g.j().y(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && lVar.j() == null) {
                                if (this.f54320f.f54303g != null) {
                                    int type = this.f54320f.f54303g.getType();
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
                                b.a.e.e.m.e.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f54320f.m.callback(true, postWriteCallBackData, m0Var, this.f54320f.f54303g, lVar.c());
                        }
                        if (this.f54320f.f54303g != null && !this.f54320f.f54303g.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(lVar.j() == null)));
                        }
                        b.a.r0.a2.g gVar2 = this.f54319e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                    }
                    b.a.r0.l3.s0.h.a("发帖： onPostExecute 完全结束");
                    return;
                }
                b.a.r0.l3.s0.h.a("发帖： onPostExecute isCanceled");
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f54301e = null;
        this.f54302f = null;
        this.f54303g = null;
        this.f54304h = null;
        this.f54305i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = baseFragmentActivity.getPageContext();
    }

    public void T() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f54302f) == null || dVar.isCancelled()) {
            return;
        }
        this.f54302f.cancel();
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.f54303g;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f54303g.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f54301e == null) {
            if (b.a.r0.l3.s0.g.j().h() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, X());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, b.a.r0.l3.s0.g.j().h()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.f54301e = new h(this);
            b.a.r0.l3.s0.h.a("dealPost()");
            b.a.r0.l3.s0.d.l(this.f54303g);
            this.f54301e.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult W(String str, b.a.r0.l3.k0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(b.a.q0.d0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54303g : (WriteData) invokeV.objValue;
    }

    public void Y() {
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

    public final void Z(l lVar) {
        b.a.e.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) || (fVar = this.o) == null || lVar == null || (this.m instanceof b.a.r0.l3.s0.g)) {
            return;
        }
        b.a.r0.v3.a.d(fVar.getPageActivity(), lVar.g());
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
            c0(lVar, null, null, this.f54303g);
        }
    }

    public final void c0(l lVar, AccessState accessState, m0 m0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, lVar, accessState, m0Var, writeData) == null) || lVar == null) {
            return;
        }
        if (this.m != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(lVar.f(), lVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(lVar.o());
            postWriteCallBackData.setReplyPrivacyTip(lVar.n());
            this.m.callback(false, postWriteCallBackData, m0Var, writeData, lVar.c());
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(false, lVar.g(), m0Var, writeData, lVar.c());
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h hVar = this.f54301e;
            if (hVar != null && !hVar.isCancelled()) {
                this.f54301e.cancel();
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f54303g, null);
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
            h hVar = this.f54301e;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.f54301e.cancel();
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
            this.j = bArr;
            this.f54305i = str;
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

    public void i0(@Nullable b.a.e.a.f<?> fVar) {
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
            if (this.f54303g == null) {
                return false;
            }
            b.a.r0.l3.s0.h.a("发帖：开始上传");
            this.f54303g.startPublish();
            l1.g(this.f54303g, 0).f(true);
            V();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.f54302f == null) {
            d dVar = new d(this);
            this.f54302f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f54303g == null) {
                return false;
            }
            if (j.z() && !j.H() && this.f54303g.getWriteImagesInfo() != null && this.f54303g.getWriteImagesInfo().size() != 0 && this.f54303g.getWriteImagesInfo().isOriginalImg() && !b.a.q0.s.e0.b.j().g("original_img_up_tip", false)) {
                b.a.q0.s.e0.b.j().t("original_img_up_tip", true);
                b.a.e.a.f<?> fVar = this.o;
                if (fVar == null) {
                    V();
                    return true;
                }
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(fVar.getPageActivity());
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
            this.f54303g = writeData;
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f54301e = null;
        this.f54302f = null;
        this.f54303g = null;
        this.f54304h = null;
        this.f54305i = null;
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f54301e = null;
        this.f54302f = null;
        this.f54303g = null;
        this.f54304h = null;
        this.f54305i = null;
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
        this.f54301e = null;
        this.f54302f = null;
        this.f54303g = null;
        this.f54304h = null;
        this.f54305i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.s = new c(this);
        this.o = null;
    }
}
