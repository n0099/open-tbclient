package com.baidu.tieba.kn.ladders;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1750a;
    final /* synthetic */ KnLaddersBannerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(KnLaddersBannerAdapter knLaddersBannerAdapter, int i) {
        this.b = knLaddersBannerAdapter;
        this.f1750a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        KnLaddersModel.Pic[] picArr;
        if (TiebaApplication.g().s()) {
            StatService.onEvent(view.getContext(), "kn_ladders_banner", "click", 1);
        }
        Context context = view.getContext();
        picArr = this.b.f1736a;
        UtilHelper.a(context, picArr[this.f1750a].link_url, "");
    }
}
