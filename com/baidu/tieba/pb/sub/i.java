package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class i extends b {
    private String j;
    private int k;
    private boolean l;
    private boolean m;

    public i(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.j = null;
        this.k = 0;
        this.l = false;
        this.m = false;
    }

    public void d(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.tieba.pb.sub.b, android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return (this.l ? 1 : 0) + this.a.size();
    }

    @Override // com.baidu.tieba.pb.sub.b, android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    public void a(String str, int i) {
        this.j = str;
        this.k = i;
    }

    @Override // com.baidu.tieba.pb.sub.b
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
