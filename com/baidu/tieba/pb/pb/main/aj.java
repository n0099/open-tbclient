package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class aj {
    private com.baidu.tieba.pb.data.d hQG;
    private boolean hQp;
    private boolean hQr;
    private String hTm;
    private boolean hTn;
    private boolean hTo;
    private Parcelable hTp;
    private boolean hTq;
    private PostData hTr;
    private PostData hTs;
    private int hTt;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUI().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUI().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bUI().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bUI().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bUI().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hTu = new aj();
    }

    public static aj bUI() {
        return a.hTu;
    }

    private aj() {
        this.hTm = null;
        this.hTn = false;
        this.hQG = null;
        this.hTo = false;
        this.hTp = null;
        this.hQr = true;
        this.hQp = false;
        this.hTq = false;
    }

    public void ap(String str, boolean z) {
        this.hTn = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hTm = null;
        } else if (!str.equals(this.hTm)) {
            reset();
            this.hTm = str;
        } else {
            this.hTn = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hTn) {
            this.hTo = false;
            return null;
        } else if (this.hQG != null && this.hQG.bQz() != null && this.hQG.bQz().size() > 0) {
            this.hTo = true;
            com.baidu.tieba.pb.data.d dVar = this.hQG;
            this.hQG = null;
            return dVar;
        } else {
            this.hTo = false;
            this.hQG = null;
            return null;
        }
    }

    public Parcelable bUJ() {
        if (this.hTo) {
            this.hTo = false;
            Parcelable parcelable = this.hTp;
            this.hTp = null;
            return parcelable;
        }
        this.hTp = null;
        return null;
    }

    public int bUK() {
        return this.hTt;
    }

    public void wM(int i) {
        this.hTt = i;
    }

    public PostData bUL() {
        return this.hTs;
    }

    public void k(PostData postData) {
        this.hTs = postData;
    }

    public PostData bUM() {
        return this.hTr;
    }

    public void l(PostData postData) {
        this.hTr = postData;
    }

    public boolean bTz() {
        return this.hQr;
    }

    public boolean bUN() {
        return this.hQp;
    }

    public boolean bUO() {
        return this.hTq;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hTn = false;
        if (this.hTm == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bQz() == null) {
            reset();
            return false;
        } else if (dVar.bQz().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hQG = dVar;
            this.hTo = false;
            this.hTp = parcelable;
            this.hQr = z;
            this.hQp = z2;
            this.hTq = z3;
            return true;
        }
    }

    public void reset() {
        this.hTn = false;
        this.hQG = null;
        this.hTo = false;
        this.hTp = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hQG != null && this.hQG.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.toLong(this.hQG.getForum().getId(), 0L)) {
                this.hQG.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hQG != null && this.hQG.bQz() != null && this.hQG.bQz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hQG.bQz().size();
                for (int i = 0; i < size; i++) {
                    if (this.hQG.bQz().get(i) != null && this.hQG.bQz().get(i).aiE() != null && currentAccount.equals(this.hQG.bQz().get(i).aiE().getUserId()) && this.hQG.bQz().get(i).aiE().getPendantData() != null) {
                        this.hQG.bQz().get(i).aiE().getPendantData().mU(lVar.ahd());
                        this.hQG.bQz().get(i).aiE().getPendantData().aZ(lVar.atC());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hQG != null && eVar != null) {
            ArrayList<PostData> bQz = this.hQG.bQz();
            if (!com.baidu.tbadk.core.util.v.isEmpty(bQz)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bQz) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData akt = postData.akt();
                        akt.agreeType = agreeData.agreeType;
                        akt.hasAgree = agreeData.hasAgree;
                        akt.diffAgreeNum = agreeData.diffAgreeNum;
                        akt.agreeNum = agreeData.agreeNum;
                        akt.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hQG != null && this.hQG.bQx() != null && this.hQG.bQx().akt() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData akt = this.hQG.bQx().akt();
            if (!TextUtils.isEmpty(akt.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && akt.threadId.equals(agreeData.threadId)) {
                akt.agreeType = agreeData.agreeType;
                akt.hasAgree = agreeData.hasAgree;
                akt.diffAgreeNum = agreeData.diffAgreeNum;
                akt.agreeNum = agreeData.agreeNum;
                akt.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
