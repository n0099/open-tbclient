package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Runnable {
    private final /* synthetic */ int[] ehD;
    private final /* synthetic */ int ehE;
    private final /* synthetic */ String ehF;
    private final /* synthetic */ String ehG;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.ehy = pbActivity;
        this.ehD = iArr;
        this.ehE = i;
        this.ehF = str;
        this.ehG = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ag = (com.baidu.adp.lib.util.k.ag(this.ehy.getPageContext().getPageActivity()) - this.ehD[1]) - this.ehE;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.ehy.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.ehy.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ag;
        if (i > 0) {
            this.ehy.aIM().getListView().smoothScrollBy(i, 0);
        }
        if (this.ehy.aIM().aLk() != null) {
            this.ehy.aIM().aLk().bJ(this.ehF, this.ehG);
        }
        this.ehy.aIM().aLV();
    }
}
