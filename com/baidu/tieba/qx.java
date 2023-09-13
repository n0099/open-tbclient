package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.ax;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qx extends hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGridImageLayout h;
    public b15 i;
    public int j;
    public String k;
    public int l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx a;

        public a(qx qxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            qx qxVar;
            ax.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (qxVar = this.a).e) != null) {
                aVar.a(qxVar.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx a;

        public b(qx qxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qxVar;
        }

        @Override // com.baidu.tieba.zy.b
        public boolean a(zy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.i != null && this.a.i.getThreadData() != null && !this.a.i().booleanValue()) {
                    xo6.a(this.a.i.getThreadData().getId());
                    xo6.l(this.a.h.b, this.a.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    xo6.l(this.a.h.c, this.a.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx(Context context) {
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
        this.j = 3;
        this.h = new NewGridImageLayout(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: A */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) {
            this.i = b15Var;
            this.h.setFrom(this.k);
            this.h.setFromForPb(this.l);
            this.h.setTransmit(i().booleanValue());
            this.h.onBindDataToView(b15Var);
            this.h.setJumpToPbListener(new a(this));
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.h.setBackgroundColor(i);
        }
    }

    public void C(int i) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (newGridImageLayout = this.h) != null) {
            newGridImageLayout.setCornerStyle(i);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h.setFromCDN(z);
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.l = i;
        }
    }

    public void F(ax.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.h.setNeedFrsTabName(z);
        }
    }

    public void I(boolean z) {
        NewGridImageLayout newGridImageLayout;
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (newGridImageLayout = this.h) != null && (gridImageLayout = newGridImageLayout.f) != null) {
            gridImageLayout.setIsTransform(z);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h.n = z;
        }
    }

    @Override // com.baidu.tieba.ax
    public void o(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mp6Var) == null) {
            this.h.setSubClickListener(mp6Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.k = str;
        }
    }

    public void H(bg<ImageView> bgVar, bg<GifView> bgVar2) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, bgVar, bgVar2) == null) && (newGridImageLayout = this.h) != null) {
            newGridImageLayout.setObjectPool(bgVar, bgVar2);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            if (this.j != i && i().booleanValue()) {
                SkinManager.setBackgroundColor(this.h, R.color.CAM_X0206);
            }
            NewGridImageLayout newGridImageLayout = this.h;
            if (newGridImageLayout != null) {
                newGridImageLayout.q(i);
            }
            this.j = i;
        }
    }

    public void J(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) && i().booleanValue()) {
            this.h.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ax
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l(1, new b(this));
        }
    }
}
