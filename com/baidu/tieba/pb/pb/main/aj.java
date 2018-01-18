package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class aj {
    private com.baidu.tieba.pb.data.f fMG;
    private boolean fMr;
    private boolean fMt;
    private String fPk;
    private boolean fPl;
    private boolean fPm;
    private Parcelable fPn;
    private boolean fPo;
    private PostData fPp;
    private PostData fPq;
    private int fPr;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcN().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcN().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcN().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcN().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    aj.bcN().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fPs = new aj();
    }

    public static aj bcN() {
        return a.fPs;
    }

    private aj() {
        this.fPk = null;
        this.fPl = false;
        this.fMG = null;
        this.fPm = false;
        this.fPn = null;
        this.fMt = true;
        this.fMr = false;
        this.fPo = false;
    }

    public void R(String str, boolean z) {
        this.fPl = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fPk = null;
        } else if (!str.equals(this.fPk)) {
            reset();
            this.fPk = str;
        } else {
            this.fPl = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.fPl) {
            this.fPm = false;
            return null;
        } else if (this.fMG != null && this.fMG.aYI() != null && this.fMG.aYI().size() > 0) {
            this.fPm = true;
            com.baidu.tieba.pb.data.f fVar = this.fMG;
            this.fMG = null;
            return fVar;
        } else {
            this.fPm = false;
            this.fMG = null;
            return null;
        }
    }

    public Parcelable bcO() {
        if (this.fPm) {
            this.fPm = false;
            Parcelable parcelable = this.fPn;
            this.fPn = null;
            return parcelable;
        }
        this.fPn = null;
        return null;
    }

    public int bcP() {
        return this.fPr;
    }

    public void sW(int i) {
        this.fPr = i;
    }

    public PostData bcQ() {
        return this.fPq;
    }

    public void i(PostData postData) {
        this.fPq = postData;
    }

    public PostData bcR() {
        return this.fPp;
    }

    public void j(PostData postData) {
        this.fPp = postData;
    }

    public boolean bbG() {
        return this.fMt;
    }

    public boolean bcS() {
        return this.fMr;
    }

    public boolean bcT() {
        return this.fPo;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fPl = false;
        if (this.fPk == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aYI() == null) {
            reset();
            return false;
        } else if (fVar.aYI().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fMG = fVar;
            this.fPm = false;
            this.fPn = parcelable;
            this.fMt = z;
            this.fMr = z2;
            this.fPo = z3;
            return true;
        }
    }

    public void reset() {
        this.fPl = false;
        this.fMG = null;
        this.fPm = false;
        this.fPn = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fMG != null && this.fMG.aYE() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fMG.aYE().getId(), 0L)) {
                this.fMG.aYE().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fMG != null && this.fMG.aYI() != null && this.fMG.aYI().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fMG.aYI().size();
                for (int i = 0; i < size; i++) {
                    if (this.fMG.aYI().get(i) != null && this.fMG.aYI().get(i).yS() != null && currentAccount.equals(this.fMG.aYI().get(i).yS().getUserId()) && this.fMG.aYI().get(i).yS().getPendantData() != null) {
                        this.fMG.aYI().get(i).yS().getPendantData().cM(hVar.xt());
                        this.fMG.aYI().get(i).yS().getPendantData().ab(hVar.JW());
                    }
                }
            }
        }
    }
}
