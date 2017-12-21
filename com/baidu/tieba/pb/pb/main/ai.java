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
    private boolean eYa;
    private boolean eYc;
    private com.baidu.tieba.pb.data.f eYp;
    private String faS;
    private boolean faT;
    private boolean faU;
    private Parcelable faV;
    private boolean faW;
    private PostData faX;
    private PostData faY;
    private int faZ;

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
        private static ai fba = new ai();
    }

    public static ai aVw() {
        return a.fba;
    }

    private ai() {
        this.faS = null;
        this.faT = false;
        this.eYp = null;
        this.faU = false;
        this.faV = null;
        this.eYc = true;
        this.eYa = false;
        this.faW = false;
    }

    public void Q(String str, boolean z) {
        this.faT = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.faS = null;
        } else if (!str.equals(this.faS)) {
            reset();
            this.faS = str;
        } else {
            this.faT = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.faT) {
            this.faU = false;
            return null;
        } else if (this.eYp != null && this.eYp.aRs() != null && this.eYp.aRs().size() > 0) {
            this.faU = true;
            com.baidu.tieba.pb.data.f fVar = this.eYp;
            this.eYp = null;
            return fVar;
        } else {
            this.faU = false;
            this.eYp = null;
            return null;
        }
    }

    public Parcelable aVx() {
        if (this.faU) {
            this.faU = false;
            Parcelable parcelable = this.faV;
            this.faV = null;
            return parcelable;
        }
        this.faV = null;
        return null;
    }

    public int aVy() {
        return this.faZ;
    }

    public void qk(int i) {
        this.faZ = i;
    }

    public PostData aVz() {
        return this.faY;
    }

    public void i(PostData postData) {
        this.faY = postData;
    }

    public PostData aVA() {
        return this.faX;
    }

    public void j(PostData postData) {
        this.faX = postData;
    }

    public boolean aUo() {
        return this.eYc;
    }

    public boolean aVB() {
        return this.eYa;
    }

    public boolean aVC() {
        return this.faW;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.faT = false;
        if (this.faS == null) {
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
            this.eYp = fVar;
            this.faU = false;
            this.faV = parcelable;
            this.eYc = z;
            this.eYa = z2;
            this.faW = z3;
            return true;
        }
    }

    public void reset() {
        this.faT = false;
        this.eYp = null;
        this.faU = false;
        this.faV = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eYp != null && this.eYp.aRo() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eYp.aRo().getId(), 0L)) {
                this.eYp.aRo().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eYp != null && this.eYp.aRs() != null && this.eYp.aRs().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eYp.aRs().size();
                for (int i = 0; i < size; i++) {
                    if (this.eYp.aRs().get(i) != null && this.eYp.aRs().get(i).rv() != null && currentAccount.equals(this.eYp.aRs().get(i).rv().getUserId()) && this.eYp.aRs().get(i).rv().getPendantData() != null) {
                        this.eYp.aRs().get(i).rv().getPendantData().cF(kVar.pR());
                        this.eYp.aRs().get(i).rv().getPendantData().T(kVar.CF());
                    }
                }
            }
        }
    }
}
