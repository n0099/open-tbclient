package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ int[] eni;
    private final /* synthetic */ int enj;
    private final /* synthetic */ String enk;
    private final /* synthetic */ String enl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.enc = pbActivity;
        this.eni = iArr;
        this.enj = i;
        this.enk = str;
        this.enl = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ag = (com.baidu.adp.lib.util.k.ag(this.enc.getPageContext().getPageActivity()) - this.eni[1]) - this.enj;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.enc.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.enc.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ag;
        if (i > 0) {
            this.enc.aJE().getListView().smoothScrollBy(i, 0);
        }
        if (this.enc.aJE().aMg() != null) {
            this.enc.aJE().aMg().bH(this.enk, this.enl);
        }
        this.enc.aJE().aMP();
    }
}
