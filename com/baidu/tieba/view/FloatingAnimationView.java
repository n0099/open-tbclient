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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView hpe;
    private TbImageView hpf;
    private ImageView hpg;
    private a hph;

    /* loaded from: classes.dex */
    public interface a {
        void akL();

        void akM();
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
        this.hpe = new FrameAnimationView(context);
        this.hpe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.f(context, f.e.tbds200), l.f(context, f.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hpe, layoutParams);
        this.hpf = new TbImageView(context);
        this.hpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.f(context, f.e.tbds62), l.f(context, f.e.tbds62));
        layoutParams2.gravity = 53;
        this.hpf.setAutoChangeStyle(false);
        addView(this.hpf, layoutParams2);
        this.hpg = new ImageView(context);
        this.hpg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.f(context, f.e.tbds14);
        addView(this.hpg, layoutParams3);
        this.hpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hph != null) {
                    FloatingAnimationView.this.hph.akL();
                }
            }
        });
        this.hpe.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hpe.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.hpe.getUrl())) {
                    FloatingAnimationView.this.hpe.startLoad(FloatingAnimationView.this.hpe.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hpf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hph != null) {
                    FloatingAnimationView.this.hph.akM();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hpe.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hpe != null) {
            this.hpe.setData(list, i);
        }
    }

    public void aX() {
        if (this.hpe != null) {
            this.hpe.setImageResource(f.C0146f.transparent_bg);
            this.hpe.aX();
        }
    }

    public void stopAnimation() {
        if (this.hpe != null) {
            this.hpe.setImageDrawable(null);
            this.hpe.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hpe != null) {
            this.hpe.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hpe != null) {
            this.hpe.release();
        }
    }

    public void ni(boolean z) {
        if (z) {
            this.hpg.setVisibility(0);
            am.c(this.hpg, f.C0146f.icon_front_worldcup_new_n);
            return;
        }
        this.hpg.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hph = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.hpf, f.C0146f.icon_live_close_n);
    }
}
