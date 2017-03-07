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
public class ej {
    public PostData epV;
    private a eqa;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int epS = 0;
    public int epT = 0;
    public int epW = 0;
    public boolean isSquence = true;
    public boolean epX = false;
    private boolean epY = false;
    private boolean epZ = false;
    private CustomMessageListener eqb = new ek(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener eqc = new el(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aMw();

        void aMx();

        void bf(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
                bfVar.bM(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar));
                this.epW = 5;
            }
            this.epS = i;
            aMs();
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
        if (this.epZ) {
            this.epS = d(i, arrayList);
            this.epT = c(this.epS, arrayList);
        } else {
            this.epS = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bhD() != this.epT) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.epS = arrayList.size() - 1;
            return null;
        }
        this.epS = i3;
        com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
        if (arrayList.get(this.epS) instanceof PostData) {
            PostData postData2 = arrayList.get(this.epS);
            this.epT = c(this.epS + 1, arrayList);
            if (postData2.bhD() == 1) {
                bgVar.threadTitle = this.threadTitle;
                if (!this.epY) {
                    bgVar.XB = true;
                } else {
                    bgVar.XB = false;
                }
            } else {
                if (postData2.bhD() != 0) {
                    bgVar.XC = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.bhD()));
                }
                bgVar.threadTitle = this.threadTitle;
                bgVar.XB = false;
            }
            bgVar.XE = postData2.aws();
            return bgVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bhD = arrayList.get(i).bhD();
        if (i > 0 && bhD == 0) {
            return this.epT + 1;
        }
        return bhD;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bhD() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aMs() {
        com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
        Object obj = null;
        switch (this.epW) {
            case 0:
            case 5:
                bfVar.bM(1);
                obj = b(this.epS, this.pbData.aJs());
                this.epW = 1;
                break;
            case 1:
                bfVar.bM(2);
                this.epW = 2;
                break;
            case 2:
                bfVar.bM(3);
                this.epW = 3;
                break;
            case 3:
                bfVar.bM(2);
                this.epW = 2;
                break;
            case 4:
            default:
                bfVar.bM(1);
                this.epW = 1;
                break;
        }
        bfVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
            bfVar.bM(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar));
            this.epS = 0;
            this.epW = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.epS = 0;
                return;
            }
            com.baidu.tbadk.core.data.bf bfVar2 = new com.baidu.tbadk.core.data.bf();
            bfVar2.bM(4);
            this.epS = 0;
            this.epW = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar2));
        }
    }

    public ej() {
        MessageManager.getInstance().registerListener(this.eqb);
        MessageManager.getInstance().registerListener(this.eqc);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.epX = z2;
        this.loadType = i;
        if (fVar != null && fVar.aJq() != null) {
            this.threadTitle = fVar.aJq().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aJq().rY();
            }
            this.epY = fVar.aJq().sf() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.epS = 0;
        this.epW = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eqa = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eqb);
        MessageManager.getInstance().unRegisterListener(this.eqc);
    }

    public int aMt() {
        return this.epW;
    }

    public void or(int i) {
        this.epW = i;
    }

    public int aMu() {
        if (this.pbData == null || this.pbData.aJs() == null) {
            return -1;
        }
        if (this.epS >= 0 && this.epS < this.pbData.aJs().size()) {
            this.epV = this.pbData.aJs().get(this.epS);
        }
        if (this.epV != null) {
            return this.epV.bhD();
        }
        return -1;
    }

    public PostData aMv() {
        if (this.pbData == null || this.pbData.aJs() == null) {
            return null;
        }
        if (this.epS >= 0 && this.epS < this.pbData.aJs().size()) {
            this.epV = this.pbData.aJs().get(this.epS);
        }
        return this.epV;
    }
}
