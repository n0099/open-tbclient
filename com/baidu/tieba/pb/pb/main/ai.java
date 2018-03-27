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
    private boolean fQa;
    private boolean fQc;
    private com.baidu.tieba.pb.data.d fQo;
    private String fSS;
    private boolean fST;
    private boolean fSU;
    private Parcelable fSV;
    private boolean fSW;
    private PostData fSX;
    private PostData fSY;
    private int fSZ;

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
        private static ai fTa = new ai();
    }

    public static ai beu() {
        return a.fTa;
    }

    private ai() {
        this.fSS = null;
        this.fST = false;
        this.fQo = null;
        this.fSU = false;
        this.fSV = null;
        this.fQc = true;
        this.fQa = false;
        this.fSW = false;
    }

    public void P(String str, boolean z) {
        this.fST = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fSS = null;
        } else if (!str.equals(this.fSS)) {
            reset();
            this.fSS = str;
        } else {
            this.fST = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fST) {
            this.fSU = false;
            return null;
        } else if (this.fQo != null && this.fQo.baw() != null && this.fQo.baw().size() > 0) {
            this.fSU = true;
            com.baidu.tieba.pb.data.d dVar = this.fQo;
            this.fQo = null;
            return dVar;
        } else {
            this.fSU = false;
            this.fQo = null;
            return null;
        }
    }

    public Parcelable bev() {
        if (this.fSU) {
            this.fSU = false;
            Parcelable parcelable = this.fSV;
            this.fSV = null;
            return parcelable;
        }
        this.fSV = null;
        return null;
    }

    public int bew() {
        return this.fSZ;
    }

    public void ta(int i) {
        this.fSZ = i;
    }

    public PostData bex() {
        return this.fSY;
    }

    public void i(PostData postData) {
        this.fSY = postData;
    }

    public PostData bey() {
        return this.fSX;
    }

    public void j(PostData postData) {
        this.fSX = postData;
    }

    public boolean bdn() {
        return this.fQc;
    }

    public boolean bez() {
        return this.fQa;
    }

    public boolean beA() {
        return this.fSW;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fST = false;
        if (this.fSS == null) {
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
            this.fQo = dVar;
            this.fSU = false;
            this.fSV = parcelable;
            this.fQc = z;
            this.fQa = z2;
            this.fSW = z3;
            return true;
        }
    }

    public void reset() {
        this.fST = false;
        this.fQo = null;
        this.fSU = false;
        this.fSV = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fQo != null && this.fQo.bas() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fQo.bas().getId(), 0L)) {
                this.fQo.bas().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fQo != null && this.fQo.baw() != null && this.fQo.baw().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fQo.baw().size();
                for (int i = 0; i < size; i++) {
                    if (this.fQo.baw().get(i) != null && this.fQo.baw().get(i).zn() != null && currentAccount.equals(this.fQo.baw().get(i).zn().getUserId()) && this.fQo.baw().get(i).zn().getPendantData() != null) {
                        this.fQo.baw().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fQo.baw().get(i).zn().getPendantData().ab(hVar.KE());
                    }
                }
            }
        }
    }
}
