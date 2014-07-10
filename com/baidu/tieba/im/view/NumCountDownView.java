package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NumCountDownView extends LinearLayout {
    private View a;
    private TextView b;
    private TextView c;
    private String d;
    private String e;
    private com.baidu.tbadk.coreExtra.c.c f;
    private m g;

    public NumCountDownView(Context context) {
        super(context);
        a(context);
    }

    public NumCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(Context context) {
        this.a = LayoutInflater.from(context).inflate(w.num_count_down_view, this);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.num_count_down_width), -2));
        setOrientation(0);
        setMinimumHeight(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.num_count_down_min_height));
        this.a.setBackgroundResource(com.baidu.tieba.u.bg_chat_prompt);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.v.num_count_down_count);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.v.num_count_down_notice);
    }

    public void setNoticeText(String str) {
        this.e = str;
        this.c.setText(this.e);
    }

    public void a(long j, long j2) {
        this.f = new l(this, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.d = String.valueOf(String.valueOf(j / 1000)) + "\"";
        this.b.setText(this.d);
    }

    public void a() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void setOnFinishlistener(m mVar) {
        this.g = mVar;
    }
}
