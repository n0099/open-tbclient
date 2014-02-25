package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getId() == R.id.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.a.a;
            FrsActivity.a(context2, obj, "");
            return;
        }
        bb bbVar = (bb) view.getTag();
        if (bbVar != null) {
            context = this.a.a;
            NewPbActivity.a(context, bbVar.l, (String) null, (String) null);
        }
    }
}
