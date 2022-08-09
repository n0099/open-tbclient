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
import com.repackage.h25;
import com.repackage.pv4;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.t25;
import com.repackage.w35;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, t25 {
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
                ru4.k().u("key_virtual_image_and_state_ying_has_show", z);
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

    @Override // com.repackage.i25
    public void A(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) || h25Var == null) {
            return;
        }
        int i = h25Var.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            } else if (i == 68) {
                ru4.k().u("key_virtual_image_and_state_has_show", false);
                f(false);
                return;
            } else {
                return;
            }
        }
        Object obj = h25Var.c;
        if (obj == null) {
            hide();
            return;
        }
        w35 w35Var = (w35) obj;
        if (w35Var.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a52));
        } else if (!TextUtils.isEmpty(w35Var.b)) {
            this.a.setText(w35Var.b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
        }
    }

    @Override // com.repackage.t25
    public void J(h25 h25Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h25Var) == null) || (editorTools = this.c) == null) {
            return;
        }
        editorTools.A(h25Var);
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
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb));
            layoutParams.setMargins(0, qi.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, qi.f(getContext(), R.dimen.obfuscated_res_0x7f07023b));
            setLayoutParams(layoutParams);
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            pv4Var.h(R.color.CAM_X0110);
            pv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            pv4Var.m(qi.f(getContext(), R.dimen.M_W_X004), qi.f(getContext(), R.dimen.M_W_X004));
            pv4Var.n(qi.f(getContext(), R.dimen.M_H_X002));
            pv4Var.i(R.drawable.obfuscated_res_0x7f0805ff, 0, TBSpecificationButtonConfig.IconType.WEBP);
            pv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(pv4Var);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
            addView(this.a, new LinearLayout.LayoutParams(-2, qi.f(getContext(), R.dimen.tbds63)));
            e(getContext());
        }
    }

    @Override // com.repackage.t25
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e) {
            this.e = false;
            J(new h25(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            pv4Var.h(R.color.CAM_X0302);
            pv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            pv4Var.m(qi.f(getContext(), R.dimen.M_W_X004), qi.f(getContext(), R.dimen.M_W_X004));
            pv4Var.n(qi.f(getContext(), R.dimen.M_H_X002));
            pv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(pv4Var);
            this.b.setTextSize(R.dimen.T_X09);
            boolean h = ru4.k().h("key_virtual_image_and_state_ying_has_show", true);
            if (!h) {
                f(h);
            } else {
                f(h);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, qi.f(getContext(), R.dimen.tbds63));
            layoutParams.setMargins(qi.f(context, R.dimen.M_W_X007), 0, qi.f(context, R.dimen.M_W_X007), 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new a(this));
            addView(this.b);
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1179));
            this.b.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f080997 : R.drawable.obfuscated_res_0x7f080996, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.b.a = Boolean.valueOf(z);
            J(new h25(67, -1, Boolean.valueOf(z)));
        }
    }

    @Override // com.repackage.t25
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.repackage.t25
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
        }
    }

    @Override // com.repackage.t25
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.repackage.t25
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            c(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && view2 == this.a) {
            J(new h25(18, -1, null));
        }
    }

    @Override // com.repackage.t25
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    @Override // com.repackage.t25
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }
}
