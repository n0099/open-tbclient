package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.u.c;
/* loaded from: classes5.dex */
public class WritePrefixItemLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21840e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21841f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21842g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21843h;

    /* renamed from: i  reason: collision with root package name */
    public View f21844i;

    public WritePrefixItemLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(this.f21840e).inflate(R.layout.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.f21841f = (TextView) findViewById(R.id.prefix_text);
        this.f21842g = (TextView) findViewById(R.id.prefix_no_tip);
        this.f21843h = (ImageView) findViewById(R.id.prefix_checked);
        this.f21844i = findViewById(R.id.prefix_item_divider);
        this.f21841f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c.d(this.f21842g).q(R.color.CAM_X0109);
        this.f21843h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_set_list_ok16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setBackgroundColor(this.f21844i, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void b(boolean z) {
        if (z) {
            this.f21843h.setVisibility(0);
        } else {
            this.f21843h.setVisibility(8);
        }
    }

    public void c(boolean z) {
        this.f21842g.setVisibility(z ? 0 : 8);
    }

    public void setDividerStyle(boolean z) {
        if (z) {
            return;
        }
        ((LinearLayout.LayoutParams) this.f21844i.getLayoutParams()).setMargins(l.g(this.f21840e, R.dimen.ds30), 0, l.g(this.f21840e, R.dimen.ds30), 0);
    }

    public void setPrefixText(String str) {
        this.f21841f.setText(str);
    }

    public void setPrefixTextColor(int i2) {
        this.f21841f.setTextColor(i2);
    }

    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21840e = context;
        a();
    }
}
