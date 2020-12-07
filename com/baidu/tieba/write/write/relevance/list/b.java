package com.baidu.tieba.write.write.relevance.list;

import android.text.Editable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchResponse;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId ajD;
    private final String mCategory;
    private a ogf;
    private List<String> ogg;
    private int mPageNum = 1;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH) { // from class: com.baidu.tieba.write.write.relevance.list.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && b.this.ogf != null) {
                if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.ajD) {
                    RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                    if (responseData != null && responseData.getData() != null) {
                        if (y.equalList(b.this.ogg, responseData.getData().getTab_option())) {
                            b.this.ogg = responseData.getData().getTab_option();
                            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(b.this.ogg));
                        }
                        if (httpResponsedMessage.getError() != 0) {
                            b.this.ogf.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            b.this.ecs();
                            return;
                        } else if (y.isEmpty(responseData.getData().getItem_list())) {
                            if (b.this.mPageNum == 1) {
                                b.this.ogf.ecp();
                                return;
                            } else {
                                b.this.ogf.ecq();
                                return;
                            }
                        } else if (responseData != null) {
                            b.this.ogf.a(responseData);
                            if (b.this.mPageNum == 1 && responseData.getData().getItem_list().size() < 20) {
                                b.this.ogf.ecq();
                            }
                            b.e(b.this);
                            return;
                        } else {
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                    b.this.ogf.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    b.this.ecs();
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(RelevanceItemSearchData relevanceItemSearchData);

        void ecp();

        void ecq();

        void onError(int i, String str);
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.mPageNum;
        bVar.mPageNum = i + 1;
        return i;
    }

    public b(BdUniqueId bdUniqueId, String str) {
        this.ajD = bdUniqueId;
        this.mCategory = str;
        this.mHttpMessageListener.setTag(this.ajD);
        bse();
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
    }

    public void ecr() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ajD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bse() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(a aVar) {
        this.ogf = aVar;
    }

    public void g(Editable editable) {
        ecs();
        h(editable);
    }

    private void h(Editable editable) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam("keyword", editable);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ajD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ajD);
        MessageManager.getInstance().unRegisterListener(this.ajD);
    }

    public void ecs() {
        this.mPageNum = 1;
    }
}
