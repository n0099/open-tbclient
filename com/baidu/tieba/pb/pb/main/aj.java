package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class aj {
    private boolean fAE;
    private boolean fAG;
    private com.baidu.tieba.pb.data.d fAT;
    private boolean fDA;
    private PostData fDB;
    private PostData fDC;
    private int fDD;
    private String fDw;
    private boolean fDx;
    private boolean fDy;
    private Parcelable fDz;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdl().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdl().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdl().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdl().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    aj.bdl().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fDE = new aj();
    }

    public static aj bdl() {
        return a.fDE;
    }

    private aj() {
        this.fDw = null;
        this.fDx = false;
        this.fAT = null;
        this.fDy = false;
        this.fDz = null;
        this.fAG = true;
        this.fAE = false;
        this.fDA = false;
    }

    public void L(String str, boolean z) {
        this.fDx = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fDw = null;
        } else if (!str.equals(this.fDw)) {
            reset();
            this.fDw = str;
        } else {
            this.fDx = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fDx) {
            this.fDy = false;
            return null;
        } else if (this.fAT != null && this.fAT.aZk() != null && this.fAT.aZk().size() > 0) {
            this.fDy = true;
            com.baidu.tieba.pb.data.d dVar = this.fAT;
            this.fAT = null;
            return dVar;
        } else {
            this.fDy = false;
            this.fAT = null;
            return null;
        }
    }

    public Parcelable bdm() {
        if (this.fDy) {
            this.fDy = false;
            Parcelable parcelable = this.fDz;
            this.fDz = null;
            return parcelable;
        }
        this.fDz = null;
        return null;
    }

    public int bdn() {
        return this.fDD;
    }

    public void qL(int i) {
        this.fDD = i;
    }

    public PostData bdo() {
        return this.fDC;
    }

    public void h(PostData postData) {
        this.fDC = postData;
    }

    public PostData bdp() {
        return this.fDB;
    }

    public void i(PostData postData) {
        this.fDB = postData;
    }

    public boolean bce() {
        return this.fAG;
    }

    public boolean bdq() {
        return this.fAE;
    }

    public boolean bdr() {
        return this.fDA;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fDx = false;
        if (this.fDw == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.aZk() == null) {
            reset();
            return false;
        } else if (dVar.aZk().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fAT = dVar;
            this.fDy = false;
            this.fDz = parcelable;
            this.fAG = z;
            this.fAE = z2;
            this.fDA = z3;
            return true;
        }
    }

    public void reset() {
        this.fDx = false;
        this.fAT = null;
        this.fDy = false;
        this.fDz = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fAT != null && this.fAT.aZg() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fAT.aZg().getId(), 0L)) {
                this.fAT.aZg().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fAT != null && this.fAT.aZk() != null && this.fAT.aZk().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fAT.aZk().size();
                for (int i = 0; i < size; i++) {
                    if (this.fAT.aZk().get(i) != null && this.fAT.aZk().get(i).vj() != null && currentAccount.equals(this.fAT.aZk().get(i).vj().getUserId()) && this.fAT.aZk().get(i).vj().getPendantData() != null) {
                        this.fAT.aZk().get(i).vj().getPendantData().dj(iVar.tT());
                        this.fAT.aZk().get(i).vj().getPendantData().Z(iVar.GZ());
                    }
                }
            }
        }
    }
}
