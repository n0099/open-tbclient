package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BasicSeperateBaMemberItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18352e;

    /* renamed from: f  reason: collision with root package name */
    public View f18353f;

    /* renamed from: g  reason: collision with root package name */
    public View f18354g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18355h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18356i;
    public TextView j;
    public TbImageView k;

    public BasicSeperateBaMemberItemView(Context context) {
        super(context);
        this.f18352e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18352e).inflate(R.layout.index_seperate_ba_item, this);
        this.f18353f = inflate;
        this.f18354g = inflate.findViewById(R.id.ly_desc);
        this.f18355h = (TbImageView) this.f18353f.findViewById(R.id.task_icon);
        this.f18356i = (TextView) this.f18353f.findViewById(R.id.txt_title);
        this.j = (TextView) this.f18353f.findViewById(R.id.txt_desc);
        this.k = (TbImageView) this.f18353f.findViewById(R.id.privilege_spread_icon);
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18352e = context;
        a();
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18352e = context;
        a();
    }
}
