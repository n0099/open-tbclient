package com.baidu.yuyinala.privatemessage.session.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class c extends BaseAdapter {
    /* JADX INFO: Access modifiers changed from: protected */
    public View m(int i, View view) {
        ((SwipeListViewScroll) ((ViewGroup) view).getChildAt(0)).setIndex(i);
        return view;
    }
}
