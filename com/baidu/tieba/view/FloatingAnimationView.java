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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView jhN;
    private TbImageView jhO;
    private ImageView jhP;
    private a jhQ;

    /* loaded from: classes3.dex */
    public interface a {
        void aSm();

        void aSn();
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
        this.jhN = new FrameAnimationView(context);
        this.jhN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.jhN, layoutParams);
        this.jhO = new TbImageView(context);
        this.jhO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, d.e.tbds62), l.h(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.jhO.setAutoChangeStyle(false);
        addView(this.jhO, layoutParams2);
        this.jhP = new ImageView(context);
        this.jhP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, d.e.tbds14);
        addView(this.jhP, layoutParams3);
        this.jhN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jhQ != null) {
                    FloatingAnimationView.this.jhQ.aSm();
                }
            }
        });
        this.jhN.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jhN.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jhN.getUrl())) {
                    FloatingAnimationView.this.jhN.startLoad(FloatingAnimationView.this.jhN.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jhO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jhQ != null) {
                    FloatingAnimationView.this.jhQ.aSn();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jhN.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jhN != null) {
            this.jhN.setData(list, i);
        }
    }

    public void cu() {
        if (this.jhN != null) {
            this.jhN.setImageResource(d.f.transparent_bg);
            this.jhN.cu();
        }
    }

    public void stopAnimation() {
        if (this.jhN != null) {
            this.jhN.setImageDrawable(null);
            this.jhN.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jhN != null) {
            this.jhN.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jhN != null) {
            this.jhN.release();
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jhP.setVisibility(0);
            al.c(this.jhP, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.jhP.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jhQ = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jhO, d.f.icon_live_close_n);
    }
}
