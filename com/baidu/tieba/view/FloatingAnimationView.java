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
    private TbImageView ggz;
    private FrameAnimationView ntq;
    private ImageView ntr;
    private a nts;

    /* loaded from: classes21.dex */
    public interface a {
        void dPY();

        void dPZ();
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
        this.ntq = new FrameAnimationView(context);
        this.ntq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.ntq, layoutParams);
        this.ggz = new TbImageView(context);
        this.ggz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.ggz.setAutoChangeStyle(false);
        addView(this.ggz, layoutParams2);
        this.ntr = new ImageView(context);
        this.ntr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.ntr, layoutParams3);
        this.ntq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nts != null) {
                    FloatingAnimationView.this.nts.dPY();
                }
            }
        });
        this.ntq.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.ntq.getBdImage() == null && !at.isEmpty(FloatingAnimationView.this.ntq.getUrl())) {
                    FloatingAnimationView.this.ntq.startLoad(FloatingAnimationView.this.ntq.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.ggz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.nts != null) {
                    FloatingAnimationView.this.nts.dPZ();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.ntq.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.ntq != null) {
            this.ntq.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ntq != null) {
            this.ntq.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.nts = aVar;
    }

    public void onChangeSkinType() {
        ap.setImageResource(this.ggz, R.drawable.icon_live_close_n);
    }
}
