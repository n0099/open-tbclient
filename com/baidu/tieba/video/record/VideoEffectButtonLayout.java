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
    private ImageView hGG;
    private ImageView hGH;
    private ImageView hGI;
    private ImageView hGJ;
    private LinearLayout hGK;
    private LinearLayout hGL;
    private LinearLayout hGM;
    private LinearLayout hGN;
    private a hGO;
    private View hGP;

    /* loaded from: classes2.dex */
    public interface a {
        void bJG();

        void bJH();

        void bJI();

        void bJJ();
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
        this.hGK = (LinearLayout) findViewById(d.g.layout_music);
        this.hGL = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hGM = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hGN = (LinearLayout) findViewById(d.g.layout_filter);
        this.hGG = (ImageView) findViewById(d.g.img_music);
        this.hGH = (ImageView) findViewById(d.g.img_sticker);
        this.hGI = (ImageView) findViewById(d.g.img_beauty);
        this.hGJ = (ImageView) findViewById(d.g.img_filter);
        this.hGG.setOnClickListener(this);
        this.hGH.setOnClickListener(this);
        this.hGI.setOnClickListener(this);
        this.hGJ.setOnClickListener(this);
    }

    public void reset() {
        this.hGP = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hGK.setVisibility(i2);
                return;
            case 1:
                this.hGL.setVisibility(i2);
                return;
            case 2:
                this.hGM.setVisibility(i2);
                return;
            case 3:
                this.hGN.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void Q(int i, boolean z) {
        switch (i) {
            case 0:
                this.hGG.setSelected(z);
                return;
            case 1:
                this.hGH.setSelected(z);
                return;
            case 2:
                this.hGI.setSelected(z);
                return;
            case 3:
                this.hGJ.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGO != null) {
            int id = view.getId();
            this.hGP = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hGO.bJG();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hGO.bJH();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hGO.bJI();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hGO.bJJ();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hGO = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void yt(int i) {
        if (i == 1) {
            this.hGG.setImageResource(d.f.icon_video_music);
        } else {
            this.hGG.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
