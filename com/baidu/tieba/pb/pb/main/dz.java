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
public class dz {
    public com.baidu.tieba.tbadkCore.data.s dmF;
    private a dmK;
    public int loadType;
    private com.baidu.tieba.pb.data.e pbData;
    private String threadTitle;
    public int dmC = 0;
    public int dmD = 0;
    public int dmG = 0;
    public boolean isSquence = true;
    public boolean dmH = false;
    private boolean dmI = false;
    private boolean dmJ = false;
    private CustomMessageListener dmL = new ea(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener dmM = new eb(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i, int i2);

        void ayy();

        void ayz();
    }

    public void u(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
                atVar.bF(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar));
                this.dmG = 5;
            }
            this.dmC = i;
            ayu();
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
        if (this.dmJ) {
            this.dmC = g(i, arrayList);
            this.dmD = f(this.dmC, arrayList);
        } else {
            this.dmC = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
            int i4 = (sVar == null || sVar.aTY() != this.dmD) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.dmC = arrayList.size() - 1;
            return null;
        }
        this.dmC = i3;
        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
        if (arrayList.get(this.dmC) instanceof com.baidu.tieba.tbadkCore.data.s) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = arrayList.get(this.dmC);
            this.dmD = f(this.dmC + 1, arrayList);
            if (sVar2.aTY() == 1) {
                auVar.threadTitle = this.threadTitle;
                if (!this.dmI) {
                    auVar.PL = true;
                } else {
                    auVar.PL = false;
                }
            } else {
                if (sVar2.aTY() != 0) {
                    auVar.PM = String.format(TbadkCoreApplication.m11getInst().getContext().getString(t.j.is_floor), Integer.valueOf(sVar2.aTY()));
                }
                auVar.threadTitle = this.threadTitle;
                auVar.PL = false;
            }
            auVar.PO = sVar2.amz();
            return auVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        return arrayList.get(i).aTY();
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
                if (sVar != null && sVar.aTY() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void ayu() {
        com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
        Object obj = null;
        switch (this.dmG) {
            case 0:
            case 5:
                atVar.bF(1);
                obj = e(this.dmC, this.pbData.avF());
                this.dmG = 1;
                break;
            case 1:
                atVar.bF(2);
                this.dmG = 2;
                break;
            case 2:
                atVar.bF(3);
                this.dmG = 3;
                break;
            case 3:
                atVar.bF(2);
                this.dmG = 2;
                break;
            case 4:
            default:
                atVar.bF(1);
                this.dmG = 1;
                break;
        }
        atVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar));
    }

    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.bF(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar));
            this.dmC = 0;
            this.dmG = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.dmC = 0;
                return;
            }
            com.baidu.tbadk.core.data.at atVar2 = new com.baidu.tbadk.core.data.at();
            atVar2.bF(4);
            this.dmC = 0;
            this.dmG = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar2));
        }
    }

    public dz() {
        MessageManager.getInstance().registerListener(this.dmL);
        MessageManager.getInstance().registerListener(this.dmM);
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2) {
        a(eVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = eVar;
        this.isSquence = z;
        this.dmH = z2;
        this.loadType = i;
        if (eVar != null && eVar.avE() != null) {
            this.threadTitle = eVar.avE().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = eVar.avE().qT();
            }
            this.dmI = eVar.avE().qZ() == 1;
        }
        if (z3) {
            a(eVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.dmC = 0;
        this.dmG = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.dmK = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dmL);
        MessageManager.getInstance().unRegisterListener(this.dmM);
    }

    public int ayv() {
        return this.dmG;
    }

    public void lU(int i) {
        this.dmG = i;
    }

    public int ayw() {
        if (this.pbData == null || this.pbData.avF() == null) {
            return -1;
        }
        if (this.dmC >= 0 && this.dmC < this.pbData.avF().size()) {
            this.dmF = this.pbData.avF().get(this.dmC);
        }
        if (this.dmF != null) {
            return this.dmF.aTY();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.s ayx() {
        if (this.pbData == null || this.pbData.avF() == null) {
            return null;
        }
        if (this.dmC >= 0 && this.dmC < this.pbData.avF().size()) {
            this.dmF = this.pbData.avF().get(this.dmC);
        }
        return this.dmF;
    }
}
