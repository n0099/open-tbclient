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
    private com.baidu.tieba.pb.data.f lEN;
    private boolean lLm;
    private boolean lLo;
    private String lOk;
    private boolean lOl;
    private Rect lOm;
    private boolean lOn;
    private Parcelable lOo;
    private boolean lOp;
    private PostData lOq;
    private PostData lOr;
    private int lOs;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drI().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drI().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.drI().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    as.drI().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.drI().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.drI().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static as lOt = new as();
    }

    public static as drI() {
        return a.lOt;
    }

    private as() {
        this.lOk = null;
        this.lOl = false;
        this.mTabIndex = 0;
        this.lEN = null;
        this.lOn = false;
        this.lOo = null;
        this.lLo = true;
        this.lLm = false;
        this.lOp = false;
    }

    public void aY(String str, boolean z) {
        this.lOl = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lOk = null;
        } else if (!str.equals(this.lOk)) {
            reset();
            this.lOk = str;
        } else {
            this.lOl = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lOl) {
            this.lOn = false;
            return null;
        } else if (this.lEN != null && this.lEN.dmV() != null && this.lEN.dmV().size() > 0) {
            this.lOn = true;
            com.baidu.tieba.pb.data.f fVar = this.lEN;
            this.lEN = null;
            return fVar;
        } else {
            this.lOn = false;
            this.lEN = null;
            return null;
        }
    }

    public Parcelable drJ() {
        if (this.lOn) {
            this.lOn = false;
            Parcelable parcelable = this.lOo;
            this.lOo = null;
            return parcelable;
        }
        this.lOo = null;
        return null;
    }

    public int drK() {
        return this.lOs;
    }

    public void Hs(int i) {
        this.lOs = i;
    }

    public PostData drL() {
        return this.lOr;
    }

    public void p(PostData postData) {
        this.lOr = postData;
    }

    public PostData drM() {
        return this.lOq;
    }

    public void q(PostData postData) {
        this.lOq = postData;
    }

    public boolean dql() {
        return this.lLo;
    }

    public boolean drN() {
        return this.lLm;
    }

    public boolean drO() {
        return this.lOp;
    }

    public void h(Rect rect) {
        this.lOm = rect;
    }

    public Rect drP() {
        return this.lOm;
    }

    public void Ht(int i) {
        this.mTabIndex = i;
    }

    public int dri() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lOl = false;
        if (this.lOk == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dmV() == null) {
            reset();
            return false;
        } else if (fVar.dmV().size() < 1) {
            reset();
            return false;
        } else {
            this.lEN = fVar;
            this.lOn = false;
            this.lOo = parcelable;
            this.lLo = z;
            this.lLm = z2;
            this.lOp = z3;
            return true;
        }
    }

    public void reset() {
        this.lOl = false;
        this.lEN = null;
        this.lOn = false;
        this.lOo = null;
        this.lOm = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lEN != null && this.lEN.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lEN.getForum().getId(), 0L)) {
                this.lEN.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lEN != null && this.lEN.dmV() != null && this.lEN.dmV().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lEN.dmV().size();
                for (int i = 0; i < size; i++) {
                    if (this.lEN.dmV().get(i) != null && this.lEN.dmV().get(i).boP() != null && currentAccount.equals(this.lEN.dmV().get(i).boP().getUserId()) && this.lEN.dmV().get(i).boP().getPendantData() != null) {
                        this.lEN.dmV().get(i).boP().getPendantData().AZ(nVar.bmL());
                        this.lEN.dmV().get(i).boP().getPendantData().ee(nVar.bBM());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lEN != null && eVar != null) {
            ArrayList<PostData> dmV = this.lEN.dmV();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dmV)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dmV) {
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
        if (this.lEN != null && this.lEN.dmT() != null && this.lEN.dmT().bqI() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bqI = this.lEN.dmT().bqI();
            if (agreeData != null && bqI != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lEN.dmT().getBaijiahaoData();
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
