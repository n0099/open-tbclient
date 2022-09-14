package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mx4 extends lx4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public CustomMessageListener D;
    public CustomMessageListener E;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mx4 mx4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                mx4 mx4Var = this.a;
                if (mx4Var.B) {
                    mx4Var.H(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mx4 mx4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.h.setBackgroundColor(PullViewHelper.getInstance().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx4(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.B = true;
        this.C = false;
        this.D = new a(this, 2016203);
        this.E = new b(this, 2016204);
        Y(tbPageContext);
    }

    @Override // com.baidu.tieba.lx4
    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.H(i);
            if (this.h == null || this.i == null) {
                return;
            }
            this.A = false;
            if (!N()) {
                AnimationDrawable animationDrawable = PullViewHelper.getInstance().getAnimationDrawable(i);
                this.n = animationDrawable;
                if (animationDrawable != null) {
                    this.A = true;
                } else {
                    this.n = new AnimationDrawable();
                }
                if (!this.A) {
                    this.n = PullViewHelper.getInstance().getDefaultAnimationDrawable(i);
                }
                this.n.setOneShot(false);
                this.i.setBackgroundDrawable(this.n);
            }
            if (this.C) {
                this.h.setBackgroundColor(0);
            }
        }
    }

    public final void Y(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.D.setTag(tbPageContext.getUniqueId());
            this.E.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.D);
            tbPageContext.registerListener(this.E);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.D);
            MessageManager.getInstance().unRegisterListener(this.E);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.C = z;
        }
    }

    public void b0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            CustomMessageListener customMessageListener = this.D;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
            }
            CustomMessageListener customMessageListener2 = this.E;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.E);
        }
    }

    @Override // com.baidu.tieba.lx4, com.baidu.tieba.sn
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i.setBackgroundDrawable(null);
            super.o(z);
            this.B = true;
        }
    }

    @Override // com.baidu.tieba.lx4, com.baidu.tieba.sn
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.w(z);
            this.B = false;
            if (this.A) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i = this.p;
            if (i != Integer.MIN_VALUE) {
                skinType = i;
            }
            H(skinType);
        }
    }

    @Override // com.baidu.tieba.lx4, com.baidu.tieba.sn
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.x();
            this.B = false;
        }
    }
}
