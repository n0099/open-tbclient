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
    private TbImageView eob;
    private FrameAnimationView kIk;
    private ImageView kIl;
    private a kIm;

    /* loaded from: classes8.dex */
    public interface a {
        void bwk();

        void bwl();
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
        this.kIk = new FrameAnimationView(context);
        this.kIk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kIk, layoutParams);
        this.eob = new TbImageView(context);
        this.eob.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eob.setAutoChangeStyle(false);
        addView(this.eob, layoutParams2);
        this.kIl = new ImageView(context);
        this.kIl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kIl, layoutParams3);
        this.kIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIm != null) {
                    FloatingAnimationView.this.kIm.bwk();
                }
            }
        });
        this.kIk.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kIk.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kIk.getUrl())) {
                    FloatingAnimationView.this.kIk.startLoad(FloatingAnimationView.this.kIk.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIm != null) {
                    FloatingAnimationView.this.kIm.bwl();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kIk.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kIk != null) {
            this.kIk.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kIk != null) {
            this.kIk.setImageResource(R.drawable.transparent_bg);
            this.kIk.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kIk != null) {
            this.kIk.setImageDrawable(null);
            this.kIk.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kIk != null) {
            this.kIk.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kIk != null) {
            this.kIk.release();
        }
    }

    public void tB(boolean z) {
        if (z) {
            this.kIl.setVisibility(0);
            am.setImageResource(this.kIl, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kIl.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kIm = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eob, R.drawable.icon_live_close_n);
    }
}
