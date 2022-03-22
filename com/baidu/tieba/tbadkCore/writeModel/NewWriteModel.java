package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.o0.r.r.t1;
import c.a.o0.r.t.a;
import c.a.o0.s.c.l0;
import c.a.p0.a4.l0.a;
import c.a.p0.a4.q0.f;
import c.a.p0.l2.k;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public d f36202b;

    /* renamed from: c  reason: collision with root package name */
    public WriteData f36203c;

    /* renamed from: d  reason: collision with root package name */
    public String f36204d;

    /* renamed from: e  reason: collision with root package name */
    public String f36205e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f36206f;

    /* renamed from: g  reason: collision with root package name */
    public e f36207g;

    /* renamed from: h  reason: collision with root package name */
    public f f36208h;
    public g i;
    public boolean j;
    public c.a.d.a.f<?> k;
    public a.c l;
    public SpanGroupManager m;
    public String n;
    public boolean o;
    public boolean p;
    public f.c q;

    /* loaded from: classes6.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f36209b;

        public a(NewWriteModel newWriteModel, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36209b = newWriteModel;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
                this.f36209b.Z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f36210b;

        public b(NewWriteModel newWriteModel, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36210b = newWriteModel;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
                this.f36210b.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.p0.a4.q0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.f36203c == null || TextUtils.isEmpty(str)) {
                    if (this.a.i != null) {
                        this.a.i.callback(false, null, null, this.a.f36203c, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.f36203c.setAuthSid(str);
                this.a.r0();
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.f36203c == null || TextUtils.isEmpty(str)) {
                    if (this.a.i != null) {
                        this.a.i.callback(false, null, null, this.a.f36203c, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.f36203c.setAuthSid(str);
                this.a.r0();
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.f36203c != null) {
                    this.a.f36203c.setAuthSid(null);
                }
                if (this.a.i != null) {
                    this.a.i.callback(false, null, null, this.a.f36203c, null);
                }
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f36203c != null) {
                    this.a.a = null;
                    this.a.f36203c.setAuthSid(null);
                    this.a.r0();
                } else if (this.a.i != null) {
                    this.a.i.callback(false, null, null, this.a.f36203c, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.a4.l0.a f36211b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f36212c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f36213d;

        public d(NewWriteModel newWriteModel) {
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
            this.f36213d = newWriteModel;
            this.a = false;
            this.f36211b = new c.a.p0.a4.l0.a();
            this.f36212c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.f36213d.f36205e);
                if (this.a) {
                    return null;
                }
                if (this.f36213d.f36206f == null || this.f36213d.f36206f.length <= 0) {
                    if (TextUtils.isEmpty(this.f36213d.f36205e) || !isLocalImagePath) {
                        return null;
                    }
                    this.f36213d.f36204d = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f36213d.f36205e));
                    if (TextUtils.isEmpty(this.f36213d.f36204d)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.f36213d;
                    return newWriteModel.a0(newWriteModel.f36204d, this.f36211b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f36213d.f36206f);
                this.f36212c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.f36213d.f36204d = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.f36213d.f36204d)) {
                    Bitmap bitmap = this.f36212c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f36212c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.f36213d;
                return newWriteModel2.a0(newWriteModel2.f36204d, this.f36211b);
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
                if (this.f36213d.f36207g != null) {
                    this.f36213d.f36207g.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.f36212c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f36212c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                c.a.p0.a4.l0.a aVar = this.f36211b;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f36213d.f36207g != null) {
                    this.f36213d.f36207g.a(null, true);
                }
                Bitmap bitmap = this.f36212c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f36212c.recycle();
                }
                super.cancel();
                this.f36213d.f36202b = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z, String str, l0 l0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<Integer, Integer, c.a.p0.a4.t0.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a4.l0.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f36214b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36215c;

        /* renamed from: d  reason: collision with root package name */
        public k f36216d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.l2.g f36217e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewWriteModel f36218f;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36219b;

            public a(h hVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36219b = hVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.w2.k.c.a((TbPageContext) this.f36219b.f36218f.k, this.a).show();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36218f = newWriteModel;
            this.a = null;
            this.f36214b = null;
            this.f36215c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.f36216d = (k) runTask.getData();
            }
            k kVar = this.f36216d;
            if (kVar != null) {
                this.f36217e = kVar.get();
            }
            setPriority(3);
            c.a.p0.a4.t0.c.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x030c  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c.a.p0.a4.t0.g doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            c.a.p0.a4.t0.g gVar;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            c.a.o0.t.a aVar;
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
                if (this.f36215c) {
                    return null;
                }
                c.a.o0.b0.d.c(this.f36218f.f36203c.getContent());
                c.a.p0.a4.t0.c.a("doInBackground() start");
                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground");
                c.a.p0.a4.l0.a aVar2 = new c.a.p0.a4.l0.a();
                this.a = aVar2;
                aVar2.j(this.f36218f.m);
                this.a.k(this.f36218f.n);
                this.a.l(this.f36217e);
                this.a.i(this.f36218f.l);
                this.f36214b = this.a.h(this.f36218f.f36203c, this.f36218f.j);
                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d2 = this.a.d();
                c.a.p0.a4.t0.a.c(this.f36218f.f36203c, d2);
                if (this.a.e() && this.f36214b != null) {
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c2 = this.a.c();
                    String error_msg = d2.getError_msg();
                    if (m.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10e5);
                    }
                    gVar = new c.a.p0.a4.t0.g(d2.getError_code(), error_msg, c2);
                    if (this.f36218f.f36203c != null && this.f36218f.f36203c.isHasImages() && !gVar.s()) {
                        this.f36218f.f36203c.deleteUploadedTempImages();
                    }
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d2 != null && d2.error_code == 220015) {
                    gVar = new c.a.p0.a4.t0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f36214b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.f36214b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                gVar.K(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d2 != null && d2.error_code == 238010) {
                    gVar = new c.a.p0.a4.t0.g(d2.getError_code(), d2.getError_msg(), null);
                    if (this.f36214b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.f36214b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                t1 t1Var = new t1();
                                t1Var.a = optJSONObject2.optString("block_content");
                                t1Var.f10955b = optJSONObject2.optString("block_cancel");
                                t1Var.f10956c = optJSONObject2.optString("block_confirm");
                                gVar.J(t1Var);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d2 != null && d2.error_code != 0) {
                    String error_msg2 = d2.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d2.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0277);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10da);
                        }
                    }
                    gVar = new c.a.p0.a4.t0.g(d2.getError_code(), error_msg2, this.a.c());
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    gVar = new c.a.p0.a4.t0.g(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c15), null);
                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!gVar.s()) {
                    ContriInfo contriInfo = new ContriInfo();
                    try {
                        if (this.f36214b != null) {
                            JSONObject jSONObject = new JSONObject(this.f36214b);
                            String optString = jSONObject.optString("msg");
                            try {
                                str4 = jSONObject.optString("pre_msg");
                            } catch (JSONException e4) {
                                e = e4;
                                str3 = optString;
                                aVar = null;
                                str = null;
                                str2 = null;
                                videoEasterEggData = null;
                                str4 = null;
                            }
                            try {
                                str5 = jSONObject.optString("color_msg");
                            } catch (JSONException e5) {
                                e = e5;
                                str3 = optString;
                                aVar = null;
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
                                gVar.C(str3);
                                gVar.I(str4);
                                gVar.A(str5);
                                gVar.L(str6);
                                gVar.H(str7);
                                gVar.G(r7);
                                gVar.E(str2);
                                gVar.D(str);
                                gVar.y(customDialogData);
                                gVar.N(str8);
                                gVar.B(contriInfo);
                                gVar.M(videoEasterEggData);
                                gVar.z(aVar);
                                gVar.F(iconStampData);
                                c.a.p0.a4.t0.c.a("doInBackground end");
                                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return gVar;
                            }
                            try {
                                str6 = jSONObject.optString("tid");
                                try {
                                    str7 = jSONObject.optString("pid");
                                } catch (JSONException e6) {
                                    e = e6;
                                    str3 = optString;
                                    aVar = null;
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
                                    gVar.C(str3);
                                    gVar.I(str4);
                                    gVar.A(str5);
                                    gVar.L(str6);
                                    gVar.H(str7);
                                    gVar.G(r7);
                                    gVar.E(str2);
                                    gVar.D(str);
                                    gVar.y(customDialogData);
                                    gVar.N(str8);
                                    gVar.B(contriInfo);
                                    gVar.M(videoEasterEggData);
                                    gVar.z(aVar);
                                    gVar.F(iconStampData);
                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return gVar;
                                }
                                try {
                                    str8 = jSONObject.optString("video_id");
                                } catch (JSONException e7) {
                                    e = e7;
                                    str3 = optString;
                                    aVar = null;
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
                                    gVar.C(str3);
                                    gVar.I(str4);
                                    gVar.A(str5);
                                    gVar.L(str6);
                                    gVar.H(str7);
                                    gVar.G(r7);
                                    gVar.E(str2);
                                    gVar.D(str);
                                    gVar.y(customDialogData);
                                    gVar.N(str8);
                                    gVar.B(contriInfo);
                                    gVar.M(videoEasterEggData);
                                    gVar.z(aVar);
                                    gVar.F(iconStampData);
                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return gVar;
                                }
                                try {
                                    customDialogData = c.a.p0.w2.b.a(jSONObject);
                                    try {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                        r7 = optJSONObject3 != null ? optJSONObject3.optInt("is_copytwzhibo", 0) : 0;
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
                                                gVar.C(str3);
                                                gVar.I(str4);
                                                gVar.A(str5);
                                                gVar.L(str6);
                                                gVar.H(str7);
                                                gVar.G(r7);
                                                gVar.E(str2);
                                                gVar.D(str);
                                                gVar.y(customDialogData);
                                                gVar.N(str8);
                                                gVar.B(contriInfo);
                                                gVar.M(videoEasterEggData);
                                                gVar.z(aVar);
                                                gVar.F(iconStampData);
                                                c.a.p0.a4.t0.c.a("doInBackground end");
                                                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                } catch (JSONException e9) {
                                                    e = e9;
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
                                                    gVar.G(r7);
                                                    gVar.E(str2);
                                                    gVar.D(str);
                                                    gVar.y(customDialogData);
                                                    gVar.N(str8);
                                                    gVar.B(contriInfo);
                                                    gVar.M(videoEasterEggData);
                                                    gVar.z(aVar);
                                                    gVar.F(iconStampData);
                                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return gVar;
                                                }
                                            } else {
                                                videoEasterEggData = null;
                                            }
                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                            if (optJSONObject6 != null) {
                                                aVar = new c.a.o0.t.a();
                                                try {
                                                    aVar.p(optJSONObject6);
                                                } catch (JSONException e10) {
                                                    e = e10;
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
                                                    gVar.G(r7);
                                                    gVar.E(str2);
                                                    gVar.D(str);
                                                    gVar.y(customDialogData);
                                                    gVar.N(str8);
                                                    gVar.B(contriInfo);
                                                    gVar.M(videoEasterEggData);
                                                    gVar.z(aVar);
                                                    gVar.F(iconStampData);
                                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
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
                                                } catch (JSONException e11) {
                                                    jSONException = e11;
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
                                                    gVar.G(r7);
                                                    gVar.E(str2);
                                                    gVar.D(str);
                                                    gVar.y(customDialogData);
                                                    gVar.N(str8);
                                                    gVar.B(contriInfo);
                                                    gVar.M(videoEasterEggData);
                                                    gVar.z(aVar);
                                                    gVar.F(iconStampData);
                                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return gVar;
                                                }
                                            } else {
                                                str3 = optString;
                                                iconStampData = null;
                                            }
                                        } catch (JSONException e12) {
                                            e = e12;
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
                                            gVar.G(r7);
                                            gVar.E(str2);
                                            gVar.D(str);
                                            gVar.y(customDialogData);
                                            gVar.N(str8);
                                            gVar.B(contriInfo);
                                            gVar.M(videoEasterEggData);
                                            gVar.z(aVar);
                                            gVar.F(iconStampData);
                                            c.a.p0.a4.t0.c.a("doInBackground end");
                                            c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return gVar;
                                        }
                                    } catch (JSONException e13) {
                                        e = e13;
                                        str3 = optString;
                                        aVar = null;
                                        str = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e14) {
                                    e = e14;
                                    str3 = optString;
                                    aVar = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    customDialogData = null;
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
                                    gVar.G(r7);
                                    gVar.E(str2);
                                    gVar.D(str);
                                    gVar.y(customDialogData);
                                    gVar.N(str8);
                                    gVar.B(contriInfo);
                                    gVar.M(videoEasterEggData);
                                    gVar.z(aVar);
                                    gVar.F(iconStampData);
                                    c.a.p0.a4.t0.c.a("doInBackground end");
                                    c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return gVar;
                                }
                            } catch (JSONException e15) {
                                e = e15;
                                str3 = optString;
                                aVar = null;
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
                                gVar.C(str3);
                                gVar.I(str4);
                                gVar.A(str5);
                                gVar.L(str6);
                                gVar.H(str7);
                                gVar.G(r7);
                                gVar.E(str2);
                                gVar.D(str);
                                gVar.y(customDialogData);
                                gVar.N(str8);
                                gVar.B(contriInfo);
                                gVar.M(videoEasterEggData);
                                gVar.z(aVar);
                                gVar.F(iconStampData);
                                c.a.p0.a4.t0.c.a("doInBackground end");
                                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return gVar;
                            }
                        } else {
                            iconStampData = null;
                            aVar = null;
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
                    } catch (JSONException e16) {
                        jSONException = e16;
                        iconStampData = null;
                        aVar = null;
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
                        str3 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e5);
                    }
                    gVar.C(str3);
                    gVar.I(str4);
                    gVar.A(str5);
                    gVar.L(str6);
                    gVar.H(str7);
                    gVar.G(r7);
                    gVar.E(str2);
                    gVar.D(str);
                    gVar.y(customDialogData);
                    gVar.N(str8);
                    gVar.B(contriInfo);
                    gVar.M(videoEasterEggData);
                    gVar.z(aVar);
                    gVar.F(iconStampData);
                }
                c.a.p0.a4.t0.c.a("doInBackground end");
                c.a.p0.a4.t0.c.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return gVar;
            }
            return (c.a.p0.a4.t0.g) invokeL.objValue;
        }

        public final void c(c.a.p0.a4.t0.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.p0.a4.q0.f.a(gVar.f(), AuthTokenData.parse(this.f36214b), this.f36218f.q)) {
                return;
            }
            if (gVar.u()) {
                this.f36218f.f0(gVar);
            } else if (gVar.x()) {
                this.f36218f.e0(gVar);
                this.f36218f.f0(gVar);
            } else if (c.a.p0.j4.a.c(gVar.f())) {
                this.f36218f.d0(gVar);
                this.f36218f.f0(gVar);
            } else if (gVar.v()) {
                l0 l0Var = new l0();
                l0Var.e(this.f36214b);
                if (l0Var.c() == null || this.f36218f.f36203c == null) {
                    return;
                }
                this.f36218f.f36203c.setVcodeMD5(l0Var.b());
                this.f36218f.f36203c.setVcodeUrl(l0Var.c());
                NewWriteModel newWriteModel = this.f36218f;
                newWriteModel.g0(gVar, null, l0Var, newWriteModel.f36203c);
            } else if (gVar.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.f36214b);
                NewWriteModel newWriteModel2 = this.f36218f;
                newWriteModel2.g0(gVar, accessState, null, newWriteModel2.f36203c);
            } else if (gVar.w()) {
                this.f36218f.f0(gVar);
            } else {
                this.f36218f.f0(gVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f36215c = true;
                c.a.p0.a4.l0.a aVar = this.a;
                if (aVar != null) {
                    aVar.b();
                }
                if (this.f36218f.i != null) {
                    this.f36218f.i.callback(false, null, null, this.f36218f.f36203c, null);
                } else if (this.f36218f.f36208h != null) {
                    this.f36218f.f36208h.a(false, null, null, null, null);
                }
                super.cancel(true);
                this.f36218f.a = null;
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
        public void onPostExecute(c.a.p0.a4.t0.g gVar) {
            String h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
                super.onPostExecute(gVar);
                c.a.p0.a4.t0.c.a("onPostExecute start");
                c.a.p0.a4.t0.c.a("发帖： onPostExecute");
                String str = null;
                this.f36218f.a = null;
                if (gVar != null && gVar.f() != 0) {
                    c.a.o0.r.d0.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", gVar.f(), gVar.g(), "tid", gVar.p(), "pid", gVar.l());
                }
                if (!this.f36215c && gVar != null) {
                    if (!gVar.s()) {
                        int type = this.f36218f.f36203c != null ? this.f36218f.f36203c.getType() : Integer.MIN_VALUE;
                        c.a.p0.a4.t0.c.a("onPostExecute success");
                        if (this.f36218f.i == null) {
                            if (this.f36218f.f36208h != null) {
                                this.f36218f.f36208h.a(true, gVar.g(), null, null, gVar.c());
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
                            if (this.f36218f.f36203c != null) {
                                postWriteCallBackData.setProZone(this.f36218f.f36203c.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f36218f.f36203c.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(gVar.q());
                            postWriteCallBackData.setmAdverSegmentData(gVar.b());
                            postWriteCallBackData.setIconStampData(gVar.j());
                            l0 l0Var = new l0();
                            l0Var.e(this.f36214b);
                            if (this.f36218f.f36203c == null || c.a.p0.a4.t0.b.k().i() == null) {
                                if (this.f36218f.f36203c == null || !this.f36218f.o) {
                                    if (this.f36218f.f36203c != null && this.f36218f.p) {
                                        c.a.p0.a4.t0.b.k().C(this.f36218f.f36203c.getForumId());
                                        c.a.p0.a4.t0.b.k().D(this.f36218f.f36203c.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f36218f.f36203c.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f36218f.f36203c;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                c.a.p0.a4.t0.b.k().C(this.f36218f.f36203c.getForumId());
                                c.a.p0.a4.t0.b.k().D(this.f36218f.f36203c.getForumName());
                                if (this.f36218f.f36203c.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f36218f.f36203c;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, c.a.p0.a4.t0.b.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                c.a.p0.a4.t0.b.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && gVar.j() == null) {
                                if (this.f36218f.f36203c != null) {
                                    int type2 = this.f36218f.f36203c.getType();
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
                            this.f36218f.i.callback(true, postWriteCallBackData, l0Var, this.f36218f.f36203c, gVar.c());
                        }
                        if (this.f36218f.f36203c != null && !this.f36218f.f36203c.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(gVar.j() == null)));
                        }
                        c.a.p0.l2.g gVar2 = this.f36217e;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (!TbadkCoreApplication.getInst().isMainProcess(true) && (type == 1 || type == 2)) {
                                c.a.o0.j0.h.i(new ReplayEvent());
                            } else if (type == 1 || type == 2) {
                                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                                    c.a.p0.x3.b.r().A(0, 3);
                                    c.a.p0.x3.b.r().G();
                                }
                                c.a.p0.x3.b.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                        }
                    } else {
                        c.a.p0.a4.t0.c.a("onPostExecute error");
                        c(gVar);
                        c.a.p0.l2.g gVar3 = this.f36217e;
                        if (gVar3 != null) {
                            gVar3.h(gVar.a, gVar.g());
                        }
                    }
                    c.a.p0.a4.t0.c.a("发帖： onPostExecute 完全结束");
                    return;
                }
                c.a.p0.a4.t0.c.a("发帖： onPostExecute isCanceled");
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f36202b = null;
        this.f36203c = null;
        this.f36204d = null;
        this.f36205e = null;
        this.f36206f = null;
        this.f36208h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = baseFragmentActivity.getPageContext();
    }

    public void X() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f36202b) == null || dVar.isCancelled()) {
            return;
        }
        this.f36202b.cancel();
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.f36203c;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.f36203c.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            if (c.a.p0.a4.t0.b.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, b0());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, c.a.p0.a4.t0.b.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.a = new h(this);
            c.a.p0.a4.t0.c.a("dealPost()");
            c.a.p0.a4.t0.a.l(this.f36203c);
            this.a.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult a0(String str, c.a.p0.a4.l0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(c.a.o0.c0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return aVar.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36203c : (WriteData) invokeV.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpanGroupManager spanGroupManager = this.m;
            if (spanGroupManager != null) {
                this.n = spanGroupManager.E();
            } else {
                this.n = null;
            }
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h hVar = this.a;
            if (hVar != null && !hVar.isCancelled()) {
                this.a.cancel();
                return;
            }
            g gVar = this.i;
            if (gVar != null) {
                gVar.callback(false, null, null, this.f36203c, null);
                return;
            }
            f fVar = this.f36208h;
            if (fVar != null) {
                fVar.a(false, null, null, null, null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h hVar = this.a;
            if (hVar == null || hVar.isCancelled()) {
                return false;
            }
            this.a.cancel();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d0(c.a.p0.a4.t0.g gVar) {
        c.a.d.a.f<?> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) || (fVar = this.k) == null || gVar == null || (this.i instanceof c.a.p0.a4.t0.b)) {
            return;
        }
        c.a.p0.j4.a.d(fVar.getPageActivity(), gVar.g());
        gVar.C(null);
    }

    public final void e0(c.a.p0.a4.t0.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || this.k == null || gVar == null || gVar.c() == null || gVar.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.k.getPageActivity(), gVar.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void f0(c.a.p0.a4.t0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            g0(gVar, null, null, this.f36203c);
        }
    }

    public final void g0(c.a.p0.a4.t0.g gVar, AccessState accessState, l0 l0Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, gVar, accessState, l0Var, writeData) == null) || gVar == null) {
            return;
        }
        if (this.i != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.f(), gVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(gVar.o());
            postWriteCallBackData.setReplyPrivacyTip(gVar.n());
            this.i.callback(false, postWriteCallBackData, l0Var, writeData, gVar.c());
            return;
        }
        f fVar = this.f36208h;
        if (fVar != null) {
            fVar.a(false, gVar.g(), l0Var, writeData, gVar.c());
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.j = z;
        }
    }

    public void j0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f36207g = eVar;
        }
    }

    public void k0(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bArr, str) == null) {
            this.f36206f = bArr;
            this.f36205e = str;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.o = z;
        }
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

    public void m0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.f36208h = fVar;
        }
    }

    public void n0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.i = gVar;
        }
    }

    public void o0(@Nullable c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            if (fVar != null) {
                this.k = fVar;
                this.unique_id = fVar.getUniqueId();
                return;
            }
            this.k = null;
            this.unique_id = null;
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f36203c == null) {
                return false;
            }
            c.a.p0.a4.t0.c.a("发帖：开始上传");
            this.f36203c.startPublish();
            PublishProgressData.valueOf(this.f36203c, 0).send(true);
            Z();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.f36202b == null) {
            d dVar = new d(this);
            this.f36202b = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.f36203c == null) {
                return false;
            }
            if (l.z() && !l.H() && this.f36203c.getWriteImagesInfo() != null && this.f36203c.getWriteImagesInfo().size() != 0 && this.f36203c.getWriteImagesInfo().isOriginalImg() && !c.a.o0.r.j0.b.k().h("original_img_up_tip", false)) {
                c.a.o0.r.j0.b.k().u("original_img_up_tip", true);
                c.a.d.a.f<?> fVar = this.k;
                if (fVar == null) {
                    Z();
                    return true;
                }
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(fVar.getPageActivity());
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0ce6);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new a(this, aVar));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this, aVar));
                aVar.create(this.k);
                aVar.show();
            } else {
                Z();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, spanGroupManager) == null) {
            this.m = spanGroupManager;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, writeData) == null) {
            this.f36203c = writeData;
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f36202b = null;
        this.f36203c = null;
        this.f36204d = null;
        this.f36205e = null;
        this.f36206f = null;
        this.f36208h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = baseActivity.getPageContext();
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f36202b = null;
        this.f36203c = null;
        this.f36204d = null;
        this.f36205e = null;
        this.f36206f = null;
        this.f36208h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = tbPageContext;
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
        this.f36202b = null;
        this.f36203c = null;
        this.f36204d = null;
        this.f36205e = null;
        this.f36206f = null;
        this.f36208h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = null;
    }
}
