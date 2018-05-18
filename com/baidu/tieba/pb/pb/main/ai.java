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
    private boolean fld;
    private boolean flf;
    private com.baidu.tieba.pb.data.d flr;
    private String fnV;
    private boolean fnW;
    private boolean fnX;
    private Parcelable fnY;
    private boolean fnZ;
    private PostData foa;
    private PostData fob;
    private int foc;

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
        private static ai fod = new ai();
    }

    public static ai aZr() {
        return a.fod;
    }

    private ai() {
        this.fnV = null;
        this.fnW = false;
        this.flr = null;
        this.fnX = false;
        this.fnY = null;
        this.flf = true;
        this.fld = false;
        this.fnZ = false;
    }

    public void L(String str, boolean z) {
        this.fnW = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fnV = null;
        } else if (!str.equals(this.fnV)) {
            reset();
            this.fnV = str;
        } else {
            this.fnW = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fnW) {
            this.fnX = false;
            return null;
        } else if (this.flr != null && this.flr.aVu() != null && this.flr.aVu().size() > 0) {
            this.fnX = true;
            com.baidu.tieba.pb.data.d dVar = this.flr;
            this.flr = null;
            return dVar;
        } else {
            this.fnX = false;
            this.flr = null;
            return null;
        }
    }

    public Parcelable aZs() {
        if (this.fnX) {
            this.fnX = false;
            Parcelable parcelable = this.fnY;
            this.fnY = null;
            return parcelable;
        }
        this.fnY = null;
        return null;
    }

    public int aZt() {
        return this.foc;
    }

    public void qu(int i) {
        this.foc = i;
    }

    public PostData aZu() {
        return this.fob;
    }

    public void h(PostData postData) {
        this.fob = postData;
    }

    public PostData aZv() {
        return this.foa;
    }

    public void i(PostData postData) {
        this.foa = postData;
    }

    public boolean aYk() {
        return this.flf;
    }

    public boolean aZw() {
        return this.fld;
    }

    public boolean aZx() {
        return this.fnZ;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fnW = false;
        if (this.fnV == null) {
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
            this.flr = dVar;
            this.fnX = false;
            this.fnY = parcelable;
            this.flf = z;
            this.fld = z2;
            this.fnZ = z3;
            return true;
        }
    }

    public void reset() {
        this.fnW = false;
        this.flr = null;
        this.fnX = false;
        this.fnY = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.flr != null && this.flr.aVq() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.flr.aVq().getId(), 0L)) {
                this.flr.aVq().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.flr != null && this.flr.aVu() != null && this.flr.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.flr.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.flr.aVu().get(i) != null && this.flr.aVu().get(i).rP() != null && currentAccount.equals(this.flr.aVu().get(i).rP().getUserId()) && this.flr.aVu().get(i).rP().getPendantData() != null) {
                        this.flr.aVu().get(i).rP().getPendantData().cL(hVar.qF());
                        this.flr.aVu().get(i).rP().getPendantData().T(hVar.Di());
                    }
                }
            }
        }
    }
}
