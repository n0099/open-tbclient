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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fqm;
    private FrameAnimationView mhY;
    private ImageView mhZ;
    private a mia;

    /* loaded from: classes8.dex */
    public interface a {
        void dqs();

        void dqt();
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
        this.mhY = new FrameAnimationView(context);
        this.mhY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mhY, layoutParams);
        this.fqm = new TbImageView(context);
        this.fqm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fqm.setAutoChangeStyle(false);
        addView(this.fqm, layoutParams2);
        this.mhZ = new ImageView(context);
        this.mhZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mhZ, layoutParams3);
        this.mhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mia != null) {
                    FloatingAnimationView.this.mia.dqs();
                }
            }
        });
        this.mhY.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mhY.getBdImage() == null && !ar.isEmpty(FloatingAnimationView.this.mhY.getUrl())) {
                    FloatingAnimationView.this.mhY.startLoad(FloatingAnimationView.this.mhY.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mia != null) {
                    FloatingAnimationView.this.mia.dqt();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ar.isEmpty(str)) {
            this.mhY.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mhY != null) {
            this.mhY.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mhY != null) {
            this.mhY.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mia = aVar;
    }

    public void onChangeSkinType() {
        an.setImageResource(this.fqm, R.drawable.icon_live_close_n);
    }
}
