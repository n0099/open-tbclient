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
    private com.baidu.tieba.pb.data.f kAH;
    private boolean kGW;
    private boolean kGY;
    private String kJS;
    private boolean kJT;
    private Rect kJU;
    private boolean kJV;
    private Parcelable kJW;
    private boolean kJX;
    private PostData kJY;
    private PostData kJZ;
    private int kKa;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZX().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.cZX().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    as.cZX().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cZX().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.cZX().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        private static as kKb = new as();
    }

    public static as cZX() {
        return a.kKb;
    }

    private as() {
        this.kJS = null;
        this.kJT = false;
        this.mTabIndex = 0;
        this.kAH = null;
        this.kJV = false;
        this.kJW = null;
        this.kGY = true;
        this.kGW = false;
        this.kJX = false;
    }

    public void aR(String str, boolean z) {
        this.kJT = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.kJS = null;
        } else if (!str.equals(this.kJS)) {
            reset();
            this.kJS = str;
        } else {
            this.kJT = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.kJT) {
            this.kJV = false;
            return null;
        } else if (this.kAH != null && this.kAH.cVo() != null && this.kAH.cVo().size() > 0) {
            this.kJV = true;
            com.baidu.tieba.pb.data.f fVar = this.kAH;
            this.kAH = null;
            return fVar;
        } else {
            this.kJV = false;
            this.kAH = null;
            return null;
        }
    }

    public Parcelable cZY() {
        if (this.kJV) {
            this.kJV = false;
            Parcelable parcelable = this.kJW;
            this.kJW = null;
            return parcelable;
        }
        this.kJW = null;
        return null;
    }

    public int cZZ() {
        return this.kKa;
    }

    public void Er(int i) {
        this.kKa = i;
    }

    public PostData daa() {
        return this.kJZ;
    }

    public void p(PostData postData) {
        this.kJZ = postData;
    }

    public PostData dab() {
        return this.kJY;
    }

    public void q(PostData postData) {
        this.kJY = postData;
    }

    public boolean cYE() {
        return this.kGY;
    }

    public boolean dac() {
        return this.kGW;
    }

    public boolean dad() {
        return this.kJX;
    }

    public void h(Rect rect) {
        this.kJU = rect;
    }

    public Rect dae() {
        return this.kJU;
    }

    public void Es(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.kJT = false;
        if (this.kJS == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.cVo() == null) {
            reset();
            return false;
        } else if (fVar.cVo().size() < 1) {
            reset();
            return false;
        } else {
            this.kAH = fVar;
            this.kJV = false;
            this.kJW = parcelable;
            this.kGY = z;
            this.kGW = z2;
            this.kJX = z3;
            return true;
        }
    }

    public void reset() {
        this.kJT = false;
        this.kAH = null;
        this.kJV = false;
        this.kJW = null;
        this.kJU = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.kAH != null && this.kAH.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.kAH.getForum().getId(), 0L)) {
                this.kAH.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.kAH != null && this.kAH.cVo() != null && this.kAH.cVo().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.kAH.cVo().size();
                for (int i = 0; i < size; i++) {
                    if (this.kAH.cVo().get(i) != null && this.kAH.cVo().get(i).beE() != null && currentAccount.equals(this.kAH.cVo().get(i).beE().getUserId()) && this.kAH.cVo().get(i).beE().getPendantData() != null) {
                        this.kAH.cVo().get(i).beE().getPendantData().zj(lVar.bcA());
                        this.kAH.cVo().get(i).beE().getPendantData().cY(lVar.bra());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.kAH != null && eVar != null) {
            ArrayList<PostData> cVo = this.kAH.cVo();
            if (!com.baidu.tbadk.core.util.y.isEmpty(cVo)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : cVo) {
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
        if (this.kAH != null && this.kAH.cVm() != null && this.kAH.cVm().bgv() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData bgv = this.kAH.cVm().bgv();
            if (agreeData != null && bgv != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.kAH.cVm().getBaijiahaoData();
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
