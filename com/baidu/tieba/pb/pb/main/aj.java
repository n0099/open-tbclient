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
    private boolean gbU;
    private boolean gbW;
    private com.baidu.tieba.pb.data.d gck;
    private String geU;
    private boolean geV;
    private boolean geW;
    private Parcelable geX;
    private boolean geY;
    private PostData geZ;
    private PostData gfa;
    private int gfb;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.blF().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.blF().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.blF().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.blF().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.blF().a((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static aj gfc = new aj();
    }

    public static aj blF() {
        return a.gfc;
    }

    private aj() {
        this.geU = null;
        this.geV = false;
        this.gck = null;
        this.geW = false;
        this.geX = null;
        this.gbW = true;
        this.gbU = false;
        this.geY = false;
    }

    public void U(String str, boolean z) {
        this.geV = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.geU = null;
        } else if (!str.equals(this.geU)) {
            reset();
            this.geU = str;
        } else {
            this.geV = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.geV) {
            this.geW = false;
            return null;
        } else if (this.gck != null && this.gck.bhB() != null && this.gck.bhB().size() > 0) {
            this.geW = true;
            com.baidu.tieba.pb.data.d dVar = this.gck;
            this.gck = null;
            return dVar;
        } else {
            this.geW = false;
            this.gck = null;
            return null;
        }
    }

    public Parcelable blG() {
        if (this.geW) {
            this.geW = false;
            Parcelable parcelable = this.geX;
            this.geX = null;
            return parcelable;
        }
        this.geX = null;
        return null;
    }

    public int blH() {
        return this.gfb;
    }

    public void sN(int i) {
        this.gfb = i;
    }

    public PostData blI() {
        return this.gfa;
    }

    public void k(PostData postData) {
        this.gfa = postData;
    }

    public PostData blJ() {
        return this.geZ;
    }

    public void l(PostData postData) {
        this.geZ = postData;
    }

    public boolean bku() {
        return this.gbW;
    }

    public boolean blK() {
        return this.gbU;
    }

    public boolean blL() {
        return this.geY;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.geV = false;
        if (this.geU == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bhB() == null) {
            reset();
            return false;
        } else if (dVar.bhB().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.gck = dVar;
            this.geW = false;
            this.geX = parcelable;
            this.gbW = z;
            this.gbU = z2;
            this.geY = z3;
            return true;
        }
    }

    public void reset() {
        this.geV = false;
        this.gck = null;
        this.geW = false;
        this.geX = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.gck != null && this.gck.bhx() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.gck.bhx().getId(), 0L)) {
                this.gck.bhx().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.gck != null && this.gck.bhB() != null && this.gck.bhB().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.gck.bhB().size();
                for (int i = 0; i < size; i++) {
                    if (this.gck.bhB().get(i) != null && this.gck.bhB().get(i).zT() != null && currentAccount.equals(this.gck.bhB().get(i).zT().getUserId()) && this.gck.bhB().get(i).zT().getPendantData() != null) {
                        this.gck.bhB().get(i).zT().getPendantData().es(lVar.yF());
                        this.gck.bhB().get(i).zT().getPendantData().ap(lVar.LW());
                    }
                }
            }
        }
    }
}
