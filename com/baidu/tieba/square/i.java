package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1725a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        Activity activity;
        Object tag = view.getTag();
        if ((tag instanceof k) && (rVar = ((k) tag).d) != null) {
            if (rVar.f1734a != null) {
                activity = this.f1725a.b;
                StatService.onEvent(activity, "ef_category", "click");
                BarFolderSecondDirActivity.a(this.f1725a.a(), rVar.b, rVar.f1734a, rVar.c);
                return;
            }
            BarFolderFirstDirActivity.a(this.f1725a.a());
        }
    }
}
