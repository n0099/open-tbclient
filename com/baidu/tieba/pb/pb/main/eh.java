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
public class eh {
    public com.baidu.tieba.tbadkCore.data.s efn;
    private a efs;
    public int loadType;
    private com.baidu.tieba.pb.data.h pbData;
    private String threadTitle;
    public int efk = 0;
    public int efl = 0;
    public int efo = 0;
    public boolean isSquence = true;
    public boolean efp = false;
    private boolean efq = false;
    private boolean efr = false;
    private CustomMessageListener eft = new ei(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener efu = new ej(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aJU();

        void aJV();

        void be(int i, int i2);
    }

    public void M(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.ba baVar = new com.baidu.tbadk.core.data.ba();
                baVar.bF(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar));
                this.efo = 5;
            }
            this.efk = i;
            aJQ();
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
        if (this.efr) {
            this.efk = g(i, arrayList);
            this.efl = f(this.efk, arrayList);
        } else {
            this.efk = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
            int i4 = (sVar == null || sVar.bfB() != this.efl) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.efk = arrayList.size() - 1;
            return null;
        }
        this.efk = i3;
        com.baidu.tbadk.core.data.bb bbVar = new com.baidu.tbadk.core.data.bb();
        if (arrayList.get(this.efk) instanceof com.baidu.tieba.tbadkCore.data.s) {
            com.baidu.tieba.tbadkCore.data.s sVar2 = arrayList.get(this.efk);
            this.efl = f(this.efk + 1, arrayList);
            if (sVar2.bfB() == 1) {
                bbVar.threadTitle = this.threadTitle;
                if (!this.efq) {
                    bbVar.Qs = true;
                } else {
                    bbVar.Qs = false;
                }
            } else {
                if (sVar2.bfB() != 0) {
                    bbVar.Qt = String.format(TbadkCoreApplication.m10getInst().getContext().getString(u.j.is_floor), Integer.valueOf(sVar2.bfB()));
                }
                bbVar.threadTitle = this.threadTitle;
                bbVar.Qs = false;
            }
            bbVar.Qv = sVar2.avx();
            return bbVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        return arrayList.get(i).bfB();
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.s sVar = arrayList.get(i2);
                if (sVar != null && sVar.bfB() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aJQ() {
        com.baidu.tbadk.core.data.ba baVar = new com.baidu.tbadk.core.data.ba();
        Object obj = null;
        switch (this.efo) {
            case 0:
            case 5:
                baVar.bF(1);
                obj = e(this.efk, this.pbData.aGZ());
                this.efo = 1;
                break;
            case 1:
                baVar.bF(2);
                this.efo = 2;
                break;
            case 2:
                baVar.bF(3);
                this.efo = 3;
                break;
            case 3:
                baVar.bF(2);
                this.efo = 2;
                break;
            case 4:
            default:
                baVar.bF(1);
                this.efo = 1;
                break;
        }
        baVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar));
    }

    private void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.ba baVar = new com.baidu.tbadk.core.data.ba();
            baVar.bF(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar));
            this.efk = 0;
            this.efo = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.efk = 0;
                return;
            }
            com.baidu.tbadk.core.data.ba baVar2 = new com.baidu.tbadk.core.data.ba();
            baVar2.bF(4);
            this.efk = 0;
            this.efo = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar2));
        }
    }

    public eh() {
        MessageManager.getInstance().registerListener(this.eft);
        MessageManager.getInstance().registerListener(this.efu);
    }

    public void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        a(hVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = hVar;
        this.isSquence = z;
        this.efp = z2;
        this.loadType = i;
        if (hVar != null && hVar.aGY() != null) {
            this.threadTitle = hVar.aGY().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = hVar.aGY().qD();
            }
            this.efq = hVar.aGY().qK() == 1;
        }
        if (z3) {
            a(hVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.efk = 0;
        this.efo = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.efs = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eft);
        MessageManager.getInstance().unRegisterListener(this.efu);
    }

    public int aJR() {
        return this.efo;
    }

    public void nL(int i) {
        this.efo = i;
    }

    public int aJS() {
        if (this.pbData == null || this.pbData.aGZ() == null) {
            return -1;
        }
        if (this.efk >= 0 && this.efk < this.pbData.aGZ().size()) {
            this.efn = this.pbData.aGZ().get(this.efk);
        }
        if (this.efn != null) {
            return this.efn.bfB();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.s aJT() {
        if (this.pbData == null || this.pbData.aGZ() == null) {
            return null;
        }
        if (this.efk >= 0 && this.efk < this.pbData.aGZ().size()) {
            this.efn = this.pbData.aGZ().get(this.efk);
        }
        return this.efn;
    }
}
