package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bFT;
    private int bFU;
    private boolean bFV;
    private boolean bFW;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bFT = null;
        this.bFU = 0;
        this.bFV = false;
        this.bFW = false;
    }

    public void ef(boolean z) {
        this.bFW = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.amM == null) {
            return 0;
        }
        return (this.bFV ? 1 : 0) + this.amM.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.amM == null || i < 0 || i >= this.amM.size()) {
            return null;
        }
        return this.amM.get(i);
    }

    public void S(String str, int i) {
        this.bFT = str;
        this.bFU = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int hC(String str) {
        if (this.amM == null) {
            return -1;
        }
        int size = this.amM.size();
        for (int i = 0; i < size; i++) {
            if (this.amM.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
