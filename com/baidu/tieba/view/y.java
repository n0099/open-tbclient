package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, Context context) {
        this.b = xVar;
        this.a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.b.a;
            FrsActivity.a(context2, obj, "");
            StatService.onEvent(this.a, "forum_feed_frsclick", "frs_click", 1);
            return;
        }
        aa aaVar = (aa) view.getTag();
        if (aaVar != null) {
            context = this.b.a;
            NewPbActivity.a(context, aaVar.l, (String) null, (String) null);
            StatService.onEvent(this.a, "forum_feed_pbclick", "pb_click", 1);
        }
    }
}
