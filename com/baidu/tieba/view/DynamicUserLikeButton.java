package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.n0.r.f0.q.b;
/* loaded from: classes5.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements b {
    public a s;
    public boolean t;
    public boolean u;

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view);
    }

    public DynamicUserLikeButton(Context context) {
        this(context, null);
    }

    @Override // d.a.n0.r.f0.q.b
    public void a(View view) {
        a aVar = this.s;
        if (aVar != null) {
            aVar.a(view);
        }
    }

    @Override // d.a.n0.r.f0.q.b
    public void b(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.n0.r.f0.q.b
    public void c(boolean z, int i2, boolean z2) {
        e(z, i2);
    }

    @Override // d.a.n0.r.f0.q.b
    public void d(int i2) {
    }

    public void e(boolean z, int i2) {
        if (z) {
            s(true);
        } else {
            s(false);
        }
    }

    public void r(int i2) {
        k();
    }

    public void s(boolean z) {
        if (this.u) {
            if (z) {
                d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
                bVar.p();
                setConfig(bVar);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                d.a.n0.r.f0.m.b bVar2 = new d.a.n0.r.f0.m.b();
                bVar2.s(R.color.CAM_X0105);
                bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                bVar2.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                bVar2.h(R.color.CAM_X0105);
                setConfig(bVar2);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
        } else if (z) {
            d.a.n0.r.f0.m.b bVar3 = new d.a.n0.r.f0.m.b();
            bVar3.r(R.color.CAM_X0109);
            setConfig(bVar3);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            d.a.n0.r.f0.m.b bVar4 = new d.a.n0.r.f0.m.b();
            bVar4.q(R.color.CAM_X0302);
            if (this.t) {
                bVar4.g(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                bVar4.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            setConfig(bVar4);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setGodRecommendStyle(boolean z) {
        this.u = z;
    }

    public void setOnClickEvent(a aVar) {
        this.s = aVar;
    }

    public void setUseNewStyle(boolean z) {
        this.t = z;
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.q(R.color.CAM_X0302);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }
}
