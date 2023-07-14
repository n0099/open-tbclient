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
public class wk9 extends rk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public ItemCardView g;
    public ThreadData h;
    public t15 i;
    public ny j;

    /* loaded from: classes8.dex */
    public class a extends t15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk9 a;

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

        public a(wk9 wk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk9Var;
        }

        @Override // com.baidu.tieba.t15
        public ThreadData getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.h;
            }
            return (ThreadData) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk9 a;

        public b(wk9 wk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            wk9 wk9Var;
            xx.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (wk9Var = this.a).c) != null) {
                aVar.a(wk9Var.i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk9(TbPageContext tbPageContext) {
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
            this.h = b2;
            this.i = new a(this);
            ItemCardView itemCardView = this.g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f);
            }
            ny nyVar = this.j;
            if (nyVar != null) {
                nyVar.b(this.i);
            }
        }
    }

    @Override // com.baidu.tieba.rk9
    public void d(xx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            ny nyVar = this.j;
            if (nyVar != null) {
                nyVar.H(aVar);
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
            ny nyVar = this.j;
            if (nyVar != null) {
                nyVar.q(this.b);
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
            if (this.j == null) {
                ny nyVar = new ny(this.a.getPageActivity());
                this.j = nyVar;
                nyVar.t(Boolean.TRUE);
                this.j.setFrom("pb");
                this.j.G(0);
                this.j.M(this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.j.N(false);
                this.j.L(true);
            }
            this.f.addView(this.j.l());
            if (this.g == null) {
                ItemCardView itemCardView = new ItemCardView(this.a.getPageActivity());
                this.g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f.addView(this.g, layoutParams);
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
            ny nyVar = this.j;
            if (nyVar != null) {
                nyVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.g;
            if (itemCardView != null) {
                itemCardView.G();
            }
        }
    }
}
