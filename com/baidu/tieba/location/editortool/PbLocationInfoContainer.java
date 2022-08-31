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
import com.baidu.tieba.a45;
import com.baidu.tieba.l25;
import com.baidu.tieba.qv4;
import com.baidu.tieba.ri;
import com.baidu.tieba.su4;
import com.baidu.tieba.x25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, x25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public EditorTools c;
    public int d;
    public boolean e;

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
                boolean z = !((Boolean) this.a.b.a).booleanValue();
                su4.k().u("key_virtual_image_and_state_ying_has_show", z);
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

    @Override // com.baidu.tieba.m25
    public void A(l25 l25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, l25Var) == null) || l25Var == null) {
            return;
        }
        int i = l25Var.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            } else if (i == 68) {
                su4.k().u("key_virtual_image_and_state_has_show", false);
                f(false);
                return;
            } else {
                return;
            }
        }
        Object obj = l25Var.c;
        if (obj == null) {
            hide();
            return;
        }
        a45 a45Var = (a45) obj;
        if (a45Var.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a56));
        } else if (!TextUtils.isEmpty(a45Var.b)) {
            this.a.setText(a45Var.b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a5c));
        }
    }

    @Override // com.baidu.tieba.x25
    public void J(l25 l25Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l25Var) == null) || (editorTools = this.c) == null) {
            return;
        }
        editorTools.A(l25Var);
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
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, ri.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb));
            layoutParams.setMargins(0, ri.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, ri.f(getContext(), R.dimen.obfuscated_res_0x7f07023b));
            setLayoutParams(layoutParams);
            qv4 qv4Var = new qv4();
            qv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            qv4Var.h(R.color.CAM_X0110);
            qv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            qv4Var.m(ri.f(getContext(), R.dimen.M_W_X004), ri.f(getContext(), R.dimen.M_W_X004));
            qv4Var.n(ri.f(getContext(), R.dimen.M_H_X002));
            qv4Var.i(R.drawable.obfuscated_res_0x7f080600, 0, TBSpecificationButtonConfig.IconType.WEBP);
            qv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(qv4Var);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a5c));
            addView(this.a, new LinearLayout.LayoutParams(-2, ri.f(getContext(), R.dimen.tbds63)));
            e(getContext());
        }
    }

    @Override // com.baidu.tieba.x25
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e) {
            this.e = false;
            J(new l25(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            qv4 qv4Var = new qv4();
            qv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            qv4Var.h(R.color.CAM_X0302);
            qv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            qv4Var.m(ri.f(getContext(), R.dimen.M_W_X004), ri.f(getContext(), R.dimen.M_W_X004));
            qv4Var.n(ri.f(getContext(), R.dimen.M_H_X002));
            qv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(qv4Var);
            this.b.setTextSize(R.dimen.T_X09);
            boolean h = su4.k().h("key_virtual_image_and_state_ying_has_show", true);
            if (!h) {
                f(h);
            } else {
                f(h);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ri.f(getContext(), R.dimen.tbds63));
            layoutParams.setMargins(ri.f(context, R.dimen.M_W_X007), 0, ri.f(context, R.dimen.M_W_X007), 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new a(this));
            addView(this.b);
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f117e));
            this.b.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f080999 : R.drawable.obfuscated_res_0x7f080998, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.b.a = Boolean.valueOf(z);
            J(new l25(67, -1, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.tieba.x25
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.baidu.tieba.x25
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a5c));
        }
    }

    @Override // com.baidu.tieba.x25
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.x25
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
            J(new l25(18, -1, null));
        }
    }

    @Override // com.baidu.tieba.x25
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    @Override // com.baidu.tieba.x25
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }
}
