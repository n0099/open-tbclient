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
/* loaded from: classes8.dex */
public class d {
    private TbPageContext<?> eSJ;
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lkB;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lkC;
    private boolean lkI = false;
    private com.baidu.adp.framework.listener.a lkJ = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.management.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m42getResultData;
            if (d.this.lkB != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m42getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m41getResultData();
                } else {
                    m42getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m42getResultData() : null;
                }
                if (m42getResultData != null) {
                    d.this.mTails = m42getResultData.getTails();
                }
                d.this.lkB.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lkK = new com.baidu.adp.framework.listener.a(1003020, CmdConfigSocket.CMD_TAIL_DELETE) { // from class: com.baidu.tieba.memberCenter.tail.management.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.c m40getResultData;
            if (d.this.lkC != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    m40getResultData = ((DeleteTailHttpResponseMessage) responsedMessage).m39getResultData();
                } else {
                    m40getResultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).m40getResultData() : null;
                }
                d.this.lkC.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m40getResultData != null ? Integer.valueOf(m40getResultData.ddM()) : null);
            }
        }
    };
    private CustomMessageListener lkL = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.management.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e) && d.this.lkB != null) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.ljM != null && d.this.mTails != null) {
                    if (eVar.ljL == 1) {
                        c(eVar);
                    } else if (eVar.ljL == 3) {
                        b(eVar);
                    } else if (eVar.ljL == 2) {
                        a(eVar);
                    }
                    d.this.lkB.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.mTails.size()) {
                    if (((TailData) d.this.mTails.get(i2)).getId() == eVar.ljM.getId()) {
                        ((TailData) d.this.mTails.get(i2)).setContent(eVar.ljM.getContent());
                        ((TailData) d.this.mTails.get(i2)).setFontColor(eVar.ljM.getFontColor());
                        ((TailData) d.this.mTails.get(i2)).setSelected(eVar.ljM.isSelected());
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
                if (((TailData) d.this.mTails.get(i)).getId() == eVar.ljM.getId()) {
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
                } else if (((TailData) d.this.mTails.get(i)).getId() != eVar.ljM.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                d.this.mTails.add(eVar.ljM);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public d(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
        this.eSJ.registerListener(this.lkJ);
        this.eSJ.registerListener(this.lkK);
        this.eSJ.registerListener(this.lkL);
    }

    public void dee() {
        this.eSJ.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void Ep(int i) {
        this.eSJ.sendMessage(new DeleteTailNetMessage(i));
    }

    public int def() {
        return 3 - this.mTails.size();
    }

    public void c(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lkB = aVar;
    }

    public void d(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lkC = aVar;
    }

    public boolean deg() {
        return this.lkI;
    }

    public List<TailData> getTails() {
        return this.mTails;
    }

    public void eV(List<TailData> list) {
        if (list == null) {
            this.mTails.clear();
        } else {
            this.mTails = list;
        }
    }

    public void tK(boolean z) {
        this.lkI = z;
    }

    public boolean b(Serializable serializable) {
        if (serializable == null || !(serializable instanceof TailDataList)) {
            dee();
            return false;
        }
        this.mTails = ((TailDataList) serializable).getTails();
        return true;
    }
}
