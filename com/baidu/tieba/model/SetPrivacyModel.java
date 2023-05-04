package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.a9;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK;
    public static final String f;
    public transient /* synthetic */ FieldHolder $fh;
    public CardPersonDynamicThreadData a;
    public b b;
    public boolean c;
    public NetWork d;
    public a e;

    /* loaded from: classes5.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<CardPersonDynamicThreadData, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SetPrivacyModel a;

        public b(SetPrivacyModel setPrivacyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {setPrivacyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = setPrivacyModel;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(CardPersonDynamicThreadData... cardPersonDynamicThreadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cardPersonDynamicThreadDataArr)) == null) {
                if (cardPersonDynamicThreadDataArr == null || cardPersonDynamicThreadDataArr.length == 0 || cardPersonDynamicThreadDataArr[0] == null) {
                    return null;
                }
                CardPersonDynamicThreadData cardPersonDynamicThreadData = cardPersonDynamicThreadDataArr[0];
                if (TbadkCoreApplication.getCurrentAccount() == null) {
                    return null;
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                this.a.d = new NetWork(SetPrivacyModel.f);
                this.a.d.getNetContext().getRequest().mIsNeedTbs = true;
                this.a.d.addPostData("user_id", currentAccount);
                this.a.d.addPostData("forum_id", cardPersonDynamicThreadData.a);
                this.a.d.addPostData("thread_id", cardPersonDynamicThreadData.b);
                this.a.d.addPostData("post_id", cardPersonDynamicThreadData.e);
                this.a.d.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.o ? 1 : 0));
                this.a.d.postNetData();
                return Integer.valueOf(this.a.d.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
            }
            return (Integer) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel();
                if (this.a.d != null) {
                    this.a.d.cancelNetConnect();
                }
                this.a.c = false;
                this.a.b = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.a.c = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
                super.onPostExecute((b) num);
                this.a.c = false;
                this.a.b = null;
                if (this.a.e != null && this.a.d != null) {
                    if (num.intValue() == 1) {
                        this.a.e.onSuccess();
                    } else if (num.intValue() == 0) {
                        this.a.e.onError(this.a.d.getErrorString());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-707511252, "Lcom/baidu/tieba/model/SetPrivacyModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-707511252, "Lcom/baidu/tieba/model/SetPrivacyModel;");
                return;
            }
        }
        UNIQUE_ID_SET_PRIVACY_TASK = BdUniqueId.gen();
        f = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPrivacyModel(a9 a9Var, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, cardPersonDynamicThreadData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cardPersonDynamicThreadData;
    }

    public void c0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b != null) {
                return false;
            }
            b bVar = new b(this);
            this.b = bVar;
            bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
            this.b.execute(this.a);
            return true;
        }
        return invokeV.booleanValue;
    }
}
