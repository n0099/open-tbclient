package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ei {
    public com.baidu.tieba.tbadkCore.data.p emV;
    private a ena;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int emS = 0;
    public int emT = 0;
    public int emW = 0;
    public boolean isSquence = true;
    public boolean emX = false;
    private boolean emY = false;
    private boolean emZ = false;
    private CustomMessageListener enb = new ej(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener enc = new ek(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aNd();

        void aNe();

        void bb(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
                bdVar.bR(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar));
                this.emW = 5;
            }
            this.emS = i;
            aMZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(int i, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (this.emZ) {
            this.emS = d(i, arrayList);
            this.emT = c(this.emS, arrayList);
        } else {
            this.emS = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.p pVar = arrayList.get(i2);
            int i4 = (pVar == null || pVar.bhQ() != this.emT) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.emS = arrayList.size() - 1;
            return null;
        }
        this.emS = i3;
        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
        if (arrayList.get(this.emS) instanceof com.baidu.tieba.tbadkCore.data.p) {
            com.baidu.tieba.tbadkCore.data.p pVar2 = arrayList.get(this.emS);
            this.emT = c(this.emS + 1, arrayList);
            if (pVar2.bhQ() == 1) {
                beVar.threadTitle = this.threadTitle;
                if (!this.emY) {
                    beVar.So = true;
                } else {
                    beVar.So = false;
                }
            } else {
                if (pVar2.bhQ() != 0) {
                    beVar.Sp = String.format(TbadkCoreApplication.m9getInst().getContext().getString(r.l.is_floor), Integer.valueOf(pVar2.bhQ()));
                }
                beVar.threadTitle = this.threadTitle;
                beVar.So = false;
            }
            beVar.Sr = pVar2.awW();
            return beVar;
        }
        return null;
    }

    private int c(int i, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bhQ = arrayList.get(i).bhQ();
        if (i > 0 && bhQ == 0) {
            return this.emT + 1;
        }
        return bhQ;
    }

    private int d(int i, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.p pVar = arrayList.get(i2);
                if (pVar != null && pVar.bhQ() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aMZ() {
        com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
        Object obj = null;
        switch (this.emW) {
            case 0:
            case 5:
                bdVar.bR(1);
                obj = b(this.emS, this.pbData.aKb());
                this.emW = 1;
                break;
            case 1:
                bdVar.bR(2);
                this.emW = 2;
                break;
            case 2:
                bdVar.bR(3);
                this.emW = 3;
                break;
            case 3:
                bdVar.bR(2);
                this.emW = 2;
                break;
            case 4:
            default:
                bdVar.bR(1);
                this.emW = 1;
                break;
        }
        bdVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
            bdVar.bR(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar));
            this.emS = 0;
            this.emW = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.emS = 0;
                return;
            }
            com.baidu.tbadk.core.data.bd bdVar2 = new com.baidu.tbadk.core.data.bd();
            bdVar2.bR(4);
            this.emS = 0;
            this.emW = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar2));
        }
    }

    public ei() {
        MessageManager.getInstance().registerListener(this.enb);
        MessageManager.getInstance().registerListener(this.enc);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.emX = z2;
        this.loadType = i;
        if (fVar != null && fVar.aJZ() != null) {
            this.threadTitle = fVar.aJZ().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aJZ().rE();
            }
            this.emY = fVar.aJZ().rL() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.emS = 0;
        this.emW = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.ena = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.enb);
        MessageManager.getInstance().unRegisterListener(this.enc);
    }

    public int aNa() {
        return this.emW;
    }

    public void oD(int i) {
        this.emW = i;
    }

    public int aNb() {
        if (this.pbData == null || this.pbData.aKb() == null) {
            return -1;
        }
        if (this.emS >= 0 && this.emS < this.pbData.aKb().size()) {
            this.emV = this.pbData.aKb().get(this.emS);
        }
        if (this.emV != null) {
            return this.emV.bhQ();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.p aNc() {
        if (this.pbData == null || this.pbData.aKb() == null) {
            return null;
        }
        if (this.emS >= 0 && this.emS < this.pbData.aKb().size()) {
            this.emV = this.pbData.aKb().get(this.emS);
        }
        return this.emV;
    }
}
