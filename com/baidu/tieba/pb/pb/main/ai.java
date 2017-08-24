package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ai {
    private boolean eMM;
    private boolean eMO;
    private com.baidu.tieba.pb.data.f eMZ;
    private String ePC;
    private boolean ePD;
    private boolean ePE;
    private Parcelable ePF;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aTl().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aTl().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aTl().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aTl().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    ai.aTl().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ai ePG = new ai();
    }

    public static ai aTl() {
        return a.ePG;
    }

    private ai() {
        this.ePC = null;
        this.ePD = false;
        this.eMZ = null;
        this.ePE = false;
        this.ePF = null;
        this.eMO = true;
        this.eMM = false;
    }

    public void S(String str, boolean z) {
        this.ePD = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.ePC = null;
        } else if (!str.equals(this.ePC)) {
            reset();
            this.ePC = str;
        } else {
            this.ePD = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.ePD) {
            this.ePE = false;
            return null;
        } else if (this.eMZ != null && this.eMZ.aPN() != null && this.eMZ.aPN().size() > 0) {
            this.ePE = true;
            com.baidu.tieba.pb.data.f fVar = this.eMZ;
            this.eMZ = null;
            return fVar;
        } else {
            this.ePE = false;
            this.eMZ = null;
            return null;
        }
    }

    public Parcelable aTm() {
        if (this.ePE) {
            this.ePE = false;
            Parcelable parcelable = this.ePF;
            this.ePF = null;
            return parcelable;
        }
        this.ePF = null;
        return null;
    }

    public boolean aSa() {
        return this.eMO;
    }

    public boolean aTn() {
        return this.eMM;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.ePD = false;
        if (this.ePC == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPN() == null) {
            reset();
            return false;
        } else if (fVar.aPN().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eMZ = fVar;
            this.ePE = false;
            this.ePF = parcelable;
            this.eMO = z;
            this.eMM = z2;
            return true;
        }
    }

    public void reset() {
        this.ePD = false;
        this.eMZ = null;
        this.ePE = false;
        this.ePF = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eMZ != null && this.eMZ.aPJ() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.eMZ.aPJ().getId(), 0L)) {
                this.eMZ.aPJ().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eMZ != null && this.eMZ.aPN() != null && this.eMZ.aPN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eMZ.aPN().size();
                for (int i = 0; i < size; i++) {
                    if (this.eMZ.aPN().get(i) != null && this.eMZ.aPN().get(i).getAuthor() != null && currentAccount.equals(this.eMZ.aPN().get(i).getAuthor().getUserId()) && this.eMZ.aPN().get(i).getAuthor().getPendantData() != null) {
                        this.eMZ.aPN().get(i).getAuthor().getPendantData().cK(jVar.pW());
                        this.eMZ.aPN().get(i).getAuthor().getPendantData().Q(jVar.CB());
                    }
                }
            }
        }
    }
}
