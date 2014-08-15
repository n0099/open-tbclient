package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String i;
    private int j;
    private boolean k;
    private boolean l;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.i = null;
        this.j = 0;
        this.k = false;
        this.l = false;
    }

    public void d(boolean z) {
        this.l = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return (this.k ? 1 : 0) + this.a.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    public void a(String str, int i) {
        this.i = str;
        this.j = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int a(String str) {
        if (this.a == null) {
            return -1;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).d().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
