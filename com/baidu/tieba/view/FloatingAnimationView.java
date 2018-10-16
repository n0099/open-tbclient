package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView hEi;
    private TbImageView hEj;
    private ImageView hEk;
    private a hEl;

    /* loaded from: classes.dex */
    public interface a {
        void apV();

        void apW();
    }

    public FloatingAnimationView(@NonNull Context context) {
        this(context, null);
    }

    public FloatingAnimationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Context context = getContext();
        this.hEi = new FrameAnimationView(context);
        this.hEi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0175e.tbds200), l.h(context, e.C0175e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hEi, layoutParams);
        this.hEj = new TbImageView(context);
        this.hEj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0175e.tbds62), l.h(context, e.C0175e.tbds62));
        layoutParams2.gravity = 53;
        this.hEj.setAutoChangeStyle(false);
        addView(this.hEj, layoutParams2);
        this.hEk = new ImageView(context);
        this.hEk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0175e.tbds14);
        addView(this.hEk, layoutParams3);
        this.hEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hEl != null) {
                    FloatingAnimationView.this.hEl.apV();
                }
            }
        });
        this.hEi.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hEi.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hEi.getUrl())) {
                    FloatingAnimationView.this.hEi.startLoad(FloatingAnimationView.this.hEi.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hEl != null) {
                    FloatingAnimationView.this.hEl.apW();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hEi.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hEi != null) {
            this.hEi.setData(list, i);
        }
    }

    public void cv() {
        if (this.hEi != null) {
            this.hEi.setImageResource(e.f.transparent_bg);
            this.hEi.cv();
        }
    }

    public void stopAnimation() {
        if (this.hEi != null) {
            this.hEi.setImageDrawable(null);
            this.hEi.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hEi != null) {
            this.hEi.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hEi != null) {
            this.hEi.release();
        }
    }

    public void nV(boolean z) {
        if (z) {
            this.hEk.setVisibility(0);
            al.c(this.hEk, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hEk.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hEl = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hEj, e.f.icon_live_close_n);
    }
}
