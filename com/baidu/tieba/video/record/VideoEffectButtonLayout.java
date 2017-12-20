package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.j;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, j.a {
    private ImageView gZA;
    private LinearLayout gZB;
    private LinearLayout gZC;
    private LinearLayout gZD;
    private LinearLayout gZE;
    private a gZF;
    private View gZG;
    private ImageView gZx;
    private ImageView gZy;
    private ImageView gZz;

    /* loaded from: classes2.dex */
    public interface a {
        void bEf();

        void bEg();

        void bEh();

        void bEi();
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
        inflate(getContext(), d.h.layout_video_effect_button, this);
        this.gZB = (LinearLayout) findViewById(d.g.layout_music);
        this.gZC = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gZD = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gZE = (LinearLayout) findViewById(d.g.layout_filter);
        this.gZx = (ImageView) findViewById(d.g.img_music);
        this.gZy = (ImageView) findViewById(d.g.img_sticker);
        this.gZz = (ImageView) findViewById(d.g.img_beauty);
        this.gZA = (ImageView) findViewById(d.g.img_filter);
        this.gZx.setOnClickListener(this);
        this.gZy.setOnClickListener(this);
        this.gZz.setOnClickListener(this);
        this.gZA.setOnClickListener(this);
    }

    public void reset() {
        this.gZG = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gZB.setVisibility(i2);
                return;
            case 1:
                this.gZC.setVisibility(i2);
                return;
            case 2:
                this.gZD.setVisibility(i2);
                return;
            case 3:
                this.gZE.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void F(int i, boolean z) {
        switch (i) {
            case 0:
                this.gZx.setSelected(z);
                return;
            case 1:
                this.gZy.setSelected(z);
                return;
            case 2:
                this.gZz.setSelected(z);
                return;
            case 3:
                this.gZA.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gZF != null) {
            int id = view.getId();
            this.gZG = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.gZF.bEf();
                akVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gZF.bEg();
                akVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gZF.bEh();
                akVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gZF.bEi();
                akVar.r("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.gZF = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vD(int i) {
        if (i == 1) {
            this.gZx.setImageResource(d.f.icon_video_music);
        } else {
            this.gZx.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
