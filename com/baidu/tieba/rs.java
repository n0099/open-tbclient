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
public class rs extends os<fw4> implements jdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout f;
    public int g;
    public fw4 h;
    public b i;

    /* loaded from: classes8.dex */
    public interface b {
        void a(fw4 fw4Var, View view2);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs a;

        public a(rs rsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rsVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i != null) {
                    this.a.i.a(this.a.h, view2);
                }
                if (this.a.d() != null) {
                    this.a.d().a(view2, this.a.h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs(Context context) {
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

    public void A(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f.setPageContext(tbPageContext);
        }
    }

    public void B(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getUserName() != null) {
            this.f.getUserName().setClickable(z);
        }
    }

    @Override // com.baidu.tieba.os
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = i | this.g;
            this.g = i2;
            z(i2);
        }
    }

    @Override // com.baidu.tieba.os
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            int i2 = (~i) & this.g;
            this.g = i2;
            z(i2);
        }
    }

    @Override // com.baidu.tieba.os
    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: t */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fw4Var) == null) {
            this.h = fw4Var;
            this.f.setData(fw4Var.getThreadData());
        }
    }

    public void u(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.getAvatar() != null) {
            this.f.getAvatar().setClickable(z);
        }
    }

    public void x(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void y(int i) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (cardUserInfoLayout = this.f) != null) {
            cardUserInfoLayout.setFromScene(i);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f.setShowFlag(this.g);
        }
    }

    @Override // com.baidu.tieba.jdb
    public void a() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.isHasPlayVirtualImage()) {
            this.f.recoverVirtualImageAnimate();
            this.f.setHasPlayVirtualImage(false);
        }
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jdb
    public void play() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.isVirtualImage() && !this.f.isHasPlayVirtualImage()) {
            this.f.setHasPlayVirtualImage(true);
            this.f.startVirtualImageAnimate();
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }
}
