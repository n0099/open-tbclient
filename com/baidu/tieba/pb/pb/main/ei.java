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
public class ei {
    private com.baidu.tieba.tbadkCore.data.s dkg;
    private a dkl;
    private int loadType;
    private com.baidu.tieba.pb.data.e pbData;
    private String threadTitle;
    private int dke = 0;
    private int dkh = 0;
    private boolean isSquence = true;
    private boolean dki = false;
    private boolean dkj = false;
    private boolean dkk = false;
    private CustomMessageListener dkm = new ej(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener dkn = new ek(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aM(int i, int i2);

        void axW();

        void axX();
    }

    public void s(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                aoVar.bU(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar));
                this.dkh = 5;
            }
            this.dke = i;
            axQ();
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
        if (i >= arrayList.size()) {
            this.dke = arrayList.size() - 1;
            return null;
        }
        if (this.dkk) {
            this.dke = f(i, arrayList);
        } else {
            this.dke = i;
        }
        com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
        if (arrayList.get(this.dke) instanceof com.baidu.tieba.tbadkCore.data.s) {
            com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(this.dke);
            if (sVar.aTs() == 1) {
                apVar.threadTitle = this.threadTitle;
                if (!this.dkj) {
                    apVar.UM = true;
                } else {
                    apVar.UM = false;
                }
            } else {
                if (sVar.aTs() != 0) {
                    apVar.UN = String.format(TbadkCoreApplication.m411getInst().getContext().getString(t.j.is_floor), Integer.valueOf(sVar.aTs()));
                }
                apVar.threadTitle = this.threadTitle;
                apVar.UM = false;
            }
            apVar.UQ = sVar.amn();
            return apVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
                if (sVar != null && sVar.aTs() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void axQ() {
        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
        Object obj = null;
        switch (this.dkh) {
            case 0:
            case 5:
                aoVar.bU(1);
                obj = e(this.dke, this.pbData.avw());
                this.dkh = 1;
                break;
            case 1:
                aoVar.bU(2);
                this.dkh = 2;
                break;
            case 2:
                aoVar.bU(3);
                this.dkh = 3;
                break;
            case 3:
                aoVar.bU(2);
                this.dkh = 2;
                break;
            case 4:
            default:
                aoVar.bU(1);
                this.dkh = 1;
                break;
        }
        aoVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar));
    }

    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.bU(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar));
            this.dke = 0;
            this.dkh = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.dke = 0;
                return;
            }
            com.baidu.tbadk.core.data.ao aoVar2 = new com.baidu.tbadk.core.data.ao();
            aoVar2.bU(4);
            this.dke = 0;
            this.dkh = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar2));
        }
    }

    public ei() {
        MessageManager.getInstance().registerListener(this.dkm);
        MessageManager.getInstance().registerListener(this.dkn);
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2) {
        a(eVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = eVar;
        this.isSquence = z;
        this.dki = z2;
        this.loadType = i;
        if (eVar != null && eVar.avv() != null) {
            this.threadTitle = eVar.avv().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = eVar.avv().tu();
            }
            this.dkj = eVar.avv().tA() == 1;
        }
        if (z3) {
            a(eVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.dke = 0;
        this.dkh = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.dkl = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dkm);
        MessageManager.getInstance().unRegisterListener(this.dkn);
    }

    public int axR() {
        return this.dkh;
    }

    public void mg(int i) {
        this.dkh = i;
    }

    public int axS() {
        return this.dke;
    }

    public boolean auq() {
        return this.isSquence;
    }

    public boolean axT() {
        return this.dki;
    }

    public int axU() {
        if (this.pbData == null || this.pbData.avw() == null) {
            return -1;
        }
        if (this.dke >= 0 && this.dke < this.pbData.avw().size()) {
            this.dkg = this.pbData.avw().get(this.dke);
        }
        if (this.dkg != null) {
            return this.dkg.aTs();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.s axV() {
        if (this.pbData == null || this.pbData.avw() == null) {
            return null;
        }
        if (this.dke >= 0 && this.dke < this.pbData.avw().size()) {
            this.dkg = this.pbData.avw().get(this.dke);
        }
        return this.dkg;
    }
}
