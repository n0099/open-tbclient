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
    private boolean eLY;
    private boolean eMa;
    private com.baidu.tieba.pb.data.f eMm;
    private String eOB;
    private boolean eOC;
    private boolean eOD;
    private Parcelable eOE;
    private boolean eOF;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.af.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.af.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSE().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.af.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                af.aSE().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.af.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    af.aSE().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static af eOG = new af();
    }

    public static af aSE() {
        return a.eOG;
    }

    private af() {
        this.eOB = null;
        this.eOC = false;
        this.eMm = null;
        this.eOD = false;
        this.eOE = null;
        this.eMa = true;
        this.eLY = false;
        this.eOF = false;
    }

    public void T(String str, boolean z) {
        this.eOC = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eOB = null;
        } else if (!str.equals(this.eOB)) {
            reset();
            this.eOB = str;
        } else {
            this.eOC = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eOC) {
            this.eOD = false;
            return null;
        } else if (this.eMm != null && this.eMm.aPk() != null && this.eMm.aPk().size() > 0) {
            this.eOD = true;
            com.baidu.tieba.pb.data.f fVar = this.eMm;
            this.eMm = null;
            return fVar;
        } else {
            this.eOD = false;
            this.eMm = null;
            return null;
        }
    }

    public Parcelable aSF() {
        if (this.eOD) {
            this.eOD = false;
            Parcelable parcelable = this.eOE;
            this.eOE = null;
            return parcelable;
        }
        this.eOE = null;
        return null;
    }

    public boolean aRD() {
        return this.eMa;
    }

    public boolean aSG() {
        return this.eLY;
    }

    public boolean aSH() {
        return this.eOF;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eOC = false;
        if (this.eOB == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPk() == null) {
            reset();
            return false;
        } else if (fVar.aPk().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eMm = fVar;
            this.eOD = false;
            this.eOE = parcelable;
            this.eMa = z;
            this.eLY = z2;
            this.eOF = z3;
            return true;
        }
    }

    public void reset() {
        this.eOC = false;
        this.eMm = null;
        this.eOD = false;
        this.eOE = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eMm != null && this.eMm.aPg() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eMm.aPg().getId(), 0L)) {
                this.eMm.aPg().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eMm != null && this.eMm.aPk() != null && this.eMm.aPk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eMm.aPk().size();
                for (int i = 0; i < size; i++) {
                    if (this.eMm.aPk().get(i) != null && this.eMm.aPk().get(i).getAuthor() != null && currentAccount.equals(this.eMm.aPk().get(i).getAuthor().getUserId()) && this.eMm.aPk().get(i).getAuthor().getPendantData() != null) {
                        this.eMm.aPk().get(i).getAuthor().getPendantData().cA(jVar.pR());
                        this.eMm.aPk().get(i).getAuthor().getPendantData().P(jVar.Cw());
                    }
                }
            }
        }
    }
}
