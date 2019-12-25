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
/* loaded from: classes6.dex */
public class ak {
    private boolean iEY;
    private boolean iFa;
    private String iHT;
    private boolean iHU;
    private Rect iHV;
    private boolean iHW;
    private Parcelable iHX;
    private boolean iHY;
    private PostData iHZ;
    private PostData iIa;
    private int iIb;
    private com.baidu.tieba.pb.data.f izO;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ak.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cmq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.ak.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cmq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ak.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cmq().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.ak.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ak.cmq().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    ak.cmq().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ak.cmq().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.ak.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    ak.cmq().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static ak iIc = new ak();
    }

    public static ak cmq() {
        return a.iIc;
    }

    private ak() {
        this.iHT = null;
        this.iHU = false;
        this.mTabIndex = 0;
        this.izO = null;
        this.iHW = false;
        this.iHX = null;
        this.iFa = true;
        this.iEY = false;
        this.iHY = false;
    }

    public void au(String str, boolean z) {
        this.iHU = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.iHT = null;
        } else if (!str.equals(this.iHT)) {
            reset();
            this.iHT = str;
        } else {
            this.iHU = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.iHU) {
            this.iHW = false;
            return null;
        } else if (this.izO != null && this.izO.chM() != null && this.izO.chM().size() > 0) {
            this.iHW = true;
            com.baidu.tieba.pb.data.f fVar = this.izO;
            this.izO = null;
            return fVar;
        } else {
            this.iHW = false;
            this.izO = null;
            return null;
        }
    }

    public Parcelable cmr() {
        if (this.iHW) {
            this.iHW = false;
            Parcelable parcelable = this.iHX;
            this.iHX = null;
            return parcelable;
        }
        this.iHX = null;
        return null;
    }

    public int cms() {
        return this.iIb;
    }

    public void yP(int i) {
        this.iIb = i;
    }

    public PostData cmt() {
        return this.iIa;
    }

    public void m(PostData postData) {
        this.iIa = postData;
    }

    public PostData cmu() {
        return this.iHZ;
    }

    public void n(PostData postData) {
        this.iHZ = postData;
    }

    public boolean ckV() {
        return this.iFa;
    }

    public boolean cmv() {
        return this.iEY;
    }

    public boolean cmw() {
        return this.iHY;
    }

    public void h(Rect rect) {
        this.iHV = rect;
    }

    public Rect cmx() {
        return this.iHV;
    }

    public void yQ(int i) {
        this.mTabIndex = i;
    }

    public int clU() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.iHU = false;
        if (this.iHT == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.chM() == null) {
            reset();
            return false;
        } else if (fVar.chM().size() < 1) {
            reset();
            return false;
        } else {
            this.izO = fVar;
            this.iHW = false;
            this.iHX = parcelable;
            this.iFa = z;
            this.iEY = z2;
            this.iHY = z3;
            return true;
        }
    }

    public void reset() {
        this.iHU = false;
        this.izO = null;
        this.iHW = false;
        this.iHX = null;
        this.iHV = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.izO != null && this.izO.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.izO.getForum().getId(), 0L)) {
                this.izO.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.izO != null && this.izO.chM() != null && this.izO.chM().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.izO.chM().size();
                for (int i = 0; i < size; i++) {
                    if (this.izO.chM().get(i) != null && this.izO.chM().get(i).azE() != null && currentAccount.equals(this.izO.chM().get(i).azE().getUserId()) && this.izO.chM().get(i).azE().getPendantData() != null) {
                        this.izO.chM().get(i).azE().getPendantData().sh(mVar.axX());
                        this.izO.chM().get(i).azE().getPendantData().bB(mVar.aLh());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.izO != null && eVar != null) {
            ArrayList<PostData> chM = this.izO.chM();
            if (!com.baidu.tbadk.core.util.v.isEmpty(chM)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : chM) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aBt = postData.aBt();
                        aBt.agreeType = agreeData.agreeType;
                        aBt.hasAgree = agreeData.hasAgree;
                        aBt.diffAgreeNum = agreeData.diffAgreeNum;
                        aBt.agreeNum = agreeData.agreeNum;
                        aBt.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.izO != null && this.izO.chK() != null && this.izO.chK().aBt() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aBt = this.izO.chK().aBt();
            if (agreeData != null && aBt != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.izO.chK().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        aBt.agreeType = agreeData.agreeType;
                        aBt.hasAgree = agreeData.hasAgree;
                        aBt.diffAgreeNum = agreeData.diffAgreeNum;
                        aBt.agreeNum = agreeData.agreeNum;
                        aBt.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(aBt.threadId)) {
                    aBt.agreeType = agreeData.agreeType;
                    aBt.hasAgree = agreeData.hasAgree;
                    aBt.diffAgreeNum = agreeData.diffAgreeNum;
                    aBt.agreeNum = agreeData.agreeNum;
                    aBt.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
