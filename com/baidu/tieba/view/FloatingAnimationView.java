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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class FloatingAnimationView extends FrameLayout {
    private TbImageView fqm;
    private FrameAnimationView mib;
    private ImageView mic;
    private a mie;

    /* loaded from: classes8.dex */
    public interface a {
        void dqw();

        void dqx();
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
        this.mib = new FrameAnimationView(context);
        this.mib.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
        layoutParams.gravity = 17;
        addView(this.mib, layoutParams);
        this.fqm = new TbImageView(context);
        this.fqm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds62), l.getDimens(context, R.dimen.tbds62));
        layoutParams2.gravity = 53;
        this.fqm.setAutoChangeStyle(false);
        addView(this.fqm, layoutParams2);
        this.mic = new ImageView(context);
        this.mic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 51;
        layoutParams3.topMargin = l.getDimens(context, R.dimen.tbds14);
        addView(this.mic, layoutParams3);
        this.mib.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mie != null) {
                    FloatingAnimationView.this.mie.dqw();
                }
            }
        });
        this.mib.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.view.FloatingAnimationView.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (FloatingAnimationView.this.mib.getBdImage() == null && !ar.isEmpty(FloatingAnimationView.this.mib.getUrl())) {
                    FloatingAnimationView.this.mib.startLoad(FloatingAnimationView.this.mib.getUrl(), 10, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
        this.fqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FloatingAnimationView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FloatingAnimationView.this.mie != null) {
                    FloatingAnimationView.this.mie.dqx();
                }
            }
        });
        onChangeSkinType();
    }

    public void setData(String str) {
        if (!ar.isEmpty(str)) {
            this.mib.setData(str);
        }
    }

    public void setData(List<String> list, int i) {
        if (this.mib != null) {
            this.mib.setData(list, i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.mib != null) {
            this.mib.setPageId(bdUniqueId);
        }
    }

    public void setCallback(a aVar) {
        this.mie = aVar;
    }

    public void onChangeSkinType() {
        an.setImageResource(this.fqm, R.drawable.icon_live_close_n);
    }
}
