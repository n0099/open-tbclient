package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleListModel extends BdBaseModel<BubbleListActivity> {
    private final int RN;
    private int currentPage;
    private boolean hasMore;
    private boolean isDefault;
    private final HttpMessageListener lll;
    private e mRecommand;
    private boolean nHv;
    private com.baidu.adp.framework.listener.a nHw;
    private BubbleListActivity nIn;
    private List<DressItemData> nIo;
    private List<DressItemData> nIp;
    private a nIq;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, e eVar, List<DressItemData> list);
    }

    static /* synthetic */ int a(BubbleListModel bubbleListModel) {
        int i = bubbleListModel.currentPage;
        bubbleListModel.currentPage = i - 1;
        return i;
    }

    public BubbleListModel(BubbleListActivity bubbleListActivity) {
        super(bubbleListActivity.getPageContext());
        this.RN = 16;
        this.currentPage = 0;
        this.hasMore = true;
        this.isDefault = false;
        this.nHw = new com.baidu.adp.framework.listener.a(1003055, CmdConfigSocket.CMD_BUBBLE_LIST) { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BubbleListHttpResponseMessage) || (responsedMessage instanceof BubbleListSocketResponseMessage)) {
                        if (responsedMessage.getError() != 0) {
                            BubbleListModel.a(BubbleListModel.this);
                        } else {
                            if (responsedMessage instanceof BubbleListHttpResponseMessage) {
                                BubbleListHttpResponseMessage bubbleListHttpResponseMessage = (BubbleListHttpResponseMessage) responsedMessage;
                                BubbleListModel.this.mRecommand = bubbleListHttpResponseMessage.getRecommand();
                                BubbleListModel.this.nIo = bubbleListHttpResponseMessage.getBubbleList();
                                BubbleListModel.this.hasMore = bubbleListHttpResponseMessage.hasMore();
                                BubbleListModel.this.isDefault = bubbleListHttpResponseMessage.isDefault();
                            } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                                BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                                BubbleListModel.this.mRecommand = bubbleListSocketResponseMessage.getRecommand();
                                BubbleListModel.this.nIo = bubbleListSocketResponseMessage.getBubbleList();
                                BubbleListModel.this.hasMore = bubbleListSocketResponseMessage.hasMore();
                                BubbleListModel.this.isDefault = bubbleListSocketResponseMessage.isDefault();
                            }
                            if (BubbleListModel.this.nIp == null) {
                                BubbleListModel.this.nIp = new ArrayList();
                            }
                            if (BubbleListModel.this.currentPage == 1) {
                                BubbleListModel.this.nIp.clear();
                                DressItemData dressItemData = new DressItemData();
                                dressItemData.setPropsId(0);
                                dressItemData.setInUse(BubbleListModel.this.isDefault);
                                BubbleListModel.this.nIp.add(dressItemData);
                            }
                            if (BubbleListModel.this.nIo != null) {
                                BubbleListModel.this.nIp.addAll(BubbleListModel.this.nIo);
                            }
                        }
                        if (BubbleListModel.this.nIq != null) {
                            BubbleListModel.this.nIq.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleListModel.this.mRecommand, BubbleListModel.this.nIp);
                        }
                    }
                }
            }
        };
        this.lll = new HttpMessageListener(1003056) { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
                    BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
                    if (bubbleSetResponseMessage.getError() != 0) {
                        BubbleListModel.this.nIn.showToast(bubbleSetResponseMessage.getErrorString());
                        return;
                    }
                    BubbleListModel.this.Kj(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
                    BubbleListModel.this.nIq.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BubbleListModel.this.mRecommand, BubbleListModel.this.nIp);
                }
            }
        };
        this.nIn = bubbleListActivity;
        this.nHv = bubbleListActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.nHw);
        dRl();
        registerListener(this.lll);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_LIST, BubbleListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_LIST, 1003055, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
    }

    private void dRl() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003056, TbConfig.SERVER_ADDRESS + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
        this.currentPage = 1;
        bubbleListRequestMessage.setPn(this.currentPage);
        bubbleListRequestMessage.setRn(15);
        sendMessage(bubbleListRequestMessage);
        return false;
    }

    public void dRm() {
        if (this.hasMore) {
            this.currentPage++;
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            bubbleListRequestMessage.setPn(this.currentPage);
            bubbleListRequestMessage.setRn(16);
            sendMessage(bubbleListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean dRn() {
        return this.nHv;
    }

    public void a(a aVar) {
        this.nIq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj(int i) {
        if (this.nIp != null && this.nIp.size() > 0) {
            for (DressItemData dressItemData : this.nIp) {
                if (dressItemData != null) {
                    if (dressItemData.getPropsId() == i) {
                        dressItemData.setInUse(true);
                    } else {
                        dressItemData.setInUse(false);
                    }
                }
            }
        }
    }
}
