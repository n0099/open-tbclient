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
    private com.baidu.tieba.pb.data.e jqV;
    private boolean jvX;
    private boolean jvZ;
    private String jyQ;
    private boolean jyR;
    private Rect jyS;
    private boolean jyT;
    private Parcelable jyU;
    private boolean jyV;
    private PostData jyW;
    private PostData jyX;
    private int jyY;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czS().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.czS().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                    ah.czS().updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.czS().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.czS().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah jyZ = new ah();
    }

    public static ah czS() {
        return a.jyZ;
    }

    private ah() {
        this.jyQ = null;
        this.jyR = false;
        this.mTabIndex = 0;
        this.jqV = null;
        this.jyT = false;
        this.jyU = null;
        this.jvZ = true;
        this.jvX = false;
        this.jyV = false;
    }

    public void aA(String str, boolean z) {
        this.jyR = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.jyQ = null;
        } else if (!str.equals(this.jyQ)) {
            reset();
            this.jyQ = str;
        } else {
            this.jyR = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.jyR) {
            this.jyT = false;
            return null;
        } else if (this.jqV != null && this.jqV.cvw() != null && this.jqV.cvw().size() > 0) {
            this.jyT = true;
            com.baidu.tieba.pb.data.e eVar = this.jqV;
            this.jqV = null;
            return eVar;
        } else {
            this.jyT = false;
            this.jqV = null;
            return null;
        }
    }

    public Parcelable czT() {
        if (this.jyT) {
            this.jyT = false;
            Parcelable parcelable = this.jyU;
            this.jyU = null;
            return parcelable;
        }
        this.jyU = null;
        return null;
    }

    public int czU() {
        return this.jyY;
    }

    public void zJ(int i) {
        this.jyY = i;
    }

    public PostData czV() {
        return this.jyX;
    }

    public void m(PostData postData) {
        this.jyX = postData;
    }

    public PostData czW() {
        return this.jyW;
    }

    public void n(PostData postData) {
        this.jyW = postData;
    }

    public boolean cyB() {
        return this.jvZ;
    }

    public boolean czX() {
        return this.jvX;
    }

    public boolean czY() {
        return this.jyV;
    }

    public void h(Rect rect) {
        this.jyS = rect;
    }

    public Rect czZ() {
        return this.jyS;
    }

    public void zK(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.jyR = false;
        if (this.jyQ == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cvw() == null) {
            reset();
            return false;
        } else if (eVar.cvw().size() < 1) {
            reset();
            return false;
        } else {
            this.jqV = eVar;
            this.jyT = false;
            this.jyU = parcelable;
            this.jvZ = z;
            this.jvX = z2;
            this.jyV = z3;
            return true;
        }
    }

    public void reset() {
        this.jyR = false;
        this.jqV = null;
        this.jyT = false;
        this.jyU = null;
        this.jyS = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.jqV != null && this.jqV.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.jqV.getForum().getId(), 0L)) {
                this.jqV.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.jqV != null && this.jqV.cvw() != null && this.jqV.cvw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jqV.cvw().size();
                for (int i = 0; i < size; i++) {
                    if (this.jqV.cvw().get(i) != null && this.jqV.cvw().get(i).aKE() != null && currentAccount.equals(this.jqV.cvw().get(i).aKE().getUserId()) && this.jqV.cvw().get(i).aKE().getPendantData() != null) {
                        this.jqV.cvw().get(i).aKE().getPendantData().tO(kVar.aIW());
                        this.jqV.cvw().get(i).aKE().getPendantData().cp(kVar.aWu());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jqV != null && eVar != null) {
            ArrayList<PostData> cvw = this.jqV.cvw();
            if (!com.baidu.tbadk.core.util.v.isEmpty(cvw)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cvw) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aMs = postData.aMs();
                        aMs.agreeType = agreeData.agreeType;
                        aMs.hasAgree = agreeData.hasAgree;
                        aMs.diffAgreeNum = agreeData.diffAgreeNum;
                        aMs.agreeNum = agreeData.agreeNum;
                        aMs.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jqV != null && this.jqV.cvu() != null && this.jqV.cvu().aMs() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aMs = this.jqV.cvu().aMs();
            if (agreeData != null && aMs != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.jqV.cvu().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aMs.agreeType = agreeData.agreeType;
                        aMs.hasAgree = agreeData.hasAgree;
                        aMs.diffAgreeNum = agreeData.diffAgreeNum;
                        aMs.agreeNum = agreeData.agreeNum;
                        aMs.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aMs.threadId)) {
                    aMs.agreeType = agreeData.agreeType;
                    aMs.hasAgree = agreeData.hasAgree;
                    aMs.diffAgreeNum = agreeData.diffAgreeNum;
                    aMs.agreeNum = agreeData.agreeNum;
                    aMs.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
