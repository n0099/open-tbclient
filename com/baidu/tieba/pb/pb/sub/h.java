package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class h extends a {
    private String bNR;
    private int bNS;
    private boolean bNT;
    private boolean bNU;

    public h(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.bNR = null;
        this.bNS = 0;
        this.bNT = false;
        this.bNU = false;
    }

    public void ea(boolean z) {
        this.bNU = z;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a, android.widget.Adapter
    public int getCount() {
        if (this.auK == null) {
            return 0;
        }
        return (this.bNT ? 1 : 0) + this.auK.size();
    }

    @Override // com.baidu.tieba.pb.pb.sub.a, android.widget.Adapter
    public Object getItem(int i) {
        if (this.auK == null || i < 0 || i >= this.auK.size()) {
            return null;
        }
        return this.auK.get(i);
    }

    public void P(String str, int i) {
        this.bNR = str;
        this.bNS = i;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a
    public int hP(String str) {
        if (this.auK == null) {
            return -1;
        }
        int size = this.auK.size();
        for (int i = 0; i < size; i++) {
            if (this.auK.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
