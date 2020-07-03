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
                ao.cLt().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ao.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLt().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLt().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cLt().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ao.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    ao.cLt().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ao.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cLt().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ao.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cLt().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ao klo = new ao();
    }

    public static ao cLt() {
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
        } else if (this.kcE != null && this.kcE.cGP() != null && this.kcE.cGP().size() > 0) {
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

    public Parcelable cLu() {
        if (this.kli) {
            this.kli = false;
            Parcelable parcelable = this.klj;
            this.klj = null;
            return parcelable;
        }
        this.klj = null;
        return null;
    }

    public int cLv() {
        return this.kln;
    }

    public void By(int i) {
        this.kln = i;
    }

    public PostData cLw() {
        return this.klm;
    }

    public void p(PostData postData) {
        this.klm = postData;
    }

    public PostData cLx() {
        return this.kll;
    }

    public void q(PostData postData) {
        this.kll = postData;
    }

    public boolean cKb() {
        return this.kin;
    }

    public boolean cLy() {
        return this.kil;
    }

    public boolean cLz() {
        return this.klk;
    }

    public void h(Rect rect) {
        this.klh = rect;
    }

    public Rect cLA() {
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
        } else if (eVar.cGP() == null) {
            reset();
            return false;
        } else if (eVar.cGP().size() < 1) {
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
        if (lVar != null && this.kcE != null && this.kcE.cGP() != null && this.kcE.cGP().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kcE.cGP().size();
                for (int i = 0; i < size; i++) {
                    if (this.kcE.cGP().get(i) != null && this.kcE.cGP().get(i).aSp() != null && currentAccount.equals(this.kcE.cGP().get(i).aSp().getUserId()) && this.kcE.cGP().get(i).aSp().getPendantData() != null) {
                        this.kcE.cGP().get(i).aSp().getPendantData().vN(lVar.aQl());
                        this.kcE.cGP().get(i).aSp().getPendantData().ct(lVar.beE());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kcE != null && eVar != null) {
            ArrayList<PostData> cGP = this.kcE.cGP();
            if (!com.baidu.tbadk.core.util.w.isEmpty(cGP)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cGP) {
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
        if (this.kcE != null && this.kcE.cGN() != null && this.kcE.cGN().aUg() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aUg = this.kcE.cGN().aUg();
            if (agreeData != null && aUg != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kcE.cGN().getBaijiahaoData();
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
