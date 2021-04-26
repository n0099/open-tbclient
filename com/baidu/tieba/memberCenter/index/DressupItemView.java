package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class DressupItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19024e;

    /* renamed from: f  reason: collision with root package name */
    public View f19025f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19026g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f19027h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19028i;
    public TextView j;

    public DressupItemView(Context context) {
        super(context);
        this.f19024e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f19024e).inflate(R.layout.index_dressup_item, this);
        this.f19025f = inflate;
        this.f19026g = (TbImageView) inflate.findViewById(R.id.bg_image);
        TbImageView tbImageView = (TbImageView) this.f19025f.findViewById(R.id.permission_icon);
        this.f19027h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f19027h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f19028i = (TextView) this.f19025f.findViewById(R.id.txt_type);
        this.j = (TextView) this.f19025f.findViewById(R.id.txt_name);
    }

    public DressupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19024e = context;
        a();
    }

    public DressupItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f19024e = context;
        a();
    }
}
