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
    private com.baidu.tieba.pb.data.f lFA;
    private boolean lLW;
    private boolean lLY;
    private String lOU;
    private boolean lOV;
    private Rect lOW;
    private boolean lOX;
    private Parcelable lOY;
    private boolean lOZ;
    private PostData lPa;
    private PostData lPb;
    private int lPc;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dnE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dnE().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dnE().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dnE().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.dnE().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dnE().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dnE().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj lPd = new aj();
    }

    public static aj dnE() {
        return a.lPd;
    }

    private aj() {
        this.lOU = null;
        this.lOV = false;
        this.mTabIndex = 0;
        this.lFA = null;
        this.lOX = false;
        this.lOY = null;
        this.lLY = true;
        this.lLW = false;
        this.lOZ = false;
    }

    public void aY(String str, boolean z) {
        this.lOV = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lOU = null;
        } else if (!str.equals(this.lOU)) {
            reset();
            this.lOU = str;
        } else {
            this.lOV = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lOV) {
            this.lOX = false;
            return null;
        } else if (this.lFA != null && this.lFA.diP() != null && this.lFA.diP().size() > 0) {
            this.lOX = true;
            com.baidu.tieba.pb.data.f fVar = this.lFA;
            this.lFA = null;
            return fVar;
        } else {
            this.lOX = false;
            this.lFA = null;
            return null;
        }
    }

    public Parcelable dnF() {
        if (this.lOX) {
            this.lOX = false;
            Parcelable parcelable = this.lOY;
            this.lOY = null;
            return parcelable;
        }
        this.lOY = null;
        return null;
    }

    public int dnG() {
        return this.lPc;
    }

    public void FF(int i) {
        this.lPc = i;
    }

    public PostData dnH() {
        return this.lPb;
    }

    public void p(PostData postData) {
        this.lPb = postData;
    }

    public PostData dnI() {
        return this.lPa;
    }

    public void q(PostData postData) {
        this.lPa = postData;
    }

    public boolean dmg() {
        return this.lLY;
    }

    public boolean dnJ() {
        return this.lLW;
    }

    public boolean dnK() {
        return this.lOZ;
    }

    public void g(Rect rect) {
        this.lOW = rect;
    }

    public Rect dnL() {
        return this.lOW;
    }

    public void FG(int i) {
        this.mTabIndex = i;
    }

    public int dnd() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lOV = false;
        if (this.lOU == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.diP() == null) {
            reset();
            return false;
        } else if (fVar.diP().size() < 1) {
            reset();
            return false;
        } else {
            this.lFA = fVar;
            this.lOX = false;
            this.lOY = parcelable;
            this.lLY = z;
            this.lLW = z2;
            this.lOZ = z3;
            return true;
        }
    }

    public void reset() {
        this.lOV = false;
        this.lFA = null;
        this.lOX = false;
        this.lOY = null;
        this.lOW = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lFA != null && this.lFA.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lFA.getForum().getId(), 0L)) {
                this.lFA.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lFA != null && this.lFA.diP() != null && this.lFA.diP().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lFA.diP().size();
                for (int i = 0; i < size; i++) {
                    if (this.lFA.diP().get(i) != null && this.lFA.diP().get(i).bnx() != null && currentAccount.equals(this.lFA.diP().get(i).bnx().getUserId()) && this.lFA.diP().get(i).bnx().getPendantData() != null) {
                        this.lFA.diP().get(i).bnx().getPendantData().zM(nVar.getImgUrl());
                        this.lFA.diP().get(i).bnx().getPendantData().ee(nVar.bAo());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lFA != null && eVar != null) {
            ArrayList<PostData> diP = this.lFA.diP();
            if (!com.baidu.tbadk.core.util.x.isEmpty(diP)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : diP) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bpr = postData.bpr();
                        bpr.agreeType = agreeData.agreeType;
                        bpr.hasAgree = agreeData.hasAgree;
                        bpr.diffAgreeNum = agreeData.diffAgreeNum;
                        bpr.agreeNum = agreeData.agreeNum;
                        bpr.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lFA != null && this.lFA.diN() != null && this.lFA.diN().bpr() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bpr = this.lFA.diN().bpr();
            if (agreeData != null && bpr != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lFA.diN().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bpr.agreeType = agreeData.agreeType;
                        bpr.hasAgree = agreeData.hasAgree;
                        bpr.diffAgreeNum = agreeData.diffAgreeNum;
                        bpr.agreeNum = agreeData.agreeNum;
                        bpr.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bpr.threadId)) {
                    bpr.agreeType = agreeData.agreeType;
                    bpr.hasAgree = agreeData.hasAgree;
                    bpr.diffAgreeNum = agreeData.diffAgreeNum;
                    bpr.agreeNum = agreeData.agreeNum;
                    bpr.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
