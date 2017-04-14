package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ int[] ejZ;
    private final /* synthetic */ int eka;
    private final /* synthetic */ String ekb;
    private final /* synthetic */ String ekc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.ejU = pbActivity;
        this.ejZ = iArr;
        this.eka = i;
        this.ekb = str;
        this.ekc = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ag = (com.baidu.adp.lib.util.k.ag(this.ejU.getPageContext().getPageActivity()) - this.ejZ[1]) - this.eka;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.ejU.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.ejU.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ag;
        if (i > 0) {
            this.ejU.aKq().getListView().smoothScrollBy(i, 0);
        }
        if (this.ejU.aKq().aMS() != null) {
            this.ejU.aKq().aMS().bL(this.ekb, this.ekc);
        }
        this.ejU.aKq().aND();
    }
}
