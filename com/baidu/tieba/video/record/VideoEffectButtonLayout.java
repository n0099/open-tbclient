package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener {
    private ImageView gBq;
    private ImageView gBr;
    private ImageView gBs;
    private ImageView gBt;
    private a gBu;
    private View gBv;

    /* loaded from: classes2.dex */
    public interface a {
        void bxv();

        void bxw();

        void bxx();

        void bxy();
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
        this.gBq = (ImageView) findViewById(d.h.img_countdown);
        this.gBr = (ImageView) findViewById(d.h.img_sticker);
        this.gBs = (ImageView) findViewById(d.h.img_beauty);
        this.gBt = (ImageView) findViewById(d.h.img_filter);
        this.gBq.setOnClickListener(this);
        this.gBr.setOnClickListener(this);
        this.gBs.setOnClickListener(this);
        this.gBt.setOnClickListener(this);
    }

    public void reset() {
        this.gBv = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBu != null) {
            int id = view.getId();
            if (this.gBv == null || this.gBv.getId() != view.getId() || id != d.h.img_countdown) {
                this.gBv = view;
                if (id == d.h.img_countdown) {
                    this.gBu.bxv();
                } else if (id == d.h.img_sticker) {
                    this.gBu.bxw();
                } else if (id == d.h.img_beauty) {
                    this.gBu.bxx();
                } else if (id == d.h.img_filter) {
                    this.gBu.bxy();
                }
            }
        }
    }

    public void setListener(a aVar) {
        this.gBu = aVar;
    }
}
