package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AbsListView.OnScrollListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.r;
        runnable = this.a.F;
        handler.removeCallbacks(runnable);
        handler2 = this.a.r;
        runnable2 = this.a.F;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Button button;
        GridView gridView;
        if (i == 2 || i == 1) {
            com.baidu.tieba.c.ai.a(this.a, absListView);
            button = this.a.h;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            gridView = this.a.j;
            gridView.setVisibility(8);
        }
    }
}
