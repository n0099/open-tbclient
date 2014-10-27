package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bAi;
    private int bAj;
    private boolean bAk;
    private boolean bAl;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bAi = null;
        this.bAj = 0;
        this.bAk = false;
        this.bAl = false;
    }

    public void eo(boolean z) {
        this.bAl = z;
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.aew == null) {
            return 0;
        }
        return (this.bAk ? 1 : 0) + this.aew.size();
    }

    @Override // com.baidu.tieba.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew == null || i < 0 || i >= this.aew.size()) {
            return null;
        }
        return this.aew.get(i);
    }

    public void L(String str, int i) {
        this.bAi = str;
        this.bAj = i;
    }

    @Override // com.baidu.tieba.pb.sub.a
    public int gZ(String str) {
        if (this.aew == null) {
            return -1;
        }
        int size = this.aew.size();
        for (int i = 0; i < size; i++) {
            if (this.aew.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
