package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Runnable {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ int[] eja;
    private final /* synthetic */ int ejb;
    private final /* synthetic */ String ejc;
    private final /* synthetic */ String ejd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.eiV = pbActivity;
        this.eja = iArr;
        this.ejb = i;
        this.ejc = str;
        this.ejd = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int e;
        int J = (com.baidu.adp.lib.util.k.J(this.eiV.getPageContext().getPageActivity()) - this.eja[1]) - this.ejb;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            e = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.e(this.eiV.getPageContext().getPageActivity(), r.f.ds120);
        } else {
            e = com.baidu.adp.lib.util.k.e(this.eiV.getPageContext().getPageActivity(), r.f.ds640);
        }
        int i = e - J;
        if (i > 0) {
            this.eiV.aKO().getListView().smoothScrollBy(i, 0);
        }
        if (this.eiV.aKO().aNq() != null) {
            this.eiV.aKO().aNq().bT(this.ejc, this.ejd);
        }
        this.eiV.aKO().aOa();
    }
}
