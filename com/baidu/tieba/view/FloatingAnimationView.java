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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fvw;
    private FrameAnimationView mpr;
    private ImageView mps;
    private a mpt;

    /* loaded from: classes15.dex */
    public interface a {
        void dtF();

        void dtG();
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
        this.mpr = new FrameAnimationView(context);
        this.mpr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mpr, layoutParams);
        this.fvw = new TbImageView(context);
        this.fvw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fvw.setAutoChangeStyle(false);
        addView(this.fvw, layoutParams2);
        this.mps = new ImageView(context);
        this.mps.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mps, layoutParams3);
        this.mpr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mpt != null) {
                    FloatingAnimationView.this.mpt.dtF();
                }
            }
        });
        this.mpr.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mpr.getBdImage() == null && !as.isEmpty(FloatingAnimationView.this.mpr.getUrl())) {
                    FloatingAnimationView.this.mpr.startLoad(FloatingAnimationView.this.mpr.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mpt != null) {
                    FloatingAnimationView.this.mpt.dtG();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!as.isEmpty(str)) {
            this.mpr.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mpr != null) {
            this.mpr.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mpr != null) {
            this.mpr.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mpt = aVar;
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.fvw, R.drawable.icon_live_close_n);
    }
}
