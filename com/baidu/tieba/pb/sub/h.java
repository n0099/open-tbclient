package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bEj;
    private int bEk;
    private boolean bEl;
    private boolean bEm;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bEj = null;
        this.bEk = 0;
        this.bEl = false;
        this.bEm = false;
    }

    public void dZ(boolean z) {
        this.bEm = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return (this.bEl ? 1 : 0) + this.mData.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    public void S(String str, int i) {
        this.bEj = str;
        this.bEk = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int hy(String str) {
        if (this.mData == null) {
            return -1;
        }
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (this.mData.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
