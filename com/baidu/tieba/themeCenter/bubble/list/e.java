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
    private int MZ;
    private final HttpMessageListener cmR;
    private final int dEQ;
    private boolean dER;
    private com.baidu.adp.framework.listener.a dES;
    private BubbleListActivity dFM;
    private List<DressItemData> dFN;
    private List<DressItemData> dFO;
    private a dFP;
    private boolean hasMore;
    private boolean isDefault;
    private k mRecommand;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<DressItemData> list);
    }

    public e(BubbleListActivity bubbleListActivity) {
        super(bubbleListActivity.getPageContext());
        this.dEQ = 16;
        this.MZ = 0;
        this.hasMore = true;
        this.isDefault = false;
        this.dES = new f(this, CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
        this.cmR = new g(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.dFM = bubbleListActivity;
        this.dER = bubbleListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        CQ();
        registerListener(this.dES);
        aFo();
        registerListener(this.cmR);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309031, BubbleListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309031, CmdConfigHttp.CMD_BUBBLE_LIST, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
    }

    private void aFo() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
        this.MZ = 1;
        bubbleListRequestMessage.setPn(this.MZ);
        bubbleListRequestMessage.setRn(15);
        sendMessage(bubbleListRequestMessage);
        return false;
    }

    public void aFr() {
        if (this.hasMore) {
            this.MZ++;
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            bubbleListRequestMessage.setPn(this.MZ);
            bubbleListRequestMessage.setRn(16);
            sendMessage(bubbleListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aFs() {
        return this.dER;
    }

    public void a(a aVar) {
        this.dFP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW(int i) {
        if (this.dFO != null && this.dFO.size() > 0) {
            for (DressItemData dressItemData : this.dFO) {
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
