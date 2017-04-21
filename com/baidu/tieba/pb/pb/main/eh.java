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
public class eh {
    private a eqA;
    public PostData eqv;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int eqs = 0;
    public int eqt = 0;
    public int eqw = 0;
    public boolean isSquence = true;
    public boolean eqx = false;
    private boolean eqy = false;
    private boolean eqz = false;
    private CustomMessageListener eqB = new ei(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener eqC = new ej(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aNG();

        void aNH();

        void aZ(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                beVar.bP(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                this.eqw = 5;
            }
            this.eqs = i;
            aNC();
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
        if (this.eqz) {
            this.eqs = d(i, arrayList);
            this.eqt = c(this.eqs, arrayList);
        } else {
            this.eqs = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bjp() != this.eqt) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.eqs = arrayList.size() - 1;
            return null;
        }
        this.eqs = i3;
        com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
        if (arrayList.get(this.eqs) instanceof PostData) {
            PostData postData2 = arrayList.get(this.eqs);
            this.eqt = c(this.eqs + 1, arrayList);
            if (postData2.bjp() == 1) {
                bfVar.threadTitle = this.threadTitle;
                if (!this.eqy) {
                    bfVar.XS = true;
                } else {
                    bfVar.XS = false;
                }
            } else {
                if (postData2.bjp() != 0) {
                    bfVar.XT = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.bjp()));
                }
                bfVar.threadTitle = this.threadTitle;
                bfVar.XS = false;
            }
            bfVar.XV = postData2.axm();
            return bfVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bjp = arrayList.get(i).bjp();
        if (i > 0 && bjp == 0) {
            return this.eqt + 1;
        }
        return bjp;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bjp() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aNC() {
        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
        Object obj = null;
        switch (this.eqw) {
            case 0:
            case 5:
                beVar.bP(1);
                obj = b(this.eqs, this.pbData.aKA());
                this.eqw = 1;
                break;
            case 1:
                beVar.bP(2);
                this.eqw = 2;
                break;
            case 2:
                beVar.bP(3);
                this.eqw = 3;
                break;
            case 3:
                beVar.bP(2);
                this.eqw = 2;
                break;
            case 4:
            default:
                beVar.bP(1);
                this.eqw = 1;
                break;
        }
        beVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
            beVar.bP(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
            this.eqs = 0;
            this.eqw = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.eqs = 0;
                return;
            }
            com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
            beVar2.bP(4);
            this.eqs = 0;
            this.eqw = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
        }
    }

    public eh() {
        MessageManager.getInstance().registerListener(this.eqB);
        MessageManager.getInstance().registerListener(this.eqC);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eqx = z2;
        this.loadType = i;
        if (fVar != null && fVar.aKy() != null) {
            this.threadTitle = fVar.aKy().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aKy().sw();
            }
            this.eqy = fVar.aKy().sD() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.eqs = 0;
        this.eqw = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eqA = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eqB);
        MessageManager.getInstance().unRegisterListener(this.eqC);
    }

    public int aND() {
        return this.eqw;
    }

    public void ov(int i) {
        this.eqw = i;
    }

    public int aNE() {
        if (this.pbData == null || this.pbData.aKA() == null) {
            return -1;
        }
        if (this.eqs >= 0 && this.eqs < this.pbData.aKA().size()) {
            this.eqv = this.pbData.aKA().get(this.eqs);
        }
        if (this.eqv != null) {
            return this.eqv.bjp();
        }
        return -1;
    }

    public PostData aNF() {
        if (this.pbData == null || this.pbData.aKA() == null) {
            return null;
        }
        if (this.eqs >= 0 && this.eqs < this.pbData.aKA().size()) {
            this.eqv = this.pbData.aKA().get(this.eqs);
        }
        return this.eqv;
    }
}
