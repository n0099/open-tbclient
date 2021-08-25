package com.baidu.tieba.wallet;

import android.content.Context;
import c.a.p0.m.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletListener;
/* loaded from: classes7.dex */
public class Login extends LightAppListenerImpl implements IWalletListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAccountChangedListener;
    public Context mContext;
    public ILoginBackListener mLoginBackListener;

    public Login(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAccountChangedListener = new CustomMessageListener(this, 2005016) { // from class: com.baidu.tieba.wallet.Login.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Login this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.this$0.mLoginBackListener == null) {
                    return;
                }
                this.this$0.mLoginBackListener.onSuccess(0, TbadkCoreApplication.getCurrentBduss());
                this.this$0.mLoginBackListener = null;
            }
        };
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iLoginBackListener) == null) {
            this.mLoginBackListener = iLoginBackListener;
            TbadkCoreApplication.getInst().handler.post(new Runnable(this) { // from class: com.baidu.tieba.wallet.Login.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Login this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.this$0.mContext, true)));
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (UrlSchemaHelper.SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS.equals(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(this.mContext)));
            } else if (UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY.equals(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.mContext, 0)));
            } else if ("tdoudiscount:".equals(str)) {
                CurrencyJumpHelper.schemaGotoBuyBean(this.mContext);
            } else {
                a.t(this.mContext, true, str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
