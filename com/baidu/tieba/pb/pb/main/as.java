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
/* loaded from: classes22.dex */
public class as {
    private com.baidu.tieba.pb.data.f lEP;
    private boolean lLo;
    private boolean lLq;
    private String lOm;
    private boolean lOn;
    private Rect lOo;
    private boolean lOp;
    private Parcelable lOq;
    private boolean lOr;
    private PostData lOs;
    private PostData lOt;
    private int lOu;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drJ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drJ().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drJ().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    as.drJ().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.drJ().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.drJ().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static as lOv = new as();
    }

    public static as drJ() {
        return a.lOv;
    }

    private as() {
        this.lOm = null;
        this.lOn = false;
        this.mTabIndex = 0;
        this.lEP = null;
        this.lOp = false;
        this.lOq = null;
        this.lLq = true;
        this.lLo = false;
        this.lOr = false;
    }

    public void aY(String str, boolean z) {
        this.lOn = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lOm = null;
        } else if (!str.equals(this.lOm)) {
            reset();
            this.lOm = str;
        } else {
            this.lOn = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lOn) {
            this.lOp = false;
            return null;
        } else if (this.lEP != null && this.lEP.dmW() != null && this.lEP.dmW().size() > 0) {
            this.lOp = true;
            com.baidu.tieba.pb.data.f fVar = this.lEP;
            this.lEP = null;
            return fVar;
        } else {
            this.lOp = false;
            this.lEP = null;
            return null;
        }
    }

    public Parcelable drK() {
        if (this.lOp) {
            this.lOp = false;
            Parcelable parcelable = this.lOq;
            this.lOq = null;
            return parcelable;
        }
        this.lOq = null;
        return null;
    }

    public int drL() {
        return this.lOu;
    }

    public void Hs(int i) {
        this.lOu = i;
    }

    public PostData drM() {
        return this.lOt;
    }

    public void p(PostData postData) {
        this.lOt = postData;
    }

    public PostData drN() {
        return this.lOs;
    }

    public void q(PostData postData) {
        this.lOs = postData;
    }

    public boolean dqm() {
        return this.lLq;
    }

    public boolean drO() {
        return this.lLo;
    }

    public boolean drP() {
        return this.lOr;
    }

    public void h(Rect rect) {
        this.lOo = rect;
    }

    public Rect drQ() {
        return this.lOo;
    }

    public void Ht(int i) {
        this.mTabIndex = i;
    }

    public int drj() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lOn = false;
        if (this.lOm == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dmW() == null) {
            reset();
            return false;
        } else if (fVar.dmW().size() < 1) {
            reset();
            return false;
        } else {
            this.lEP = fVar;
            this.lOp = false;
            this.lOq = parcelable;
            this.lLq = z;
            this.lLo = z2;
            this.lOr = z3;
            return true;
        }
    }

    public void reset() {
        this.lOn = false;
        this.lEP = null;
        this.lOp = false;
        this.lOq = null;
        this.lOo = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lEP != null && this.lEP.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lEP.getForum().getId(), 0L)) {
                this.lEP.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lEP != null && this.lEP.dmW() != null && this.lEP.dmW().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lEP.dmW().size();
                for (int i = 0; i < size; i++) {
                    if (this.lEP.dmW().get(i) != null && this.lEP.dmW().get(i).boP() != null && currentAccount.equals(this.lEP.dmW().get(i).boP().getUserId()) && this.lEP.dmW().get(i).boP().getPendantData() != null) {
                        this.lEP.dmW().get(i).boP().getPendantData().AZ(nVar.bmL());
                        this.lEP.dmW().get(i).boP().getPendantData().ee(nVar.bBM());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lEP != null && eVar != null) {
            ArrayList<PostData> dmW = this.lEP.dmW();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dmW)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dmW) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bqI = postData.bqI();
                        bqI.agreeType = agreeData.agreeType;
                        bqI.hasAgree = agreeData.hasAgree;
                        bqI.diffAgreeNum = agreeData.diffAgreeNum;
                        bqI.agreeNum = agreeData.agreeNum;
                        bqI.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lEP != null && this.lEP.dmU() != null && this.lEP.dmU().bqI() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bqI = this.lEP.dmU().bqI();
            if (agreeData != null && bqI != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lEP.dmU().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bqI.agreeType = agreeData.agreeType;
                        bqI.hasAgree = agreeData.hasAgree;
                        bqI.diffAgreeNum = agreeData.diffAgreeNum;
                        bqI.agreeNum = agreeData.agreeNum;
                        bqI.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bqI.threadId)) {
                    bqI.agreeType = agreeData.agreeType;
                    bqI.hasAgree = agreeData.hasAgree;
                    bqI.diffAgreeNum = agreeData.diffAgreeNum;
                    bqI.agreeNum = agreeData.agreeNum;
                    bqI.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
