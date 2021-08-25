package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
/* loaded from: classes9.dex */
public class l implements com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<BackupView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackupView f66718a;

    /* renamed from: b  reason: collision with root package name */
    public View f66719b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f66720c;

    /* renamed from: d  reason: collision with root package name */
    public c f66721d;

    /* renamed from: e  reason: collision with root package name */
    public m f66722e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.g f66723f;

    public l(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.core.nativeexpress.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, themeStatusBroadcastReceiver, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66719b = view;
        this.f66720c = themeStatusBroadcastReceiver;
        this.f66723f = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c cVar = this.f66721d;
            boolean z = false;
            if (cVar != null && cVar.a((NativeExpressView) this.f66719b, 0)) {
                z = true;
            }
            if (!z) {
                this.f66722e.a(107);
                return;
            }
            this.f66723f.d().h();
            BackupView backupView = (BackupView) this.f66719b.findViewWithTag("tt_express_backup_fl_tag_26");
            this.f66718a = backupView;
            if (backupView != null) {
                backupView.setThemeChangeReceiver(this.f66720c);
                com.bytedance.sdk.openadsdk.core.e.p pVar = new com.bytedance.sdk.openadsdk.core.e.p();
                BackupView backupView2 = this.f66718a;
                float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
                BackupView backupView3 = this.f66718a;
                float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
                pVar.a(true);
                pVar.a(realWidth);
                pVar.b(realHeight);
                this.f66722e.a(this.f66718a, pVar);
                return;
            }
            this.f66722e.a(107);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            this.f66722e = mVar;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c();
            } else {
                com.bytedance.sdk.openadsdk.core.l.d().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ l f66724a;

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
                        this.f66724a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66724a.c();
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    /* renamed from: a */
    public BackupView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66718a : (BackupView) invokeV.objValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f66721d = cVar;
        }
    }
}
