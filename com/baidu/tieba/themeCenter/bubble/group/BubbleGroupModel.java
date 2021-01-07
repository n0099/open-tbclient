package com.baidu.tieba.themeCenter.bubble.group;

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
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleGroupModel extends BdBaseModel<BubbleGroupActivity> {
    private final HttpMessageListener lhA;
    private List<b> mGroupList;
    private e mRecommand;
    private boolean nBt;
    private com.baidu.adp.framework.listener.a nBu;
    private BubbleGroupActivity nCy;
    private a nCz;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, e eVar, List<b> list);
    }

    public BubbleGroupModel(BubbleGroupActivity bubbleGroupActivity) {
        super(bubbleGroupActivity.getPageContext());
        this.nBu = new com.baidu.adp.framework.listener.a(1003039, CmdConfigSocket.CMD_BUBBLE_CATEGORY) { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BubbleGroupHttpResponseMessage) || (responsedMessage instanceof BubbleGroupSocketResponseMessage)) {
                        if (responsedMessage.getError() != 0) {
                            if (BubbleGroupModel.this.nCz != null) {
                                BubbleGroupModel.this.nCz.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleGroupModel.this.mRecommand, BubbleGroupModel.this.mGroupList);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BubbleGroupHttpResponseMessage) {
                            BubbleGroupHttpResponseMessage bubbleGroupHttpResponseMessage = (BubbleGroupHttpResponseMessage) responsedMessage;
                            BubbleGroupModel.this.mRecommand = bubbleGroupHttpResponseMessage.getRecommand();
                            BubbleGroupModel.this.mGroupList = bubbleGroupHttpResponseMessage.getGroupList();
                        } else if (responsedMessage instanceof BubbleGroupSocketResponseMessage) {
                            BubbleGroupSocketResponseMessage bubbleGroupSocketResponseMessage = (BubbleGroupSocketResponseMessage) responsedMessage;
                            BubbleGroupModel.this.mRecommand = bubbleGroupSocketResponseMessage.getRecommand();
                            BubbleGroupModel.this.mGroupList = bubbleGroupSocketResponseMessage.getGroupList();
                        }
                        if (BubbleGroupModel.this.nCz != null) {
                            BubbleGroupModel.this.nCz.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleGroupModel.this.mRecommand, BubbleGroupModel.this.mGroupList);
                        }
                    }
                }
            }
        };
        this.lhA = new HttpMessageListener(1003056) { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
                    BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
                    if (bubbleSetResponseMessage.getError() != 0) {
                        BubbleGroupModel.this.nCy.showToast(bubbleSetResponseMessage.getErrorString());
                        return;
                    }
                    BubbleGroupModel.this.Lw(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
                    BubbleGroupModel.this.nCz.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BubbleGroupModel.this.mRecommand, BubbleGroupModel.this.mGroupList);
                }
            }
        };
        this.nCy = bubbleGroupActivity;
        this.nBt = bubbleGroupActivity.getIntent().getBooleanExtra("member_buy_show", false);
        dSJ();
        registerListener(this.nBu);
        dSK();
        registerListener(this.lhA);
    }

    private void dSJ() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_CATEGORY, BubbleGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BUBBLE_CATEGORY, 1003039, TbConfig.BUBBLE_GROUP_PAGE, BubbleGroupHttpResponseMessage.class, false, false, false, false);
    }

    private void dSK() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003056, TbConfig.SERVER_ADDRESS + "c/e/bu/setbubble");
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BubbleGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nCz = aVar;
    }

    public boolean dMw() {
        return this.nBt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw(int i) {
        if (this.mGroupList != null && this.mGroupList.size() > 0) {
            for (b bVar : this.mGroupList) {
                if (bVar != null && bVar.getBubbleList() != null) {
                    for (DressItemData dressItemData : bVar.getBubbleList()) {
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
    }
}
