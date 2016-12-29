package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ int[] eam;
    private final /* synthetic */ int ean;
    private final /* synthetic */ String eao;
    private final /* synthetic */ String eap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.eah = pbActivity;
        this.eam = iArr;
        this.ean = i;
        this.eao = str;
        this.eap = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int e;
        int J = (com.baidu.adp.lib.util.k.J(this.eah.getPageContext().getPageActivity()) - this.eam[1]) - this.ean;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            e = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.e(this.eah.getPageContext().getPageActivity(), r.e.ds120);
        } else {
            e = com.baidu.adp.lib.util.k.e(this.eah.getPageContext().getPageActivity(), r.e.ds640);
        }
        int i = e - J;
        if (i > 0) {
            this.eah.aJb().Pv().smoothScrollBy(i, 0);
        }
        if (this.eah.aJb().aLC() != null) {
            this.eah.aJb().aLC().bL(this.eao, this.eap);
        }
        this.eah.aJb().aMk();
    }
}
