package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zx extends wx<l15> implements hka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout f;
    public int g;
    public l15 h;
    public b i;

    /* loaded from: classes8.dex */
    public interface b {
        void a(l15 l15Var, View view2);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx a;

        public a(zx zxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i != null) {
                    this.a.i.a(this.a.h, view2);
                }
                if (this.a.h() != null) {
                    this.a.h().a(view2, this.a.h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx(Context context) {
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
        this.g = 34053;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().c instanceof CardUserInfoLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().c.getParent() == null) {
            this.f = (CardUserInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().c;
        } else {
            this.f = new CardUserInfoLayout(context);
        }
        this.f.setShowFlag(this.g);
        this.f.setUserAfterClickListener(new a(this));
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f.setShowFlag(this.g);
        }
    }

    public void B(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f.setPageContext(tbPageContext);
        }
    }

    public void C(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getUserName() != null) {
            this.f.getUserName().setClickable(z);
        }
    }

    @Override // com.baidu.tieba.wx
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i2 = i | this.g;
            this.g = i2;
            A(i2);
        }
    }

    @Override // com.baidu.tieba.wx
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = (~i) & this.g;
            this.g = i2;
            A(i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qy
    /* renamed from: u */
    public void a(l15 l15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l15Var) == null) {
            this.h = l15Var;
            this.f.setData(l15Var.getThreadData());
        }
    }

    public void x(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getAvatar() != null) {
            this.f.getAvatar().setClickable(z);
        }
    }

    public void y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.hka
    public void b() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.startVirtualAnimation();
        }
    }

    @Override // com.baidu.tieba.hka
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            l15 l15Var = this.h;
            if (l15Var != null && l15Var.getThreadData() != null && this.h.getThreadData().getCustomFigure() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hka
    public void d() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.recoverVirtualAnimation();
        }
    }

    @Override // com.baidu.tieba.hka
    public void e() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (cardUserInfoLayout = this.f) != null) {
            if (cardUserInfoLayout.isHasPlayVirtualImage()) {
                this.f.recoverVirtualImageAnimate();
                this.f.setHasPlayVirtualImage(false);
            }
            this.f.recoverVirtualAnimation();
        }
    }

    @Override // com.baidu.tieba.wx
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hka
    public void play() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.isVirtualImage() && !this.f.isHasPlayVirtualImage()) {
            this.f.setHasPlayVirtualImage(true);
            this.f.startVirtualImageAnimate();
        }
    }

    @Override // com.baidu.tieba.ry
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }
}
