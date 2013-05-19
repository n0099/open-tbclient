package com.baidu.tieba.more;

import com.baidu.tieba.c.an;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.a.e {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        z zVar;
        if (obj != null && (obj instanceof an) && obj == an.DO_CLEAR) {
            this.a.a(this.a.getString(R.string.image_cash_del_suc));
            zVar = this.a.c;
            zVar.p();
        }
    }
}
