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
    private TbImageView eop;
    private FrameAnimationView kIw;
    private ImageView kIx;
    private a kIy;

    /* loaded from: classes8.dex */
    public interface a {
        void bwl();

        void bwm();
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
        this.kIw = new FrameAnimationView(context);
        this.kIw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kIw, layoutParams);
        this.eop = new TbImageView(context);
        this.eop.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eop.setAutoChangeStyle(false);
        addView(this.eop, layoutParams2);
        this.kIx = new ImageView(context);
        this.kIx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kIx, layoutParams3);
        this.kIw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIy != null) {
                    FloatingAnimationView.this.kIy.bwl();
                }
            }
        });
        this.kIw.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kIw.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kIw.getUrl())) {
                    FloatingAnimationView.this.kIw.startLoad(FloatingAnimationView.this.kIw.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eop.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIy != null) {
                    FloatingAnimationView.this.kIy.bwm();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kIw.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kIw != null) {
            this.kIw.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kIw != null) {
            this.kIw.setImageResource(R.drawable.transparent_bg);
            this.kIw.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kIw != null) {
            this.kIw.setImageDrawable(null);
            this.kIw.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kIw != null) {
            this.kIw.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kIw != null) {
            this.kIw.release();
        }
    }

    public void tB(boolean z) {
        if (z) {
            this.kIx.setVisibility(0);
            am.setImageResource(this.kIx, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kIx.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kIy = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eop, R.drawable.icon_live_close_n);
    }
}
