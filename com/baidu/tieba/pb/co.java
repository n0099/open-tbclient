package com.baidu.tieba.pb;

import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements Runnable {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        int i;
        listView = this.a.u;
        i = this.a.B;
        listView.setSelection(i + 1);
    }
}
