package com.baidu.tieba.majorsearch.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.message.SearchMajorHttpResponsedMessage;
import java.util.List;
/* loaded from: classes24.dex */
public class SearchMajorModel extends BdBaseModel {
    a kNU;
    private HttpMessageListener mHttpMessageListener;

    /* loaded from: classes24.dex */
    public interface a {
        void af(List<String> list);

        void b(ErrorData errorData);
    }

    public SearchMajorModel(e eVar, a aVar) {
        super(eVar);
        this.mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_SEARCH_MAJOR) { // from class: com.baidu.tieba.majorsearch.model.SearchMajorModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                SearchMajorHttpResponsedMessage searchMajorHttpResponsedMessage;
                if (httpResponsedMessage != null) {
                    SearchMajorModel.this.mErrorCode = httpResponsedMessage.getError();
                    SearchMajorModel.this.mErrorString = httpResponsedMessage.getErrorString();
                    if (!StringUtils.isNull(SearchMajorModel.this.mErrorString)) {
                        str = SearchMajorModel.this.mErrorString;
                    } else {
                        str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                    }
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(SearchMajorModel.this.mErrorCode);
                    errorData.setError_msg(str);
                    if (!(httpResponsedMessage instanceof SearchMajorHttpResponsedMessage)) {
                        searchMajorHttpResponsedMessage = null;
                    } else {
                        searchMajorHttpResponsedMessage = (SearchMajorHttpResponsedMessage) httpResponsedMessage;
                    }
                    if (searchMajorHttpResponsedMessage != null && searchMajorHttpResponsedMessage.getData() != null && !y.isEmpty(searchMajorHttpResponsedMessage.getData().kNT)) {
                        SearchMajorModel.this.kNU.af(searchMajorHttpResponsedMessage.getData().kNT);
                    } else {
                        SearchMajorModel.this.kNU.b(errorData);
                    }
                }
            }
        };
        this.mHttpMessageListener.setSelfListener(true);
        registerListener(this.mHttpMessageListener);
        this.kNU = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
