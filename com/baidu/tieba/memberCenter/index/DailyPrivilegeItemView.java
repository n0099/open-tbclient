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
    public Context f18915e;

    /* renamed from: f  reason: collision with root package name */
    public View f18916f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18917g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18918h;
    public PrivilegeTextView i;
    public TextView j;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.f18915e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18915e).inflate(R.layout.index_daily_item, this);
        this.f18916f = inflate;
        this.f18917g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        TbImageView tbImageView = (TbImageView) this.f18916f.findViewById(R.id.privilege_tag_icon);
        this.f18918h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18918h.setDefaultBgResource(R.drawable.transparent_bg);
        this.i = (PrivilegeTextView) this.f18916f.findViewById(R.id.privilege_title);
        this.j = (TextView) this.f18916f.findViewById(R.id.privilege_desc);
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18915e = context;
        a();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18915e = context;
        a();
    }
}
