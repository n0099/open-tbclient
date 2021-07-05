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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.r.b;
import d.l.a.a.a.c.k;
import d.l.a.a.a.f.c;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class e implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f30995a;

    /* loaded from: classes6.dex */
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
        this.f30995a = new WeakReference<>(context);
    }

    private void c(d.l.a.a.a.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            b.a aVar = new b.a(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.a.a.f.c f31006a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f31007b;

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
                    this.f31007b = this;
                    this.f31006a = cVar;
                }

                @Override // com.bytedance.sdk.openadsdk.r.b.a
                public void a() {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (interfaceC2044c = this.f31006a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.b(new a());
                }

                @Override // com.bytedance.sdk.openadsdk.r.b.a
                public void b() {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (interfaceC2044c = this.f31006a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.a(new a());
                }

                @Override // com.bytedance.sdk.openadsdk.r.b.a
                public void c() {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interfaceC2044c = this.f31006a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.c(new a());
                }
            };
            if (cVar.j == 1) {
                com.bytedance.sdk.openadsdk.r.b.a(this.f30995a.get(), String.valueOf(cVar.hashCode()), cVar.f74047b, cVar.f74048c, cVar.f74049d, cVar.f74050e, aVar);
            } else {
                com.bytedance.sdk.openadsdk.r.b.a(this.f30995a.get(), String.valueOf(cVar.hashCode()), cVar.f74047b, cVar.f74048c, aVar);
            }
        }
    }

    @Override // d.l.a.a.a.c.k
    public void a(int i2, @Nullable Context context, @Nullable d.l.a.a.a.d.d dVar, String str, Drawable drawable, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), context, dVar, str, drawable, Integer.valueOf(i3)}) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                j.f("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }
    }

    private AlertDialog b(Activity activity, d.l.a.a.a.f.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, activity, cVar)) == null) ? new com.bytedance.sdk.openadsdk.core.widget.f(activity).a(cVar.f74047b).b(cVar.f74048c).c(cVar.f74049d).d(cVar.f74050e).a(cVar.f74052g).a(new f.a(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.a.a.f.c f31004a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f31005b;

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
                this.f31005b = this;
                this.f31004a = cVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
            public void a(Dialog dialog) {
                c.InterfaceC2044c interfaceC2044c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialog) == null) || (interfaceC2044c = this.f31004a.f74053h) == null) {
                    return;
                }
                interfaceC2044c.b(dialog);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.f.a
            public void b(Dialog dialog) {
                c.InterfaceC2044c interfaceC2044c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialog) == null) || (interfaceC2044c = this.f31004a.f74053h) == null) {
                    return;
                }
                interfaceC2044c.a(dialog);
            }
        }).a(new DialogInterface.OnCancelListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.a.a.f.c f31002a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f31003b;

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
                this.f31003b = this;
                this.f31002a = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC2044c interfaceC2044c;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (interfaceC2044c = this.f31002a.f74053h) == null) {
                    return;
                }
                interfaceC2044c.c(dialogInterface);
            }
        }) : (AlertDialog) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.l.a.a.a.c.k
    /* renamed from: a */
    public AlertDialog b(@NonNull d.l.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar == null || com.bytedance.sdk.openadsdk.n.a.a(cVar)) {
                return null;
            }
            Context context = cVar.f74046a;
            if (context != null && (context instanceof Activity)) {
                return a((Activity) context, cVar);
            }
            c(cVar);
            return null;
        }
        return (AlertDialog) invokeL.objValue;
    }

    private AlertDialog a(Activity activity, d.l.a.a.a.f.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, activity, cVar)) == null) {
            if (cVar.j == 1) {
                AlertDialog b2 = b(activity, cVar);
                b2.show();
                return b2;
            }
            AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, r.g(activity, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).setTitle(cVar.f74047b).setMessage(cVar.f74048c).setPositiveButton(cVar.f74049d, new DialogInterface.OnClickListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.a.a.f.c f31000a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f31001b;

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
                    this.f31001b = this;
                    this.f31000a = cVar;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC2044c = this.f31000a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.b(dialogInterface);
                }
            }).setNegativeButton(cVar.f74050e, new DialogInterface.OnClickListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.a.a.f.c f30998a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f30999b;

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
                    this.f30999b = this;
                    this.f30998a = cVar;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC2044c = this.f30998a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.a(dialogInterface);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.a.a.f.c f30996a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f30997b;

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
                    this.f30997b = this;
                    this.f30996a = cVar;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    c.InterfaceC2044c interfaceC2044c;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (interfaceC2044c = this.f30996a.f74053h) == null) {
                        return;
                    }
                    interfaceC2044c.c(dialogInterface);
                }
            });
            Drawable drawable = cVar.f74052g;
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
