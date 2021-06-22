package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class UserDefineConfirmBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21090e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21091f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21092g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21093h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21094i;
    public TextView j;
    public View.OnClickListener k;
    public String l;

    public UserDefineConfirmBottomView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f21090e = context;
        LayoutInflater.from(context).inflate(R.layout.user_define_confirm_bottom_view, (ViewGroup) this, true);
        setOrientation(1);
        this.f21091f = (RelativeLayout) findViewById(R.id.confirm_btn_root);
        this.f21092g = (LinearLayout) findViewById(R.id.big_tbean_root);
        this.f21093h = (TextView) findViewById(R.id.big_tbean_toast_tv);
        this.f21094i = (TextView) findViewById(R.id.big_tbean_jump_tv);
        this.j = (TextView) findViewById(R.id.user_define_confirm_tv);
        this.f21091f.setOnClickListener(null);
    }

    public void b(boolean z) {
        if (z) {
            this.f21092g.setVisibility(0);
        } else {
            this.f21092g.setVisibility(4);
        }
    }

    public void setBigTbeanToastText(int i2) {
        String format = String.format(this.f21090e.getString(R.string.big_tbean_toast), StringHelper.numberUniform(i2));
        this.l = format;
        this.f21093h.setText(format);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f21094i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(this.k);
    }

    public void setPayEnabled(boolean z) {
        if (z) {
            this.f21093h.setText(this.l);
            this.f21093h.setGravity(3);
            b(true);
            this.j.setEnabled(true);
            this.f21092g.setVisibility(0);
            this.f21094i.setVisibility(0);
            return;
        }
        this.f21093h.setText(R.string.user_define_max_money);
        this.f21093h.setGravity(17);
        this.j.setEnabled(false);
        b(false);
        this.f21092g.setVisibility(0);
        this.f21094i.setVisibility(8);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
