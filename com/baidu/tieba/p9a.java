package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class p9a extends nl6<f9a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public LinearLayout j;
    public LinearLayout k;
    public AutoBannerView l;
    public View m;
    public View n;
    public f35<o8a> o;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d080a : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f35<o8a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p9a a;

        public a(p9a p9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p9aVar;
        }

        @Override // com.baidu.tieba.f35
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && this.a.l != null && str != null) {
                TiebaStatic.log(new StatisticItem("c13247").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_param1", str));
                this.a.l.f();
                this.a.l.b(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f35
        /* renamed from: c */
        public void a(int i, o8a o8aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, o8aVar) == null) && this.a.l != null && o8aVar != null && o8aVar.a() != null && this.a.l.a(i)) {
                TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_param1", o8aVar.a()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p9a(TbPageContext<?> tbPageContext) {
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
        this.i = 3;
        this.o = new a(this);
        this.n = i();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.n.setPadding(dimens, 0, dimens, 0);
        this.j = (LinearLayout) this.n.findViewById(R.id.obfuscated_res_0x7f092a75);
        this.k = (LinearLayout) this.n.findViewById(R.id.obfuscated_res_0x7f0916fd);
        AutoBannerView autoBannerView = (AutoBannerView) this.n.findViewById(R.id.obfuscated_res_0x7f091c8c);
        this.l = autoBannerView;
        autoBannerView.getCoverFlowView().setAutoPlay(false);
        this.l.setMarqueenTime(3000L);
        this.l.getCoverFlowView().setCallback(this.o);
        this.m = this.n.findViewById(R.id.obfuscated_res_0x7f090437);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || this.l.getCoverFlowView() == null) {
            return;
        }
        if (z) {
            this.l.getCoverFlowView().o();
        } else {
            this.l.getCoverFlowView().D();
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            r(z);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.i != i) {
            AutoBannerView autoBannerView = this.l;
            if (autoBannerView != null) {
                autoBannerView.e(i);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            this.i = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: s */
    public void j(f9a f9aVar) {
        List<o8a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f9aVar) == null) {
            k(this.b, TbadkCoreApplication.getInst().getSkinType());
            if (this.j == null || f9aVar == null || (list = f9aVar.a) == null || this.l == null || list.size() == 0) {
                return;
            }
            this.l.d(f9aVar.a);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r(false);
        }
    }
}
