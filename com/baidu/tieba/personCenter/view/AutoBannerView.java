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
import d.b.c.a.j;
import d.b.c.e.p.l;
import d.b.i0.m.c;
import d.b.i0.r.w.b.b;
import d.b.i0.r.w.b.e;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<d.b.j0.g2.e.a> f19961e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.j0.g2.e.a> f19962f;

    /* renamed from: g  reason: collision with root package name */
    public c f19963g;

    /* loaded from: classes3.dex */
    public class a extends b {
        public a() {
        }

        @Override // d.b.i0.r.w.b.b, d.b.i0.r.w.a
        public d.b.i0.r.w.b.c a() {
            d.b.i0.r.w.b.c cVar = new d.b.i0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.b.i0.r.w.b.b, d.b.i0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setPlaceHolder(2);
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(true);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(l.g(AutoBannerView.this.getContext(), R.dimen.tbds12));
            return tbImageView;
        }

        @Override // d.b.i0.r.w.b.b, d.b.i0.r.w.a
        public e d() {
            e eVar = new e();
            eVar.a(l.g(AutoBannerView.this.getContext(), R.dimen.tbds209));
            return eVar;
        }
    }

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public boolean a(int i) {
        return i > 0 && i <= ListUtils.getCount(this.f19962f);
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
        this.f19961e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f19961e.setIndicatorNoOffet(false);
        this.f19961e.setDisableParentEvent(false);
        this.f19961e.setCoverFlowFactory(aVar);
        this.f19961e.setIndicatorVisible(0);
        this.f19961e.setIsAutoPlayDragging(false);
        addView(this.f19961e);
    }

    public void d(List<d.b.j0.g2.e.a> list) {
        this.f19962f = list;
        this.f19961e.setData(list);
    }

    public void e(int i) {
        CoverFlowView<d.b.j0.g2.e.a> coverFlowView = this.f19961e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    public void f() {
        CoverFlowView<d.b.j0.g2.e.a> coverFlowView = this.f19961e;
        if (coverFlowView != null) {
            coverFlowView.w();
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f19961e;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f19963g != null) {
            this.f19963g.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f19963g = cVar;
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<d.b.j0.g2.e.a> coverFlowView = this.f19961e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<d.b.j0.g2.e.a> coverFlowView = this.f19961e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19961e = null;
        this.f19962f = null;
        c();
    }
}
