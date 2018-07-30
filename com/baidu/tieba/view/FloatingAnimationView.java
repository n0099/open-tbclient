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
    private FrameAnimationView hpd;
    private TbImageView hpe;
    private ImageView hpf;
    private a hpg;

    /* loaded from: classes.dex */
    public interface a {
        void akJ();

        void akK();
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
        this.hpd = new FrameAnimationView(context);
        this.hpd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.f(context, d.e.tbds200), l.f(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hpd, layoutParams);
        this.hpe = new TbImageView(context);
        this.hpe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.f(context, d.e.tbds62), l.f(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.hpe.setAutoChangeStyle(false);
        addView(this.hpe, layoutParams2);
        this.hpf = new ImageView(context);
        this.hpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.f(context, d.e.tbds14);
        addView(this.hpf, layoutParams3);
        this.hpd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hpg != null) {
                    FloatingAnimationView.this.hpg.akJ();
                }
            }
        });
        this.hpd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hpd.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.hpd.getUrl())) {
                    FloatingAnimationView.this.hpd.startLoad(FloatingAnimationView.this.hpd.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hpg != null) {
                    FloatingAnimationView.this.hpg.akK();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hpd.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hpd != null) {
            this.hpd.setData(list, i);
        }
    }

    public void aX() {
        if (this.hpd != null) {
            this.hpd.setImageResource(d.f.transparent_bg);
            this.hpd.aX();
        }
    }

    public void stopAnimation() {
        if (this.hpd != null) {
            this.hpd.setImageDrawable(null);
            this.hpd.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hpd != null) {
            this.hpd.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hpd != null) {
            this.hpd.release();
        }
    }

    public void ni(boolean z) {
        if (z) {
            this.hpf.setVisibility(0);
            am.c(this.hpf, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.hpf.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hpg = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.hpe, d.f.icon_live_close_n);
    }
}
