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
    public Context f18582e;

    /* renamed from: f  reason: collision with root package name */
    public View f18583f;

    /* renamed from: g  reason: collision with root package name */
    public View f18584g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18585h;
    public TextView i;
    public TextView j;
    public TbImageView k;

    public BasicSeperateBaMemberItemView(Context context) {
        super(context);
        this.f18582e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18582e).inflate(R.layout.index_seperate_ba_item, this);
        this.f18583f = inflate;
        this.f18584g = inflate.findViewById(R.id.ly_desc);
        this.f18585h = (TbImageView) this.f18583f.findViewById(R.id.task_icon);
        this.i = (TextView) this.f18583f.findViewById(R.id.txt_title);
        this.j = (TextView) this.f18583f.findViewById(R.id.txt_desc);
        this.k = (TbImageView) this.f18583f.findViewById(R.id.privilege_spread_icon);
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18582e = context;
        a();
    }

    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18582e = context;
        a();
    }
}
