package com.baidu.tieba.recommend;

import android.graphics.Bitmap;
import android.widget.ListView;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.c.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        GuessActivity guessActivity;
        ListView listView;
        if (bitmap != null) {
            guessActivity = this.a.a;
            listView = guessActivity.i;
            com.baidu.tieba.view.q qVar = (com.baidu.tieba.view.q) listView.findViewWithTag(str);
            if (qVar != null) {
                qVar.invalidate();
            }
        }
    }
}
