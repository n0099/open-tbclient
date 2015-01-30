package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bFU;
    private int bFV;
    private boolean bFW;
    private boolean bFX;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bFU = null;
        this.bFV = 0;
        this.bFW = false;
        this.bFX = false;
    }

    public void ef(boolean z) {
        this.bFX = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.amP == null) {
            return 0;
        }
        return (this.bFW ? 1 : 0) + this.amP.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.amP == null || i < 0 || i >= this.amP.size()) {
            return null;
        }
        return this.amP.get(i);
    }

    public void S(String str, int i) {
        this.bFU = str;
        this.bFV = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int hF(String str) {
        if (this.amP == null) {
            return -1;
        }
        int size = this.amP.size();
        for (int i = 0; i < size; i++) {
            if (this.amP.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
