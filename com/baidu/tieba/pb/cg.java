package com.baidu.tieba.pb;

import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements AbsListView.OnScrollListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ GridView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(SubPbActivity subPbActivity, GridView gridView) {
        this.a = subPbActivity;
        this.b = gridView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Button button;
        if (i == 2 || i == 1) {
            com.baidu.tieba.c.ag.a(this.a, absListView);
            button = this.a.x;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            this.b.setVisibility(8);
        }
    }
}
