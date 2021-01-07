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
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lpK;
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lpl;
    private Boolean lpV = false;
    private boolean lpW = false;
    private com.baidu.adp.framework.listener.a lpt = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m47getResultData;
            if (g.this.lpl != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m47getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m46getResultData();
                } else {
                    m47getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m47getResultData() : null;
                }
                if (m47getResultData != null) {
                    g.this.mTails = new ArrayList();
                    if (m47getResultData.getTails() != null) {
                        for (TailData tailData : m47getResultData.getTails()) {
                            TailData tailData2 = new TailData();
                            tailData2.setId(tailData.getId());
                            tailData2.setContent(tailData.getContent());
                            tailData2.setFontColor(tailData.getFontColor());
                            tailData2.setFontType(tailData.getFontType());
                            tailData2.setSelected(tailData.isSelected());
                            g.this.mTails.add(tailData2);
                        }
                    }
                    g.this.lpl.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                    g.this.dib();
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lpX = new com.baidu.adp.framework.listener.a(1003022, CmdConfigSocket.CMD_TAIL_SET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.f m49getResultData;
            if (g.this.lpl != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    m49getResultData = ((SetTailHttpResponseMessage) responsedMessage).m48getResultData();
                } else {
                    m49getResultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).m49getResultData() : null;
                }
                g.this.lpK.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m49getResultData != null ? Integer.valueOf(m49getResultData.dhE()) : null);
            }
        }
    };
    private CustomMessageListener lpv = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e)) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.lov != null && g.this.mTails != null) {
                    if (eVar.lou == 1) {
                        c(eVar);
                    } else if (eVar.lou == 3) {
                        b(eVar);
                    } else if (eVar.lou == 2) {
                        a(eVar);
                    }
                    g.this.lpl.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.mTails.size()) {
                    if (((TailData) g.this.mTails.get(i2)).getId() == eVar.lov.getId()) {
                        ((TailData) g.this.mTails.get(i2)).setContent(eVar.lov.getContent());
                        ((TailData) g.this.mTails.get(i2)).setFontColor(eVar.lov.getFontColor());
                        ((TailData) g.this.mTails.get(i2)).setSelected(eVar.lov.isSelected());
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
                if (((TailData) g.this.mTails.get(i)).getId() == eVar.lov.getId()) {
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
                } else if (((TailData) g.this.mTails.get(i)).getId() != eVar.lov.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                g.this.mTails.add(eVar.lov);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public g(Context context) {
        dih();
    }

    public void dhW() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dib() {
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

    private void dih() {
        this.lpV = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean dii() {
        return this.lpV.booleanValue();
    }

    public void dij() {
        MessageManager.getInstance().unRegisterListener(this.lpt);
        MessageManager.getInstance().unRegisterListener(this.lpX);
        MessageManager.getInstance().unRegisterListener(this.lpv);
    }

    public void onAttached() {
        MessageManager.getInstance().registerListener(this.lpt);
        MessageManager.getInstance().registerListener(this.lpX);
        MessageManager.getInstance().registerListener(this.lpv);
    }

    public void e(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lpl = aVar;
    }

    public void f(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lpK = aVar;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void tQ(boolean z) {
        this.lpW = z;
    }

    public boolean dik() {
        return this.lpW;
    }
}
