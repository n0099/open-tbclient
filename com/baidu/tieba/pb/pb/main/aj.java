package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class aj {
    private com.baidu.tieba.pb.data.d hJH;
    private boolean hJq;
    private boolean hJs;
    private String hMm;
    private boolean hMn;
    private boolean hMo;
    private Parcelable hMp;
    private boolean hMq;
    private PostData hMr;
    private PostData hMs;
    private int hMt;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTO().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTO().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bTO().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTO().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTO().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hMu = new aj();
    }

    public static aj bTO() {
        return a.hMu;
    }

    private aj() {
        this.hMm = null;
        this.hMn = false;
        this.hJH = null;
        this.hMo = false;
        this.hMp = null;
        this.hJs = true;
        this.hJq = false;
        this.hMq = false;
    }

    public void aq(String str, boolean z) {
        this.hMn = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hMm = null;
        } else if (!str.equals(this.hMm)) {
            reset();
            this.hMm = str;
        } else {
            this.hMn = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hMn) {
            this.hMo = false;
            return null;
        } else if (this.hJH != null && this.hJH.bPK() != null && this.hJH.bPK().size() > 0) {
            this.hMo = true;
            com.baidu.tieba.pb.data.d dVar = this.hJH;
            this.hJH = null;
            return dVar;
        } else {
            this.hMo = false;
            this.hJH = null;
            return null;
        }
    }

    public Parcelable bTP() {
        if (this.hMo) {
            this.hMo = false;
            Parcelable parcelable = this.hMp;
            this.hMp = null;
            return parcelable;
        }
        this.hMp = null;
        return null;
    }

    public int bTQ() {
        return this.hMt;
    }

    public void xy(int i) {
        this.hMt = i;
    }

    public PostData bTR() {
        return this.hMs;
    }

    public void k(PostData postData) {
        this.hMs = postData;
    }

    public PostData bTS() {
        return this.hMr;
    }

    public void l(PostData postData) {
        this.hMr = postData;
    }

    public boolean bSG() {
        return this.hJs;
    }

    public boolean bTT() {
        return this.hJq;
    }

    public boolean bTU() {
        return this.hMq;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hMn = false;
        if (this.hMm == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bPK() == null) {
            reset();
            return false;
        } else if (dVar.bPK().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hJH = dVar;
            this.hMo = false;
            this.hMp = parcelable;
            this.hJs = z;
            this.hJq = z2;
            this.hMq = z3;
            return true;
        }
    }

    public void reset() {
        this.hMn = false;
        this.hJH = null;
        this.hMo = false;
        this.hMp = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hJH != null && this.hJH.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.hJH.getForum().getId(), 0L)) {
                this.hJH.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hJH != null && this.hJH.bPK() != null && this.hJH.bPK().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hJH.bPK().size();
                for (int i = 0; i < size; i++) {
                    if (this.hJH.bPK().get(i) != null && this.hJH.bPK().get(i).adv() != null && currentAccount.equals(this.hJH.bPK().get(i).adv().getUserId()) && this.hJH.bPK().get(i).adv().getPendantData() != null) {
                        this.hJH.bPK().get(i).adv().getPendantData().ml(lVar.abS());
                        this.hJH.bPK().get(i).adv().getPendantData().bg(lVar.aqx());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hJH != null && eVar != null) {
            ArrayList<PostData> bPK = this.hJH.bPK();
            if (!com.baidu.tbadk.core.util.v.aa(bPK)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bPK) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData afl = postData.afl();
                        afl.agreeType = agreeData.agreeType;
                        afl.hasAgree = agreeData.hasAgree;
                        afl.diffAgreeNum = agreeData.diffAgreeNum;
                        afl.agreeNum = agreeData.agreeNum;
                        afl.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hJH != null && this.hJH.bPI() != null && this.hJH.bPI().afl() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData afl = this.hJH.bPI().afl();
            if (!TextUtils.isEmpty(afl.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && afl.threadId.equals(agreeData.threadId)) {
                afl.agreeType = agreeData.agreeType;
                afl.hasAgree = agreeData.hasAgree;
                afl.diffAgreeNum = agreeData.diffAgreeNum;
                afl.agreeNum = agreeData.agreeNum;
                afl.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
