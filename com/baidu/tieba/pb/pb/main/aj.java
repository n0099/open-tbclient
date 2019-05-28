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
    private com.baidu.tieba.pb.data.d hJK;
    private boolean hJt;
    private boolean hJv;
    private String hMp;
    private boolean hMq;
    private boolean hMr;
    private Parcelable hMs;
    private boolean hMt;
    private PostData hMu;
    private PostData hMv;
    private int hMw;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTR().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTR().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTR().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bTR().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bTR().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTR().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bTR().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hMx = new aj();
    }

    public static aj bTR() {
        return a.hMx;
    }

    private aj() {
        this.hMp = null;
        this.hMq = false;
        this.hJK = null;
        this.hMr = false;
        this.hMs = null;
        this.hJv = true;
        this.hJt = false;
        this.hMt = false;
    }

    public void aq(String str, boolean z) {
        this.hMq = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hMp = null;
        } else if (!str.equals(this.hMp)) {
            reset();
            this.hMp = str;
        } else {
            this.hMq = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hMq) {
            this.hMr = false;
            return null;
        } else if (this.hJK != null && this.hJK.bPN() != null && this.hJK.bPN().size() > 0) {
            this.hMr = true;
            com.baidu.tieba.pb.data.d dVar = this.hJK;
            this.hJK = null;
            return dVar;
        } else {
            this.hMr = false;
            this.hJK = null;
            return null;
        }
    }

    public Parcelable bTS() {
        if (this.hMr) {
            this.hMr = false;
            Parcelable parcelable = this.hMs;
            this.hMs = null;
            return parcelable;
        }
        this.hMs = null;
        return null;
    }

    public int bTT() {
        return this.hMw;
    }

    public void xy(int i) {
        this.hMw = i;
    }

    public PostData bTU() {
        return this.hMv;
    }

    public void k(PostData postData) {
        this.hMv = postData;
    }

    public PostData bTV() {
        return this.hMu;
    }

    public void l(PostData postData) {
        this.hMu = postData;
    }

    public boolean bSJ() {
        return this.hJv;
    }

    public boolean bTW() {
        return this.hJt;
    }

    public boolean bTX() {
        return this.hMt;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hMq = false;
        if (this.hMp == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bPN() == null) {
            reset();
            return false;
        } else if (dVar.bPN().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hJK = dVar;
            this.hMr = false;
            this.hMs = parcelable;
            this.hJv = z;
            this.hJt = z2;
            this.hMt = z3;
            return true;
        }
    }

    public void reset() {
        this.hMq = false;
        this.hJK = null;
        this.hMr = false;
        this.hMs = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hJK != null && this.hJK.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.hJK.getForum().getId(), 0L)) {
                this.hJK.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hJK != null && this.hJK.bPN() != null && this.hJK.bPN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hJK.bPN().size();
                for (int i = 0; i < size; i++) {
                    if (this.hJK.bPN().get(i) != null && this.hJK.bPN().get(i).adv() != null && currentAccount.equals(this.hJK.bPN().get(i).adv().getUserId()) && this.hJK.bPN().get(i).adv().getPendantData() != null) {
                        this.hJK.bPN().get(i).adv().getPendantData().ml(lVar.abS());
                        this.hJK.bPN().get(i).adv().getPendantData().bg(lVar.aqx());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hJK != null && eVar != null) {
            ArrayList<PostData> bPN = this.hJK.bPN();
            if (!com.baidu.tbadk.core.util.v.aa(bPN)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bPN) {
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
        if (this.hJK != null && this.hJK.bPL() != null && this.hJK.bPL().afl() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData afl = this.hJK.bPL().afl();
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
