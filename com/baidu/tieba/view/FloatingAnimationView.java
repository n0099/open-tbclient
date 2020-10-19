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
/* loaded from: classes21.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fWv;
    private FrameAnimationView ngP;
    private ImageView ngQ;
    private a ngR;

    /* loaded from: classes21.dex */
    public interface a {
        void dMQ();

        void dMR();
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
        this.ngP = new FrameAnimationView(context);
        this.ngP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.ngP, layoutParams);
        this.fWv = new TbImageView(context);
        this.fWv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fWv.setAutoChangeStyle(false);
        addView(this.fWv, layoutParams2);
        this.ngQ = new ImageView(context);
        this.ngQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.ngQ, layoutParams3);
        this.ngP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.ngR != null) {
                    FloatingAnimationView.this.ngR.dMQ();
                }
            }
        });
        this.ngP.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.ngP.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.ngP.getUrl())) {
                    FloatingAnimationView.this.ngP.startLoad(FloatingAnimationView.this.ngP.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.ngR != null) {
                    FloatingAnimationView.this.ngR.dMR();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.ngP.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.ngP != null) {
            this.ngP.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ngP != null) {
            this.ngP.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.ngR = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.fWv, R.drawable.icon_live_close_n);
    }
}
