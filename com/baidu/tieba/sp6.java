package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.gamepaltform.GameRankListViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sp6 extends gj6<ox6, GameRankListViewHolder> implements eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu6 l;

    /* loaded from: classes5.dex */
    public class a implements GameRankHorizontalLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp6 a;

        public a(sp6 sp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp6Var;
        }

        @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.b
        public void a(nx6 nx6Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, nx6Var, i) != null) || nx6Var == null) {
                return;
            }
            if (this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c12105").param("fid", this.a.l.c).param("obj_locate", i + 1));
            }
            if (!StringUtils.isNull(nx6Var.c())) {
                sp4.o(this.a.c.getPageActivity(), nx6Var.c());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sp6 sp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                py4 k = py4.k();
                k.y("game_rank_list_info", System.currentTimeMillis() + ",7");
                py4.k().w("game_rank_list_show_times", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sp6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new cu6();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: G */
    public GameRankListViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new GameRankListViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0376, (ViewGroup) null));
        }
        return (GameRankListViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gj6, com.baidu.tieba.kn
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ox6 ox6Var, GameRankListViewHolder gameRankListViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ox6Var, gameRankListViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, ox6Var, gameRankListViewHolder);
            if (ox6Var == null) {
                return null;
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            if (this.l != null) {
                TiebaStatic.log(new StatisticItem("c12104").param("fid", this.l.c));
            }
            GameRankHorizontalLayout gameRankHorizontalLayout = gameRankListViewHolder.a;
            if (gameRankHorizontalLayout != null) {
                gameRankHorizontalLayout.setData(ox6Var);
                gameRankListViewHolder.a.setOnCardClickListener(new a(this));
            }
            TextView textView = gameRankListViewHolder.b;
            if (textView != null) {
                textView.setOnClickListener(new b(this));
            }
            rq4 layoutMode = this.c.getLayoutMode();
            boolean z = true;
            if (this.f != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.c.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.eu6
    public cu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (cu6) invokeV.objValue;
    }
}
