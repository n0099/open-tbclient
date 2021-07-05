package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.g.d;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTDelegateActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Intent f29003a;

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f29004b;

    /* renamed from: c  reason: collision with root package name */
    public TTAdDislike f29005c;

    /* renamed from: d  reason: collision with root package name */
    public f f29006d;

    /* renamed from: e  reason: collision with root package name */
    public e f29007e;

    /* renamed from: f  reason: collision with root package name */
    public b f29008f;

    /* renamed from: g  reason: collision with root package name */
    public c f29009g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f29010h;

    /* loaded from: classes6.dex */
    public static class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.bytedance.sdk.openadsdk.downloadnew.a.g.a();
                j.j(o.a());
            }
        }
    }

    public TTDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            try {
                if (this.f29009g != null) {
                    this.f29009g.dismiss();
                }
                c cVar = new c(this, str);
                this.f29009g = cVar;
                cVar.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f29021a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29021a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            this.f29021a.finish();
                        }
                    }
                });
                this.f29009g.show();
            } catch (Throwable unused) {
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
            if (str != null && this.f29005c == null) {
                try {
                    m a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(str));
                    if (a2 != null) {
                        com.bytedance.sdk.openadsdk.dislike.ui.a aVar = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, a2.aG(), false);
                        this.f29005c = aVar;
                        aVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.16
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ TTDelegateActivity f29025a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f29025a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onCancel() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f29025a.finish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onSelected(int i2, String str2, boolean z) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str2, Boolean.valueOf(z)}) == null) {
                                    this.f29025a.finish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onShow() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                }
                            }
                        });
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            TTAdDislike tTAdDislike = this.f29005c;
            if (tTAdDislike != null) {
                tTAdDislike.showDislikeDialog();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            a();
            this.f29003a = getIntent();
            if (o.a() == null) {
                o.a(this);
            }
            com.bytedance.sdk.component.e.e.b().execute(new g(this, "onDelegateActivityOnCreate") { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f29039a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29039a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.k.a.a().a(this.f29039a);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f29004b != null && this.f29004b.isShowing()) {
                    this.f29004b.dismiss();
                }
                if (this.f29007e != null && this.f29007e.isShowing()) {
                    this.f29007e.dismiss();
                }
                if (this.f29008f != null && this.f29008f.isShowing()) {
                    this.f29008f.dismiss();
                }
                if (this.f29009g != null && this.f29009g.isShowing()) {
                    this.f29009g.dismiss();
                }
                if (this.f29010h != null && this.f29010h.isShowing()) {
                    this.f29010h.dismiss();
                }
            } catch (Throwable unused) {
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            if (o.a() == null) {
                o.a(this);
            }
            try {
                setIntent(intent);
                this.f29003a = intent;
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) {
            d.a().a(this, strArr, iArr);
            com.bytedance.sdk.component.e.e.a(new a("onRequestPermissionsResult"), 1);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (getIntent() != null) {
                b();
            }
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, str) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 9);
            intent.putExtra("dialog_app_manage_model", str);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    public static void a(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, strArr) == null) {
            Intent intent = new Intent(o.a(), TTDelegateActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("type", 4);
            intent.putExtra("permission_id_key", str);
            intent.putExtra("permission_content_key", strArr);
            if (o.a() != null) {
                com.bytedance.sdk.component.utils.b.a(o.a(), intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.utils.b.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.utils.b.a
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                            com.bytedance.sdk.component.utils.j.b("requestPermission->startActivity error :" + th.toString());
                        }
                    }
                });
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    TTCustomController f2 = h.d().f();
                    boolean isCanUsePhoneState = f2.isCanUsePhoneState();
                    boolean isCanUseWriteExternal = f2.isCanUseWriteExternal();
                    ArrayList arrayList = new ArrayList();
                    com.bytedance.sdk.openadsdk.n.a.a(f2, arrayList);
                    if (isCanUsePhoneState) {
                        arrayList.add("android.permission.READ_PHONE_STATE");
                    }
                    if (isCanUseWriteExternal) {
                        arrayList.add(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.g.e(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f29038a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f29038a = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.g.e
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.bytedance.sdk.component.e.e.a(new a("checkNecessaryPermission"), 1);
                                this.f29038a.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.g.e
                        public void a(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                "android.permission.READ_PHONE_STATE".equals(str);
                                com.bytedance.sdk.component.e.e.a(new a("checkNecessaryPermission"), 1);
                                this.f29038a.finish();
                            }
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            com.bytedance.sdk.component.utils.j.b(TTAdConstant.TAG, "已经有Read phone state权限");
            finish();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            try {
                if (this.f29003a == null) {
                    return;
                }
                int intExtra = this.f29003a.getIntExtra("type", 0);
                String stringExtra = this.f29003a.getStringExtra("app_download_url");
                this.f29003a.getStringExtra("app_name");
                switch (intExtra) {
                    case 1:
                        return;
                    case 2:
                        c();
                        return;
                    case 3:
                        a(stringExtra, this.f29003a.getStringExtra("dialog_title_key"), this.f29003a.getStringExtra("dialog_content_key"));
                        return;
                    case 4:
                        b(this.f29003a.getStringExtra("permission_id_key"), this.f29003a.getStringArrayExtra("permission_content_key"));
                        return;
                    case 5:
                        a(stringExtra, this.f29003a.getStringExtra("dialog_title_key"), this.f29003a.getStringExtra("dialog_content_key"), this.f29003a.getStringExtra("dialog_btn_yes_key"), this.f29003a.getStringExtra("dialog_btn_no_key"));
                        return;
                    case 6:
                        d(this.f29003a.getStringExtra("materialmeta"));
                        return;
                    case 7:
                        if (this.f29003a != null) {
                            a(this.f29003a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f29003a.getStringExtra("dialog_title_key"), this.f29003a.getStringExtra("dialog_app_manage_model_icon_url"), this.f29003a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                            return;
                        }
                        return;
                    case 8:
                        a(this.f29003a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f29003a.getStringExtra("dialog_title_key"), this.f29003a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        return;
                    case 9:
                        c(this.f29003a.getStringExtra("dialog_app_manage_model"));
                        return;
                    case 10:
                        a(this.f29003a.getStringExtra("dialog_content_key"));
                        return;
                    default:
                        finish();
                        return;
                }
            } catch (Exception unused) {
                finish();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2, str3) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 3);
            intent.putExtra("app_download_url", str);
            intent.putExtra("dialog_title_key", str2);
            intent.putExtra("dialog_content_key", str3);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 7);
            intent.putExtra("app_download_url", str);
            intent.putExtra("dialog_title_key", str3);
            intent.putExtra("dialog_app_manage_model", str2);
            intent.putExtra("dialog_app_manage_model_icon_url", str4);
            intent.putExtra("dialog_app_detail_is_download_type", z);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, str2, str3, Boolean.valueOf(z)}) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 8);
            intent.putExtra("app_download_url", str);
            intent.putExtra("dialog_title_key", str3);
            intent.putExtra("dialog_app_detail_is_download_type", z);
            intent.putExtra("dialog_app_manage_model", str2);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, context, str) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("type", 10);
            intent.putExtra("dialog_content_key", str);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, str) == null) {
            try {
                if (this.f29009g != null) {
                    this.f29009g.dismiss();
                }
                c cVar = new c(this, str);
                this.f29009g = cVar;
                cVar.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f29020a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29020a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) || this.f29020a.f29009g == null) {
                            return;
                        }
                        this.f29020a.f29009g.dismiss();
                    }
                });
                this.f29009g.show();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, str2, str3, str4, str5}) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 5);
            intent.putExtra("app_download_url", str);
            intent.putExtra("dialog_title_key", str2);
            intent.putExtra("dialog_content_key", str3);
            intent.putExtra("dialog_btn_yes_key", str4);
            intent.putExtra("dialog_btn_no_key", str5);
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            try {
                if (this.f29008f != null) {
                    this.f29008f.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
                this.f29008f = bVar;
                bVar.a(str3).a(new b.a(this, str2, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f29022a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f29023b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f29024c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29024c = this;
                        this.f29022a = str2;
                        this.f29023b = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.r.b.a(this.f29022a);
                            this.f29024c.finish();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void b(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) || this.f29024c.f29008f == null) {
                            return;
                        }
                        this.f29024c.f29008f.dismiss();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void c(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                            this.f29024c.b(this.f29023b);
                        }
                    }
                });
                this.f29008f.a(z);
                this.f29008f.show();
            } catch (Throwable unused) {
            }
        }
    }

    private void b(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, str, strArr) == null) {
            if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.g.e(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f29030a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ TTDelegateActivity f29031b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f29031b = this;
                                this.f29030a = str;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.g.e
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.r.c.a(this.f29030a);
                                    this.f29031b.finish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.g.e
                            public void a(String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                    com.bytedance.sdk.openadsdk.r.c.a(this.f29030a, str2);
                                    this.f29031b.finish();
                                }
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        finish();
                        return;
                    }
                }
                com.bytedance.sdk.component.utils.j.b(TTAdConstant.TAG, "已经有权限");
                finish();
                return;
            }
            finish();
        }
    }

    public static void a(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, mVar) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("type", 6);
            intent.putExtra("materialmeta", mVar.aO().toString());
            if (context != null) {
                context.startActivity(intent);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            try {
                if (this.f29010h == null || !this.f29010h.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.a aVar = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
                    this.f29010h = aVar;
                    aVar.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f29011a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f29011a = this;
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.f29011a.finish();
                            }
                        }
                    });
                    this.f29010h.show();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        String str6;
        com.bytedance.sdk.openadsdk.core.e.c b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)}) == null) {
            try {
                String str7 = "";
                if (TextUtils.isEmpty(str) || (b2 = com.bytedance.sdk.openadsdk.core.b.b(new JSONObject(str))) == null) {
                    str5 = "";
                    str6 = str5;
                } else {
                    str7 = b2.b();
                    str6 = b2.c();
                    str5 = b2.g();
                    if (TextUtils.isEmpty(str5)) {
                        str5 = str3;
                    }
                }
                if (this.f29007e == null || !this.f29007e.isShowing()) {
                    e a2 = new e(this).a(str5).b(str7).c(str4).d(str6).a(new e.a(this, str2, str, str3, z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f29012a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f29013b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f29014c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f29015d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f29016e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str2, str, str3, Boolean.valueOf(z)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f29016e = this;
                            this.f29012a = str2;
                            this.f29013b = str;
                            this.f29014c = str3;
                            this.f29015d = z;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void a(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.r.b.a(this.f29012a);
                                this.f29016e.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void b(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                                this.f29016e.b(this.f29013b, this.f29012a, this.f29014c, this.f29015d);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void c(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.r.b.c(this.f29012a);
                                this.f29016e.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void d(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048579, this, dialog) == null) {
                                this.f29016e.b(this.f29013b);
                            }
                        }
                    });
                    this.f29007e = a2;
                    a2.show();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            try {
                if (this.f29008f == null || !this.f29008f.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
                    this.f29008f = bVar;
                    bVar.a(str3).a(new b.a(this, str2, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f29017a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f29018b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f29019c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str2, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f29019c = this;
                            this.f29017a = str2;
                            this.f29018b = str;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void a(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.r.b.a(this.f29017a);
                                this.f29019c.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void b(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.r.b.c(this.f29017a);
                                this.f29019c.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void c(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                                this.f29019c.b(this.f29018b);
                            }
                        }
                    });
                    this.f29008f.a(z);
                    this.f29008f.show();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, this, str, str2, str3, str4, str5) == null) {
            AlertDialog alertDialog = this.f29004b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.f29006d == null) {
                this.f29006d = new f(this).a(str2).b(str3).c(str4).d(str5).a(new f.a(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f29028a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f29029b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29029b = this;
                        this.f29028a = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.r.b.a(this.f29028a);
                            this.f29029b.finish();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
                    public void b(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.r.b.b(this.f29028a);
                            this.f29029b.finish();
                        }
                    }
                }).a(new DialogInterface.OnCancelListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f29026a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f29027b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29027b = this;
                        this.f29026a = str;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            com.bytedance.sdk.openadsdk.r.b.c(this.f29026a);
                            this.f29027b.finish();
                        }
                    }
                });
            }
            if (!this.f29006d.isShowing()) {
                this.f29006d.show();
            }
            this.f29004b = this.f29006d;
        }
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = r.a(this, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            a(str4, str3, new DialogInterface.OnClickListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29032a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f29033b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29033b = this;
                    this.f29032a = str;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        com.bytedance.sdk.openadsdk.r.b.a(this.f29032a);
                        this.f29033b.finish();
                    }
                }
            }, new DialogInterface.OnClickListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29034a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f29035b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29035b = this;
                    this.f29034a = str;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        com.bytedance.sdk.openadsdk.r.b.b(this.f29034a);
                        this.f29035b.finish();
                    }
                }
            }, new DialogInterface.OnCancelListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29036a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f29037b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29037b = this;
                    this.f29036a = str;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.bytedance.sdk.openadsdk.r.b.c(this.f29036a);
                        this.f29037b.finish();
                    }
                }
            });
        }
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, this, str, str2, onClickListener, onClickListener2, onCancelListener) == null) {
            try {
                if (this.f29004b == null) {
                    this.f29004b = new AlertDialog.Builder(this, r.g(this, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).create();
                }
                this.f29004b.setTitle(String.valueOf(str));
                this.f29004b.setMessage(String.valueOf(str2));
                this.f29004b.setButton(-1, r.a(this, "tt_label_ok"), onClickListener);
                this.f29004b.setButton(-2, r.a(this, "tt_label_cancel"), onClickListener2);
                this.f29004b.setOnCancelListener(onCancelListener);
                if (this.f29004b.isShowing()) {
                    return;
                }
                this.f29004b.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
