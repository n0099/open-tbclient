package com.baidu.tieba.kn.ladders;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1185a;
    private final /* synthetic */ KnLaddersModel.PlayerInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, KnLaddersModel.PlayerInfo playerInfo) {
        this.f1185a = aVar;
        this.b = playerInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(view.getContext(), "kn_ladders_portrait", "click", 1);
        }
        FrsActivity.a(view.getContext(), this.b.forum_name, "KnLadders");
    }
}
