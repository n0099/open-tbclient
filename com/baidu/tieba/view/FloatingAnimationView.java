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
    private FrameAnimationView mpt;
    private ImageView mpu;
    private a mpv;

    /* loaded from: classes15.dex */
    public interface a {
        void dtG();

        void dtH();
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
        this.mpt = new FrameAnimationView(context);
        this.mpt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mpt, layoutParams);
        this.fvw = new TbImageView(context);
        this.fvw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fvw.setAutoChangeStyle(false);
        addView(this.fvw, layoutParams2);
        this.mpu = new ImageView(context);
        this.mpu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mpu, layoutParams3);
        this.mpt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mpv != null) {
                    FloatingAnimationView.this.mpv.dtG();
                }
            }
        });
        this.mpt.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mpt.getBdImage() == null && !as.isEmpty(FloatingAnimationView.this.mpt.getUrl())) {
                    FloatingAnimationView.this.mpt.startLoad(FloatingAnimationView.this.mpt.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mpv != null) {
                    FloatingAnimationView.this.mpv.dtH();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!as.isEmpty(str)) {
            this.mpt.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mpt != null) {
            this.mpt.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mpt != null) {
            this.mpt.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mpv = aVar;
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.fvw, R.drawable.icon_live_close_n);
    }
}
