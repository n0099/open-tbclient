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
    private boolean fPO;
    private boolean fPQ;
    private com.baidu.tieba.pb.data.d fQe;
    private String fSH;
    private boolean fSI;
    private boolean fSJ;
    private Parcelable fSK;
    private boolean fSL;
    private PostData fSM;
    private PostData fSN;
    private int fSO;

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
        private static aj fSP = new aj();
    }

    public static aj biX() {
        return a.fSP;
    }

    private aj() {
        this.fSH = null;
        this.fSI = false;
        this.fQe = null;
        this.fSJ = false;
        this.fSK = null;
        this.fPQ = true;
        this.fPO = false;
        this.fSL = false;
    }

    public void T(String str, boolean z) {
        this.fSI = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fSH = null;
        } else if (!str.equals(this.fSH)) {
            reset();
            this.fSH = str;
        } else {
            this.fSI = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fSI) {
            this.fSJ = false;
            return null;
        } else if (this.fQe != null && this.fQe.beX() != null && this.fQe.beX().size() > 0) {
            this.fSJ = true;
            com.baidu.tieba.pb.data.d dVar = this.fQe;
            this.fQe = null;
            return dVar;
        } else {
            this.fSJ = false;
            this.fQe = null;
            return null;
        }
    }

    public Parcelable biY() {
        if (this.fSJ) {
            this.fSJ = false;
            Parcelable parcelable = this.fSK;
            this.fSK = null;
            return parcelable;
        }
        this.fSK = null;
        return null;
    }

    public int biZ() {
        return this.fSO;
    }

    public void rJ(int i) {
        this.fSO = i;
    }

    public PostData bja() {
        return this.fSN;
    }

    public void i(PostData postData) {
        this.fSN = postData;
    }

    public PostData bjb() {
        return this.fSM;
    }

    public void j(PostData postData) {
        this.fSM = postData;
    }

    public boolean bhQ() {
        return this.fPQ;
    }

    public boolean bjc() {
        return this.fPO;
    }

    public boolean bjd() {
        return this.fSL;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fSI = false;
        if (this.fSH == null) {
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
            this.fQe = dVar;
            this.fSJ = false;
            this.fSK = parcelable;
            this.fPQ = z;
            this.fPO = z2;
            this.fSL = z3;
            return true;
        }
    }

    public void reset() {
        this.fSI = false;
        this.fQe = null;
        this.fSJ = false;
        this.fSK = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fQe != null && this.fQe.beT() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.fQe.beT().getId(), 0L)) {
                this.fQe.beT().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fQe != null && this.fQe.beX() != null && this.fQe.beX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQe.beX().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQe.beX().get(i) != null && this.fQe.beX().get(i).yv() != null && currentAccount.equals(this.fQe.beX().get(i).yv().getUserId()) && this.fQe.beX().get(i).yv().getPendantData() != null) {
                        this.fQe.beX().get(i).yv().getPendantData().dR(jVar.xf());
                        this.fQe.beX().get(i).yv().getPendantData().af(jVar.Ko());
                    }
                }
            }
        }
    }
}
