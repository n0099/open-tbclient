package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q23 extends k23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;
        public final q23 b;
        public Context c;
        public boolean d;

        /* renamed from: com.baidu.tieba.q23$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0391a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0391a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -1);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -2);
                    }
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = false;
            q23 b2 = b(context);
            this.b = b2;
            b2.d(this);
            this.a = new b((ViewGroup) this.b.getWindow().getDecorView());
            this.c = context;
        }

        public q23 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.setOnCancelListener(this.a.f);
                this.b.setOnDismissListener(this.a.g);
                this.b.setOnShowListener(this.a.h);
                this.b.d(this);
                return this.b;
            }
            return (q23) invokeV.objValue;
        }

        public abstract q23 b(Context context);

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.b.setCanceledOnTouchOutside(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, onClickListener)) == null) {
                e(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, onClickListener)) == null) {
                this.a.b.setText(charSequence);
                this.a.b.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onCancelListener)) == null) {
                this.a.f = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.a.c.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, onClickListener)) == null) {
                i(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.a.a.setText(charSequence);
                this.a.a.setOnClickListener(new View$OnClickListenerC0391a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
                this.a.e.removeAllViews();
                this.a.e.addView(view2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public q23 k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                q23 a = a();
                if (this.d) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (q23) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public View d;
        public FrameLayout e;
        public DialogInterface.OnCancelListener f;
        public DialogInterface.OnDismissListener g;
        public DialogInterface.OnShowListener h;
        public FrameLayout i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907d0);
            this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09223c);
            this.a = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a39);
            this.b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091673);
            this.d = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907c0);
            this.e = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907c1);
            this.m = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e1c);
            this.n = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09044c);
            this.o = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907c0);
            this.i = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907d0);
            this.k = viewGroup.findViewById(R.id.obfuscated_res_0x7f0916c5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q23(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        c();
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d082d);
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(80);
            a(false);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
