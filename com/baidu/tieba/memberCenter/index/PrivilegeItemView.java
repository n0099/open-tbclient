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
    public Context f18316e;

    /* renamed from: f  reason: collision with root package name */
    public View f18317f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18318g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeTextView f18319h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18320i;

    public PrivilegeItemView(Context context) {
        super(context);
        this.f18316e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18316e).inflate(R.layout.index_privilege_item, this);
        this.f18317f = inflate;
        this.f18318g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        this.f18319h = (PrivilegeTextView) this.f18317f.findViewById(R.id.privilege_name);
        this.f18320i = (TextView) this.f18317f.findViewById(R.id.privilege_desc);
    }

    public PrivilegeTextView getPrivilegeName() {
        return this.f18319h;
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18316e = context;
        a();
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f18316e = context;
        a();
    }
}
