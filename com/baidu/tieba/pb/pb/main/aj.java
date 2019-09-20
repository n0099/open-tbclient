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
    private boolean hSB;
    private com.baidu.tieba.pb.data.d hSQ;
    private boolean hSz;
    private PostData hVA;
    private PostData hVB;
    private int hVC;
    private String hVv;
    private boolean hVw;
    private boolean hVx;
    private Parcelable hVy;
    private boolean hVz;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bXI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bXI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bXI().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bXI().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bXI().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bXI().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bXI().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hVD = new aj();
    }

    public static aj bXI() {
        return a.hVD;
    }

    private aj() {
        this.hVv = null;
        this.hVw = false;
        this.hSQ = null;
        this.hVx = false;
        this.hVy = null;
        this.hSB = true;
        this.hSz = false;
        this.hVz = false;
    }

    public void au(String str, boolean z) {
        this.hVw = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hVv = null;
        } else if (!str.equals(this.hVv)) {
            reset();
            this.hVv = str;
        } else {
            this.hVw = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hVw) {
            this.hVx = false;
            return null;
        } else if (this.hSQ != null && this.hSQ.bTA() != null && this.hSQ.bTA().size() > 0) {
            this.hVx = true;
            com.baidu.tieba.pb.data.d dVar = this.hSQ;
            this.hSQ = null;
            return dVar;
        } else {
            this.hVx = false;
            this.hSQ = null;
            return null;
        }
    }

    public Parcelable bXJ() {
        if (this.hVx) {
            this.hVx = false;
            Parcelable parcelable = this.hVy;
            this.hVy = null;
            return parcelable;
        }
        this.hVy = null;
        return null;
    }

    public int bXK() {
        return this.hVC;
    }

    public void yh(int i) {
        this.hVC = i;
    }

    public PostData bXL() {
        return this.hVB;
    }

    public void k(PostData postData) {
        this.hVB = postData;
    }

    public PostData bXM() {
        return this.hVA;
    }

    public void l(PostData postData) {
        this.hVA = postData;
    }

    public boolean bWz() {
        return this.hSB;
    }

    public boolean bXN() {
        return this.hSz;
    }

    public boolean bXO() {
        return this.hVz;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hVw = false;
        if (this.hVv == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bTA() == null) {
            reset();
            return false;
        } else if (dVar.bTA().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hSQ = dVar;
            this.hVx = false;
            this.hVy = parcelable;
            this.hSB = z;
            this.hSz = z2;
            this.hVz = z3;
            return true;
        }
    }

    public void reset() {
        this.hVw = false;
        this.hSQ = null;
        this.hVx = false;
        this.hVy = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hSQ != null && this.hSQ.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.e(this.hSQ.getForum().getId(), 0L)) {
                this.hSQ.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hSQ != null && this.hSQ.bTA() != null && this.hSQ.bTA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hSQ.bTA().size();
                for (int i = 0; i < size; i++) {
                    if (this.hSQ.bTA().get(i) != null && this.hSQ.bTA().get(i).aeC() != null && currentAccount.equals(this.hSQ.bTA().get(i).aeC().getUserId()) && this.hSQ.bTA().get(i).aeC().getPendantData() != null) {
                        this.hSQ.bTA().get(i).aeC().getPendantData().mx(lVar.acZ());
                        this.hSQ.bTA().get(i).aeC().getPendantData().bk(lVar.arQ());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hSQ != null && eVar != null) {
            ArrayList<PostData> bTA = this.hSQ.bTA();
            if (!com.baidu.tbadk.core.util.v.aa(bTA)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bTA) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData ags = postData.ags();
                        ags.agreeType = agreeData.agreeType;
                        ags.hasAgree = agreeData.hasAgree;
                        ags.diffAgreeNum = agreeData.diffAgreeNum;
                        ags.agreeNum = agreeData.agreeNum;
                        ags.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hSQ != null && this.hSQ.bTy() != null && this.hSQ.bTy().ags() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData ags = this.hSQ.bTy().ags();
            if (!TextUtils.isEmpty(ags.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && ags.threadId.equals(agreeData.threadId)) {
                ags.agreeType = agreeData.agreeType;
                ags.hasAgree = agreeData.hasAgree;
                ags.diffAgreeNum = agreeData.diffAgreeNum;
                ags.agreeNum = agreeData.agreeNum;
                ags.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
