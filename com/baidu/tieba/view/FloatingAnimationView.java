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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes20.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView glU;
    private FrameAnimationView nAs;
    private ImageView nAt;
    private a nAu;

    /* loaded from: classes20.dex */
    public interface a {
        void dSA();

        void dSz();
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
        this.nAs = new FrameAnimationView(context);
        this.nAs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nAs, layoutParams);
        this.glU = new TbImageView(context);
        this.glU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.glU.setAutoChangeStyle(false);
        addView(this.glU, layoutParams2);
        this.nAt = new ImageView(context);
        this.nAt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nAt, layoutParams3);
        this.nAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nAu != null) {
                    FloatingAnimationView.this.nAu.dSz();
                }
            }
        });
        this.nAs.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nAs.getBdImage() == null && !au.isEmpty(FloatingAnimationView.this.nAs.getUrl())) {
                    FloatingAnimationView.this.nAs.startLoad(FloatingAnimationView.this.nAs.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.glU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nAu != null) {
                    FloatingAnimationView.this.nAu.dSA();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nAs.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nAs != null) {
            this.nAs.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nAs != null) {
            this.nAs.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nAu = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.glU, R.drawable.icon_live_close_n);
    }
}
