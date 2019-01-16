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
    private boolean gbT;
    private boolean gbV;
    private com.baidu.tieba.pb.data.d gcj;
    private String geT;
    private boolean geU;
    private boolean geV;
    private Parcelable geW;
    private boolean geX;
    private PostData geY;
    private PostData geZ;
    private int gfa;

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
        private static aj gfb = new aj();
    }

    public static aj blF() {
        return a.gfb;
    }

    private aj() {
        this.geT = null;
        this.geU = false;
        this.gcj = null;
        this.geV = false;
        this.geW = null;
        this.gbV = true;
        this.gbT = false;
        this.geX = false;
    }

    public void U(String str, boolean z) {
        this.geU = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.geT = null;
        } else if (!str.equals(this.geT)) {
            reset();
            this.geT = str;
        } else {
            this.geU = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.geU) {
            this.geV = false;
            return null;
        } else if (this.gcj != null && this.gcj.bhB() != null && this.gcj.bhB().size() > 0) {
            this.geV = true;
            com.baidu.tieba.pb.data.d dVar = this.gcj;
            this.gcj = null;
            return dVar;
        } else {
            this.geV = false;
            this.gcj = null;
            return null;
        }
    }

    public Parcelable blG() {
        if (this.geV) {
            this.geV = false;
            Parcelable parcelable = this.geW;
            this.geW = null;
            return parcelable;
        }
        this.geW = null;
        return null;
    }

    public int blH() {
        return this.gfa;
    }

    public void sN(int i) {
        this.gfa = i;
    }

    public PostData blI() {
        return this.geZ;
    }

    public void k(PostData postData) {
        this.geZ = postData;
    }

    public PostData blJ() {
        return this.geY;
    }

    public void l(PostData postData) {
        this.geY = postData;
    }

    public boolean bku() {
        return this.gbV;
    }

    public boolean blK() {
        return this.gbT;
    }

    public boolean blL() {
        return this.geX;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.geU = false;
        if (this.geT == null) {
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
            this.gcj = dVar;
            this.geV = false;
            this.geW = parcelable;
            this.gbV = z;
            this.gbT = z2;
            this.geX = z3;
            return true;
        }
    }

    public void reset() {
        this.geU = false;
        this.gcj = null;
        this.geV = false;
        this.geW = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.gcj != null && this.gcj.bhx() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.gcj.bhx().getId(), 0L)) {
                this.gcj.bhx().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.gcj != null && this.gcj.bhB() != null && this.gcj.bhB().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.gcj.bhB().size();
                for (int i = 0; i < size; i++) {
                    if (this.gcj.bhB().get(i) != null && this.gcj.bhB().get(i).zT() != null && currentAccount.equals(this.gcj.bhB().get(i).zT().getUserId()) && this.gcj.bhB().get(i).zT().getPendantData() != null) {
                        this.gcj.bhB().get(i).zT().getPendantData().es(lVar.yF());
                        this.gcj.bhB().get(i).zT().getPendantData().ap(lVar.LW());
                    }
                }
            }
        }
    }
}
