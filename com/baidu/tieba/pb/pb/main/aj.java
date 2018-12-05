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
    private boolean fYe;
    private boolean fYg;
    private com.baidu.tieba.pb.data.d fYu;
    private String gaX;
    private boolean gaY;
    private boolean gaZ;
    private Parcelable gba;
    private boolean gbb;
    private PostData gbc;
    private PostData gbd;
    private int gbe;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkm().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004006) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkm().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkm().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bkm().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                    aj.bkm().a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static aj gbf = new aj();
    }

    public static aj bkm() {
        return a.gbf;
    }

    private aj() {
        this.gaX = null;
        this.gaY = false;
        this.fYu = null;
        this.gaZ = false;
        this.gba = null;
        this.fYg = true;
        this.fYe = false;
        this.gbb = false;
    }

    public void V(String str, boolean z) {
        this.gaY = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.gaX = null;
        } else if (!str.equals(this.gaX)) {
            reset();
            this.gaX = str;
        } else {
            this.gaY = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.gaY) {
            this.gaZ = false;
            return null;
        } else if (this.fYu != null && this.fYu.bgm() != null && this.fYu.bgm().size() > 0) {
            this.gaZ = true;
            com.baidu.tieba.pb.data.d dVar = this.fYu;
            this.fYu = null;
            return dVar;
        } else {
            this.gaZ = false;
            this.fYu = null;
            return null;
        }
    }

    public Parcelable bkn() {
        if (this.gaZ) {
            this.gaZ = false;
            Parcelable parcelable = this.gba;
            this.gba = null;
            return parcelable;
        }
        this.gba = null;
        return null;
    }

    public int bko() {
        return this.gbe;
    }

    public void sw(int i) {
        this.gbe = i;
    }

    public PostData bkp() {
        return this.gbd;
    }

    public void i(PostData postData) {
        this.gbd = postData;
    }

    public PostData bkq() {
        return this.gbc;
    }

    public void j(PostData postData) {
        this.gbc = postData;
    }

    public boolean bjf() {
        return this.fYg;
    }

    public boolean bkr() {
        return this.fYe;
    }

    public boolean bks() {
        return this.gbb;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.gaY = false;
        if (this.gaX == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bgm() == null) {
            reset();
            return false;
        } else if (dVar.bgm().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.fYu = dVar;
            this.gaZ = false;
            this.gba = parcelable;
            this.fYg = z;
            this.fYe = z2;
            this.gbb = z3;
            return true;
        }
    }

    public void reset() {
        this.gaY = false;
        this.fYu = null;
        this.gaZ = false;
        this.gba = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.fYu != null && this.fYu.bgi() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.d(this.fYu.bgi().getId(), 0L)) {
                this.fYu.bgi().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fYu != null && this.fYu.bgm() != null && this.fYu.bgm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fYu.bgm().size();
                for (int i = 0; i < size; i++) {
                    if (this.fYu.bgm().get(i) != null && this.fYu.bgm().get(i).zG() != null && currentAccount.equals(this.fYu.bgm().get(i).zG().getUserId()) && this.fYu.bgm().get(i).zG().getPendantData() != null) {
                        this.fYu.bgm().get(i).zG().getPendantData().ej(jVar.ys());
                        this.fYu.bgm().get(i).zG().getPendantData().ao(jVar.LE());
                    }
                }
            }
        }
    }
}
