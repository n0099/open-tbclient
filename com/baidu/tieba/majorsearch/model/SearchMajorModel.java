package com.baidu.tieba.majorsearch.model;

import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.message.SearchMajorHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class SearchMajorModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f54116e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f54117f;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SearchMajorModel f54118a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchMajorModel searchMajorModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchMajorModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54118a = searchMajorModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            this.f54118a.mErrorCode = httpResponsedMessage.getError();
            this.f54118a.mErrorString = httpResponsedMessage.getErrorString();
            if (!StringUtils.isNull(this.f54118a.mErrorString)) {
                str = this.f54118a.mErrorString;
            } else {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.f54118a.mErrorCode);
            errorData.setError_msg(str);
            SearchMajorHttpResponsedMessage searchMajorHttpResponsedMessage = httpResponsedMessage instanceof SearchMajorHttpResponsedMessage ? (SearchMajorHttpResponsedMessage) httpResponsedMessage : null;
            if (searchMajorHttpResponsedMessage != null && searchMajorHttpResponsedMessage.getData() != null && !ListUtils.isEmpty(searchMajorHttpResponsedMessage.getData().f26336a)) {
                this.f54118a.f54116e.onSuccess(searchMajorHttpResponsedMessage.getData().f26336a);
            } else {
                this.f54118a.f54116e.onError(errorData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onError(ErrorData errorData);

        void onSuccess(List<String> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchMajorModel(f fVar, b bVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_SEARCH_MAJOR);
        this.f54117f = aVar;
        aVar.setSelfListener(true);
        registerListener(this.f54117f);
        this.f54116e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }
}
