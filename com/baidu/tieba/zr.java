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
/* loaded from: classes9.dex */
public class zr extends wr<jv4> implements lva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout f;
    public int g;
    public jv4 h;
    public b i;

    /* loaded from: classes9.dex */
    public interface b {
        void a(jv4 jv4Var, View view2);
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr a;

        public a(zr zrVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zrVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zrVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i != null) {
                    this.a.i.a(this.a.h, view2);
                }
                if (this.a.g() != null) {
                    this.a.g().a(view2, this.a.h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zr(Context context) {
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
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.setFromScene(i);
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f.setShowFlag(this.g);
        }
    }

    public void C(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) == null) {
            this.f.setPageContext(tbPageContext);
        }
    }

    public void D(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getUserName() != null) {
            this.f.getUserName().setClickable(z);
        }
    }

    @Override // com.baidu.tieba.wr
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i2 = i | this.g;
            this.g = i2;
            B(i2);
        }
    }

    @Override // com.baidu.tieba.wr
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = (~i) & this.g;
            this.g = i2;
            B(i2);
        }
    }

    @Override // com.baidu.tieba.wr
    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    /* renamed from: x */
    public void onBindDataToView(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jv4Var) == null) {
            this.h = jv4Var;
            this.f.setData(jv4Var.getThreadData());
        }
    }

    public void y(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getAvatar() != null) {
            this.f.getAvatar().setClickable(z);
        }
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.i = bVar;
        }
    }

    @Override // com.baidu.tieba.lva
    public void a() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.startVirtualAnimation();
        }
    }

    @Override // com.baidu.tieba.lva
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jv4 jv4Var = this.h;
            if (jv4Var != null && jv4Var.getThreadData() != null && this.h.getThreadData().getCustomFigure() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lva
    public void c() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.recoverVirtualAnimation();
        }
    }

    @Override // com.baidu.tieba.lva
    public void d() {
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

    @Override // com.baidu.tieba.wr
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lva
    public void play() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.isVirtualImage() && !this.f.isHasPlayVirtualImage()) {
            this.f.setHasPlayVirtualImage(true);
            this.f.startVirtualImageAnimate();
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }
}
