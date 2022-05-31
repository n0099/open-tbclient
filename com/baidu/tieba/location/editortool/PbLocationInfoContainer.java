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
import com.repackage.f05;
import com.repackage.j15;
import com.repackage.li;
import com.repackage.ot4;
import com.repackage.sz4;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, f05 {
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
        b();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.l(i);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setGravity(16);
            setOrientation(0);
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ce));
            layoutParams.setMargins(0, li.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, li.f(getContext(), R.dimen.obfuscated_res_0x7f07023e));
            setLayoutParams(layoutParams);
            ot4 ot4Var = new ot4();
            ot4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ot4Var.h(R.color.CAM_X0110);
            ot4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ot4Var.m(li.f(getContext(), R.dimen.M_W_X004), li.f(getContext(), R.dimen.M_W_X004));
            ot4Var.n(li.f(getContext(), R.dimen.M_H_X002));
            ot4Var.i(R.drawable.obfuscated_res_0x7f0805fc, 0, TBSpecificationButtonConfig.IconType.WEBP);
            ot4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ot4Var);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a57));
            addView(this.a, new LinearLayout.LayoutParams(-2, li.f(getContext(), R.dimen.tbds63)));
        }
    }

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d) {
            this.d = false;
            g(new sz4(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sz4Var) == null) || (editorTools = this.b) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a57));
        }
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i = sz4Var.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = sz4Var.c;
        if (obj == null) {
            hide();
            return;
        }
        j15 j15Var = (j15) obj;
        if (j15Var.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a51));
        } else if (!TextUtils.isEmpty(j15Var.b)) {
            this.a.setText(j15Var.b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a57));
        }
    }

    @Override // com.repackage.f05
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
            g(new sz4(18, -1, null));
        }
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.b = editorTools;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.c = i;
        }
    }
}
