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
    private ImageView gZC;
    private ImageView gZD;
    private ImageView gZE;
    private ImageView gZF;
    private LinearLayout gZG;
    private LinearLayout gZH;
    private LinearLayout gZI;
    private LinearLayout gZJ;
    private a gZK;
    private View gZL;

    /* loaded from: classes2.dex */
    public interface a {
        void bEg();

        void bEh();

        void bEi();

        void bEj();
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
        this.gZG = (LinearLayout) findViewById(d.g.layout_music);
        this.gZH = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gZI = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gZJ = (LinearLayout) findViewById(d.g.layout_filter);
        this.gZC = (ImageView) findViewById(d.g.img_music);
        this.gZD = (ImageView) findViewById(d.g.img_sticker);
        this.gZE = (ImageView) findViewById(d.g.img_beauty);
        this.gZF = (ImageView) findViewById(d.g.img_filter);
        this.gZC.setOnClickListener(this);
        this.gZD.setOnClickListener(this);
        this.gZE.setOnClickListener(this);
        this.gZF.setOnClickListener(this);
    }

    public void reset() {
        this.gZL = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gZG.setVisibility(i2);
                return;
            case 1:
                this.gZH.setVisibility(i2);
                return;
            case 2:
                this.gZI.setVisibility(i2);
                return;
            case 3:
                this.gZJ.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void F(int i, boolean z) {
        switch (i) {
            case 0:
                this.gZC.setSelected(z);
                return;
            case 1:
                this.gZD.setSelected(z);
                return;
            case 2:
                this.gZE.setSelected(z);
                return;
            case 3:
                this.gZF.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gZK != null) {
            int id = view.getId();
            this.gZL = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.gZK.bEg();
                akVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gZK.bEh();
                akVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gZK.bEi();
                akVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gZK.bEj();
                akVar.r("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.gZK = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vD(int i) {
        if (i == 1) {
            this.gZC.setImageResource(d.f.icon_video_music);
        } else {
            this.gZC.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
