package com.baidu.tieba.im.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class c {
    final /* synthetic */ a a;
    private View b = null;
    private LinearLayout c = null;
    private TextView d = null;
    private ImageView e = null;
    private String f = null;

    public c(a aVar, LayoutInflater layoutInflater) {
        this.a = aVar;
        a(layoutInflater);
    }

    private void a(LayoutInflater layoutInflater) {
        this.b = layoutInflater.inflate(com.baidu.tieba.v.chatterbox_dialog_item, (ViewGroup) null);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.u.chatterbox_text);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.chatterbox_item_layout);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.u.chatterbox_selected);
    }

    public boolean a(View view) {
        return this.c.equals(view);
    }

    public void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public String a() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.d.setText(str);
    }

    public String b() {
        CharSequence text = this.d.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public View c() {
        return this.b;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }
}
