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
    public Context f18298e;

    /* renamed from: f  reason: collision with root package name */
    public View f18299f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18300g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18301h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18302i;
    public TextView j;

    public DressupItemView(Context context) {
        super(context);
        this.f18298e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18298e).inflate(R.layout.index_dressup_item, this);
        this.f18299f = inflate;
        this.f18300g = (TbImageView) inflate.findViewById(R.id.bg_image);
        TbImageView tbImageView = (TbImageView) this.f18299f.findViewById(R.id.permission_icon);
        this.f18301h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18301h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f18302i = (TextView) this.f18299f.findViewById(R.id.txt_type);
        this.j = (TextView) this.f18299f.findViewById(R.id.txt_name);
    }

    public DressupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18298e = context;
        a();
    }

    public DressupItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f18298e = context;
        a();
    }
}
