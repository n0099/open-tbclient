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
public class ao {
    private com.baidu.tieba.pb.data.e kcE;
    private boolean kil;
    private boolean kin;
    private String klf;
    private boolean klg;
    private Rect klh;
    private boolean kli;
    private Parcelable klj;
    private boolean klk;
    private PostData kll;
    private PostData klm;
    private int kln;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ao.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ao.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLu().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLu().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ao.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    ao.cLu().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ao.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cLu().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ao.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cLu().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ao klo = new ao();
    }

    public static ao cLu() {
        return a.klo;
    }

    private ao() {
        this.klf = null;
        this.klg = false;
        this.mTabIndex = 0;
        this.kcE = null;
        this.kli = false;
        this.klj = null;
        this.kin = true;
        this.kil = false;
        this.klk = false;
    }

    public void aP(String str, boolean z) {
        this.klg = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.klf = null;
        } else if (!str.equals(this.klf)) {
            reset();
            this.klf = str;
        } else {
            this.klg = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.klg) {
            this.kli = false;
            return null;
        } else if (this.kcE != null && this.kcE.cGQ() != null && this.kcE.cGQ().size() > 0) {
            this.kli = true;
            com.baidu.tieba.pb.data.e eVar = this.kcE;
            this.kcE = null;
            return eVar;
        } else {
            this.kli = false;
            this.kcE = null;
            return null;
        }
    }

    public Parcelable cLv() {
        if (this.kli) {
            this.kli = false;
            Parcelable parcelable = this.klj;
            this.klj = null;
            return parcelable;
        }
        this.klj = null;
        return null;
    }

    public int cLw() {
        return this.kln;
    }

    public void By(int i) {
        this.kln = i;
    }

    public PostData cLx() {
        return this.klm;
    }

    public void p(PostData postData) {
        this.klm = postData;
    }

    public PostData cLy() {
        return this.kll;
    }

    public void q(PostData postData) {
        this.kll = postData;
    }

    public boolean cKc() {
        return this.kin;
    }

    public boolean cLz() {
        return this.kil;
    }

    public boolean cLA() {
        return this.klk;
    }

    public void h(Rect rect) {
        this.klh = rect;
    }

    public Rect cLB() {
        return this.klh;
    }

    public void Bz(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.klg = false;
        if (this.klf == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cGQ() == null) {
            reset();
            return false;
        } else if (eVar.cGQ().size() < 1) {
            reset();
            return false;
        } else {
            this.kcE = eVar;
            this.kli = false;
            this.klj = parcelable;
            this.kin = z;
            this.kil = z2;
            this.klk = z3;
            return true;
        }
    }

    public void reset() {
        this.klg = false;
        this.kcE = null;
        this.kli = false;
        this.klj = null;
        this.klh = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kcE != null && this.kcE.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kcE.getForum().getId(), 0L)) {
                this.kcE.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kcE != null && this.kcE.cGQ() != null && this.kcE.cGQ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kcE.cGQ().size();
                for (int i = 0; i < size; i++) {
                    if (this.kcE.cGQ().get(i) != null && this.kcE.cGQ().get(i).aSp() != null && currentAccount.equals(this.kcE.cGQ().get(i).aSp().getUserId()) && this.kcE.cGQ().get(i).aSp().getPendantData() != null) {
                        this.kcE.cGQ().get(i).aSp().getPendantData().vN(lVar.aQl());
                        this.kcE.cGQ().get(i).aSp().getPendantData().ct(lVar.beE());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kcE != null && eVar != null) {
            ArrayList<PostData> cGQ = this.kcE.cGQ();
            if (!com.baidu.tbadk.core.util.w.isEmpty(cGQ)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cGQ) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aUg = postData.aUg();
                        aUg.agreeType = agreeData.agreeType;
                        aUg.hasAgree = agreeData.hasAgree;
                        aUg.diffAgreeNum = agreeData.diffAgreeNum;
                        aUg.agreeNum = agreeData.agreeNum;
                        aUg.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kcE != null && this.kcE.cGO() != null && this.kcE.cGO().aUg() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aUg = this.kcE.cGO().aUg();
            if (agreeData != null && aUg != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kcE.cGO().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aUg.agreeType = agreeData.agreeType;
                        aUg.hasAgree = agreeData.hasAgree;
                        aUg.diffAgreeNum = agreeData.diffAgreeNum;
                        aUg.agreeNum = agreeData.agreeNum;
                        aUg.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aUg.threadId)) {
                    aUg.agreeType = agreeData.agreeType;
                    aUg.hasAgree = agreeData.hasAgree;
                    aUg.diffAgreeNum = agreeData.diffAgreeNum;
                    aUg.agreeNum = agreeData.agreeNum;
                    aUg.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
