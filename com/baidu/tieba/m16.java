package com.baidu.tieba;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.l16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class m16 implements l16, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public k16 h;
    public l16.a i;
    public int j;
    public Map k;

    public m16(TbPageContext tbPageContext, k16 k16Var, l16.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, k16Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = new HashMap();
        this.a = tbPageContext;
        this.h = k16Var;
        this.i = aVar;
        d();
    }

    @Override // com.baidu.tieba.l16
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.getVisibility();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l16
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l16
    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ((Float) this.k.get(Integer.valueOf(this.j))).floatValue();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.l16
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(0);
        }
    }

    @Override // com.baidu.tieba.l16
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            h(this.j, false);
            this.j = i;
            h(i, true);
            k16 k16Var = this.h;
            if (k16Var != null) {
                k16Var.a(getSpeed());
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.k.put(0, Float.valueOf(1.0f));
            this.k.put(1, Float.valueOf(0.5f));
            this.k.put(2, Float.valueOf(0.33333334f));
            this.k.put(3, Float.valueOf(2.0f));
            this.k.put(4, Float.valueOf(3.0f));
            e();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = (LinearLayout) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904cd);
            this.c = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f30);
            this.d = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f2f);
            this.e = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f2e);
            this.f = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f2b);
            this.g = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f2c);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            nv4 d = nv4.d(this.b);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0214);
            g(this.e, true);
            g(this.c, false);
            g(this.d, false);
            g(this.f, false);
            g(this.g, false);
        }
    }

    public final void g(TextView textView, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            Resources resources = this.a.getResources();
            if (z) {
                i = R.color.CAM_X0302;
            } else {
                i = R.color.CAM_X0101;
            }
            textView.setTextColor(resources.getColor(i));
            if (z) {
                i2 = R.dimen.T_X05;
            } else {
                i2 = R.dimen.T_X07;
            }
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(i2));
        }
    }

    public final void h(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                g(this.g, z);
                                return;
                            }
                            return;
                        }
                        g(this.f, z);
                        return;
                    }
                    g(this.c, z);
                    return;
                }
                g(this.d, z);
                return;
            }
            g(this.e, z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091f30) {
                l16.a aVar = this.i;
                if (aVar == null || aVar.a(2)) {
                    f(2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f2f) {
                l16.a aVar2 = this.i;
                if (aVar2 == null || aVar2.a(1)) {
                    f(1);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f2e) {
                l16.a aVar3 = this.i;
                if (aVar3 == null || aVar3.a(0)) {
                    f(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f2b) {
                l16.a aVar4 = this.i;
                if (aVar4 == null || aVar4.a(3)) {
                    f(3);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f2c) {
                l16.a aVar5 = this.i;
                if (aVar5 == null || aVar5.a(4)) {
                    f(4);
                }
            }
        }
    }
}
