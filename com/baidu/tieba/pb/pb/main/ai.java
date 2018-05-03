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
    private boolean fjW;
    private boolean fjY;
    private com.baidu.tieba.pb.data.d fkk;
    private String fmO;
    private boolean fmP;
    private boolean fmQ;
    private Parcelable fmR;
    private boolean fmS;
    private PostData fmT;
    private PostData fmU;
    private int fmV;

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
        private static ai fmW = new ai();
    }

    public static ai aZr() {
        return a.fmW;
    }

    private ai() {
        this.fmO = null;
        this.fmP = false;
        this.fkk = null;
        this.fmQ = false;
        this.fmR = null;
        this.fjY = true;
        this.fjW = false;
        this.fmS = false;
    }

    public void L(String str, boolean z) {
        this.fmP = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fmO = null;
        } else if (!str.equals(this.fmO)) {
            reset();
            this.fmO = str;
        } else {
            this.fmP = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fmP) {
            this.fmQ = false;
            return null;
        } else if (this.fkk != null && this.fkk.aVu() != null && this.fkk.aVu().size() > 0) {
            this.fmQ = true;
            com.baidu.tieba.pb.data.d dVar = this.fkk;
            this.fkk = null;
            return dVar;
        } else {
            this.fmQ = false;
            this.fkk = null;
            return null;
        }
    }

    public Parcelable aZs() {
        if (this.fmQ) {
            this.fmQ = false;
            Parcelable parcelable = this.fmR;
            this.fmR = null;
            return parcelable;
        }
        this.fmR = null;
        return null;
    }

    public int aZt() {
        return this.fmV;
    }

    public void qv(int i) {
        this.fmV = i;
    }

    public PostData aZu() {
        return this.fmU;
    }

    public void h(PostData postData) {
        this.fmU = postData;
    }

    public PostData aZv() {
        return this.fmT;
    }

    public void i(PostData postData) {
        this.fmT = postData;
    }

    public boolean aYk() {
        return this.fjY;
    }

    public boolean aZw() {
        return this.fjW;
    }

    public boolean aZx() {
        return this.fmS;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fmP = false;
        if (this.fmO == null) {
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
            this.fkk = dVar;
            this.fmQ = false;
            this.fmR = parcelable;
            this.fjY = z;
            this.fjW = z2;
            this.fmS = z3;
            return true;
        }
    }

    public void reset() {
        this.fmP = false;
        this.fkk = null;
        this.fmQ = false;
        this.fmR = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fkk != null && this.fkk.aVq() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fkk.aVq().getId(), 0L)) {
                this.fkk.aVq().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fkk != null && this.fkk.aVu() != null && this.fkk.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fkk.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.fkk.aVu().get(i) != null && this.fkk.aVu().get(i).rQ() != null && currentAccount.equals(this.fkk.aVu().get(i).rQ().getUserId()) && this.fkk.aVu().get(i).rQ().getPendantData() != null) {
                        this.fkk.aVu().get(i).rQ().getPendantData().cL(hVar.qG());
                        this.fkk.aVu().get(i).rQ().getPendantData().T(hVar.Dk());
                    }
                }
            }
        }
    }
}
