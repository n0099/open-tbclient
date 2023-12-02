package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tf6 implements sf6, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public TbPageContext b;
    public LinearLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public RelativeLayout l;
    public RelativeLayout m;
    public rf6 n;
    public float o;
    public float p;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf6 a;

        public a(tf6 tf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i(0.0f);
                tf6 tf6Var = this.a;
                tf6Var.o = tf6Var.a;
            }
        }
    }

    public tf6(TbPageContext tbPageContext, int i, int i2, rf6 rf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), rf6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.n = rf6Var;
        if (i2 != 0 && i != 0) {
            float f = i2;
            float f2 = i;
            if ((f * 1.0f) / f2 <= 0.5625f) {
                this.a = (f2 * 1.0f) / f;
                this.o = this.a;
                this.p = 0.0f;
                g();
            }
        }
        this.a = 1.7777778f;
        this.o = this.a;
        this.p = 0.0f;
        g();
    }

    @Override // com.baidu.tieba.sf6
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.sf6
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.i.setVisibility(i);
            if (i == 8) {
                this.p = 1.7777778f;
                i(1.7777778f);
            }
        }
    }

    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.o = f;
            rf6 rf6Var = this.n;
            if (rf6Var != null) {
                rf6Var.a(f);
            }
            j();
        }
    }

    @Override // com.baidu.tieba.sf6
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getVisibility();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sf6
    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.sf6
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.sf6
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p = 0.0f;
            h(BdUtilHelper.getEquipmentWidth(this.b.getPageActivity()), BdUtilHelper.getEquipmentHeight(this.b.getPageActivity()));
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090592);
            this.c = linearLayout;
            EMManager.from(linearLayout).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0214);
            this.d = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f14);
            this.i = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f15);
            this.g = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f12);
            this.l = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f13);
            this.f = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f10);
            this.k = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f11);
            this.e = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f0c);
            this.j = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f0d);
            this.h = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f0e);
            this.m = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091f0f);
            j();
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.m.setOnClickListener(this);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c08));
            this.g.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c07));
            this.f.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c06));
            this.e.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c04));
            this.h.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c05));
            float f = this.p;
            if (f == 0.0f) {
                this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080c08, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.7777778f) {
                this.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080c07, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.3333334f) {
                this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080c06, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 0.5625f) {
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080c04, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.0f) {
                this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080c05, this.b.getResources().getColor(R.color.CAM_X0302), null));
            }
        }
    }

    public final void h(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            i(this.a);
            if (i != 0 && i2 != 0) {
                float f = i;
                float f2 = i2;
                if ((f * 1.0f) / f2 <= 0.5625f) {
                    this.a = (f2 * 1.0f) / f;
                    SafeHandler.getInst().post(new a(this));
                }
            }
            this.a = 1.7777778f;
            SafeHandler.getInst().post(new a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091f15) {
                reset();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f13) {
                this.p = 1.7777778f;
                i(1.7777778f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f11) {
                this.p = 1.3333334f;
                i(1.3333334f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f0d) {
                this.p = 0.5625f;
                i(0.5625f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f0f) {
                this.p = 1.0f;
                i(1.0f);
            }
        }
    }
}
