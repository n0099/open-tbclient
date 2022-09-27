package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class jm7 extends p9<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ViewGroup b;
    public GridView c;
    public View d;
    public im7 e;
    public BubbleChooseActivity f;
    public ProgressBar g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm7(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f = orignalPage;
        orignalPage.setContentView(R.layout.obfuscated_res_0x7f0d0164);
        NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f09126a);
        this.a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.setTitleText(R.string.obfuscated_res_0x7f0f054a);
        this.d = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0165, this.f);
        this.b = (ViewGroup) this.f.findViewById(R.id.obfuscated_res_0x7f0906d3);
        this.c = (GridView) this.f.findViewById(R.id.obfuscated_res_0x7f090d13);
        im7 im7Var = new im7(tbPageContext);
        this.e = im7Var;
        this.c.setAdapter((ListAdapter) im7Var);
        this.g = (ProgressBar) this.f.findViewById(R.id.obfuscated_res_0x7f090479);
    }

    public im7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (im7) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public GridView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (GridView) invokeV.objValue;
    }

    public BubbleListData.BubbleData m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            im7 im7Var = this.e;
            if (im7Var == null) {
                return null;
            }
            return im7Var.getItem(i);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.setVisibility(8);
        }
    }

    public void o(List<BubbleListData.BubbleData> list, boolean z) {
        im7 im7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) || (im7Var = this.e) == null) {
            return;
        }
        im7Var.d(z);
        this.e.c(list);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.onChangeSkinType((TbPageContext) getPageContext(), i);
            this.f.getLayoutMode().l(i == 1);
            this.f.getLayoutMode().k(this.b);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.setVisibility(0);
        }
    }
}
