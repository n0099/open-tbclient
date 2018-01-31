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
    private ImageView hwD;
    private ImageView hwE;
    private ImageView hwF;
    private ImageView hwG;
    private LinearLayout hwH;
    private LinearLayout hwI;
    private LinearLayout hwJ;
    private LinearLayout hwK;
    private a hwL;
    private View hwM;

    /* loaded from: classes2.dex */
    public interface a {
        void bDf();

        void bDg();

        void bDh();

        void bDi();
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
        this.hwH = (LinearLayout) findViewById(d.g.layout_music);
        this.hwI = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hwJ = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hwK = (LinearLayout) findViewById(d.g.layout_filter);
        this.hwD = (ImageView) findViewById(d.g.img_music);
        this.hwE = (ImageView) findViewById(d.g.img_sticker);
        this.hwF = (ImageView) findViewById(d.g.img_beauty);
        this.hwG = (ImageView) findViewById(d.g.img_filter);
        this.hwD.setOnClickListener(this);
        this.hwE.setOnClickListener(this);
        this.hwF.setOnClickListener(this);
        this.hwG.setOnClickListener(this);
    }

    public void reset() {
        this.hwM = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hwH.setVisibility(i2);
                return;
            case 1:
                this.hwI.setVisibility(i2);
                return;
            case 2:
                this.hwJ.setVisibility(i2);
                return;
            case 3:
                this.hwK.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void Q(int i, boolean z) {
        switch (i) {
            case 0:
                this.hwD.setSelected(z);
                return;
            case 1:
                this.hwE.setSelected(z);
                return;
            case 2:
                this.hwF.setSelected(z);
                return;
            case 3:
                this.hwG.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hwL != null) {
            int id = view.getId();
            this.hwM = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hwL.bDf();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hwL.bDg();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hwL.bDh();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hwL.bDi();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hwL = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
        if (i == 1) {
            this.hwD.setImageResource(d.f.icon_video_music);
        } else {
            this.hwD.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
