package com.baidu.tieba.im.widget;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tbadk.core.dialog.c {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public final void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        if (this.a == 1) {
            UtilHelper.a(TbadkApplication.j().b(), j.egg_breaker_tip_isee_tip);
        }
        aVar2 = a.a;
        aVar2.c();
    }
}
