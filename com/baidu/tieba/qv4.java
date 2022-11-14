package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.uv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qv4 implements tv4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public uv4 b;
    public View c;
    public EMTextView d;
    public View e;
    public ImageView f;
    public Drawable g;
    public String h;
    public int i;
    public int j;
    public int k;
    public uv4.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv4 a;

        public a(qv4 qv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l != null) {
                    this.a.l.onClick();
                }
                if (this.a.b != null && this.a.b.d() != null) {
                    this.a.b.d().n0(this.a.b, this.a.a, this.a.d);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105274, "Lcom/baidu/tieba/qv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105274, "Lcom/baidu/tieba/qv4;");
                return;
            }
        }
        q = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    public qv4(int i, String str, uv4 uv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, uv4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.a = i;
        this.h = str;
        this.b = uv4Var;
        j();
        i();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public qv4(uv4 uv4Var) {
        this(null, uv4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (uv4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public qv4(String str, uv4 uv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, uv4Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.h = str;
        this.b = uv4Var;
        this.a = hashCode();
        j();
        i();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public void l(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.g = drawable;
        }
    }

    public void m(uv4.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.l = dVar;
            i();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.h = str;
            this.d.setText(str);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
            SkinManager.setBackgroundResource(this.d, i);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
            SkinManager.setViewTextColor(this.d, i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
            MaskView.d(this.d, z);
        }
    }

    @Override // com.baidu.tieba.tv4
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.d, this.j);
            SkinManager.setViewTextColorSelector(this.d, this.i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            MaskView.d(this.d, this.n);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tv4
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void i() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (eMTextView = this.d) != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            pw4.d(this.d).A(R.string.F_X02);
        }
    }

    public final void h() {
        uv4 uv4Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (uv4Var = this.b) != null && uv4Var.getContext() != null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d075d, this.b.f(), false);
            this.c = inflate;
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (this.o) {
                i = r;
            } else {
                i = q;
            }
            layoutParams.width = i;
            Object tag = this.d.getTag();
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f091015);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            this.d.setTag(tag);
            View findViewById = this.c.findViewById(R.id.divider_line);
            this.e = findViewById;
            findViewById.setVisibility(8);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.f = imageView;
            imageView.setImageDrawable(this.g);
            a();
            this.c.setOnClickListener(this.p);
        }
    }

    public final void j() {
        uv4 uv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (uv4Var = this.b) != null && uv4Var.getContext() != null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d075e, this.b.f(), false);
            this.c = inflate;
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091015);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            View findViewById = this.c.findViewById(R.id.divider_line);
            this.e = findViewById;
            if (this.m) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            a();
        }
    }
}
