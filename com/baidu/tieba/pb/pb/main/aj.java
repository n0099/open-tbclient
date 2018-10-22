package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class aj {
    private boolean fPP;
    private boolean fPR;
    private com.baidu.tieba.pb.data.d fQf;
    private String fSI;
    private boolean fSJ;
    private boolean fSK;
    private Parcelable fSL;
    private boolean fSM;
    private PostData fSN;
    private PostData fSO;
    private int fSP;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biX().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biX().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    aj.biX().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static aj fSQ = new aj();
    }

    public static aj biX() {
        return a.fSQ;
    }

    private aj() {
        this.fSI = null;
        this.fSJ = false;
        this.fQf = null;
        this.fSK = false;
        this.fSL = null;
        this.fPR = true;
        this.fPP = false;
        this.fSM = false;
    }

    public void T(String str, boolean z) {
        this.fSJ = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fSI = null;
        } else if (!str.equals(this.fSI)) {
            reset();
            this.fSI = str;
        } else {
            this.fSJ = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fSJ) {
            this.fSK = false;
            return null;
        } else if (this.fQf != null && this.fQf.beX() != null && this.fQf.beX().size() > 0) {
            this.fSK = true;
            com.baidu.tieba.pb.data.d dVar = this.fQf;
            this.fQf = null;
            return dVar;
        } else {
            this.fSK = false;
            this.fQf = null;
            return null;
        }
    }

    public Parcelable biY() {
        if (this.fSK) {
            this.fSK = false;
            Parcelable parcelable = this.fSL;
            this.fSL = null;
            return parcelable;
        }
        this.fSL = null;
        return null;
    }

    public int biZ() {
        return this.fSP;
    }

    public void rJ(int i) {
        this.fSP = i;
    }

    public PostData bja() {
        return this.fSO;
    }

    public void i(PostData postData) {
        this.fSO = postData;
    }

    public PostData bjb() {
        return this.fSN;
    }

    public void j(PostData postData) {
        this.fSN = postData;
    }

    public boolean bhQ() {
        return this.fPR;
    }

    public boolean bjc() {
        return this.fPP;
    }

    public boolean bjd() {
        return this.fSM;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fSJ = false;
        if (this.fSI == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.beX() == null) {
            reset();
            return false;
        } else if (dVar.beX().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fQf = dVar;
            this.fSK = false;
            this.fSL = parcelable;
            this.fPR = z;
            this.fPP = z2;
            this.fSM = z3;
            return true;
        }
    }

    public void reset() {
        this.fSJ = false;
        this.fQf = null;
        this.fSK = false;
        this.fSL = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fQf != null && this.fQf.beT() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.fQf.beT().getId(), 0L)) {
                this.fQf.beT().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fQf != null && this.fQf.beX() != null && this.fQf.beX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQf.beX().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQf.beX().get(i) != null && this.fQf.beX().get(i).yv() != null && currentAccount.equals(this.fQf.beX().get(i).yv().getUserId()) && this.fQf.beX().get(i).yv().getPendantData() != null) {
                        this.fQf.beX().get(i).yv().getPendantData().dR(jVar.xf());
                        this.fQf.beX().get(i).yv().getPendantData().af(jVar.Ko());
                    }
                }
            }
        }
    }
}
