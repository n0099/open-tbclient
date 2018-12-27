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
    private FrameAnimationView hQp;
    private TbImageView hQq;
    private ImageView hQr;
    private a hQs;

    /* loaded from: classes.dex */
    public interface a {
        void arY();

        void arZ();
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
        this.hQp = new FrameAnimationView(context);
        this.hQp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds200), l.h(context, e.C0210e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hQp, layoutParams);
        this.hQq = new TbImageView(context);
        this.hQq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0210e.tbds62), l.h(context, e.C0210e.tbds62));
        layoutParams2.gravity = 53;
        this.hQq.setAutoChangeStyle(false);
        addView(this.hQq, layoutParams2);
        this.hQr = new ImageView(context);
        this.hQr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0210e.tbds14);
        addView(this.hQr, layoutParams3);
        this.hQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hQs != null) {
                    FloatingAnimationView.this.hQs.arY();
                }
            }
        });
        this.hQp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hQp.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hQp.getUrl())) {
                    FloatingAnimationView.this.hQp.startLoad(FloatingAnimationView.this.hQp.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hQs != null) {
                    FloatingAnimationView.this.hQs.arZ();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hQp.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hQp != null) {
            this.hQp.setData(list, i);
        }
    }

    public void cv() {
        if (this.hQp != null) {
            this.hQp.setImageResource(e.f.transparent_bg);
            this.hQp.cv();
        }
    }

    public void stopAnimation() {
        if (this.hQp != null) {
            this.hQp.setImageDrawable(null);
            this.hQp.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hQp != null) {
            this.hQp.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hQp != null) {
            this.hQp.release();
        }
    }

    public void oo(boolean z) {
        if (z) {
            this.hQr.setVisibility(0);
            al.c(this.hQr, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hQr.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hQs = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hQq, e.f.icon_live_close_n);
    }
}
