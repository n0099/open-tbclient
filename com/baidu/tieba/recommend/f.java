package com.baidu.tieba.recommend;

import android.app.Activity;
import android.graphics.Bitmap;
import com.baidu.tieba.MainTabActivity;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.c.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    @Override // com.baidu.tieba.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap, String str, boolean z) {
        GuessActivity guessActivity;
        MainTabActivity mainTabActivity;
        GuessActivity guessActivity2;
        com.baidu.tieba.c.a aVar;
        GuessActivity guessActivity3;
        com.baidu.tieba.c.a aVar2;
        GuessActivity guessActivity4;
        GuessActivity guessActivity5;
        guessActivity = this.a.a;
        if (guessActivity.getParent() != null) {
            guessActivity4 = this.a.a;
            if (guessActivity4.getParent().getParent() != null) {
                guessActivity5 = this.a.a;
                Activity parent = guessActivity5.getParent().getParent();
                if (parent instanceof MainTabActivity) {
                    mainTabActivity = (MainTabActivity) parent;
                    if (bitmap != null) {
                        guessActivity2 = this.a.a;
                        aVar = guessActivity2.r;
                        if (aVar != null) {
                            guessActivity3 = this.a.a;
                            aVar2 = guessActivity3.r;
                            aVar2.b();
                        }
                        if (mainTabActivity != null) {
                            mainTabActivity.a();
                            return;
                        }
                        return;
                    } else if (mainTabActivity != null) {
                        mainTabActivity.a(bitmap, false);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        mainTabActivity = null;
        if (bitmap != null) {
        }
    }
}
