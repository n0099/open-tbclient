package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class yd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public ba9 b;
    public View c;
    public View d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public Button i;

    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(yd9 yd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public yd9(PbFragment pbFragment, ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ba9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = pbFragment;
        this.b = ba9Var;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.c);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.i;
            if (button != null && button.getVisibility() == 0) {
                View view2 = this.f;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                z2 = true;
            } else {
                View view3 = this.f;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                z2 = false;
            }
            View view4 = this.h;
            if ((view4 == null || view4.getVisibility() == 8) && z2 && z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public void g(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u89Var) == null) {
            ArrayList<m15> actDatas = u89Var.N().getActDatas();
            if (actDatas != null && actDatas.size() > 0) {
                this.e.setText(String.valueOf(actDatas.get(0).f()));
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0305, 1);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06e3, (ViewGroup) null);
            this.c = inflate;
            inflate.setOnTouchListener(this.b);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091a94);
            this.d = findViewById;
            findViewById.setVisibility(8);
            this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a93);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f0918ed);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f0918ee);
            this.c.setOnLongClickListener(new a(this));
        }
    }

    public void h(u89 u89Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, u89Var, z) == null) {
            boolean b = b(z);
            if (u89Var != null && u89Var.y() != null && u89Var.y().c() == 0 && z) {
                if (b) {
                    this.g.setVisibility(0);
                    return;
                } else {
                    this.g.setVisibility(8);
                    return;
                }
            }
            this.g.setVisibility(8);
        }
    }
}
