package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ int[] elT;
    private final /* synthetic */ int elU;
    private final /* synthetic */ String elV;
    private final /* synthetic */ String elW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.elO = pbActivity;
        this.elT = iArr;
        this.elU = i;
        this.elV = str;
        this.elW = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int g;
        int ah = (com.baidu.adp.lib.util.k.ah(this.elO.getPageContext().getPageActivity()) - this.elT[1]) - this.elU;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            g = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(this.elO.getPageContext().getPageActivity(), w.f.ds120);
        } else {
            g = com.baidu.adp.lib.util.k.g(this.elO.getPageContext().getPageActivity(), w.f.ds640);
        }
        int i = g - ah;
        if (i > 0) {
            this.elO.aKj().getListView().smoothScrollBy(i, 0);
        }
        if (this.elO.aKj().aMJ() != null) {
            this.elO.aKj().aMJ().bM(this.elV, this.elW);
        }
        this.elO.aKj().aNu();
    }
}
