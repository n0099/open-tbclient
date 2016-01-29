package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dn {
    private com.baidu.tieba.tbadkCore.data.r cPP;
    private a cPU;
    private int loadType;
    private com.baidu.tieba.pb.a.c pbData;
    private String threadTitle;
    private int cPN = 0;
    private int cPQ = 0;
    private boolean isSquence = true;
    private boolean cPR = false;
    private boolean cPS = false;
    private boolean cPT = false;
    private CustomMessageListener cPV = new Cdo(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener cPW = new dp(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i, int i2);

        void aqG();

        void aqH();
    }

    public void s(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                adVar.bS(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar));
                this.cPQ = 5;
            }
            this.cPN = i;
            aqA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(int i, ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= arrayList.size()) {
            this.cPN = arrayList.size() - 1;
            return null;
        }
        if (this.cPT) {
            this.cPN = f(i, arrayList);
        } else {
            this.cPN = i;
        }
        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
        if (arrayList.get(this.cPN) instanceof com.baidu.tieba.tbadkCore.data.r) {
            com.baidu.tieba.tbadkCore.data.r rVar = arrayList.get(this.cPN);
            if (rVar.aMw() == 1) {
                aeVar.threadTitle = this.threadTitle;
                if (!this.cPS) {
                    aeVar.Wx = true;
                } else {
                    aeVar.Wx = false;
                }
            } else {
                if (rVar.aMw() != 0) {
                    aeVar.Wy = String.format(TbadkCoreApplication.m411getInst().getContext().getString(t.j.is_floor), Integer.valueOf(rVar.aMw()));
                }
                aeVar.threadTitle = this.threadTitle;
                aeVar.Wx = false;
            }
            aeVar.WA = rVar.aiT();
            return aeVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.r rVar = arrayList.get(i2);
                if (rVar != null && rVar.aMw() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aqA() {
        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
        Object obj = null;
        switch (this.cPQ) {
            case 0:
            case 5:
                adVar.bS(1);
                obj = e(this.cPN, this.pbData.aoG());
                this.cPQ = 1;
                break;
            case 1:
                adVar.bS(2);
                this.cPQ = 2;
                break;
            case 2:
                adVar.bS(3);
                this.cPQ = 3;
                break;
            case 3:
                adVar.bS(2);
                this.cPQ = 2;
                break;
            case 4:
            default:
                adVar.bS(1);
                this.cPQ = 1;
                break;
        }
        adVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar));
    }

    private void a(com.baidu.tieba.pb.a.c cVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
            adVar.bS(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar));
            this.cPN = 0;
            this.cPQ = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.cPN = 0;
                return;
            }
            com.baidu.tbadk.core.data.ad adVar2 = new com.baidu.tbadk.core.data.ad();
            adVar2.bS(4);
            this.cPN = 0;
            this.cPQ = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar2));
        }
    }

    public dn() {
        MessageManager.getInstance().registerListener(this.cPV);
        MessageManager.getInstance().registerListener(this.cPW);
    }

    public void b(com.baidu.tieba.pb.a.c cVar, boolean z, int i, boolean z2) {
        a(cVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = cVar;
        this.isSquence = z;
        this.cPR = z2;
        this.loadType = i;
        if (cVar != null && cVar.aoF() != null) {
            this.threadTitle = cVar.aoF().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = cVar.aoF().tr();
            }
            this.cPS = cVar.aoF().tx() == 1;
        }
        if (z3) {
            a(cVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.cPN = 0;
        this.cPQ = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.cPU = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.cPV);
        MessageManager.getInstance().unRegisterListener(this.cPW);
    }

    public int aqB() {
        return this.cPQ;
    }

    public void kY(int i) {
        this.cPQ = i;
    }

    public int aqC() {
        return this.cPN;
    }

    public boolean anx() {
        return this.isSquence;
    }

    public boolean aqD() {
        return this.cPR;
    }

    public int aqE() {
        if (this.pbData == null || this.pbData.aoG() == null) {
            return -1;
        }
        if (this.cPN >= 0 && this.cPN < this.pbData.aoG().size()) {
            this.cPP = this.pbData.aoG().get(this.cPN);
        }
        if (this.cPP != null) {
            return this.cPP.aMw();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.r aqF() {
        if (this.pbData == null || this.pbData.aoG() == null) {
            return null;
        }
        if (this.cPN >= 0 && this.cPN < this.pbData.aoG().size()) {
            this.cPP = this.pbData.aoG().get(this.cPN);
        }
        return this.cPP;
    }
}
