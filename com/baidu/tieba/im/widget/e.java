package com.baidu.tieba.im.widget;

import android.app.Activity;
import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
import protobuf.QueryPrize.QueryPrizeRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements com.baidu.tieba.view.dialog.c {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Activity activity) {
        this.a = activity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public final void onClick(com.baidu.tieba.view.dialog.a aVar) {
        QueryPrizeRes.PrizeInfo prizeInfo;
        QueryPrizeRes.PrizeInfo prizeInfo2;
        QueryPrizeRes.PrizeInfo prizeInfo3;
        QueryPrizeRes.PrizeInfo prizeInfo4;
        com.baidu.tieba.view.dialog.a aVar2;
        prizeInfo = a.b;
        if (prizeInfo != null) {
            prizeInfo2 = a.b;
            StringBuilder append = new StringBuilder(String.valueOf(prizeInfo2.getLink())).append("?prize_id=");
            prizeInfo3 = a.b;
            StringBuilder append2 = append.append(prizeInfo3.getPrizeId()).append("&op_time=");
            prizeInfo4 = a.b;
            TbWebViewActivity.a((Context) this.a, TiebaApplication.g().getString(R.string.egg_breaker_tip_real_title), append2.append(prizeInfo4.getOpTime()).toString(), false);
            aVar2 = a.a;
            aVar2.c();
        }
    }
}
