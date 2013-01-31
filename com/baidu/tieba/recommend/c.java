package com.baidu.tieba.recommend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.a.av;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        l lVar = (l) ((ListView) adapterView).getAdapter();
        long itemId = lVar.getItemId(i);
        if (itemId != -1 && itemId != -2) {
            av avVar = (av) lVar.getItem(i);
            this.a.f = avVar.b();
            this.a.b(avVar);
            this.a.c.show();
            return false;
        }
        return false;
    }
}
