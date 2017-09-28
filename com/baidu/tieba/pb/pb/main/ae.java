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
    private boolean eFA;
    private boolean eFC;
    private com.baidu.tieba.pb.data.f eFO;
    private String eIo;
    private boolean eIp;
    private boolean eIq;
    private Parcelable eIr;
    private boolean eIs;
    private PostData eIt;
    private PostData eIu;
    private int eIv;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ae.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ae.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQE().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ae.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ae.aQE().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ae.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    ae.aQE().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ae eIw = new ae();
    }

    public static ae aQE() {
        return a.eIw;
    }

    private ae() {
        this.eIo = null;
        this.eIp = false;
        this.eFO = null;
        this.eIq = false;
        this.eIr = null;
        this.eFC = true;
        this.eFA = false;
        this.eIs = false;
    }

    public void Q(String str, boolean z) {
        this.eIp = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eIo = null;
        } else if (!str.equals(this.eIo)) {
            reset();
            this.eIo = str;
        } else {
            this.eIp = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eIp) {
            this.eIq = false;
            return null;
        } else if (this.eFO != null && this.eFO.aNd() != null && this.eFO.aNd().size() > 0) {
            this.eIq = true;
            com.baidu.tieba.pb.data.f fVar = this.eFO;
            this.eFO = null;
            return fVar;
        } else {
            this.eIq = false;
            this.eFO = null;
            return null;
        }
    }

    public Parcelable aQF() {
        if (this.eIq) {
            this.eIq = false;
            Parcelable parcelable = this.eIr;
            this.eIr = null;
            return parcelable;
        }
        this.eIr = null;
        return null;
    }

    public int aQG() {
        return this.eIv;
    }

    public void pt(int i) {
        this.eIv = i;
    }

    public PostData aQH() {
        return this.eIu;
    }

    public void j(PostData postData) {
        this.eIu = postData;
    }

    public PostData aQI() {
        return this.eIt;
    }

    public void k(PostData postData) {
        this.eIt = postData;
    }

    public boolean aPx() {
        return this.eFC;
    }

    public boolean aQJ() {
        return this.eFA;
    }

    public boolean aQK() {
        return this.eIs;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.eIp = false;
        if (this.eIo == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aNd() == null) {
            reset();
            return false;
        } else if (fVar.aNd().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eFO = fVar;
            this.eIq = false;
            this.eIr = parcelable;
            this.eFC = z;
            this.eFA = z2;
            this.eIs = z3;
            return true;
        }
    }

    public void reset() {
        this.eIp = false;
        this.eFO = null;
        this.eIq = false;
        this.eIr = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eFO != null && this.eFO.aMZ() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eFO.aMZ().getId(), 0L)) {
                this.eFO.aMZ().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.eFO != null && this.eFO.aNd() != null && this.eFO.aNd().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eFO.aNd().size();
                for (int i = 0; i < size; i++) {
                    if (this.eFO.aNd().get(i) != null && this.eFO.aNd().get(i).getAuthor() != null && currentAccount.equals(this.eFO.aNd().get(i).getAuthor().getUserId()) && this.eFO.aNd().get(i).getAuthor().getPendantData() != null) {
                        this.eFO.aNd().get(i).getAuthor().getPendantData().cA(iVar.pS());
                        this.eFO.aNd().get(i).getAuthor().getPendantData().P(iVar.Ca());
                    }
                }
            }
        }
    }
}
