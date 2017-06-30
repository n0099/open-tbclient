package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ int[] ewn;
    private final /* synthetic */ int ewo;
    private final /* synthetic */ String ewp;
    private final /* synthetic */ String ewq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.ewh = pbActivity;
        this.ewn = iArr;
        this.ewo = i;
        this.ewp = str;
        this.ewq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ag = (com.baidu.adp.lib.util.k.ag(this.ewh.getPageContext().getPageActivity()) - this.ewn[1]) - this.ewo;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.ewh.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.ewh.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ag;
        if (i > 0) {
            this.ewh.aNy().getListView().smoothScrollBy(i, 0);
        }
        if (this.ewh.aNy().aQe() != null) {
            this.ewh.aNy().aQe().bK(this.ewp, this.ewq);
        }
        this.ewh.aNy().aQN();
    }
}
