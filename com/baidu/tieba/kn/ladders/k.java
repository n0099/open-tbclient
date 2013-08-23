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
    final /* synthetic */ KnLaddersBannerAdapter f1221a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(KnLaddersBannerAdapter knLaddersBannerAdapter, int i) {
        this.f1221a = knLaddersBannerAdapter;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        KnLaddersModel.Pic[] picArr;
        if (TiebaApplication.g().u()) {
            StatService.onEvent(view.getContext(), "kn_ladders_banner", "click", 1);
        }
        Context context = view.getContext();
        picArr = this.f1221a.f1207a;
        UtilHelper.a(context, picArr[this.b].link_url, "");
    }
}
