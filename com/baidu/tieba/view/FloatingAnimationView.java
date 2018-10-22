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
    private FrameAnimationView hEj;
    private TbImageView hEk;
    private ImageView hEl;
    private a hEm;

    /* loaded from: classes.dex */
    public interface a {
        void apW();

        void apX();
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
        this.hEj = new FrameAnimationView(context);
        this.hEj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0175e.tbds200), l.h(context, e.C0175e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hEj, layoutParams);
        this.hEk = new TbImageView(context);
        this.hEk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0175e.tbds62), l.h(context, e.C0175e.tbds62));
        layoutParams2.gravity = 53;
        this.hEk.setAutoChangeStyle(false);
        addView(this.hEk, layoutParams2);
        this.hEl = new ImageView(context);
        this.hEl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0175e.tbds14);
        addView(this.hEl, layoutParams3);
        this.hEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hEm != null) {
                    FloatingAnimationView.this.hEm.apW();
                }
            }
        });
        this.hEj.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hEj.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hEj.getUrl())) {
                    FloatingAnimationView.this.hEj.startLoad(FloatingAnimationView.this.hEj.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hEk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hEm != null) {
                    FloatingAnimationView.this.hEm.apX();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hEj.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hEj != null) {
            this.hEj.setData(list, i);
        }
    }

    public void cv() {
        if (this.hEj != null) {
            this.hEj.setImageResource(e.f.transparent_bg);
            this.hEj.cv();
        }
    }

    public void stopAnimation() {
        if (this.hEj != null) {
            this.hEj.setImageDrawable(null);
            this.hEj.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hEj != null) {
            this.hEj.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hEj != null) {
            this.hEj.release();
        }
    }

    public void nV(boolean z) {
        if (z) {
            this.hEl.setVisibility(0);
            al.c(this.hEl, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hEl.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hEm = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hEk, e.f.icon_live_close_n);
    }
}
