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
    private boolean eWS;
    private boolean eWU;
    private com.baidu.tieba.pb.data.f eXh;
    private String eZK;
    private boolean eZL;
    private boolean eZM;
    private Parcelable eZN;
    private boolean eZO;
    private PostData eZP;
    private PostData eZQ;
    private int eZR;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVn().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVn().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVn().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aVn().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ai.aVn().a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ai eZS = new ai();
    }

    public static ai aVn() {
        return a.eZS;
    }

    private ai() {
        this.eZK = null;
        this.eZL = false;
        this.eXh = null;
        this.eZM = false;
        this.eZN = null;
        this.eWU = true;
        this.eWS = false;
        this.eZO = false;
    }

    public void P(String str, boolean z) {
        this.eZL = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eZK = null;
        } else if (!str.equals(this.eZK)) {
            reset();
            this.eZK = str;
        } else {
            this.eZL = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eZL) {
            this.eZM = false;
            return null;
        } else if (this.eXh != null && this.eXh.aRj() != null && this.eXh.aRj().size() > 0) {
            this.eZM = true;
            com.baidu.tieba.pb.data.f fVar = this.eXh;
            this.eXh = null;
            return fVar;
        } else {
            this.eZM = false;
            this.eXh = null;
            return null;
        }
    }

    public Parcelable aVo() {
        if (this.eZM) {
            this.eZM = false;
            Parcelable parcelable = this.eZN;
            this.eZN = null;
            return parcelable;
        }
        this.eZN = null;
        return null;
    }

    public int aVp() {
        return this.eZR;
    }

    public void qd(int i) {
        this.eZR = i;
    }

    public PostData aVq() {
        return this.eZQ;
    }

    public void i(PostData postData) {
        this.eZQ = postData;
    }

    public PostData aVr() {
        return this.eZP;
    }

    public void j(PostData postData) {
        this.eZP = postData;
    }

    public boolean aUf() {
        return this.eWU;
    }

    public boolean aVs() {
        return this.eWS;
    }

    public boolean aVt() {
        return this.eZO;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eZL = false;
        if (this.eZK == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aRj() == null) {
            reset();
            return false;
        } else if (fVar.aRj().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eXh = fVar;
            this.eZM = false;
            this.eZN = parcelable;
            this.eWU = z;
            this.eWS = z2;
            this.eZO = z3;
            return true;
        }
    }

    public void reset() {
        this.eZL = false;
        this.eXh = null;
        this.eZM = false;
        this.eZN = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eXh != null && this.eXh.aRf() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eXh.aRf().getId(), 0L)) {
                this.eXh.aRf().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eXh != null && this.eXh.aRj() != null && this.eXh.aRj().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eXh.aRj().size();
                for (int i = 0; i < size; i++) {
                    if (this.eXh.aRj().get(i) != null && this.eXh.aRj().get(i).rx() != null && currentAccount.equals(this.eXh.aRj().get(i).rx().getUserId()) && this.eXh.aRj().get(i).rx().getPendantData() != null) {
                        this.eXh.aRj().get(i).rx().getPendantData().cF(kVar.pT());
                        this.eXh.aRj().get(i).rx().getPendantData().T(kVar.CE());
                    }
                }
            }
        }
    }
}
