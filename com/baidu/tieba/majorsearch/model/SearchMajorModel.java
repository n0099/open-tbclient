package com.baidu.tieba.majorsearch.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.message.SearchMajorHttpResponsedMessage;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchMajorModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18217e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f18218f;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            if (httpResponsedMessage == null) {
                return;
            }
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
            SearchMajorHttpResponsedMessage searchMajorHttpResponsedMessage = httpResponsedMessage instanceof SearchMajorHttpResponsedMessage ? (SearchMajorHttpResponsedMessage) httpResponsedMessage : null;
            if (searchMajorHttpResponsedMessage != null && searchMajorHttpResponsedMessage.getData() != null && !ListUtils.isEmpty(searchMajorHttpResponsedMessage.getData().f58123a)) {
                SearchMajorModel.this.f18217e.onSuccess(searchMajorHttpResponsedMessage.getData().f58123a);
            } else {
                SearchMajorModel.this.f18217e.onError(errorData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onError(ErrorData errorData);

        void onSuccess(List<String> list);
    }

    public SearchMajorModel(f fVar, b bVar) {
        super(fVar);
        a aVar = new a(CmdConfigHttp.CMD_SEARCH_MAJOR);
        this.f18218f = aVar;
        aVar.setSelfListener(true);
        registerListener(this.f18218f);
        this.f18217e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
