package com.baidu.tieba.im.widget;

import android.app.Activity;
import com.baidu.tbadk.core.b.i;
import protobuf.QueryPrize.QueryPrizeRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.tbadk.core.dialog.c {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity) {
        this.a = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public final void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        QueryPrizeRes.PrizeInfo prizeInfo;
        QueryPrizeRes.PrizeInfo prizeInfo2;
        com.baidu.tbadk.core.dialog.a aVar2;
        prizeInfo = a.b;
        if (prizeInfo != null) {
            Activity activity = this.a;
            prizeInfo2 = a.b;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new i(activity, prizeInfo2.getLink(), false, "from_egg_greaker")));
            aVar2 = a.a;
            aVar2.c();
        }
    }
}
