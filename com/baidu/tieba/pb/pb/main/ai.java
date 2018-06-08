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
    private boolean fwA;
    private com.baidu.tieba.pb.data.d fwM;
    private boolean fwy;
    private String fzp;
    private boolean fzq;
    private boolean fzr;
    private Parcelable fzs;
    private boolean fzt;
    private PostData fzu;
    private PostData fzv;
    private int fzw;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ai.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bep().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.ai.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bep().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.ai.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bep().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ai.bep().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.ai.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                    ai.bep().a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static ai fzx = new ai();
    }

    public static ai bep() {
        return a.fzx;
    }

    private ai() {
        this.fzp = null;
        this.fzq = false;
        this.fwM = null;
        this.fzr = false;
        this.fzs = null;
        this.fwA = true;
        this.fwy = false;
        this.fzt = false;
    }

    public void L(String str, boolean z) {
        this.fzq = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fzp = null;
        } else if (!str.equals(this.fzp)) {
            reset();
            this.fzp = str;
        } else {
            this.fzq = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fzq) {
            this.fzr = false;
            return null;
        } else if (this.fwM != null && this.fwM.baq() != null && this.fwM.baq().size() > 0) {
            this.fzr = true;
            com.baidu.tieba.pb.data.d dVar = this.fwM;
            this.fwM = null;
            return dVar;
        } else {
            this.fzr = false;
            this.fwM = null;
            return null;
        }
    }

    public Parcelable beq() {
        if (this.fzr) {
            this.fzr = false;
            Parcelable parcelable = this.fzs;
            this.fzs = null;
            return parcelable;
        }
        this.fzs = null;
        return null;
    }

    public int ber() {
        return this.fzw;
    }

    public void qG(int i) {
        this.fzw = i;
    }

    public PostData bes() {
        return this.fzv;
    }

    public void h(PostData postData) {
        this.fzv = postData;
    }

    public PostData bet() {
        return this.fzu;
    }

    public void i(PostData postData) {
        this.fzu = postData;
    }

    public boolean bdi() {
        return this.fwA;
    }

    public boolean beu() {
        return this.fwy;
    }

    public boolean bev() {
        return this.fzt;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fzq = false;
        if (this.fzp == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.baq() == null) {
            reset();
            return false;
        } else if (dVar.baq().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fwM = dVar;
            this.fzr = false;
            this.fzs = parcelable;
            this.fwA = z;
            this.fwy = z2;
            this.fzt = z3;
            return true;
        }
    }

    public void reset() {
        this.fzq = false;
        this.fwM = null;
        this.fzr = false;
        this.fzs = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fwM != null && this.fwM.bam() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.fwM.bam().getId(), 0L)) {
                this.fwM.bam().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.fwM != null && this.fwM.baq() != null && this.fwM.baq().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fwM.baq().size();
                for (int i = 0; i < size; i++) {
                    if (this.fwM.baq().get(i) != null && this.fwM.baq().get(i).vm() != null && currentAccount.equals(this.fwM.baq().get(i).vm().getUserId()) && this.fwM.baq().get(i).vm().getPendantData() != null) {
                        this.fwM.baq().get(i).vm().getPendantData().dj(iVar.ub());
                        this.fwM.baq().get(i).vm().getPendantData().W(iVar.GL());
                    }
                }
            }
        }
    }
}
