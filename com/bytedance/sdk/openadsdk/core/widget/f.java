package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class f extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f30855a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30856b;

    /* renamed from: c  reason: collision with root package name */
    public Button f30857c;

    /* renamed from: d  reason: collision with root package name */
    public Button f30858d;

    /* renamed from: e  reason: collision with root package name */
    public Context f30859e;

    /* renamed from: f  reason: collision with root package name */
    public String f30860f;

    /* renamed from: g  reason: collision with root package name */
    public String f30861g;

    /* renamed from: h  reason: collision with root package name */
    public String f30862h;

    /* renamed from: i  reason: collision with root package name */
    public String f30863i;
    public Drawable j;
    public a k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, r.g(context, "tt_custom_dialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30859e = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TextView textView = this.f30855a;
            if (textView != null) {
                textView.setText(this.f30860f);
                Drawable drawable = this.j;
                if (drawable != null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.j.getIntrinsicHeight();
                    int d2 = q.d(this.f30859e, 45.0f);
                    if (intrinsicWidth > d2 || intrinsicWidth < d2) {
                        intrinsicWidth = d2;
                    }
                    if (intrinsicHeight > d2 || intrinsicHeight < d2) {
                        intrinsicHeight = d2;
                    }
                    this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    this.f30855a.setCompoundDrawables(this.j, null, null, null);
                    this.f30855a.setCompoundDrawablePadding(q.d(this.f30859e, 10.0f));
                }
            }
            TextView textView2 = this.f30856b;
            if (textView2 != null) {
                textView2.setText(this.f30861g);
            }
            Button button = this.f30857c;
            if (button != null) {
                button.setText(this.f30862h);
            }
            Button button2 = this.f30858d;
            if (button2 != null) {
                button2.setText(this.f30863i);
            }
        }
    }

    public f c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f30862h = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f30863i = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(r.f(this.f30859e, "tt_install_dialog_layout"));
            setCanceledOnTouchOutside(true);
            a();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.show();
            b();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f30855a = (TextView) findViewById(r.e(this.f30859e, "tt_install_title"));
            this.f30856b = (TextView) findViewById(r.e(this.f30859e, "tt_install_content"));
            this.f30857c = (Button) findViewById(r.e(this.f30859e, "tt_install_btn_yes"));
            this.f30858d = (Button) findViewById(r.e(this.f30859e, "tt_install_btn_no"));
            this.f30857c.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f30864a;

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
                    this.f30864a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30864a.dismiss();
                        if (this.f30864a.k != null) {
                            this.f30864a.k.a(this.f30864a);
                        }
                    }
                }
            });
            this.f30858d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f30865a;

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
                    this.f30865a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30865a.dismiss();
                        if (this.f30865a.k != null) {
                            this.f30865a.k.b(this.f30865a);
                        }
                    }
                }
            });
        }
    }

    public f a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f30860f = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
            this.j = drawable;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.k = aVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            setOnCancelListener(onCancelListener);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f30861g = str;
            return this;
        }
        return (f) invokeL.objValue;
    }
}
