package com.baidu.tieba.nearby;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1180a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NearbyPbActivity nearbyPbActivity) {
        this.f1180a = nearbyPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1180a.q;
        runnable = this.f1180a.E;
        handler.removeCallbacks(runnable);
        handler2 = this.f1180a.q;
        runnable2 = this.f1180a.E;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Button button;
        GridView gridView;
        if (i == 2 || i == 1) {
            com.baidu.tieba.util.ab.a(this.f1180a, absListView);
            button = this.f1180a.e;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            gridView = this.f1180a.g;
            gridView.setVisibility(8);
        }
    }
}
