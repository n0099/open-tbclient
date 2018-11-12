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
    private ImageView hBV;
    private ImageView hBW;
    private ImageView hBX;
    private ImageView hBY;
    private LinearLayout hBZ;
    private LinearLayout hCa;
    private LinearLayout hCb;
    private LinearLayout hCc;
    private a hCd;
    private View hCe;

    /* loaded from: classes5.dex */
    public interface a {
        void bIC();

        void bID();

        void bIE();

        void bIF();
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
        this.hBZ = (LinearLayout) findViewById(e.g.layout_music);
        this.hCa = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hCb = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hCc = (LinearLayout) findViewById(e.g.layout_filter);
        this.hBV = (ImageView) findViewById(e.g.img_music);
        this.hBW = (ImageView) findViewById(e.g.img_sticker);
        this.hBX = (ImageView) findViewById(e.g.img_beauty);
        this.hBY = (ImageView) findViewById(e.g.img_filter);
        this.hBV.setOnClickListener(this);
        this.hBW.setOnClickListener(this);
        this.hBX.setOnClickListener(this);
        this.hBY.setOnClickListener(this);
    }

    public void reset() {
        this.hCe = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hBZ.setVisibility(i2);
                return;
            case 1:
                this.hCa.setVisibility(i2);
                return;
            case 2:
                this.hCb.setVisibility(i2);
                return;
            case 3:
                this.hCc.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hBV.setSelected(z);
                return;
            case 1:
                this.hBW.setSelected(z);
                return;
            case 2:
                this.hBX.setSelected(z);
                return;
            case 3:
                this.hBY.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCd != null) {
            int id = view.getId();
            this.hCe = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hCd.bIC();
                amVar.x("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hCd.bID();
                amVar.x("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hCd.bIE();
                amVar.x("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hCd.bIF();
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hCd = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wg(int i) {
        if (i == 1) {
            this.hBV.setImageResource(e.f.icon_video_music);
        } else {
            this.hBV.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
