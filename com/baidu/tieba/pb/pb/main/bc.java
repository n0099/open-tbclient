package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ int[] evQ;
    private final /* synthetic */ int evR;
    private final /* synthetic */ String evS;
    private final /* synthetic */ String evT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity, int[] iArr, int i, String str, String str2) {
        this.evL = pbActivity;
        this.evQ = iArr;
        this.evR = i;
        this.evS = str;
        this.evT = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int e;
        int L = (com.baidu.adp.lib.util.k.L(this.evL.getPageContext().getPageActivity()) - this.evQ[1]) - this.evR;
        if (TbadkCoreApplication.m9getInst().getKeyboardHeight() > 0) {
            e = TbadkCoreApplication.m9getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.e(this.evL.getPageContext().getPageActivity(), r.e.ds120);
        } else {
            e = com.baidu.adp.lib.util.k.e(this.evL.getPageContext().getPageActivity(), r.e.ds640);
        }
        int i = e - L;
        if (i > 0) {
            this.evL.aPc().PW().smoothScrollBy(i, 0);
        }
        if (this.evL.aPc().aRI() != null) {
            this.evL.aPc().aRI().bI(this.evS, this.evT);
        }
        this.evL.aPc().aSq();
    }
}
