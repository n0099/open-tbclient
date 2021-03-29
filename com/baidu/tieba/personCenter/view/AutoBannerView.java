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
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.h0.m.c;
import d.b.h0.r.w.b.b;
import d.b.h0.r.w.b.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AutoBannerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<d.b.i0.f2.e.a> f20261e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.f2.e.a> f20262f;

    /* renamed from: g  reason: collision with root package name */
    public c f20263g;

    /* loaded from: classes5.dex */
    public class a extends b {
        public a() {
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public d.b.h0.r.w.b.c a() {
            d.b.h0.r.w.b.c cVar = new d.b.h0.r.w.b.c();
            cVar.c(R.drawable.icon_banner_gray_n);
            cVar.g(R.drawable.icon_banner_s);
            cVar.d(81);
            cVar.e(R.dimen.tbds26);
            cVar.h(R.dimen.tbds10);
            return cVar;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
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

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
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
        return i > 0 && i <= ListUtils.getCount(this.f20262f);
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
        this.f20261e = new CoverFlowView<>(getContext());
        a aVar = new a();
        this.f20261e.setIndicatorNoOffet(false);
        this.f20261e.setDisableParentEvent(false);
        this.f20261e.setCoverFlowFactory(aVar);
        this.f20261e.setIndicatorVisible(0);
        this.f20261e.setIsAutoPlayDragging(false);
        addView(this.f20261e);
    }

    public void d(List<d.b.i0.f2.e.a> list) {
        this.f20262f = list;
        this.f20261e.setData(list);
    }

    public void e(int i) {
        CoverFlowView<d.b.i0.f2.e.a> coverFlowView = this.f20261e;
        if (coverFlowView != null) {
            coverFlowView.s();
        }
    }

    public void f() {
        CoverFlowView<d.b.i0.f2.e.a> coverFlowView = this.f20261e;
        if (coverFlowView != null) {
            coverFlowView.w();
        }
    }

    public CoverFlowView getCoverFlowView() {
        return this.f20261e;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f20263g != null) {
            this.f20263g.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.f20263g = cVar;
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<d.b.i0.f2.e.a> coverFlowView = this.f20261e;
        if (coverFlowView != null) {
            coverFlowView.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<d.b.i0.f2.e.a> coverFlowView = this.f20261e;
        if (coverFlowView != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20261e = null;
        this.f20262f = null;
        c();
    }
}
