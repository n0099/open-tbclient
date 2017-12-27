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
    private boolean fKR;
    private boolean fKT;
    private com.baidu.tieba.pb.data.f fLg;
    private String fNK;
    private boolean fNL;
    private boolean fNM;
    private Parcelable fNN;
    private boolean fNO;
    private PostData fNP;
    private PostData fNQ;
    private int fNR;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcJ().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bcJ().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    aj.bcJ().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fNS = new aj();
    }

    public static aj bcJ() {
        return a.fNS;
    }

    private aj() {
        this.fNK = null;
        this.fNL = false;
        this.fLg = null;
        this.fNM = false;
        this.fNN = null;
        this.fKT = true;
        this.fKR = false;
        this.fNO = false;
    }

    public void R(String str, boolean z) {
        this.fNL = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fNK = null;
        } else if (!str.equals(this.fNK)) {
            reset();
            this.fNK = str;
        } else {
            this.fNL = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.fNL) {
            this.fNM = false;
            return null;
        } else if (this.fLg != null && this.fLg.aYC() != null && this.fLg.aYC().size() > 0) {
            this.fNM = true;
            com.baidu.tieba.pb.data.f fVar = this.fLg;
            this.fLg = null;
            return fVar;
        } else {
            this.fNM = false;
            this.fLg = null;
            return null;
        }
    }

    public Parcelable bcK() {
        if (this.fNM) {
            this.fNM = false;
            Parcelable parcelable = this.fNN;
            this.fNN = null;
            return parcelable;
        }
        this.fNN = null;
        return null;
    }

    public int bcL() {
        return this.fNR;
    }

    public void te(int i) {
        this.fNR = i;
    }

    public PostData bcM() {
        return this.fNQ;
    }

    public void i(PostData postData) {
        this.fNQ = postData;
    }

    public PostData bcN() {
        return this.fNP;
    }

    public void j(PostData postData) {
        this.fNP = postData;
    }

    public boolean bbC() {
        return this.fKT;
    }

    public boolean bcO() {
        return this.fKR;
    }

    public boolean bcP() {
        return this.fNO;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fNL = false;
        if (this.fNK == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aYC() == null) {
            reset();
            return false;
        } else if (fVar.aYC().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fLg = fVar;
            this.fNM = false;
            this.fNN = parcelable;
            this.fKT = z;
            this.fKR = z2;
            this.fNO = z3;
            return true;
        }
    }

    public void reset() {
        this.fNL = false;
        this.fLg = null;
        this.fNM = false;
        this.fNN = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fLg != null && this.fLg.aYy() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fLg.aYy().getId(), 0L)) {
                this.fLg.aYy().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fLg != null && this.fLg.aYC() != null && this.fLg.aYC().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fLg.aYC().size();
                for (int i = 0; i < size; i++) {
                    if (this.fLg.aYC().get(i) != null && this.fLg.aYC().get(i).yX() != null && currentAccount.equals(this.fLg.aYC().get(i).yX().getUserId()) && this.fLg.aYC().get(i).yX().getPendantData() != null) {
                        this.fLg.aYC().get(i).yX().getPendantData().cM(hVar.xu());
                        this.fLg.aYC().get(i).yX().getPendantData().ab(hVar.Kh());
                    }
                }
            }
        }
    }
}
