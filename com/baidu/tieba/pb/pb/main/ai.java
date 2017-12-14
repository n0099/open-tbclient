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
public class ai {
    private boolean eXV;
    private boolean eXX;
    private com.baidu.tieba.pb.data.f eYk;
    private String faN;
    private boolean faO;
    private boolean faP;
    private Parcelable faQ;
    private boolean faR;
    private PostData faS;
    private PostData faT;
    private int faU;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVw().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVw().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVw().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVw().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ai.aVw().a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ai faV = new ai();
    }

    public static ai aVw() {
        return a.faV;
    }

    private ai() {
        this.faN = null;
        this.faO = false;
        this.eYk = null;
        this.faP = false;
        this.faQ = null;
        this.eXX = true;
        this.eXV = false;
        this.faR = false;
    }

    public void Q(String str, boolean z) {
        this.faO = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.faN = null;
        } else if (!str.equals(this.faN)) {
            reset();
            this.faN = str;
        } else {
            this.faO = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.faO) {
            this.faP = false;
            return null;
        } else if (this.eYk != null && this.eYk.aRs() != null && this.eYk.aRs().size() > 0) {
            this.faP = true;
            com.baidu.tieba.pb.data.f fVar = this.eYk;
            this.eYk = null;
            return fVar;
        } else {
            this.faP = false;
            this.eYk = null;
            return null;
        }
    }

    public Parcelable aVx() {
        if (this.faP) {
            this.faP = false;
            Parcelable parcelable = this.faQ;
            this.faQ = null;
            return parcelable;
        }
        this.faQ = null;
        return null;
    }

    public int aVy() {
        return this.faU;
    }

    public void qk(int i) {
        this.faU = i;
    }

    public PostData aVz() {
        return this.faT;
    }

    public void i(PostData postData) {
        this.faT = postData;
    }

    public PostData aVA() {
        return this.faS;
    }

    public void j(PostData postData) {
        this.faS = postData;
    }

    public boolean aUo() {
        return this.eXX;
    }

    public boolean aVB() {
        return this.eXV;
    }

    public boolean aVC() {
        return this.faR;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.faO = false;
        if (this.faN == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aRs() == null) {
            reset();
            return false;
        } else if (fVar.aRs().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eYk = fVar;
            this.faP = false;
            this.faQ = parcelable;
            this.eXX = z;
            this.eXV = z2;
            this.faR = z3;
            return true;
        }
    }

    public void reset() {
        this.faO = false;
        this.eYk = null;
        this.faP = false;
        this.faQ = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eYk != null && this.eYk.aRo() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eYk.aRo().getId(), 0L)) {
                this.eYk.aRo().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eYk != null && this.eYk.aRs() != null && this.eYk.aRs().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eYk.aRs().size();
                for (int i = 0; i < size; i++) {
                    if (this.eYk.aRs().get(i) != null && this.eYk.aRs().get(i).rv() != null && currentAccount.equals(this.eYk.aRs().get(i).rv().getUserId()) && this.eYk.aRs().get(i).rv().getPendantData() != null) {
                        this.eYk.aRs().get(i).rv().getPendantData().cF(kVar.pR());
                        this.eYk.aRs().get(i).rv().getPendantData().T(kVar.CF());
                    }
                }
            }
        }
    }
}
