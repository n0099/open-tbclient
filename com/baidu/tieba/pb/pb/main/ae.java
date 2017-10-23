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
public class ae {
    private com.baidu.tieba.pb.data.f eFA;
    private boolean eFm;
    private boolean eFo;
    private String eIa;
    private boolean eIb;
    private boolean eIc;
    private Parcelable eId;
    private boolean eIe;
    private PostData eIf;
    private PostData eIg;
    private int eIh;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQz().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ae.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQz().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ae.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQz().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ae.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQz().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ae.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    ae.aQz().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ae eIi = new ae();
    }

    public static ae aQz() {
        return a.eIi;
    }

    private ae() {
        this.eIa = null;
        this.eIb = false;
        this.eFA = null;
        this.eIc = false;
        this.eId = null;
        this.eFo = true;
        this.eFm = false;
        this.eIe = false;
    }

    public void Q(String str, boolean z) {
        this.eIb = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eIa = null;
        } else if (!str.equals(this.eIa)) {
            reset();
            this.eIa = str;
        } else {
            this.eIb = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eIb) {
            this.eIc = false;
            return null;
        } else if (this.eFA != null && this.eFA.aMY() != null && this.eFA.aMY().size() > 0) {
            this.eIc = true;
            com.baidu.tieba.pb.data.f fVar = this.eFA;
            this.eFA = null;
            return fVar;
        } else {
            this.eIc = false;
            this.eFA = null;
            return null;
        }
    }

    public Parcelable aQA() {
        if (this.eIc) {
            this.eIc = false;
            Parcelable parcelable = this.eId;
            this.eId = null;
            return parcelable;
        }
        this.eId = null;
        return null;
    }

    public int aQB() {
        return this.eIh;
    }

    public void ps(int i) {
        this.eIh = i;
    }

    public PostData aQC() {
        return this.eIg;
    }

    public void j(PostData postData) {
        this.eIg = postData;
    }

    public PostData aQD() {
        return this.eIf;
    }

    public void k(PostData postData) {
        this.eIf = postData;
    }

    public boolean aPs() {
        return this.eFo;
    }

    public boolean aQE() {
        return this.eFm;
    }

    public boolean aQF() {
        return this.eIe;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eIb = false;
        if (this.eIa == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aMY() == null) {
            reset();
            return false;
        } else if (fVar.aMY().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eFA = fVar;
            this.eIc = false;
            this.eId = parcelable;
            this.eFo = z;
            this.eFm = z2;
            this.eIe = z3;
            return true;
        }
    }

    public void reset() {
        this.eIb = false;
        this.eFA = null;
        this.eIc = false;
        this.eId = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eFA != null && this.eFA.aMU() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eFA.aMU().getId(), 0L)) {
                this.eFA.aMU().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.eFA != null && this.eFA.aMY() != null && this.eFA.aMY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eFA.aMY().size();
                for (int i = 0; i < size; i++) {
                    if (this.eFA.aMY().get(i) != null && this.eFA.aMY().get(i).getAuthor() != null && currentAccount.equals(this.eFA.aMY().get(i).getAuthor().getUserId()) && this.eFA.aMY().get(i).getAuthor().getPendantData() != null) {
                        this.eFA.aMY().get(i).getAuthor().getPendantData().cz(iVar.pL());
                        this.eFA.aMY().get(i).getAuthor().getPendantData().Q(iVar.BU());
                    }
                }
            }
        }
    }
}
