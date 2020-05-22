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
    private TbImageView feQ;
    private FrameAnimationView lMT;
    private ImageView lMU;
    private a lMV;

    /* loaded from: classes8.dex */
    public interface a {
        void bMu();

        void bMv();
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
        this.lMT = new FrameAnimationView(context);
        this.lMT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.lMT, layoutParams);
        this.feQ = new TbImageView(context);
        this.feQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.feQ.setAutoChangeStyle(false);
        addView(this.feQ, layoutParams2);
        this.lMU = new ImageView(context);
        this.lMU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.lMU, layoutParams3);
        this.lMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lMV != null) {
                    FloatingAnimationView.this.lMV.bMu();
                }
            }
        });
        this.lMT.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.lMT.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.lMT.getUrl())) {
                    FloatingAnimationView.this.lMT.startLoad(FloatingAnimationView.this.lMT.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.feQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.lMV != null) {
                    FloatingAnimationView.this.lMV.bMv();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.lMT.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.lMT != null) {
            this.lMT.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.lMT != null) {
            this.lMT.setImageResource(R.drawable.transparent_bg);
            this.lMT.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.lMT != null) {
            this.lMT.setImageDrawable(null);
            this.lMT.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.lMT != null) {
            this.lMT.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.lMT != null) {
            this.lMT.release();
        }
    }

    public void vh(boolean z) {
        if (z) {
            this.lMU.setVisibility(0);
            am.setImageResource(this.lMU, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.lMU.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.lMV = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.feQ, R.drawable.icon_live_close_n);
    }
}
