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
    private String lAf;
    private boolean lAg;
    private Rect lAh;
    private boolean lAi;
    private Parcelable lAj;
    private boolean lAk;
    private PostData lAl;
    private PostData lAm;
    private int lAn;
    private com.baidu.tieba.pb.data.f lqP;
    private boolean lxi;
    private boolean lxk;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmS().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmS().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dmS().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    as.dmS().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dmS().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dmS().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static as lAo = new as();
    }

    public static as dmS() {
        return a.lAo;
    }

    private as() {
        this.lAf = null;
        this.lAg = false;
        this.mTabIndex = 0;
        this.lqP = null;
        this.lAi = false;
        this.lAj = null;
        this.lxk = true;
        this.lxi = false;
        this.lAk = false;
    }

    public void aX(String str, boolean z) {
        this.lAg = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lAf = null;
        } else if (!str.equals(this.lAf)) {
            reset();
            this.lAf = str;
        } else {
            this.lAg = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lAg) {
            this.lAi = false;
            return null;
        } else if (this.lqP != null && this.lqP.dim() != null && this.lqP.dim().size() > 0) {
            this.lAi = true;
            com.baidu.tieba.pb.data.f fVar = this.lqP;
            this.lqP = null;
            return fVar;
        } else {
            this.lAi = false;
            this.lqP = null;
            return null;
        }
    }

    public Parcelable dmT() {
        if (this.lAi) {
            this.lAi = false;
            Parcelable parcelable = this.lAj;
            this.lAj = null;
            return parcelable;
        }
        this.lAj = null;
        return null;
    }

    public int dmU() {
        return this.lAn;
    }

    public void Ge(int i) {
        this.lAn = i;
    }

    public PostData dmV() {
        return this.lAm;
    }

    public void p(PostData postData) {
        this.lAm = postData;
    }

    public PostData dmW() {
        return this.lAl;
    }

    public void q(PostData postData) {
        this.lAl = postData;
    }

    public boolean dlz() {
        return this.lxk;
    }

    public boolean dmX() {
        return this.lxi;
    }

    public boolean dmY() {
        return this.lAk;
    }

    public void h(Rect rect) {
        this.lAh = rect;
    }

    public Rect dmZ() {
        return this.lAh;
    }

    public void Gf(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lAg = false;
        if (this.lAf == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dim() == null) {
            reset();
            return false;
        } else if (fVar.dim().size() < 1) {
            reset();
            return false;
        } else {
            this.lqP = fVar;
            this.lAi = false;
            this.lAj = parcelable;
            this.lxk = z;
            this.lxi = z2;
            this.lAk = z3;
            return true;
        }
    }

    public void reset() {
        this.lAg = false;
        this.lqP = null;
        this.lAi = false;
        this.lAj = null;
        this.lAh = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lqP != null && this.lqP.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lqP.getForum().getId(), 0L)) {
                this.lqP.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lqP != null && this.lqP.dim() != null && this.lqP.dim().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lqP.dim().size();
                for (int i = 0; i < size; i++) {
                    if (this.lqP.dim().get(i) != null && this.lqP.dim().get(i).bmA() != null && currentAccount.equals(this.lqP.dim().get(i).bmA().getUserId()) && this.lqP.dim().get(i).bmA().getPendantData() != null) {
                        this.lqP.dim().get(i).bmA().getPendantData().AX(mVar.bkw());
                        this.lqP.dim().get(i).bmA().getPendantData().dF(mVar.byW());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lqP != null && eVar != null) {
            ArrayList<PostData> dim = this.lqP.dim();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dim)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dim) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData bor = postData.bor();
                        bor.agreeType = agreeData.agreeType;
                        bor.hasAgree = agreeData.hasAgree;
                        bor.diffAgreeNum = agreeData.diffAgreeNum;
                        bor.agreeNum = agreeData.agreeNum;
                        bor.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lqP != null && this.lqP.dik() != null && this.lqP.dik().bor() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bor = this.lqP.dik().bor();
            if (agreeData != null && bor != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lqP.dik().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        bor.agreeType = agreeData.agreeType;
                        bor.hasAgree = agreeData.hasAgree;
                        bor.diffAgreeNum = agreeData.diffAgreeNum;
                        bor.agreeNum = agreeData.agreeNum;
                        bor.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(bor.threadId)) {
                    bor.agreeType = agreeData.agreeType;
                    bor.hasAgree = agreeData.hasAgree;
                    bor.diffAgreeNum = agreeData.diffAgreeNum;
                    bor.agreeNum = agreeData.agreeNum;
                    bor.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
