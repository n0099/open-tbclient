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
/* loaded from: classes21.dex */
public class as {
    private com.baidu.tieba.pb.data.f kJe;
    private boolean kPw;
    private boolean kPy;
    private int kSA;
    private String kSs;
    private boolean kSt;
    private Rect kSu;
    private boolean kSv;
    private Parcelable kSw;
    private boolean kSx;
    private PostData kSy;
    private PostData kSz;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.ddA().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.ddA().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.ddA().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.ddA().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    as.ddA().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.ddA().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.ddA().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static as kSB = new as();
    }

    public static as ddA() {
        return a.kSB;
    }

    private as() {
        this.kSs = null;
        this.kSt = false;
        this.mTabIndex = 0;
        this.kJe = null;
        this.kSv = false;
        this.kSw = null;
        this.kPy = true;
        this.kPw = false;
        this.kSx = false;
    }

    public void aR(String str, boolean z) {
        this.kSt = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.kSs = null;
        } else if (!str.equals(this.kSs)) {
            reset();
            this.kSs = str;
        } else {
            this.kSt = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.kSt) {
            this.kSv = false;
            return null;
        } else if (this.kJe != null && this.kJe.cYT() != null && this.kJe.cYT().size() > 0) {
            this.kSv = true;
            com.baidu.tieba.pb.data.f fVar = this.kJe;
            this.kJe = null;
            return fVar;
        } else {
            this.kSv = false;
            this.kJe = null;
            return null;
        }
    }

    public Parcelable ddB() {
        if (this.kSv) {
            this.kSv = false;
            Parcelable parcelable = this.kSw;
            this.kSw = null;
            return parcelable;
        }
        this.kSw = null;
        return null;
    }

    public int ddC() {
        return this.kSA;
    }

    public void ES(int i) {
        this.kSA = i;
    }

    public PostData ddD() {
        return this.kSz;
    }

    public void p(PostData postData) {
        this.kSz = postData;
    }

    public PostData ddE() {
        return this.kSy;
    }

    public void q(PostData postData) {
        this.kSy = postData;
    }

    public boolean dch() {
        return this.kPy;
    }

    public boolean ddF() {
        return this.kPw;
    }

    public boolean ddG() {
        return this.kSx;
    }

    public void h(Rect rect) {
        this.kSu = rect;
    }

    public Rect ddH() {
        return this.kSu;
    }

    public void ET(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.kSt = false;
        if (this.kSs == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.cYT() == null) {
            reset();
            return false;
        } else if (fVar.cYT().size() < 1) {
            reset();
            return false;
        } else {
            this.kJe = fVar;
            this.kSv = false;
            this.kSw = parcelable;
            this.kPy = z;
            this.kPw = z2;
            this.kSx = z3;
            return true;
        }
    }

    public void reset() {
        this.kSt = false;
        this.kJe = null;
        this.kSv = false;
        this.kSw = null;
        this.kSu = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kJe != null && this.kJe.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kJe.getForum().getId(), 0L)) {
                this.kJe.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.kJe != null && this.kJe.cYT() != null && this.kJe.cYT().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kJe.cYT().size();
                for (int i = 0; i < size; i++) {
                    if (this.kJe.cYT().get(i) != null && this.kJe.cYT().get(i).bfy() != null && currentAccount.equals(this.kJe.cYT().get(i).bfy().getUserId()) && this.kJe.cYT().get(i).bfy().getPendantData() != null) {
                        this.kJe.cYT().get(i).bfy().getPendantData().zE(mVar.bdu());
                        this.kJe.cYT().get(i).bfy().getPendantData().cZ(mVar.brU());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kJe != null && eVar != null) {
            ArrayList<PostData> cYT = this.kJe.cYT();
            if (!com.baidu.tbadk.core.util.y.isEmpty(cYT)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cYT) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bhp = postData.bhp();
                        bhp.agreeType = agreeData.agreeType;
                        bhp.hasAgree = agreeData.hasAgree;
                        bhp.diffAgreeNum = agreeData.diffAgreeNum;
                        bhp.agreeNum = agreeData.agreeNum;
                        bhp.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kJe != null && this.kJe.cYR() != null && this.kJe.cYR().bhp() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bhp = this.kJe.cYR().bhp();
            if (agreeData != null && bhp != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kJe.cYR().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bhp.agreeType = agreeData.agreeType;
                        bhp.hasAgree = agreeData.hasAgree;
                        bhp.diffAgreeNum = agreeData.diffAgreeNum;
                        bhp.agreeNum = agreeData.agreeNum;
                        bhp.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bhp.threadId)) {
                    bhp.agreeType = agreeData.agreeType;
                    bhp.hasAgree = agreeData.hasAgree;
                    bhp.diffAgreeNum = agreeData.diffAgreeNum;
                    bhp.agreeNum = agreeData.agreeNum;
                    bhp.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
