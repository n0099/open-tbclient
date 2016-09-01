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
public class eh {
    public com.baidu.tieba.tbadkCore.data.q ers;
    private a erx;
    public int loadType;
    private com.baidu.tieba.pb.data.h pbData;
    private String threadTitle;
    public int erp = 0;
    public int erq = 0;
    public int ert = 0;
    public boolean isSquence = true;
    public boolean eru = false;
    private boolean erv = false;
    private boolean erw = false;
    private CustomMessageListener ery = new ei(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener erz = new ej(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aOL();

        void aOM();

        void bi(int i, int i2);
    }

    public void M(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
                bcVar.bS(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
                this.ert = 5;
            }
            this.erp = i;
            aOH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (this.erw) {
            this.erp = g(i, arrayList);
            this.erq = f(this.erp, arrayList);
        } else {
            this.erp = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
            int i4 = (qVar == null || qVar.bjc() != this.erq) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.erp = arrayList.size() - 1;
            return null;
        }
        this.erp = i3;
        com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
        if (arrayList.get(this.erp) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = arrayList.get(this.erp);
            this.erq = f(this.erp + 1, arrayList);
            if (qVar2.bjc() == 1) {
                bdVar.threadTitle = this.threadTitle;
                if (!this.erv) {
                    bdVar.Tb = true;
                } else {
                    bdVar.Tb = false;
                }
            } else {
                if (qVar2.bjc() != 0) {
                    bdVar.Tc = String.format(TbadkCoreApplication.m9getInst().getContext().getString(t.j.is_floor), Integer.valueOf(qVar2.bjc()));
                }
                bdVar.threadTitle = this.threadTitle;
                bdVar.Tb = false;
            }
            bdVar.Te = qVar2.aAk();
            return bdVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bjc = arrayList.get(i).bjc();
        if (i > 0 && bjc == 0) {
            return this.erq + 1;
        }
        return bjc;
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
                if (qVar != null && qVar.bjc() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aOH() {
        com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
        Object obj = null;
        switch (this.ert) {
            case 0:
            case 5:
                bcVar.bS(1);
                obj = e(this.erp, this.pbData.aLR());
                this.ert = 1;
                break;
            case 1:
                bcVar.bS(2);
                this.ert = 2;
                break;
            case 2:
                bcVar.bS(3);
                this.ert = 3;
                break;
            case 3:
                bcVar.bS(2);
                this.ert = 2;
                break;
            case 4:
            default:
                bcVar.bS(1);
                this.ert = 1;
                break;
        }
        bcVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
    }

    private void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
            bcVar.bS(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
            this.erp = 0;
            this.ert = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.erp = 0;
                return;
            }
            com.baidu.tbadk.core.data.bc bcVar2 = new com.baidu.tbadk.core.data.bc();
            bcVar2.bS(4);
            this.erp = 0;
            this.ert = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar2));
        }
    }

    public eh() {
        MessageManager.getInstance().registerListener(this.ery);
        MessageManager.getInstance().registerListener(this.erz);
    }

    public void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        a(hVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = hVar;
        this.isSquence = z;
        this.eru = z2;
        this.loadType = i;
        if (hVar != null && hVar.aLQ() != null) {
            this.threadTitle = hVar.aLQ().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = hVar.aLQ().rI();
            }
            this.erv = hVar.aLQ().rP() == 1;
        }
        if (z3) {
            a(hVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.erp = 0;
        this.ert = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.erx = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ery);
        MessageManager.getInstance().unRegisterListener(this.erz);
    }

    public int aOI() {
        return this.ert;
    }

    public void op(int i) {
        this.ert = i;
    }

    public int aOJ() {
        if (this.pbData == null || this.pbData.aLR() == null) {
            return -1;
        }
        if (this.erp >= 0 && this.erp < this.pbData.aLR().size()) {
            this.ers = this.pbData.aLR().get(this.erp);
        }
        if (this.ers != null) {
            return this.ers.bjc();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.q aOK() {
        if (this.pbData == null || this.pbData.aLR() == null) {
            return null;
        }
        if (this.erp >= 0 && this.erp < this.pbData.aLR().size()) {
            this.ers = this.pbData.aLR().get(this.erp);
        }
        return this.ers;
    }
}
