package com.baidu.tieba.im.widget;

import android.app.Activity;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
import protobuf.QueryPrize.QueryPrizeRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity) {
        this.a = activity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void onClick(com.baidu.tieba.view.dialog.a aVar) {
        QueryPrizeRes.PrizeInfo prizeInfo;
        QueryPrizeRes.PrizeInfo prizeInfo2;
        com.baidu.tieba.view.dialog.a aVar2;
        prizeInfo = a.b;
        if (prizeInfo != null) {
            Activity activity = this.a;
            prizeInfo2 = a.b;
            FacePackageDetailActivity.a(activity, prizeInfo2.getLink(), false, "from_egg_greaker");
            aVar2 = a.a;
            aVar2.c();
        }
    }
}
