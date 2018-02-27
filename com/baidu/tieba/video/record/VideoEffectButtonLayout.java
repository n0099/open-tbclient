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
    private ImageView hxE;
    private ImageView hxF;
    private ImageView hxG;
    private ImageView hxH;
    private LinearLayout hxI;
    private LinearLayout hxJ;
    private LinearLayout hxK;
    private LinearLayout hxL;
    private a hxM;
    private View hxN;

    /* loaded from: classes2.dex */
    public interface a {
        void bDM();

        void bDN();

        void bDO();

        void bDP();
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
        this.hxI = (LinearLayout) findViewById(d.g.layout_music);
        this.hxJ = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hxK = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hxL = (LinearLayout) findViewById(d.g.layout_filter);
        this.hxE = (ImageView) findViewById(d.g.img_music);
        this.hxF = (ImageView) findViewById(d.g.img_sticker);
        this.hxG = (ImageView) findViewById(d.g.img_beauty);
        this.hxH = (ImageView) findViewById(d.g.img_filter);
        this.hxE.setOnClickListener(this);
        this.hxF.setOnClickListener(this);
        this.hxG.setOnClickListener(this);
        this.hxH.setOnClickListener(this);
    }

    public void reset() {
        this.hxN = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hxI.setVisibility(i2);
                return;
            case 1:
                this.hxJ.setVisibility(i2);
                return;
            case 2:
                this.hxK.setVisibility(i2);
                return;
            case 3:
                this.hxL.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void W(int i, boolean z) {
        switch (i) {
            case 0:
                this.hxE.setSelected(z);
                return;
            case 1:
                this.hxF.setSelected(z);
                return;
            case 2:
                this.hxG.setSelected(z);
                return;
            case 3:
                this.hxH.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hxM != null) {
            int id = view.getId();
            this.hxN = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hxM.bDM();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hxM.bDN();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hxM.bDO();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hxM.bDP();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hxM = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
        if (i == 1) {
            this.hxE.setImageResource(d.f.icon_video_music);
        } else {
            this.hxE.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
