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
    private com.baidu.tieba.pb.data.f lkO;
    private boolean lrl;
    private boolean lrn;
    private String lui;
    private boolean luj;
    private Rect luk;
    private boolean lul;
    private Parcelable lum;
    private boolean lun;
    private PostData luo;
    private PostData lup;
    private int luq;
    private int mTabIndex;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dkq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dkq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dkq().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.as.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as.dkq().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.as.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                    as.dkq().updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.as.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dkq().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.as.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    as.dkq().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static as lur = new as();
    }

    public static as dkq() {
        return a.lur;
    }

    private as() {
        this.lui = null;
        this.luj = false;
        this.mTabIndex = 0;
        this.lkO = null;
        this.lul = false;
        this.lum = null;
        this.lrn = true;
        this.lrl = false;
        this.lun = false;
    }

    public void aX(String str, boolean z) {
        this.luj = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.lui = null;
        } else if (!str.equals(this.lui)) {
            reset();
            this.lui = str;
        } else {
            this.luj = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.luj) {
            this.lul = false;
            return null;
        } else if (this.lkO != null && this.lkO.dfK() != null && this.lkO.dfK().size() > 0) {
            this.lul = true;
            com.baidu.tieba.pb.data.f fVar = this.lkO;
            this.lkO = null;
            return fVar;
        } else {
            this.lul = false;
            this.lkO = null;
            return null;
        }
    }

    public Parcelable dkr() {
        if (this.lul) {
            this.lul = false;
            Parcelable parcelable = this.lum;
            this.lum = null;
            return parcelable;
        }
        this.lum = null;
        return null;
    }

    public int dks() {
        return this.luq;
    }

    public void FR(int i) {
        this.luq = i;
    }

    public PostData dkt() {
        return this.lup;
    }

    public void p(PostData postData) {
        this.lup = postData;
    }

    public PostData dku() {
        return this.luo;
    }

    public void q(PostData postData) {
        this.luo = postData;
    }

    public boolean diX() {
        return this.lrn;
    }

    public boolean dkv() {
        return this.lrl;
    }

    public boolean dkw() {
        return this.lun;
    }

    public void h(Rect rect) {
        this.luk = rect;
    }

    public Rect dkx() {
        return this.luk;
    }

    public void FS(int i) {
        this.mTabIndex = i;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.luj = false;
        if (this.lui == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.dfK() == null) {
            reset();
            return false;
        } else if (fVar.dfK().size() < 1) {
            reset();
            return false;
        } else {
            this.lkO = fVar;
            this.lul = false;
            this.lum = parcelable;
            this.lrn = z;
            this.lrl = z2;
            this.lun = z3;
            return true;
        }
    }

    public void reset() {
        this.luj = false;
        this.lkO = null;
        this.lul = false;
        this.lum = null;
        this.luk = null;
        this.mTabIndex = 0;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.lkO != null && this.lkO.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.f.b.toLong(this.lkO.getForum().getId(), 0L)) {
                this.lkO.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (mVar != null && this.lkO != null && this.lkO.dfK() != null && this.lkO.dfK().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.lkO.dfK().size();
                for (int i = 0; i < size; i++) {
                    if (this.lkO.dfK().get(i) != null && this.lkO.dfK().get(i).bka() != null && currentAccount.equals(this.lkO.dfK().get(i).bka().getUserId()) && this.lkO.dfK().get(i).bka().getPendantData() != null) {
                        this.lkO.dfK().get(i).bka().getPendantData().AJ(mVar.bhW());
                        this.lkO.dfK().get(i).bka().getPendantData().dj(mVar.bwx());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lkO != null && eVar != null) {
            ArrayList<PostData> dfK = this.lkO.dfK();
            if (!com.baidu.tbadk.core.util.y.isEmpty(dfK)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : dfK) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData blR = postData.blR();
                        blR.agreeType = agreeData.agreeType;
                        blR.hasAgree = agreeData.hasAgree;
                        blR.diffAgreeNum = agreeData.diffAgreeNum;
                        blR.agreeNum = agreeData.agreeNum;
                        blR.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.lkO != null && this.lkO.dfI() != null && this.lkO.dfI().blR() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData blR = this.lkO.dfI().blR();
            if (agreeData != null && blR != null) {
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.lkO.dfI().getBaijiahaoData();
                    if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        blR.agreeType = agreeData.agreeType;
                        blR.hasAgree = agreeData.hasAgree;
                        blR.diffAgreeNum = agreeData.diffAgreeNum;
                        blR.agreeNum = agreeData.agreeNum;
                        blR.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                    return;
                }
                String str2 = agreeData.threadId;
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && str2.equals(blR.threadId)) {
                    blR.agreeType = agreeData.agreeType;
                    blR.hasAgree = agreeData.hasAgree;
                    blR.diffAgreeNum = agreeData.diffAgreeNum;
                    blR.agreeNum = agreeData.agreeNum;
                    blR.disAgreeNum = agreeData.disAgreeNum;
                }
            }
        }
    }
}
