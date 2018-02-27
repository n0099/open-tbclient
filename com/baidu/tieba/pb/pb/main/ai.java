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
    private boolean fPK;
    private boolean fPM;
    private com.baidu.tieba.pb.data.d fPY;
    private String fSC;
    private boolean fSD;
    private boolean fSE;
    private Parcelable fSF;
    private boolean fSG;
    private PostData fSH;
    private PostData fSI;
    private int fSJ;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bet().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bet().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bet().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bet().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                    ai.bet().a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static ai fSK = new ai();
    }

    public static ai bet() {
        return a.fSK;
    }

    private ai() {
        this.fSC = null;
        this.fSD = false;
        this.fPY = null;
        this.fSE = false;
        this.fSF = null;
        this.fPM = true;
        this.fPK = false;
        this.fSG = false;
    }

    public void P(String str, boolean z) {
        this.fSD = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fSC = null;
        } else if (!str.equals(this.fSC)) {
            reset();
            this.fSC = str;
        } else {
            this.fSD = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fSD) {
            this.fSE = false;
            return null;
        } else if (this.fPY != null && this.fPY.bav() != null && this.fPY.bav().size() > 0) {
            this.fSE = true;
            com.baidu.tieba.pb.data.d dVar = this.fPY;
            this.fPY = null;
            return dVar;
        } else {
            this.fSE = false;
            this.fPY = null;
            return null;
        }
    }

    public Parcelable beu() {
        if (this.fSE) {
            this.fSE = false;
            Parcelable parcelable = this.fSF;
            this.fSF = null;
            return parcelable;
        }
        this.fSF = null;
        return null;
    }

    public int bev() {
        return this.fSJ;
    }

    public void ta(int i) {
        this.fSJ = i;
    }

    public PostData bew() {
        return this.fSI;
    }

    public void i(PostData postData) {
        this.fSI = postData;
    }

    public PostData bex() {
        return this.fSH;
    }

    public void j(PostData postData) {
        this.fSH = postData;
    }

    public boolean bdm() {
        return this.fPM;
    }

    public boolean bey() {
        return this.fPK;
    }

    public boolean bez() {
        return this.fSG;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fSD = false;
        if (this.fSC == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bav() == null) {
            reset();
            return false;
        } else if (dVar.bav().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fPY = dVar;
            this.fSE = false;
            this.fSF = parcelable;
            this.fPM = z;
            this.fPK = z2;
            this.fSG = z3;
            return true;
        }
    }

    public void reset() {
        this.fSD = false;
        this.fPY = null;
        this.fSE = false;
        this.fSF = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fPY != null && this.fPY.bar() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fPY.bar().getId(), 0L)) {
                this.fPY.bar().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fPY != null && this.fPY.bav() != null && this.fPY.bav().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fPY.bav().size();
                for (int i = 0; i < size; i++) {
                    if (this.fPY.bav().get(i) != null && this.fPY.bav().get(i).zn() != null && currentAccount.equals(this.fPY.bav().get(i).zn().getUserId()) && this.fPY.bav().get(i).zn().getPendantData() != null) {
                        this.fPY.bav().get(i).zn().getPendantData().cX(hVar.ya());
                        this.fPY.bav().get(i).zn().getPendantData().ab(hVar.KD());
                    }
                }
            }
        }
    }
}
