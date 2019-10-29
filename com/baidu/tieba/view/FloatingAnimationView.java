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
/* loaded from: classes3.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView dyR;
    private FrameAnimationView jKl;
    private ImageView jKm;
    private a jKn;

    /* loaded from: classes3.dex */
    public interface a {
        void bch();

        void bci();
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
        this.jKl = new FrameAnimationView(context);
        this.jKl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jKl, layoutParams);
        this.dyR = new TbImageView(context);
        this.dyR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.dyR.setAutoChangeStyle(false);
        addView(this.dyR, layoutParams2);
        this.jKm = new ImageView(context);
        this.jKm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.jKm, layoutParams3);
        this.jKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jKn != null) {
                    FloatingAnimationView.this.jKn.bch();
                }
            }
        });
        this.jKl.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jKl.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.jKl.getUrl())) {
                    FloatingAnimationView.this.jKl.startLoad(FloatingAnimationView.this.jKl.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.dyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jKn != null) {
                    FloatingAnimationView.this.jKn.bci();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jKl.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jKl != null) {
            this.jKl.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.jKl != null) {
            this.jKl.setImageResource(R.drawable.transparent_bg);
            this.jKl.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.jKl != null) {
            this.jKl.setImageDrawable(null);
            this.jKl.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jKl != null) {
            this.jKl.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jKl != null) {
            this.jKl.release();
        }
    }

    public void rF(boolean z) {
        if (z) {
            this.jKm.setVisibility(0);
            am.setImageResource(this.jKm, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jKm.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jKn = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.dyR, R.drawable.icon_live_close_n);
    }
}
