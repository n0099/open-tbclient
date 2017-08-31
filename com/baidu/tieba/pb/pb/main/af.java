package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class af {
    private boolean eLe;
    private boolean eLg;
    private com.baidu.tieba.pb.data.f eLs;
    private String eNH;
    private boolean eNI;
    private boolean eNJ;
    private Parcelable eNK;
    private boolean eNL;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSt().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.af.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSt().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.af.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSt().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.af.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSt().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.af.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    af.aSt().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static af eNM = new af();
    }

    public static af aSt() {
        return a.eNM;
    }

    private af() {
        this.eNH = null;
        this.eNI = false;
        this.eLs = null;
        this.eNJ = false;
        this.eNK = null;
        this.eLg = true;
        this.eLe = false;
        this.eNL = false;
    }

    public void T(String str, boolean z) {
        this.eNI = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eNH = null;
        } else if (!str.equals(this.eNH)) {
            reset();
            this.eNH = str;
        } else {
            this.eNI = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eNI) {
            this.eNJ = false;
            return null;
        } else if (this.eLs != null && this.eLs.aOZ() != null && this.eLs.aOZ().size() > 0) {
            this.eNJ = true;
            com.baidu.tieba.pb.data.f fVar = this.eLs;
            this.eLs = null;
            return fVar;
        } else {
            this.eNJ = false;
            this.eLs = null;
            return null;
        }
    }

    public Parcelable aSu() {
        if (this.eNJ) {
            this.eNJ = false;
            Parcelable parcelable = this.eNK;
            this.eNK = null;
            return parcelable;
        }
        this.eNK = null;
        return null;
    }

    public boolean aRs() {
        return this.eLg;
    }

    public boolean aSv() {
        return this.eLe;
    }

    public boolean aSw() {
        return this.eNL;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eNI = false;
        if (this.eNH == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aOZ() == null) {
            reset();
            return false;
        } else if (fVar.aOZ().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eLs = fVar;
            this.eNJ = false;
            this.eNK = parcelable;
            this.eLg = z;
            this.eLe = z2;
            this.eNL = z3;
            return true;
        }
    }

    public void reset() {
        this.eNI = false;
        this.eLs = null;
        this.eNJ = false;
        this.eNK = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eLs != null && this.eLs.aOV() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eLs.aOV().getId(), 0L)) {
                this.eLs.aOV().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eLs != null && this.eLs.aOZ() != null && this.eLs.aOZ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eLs.aOZ().size();
                for (int i = 0; i < size; i++) {
                    if (this.eLs.aOZ().get(i) != null && this.eLs.aOZ().get(i).getAuthor() != null && currentAccount.equals(this.eLs.aOZ().get(i).getAuthor().getUserId()) && this.eLs.aOZ().get(i).getAuthor().getPendantData() != null) {
                        this.eLs.aOZ().get(i).getAuthor().getPendantData().cA(jVar.pR());
                        this.eLs.aOZ().get(i).getAuthor().getPendantData().P(jVar.Cw());
                    }
                }
            }
        }
    }
}
