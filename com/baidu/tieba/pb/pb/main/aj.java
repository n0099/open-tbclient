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
    private com.baidu.tieba.pb.data.d fID;
    private boolean fIn;
    private boolean fIp;
    private String fLg;
    private boolean fLh;
    private boolean fLi;
    private Parcelable fLj;
    private boolean fLk;
    private PostData fLl;
    private PostData fLm;
    private int fLn;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bfL().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bfL().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bfL().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bfL().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    aj.bfL().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static aj fLo = new aj();
    }

    public static aj bfL() {
        return a.fLo;
    }

    private aj() {
        this.fLg = null;
        this.fLh = false;
        this.fID = null;
        this.fLi = false;
        this.fLj = null;
        this.fIp = true;
        this.fIn = false;
        this.fLk = false;
    }

    public void M(String str, boolean z) {
        this.fLh = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.fLg = null;
        } else if (!str.equals(this.fLg)) {
            reset();
            this.fLg = str;
        } else {
            this.fLh = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.fLh) {
            this.fLi = false;
            return null;
        } else if (this.fID != null && this.fID.bbL() != null && this.fID.bbL().size() > 0) {
            this.fLi = true;
            com.baidu.tieba.pb.data.d dVar = this.fID;
            this.fID = null;
            return dVar;
        } else {
            this.fLi = false;
            this.fID = null;
            return null;
        }
    }

    public Parcelable bfM() {
        if (this.fLi) {
            this.fLi = false;
            Parcelable parcelable = this.fLj;
            this.fLj = null;
            return parcelable;
        }
        this.fLj = null;
        return null;
    }

    public int bfN() {
        return this.fLn;
    }

    public void rm(int i) {
        this.fLn = i;
    }

    public PostData bfO() {
        return this.fLm;
    }

    public void i(PostData postData) {
        this.fLm = postData;
    }

    public PostData bfP() {
        return this.fLl;
    }

    public void j(PostData postData) {
        this.fLl = postData;
    }

    public boolean beE() {
        return this.fIp;
    }

    public boolean bfQ() {
        return this.fIn;
    }

    public boolean bfR() {
        return this.fLk;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.fLh = false;
        if (this.fLg == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bbL() == null) {
            reset();
            return false;
        } else if (dVar.bbL().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fID = dVar;
            this.fLi = false;
            this.fLj = parcelable;
            this.fIp = z;
            this.fIn = z2;
            this.fLk = z3;
            return true;
        }
    }

    public void reset() {
        this.fLh = false;
        this.fID = null;
        this.fLi = false;
        this.fLj = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fID != null && this.fID.bbH() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.fID.bbH().getId(), 0L)) {
                this.fID.bbH().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fID != null && this.fID.bbL() != null && this.fID.bbL().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fID.bbL().size();
                for (int i = 0; i < size; i++) {
                    if (this.fID.bbL().get(i) != null && this.fID.bbL().get(i).wm() != null && currentAccount.equals(this.fID.bbL().get(i).wm().getUserId()) && this.fID.bbL().get(i).wm().getPendantData() != null) {
                        this.fID.bbL().get(i).wm().getPendantData().dB(jVar.uW());
                        this.fID.bbL().get(i).wm().getPendantData().ad(jVar.Ip());
                    }
                }
            }
        }
    }
}
