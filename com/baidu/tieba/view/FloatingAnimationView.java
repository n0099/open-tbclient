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
    private TbImageView fGO;
    private FrameAnimationView mHh;
    private ImageView mHi;
    private a mHj;

    /* loaded from: classes15.dex */
    public interface a {
        void dFb();

        void dFc();
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
        this.mHh = new FrameAnimationView(context);
        this.mHh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mHh, layoutParams);
        this.fGO = new TbImageView(context);
        this.fGO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fGO.setAutoChangeStyle(false);
        addView(this.fGO, layoutParams2);
        this.mHi = new ImageView(context);
        this.mHi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mHi, layoutParams3);
        this.mHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mHj != null) {
                    FloatingAnimationView.this.mHj.dFb();
                }
            }
        });
        this.mHh.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mHh.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.mHh.getUrl())) {
                    FloatingAnimationView.this.mHh.startLoad(FloatingAnimationView.this.mHh.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mHj != null) {
                    FloatingAnimationView.this.mHj.dFc();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.mHh.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mHh != null) {
            this.mHh.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mHh != null) {
            this.mHh.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mHj = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.fGO, R.drawable.icon_live_close_n);
    }
}
