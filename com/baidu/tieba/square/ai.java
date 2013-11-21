package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.forumdetail.ForumDetailData;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private aj f2362a;
    private ForumDetailData.ThreadInfo[] b = null;

    public ai(Context context) {
        this.f2362a = null;
        this.f2362a = new aj(context);
    }

    public void a(ForumDetailData.ThreadInfo[] threadInfoArr) {
        this.b = threadInfoArr;
        if (this.f2362a != null) {
            this.f2362a.setData(threadInfoArr);
        }
    }

    public void a(int i) {
        if (this.f2362a != null) {
            this.f2362a.a(i);
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
        return this.f2362a;
    }
}
