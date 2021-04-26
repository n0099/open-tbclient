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
    public Context f19019e;

    /* renamed from: f  reason: collision with root package name */
    public View f19020f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19021g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f19022h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f19023i;
    public TextView j;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.f19019e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f19019e).inflate(R.layout.index_daily_item, this);
        this.f19020f = inflate;
        this.f19021g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        TbImageView tbImageView = (TbImageView) this.f19020f.findViewById(R.id.privilege_tag_icon);
        this.f19022h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f19022h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f19023i = (PrivilegeTextView) this.f19020f.findViewById(R.id.privilege_title);
        this.j = (TextView) this.f19020f.findViewById(R.id.privilege_desc);
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19019e = context;
        a();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f19019e = context;
        a();
    }
}
