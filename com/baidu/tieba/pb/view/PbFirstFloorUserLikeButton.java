package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.j0.r.f0.q.b;
/* loaded from: classes5.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements b {
    public String s;
    public String t;
    public d.a.j0.r.f0.m.b u;
    public d.a.j0.r.f0.m.b v;
    public View.OnClickListener w;

    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
        m();
    }

    private void m() {
        this.s = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.t = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.t);
        d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
        this.u = bVar;
        bVar.q(R.color.CAM_X0302);
        d.a.j0.r.f0.m.b bVar2 = new d.a.j0.r.f0.m.b();
        this.v = bVar2;
        bVar2.r(R.color.CAM_X0109);
        setConfig(this.u);
    }

    @Override // d.a.j0.r.f0.q.b
    public void a(boolean z, int i2, boolean z2) {
        s(z);
        setVisibility(0);
    }

    public void b(View view) {
        View.OnClickListener onClickListener = this.w;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.a.j0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.j0.r.f0.q.b
    public void d(int i2) {
    }

    @Override // d.a.j0.r.f0.q.b
    public void e(boolean z, int i2) {
        s(z);
    }

    public void r(int i2) {
        k();
    }

    public void s(boolean z) {
        Object obj = this.f12565e;
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() == z) {
            return;
        }
        this.f12565e = Boolean.valueOf(z);
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.s);
            setConfig(this.v);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.t);
            setConfig(this.u);
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFollowIconSize(int i2) {
        this.u.g(i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m();
    }
}
