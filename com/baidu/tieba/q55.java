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
/* loaded from: classes7.dex */
public class q55 extends p55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public CustomMessageListener D;
    public CustomMessageListener E;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q55 q55Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q55Var, Integer.valueOf(i)};
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
            this.a = q55Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                q55 q55Var = this.a;
                if (q55Var.B) {
                    q55Var.D(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q55 q55Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q55Var, Integer.valueOf(i)};
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
            this.a = q55Var;
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
    public q55(TbPageContext<?> tbPageContext) {
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
        T(tbPageContext);
    }

    @Override // com.baidu.tieba.p55
    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.D(i);
            if (this.h != null && this.i != null) {
                this.A = false;
                if (!I()) {
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
    }

    public final void T(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.D.setTag(tbPageContext.getUniqueId());
            this.E.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.D);
            tbPageContext.registerListener(this.E);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.C = z;
        }
    }

    public void W(BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.p55, com.baidu.tieba.ei
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i.setBackgroundDrawable(null);
            super.h(z);
            this.B = true;
        }
    }

    @Override // com.baidu.tieba.p55, com.baidu.tieba.ei
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.s(z);
            this.B = false;
            if (!this.A) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                int i = this.p;
                if (i != Integer.MIN_VALUE) {
                    skinType = i;
                }
                D(skinType);
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.D);
            MessageManager.getInstance().unRegisterListener(this.E);
        }
    }

    @Override // com.baidu.tieba.p55, com.baidu.tieba.ei
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.t();
            this.B = false;
        }
    }
}
