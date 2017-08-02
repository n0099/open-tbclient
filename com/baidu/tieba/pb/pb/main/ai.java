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
    private boolean eJD;
    private boolean eJF;
    private com.baidu.tieba.pb.data.f eJQ;
    private String eMt;
    private boolean eMu;
    private boolean eMv;
    private Parcelable eMw;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSy().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSy().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSy().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aSy().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    ai.aSy().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ai eMx = new ai();
    }

    public static ai aSy() {
        return a.eMx;
    }

    private ai() {
        this.eMt = null;
        this.eMu = false;
        this.eJQ = null;
        this.eMv = false;
        this.eMw = null;
        this.eJF = true;
        this.eJD = false;
    }

    public void S(String str, boolean z) {
        this.eMu = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eMt = null;
        } else if (!str.equals(this.eMt)) {
            reset();
            this.eMt = str;
        } else {
            this.eMu = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eMu) {
            this.eMv = false;
            return null;
        } else if (this.eJQ != null && this.eJQ.aPa() != null && this.eJQ.aPa().size() > 0) {
            this.eMv = true;
            com.baidu.tieba.pb.data.f fVar = this.eJQ;
            this.eJQ = null;
            return fVar;
        } else {
            this.eMv = false;
            this.eJQ = null;
            return null;
        }
    }

    public Parcelable aSz() {
        if (this.eMv) {
            this.eMv = false;
            Parcelable parcelable = this.eMw;
            this.eMw = null;
            return parcelable;
        }
        this.eMw = null;
        return null;
    }

    public boolean aRn() {
        return this.eJF;
    }

    public boolean aSA() {
        return this.eJD;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eMu = false;
        if (this.eMt == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aPa() == null) {
            reset();
            return false;
        } else if (fVar.aPa().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eJQ = fVar;
            this.eMv = false;
            this.eMw = parcelable;
            this.eJF = z;
            this.eJD = z2;
            return true;
        }
    }

    public void reset() {
        this.eMu = false;
        this.eJQ = null;
        this.eMv = false;
        this.eMw = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eJQ != null && this.eJQ.aOW() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eJQ.aOW().getId(), 0L)) {
                this.eJQ.aOW().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eJQ != null && this.eJQ.aPa() != null && this.eJQ.aPa().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eJQ.aPa().size();
                for (int i = 0; i < size; i++) {
                    if (this.eJQ.aPa().get(i) != null && this.eJQ.aPa().get(i).getAuthor() != null && currentAccount.equals(this.eJQ.aPa().get(i).getAuthor().getUserId()) && this.eJQ.aPa().get(i).getAuthor().getPendantData() != null) {
                        this.eJQ.aPa().get(i).getAuthor().getPendantData().cB(jVar.pL());
                        this.eJQ.aPa().get(i).getAuthor().getPendantData().Q(jVar.Ct());
                    }
                }
            }
        }
    }
}
