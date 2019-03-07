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
    private FrameAnimationView jhM;
    private TbImageView jhN;
    private ImageView jhO;
    private a jhP;

    /* loaded from: classes3.dex */
    public interface a {
        void aSo();

        void aSp();
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
        this.jhM = new FrameAnimationView(context);
        this.jhM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
        layoutParams.gravity = 17;
        addView(this.jhM, layoutParams);
        this.jhN = new TbImageView(context);
        this.jhN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, d.e.tbds62), l.h(context, d.e.tbds62));
        layoutParams2.gravity = 53;
        this.jhN.setAutoChangeStyle(false);
        addView(this.jhN, layoutParams2);
        this.jhO = new ImageView(context);
        this.jhO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, d.e.tbds14);
        addView(this.jhO, layoutParams3);
        this.jhM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jhP != null) {
                    FloatingAnimationView.this.jhP.aSo();
                }
            }
        });
        this.jhM.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jhM.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jhM.getUrl())) {
                    FloatingAnimationView.this.jhM.startLoad(FloatingAnimationView.this.jhM.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jhN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jhP != null) {
                    FloatingAnimationView.this.jhP.aSp();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jhM.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jhM != null) {
            this.jhM.setData(list, i);
        }
    }

    public void cu() {
        if (this.jhM != null) {
            this.jhM.setImageResource(d.f.transparent_bg);
            this.jhM.cu();
        }
    }

    public void stopAnimation() {
        if (this.jhM != null) {
            this.jhM.setImageDrawable(null);
            this.jhM.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jhM != null) {
            this.jhM.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jhM != null) {
            this.jhM.release();
        }
    }

    public void qP(boolean z) {
        if (z) {
            this.jhO.setVisibility(0);
            al.c(this.jhO, d.f.icon_front_worldcup_new_n);
            return;
        }
        this.jhO.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jhP = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jhN, d.f.icon_live_close_n);
    }
}
