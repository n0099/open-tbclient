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
import com.repackage.as8;
import com.repackage.b9;
import com.repackage.cr4;
import com.repackage.cr7;
import com.repackage.dm7;
import com.repackage.dn8;
import com.repackage.gl8;
import com.repackage.gt7;
import com.repackage.hm8;
import com.repackage.hz4;
import com.repackage.i35;
import com.repackage.jq4;
import com.repackage.kt4;
import com.repackage.mi;
import com.repackage.ni;
import com.repackage.ni8;
import com.repackage.o55;
import com.repackage.pg;
import com.repackage.qx4;
import com.repackage.u35;
import com.repackage.vt4;
import com.repackage.xm8;
import com.repackage.ym8;
import com.repackage.zl7;
import com.repackage.zm8;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;
    public d b;
    public WriteData c;
    public String d;
    public String e;
    public byte[] f;
    public e g;
    public f h;
    public g i;
    public boolean j;
    public b9<?> k;
    public gl8.c l;
    public SpanGroupManager m;
    public String n;
    public boolean o;
    public boolean p;
    public hm8.c q;

    /* loaded from: classes4.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, cr4Var};
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
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
                this.b.Z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, cr4Var};
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
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends hm8.c {
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

        @Override // com.repackage.hm8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.c == null || TextUtils.isEmpty(str)) {
                    if (this.a.i != null) {
                        this.a.i.callback(false, null, null, this.a.c, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.c.setAuthSid(str);
                this.a.r0();
            }
        }

        @Override // com.repackage.hm8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.c == null || TextUtils.isEmpty(str)) {
                    if (this.a.i != null) {
                        this.a.i.callback(false, null, null, this.a.c, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.c.setAuthSid(str);
                this.a.r0();
            }
        }

        @Override // com.repackage.hm8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.c != null) {
                    this.a.c.setAuthSid(null);
                }
                if (this.a.i != null) {
                    this.a.i.callback(false, null, null, this.a.c, null);
                }
            }
        }

        @Override // com.repackage.hm8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.c != null) {
                    this.a.a = null;
                    this.a.c.setAuthSid(null);
                    this.a.r0();
                } else if (this.a.i != null) {
                    this.a.i.callback(false, null, null, this.a.c, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Void, Void, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public gl8 b;
        public Bitmap c;
        public final /* synthetic */ NewWriteModel d;

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
            this.d = newWriteModel;
            this.a = false;
            this.b = new gl8();
            this.c = null;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                boolean isLocalImagePath = FileHelper.isLocalImagePath(this.d.e);
                if (this.a) {
                    return null;
                }
                if (this.d.f == null || this.d.f.length <= 0) {
                    if (TextUtils.isEmpty(this.d.e) || !isLocalImagePath) {
                        return null;
                    }
                    this.d.d = FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.d.e));
                    if (TextUtils.isEmpty(this.d.d)) {
                        return null;
                    }
                    NewWriteModel newWriteModel = this.d;
                    return newWriteModel.a0(newWriteModel.d, this.b);
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.d.f);
                this.c = Bytes2Bitmap;
                if (Bytes2Bitmap == null) {
                    return null;
                }
                this.d.d = FileHelper.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, Bytes2Bitmap, 85);
                if (TextUtils.isEmpty(this.d.d)) {
                    Bitmap bitmap = this.c;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.c.recycle();
                    }
                    return null;
                }
                NewWriteModel newWriteModel2 = this.d;
                return newWriteModel2.a0(newWriteModel2.d, this.b);
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
                if (this.d.g != null) {
                    this.d.g.a(imageUploadResult, false);
                }
                Bitmap bitmap = this.c;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.c.recycle();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                gl8 gl8Var = this.b;
                if (gl8Var != null) {
                    gl8Var.b();
                }
                if (this.d.g != null) {
                    this.d.g.a(null, true);
                }
                Bitmap bitmap = this.c;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.c.recycle();
                }
                super.cancel();
                this.d.b = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(boolean z, String str, qx4 qx4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes4.dex */
    public class h extends BdAsyncTask<Integer, Integer, dn8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gl8 a;
        public String b;
        public boolean c;
        public dm7 d;
        public zl7 e;
        public final /* synthetic */ NewWriteModel f;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ h b;

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
                this.b = hVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gt7.a((TbPageContext) this.b.f.k, this.a).show();
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
            this.f = newWriteModel;
            this.a = null;
            this.b = null;
            this.c = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, dm7.class);
            if (runTask != null) {
                this.d = (dm7) runTask.getData();
            }
            dm7 dm7Var = this.d;
            if (dm7Var != null) {
                this.e = dm7Var.get();
            }
            setPriority(3);
            zm8.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:139:0x030c  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public dn8 doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            dn8 dn8Var;
            JSONArray jSONArray;
            JSONException jSONException;
            IconStampData iconStampData;
            hz4 hz4Var;
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
                i35.c(this.f.c.getContent());
                zm8.a("doInBackground() start");
                zm8.a("发帖：任务后台执行 开始 doInBackground");
                gl8 gl8Var = new gl8();
                this.a = gl8Var;
                gl8Var.j(this.f.m);
                this.a.k(this.f.n);
                this.a.l(this.e);
                this.a.i(this.f.l);
                this.b = this.a.h(this.f.c, this.f.j);
                zm8.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData d = this.a.d();
                xm8.c(this.f.c, d);
                if (this.a.e() && this.b != null) {
                    zm8.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData c = this.a.c();
                    String error_msg = d.getError_msg();
                    if (ni.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10ec);
                    }
                    dn8Var = new dn8(d.getError_code(), error_msg, c);
                    if (this.f.c != null && this.f.c.isHasImages() && !dn8Var.s()) {
                        this.f.c.deleteUploadedTempImages();
                    }
                    zm8.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (d != null && d.error_code == 220015) {
                    dn8Var = new dn8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                dn8Var.K(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    zm8.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (d != null && d.error_code == 238010) {
                    dn8Var = new dn8(d.getError_code(), d.getError_msg(), null);
                    if (this.b != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.b).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                jq4 jq4Var = new jq4();
                                jq4Var.a = optJSONObject2.optString("block_content");
                                jq4Var.b = optJSONObject2.optString("block_cancel");
                                jq4Var.c = optJSONObject2.optString("block_confirm");
                                dn8Var.J(jq4Var);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    zm8.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (d != null && d.error_code != 0) {
                    String error_msg2 = d.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (d.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0278);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f10e1);
                        }
                    }
                    dn8Var = new dn8(d.getError_code(), error_msg2, this.a.c());
                    zm8.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    dn8Var = new dn8(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c17), null);
                    zm8.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!dn8Var.s()) {
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
                                hz4Var = null;
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
                                hz4Var = null;
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
                                dn8Var.C(str3);
                                dn8Var.I(str4);
                                dn8Var.A(str5);
                                dn8Var.L(str6);
                                dn8Var.H(str7);
                                dn8Var.G(r7);
                                dn8Var.E(str2);
                                dn8Var.D(str);
                                dn8Var.y(customDialogData);
                                dn8Var.N(str8);
                                dn8Var.B(contriInfo);
                                dn8Var.M(videoEasterEggData);
                                dn8Var.z(hz4Var);
                                dn8Var.F(iconStampData);
                                zm8.a("doInBackground end");
                                zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return dn8Var;
                            }
                            try {
                                str6 = jSONObject.optString("tid");
                                try {
                                    str7 = jSONObject.optString("pid");
                                } catch (JSONException e5) {
                                    e = e5;
                                    str3 = optString;
                                    hz4Var = null;
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
                                    dn8Var.C(str3);
                                    dn8Var.I(str4);
                                    dn8Var.A(str5);
                                    dn8Var.L(str6);
                                    dn8Var.H(str7);
                                    dn8Var.G(r7);
                                    dn8Var.E(str2);
                                    dn8Var.D(str);
                                    dn8Var.y(customDialogData);
                                    dn8Var.N(str8);
                                    dn8Var.B(contriInfo);
                                    dn8Var.M(videoEasterEggData);
                                    dn8Var.z(hz4Var);
                                    dn8Var.F(iconStampData);
                                    zm8.a("doInBackground end");
                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return dn8Var;
                                }
                                try {
                                    str8 = jSONObject.optString("video_id");
                                } catch (JSONException e6) {
                                    e = e6;
                                    str3 = optString;
                                    hz4Var = null;
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
                                    dn8Var.C(str3);
                                    dn8Var.I(str4);
                                    dn8Var.A(str5);
                                    dn8Var.L(str6);
                                    dn8Var.H(str7);
                                    dn8Var.G(r7);
                                    dn8Var.E(str2);
                                    dn8Var.D(str);
                                    dn8Var.y(customDialogData);
                                    dn8Var.N(str8);
                                    dn8Var.B(contriInfo);
                                    dn8Var.M(videoEasterEggData);
                                    dn8Var.z(hz4Var);
                                    dn8Var.F(iconStampData);
                                    zm8.a("doInBackground end");
                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return dn8Var;
                                }
                                try {
                                    customDialogData = cr7.a(jSONObject);
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
                                                hz4Var = null;
                                                str = null;
                                                videoEasterEggData = null;
                                                jSONException = e;
                                                iconStampData = null;
                                                jSONException.printStackTrace();
                                                if (StringUtils.isNull(str3)) {
                                                }
                                                dn8Var.C(str3);
                                                dn8Var.I(str4);
                                                dn8Var.A(str5);
                                                dn8Var.L(str6);
                                                dn8Var.H(str7);
                                                dn8Var.G(r7);
                                                dn8Var.E(str2);
                                                dn8Var.D(str);
                                                dn8Var.y(customDialogData);
                                                dn8Var.N(str8);
                                                dn8Var.B(contriInfo);
                                                dn8Var.M(videoEasterEggData);
                                                dn8Var.z(hz4Var);
                                                dn8Var.F(iconStampData);
                                                zm8.a("doInBackground end");
                                                zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                return dn8Var;
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
                                                    hz4Var = null;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    dn8Var.C(str3);
                                                    dn8Var.I(str4);
                                                    dn8Var.A(str5);
                                                    dn8Var.L(str6);
                                                    dn8Var.H(str7);
                                                    dn8Var.G(r7);
                                                    dn8Var.E(str2);
                                                    dn8Var.D(str);
                                                    dn8Var.y(customDialogData);
                                                    dn8Var.N(str8);
                                                    dn8Var.B(contriInfo);
                                                    dn8Var.M(videoEasterEggData);
                                                    dn8Var.z(hz4Var);
                                                    dn8Var.F(iconStampData);
                                                    zm8.a("doInBackground end");
                                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return dn8Var;
                                                }
                                            } else {
                                                videoEasterEggData = null;
                                            }
                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("advertisement");
                                            if (optJSONObject6 != null) {
                                                hz4Var = new hz4();
                                                try {
                                                    hz4Var.p(optJSONObject6);
                                                } catch (JSONException e9) {
                                                    e = e9;
                                                    str3 = optString;
                                                    jSONException = e;
                                                    iconStampData = null;
                                                    jSONException.printStackTrace();
                                                    if (StringUtils.isNull(str3)) {
                                                    }
                                                    dn8Var.C(str3);
                                                    dn8Var.I(str4);
                                                    dn8Var.A(str5);
                                                    dn8Var.L(str6);
                                                    dn8Var.H(str7);
                                                    dn8Var.G(r7);
                                                    dn8Var.E(str2);
                                                    dn8Var.D(str);
                                                    dn8Var.y(customDialogData);
                                                    dn8Var.N(str8);
                                                    dn8Var.B(contriInfo);
                                                    dn8Var.M(videoEasterEggData);
                                                    dn8Var.z(hz4Var);
                                                    dn8Var.F(iconStampData);
                                                    zm8.a("doInBackground end");
                                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return dn8Var;
                                                }
                                            } else {
                                                hz4Var = null;
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
                                                    dn8Var.C(str3);
                                                    dn8Var.I(str4);
                                                    dn8Var.A(str5);
                                                    dn8Var.L(str6);
                                                    dn8Var.H(str7);
                                                    dn8Var.G(r7);
                                                    dn8Var.E(str2);
                                                    dn8Var.D(str);
                                                    dn8Var.y(customDialogData);
                                                    dn8Var.N(str8);
                                                    dn8Var.B(contriInfo);
                                                    dn8Var.M(videoEasterEggData);
                                                    dn8Var.z(hz4Var);
                                                    dn8Var.F(iconStampData);
                                                    zm8.a("doInBackground end");
                                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                                    return dn8Var;
                                                }
                                            } else {
                                                str3 = optString;
                                                iconStampData = null;
                                            }
                                        } catch (JSONException e11) {
                                            e = e11;
                                            str3 = optString;
                                            hz4Var = null;
                                            videoEasterEggData = null;
                                            jSONException = e;
                                            iconStampData = null;
                                            jSONException.printStackTrace();
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            dn8Var.C(str3);
                                            dn8Var.I(str4);
                                            dn8Var.A(str5);
                                            dn8Var.L(str6);
                                            dn8Var.H(str7);
                                            dn8Var.G(r7);
                                            dn8Var.E(str2);
                                            dn8Var.D(str);
                                            dn8Var.y(customDialogData);
                                            dn8Var.N(str8);
                                            dn8Var.B(contriInfo);
                                            dn8Var.M(videoEasterEggData);
                                            dn8Var.z(hz4Var);
                                            dn8Var.F(iconStampData);
                                            zm8.a("doInBackground end");
                                            zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                            return dn8Var;
                                        }
                                    } catch (JSONException e12) {
                                        e = e12;
                                        str3 = optString;
                                        hz4Var = null;
                                        str = null;
                                        str2 = null;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
                                    str3 = optString;
                                    hz4Var = null;
                                    str = null;
                                    str2 = null;
                                    videoEasterEggData = null;
                                    customDialogData = null;
                                    jSONException = e;
                                    iconStampData = null;
                                    jSONException.printStackTrace();
                                    if (StringUtils.isNull(str3)) {
                                    }
                                    dn8Var.C(str3);
                                    dn8Var.I(str4);
                                    dn8Var.A(str5);
                                    dn8Var.L(str6);
                                    dn8Var.H(str7);
                                    dn8Var.G(r7);
                                    dn8Var.E(str2);
                                    dn8Var.D(str);
                                    dn8Var.y(customDialogData);
                                    dn8Var.N(str8);
                                    dn8Var.B(contriInfo);
                                    dn8Var.M(videoEasterEggData);
                                    dn8Var.z(hz4Var);
                                    dn8Var.F(iconStampData);
                                    zm8.a("doInBackground end");
                                    zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                    return dn8Var;
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                str3 = optString;
                                hz4Var = null;
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
                                dn8Var.C(str3);
                                dn8Var.I(str4);
                                dn8Var.A(str5);
                                dn8Var.L(str6);
                                dn8Var.H(str7);
                                dn8Var.G(r7);
                                dn8Var.E(str2);
                                dn8Var.D(str);
                                dn8Var.y(customDialogData);
                                dn8Var.N(str8);
                                dn8Var.B(contriInfo);
                                dn8Var.M(videoEasterEggData);
                                dn8Var.z(hz4Var);
                                dn8Var.F(iconStampData);
                                zm8.a("doInBackground end");
                                zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return dn8Var;
                            }
                        } else {
                            iconStampData = null;
                            hz4Var = null;
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
                        hz4Var = null;
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
                        str3 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10ec);
                    }
                    dn8Var.C(str3);
                    dn8Var.I(str4);
                    dn8Var.A(str5);
                    dn8Var.L(str6);
                    dn8Var.H(str7);
                    dn8Var.G(r7);
                    dn8Var.E(str2);
                    dn8Var.D(str);
                    dn8Var.y(customDialogData);
                    dn8Var.N(str8);
                    dn8Var.B(contriInfo);
                    dn8Var.M(videoEasterEggData);
                    dn8Var.z(hz4Var);
                    dn8Var.F(iconStampData);
                }
                zm8.a("doInBackground end");
                zm8.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                return dn8Var;
            }
            return (dn8) invokeL.objValue;
        }

        public final void c(dn8 dn8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dn8Var) == null) || hm8.a(dn8Var.f(), AuthTokenData.parse(this.b), this.f.q)) {
                return;
            }
            if (dn8Var.u()) {
                this.f.f0(dn8Var);
            } else if (dn8Var.x()) {
                this.f.e0(dn8Var);
                this.f.f0(dn8Var);
            } else if (as8.c(dn8Var.f())) {
                this.f.d0(dn8Var);
                this.f.f0(dn8Var);
            } else if (dn8Var.v()) {
                qx4 qx4Var = new qx4();
                qx4Var.e(this.b);
                if (qx4Var.c() == null || this.f.c == null) {
                    return;
                }
                this.f.c.setVcodeMD5(qx4Var.b());
                this.f.c.setVcodeUrl(qx4Var.c());
                NewWriteModel newWriteModel = this.f;
                newWriteModel.g0(dn8Var, null, qx4Var, newWriteModel.c);
            } else if (dn8Var.t()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.b);
                NewWriteModel newWriteModel2 = this.f;
                newWriteModel2.g0(dn8Var, accessState, null, newWriteModel2.c);
            } else if (dn8Var.w()) {
                this.f.f0(dn8Var);
            } else {
                this.f.f0(dn8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                gl8 gl8Var = this.a;
                if (gl8Var != null) {
                    gl8Var.b();
                }
                if (this.f.i != null) {
                    this.f.i.callback(false, null, null, this.f.c, null);
                } else if (this.f.h != null) {
                    this.f.h.a(false, null, null, null, null);
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
        public void onPostExecute(dn8 dn8Var) {
            String h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dn8Var) == null) {
                super.onPostExecute(dn8Var);
                zm8.a("onPostExecute start");
                zm8.a("发帖： onPostExecute");
                String str = null;
                this.f.a = null;
                if (dn8Var != null && dn8Var.f() != 0) {
                    kt4.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", dn8Var.f(), dn8Var.g(), "tid", dn8Var.p(), "pid", dn8Var.l());
                }
                if (!this.c && dn8Var != null) {
                    if (!dn8Var.s()) {
                        int type = this.f.c != null ? this.f.c.getType() : Integer.MIN_VALUE;
                        zm8.a("onPostExecute success");
                        if (this.f.i == null) {
                            if (this.f.h != null) {
                                this.f.h.a(true, dn8Var.g(), null, null, dn8Var.c());
                            }
                        } else {
                            if (!StringUtils.isNull(dn8Var.m()) && !StringUtils.isNull(dn8Var.d())) {
                                str = dn8Var.m();
                                h = dn8Var.d();
                            } else if (StringUtils.isNull(dn8Var.h()) && StringUtils.isNull(dn8Var.i())) {
                                h = null;
                            } else {
                                str = dn8Var.i();
                                h = dn8Var.h();
                            }
                            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dn8Var.f(), dn8Var.g(), str, h);
                            postWriteCallBackData.setThreadId(dn8Var.p());
                            postWriteCallBackData.setPostId(dn8Var.l());
                            postWriteCallBackData.setIsCopyTWZhibo(dn8Var.k());
                            postWriteCallBackData.setErrorString(dn8Var.g());
                            postWriteCallBackData.setActivityDialog(dn8Var.a());
                            postWriteCallBackData.setVideoid(dn8Var.r());
                            postWriteCallBackData.setContriInfo(dn8Var.e());
                            if (this.f.c != null) {
                                postWriteCallBackData.setProZone(this.f.c.getProZone());
                                postWriteCallBackData.setGeneralTabId(this.f.c.getTabId());
                            }
                            postWriteCallBackData.setVideoEasterEggData(dn8Var.q());
                            postWriteCallBackData.setmAdverSegmentData(dn8Var.b());
                            postWriteCallBackData.setIconStampData(dn8Var.j());
                            qx4 qx4Var = new qx4();
                            qx4Var.e(this.b);
                            if (this.f.c == null || ym8.k().i() == null) {
                                if (this.f.c == null || !this.f.o) {
                                    if (this.f.c != null && this.f.p) {
                                        ym8.k().C(this.f.c.getForumId());
                                        ym8.k().D(this.f.c.getForumName());
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                    }
                                } else {
                                    if (this.f.c.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.f.c;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                }
                            } else {
                                ym8.k().C(this.f.c.getForumId());
                                ym8.k().D(this.f.c.getForumName());
                                if (this.f.c.getVideoInfo() != null) {
                                    postWriteCallBackData.writeDataForVideo = this.f.c;
                                }
                                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, ym8.k().i()));
                                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                ym8.k().z(false);
                            }
                            CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null && dn8Var.j() == null) {
                                if (this.f.c != null) {
                                    int type2 = this.f.c.getType();
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
                                pg.a().postDelayed(new a(this, activityDialog), 1000L);
                            }
                            this.f.i.callback(true, postWriteCallBackData, qx4Var, this.f.c, dn8Var.c());
                        }
                        if (this.f.c != null && !this.f.c.isWork()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(dn8Var.j() == null)));
                        }
                        zl7 zl7Var = this.e;
                        if (zl7Var != null) {
                            zl7Var.c();
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (!TbadkCoreApplication.getInst().isMainProcess(true) && (type == 1 || type == 2)) {
                                o55.i(new ReplayEvent());
                            } else if (type == 1 || type == 2) {
                                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                                    ni8.r().A(0, 3);
                                    ni8.r().G();
                                }
                                ni8.r().z(StampMission.Type.REPLAY_THREAD);
                            }
                        }
                    } else {
                        zm8.a("onPostExecute error");
                        c(dn8Var);
                        zl7 zl7Var2 = this.e;
                        if (zl7Var2 != null) {
                            zl7Var2.h(dn8Var.a, dn8Var.g());
                        }
                    }
                    zm8.a("发帖： onPostExecute 完全结束");
                    return;
                }
                zm8.a("发帖： onPostExecute isCanceled");
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
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = baseFragmentActivity.getPageContext();
    }

    public void X() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.b) == null || dVar.isCancelled()) {
            return;
        }
        this.b.cancel();
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.c;
            if (writeData == null) {
                return true;
            }
            return (writeData.getWriteImagesInfo() != null ? this.c.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
        }
        return invokeV.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            if (ym8.k().i() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, b0());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, ym8.k().i()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.a = new h(this);
            zm8.a("dealPost()");
            xm8.l(this.c);
            this.a.execute(new Integer[0]);
        }
    }

    public final ImageUploadResult a0(String str, gl8 gl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, gl8Var)) == null) {
            if (gl8Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.clearAllActions();
            imageFileInfo.addPersistAction(u35.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
            return gl8Var.g(imageFileInfo, true);
        }
        return (ImageUploadResult) invokeLL.objValue;
    }

    public WriteData b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (WriteData) invokeV.objValue;
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
                gVar.callback(false, null, null, this.c, null);
                return;
            }
            f fVar = this.h;
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

    public final void d0(dn8 dn8Var) {
        b9<?> b9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dn8Var) == null) || (b9Var = this.k) == null || dn8Var == null || (this.i instanceof ym8)) {
            return;
        }
        as8.d(b9Var.getPageActivity(), dn8Var.g());
        dn8Var.C(null);
    }

    public final void e0(dn8 dn8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dn8Var) == null) || this.k == null || dn8Var == null || dn8Var.c() == null || dn8Var.c().mFrsForbidenDialogInfo == null) {
            return;
        }
        AntiHelper.p(this.k.getPageActivity(), dn8Var.c().mFrsForbidenDialogInfo.ahead_url);
    }

    public final void f0(dn8 dn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dn8Var) == null) {
            g0(dn8Var, null, null, this.c);
        }
    }

    public final void g0(dn8 dn8Var, AccessState accessState, qx4 qx4Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, dn8Var, accessState, qx4Var, writeData) == null) || dn8Var == null) {
            return;
        }
        if (this.i != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dn8Var.f(), dn8Var.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(dn8Var.o());
            postWriteCallBackData.setReplyPrivacyTip(dn8Var.n());
            this.i.callback(false, postWriteCallBackData, qx4Var, writeData, dn8Var.c());
            return;
        }
        f fVar = this.h;
        if (fVar != null) {
            fVar.a(false, dn8Var.g(), qx4Var, writeData, dn8Var.c());
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
            this.g = eVar;
        }
    }

    public void k0(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bArr, str) == null) {
            this.f = bArr;
            this.e = str;
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
            this.h = fVar;
        }
    }

    public void n0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.i = gVar;
        }
    }

    public void o0(@Nullable b9<?> b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, b9Var) == null) {
            if (b9Var != null) {
                this.k = b9Var;
                this.unique_id = b9Var.getUniqueId();
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
            if (this.c == null) {
                return false;
            }
            zm8.a("发帖：开始上传");
            this.c.startPublish();
            PublishProgressData.valueOf(this.c, 0).send(true);
            Z();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.b == null) {
            d dVar = new d(this);
            this.b = dVar;
            dVar.execute(new Void[0]);
        }
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.c == null) {
                return false;
            }
            if (mi.z() && !mi.H() && this.c.getWriteImagesInfo() != null && this.c.getWriteImagesInfo().size() != 0 && this.c.getWriteImagesInfo().isOriginalImg() && !vt4.k().h("original_img_up_tip", false)) {
                vt4.k().u("original_img_up_tip", true);
                b9<?> b9Var = this.k;
                if (b9Var == null) {
                    Z();
                    return true;
                }
                cr4 cr4Var = new cr4(b9Var.getPageActivity());
                cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0ce8);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f025d, new a(this, cr4Var));
                cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this, cr4Var));
                cr4Var.create(this.k);
                cr4Var.show();
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
            this.c = writeData;
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
        this.e = null;
        this.f = null;
        this.h = null;
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
        this.e = null;
        this.f = null;
        this.h = null;
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.q = new c(this);
        this.k = null;
    }
}
