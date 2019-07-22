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
    private TbImageView dpP;
    private FrameAnimationView jGU;
    private ImageView jGV;
    private a jGW;

    /* loaded from: classes3.dex */
    public interface a {
        void bbw();

        void bbx();
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
        this.jGU = new FrameAnimationView(context);
        this.jGU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.jGU, layoutParams);
        this.dpP = new TbImageView(context);
        this.dpP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds62), l.g(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.dpP.setAutoChangeStyle(false);
        addView(this.dpP, layoutParams2);
        this.jGV = new ImageView(context);
        this.jGV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.g(context, R.dimen.tbds14);
        addView(this.jGV, layoutParams3);
        this.jGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jGW != null) {
                    FloatingAnimationView.this.jGW.bbw();
                }
            }
        });
        this.jGU.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.jGU.getBdImage() == null && !aq.isEmpty(FloatingAnimationView.this.jGU.getUrl())) {
                    FloatingAnimationView.this.jGU.startLoad(FloatingAnimationView.this.jGU.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.dpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.jGW != null) {
                    FloatingAnimationView.this.jGW.bbx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jGU.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.jGU != null) {
            this.jGU.setData(list, i);
        }
    }

    public void br() {
        if (this.jGU != null) {
            this.jGU.setImageResource(R.drawable.transparent_bg);
            this.jGU.br();
        }
    }

    public void stopAnimation() {
        if (this.jGU != null) {
            this.jGU.setImageDrawable(null);
            this.jGU.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jGU != null) {
            this.jGU.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.jGU != null) {
            this.jGU.release();
        }
    }

    public void rS(boolean z) {
        if (z) {
            this.jGV.setVisibility(0);
            am.c(this.jGV, (int) R.drawable.icon_front_worldcup_new_n);
            return;
        }
        this.jGV.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.jGW = aVar;
    }

    public void onChangeSkinType() {
        am.c(this.dpP, (int) R.drawable.icon_live_close_n);
    }
}
