package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.ux;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mz extends by {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout h;
    public BjhArticleLayout i;
    public h15 j;
    public int k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz a;

        public a(mz mzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mzVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mz mzVar;
            ux.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (mzVar = this.a).e) != null) {
                aVar.a(mzVar.j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 3;
    }

    public void A(ux.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.e = aVar;
        }
    }

    @Override // com.baidu.tieba.ux
    public void p(go6<h15> go6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, go6Var) == null) {
            super.p(go6Var);
            BjhArticleLayout bjhArticleLayout = this.i;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.setSubClickListener(go6Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oy
    /* renamed from: z */
    public void a(h15 h15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h15Var) == null) {
            this.j = h15Var;
            BjhArticleLayout bjhArticleLayout = this.i;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.a(h15Var);
            }
        }
    }

    @Override // com.baidu.tieba.ux
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h == null) {
                LinearLayout linearLayout = new LinearLayout(this.b);
                this.h = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.h.setOrientation(1);
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.h.removeAllViews();
            if (this.i == null) {
                BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.b);
                this.i = bjhArticleLayout;
                bjhArticleLayout.setJumpToPbListener(new a(this));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
            this.h.addView(this.i, layoutParams);
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && i != this.k) {
            this.k = i;
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0206);
            BjhArticleLayout bjhArticleLayout = this.i;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}
