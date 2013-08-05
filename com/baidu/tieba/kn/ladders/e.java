package com.baidu.tieba.kn.ladders;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
import com.baidu.tieba.kn.shake.ShakeActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1186a;
    private final /* synthetic */ long b;
    private final /* synthetic */ KnLaddersModel.PlayerInfo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, long j, KnLaddersModel.PlayerInfo playerInfo) {
        this.f1186a = aVar;
        this.b = j;
        this.c = playerInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        KnLaddersFragment knLaddersFragment;
        Activity activity5;
        activity = this.f1186a.k;
        if (NetWorkCore.a(activity) == NetWorkCore.NetworkState.UNAVAIL) {
            activity5 = this.f1186a.k;
            am.a((Context) activity5, (int) R.string.neterror);
        } else if (this.b <= 0) {
            String E = TiebaApplication.E();
            if ((E == null || E.length() <= 0) && DatabaseService.o() <= 0) {
                activity2 = this.f1186a.k;
                activity3 = this.f1186a.k;
                LoginActivity.a(activity2, activity3.getString(R.string.login_to_shake), true, 11003);
                return;
            }
            if (TiebaApplication.f().t()) {
                StatService.onEvent(view.getContext(), "kn_ladders_support", "click", 1);
            }
            activity4 = this.f1186a.k;
            ShakeActivity.a(activity4, String.valueOf(this.c.player_id), this.c.player_name, "KnLadders");
            knLaddersFragment = this.f1186a.l;
            knLaddersFragment.a(true);
        }
    }
}
