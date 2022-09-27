package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class yx5 extends i16<ThreadData> implements g26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public RelativeLayout j;
    public ThreadData k;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public final View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx5 a;

        public a(yx5 yx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k == null || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.k);
            TiebaStatic.log(new StatisticItem("c11844").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.k.getFid()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx5(TbPageContext<?> tbPageContext) {
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
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.i = tbPageContext;
        View h = h();
        this.l = h.findViewById(R.id.obfuscated_res_0x7f0907f9);
        this.m = h.findViewById(R.id.obfuscated_res_0x7f091ba8);
        this.n = h.findViewById(R.id.obfuscated_res_0x7f091baa);
        this.j = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f0901e9);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0901fe);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091f77);
        this.r = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f0901c4);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09022b);
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d02fa : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.p, R.drawable.ala_live_card_start_live_selector);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: s */
    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.k.hasRecommend) {
                this.q.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
                layoutParams.height = ej.i(this.i.getPageActivity()) / 4;
                this.r.setLayoutParams(layoutParams);
            } else {
                this.q.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = this.r.getLayoutParams();
                layoutParams2.height = this.i.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201);
                this.r.setLayoutParams(layoutParams2);
            }
            j(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.p.setOnClickListener(this.s);
        }
    }
}
