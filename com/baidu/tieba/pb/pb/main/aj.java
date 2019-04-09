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
    private boolean hrM;
    private boolean hrO;
    private com.baidu.tieba.pb.data.d hsd;
    private String huK;
    private boolean huL;
    private boolean huM;
    private Parcelable huN;
    private boolean huO;
    private PostData huP;
    private PostData huQ;
    private int huR;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bLX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bLX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bLX().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bLX().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bLX().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bLX().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bLX().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj huS = new aj();
    }

    public static aj bLX() {
        return a.huS;
    }

    private aj() {
        this.huK = null;
        this.huL = false;
        this.hsd = null;
        this.huM = false;
        this.huN = null;
        this.hrO = true;
        this.hrM = false;
        this.huO = false;
    }

    public void ao(String str, boolean z) {
        this.huL = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.huK = null;
        } else if (!str.equals(this.huK)) {
            reset();
            this.huK = str;
        } else {
            this.huL = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.huL) {
            this.huM = false;
            return null;
        } else if (this.hsd != null && this.hsd.bHY() != null && this.hsd.bHY().size() > 0) {
            this.huM = true;
            com.baidu.tieba.pb.data.d dVar = this.hsd;
            this.hsd = null;
            return dVar;
        } else {
            this.huM = false;
            this.hsd = null;
            return null;
        }
    }

    public Parcelable bLY() {
        if (this.huM) {
            this.huM = false;
            Parcelable parcelable = this.huN;
            this.huN = null;
            return parcelable;
        }
        this.huN = null;
        return null;
    }

    public int bLZ() {
        return this.huR;
    }

    public void ws(int i) {
        this.huR = i;
    }

    public PostData bMa() {
        return this.huQ;
    }

    public void k(PostData postData) {
        this.huQ = postData;
    }

    public PostData bMb() {
        return this.huP;
    }

    public void l(PostData postData) {
        this.huP = postData;
    }

    public boolean bKP() {
        return this.hrO;
    }

    public boolean bMc() {
        return this.hrM;
    }

    public boolean bMd() {
        return this.huO;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.huL = false;
        if (this.huK == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bHY() == null) {
            reset();
            return false;
        } else if (dVar.bHY().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hsd = dVar;
            this.huM = false;
            this.huN = parcelable;
            this.hrO = z;
            this.hrM = z2;
            this.huO = z3;
            return true;
        }
    }

    public void reset() {
        this.huL = false;
        this.hsd = null;
        this.huM = false;
        this.huN = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hsd != null && this.hsd.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.hsd.getForum().getId(), 0L)) {
                this.hsd.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsd != null && this.hsd.bHY() != null && this.hsd.bHY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsd.bHY().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsd.bHY().get(i) != null && this.hsd.bHY().get(i).YO() != null && currentAccount.equals(this.hsd.bHY().get(i).YO().getUserId()) && this.hsd.bHY().get(i).YO().getPendantData() != null) {
                        this.hsd.bHY().get(i).YO().getPendantData().lg(lVar.Xk());
                        this.hsd.bHY().get(i).YO().getPendantData().aR(lVar.alu());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsd != null && eVar != null) {
            ArrayList<PostData> bHY = this.hsd.bHY();
            if (!com.baidu.tbadk.core.util.v.T(bHY)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bHY) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aaE = postData.aaE();
                        aaE.agreeType = agreeData.agreeType;
                        aaE.hasAgree = agreeData.hasAgree;
                        aaE.diffAgreeNum = agreeData.diffAgreeNum;
                        aaE.agreeNum = agreeData.agreeNum;
                        aaE.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsd != null && this.hsd.bHW() != null && this.hsd.bHW().aaE() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aaE = this.hsd.bHW().aaE();
            if (!TextUtils.isEmpty(aaE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && aaE.threadId.equals(agreeData.threadId)) {
                aaE.agreeType = agreeData.agreeType;
                aaE.hasAgree = agreeData.hasAgree;
                aaE.diffAgreeNum = agreeData.diffAgreeNum;
                aaE.agreeNum = agreeData.agreeNum;
                aaE.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
