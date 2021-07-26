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
/* loaded from: classes5.dex */
public class f extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f31038a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f31039b;

    /* renamed from: c  reason: collision with root package name */
    public Button f31040c;

    /* renamed from: d  reason: collision with root package name */
    public Button f31041d;

    /* renamed from: e  reason: collision with root package name */
    public Context f31042e;

    /* renamed from: f  reason: collision with root package name */
    public String f31043f;

    /* renamed from: g  reason: collision with root package name */
    public String f31044g;

    /* renamed from: h  reason: collision with root package name */
    public String f31045h;

    /* renamed from: i  reason: collision with root package name */
    public String f31046i;
    public Drawable j;
    public a k;

    /* loaded from: classes5.dex */
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
        this.f31042e = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TextView textView = this.f31038a;
            if (textView != null) {
                textView.setText(this.f31043f);
                Drawable drawable = this.j;
                if (drawable != null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.j.getIntrinsicHeight();
                    int d2 = s.d(this.f31042e, 45.0f);
                    if (intrinsicWidth > d2 || intrinsicWidth < d2) {
                        intrinsicWidth = d2;
                    }
                    if (intrinsicHeight > d2 || intrinsicHeight < d2) {
                        intrinsicHeight = d2;
                    }
                    this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    this.f31038a.setCompoundDrawables(this.j, null, null, null);
                    this.f31038a.setCompoundDrawablePadding(s.d(this.f31042e, 10.0f));
                }
            }
            TextView textView2 = this.f31039b;
            if (textView2 != null) {
                textView2.setText(this.f31044g);
            }
            Button button = this.f31040c;
            if (button != null) {
                button.setText(this.f31045h);
            }
            Button button2 = this.f31041d;
            if (button2 != null) {
                button2.setText(this.f31046i);
            }
        }
    }

    public f c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f31045h = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f31046i = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f31042e, "tt_install_dialog_layout"));
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
            this.f31038a = (TextView) findViewById(t.e(this.f31042e, "tt_install_title"));
            this.f31039b = (TextView) findViewById(t.e(this.f31042e, "tt_install_content"));
            this.f31040c = (Button) findViewById(t.e(this.f31042e, "tt_install_btn_yes"));
            this.f31041d = (Button) findViewById(t.e(this.f31042e, "tt_install_btn_no"));
            this.f31040c.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f31047a;

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
                    this.f31047a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f31047a.dismiss();
                        if (this.f31047a.k != null) {
                            this.f31047a.k.a(this.f31047a);
                        }
                    }
                }
            });
            this.f31041d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f31048a;

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
                    this.f31048a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f31048a.dismiss();
                        if (this.f31048a.k != null) {
                            this.f31048a.k.b(this.f31048a);
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
            this.f31043f = str;
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
            this.f31044g = str;
            return this;
        }
        return (f) invokeL.objValue;
    }
}
