package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f2004a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, Context context) {
        this.f2004a = qVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.f2004a.f2003a;
            FrsActivity.a(context2, obj, "");
            StatService.onEvent(this.b, "forum_feed_frsclick", "frs_click", 1);
            return;
        }
        w wVar = (w) view.getTag();
        if (wVar != null) {
            context = this.f2004a.f2003a;
            NewPbActivity.a(context, wVar.l, null, null);
            StatService.onEvent(this.b, "forum_feed_pbclick", "pb_click", 1);
        }
    }
}
