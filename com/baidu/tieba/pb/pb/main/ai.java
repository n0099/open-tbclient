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
    private boolean eKQ;
    private boolean eKS;
    private com.baidu.tieba.pb.data.f eLd;
    private String eNG;
    private boolean eNH;
    private boolean eNI;
    private Parcelable eNJ;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSJ().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSJ().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    ai.aSJ().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ai eNK = new ai();
    }

    public static ai aSJ() {
        return a.eNK;
    }

    private ai() {
        this.eNG = null;
        this.eNH = false;
        this.eLd = null;
        this.eNI = false;
        this.eNJ = null;
        this.eKS = true;
        this.eKQ = false;
    }

    public void R(String str, boolean z) {
        this.eNH = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eNG = null;
        } else if (!str.equals(this.eNG)) {
            reset();
            this.eNG = str;
        } else {
            this.eNH = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eNH) {
            this.eNI = false;
            return null;
        } else if (this.eLd != null && this.eLd.aPl() != null && this.eLd.aPl().size() > 0) {
            this.eNI = true;
            com.baidu.tieba.pb.data.f fVar = this.eLd;
            this.eLd = null;
            return fVar;
        } else {
            this.eNI = false;
            this.eLd = null;
            return null;
        }
    }

    public Parcelable aSK() {
        if (this.eNI) {
            this.eNI = false;
            Parcelable parcelable = this.eNJ;
            this.eNJ = null;
            return parcelable;
        }
        this.eNJ = null;
        return null;
    }

    public boolean aRy() {
        return this.eKS;
    }

    public boolean aSL() {
        return this.eKQ;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eNH = false;
        if (this.eNG == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPl() == null) {
            reset();
            return false;
        } else if (fVar.aPl().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eLd = fVar;
            this.eNI = false;
            this.eNJ = parcelable;
            this.eKS = z;
            this.eKQ = z2;
            return true;
        }
    }

    public void reset() {
        this.eNH = false;
        this.eLd = null;
        this.eNI = false;
        this.eNJ = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eLd != null && this.eLd.aPh() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.eLd.aPh().getId(), 0L)) {
                this.eLd.aPh().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eLd != null && this.eLd.aPl() != null && this.eLd.aPl().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eLd.aPl().size();
                for (int i = 0; i < size; i++) {
                    if (this.eLd.aPl().get(i) != null && this.eLd.aPl().get(i).getAuthor() != null && currentAccount.equals(this.eLd.aPl().get(i).getAuthor().getUserId()) && this.eLd.aPl().get(i).getAuthor().getPendantData() != null) {
                        this.eLd.aPl().get(i).getAuthor().getPendantData().cH(jVar.pV());
                        this.eLd.aPl().get(i).getAuthor().getPendantData().Q(jVar.CB());
                    }
                }
            }
        }
    }
}
