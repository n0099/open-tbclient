package com.baidu.tieba.pb.pb.main;

import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ah {
    private com.baidu.tieba.pb.data.e iFb;
    private boolean iKb;
    private boolean iKd;
    private String iMU;
    private boolean iMV;
    private Rect iMW;
    private boolean iMX;
    private Parcelable iMY;
    private boolean iMZ;
    private PostData iNa;
    private PostData iNb;
    private int iNc;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coQ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coQ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coQ().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coQ().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ah.coQ().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coQ().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coQ().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah iNd = new ah();
    }

    public static ah coQ() {
        return a.iNd;
    }

    private ah() {
        this.iMU = null;
        this.iMV = false;
        this.mTabIndex = 0;
        this.iFb = null;
        this.iMX = false;
        this.iMY = null;
        this.iKd = true;
        this.iKb = false;
        this.iMZ = false;
    }

    public void au(String str, boolean z) {
        this.iMV = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iMU = null;
        } else if (!str.equals(this.iMU)) {
            reset();
            this.iMU = str;
        } else {
            this.iMV = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.iMV) {
            this.iMX = false;
            return null;
        } else if (this.iFb != null && this.iFb.ckw() != null && this.iFb.ckw().size() > 0) {
            this.iMX = true;
            com.baidu.tieba.pb.data.e eVar = this.iFb;
            this.iFb = null;
            return eVar;
        } else {
            this.iMX = false;
            this.iFb = null;
            return null;
        }
    }

    public Parcelable coR() {
        if (this.iMX) {
            this.iMX = false;
            Parcelable parcelable = this.iMY;
            this.iMY = null;
            return parcelable;
        }
        this.iMY = null;
        return null;
    }

    public int coS() {
        return this.iNc;
    }

    public void za(int i) {
        this.iNc = i;
    }

    public PostData coT() {
        return this.iNb;
    }

    public void m(PostData postData) {
        this.iNb = postData;
    }

    public PostData coU() {
        return this.iNa;
    }

    public void n(PostData postData) {
        this.iNa = postData;
    }

    public boolean cnz() {
        return this.iKd;
    }

    public boolean coV() {
        return this.iKb;
    }

    public boolean coW() {
        return this.iMZ;
    }

    public void h(Rect rect) {
        this.iMW = rect;
    }

    public Rect coX() {
        return this.iMW;
    }

    public void zb(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iMV = false;
        if (this.iMU == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.ckw() == null) {
            reset();
            return false;
        } else if (eVar.ckw().size() < 1) {
            reset();
            return false;
        } else {
            this.iFb = eVar;
            this.iMX = false;
            this.iMY = parcelable;
            this.iKd = z;
            this.iKb = z2;
            this.iMZ = z3;
            return true;
        }
    }

    public void reset() {
        this.iMV = false;
        this.iFb = null;
        this.iMX = false;
        this.iMY = null;
        this.iMW = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.iFb != null && this.iFb.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.iFb.getForum().getId(), 0L)) {
                this.iFb.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iFb != null && this.iFb.ckw() != null && this.iFb.ckw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iFb.ckw().size();
                for (int i = 0; i < size; i++) {
                    if (this.iFb.ckw().get(i) != null && this.iFb.ckw().get(i).aCo() != null && currentAccount.equals(this.iFb.ckw().get(i).aCo().getUserId()) && this.iFb.ckw().get(i).aCo().getPendantData() != null) {
                        this.iFb.ckw().get(i).aCo().getPendantData().sB(mVar.aAG());
                        this.iFb.ckw().get(i).aCo().getPendantData().bI(mVar.aNY());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iFb != null && eVar != null) {
            ArrayList<PostData> ckw = this.iFb.ckw();
            if (!com.baidu.tbadk.core.util.v.isEmpty(ckw)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : ckw) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aEa = postData.aEa();
                        aEa.agreeType = agreeData.agreeType;
                        aEa.hasAgree = agreeData.hasAgree;
                        aEa.diffAgreeNum = agreeData.diffAgreeNum;
                        aEa.agreeNum = agreeData.agreeNum;
                        aEa.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iFb != null && this.iFb.cku() != null && this.iFb.cku().aEa() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aEa = this.iFb.cku().aEa();
            if (agreeData != null && aEa != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.iFb.cku().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aEa.agreeType = agreeData.agreeType;
                        aEa.hasAgree = agreeData.hasAgree;
                        aEa.diffAgreeNum = agreeData.diffAgreeNum;
                        aEa.agreeNum = agreeData.agreeNum;
                        aEa.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aEa.threadId)) {
                    aEa.agreeType = agreeData.agreeType;
                    aEa.hasAgree = agreeData.hasAgree;
                    aEa.diffAgreeNum = agreeData.diffAgreeNum;
                    aEa.agreeNum = agreeData.agreeNum;
                    aEa.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
