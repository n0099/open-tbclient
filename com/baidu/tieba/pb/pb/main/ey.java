package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ey {
    public PostData erD;
    private a erI;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int erA = 0;
    public int erB = 0;
    public int erE = 0;
    public boolean isSquence = true;
    public boolean erF = false;
    private boolean erG = false;
    private boolean erH = false;
    private CustomMessageListener erJ = new ez(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener erK = new fa(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aLS();

        void aLT();

        void aU(int i, int i2);
    }

    public void z(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
                bhVar.bN(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                this.erE = 5;
            }
            this.erA = i;
            aLO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(int i, ArrayList<PostData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (this.erH) {
            this.erA = d(i, arrayList);
            this.erB = c(this.erA, arrayList);
        } else {
            this.erA = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.big() != this.erB) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.erA = arrayList.size() - 1;
            return null;
        }
        this.erA = i3;
        com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
        if (arrayList.get(this.erA) instanceof PostData) {
            PostData postData2 = arrayList.get(this.erA);
            this.erB = c(this.erA + 1, arrayList);
            if (postData2.big() == 1) {
                biVar.threadTitle = this.threadTitle;
                if (!this.erG) {
                    biVar.Xf = true;
                } else {
                    biVar.Xf = false;
                }
            } else {
                if (postData2.big() != 0) {
                    biVar.Xg = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.big()));
                }
                biVar.threadTitle = this.threadTitle;
                biVar.Xf = false;
            }
            biVar.Xi = postData2.avd();
            return biVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int big = arrayList.get(i).big();
        if (i > 0 && big == 0) {
            return this.erB + 1;
        }
        return big;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.big() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aLO() {
        com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
        Object obj = null;
        switch (this.erE) {
            case 0:
            case 5:
                bhVar.bN(1);
                obj = b(this.erA, this.pbData.aID());
                this.erE = 1;
                break;
            case 1:
                bhVar.bN(2);
                this.erE = 2;
                break;
            case 2:
                bhVar.bN(3);
                this.erE = 3;
                break;
            case 3:
                bhVar.bN(2);
                this.erE = 2;
                break;
            case 4:
            default:
                bhVar.bN(1);
                this.erE = 1;
                break;
        }
        bhVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
            bhVar.bN(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
            this.erA = 0;
            this.erE = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.erA = 0;
                return;
            }
            com.baidu.tbadk.core.data.bh bhVar2 = new com.baidu.tbadk.core.data.bh();
            bhVar2.bN(4);
            this.erA = 0;
            this.erE = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
        }
    }

    public ey() {
        MessageManager.getInstance().registerListener(this.erJ);
        MessageManager.getInstance().registerListener(this.erK);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.erF = z2;
        this.loadType = i;
        if (fVar != null && fVar.aIB() != null) {
            this.threadTitle = fVar.aIB().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aIB().rC();
            }
            this.erG = fVar.aIB().rJ() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.erA = 0;
        this.erE = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.erI = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.erJ);
        MessageManager.getInstance().unRegisterListener(this.erK);
    }

    public int aLP() {
        return this.erE;
    }

    public void oG(int i) {
        this.erE = i;
    }

    public int aLQ() {
        if (this.pbData == null || this.pbData.aID() == null) {
            return -1;
        }
        if (this.erA >= 0 && this.erA < this.pbData.aID().size()) {
            this.erD = this.pbData.aID().get(this.erA);
        }
        if (this.erD != null) {
            return this.erD.big();
        }
        return -1;
    }

    public PostData aLR() {
        if (this.pbData == null || this.pbData.aID() == null) {
            return null;
        }
        if (this.erA >= 0 && this.erA < this.pbData.aID().size()) {
            this.erD = this.pbData.aID().get(this.erA);
        }
        return this.erD;
    }
}
