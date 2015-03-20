package com.baidu.tieba.pb.richview.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class e implements a<View> {
    private float asH;
    private com.baidu.adp.lib.e.b<TextView> bOr = new com.baidu.adp.lib.e.b<>(new f(this), 8, 0);
    private Context context;

    public e(Context context) {
        this.asH = 0.0f;
        this.context = context;
        this.asH = 1.2f;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public int acx() {
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.richview.b.a
    /* renamed from: c */
    public TextView b(com.baidu.tieba.pb.richview.a.c cVar) {
        if (!(cVar instanceof com.baidu.tieba.pb.richview.a.f)) {
            return null;
        }
        TextView hz = this.bOr.hz();
        hz.setText(((com.baidu.tieba.pb.richview.a.f) cVar).acw());
        return hz;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public void O(View view) {
        if (view instanceof TextView) {
            this.bOr.j((TextView) view);
        }
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public boolean P(View view) {
        return view instanceof TextView;
    }
}
