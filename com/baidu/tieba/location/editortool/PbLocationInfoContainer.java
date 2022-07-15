package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j15;
import com.repackage.pi;
import com.repackage.uu4;
import com.repackage.v15;
import com.repackage.xt4;
import com.repackage.z25;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, v15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public EditorTools c;
    public int d;
    public boolean e;

    /* loaded from: classes3.dex */
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
                boolean z = !((Boolean) this.a.b.a).booleanValue();
                xt4.k().u("key_virtual_image_and_state_ying_has_show", z);
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
        this.d = 0;
        this.e = true;
        d();
    }

    @Override // com.repackage.k15
    public void C(j15 j15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || j15Var == null) {
            return;
        }
        int i = j15Var.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            } else if (i == 68) {
                xt4.k().u("key_virtual_image_and_state_has_show", false);
                f(false);
                return;
            } else {
                return;
            }
        }
        Object obj = j15Var.c;
        if (obj == null) {
            hide();
            return;
        }
        z25 z25Var = (z25) obj;
        if (z25Var.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a42));
        } else if (!TextUtils.isEmpty(z25Var.b)) {
            this.a.setText(z25Var.b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
        }
    }

    @Override // com.repackage.v15
    public void L(j15 j15Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j15Var) == null) || (editorTools = this.c) == null) {
            return;
        }
        editorTools.A(j15Var);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.l(i);
            this.b.l(i);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setGravity(16);
            setOrientation(0);
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, pi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cd));
            layoutParams.setMargins(0, pi.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, pi.f(getContext(), R.dimen.obfuscated_res_0x7f07023d));
            setLayoutParams(layoutParams);
            uu4 uu4Var = new uu4();
            uu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            uu4Var.h(R.color.CAM_X0110);
            uu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            uu4Var.m(pi.f(getContext(), R.dimen.M_W_X004), pi.f(getContext(), R.dimen.M_W_X004));
            uu4Var.n(pi.f(getContext(), R.dimen.M_H_X002));
            uu4Var.i(R.drawable.obfuscated_res_0x7f0805fa, 0, TBSpecificationButtonConfig.IconType.WEBP);
            uu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(uu4Var);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
            addView(this.a, new LinearLayout.LayoutParams(-2, pi.f(getContext(), R.dimen.tbds63)));
            e(getContext());
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            uu4 uu4Var = new uu4();
            uu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            uu4Var.h(R.color.CAM_X0302);
            uu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            uu4Var.m(pi.f(getContext(), R.dimen.M_W_X004), pi.f(getContext(), R.dimen.M_W_X004));
            uu4Var.n(pi.f(getContext(), R.dimen.M_H_X002));
            uu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(uu4Var);
            this.b.setTextSize(R.dimen.T_X09);
            boolean h = xt4.k().h("key_virtual_image_and_state_ying_has_show", true);
            if (!h) {
                f(h);
            } else {
                f(h);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, pi.f(getContext(), R.dimen.tbds63));
            layoutParams.setMargins(pi.f(context, R.dimen.M_W_X007), 0, pi.f(context, R.dimen.M_W_X007), 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new a(this));
            addView(this.b);
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.b.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1190));
            this.b.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f080977 : R.drawable.obfuscated_res_0x7f080976, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.b.a = Boolean.valueOf(z);
            L(new j15(67, -1, Boolean.valueOf(z)));
        }
    }

    @Override // com.repackage.v15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.repackage.v15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
        }
    }

    @Override // com.repackage.v15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.repackage.v15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            c(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 == this.a) {
            L(new j15(18, -1, null));
        }
    }

    @Override // com.repackage.v15
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e) {
            this.e = false;
            L(new j15(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.repackage.v15
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    @Override // com.repackage.v15
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }
}
