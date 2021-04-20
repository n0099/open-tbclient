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
    public Context f18597e;

    /* renamed from: f  reason: collision with root package name */
    public View f18598f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18599g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18600h;
    public TextView i;
    public TextView j;

    public DressupItemView(Context context) {
        super(context);
        this.f18597e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18597e).inflate(R.layout.index_dressup_item, this);
        this.f18598f = inflate;
        this.f18599g = (TbImageView) inflate.findViewById(R.id.bg_image);
        TbImageView tbImageView = (TbImageView) this.f18598f.findViewById(R.id.permission_icon);
        this.f18600h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18600h.setDefaultBgResource(R.drawable.transparent_bg);
        this.i = (TextView) this.f18598f.findViewById(R.id.txt_type);
        this.j = (TextView) this.f18598f.findViewById(R.id.txt_name);
    }

    public DressupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18597e = context;
        a();
    }

    public DressupItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18597e = context;
        a();
    }
}
