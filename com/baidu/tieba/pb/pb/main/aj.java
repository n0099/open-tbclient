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
    private com.baidu.tieba.pb.data.d fRE;
    private boolean fRo;
    private boolean fRq;
    private String fUh;
    private boolean fUi;
    private boolean fUj;
    private Parcelable fUk;
    private boolean fUl;
    private PostData fUm;
    private PostData fUn;
    private int fUo;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biu().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biu().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.biu().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    aj.biu().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static aj fUp = new aj();
    }

    public static aj biu() {
        return a.fUp;
    }

    private aj() {
        this.fUh = null;
        this.fUi = false;
        this.fRE = null;
        this.fUj = false;
        this.fUk = null;
        this.fRq = true;
        this.fRo = false;
        this.fUl = false;
    }

    public void T(String str, boolean z) {
        this.fUi = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fUh = null;
        } else if (!str.equals(this.fUh)) {
            reset();
            this.fUh = str;
        } else {
            this.fUi = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fUi) {
            this.fUj = false;
            return null;
        } else if (this.fRE != null && this.fRE.bev() != null && this.fRE.bev().size() > 0) {
            this.fUj = true;
            com.baidu.tieba.pb.data.d dVar = this.fRE;
            this.fRE = null;
            return dVar;
        } else {
            this.fUj = false;
            this.fRE = null;
            return null;
        }
    }

    public Parcelable biv() {
        if (this.fUj) {
            this.fUj = false;
            Parcelable parcelable = this.fUk;
            this.fUk = null;
            return parcelable;
        }
        this.fUk = null;
        return null;
    }

    public int biw() {
        return this.fUo;
    }

    public void sc(int i) {
        this.fUo = i;
    }

    public PostData bix() {
        return this.fUn;
    }

    public void i(PostData postData) {
        this.fUn = postData;
    }

    public PostData biy() {
        return this.fUm;
    }

    public void j(PostData postData) {
        this.fUm = postData;
    }

    public boolean bhn() {
        return this.fRq;
    }

    public boolean biz() {
        return this.fRo;
    }

    public boolean biA() {
        return this.fUl;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fUi = false;
        if (this.fUh == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bev() == null) {
            reset();
            return false;
        } else if (dVar.bev().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fRE = dVar;
            this.fUj = false;
            this.fUk = parcelable;
            this.fRq = z;
            this.fRo = z2;
            this.fUl = z3;
            return true;
        }
    }

    public void reset() {
        this.fUi = false;
        this.fRE = null;
        this.fUj = false;
        this.fUk = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fRE != null && this.fRE.ber() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.fRE.ber().getId(), 0L)) {
                this.fRE.ber().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fRE != null && this.fRE.bev() != null && this.fRE.bev().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fRE.bev().size();
                for (int i = 0; i < size; i++) {
                    if (this.fRE.bev().get(i) != null && this.fRE.bev().get(i).yC() != null && currentAccount.equals(this.fRE.bev().get(i).yC().getUserId()) && this.fRE.bev().get(i).yC().getPendantData() != null) {
                        this.fRE.bev().get(i).yC().getPendantData().dR(jVar.xn());
                        this.fRE.bev().get(i).yC().getPendantData().ah(jVar.KA());
                    }
                }
            }
        }
    }
}
