package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.ChatFloatEntranceFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ku7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pu7 a;
    public boolean b;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ku7 ku7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku7Var, Integer.valueOf(i)};
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
            this.a = ku7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.b = true;
            }
        }
    }

    public ku7(ChatFloatEntranceFragment chatFloatEntranceFragment, pu7 pu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatFloatEntranceFragment, pu7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pu7Var;
        a aVar = new a(this, 2921437);
        if (chatFloatEntranceFragment != null) {
            chatFloatEntranceFragment.registerListener(aVar);
        }
    }

    public void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) || motionEvent == null) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            this.b = false;
            pu7 pu7Var = this.a;
            if (pu7Var != null) {
                pu7Var.a();
            }
        } else if (motionEvent.getAction() == 2) {
            pu7 pu7Var2 = this.a;
            if (pu7Var2 != null && !this.b) {
                pu7Var2.a();
            }
        } else if (this.b) {
            pu7 pu7Var3 = this.a;
            if (pu7Var3 != null) {
                pu7Var3.b();
            }
            this.b = false;
        } else {
            pu7 pu7Var4 = this.a;
            if (pu7Var4 != null) {
                pu7Var4.a();
            }
        }
    }
}
