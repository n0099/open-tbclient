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
    public PostData eNk;
    private a eNp;
    public int loadType;
    private com.baidu.tieba.pb.data.f pbData;
    private String threadTitle;
    public int eNh = 0;
    public int eNi = 0;
    public int eNl = 0;
    public boolean isSquence = true;
    public boolean eNm = false;
    private boolean eNn = false;
    private boolean eNo = false;
    private CustomMessageListener aYO = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READ_FINISHED) { // from class: com.baidu.tieba.pb.pb.main.ae.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (ae.this.pbData != null) {
                    ae.this.eNo = false;
                    int size = ae.this.pbData.aPl() != null ? ae.this.pbData.aPl().size() : 0;
                    if (ae.this.eNh >= size - 3 && ae.this.eNp != null && ae.this.pbData.qH().qD() != 0) {
                        ae.this.eNp.aSE();
                    }
                    if (ae.this.eNh >= size - 1) {
                        ae.this.eNh = -1;
                        ae.this.eNl = 5;
                        bh bhVar = new bh();
                        bhVar.setData(TbadkCoreApplication.getInst().getResources().getString(d.l.read_thread_over));
                        bhVar.bO(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                        return;
                    } else if (ae.this.eNh == -1) {
                        ae.this.eNl = 5;
                        ae.this.eNh = 0;
                        bh bhVar2 = new bh();
                        bhVar2.bO(15);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
                        return;
                    } else {
                        ae.this.eNh++;
                        ae.this.eNl = 1;
                        Object b = ae.this.b(ae.this.eNh, ae.this.pbData.aPl());
                        bh bhVar3 = new bh();
                        bhVar3.bO(1);
                        bhVar3.setData(b);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar3));
                        return;
                    }
                }
                ae.this.eNl = 5;
                ae.this.eNh = 0;
            }
        }
    };
    private CustomMessageListener eNq = new CustomMessageListener(CmdConfigCustom.CMD_TTS_AUDIO_VIEW_OPTION) { // from class: com.baidu.tieba.pb.pb.main.ae.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                int rf = ((bh) customResponsedMessage.getData()).rf();
                ae.this.eNo = false;
                switch (rf) {
                    case 9:
                        ae.this.B(ae.this.eNh, false);
                        return;
                    case 10:
                        ae.this.B(ae.this.eNh + 1, true);
                        return;
                    case 11:
                        ae.this.eNo = true;
                        ae.this.B(ae.this.eNh - 1, true);
                        return;
                    case 12:
                    default:
                        return;
                    case 13:
                        ae.this.eNl = 0;
                        ae.this.eNh = 0;
                        return;
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aSE();

        void aSF();

        void bc(int i, int i2);
    }

    public void B(int i, boolean z) {
        if (this.pbData != null) {
            if (z) {
                bh bhVar = new bh();
                bhVar.bO(4);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                this.eNl = 5;
            }
            this.eNh = i;
            aSA();
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
        if (this.eNo) {
            this.eNh = d(i, arrayList);
            this.eNi = c(this.eNh, arrayList);
        } else {
            this.eNh = i;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            PostData postData = arrayList.get(i2);
            int i4 = (postData == null || postData.bsy() != this.eNi) ? i3 : i2;
            i2++;
            i3 = i4;
        }
        if (i3 >= arrayList.size()) {
            this.eNh = arrayList.size() - 1;
            return null;
        }
        this.eNh = i3;
        bi biVar = new bi();
        if (arrayList.get(this.eNh) instanceof PostData) {
            PostData postData2 = arrayList.get(this.eNh);
            this.eNi = c(this.eNh + 1, arrayList);
            if (postData2.bsy() == 1) {
                biVar.threadTitle = this.threadTitle;
                if (!this.eNn) {
                    biVar.YR = true;
                } else {
                    biVar.YR = false;
                }
            } else {
                if (postData2.bsy() != 0) {
                    biVar.YS = String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.is_floor), Integer.valueOf(postData2.bsy()));
                }
                biVar.threadTitle = this.threadTitle;
                biVar.YR = false;
            }
            biVar.YU = postData2.aAP();
            return biVar;
        }
        return null;
    }

    private int c(int i, ArrayList<PostData> arrayList) {
        if (i < 0 || arrayList == null || arrayList.size() <= 0 || i >= arrayList.size() || arrayList.get(i) == null) {
            return -1;
        }
        int bsy = arrayList.get(i).bsy();
        if (i > 0 && bsy == 0) {
            return this.eNi + 1;
        }
        return bsy;
    }

    private int d(int i, ArrayList<PostData> arrayList) {
        if (i >= 0 && arrayList != null && arrayList.size() > 0 && i < arrayList.size()) {
            for (int i2 = i; i2 >= 0; i2--) {
                PostData postData = arrayList.get(i2);
                if (postData != null && postData.bsy() > 0) {
                    return i2;
                }
            }
            return i;
        }
        return i;
    }

    private void aSA() {
        bh bhVar = new bh();
        Object obj = null;
        switch (this.eNl) {
            case 0:
            case 5:
                bhVar.bO(1);
                obj = b(this.eNh, this.pbData.aPl());
                this.eNl = 1;
                break;
            case 1:
                bhVar.bO(2);
                this.eNl = 2;
                break;
            case 2:
                bhVar.bO(3);
                this.eNl = 3;
                break;
            case 3:
                bhVar.bO(2);
                this.eNl = 2;
                break;
            case 4:
            default:
                bhVar.bO(1);
                this.eNl = 1;
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
            this.eNh = 0;
            this.eNl = 5;
        } else if (i != 1 && i != 3 && i != 4) {
            if (i == 6) {
                this.eNh = 0;
                return;
            }
            bh bhVar2 = new bh();
            bhVar2.bO(4);
            this.eNh = 0;
            this.eNl = 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
        }
    }

    public ae() {
        MessageManager.getInstance().registerListener(this.aYO);
        MessageManager.getInstance().registerListener(this.eNq);
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2) {
        a(fVar, z, i, z2, true);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, boolean z2, boolean z3) {
        this.pbData = fVar;
        this.isSquence = z;
        this.eNm = z2;
        this.loadType = i;
        if (fVar != null && fVar.aPj() != null) {
            this.threadTitle = fVar.aPj().getTitle();
            if (StringUtils.isNull(this.threadTitle)) {
                this.threadTitle = fVar.aPj().rN();
            }
            this.eNn = fVar.aPj().rU() == 1;
        }
        if (z3) {
            a(fVar, z, i, z2);
        }
    }

    public void clearData() {
        this.pbData = null;
        this.eNh = 0;
        this.eNl = 0;
        this.isSquence = true;
    }

    public void a(a aVar) {
        this.eNp = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aYO);
        MessageManager.getInstance().unRegisterListener(this.eNq);
    }

    public int aSB() {
        return this.eNl;
    }

    public void pg(int i) {
        this.eNl = i;
    }

    public int aSC() {
        if (this.pbData == null || this.pbData.aPl() == null) {
            return -1;
        }
        if (this.eNh >= 0 && this.eNh < this.pbData.aPl().size()) {
            this.eNk = this.pbData.aPl().get(this.eNh);
        }
        if (this.eNk != null) {
            return this.eNk.bsy();
        }
        return -1;
    }

    public PostData aSD() {
        if (this.pbData == null || this.pbData.aPl() == null) {
            return null;
        }
        if (this.eNh >= 0 && this.eNh < this.pbData.aPl().size()) {
            this.eNk = this.pbData.aPl().get(this.eNh);
        }
        return this.eNk;
    }
}
