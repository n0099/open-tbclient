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
    private com.baidu.tieba.pb.data.f lKf;
    private boolean lQB;
    private boolean lQD;
    private boolean lTA;
    private Rect lTB;
    private boolean lTC;
    private Parcelable lTD;
    private boolean lTE;
    private PostData lTF;
    private PostData lTG;
    private int lTH;
    private String lTz;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drv().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drv().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drv().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.drv().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                    aj.drv().updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.drv().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.drv().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj lTI = new aj();
    }

    public static aj drv() {
        return a.lTI;
    }

    private aj() {
        this.lTz = null;
        this.lTA = false;
        this.mTabIndex = 0;
        this.lKf = null;
        this.lTC = false;
        this.lTD = null;
        this.lQD = true;
        this.lQB = false;
        this.lTE = false;
    }

    public void aY(String str, boolean z) {
        this.lTA = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lTz = null;
        } else if (!str.equals(this.lTz)) {
            reset();
            this.lTz = str;
        } else {
            this.lTA = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.lTA) {
            this.lTC = false;
            return null;
        } else if (this.lKf != null && this.lKf.dmG() != null && this.lKf.dmG().size() > 0) {
            this.lTC = true;
            com.baidu.tieba.pb.data.f fVar = this.lKf;
            this.lKf = null;
            return fVar;
        } else {
            this.lTC = false;
            this.lKf = null;
            return null;
        }
    }

    public Parcelable drw() {
        if (this.lTC) {
            this.lTC = false;
            Parcelable parcelable = this.lTD;
            this.lTD = null;
            return parcelable;
        }
        this.lTD = null;
        return null;
    }

    public int drx() {
        return this.lTH;
    }

    public void Hl(int i) {
        this.lTH = i;
    }

    public PostData dry() {
        return this.lTG;
    }

    public void p(PostData postData) {
        this.lTG = postData;
    }

    public PostData drz() {
        return this.lTF;
    }

    public void q(PostData postData) {
        this.lTF = postData;
    }

    public boolean dpY() {
        return this.lQD;
    }

    public boolean drA() {
        return this.lQB;
    }

    public boolean drB() {
        return this.lTE;
    }

    public void g(Rect rect) {
        this.lTB = rect;
    }

    public Rect drC() {
        return this.lTB;
    }

    public void Hm(int i) {
        this.mTabIndex = i;
    }

    public int dqV() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.lTA = false;
        if (this.lTz == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dmG() == null) {
            reset();
            return false;
        } else if (fVar.dmG().size() < 1) {
            reset();
            return false;
        } else {
            this.lKf = fVar;
            this.lTC = false;
            this.lTD = parcelable;
            this.lQD = z;
            this.lQB = z2;
            this.lTE = z3;
            return true;
        }
    }

    public void reset() {
        this.lTA = false;
        this.lKf = null;
        this.lTC = false;
        this.lTD = null;
        this.lTB = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lKf != null && this.lKf.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lKf.getForum().getId(), 0L)) {
                this.lKf.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.n nVar) {
        if (nVar != null && this.lKf != null && this.lKf.dmG() != null && this.lKf.dmG().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lKf.dmG().size();
                for (int i = 0; i < size; i++) {
                    if (this.lKf.dmG().get(i) != null && this.lKf.dmG().get(i).brq() != null && currentAccount.equals(this.lKf.dmG().get(i).brq().getUserId()) && this.lKf.dmG().get(i).brq().getPendantData() != null) {
                        this.lKf.dmG().get(i).brq().getPendantData().AY(nVar.getImgUrl());
                        this.lKf.dmG().get(i).brq().getPendantData().ee(nVar.bEh());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lKf != null && eVar != null) {
            ArrayList<PostData> dmG = this.lKf.dmG();
            if (!com.baidu.tbadk.core.util.x.isEmpty(dmG)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dmG) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData btk = postData.btk();
                        btk.agreeType = agreeData.agreeType;
                        btk.hasAgree = agreeData.hasAgree;
                        btk.diffAgreeNum = agreeData.diffAgreeNum;
                        btk.agreeNum = agreeData.agreeNum;
                        btk.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lKf != null && this.lKf.dmE() != null && this.lKf.dmE().btk() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData btk = this.lKf.dmE().btk();
            if (agreeData != null && btk != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lKf.dmE().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        btk.agreeType = agreeData.agreeType;
                        btk.hasAgree = agreeData.hasAgree;
                        btk.diffAgreeNum = agreeData.diffAgreeNum;
                        btk.agreeNum = agreeData.agreeNum;
                        btk.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(btk.threadId)) {
                    btk.agreeType = agreeData.agreeType;
                    btk.hasAgree = agreeData.hasAgree;
                    btk.diffAgreeNum = agreeData.diffAgreeNum;
                    btk.agreeNum = agreeData.agreeNum;
                    btk.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
