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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView jAL;
    private TbImageView jAM;
    private ImageView jAN;
    private a jAO;

    /* loaded from: classes3.dex */
    public interface a {
        void aZx();

        void aZy();
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
        this.jAL = new FrameAnimationView(context);
        this.jAL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jAL, layoutParams);
        this.jAM = new TbImageView(context);
        this.jAM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.jAM.setAutoChangeStyle(false);
        addView(this.jAM, layoutParams2);
        this.jAN = new ImageView(context);
        this.jAN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jAN, layoutParams3);
        this.jAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAO != null) {
                    FloatingAnimationView.this.jAO.aZx();
                }
            }
        });
        this.jAL.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jAL.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jAL.getUrl())) {
                    FloatingAnimationView.this.jAL.startLoad(FloatingAnimationView.this.jAL.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAO != null) {
                    FloatingAnimationView.this.jAO.aZy();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jAL.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jAL != null) {
            this.jAL.setData(list, i);
        }
    }

    public void bo() {
        if (this.jAL != null) {
            this.jAL.setImageResource(R.drawable.transparent_bg);
            this.jAL.bo();
        }
    }

    public void stopAnimation() {
        if (this.jAL != null) {
            this.jAL.setImageDrawable(null);
            this.jAL.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jAL != null) {
            this.jAL.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jAL != null) {
            this.jAL.release();
        }
    }

    public void rF(boolean z) {
        if (z) {
            this.jAN.setVisibility(0);
            al.c(this.jAN, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jAN.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jAO = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jAM, (int) R.drawable.icon_live_close_n);
    }
}
