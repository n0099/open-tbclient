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
    private TbImageView gud;
    private FrameAnimationView nOu;
    private ImageView nOv;
    private a nOw;

    /* loaded from: classes21.dex */
    public interface a {
        void dXT();

        void dXU();
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
        this.nOu = new FrameAnimationView(context);
        this.nOu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nOu, layoutParams);
        this.gud = new TbImageView(context);
        this.gud.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.gud.setAutoChangeStyle(false);
        addView(this.gud, layoutParams2);
        this.nOv = new ImageView(context);
        this.nOv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nOv, layoutParams3);
        this.nOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nOw != null) {
                    FloatingAnimationView.this.nOw.dXT();
                }
            }
        });
        this.nOu.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nOu.getBdImage() == null && !au.isEmpty(FloatingAnimationView.this.nOu.getUrl())) {
                    FloatingAnimationView.this.nOu.startLoad(FloatingAnimationView.this.nOu.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.gud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nOw != null) {
                    FloatingAnimationView.this.nOw.dXU();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nOu.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nOu != null) {
            this.nOu.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nOu != null) {
            this.nOu.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nOw = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.gud, R.drawable.icon_live_close_n);
    }
}
