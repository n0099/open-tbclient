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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView gAy;
    private FrameAnimationView nNm;
    private ImageView nNn;
    private a nNo;

    /* loaded from: classes.dex */
    public interface a {
        void dTG();

        void dTH();
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
        this.nNm = new FrameAnimationView(context);
        this.nNm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.nNm, layoutParams);
        this.gAy = new TbImageView(context);
        this.gAy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.gAy.setAutoChangeStyle(false);
        addView(this.gAy, layoutParams2);
        this.nNn = new ImageView(context);
        this.nNn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.nNn, layoutParams3);
        this.nNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nNo != null) {
                    FloatingAnimationView.this.nNo.dTG();
                }
            }
        });
        this.nNm.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.nNm.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.nNm.getUrl())) {
                    FloatingAnimationView.this.nNm.startLoad(FloatingAnimationView.this.nNm.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.gAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nNo != null) {
                    FloatingAnimationView.this.nNo.dTH();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.nNm.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.nNm != null) {
            this.nNm.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.nNm != null) {
            this.nNm.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nNo = aVar;
    }

    public void onChangeSkinType() {
        ao.setImageResource(this.gAy, R.drawable.icon_live_close_n);
    }
}
