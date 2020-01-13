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
/* loaded from: classes7.dex */
public class ak {
    private com.baidu.tieba.pb.data.f iDs;
    private boolean iIC;
    private boolean iIE;
    private boolean iLA;
    private Parcelable iLB;
    private boolean iLC;
    private PostData iLD;
    private PostData iLE;
    private int iLF;
    private String iLx;
    private boolean iLy;
    private Rect iLz;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ak.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cnx().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ak.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cnx().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ak.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cnx().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ak.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cnx().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ak.cnx().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ak.cnx().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ak.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ak.cnx().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static ak iLG = new ak();
    }

    public static ak cnx() {
        return a.iLG;
    }

    private ak() {
        this.iLx = null;
        this.iLy = false;
        this.mTabIndex = 0;
        this.iDs = null;
        this.iLA = false;
        this.iLB = null;
        this.iIE = true;
        this.iIC = false;
        this.iLC = false;
    }

    public void au(String str, boolean z) {
        this.iLy = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iLx = null;
        } else if (!str.equals(this.iLx)) {
            reset();
            this.iLx = str;
        } else {
            this.iLy = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.iLy) {
            this.iLA = false;
            return null;
        } else if (this.iDs != null && this.iDs.ciU() != null && this.iDs.ciU().size() > 0) {
            this.iLA = true;
            com.baidu.tieba.pb.data.f fVar = this.iDs;
            this.iDs = null;
            return fVar;
        } else {
            this.iLA = false;
            this.iDs = null;
            return null;
        }
    }

    public Parcelable cny() {
        if (this.iLA) {
            this.iLA = false;
            Parcelable parcelable = this.iLB;
            this.iLB = null;
            return parcelable;
        }
        this.iLB = null;
        return null;
    }

    public int cnz() {
        return this.iLF;
    }

    public void yU(int i) {
        this.iLF = i;
    }

    public PostData cnA() {
        return this.iLE;
    }

    public void m(PostData postData) {
        this.iLE = postData;
    }

    public PostData cnB() {
        return this.iLD;
    }

    public void n(PostData postData) {
        this.iLD = postData;
    }

    public boolean cmd() {
        return this.iIE;
    }

    public boolean cnC() {
        return this.iIC;
    }

    public boolean cnD() {
        return this.iLC;
    }

    public void h(Rect rect) {
        this.iLz = rect;
    }

    public Rect cnE() {
        return this.iLz;
    }

    public void yV(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iLy = false;
        if (this.iLx == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.ciU() == null) {
            reset();
            return false;
        } else if (fVar.ciU().size() < 1) {
            reset();
            return false;
        } else {
            this.iDs = fVar;
            this.iLA = false;
            this.iLB = parcelable;
            this.iIE = z;
            this.iIC = z2;
            this.iLC = z3;
            return true;
        }
    }

    public void reset() {
        this.iLy = false;
        this.iDs = null;
        this.iLA = false;
        this.iLB = null;
        this.iLz = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.iDs != null && this.iDs.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.iDs.getForum().getId(), 0L)) {
                this.iDs.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iDs != null && this.iDs.ciU() != null && this.iDs.ciU().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iDs.ciU().size();
                for (int i = 0; i < size; i++) {
                    if (this.iDs.ciU().get(i) != null && this.iDs.ciU().get(i).azX() != null && currentAccount.equals(this.iDs.ciU().get(i).azX().getUserId()) && this.iDs.ciU().get(i).azX().getPendantData() != null) {
                        this.iDs.ciU().get(i).azX().getPendantData().sk(mVar.ayq());
                        this.iDs.ciU().get(i).azX().getPendantData().bE(mVar.aLA());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iDs != null && eVar != null) {
            ArrayList<PostData> ciU = this.iDs.ciU();
            if (!com.baidu.tbadk.core.util.v.isEmpty(ciU)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : ciU) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aBM = postData.aBM();
                        aBM.agreeType = agreeData.agreeType;
                        aBM.hasAgree = agreeData.hasAgree;
                        aBM.diffAgreeNum = agreeData.diffAgreeNum;
                        aBM.agreeNum = agreeData.agreeNum;
                        aBM.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iDs != null && this.iDs.ciS() != null && this.iDs.ciS().aBM() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aBM = this.iDs.ciS().aBM();
            if (agreeData != null && aBM != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.iDs.ciS().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aBM.agreeType = agreeData.agreeType;
                        aBM.hasAgree = agreeData.hasAgree;
                        aBM.diffAgreeNum = agreeData.diffAgreeNum;
                        aBM.agreeNum = agreeData.agreeNum;
                        aBM.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aBM.threadId)) {
                    aBM.agreeType = agreeData.agreeType;
                    aBM.hasAgree = agreeData.hasAgree;
                    aBM.diffAgreeNum = agreeData.diffAgreeNum;
                    aBM.agreeNum = agreeData.agreeNum;
                    aBM.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
