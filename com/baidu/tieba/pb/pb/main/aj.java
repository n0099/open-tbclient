package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class aj {
    private boolean hPH;
    private boolean hPJ;
    private com.baidu.tieba.pb.data.d hPY;
    private String hSD;
    private boolean hSE;
    private boolean hSF;
    private Parcelable hSG;
    private boolean hSH;
    private PostData hSI;
    private PostData hSJ;
    private int hSK;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWF().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWF().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWF().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bWF().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bWF().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bWF().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bWF().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hSL = new aj();
    }

    public static aj bWF() {
        return a.hSL;
    }

    private aj() {
        this.hSD = null;
        this.hSE = false;
        this.hPY = null;
        this.hSF = false;
        this.hSG = null;
        this.hPJ = true;
        this.hPH = false;
        this.hSH = false;
    }

    public void au(String str, boolean z) {
        this.hSE = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hSD = null;
        } else if (!str.equals(this.hSD)) {
            reset();
            this.hSD = str;
        } else {
            this.hSE = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hSE) {
            this.hSF = false;
            return null;
        } else if (this.hPY != null && this.hPY.bSz() != null && this.hPY.bSz().size() > 0) {
            this.hSF = true;
            com.baidu.tieba.pb.data.d dVar = this.hPY;
            this.hPY = null;
            return dVar;
        } else {
            this.hSF = false;
            this.hPY = null;
            return null;
        }
    }

    public Parcelable bWG() {
        if (this.hSF) {
            this.hSF = false;
            Parcelable parcelable = this.hSG;
            this.hSG = null;
            return parcelable;
        }
        this.hSG = null;
        return null;
    }

    public int bWH() {
        return this.hSK;
    }

    public void yc(int i) {
        this.hSK = i;
    }

    public PostData bWI() {
        return this.hSJ;
    }

    public void k(PostData postData) {
        this.hSJ = postData;
    }

    public PostData bWJ() {
        return this.hSI;
    }

    public void l(PostData postData) {
        this.hSI = postData;
    }

    public boolean bVw() {
        return this.hPJ;
    }

    public boolean bWK() {
        return this.hPH;
    }

    public boolean bWL() {
        return this.hSH;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hSE = false;
        if (this.hSD == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bSz() == null) {
            reset();
            return false;
        } else if (dVar.bSz().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hPY = dVar;
            this.hSF = false;
            this.hSG = parcelable;
            this.hPJ = z;
            this.hPH = z2;
            this.hSH = z3;
            return true;
        }
    }

    public void reset() {
        this.hSE = false;
        this.hPY = null;
        this.hSF = false;
        this.hSG = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hPY != null && this.hPY.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.hPY.getForum().getId(), 0L)) {
                this.hPY.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hPY != null && this.hPY.bSz() != null && this.hPY.bSz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hPY.bSz().size();
                for (int i = 0; i < size; i++) {
                    if (this.hPY.bSz().get(i) != null && this.hPY.bSz().get(i).aex() != null && currentAccount.equals(this.hPY.bSz().get(i).aex().getUserId()) && this.hPY.bSz().get(i).aex().getPendantData() != null) {
                        this.hPY.bSz().get(i).aex().getPendantData().mv(lVar.acU());
                        this.hPY.bSz().get(i).aex().getPendantData().bh(lVar.arC());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hPY != null && eVar != null) {
            ArrayList<PostData> bSz = this.hPY.bSz();
            if (!com.baidu.tbadk.core.util.v.aa(bSz)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bSz) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData agn = postData.agn();
                        agn.agreeType = agreeData.agreeType;
                        agn.hasAgree = agreeData.hasAgree;
                        agn.diffAgreeNum = agreeData.diffAgreeNum;
                        agn.agreeNum = agreeData.agreeNum;
                        agn.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hPY != null && this.hPY.bSx() != null && this.hPY.bSx().agn() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData agn = this.hPY.bSx().agn();
            if (!TextUtils.isEmpty(agn.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && agn.threadId.equals(agreeData.threadId)) {
                agn.agreeType = agreeData.agreeType;
                agn.hasAgree = agreeData.hasAgree;
                agn.diffAgreeNum = agreeData.diffAgreeNum;
                agn.agreeNum = agreeData.agreeNum;
                agn.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
