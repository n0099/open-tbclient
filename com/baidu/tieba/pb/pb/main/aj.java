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
/* loaded from: classes2.dex */
public class aj {
    private com.baidu.tieba.pb.data.f lOq;
    private boolean lUS;
    private boolean lUU;
    private String lXQ;
    private boolean lXR;
    private Rect lXS;
    private boolean lXT;
    private Parcelable lXU;
    private boolean lXV;
    private PostData lXW;
    private PostData lXX;
    private int lXY;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpS().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpS().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.dpS().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dpS().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dpS().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj lXZ = new aj();
    }

    public static aj dpS() {
        return a.lXZ;
    }

    private aj() {
        this.lXQ = null;
        this.lXR = false;
        this.mTabIndex = 0;
        this.lOq = null;
        this.lXT = false;
        this.lXU = null;
        this.lUU = true;
        this.lUS = false;
        this.lXV = false;
    }

    public void aX(String str, boolean z) {
        this.lXR = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lXQ = null;
        } else if (!str.equals(this.lXQ)) {
            reset();
            this.lXQ = str;
        } else {
            this.lXR = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lXR) {
            this.lXT = false;
            return null;
        } else if (this.lOq != null && this.lOq.dlb() != null && this.lOq.dlb().size() > 0) {
            this.lXT = true;
            com.baidu.tieba.pb.data.f fVar = this.lOq;
            this.lOq = null;
            return fVar;
        } else {
            this.lXT = false;
            this.lOq = null;
            return null;
        }
    }

    public Parcelable dpT() {
        if (this.lXT) {
            this.lXT = false;
            Parcelable parcelable = this.lXU;
            this.lXU = null;
            return parcelable;
        }
        this.lXU = null;
        return null;
    }

    public int dpU() {
        return this.lXY;
    }

    public void FY(int i) {
        this.lXY = i;
    }

    public PostData dpV() {
        return this.lXX;
    }

    public void p(PostData postData) {
        this.lXX = postData;
    }

    public PostData dpW() {
        return this.lXW;
    }

    public void q(PostData postData) {
        this.lXW = postData;
    }

    public boolean dov() {
        return this.lUU;
    }

    public boolean dpX() {
        return this.lUS;
    }

    public boolean dpY() {
        return this.lXV;
    }

    public void g(Rect rect) {
        this.lXS = rect;
    }

    public Rect dpZ() {
        return this.lXS;
    }

    public void FZ(int i) {
        this.mTabIndex = i;
    }

    public int dps() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lXR = false;
        if (this.lXQ == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dlb() == null) {
            reset();
            return false;
        } else if (fVar.dlb().size() < 1) {
            reset();
            return false;
        } else {
            this.lOq = fVar;
            this.lXT = false;
            this.lXU = parcelable;
            this.lUU = z;
            this.lUS = z2;
            this.lXV = z3;
            return true;
        }
    }

    public void reset() {
        this.lXR = false;
        this.lOq = null;
        this.lXT = false;
        this.lXU = null;
        this.lXS = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lOq != null && this.lOq.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lOq.getForum().getId(), 0L)) {
                this.lOq.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lOq != null && this.lOq.dlb() != null && this.lOq.dlb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lOq.dlb().size();
                for (int i = 0; i < size; i++) {
                    if (this.lOq.dlb().get(i) != null && this.lOq.dlb().get(i).bnQ() != null && currentAccount.equals(this.lOq.dlb().get(i).bnQ().getUserId()) && this.lOq.dlb().get(i).bnQ().getPendantData() != null) {
                        this.lOq.dlb().get(i).bnQ().getPendantData().Ad(nVar.getImgUrl());
                        this.lOq.dlb().get(i).bnQ().getPendantData().ek(nVar.bAG());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lOq != null && eVar != null) {
            ArrayList<PostData> dlb = this.lOq.dlb();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dlb)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dlb) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bpJ = postData.bpJ();
                        bpJ.agreeType = agreeData.agreeType;
                        bpJ.hasAgree = agreeData.hasAgree;
                        bpJ.diffAgreeNum = agreeData.diffAgreeNum;
                        bpJ.agreeNum = agreeData.agreeNum;
                        bpJ.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lOq != null && this.lOq.dkZ() != null && this.lOq.dkZ().bpJ() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bpJ = this.lOq.dkZ().bpJ();
            if (agreeData != null && bpJ != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lOq.dkZ().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bpJ.agreeType = agreeData.agreeType;
                        bpJ.hasAgree = agreeData.hasAgree;
                        bpJ.diffAgreeNum = agreeData.diffAgreeNum;
                        bpJ.agreeNum = agreeData.agreeNum;
                        bpJ.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bpJ.threadId)) {
                    bpJ.agreeType = agreeData.agreeType;
                    bpJ.hasAgree = agreeData.hasAgree;
                    bpJ.diffAgreeNum = agreeData.diffAgreeNum;
                    bpJ.agreeNum = agreeData.agreeNum;
                    bpJ.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
