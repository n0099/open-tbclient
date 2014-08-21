package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        super/*android.widget.BaseAdapter*/.notifyDataSetChanged();
    }
}
