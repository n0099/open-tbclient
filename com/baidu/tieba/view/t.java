package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2697a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, Context context) {
        this.b = sVar;
        this.f2697a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.b.f2696a;
            FrsActivity.a(context2, obj, "");
            StatService.onEvent(this.f2697a, "forum_feed_frsclick", "frs_click", 1);
            return;
        }
        v vVar = (v) view.getTag();
        if (vVar != null) {
            context = this.b.f2696a;
            NewPbActivity.a(context, vVar.l, null, null);
            StatService.onEvent(this.f2697a, "forum_feed_pbclick", "pb_click", 1);
        }
    }
}
