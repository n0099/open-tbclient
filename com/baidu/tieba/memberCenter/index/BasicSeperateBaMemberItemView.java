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
public class BasicSeperateBaMemberItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18270e;

    /* renamed from: f  reason: collision with root package name */
    public View f18271f;

    /* renamed from: g  reason: collision with root package name */
    public View f18272g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18273h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18274i;
    public TextView j;
    public TbImageView k;

    public BasicSeperateBaMemberItemView(Context context) {
        super(context);
        this.f18270e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18270e).inflate(R.layout.index_seperate_ba_item, this);
        this.f18271f = inflate;
        this.f18272g = inflate.findViewById(R.id.ly_desc);
        this.f18273h = (TbImageView) this.f18271f.findViewById(R.id.task_icon);
        this.f18274i = (TextView) this.f18271f.findViewById(R.id.txt_title);
        this.j = (TextView) this.f18271f.findViewById(R.id.txt_desc);
        this.k = (TbImageView) this.f18271f.findViewById(R.id.privilege_spread_icon);
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18270e = context;
        a();
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18270e = context;
        a();
    }
}
