package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.p.a.a.a.c.k;
import c.p.a.a.a.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.q.c;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class e implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f67606a;

    /* loaded from: classes9.dex */
    public static class a implements DialogInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.content.DialogInterface
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67606a = new WeakReference<>(context);
    }

    private void c(c.p.a.a.a.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            c.a aVar = new c.a(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c.p.a.a.a.f.c f67617a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f67618b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67618b = this;
                    this.f67617a = cVar;
                }

                @Override // com.bytedance.sdk.openadsdk.q.c.a
                public void a() {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (interfaceC1519c = this.f67617a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.a(new a());
                }

                @Override // com.bytedance.sdk.openadsdk.q.c.a
                public void b() {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (interfaceC1519c = this.f67617a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.b(new a());
                }

                @Override // com.bytedance.sdk.openadsdk.q.c.a
                public void c() {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interfaceC1519c = this.f67617a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.c(new a());
                }
            };
            if (cVar.f34456j == 1) {
                com.bytedance.sdk.openadsdk.q.c.a(this.f67606a.get(), String.valueOf(cVar.hashCode()), cVar.f34448b, cVar.f34449c, cVar.f34450d, cVar.f34451e, aVar);
            } else {
                com.bytedance.sdk.openadsdk.q.c.a(this.f67606a.get(), String.valueOf(cVar.hashCode()), cVar.f34448b, cVar.f34449c, aVar);
            }
        }
    }

    @Override // c.p.a.a.a.c.k
    public void a(int i2, @Nullable Context context, @Nullable c.p.a.a.a.d.d dVar, String str, Drawable drawable, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), context, dVar, str, drawable, Integer.valueOf(i3)}) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.k.f("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }
    }

    private AlertDialog b(Activity activity, c.p.a.a.a.f.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, activity, cVar)) == null) ? new com.bytedance.sdk.openadsdk.core.widget.f(activity).a(cVar.f34448b).b(cVar.f34449c).c(cVar.f34450d).d(cVar.f34451e).a(cVar.f34453g).a(new f.a(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.p.a.a.a.f.c f67615a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f67616b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67616b = this;
                this.f67615a = cVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
            public void a(Dialog dialog) {
                c.InterfaceC1519c interfaceC1519c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) || (interfaceC1519c = this.f67615a.f34454h) == null) {
                    return;
                }
                interfaceC1519c.a(dialog);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
            public void b(Dialog dialog) {
                c.InterfaceC1519c interfaceC1519c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) || (interfaceC1519c = this.f67615a.f34454h) == null) {
                    return;
                }
                interfaceC1519c.b(dialog);
            }
        }).a(new DialogInterface.OnCancelListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.p.a.a.a.f.c f67613a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f67614b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67614b = this;
                this.f67613a = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1519c interfaceC1519c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (interfaceC1519c = this.f67613a.f34454h) == null) {
                    return;
                }
                interfaceC1519c.c(dialogInterface);
            }
        }) : (AlertDialog) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.p.a.a.a.c.k
    /* renamed from: a */
    public AlertDialog b(@NonNull c.p.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar == null || com.bytedance.sdk.openadsdk.m.a.a(cVar)) {
                return null;
            }
            Context context = cVar.f34447a;
            if (context != null && (context instanceof Activity)) {
                return a((Activity) context, cVar);
            }
            c(cVar);
            return null;
        }
        return (AlertDialog) invokeL.objValue;
    }

    private AlertDialog a(Activity activity, c.p.a.a.a.f.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, activity, cVar)) == null) {
            if (cVar.f34456j == 1) {
                AlertDialog b2 = b(activity, cVar);
                b2.show();
                return b2;
            }
            AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, t.g(activity, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).setTitle(cVar.f34448b).setMessage(cVar.f34449c).setPositiveButton(cVar.f34450d, new DialogInterface.OnClickListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c.p.a.a.a.f.c f67611a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f67612b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67612b = this;
                    this.f67611a = cVar;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC1519c = this.f67611a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.a(dialogInterface);
                }
            }).setNegativeButton(cVar.f34451e, new DialogInterface.OnClickListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c.p.a.a.a.f.c f67609a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f67610b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67610b = this;
                    this.f67609a = cVar;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC1519c = this.f67609a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.b(dialogInterface);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c.p.a.a.a.f.c f67607a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f67608b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67608b = this;
                    this.f67607a = cVar;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    c.InterfaceC1519c interfaceC1519c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (interfaceC1519c = this.f67607a.f34454h) == null) {
                        return;
                    }
                    interfaceC1519c.c(dialogInterface);
                }
            });
            Drawable drawable = cVar.f34453g;
            if (drawable != null) {
                onCancelListener.setIcon(drawable);
            }
            AlertDialog create = onCancelListener.create();
            create.show();
            return create;
        }
        return (AlertDialog) invokeLL.objValue;
    }
}
