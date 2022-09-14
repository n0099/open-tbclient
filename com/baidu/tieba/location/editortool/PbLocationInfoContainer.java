package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.ay4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.ej;
import com.baidu.tieba.g55;
import com.baidu.tieba.u45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, g55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public EditorTools b;
    public int c;
    public boolean d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        public a(PbLocationInfoContainer pbLocationInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLocationInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLocationInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.a.a).booleanValue();
                bx4.k().u("key_virtual_image_and_state_ying_has_show", z);
                this.a.f(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = true;
        d();
    }

    @Override // com.baidu.tieba.v45
    public void B(u45 u45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, u45Var) == null) && u45Var != null && u45Var.a == 68) {
            bx4.k().u("key_virtual_image_and_state_has_show", false);
            f(false);
        }
    }

    @Override // com.baidu.tieba.g55
    public void K(u45 u45Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u45Var) == null) || (editorTools = this.b) == null) {
            return;
        }
        editorTools.A(u45Var);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.l(i);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(16);
            setOrientation(0);
            e(getContext());
        }
    }

    @Override // com.baidu.tieba.g55
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.d) {
            this.d = false;
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ay4Var.h(R.color.CAM_X0302);
            ay4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ay4Var.m(ej.f(getContext(), R.dimen.M_W_X004), ej.f(getContext(), R.dimen.M_W_X004));
            ay4Var.n(ej.f(getContext(), R.dimen.M_H_X002));
            ay4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.a.setTextSize(R.dimen.T_X09);
            boolean h = bx4.k().h("key_virtual_image_and_state_ying_has_show", true);
            if (!h) {
                f(h);
            } else {
                f(h);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.f(getContext(), R.dimen.tbds63));
            layoutParams.setMargins(0, 0, ej.f(context, R.dimen.M_W_X007), 0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(new a(this));
            addView(this.a);
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f119b));
            this.a.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f0809b4 : R.drawable.obfuscated_res_0x7f0809b3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.a.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.a.a = Boolean.valueOf(z);
            K(new u45(67, -1, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.tieba.g55
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : invokeV.intValue;
    }

    @Override // com.baidu.tieba.g55
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.g55
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.g55
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            c(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.g55
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.b = editorTools;
        }
    }

    @Override // com.baidu.tieba.g55
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.c = i;
        }
    }
}
