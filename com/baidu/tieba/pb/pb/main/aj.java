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
    private com.baidu.tieba.pb.data.f lOF;
    private boolean lVh;
    private boolean lVj;
    private String lYf;
    private boolean lYg;
    private Rect lYh;
    private boolean lYi;
    private Parcelable lYj;
    private boolean lYk;
    private PostData lYl;
    private PostData lYm;
    private int lYn;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpZ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpZ().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpZ().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.dpZ().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.dpZ().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dpZ().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.dpZ().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj lYo = new aj();
    }

    public static aj dpZ() {
        return a.lYo;
    }

    private aj() {
        this.lYf = null;
        this.lYg = false;
        this.mTabIndex = 0;
        this.lOF = null;
        this.lYi = false;
        this.lYj = null;
        this.lVj = true;
        this.lVh = false;
        this.lYk = false;
    }

    public void aX(String str, boolean z) {
        this.lYg = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lYf = null;
        } else if (!str.equals(this.lYf)) {
            reset();
            this.lYf = str;
        } else {
            this.lYg = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lYg) {
            this.lYi = false;
            return null;
        } else if (this.lOF != null && this.lOF.dli() != null && this.lOF.dli().size() > 0) {
            this.lYi = true;
            com.baidu.tieba.pb.data.f fVar = this.lOF;
            this.lOF = null;
            return fVar;
        } else {
            this.lYi = false;
            this.lOF = null;
            return null;
        }
    }

    public Parcelable dqa() {
        if (this.lYi) {
            this.lYi = false;
            Parcelable parcelable = this.lYj;
            this.lYj = null;
            return parcelable;
        }
        this.lYj = null;
        return null;
    }

    public int dqb() {
        return this.lYn;
    }

    public void FY(int i) {
        this.lYn = i;
    }

    public PostData dqc() {
        return this.lYm;
    }

    public void p(PostData postData) {
        this.lYm = postData;
    }

    public PostData dqd() {
        return this.lYl;
    }

    public void q(PostData postData) {
        this.lYl = postData;
    }

    public boolean doC() {
        return this.lVj;
    }

    public boolean dqe() {
        return this.lVh;
    }

    public boolean dqf() {
        return this.lYk;
    }

    public void g(Rect rect) {
        this.lYh = rect;
    }

    public Rect dqg() {
        return this.lYh;
    }

    public void FZ(int i) {
        this.mTabIndex = i;
    }

    public int dpz() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lYg = false;
        if (this.lYf == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dli() == null) {
            reset();
            return false;
        } else if (fVar.dli().size() < 1) {
            reset();
            return false;
        } else {
            this.lOF = fVar;
            this.lYi = false;
            this.lYj = parcelable;
            this.lVj = z;
            this.lVh = z2;
            this.lYk = z3;
            return true;
        }
    }

    public void reset() {
        this.lYg = false;
        this.lOF = null;
        this.lYi = false;
        this.lYj = null;
        this.lYh = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lOF != null && this.lOF.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lOF.getForum().getId(), 0L)) {
                this.lOF.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lOF != null && this.lOF.dli() != null && this.lOF.dli().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lOF.dli().size();
                for (int i = 0; i < size; i++) {
                    if (this.lOF.dli().get(i) != null && this.lOF.dli().get(i).bnQ() != null && currentAccount.equals(this.lOF.dli().get(i).bnQ().getUserId()) && this.lOF.dli().get(i).bnQ().getPendantData() != null) {
                        this.lOF.dli().get(i).bnQ().getPendantData().Ad(nVar.getImgUrl());
                        this.lOF.dli().get(i).bnQ().getPendantData().ek(nVar.bAG());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lOF != null && eVar != null) {
            ArrayList<PostData> dli = this.lOF.dli();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dli)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dli) {
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
        if (this.lOF != null && this.lOF.dlg() != null && this.lOF.dlg().bpJ() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bpJ = this.lOF.dlg().bpJ();
            if (agreeData != null && bpJ != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lOF.dlg().getBaijiahaoData();
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
