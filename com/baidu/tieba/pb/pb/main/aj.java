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
    private boolean hsf;
    private boolean hsh;
    private com.baidu.tieba.pb.data.d hsw;
    private String hvd;
    private boolean hve;
    private boolean hvf;
    private Parcelable hvg;
    private boolean hvh;
    private PostData hvi;
    private PostData hvj;
    private int hvk;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMb().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMb().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMb().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bMb().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bMb().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bMb().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bMb().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hvl = new aj();
    }

    public static aj bMb() {
        return a.hvl;
    }

    private aj() {
        this.hvd = null;
        this.hve = false;
        this.hsw = null;
        this.hvf = false;
        this.hvg = null;
        this.hsh = true;
        this.hsf = false;
        this.hvh = false;
    }

    public void ao(String str, boolean z) {
        this.hve = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hvd = null;
        } else if (!str.equals(this.hvd)) {
            reset();
            this.hvd = str;
        } else {
            this.hve = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hve) {
            this.hvf = false;
            return null;
        } else if (this.hsw != null && this.hsw.bIc() != null && this.hsw.bIc().size() > 0) {
            this.hvf = true;
            com.baidu.tieba.pb.data.d dVar = this.hsw;
            this.hsw = null;
            return dVar;
        } else {
            this.hvf = false;
            this.hsw = null;
            return null;
        }
    }

    public Parcelable bMc() {
        if (this.hvf) {
            this.hvf = false;
            Parcelable parcelable = this.hvg;
            this.hvg = null;
            return parcelable;
        }
        this.hvg = null;
        return null;
    }

    public int bMd() {
        return this.hvk;
    }

    public void ww(int i) {
        this.hvk = i;
    }

    public PostData bMe() {
        return this.hvj;
    }

    public void k(PostData postData) {
        this.hvj = postData;
    }

    public PostData bMf() {
        return this.hvi;
    }

    public void l(PostData postData) {
        this.hvi = postData;
    }

    public boolean bKT() {
        return this.hsh;
    }

    public boolean bMg() {
        return this.hsf;
    }

    public boolean bMh() {
        return this.hvh;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hve = false;
        if (this.hvd == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bIc() == null) {
            reset();
            return false;
        } else if (dVar.bIc().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hsw = dVar;
            this.hvf = false;
            this.hvg = parcelable;
            this.hsh = z;
            this.hsf = z2;
            this.hvh = z3;
            return true;
        }
    }

    public void reset() {
        this.hve = false;
        this.hsw = null;
        this.hvf = false;
        this.hvg = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hsw != null && this.hsw.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.hsw.getForum().getId(), 0L)) {
                this.hsw.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hsw != null && this.hsw.bIc() != null && this.hsw.bIc().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hsw.bIc().size();
                for (int i = 0; i < size; i++) {
                    if (this.hsw.bIc().get(i) != null && this.hsw.bIc().get(i).YR() != null && currentAccount.equals(this.hsw.bIc().get(i).YR().getUserId()) && this.hsw.bIc().get(i).YR().getPendantData() != null) {
                        this.hsw.bIc().get(i).YR().getPendantData().lf(lVar.Xn());
                        this.hsw.bIc().get(i).YR().getPendantData().aR(lVar.aly());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hsw != null && eVar != null) {
            ArrayList<PostData> bIc = this.hsw.bIc();
            if (!com.baidu.tbadk.core.util.v.T(bIc)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bIc) {
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
        if (this.hsw != null && this.hsw.bIa() != null && this.hsw.bIa().aaH() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData aaH = this.hsw.bIa().aaH();
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
