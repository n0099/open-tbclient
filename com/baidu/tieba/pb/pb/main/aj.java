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
    private boolean hQC;
    private boolean hQE;
    private com.baidu.tieba.pb.data.d hQT;
    private boolean hTA;
    private Parcelable hTB;
    private boolean hTC;
    private PostData hTD;
    private PostData hTE;
    private int hTF;
    private String hTy;
    private boolean hTz;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWV().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWV().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWV().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWV().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bWV().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bWV().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bWV().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hTG = new aj();
    }

    public static aj bWV() {
        return a.hTG;
    }

    private aj() {
        this.hTy = null;
        this.hTz = false;
        this.hQT = null;
        this.hTA = false;
        this.hTB = null;
        this.hQE = true;
        this.hQC = false;
        this.hTC = false;
    }

    public void au(String str, boolean z) {
        this.hTz = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hTy = null;
        } else if (!str.equals(this.hTy)) {
            reset();
            this.hTy = str;
        } else {
            this.hTz = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hTz) {
            this.hTA = false;
            return null;
        } else if (this.hQT != null && this.hQT.bSN() != null && this.hQT.bSN().size() > 0) {
            this.hTA = true;
            com.baidu.tieba.pb.data.d dVar = this.hQT;
            this.hQT = null;
            return dVar;
        } else {
            this.hTA = false;
            this.hQT = null;
            return null;
        }
    }

    public Parcelable bWW() {
        if (this.hTA) {
            this.hTA = false;
            Parcelable parcelable = this.hTB;
            this.hTB = null;
            return parcelable;
        }
        this.hTB = null;
        return null;
    }

    public int bWX() {
        return this.hTF;
    }

    public void ye(int i) {
        this.hTF = i;
    }

    public PostData bWY() {
        return this.hTE;
    }

    public void k(PostData postData) {
        this.hTE = postData;
    }

    public PostData bWZ() {
        return this.hTD;
    }

    public void l(PostData postData) {
        this.hTD = postData;
    }

    public boolean bVM() {
        return this.hQE;
    }

    public boolean bXa() {
        return this.hQC;
    }

    public boolean bXb() {
        return this.hTC;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hTz = false;
        if (this.hTy == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bSN() == null) {
            reset();
            return false;
        } else if (dVar.bSN().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hQT = dVar;
            this.hTA = false;
            this.hTB = parcelable;
            this.hQE = z;
            this.hQC = z2;
            this.hTC = z3;
            return true;
        }
    }

    public void reset() {
        this.hTz = false;
        this.hQT = null;
        this.hTA = false;
        this.hTB = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hQT != null && this.hQT.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.hQT.getForum().getId(), 0L)) {
                this.hQT.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hQT != null && this.hQT.bSN() != null && this.hQT.bSN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hQT.bSN().size();
                for (int i = 0; i < size; i++) {
                    if (this.hQT.bSN().get(i) != null && this.hQT.bSN().get(i).aey() != null && currentAccount.equals(this.hQT.bSN().get(i).aey().getUserId()) && this.hQT.bSN().get(i).aey().getPendantData() != null) {
                        this.hQT.bSN().get(i).aey().getPendantData().mv(lVar.acV());
                        this.hQT.bSN().get(i).aey().getPendantData().bh(lVar.arE());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hQT != null && eVar != null) {
            ArrayList<PostData> bSN = this.hQT.bSN();
            if (!com.baidu.tbadk.core.util.v.aa(bSN)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bSN) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData ago = postData.ago();
                        ago.agreeType = agreeData.agreeType;
                        ago.hasAgree = agreeData.hasAgree;
                        ago.diffAgreeNum = agreeData.diffAgreeNum;
                        ago.agreeNum = agreeData.agreeNum;
                        ago.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hQT != null && this.hQT.bSL() != null && this.hQT.bSL().ago() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData ago = this.hQT.bSL().ago();
            if (!TextUtils.isEmpty(ago.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && ago.threadId.equals(agreeData.threadId)) {
                ago.agreeType = agreeData.agreeType;
                ago.hasAgree = agreeData.hasAgree;
                ago.diffAgreeNum = agreeData.diffAgreeNum;
                ago.agreeNum = agreeData.agreeNum;
                ago.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
