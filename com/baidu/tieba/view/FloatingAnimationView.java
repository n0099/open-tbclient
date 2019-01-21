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
    private a hRA;
    private FrameAnimationView hRx;
    private TbImageView hRy;
    private ImageView hRz;

    /* loaded from: classes.dex */
    public interface a {
        void asw();

        void asx();
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
        this.hRx = new FrameAnimationView(context);
        this.hRx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds200), l.h(context, e.C0210e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hRx, layoutParams);
        this.hRy = new TbImageView(context);
        this.hRy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds62), l.h(context, e.C0210e.tbds62));
        layoutParams2.gravity = 53;
        this.hRy.setAutoChangeStyle(false);
        addView(this.hRy, layoutParams2);
        this.hRz = new ImageView(context);
        this.hRz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0210e.tbds14);
        addView(this.hRz, layoutParams3);
        this.hRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hRA != null) {
                    FloatingAnimationView.this.hRA.asw();
                }
            }
        });
        this.hRx.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hRx.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hRx.getUrl())) {
                    FloatingAnimationView.this.hRx.startLoad(FloatingAnimationView.this.hRx.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hRA != null) {
                    FloatingAnimationView.this.hRA.asx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hRx.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hRx != null) {
            this.hRx.setData(list, i);
        }
    }

    public void cv() {
        if (this.hRx != null) {
            this.hRx.setImageResource(e.f.transparent_bg);
            this.hRx.cv();
        }
    }

    public void stopAnimation() {
        if (this.hRx != null) {
            this.hRx.setImageDrawable(null);
            this.hRx.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hRx != null) {
            this.hRx.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hRx != null) {
            this.hRx.release();
        }
    }

    public void op(boolean z) {
        if (z) {
            this.hRz.setVisibility(0);
            al.c(this.hRz, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hRz.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hRA = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hRy, e.f.icon_live_close_n);
    }
}
