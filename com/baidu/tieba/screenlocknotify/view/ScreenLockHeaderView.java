package com.baidu.tieba.screenlocknotify.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.k0.u2.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes5.dex */
public class ScreenLockHeaderView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20407e;

    /* renamed from: f  reason: collision with root package name */
    public View f20408f;

    /* renamed from: g  reason: collision with root package name */
    public View f20409g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20410h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20411i;
    public TextView j;
    public View k;
    public d l;
    public TextView m;
    public EditText n;
    public RelativeLayout o;

    public ScreenLockHeaderView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.screenlock_show_item_header, (ViewGroup) this, true);
        this.f20407e = (TextView) findViewById(R.id.friend_name_show1);
        this.f20408f = findViewById(R.id.friend_name_layout);
        this.f20409g = findViewById(R.id.msg_content_layout);
        this.f20410h = (TextView) findViewById(R.id.last_msg_time_show1);
        this.f20411i = (TextView) findViewById(R.id.one_msg_content_show1);
        this.j = (TextView) findViewById(R.id.unread_msg_count_show1);
        this.k = findViewById(R.id.line);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.screen_notify_item_background);
        setOrientation(1);
        this.o = (RelativeLayout) findViewById(R.id.screenlock_input_layout);
        this.m = (TextView) findViewById(R.id.screenlock_send_button);
        this.n = (EditText) findViewById(R.id.screenlock_edit_view);
        this.o.setVisibility(8);
    }

    public String a(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String b(int i2) {
        if (i2 < 100) {
            return "" + i2;
        }
        return "99+";
    }

    public void c(boolean z) {
        if (z) {
            this.o.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.o.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void d(d dVar) {
        this.l = dVar;
        this.f20407e.setText(dVar.f62171a);
        this.f20410h.setText(a(dVar.l));
        this.f20411i.setText(dVar.f62175e);
        this.j.setText(b(dVar.f62179i));
    }

    public d getData() {
        return this.l;
    }

    public View getEditText() {
        return this.n;
    }

    public String getInputMsg() {
        EditText editText = this.n;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.m.setOnClickListener(onClickListener);
        this.f20408f.setOnClickListener(onClickListener2);
        this.f20409g.setOnClickListener(onClickListener2);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
