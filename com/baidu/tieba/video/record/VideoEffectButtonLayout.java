package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.i;
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hNA;
    private ImageView hNB;
    private ImageView hNC;
    private LinearLayout hND;
    private LinearLayout hNE;
    private LinearLayout hNF;
    private LinearLayout hNG;
    private a hNH;
    private View hNI;
    private ImageView hNz;

    /* loaded from: classes5.dex */
    public interface a {
        void bMf();

        void bMg();

        void bMh();

        void bMi();
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
        inflate(getContext(), e.h.layout_video_effect_button, this);
        this.hND = (LinearLayout) findViewById(e.g.layout_music);
        this.hNE = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hNF = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hNG = (LinearLayout) findViewById(e.g.layout_filter);
        this.hNz = (ImageView) findViewById(e.g.img_music);
        this.hNA = (ImageView) findViewById(e.g.img_sticker);
        this.hNB = (ImageView) findViewById(e.g.img_beauty);
        this.hNC = (ImageView) findViewById(e.g.img_filter);
        this.hNz.setOnClickListener(this);
        this.hNA.setOnClickListener(this);
        this.hNB.setOnClickListener(this);
        this.hNC.setOnClickListener(this);
    }

    public void reset() {
        this.hNI = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hND.setVisibility(i2);
                return;
            case 1:
                this.hNE.setVisibility(i2);
                return;
            case 2:
                this.hNF.setVisibility(i2);
                return;
            case 3:
                this.hNG.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hNz.setSelected(z);
                return;
            case 1:
                this.hNA.setSelected(z);
                return;
            case 2:
                this.hNB.setSelected(z);
                return;
            case 3:
                this.hNC.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hNH != null) {
            int id = view.getId();
            this.hNI = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hNH.bMf();
                amVar.y("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hNH.bMg();
                amVar.y("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hNH.bMh();
                amVar.y("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hNH.bMi();
                amVar.y("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hNH = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wT(int i) {
        if (i == 1) {
            this.hNz.setImageResource(e.f.icon_video_music);
        } else {
            this.hNz.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
