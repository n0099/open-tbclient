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
import d.a.n0.r.u.c;
/* loaded from: classes5.dex */
public class WritePrefixItemLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21953e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21954f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21955g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21956h;

    /* renamed from: i  reason: collision with root package name */
    public View f21957i;

    public WritePrefixItemLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(this.f21953e).inflate(R.layout.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.f21954f = (TextView) findViewById(R.id.prefix_text);
        this.f21955g = (TextView) findViewById(R.id.prefix_no_tip);
        this.f21956h = (ImageView) findViewById(R.id.prefix_checked);
        this.f21957i = findViewById(R.id.prefix_item_divider);
        this.f21954f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c.d(this.f21955g).s(R.color.CAM_X0109);
        this.f21956h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_set_list_ok16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setBackgroundColor(this.f21957i, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void b(boolean z) {
        if (z) {
            this.f21956h.setVisibility(0);
        } else {
            this.f21956h.setVisibility(8);
        }
    }

    public void c(boolean z) {
        this.f21955g.setVisibility(z ? 0 : 8);
    }

    public void setDividerStyle(boolean z) {
        if (z) {
            return;
        }
        ((LinearLayout.LayoutParams) this.f21957i.getLayoutParams()).setMargins(l.g(this.f21953e, R.dimen.ds30), 0, l.g(this.f21953e, R.dimen.ds30), 0);
    }

    public void setPrefixText(String str) {
        this.f21954f.setText(str);
    }

    public void setPrefixTextColor(int i2) {
        this.f21954f.setTextColor(i2);
    }

    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21953e = context;
        a();
    }
}
