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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView hnV;
    private TbImageView hnW;
    private ImageView hnX;
    private a hnY;

    /* loaded from: classes.dex */
    public interface a {
        void akk();

        void akl();
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
        this.hnV = new FrameAnimationView(context);
        this.hnV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.e(context, d.e.tbds200), l.e(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hnV, layoutParams);
        this.hnW = new TbImageView(context);
        this.hnW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.e(context, d.e.tbds62), l.e(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.hnW.setAutoChangeStyle(false);
        addView(this.hnW, layoutParams2);
        this.hnX = new ImageView(context);
        this.hnX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.e(context, d.e.tbds14);
        addView(this.hnX, layoutParams3);
        this.hnV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hnY != null) {
                    FloatingAnimationView.this.hnY.akk();
                }
            }
        });
        this.hnV.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hnV.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.hnV.getUrl())) {
                    FloatingAnimationView.this.hnV.startLoad(FloatingAnimationView.this.hnV.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hnY != null) {
                    FloatingAnimationView.this.hnY.akl();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hnV.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hnV != null) {
            this.hnV.setData(list, i);
        }
    }

    public void ba() {
        if (this.hnV != null) {
            this.hnV.setImageResource(d.f.transparent_bg);
            this.hnV.ba();
        }
    }

    public void stopAnimation() {
        if (this.hnV != null) {
            this.hnV.setImageDrawable(null);
            this.hnV.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hnV != null) {
            this.hnV.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hnV != null) {
            this.hnV.release();
        }
    }

    public void nu(boolean z) {
        if (z) {
            this.hnX.setVisibility(0);
            am.c(this.hnX, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.hnX.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hnY = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.hnW, d.f.icon_live_close_n);
    }
}
