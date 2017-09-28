package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener {
    private ImageView gBr;
    private ImageView gBs;
    private ImageView gBt;
    private ImageView gBu;
    private a gBv;
    private View gBw;

    /* loaded from: classes2.dex */
    public interface a {
        void bxw();

        void bxx();

        void bxy();

        void bxz();
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
        this.gBr = (ImageView) findViewById(d.h.img_countdown);
        this.gBs = (ImageView) findViewById(d.h.img_sticker);
        this.gBt = (ImageView) findViewById(d.h.img_beauty);
        this.gBu = (ImageView) findViewById(d.h.img_filter);
        this.gBr.setOnClickListener(this);
        this.gBs.setOnClickListener(this);
        this.gBt.setOnClickListener(this);
        this.gBu.setOnClickListener(this);
    }

    public void reset() {
        this.gBw = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBv != null) {
            int id = view.getId();
            if (this.gBw == null || this.gBw.getId() != view.getId() || id != d.h.img_countdown) {
                this.gBw = view;
                if (id == d.h.img_countdown) {
                    this.gBv.bxw();
                } else if (id == d.h.img_sticker) {
                    this.gBv.bxx();
                } else if (id == d.h.img_beauty) {
                    this.gBv.bxy();
                } else if (id == d.h.img_filter) {
                    this.gBv.bxz();
                }
            }
        }
    }

    public void setListener(a aVar) {
        this.gBv = aVar;
    }
}
