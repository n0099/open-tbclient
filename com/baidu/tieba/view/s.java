package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2596a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, Context context) {
        this.b = rVar;
        this.f2596a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.b.f2595a;
            FrsActivity.a(context2, obj, "");
            StatService.onEvent(this.f2596a, "forum_feed_frsclick", "frs_click", 1);
            return;
        }
        u uVar = (u) view.getTag();
        if (uVar != null) {
            context = this.b.f2595a;
            NewPbActivity.a(context, uVar.l, null, null);
            StatService.onEvent(this.f2596a, "forum_feed_pbclick", "pb_click", 1);
        }
    }
}
