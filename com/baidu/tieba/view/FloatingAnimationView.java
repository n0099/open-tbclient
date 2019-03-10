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
    private FrameAnimationView jih;
    private TbImageView jii;
    private ImageView jij;
    private a jik;

    /* loaded from: classes3.dex */
    public interface a {
        void aSp();

        void aSq();
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
        this.jih = new FrameAnimationView(context);
        this.jih.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.jih, layoutParams);
        this.jii = new TbImageView(context);
        this.jii.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, d.e.tbds62), l.h(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.jii.setAutoChangeStyle(false);
        addView(this.jii, layoutParams2);
        this.jij = new ImageView(context);
        this.jij.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, d.e.tbds14);
        addView(this.jij, layoutParams3);
        this.jih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jik != null) {
                    FloatingAnimationView.this.jik.aSp();
                }
            }
        });
        this.jih.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jih.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jih.getUrl())) {
                    FloatingAnimationView.this.jih.startLoad(FloatingAnimationView.this.jih.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jik != null) {
                    FloatingAnimationView.this.jik.aSq();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jih.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jih != null) {
            this.jih.setData(list, i);
        }
    }

    public void cu() {
        if (this.jih != null) {
            this.jih.setImageResource(d.f.transparent_bg);
            this.jih.cu();
        }
    }

    public void stopAnimation() {
        if (this.jih != null) {
            this.jih.setImageDrawable(null);
            this.jih.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jih != null) {
            this.jih.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jih != null) {
            this.jih.release();
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jij.setVisibility(0);
            al.c(this.jij, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.jij.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jik = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jii, d.f.icon_live_close_n);
    }
}
