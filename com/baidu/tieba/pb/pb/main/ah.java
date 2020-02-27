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
    private com.baidu.tieba.pb.data.e iEZ;
    private boolean iJZ;
    private boolean iKb;
    private String iMS;
    private boolean iMT;
    private Rect iMU;
    private boolean iMV;
    private Parcelable iMW;
    private boolean iMX;
    private PostData iMY;
    private PostData iMZ;
    private int iNa;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coO().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coO().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coO().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ah.coO().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coO().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coO().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah iNb = new ah();
    }

    public static ah coO() {
        return a.iNb;
    }

    private ah() {
        this.iMS = null;
        this.iMT = false;
        this.mTabIndex = 0;
        this.iEZ = null;
        this.iMV = false;
        this.iMW = null;
        this.iKb = true;
        this.iJZ = false;
        this.iMX = false;
    }

    public void au(String str, boolean z) {
        this.iMT = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iMS = null;
        } else if (!str.equals(this.iMS)) {
            reset();
            this.iMS = str;
        } else {
            this.iMT = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.iMT) {
            this.iMV = false;
            return null;
        } else if (this.iEZ != null && this.iEZ.cku() != null && this.iEZ.cku().size() > 0) {
            this.iMV = true;
            com.baidu.tieba.pb.data.e eVar = this.iEZ;
            this.iEZ = null;
            return eVar;
        } else {
            this.iMV = false;
            this.iEZ = null;
            return null;
        }
    }

    public Parcelable coP() {
        if (this.iMV) {
            this.iMV = false;
            Parcelable parcelable = this.iMW;
            this.iMW = null;
            return parcelable;
        }
        this.iMW = null;
        return null;
    }

    public int coQ() {
        return this.iNa;
    }

    public void za(int i) {
        this.iNa = i;
    }

    public PostData coR() {
        return this.iMZ;
    }

    public void m(PostData postData) {
        this.iMZ = postData;
    }

    public PostData coS() {
        return this.iMY;
    }

    public void n(PostData postData) {
        this.iMY = postData;
    }

    public boolean cnx() {
        return this.iKb;
    }

    public boolean coT() {
        return this.iJZ;
    }

    public boolean coU() {
        return this.iMX;
    }

    public void h(Rect rect) {
        this.iMU = rect;
    }

    public Rect coV() {
        return this.iMU;
    }

    public void zb(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iMT = false;
        if (this.iMS == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cku() == null) {
            reset();
            return false;
        } else if (eVar.cku().size() < 1) {
            reset();
            return false;
        } else {
            this.iEZ = eVar;
            this.iMV = false;
            this.iMW = parcelable;
            this.iKb = z;
            this.iJZ = z2;
            this.iMX = z3;
            return true;
        }
    }

    public void reset() {
        this.iMT = false;
        this.iEZ = null;
        this.iMV = false;
        this.iMW = null;
        this.iMU = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.iEZ != null && this.iEZ.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.iEZ.getForum().getId(), 0L)) {
                this.iEZ.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iEZ != null && this.iEZ.cku() != null && this.iEZ.cku().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iEZ.cku().size();
                for (int i = 0; i < size; i++) {
                    if (this.iEZ.cku().get(i) != null && this.iEZ.cku().get(i).aCm() != null && currentAccount.equals(this.iEZ.cku().get(i).aCm().getUserId()) && this.iEZ.cku().get(i).aCm().getPendantData() != null) {
                        this.iEZ.cku().get(i).aCm().getPendantData().sB(mVar.aAE());
                        this.iEZ.cku().get(i).aCm().getPendantData().bI(mVar.aNW());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iEZ != null && eVar != null) {
            ArrayList<PostData> cku = this.iEZ.cku();
            if (!com.baidu.tbadk.core.util.v.isEmpty(cku)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cku) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aDY = postData.aDY();
                        aDY.agreeType = agreeData.agreeType;
                        aDY.hasAgree = agreeData.hasAgree;
                        aDY.diffAgreeNum = agreeData.diffAgreeNum;
                        aDY.agreeNum = agreeData.agreeNum;
                        aDY.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.cks().aDY() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aDY = this.iEZ.cks().aDY();
            if (agreeData != null && aDY != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.iEZ.cks().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aDY.agreeType = agreeData.agreeType;
                        aDY.hasAgree = agreeData.hasAgree;
                        aDY.diffAgreeNum = agreeData.diffAgreeNum;
                        aDY.agreeNum = agreeData.agreeNum;
                        aDY.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aDY.threadId)) {
                    aDY.agreeType = agreeData.agreeType;
                    aDY.hasAgree = agreeData.hasAgree;
                    aDY.diffAgreeNum = agreeData.diffAgreeNum;
                    aDY.agreeNum = agreeData.agreeNum;
                    aDY.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
