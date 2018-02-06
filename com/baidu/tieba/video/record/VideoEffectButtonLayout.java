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
    private ImageView hxR;
    private ImageView hxS;
    private ImageView hxT;
    private ImageView hxU;
    private LinearLayout hxV;
    private LinearLayout hxW;
    private LinearLayout hxX;
    private LinearLayout hxY;
    private a hxZ;
    private View hya;

    /* loaded from: classes2.dex */
    public interface a {
        void bDN();

        void bDO();

        void bDP();

        void bDQ();
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
        this.hxV = (LinearLayout) findViewById(d.g.layout_music);
        this.hxW = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hxX = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hxY = (LinearLayout) findViewById(d.g.layout_filter);
        this.hxR = (ImageView) findViewById(d.g.img_music);
        this.hxS = (ImageView) findViewById(d.g.img_sticker);
        this.hxT = (ImageView) findViewById(d.g.img_beauty);
        this.hxU = (ImageView) findViewById(d.g.img_filter);
        this.hxR.setOnClickListener(this);
        this.hxS.setOnClickListener(this);
        this.hxT.setOnClickListener(this);
        this.hxU.setOnClickListener(this);
    }

    public void reset() {
        this.hya = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hxV.setVisibility(i2);
                return;
            case 1:
                this.hxW.setVisibility(i2);
                return;
            case 2:
                this.hxX.setVisibility(i2);
                return;
            case 3:
                this.hxY.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void W(int i, boolean z) {
        switch (i) {
            case 0:
                this.hxR.setSelected(z);
                return;
            case 1:
                this.hxS.setSelected(z);
                return;
            case 2:
                this.hxT.setSelected(z);
                return;
            case 3:
                this.hxU.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hxZ != null) {
            int id = view.getId();
            this.hya = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hxZ.bDN();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hxZ.bDO();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hxZ.bDP();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hxZ.bDQ();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hxZ = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wU(int i) {
        if (i == 1) {
            this.hxR.setImageResource(d.f.icon_video_music);
        } else {
            this.hxR.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
