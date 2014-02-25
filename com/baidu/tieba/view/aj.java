package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, Context context) {
        this.a = aiVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.a.a;
            FrsActivity.a(context2, obj, "");
            com.baidu.tieba.util.cb.a(this.b, "forum_feed_frsclick", "frs_click", 1, new Object[0]);
            return;
        }
        al alVar = (al) view.getTag();
        if (alVar != null) {
            context = this.a.a;
            NewPbActivity.a(context, alVar.l, (String) null, (String) null);
            com.baidu.tieba.util.cb.a(this.b, "forum_feed_pbclick", "pb_click", 1, new Object[0]);
        }
    }
}
