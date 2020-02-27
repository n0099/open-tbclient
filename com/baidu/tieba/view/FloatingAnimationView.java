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
    private TbImageView eoa;
    private FrameAnimationView kIi;
    private ImageView kIj;
    private a kIk;

    /* loaded from: classes8.dex */
    public interface a {
        void bwi();

        void bwj();
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
        this.kIi = new FrameAnimationView(context);
        this.kIi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kIi, layoutParams);
        this.eoa = new TbImageView(context);
        this.eoa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eoa.setAutoChangeStyle(false);
        addView(this.eoa, layoutParams2);
        this.kIj = new ImageView(context);
        this.kIj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kIj, layoutParams3);
        this.kIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIk != null) {
                    FloatingAnimationView.this.kIk.bwi();
                }
            }
        });
        this.kIi.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kIi.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kIi.getUrl())) {
                    FloatingAnimationView.this.kIi.startLoad(FloatingAnimationView.this.kIi.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eoa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kIk != null) {
                    FloatingAnimationView.this.kIk.bwj();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kIi.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kIi != null) {
            this.kIi.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kIi != null) {
            this.kIi.setImageResource(R.drawable.transparent_bg);
            this.kIi.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kIi != null) {
            this.kIi.setImageDrawable(null);
            this.kIi.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kIi != null) {
            this.kIi.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kIi != null) {
            this.kIi.release();
        }
    }

    public void tB(boolean z) {
        if (z) {
            this.kIj.setVisibility(0);
            am.setImageResource(this.kIj, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kIj.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kIk = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eoa, R.drawable.icon_live_close_n);
    }
}
