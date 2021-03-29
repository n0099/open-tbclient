package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class DailyPrivilegeItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18916e;

    /* renamed from: f  reason: collision with root package name */
    public View f18917f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18918g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18919h;
    public PrivilegeTextView i;
    public TextView j;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.f18916e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18916e).inflate(R.layout.index_daily_item, this);
        this.f18917f = inflate;
        this.f18918g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        TbImageView tbImageView = (TbImageView) this.f18917f.findViewById(R.id.privilege_tag_icon);
        this.f18919h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18919h.setDefaultBgResource(R.drawable.transparent_bg);
        this.i = (PrivilegeTextView) this.f18917f.findViewById(R.id.privilege_title);
        this.j = (TextView) this.f18917f.findViewById(R.id.privilege_desc);
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18916e = context;
        a();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18916e = context;
        a();
    }
}
