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
    private TbImageView eoG;
    private FrameAnimationView kKd;
    private ImageView kKe;
    private a kKf;

    /* loaded from: classes8.dex */
    public interface a {
        void bwq();

        void bwr();
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
        this.kKd = new FrameAnimationView(context);
        this.kKd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kKd, layoutParams);
        this.eoG = new TbImageView(context);
        this.eoG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.eoG.setAutoChangeStyle(false);
        addView(this.eoG, layoutParams2);
        this.kKe = new ImageView(context);
        this.kKe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kKe, layoutParams3);
        this.kKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kKf != null) {
                    FloatingAnimationView.this.kKf.bwq();
                }
            }
        });
        this.kKd.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kKd.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kKd.getUrl())) {
                    FloatingAnimationView.this.kKd.startLoad(FloatingAnimationView.this.kKd.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.eoG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kKf != null) {
                    FloatingAnimationView.this.kKf.bwr();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kKd.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kKd != null) {
            this.kKd.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kKd != null) {
            this.kKd.setImageResource(R.drawable.transparent_bg);
            this.kKd.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kKd != null) {
            this.kKd.setImageDrawable(null);
            this.kKd.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kKd != null) {
            this.kKd.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kKd != null) {
            this.kKd.release();
        }
    }

    public void tH(boolean z) {
        if (z) {
            this.kKe.setVisibility(0);
            am.setImageResource(this.kKe, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kKe.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kKf = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.eoG, R.drawable.icon_live_close_n);
    }
}
