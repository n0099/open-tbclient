package com.baidu.tieba.memberCenter.tail.management;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private TbPageContext<?> eUY;
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lsH;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsI;
    private boolean lsO = false;
    private com.baidu.adp.framework.listener.a lsP = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.management.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m41getResultData;
            if (d.this.lsH != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m41getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m40getResultData();
                } else {
                    m41getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m41getResultData() : null;
                }
                if (m41getResultData != null) {
                    d.this.mTails = m41getResultData.getTails();
                }
                d.this.lsH.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lsQ = new com.baidu.adp.framework.listener.a(1003020, CmdConfigSocket.CMD_TAIL_DELETE) { // from class: com.baidu.tieba.memberCenter.tail.management.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.c m39getResultData;
            if (d.this.lsI != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    m39getResultData = ((DeleteTailHttpResponseMessage) responsedMessage).m38getResultData();
                } else {
                    m39getResultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).m39getResultData() : null;
                }
                d.this.lsI.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m39getResultData != null ? Integer.valueOf(m39getResultData.dfM()) : null);
            }
        }
    };
    private CustomMessageListener lsR = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.management.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e) && d.this.lsH != null) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.lrS != null && d.this.mTails != null) {
                    if (eVar.lrR == 1) {
                        c(eVar);
                    } else if (eVar.lrR == 3) {
                        b(eVar);
                    } else if (eVar.lrR == 2) {
                        a(eVar);
                    }
                    d.this.lsH.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.mTails.size()) {
                    if (((TailData) d.this.mTails.get(i2)).getId() == eVar.lrS.getId()) {
                        ((TailData) d.this.mTails.get(i2)).setContent(eVar.lrS.getContent());
                        ((TailData) d.this.mTails.get(i2)).setFontColor(eVar.lrS.getFontColor());
                        ((TailData) d.this.mTails.get(i2)).setSelected(eVar.lrS.isSelected());
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
            for (int i = 0; i < d.this.mTails.size(); i++) {
                if (((TailData) d.this.mTails.get(i)).getId() == eVar.lrS.getId()) {
                    d.this.mTails.remove(i);
                    if (d.this.mTails.size() != 0) {
                        Iterator it = d.this.mTails.iterator();
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
                if (i >= d.this.mTails.size()) {
                    break;
                } else if (((TailData) d.this.mTails.get(i)).getId() != eVar.lrS.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                d.this.mTails.add(eVar.lrS);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public d(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
        this.eUY.registerListener(this.lsP);
        this.eUY.registerListener(this.lsQ);
        this.eUY.registerListener(this.lsR);
    }

    public void dge() {
        this.eUY.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void EH(int i) {
        this.eUY.sendMessage(new DeleteTailNetMessage(i));
    }

    public int dgf() {
        return 3 - this.mTails.size();
    }

    public void c(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lsH = aVar;
    }

    public void d(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lsI = aVar;
    }

    public boolean dgg() {
        return this.lsO;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void eT(List<TailData> list) {
        if (list == null) {
            this.mTails.clear();
        } else {
            this.mTails = list;
        }
    }

    public void tX(boolean z) {
        this.lsO = z;
    }

    public boolean b(Serializable serializable) {
        if (serializable == null || !(serializable instanceof TailDataList)) {
            dge();
            return false;
        }
        this.mTails = ((TailDataList) serializable).getTails();
        return true;
    }
}
