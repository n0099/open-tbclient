package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, Context context) {
        this.b = afVar;
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
            com.baidu.tieba.util.by.a(this.a, "forum_feed_frsclick", "frs_click", 1, new Object[0]);
            return;
        }
        ai aiVar = (ai) view.getTag();
        if (aiVar != null) {
            context = this.b.a;
            NewPbActivity.a(context, aiVar.l, (String) null, (String) null);
            com.baidu.tieba.util.by.a(this.a, "forum_feed_pbclick", "pb_click", 1, new Object[0]);
        }
    }
}
