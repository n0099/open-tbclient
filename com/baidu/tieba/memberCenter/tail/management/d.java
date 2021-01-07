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
    private TbPageContext<?> eXu;
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lpl;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lpm;
    private boolean lps = false;
    private com.baidu.adp.framework.listener.a lpt = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.management.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m47getResultData;
            if (d.this.lpl != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m47getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m46getResultData();
                } else {
                    m47getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m47getResultData() : null;
                }
                if (m47getResultData != null) {
                    d.this.mTails = m47getResultData.getTails();
                }
                d.this.lpl.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lpu = new com.baidu.adp.framework.listener.a(1003020, CmdConfigSocket.CMD_TAIL_DELETE) { // from class: com.baidu.tieba.memberCenter.tail.management.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.c m45getResultData;
            if (d.this.lpm != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    m45getResultData = ((DeleteTailHttpResponseMessage) responsedMessage).m44getResultData();
                } else {
                    m45getResultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).m45getResultData() : null;
                }
                d.this.lpm.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m45getResultData != null ? Integer.valueOf(m45getResultData.dhE()) : null);
            }
        }
    };
    private CustomMessageListener lpv = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.management.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e) && d.this.lpl != null) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.lov != null && d.this.mTails != null) {
                    if (eVar.lou == 1) {
                        c(eVar);
                    } else if (eVar.lou == 3) {
                        b(eVar);
                    } else if (eVar.lou == 2) {
                        a(eVar);
                    }
                    d.this.lpl.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.mTails.size()) {
                    if (((TailData) d.this.mTails.get(i2)).getId() == eVar.lov.getId()) {
                        ((TailData) d.this.mTails.get(i2)).setContent(eVar.lov.getContent());
                        ((TailData) d.this.mTails.get(i2)).setFontColor(eVar.lov.getFontColor());
                        ((TailData) d.this.mTails.get(i2)).setSelected(eVar.lov.isSelected());
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
                if (((TailData) d.this.mTails.get(i)).getId() == eVar.lov.getId()) {
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
                } else if (((TailData) d.this.mTails.get(i)).getId() != eVar.lov.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                d.this.mTails.add(eVar.lov);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public d(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
        this.eXu.registerListener(this.lpt);
        this.eXu.registerListener(this.lpu);
        this.eXu.registerListener(this.lpv);
    }

    public void dhW() {
        this.eXu.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void FV(int i) {
        this.eXu.sendMessage(new DeleteTailNetMessage(i));
    }

    public int dhX() {
        return 3 - this.mTails.size();
    }

    public void c(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.lpl = aVar;
    }

    public void d(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lpm = aVar;
    }

    public boolean dhY() {
        return this.lps;
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

    public void tO(boolean z) {
        this.lps = z;
    }

    public boolean b(Serializable serializable) {
        if (serializable == null || !(serializable instanceof TailDataList)) {
            dhW();
            return false;
        }
        this.mTails = ((TailDataList) serializable).getTails();
        return true;
    }
}
