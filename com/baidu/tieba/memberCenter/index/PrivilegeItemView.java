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
    public Context f18613e;

    /* renamed from: f  reason: collision with root package name */
    public View f18614f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18615g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeTextView f18616h;
    public TextView i;

    public PrivilegeItemView(Context context) {
        super(context);
        this.f18613e = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18613e).inflate(R.layout.index_privilege_item, this);
        this.f18614f = inflate;
        this.f18615g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
        this.f18616h = (PrivilegeTextView) this.f18614f.findViewById(R.id.privilege_name);
        this.i = (TextView) this.f18614f.findViewById(R.id.privilege_desc);
    }

    public PrivilegeTextView getPrivilegeName() {
        return this.f18616h;
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18613e = context;
        a();
    }

    public PrivilegeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18613e = context;
        a();
    }
}
