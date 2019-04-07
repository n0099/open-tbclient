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
    private boolean hrL;
    private boolean hrN;
    private com.baidu.tieba.pb.data.d hsc;
    private String huJ;
    private boolean huK;
    private boolean huL;
    private Parcelable huM;
    private boolean huN;
    private PostData huO;
    private PostData huP;
    private int huQ;

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
        private static aj huR = new aj();
    }

    public static aj bLX() {
        return a.huR;
    }

    private aj() {
        this.huJ = null;
        this.huK = false;
        this.hsc = null;
        this.huL = false;
        this.huM = null;
        this.hrN = true;
        this.hrL = false;
        this.huN = false;
    }

    public void ao(String str, boolean z) {
        this.huK = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.huJ = null;
        } else if (!str.equals(this.huJ)) {
            reset();
            this.huJ = str;
        } else {
            this.huK = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.huK) {
            this.huL = false;
            return null;
        } else if (this.hsc != null && this.hsc.bHY() != null && this.hsc.bHY().size() > 0) {
            this.huL = true;
            com.baidu.tieba.pb.data.d dVar = this.hsc;
            this.hsc = null;
            return dVar;
        } else {
            this.huL = false;
            this.hsc = null;
            return null;
        }
    }

    public Parcelable bLY() {
        if (this.huL) {
            this.huL = false;
            Parcelable parcelable = this.huM;
            this.huM = null;
            return parcelable;
        }
        this.huM = null;
        return null;
    }

    public int bLZ() {
        return this.huQ;
    }

    public void ws(int i) {
        this.huQ = i;
    }

    public PostData bMa() {
        return this.huP;
    }

    public void k(PostData postData) {
        this.huP = postData;
    }

    public PostData bMb() {
        return this.huO;
    }

    public void l(PostData postData) {
        this.huO = postData;
    }

    public boolean bKP() {
        return this.hrN;
    }

    public boolean bMc() {
        return this.hrL;
    }

    public boolean bMd() {
        return this.huN;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.huK = false;
        if (this.huJ == null) {
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
            this.hsc = dVar;
            this.huL = false;
            this.huM = parcelable;
            this.hrN = z;
            this.hrL = z2;
            this.huN = z3;
            return true;
        }
    }

    public void reset() {
        this.huK = false;
        this.hsc = null;
        this.huL = false;
        this.huM = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hsc != null && this.hsc.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.hsc.getForum().getId(), 0L)) {
                this.hsc.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsc != null && this.hsc.bHY() != null && this.hsc.bHY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsc.bHY().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsc.bHY().get(i) != null && this.hsc.bHY().get(i).YO() != null && currentAccount.equals(this.hsc.bHY().get(i).YO().getUserId()) && this.hsc.bHY().get(i).YO().getPendantData() != null) {
                        this.hsc.bHY().get(i).YO().getPendantData().lg(lVar.Xk());
                        this.hsc.bHY().get(i).YO().getPendantData().aR(lVar.alu());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsc != null && eVar != null) {
            ArrayList<PostData> bHY = this.hsc.bHY();
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
        if (this.hsc != null && this.hsc.bHW() != null && this.hsc.bHW().aaE() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aaE = this.hsc.bHW().aaE();
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
