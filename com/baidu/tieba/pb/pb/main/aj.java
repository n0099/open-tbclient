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
    private com.baidu.tieba.pb.data.d hJL;
    private boolean hJu;
    private boolean hJw;
    private String hMq;
    private boolean hMr;
    private boolean hMs;
    private Parcelable hMt;
    private boolean hMu;
    private PostData hMv;
    private PostData hMw;
    private int hMx;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTS().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTS().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bTS().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTS().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTS().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hMy = new aj();
    }

    public static aj bTS() {
        return a.hMy;
    }

    private aj() {
        this.hMq = null;
        this.hMr = false;
        this.hJL = null;
        this.hMs = false;
        this.hMt = null;
        this.hJw = true;
        this.hJu = false;
        this.hMu = false;
    }

    public void aq(String str, boolean z) {
        this.hMr = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hMq = null;
        } else if (!str.equals(this.hMq)) {
            reset();
            this.hMq = str;
        } else {
            this.hMr = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hMr) {
            this.hMs = false;
            return null;
        } else if (this.hJL != null && this.hJL.bPO() != null && this.hJL.bPO().size() > 0) {
            this.hMs = true;
            com.baidu.tieba.pb.data.d dVar = this.hJL;
            this.hJL = null;
            return dVar;
        } else {
            this.hMs = false;
            this.hJL = null;
            return null;
        }
    }

    public Parcelable bTT() {
        if (this.hMs) {
            this.hMs = false;
            Parcelable parcelable = this.hMt;
            this.hMt = null;
            return parcelable;
        }
        this.hMt = null;
        return null;
    }

    public int bTU() {
        return this.hMx;
    }

    public void xy(int i) {
        this.hMx = i;
    }

    public PostData bTV() {
        return this.hMw;
    }

    public void k(PostData postData) {
        this.hMw = postData;
    }

    public PostData bTW() {
        return this.hMv;
    }

    public void l(PostData postData) {
        this.hMv = postData;
    }

    public boolean bSK() {
        return this.hJw;
    }

    public boolean bTX() {
        return this.hJu;
    }

    public boolean bTY() {
        return this.hMu;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hMr = false;
        if (this.hMq == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bPO() == null) {
            reset();
            return false;
        } else if (dVar.bPO().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hJL = dVar;
            this.hMs = false;
            this.hMt = parcelable;
            this.hJw = z;
            this.hJu = z2;
            this.hMu = z3;
            return true;
        }
    }

    public void reset() {
        this.hMr = false;
        this.hJL = null;
        this.hMs = false;
        this.hMt = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hJL != null && this.hJL.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.hJL.getForum().getId(), 0L)) {
                this.hJL.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hJL != null && this.hJL.bPO() != null && this.hJL.bPO().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hJL.bPO().size();
                for (int i = 0; i < size; i++) {
                    if (this.hJL.bPO().get(i) != null && this.hJL.bPO().get(i).adv() != null && currentAccount.equals(this.hJL.bPO().get(i).adv().getUserId()) && this.hJL.bPO().get(i).adv().getPendantData() != null) {
                        this.hJL.bPO().get(i).adv().getPendantData().mk(lVar.abS());
                        this.hJL.bPO().get(i).adv().getPendantData().bg(lVar.aqx());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hJL != null && eVar != null) {
            ArrayList<PostData> bPO = this.hJL.bPO();
            if (!com.baidu.tbadk.core.util.v.aa(bPO)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bPO) {
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
        if (this.hJL != null && this.hJL.bPM() != null && this.hJL.bPM().afl() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData afl = this.hJL.bPM().afl();
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
