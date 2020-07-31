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
    private com.baidu.tieba.pb.data.f klg;
    private boolean kri;
    private boolean krk;
    private String kue;
    private boolean kuf;
    private Rect kug;
    private boolean kuh;
    private Parcelable kui;
    private boolean kuj;
    private PostData kuk;
    private PostData kul;
    private int kum;
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
        private static as kun = new as();
    }

    public static as cPg() {
        return a.kun;
    }

    private as() {
        this.kue = null;
        this.kuf = false;
        this.mTabIndex = 0;
        this.klg = null;
        this.kuh = false;
        this.kui = null;
        this.krk = true;
        this.kri = false;
        this.kuj = false;
    }

    public void aN(String str, boolean z) {
        this.kuf = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.kue = null;
        } else if (!str.equals(this.kue)) {
            reset();
            this.kue = str;
        } else {
            this.kuf = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.kuf) {
            this.kuh = false;
            return null;
        } else if (this.klg != null && this.klg.cKz() != null && this.klg.cKz().size() > 0) {
            this.kuh = true;
            com.baidu.tieba.pb.data.f fVar = this.klg;
            this.klg = null;
            return fVar;
        } else {
            this.kuh = false;
            this.klg = null;
            return null;
        }
    }

    public Parcelable cPh() {
        if (this.kuh) {
            this.kuh = false;
            Parcelable parcelable = this.kui;
            this.kui = null;
            return parcelable;
        }
        this.kui = null;
        return null;
    }

    public int cPi() {
        return this.kum;
    }

    public void BX(int i) {
        this.kum = i;
    }

    public PostData cPj() {
        return this.kul;
    }

    public void p(PostData postData) {
        this.kul = postData;
    }

    public PostData cPk() {
        return this.kuk;
    }

    public void q(PostData postData) {
        this.kuk = postData;
    }

    public boolean cNN() {
        return this.krk;
    }

    public boolean cPl() {
        return this.kri;
    }

    public boolean cPm() {
        return this.kuj;
    }

    public void h(Rect rect) {
        this.kug = rect;
    }

    public Rect cPn() {
        return this.kug;
    }

    public void BY(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.kuf = false;
        if (this.kue == null) {
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
            this.klg = fVar;
            this.kuh = false;
            this.kui = parcelable;
            this.krk = z;
            this.kri = z2;
            this.kuj = z3;
            return true;
        }
    }

    public void reset() {
        this.kuf = false;
        this.klg = null;
        this.kuh = false;
        this.kui = null;
        this.kug = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.klg != null && this.klg.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.klg.getForum().getId(), 0L)) {
                this.klg.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.klg != null && this.klg.cKz() != null && this.klg.cKz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.klg.cKz().size();
                for (int i = 0; i < size; i++) {
                    if (this.klg.cKz().get(i) != null && this.klg.cKz().get(i).aWl() != null && currentAccount.equals(this.klg.cKz().get(i).aWl().getUserId()) && this.klg.cKz().get(i).aWl().getPendantData() != null) {
                        this.klg.cKz().get(i).aWl().getPendantData().wU(lVar.aUh());
                        this.klg.cKz().get(i).aWl().getPendantData().cN(lVar.bin());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.klg != null && eVar != null) {
            ArrayList<PostData> cKz = this.klg.cKz();
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
        if (this.klg != null && this.klg.cKx() != null && this.klg.cKx().aYc() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aYc = this.klg.cKx().aYc();
            if (agreeData != null && aYc != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.klg.cKx().getBaijiahaoData();
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
