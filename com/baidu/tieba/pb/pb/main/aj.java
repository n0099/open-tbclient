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
/* loaded from: classes2.dex */
public class aj {
    private com.baidu.tieba.pb.data.f lKe;
    private boolean lQA;
    private boolean lQC;
    private Rect lTA;
    private boolean lTB;
    private Parcelable lTC;
    private boolean lTD;
    private PostData lTE;
    private PostData lTF;
    private int lTG;
    private String lTy;
    private boolean lTz;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drw().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drw().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drw().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drw().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.drw().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.drw().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.drw().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj lTH = new aj();
    }

    public static aj drw() {
        return a.lTH;
    }

    private aj() {
        this.lTy = null;
        this.lTz = false;
        this.mTabIndex = 0;
        this.lKe = null;
        this.lTB = false;
        this.lTC = null;
        this.lQC = true;
        this.lQA = false;
        this.lTD = false;
    }

    public void aY(String str, boolean z) {
        this.lTz = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lTy = null;
        } else if (!str.equals(this.lTy)) {
            reset();
            this.lTy = str;
        } else {
            this.lTz = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lTz) {
            this.lTB = false;
            return null;
        } else if (this.lKe != null && this.lKe.dmH() != null && this.lKe.dmH().size() > 0) {
            this.lTB = true;
            com.baidu.tieba.pb.data.f fVar = this.lKe;
            this.lKe = null;
            return fVar;
        } else {
            this.lTB = false;
            this.lKe = null;
            return null;
        }
    }

    public Parcelable drx() {
        if (this.lTB) {
            this.lTB = false;
            Parcelable parcelable = this.lTC;
            this.lTC = null;
            return parcelable;
        }
        this.lTC = null;
        return null;
    }

    public int dry() {
        return this.lTG;
    }

    public void Hl(int i) {
        this.lTG = i;
    }

    public PostData drz() {
        return this.lTF;
    }

    public void p(PostData postData) {
        this.lTF = postData;
    }

    public PostData drA() {
        return this.lTE;
    }

    public void q(PostData postData) {
        this.lTE = postData;
    }

    public boolean dpZ() {
        return this.lQC;
    }

    public boolean drB() {
        return this.lQA;
    }

    public boolean drC() {
        return this.lTD;
    }

    public void g(Rect rect) {
        this.lTA = rect;
    }

    public Rect drD() {
        return this.lTA;
    }

    public void Hm(int i) {
        this.mTabIndex = i;
    }

    public int dqW() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lTz = false;
        if (this.lTy == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dmH() == null) {
            reset();
            return false;
        } else if (fVar.dmH().size() < 1) {
            reset();
            return false;
        } else {
            this.lKe = fVar;
            this.lTB = false;
            this.lTC = parcelable;
            this.lQC = z;
            this.lQA = z2;
            this.lTD = z3;
            return true;
        }
    }

    public void reset() {
        this.lTz = false;
        this.lKe = null;
        this.lTB = false;
        this.lTC = null;
        this.lTA = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lKe != null && this.lKe.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lKe.getForum().getId(), 0L)) {
                this.lKe.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lKe != null && this.lKe.dmH() != null && this.lKe.dmH().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lKe.dmH().size();
                for (int i = 0; i < size; i++) {
                    if (this.lKe.dmH().get(i) != null && this.lKe.dmH().get(i).brr() != null && currentAccount.equals(this.lKe.dmH().get(i).brr().getUserId()) && this.lKe.dmH().get(i).brr().getPendantData() != null) {
                        this.lKe.dmH().get(i).brr().getPendantData().AX(nVar.getImgUrl());
                        this.lKe.dmH().get(i).brr().getPendantData().ee(nVar.bEi());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lKe != null && eVar != null) {
            ArrayList<PostData> dmH = this.lKe.dmH();
            if (!com.baidu.tbadk.core.util.x.isEmpty(dmH)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dmH) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData btl = postData.btl();
                        btl.agreeType = agreeData.agreeType;
                        btl.hasAgree = agreeData.hasAgree;
                        btl.diffAgreeNum = agreeData.diffAgreeNum;
                        btl.agreeNum = agreeData.agreeNum;
                        btl.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lKe != null && this.lKe.dmF() != null && this.lKe.dmF().btl() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData btl = this.lKe.dmF().btl();
            if (agreeData != null && btl != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lKe.dmF().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        btl.agreeType = agreeData.agreeType;
                        btl.hasAgree = agreeData.hasAgree;
                        btl.diffAgreeNum = agreeData.diffAgreeNum;
                        btl.agreeNum = agreeData.agreeNum;
                        btl.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(btl.threadId)) {
                    btl.agreeType = agreeData.agreeType;
                    btl.hasAgree = agreeData.hasAgree;
                    btl.diffAgreeNum = agreeData.diffAgreeNum;
                    btl.agreeNum = agreeData.agreeNum;
                    btl.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
