package com.baidu.tieba.themeCenter.bubble.group;

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
public class d extends com.baidu.adp.base.e<BubbleGroupActivity> {
    private final HttpMessageListener cqU;
    private com.baidu.adp.framework.listener.a csn;
    private List<c> dLY;
    private boolean dMa;
    private BubbleGroupActivity dNf;
    private a dNg;
    private k mRecommand;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<c> list);
    }

    public d(BubbleGroupActivity bubbleGroupActivity) {
        super(bubbleGroupActivity.getPageContext());
        this.csn = new e(this, CmdConfigHttp.CMD_BUBBLE_CATEGORY, 309030);
        this.cqU = new f(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.dNf = bubbleGroupActivity;
        this.dMa = bubbleGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        ahe();
        registerListener(this.csn);
        aHD();
        registerListener(this.cqU);
    }

    private void ahe() {
        com.baidu.tieba.tbadkCore.a.a.a(309030, BubbleGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309030, CmdConfigHttp.CMD_BUBBLE_CATEGORY, TbConfig.BUBBLE_GROUP_PAGE, BubbleGroupHttpResponseMessage.class, false, false, false, false);
    }

    private void aHD() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage(new BubbleGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dNg = aVar;
    }

    public boolean aBV() {
        return this.dMa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(int i) {
        if (this.dLY != null && this.dLY.size() > 0) {
            for (c cVar : this.dLY) {
                if (cVar != null && cVar.getBubbleList() != null) {
                    for (DressItemData dressItemData : cVar.getBubbleList()) {
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
