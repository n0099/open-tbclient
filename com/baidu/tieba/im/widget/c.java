package com.baidu.tieba.im.widget;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.view.dialog.c {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public final void onClick(com.baidu.tieba.view.dialog.a aVar) {
        com.baidu.tieba.view.dialog.a aVar2;
        if (this.a == 1) {
            UtilHelper.a(TiebaApplication.g().b(), (int) R.string.egg_breaker_tip_isee_tip);
        }
        aVar2 = a.a;
        aVar2.c();
    }
}
