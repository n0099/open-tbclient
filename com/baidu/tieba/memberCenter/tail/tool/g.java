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
/* loaded from: classes8.dex */
public class g {
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lkB;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lla;
    private Boolean lll = false;
    private boolean llm = false;
    private com.baidu.adp.framework.listener.a lkJ = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m42getResultData;
            if (g.this.lkB != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m42getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m41getResultData();
                } else {
                    m42getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m42getResultData() : null;
                }
                if (m42getResultData != null) {
                    g.this.mTails = new ArrayList();
                    if (m42getResultData.getTails() != null) {
                        for (TailData tailData : m42getResultData.getTails()) {
                            TailData tailData2 = new TailData();
                            tailData2.setId(tailData.getId());
                            tailData2.setContent(tailData.getContent());
                            tailData2.setFontColor(tailData.getFontColor());
                            tailData2.setFontType(tailData.getFontType());
                            tailData2.setSelected(tailData.isSelected());
                            g.this.mTails.add(tailData2);
                        }
                    }
                    g.this.lkB.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                    g.this.dej();
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lln = new com.baidu.adp.framework.listener.a(1003022, CmdConfigSocket.CMD_TAIL_SET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.f m44getResultData;
            if (g.this.lkB != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    m44getResultData = ((SetTailHttpResponseMessage) responsedMessage).m43getResultData();
                } else {
                    m44getResultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).m44getResultData() : null;
                }
                g.this.lla.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m44getResultData != null ? Integer.valueOf(m44getResultData.ddM()) : null);
            }
        }
    };
    private CustomMessageListener lkL = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e)) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.ljM != null && g.this.mTails != null) {
                    if (eVar.ljL == 1) {
                        c(eVar);
                    } else if (eVar.ljL == 3) {
                        b(eVar);
                    } else if (eVar.ljL == 2) {
                        a(eVar);
                    }
                    g.this.lkB.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.mTails.size()) {
                    if (((TailData) g.this.mTails.get(i2)).getId() == eVar.ljM.getId()) {
                        ((TailData) g.this.mTails.get(i2)).setContent(eVar.ljM.getContent());
                        ((TailData) g.this.mTails.get(i2)).setFontColor(eVar.ljM.getFontColor());
                        ((TailData) g.this.mTails.get(i2)).setSelected(eVar.ljM.isSelected());
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
                if (((TailData) g.this.mTails.get(i)).getId() == eVar.ljM.getId()) {
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
                } else if (((TailData) g.this.mTails.get(i)).getId() != eVar.ljM.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                g.this.mTails.add(eVar.ljM);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public g(Context context) {
        dep();
    }

    public void dee() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dej() {
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

    private void dep() {
        this.lll = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean deq() {
        return this.lll.booleanValue();
    }

    public void der() {
        MessageManager.getInstance().unRegisterListener(this.lkJ);
        MessageManager.getInstance().unRegisterListener(this.lln);
        MessageManager.getInstance().unRegisterListener(this.lkL);
    }

    public void onAttached() {
        MessageManager.getInstance().registerListener(this.lkJ);
        MessageManager.getInstance().registerListener(this.lln);
        MessageManager.getInstance().registerListener(this.lkL);
    }

    public void e(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lkB = aVar;
    }

    public void f(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lla = aVar;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void tM(boolean z) {
        this.llm = z;
    }

    public boolean des() {
        return this.llm;
    }
}
