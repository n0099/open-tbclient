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
    public FrameAnimationView f22411e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f22412f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22413g;

    /* renamed from: h  reason: collision with root package name */
    public d f22414h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f22414h != null) {
                FloatingAnimationView.this.f22414h.b();
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
            if (FloatingAnimationView.this.f22411e.getBdImage() != null || k.isEmpty(FloatingAnimationView.this.f22411e.getUrl())) {
                return;
            }
            FloatingAnimationView.this.f22411e.V(FloatingAnimationView.this.f22411e.getUrl(), 10, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingAnimationView.this.f22414h != null) {
                FloatingAnimationView.this.f22414h.a();
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
        this.f22411e = frameAnimationView;
        frameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.f22411e, layoutParams);
        TbImageView tbImageView = new TbImageView(context);
        this.f22412f = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.f22412f.setAutoChangeStyle(false);
        addView(this.f22412f, layoutParams2);
        ImageView imageView = new ImageView(context);
        this.f22413g = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.f22413g, layoutParams3);
        this.f22411e.setOnClickListener(new a());
        this.f22411e.setOnDrawListener(new b());
        this.f22412f.setOnClickListener(new c());
        d();
    }

    public void d() {
        SkinManager.setImageResource(this.f22412f, R.drawable.icon_live_close_n);
    }

    public void setCallback(d dVar) {
        this.f22414h = dVar;
    }

    public void setData(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        this.f22411e.setData(str);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        FrameAnimationView frameAnimationView = this.f22411e;
        if (frameAnimationView != null) {
            frameAnimationView.setPageId(bdUniqueId);
        }
    }

    public FloatingAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public void setData(List<String> list, int i2) {
        FrameAnimationView frameAnimationView = this.f22411e;
        if (frameAnimationView != null) {
            frameAnimationView.setData(list, i2);
        }
    }
}
