package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class k36 extends ActivityDelegation implements jo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public n36 b;
    public Activity c;
    public Map<String, String> d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k36 k36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k36Var, Integer.valueOf(i)};
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
            this.a = k36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof rm5)) {
                    return;
                }
                rm5 rm5Var = (rm5) data;
                if (getTag() != rm5Var.a && !rm5Var.g) {
                    return;
                }
                this.a.mResult.putInt("result_code", rm5Var.b);
                this.a.mResult.putString("result_msg", rm5Var.c);
                if (this.a.b != null) {
                    this.a.b.a(this.a.mResult);
                }
                this.a.finish();
            }
        }
    }

    public k36() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.e = new a(this, 2921393);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = null;
            MessageManager.getInstance().unRegisterListener(this.e);
            super.finish();
        }
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.c = activity;
        }
    }

    public void e(n36 n36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n36Var) == null) {
            this.b = n36Var;
        }
    }

    @Override // com.baidu.tieba.jo1
    public void onResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mResult.putInt("result_code", i);
            this.mResult.putString("result_msg", "");
            finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.setTag(this.a);
            MessageManager.getInstance().registerListener(this.e);
            int i = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            rm5 rm5Var = new rm5();
            rm5Var.a = this.a;
            rm5Var.b = i;
            rm5Var.c = string;
            rm5Var.e = (Map) this.mParams.getSerializable("params");
            rm5Var.f = this.d;
            if (getAgent() != null) {
                rm5Var.d = getAgent();
            } else {
                Activity activity = this.c;
                if (activity != null) {
                    rm5Var.d = activity;
                } else {
                    rm5Var.d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, rm5Var);
            customMessage.setTag(this.a);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            Bundle bundle = this.mResult;
            int i2 = 1;
            if (sendMessage) {
                i2 = 0;
            }
            bundle.putInt("result_code", i2);
            Bundle bundle2 = this.mResult;
            bundle2.putString("result_msg", "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }
}
