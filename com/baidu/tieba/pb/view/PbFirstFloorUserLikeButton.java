package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.h0.r.f0.q.b;
/* loaded from: classes5.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements b {
    public String s;
    public String t;
    public d.b.h0.r.f0.m.b u;
    public d.b.h0.r.f0.m.b v;
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
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        this.u = bVar;
        bVar.q(R.color.CAM_X0302);
        d.b.h0.r.f0.m.b bVar2 = new d.b.h0.r.f0.m.b();
        this.v = bVar2;
        bVar2.r(R.color.CAM_X0109);
        setConfig(this.u);
    }

    @Override // d.b.h0.r.f0.q.b
    public void a(boolean z, int i) {
        s(z);
    }

    public void b(View view) {
        View.OnClickListener onClickListener = this.w;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.b.h0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.b.h0.r.f0.q.b
    public void d(boolean z, int i, boolean z2) {
        s(z);
        setVisibility(0);
    }

    @Override // d.b.h0.r.f0.q.b
    public void e(int i) {
    }

    public void r(int i) {
        k();
    }

    public void s(boolean z) {
        Object obj = this.f13600e;
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() == z) {
            return;
        }
        this.f13600e = Boolean.valueOf(z);
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

    public void setFollowIconSize(int i) {
        this.u.g(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m();
    }
}
