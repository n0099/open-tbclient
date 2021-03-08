package com.baidu.tieba.write.write.relevance.list;

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
/* loaded from: classes7.dex */
public class a {
    private BdUniqueId ahU;
    private final String mCategory;
    private InterfaceC0913a opE;
    private List<String> opF;
    private int mPageNum = 1;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH) { // from class: com.baidu.tieba.write.write.relevance.list.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && a.this.opE != null) {
                if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.ahU) {
                    RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                    if (responseData != null && responseData.getData() != null) {
                        if (!y.equalList(a.this.opF, responseData.getData().getTab_option())) {
                            a.this.opF = responseData.getData().getTab_option();
                            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(a.this.opF));
                        }
                        if (httpResponsedMessage.getError() != 0) {
                            a.this.opE.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            a.this.dZZ();
                            return;
                        } else if (y.isEmpty(responseData.getData().getItem_list())) {
                            if (a.this.mPageNum == 1) {
                                a.this.opE.dZW();
                                return;
                            } else {
                                a.this.opE.dZX();
                                return;
                            }
                        } else if (responseData != null) {
                            a.this.opE.a(responseData);
                            if (a.this.mPageNum == 1 && responseData.getData().getItem_list().size() < 20) {
                                a.this.opE.dZX();
                            }
                            a.e(a.this);
                            return;
                        } else {
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                    a.this.opE.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    a.this.dZZ();
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.write.relevance.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0913a {
        void a(RelevanceItemSearchData relevanceItemSearchData);

        void dZW();

        void dZX();

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId, String str) {
        this.ahU = bdUniqueId;
        this.mCategory = str;
        this.mHttpMessageListener.setTag(this.ahU);
        brh();
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
    }

    public void dZY() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ahU);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void brh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(InterfaceC0913a interfaceC0913a) {
        this.opE = interfaceC0913a;
    }

    public void VK(String str) {
        dZZ();
        VL(str);
    }

    private void VL(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam("keyword", str);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ahU);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ahU);
        MessageManager.getInstance().unRegisterListener(this.ahU);
    }

    public void dZZ() {
        this.mPageNum = 1;
    }
}
