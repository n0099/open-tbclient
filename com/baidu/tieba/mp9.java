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
import com.baidu.tieba.ax;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mp9 extends hp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public ItemCardView g;
    public ThreadData h;
    public b15 i;
    public qx j;

    /* loaded from: classes7.dex */
    public class a extends b15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp9 a;

        @Override // com.baidu.tieba.b15
        public NegativeFeedBackData getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (NegativeFeedBackData) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.cn
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }

        public a(mp9 mp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp9Var;
        }

        @Override // com.baidu.tieba.b15
        public ThreadData getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.h;
            }
            return (ThreadData) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp9 a;

        public b(mp9 mp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mp9 mp9Var;
            ax.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (mp9Var = this.a).c) != null) {
                aVar.a(mp9Var.i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp9(TbPageContext tbPageContext) {
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

    @Override // com.baidu.tieba.hp9
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
            qx qxVar = this.j;
            if (qxVar != null) {
                qxVar.onBindDataToView(this.i);
            }
        }
    }

    @Override // com.baidu.tieba.hp9
    public void d(ax.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            qx qxVar = this.j;
            if (qxVar != null) {
                qxVar.F(aVar);
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.hp9
    public void e(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mp6Var) == null) {
            super.e(mp6Var);
            qx qxVar = this.j;
            if (qxVar != null) {
                qxVar.o(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.hp9
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
                qx qxVar = new qx(this.a.getPageActivity());
                this.j = qxVar;
                qxVar.r(Boolean.TRUE);
                this.j.setFrom("pb");
                this.j.E(0);
                this.j.J(this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.j.K(false);
                this.j.I(true);
            }
            this.f.addView(this.j.j());
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

    @Override // com.baidu.tieba.hp9
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) && this.e != i) {
            this.e = i;
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0206);
            qx qxVar = this.j;
            if (qxVar != null) {
                qxVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.g;
            if (itemCardView != null) {
                itemCardView.M();
            }
        }
    }
}
