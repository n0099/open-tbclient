package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bNB;
    private int bNC;
    private boolean bND;
    private boolean bNE;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bNB = null;
        this.bNC = 0;
        this.bND = false;
        this.bNE = false;
    }

    public void ec(boolean z) {
        this.bNE = z;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return (this.bND ? 1 : 0) + this.auC.size();
    }

    @Override // com.baidu.tieba.pb.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.auC == null || i < 0 || i >= this.auC.size()) {
            return null;
        }
        return this.auC.get(i);
    }

    public void P(String str, int i) {
        this.bNB = str;
        this.bNC = i;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a
    public int hM(String str) {
        if (this.auC == null) {
            return -1;
        }
        int size = this.auC.size();
        for (int i = 0; i < size; i++) {
            if (this.auC.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
