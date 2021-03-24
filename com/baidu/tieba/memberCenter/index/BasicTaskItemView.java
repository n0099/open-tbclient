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
    public Context f18900e;

    /* renamed from: f  reason: collision with root package name */
    public View f18901f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18902g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18903h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public View.OnClickListener m;

    public BasicTaskItemView(Context context) {
        super(context);
        this.f18900e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18900e).inflate(R.layout.index_task_item, this);
        this.f18901f = inflate;
        this.l = inflate.findViewById(R.id.ly_desc);
        this.f18902g = (TbImageView) this.f18901f.findViewById(R.id.task_icon);
        this.f18903h = (TextView) this.f18901f.findViewById(R.id.txt_title);
        this.i = (TextView) this.f18901f.findViewById(R.id.txt_desc);
        TextView textView = (TextView) this.f18901f.findViewById(R.id.txt_status);
        this.j = textView;
        textView.setOnClickListener(this.m);
        this.l.setOnClickListener(this.m);
        this.k = this.f18901f.findViewById(R.id.divider_line);
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18900e = context;
        a();
    }

    public BasicTaskItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18900e = context;
        a();
    }
}
