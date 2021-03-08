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
    private com.baidu.tieba.pb.data.f lQH;
    private boolean lXj;
    private boolean lXl;
    private int mTabIndex;
    private String mai;
    private boolean maj;
    private Rect mak;
    private boolean mal;
    private Parcelable mam;
    private boolean man;
    private PostData mao;
    private PostData maq;
    private int mar;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dqi().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dqi().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dqi().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dqi().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.dqi().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dqi().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dqi().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj mas = new aj();
    }

    public static aj dqi() {
        return a.mas;
    }

    private aj() {
        this.mai = null;
        this.maj = false;
        this.mTabIndex = 0;
        this.lQH = null;
        this.mal = false;
        this.mam = null;
        this.lXl = true;
        this.lXj = false;
        this.man = false;
    }

    public void aX(String str, boolean z) {
        this.maj = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.mai = null;
        } else if (!str.equals(this.mai)) {
            reset();
            this.mai = str;
        } else {
            this.maj = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.maj) {
            this.mal = false;
            return null;
        } else if (this.lQH != null && this.lQH.dlr() != null && this.lQH.dlr().size() > 0) {
            this.mal = true;
            com.baidu.tieba.pb.data.f fVar = this.lQH;
            this.lQH = null;
            return fVar;
        } else {
            this.mal = false;
            this.lQH = null;
            return null;
        }
    }

    public Parcelable dqj() {
        if (this.mal) {
            this.mal = false;
            Parcelable parcelable = this.mam;
            this.mam = null;
            return parcelable;
        }
        this.mam = null;
        return null;
    }

    public int dqk() {
        return this.mar;
    }

    public void Gb(int i) {
        this.mar = i;
    }

    public PostData dql() {
        return this.maq;
    }

    public void p(PostData postData) {
        this.maq = postData;
    }

    public PostData dqm() {
        return this.mao;
    }

    public void q(PostData postData) {
        this.mao = postData;
    }

    public boolean doL() {
        return this.lXl;
    }

    public boolean dqn() {
        return this.lXj;
    }

    public boolean dqo() {
        return this.man;
    }

    public void g(Rect rect) {
        this.mak = rect;
    }

    public Rect dqp() {
        return this.mak;
    }

    public void Gc(int i) {
        this.mTabIndex = i;
    }

    public int dpI() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.maj = false;
        if (this.mai == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dlr() == null) {
            reset();
            return false;
        } else if (fVar.dlr().size() < 1) {
            reset();
            return false;
        } else {
            this.lQH = fVar;
            this.mal = false;
            this.mam = parcelable;
            this.lXl = z;
            this.lXj = z2;
            this.man = z3;
            return true;
        }
    }

    public void reset() {
        this.maj = false;
        this.lQH = null;
        this.mal = false;
        this.mam = null;
        this.mak = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lQH != null && this.lQH.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lQH.getForum().getId(), 0L)) {
                this.lQH.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lQH != null && this.lQH.dlr() != null && this.lQH.dlr().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lQH.dlr().size();
                for (int i = 0; i < size; i++) {
                    if (this.lQH.dlr().get(i) != null && this.lQH.dlr().get(i).bnS() != null && currentAccount.equals(this.lQH.dlr().get(i).bnS().getUserId()) && this.lQH.dlr().get(i).bnS().getPendantData() != null) {
                        this.lQH.dlr().get(i).bnS().getPendantData().Ak(nVar.getImgUrl());
                        this.lQH.dlr().get(i).bnS().getPendantData().ek(nVar.bAJ());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lQH != null && eVar != null) {
            ArrayList<PostData> dlr = this.lQH.dlr();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dlr)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dlr) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bpL = postData.bpL();
                        bpL.agreeType = agreeData.agreeType;
                        bpL.hasAgree = agreeData.hasAgree;
                        bpL.diffAgreeNum = agreeData.diffAgreeNum;
                        bpL.agreeNum = agreeData.agreeNum;
                        bpL.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lQH != null && this.lQH.dlp() != null && this.lQH.dlp().bpL() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bpL = this.lQH.dlp().bpL();
            if (agreeData != null && bpL != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lQH.dlp().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bpL.agreeType = agreeData.agreeType;
                        bpL.hasAgree = agreeData.hasAgree;
                        bpL.diffAgreeNum = agreeData.diffAgreeNum;
                        bpL.agreeNum = agreeData.agreeNum;
                        bpL.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bpL.threadId)) {
                    bpL.agreeType = agreeData.agreeType;
                    bpL.hasAgree = agreeData.hasAgree;
                    bpL.diffAgreeNum = agreeData.diffAgreeNum;
                    bpL.agreeNum = agreeData.agreeNum;
                    bpL.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
