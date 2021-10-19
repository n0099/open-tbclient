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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
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
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TTDelegateActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Intent f65813a;

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f65814b;

    /* renamed from: c  reason: collision with root package name */
    public TTAdDislike f65815c;

    /* renamed from: d  reason: collision with root package name */
    public f f65816d;

    /* renamed from: e  reason: collision with root package name */
    public e f65817e;

    /* renamed from: f  reason: collision with root package name */
    public b f65818f;

    /* renamed from: g  reason: collision with root package name */
    public c f65819g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f65820h;

    /* loaded from: classes9.dex */
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
                if (this.f65819g != null) {
                    this.f65819g.dismiss();
                }
                c cVar = new c(this, str);
                this.f65819g = cVar;
                cVar.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f65831a;

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
                        this.f65831a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            this.f65831a.finish();
                        }
                    }
                });
                this.f65819g.show();
            } catch (Throwable unused) {
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
            if (str != null && this.f65815c == null) {
                try {
                    m a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(str));
                    if (a2 != null) {
                        com.bytedance.sdk.openadsdk.dislike.ui.a aVar = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, a2.aG(), false);
                        this.f65815c = aVar;
                        aVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.16
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ TTDelegateActivity f65835a;

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
                                this.f65835a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onCancel() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f65835a.finish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onSelected(int i2, String str2, boolean z) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str2, Boolean.valueOf(z)}) == null) {
                                    this.f65835a.finish();
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
            TTAdDislike tTAdDislike = this.f65815c;
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
            this.f65813a = getIntent();
            if (o.a() == null) {
                o.a(this);
            }
            com.bytedance.sdk.component.d.e.b().execute(new g(this, "onDelegateActivityOnCreate") { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f65849a;

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
                    this.f65849a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.j.a.a().a(this.f65849a);
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
                if (this.f65814b != null && this.f65814b.isShowing()) {
                    this.f65814b.dismiss();
                }
                if (this.f65817e != null && this.f65817e.isShowing()) {
                    this.f65817e.dismiss();
                }
                if (this.f65818f != null && this.f65818f.isShowing()) {
                    this.f65818f.dismiss();
                }
                if (this.f65819g != null && this.f65819g.isShowing()) {
                    this.f65819g.dismiss();
                }
                if (this.f65820h != null && this.f65820h.isShowing()) {
                    this.f65820h.dismiss();
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
                this.f65813a = intent;
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) {
            d.a().a(this, strArr, iArr);
            com.bytedance.sdk.component.d.e.a(new a("onRequestPermissionsResult"), 1);
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
                intent.addFlags(268435456);
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
            intent.addFlags(268435456);
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
                            k.c("requestPermission->startActivity error :" + th.toString());
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
                    com.bytedance.sdk.openadsdk.m.a.a(f2, arrayList);
                    if (isCanUsePhoneState) {
                        arrayList.add("android.permission.READ_PHONE_STATE");
                    }
                    if (isCanUseWriteExternal) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.g.e(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f65848a;

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
                            this.f65848a = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.g.e
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.bytedance.sdk.component.d.e.a(new a("checkNecessaryPermission"), 1);
                                this.f65848a.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.g.e
                        public void a(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                "android.permission.READ_PHONE_STATE".equals(str);
                                com.bytedance.sdk.component.d.e.a(new a("checkNecessaryPermission"), 1);
                                this.f65848a.finish();
                            }
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            k.b(TTAdConstant.TAG, "已经有Read phone state权限");
            finish();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            try {
                if (this.f65813a == null) {
                    return;
                }
                int intExtra = this.f65813a.getIntExtra("type", 0);
                String stringExtra = this.f65813a.getStringExtra("app_download_url");
                this.f65813a.getStringExtra("app_name");
                switch (intExtra) {
                    case 1:
                        return;
                    case 2:
                        c();
                        return;
                    case 3:
                        a(stringExtra, this.f65813a.getStringExtra("dialog_title_key"), this.f65813a.getStringExtra("dialog_content_key"));
                        return;
                    case 4:
                        b(this.f65813a.getStringExtra("permission_id_key"), this.f65813a.getStringArrayExtra("permission_content_key"));
                        return;
                    case 5:
                        a(stringExtra, this.f65813a.getStringExtra("dialog_title_key"), this.f65813a.getStringExtra("dialog_content_key"), this.f65813a.getStringExtra("dialog_btn_yes_key"), this.f65813a.getStringExtra("dialog_btn_no_key"));
                        return;
                    case 6:
                        d(this.f65813a.getStringExtra("materialmeta"));
                        return;
                    case 7:
                        if (this.f65813a != null) {
                            a(this.f65813a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f65813a.getStringExtra("dialog_title_key"), this.f65813a.getStringExtra("dialog_app_manage_model_icon_url"), this.f65813a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                            return;
                        }
                        return;
                    case 8:
                        a(this.f65813a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f65813a.getStringExtra("dialog_title_key"), this.f65813a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        return;
                    case 9:
                        c(this.f65813a.getStringExtra("dialog_app_manage_model"));
                        return;
                    case 10:
                        a(this.f65813a.getStringExtra("dialog_content_key"));
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
                intent.addFlags(268435456);
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
                intent.addFlags(268435456);
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
                intent.addFlags(268435456);
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
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            if (context == null) {
                context = o.a();
            }
            Intent intent = new Intent(context, TTDelegateActivity.class);
            intent.addFlags(268435456);
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
                if (this.f65819g != null) {
                    this.f65819g.dismiss();
                }
                c cVar = new c(this, str);
                this.f65819g = cVar;
                cVar.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f65830a;

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
                        this.f65830a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) || this.f65830a.f65819g == null) {
                            return;
                        }
                        this.f65830a.f65819g.dismiss();
                    }
                });
                this.f65819g.show();
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
                intent.addFlags(268435456);
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
                if (this.f65818f != null) {
                    this.f65818f.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
                this.f65818f = bVar;
                bVar.a(str3).a(new b.a(this, str2, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f65832a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f65833b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f65834c;

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
                        this.f65834c = this;
                        this.f65832a = str2;
                        this.f65833b = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.q.c.a(this.f65832a);
                            this.f65834c.finish();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void b(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) || this.f65834c.f65818f == null) {
                            return;
                        }
                        this.f65834c.f65818f.dismiss();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                    public void c(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                            this.f65834c.b(this.f65833b);
                        }
                    }
                });
                this.f65818f.a(z);
                this.f65818f.show();
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
                            public final /* synthetic */ String f65840a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ TTDelegateActivity f65841b;

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
                                this.f65841b = this;
                                this.f65840a = str;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.g.e
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.q.d.a(this.f65840a);
                                    this.f65841b.finish();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.g.e
                            public void a(String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                    com.bytedance.sdk.openadsdk.q.d.a(this.f65840a, str2);
                                    this.f65841b.finish();
                                }
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        finish();
                        return;
                    }
                }
                k.b(TTAdConstant.TAG, "已经有权限");
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
                intent.addFlags(268435456);
            }
            intent.putExtra("type", 6);
            intent.putExtra("materialmeta", mVar.aP().toString());
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
                if (this.f65820h == null || !this.f65820h.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.a aVar = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
                    this.f65820h = aVar;
                    aVar.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f65821a;

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
                            this.f65821a = this;
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.f65821a.finish();
                            }
                        }
                    });
                    this.f65820h.show();
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
                if (this.f65817e == null || !this.f65817e.isShowing()) {
                    e a2 = new e(this).a(str5).b(str7).c(str4).d(str6).a(new e.a(this, str2, str, str3, z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f65822a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f65823b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f65824c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f65825d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f65826e;

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
                            this.f65826e = this;
                            this.f65822a = str2;
                            this.f65823b = str;
                            this.f65824c = str3;
                            this.f65825d = z;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void a(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.q.c.a(this.f65822a);
                                this.f65826e.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void b(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                                this.f65826e.b(this.f65823b, this.f65822a, this.f65824c, this.f65825d);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void c(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.q.c.c(this.f65822a);
                                this.f65826e.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                        public void d(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048579, this, dialog) == null) {
                                this.f65826e.b(this.f65823b);
                            }
                        }
                    });
                    this.f65817e = a2;
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
                if (this.f65818f == null || !this.f65818f.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
                    this.f65818f = bVar;
                    bVar.a(str3).a(new b.a(this, str2, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f65827a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f65828b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ TTDelegateActivity f65829c;

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
                            this.f65829c = this;
                            this.f65827a = str2;
                            this.f65828b = str;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void a(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.q.c.a(this.f65827a);
                                this.f65829c.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void b(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                                com.bytedance.sdk.openadsdk.q.c.c(this.f65827a);
                                this.f65829c.finish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                        public void c(Dialog dialog) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
                                this.f65829c.b(this.f65828b);
                            }
                        }
                    });
                    this.f65818f.a(z);
                    this.f65818f.show();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, this, str, str2, str3, str4, str5) == null) {
            AlertDialog alertDialog = this.f65814b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.f65816d == null) {
                this.f65816d = new f(this).a(str2).b(str3).c(str4).d(str5).a(new f.a(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f65838a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f65839b;

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
                        this.f65839b = this;
                        this.f65838a = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
                    public void a(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.q.c.a(this.f65838a);
                            this.f65839b.finish();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
                    public void b(Dialog dialog) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) {
                            com.bytedance.sdk.openadsdk.q.c.b(this.f65838a);
                            this.f65839b.finish();
                        }
                    }
                }).a(new DialogInterface.OnCancelListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f65836a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f65837b;

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
                        this.f65837b = this;
                        this.f65836a = str;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            com.bytedance.sdk.openadsdk.q.c.c(this.f65836a);
                            this.f65837b.finish();
                        }
                    }
                });
            }
            if (!this.f65816d.isShowing()) {
                this.f65816d.show();
            }
            this.f65814b = this.f65816d;
        }
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = t.a(this, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            a(str4, str3, new DialogInterface.OnClickListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65842a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f65843b;

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
                    this.f65843b = this;
                    this.f65842a = str;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        com.bytedance.sdk.openadsdk.q.c.a(this.f65842a);
                        this.f65843b.finish();
                    }
                }
            }, new DialogInterface.OnClickListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65844a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f65845b;

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
                    this.f65845b = this;
                    this.f65844a = str;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        com.bytedance.sdk.openadsdk.q.c.b(this.f65844a);
                        this.f65845b.finish();
                    }
                }
            }, new DialogInterface.OnCancelListener(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65846a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f65847b;

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
                    this.f65847b = this;
                    this.f65846a = str;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.bytedance.sdk.openadsdk.q.c.c(this.f65846a);
                        this.f65847b.finish();
                    }
                }
            });
        }
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, this, str, str2, onClickListener, onClickListener2, onCancelListener) == null) {
            try {
                if (this.f65814b == null) {
                    this.f65814b = new AlertDialog.Builder(this, t.g(this, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).create();
                }
                this.f65814b.setTitle(String.valueOf(str));
                this.f65814b.setMessage(String.valueOf(str2));
                this.f65814b.setButton(-1, t.a(this, "tt_label_ok"), onClickListener);
                this.f65814b.setButton(-2, t.a(this, "tt_label_cancel"), onClickListener2);
                this.f65814b.setOnCancelListener(onCancelListener);
                if (this.f65814b.isShowing()) {
                    return;
                }
                this.f65814b.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
