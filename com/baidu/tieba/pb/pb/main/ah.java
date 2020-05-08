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
    private com.baidu.tieba.pb.data.e jqZ;
    private boolean jwb;
    private boolean jwd;
    private String jyU;
    private boolean jyV;
    private Rect jyW;
    private boolean jyX;
    private Parcelable jyY;
    private boolean jyZ;
    private PostData jza;
    private PostData jzb;
    private int jzc;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czP().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czP().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czP().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czP().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ah.czP().updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.czP().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.czP().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah jzd = new ah();
    }

    public static ah czP() {
        return a.jzd;
    }

    private ah() {
        this.jyU = null;
        this.jyV = false;
        this.mTabIndex = 0;
        this.jqZ = null;
        this.jyX = false;
        this.jyY = null;
        this.jwd = true;
        this.jwb = false;
        this.jyZ = false;
    }

    public void aA(String str, boolean z) {
        this.jyV = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.jyU = null;
        } else if (!str.equals(this.jyU)) {
            reset();
            this.jyU = str;
        } else {
            this.jyV = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.jyV) {
            this.jyX = false;
            return null;
        } else if (this.jqZ != null && this.jqZ.cvt() != null && this.jqZ.cvt().size() > 0) {
            this.jyX = true;
            com.baidu.tieba.pb.data.e eVar = this.jqZ;
            this.jqZ = null;
            return eVar;
        } else {
            this.jyX = false;
            this.jqZ = null;
            return null;
        }
    }

    public Parcelable czQ() {
        if (this.jyX) {
            this.jyX = false;
            Parcelable parcelable = this.jyY;
            this.jyY = null;
            return parcelable;
        }
        this.jyY = null;
        return null;
    }

    public int czR() {
        return this.jzc;
    }

    public void zJ(int i) {
        this.jzc = i;
    }

    public PostData czS() {
        return this.jzb;
    }

    public void m(PostData postData) {
        this.jzb = postData;
    }

    public PostData czT() {
        return this.jza;
    }

    public void n(PostData postData) {
        this.jza = postData;
    }

    public boolean cyy() {
        return this.jwd;
    }

    public boolean czU() {
        return this.jwb;
    }

    public boolean czV() {
        return this.jyZ;
    }

    public void h(Rect rect) {
        this.jyW = rect;
    }

    public Rect czW() {
        return this.jyW;
    }

    public void zK(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.jyV = false;
        if (this.jyU == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cvt() == null) {
            reset();
            return false;
        } else if (eVar.cvt().size() < 1) {
            reset();
            return false;
        } else {
            this.jqZ = eVar;
            this.jyX = false;
            this.jyY = parcelable;
            this.jwd = z;
            this.jwb = z2;
            this.jyZ = z3;
            return true;
        }
    }

    public void reset() {
        this.jyV = false;
        this.jqZ = null;
        this.jyX = false;
        this.jyY = null;
        this.jyW = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.jqZ != null && this.jqZ.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.jqZ.getForum().getId(), 0L)) {
                this.jqZ.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.jqZ != null && this.jqZ.cvt() != null && this.jqZ.cvt().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jqZ.cvt().size();
                for (int i = 0; i < size; i++) {
                    if (this.jqZ.cvt().get(i) != null && this.jqZ.cvt().get(i).aKC() != null && currentAccount.equals(this.jqZ.cvt().get(i).aKC().getUserId()) && this.jqZ.cvt().get(i).aKC().getPendantData() != null) {
                        this.jqZ.cvt().get(i).aKC().getPendantData().tR(kVar.aIU());
                        this.jqZ.cvt().get(i).aKC().getPendantData().cp(kVar.aWs());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jqZ != null && eVar != null) {
            ArrayList<PostData> cvt = this.jqZ.cvt();
            if (!com.baidu.tbadk.core.util.v.isEmpty(cvt)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cvt) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aMq = postData.aMq();
                        aMq.agreeType = agreeData.agreeType;
                        aMq.hasAgree = agreeData.hasAgree;
                        aMq.diffAgreeNum = agreeData.diffAgreeNum;
                        aMq.agreeNum = agreeData.agreeNum;
                        aMq.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jqZ != null && this.jqZ.cvr() != null && this.jqZ.cvr().aMq() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aMq = this.jqZ.cvr().aMq();
            if (agreeData != null && aMq != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.jqZ.cvr().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aMq.agreeType = agreeData.agreeType;
                        aMq.hasAgree = agreeData.hasAgree;
                        aMq.diffAgreeNum = agreeData.diffAgreeNum;
                        aMq.agreeNum = agreeData.agreeNum;
                        aMq.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aMq.threadId)) {
                    aMq.agreeType = agreeData.agreeType;
                    aMq.hasAgree = agreeData.hasAgree;
                    aMq.diffAgreeNum = agreeData.diffAgreeNum;
                    aMq.agreeNum = agreeData.agreeNum;
                    aMq.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
