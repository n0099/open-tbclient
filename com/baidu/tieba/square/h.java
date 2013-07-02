package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Activity activity;
        Object tag = view.getTag();
        if ((tag instanceof j) && (qVar = ((j) tag).d) != null) {
            if (qVar.a != null) {
                activity = this.a.b;
                StatService.onEvent(activity, "ef_category", "click");
                BarFolderSecondDirActivity.a(this.a.a(), qVar.b, qVar.a, qVar.c);
                return;
            }
            BarFolderFirstDirActivity.a(this.a.a());
        }
    }
}
