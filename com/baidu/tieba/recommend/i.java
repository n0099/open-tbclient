package com.baidu.tieba.recommend;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AbsListView.OnScrollListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.q;
        runnable = this.a.s;
        handler.removeCallbacks(runnable);
        handler2 = this.a.q;
        runnable2 = this.a.s;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ListView listView;
        ListView listView2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        if (i == 0) {
            listView2 = this.a.i;
            onItemLongClickListener = this.a.t;
            listView2.setOnItemLongClickListener(onItemLongClickListener);
            return;
        }
        listView = this.a.i;
        listView.setOnItemLongClickListener(null);
    }
}
