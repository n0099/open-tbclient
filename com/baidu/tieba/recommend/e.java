package com.baidu.tieba.recommend;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.a aVar2;
        l lVar;
        if (((com.baidu.tieba.view.q) view).a()) {
            aVar = this.a.q;
            aVar.b();
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                return;
            }
            aVar2 = this.a.q;
            Bitmap a = aVar2.a((String) view.getTag(), new f(this));
            MainTabActivity mainTabActivity = null;
            if (this.a.getParent() != null && this.a.getParent().getParent() != null) {
                Activity parent = this.a.getParent().getParent();
                if (parent instanceof MainTabActivity) {
                    mainTabActivity = (MainTabActivity) parent;
                }
            }
            if (a != null && mainTabActivity != null) {
                mainTabActivity.a(a, false);
                return;
            }
            lVar = this.a.i;
            Bitmap c = lVar.a().c(String.valueOf((String) view.getTag()) + "_small");
            if (c == null || mainTabActivity == null) {
                return;
            }
            mainTabActivity.a(c, true);
        }
    }
}
