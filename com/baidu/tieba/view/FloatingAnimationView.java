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
/* loaded from: classes20.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fKe;
    private FrameAnimationView mRl;
    private ImageView mRm;
    private a mRn;

    /* loaded from: classes20.dex */
    public interface a {
        void dJe();

        void dJf();
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
        this.mRl = new FrameAnimationView(context);
        this.mRl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mRl, layoutParams);
        this.fKe = new TbImageView(context);
        this.fKe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fKe.setAutoChangeStyle(false);
        addView(this.fKe, layoutParams2);
        this.mRm = new ImageView(context);
        this.mRm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mRm, layoutParams3);
        this.mRl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mRn != null) {
                    FloatingAnimationView.this.mRn.dJe();
                }
            }
        });
        this.mRl.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mRl.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.mRl.getUrl())) {
                    FloatingAnimationView.this.mRl.startLoad(FloatingAnimationView.this.mRl.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mRn != null) {
                    FloatingAnimationView.this.mRn.dJf();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.mRl.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mRl != null) {
            this.mRl.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mRl != null) {
            this.mRl.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mRn = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.fKe, R.drawable.icon_live_close_n);
    }
}
