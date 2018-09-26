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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private FrameAnimationView hwW;
    private TbImageView hwX;
    private ImageView hwY;
    private a hwZ;

    /* loaded from: classes.dex */
    public interface a {
        void amw();

        void amx();
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
        this.hwW = new FrameAnimationView(context);
        this.hwW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, e.C0141e.tbds200), l.h(context, e.C0141e.tbds200));
        layoutParams.gravity = 17;
        addView(this.hwW, layoutParams);
        this.hwX = new TbImageView(context);
        this.hwX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.h(context, e.C0141e.tbds62), l.h(context, e.C0141e.tbds62));
        layoutParams2.gravity = 53;
        this.hwX.setAutoChangeStyle(false);
        addView(this.hwX, layoutParams2);
        this.hwY = new ImageView(context);
        this.hwY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.h(context, e.C0141e.tbds14);
        addView(this.hwY, layoutParams3);
        this.hwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hwZ != null) {
                    FloatingAnimationView.this.hwZ.amw();
                }
            }
        });
        this.hwW.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.hwW.getBdImage() == null && !ao.isEmpty(FloatingAnimationView.this.hwW.getUrl())) {
                    FloatingAnimationView.this.hwW.startLoad(FloatingAnimationView.this.hwW.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.hwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.hwZ != null) {
                    FloatingAnimationView.this.hwZ.amx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hwW.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.hwW != null) {
            this.hwW.setData(list, i);
        }
    }

    public void ce() {
        if (this.hwW != null) {
            this.hwW.setImageResource(e.f.transparent_bg);
            this.hwW.ce();
        }
    }

    public void stopAnimation() {
        if (this.hwW != null) {
            this.hwW.setImageDrawable(null);
            this.hwW.stopAnimation();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hwW != null) {
            this.hwW.setPageId(bdUniqueId);
        }
    }

    public void release() {
        if (this.hwW != null) {
            this.hwW.release();
        }
    }

    public void nF(boolean z) {
        if (z) {
            this.hwY.setVisibility(0);
            al.c(this.hwY, e.f.icon_front_worldcup_new_n);
            return;
        }
        this.hwY.setVisibility(8);
    }

    public void setCallback(a aVar) {
        this.hwZ = aVar;
    }

    public void onChangeSkinType() {
        al.c(this.hwX, e.f.icon_live_close_n);
    }
}
