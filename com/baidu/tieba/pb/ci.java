package com.baidu.tieba.pb;

import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements AbsListView.OnScrollListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Button button;
        GridView gridView;
        if (i == 2 || i == 1) {
            com.baidu.tieba.c.ah.a(this.a, absListView);
            button = this.a.y;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            gridView = this.a.ad;
            gridView.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
