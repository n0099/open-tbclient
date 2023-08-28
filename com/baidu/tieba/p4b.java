package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class p4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public BdUniqueId b;
    public final String c;
    public b d;
    public List<String> e;
    public HttpMessageListener f;

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void c(RelevanceItemSearchData relevanceItemSearchData);

        void d();

        void onError(int i, String str);
    }

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p4b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p4b p4bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p4bVar, Integer.valueOf(i)};
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
            this.a = p4bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            RelevanceItemSearchData relevanceItemSearchData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && this.a.d != null) {
                if (httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() != this.a.b) {
                    return;
                }
                if (httpResponsedMessage instanceof RelevanceItemSearchResponse) {
                    relevanceItemSearchData = ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData();
                } else {
                    relevanceItemSearchData = null;
                }
                if (relevanceItemSearchData != null && relevanceItemSearchData.getData() != null) {
                    if (!ListUtils.equalList(this.a.e, relevanceItemSearchData.getData().getTab_option())) {
                        this.a.e = relevanceItemSearchData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(this.a.e));
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
                            if (this.a.a == 1) {
                                this.a.d.a();
                                return;
                            } else {
                                this.a.d.d();
                                return;
                            }
                        } else if (relevanceItemSearchData != null) {
                            this.a.d.c(relevanceItemSearchData);
                            if (this.a.a == 1 && relevanceItemSearchData.getData().getItem_list().size() < 20) {
                                this.a.d.d();
                            }
                            p4b.f(this.a);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    this.a.l();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                this.a.d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e29));
                this.a.l();
            }
        }
    }

    public p4b(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        a aVar = new a(this, CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f = aVar;
        this.b = bdUniqueId;
        this.c = str;
        aVar.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f);
    }

    public static /* synthetic */ int f(p4b p4bVar) {
        int i = p4bVar.a;
        p4bVar.a = i + 1;
        return i;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            l();
            i(str);
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.c);
            httpMessage.addParam("pn", this.a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.c);
            httpMessage.addParam("keyword", str);
            httpMessage.addParam("pn", this.a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().removeMessage(this.b);
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 1;
        }
    }
}
