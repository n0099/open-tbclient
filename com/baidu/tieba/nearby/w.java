package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AbsListView.OnScrollListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.q;
        runnable = this.a.E;
        handler.removeCallbacks(runnable);
        handler2 = this.a.q;
        runnable2 = this.a.E;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Button button;
        GridView gridView;
        if (i == 2 || i == 1) {
            com.baidu.tieba.d.ag.a(this.a, absListView);
            button = this.a.g;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            gridView = this.a.i;
            gridView.setVisibility(8);
        }
    }
}
