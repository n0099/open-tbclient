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
/* loaded from: classes21.dex */
public class as {
    private boolean lAA;
    private Parcelable lAB;
    private boolean lAC;
    private PostData lAD;
    private PostData lAE;
    private int lAF;
    private String lAx;
    private boolean lAy;
    private Rect lAz;
    private com.baidu.tieba.pb.data.f lre;
    private boolean lxB;
    private boolean lxz;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmr().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmr().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmr().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmr().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    as.dmr().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dmr().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dmr().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static as lAG = new as();
    }

    public static as dmr() {
        return a.lAG;
    }

    private as() {
        this.lAx = null;
        this.lAy = false;
        this.mTabIndex = 0;
        this.lre = null;
        this.lAA = false;
        this.lAB = null;
        this.lxB = true;
        this.lxz = false;
        this.lAC = false;
    }

    public void aX(String str, boolean z) {
        this.lAy = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lAx = null;
        } else if (!str.equals(this.lAx)) {
            reset();
            this.lAx = str;
        } else {
            this.lAy = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lAy) {
            this.lAA = false;
            return null;
        } else if (this.lre != null && this.lre.dhJ() != null && this.lre.dhJ().size() > 0) {
            this.lAA = true;
            com.baidu.tieba.pb.data.f fVar = this.lre;
            this.lre = null;
            return fVar;
        } else {
            this.lAA = false;
            this.lre = null;
            return null;
        }
    }

    public Parcelable dms() {
        if (this.lAA) {
            this.lAA = false;
            Parcelable parcelable = this.lAB;
            this.lAB = null;
            return parcelable;
        }
        this.lAB = null;
        return null;
    }

    public int dmt() {
        return this.lAF;
    }

    public void GC(int i) {
        this.lAF = i;
    }

    public PostData dmu() {
        return this.lAE;
    }

    public void p(PostData postData) {
        this.lAE = postData;
    }

    public PostData dmv() {
        return this.lAD;
    }

    public void q(PostData postData) {
        this.lAD = postData;
    }

    public boolean dkW() {
        return this.lxB;
    }

    public boolean dmw() {
        return this.lxz;
    }

    public boolean dmx() {
        return this.lAC;
    }

    public void h(Rect rect) {
        this.lAz = rect;
    }

    public Rect dmy() {
        return this.lAz;
    }

    public void GD(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lAy = false;
        if (this.lAx == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dhJ() == null) {
            reset();
            return false;
        } else if (fVar.dhJ().size() < 1) {
            reset();
            return false;
        } else {
            this.lre = fVar;
            this.lAA = false;
            this.lAB = parcelable;
            this.lxB = z;
            this.lxz = z2;
            this.lAC = z3;
            return true;
        }
    }

    public void reset() {
        this.lAy = false;
        this.lre = null;
        this.lAA = false;
        this.lAB = null;
        this.lAz = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lre != null && this.lre.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lre.getForum().getId(), 0L)) {
                this.lre.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lre != null && this.lre.dhJ() != null && this.lre.dhJ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lre.dhJ().size();
                for (int i = 0; i < size; i++) {
                    if (this.lre.dhJ().get(i) != null && this.lre.dhJ().get(i).blC() != null && currentAccount.equals(this.lre.dhJ().get(i).blC().getUserId()) && this.lre.dhJ().get(i).blC().getPendantData() != null) {
                        this.lre.dhJ().get(i).blC().getPendantData().As(mVar.bjy());
                        this.lre.dhJ().get(i).blC().getPendantData().dF(mVar.bym());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lre != null && eVar != null) {
            ArrayList<PostData> dhJ = this.lre.dhJ();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dhJ)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dhJ) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bnv = postData.bnv();
                        bnv.agreeType = agreeData.agreeType;
                        bnv.hasAgree = agreeData.hasAgree;
                        bnv.diffAgreeNum = agreeData.diffAgreeNum;
                        bnv.agreeNum = agreeData.agreeNum;
                        bnv.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lre != null && this.lre.dhH() != null && this.lre.dhH().bnv() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bnv = this.lre.dhH().bnv();
            if (agreeData != null && bnv != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lre.dhH().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bnv.agreeType = agreeData.agreeType;
                        bnv.hasAgree = agreeData.hasAgree;
                        bnv.diffAgreeNum = agreeData.diffAgreeNum;
                        bnv.agreeNum = agreeData.agreeNum;
                        bnv.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bnv.threadId)) {
                    bnv.agreeType = agreeData.agreeType;
                    bnv.hasAgree = agreeData.hasAgree;
                    bnv.diffAgreeNum = agreeData.diffAgreeNum;
                    bnv.agreeNum = agreeData.agreeNum;
                    bnv.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
