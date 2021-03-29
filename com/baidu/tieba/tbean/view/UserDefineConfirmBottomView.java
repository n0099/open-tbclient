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
    public Context f21479e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21480f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21481g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21482h;
    public TextView i;
    public TextView j;
    public View.OnClickListener k;
    public String l;

    public UserDefineConfirmBottomView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f21479e = context;
        LayoutInflater.from(context).inflate(R.layout.user_define_confirm_bottom_view, (ViewGroup) this, true);
        setOrientation(1);
        this.f21480f = (RelativeLayout) findViewById(R.id.confirm_btn_root);
        this.f21481g = (LinearLayout) findViewById(R.id.big_tbean_root);
        this.f21482h = (TextView) findViewById(R.id.big_tbean_toast_tv);
        this.i = (TextView) findViewById(R.id.big_tbean_jump_tv);
        this.j = (TextView) findViewById(R.id.user_define_confirm_tv);
        this.f21480f.setOnClickListener(null);
    }

    public void b(boolean z) {
        if (z) {
            this.f21481g.setVisibility(0);
        } else {
            this.f21481g.setVisibility(4);
        }
    }

    public void setBigTbeanToastText(int i) {
        String format = String.format(this.f21479e.getString(R.string.big_tbean_toast), StringHelper.numberUniform(i));
        this.l = format;
        this.f21482h.setText(format);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(this.k);
    }

    public void setPayEnabled(boolean z) {
        if (z) {
            this.f21482h.setText(this.l);
            this.f21482h.setGravity(3);
            b(true);
            this.j.setEnabled(true);
            this.f21481g.setVisibility(0);
            this.i.setVisibility(0);
            return;
        }
        this.f21482h.setText(R.string.user_define_max_money);
        this.f21482h.setGravity(17);
        this.j.setEnabled(false);
        b(false);
        this.f21481g.setVisibility(0);
        this.i.setVisibility(8);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
