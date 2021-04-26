package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.i0.m.c;
import d.a.i0.r.w.b.b;
import d.a.i0.r.w.b.e;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<d.a.j0.g2.e.a> f20467e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.j0.g2.e.a> f20468f;

    /* renamed from: g  reason: collision with root package name */
    public c f20469g;

    /* loaded from: classes4.dex */
    public class a extends b {
        public a() {
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public d.a.i0.r.w.b.c a() {
            d.a.i0.r.w.b.c cVar = new d.a.i0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(l.g(AutoBannerView.this.getContext(), R.dimen.tbds209));
            return eVar;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(true);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(l.g(AutoBannerView.this.getContext(), R.dimen.tbds12));
            return tbImageView;
        }
    }

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public boolean a(int i2) {
        return i2 > 0 && i2 <= ListUtils.getCount(this.f20468f);
    }

    public void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{str});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        this.f20467e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f20467e.setIndicatorNoOffet(false);
        this.f20467e.setDisableParentEvent(false);
        this.f20467e.setCoverFlowFactory(aVar);
        this.f20467e.setIndicatorVisible(0);
        this.f20467e.setIsAutoPlayDragging(false);
        addView(this.f20467e);
    }

    public void d(List<d.a.j0.g2.e.a> list) {
        this.f20468f = list;
        this.f20467e.setData(list);
    }

    public void e(int i2) {
        CoverFlowView<d.a.j0.g2.e.a> coverFlowView = this.f20467e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    public void f() {
        CoverFlowView<d.a.j0.g2.e.a> coverFlowView = this.f20467e;
        if (coverFlowView != null) {
            coverFlowView.w();
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f20467e;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f20469g != null) {
            this.f20469g.a(this, i2 == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f20469g = cVar;
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<d.a.j0.g2.e.a> coverFlowView = this.f20467e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i2);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<d.a.j0.g2.e.a> coverFlowView = this.f20467e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20467e = null;
        this.f20468f = null;
        c();
    }
}
