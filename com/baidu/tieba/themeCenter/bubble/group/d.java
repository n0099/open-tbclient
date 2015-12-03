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
    private final HttpMessageListener cmR;
    private com.baidu.adp.framework.listener.a cok;
    private List<c> dEu;
    private boolean dEw;
    private BubbleGroupActivity dFD;
    private a dFE;
    private k mRecommand;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<c> list);
    }

    public d(BubbleGroupActivity bubbleGroupActivity) {
        super(bubbleGroupActivity.getPageContext());
        this.cok = new e(this, CmdConfigHttp.CMD_BUBBLE_CATEGORY, 309030);
        this.cmR = new f(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.dFD = bubbleGroupActivity;
        this.dEw = bubbleGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        afV();
        registerListener(this.cok);
        aFo();
        registerListener(this.cmR);
    }

    private void afV() {
        com.baidu.tieba.tbadkCore.a.a.a(309030, BubbleGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309030, CmdConfigHttp.CMD_BUBBLE_CATEGORY, TbConfig.BUBBLE_GROUP_PAGE, BubbleGroupHttpResponseMessage.class, false, false, false, false);
    }

    private void aFo() {
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
        this.dFE = aVar;
    }

    public boolean azO() {
        return this.dEw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW(int i) {
        if (this.dEu != null && this.dEu.size() > 0) {
            for (c cVar : this.dEu) {
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
