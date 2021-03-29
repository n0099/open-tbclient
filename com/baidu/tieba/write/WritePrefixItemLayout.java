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
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes5.dex */
public class WritePrefixItemLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22232e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22233f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22234g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22235h;
    public View i;

    public WritePrefixItemLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(this.f22232e).inflate(R.layout.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.f22233f = (TextView) findViewById(R.id.prefix_text);
        this.f22234g = (TextView) findViewById(R.id.prefix_no_tip);
        this.f22235h = (ImageView) findViewById(R.id.prefix_checked);
        this.i = findViewById(R.id.prefix_item_divider);
        this.f22233f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c.a(this.f22234g).n(R.color.CAM_X0109);
        this.f22235h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_set_list_ok16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void b(boolean z) {
        if (z) {
            this.f22235h.setVisibility(0);
        } else {
            this.f22235h.setVisibility(8);
        }
    }

    public void c(boolean z) {
        this.f22234g.setVisibility(z ? 0 : 8);
    }

    public void setDividerStyle(boolean z) {
        if (z) {
            return;
        }
        ((LinearLayout.LayoutParams) this.i.getLayoutParams()).setMargins(l.g(this.f22232e, R.dimen.ds30), 0, l.g(this.f22232e, R.dimen.ds30), 0);
    }

    public void setPrefixText(String str) {
        this.f22233f.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.f22233f.setTextColor(i);
    }

    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22232e = context;
        a();
    }
}
