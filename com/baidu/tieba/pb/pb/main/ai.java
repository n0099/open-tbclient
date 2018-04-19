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
    private boolean fjZ;
    private boolean fkb;
    private com.baidu.tieba.pb.data.d fkn;
    private String fmR;
    private boolean fmS;
    private boolean fmT;
    private Parcelable fmU;
    private boolean fmV;
    private PostData fmW;
    private PostData fmX;
    private int fmY;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aZr().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aZr().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aZr().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.aZr().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    ai.aZr().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static ai fmZ = new ai();
    }

    public static ai aZr() {
        return a.fmZ;
    }

    private ai() {
        this.fmR = null;
        this.fmS = false;
        this.fkn = null;
        this.fmT = false;
        this.fmU = null;
        this.fkb = true;
        this.fjZ = false;
        this.fmV = false;
    }

    public void L(String str, boolean z) {
        this.fmS = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fmR = null;
        } else if (!str.equals(this.fmR)) {
            reset();
            this.fmR = str;
        } else {
            this.fmS = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fmS) {
            this.fmT = false;
            return null;
        } else if (this.fkn != null && this.fkn.aVu() != null && this.fkn.aVu().size() > 0) {
            this.fmT = true;
            com.baidu.tieba.pb.data.d dVar = this.fkn;
            this.fkn = null;
            return dVar;
        } else {
            this.fmT = false;
            this.fkn = null;
            return null;
        }
    }

    public Parcelable aZs() {
        if (this.fmT) {
            this.fmT = false;
            Parcelable parcelable = this.fmU;
            this.fmU = null;
            return parcelable;
        }
        this.fmU = null;
        return null;
    }

    public int aZt() {
        return this.fmY;
    }

    public void qv(int i) {
        this.fmY = i;
    }

    public PostData aZu() {
        return this.fmX;
    }

    public void h(PostData postData) {
        this.fmX = postData;
    }

    public PostData aZv() {
        return this.fmW;
    }

    public void i(PostData postData) {
        this.fmW = postData;
    }

    public boolean aYk() {
        return this.fkb;
    }

    public boolean aZw() {
        return this.fjZ;
    }

    public boolean aZx() {
        return this.fmV;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fmS = false;
        if (this.fmR == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.aVu() == null) {
            reset();
            return false;
        } else if (dVar.aVu().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fkn = dVar;
            this.fmT = false;
            this.fmU = parcelable;
            this.fkb = z;
            this.fjZ = z2;
            this.fmV = z3;
            return true;
        }
    }

    public void reset() {
        this.fmS = false;
        this.fkn = null;
        this.fmT = false;
        this.fmU = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fkn != null && this.fkn.aVq() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fkn.aVq().getId(), 0L)) {
                this.fkn.aVq().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fkn != null && this.fkn.aVu() != null && this.fkn.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fkn.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.fkn.aVu().get(i) != null && this.fkn.aVu().get(i).rQ() != null && currentAccount.equals(this.fkn.aVu().get(i).rQ().getUserId()) && this.fkn.aVu().get(i).rQ().getPendantData() != null) {
                        this.fkn.aVu().get(i).rQ().getPendantData().cL(hVar.qG());
                        this.fkn.aVu().get(i).rQ().getPendantData().T(hVar.Dk());
                    }
                }
            }
        }
    }
}
