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
public class ep {
    public PostData elQ;
    private a elV;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int elN = 0;
    public int elO = 0;
    public int elR = 0;
    public boolean isSquence = true;
    public boolean elS = false;
    private boolean elT = false;
    private boolean elU = false;
    private CustomMessageListener elW = new eq(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener elX = new er(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aKW();

        void aKX();

        void aW(int i, int i2);
    }

    public void z(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                bgVar.bM(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
                this.elR = 5;
            }
            this.elN = i;
            aKS();
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
        if (this.elU) {
            this.elN = d(i, arrayList);
            this.elO = c(this.elN, arrayList);
        } else {
            this.elN = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bgM() != this.elO) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.elN = arrayList.size() - 1;
            return null;
        }
        this.elN = i3;
        com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
        if (arrayList.get(this.elN) instanceof PostData) {
            PostData postData2 = arrayList.get(this.elN);
            this.elO = c(this.elN + 1, arrayList);
            if (postData2.bgM() == 1) {
                bhVar.threadTitle = this.threadTitle;
                if (!this.elT) {
                    bhVar.Xk = true;
                } else {
                    bhVar.Xk = false;
                }
            } else {
                if (postData2.bgM() != 0) {
                    bhVar.Xl = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.bgM()));
                }
                bhVar.threadTitle = this.threadTitle;
                bhVar.Xk = false;
            }
            bhVar.Xn = postData2.aui();
            return bhVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bgM = arrayList.get(i).bgM();
        if (i > 0 && bgM == 0) {
            return this.elO + 1;
        }
        return bgM;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bgM() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aKS() {
        com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
        Object obj = null;
        switch (this.elR) {
            case 0:
            case 5:
                bgVar.bM(1);
                obj = b(this.elN, this.pbData.aHI());
                this.elR = 1;
                break;
            case 1:
                bgVar.bM(2);
                this.elR = 2;
                break;
            case 2:
                bgVar.bM(3);
                this.elR = 3;
                break;
            case 3:
                bgVar.bM(2);
                this.elR = 2;
                break;
            case 4:
            default:
                bgVar.bM(1);
                this.elR = 1;
                break;
        }
        bgVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
            bgVar.bM(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
            this.elN = 0;
            this.elR = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.elN = 0;
                return;
            }
            com.baidu.tbadk.core.data.bg bgVar2 = new com.baidu.tbadk.core.data.bg();
            bgVar2.bM(4);
            this.elN = 0;
            this.elR = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar2));
        }
    }

    public ep() {
        MessageManager.getInstance().registerListener(this.elW);
        MessageManager.getInstance().registerListener(this.elX);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.elS = z2;
        this.loadType = i;
        if (fVar != null && fVar.aHG() != null) {
            this.threadTitle = fVar.aHG().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aHG().rG();
            }
            this.elT = fVar.aHG().rN() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.elN = 0;
        this.elR = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.elV = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.elW);
        MessageManager.getInstance().unRegisterListener(this.elX);
    }

    public int aKT() {
        return this.elR;
    }

    public void om(int i) {
        this.elR = i;
    }

    public int aKU() {
        if (this.pbData == null || this.pbData.aHI() == null) {
            return -1;
        }
        if (this.elN >= 0 && this.elN < this.pbData.aHI().size()) {
            this.elQ = this.pbData.aHI().get(this.elN);
        }
        if (this.elQ != null) {
            return this.elQ.bgM();
        }
        return -1;
    }

    public PostData aKV() {
        if (this.pbData == null || this.pbData.aHI() == null) {
            return null;
        }
        if (this.elN >= 0 && this.elN < this.pbData.aHI().size()) {
            this.elQ = this.pbData.aHI().get(this.elN);
        }
        return this.elQ;
    }
}
