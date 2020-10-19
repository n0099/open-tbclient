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
/* loaded from: classes22.dex */
public class as {
    private com.baidu.tieba.pb.data.f kYp;
    private boolean leJ;
    private boolean leL;
    private String lhF;
    private boolean lhG;
    private Rect lhH;
    private boolean lhI;
    private Parcelable lhJ;
    private boolean lhK;
    private PostData lhL;
    private PostData lhM;
    private int lhN;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dhj().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dhj().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dhj().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dhj().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    as.dhj().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dhj().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dhj().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static as lhO = new as();
    }

    public static as dhj() {
        return a.lhO;
    }

    private as() {
        this.lhF = null;
        this.lhG = false;
        this.mTabIndex = 0;
        this.kYp = null;
        this.lhI = false;
        this.lhJ = null;
        this.leL = true;
        this.leJ = false;
        this.lhK = false;
    }

    public void aV(String str, boolean z) {
        this.lhG = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lhF = null;
        } else if (!str.equals(this.lhF)) {
            reset();
            this.lhF = str;
        } else {
            this.lhG = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lhG) {
            this.lhI = false;
            return null;
        } else if (this.kYp != null && this.kYp.dcC() != null && this.kYp.dcC().size() > 0) {
            this.lhI = true;
            com.baidu.tieba.pb.data.f fVar = this.kYp;
            this.kYp = null;
            return fVar;
        } else {
            this.lhI = false;
            this.kYp = null;
            return null;
        }
    }

    public Parcelable dhk() {
        if (this.lhI) {
            this.lhI = false;
            Parcelable parcelable = this.lhJ;
            this.lhJ = null;
            return parcelable;
        }
        this.lhJ = null;
        return null;
    }

    public int dhl() {
        return this.lhN;
    }

    public void Fy(int i) {
        this.lhN = i;
    }

    public PostData dhm() {
        return this.lhM;
    }

    public void p(PostData postData) {
        this.lhM = postData;
    }

    public PostData dhn() {
        return this.lhL;
    }

    public void q(PostData postData) {
        this.lhL = postData;
    }

    public boolean dfQ() {
        return this.leL;
    }

    public boolean dho() {
        return this.leJ;
    }

    public boolean dhp() {
        return this.lhK;
    }

    public void h(Rect rect) {
        this.lhH = rect;
    }

    public Rect dhq() {
        return this.lhH;
    }

    public void Fz(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lhG = false;
        if (this.lhF == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dcC() == null) {
            reset();
            return false;
        } else if (fVar.dcC().size() < 1) {
            reset();
            return false;
        } else {
            this.kYp = fVar;
            this.lhI = false;
            this.lhJ = parcelable;
            this.leL = z;
            this.leJ = z2;
            this.lhK = z3;
            return true;
        }
    }

    public void reset() {
        this.lhG = false;
        this.kYp = null;
        this.lhI = false;
        this.lhJ = null;
        this.lhH = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kYp != null && this.kYp.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kYp.getForum().getId(), 0L)) {
                this.kYp.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.kYp != null && this.kYp.dcC() != null && this.kYp.dcC().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kYp.dcC().size();
                for (int i = 0; i < size; i++) {
                    if (this.kYp.dcC().get(i) != null && this.kYp.dcC().get(i).bih() != null && currentAccount.equals(this.kYp.dcC().get(i).bih().getUserId()) && this.kYp.dcC().get(i).bih().getPendantData() != null) {
                        this.kYp.dcC().get(i).bih().getPendantData().Aq(mVar.bgd());
                        this.kYp.dcC().get(i).bih().getPendantData().dh(mVar.buE());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kYp != null && eVar != null) {
            ArrayList<PostData> dcC = this.kYp.dcC();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dcC)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dcC) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bjY = postData.bjY();
                        bjY.agreeType = agreeData.agreeType;
                        bjY.hasAgree = agreeData.hasAgree;
                        bjY.diffAgreeNum = agreeData.diffAgreeNum;
                        bjY.agreeNum = agreeData.agreeNum;
                        bjY.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kYp != null && this.kYp.dcA() != null && this.kYp.dcA().bjY() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bjY = this.kYp.dcA().bjY();
            if (agreeData != null && bjY != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kYp.dcA().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bjY.agreeType = agreeData.agreeType;
                        bjY.hasAgree = agreeData.hasAgree;
                        bjY.diffAgreeNum = agreeData.diffAgreeNum;
                        bjY.agreeNum = agreeData.agreeNum;
                        bjY.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bjY.threadId)) {
                    bjY.agreeType = agreeData.agreeType;
                    bjY.hasAgree = agreeData.hasAgree;
                    bjY.diffAgreeNum = agreeData.diffAgreeNum;
                    bjY.agreeNum = agreeData.agreeNum;
                    bjY.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
