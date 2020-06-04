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
    private TbImageView ffb;
    private FrameAnimationView lOb;
    private ImageView lOc;
    private a lOd;

    /* loaded from: classes8.dex */
    public interface a {
        void bMw();

        void bMx();
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
        this.lOb = new FrameAnimationView(context);
        this.lOb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.lOb, layoutParams);
        this.ffb = new TbImageView(context);
        this.ffb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.ffb.setAutoChangeStyle(false);
        addView(this.ffb, layoutParams2);
        this.lOc = new ImageView(context);
        this.lOc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.lOc, layoutParams3);
        this.lOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lOd != null) {
                    FloatingAnimationView.this.lOd.bMw();
                }
            }
        });
        this.lOb.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.lOb.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.lOb.getUrl())) {
                    FloatingAnimationView.this.lOb.startLoad(FloatingAnimationView.this.lOb.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.ffb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lOd != null) {
                    FloatingAnimationView.this.lOd.bMx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.lOb.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.lOb != null) {
            this.lOb.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.lOb != null) {
            this.lOb.setImageResource(R.drawable.transparent_bg);
            this.lOb.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.lOb != null) {
            this.lOb.setImageDrawable(null);
            this.lOb.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.lOb != null) {
            this.lOb.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.lOb != null) {
            this.lOb.release();
        }
    }

    public void vh(boolean z) {
        if (z) {
            this.lOc.setVisibility(0);
            am.setImageResource(this.lOc, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.lOc.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.lOd = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.ffb, R.drawable.icon_live_close_n);
    }
}
