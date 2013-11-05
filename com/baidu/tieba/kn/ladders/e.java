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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1745a;
    final /* synthetic */ KnLaddersModel.PlayerInfo b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, long j, KnLaddersModel.PlayerInfo playerInfo) {
        this.c = aVar;
        this.f1745a = j;
        this.b = playerInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        KnLaddersFragment knLaddersFragment;
        Activity activity4;
        if (!UtilHelper.b()) {
            activity4 = this.c.k;
            UtilHelper.a((Context) activity4, (int) R.string.neterror);
        } else if (this.f1745a <= 0) {
            String C = TiebaApplication.C();
            if ((C == null || C.length() <= 0) && DatabaseService.m() <= 0) {
                activity = this.c.k;
                activity2 = this.c.k;
                LoginActivity.a(activity, activity2.getString(R.string.login_to_shake), true, 11003);
                return;
            }
            if (TiebaApplication.g().s()) {
                StatService.onEvent(view.getContext(), "kn_ladders_support", "click", 1);
            }
            activity3 = this.c.k;
            ShakeActivity.a(activity3, String.valueOf(this.b.player_id), this.b.player_name, "KnLadders");
            knLaddersFragment = this.c.l;
            knLaddersFragment.a(true);
        }
    }
}
