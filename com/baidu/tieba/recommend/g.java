package com.baidu.tieba.recommend;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.a aVar2;
        n nVar;
        if (((com.baidu.tieba.view.q) view).a()) {
            aVar = this.a.r;
            aVar.b();
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                aVar2 = this.a.r;
                Bitmap a = aVar2.a((String) view.getTag(), new h(this));
                MainTabActivity mainTabActivity = null;
                if (this.a.getParent() != null && this.a.getParent().getParent() != null) {
                    Activity parent = this.a.getParent().getParent();
                    if (parent instanceof MainTabActivity) {
                        mainTabActivity = (MainTabActivity) parent;
                    }
                }
                if (a == null || mainTabActivity == null) {
                    nVar = this.a.j;
                    Bitmap c = nVar.a().c(String.valueOf((String) view.getTag()) + "_small");
                    if (c != null && mainTabActivity != null) {
                        mainTabActivity.a(c, true);
                        return;
                    }
                    return;
                }
                mainTabActivity.a(a, false);
            }
        }
    }
}
