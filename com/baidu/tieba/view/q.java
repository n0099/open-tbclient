package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1875a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Context context) {
        this.f1875a = pVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.f1875a.f1874a;
            FrsActivity.a(context2, obj, "");
            StatService.onEvent(this.b, "forum_feed_frsclick", "frs_click", 1);
            return;
        }
        v vVar = (v) view.getTag();
        if (vVar != null) {
            context = this.f1875a.f1874a;
            NewPbActivity.a(context, vVar.k, null, null);
            StatService.onEvent(this.b, "forum_feed_pbclick", "pb_click", 1);
        }
    }
}
