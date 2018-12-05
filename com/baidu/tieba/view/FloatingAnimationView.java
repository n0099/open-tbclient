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
    private FrameAnimationView hNe;
    private TbImageView hNf;
    private ImageView hNg;
    private a hNh;

    /* loaded from: classes.dex */
    public interface a {
        void arj();

        void ark();
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
        this.hNe = new FrameAnimationView(context);
        this.hNe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds200), l.h(context, e.C0210e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hNe, layoutParams);
        this.hNf = new TbImageView(context);
        this.hNf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds62), l.h(context, e.C0210e.tbds62));
        layoutParams2.gravity = 53;
        this.hNf.setAutoChangeStyle(false);
        addView(this.hNf, layoutParams2);
        this.hNg = new ImageView(context);
        this.hNg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0210e.tbds14);
        addView(this.hNg, layoutParams3);
        this.hNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hNh != null) {
                    FloatingAnimationView.this.hNh.arj();
                }
            }
        });
        this.hNe.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hNe.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hNe.getUrl())) {
                    FloatingAnimationView.this.hNe.startLoad(FloatingAnimationView.this.hNe.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hNh != null) {
                    FloatingAnimationView.this.hNh.ark();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hNe.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hNe != null) {
            this.hNe.setData(list, i);
        }
    }

    public void cv() {
        if (this.hNe != null) {
            this.hNe.setImageResource(e.f.transparent_bg);
            this.hNe.cv();
        }
    }

    public void stopAnimation() {
        if (this.hNe != null) {
            this.hNe.setImageDrawable(null);
            this.hNe.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hNe != null) {
            this.hNe.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hNe != null) {
            this.hNe.release();
        }
    }

    public void ol(boolean z) {
        if (z) {
            this.hNg.setVisibility(0);
            al.c(this.hNg, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hNg.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hNh = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hNf, e.f.icon_live_close_n);
    }
}
