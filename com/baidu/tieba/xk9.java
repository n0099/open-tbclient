package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xk9 extends rk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public hz g;
    public ItemCardView h;
    public ThreadData i;
    public t15 j;
    public tz k;

    /* loaded from: classes8.dex */
    public class a extends t15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk9 a;

        @Override // com.baidu.tieba.t15
        public s35 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (s35) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.yn
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }

        public a(xk9 xk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk9Var;
        }

        @Override // com.baidu.tieba.t15
        public ThreadData getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.i;
            }
            return (ThreadData) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk9 a;

        public b(xk9 xk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            xk9 xk9Var;
            xx.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (xk9Var = this.a).c) != null) {
                aVar.a(xk9Var.j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk9(TbPageContext tbPageContext) {
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
    }

    @Override // com.baidu.tieba.rk9
    public void c(OriginalThreadInfo originalThreadInfo) {
        ThreadData b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.d = originalThreadInfo;
            if (originalThreadInfo == null) {
                b2 = null;
            } else {
                b2 = originalThreadInfo.b();
            }
            this.i = b2;
            a aVar = new a(this);
            this.j = aVar;
            tz tzVar = this.k;
            if (tzVar != null) {
                tzVar.b(aVar);
            }
            ItemCardView itemCardView = this.h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f);
            }
            hz hzVar = this.g;
            if (hzVar != null) {
                hzVar.b(this.j);
            }
        }
    }

    @Override // com.baidu.tieba.rk9
    public void d(xx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            tz tzVar = this.k;
            if (tzVar != null) {
                tzVar.E(aVar);
            }
            hz hzVar = this.g;
            if (hzVar != null) {
                hzVar.D(aVar);
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.rk9
    public void e(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, up6Var) == null) {
            super.e(up6Var);
            tz tzVar = this.k;
            if (tzVar != null) {
                tzVar.q(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.rk9
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0206);
                this.f.setOrientation(1);
                this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f.removeAllViews();
            if (this.g == null) {
                hz hzVar = new hz(this.a);
                this.g = hzVar;
                hzVar.t(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f.addView(this.g.l(), layoutParams);
            if (this.k == null) {
                tz tzVar = new tz(this.a.getPageActivity());
                this.k = tzVar;
                tzVar.setFrom("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            this.f.addView(this.k.l(), layoutParams2);
            if (this.h == null) {
                this.h = new ItemCardView(this.a.getPageActivity());
            }
            this.h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams3.leftMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.rightMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f.addView(this.h, layoutParams3);
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rk9
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) && this.e != i) {
            this.e = i;
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0206);
            hz hzVar = this.g;
            if (hzVar != null) {
                hzVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.h;
            if (itemCardView != null) {
                itemCardView.G();
            }
            tz tzVar = this.k;
            if (tzVar != null) {
                tzVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
