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
    private boolean hrY;
    private boolean hsa;
    private com.baidu.tieba.pb.data.d hsp;
    private String huW;
    private boolean huX;
    private boolean huY;
    private Parcelable huZ;
    private boolean hva;
    private PostData hvb;
    private PostData hvc;
    private int hvd;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMa().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMa().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMa().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMa().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bMa().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bMa().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bMa().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hve = new aj();
    }

    public static aj bMa() {
        return a.hve;
    }

    private aj() {
        this.huW = null;
        this.huX = false;
        this.hsp = null;
        this.huY = false;
        this.huZ = null;
        this.hsa = true;
        this.hrY = false;
        this.hva = false;
    }

    public void ao(String str, boolean z) {
        this.huX = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.huW = null;
        } else if (!str.equals(this.huW)) {
            reset();
            this.huW = str;
        } else {
            this.huX = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.huX) {
            this.huY = false;
            return null;
        } else if (this.hsp != null && this.hsp.bIb() != null && this.hsp.bIb().size() > 0) {
            this.huY = true;
            com.baidu.tieba.pb.data.d dVar = this.hsp;
            this.hsp = null;
            return dVar;
        } else {
            this.huY = false;
            this.hsp = null;
            return null;
        }
    }

    public Parcelable bMb() {
        if (this.huY) {
            this.huY = false;
            Parcelable parcelable = this.huZ;
            this.huZ = null;
            return parcelable;
        }
        this.huZ = null;
        return null;
    }

    public int bMc() {
        return this.hvd;
    }

    public void ww(int i) {
        this.hvd = i;
    }

    public PostData bMd() {
        return this.hvc;
    }

    public void k(PostData postData) {
        this.hvc = postData;
    }

    public PostData bMe() {
        return this.hvb;
    }

    public void l(PostData postData) {
        this.hvb = postData;
    }

    public boolean bKS() {
        return this.hsa;
    }

    public boolean bMf() {
        return this.hrY;
    }

    public boolean bMg() {
        return this.hva;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.huX = false;
        if (this.huW == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bIb() == null) {
            reset();
            return false;
        } else if (dVar.bIb().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hsp = dVar;
            this.huY = false;
            this.huZ = parcelable;
            this.hsa = z;
            this.hrY = z2;
            this.hva = z3;
            return true;
        }
    }

    public void reset() {
        this.huX = false;
        this.hsp = null;
        this.huY = false;
        this.huZ = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hsp != null && this.hsp.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.hsp.getForum().getId(), 0L)) {
                this.hsp.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsp != null && this.hsp.bIb() != null && this.hsp.bIb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsp.bIb().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsp.bIb().get(i) != null && this.hsp.bIb().get(i).YR() != null && currentAccount.equals(this.hsp.bIb().get(i).YR().getUserId()) && this.hsp.bIb().get(i).YR().getPendantData() != null) {
                        this.hsp.bIb().get(i).YR().getPendantData().lf(lVar.Xn());
                        this.hsp.bIb().get(i).YR().getPendantData().aR(lVar.alx());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsp != null && eVar != null) {
            ArrayList<PostData> bIb = this.hsp.bIb();
            if (!com.baidu.tbadk.core.util.v.T(bIb)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bIb) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData aaH = postData.aaH();
                        aaH.agreeType = agreeData.agreeType;
                        aaH.hasAgree = agreeData.hasAgree;
                        aaH.diffAgreeNum = agreeData.diffAgreeNum;
                        aaH.agreeNum = agreeData.agreeNum;
                        aaH.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsp != null && this.hsp.bHZ() != null && this.hsp.bHZ().aaH() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aaH = this.hsp.bHZ().aaH();
            if (!TextUtils.isEmpty(aaH.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && aaH.threadId.equals(agreeData.threadId)) {
                aaH.agreeType = agreeData.agreeType;
                aaH.hasAgree = agreeData.hasAgree;
                aaH.diffAgreeNum = agreeData.diffAgreeNum;
                aaH.agreeNum = agreeData.agreeNum;
                aaH.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
