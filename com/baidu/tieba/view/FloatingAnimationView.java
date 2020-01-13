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
/* loaded from: classes6.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView ejQ;
    private FrameAnimationView kHi;
    private ImageView kHj;
    private a kHk;

    /* loaded from: classes6.dex */
    public interface a {
        void buE();

        void buF();
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
        this.kHi = new FrameAnimationView(context);
        this.kHi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kHi, layoutParams);
        this.ejQ = new TbImageView(context);
        this.ejQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.ejQ.setAutoChangeStyle(false);
        addView(this.ejQ, layoutParams2);
        this.kHj = new ImageView(context);
        this.kHj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kHj, layoutParams3);
        this.kHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kHk != null) {
                    FloatingAnimationView.this.kHk.buE();
                }
            }
        });
        this.kHi.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kHi.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kHi.getUrl())) {
                    FloatingAnimationView.this.kHi.startLoad(FloatingAnimationView.this.kHi.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.ejQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kHk != null) {
                    FloatingAnimationView.this.kHk.buF();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kHi.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kHi != null) {
            this.kHi.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kHi != null) {
            this.kHi.setImageResource(R.drawable.transparent_bg);
            this.kHi.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kHi != null) {
            this.kHi.setImageDrawable(null);
            this.kHi.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kHi != null) {
            this.kHi.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kHi != null) {
            this.kHi.release();
        }
    }

    public void tx(boolean z) {
        if (z) {
            this.kHj.setVisibility(0);
            am.setImageResource(this.kHj, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kHj.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kHk = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.ejQ, R.drawable.icon_live_close_n);
    }
}
