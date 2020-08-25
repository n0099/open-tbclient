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
    private com.baidu.tieba.pb.data.f kAA;
    private boolean kGP;
    private boolean kGR;
    private String kJL;
    private boolean kJM;
    private Rect kJN;
    private boolean kJO;
    private Parcelable kJP;
    private boolean kJQ;
    private PostData kJR;
    private PostData kJS;
    private int kJT;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZW().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZW().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZW().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZW().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    as.cZW().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cZW().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cZW().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private static as kJU = new as();
    }

    public static as cZW() {
        return a.kJU;
    }

    private as() {
        this.kJL = null;
        this.kJM = false;
        this.mTabIndex = 0;
        this.kAA = null;
        this.kJO = false;
        this.kJP = null;
        this.kGR = true;
        this.kGP = false;
        this.kJQ = false;
    }

    public void aR(String str, boolean z) {
        this.kJM = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.kJL = null;
        } else if (!str.equals(this.kJL)) {
            reset();
            this.kJL = str;
        } else {
            this.kJM = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.kJM) {
            this.kJO = false;
            return null;
        } else if (this.kAA != null && this.kAA.cVn() != null && this.kAA.cVn().size() > 0) {
            this.kJO = true;
            com.baidu.tieba.pb.data.f fVar = this.kAA;
            this.kAA = null;
            return fVar;
        } else {
            this.kJO = false;
            this.kAA = null;
            return null;
        }
    }

    public Parcelable cZX() {
        if (this.kJO) {
            this.kJO = false;
            Parcelable parcelable = this.kJP;
            this.kJP = null;
            return parcelable;
        }
        this.kJP = null;
        return null;
    }

    public int cZY() {
        return this.kJT;
    }

    public void Er(int i) {
        this.kJT = i;
    }

    public PostData cZZ() {
        return this.kJS;
    }

    public void p(PostData postData) {
        this.kJS = postData;
    }

    public PostData daa() {
        return this.kJR;
    }

    public void q(PostData postData) {
        this.kJR = postData;
    }

    public boolean cYD() {
        return this.kGR;
    }

    public boolean dab() {
        return this.kGP;
    }

    public boolean dac() {
        return this.kJQ;
    }

    public void h(Rect rect) {
        this.kJN = rect;
    }

    public Rect dad() {
        return this.kJN;
    }

    public void Es(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.kJM = false;
        if (this.kJL == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.cVn() == null) {
            reset();
            return false;
        } else if (fVar.cVn().size() < 1) {
            reset();
            return false;
        } else {
            this.kAA = fVar;
            this.kJO = false;
            this.kJP = parcelable;
            this.kGR = z;
            this.kGP = z2;
            this.kJQ = z3;
            return true;
        }
    }

    public void reset() {
        this.kJM = false;
        this.kAA = null;
        this.kJO = false;
        this.kJP = null;
        this.kJN = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kAA != null && this.kAA.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kAA.getForum().getId(), 0L)) {
                this.kAA.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kAA != null && this.kAA.cVn() != null && this.kAA.cVn().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kAA.cVn().size();
                for (int i = 0; i < size; i++) {
                    if (this.kAA.cVn().get(i) != null && this.kAA.cVn().get(i).beE() != null && currentAccount.equals(this.kAA.cVn().get(i).beE().getUserId()) && this.kAA.cVn().get(i).beE().getPendantData() != null) {
                        this.kAA.cVn().get(i).beE().getPendantData().zi(lVar.bcA());
                        this.kAA.cVn().get(i).beE().getPendantData().cY(lVar.bqZ());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kAA != null && eVar != null) {
            ArrayList<PostData> cVn = this.kAA.cVn();
            if (!com.baidu.tbadk.core.util.y.isEmpty(cVn)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cVn) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bgv = postData.bgv();
                        bgv.agreeType = agreeData.agreeType;
                        bgv.hasAgree = agreeData.hasAgree;
                        bgv.diffAgreeNum = agreeData.diffAgreeNum;
                        bgv.agreeNum = agreeData.agreeNum;
                        bgv.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kAA != null && this.kAA.cVl() != null && this.kAA.cVl().bgv() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bgv = this.kAA.cVl().bgv();
            if (agreeData != null && bgv != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kAA.cVl().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bgv.agreeType = agreeData.agreeType;
                        bgv.hasAgree = agreeData.hasAgree;
                        bgv.diffAgreeNum = agreeData.diffAgreeNum;
                        bgv.agreeNum = agreeData.agreeNum;
                        bgv.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bgv.threadId)) {
                    bgv.agreeType = agreeData.agreeType;
                    bgv.hasAgree = agreeData.hasAgree;
                    bgv.diffAgreeNum = agreeData.diffAgreeNum;
                    bgv.agreeNum = agreeData.agreeNum;
                    bgv.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
