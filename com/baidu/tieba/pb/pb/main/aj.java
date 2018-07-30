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
    private boolean fAL;
    private boolean fAN;
    private com.baidu.tieba.pb.data.d fBa;
    private String fDD;
    private boolean fDE;
    private boolean fDF;
    private Parcelable fDG;
    private boolean fDH;
    private PostData fDI;
    private PostData fDJ;
    private int fDK;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdq().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdq().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bdq().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    aj.bdq().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fDL = new aj();
    }

    public static aj bdq() {
        return a.fDL;
    }

    private aj() {
        this.fDD = null;
        this.fDE = false;
        this.fBa = null;
        this.fDF = false;
        this.fDG = null;
        this.fAN = true;
        this.fAL = false;
        this.fDH = false;
    }

    public void L(String str, boolean z) {
        this.fDE = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fDD = null;
        } else if (!str.equals(this.fDD)) {
            reset();
            this.fDD = str;
        } else {
            this.fDE = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fDE) {
            this.fDF = false;
            return null;
        } else if (this.fBa != null && this.fBa.aZp() != null && this.fBa.aZp().size() > 0) {
            this.fDF = true;
            com.baidu.tieba.pb.data.d dVar = this.fBa;
            this.fBa = null;
            return dVar;
        } else {
            this.fDF = false;
            this.fBa = null;
            return null;
        }
    }

    public Parcelable bdr() {
        if (this.fDF) {
            this.fDF = false;
            Parcelable parcelable = this.fDG;
            this.fDG = null;
            return parcelable;
        }
        this.fDG = null;
        return null;
    }

    public int bds() {
        return this.fDK;
    }

    public void qL(int i) {
        this.fDK = i;
    }

    public PostData bdt() {
        return this.fDJ;
    }

    public void h(PostData postData) {
        this.fDJ = postData;
    }

    public PostData bdu() {
        return this.fDI;
    }

    public void i(PostData postData) {
        this.fDI = postData;
    }

    public boolean bcj() {
        return this.fAN;
    }

    public boolean bdv() {
        return this.fAL;
    }

    public boolean bdw() {
        return this.fDH;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fDE = false;
        if (this.fDD == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.aZp() == null) {
            reset();
            return false;
        } else if (dVar.aZp().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fBa = dVar;
            this.fDF = false;
            this.fDG = parcelable;
            this.fAN = z;
            this.fAL = z2;
            this.fDH = z3;
            return true;
        }
    }

    public void reset() {
        this.fDE = false;
        this.fBa = null;
        this.fDF = false;
        this.fDG = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fBa != null && this.fBa.aZl() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fBa.aZl().getId(), 0L)) {
                this.fBa.aZl().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fBa != null && this.fBa.aZp() != null && this.fBa.aZp().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fBa.aZp().size();
                for (int i = 0; i < size; i++) {
                    if (this.fBa.aZp().get(i) != null && this.fBa.aZp().get(i).vk() != null && currentAccount.equals(this.fBa.aZp().get(i).vk().getUserId()) && this.fBa.aZp().get(i).vk().getPendantData() != null) {
                        this.fBa.aZp().get(i).vk().getPendantData().dj(iVar.tU());
                        this.fBa.aZp().get(i).vk().getPendantData().Z(iVar.GZ());
                    }
                }
            }
        }
    }
}
