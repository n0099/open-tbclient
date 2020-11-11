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
    private TbImageView gmn;
    private FrameAnimationView nzl;
    private ImageView nzm;
    private a nzn;

    /* loaded from: classes21.dex */
    public interface a {
        void dSA();

        void dSB();
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
        this.nzl = new FrameAnimationView(context);
        this.nzl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nzl, layoutParams);
        this.gmn = new TbImageView(context);
        this.gmn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.gmn.setAutoChangeStyle(false);
        addView(this.gmn, layoutParams2);
        this.nzm = new ImageView(context);
        this.nzm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nzm, layoutParams3);
        this.nzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nzn != null) {
                    FloatingAnimationView.this.nzn.dSA();
                }
            }
        });
        this.nzl.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nzl.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.nzl.getUrl())) {
                    FloatingAnimationView.this.nzl.startLoad(FloatingAnimationView.this.nzl.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.gmn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nzn != null) {
                    FloatingAnimationView.this.nzn.dSB();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.nzl.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nzl != null) {
            this.nzl.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nzl != null) {
            this.nzl.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nzn = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.gmn, R.drawable.icon_live_close_n);
    }
}
