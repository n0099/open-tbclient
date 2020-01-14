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
/* loaded from: classes6.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView ejQ;
    private FrameAnimationView kHn;
    private ImageView kHo;
    private a kHp;

    /* loaded from: classes6.dex */
    public interface a {
        void buE();

        void buF();
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
        this.kHn = new FrameAnimationView(context);
        this.kHn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.kHn, layoutParams);
        this.ejQ = new TbImageView(context);
        this.ejQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.ejQ.setAutoChangeStyle(false);
        addView(this.ejQ, layoutParams2);
        this.kHo = new ImageView(context);
        this.kHo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.kHo, layoutParams3);
        this.kHn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kHp != null) {
                    FloatingAnimationView.this.kHp.buE();
                }
            }
        });
        this.kHn.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.kHn.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.kHn.getUrl())) {
                    FloatingAnimationView.this.kHn.startLoad(FloatingAnimationView.this.kHn.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.ejQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.kHp != null) {
                    FloatingAnimationView.this.kHp.buF();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.kHn.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.kHn != null) {
            this.kHn.setData(list, i);
        }
    }

    public void playAnimation() {
        if (this.kHn != null) {
            this.kHn.setImageResource(R.drawable.transparent_bg);
            this.kHn.playAnimation();
        }
    }

    public void stopAnimation() {
        if (this.kHn != null) {
            this.kHn.setImageDrawable(null);
            this.kHn.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.kHn != null) {
            this.kHn.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.kHn != null) {
            this.kHn.release();
        }
    }

    public void tx(boolean z) {
        if (z) {
            this.kHo.setVisibility(0);
            am.setImageResource(this.kHo, R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.kHo.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.kHp = aVar;
    }

    public void onChangeSkinType() {
        am.setImageResource(this.ejQ, R.drawable.icon_live_close_n);
    }
}
