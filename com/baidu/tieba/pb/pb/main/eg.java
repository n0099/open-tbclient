package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class eg {
    public com.baidu.tieba.tbadkCore.data.s dSW;
    private a dTb;
    public int loadType;
    private com.baidu.tieba.pb.data.h pbData;
    private String threadTitle;
    public int dST = 0;
    public int dSU = 0;
    public int dSX = 0;
    public boolean isSquence = true;
    public boolean dSY = false;
    private boolean dSZ = false;
    private boolean dTa = false;
    private CustomMessageListener dTc = new eh(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener dTd = new ei(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aGH();

        void aGI();

        void bb(int i, int i2);
    }

    public void I(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
                avVar.bG(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar));
                this.dSX = 5;
            }
            this.dST = i;
            aGD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (this.dTa) {
            this.dST = g(i, arrayList);
            this.dSU = f(this.dST, arrayList);
        } else {
            this.dST = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
            int i4 = (sVar == null || sVar.bcm() != this.dSU) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.dST = arrayList.size() - 1;
            return null;
        }
        this.dST = i3;
        com.baidu.tbadk.core.data.aw awVar = new com.baidu.tbadk.core.data.aw();
        if (arrayList.get(this.dST) instanceof com.baidu.tieba.tbadkCore.data.s) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = arrayList.get(this.dST);
            this.dSU = f(this.dST + 1, arrayList);
            if (sVar2.bcm() == 1) {
                awVar.threadTitle = this.threadTitle;
                if (!this.dSZ) {
                    awVar.PX = true;
                } else {
                    awVar.PX = false;
                }
            } else {
                if (sVar2.bcm() != 0) {
                    awVar.PY = String.format(TbadkCoreApplication.m9getInst().getContext().getString(u.j.is_floor), Integer.valueOf(sVar2.bcm()));
                }
                awVar.threadTitle = this.threadTitle;
                awVar.PX = false;
            }
            awVar.Qa = sVar2.auL();
            return awVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        return arrayList.get(i).bcm();
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
                if (sVar != null && sVar.bcm() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aGD() {
        com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
        Object obj = null;
        switch (this.dSX) {
            case 0:
            case 5:
                avVar.bG(1);
                obj = e(this.dST, this.pbData.aDP());
                this.dSX = 1;
                break;
            case 1:
                avVar.bG(2);
                this.dSX = 2;
                break;
            case 2:
                avVar.bG(3);
                this.dSX = 3;
                break;
            case 3:
                avVar.bG(2);
                this.dSX = 2;
                break;
            case 4:
            default:
                avVar.bG(1);
                this.dSX = 1;
                break;
        }
        avVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar));
    }

    private void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
            avVar.bG(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar));
            this.dST = 0;
            this.dSX = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.dST = 0;
                return;
            }
            com.baidu.tbadk.core.data.av avVar2 = new com.baidu.tbadk.core.data.av();
            avVar2.bG(4);
            this.dST = 0;
            this.dSX = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar2));
        }
    }

    public eg() {
        MessageManager.getInstance().registerListener(this.dTc);
        MessageManager.getInstance().registerListener(this.dTd);
    }

    public void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        a(hVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = hVar;
        this.isSquence = z;
        this.dSY = z2;
        this.loadType = i;
        if (hVar != null && hVar.aDO() != null) {
            this.threadTitle = hVar.aDO().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = hVar.aDO().qO();
            }
            this.dSZ = hVar.aDO().qU() == 1;
        }
        if (z3) {
            a(hVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.dST = 0;
        this.dSX = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.dTb = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dTc);
        MessageManager.getInstance().unRegisterListener(this.dTd);
    }

    public int aGE() {
        return this.dSX;
    }

    public void nt(int i) {
        this.dSX = i;
    }

    public int aGF() {
        if (this.pbData == null || this.pbData.aDP() == null) {
            return -1;
        }
        if (this.dST >= 0 && this.dST < this.pbData.aDP().size()) {
            this.dSW = this.pbData.aDP().get(this.dST);
        }
        if (this.dSW != null) {
            return this.dSW.bcm();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.s aGG() {
        if (this.pbData == null || this.pbData.aDP() == null) {
            return null;
        }
        if (this.dST >= 0 && this.dST < this.pbData.aDP().size()) {
            this.dSW = this.pbData.aDP().get(this.dST);
        }
        return this.dSW;
    }
}
