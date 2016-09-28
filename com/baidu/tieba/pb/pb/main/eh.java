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
public class eh {
    public com.baidu.tieba.tbadkCore.data.q etB;
    private a etG;
    public int loadType;
    private com.baidu.tieba.pb.data.h pbData;
    private String threadTitle;
    public int ety = 0;
    public int etz = 0;
    public int etC = 0;
    public boolean isSquence = true;
    public boolean etD = false;
    private boolean etE = false;
    private boolean etF = false;
    private CustomMessageListener etH = new ei(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener etI = new ej(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aPu();

        void aPv();

        void bk(int i, int i2);
    }

    public void M(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                beVar.bS(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                this.etC = 5;
            }
            this.ety = i;
            aPq();
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
        if (this.etF) {
            this.ety = g(i, arrayList);
            this.etz = f(this.ety, arrayList);
        } else {
            this.ety = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
            int i4 = (qVar == null || qVar.bjO() != this.etz) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.ety = arrayList.size() - 1;
            return null;
        }
        this.ety = i3;
        com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
        if (arrayList.get(this.ety) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = arrayList.get(this.ety);
            this.etz = f(this.ety + 1, arrayList);
            if (qVar2.bjO() == 1) {
                bfVar.threadTitle = this.threadTitle;
                if (!this.etE) {
                    bfVar.Ti = true;
                } else {
                    bfVar.Ti = false;
                }
            } else {
                if (qVar2.bjO() != 0) {
                    bfVar.Tj = String.format(TbadkCoreApplication.m9getInst().getContext().getString(r.j.is_floor), Integer.valueOf(qVar2.bjO()));
                }
                bfVar.threadTitle = this.threadTitle;
                bfVar.Ti = false;
            }
            bfVar.Tl = qVar2.aAI();
            return bfVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bjO = arrayList.get(i).bjO();
        if (i > 0 && bjO == 0) {
            return this.etz + 1;
        }
        return bjO;
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
                if (qVar != null && qVar.bjO() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aPq() {
        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
        Object obj = null;
        switch (this.etC) {
            case 0:
            case 5:
                beVar.bS(1);
                obj = e(this.ety, this.pbData.aMt());
                this.etC = 1;
                break;
            case 1:
                beVar.bS(2);
                this.etC = 2;
                break;
            case 2:
                beVar.bS(3);
                this.etC = 3;
                break;
            case 3:
                beVar.bS(2);
                this.etC = 2;
                break;
            case 4:
            default:
                beVar.bS(1);
                this.etC = 1;
                break;
        }
        beVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
    }

    private void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
            beVar.bS(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
            this.ety = 0;
            this.etC = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.ety = 0;
                return;
            }
            com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
            beVar2.bS(4);
            this.ety = 0;
            this.etC = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
        }
    }

    public eh() {
        MessageManager.getInstance().registerListener(this.etH);
        MessageManager.getInstance().registerListener(this.etI);
    }

    public void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        a(hVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = hVar;
        this.isSquence = z;
        this.etD = z2;
        this.loadType = i;
        if (hVar != null && hVar.aMs() != null) {
            this.threadTitle = hVar.aMs().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = hVar.aMs().rU();
            }
            this.etE = hVar.aMs().sb() == 1;
        }
        if (z3) {
            a(hVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.ety = 0;
        this.etC = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.etG = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.etH);
        MessageManager.getInstance().unRegisterListener(this.etI);
    }

    public int aPr() {
        return this.etC;
    }

    public void oz(int i) {
        this.etC = i;
    }

    public int aPs() {
        if (this.pbData == null || this.pbData.aMt() == null) {
            return -1;
        }
        if (this.ety >= 0 && this.ety < this.pbData.aMt().size()) {
            this.etB = this.pbData.aMt().get(this.ety);
        }
        if (this.etB != null) {
            return this.etB.bjO();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.q aPt() {
        if (this.pbData == null || this.pbData.aMt() == null) {
            return null;
        }
        if (this.ety >= 0 && this.ety < this.pbData.aMt().size()) {
            this.etB = this.pbData.aMt().get(this.ety);
        }
        return this.etB;
    }
}
