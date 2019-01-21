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
    private ImageView hND;
    private LinearLayout hNE;
    private LinearLayout hNF;
    private LinearLayout hNG;
    private LinearLayout hNH;
    private a hNI;
    private View hNJ;

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
        this.hNE = (LinearLayout) findViewById(e.g.layout_music);
        this.hNF = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hNG = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hNH = (LinearLayout) findViewById(e.g.layout_filter);
        this.hNA = (ImageView) findViewById(e.g.img_music);
        this.hNB = (ImageView) findViewById(e.g.img_sticker);
        this.hNC = (ImageView) findViewById(e.g.img_beauty);
        this.hND = (ImageView) findViewById(e.g.img_filter);
        this.hNA.setOnClickListener(this);
        this.hNB.setOnClickListener(this);
        this.hNC.setOnClickListener(this);
        this.hND.setOnClickListener(this);
    }

    public void reset() {
        this.hNJ = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hNE.setVisibility(i2);
                return;
            case 1:
                this.hNF.setVisibility(i2);
                return;
            case 2:
                this.hNG.setVisibility(i2);
                return;
            case 3:
                this.hNH.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hNA.setSelected(z);
                return;
            case 1:
                this.hNB.setSelected(z);
                return;
            case 2:
                this.hNC.setSelected(z);
                return;
            case 3:
                this.hND.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hNI != null) {
            int id = view.getId();
            this.hNJ = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hNI.bMf();
                amVar.y("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hNI.bMg();
                amVar.y("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hNI.bMh();
                amVar.y("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hNI.bMi();
                amVar.y("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hNI = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wT(int i) {
        if (i == 1) {
            this.hNA.setImageResource(e.f.icon_video_music);
        } else {
            this.hNA.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
