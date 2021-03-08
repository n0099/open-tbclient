package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView gFf;
    private FrameAnimationView nZW;
    private ImageView nZX;
    private a nZY;

    /* loaded from: classes.dex */
    public interface a {
        void dWk();

        void dWl();
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
        this.nZW = new FrameAnimationView(context);
        this.nZW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nZW, layoutParams);
        this.gFf = new TbImageView(context);
        this.gFf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.gFf.setAutoChangeStyle(false);
        addView(this.gFf, layoutParams2);
        this.nZX = new ImageView(context);
        this.nZX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nZX, layoutParams3);
        this.nZW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nZY != null) {
                    FloatingAnimationView.this.nZY.dWk();
                }
            }
        });
        this.nZW.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nZW.getBdImage() == null && !au.isEmpty(FloatingAnimationView.this.nZW.getUrl())) {
                    FloatingAnimationView.this.nZW.startLoad(FloatingAnimationView.this.nZW.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.gFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nZY != null) {
                    FloatingAnimationView.this.nZY.dWl();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nZW.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nZW != null) {
            this.nZW.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nZW != null) {
            this.nZW.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nZY = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.gFf, R.drawable.icon_live_close_n);
    }
}
