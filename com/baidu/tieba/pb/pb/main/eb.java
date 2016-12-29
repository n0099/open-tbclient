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
public class eb {
    public com.baidu.tieba.tbadkCore.data.q eeb;
    private a eeg;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int edY = 0;
    public int edZ = 0;
    public int eec = 0;
    public boolean isSquence = true;
    public boolean eed = false;
    private boolean eee = false;
    private boolean eef = false;
    private CustomMessageListener eeh = new ec(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener eei = new ed(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aLp();

        void aLq();

        void ba(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
                bcVar.bS(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
                this.eec = 5;
            }
            this.edY = i;
            aLl();
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
        if (this.eef) {
            this.edY = g(i, arrayList);
            this.edZ = f(this.edY, arrayList);
        } else {
            this.edY = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
            int i4 = (qVar == null || qVar.bga() != this.edZ) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.edY = arrayList.size() - 1;
            return null;
        }
        this.edY = i3;
        com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
        if (arrayList.get(this.edY) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = arrayList.get(this.edY);
            this.edZ = f(this.edY + 1, arrayList);
            if (qVar2.bga() == 1) {
                bdVar.threadTitle = this.threadTitle;
                if (!this.eee) {
                    bdVar.Te = true;
                } else {
                    bdVar.Te = false;
                }
            } else {
                if (qVar2.bga() != 0) {
                    bdVar.Tf = String.format(TbadkCoreApplication.m9getInst().getContext().getString(r.j.is_floor), Integer.valueOf(qVar2.bga()));
                }
                bdVar.threadTitle = this.threadTitle;
                bdVar.Te = false;
            }
            bdVar.Th = qVar2.avP();
            return bdVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bga = arrayList.get(i).bga();
        if (i > 0 && bga == 0) {
            return this.edZ + 1;
        }
        return bga;
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
                if (qVar != null && qVar.bga() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aLl() {
        com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
        Object obj = null;
        switch (this.eec) {
            case 0:
            case 5:
                bcVar.bS(1);
                obj = e(this.edY, this.pbData.aIm());
                this.eec = 1;
                break;
            case 1:
                bcVar.bS(2);
                this.eec = 2;
                break;
            case 2:
                bcVar.bS(3);
                this.eec = 3;
                break;
            case 3:
                bcVar.bS(2);
                this.eec = 2;
                break;
            case 4:
            default:
                bcVar.bS(1);
                this.eec = 1;
                break;
        }
        bcVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
            bcVar.bS(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
            this.edY = 0;
            this.eec = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.edY = 0;
                return;
            }
            com.baidu.tbadk.core.data.bc bcVar2 = new com.baidu.tbadk.core.data.bc();
            bcVar2.bS(4);
            this.edY = 0;
            this.eec = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar2));
        }
    }

    public eb() {
        MessageManager.getInstance().registerListener(this.eeh);
        MessageManager.getInstance().registerListener(this.eei);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eed = z2;
        this.loadType = i;
        if (fVar != null && fVar.aIl() != null) {
            this.threadTitle = fVar.aIl().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aIl().rN();
            }
            this.eee = fVar.aIl().rU() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.edY = 0;
        this.eec = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eeg = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eeh);
        MessageManager.getInstance().unRegisterListener(this.eei);
    }

    public int aLm() {
        return this.eec;
    }

    public void nM(int i) {
        this.eec = i;
    }

    public int aLn() {
        if (this.pbData == null || this.pbData.aIm() == null) {
            return -1;
        }
        if (this.edY >= 0 && this.edY < this.pbData.aIm().size()) {
            this.eeb = this.pbData.aIm().get(this.edY);
        }
        if (this.eeb != null) {
            return this.eeb.bga();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.q aLo() {
        if (this.pbData == null || this.pbData.aIm() == null) {
            return null;
        }
        if (this.edY >= 0 && this.edY < this.pbData.aIm().size()) {
            this.eeb = this.pbData.aIm().get(this.edY);
        }
        return this.eeb;
    }
}
