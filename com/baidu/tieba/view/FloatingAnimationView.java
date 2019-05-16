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
    private FrameAnimationView jAH;
    private TbImageView jAI;
    private ImageView jAJ;
    private a jAK;

    /* loaded from: classes3.dex */
    public interface a {
        void aZu();

        void aZv();
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
        this.jAH = new FrameAnimationView(context);
        this.jAH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jAH, layoutParams);
        this.jAI = new TbImageView(context);
        this.jAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.jAI.setAutoChangeStyle(false);
        addView(this.jAI, layoutParams2);
        this.jAJ = new ImageView(context);
        this.jAJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jAJ, layoutParams3);
        this.jAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAK != null) {
                    FloatingAnimationView.this.jAK.aZu();
                }
            }
        });
        this.jAH.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jAH.getBdImage() == null && !ap.isEmpty(FloatingAnimationView.this.jAH.getUrl())) {
                    FloatingAnimationView.this.jAH.startLoad(FloatingAnimationView.this.jAH.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.jAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jAK != null) {
                    FloatingAnimationView.this.jAK.aZv();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jAH.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jAH != null) {
            this.jAH.setData(list, i);
        }
    }

    public void bo() {
        if (this.jAH != null) {
            this.jAH.setImageResource(R.drawable.transparent_bg);
            this.jAH.bo();
        }
    }

    public void stopAnimation() {
        if (this.jAH != null) {
            this.jAH.setImageDrawable(null);
            this.jAH.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jAH != null) {
            this.jAH.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jAH != null) {
            this.jAH.release();
        }
    }

    public void rE(boolean z) {
        if (z) {
            this.jAJ.setVisibility(0);
            al.c(this.jAJ, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jAJ.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jAK = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.jAI, (int) R.drawable.icon_live_close_n);
    }
}
