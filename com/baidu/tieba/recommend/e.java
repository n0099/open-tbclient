package com.baidu.tieba.recommend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.a.ax;
/* loaded from: classes.dex */
class e implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        n nVar = (n) ((ListView) adapterView).getAdapter();
        long itemId = nVar.getItemId(i);
        if (itemId != -1 && itemId != -2) {
            ax axVar = (ax) nVar.getItem(i);
            this.a.f = axVar.b();
            this.a.b(axVar);
            this.a.c.show();
            return false;
        }
        return false;
    }
}
