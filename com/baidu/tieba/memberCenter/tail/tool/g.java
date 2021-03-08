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
    private com.baidu.tieba.memberCenter.tail.a.a<Void> luY;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lvx;
    private Boolean lvI = false;
    private boolean lvJ = false;
    private com.baidu.adp.framework.listener.a lvg = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m42getResultData;
            if (g.this.luY != null) {
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
                    g.this.luY.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                    g.this.dgz();
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lvK = new com.baidu.adp.framework.listener.a(1003022, CmdConfigSocket.CMD_TAIL_SET) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.f m44getResultData;
            if (g.this.luY != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    m44getResultData = ((SetTailHttpResponseMessage) responsedMessage).m43getResultData();
                } else {
                    m44getResultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).m44getResultData() : null;
                }
                g.this.lvx.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m44getResultData != null ? Integer.valueOf(m44getResultData.dgc()) : null);
            }
        }
    };
    private CustomMessageListener lvi = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.tool.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e)) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.luj != null && g.this.mTails != null) {
                    if (eVar.lui == 1) {
                        c(eVar);
                    } else if (eVar.lui == 3) {
                        b(eVar);
                    } else if (eVar.lui == 2) {
                        a(eVar);
                    }
                    g.this.luY.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.this.mTails.size()) {
                    if (((TailData) g.this.mTails.get(i2)).getId() == eVar.luj.getId()) {
                        ((TailData) g.this.mTails.get(i2)).setContent(eVar.luj.getContent());
                        ((TailData) g.this.mTails.get(i2)).setFontColor(eVar.luj.getFontColor());
                        ((TailData) g.this.mTails.get(i2)).setSelected(eVar.luj.isSelected());
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
                if (((TailData) g.this.mTails.get(i)).getId() == eVar.luj.getId()) {
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
                } else if (((TailData) g.this.mTails.get(i)).getId() != eVar.luj.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                g.this.mTails.add(eVar.luj);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public g(Context context) {
        dgF();
    }

    public void dgu() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgz() {
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

    private void dgF() {
        this.lvI = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean dgG() {
        return this.lvI.booleanValue();
    }

    public void dgH() {
        MessageManager.getInstance().unRegisterListener(this.lvg);
        MessageManager.getInstance().unRegisterListener(this.lvK);
        MessageManager.getInstance().unRegisterListener(this.lvi);
    }

    public void onAttached() {
        MessageManager.getInstance().registerListener(this.lvg);
        MessageManager.getInstance().registerListener(this.lvK);
        MessageManager.getInstance().registerListener(this.lvi);
    }

    public void e(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.luY = aVar;
    }

    public void f(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lvx = aVar;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void tZ(boolean z) {
        this.lvJ = z;
    }

    public boolean dgI() {
        return this.lvJ;
    }
}
