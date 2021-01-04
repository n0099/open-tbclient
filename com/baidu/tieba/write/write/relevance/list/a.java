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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchResponse;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a {
    private BdUniqueId ahE;
    private final String mCategory;
    private InterfaceC0881a ohM;
    private List<String> ohN;
    private int mPageNum = 1;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH) { // from class: com.baidu.tieba.write.write.relevance.list.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && a.this.ohM != null) {
                if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.ahE) {
                    RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                    if (responseData != null && responseData.getData() != null) {
                        if (!x.equalList(a.this.ohN, responseData.getData().getTab_option())) {
                            a.this.ohN = responseData.getData().getTab_option();
                            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(a.this.ohN));
                        }
                        if (httpResponsedMessage.getError() != 0) {
                            a.this.ohM.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            a.this.ebp();
                            return;
                        } else if (x.isEmpty(responseData.getData().getItem_list())) {
                            if (a.this.mPageNum == 1) {
                                a.this.ohM.ebm();
                                return;
                            } else {
                                a.this.ohM.ebn();
                                return;
                            }
                        } else if (responseData != null) {
                            a.this.ohM.a(responseData);
                            if (a.this.mPageNum == 1 && responseData.getData().getItem_list().size() < 20) {
                                a.this.ohM.ebn();
                            }
                            a.e(a.this);
                            return;
                        } else {
                            return;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                    a.this.ohM.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    a.this.ebp();
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.write.relevance.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0881a {
        void a(RelevanceItemSearchData relevanceItemSearchData);

        void ebm();

        void ebn();

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId, String str) {
        this.ahE = bdUniqueId;
        this.mCategory = str;
        this.mHttpMessageListener.setTag(this.ahE);
        buG();
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
    }

    public void ebo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ahE);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void buG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(InterfaceC0881a interfaceC0881a) {
        this.ohM = interfaceC0881a;
    }

    public void VB(String str) {
        ebp();
        VC(str);
    }

    private void VC(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.mCategory);
        httpMessage.addParam("keyword", str);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.ahE);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ahE);
        MessageManager.getInstance().unRegisterListener(this.ahE);
    }

    public void ebp() {
        this.mPageNum = 1;
    }
}
