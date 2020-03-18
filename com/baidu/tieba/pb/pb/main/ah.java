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
    private com.baidu.tieba.pb.data.e iGO;
    private boolean iLO;
    private boolean iLQ;
    private String iOH;
    private boolean iOI;
    private Rect iOJ;
    private boolean iOK;
    private Parcelable iOL;
    private boolean iOM;
    private PostData iON;
    private PostData iOO;
    private int iOP;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.cpm().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.cpm().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.cpm().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.cpm().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ah.cpm().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.cpm().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.cpm().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah iOQ = new ah();
    }

    public static ah cpm() {
        return a.iOQ;
    }

    private ah() {
        this.iOH = null;
        this.iOI = false;
        this.mTabIndex = 0;
        this.iGO = null;
        this.iOK = false;
        this.iOL = null;
        this.iLQ = true;
        this.iLO = false;
        this.iOM = false;
    }

    public void au(String str, boolean z) {
        this.iOI = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iOH = null;
        } else if (!str.equals(this.iOH)) {
            reset();
            this.iOH = str;
        } else {
            this.iOI = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.iOI) {
            this.iOK = false;
            return null;
        } else if (this.iGO != null && this.iGO.ckR() != null && this.iGO.ckR().size() > 0) {
            this.iOK = true;
            com.baidu.tieba.pb.data.e eVar = this.iGO;
            this.iGO = null;
            return eVar;
        } else {
            this.iOK = false;
            this.iGO = null;
            return null;
        }
    }

    public Parcelable cpn() {
        if (this.iOK) {
            this.iOK = false;
            Parcelable parcelable = this.iOL;
            this.iOL = null;
            return parcelable;
        }
        this.iOL = null;
        return null;
    }

    public int cpo() {
        return this.iOP;
    }

    public void zi(int i) {
        this.iOP = i;
    }

    public PostData cpp() {
        return this.iOO;
    }

    public void m(PostData postData) {
        this.iOO = postData;
    }

    public PostData cpq() {
        return this.iON;
    }

    public void n(PostData postData) {
        this.iON = postData;
    }

    public boolean cnV() {
        return this.iLQ;
    }

    public boolean cpr() {
        return this.iLO;
    }

    public boolean cps() {
        return this.iOM;
    }

    public void h(Rect rect) {
        this.iOJ = rect;
    }

    public Rect cpt() {
        return this.iOJ;
    }

    public void zj(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iOI = false;
        if (this.iOH == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.ckR() == null) {
            reset();
            return false;
        } else if (eVar.ckR().size() < 1) {
            reset();
            return false;
        } else {
            this.iGO = eVar;
            this.iOK = false;
            this.iOL = parcelable;
            this.iLQ = z;
            this.iLO = z2;
            this.iOM = z3;
            return true;
        }
    }

    public void reset() {
        this.iOI = false;
        this.iGO = null;
        this.iOK = false;
        this.iOL = null;
        this.iOJ = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.iGO != null && this.iGO.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.iGO.getForum().getId(), 0L)) {
                this.iGO.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iGO != null && this.iGO.ckR() != null && this.iGO.ckR().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iGO.ckR().size();
                for (int i = 0; i < size; i++) {
                    if (this.iGO.ckR().get(i) != null && this.iGO.ckR().get(i).aCr() != null && currentAccount.equals(this.iGO.ckR().get(i).aCr().getUserId()) && this.iGO.ckR().get(i).aCr().getPendantData() != null) {
                        this.iGO.ckR().get(i).aCr().getPendantData().sA(mVar.aAJ());
                        this.iGO.ckR().get(i).aCr().getPendantData().bI(mVar.aOd());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iGO != null && eVar != null) {
            ArrayList<PostData> ckR = this.iGO.ckR();
            if (!com.baidu.tbadk.core.util.v.isEmpty(ckR)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : ckR) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aEe = postData.aEe();
                        aEe.agreeType = agreeData.agreeType;
                        aEe.hasAgree = agreeData.hasAgree;
                        aEe.diffAgreeNum = agreeData.diffAgreeNum;
                        aEe.agreeNum = agreeData.agreeNum;
                        aEe.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iGO != null && this.iGO.ckP() != null && this.iGO.ckP().aEe() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aEe = this.iGO.ckP().aEe();
            if (agreeData != null && aEe != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.iGO.ckP().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aEe.agreeType = agreeData.agreeType;
                        aEe.hasAgree = agreeData.hasAgree;
                        aEe.diffAgreeNum = agreeData.diffAgreeNum;
                        aEe.agreeNum = agreeData.agreeNum;
                        aEe.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aEe.threadId)) {
                    aEe.agreeType = agreeData.agreeType;
                    aEe.hasAgree = agreeData.hasAgree;
                    aEe.diffAgreeNum = agreeData.diffAgreeNum;
                    aEe.agreeNum = agreeData.agreeNum;
                    aEe.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
