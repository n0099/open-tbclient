package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e<BubbleListActivity> {
    private int Np;
    private final HttpMessageListener cqU;
    private final int dMt;
    private boolean dMu;
    private com.baidu.adp.framework.listener.a dMv;
    private BubbleListActivity dNo;
    private List<DressItemData> dNp;
    private List<DressItemData> dNq;
    private a dNr;
    private boolean hasMore;
    private boolean isDefault;
    private k mRecommand;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<DressItemData> list);
    }

    public e(BubbleListActivity bubbleListActivity) {
        super(bubbleListActivity.getPageContext());
        this.dMt = 16;
        this.Np = 0;
        this.hasMore = true;
        this.isDefault = false;
        this.dMv = new f(this, CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
        this.cqU = new g(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.dNo = bubbleListActivity;
        this.dMu = bubbleListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        CF();
        registerListener(this.dMv);
        aHD();
        registerListener(this.cqU);
    }

    private void CF() {
        com.baidu.tieba.tbadkCore.a.a.a(309031, BubbleListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309031, CmdConfigHttp.CMD_BUBBLE_LIST, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
    }

    private void aHD() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
        this.Np = 1;
        bubbleListRequestMessage.setPn(this.Np);
        bubbleListRequestMessage.setRn(15);
        sendMessage(bubbleListRequestMessage);
        return false;
    }

    public void aHG() {
        if (this.hasMore) {
            this.Np++;
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            bubbleListRequestMessage.setPn(this.Np);
            bubbleListRequestMessage.setRn(16);
            sendMessage(bubbleListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aHH() {
        return this.dMu;
    }

    public void a(a aVar) {
        this.dNr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(int i) {
        if (this.dNq != null && this.dNq.size() > 0) {
            for (DressItemData dressItemData : this.dNq) {
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
