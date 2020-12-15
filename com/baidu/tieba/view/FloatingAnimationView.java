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
/* loaded from: classes21.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView guf;
    private FrameAnimationView nOw;
    private ImageView nOx;
    private a nOy;

    /* loaded from: classes21.dex */
    public interface a {
        void dXU();

        void dXV();
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
        this.nOw = new FrameAnimationView(context);
        this.nOw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nOw, layoutParams);
        this.guf = new TbImageView(context);
        this.guf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.guf.setAutoChangeStyle(false);
        addView(this.guf, layoutParams2);
        this.nOx = new ImageView(context);
        this.nOx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nOx, layoutParams3);
        this.nOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nOy != null) {
                    FloatingAnimationView.this.nOy.dXU();
                }
            }
        });
        this.nOw.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nOw.getBdImage() == null && !au.isEmpty(FloatingAnimationView.this.nOw.getUrl())) {
                    FloatingAnimationView.this.nOw.startLoad(FloatingAnimationView.this.nOw.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.guf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nOy != null) {
                    FloatingAnimationView.this.nOy.dXV();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nOw.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nOw != null) {
            this.nOw.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nOw != null) {
            this.nOw.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nOy = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.guf, R.drawable.icon_live_close_n);
    }
}
