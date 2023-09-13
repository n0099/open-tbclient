package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wn5 extends qn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public TBSpecificationBtn d;
    public LinearLayout e;
    public int f;
    public int g;
    public int h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276363, "Lcom/baidu/tieba/wn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276363, "Lcom/baidu/tieba/wn5;");
                return;
            }
        }
        j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn5(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        oa5 oa5Var = new oa5();
        oa5Var.s(R.color.CAM_X0905, R.color.CAM_X0304);
        this.d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.d.setTextSize(R.dimen.T_X05);
        this.d.setConfig(oa5Var);
        this.f = R.drawable.new_pic_emotion_08;
        this.g = R.color.CAM_X0107;
        this.h = R.color.CAM_X0109;
        this.d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = 8;
            if (this.d.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = k;
                    this.e.setLayoutParams(marginLayoutParams);
                }
                if (!this.i && (this.b.getText() == null || this.b.getText().length() <= 0)) {
                    z = false;
                } else {
                    z = true;
                }
                TextView textView = this.b;
                if (z) {
                    i = 0;
                }
                textView.setVisibility(i);
                this.g = R.color.CAM_X0107;
            } else if (this.b.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = k;
                    this.e.setLayoutParams(marginLayoutParams2);
                }
                this.g = R.color.CAM_X0107;
            } else if (this.c.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.e.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = m;
                    this.e.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.c.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = n;
                    this.c.setLayoutParams(marginLayoutParams4);
                }
                this.g = R.color.CAM_X0107;
                this.h = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.a.getLayoutParams();
                int i2 = j;
                layoutParams5.width = i2;
                layoutParams5.height = i2;
                this.a.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.e.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = l;
                    this.e.setLayoutParams(marginLayoutParams5);
                }
                this.h = R.color.CAM_X0109;
            }
            onChangeSkinType();
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0109, 1);
            a();
        }
    }

    public View getAttachedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.attachedView;
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d.setVisibility(0);
            this.c.setVisibility(0);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0109, 1);
            a();
        }
    }

    @Override // com.baidu.tieba.qn5
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.qn5
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setBackgroundColor(this.attachedView, i);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || str == null) {
            return;
        }
        this.d.setText(str);
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
            SkinManager.setImageResource(this.a, i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f = i;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i = z;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.b.setText(str);
            }
            a();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || str == null) {
            return;
        }
        this.c.setText(str);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || str == null) {
            return;
        }
        this.c.setText(str);
        this.c.setVisibility(0);
        a();
    }

    public void k(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            if (equipmentHeight <= 0) {
                i2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
            } else {
                i2 = (int) (equipmentHeight * 0.16d);
            }
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2 + i;
                this.a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0202);
            WebPManager.setMaskDrawable(this.a, this.f, null);
            SkinManager.setViewTextColor(this.b, this.h, 1, skinType);
            SkinManager.setViewTextColor(this.c, this.g, 1, skinType);
            TBSpecificationBtn tBSpecificationBtn = this.d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }
}
