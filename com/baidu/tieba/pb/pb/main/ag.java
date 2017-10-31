package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ag {
    private boolean eNW;
    private boolean eNY;
    private com.baidu.tieba.pb.data.f eOk;
    private String eQK;
    private boolean eQL;
    private boolean eQM;
    private Parcelable eQN;
    private boolean eQO;
    private PostData eQP;
    private PostData eQQ;
    private int eQR;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTG().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ag.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTG().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ag.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTG().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ag.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTG().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ag.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ag.aTG().a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ag eQS = new ag();
    }

    public static ag aTG() {
        return a.eQS;
    }

    private ag() {
        this.eQK = null;
        this.eQL = false;
        this.eOk = null;
        this.eQM = false;
        this.eQN = null;
        this.eNY = true;
        this.eNW = false;
        this.eQO = false;
    }

    public void O(String str, boolean z) {
        this.eQL = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eQK = null;
        } else if (!str.equals(this.eQK)) {
            reset();
            this.eQK = str;
        } else {
            this.eQL = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eQL) {
            this.eQM = false;
            return null;
        } else if (this.eOk != null && this.eOk.aPQ() != null && this.eOk.aPQ().size() > 0) {
            this.eQM = true;
            com.baidu.tieba.pb.data.f fVar = this.eOk;
            this.eOk = null;
            return fVar;
        } else {
            this.eQM = false;
            this.eOk = null;
            return null;
        }
    }

    public Parcelable aTH() {
        if (this.eQM) {
            this.eQM = false;
            Parcelable parcelable = this.eQN;
            this.eQN = null;
            return parcelable;
        }
        this.eQN = null;
        return null;
    }

    public int aTI() {
        return this.eQR;
    }

    public void pM(int i) {
        this.eQR = i;
    }

    public PostData aTJ() {
        return this.eQQ;
    }

    public void i(PostData postData) {
        this.eQQ = postData;
    }

    public PostData aTK() {
        return this.eQP;
    }

    public void j(PostData postData) {
        this.eQP = postData;
    }

    public boolean aSA() {
        return this.eNY;
    }

    public boolean aTL() {
        return this.eNW;
    }

    public boolean aTM() {
        return this.eQO;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eQL = false;
        if (this.eQK == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPQ() == null) {
            reset();
            return false;
        } else if (fVar.aPQ().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eOk = fVar;
            this.eQM = false;
            this.eQN = parcelable;
            this.eNY = z;
            this.eNW = z2;
            this.eQO = z3;
            return true;
        }
    }

    public void reset() {
        this.eQL = false;
        this.eOk = null;
        this.eQM = false;
        this.eQN = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eOk != null && this.eOk.aPM() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eOk.aPM().getId(), 0L)) {
                this.eOk.aPM().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eOk != null && this.eOk.aPQ() != null && this.eOk.aPQ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eOk.aPQ().size();
                for (int i = 0; i < size; i++) {
                    if (this.eOk.aPQ().get(i) != null && this.eOk.aPQ().get(i).rt() != null && currentAccount.equals(this.eOk.aPQ().get(i).rt().getUserId()) && this.eOk.aPQ().get(i).rt().getPendantData() != null) {
                        this.eOk.aPQ().get(i).rt().getPendantData().cF(kVar.pQ());
                        this.eOk.aPQ().get(i).rt().getPendantData().Q(kVar.Cj());
                    }
                }
            }
        }
    }
}
