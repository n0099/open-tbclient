package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ai {
    private boolean fPV;
    private boolean fPX;
    private com.baidu.tieba.pb.data.d fQj;
    private String fSN;
    private boolean fSO;
    private boolean fSP;
    private Parcelable fSQ;
    private boolean fSR;
    private PostData fSS;
    private PostData fST;
    private int fSU;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.beu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.beu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.beu().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.beu().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    ai.beu().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static ai fSV = new ai();
    }

    public static ai beu() {
        return a.fSV;
    }

    private ai() {
        this.fSN = null;
        this.fSO = false;
        this.fQj = null;
        this.fSP = false;
        this.fSQ = null;
        this.fPX = true;
        this.fPV = false;
        this.fSR = false;
    }

    public void Q(String str, boolean z) {
        this.fSO = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fSN = null;
        } else if (!str.equals(this.fSN)) {
            reset();
            this.fSN = str;
        } else {
            this.fSO = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fSO) {
            this.fSP = false;
            return null;
        } else if (this.fQj != null && this.fQj.baw() != null && this.fQj.baw().size() > 0) {
            this.fSP = true;
            com.baidu.tieba.pb.data.d dVar = this.fQj;
            this.fQj = null;
            return dVar;
        } else {
            this.fSP = false;
            this.fQj = null;
            return null;
        }
    }

    public Parcelable bev() {
        if (this.fSP) {
            this.fSP = false;
            Parcelable parcelable = this.fSQ;
            this.fSQ = null;
            return parcelable;
        }
        this.fSQ = null;
        return null;
    }

    public int bew() {
        return this.fSU;
    }

    public void sZ(int i) {
        this.fSU = i;
    }

    public PostData bex() {
        return this.fST;
    }

    public void i(PostData postData) {
        this.fST = postData;
    }

    public PostData bey() {
        return this.fSS;
    }

    public void j(PostData postData) {
        this.fSS = postData;
    }

    public boolean bdn() {
        return this.fPX;
    }

    public boolean bez() {
        return this.fPV;
    }

    public boolean beA() {
        return this.fSR;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fSO = false;
        if (this.fSN == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.baw() == null) {
            reset();
            return false;
        } else if (dVar.baw().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fQj = dVar;
            this.fSP = false;
            this.fSQ = parcelable;
            this.fPX = z;
            this.fPV = z2;
            this.fSR = z3;
            return true;
        }
    }

    public void reset() {
        this.fSO = false;
        this.fQj = null;
        this.fSP = false;
        this.fSQ = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fQj != null && this.fQj.bas() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fQj.bas().getId(), 0L)) {
                this.fQj.bas().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fQj != null && this.fQj.baw() != null && this.fQj.baw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQj.baw().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQj.baw().get(i) != null && this.fQj.baw().get(i).zn() != null && currentAccount.equals(this.fQj.baw().get(i).zn().getUserId()) && this.fQj.baw().get(i).zn().getPendantData() != null) {
                        this.fQj.baw().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fQj.baw().get(i).zn().getPendantData().ab(hVar.KE());
                    }
                }
            }
        }
    }
}
