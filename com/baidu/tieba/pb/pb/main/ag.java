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
    private com.baidu.tieba.pb.data.f eOE;
    private boolean eOq;
    private boolean eOs;
    private String eRe;
    private boolean eRf;
    private boolean eRg;
    private Parcelable eRh;
    private boolean eRi;
    private PostData eRj;
    private PostData eRk;
    private int eRl;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ag.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ag.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTO().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ag.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ag.aTO().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ag.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ag.aTO().a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ag eRm = new ag();
    }

    public static ag aTO() {
        return a.eRm;
    }

    private ag() {
        this.eRe = null;
        this.eRf = false;
        this.eOE = null;
        this.eRg = false;
        this.eRh = null;
        this.eOs = true;
        this.eOq = false;
        this.eRi = false;
    }

    public void O(String str, boolean z) {
        this.eRf = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eRe = null;
        } else if (!str.equals(this.eRe)) {
            reset();
            this.eRe = str;
        } else {
            this.eRf = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eRf) {
            this.eRg = false;
            return null;
        } else if (this.eOE != null && this.eOE.aPY() != null && this.eOE.aPY().size() > 0) {
            this.eRg = true;
            com.baidu.tieba.pb.data.f fVar = this.eOE;
            this.eOE = null;
            return fVar;
        } else {
            this.eRg = false;
            this.eOE = null;
            return null;
        }
    }

    public Parcelable aTP() {
        if (this.eRg) {
            this.eRg = false;
            Parcelable parcelable = this.eRh;
            this.eRh = null;
            return parcelable;
        }
        this.eRh = null;
        return null;
    }

    public int aTQ() {
        return this.eRl;
    }

    public void pN(int i) {
        this.eRl = i;
    }

    public PostData aTR() {
        return this.eRk;
    }

    public void i(PostData postData) {
        this.eRk = postData;
    }

    public PostData aTS() {
        return this.eRj;
    }

    public void j(PostData postData) {
        this.eRj = postData;
    }

    public boolean aSI() {
        return this.eOs;
    }

    public boolean aTT() {
        return this.eOq;
    }

    public boolean aTU() {
        return this.eRi;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eRf = false;
        if (this.eRe == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPY() == null) {
            reset();
            return false;
        } else if (fVar.aPY().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eOE = fVar;
            this.eRg = false;
            this.eRh = parcelable;
            this.eOs = z;
            this.eOq = z2;
            this.eRi = z3;
            return true;
        }
    }

    public void reset() {
        this.eRf = false;
        this.eOE = null;
        this.eRg = false;
        this.eRh = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eOE != null && this.eOE.aPU() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eOE.aPU().getId(), 0L)) {
                this.eOE.aPU().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eOE != null && this.eOE.aPY() != null && this.eOE.aPY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eOE.aPY().size();
                for (int i = 0; i < size; i++) {
                    if (this.eOE.aPY().get(i) != null && this.eOE.aPY().get(i).rt() != null && currentAccount.equals(this.eOE.aPY().get(i).rt().getUserId()) && this.eOE.aPY().get(i).rt().getPendantData() != null) {
                        this.eOE.aPY().get(i).rt().getPendantData().cF(kVar.pQ());
                        this.eOE.aPY().get(i).rt().getPendantData().Q(kVar.Cv());
                    }
                }
            }
        }
    }
}
