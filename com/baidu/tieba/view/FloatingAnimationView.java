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
    private FrameAnimationView jAI;
    private TbImageView jAJ;
    private ImageView jAK;
    private a jAL;

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
        this.jAI = new FrameAnimationView(context);
        this.jAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jAI, layoutParams);
        this.jAJ = new TbImageView(context);
        this.jAJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.jAJ.setAutoChangeStyle(false);
        addView(this.jAJ, layoutParams2);
        this.jAK = new ImageView(context);
        this.jAK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jAK, layoutParams3);
        this.jAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAL != null) {
                    FloatingAnimationView.this.jAL.aZx();
                }
            }
        });
        this.jAI.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jAI.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jAI.getUrl())) {
                    FloatingAnimationView.this.jAI.startLoad(FloatingAnimationView.this.jAI.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAL != null) {
                    FloatingAnimationView.this.jAL.aZy();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jAI.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jAI != null) {
            this.jAI.setData(list, i);
        }
    }

    public void bo() {
        if (this.jAI != null) {
            this.jAI.setImageResource(R.drawable.transparent_bg);
            this.jAI.bo();
        }
    }

    public void stopAnimation() {
        if (this.jAI != null) {
            this.jAI.setImageDrawable(null);
            this.jAI.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jAI != null) {
            this.jAI.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jAI != null) {
            this.jAI.release();
        }
    }

    public void rE(boolean z) {
        if (z) {
            this.jAK.setVisibility(0);
            al.c(this.jAK, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jAK.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jAL = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jAJ, (int) R.drawable.icon_live_close_n);
    }
}
