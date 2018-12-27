package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class aj {
    private boolean gaW;
    private boolean gaY;
    private com.baidu.tieba.pb.data.d gbm;
    private String gdP;
    private boolean gdQ;
    private boolean gdR;
    private Parcelable gdS;
    private boolean gdT;
    private PostData gdU;
    private PostData gdV;
    private int gdW;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkX().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkX().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkX().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    aj.bkX().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static aj gdX = new aj();
    }

    public static aj bkX() {
        return a.gdX;
    }

    private aj() {
        this.gdP = null;
        this.gdQ = false;
        this.gbm = null;
        this.gdR = false;
        this.gdS = null;
        this.gaY = true;
        this.gaW = false;
        this.gdT = false;
    }

    public void V(String str, boolean z) {
        this.gdQ = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.gdP = null;
        } else if (!str.equals(this.gdP)) {
            reset();
            this.gdP = str;
        } else {
            this.gdQ = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.gdQ) {
            this.gdR = false;
            return null;
        } else if (this.gbm != null && this.gbm.bgX() != null && this.gbm.bgX().size() > 0) {
            this.gdR = true;
            com.baidu.tieba.pb.data.d dVar = this.gbm;
            this.gbm = null;
            return dVar;
        } else {
            this.gdR = false;
            this.gbm = null;
            return null;
        }
    }

    public Parcelable bkY() {
        if (this.gdR) {
            this.gdR = false;
            Parcelable parcelable = this.gdS;
            this.gdS = null;
            return parcelable;
        }
        this.gdS = null;
        return null;
    }

    public int bkZ() {
        return this.gdW;
    }

    public void sJ(int i) {
        this.gdW = i;
    }

    public PostData bla() {
        return this.gdV;
    }

    public void i(PostData postData) {
        this.gdV = postData;
    }

    public PostData blb() {
        return this.gdU;
    }

    public void j(PostData postData) {
        this.gdU = postData;
    }

    public boolean bjQ() {
        return this.gaY;
    }

    public boolean blc() {
        return this.gaW;
    }

    public boolean bld() {
        return this.gdT;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.gdQ = false;
        if (this.gdP == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bgX() == null) {
            reset();
            return false;
        } else if (dVar.bgX().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.gbm = dVar;
            this.gdR = false;
            this.gdS = parcelable;
            this.gaY = z;
            this.gaW = z2;
            this.gdT = z3;
            return true;
        }
    }

    public void reset() {
        this.gdQ = false;
        this.gbm = null;
        this.gdR = false;
        this.gdS = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.gbm != null && this.gbm.bgT() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.gbm.bgT().getId(), 0L)) {
                this.gbm.bgT().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.gbm != null && this.gbm.bgX() != null && this.gbm.bgX().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.gbm.bgX().size();
                for (int i = 0; i < size; i++) {
                    if (this.gbm.bgX().get(i) != null && this.gbm.bgX().get(i).zG() != null && currentAccount.equals(this.gbm.bgX().get(i).zG().getUserId()) && this.gbm.bgX().get(i).zG().getPendantData() != null) {
                        this.gbm.bgX().get(i).zG().getPendantData().ej(jVar.ys());
                        this.gbm.bgX().get(i).zG().getPendantData().ap(jVar.LF());
                    }
                }
            }
        }
    }
}
