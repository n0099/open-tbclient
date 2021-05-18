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
    public Context f18307e;

    /* renamed from: f  reason: collision with root package name */
    public View f18308f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18309g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18310h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f18311i;
    public TextView j;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.f18307e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18307e).inflate(R.layout.index_daily_item, this);
        this.f18308f = inflate;
        this.f18309g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        TbImageView tbImageView = (TbImageView) this.f18308f.findViewById(R.id.privilege_tag_icon);
        this.f18310h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18310h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f18311i = (PrivilegeTextView) this.f18308f.findViewById(R.id.privilege_title);
        this.j = (TextView) this.f18308f.findViewById(R.id.privilege_desc);
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18307e = context;
        a();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f18307e = context;
        a();
    }
}
