package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rs9 extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundLinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TbPageContext f;
    public TextView g;
    public TextView h;
    public TextView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs9(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = tbPageContext;
        D(tbPageContext, onClickListener);
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void D(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, onClickListener) == null) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07f8, (ViewGroup) null);
            this.a = roundLinearLayout;
            roundLinearLayout.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c3d);
            this.b = textView;
            textView.setOnClickListener(onClickListener);
            TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c3f);
            this.c = textView2;
            textView2.setOnClickListener(onClickListener);
            TextView textView3 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c3b);
            this.d = textView3;
            textView3.setOnClickListener(onClickListener);
            TextView textView4 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c3e);
            this.e = textView4;
            textView4.setOnClickListener(onClickListener);
            TextView textView5 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c3c);
            this.g = textView5;
            textView5.setOnClickListener(onClickListener);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c40);
            TextView textView6 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091c39);
            this.i = textView6;
            textView6.setOnClickListener(onClickListener);
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e.setVisibility(0);
            if (i == 0) {
                this.e.setText(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0d18));
            } else if (i == 1) {
                this.e.setText(this.f.getResources().getString(R.string.un_mute));
            }
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(0);
            this.h.setText(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0cb7), str));
        }
    }

    public void F(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.b.setText(R.string.obfuscated_res_0x7f0f123a);
            } else {
                this.b.setText(R.string.frs_recommend_friend_item_add);
            }
            if (z2) {
                this.d.setText(R.string.obfuscated_res_0x7f0f1234);
            } else {
                this.d.setText(R.string.obfuscated_res_0x7f0f0361);
            }
            if (z3) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0211);
            SkinManager.setViewTextColorSelector(this.d, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.b, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.c, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0105);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
        }
    }
}
