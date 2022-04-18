package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.i05;
import com.repackage.lu4;
import com.repackage.oi;
import com.repackage.v05;
import com.repackage.y15;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, v05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public EditorTools b;
    public int c;
    public boolean d;

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
        c();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.l(i);
        }
    }

    @Override // com.repackage.v05
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.d) {
            this.d = false;
            d(new i05(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setGravity(16);
            setOrientation(0);
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, oi.f(getContext(), R.dimen.obfuscated_res_0x7f0702ce));
            layoutParams.setMargins(0, oi.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, oi.f(getContext(), R.dimen.obfuscated_res_0x7f07023e));
            setLayoutParams(layoutParams);
            lu4 lu4Var = new lu4();
            lu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            lu4Var.h(R.color.CAM_X0110);
            lu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            lu4Var.m(oi.f(getContext(), R.dimen.M_W_X004), oi.f(getContext(), R.dimen.M_W_X004));
            lu4Var.n(oi.f(getContext(), R.dimen.M_H_X002));
            lu4Var.i(R.drawable.obfuscated_res_0x7f08060f, 0, TBSpecificationButtonConfig.IconType.WEBP);
            lu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(lu4Var);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a4a));
            addView(this.a, new LinearLayout.LayoutParams(-2, oi.f(getContext(), R.dimen.tbds63)));
        }
    }

    @Override // com.repackage.v05
    public void d(i05 i05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, i05Var) == null) || (editorTools = this.b) == null) {
            return;
        }
        editorTools.A(i05Var);
    }

    @Override // com.repackage.v05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    @Override // com.repackage.v05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a4a));
        }
    }

    @Override // com.repackage.v05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, i05Var) == null) || i05Var == null) {
            return;
        }
        int i = i05Var.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = i05Var.c;
        if (obj == null) {
            hide();
            return;
        }
        y15 y15Var = (y15) obj;
        if (y15Var.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a44));
        } else if (!TextUtils.isEmpty(y15Var.b)) {
            this.a.setText(y15Var.b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a4a));
        }
    }

    @Override // com.repackage.v05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            a(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view2) == null) && view2 == this.a) {
            d(new i05(18, -1, null));
        }
    }

    @Override // com.repackage.v05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.b = editorTools;
        }
    }

    @Override // com.repackage.v05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.c = i;
        }
    }
}
