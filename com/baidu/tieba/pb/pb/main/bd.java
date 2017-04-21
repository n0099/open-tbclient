package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ int[] emp;
    private final /* synthetic */ int emq;
    private final /* synthetic */ String emr;
    private final /* synthetic */ String ems;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.emk = pbActivity;
        this.emp = iArr;
        this.emq = i;
        this.emr = str;
        this.ems = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ag = (com.baidu.adp.lib.util.k.ag(this.emk.getPageContext().getPageActivity()) - this.emp[1]) - this.emq;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.emk.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.emk.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ag;
        if (i > 0) {
            this.emk.aLr().getListView().smoothScrollBy(i, 0);
        }
        if (this.emk.aLr().aNT() != null) {
            this.emk.aLr().aNT().bK(this.emr, this.ems);
        }
        this.emk.aLr().aOE();
    }
}
