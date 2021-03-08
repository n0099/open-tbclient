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
    private TbPageContext<?> eWx;
    private com.baidu.tieba.memberCenter.tail.a.a<Void> luY;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> luZ;
    private boolean lvf = false;
    private com.baidu.adp.framework.listener.a lvg = new com.baidu.adp.framework.listener.a(1003021, CmdConfigSocket.CMD_TAIL_GET) { // from class: com.baidu.tieba.memberCenter.tail.management.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.d m42getResultData;
            if (d.this.luY != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    m42getResultData = ((GetTailsHttpResponseMessage) responsedMessage).m41getResultData();
                } else {
                    m42getResultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).m42getResultData() : null;
                }
                if (m42getResultData != null) {
                    d.this.mTails = m42getResultData.getTails();
                }
                d.this.luY.b(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lvh = new com.baidu.adp.framework.listener.a(1003020, CmdConfigSocket.CMD_TAIL_DELETE) { // from class: com.baidu.tieba.memberCenter.tail.management.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.c m40getResultData;
            if (d.this.luZ != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    m40getResultData = ((DeleteTailHttpResponseMessage) responsedMessage).m39getResultData();
                } else {
                    m40getResultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).m40getResultData() : null;
                }
                d.this.luZ.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m40getResultData != null ? Integer.valueOf(m40getResultData.dgc()) : null);
            }
        }
    };
    private CustomMessageListener lvi = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_REFRESH) { // from class: com.baidu.tieba.memberCenter.tail.management.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.memberCenter.tail.data.e) && d.this.luY != null) {
                com.baidu.tieba.memberCenter.tail.data.e eVar = (com.baidu.tieba.memberCenter.tail.data.e) customResponsedMessage.getData();
                if (eVar.luj != null && d.this.mTails != null) {
                    if (eVar.lui == 1) {
                        c(eVar);
                    } else if (eVar.lui == 3) {
                        b(eVar);
                    } else if (eVar.lui == 2) {
                        a(eVar);
                    }
                    d.this.luY.b(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
                }
            }
        }

        private void a(com.baidu.tieba.memberCenter.tail.data.e eVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.mTails.size()) {
                    if (((TailData) d.this.mTails.get(i2)).getId() == eVar.luj.getId()) {
                        ((TailData) d.this.mTails.get(i2)).setContent(eVar.luj.getContent());
                        ((TailData) d.this.mTails.get(i2)).setFontColor(eVar.luj.getFontColor());
                        ((TailData) d.this.mTails.get(i2)).setSelected(eVar.luj.isSelected());
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
                if (((TailData) d.this.mTails.get(i)).getId() == eVar.luj.getId()) {
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
                } else if (((TailData) d.this.mTails.get(i)).getId() != eVar.luj.getId()) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                d.this.mTails.add(eVar.luj);
            }
        }
    };
    private List<TailData> mTails = new ArrayList();

    public d(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
        this.eWx.registerListener(this.lvg);
        this.eWx.registerListener(this.lvh);
        this.eWx.registerListener(this.lvi);
    }

    public void dgu() {
        this.eWx.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void EK(int i) {
        this.eWx.sendMessage(new DeleteTailNetMessage(i));
    }

    public int dgv() {
        return 3 - this.mTails.size();
    }

    public void c(com.baidu.tieba.memberCenter.tail.a.a<Void> aVar) {
        this.luY = aVar;
    }

    public void d(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.luZ = aVar;
    }

    public boolean dgw() {
        return this.lvf;
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
        this.lvf = z;
    }

    public boolean b(Serializable serializable) {
        if (serializable == null || !(serializable instanceof TailDataList)) {
            dgu();
            return false;
        }
        this.mTails = ((TailDataList) serializable).getTails();
        return true;
    }
}
