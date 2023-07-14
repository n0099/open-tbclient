package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zk9 extends rk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout f;
    public t15 g;
    public hz h;
    public tz i;
    public ThreadData j;
    public VoteView k;

    /* loaded from: classes8.dex */
    public class a extends t15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk9 a;

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

        public a(zk9 zk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk9Var;
        }

        @Override // com.baidu.tieba.t15
        public ThreadData getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.j;
            }
            return (ThreadData) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk9 a;

        public b(zk9 zk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            zk9 zk9Var;
            xx.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (zk9Var = this.a).c) != null) {
                aVar.a(zk9Var.g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk9(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rk9
    public void d(xx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            tz tzVar = this.i;
            if (tzVar != null) {
                tzVar.E(aVar);
            }
            hz hzVar = this.h;
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
            tz tzVar = this.i;
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
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f.setOrientation(1);
                this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f.removeAllViews();
            if (this.h == null) {
                hz hzVar = new hz(this.a);
                this.h = hzVar;
                hzVar.t(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f.addView(this.h.l(), layoutParams);
            if (this.i == null) {
                tz tzVar = new tz(this.a.getPageActivity());
                this.i = tzVar;
                tzVar.setFrom("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.f.addView(this.i.l(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f.addView(this.k, layoutParams3);
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
            hz hzVar = this.h;
            if (hzVar != null) {
                hzVar.onChangeSkinType(tbPageContext, i);
            }
            tz tzVar = this.i;
            if (tzVar != null) {
                tzVar.onChangeSkinType(tbPageContext, i);
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
            this.j = b2;
            a aVar = new a(this);
            this.g = aVar;
            tz tzVar = this.i;
            if (tzVar != null) {
                tzVar.b(aVar);
            }
            hz hzVar = this.h;
            if (hzVar != null) {
                hzVar.b(this.g);
            }
            PollData pollData = this.d.G;
            if (pollData != null && pollData.getOptions() != null && this.d.G.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.d;
                voteView.setData(originalThreadInfo2.G, originalThreadInfo2.f, originalThreadInfo2.e);
                this.k.setVisibility(0);
                return;
            }
            this.f.removeView(this.k);
        }
    }
}
