package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bAw;
    private int bAx;
    private boolean bAy;
    private boolean bAz;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bAw = null;
        this.bAx = 0;
        this.bAy = false;
        this.bAz = false;
    }

    public void eo(boolean z) {
        this.bAz = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.aeE == null) {
            return 0;
        }
        return (this.bAy ? 1 : 0) + this.aeE.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.aeE == null || i < 0 || i >= this.aeE.size()) {
            return null;
        }
        return this.aeE.get(i);
    }

    public void L(String str, int i) {
        this.bAw = str;
        this.bAx = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int gZ(String str) {
        if (this.aeE == null) {
            return -1;
        }
        int size = this.aeE.size();
        for (int i = 0; i < size; i++) {
            if (this.aeE.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
