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
    private FrameAnimationView hFT;
    private TbImageView hFU;
    private ImageView hFV;
    private a hFW;

    /* loaded from: classes.dex */
    public interface a {
        void apx();

        void apy();
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
        this.hFT = new FrameAnimationView(context);
        this.hFT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0200e.tbds200), l.h(context, e.C0200e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hFT, layoutParams);
        this.hFU = new TbImageView(context);
        this.hFU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0200e.tbds62), l.h(context, e.C0200e.tbds62));
        layoutParams2.gravity = 53;
        this.hFU.setAutoChangeStyle(false);
        addView(this.hFU, layoutParams2);
        this.hFV = new ImageView(context);
        this.hFV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0200e.tbds14);
        addView(this.hFV, layoutParams3);
        this.hFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hFW != null) {
                    FloatingAnimationView.this.hFW.apx();
                }
            }
        });
        this.hFT.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hFT.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hFT.getUrl())) {
                    FloatingAnimationView.this.hFT.startLoad(FloatingAnimationView.this.hFT.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hFW != null) {
                    FloatingAnimationView.this.hFW.apy();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hFT.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hFT != null) {
            this.hFT.setData(list, i);
        }
    }

    public void cv() {
        if (this.hFT != null) {
            this.hFT.setImageResource(e.f.transparent_bg);
            this.hFT.cv();
        }
    }

    public void stopAnimation() {
        if (this.hFT != null) {
            this.hFT.setImageDrawable(null);
            this.hFT.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hFT != null) {
            this.hFT.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hFT != null) {
            this.hFT.release();
        }
    }

    public void oj(boolean z) {
        if (z) {
            this.hFV.setVisibility(0);
            al.c(this.hFV, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hFV.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hFW = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hFU, e.f.icon_live_close_n);
    }
}
