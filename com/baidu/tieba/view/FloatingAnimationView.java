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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class FloatingAnimationView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public FrameAnimationView f21584e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f21585f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21586g;

    /* renamed from: h  reason: collision with root package name */
    public d f21587h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f21587h != null) {
                FloatingAnimationView.this.f21587h.b();
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
            if (FloatingAnimationView.this.f21584e.getBdImage() != null || k.isEmpty(FloatingAnimationView.this.f21584e.getUrl())) {
                return;
            }
            FloatingAnimationView.this.f21584e.V(FloatingAnimationView.this.f21584e.getUrl(), 10, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f21587h != null) {
                FloatingAnimationView.this.f21587h.a();
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
        this.f21584e = frameAnimationView;
        frameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.f21584e, layoutParams);
        TbImageView tbImageView = new TbImageView(context);
        this.f21585f = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.f21585f.setAutoChangeStyle(false);
        addView(this.f21585f, layoutParams2);
        ImageView imageView = new ImageView(context);
        this.f21586g = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.f21586g, layoutParams3);
        this.f21584e.setOnClickListener(new a());
        this.f21584e.setOnDrawListener(new b());
        this.f21585f.setOnClickListener(new c());
        d();
    }

    public void d() {
        SkinManager.setImageResource(this.f21585f, R.drawable.icon_live_close_n);
    }

    public void setCallback(d dVar) {
        this.f21587h = dVar;
    }

    public void setData(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f21584e.setData(str);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrameAnimationView frameAnimationView = this.f21584e;
        if (frameAnimationView != null) {
            frameAnimationView.setPageId(bdUniqueId);
        }
    }

    public FloatingAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public void setData(List<String> list, int i2) {
        FrameAnimationView frameAnimationView = this.f21584e;
        if (frameAnimationView != null) {
            frameAnimationView.setData(list, i2);
        }
    }
}
