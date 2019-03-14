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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView jhY;
    private TbImageView jhZ;
    private ImageView jia;
    private a jib;

    /* loaded from: classes3.dex */
    public interface a {
        void aSo();

        void aSp();
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
        this.jhY = new FrameAnimationView(context);
        this.jhY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.jhY, layoutParams);
        this.jhZ = new TbImageView(context);
        this.jhZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, d.e.tbds62), l.h(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.jhZ.setAutoChangeStyle(false);
        addView(this.jhZ, layoutParams2);
        this.jia = new ImageView(context);
        this.jia.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, d.e.tbds14);
        addView(this.jia, layoutParams3);
        this.jhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jib != null) {
                    FloatingAnimationView.this.jib.aSo();
                }
            }
        });
        this.jhY.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jhY.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jhY.getUrl())) {
                    FloatingAnimationView.this.jhY.startLoad(FloatingAnimationView.this.jhY.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jib != null) {
                    FloatingAnimationView.this.jib.aSp();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jhY.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jhY != null) {
            this.jhY.setData(list, i);
        }
    }

    public void cu() {
        if (this.jhY != null) {
            this.jhY.setImageResource(d.f.transparent_bg);
            this.jhY.cu();
        }
    }

    public void stopAnimation() {
        if (this.jhY != null) {
            this.jhY.setImageDrawable(null);
            this.jhY.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jhY != null) {
            this.jhY.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jhY != null) {
            this.jhY.release();
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jia.setVisibility(0);
            al.c(this.jia, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.jia.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jib = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jhZ, d.f.icon_live_close_n);
    }
}
