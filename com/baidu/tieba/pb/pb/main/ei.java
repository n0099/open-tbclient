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
    public com.baidu.tieba.tbadkCore.data.q ezS;
    private a ezX;
    public int loadType;
    private com.baidu.tieba.pb.data.h pbData;
    private String threadTitle;
    public int ezP = 0;
    public int ezQ = 0;
    public int ezT = 0;
    public boolean isSquence = true;
    public boolean ezU = false;
    private boolean ezV = false;
    private boolean ezW = false;
    private CustomMessageListener ezY = new ej(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener ezZ = new ek(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aRv();

        void aRw();

        void bl(int i, int i2);
    }

    public void O(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                bgVar.bS(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
                this.ezT = 5;
            }
            this.ezP = i;
            aRr();
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
        if (this.ezW) {
            this.ezP = g(i, arrayList);
            this.ezQ = f(this.ezP, arrayList);
        } else {
            this.ezP = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
            int i4 = (qVar == null || qVar.bml() != this.ezQ) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.ezP = arrayList.size() - 1;
            return null;
        }
        this.ezP = i3;
        com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
        if (arrayList.get(this.ezP) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar2 = arrayList.get(this.ezP);
            this.ezQ = f(this.ezP + 1, arrayList);
            if (qVar2.bml() == 1) {
                bhVar.threadTitle = this.threadTitle;
                if (!this.ezV) {
                    bhVar.TD = true;
                } else {
                    bhVar.TD = false;
                }
            } else {
                if (qVar2.bml() != 0) {
                    bhVar.TE = String.format(TbadkCoreApplication.m9getInst().getContext().getString(r.j.is_floor), Integer.valueOf(qVar2.bml()));
                }
                bhVar.threadTitle = this.threadTitle;
                bhVar.TD = false;
            }
            bhVar.TG = qVar2.aCE();
            return bhVar;
        }
        return null;
    }

    private int f(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bml = arrayList.get(i).bml();
        if (i > 0 && bml == 0) {
            return this.ezQ + 1;
        }
        return bml;
    }

    private int g(int i, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                com.baidu.tieba.tbadkCore.data.q qVar = arrayList.get(i2);
                if (qVar != null && qVar.bml() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aRr() {
        com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
        Object obj = null;
        switch (this.ezT) {
            case 0:
            case 5:
                bgVar.bS(1);
                obj = e(this.ezP, this.pbData.aOm());
                this.ezT = 1;
                break;
            case 1:
                bgVar.bS(2);
                this.ezT = 2;
                break;
            case 2:
                bgVar.bS(3);
                this.ezT = 3;
                break;
            case 3:
                bgVar.bS(2);
                this.ezT = 2;
                break;
            case 4:
            default:
                bgVar.bS(1);
                this.ezT = 1;
                break;
        }
        bgVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
    }

    private void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
            bgVar.bS(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
            this.ezP = 0;
            this.ezT = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.ezP = 0;
                return;
            }
            com.baidu.tbadk.core.data.bg bgVar2 = new com.baidu.tbadk.core.data.bg();
            bgVar2.bS(4);
            this.ezP = 0;
            this.ezT = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar2));
        }
    }

    public ei() {
        MessageManager.getInstance().registerListener(this.ezY);
        MessageManager.getInstance().registerListener(this.ezZ);
    }

    public void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2) {
        a(hVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = hVar;
        this.isSquence = z;
        this.ezU = z2;
        this.loadType = i;
        if (hVar != null && hVar.aOl() != null) {
            this.threadTitle = hVar.aOl().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = hVar.aOl().rW();
            }
            this.ezV = hVar.aOl().sd() == 1;
        }
        if (z3) {
            a(hVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.ezP = 0;
        this.ezT = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.ezX = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ezY);
        MessageManager.getInstance().unRegisterListener(this.ezZ);
    }

    public int aRs() {
        return this.ezT;
    }

    public void oK(int i) {
        this.ezT = i;
    }

    public int aRt() {
        if (this.pbData == null || this.pbData.aOm() == null) {
            return -1;
        }
        if (this.ezP >= 0 && this.ezP < this.pbData.aOm().size()) {
            this.ezS = this.pbData.aOm().get(this.ezP);
        }
        if (this.ezS != null) {
            return this.ezS.bml();
        }
        return -1;
    }

    public com.baidu.tieba.tbadkCore.data.q aRu() {
        if (this.pbData == null || this.pbData.aOm() == null) {
            return null;
        }
        if (this.ezP >= 0 && this.ezP < this.pbData.aOm().size()) {
            this.ezS = this.pbData.aOm().get(this.ezP);
        }
        return this.ezS;
    }
}
