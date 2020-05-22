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
    private com.baidu.tieba.pb.data.e jHO;
    private boolean jNr;
    private boolean jNt;
    private String jQj;
    private boolean jQk;
    private Rect jQl;
    private boolean jQm;
    private Parcelable jQn;
    private boolean jQo;
    private PostData jQp;
    private PostData jQq;
    private int jQr;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ao.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cGM().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ao.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cGM().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cGM().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cGM().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ao.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    ao.cGM().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ao.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cGM().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ao.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cGM().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ao jQs = new ao();
    }

    public static ao cGM() {
        return a.jQs;
    }

    private ao() {
        this.jQj = null;
        this.jQk = false;
        this.mTabIndex = 0;
        this.jHO = null;
        this.jQm = false;
        this.jQn = null;
        this.jNt = true;
        this.jNr = false;
        this.jQo = false;
    }

    public void aN(String str, boolean z) {
        this.jQk = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.jQj = null;
        } else if (!str.equals(this.jQj)) {
            reset();
            this.jQj = str;
        } else {
            this.jQk = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.jQk) {
            this.jQm = false;
            return null;
        } else if (this.jHO != null && this.jHO.cCk() != null && this.jHO.cCk().size() > 0) {
            this.jQm = true;
            com.baidu.tieba.pb.data.e eVar = this.jHO;
            this.jHO = null;
            return eVar;
        } else {
            this.jQm = false;
            this.jHO = null;
            return null;
        }
    }

    public Parcelable cGN() {
        if (this.jQm) {
            this.jQm = false;
            Parcelable parcelable = this.jQn;
            this.jQn = null;
            return parcelable;
        }
        this.jQn = null;
        return null;
    }

    public int cGO() {
        return this.jQr;
    }

    public void Au(int i) {
        this.jQr = i;
    }

    public PostData cGP() {
        return this.jQq;
    }

    public void p(PostData postData) {
        this.jQq = postData;
    }

    public PostData cGQ() {
        return this.jQp;
    }

    public void q(PostData postData) {
        this.jQp = postData;
    }

    public boolean cFv() {
        return this.jNt;
    }

    public boolean cGR() {
        return this.jNr;
    }

    public boolean cGS() {
        return this.jQo;
    }

    public void h(Rect rect) {
        this.jQl = rect;
    }

    public Rect cGT() {
        return this.jQl;
    }

    public void Av(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.jQk = false;
        if (this.jQj == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cCk() == null) {
            reset();
            return false;
        } else if (eVar.cCk().size() < 1) {
            reset();
            return false;
        } else {
            this.jHO = eVar;
            this.jQm = false;
            this.jQn = parcelable;
            this.jNt = z;
            this.jNr = z2;
            this.jQo = z3;
            return true;
        }
    }

    public void reset() {
        this.jQk = false;
        this.jHO = null;
        this.jQm = false;
        this.jQn = null;
        this.jQl = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.jHO != null && this.jHO.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.jHO.getForum().getId(), 0L)) {
                this.jHO.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.jHO != null && this.jHO.cCk() != null && this.jHO.cCk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jHO.cCk().size();
                for (int i = 0; i < size; i++) {
                    if (this.jHO.cCk().get(i) != null && this.jHO.cCk().get(i).aQx() != null && currentAccount.equals(this.jHO.cCk().get(i).aQx().getUserId()) && this.jHO.cCk().get(i).aQx().getPendantData() != null) {
                        this.jHO.cCk().get(i).aQx().getPendantData().vx(lVar.aOP());
                        this.jHO.cCk().get(i).aQx().getPendantData().cr(lVar.bcB());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jHO != null && eVar != null) {
            ArrayList<PostData> cCk = this.jHO.cCk();
            if (!com.baidu.tbadk.core.util.v.isEmpty(cCk)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cCk) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aSp = postData.aSp();
                        aSp.agreeType = agreeData.agreeType;
                        aSp.hasAgree = agreeData.hasAgree;
                        aSp.diffAgreeNum = agreeData.diffAgreeNum;
                        aSp.agreeNum = agreeData.agreeNum;
                        aSp.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jHO != null && this.jHO.cCi() != null && this.jHO.cCi().aSp() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aSp = this.jHO.cCi().aSp();
            if (agreeData != null && aSp != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.jHO.cCi().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aSp.agreeType = agreeData.agreeType;
                        aSp.hasAgree = agreeData.hasAgree;
                        aSp.diffAgreeNum = agreeData.diffAgreeNum;
                        aSp.agreeNum = agreeData.agreeNum;
                        aSp.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aSp.threadId)) {
                    aSp.agreeType = agreeData.agreeType;
                    aSp.hasAgree = agreeData.hasAgree;
                    aSp.diffAgreeNum = agreeData.diffAgreeNum;
                    aSp.agreeNum = agreeData.agreeNum;
                    aSp.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
