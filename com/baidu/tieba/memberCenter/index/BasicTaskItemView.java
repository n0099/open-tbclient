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
public class BasicTaskItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19001e;

    /* renamed from: f  reason: collision with root package name */
    public View f19002f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19003g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19004h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19005i;
    public TextView j;
    public View k;
    public View l;
    public View.OnClickListener m;

    public BasicTaskItemView(Context context) {
        super(context);
        this.f19001e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f19001e).inflate(R.layout.index_task_item, this);
        this.f19002f = inflate;
        this.l = inflate.findViewById(R.id.ly_desc);
        this.f19003g = (TbImageView) this.f19002f.findViewById(R.id.task_icon);
        this.f19004h = (TextView) this.f19002f.findViewById(R.id.txt_title);
        this.f19005i = (TextView) this.f19002f.findViewById(R.id.txt_desc);
        TextView textView = (TextView) this.f19002f.findViewById(R.id.txt_status);
        this.j = textView;
        textView.setOnClickListener(this.m);
        this.l.setOnClickListener(this.m);
        this.k = this.f19002f.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19001e = context;
        a();
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f19001e = context;
        a();
    }
}
