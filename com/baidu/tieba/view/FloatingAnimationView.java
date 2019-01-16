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
    private FrameAnimationView hRw;
    private TbImageView hRx;
    private ImageView hRy;
    private a hRz;

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
        this.hRw = new FrameAnimationView(context);
        this.hRw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds200), l.h(context, e.C0210e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hRw, layoutParams);
        this.hRx = new TbImageView(context);
        this.hRx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds62), l.h(context, e.C0210e.tbds62));
        layoutParams2.gravity = 53;
        this.hRx.setAutoChangeStyle(false);
        addView(this.hRx, layoutParams2);
        this.hRy = new ImageView(context);
        this.hRy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0210e.tbds14);
        addView(this.hRy, layoutParams3);
        this.hRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hRz != null) {
                    FloatingAnimationView.this.hRz.asw();
                }
            }
        });
        this.hRw.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hRw.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hRw.getUrl())) {
                    FloatingAnimationView.this.hRw.startLoad(FloatingAnimationView.this.hRw.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hRz != null) {
                    FloatingAnimationView.this.hRz.asx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hRw.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hRw != null) {
            this.hRw.setData(list, i);
        }
    }

    public void cv() {
        if (this.hRw != null) {
            this.hRw.setImageResource(e.f.transparent_bg);
            this.hRw.cv();
        }
    }

    public void stopAnimation() {
        if (this.hRw != null) {
            this.hRw.setImageDrawable(null);
            this.hRw.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hRw != null) {
            this.hRw.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hRw != null) {
            this.hRw.release();
        }
    }

    public void op(boolean z) {
        if (z) {
            this.hRy.setVisibility(0);
            al.c(this.hRy, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hRy.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hRz = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hRx, e.f.icon_live_close_n);
    }
}
