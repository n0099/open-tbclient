package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ty6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public RankListViewController.RankListViewHolder c;
    public TextView d;
    public TextView e;
    public String f;
    public int g;
    public View.OnClickListener h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty6 a;

        public a(ty6 ty6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ty6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TextUtils.isEmpty(this.a.f)) {
                    this.a.a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.f});
                if (this.a.g == 0) {
                    return;
                }
                if (this.a.g == 2) {
                    StatisticItem statisticItem = new StatisticItem("c13658");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem);
                } else if (this.a.g == 1) {
                    StatisticItem statisticItem2 = new StatisticItem("c13669");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    public ty6(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = tbPageContext;
        this.b = view2;
        RankListViewController.RankListViewHolder rankListViewHolder = new RankListViewController.RankListViewHolder(view2.findViewById(R.id.obfuscated_res_0x7f09285a));
        this.c = rankListViewHolder;
        rankListViewHolder.m(1);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e1d);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e11);
        this.e = textView;
        textView.setTextSize(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbfontsize46));
        this.d.setOnClickListener(this.h);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.j(i);
            SkinManager.setBackgroundColor(this.c.itemView, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.g = i;
        }
    }

    public void e(wy6 wy6Var) {
        vy6 vy6Var;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy6Var) == null) {
            if (wy6Var != null && (vy6Var = wy6Var.c) != null && (metaData = vy6Var.f) != null && !metaData.isMask && TbadkCoreApplication.isLogin()) {
                this.b.setVisibility(0);
                this.c.f(wy6Var.c);
                this.c.i();
                this.f = wy6Var.e;
                return;
            }
            this.b.setVisibility(8);
        }
    }
}
