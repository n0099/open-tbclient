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
    private boolean fMM;
    private boolean fMO;
    private com.baidu.tieba.pb.data.f fNb;
    private String fPF;
    private boolean fPG;
    private boolean fPH;
    private Parcelable fPI;
    private boolean fPJ;
    private PostData fPK;
    private PostData fPL;
    private int fPM;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcS().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcS().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    aj.bcS().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fPN = new aj();
    }

    public static aj bcS() {
        return a.fPN;
    }

    private aj() {
        this.fPF = null;
        this.fPG = false;
        this.fNb = null;
        this.fPH = false;
        this.fPI = null;
        this.fMO = true;
        this.fMM = false;
        this.fPJ = false;
    }

    public void R(String str, boolean z) {
        this.fPG = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fPF = null;
        } else if (!str.equals(this.fPF)) {
            reset();
            this.fPF = str;
        } else {
            this.fPG = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.fPG) {
            this.fPH = false;
            return null;
        } else if (this.fNb != null && this.fNb.aYN() != null && this.fNb.aYN().size() > 0) {
            this.fPH = true;
            com.baidu.tieba.pb.data.f fVar = this.fNb;
            this.fNb = null;
            return fVar;
        } else {
            this.fPH = false;
            this.fNb = null;
            return null;
        }
    }

    public Parcelable bcT() {
        if (this.fPH) {
            this.fPH = false;
            Parcelable parcelable = this.fPI;
            this.fPI = null;
            return parcelable;
        }
        this.fPI = null;
        return null;
    }

    public int bcU() {
        return this.fPM;
    }

    public void sW(int i) {
        this.fPM = i;
    }

    public PostData bcV() {
        return this.fPL;
    }

    public void i(PostData postData) {
        this.fPL = postData;
    }

    public PostData bcW() {
        return this.fPK;
    }

    public void j(PostData postData) {
        this.fPK = postData;
    }

    public boolean bbL() {
        return this.fMO;
    }

    public boolean bcX() {
        return this.fMM;
    }

    public boolean bcY() {
        return this.fPJ;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fPG = false;
        if (this.fPF == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aYN() == null) {
            reset();
            return false;
        } else if (fVar.aYN().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fNb = fVar;
            this.fPH = false;
            this.fPI = parcelable;
            this.fMO = z;
            this.fMM = z2;
            this.fPJ = z3;
            return true;
        }
    }

    public void reset() {
        this.fPG = false;
        this.fNb = null;
        this.fPH = false;
        this.fPI = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fNb != null && this.fNb.aYJ() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fNb.aYJ().getId(), 0L)) {
                this.fNb.aYJ().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fNb != null && this.fNb.aYN() != null && this.fNb.aYN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fNb.aYN().size();
                for (int i = 0; i < size; i++) {
                    if (this.fNb.aYN().get(i) != null && this.fNb.aYN().get(i).yT() != null && currentAccount.equals(this.fNb.aYN().get(i).yT().getUserId()) && this.fNb.aYN().get(i).yT().getPendantData() != null) {
                        this.fNb.aYN().get(i).yT().getPendantData().cM(hVar.xu());
                        this.fNb.aYN().get(i).yT().getPendantData().ab(hVar.JY());
                    }
                }
            }
        }
    }
}
