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
/* loaded from: classes8.dex */
public class BubbleListModel extends BdBaseModel<BubbleListActivity> {
    private final int RN;
    private int currentPage;
    private boolean hasMore;
    private boolean isDefault;
    private final HttpMessageListener lcU;
    private e mRecommand;
    private boolean nxk;
    private com.baidu.adp.framework.listener.a nxl;
    private BubbleListActivity nyc;
    private List<DressItemData> nyd;
    private List<DressItemData> nye;
    private a nyf;

    /* loaded from: classes8.dex */
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
        this.nxl = new com.baidu.adp.framework.listener.a(1003055, CmdConfigSocket.CMD_BUBBLE_LIST) { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.1
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
                                BubbleListModel.this.nyd = bubbleListHttpResponseMessage.getBubbleList();
                                BubbleListModel.this.hasMore = bubbleListHttpResponseMessage.hasMore();
                                BubbleListModel.this.isDefault = bubbleListHttpResponseMessage.isDefault();
                            } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                                BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                                BubbleListModel.this.mRecommand = bubbleListSocketResponseMessage.getRecommand();
                                BubbleListModel.this.nyd = bubbleListSocketResponseMessage.getBubbleList();
                                BubbleListModel.this.hasMore = bubbleListSocketResponseMessage.hasMore();
                                BubbleListModel.this.isDefault = bubbleListSocketResponseMessage.isDefault();
                            }
                            if (BubbleListModel.this.nye == null) {
                                BubbleListModel.this.nye = new ArrayList();
                            }
                            if (BubbleListModel.this.currentPage == 1) {
                                BubbleListModel.this.nye.clear();
                                DressItemData dressItemData = new DressItemData();
                                dressItemData.setPropsId(0);
                                dressItemData.setInUse(BubbleListModel.this.isDefault);
                                BubbleListModel.this.nye.add(dressItemData);
                            }
                            if (BubbleListModel.this.nyd != null) {
                                BubbleListModel.this.nye.addAll(BubbleListModel.this.nyd);
                            }
                        }
                        if (BubbleListModel.this.nyf != null) {
                            BubbleListModel.this.nyf.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleListModel.this.mRecommand, BubbleListModel.this.nye);
                        }
                    }
                }
            }
        };
        this.lcU = new HttpMessageListener(1003056) { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
                    BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
                    if (bubbleSetResponseMessage.getError() != 0) {
                        BubbleListModel.this.nyc.showToast(bubbleSetResponseMessage.getErrorString());
                        return;
                    }
                    BubbleListModel.this.JP(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
                    BubbleListModel.this.nyf.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BubbleListModel.this.mRecommand, BubbleListModel.this.nye);
                }
            }
        };
        this.nyc = bubbleListActivity;
        this.nxk = bubbleListActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.nxl);
        dOS();
        registerListener(this.lcU);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_LIST, BubbleListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_LIST, 1003055, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
    }

    private void dOS() {
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

    public void dOT() {
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

    public boolean dOU() {
        return this.nxk;
    }

    public void a(a aVar) {
        this.nyf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP(int i) {
        if (this.nye != null && this.nye.size() > 0) {
            for (DressItemData dressItemData : this.nye) {
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
