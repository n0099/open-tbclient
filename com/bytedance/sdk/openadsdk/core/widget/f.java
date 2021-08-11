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
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class f extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f66972a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66973b;

    /* renamed from: c  reason: collision with root package name */
    public Button f66974c;

    /* renamed from: d  reason: collision with root package name */
    public Button f66975d;

    /* renamed from: e  reason: collision with root package name */
    public Context f66976e;

    /* renamed from: f  reason: collision with root package name */
    public String f66977f;

    /* renamed from: g  reason: collision with root package name */
    public String f66978g;

    /* renamed from: h  reason: collision with root package name */
    public String f66979h;

    /* renamed from: i  reason: collision with root package name */
    public String f66980i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f66981j;
    public a k;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, t.g(context, "tt_custom_dialog"));
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
        this.f66976e = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TextView textView = this.f66972a;
            if (textView != null) {
                textView.setText(this.f66977f);
                Drawable drawable = this.f66981j;
                if (drawable != null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.f66981j.getIntrinsicHeight();
                    int d2 = s.d(this.f66976e, 45.0f);
                    if (intrinsicWidth > d2 || intrinsicWidth < d2) {
                        intrinsicWidth = d2;
                    }
                    if (intrinsicHeight > d2 || intrinsicHeight < d2) {
                        intrinsicHeight = d2;
                    }
                    this.f66981j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    this.f66972a.setCompoundDrawables(this.f66981j, null, null, null);
                    this.f66972a.setCompoundDrawablePadding(s.d(this.f66976e, 10.0f));
                }
            }
            TextView textView2 = this.f66973b;
            if (textView2 != null) {
                textView2.setText(this.f66978g);
            }
            Button button = this.f66974c;
            if (button != null) {
                button.setText(this.f66979h);
            }
            Button button2 = this.f66975d;
            if (button2 != null) {
                button2.setText(this.f66980i);
            }
        }
    }

    public f c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f66979h = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f66980i = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f66976e, "tt_install_dialog_layout"));
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
            this.f66972a = (TextView) findViewById(t.e(this.f66976e, "tt_install_title"));
            this.f66973b = (TextView) findViewById(t.e(this.f66976e, "tt_install_content"));
            this.f66974c = (Button) findViewById(t.e(this.f66976e, "tt_install_btn_yes"));
            this.f66975d = (Button) findViewById(t.e(this.f66976e, "tt_install_btn_no"));
            this.f66974c.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f66982a;

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
                    this.f66982a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f66982a.dismiss();
                        if (this.f66982a.k != null) {
                            this.f66982a.k.a(this.f66982a);
                        }
                    }
                }
            });
            this.f66975d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f66983a;

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
                    this.f66983a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f66983a.dismiss();
                        if (this.f66983a.k != null) {
                            this.f66983a.k.b(this.f66983a);
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
            this.f66977f = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
            this.f66981j = drawable;
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
            this.f66978g = str;
            return this;
        }
        return (f) invokeL.objValue;
    }
}
