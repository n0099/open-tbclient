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
    private a hMA;
    private View hMB;
    private ImageView hMs;
    private ImageView hMt;
    private ImageView hMu;
    private ImageView hMv;
    private LinearLayout hMw;
    private LinearLayout hMx;
    private LinearLayout hMy;
    private LinearLayout hMz;

    /* loaded from: classes5.dex */
    public interface a {
        void bLw();

        void bLx();

        void bLy();

        void bLz();
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
        this.hMw = (LinearLayout) findViewById(e.g.layout_music);
        this.hMx = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hMy = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hMz = (LinearLayout) findViewById(e.g.layout_filter);
        this.hMs = (ImageView) findViewById(e.g.img_music);
        this.hMt = (ImageView) findViewById(e.g.img_sticker);
        this.hMu = (ImageView) findViewById(e.g.img_beauty);
        this.hMv = (ImageView) findViewById(e.g.img_filter);
        this.hMs.setOnClickListener(this);
        this.hMt.setOnClickListener(this);
        this.hMu.setOnClickListener(this);
        this.hMv.setOnClickListener(this);
    }

    public void reset() {
        this.hMB = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hMw.setVisibility(i2);
                return;
            case 1:
                this.hMx.setVisibility(i2);
                return;
            case 2:
                this.hMy.setVisibility(i2);
                return;
            case 3:
                this.hMz.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hMs.setSelected(z);
                return;
            case 1:
                this.hMt.setSelected(z);
                return;
            case 2:
                this.hMu.setSelected(z);
                return;
            case 3:
                this.hMv.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hMA != null) {
            int id = view.getId();
            this.hMB = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hMA.bLw();
                amVar.x("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hMA.bLx();
                amVar.x("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hMA.bLy();
                amVar.x("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hMA.bLz();
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hMA = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wQ(int i) {
        if (i == 1) {
            this.hMs.setImageResource(e.f.icon_video_music);
        } else {
            this.hMs.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
