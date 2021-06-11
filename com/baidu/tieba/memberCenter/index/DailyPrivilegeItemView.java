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
    public Context f18293e;

    /* renamed from: f  reason: collision with root package name */
    public View f18294f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18295g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18296h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f18297i;
    public TextView j;

    public DailyPrivilegeItemView(Context context) {
        super(context);
        this.f18293e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18293e).inflate(R.layout.index_daily_item, this);
        this.f18294f = inflate;
        this.f18295g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        TbImageView tbImageView = (TbImageView) this.f18294f.findViewById(R.id.privilege_tag_icon);
        this.f18296h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f18296h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f18297i = (PrivilegeTextView) this.f18294f.findViewById(R.id.privilege_title);
        this.j = (TextView) this.f18294f.findViewById(R.id.privilege_desc);
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18293e = context;
        a();
    }

    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f18293e = context;
        a();
    }
}
