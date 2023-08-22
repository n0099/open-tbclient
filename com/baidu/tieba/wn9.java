package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wn9 extends qn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public iy g;
    public ItemCardView h;
    public ThreadData i;
    public w05 j;
    public uy k;

    /* loaded from: classes8.dex */
    public class a extends w05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn9 a;

        @Override // com.baidu.tieba.w05
        public NegativeFeedBackData getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (NegativeFeedBackData) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.bn
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }

        public a(wn9 wn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn9Var;
        }

        @Override // com.baidu.tieba.w05
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
        public final /* synthetic */ wn9 a;

        public b(wn9 wn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            wn9 wn9Var;
            zw.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (wn9Var = this.a).c) != null) {
                aVar.a(wn9Var.j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn9(TbPageContext tbPageContext) {
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

    @Override // com.baidu.tieba.qn9
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
            uy uyVar = this.k;
            if (uyVar != null) {
                uyVar.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f);
            }
            iy iyVar = this.g;
            if (iyVar != null) {
                iyVar.onBindDataToView(this.j);
            }
        }
    }

    @Override // com.baidu.tieba.qn9
    public void d(zw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            uy uyVar = this.k;
            if (uyVar != null) {
                uyVar.D(aVar);
            }
            iy iyVar = this.g;
            if (iyVar != null) {
                iyVar.C(aVar);
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.qn9
    public void e(jo6 jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jo6Var) == null) {
            super.e(jo6Var);
            uy uyVar = this.k;
            if (uyVar != null) {
                uyVar.p(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.qn9
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
                iy iyVar = new iy(this.a);
                this.g = iyVar;
                iyVar.s(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f.addView(this.g.k(), layoutParams);
            if (this.k == null) {
                uy uyVar = new uy(this.a.getPageActivity());
                this.k = uyVar;
                uyVar.setFrom("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            this.f.addView(this.k.k(), layoutParams2);
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

    @Override // com.baidu.tieba.qn9
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) && this.e != i) {
            this.e = i;
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0206);
            iy iyVar = this.g;
            if (iyVar != null) {
                iyVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.h;
            if (itemCardView != null) {
                itemCardView.N();
            }
            uy uyVar = this.k;
            if (uyVar != null) {
                uyVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
