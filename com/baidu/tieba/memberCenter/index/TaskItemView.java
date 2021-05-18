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
public class TaskItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18338e;

    /* renamed from: f  reason: collision with root package name */
    public View f18339f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18340g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18341h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18342i;
    public TextView j;
    public View k;
    public View l;
    public View.OnClickListener m;

    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18338e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18338e).inflate(R.layout.index_task_item, this);
        this.f18339f = inflate;
        this.l = inflate.findViewById(R.id.ly_desc);
        this.f18340g = (TbImageView) this.f18339f.findViewById(R.id.task_icon);
        this.f18341h = (TextView) this.f18339f.findViewById(R.id.txt_title);
        this.f18342i = (TextView) this.f18339f.findViewById(R.id.txt_desc);
        TextView textView = (TextView) this.f18339f.findViewById(R.id.txt_status);
        this.j = textView;
        textView.setOnClickListener(this.m);
        this.l.setOnClickListener(this.m);
        this.k = this.f18339f.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        this.j.setOnClickListener(onClickListener);
        this.l.setOnClickListener(this.m);
    }

    public TaskItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f18338e = context;
        a();
    }
}
