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
public class PrivilegeItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19042e;

    /* renamed from: f  reason: collision with root package name */
    public View f19043f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19044g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeTextView f19045h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19046i;

    public PrivilegeItemView(Context context) {
        super(context);
        this.f19042e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f19042e).inflate(R.layout.index_privilege_item, this);
        this.f19043f = inflate;
        this.f19044g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        this.f19045h = (PrivilegeTextView) this.f19043f.findViewById(R.id.privilege_name);
        this.f19046i = (TextView) this.f19043f.findViewById(R.id.privilege_desc);
    }

    public PrivilegeTextView getPrivilegeName() {
        return this.f19045h;
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19042e = context;
        a();
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f19042e = context;
        a();
    }
}
