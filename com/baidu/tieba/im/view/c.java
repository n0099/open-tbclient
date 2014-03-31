package com.baidu.tieba.im.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class c {
    final /* synthetic */ a a;
    private View b;
    private LinearLayout c;
    private TextView d;
    private ImageView e;
    private String f = null;

    public c(a aVar, LayoutInflater layoutInflater) {
        this.a = aVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.b = layoutInflater.inflate(com.baidu.tieba.im.i.chatterbox_dialog_item, (ViewGroup) null);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.im.h.chatterbox_text);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.im.h.chatterbox_item_layout);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.im.h.chatterbox_selected);
    }

    public final boolean a(View view) {
        return this.c.equals(view);
    }

    public final void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public final String a() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void b(String str) {
        this.d.setText(str);
    }

    public final String b() {
        CharSequence text = this.d.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final View c() {
        return this.b;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }
}
