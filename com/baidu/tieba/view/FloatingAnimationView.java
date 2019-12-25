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
/* loaded from: classes5.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView ejc;
    private FrameAnimationView kDH;
    private ImageView kDI;
    private a kDJ;

    /* loaded from: classes5.dex */
    public interface a {
        void btC();

        void btD();
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
        this.kDH = new FrameAnimationView(context);
        this.kDH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kDH, layoutParams);
        this.ejc = new TbImageView(context);
        this.ejc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.ejc.setAutoChangeStyle(false);
        addView(this.ejc, layoutParams2);
        this.kDI = new ImageView(context);
        this.kDI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kDI, layoutParams3);
        this.kDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kDJ != null) {
                    FloatingAnimationView.this.kDJ.btC();
                }
            }
        });
        this.kDH.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kDH.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kDH.getUrl())) {
                    FloatingAnimationView.this.kDH.startLoad(FloatingAnimationView.this.kDH.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.ejc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kDJ != null) {
                    FloatingAnimationView.this.kDJ.btD();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kDH.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kDH != null) {
            this.kDH.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kDH != null) {
            this.kDH.setImageResource(R.drawable.transparent_bg);
            this.kDH.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kDH != null) {
            this.kDH.setImageDrawable(null);
            this.kDH.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kDH != null) {
            this.kDH.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kDH != null) {
            this.kDH.release();
        }
    }

    public void tl(boolean z) {
        if (z) {
            this.kDI.setVisibility(0);
            am.setImageResource(this.kDI, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kDI.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kDJ = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.ejc, R.drawable.icon_live_close_n);
    }
}
