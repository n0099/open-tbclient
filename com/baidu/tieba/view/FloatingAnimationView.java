package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView gDw;
    private FrameAnimationView nXR;
    private ImageView nXS;
    private a nXT;

    /* loaded from: classes.dex */
    public interface a {
        void dWc();

        void dWd();
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
        this.nXR = new FrameAnimationView(context);
        this.nXR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nXR, layoutParams);
        this.gDw = new TbImageView(context);
        this.gDw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.gDw.setAutoChangeStyle(false);
        addView(this.gDw, layoutParams2);
        this.nXS = new ImageView(context);
        this.nXS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nXS, layoutParams3);
        this.nXR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nXT != null) {
                    FloatingAnimationView.this.nXT.dWc();
                }
            }
        });
        this.nXR.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nXR.getBdImage() == null && !au.isEmpty(FloatingAnimationView.this.nXR.getUrl())) {
                    FloatingAnimationView.this.nXR.startLoad(FloatingAnimationView.this.nXR.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.gDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nXT != null) {
                    FloatingAnimationView.this.nXT.dWd();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nXR.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nXR != null) {
            this.nXR.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nXR != null) {
            this.nXR.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nXT = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.gDw, R.drawable.icon_live_close_n);
    }
}
