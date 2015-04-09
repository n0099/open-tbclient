package com.baidu.tieba.pb.richview.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class e implements a<View> {
    private float asP;
    private com.baidu.adp.lib.e.b<TextView> bOH = new com.baidu.adp.lib.e.b<>(new f(this), 8, 0);
    private Context context;

    public e(Context context) {
        this.asP = 0.0f;
        this.context = context;
        this.asP = 1.2f;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public int acM() {
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.richview.b.a
    /* renamed from: c */
    public TextView b(com.baidu.tieba.pb.richview.a.c cVar) {
        if (!(cVar instanceof com.baidu.tieba.pb.richview.a.f)) {
            return null;
        }
        TextView hz = this.bOH.hz();
        hz.setText(((com.baidu.tieba.pb.richview.a.f) cVar).acL());
        return hz;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public void O(View view) {
        if (view instanceof TextView) {
            this.bOH.j((TextView) view);
        }
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public boolean P(View view) {
        return view instanceof TextView;
    }
}
