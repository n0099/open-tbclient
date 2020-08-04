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
/* loaded from: classes16.dex */
public class as {
    private com.baidu.tieba.pb.data.f kli;
    private boolean krk;
    private boolean krm;
    private String kug;
    private boolean kuh;
    private Rect kui;
    private boolean kuj;
    private Parcelable kuk;
    private boolean kul;
    private PostData kum;
    private PostData kun;
    private int kuo;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cPg().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cPg().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cPg().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cPg().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    as.cPg().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cPg().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cPg().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private static as kup = new as();
    }

    public static as cPg() {
        return a.kup;
    }

    private as() {
        this.kug = null;
        this.kuh = false;
        this.mTabIndex = 0;
        this.kli = null;
        this.kuj = false;
        this.kuk = null;
        this.krm = true;
        this.krk = false;
        this.kul = false;
    }

    public void aN(String str, boolean z) {
        this.kuh = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.kug = null;
        } else if (!str.equals(this.kug)) {
            reset();
            this.kug = str;
        } else {
            this.kuh = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.kuh) {
            this.kuj = false;
            return null;
        } else if (this.kli != null && this.kli.cKz() != null && this.kli.cKz().size() > 0) {
            this.kuj = true;
            com.baidu.tieba.pb.data.f fVar = this.kli;
            this.kli = null;
            return fVar;
        } else {
            this.kuj = false;
            this.kli = null;
            return null;
        }
    }

    public Parcelable cPh() {
        if (this.kuj) {
            this.kuj = false;
            Parcelable parcelable = this.kuk;
            this.kuk = null;
            return parcelable;
        }
        this.kuk = null;
        return null;
    }

    public int cPi() {
        return this.kuo;
    }

    public void BX(int i) {
        this.kuo = i;
    }

    public PostData cPj() {
        return this.kun;
    }

    public void p(PostData postData) {
        this.kun = postData;
    }

    public PostData cPk() {
        return this.kum;
    }

    public void q(PostData postData) {
        this.kum = postData;
    }

    public boolean cNN() {
        return this.krm;
    }

    public boolean cPl() {
        return this.krk;
    }

    public boolean cPm() {
        return this.kul;
    }

    public void h(Rect rect) {
        this.kui = rect;
    }

    public Rect cPn() {
        return this.kui;
    }

    public void BY(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.kuh = false;
        if (this.kug == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.cKz() == null) {
            reset();
            return false;
        } else if (fVar.cKz().size() < 1) {
            reset();
            return false;
        } else {
            this.kli = fVar;
            this.kuj = false;
            this.kuk = parcelable;
            this.krm = z;
            this.krk = z2;
            this.kul = z3;
            return true;
        }
    }

    public void reset() {
        this.kuh = false;
        this.kli = null;
        this.kuj = false;
        this.kuk = null;
        this.kui = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kli != null && this.kli.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kli.getForum().getId(), 0L)) {
                this.kli.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kli != null && this.kli.cKz() != null && this.kli.cKz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kli.cKz().size();
                for (int i = 0; i < size; i++) {
                    if (this.kli.cKz().get(i) != null && this.kli.cKz().get(i).aWl() != null && currentAccount.equals(this.kli.cKz().get(i).aWl().getUserId()) && this.kli.cKz().get(i).aWl().getPendantData() != null) {
                        this.kli.cKz().get(i).aWl().getPendantData().wU(lVar.aUh());
                        this.kli.cKz().get(i).aWl().getPendantData().cN(lVar.bin());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kli != null && eVar != null) {
            ArrayList<PostData> cKz = this.kli.cKz();
            if (!com.baidu.tbadk.core.util.x.isEmpty(cKz)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cKz) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aYc = postData.aYc();
                        aYc.agreeType = agreeData.agreeType;
                        aYc.hasAgree = agreeData.hasAgree;
                        aYc.diffAgreeNum = agreeData.diffAgreeNum;
                        aYc.agreeNum = agreeData.agreeNum;
                        aYc.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kli != null && this.kli.cKx() != null && this.kli.cKx().aYc() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aYc = this.kli.cKx().aYc();
            if (agreeData != null && aYc != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kli.cKx().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aYc.agreeType = agreeData.agreeType;
                        aYc.hasAgree = agreeData.hasAgree;
                        aYc.diffAgreeNum = agreeData.diffAgreeNum;
                        aYc.agreeNum = agreeData.agreeNum;
                        aYc.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aYc.threadId)) {
                    aYc.agreeType = agreeData.agreeType;
                    aYc.hasAgree = agreeData.hasAgree;
                    aYc.diffAgreeNum = agreeData.diffAgreeNum;
                    aYc.agreeNum = agreeData.agreeNum;
                    aYc.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
