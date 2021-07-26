package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
/* loaded from: classes4.dex */
public class SetPrivacyModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId UNIQUE_ID_SET_PRIVACY_TASK;
    public static final String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CardPersonDynamicThreadData f18767e;

    /* renamed from: f  reason: collision with root package name */
    public b f18768f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18769g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f18770h;

    /* renamed from: i  reason: collision with root package name */
    public a f18771i;

    /* loaded from: classes4.dex */
    public interface a {
        void onError(String str);

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<CardPersonDynamicThreadData, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPrivacyModel f18772a;

        public b(SetPrivacyModel setPrivacyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {setPrivacyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18772a = setPrivacyModel;
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
                this.f18772a.f18770h = new NetWork(SetPrivacyModel.j);
                this.f18772a.f18770h.getNetContext().getRequest().mIsNeedTbs = true;
                this.f18772a.f18770h.addPostData("user_id", currentAccount);
                this.f18772a.f18770h.addPostData("forum_id", cardPersonDynamicThreadData.f14588e);
                this.f18772a.f18770h.addPostData("thread_id", cardPersonDynamicThreadData.f14589f);
                this.f18772a.f18770h.addPostData("post_id", cardPersonDynamicThreadData.f14590g);
                this.f18772a.f18770h.addPostData("is_hide", String.valueOf(!cardPersonDynamicThreadData.q ? 1 : 0));
                this.f18772a.f18770h.postNetData();
                return Integer.valueOf(this.f18772a.f18770h.getNetContext().getResponse().isRequestSuccess() ? 1 : 0);
            }
            return (Integer) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel();
                if (this.f18772a.f18770h != null) {
                    this.f18772a.f18770h.cancelNetConnect();
                }
                this.f18772a.f18769g = false;
                this.f18772a.f18768f = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.f18772a.f18769g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
                super.onPostExecute((b) num);
                this.f18772a.f18769g = false;
                this.f18772a.f18768f = null;
                if (this.f18772a.f18771i == null || this.f18772a.f18770h == null) {
                    return;
                }
                if (num.intValue() == 1) {
                    this.f18772a.f18771i.onSuccess();
                } else if (num.intValue() == 0) {
                    this.f18772a.f18771i.onError(this.f18772a.f18770h.getErrorString());
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
        j = TbConfig.SERVER_ADDRESS + TbConfig.URL_SET_PRIVACY;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPrivacyModel(f fVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, cardPersonDynamicThreadData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18767e = cardPersonDynamicThreadData;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18769g : invokeV.booleanValue;
    }

    public void D(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f18771i = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f18768f != null) {
                return false;
            }
            b bVar = new b(this);
            this.f18768f = bVar;
            bVar.setTag(UNIQUE_ID_SET_PRIVACY_TASK);
            this.f18768f.execute(this.f18767e);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b bVar = this.f18768f;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
