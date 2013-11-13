package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.forumdetail.ForumDetailData;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private aj f2378a;
    private ForumDetailData.ThreadInfo[] b = null;

    public ai(Context context) {
        this.f2378a = null;
        this.f2378a = new aj(context);
    }

    public void a(ForumDetailData.ThreadInfo[] threadInfoArr) {
        this.b = threadInfoArr;
        if (this.f2378a != null) {
            this.f2378a.setData(threadInfoArr);
        }
    }

    public void a(int i) {
        if (this.f2378a != null) {
            this.f2378a.a(i);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.b == null || this.b.length <= 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f2378a;
    }
}
