package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class FloatingAnimationView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public FrameAnimationView f21751e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f21752f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21753g;

    /* renamed from: h  reason: collision with root package name */
    public d f21754h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f21754h != null) {
                FloatingAnimationView.this.f21754h.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            if (FloatingAnimationView.this.f21751e.getBdImage() != null || k.isEmpty(FloatingAnimationView.this.f21751e.getUrl())) {
                return;
            }
            FloatingAnimationView.this.f21751e.W(FloatingAnimationView.this.f21751e.getUrl(), 10, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f21754h != null) {
                FloatingAnimationView.this.f21754h.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();
    }

    public FloatingAnimationView(@NonNull Context context) {
        this(context, null);
    }

    public final void c() {
        Context context = getContext();
        FrameAnimationView frameAnimationView = new FrameAnimationView(context);
        this.f21751e = frameAnimationView;
        frameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.f21751e, layoutParams);
        TbImageView tbImageView = new TbImageView(context);
        this.f21752f = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.f21752f.setAutoChangeStyle(false);
        addView(this.f21752f, layoutParams2);
        ImageView imageView = new ImageView(context);
        this.f21753g = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.f21753g, layoutParams3);
        this.f21751e.setOnClickListener(new a());
        this.f21751e.setOnDrawListener(new b());
        this.f21752f.setOnClickListener(new c());
        d();
    }

    public void d() {
        SkinManager.setImageResource(this.f21752f, R.drawable.icon_live_close_n);
    }

    public void setCallback(d dVar) {
        this.f21754h = dVar;
    }

    public void setData(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f21751e.setData(str);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrameAnimationView frameAnimationView = this.f21751e;
        if (frameAnimationView != null) {
            frameAnimationView.setPageId(bdUniqueId);
        }
    }

    public FloatingAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public void setData(List<String> list, int i) {
        FrameAnimationView frameAnimationView = this.f21751e;
        if (frameAnimationView != null) {
            frameAnimationView.setData(list, i);
        }
    }
}
