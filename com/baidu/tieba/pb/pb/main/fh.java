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
public class fh {
    public PostData eAO;
    private a eAT;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int eAL = 0;
    public int eAM = 0;
    public int eAP = 0;
    public boolean isSquence = true;
    public boolean eAQ = false;
    private boolean eAR = false;
    private boolean eAS = false;
    private CustomMessageListener eAU = new fi(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener eAV = new fj(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aPQ();

        void aPR();

        void bc(int i, int i2);
    }

    public void z(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
                biVar.bN(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar));
                this.eAP = 5;
            }
            this.eAL = i;
            aPM();
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
        if (this.eAS) {
            this.eAL = d(i, arrayList);
            this.eAM = c(this.eAL, arrayList);
        } else {
            this.eAL = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bmu() != this.eAM) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.eAL = arrayList.size() - 1;
            return null;
        }
        this.eAL = i3;
        com.baidu.tbadk.core.data.bj bjVar = new com.baidu.tbadk.core.data.bj();
        if (arrayList.get(this.eAL) instanceof PostData) {
            PostData postData2 = arrayList.get(this.eAL);
            this.eAM = c(this.eAL + 1, arrayList);
            if (postData2.bmu() == 1) {
                bjVar.threadTitle = this.threadTitle;
                if (!this.eAR) {
                    bjVar.Xf = true;
                } else {
                    bjVar.Xf = false;
                }
            } else {
                if (postData2.bmu() != 0) {
                    bjVar.Xg = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.bmu()));
                }
                bjVar.threadTitle = this.threadTitle;
                bjVar.Xf = false;
            }
            bjVar.Xi = postData2.azb();
            return bjVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bmu = arrayList.get(i).bmu();
        if (i > 0 && bmu == 0) {
            return this.eAM + 1;
        }
        return bmu;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bmu() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aPM() {
        com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
        Object obj = null;
        switch (this.eAP) {
            case 0:
            case 5:
                biVar.bN(1);
                obj = b(this.eAL, this.pbData.aMx());
                this.eAP = 1;
                break;
            case 1:
                biVar.bN(2);
                this.eAP = 2;
                break;
            case 2:
                biVar.bN(3);
                this.eAP = 3;
                break;
            case 3:
                biVar.bN(2);
                this.eAP = 2;
                break;
            case 4:
            default:
                biVar.bN(1);
                this.eAP = 1;
                break;
        }
        biVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
            biVar.bN(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar));
            this.eAL = 0;
            this.eAP = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.eAL = 0;
                return;
            }
            com.baidu.tbadk.core.data.bi biVar2 = new com.baidu.tbadk.core.data.bi();
            biVar2.bN(4);
            this.eAL = 0;
            this.eAP = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar2));
        }
    }

    public fh() {
        MessageManager.getInstance().registerListener(this.eAU);
        MessageManager.getInstance().registerListener(this.eAV);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eAQ = z2;
        this.loadType = i;
        if (fVar != null && fVar.aMv() != null) {
            this.threadTitle = fVar.aMv().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aMv().rz();
            }
            this.eAR = fVar.aMv().rG() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.eAL = 0;
        this.eAP = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eAT = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eAU);
        MessageManager.getInstance().unRegisterListener(this.eAV);
    }

    public int aPN() {
        return this.eAP;
    }

    public void oX(int i) {
        this.eAP = i;
    }

    public int aPO() {
        if (this.pbData == null || this.pbData.aMx() == null) {
            return -1;
        }
        if (this.eAL >= 0 && this.eAL < this.pbData.aMx().size()) {
            this.eAO = this.pbData.aMx().get(this.eAL);
        }
        if (this.eAO != null) {
            return this.eAO.bmu();
        }
        return -1;
    }

    public PostData aPP() {
        if (this.pbData == null || this.pbData.aMx() == null) {
            return null;
        }
        if (this.eAL >= 0 && this.eAL < this.pbData.aMx().size()) {
            this.eAO = this.pbData.aMx().get(this.eAL);
        }
        return this.eAO;
    }
}
