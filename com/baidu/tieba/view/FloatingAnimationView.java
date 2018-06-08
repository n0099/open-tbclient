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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView hjQ;
    private TbImageView hjR;
    private ImageView hjS;
    private a hjT;

    /* loaded from: classes.dex */
    public interface a {
        void akQ();

        void akR();
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
        this.hjQ = new FrameAnimationView(context);
        this.hjQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.e(context, d.e.tbds200), l.e(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hjQ, layoutParams);
        this.hjR = new TbImageView(context);
        this.hjR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.e(context, d.e.tbds62), l.e(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.hjR.setAutoChangeStyle(false);
        addView(this.hjR, layoutParams2);
        this.hjS = new ImageView(context);
        this.hjS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.e(context, d.e.tbds14);
        addView(this.hjS, layoutParams3);
        this.hjQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hjT != null) {
                    FloatingAnimationView.this.hjT.akQ();
                }
            }
        });
        this.hjQ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hjQ.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hjQ.getUrl())) {
                    FloatingAnimationView.this.hjQ.startLoad(FloatingAnimationView.this.hjQ.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hjR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hjT != null) {
                    FloatingAnimationView.this.hjT.akR();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hjQ.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hjQ != null) {
            this.hjQ.setData(list, i);
        }
    }

    public void ba() {
        if (this.hjQ != null) {
            this.hjQ.setImageResource(d.f.transparent_bg);
            this.hjQ.ba();
        }
    }

    public void stopAnimation() {
        if (this.hjQ != null) {
            this.hjQ.setImageDrawable(null);
            this.hjQ.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hjQ != null) {
            this.hjQ.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hjQ != null) {
            this.hjQ.release();
        }
    }

    public void nm(boolean z) {
        if (z) {
            this.hjS.setVisibility(0);
            al.c(this.hjS, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.hjS.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hjT = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hjR, d.f.icon_live_close_n);
    }
}
