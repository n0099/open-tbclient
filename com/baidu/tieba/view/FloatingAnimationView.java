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
    private TbImageView eSi;
    private FrameAnimationView luq;
    private ImageView lur;
    private a lus;

    /* loaded from: classes8.dex */
    public interface a {
        void bGa();

        void bGb();
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
        this.luq = new FrameAnimationView(context);
        this.luq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.luq, layoutParams);
        this.eSi = new TbImageView(context);
        this.eSi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eSi.setAutoChangeStyle(false);
        addView(this.eSi, layoutParams2);
        this.lur = new ImageView(context);
        this.lur.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.lur, layoutParams3);
        this.luq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lus != null) {
                    FloatingAnimationView.this.lus.bGa();
                }
            }
        });
        this.luq.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.luq.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.luq.getUrl())) {
                    FloatingAnimationView.this.luq.startLoad(FloatingAnimationView.this.luq.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eSi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lus != null) {
                    FloatingAnimationView.this.lus.bGb();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.luq.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.luq != null) {
            this.luq.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.luq != null) {
            this.luq.setImageResource(R.drawable.transparent_bg);
            this.luq.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.luq != null) {
            this.luq.setImageDrawable(null);
            this.luq.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.luq != null) {
            this.luq.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.luq != null) {
            this.luq.release();
        }
    }

    public void uJ(boolean z) {
        if (z) {
            this.lur.setVisibility(0);
            am.setImageResource(this.lur, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.lur.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.lus = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eSi, R.drawable.icon_live_close_n);
    }
}
