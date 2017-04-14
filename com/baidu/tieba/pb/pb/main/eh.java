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
    public PostData eod;
    private a eoj;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int eoa = 0;
    public int eob = 0;
    public int eoe = 0;
    public boolean isSquence = true;
    public boolean eog = false;
    private boolean eoh = false;
    private boolean eoi = false;
    private CustomMessageListener eok = new ei(this, CmdConfigCustom.CMD_TTS_READ_FINISHED);
    private CustomMessageListener eol = new ej(this, CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION);

    /* loaded from: classes.dex */
    public interface a {
        void aMF();

        void aMG();

        void aZ(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                beVar.bP(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                this.eoe = 5;
            }
            this.eoa = i;
            aMB();
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
        if (this.eoi) {
            this.eoa = d(i, arrayList);
            this.eob = c(this.eoa, arrayList);
        } else {
            this.eoa = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bio() != this.eob) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.eoa = arrayList.size() - 1;
            return null;
        }
        this.eoa = i3;
        com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
        if (arrayList.get(this.eoa) instanceof PostData) {
            PostData postData2 = arrayList.get(this.eoa);
            this.eob = c(this.eoa + 1, arrayList);
            if (postData2.bio() == 1) {
                bfVar.threadTitle = this.threadTitle;
                if (!this.eoh) {
                    bfVar.XR = true;
                } else {
                    bfVar.XR = false;
                }
            } else {
                if (postData2.bio() != 0) {
                    bfVar.XS = String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.is_floor), Integer.valueOf(postData2.bio()));
                }
                bfVar.threadTitle = this.threadTitle;
                bfVar.XR = false;
            }
            bfVar.XU = postData2.awl();
            return bfVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bio = arrayList.get(i).bio();
        if (i > 0 && bio == 0) {
            return this.eob + 1;
        }
        return bio;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bio() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aMB() {
        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
        Object obj = null;
        switch (this.eoe) {
            case 0:
            case 5:
                beVar.bP(1);
                obj = b(this.eoa, this.pbData.aJz());
                this.eoe = 1;
                break;
            case 1:
                beVar.bP(2);
                this.eoe = 2;
                break;
            case 2:
                beVar.bP(3);
                this.eoe = 3;
                break;
            case 3:
                beVar.bP(2);
                this.eoe = 2;
                break;
            case 4:
            default:
                beVar.bP(1);
                this.eoe = 1;
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
            this.eoa = 0;
            this.eoe = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.eoa = 0;
                return;
            }
            com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
            beVar2.bP(4);
            this.eoa = 0;
            this.eoe = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
        }
    }

    public eh() {
        MessageManager.getInstance().registerListener(this.eok);
        MessageManager.getInstance().registerListener(this.eol);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eog = z2;
        this.loadType = i;
        if (fVar != null && fVar.aJx() != null) {
            this.threadTitle = fVar.aJx().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aJx().sw();
            }
            this.eoh = fVar.aJx().sD() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.eoa = 0;
        this.eoe = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eoj = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eok);
        MessageManager.getInstance().unRegisterListener(this.eol);
    }

    public int aMC() {
        return this.eoe;
    }

    public void op(int i) {
        this.eoe = i;
    }

    public int aMD() {
        if (this.pbData == null || this.pbData.aJz() == null) {
            return -1;
        }
        if (this.eoa >= 0 && this.eoa < this.pbData.aJz().size()) {
            this.eod = this.pbData.aJz().get(this.eoa);
        }
        if (this.eod != null) {
            return this.eod.bio();
        }
        return -1;
    }

    public PostData aME() {
        if (this.pbData == null || this.pbData.aJz() == null) {
            return null;
        }
        if (this.eoa >= 0 && this.eoa < this.pbData.aJz().size()) {
            this.eod = this.pbData.aJz().get(this.eoa);
        }
        return this.eod;
    }
}
