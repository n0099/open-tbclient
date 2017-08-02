package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae {
    public PostData eLX;
    private a eMc;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int eLU = 0;
    public int eLV = 0;
    public int eLY = 0;
    public boolean isSquence = true;
    public boolean eLZ = false;
    private boolean eMa = false;
    private boolean eMb = false;
    private CustomMessageListener aXD = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READ_FINISHED) { // from class: com.baidu.tieba.pb.pb.main.ae.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (ae.this.pbData != null) {
                    ae.this.eMb = false;
                    int size = ae.this.pbData.aPa() != null ? ae.this.pbData.aPa().size() : 0;
                    if (ae.this.eLU >= size - 3 && ae.this.eMc != null && ae.this.pbData.qx().qt() != 0) {
                        ae.this.eMc.aSt();
                    }
                    if (ae.this.eLU >= size - 1) {
                        ae.this.eLU = -1;
                        ae.this.eLY = 5;
                        bh bhVar = new bh();
                        bhVar.setData(TbadkCoreApplication.getInst().getResources().getString(d.l.read_thread_over));
                        bhVar.bM(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                        return;
                    } else if (ae.this.eLU == -1) {
                        ae.this.eLY = 5;
                        ae.this.eLU = 0;
                        bh bhVar2 = new bh();
                        bhVar2.bM(15);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
                        return;
                    } else {
                        ae.this.eLU++;
                        ae.this.eLY = 1;
                        Object b = ae.this.b(ae.this.eLU, ae.this.pbData.aPa());
                        bh bhVar3 = new bh();
                        bhVar3.bM(1);
                        bhVar3.setData(b);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar3));
                        return;
                    }
                }
                ae.this.eLY = 5;
                ae.this.eLU = 0;
            }
        }
    };
    private CustomMessageListener eMd = new CustomMessageListener(CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION) { // from class: com.baidu.tieba.pb.pb.main.ae.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                int qV = ((bh) customResponsedMessage.getData()).qV();
                ae.this.eMb = false;
                switch (qV) {
                    case 9:
                        ae.this.A(ae.this.eLU, false);
                        return;
                    case 10:
                        ae.this.A(ae.this.eLU + 1, true);
                        return;
                    case 11:
                        ae.this.eMb = true;
                        ae.this.A(ae.this.eLU - 1, true);
                        return;
                    case 12:
                    default:
                        return;
                    case 13:
                        ae.this.eLY = 0;
                        ae.this.eLU = 0;
                        return;
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aSt();

        void aSu();

        void bb(int i, int i2);
    }

    public void A(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                bh bhVar = new bh();
                bhVar.bM(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                this.eLY = 5;
            }
            this.eLU = i;
            aSp();
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
        if (this.eMb) {
            this.eLU = d(i, arrayList);
            this.eLV = c(this.eLU, arrayList);
        } else {
            this.eLU = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bsr() != this.eLV) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.eLU = arrayList.size() - 1;
            return null;
        }
        this.eLU = i3;
        bi biVar = new bi();
        if (arrayList.get(this.eLU) instanceof PostData) {
            PostData postData2 = arrayList.get(this.eLU);
            this.eLV = c(this.eLU + 1, arrayList);
            if (postData2.bsr() == 1) {
                biVar.threadTitle = this.threadTitle;
                if (!this.eMa) {
                    biVar.Xv = true;
                } else {
                    biVar.Xv = false;
                }
            } else {
                if (postData2.bsr() != 0) {
                    biVar.Xw = String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.is_floor), Integer.valueOf(postData2.bsr()));
                }
                biVar.threadTitle = this.threadTitle;
                biVar.Xv = false;
            }
            biVar.Xy = postData2.aAE();
            return biVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bsr = arrayList.get(i).bsr();
        if (i > 0 && bsr == 0) {
            return this.eLV + 1;
        }
        return bsr;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bsr() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aSp() {
        bh bhVar = new bh();
        Object obj = null;
        switch (this.eLY) {
            case 0:
            case 5:
                bhVar.bM(1);
                obj = b(this.eLU, this.pbData.aPa());
                this.eLY = 1;
                break;
            case 1:
                bhVar.bM(2);
                this.eLY = 2;
                break;
            case 2:
                bhVar.bM(3);
                this.eLY = 3;
                break;
            case 3:
                bhVar.bM(2);
                this.eLY = 2;
                break;
            case 4:
            default:
                bhVar.bM(1);
                this.eLY = 1;
                break;
        }
        bhVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            bh bhVar = new bh();
            bhVar.bM(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
            this.eLU = 0;
            this.eLY = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.eLU = 0;
                return;
            }
            bh bhVar2 = new bh();
            bhVar2.bM(4);
            this.eLU = 0;
            this.eLY = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
        }
    }

    public ae() {
        MessageManager.getInstance().registerListener(this.aXD);
        MessageManager.getInstance().registerListener(this.eMd);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eLZ = z2;
        this.loadType = i;
        if (fVar != null && fVar.aOY() != null) {
            this.threadTitle = fVar.aOY().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aOY().rD();
            }
            this.eMa = fVar.aOY().rK() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.eLU = 0;
        this.eLY = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eMc = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aXD);
        MessageManager.getInstance().unRegisterListener(this.eMd);
    }

    public int aSq() {
        return this.eLY;
    }

    public void ph(int i) {
        this.eLY = i;
    }

    public int aSr() {
        if (this.pbData == null || this.pbData.aPa() == null) {
            return -1;
        }
        if (this.eLU >= 0 && this.eLU < this.pbData.aPa().size()) {
            this.eLX = this.pbData.aPa().get(this.eLU);
        }
        if (this.eLX != null) {
            return this.eLX.bsr();
        }
        return -1;
    }

    public PostData aSs() {
        if (this.pbData == null || this.pbData.aPa() == null) {
            return null;
        }
        if (this.eLU >= 0 && this.eLU < this.pbData.aPa().size()) {
            this.eLX = this.pbData.aPa().get(this.eLU);
        }
        return this.eLX;
    }
}
