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
    final /* synthetic */ a f1250a;
    private final /* synthetic */ long b;
    private final /* synthetic */ KnLaddersModel.PlayerInfo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, long j, KnLaddersModel.PlayerInfo playerInfo) {
        this.f1250a = aVar;
        this.b = j;
        this.c = playerInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        KnLaddersFragment knLaddersFragment;
        Activity activity4;
        if (!UtilHelper.b()) {
            activity4 = this.f1250a.k;
            UtilHelper.a((Context) activity4, (int) R.string.neterror);
        } else if (this.b <= 0) {
            String C = TiebaApplication.C();
            if ((C == null || C.length() <= 0) && DatabaseService.m() <= 0) {
                activity = this.f1250a.k;
                activity2 = this.f1250a.k;
                LoginActivity.a(activity, activity2.getString(R.string.login_to_shake), true, 11003);
                return;
            }
            if (TiebaApplication.g().s()) {
                StatService.onEvent(view.getContext(), "kn_ladders_support", "click", 1);
            }
            activity3 = this.f1250a.k;
            ShakeActivity.a(activity3, String.valueOf(this.c.player_id), this.c.player_name, "KnLadders");
            knLaddersFragment = this.f1250a.l;
            knLaddersFragment.a(true);
        }
    }
}
