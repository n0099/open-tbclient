package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nh6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AcceleratorFragment a;

    public nh6(AcceleratorFragment acceleratorFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {acceleratorFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = acceleratorFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (this.a.c != null && this.a.c.getItemData() != null) {
                TbSingleton.getInstance().removeAcceleratorServer(String.valueOf(this.a.c.getItemData().itemId));
            }
            this.a.e2();
            this.a.getActivity().finish();
        }
    }
}
