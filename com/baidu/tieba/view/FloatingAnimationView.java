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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView eSd;
    private FrameAnimationView lum;
    private ImageView lun;
    private a luo;

    /* loaded from: classes8.dex */
    public interface a {
        void bGc();

        void bGd();
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
        this.lum = new FrameAnimationView(context);
        this.lum.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.lum, layoutParams);
        this.eSd = new TbImageView(context);
        this.eSd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eSd.setAutoChangeStyle(false);
        addView(this.eSd, layoutParams2);
        this.lun = new ImageView(context);
        this.lun.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.lun, layoutParams3);
        this.lum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.luo != null) {
                    FloatingAnimationView.this.luo.bGc();
                }
            }
        });
        this.lum.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.lum.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.lum.getUrl())) {
                    FloatingAnimationView.this.lum.startLoad(FloatingAnimationView.this.lum.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.luo != null) {
                    FloatingAnimationView.this.luo.bGd();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.lum.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.lum != null) {
            this.lum.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.lum != null) {
            this.lum.setImageResource(R.drawable.transparent_bg);
            this.lum.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.lum != null) {
            this.lum.setImageDrawable(null);
            this.lum.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.lum != null) {
            this.lum.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.lum != null) {
            this.lum.release();
        }
    }

    public void uJ(boolean z) {
        if (z) {
            this.lun.setVisibility(0);
            am.setImageResource(this.lun, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.lun.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.luo = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eSd, R.drawable.icon_live_close_n);
    }
}
