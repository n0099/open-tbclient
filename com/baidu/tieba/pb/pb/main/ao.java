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
    private com.baidu.tieba.pb.data.e jIU;
    private boolean jOx;
    private boolean jOz;
    private String jRp;
    private boolean jRq;
    private Rect jRr;
    private boolean jRs;
    private Parcelable jRt;
    private boolean jRu;
    private PostData jRv;
    private PostData jRw;
    private int jRx;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ao.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cHc().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ao.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cHc().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cHc().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ao.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ao.cHc().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ao.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    ao.cHc().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ao.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cHc().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ao.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ao.cHc().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static ao jRy = new ao();
    }

    public static ao cHc() {
        return a.jRy;
    }

    private ao() {
        this.jRp = null;
        this.jRq = false;
        this.mTabIndex = 0;
        this.jIU = null;
        this.jRs = false;
        this.jRt = null;
        this.jOz = true;
        this.jOx = false;
        this.jRu = false;
    }

    public void aN(String str, boolean z) {
        this.jRq = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.jRp = null;
        } else if (!str.equals(this.jRp)) {
            reset();
            this.jRp = str;
        } else {
            this.jRq = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.jRq) {
            this.jRs = false;
            return null;
        } else if (this.jIU != null && this.jIU.cCA() != null && this.jIU.cCA().size() > 0) {
            this.jRs = true;
            com.baidu.tieba.pb.data.e eVar = this.jIU;
            this.jIU = null;
            return eVar;
        } else {
            this.jRs = false;
            this.jIU = null;
            return null;
        }
    }

    public Parcelable cHd() {
        if (this.jRs) {
            this.jRs = false;
            Parcelable parcelable = this.jRt;
            this.jRt = null;
            return parcelable;
        }
        this.jRt = null;
        return null;
    }

    public int cHe() {
        return this.jRx;
    }

    public void Aw(int i) {
        this.jRx = i;
    }

    public PostData cHf() {
        return this.jRw;
    }

    public void p(PostData postData) {
        this.jRw = postData;
    }

    public PostData cHg() {
        return this.jRv;
    }

    public void q(PostData postData) {
        this.jRv = postData;
    }

    public boolean cFL() {
        return this.jOz;
    }

    public boolean cHh() {
        return this.jOx;
    }

    public boolean cHi() {
        return this.jRu;
    }

    public void h(Rect rect) {
        this.jRr = rect;
    }

    public Rect cHj() {
        return this.jRr;
    }

    public void Ax(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.jRq = false;
        if (this.jRp == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.cCA() == null) {
            reset();
            return false;
        } else if (eVar.cCA().size() < 1) {
            reset();
            return false;
        } else {
            this.jIU = eVar;
            this.jRs = false;
            this.jRt = parcelable;
            this.jOz = z;
            this.jOx = z2;
            this.jRu = z3;
            return true;
        }
    }

    public void reset() {
        this.jRq = false;
        this.jIU = null;
        this.jRs = false;
        this.jRt = null;
        this.jRr = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.jIU != null && this.jIU.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.jIU.getForum().getId(), 0L)) {
                this.jIU.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.jIU != null && this.jIU.cCA() != null && this.jIU.cCA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.jIU.cCA().size();
                for (int i = 0; i < size; i++) {
                    if (this.jIU.cCA().get(i) != null && this.jIU.cCA().get(i).aQx() != null && currentAccount.equals(this.jIU.cCA().get(i).aQx().getUserId()) && this.jIU.cCA().get(i).aQx().getPendantData() != null) {
                        this.jIU.cCA().get(i).aQx().getPendantData().vx(lVar.aOP());
                        this.jIU.cCA().get(i).aQx().getPendantData().cr(lVar.bcC());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.jIU != null && eVar != null) {
            ArrayList<PostData> cCA = this.jIU.cCA();
            if (!com.baidu.tbadk.core.util.v.isEmpty(cCA)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cCA) {
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
        if (this.jIU != null && this.jIU.cCy() != null && this.jIU.cCy().aSp() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aSp = this.jIU.cCy().aSp();
            if (agreeData != null && aSp != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.jIU.cCy().getBaijiahaoData();
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
