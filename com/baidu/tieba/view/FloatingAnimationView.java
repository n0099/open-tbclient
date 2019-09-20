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
    private TbImageView drH;
    private FrameAnimationView jKw;
    private ImageView jKx;
    private a jKy;

    /* loaded from: classes3.dex */
    public interface a {
        void bcc();

        void bcd();
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
        this.jKw = new FrameAnimationView(context);
        this.jKw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jKw, layoutParams);
        this.drH = new TbImageView(context);
        this.drH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.drH.setAutoChangeStyle(false);
        addView(this.drH, layoutParams2);
        this.jKx = new ImageView(context);
        this.jKx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jKx, layoutParams3);
        this.jKw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jKy != null) {
                    FloatingAnimationView.this.jKy.bcc();
                }
            }
        });
        this.jKw.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jKw.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.jKw.getUrl())) {
                    FloatingAnimationView.this.jKw.startLoad(FloatingAnimationView.this.jKw.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.drH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jKy != null) {
                    FloatingAnimationView.this.jKy.bcd();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jKw.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jKw != null) {
            this.jKw.setData(list, i);
        }
    }

    public void br() {
        if (this.jKw != null) {
            this.jKw.setImageResource(R.drawable.transparent_bg);
            this.jKw.br();
        }
    }

    public void stopAnimation() {
        if (this.jKw != null) {
            this.jKw.setImageDrawable(null);
            this.jKw.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jKw != null) {
            this.jKw.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jKw != null) {
            this.jKw.release();
        }
    }

    public void rW(boolean z) {
        if (z) {
            this.jKx.setVisibility(0);
            am.c(this.jKx, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jKx.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jKy = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.drH, (int) R.drawable.icon_live_close_n);
    }
}
