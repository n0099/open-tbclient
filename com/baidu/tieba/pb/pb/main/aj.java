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
    private boolean fAB;
    private com.baidu.tieba.pb.data.d fAN;
    private boolean fAz;
    private String fDq;
    private boolean fDr;
    private boolean fDs;
    private Parcelable fDt;
    private boolean fDu;
    private PostData fDv;
    private PostData fDw;
    private int fDx;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.beX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.beX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.beX().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.beX().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    aj.beX().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fDy = new aj();
    }

    public static aj beX() {
        return a.fDy;
    }

    private aj() {
        this.fDq = null;
        this.fDr = false;
        this.fAN = null;
        this.fDs = false;
        this.fDt = null;
        this.fAB = true;
        this.fAz = false;
        this.fDu = false;
    }

    public void M(String str, boolean z) {
        this.fDr = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fDq = null;
        } else if (!str.equals(this.fDq)) {
            reset();
            this.fDq = str;
        } else {
            this.fDr = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fDr) {
            this.fDs = false;
            return null;
        } else if (this.fAN != null && this.fAN.baX() != null && this.fAN.baX().size() > 0) {
            this.fDs = true;
            com.baidu.tieba.pb.data.d dVar = this.fAN;
            this.fAN = null;
            return dVar;
        } else {
            this.fDs = false;
            this.fAN = null;
            return null;
        }
    }

    public Parcelable beY() {
        if (this.fDs) {
            this.fDs = false;
            Parcelable parcelable = this.fDt;
            this.fDt = null;
            return parcelable;
        }
        this.fDt = null;
        return null;
    }

    public int beZ() {
        return this.fDx;
    }

    public void qO(int i) {
        this.fDx = i;
    }

    public PostData bfa() {
        return this.fDw;
    }

    public void h(PostData postData) {
        this.fDw = postData;
    }

    public PostData bfb() {
        return this.fDv;
    }

    public void i(PostData postData) {
        this.fDv = postData;
    }

    public boolean bdQ() {
        return this.fAB;
    }

    public boolean bfc() {
        return this.fAz;
    }

    public boolean bfd() {
        return this.fDu;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fDr = false;
        if (this.fDq == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.baX() == null) {
            reset();
            return false;
        } else if (dVar.baX().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fAN = dVar;
            this.fDs = false;
            this.fDt = parcelable;
            this.fAB = z;
            this.fAz = z2;
            this.fDu = z3;
            return true;
        }
    }

    public void reset() {
        this.fDr = false;
        this.fAN = null;
        this.fDs = false;
        this.fDt = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fAN != null && this.fAN.baT() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fAN.baT().getId(), 0L)) {
                this.fAN.baT().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fAN != null && this.fAN.baX() != null && this.fAN.baX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fAN.baX().size();
                for (int i = 0; i < size; i++) {
                    if (this.fAN.baX().get(i) != null && this.fAN.baX().get(i).vw() != null && currentAccount.equals(this.fAN.baX().get(i).vw().getUserId()) && this.fAN.baX().get(i).vw().getPendantData() != null) {
                        this.fAN.baX().get(i).vw().getPendantData().dm(iVar.uh());
                        this.fAN.baX().get(i).vw().getPendantData().X(iVar.Hd());
                    }
                }
            }
        }
    }
}
