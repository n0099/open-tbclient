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
    public PostData ePg;
    private a ePl;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int ePd = 0;
    public int ePe = 0;
    public int ePh = 0;
    public boolean isSquence = true;
    public boolean ePi = false;
    private boolean ePj = false;
    private boolean ePk = false;
    private CustomMessageListener aYQ = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READ_FINISHED) { // from class: com.baidu.tieba.pb.pb.main.ae.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (ae.this.pbData != null) {
                    ae.this.ePk = false;
                    int size = ae.this.pbData.aPN() != null ? ae.this.pbData.aPN().size() : 0;
                    if (ae.this.ePd >= size - 3 && ae.this.ePl != null && ae.this.pbData.qI().qE() != 0) {
                        ae.this.ePl.aTg();
                    }
                    if (ae.this.ePd >= size - 1) {
                        ae.this.ePd = -1;
                        ae.this.ePh = 5;
                        bh bhVar = new bh();
                        bhVar.setData(TbadkCoreApplication.getInst().getResources().getString(d.l.read_thread_over));
                        bhVar.bO(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                        return;
                    } else if (ae.this.ePd == -1) {
                        ae.this.ePh = 5;
                        ae.this.ePd = 0;
                        bh bhVar2 = new bh();
                        bhVar2.bO(15);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
                        return;
                    } else {
                        ae.this.ePd++;
                        ae.this.ePh = 1;
                        Object b = ae.this.b(ae.this.ePd, ae.this.pbData.aPN());
                        bh bhVar3 = new bh();
                        bhVar3.bO(1);
                        bhVar3.setData(b);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar3));
                        return;
                    }
                }
                ae.this.ePh = 5;
                ae.this.ePd = 0;
            }
        }
    };
    private CustomMessageListener ePm = new CustomMessageListener(CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION) { // from class: com.baidu.tieba.pb.pb.main.ae.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                int rg = ((bh) customResponsedMessage.getData()).rg();
                ae.this.ePk = false;
                switch (rg) {
                    case 9:
                        ae.this.B(ae.this.ePd, false);
                        return;
                    case 10:
                        ae.this.B(ae.this.ePd + 1, true);
                        return;
                    case 11:
                        ae.this.ePk = true;
                        ae.this.B(ae.this.ePd - 1, true);
                        return;
                    case 12:
                    default:
                        return;
                    case 13:
                        ae.this.ePh = 0;
                        ae.this.ePd = 0;
                        return;
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aTg();

        void aTh();

        void bk(int i, int i2);
    }

    public void B(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                bh bhVar = new bh();
                bhVar.bO(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                this.ePh = 5;
            }
            this.ePd = i;
            aTc();
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
        if (this.ePk) {
            this.ePd = d(i, arrayList);
            this.ePe = c(this.ePd, arrayList);
        } else {
            this.ePd = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bsZ() != this.ePe) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.ePd = arrayList.size() - 1;
            return null;
        }
        this.ePd = i3;
        bi biVar = new bi();
        if (arrayList.get(this.ePd) instanceof PostData) {
            PostData postData2 = arrayList.get(this.ePd);
            this.ePe = c(this.ePd + 1, arrayList);
            if (postData2.bsZ() == 1) {
                biVar.threadTitle = this.threadTitle;
                if (!this.ePj) {
                    biVar.YU = true;
                } else {
                    biVar.YU = false;
                }
            } else {
                if (postData2.bsZ() != 0) {
                    biVar.YV = String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.is_floor), Integer.valueOf(postData2.bsZ()));
                }
                biVar.threadTitle = this.threadTitle;
                biVar.YU = false;
            }
            biVar.YX = postData2.aBr();
            return biVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bsZ = arrayList.get(i).bsZ();
        if (i > 0 && bsZ == 0) {
            return this.ePe + 1;
        }
        return bsZ;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bsZ() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aTc() {
        bh bhVar = new bh();
        Object obj = null;
        switch (this.ePh) {
            case 0:
            case 5:
                bhVar.bO(1);
                obj = b(this.ePd, this.pbData.aPN());
                this.ePh = 1;
                break;
            case 1:
                bhVar.bO(2);
                this.ePh = 2;
                break;
            case 2:
                bhVar.bO(3);
                this.ePh = 3;
                break;
            case 3:
                bhVar.bO(2);
                this.ePh = 2;
                break;
            case 4:
            default:
                bhVar.bO(1);
                this.ePh = 1;
                break;
        }
        bhVar.setData(obj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
    }

    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        if (!z) {
            bh bhVar = new bh();
            bhVar.bO(15);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
            this.ePd = 0;
            this.ePh = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.ePd = 0;
                return;
            }
            bh bhVar2 = new bh();
            bhVar2.bO(4);
            this.ePd = 0;
            this.ePh = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
        }
    }

    public ae() {
        MessageManager.getInstance().registerListener(this.aYQ);
        MessageManager.getInstance().registerListener(this.ePm);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.ePi = z2;
        this.loadType = i;
        if (fVar != null && fVar.aPL() != null) {
            this.threadTitle = fVar.aPL().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aPL().rO();
            }
            this.ePj = fVar.aPL().rV() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.ePd = 0;
        this.ePh = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.ePl = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aYQ);
        MessageManager.getInstance().unRegisterListener(this.ePm);
    }

    public int aTd() {
        return this.ePh;
    }

    public void pq(int i) {
        this.ePh = i;
    }

    public int aTe() {
        if (this.pbData == null || this.pbData.aPN() == null) {
            return -1;
        }
        if (this.ePd >= 0 && this.ePd < this.pbData.aPN().size()) {
            this.ePg = this.pbData.aPN().get(this.ePd);
        }
        if (this.ePg != null) {
            return this.ePg.bsZ();
        }
        return -1;
    }

    public PostData aTf() {
        if (this.pbData == null || this.pbData.aPN() == null) {
            return null;
        }
        if (this.ePd >= 0 && this.ePd < this.pbData.aPN().size()) {
            this.ePg = this.pbData.aPN().get(this.ePd);
        }
        return this.ePg;
    }
}
