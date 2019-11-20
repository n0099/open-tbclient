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
    private TbImageView dya;
    private FrameAnimationView jJu;
    private ImageView jJv;
    private a jJw;

    /* loaded from: classes3.dex */
    public interface a {
        void bcf();

        void bcg();
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
        this.jJu = new FrameAnimationView(context);
        this.jJu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jJu, layoutParams);
        this.dya = new TbImageView(context);
        this.dya.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.dya.setAutoChangeStyle(false);
        addView(this.dya, layoutParams2);
        this.jJv = new ImageView(context);
        this.jJv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.jJv, layoutParams3);
        this.jJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jJw != null) {
                    FloatingAnimationView.this.jJw.bcf();
                }
            }
        });
        this.jJu.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jJu.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.jJu.getUrl())) {
                    FloatingAnimationView.this.jJu.startLoad(FloatingAnimationView.this.jJu.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.dya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jJw != null) {
                    FloatingAnimationView.this.jJw.bcg();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jJu.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jJu != null) {
            this.jJu.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.jJu != null) {
            this.jJu.setImageResource(R.drawable.transparent_bg);
            this.jJu.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.jJu != null) {
            this.jJu.setImageDrawable(null);
            this.jJu.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jJu != null) {
            this.jJu.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jJu != null) {
            this.jJu.release();
        }
    }

    public void rF(boolean z) {
        if (z) {
            this.jJv.setVisibility(0);
            am.setImageResource(this.jJv, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jJv.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jJw = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.dya, R.drawable.icon_live_close_n);
    }
}
