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
    public PostData ePe;
    private a ePj;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int ePb = 0;
    public int ePc = 0;
    public int ePf = 0;
    public boolean isSquence = true;
    public boolean ePg = false;
    private boolean ePh = false;
    private boolean ePi = false;
    private CustomMessageListener aYP = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READ_FINISHED) { // from class: com.baidu.tieba.pb.pb.main.ae.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (ae.this.pbData != null) {
                    ae.this.ePi = false;
                    int size = ae.this.pbData.aPS() != null ? ae.this.pbData.aPS().size() : 0;
                    if (ae.this.ePb >= size - 3 && ae.this.ePj != null && ae.this.pbData.qH().qD() != 0) {
                        ae.this.ePj.aTl();
                    }
                    if (ae.this.ePb >= size - 1) {
                        ae.this.ePb = -1;
                        ae.this.ePf = 5;
                        bh bhVar = new bh();
                        bhVar.setData(TbadkCoreApplication.getInst().getResources().getString(d.l.read_thread_over));
                        bhVar.bO(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                        return;
                    } else if (ae.this.ePb == -1) {
                        ae.this.ePf = 5;
                        ae.this.ePb = 0;
                        bh bhVar2 = new bh();
                        bhVar2.bO(15);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
                        return;
                    } else {
                        ae.this.ePb++;
                        ae.this.ePf = 1;
                        Object b = ae.this.b(ae.this.ePb, ae.this.pbData.aPS());
                        bh bhVar3 = new bh();
                        bhVar3.bO(1);
                        bhVar3.setData(b);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar3));
                        return;
                    }
                }
                ae.this.ePf = 5;
                ae.this.ePb = 0;
            }
        }
    };
    private CustomMessageListener ePk = new CustomMessageListener(CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION) { // from class: com.baidu.tieba.pb.pb.main.ae.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                int rf = ((bh) customResponsedMessage.getData()).rf();
                ae.this.ePi = false;
                switch (rf) {
                    case 9:
                        ae.this.B(ae.this.ePb, false);
                        return;
                    case 10:
                        ae.this.B(ae.this.ePb + 1, true);
                        return;
                    case 11:
                        ae.this.ePi = true;
                        ae.this.B(ae.this.ePb - 1, true);
                        return;
                    case 12:
                    default:
                        return;
                    case 13:
                        ae.this.ePf = 0;
                        ae.this.ePb = 0;
                        return;
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aTl();

        void aTm();

        void bk(int i, int i2);
    }

    public void B(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                bh bhVar = new bh();
                bhVar.bO(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                this.ePf = 5;
            }
            this.ePb = i;
            aTh();
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
        if (this.ePi) {
            this.ePb = d(i, arrayList);
            this.ePc = c(this.ePb, arrayList);
        } else {
            this.ePb = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.btg() != this.ePc) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.ePb = arrayList.size() - 1;
            return null;
        }
        this.ePb = i3;
        bi biVar = new bi();
        if (arrayList.get(this.ePb) instanceof PostData) {
            PostData postData2 = arrayList.get(this.ePb);
            this.ePc = c(this.ePb + 1, arrayList);
            if (postData2.btg() == 1) {
                biVar.threadTitle = this.threadTitle;
                if (!this.ePh) {
                    biVar.YT = true;
                } else {
                    biVar.YT = false;
                }
            } else {
                if (postData2.btg() != 0) {
                    biVar.YU = String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.is_floor), Integer.valueOf(postData2.btg()));
                }
                biVar.threadTitle = this.threadTitle;
                biVar.YT = false;
            }
            biVar.YW = postData2.aBw();
            return biVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int btg = arrayList.get(i).btg();
        if (i > 0 && btg == 0) {
            return this.ePc + 1;
        }
        return btg;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.btg() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aTh() {
        bh bhVar = new bh();
        Object obj = null;
        switch (this.ePf) {
            case 0:
            case 5:
                bhVar.bO(1);
                obj = b(this.ePb, this.pbData.aPS());
                this.ePf = 1;
                break;
            case 1:
                bhVar.bO(2);
                this.ePf = 2;
                break;
            case 2:
                bhVar.bO(3);
                this.ePf = 3;
                break;
            case 3:
                bhVar.bO(2);
                this.ePf = 2;
                break;
            case 4:
            default:
                bhVar.bO(1);
                this.ePf = 1;
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
            this.ePb = 0;
            this.ePf = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.ePb = 0;
                return;
            }
            bh bhVar2 = new bh();
            bhVar2.bO(4);
            this.ePb = 0;
            this.ePf = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
        }
    }

    public ae() {
        MessageManager.getInstance().registerListener(this.aYP);
        MessageManager.getInstance().registerListener(this.ePk);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.ePg = z2;
        this.loadType = i;
        if (fVar != null && fVar.aPQ() != null) {
            this.threadTitle = fVar.aPQ().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aPQ().rN();
            }
            this.ePh = fVar.aPQ().rU() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.ePb = 0;
        this.ePf = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.ePj = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aYP);
        MessageManager.getInstance().unRegisterListener(this.ePk);
    }

    public int aTi() {
        return this.ePf;
    }

    public void pq(int i) {
        this.ePf = i;
    }

    public int aTj() {
        if (this.pbData == null || this.pbData.aPS() == null) {
            return -1;
        }
        if (this.ePb >= 0 && this.ePb < this.pbData.aPS().size()) {
            this.ePe = this.pbData.aPS().get(this.ePb);
        }
        if (this.ePe != null) {
            return this.ePe.btg();
        }
        return -1;
    }

    public PostData aTk() {
        if (this.pbData == null || this.pbData.aPS() == null) {
            return null;
        }
        if (this.ePb >= 0 && this.ePb < this.pbData.aPS().size()) {
            this.ePe = this.pbData.aPS().get(this.ePb);
        }
        return this.ePe;
    }
}
