package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lsV;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> ltv;
    private Boolean ltG = false;
    private boolean ltH = false;
    private com.baidu.adp.framework.listener.a ltd = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m41getResultData;
            if (g.this.lsV != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m41getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m40getResultData();
                } else {
                    m41getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m41getResultData() : null;
                }
                if (m41getResultData != null) {
                    g.this.mTails = new ArrayList();
                    if (m41getResultData.getTails() != null) {
                        for (TailData tailData : m41getResultData.getTails()) {
                            TailData tailData2 = new TailData();
                            tailData2.setId(tailData.getId());
                            tailData2.setContent(tailData.getContent());
                            tailData2.setFontColor(tailData.getFontColor());
                            tailData2.setFontType(tailData.getFontType());
                            tailData2.setSelected(tailData.isSelected());
                            g.this.mTails.add(tailData2);
                        }
                    }
                    g.this.lsV.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                    g.this.dgq();
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ltI = new com.baidu.adp.framework.listener.a(1003022, CmdConfigSocket.CMD_TAIL_SET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.f m43getResultData;
            if (g.this.lsV != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    m43getResultData = ((SetTailHttpResponseMessage) responsedMessage).m42getResultData();
                } else {
                    m43getResultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).m43getResultData() : null;
                }
                g.this.ltv.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m43getResultData != null ? Integer.valueOf(m43getResultData.dfT()) : null);
            }
        }
    };
    private CustomMessageListener ltf = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e)) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.lsg != null && g.this.mTails != null) {
                    if (eVar.lsf == 1) {
                        c(eVar);
                    } else if (eVar.lsf == 3) {
                        b(eVar);
                    } else if (eVar.lsf == 2) {
                        a(eVar);
                    }
                    g.this.lsV.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.mTails.size()) {
                    if (((TailData) g.this.mTails.get(i2)).getId() == eVar.lsg.getId()) {
                        ((TailData) g.this.mTails.get(i2)).setContent(eVar.lsg.getContent());
                        ((TailData) g.this.mTails.get(i2)).setFontColor(eVar.lsg.getFontColor());
                        ((TailData) g.this.mTails.get(i2)).setSelected(eVar.lsg.isSelected());
                        return;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        private void b(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            boolean z = false;
            for (int i = 0; i < g.this.mTails.size(); i++) {
                if (((TailData) g.this.mTails.get(i)).getId() == eVar.lsg.getId()) {
                    g.this.mTails.remove(i);
                    if (g.this.mTails.size() != 0) {
                        Iterator it = g.this.mTails.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((TailData) it.next()).isSelected()) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT, Boolean.valueOf(z)));
                    return;
                }
            }
        }

        private void c(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= g.this.mTails.size()) {
                    break;
                } else if (((TailData) g.this.mTails.get(i)).getId() != eVar.lsg.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                g.this.mTails.add(eVar.lsg);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public g(Context context) {
        dgw();
    }

    public void dgl() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgq() {
        boolean z;
        Iterator<TailData> it = this.mTails.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().isSelected()) {
                z = true;
                break;
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT, Boolean.valueOf(z)));
    }

    public void ab(int i, boolean z) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, z ? 1 : 0));
    }

    private void dgw() {
        this.ltG = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean dgx() {
        return this.ltG.booleanValue();
    }

    public void dgy() {
        MessageManager.getInstance().unRegisterListener(this.ltd);
        MessageManager.getInstance().unRegisterListener(this.ltI);
        MessageManager.getInstance().unRegisterListener(this.ltf);
    }

    public void onAttached() {
        MessageManager.getInstance().registerListener(this.ltd);
        MessageManager.getInstance().registerListener(this.ltI);
        MessageManager.getInstance().registerListener(this.ltf);
    }

    public void e(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lsV = aVar;
    }

    public void f(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.ltv = aVar;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void tZ(boolean z) {
        this.ltH = z;
    }

    public boolean dgz() {
        return this.ltH;
    }
}
