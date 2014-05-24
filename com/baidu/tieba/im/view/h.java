package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HaloView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    public LinearLayout a;
    public Button b;
    public Context c;
    private HaloView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private String i;
    private boolean j;

    public h(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        a(context);
    }

    private void a(Context context) {
        this.c = context;
        LayoutInflater.from(context).inflate(w.chatterbox_view, (ViewGroup) this, true);
        this.b = (Button) findViewById(v.chat_select_btn);
        this.d = (HaloView) findViewById(v.haloView);
        this.e = (LinearLayout) findViewById(v.chat_view);
        this.f = (TextView) findViewById(v.chat_view_content_1);
        this.g = (TextView) findViewById(v.chat_view_content_2);
        this.h = (TextView) findViewById(v.chat_view_content_3);
    }

    public void a(boolean z, boolean z2) {
        boolean z3 = this.j;
        this.j = z;
        if (z2 || (!z3 && z3 != this.j)) {
            b();
        }
    }

    private void b() {
        this.i = null;
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.e.setVisibility(8);
        if (this.j) {
            setVisibility(0);
            this.d.setIsBlack(false);
            this.b.setVisibility(0);
            return;
        }
        setVisibility(8);
        this.d.setIsBlack(true);
        this.b.setVisibility(8);
    }

    public void setTitle(String str) {
        if (str == null || !str.equals(this.i)) {
            if (TextUtils.isEmpty(str)) {
                b();
                return;
            }
            setVisibility(0);
            this.b.setVisibility(8);
            this.d.setIsBlack(true);
            this.e.setVisibility(0);
            if (str.length() <= 7) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                this.f.setText(str);
            } else if (str.length() <= 13) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(8);
                String substring = str.substring(0, 7);
                String substring2 = str.substring(7, str.length());
                this.f.setText(substring);
                this.g.setText(substring2);
            } else {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                String substring3 = str.substring(0, 7);
                String substring4 = str.substring(7, 13);
                String substring5 = str.substring(13, str.length() <= 15 ? str.length() : 15);
                this.f.setText(substring3);
                this.g.setText(substring4);
                this.h.setText(substring5);
            }
            this.i = str;
        }
    }

    public boolean a(View view) {
        if (this.j) {
            return view == this.b || view == this.e;
        }
        return false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.b.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
    }

    public void a() {
        this.d.a();
    }
}
