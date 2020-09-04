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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fGS;
    private ImageView mHA;
    private a mHB;
    private FrameAnimationView mHz;

    /* loaded from: classes15.dex */
    public interface a {
        void dFk();

        void dFl();
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
        this.mHz = new FrameAnimationView(context);
        this.mHz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mHz, layoutParams);
        this.fGS = new TbImageView(context);
        this.fGS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fGS.setAutoChangeStyle(false);
        addView(this.fGS, layoutParams2);
        this.mHA = new ImageView(context);
        this.mHA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mHA, layoutParams3);
        this.mHz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mHB != null) {
                    FloatingAnimationView.this.mHB.dFk();
                }
            }
        });
        this.mHz.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mHz.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.mHz.getUrl())) {
                    FloatingAnimationView.this.mHz.startLoad(FloatingAnimationView.this.mHz.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fGS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mHB != null) {
                    FloatingAnimationView.this.mHB.dFl();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.mHz.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mHz != null) {
            this.mHz.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mHz != null) {
            this.mHz.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mHB = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.fGS, R.drawable.icon_live_close_n);
    }
}
