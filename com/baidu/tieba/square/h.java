package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1433a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Activity activity;
        Object tag = view.getTag();
        if ((tag instanceof j) && (qVar = ((j) tag).d) != null) {
            if (qVar.f1441a != null) {
                activity = this.f1433a.b;
                StatService.onEvent(activity, "ef_category", "click");
                BarFolderSecondDirActivity.a(this.f1433a.a(), qVar.b, qVar.f1441a, qVar.c);
                return;
            }
            BarFolderFirstDirActivity.a(this.f1433a.a());
        }
    }
}
