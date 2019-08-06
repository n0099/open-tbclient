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
    private TbImageView dpW;
    private FrameAnimationView jIb;
    private ImageView jIc;
    private a jId;

    /* loaded from: classes3.dex */
    public interface a {
        void bby();

        void bbz();
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
        this.jIb = new FrameAnimationView(context);
        this.jIb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jIb, layoutParams);
        this.dpW = new TbImageView(context);
        this.dpW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.dpW.setAutoChangeStyle(false);
        addView(this.dpW, layoutParams2);
        this.jIc = new ImageView(context);
        this.jIc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jIc, layoutParams3);
        this.jIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jId != null) {
                    FloatingAnimationView.this.jId.bby();
                }
            }
        });
        this.jIb.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jIb.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.jIb.getUrl())) {
                    FloatingAnimationView.this.jIb.startLoad(FloatingAnimationView.this.jIb.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.dpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jId != null) {
                    FloatingAnimationView.this.jId.bbz();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jIb.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jIb != null) {
            this.jIb.setData(list, i);
        }
    }

    public void br() {
        if (this.jIb != null) {
            this.jIb.setImageResource(R.drawable.transparent_bg);
            this.jIb.br();
        }
    }

    public void stopAnimation() {
        if (this.jIb != null) {
            this.jIb.setImageDrawable(null);
            this.jIb.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jIb != null) {
            this.jIb.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jIb != null) {
            this.jIb.release();
        }
    }

    public void rT(boolean z) {
        if (z) {
            this.jIc.setVisibility(0);
            am.c(this.jIc, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jIc.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jId = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.dpW, (int) R.drawable.icon_live_close_n);
    }
}
