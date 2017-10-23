package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener {
    private ImageView gBb;
    private ImageView gBc;
    private ImageView gBd;
    private ImageView gBe;
    private a gBf;
    private View gBg;

    /* loaded from: classes2.dex */
    public interface a {
        void bxn();

        void bxo();

        void bxp();

        void bxq();
    }

    public VideoEffectButtonLayout(Context context) {
        super(context);
        initView();
    }

    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), d.j.layout_video_effect_button, this);
        this.gBb = (ImageView) findViewById(d.h.img_countdown);
        this.gBc = (ImageView) findViewById(d.h.img_sticker);
        this.gBd = (ImageView) findViewById(d.h.img_beauty);
        this.gBe = (ImageView) findViewById(d.h.img_filter);
        this.gBb.setOnClickListener(this);
        this.gBc.setOnClickListener(this);
        this.gBd.setOnClickListener(this);
        this.gBe.setOnClickListener(this);
    }

    public void reset() {
        this.gBg = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBf != null) {
            int id = view.getId();
            if (this.gBg == null || this.gBg.getId() != view.getId() || id != d.h.img_countdown) {
                this.gBg = view;
                if (id == d.h.img_countdown) {
                    this.gBf.bxn();
                } else if (id == d.h.img_sticker) {
                    this.gBf.bxo();
                } else if (id == d.h.img_beauty) {
                    this.gBf.bxp();
                } else if (id == d.h.img_filter) {
                    this.gBf.bxq();
                }
            }
        }
    }

    public void setListener(a aVar) {
        this.gBf = aVar;
    }
}
