package com.baidu.tieba.recommend;

import android.graphics.Bitmap;
import android.widget.ListView;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.c.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        GuessActivity guessActivity;
        ListView listView;
        if (bitmap == null) {
            return;
        }
        guessActivity = this.a.a;
        listView = guessActivity.h;
        com.baidu.tieba.view.q qVar = (com.baidu.tieba.view.q) listView.findViewWithTag(str);
        if (qVar != null) {
            qVar.invalidate();
        }
    }
}
