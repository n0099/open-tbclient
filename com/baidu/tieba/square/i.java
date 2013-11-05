package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2365a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        Activity activity;
        Object tag = view.getTag();
        if ((tag instanceof l) && (sVar = ((l) tag).d) != null) {
            if (sVar.f2375a == null) {
                if (TiebaApplication.g().s()) {
                    activity = this.f2365a.b;
                    StatService.onEvent(activity, "sq_all_category", "click", 1);
                }
                BarFolderFirstDirActivity.a(this.f2365a.a());
                return;
            }
            ForumListActivity.a(this.f2365a.a(), sVar.b, sVar.f2375a, sVar.c);
        }
    }
}
