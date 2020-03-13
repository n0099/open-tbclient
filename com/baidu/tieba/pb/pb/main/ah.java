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
public class ah {
    private com.baidu.tieba.pb.data.e iFn;
    private boolean iKn;
    private boolean iKp;
    private String iNg;
    private boolean iNh;
    private Rect iNi;
    private boolean iNj;
    private Parcelable iNk;
    private boolean iNl;
    private PostData iNm;
    private PostData iNn;
    private int iNo;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coR().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ah.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coR().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coR().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ah.coR().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ah.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ah.coR().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ah.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coR().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ah.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ah.coR().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ah iNp = new ah();
    }

    public static ah coR() {
        return a.iNp;
    }

    private ah() {
        this.iNg = null;
        this.iNh = false;
        this.mTabIndex = 0;
        this.iFn = null;
        this.iNj = false;
        this.iNk = null;
        this.iKp = true;
        this.iKn = false;
        this.iNl = false;
    }

    public void au(String str, boolean z) {
        this.iNh = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iNg = null;
        } else if (!str.equals(this.iNg)) {
            reset();
            this.iNg = str;
        } else {
            this.iNh = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.iNh) {
            this.iNj = false;
            return null;
        } else if (this.iFn != null && this.iFn.ckx() != null && this.iFn.ckx().size() > 0) {
            this.iNj = true;
            com.baidu.tieba.pb.data.e eVar = this.iFn;
            this.iFn = null;
            return eVar;
        } else {
            this.iNj = false;
            this.iFn = null;
            return null;
        }
    }

    public Parcelable coS() {
        if (this.iNj) {
            this.iNj = false;
            Parcelable parcelable = this.iNk;
            this.iNk = null;
            return parcelable;
        }
        this.iNk = null;
        return null;
    }

    public int coT() {
        return this.iNo;
    }

    public void za(int i) {
        this.iNo = i;
    }

    public PostData coU() {
        return this.iNn;
    }

    public void m(PostData postData) {
        this.iNn = postData;
    }

    public PostData coV() {
        return this.iNm;
    }

    public void n(PostData postData) {
        this.iNm = postData;
    }

    public boolean cnA() {
        return this.iKp;
    }

    public boolean coW() {
        return this.iKn;
    }

    public boolean coX() {
        return this.iNl;
    }

    public void h(Rect rect) {
        this.iNi = rect;
    }

    public Rect coY() {
        return this.iNi;
    }

    public void zb(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iNh = false;
        if (this.iNg == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.ckx() == null) {
            reset();
            return false;
        } else if (eVar.ckx().size() < 1) {
            reset();
            return false;
        } else {
            this.iFn = eVar;
            this.iNj = false;
            this.iNk = parcelable;
            this.iKp = z;
            this.iKn = z2;
            this.iNl = z3;
            return true;
        }
    }

    public void reset() {
        this.iNh = false;
        this.iFn = null;
        this.iNj = false;
        this.iNk = null;
        this.iNi = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.iFn != null && this.iFn.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.iFn.getForum().getId(), 0L)) {
                this.iFn.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.iFn != null && this.iFn.ckx() != null && this.iFn.ckx().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.iFn.ckx().size();
                for (int i = 0; i < size; i++) {
                    if (this.iFn.ckx().get(i) != null && this.iFn.ckx().get(i).aCo() != null && currentAccount.equals(this.iFn.ckx().get(i).aCo().getUserId()) && this.iFn.ckx().get(i).aCo().getPendantData() != null) {
                        this.iFn.ckx().get(i).aCo().getPendantData().sB(mVar.aAG());
                        this.iFn.ckx().get(i).aCo().getPendantData().bI(mVar.aNZ());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iFn != null && eVar != null) {
            ArrayList<PostData> ckx = this.iFn.ckx();
            if (!com.baidu.tbadk.core.util.v.isEmpty(ckx)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : ckx) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aEa = postData.aEa();
                        aEa.agreeType = agreeData.agreeType;
                        aEa.hasAgree = agreeData.hasAgree;
                        aEa.diffAgreeNum = agreeData.diffAgreeNum;
                        aEa.agreeNum = agreeData.agreeNum;
                        aEa.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.iFn != null && this.iFn.ckv() != null && this.iFn.ckv().aEa() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aEa = this.iFn.ckv().aEa();
            if (agreeData != null && aEa != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.iFn.ckv().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aEa.agreeType = agreeData.agreeType;
                        aEa.hasAgree = agreeData.hasAgree;
                        aEa.diffAgreeNum = agreeData.diffAgreeNum;
                        aEa.agreeNum = agreeData.agreeNum;
                        aEa.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aEa.threadId)) {
                    aEa.agreeType = agreeData.agreeType;
                    aEa.hasAgree = agreeData.hasAgree;
                    aEa.diffAgreeNum = agreeData.diffAgreeNum;
                    aEa.agreeNum = agreeData.agreeNum;
                    aEa.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
