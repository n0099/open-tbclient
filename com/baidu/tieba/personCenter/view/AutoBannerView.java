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
import d.a.m0.m.c;
import d.a.m0.r.w.b.b;
import d.a.m0.r.w.b.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AutoBannerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<d.a.n0.h2.e.a> f19677e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.h2.e.a> f19678f;

    /* renamed from: g  reason: collision with root package name */
    public c f19679g;

    /* loaded from: classes5.dex */
    public class a extends b {
        public a() {
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
        public d.a.m0.r.w.b.c a() {
            d.a.m0.r.w.b.c cVar = new d.a.m0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a(l.g(AutoBannerView.this.getContext(), R.dimen.tbds209));
            return eVar;
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
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
        return i2 > 0 && i2 <= ListUtils.getCount(this.f19678f);
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
        this.f19677e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f19677e.setIndicatorNoOffet(false);
        this.f19677e.setDisableParentEvent(false);
        this.f19677e.setCoverFlowFactory(aVar);
        this.f19677e.setIndicatorVisible(0);
        this.f19677e.setIsAutoPlayDragging(false);
        addView(this.f19677e);
    }

    public void d(List<d.a.n0.h2.e.a> list) {
        this.f19678f = list;
        this.f19677e.setData(list);
    }

    public void e(int i2) {
        CoverFlowView<d.a.n0.h2.e.a> coverFlowView = this.f19677e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    public void f() {
        CoverFlowView<d.a.n0.h2.e.a> coverFlowView = this.f19677e;
        if (coverFlowView != null) {
            coverFlowView.w();
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f19677e;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f19679g != null) {
            this.f19679g.a(this, i2 == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f19679g = cVar;
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<d.a.n0.h2.e.a> coverFlowView = this.f19677e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i2);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<d.a.n0.h2.e.a> coverFlowView = this.f19677e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19677e = null;
        this.f19678f = null;
        c();
    }
}
