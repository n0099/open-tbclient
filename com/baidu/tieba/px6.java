package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class px6 extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public View f;
    public LinearLayout g;
    public rx6 h;
    public Context i;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px6 a;

        public a(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = px6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int top = this.a.d.findViewById(R.id.obfuscated_res_0x7f090fdf).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.a.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px6(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context, i);
        this.i = context;
        e();
        c(TbadkCoreApplication.getInst().getSkinType());
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    public void d(rx6 rx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rx6Var) == null) {
            this.h = rx6Var;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            dismiss();
            rx6 rx6Var = this.h;
            if (rx6Var == null) {
                return;
            }
            if (view2 == this.a) {
                rx6Var.b();
            } else if (view2 == this.b) {
                rx6Var.a();
            }
        }
    }

    public final void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d027e, (ViewGroup) null);
            this.d = inflate;
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09267b);
            this.b = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09263f);
            this.c = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0925df);
            this.g = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090fdf);
            this.e = this.d.findViewById(R.id.obfuscated_res_0x7f0914c2);
            this.f = this.d.findViewById(R.id.obfuscated_res_0x7f0914c3);
            if (i == 1) {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0204);
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundResource(this.g, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                setAttachedInDecor(false);
            }
            setContentView(this.d);
            GreyUtil.grey(this);
            setWidth(-1);
            setHeight(ri.j(this.i));
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
            this.d.setOnTouchListener(new a(this));
        }
    }
}
