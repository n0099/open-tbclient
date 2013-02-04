package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements Runnable {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ GridView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(SubPbActivity subPbActivity, GridView gridView) {
        this.a = subPbActivity;
        this.b = gridView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
    }
}
