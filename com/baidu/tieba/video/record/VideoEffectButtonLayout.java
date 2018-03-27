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
    private ImageView hyc;
    private ImageView hyd;
    private ImageView hye;
    private ImageView hyf;
    private LinearLayout hyg;
    private LinearLayout hyh;
    private LinearLayout hyi;
    private LinearLayout hyj;
    private a hyk;
    private View hyl;

    /* loaded from: classes2.dex */
    public interface a {
        void bDR();

        void bDS();

        void bDT();

        void bDU();
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
        this.hyg = (LinearLayout) findViewById(d.g.layout_music);
        this.hyh = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hyi = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hyj = (LinearLayout) findViewById(d.g.layout_filter);
        this.hyc = (ImageView) findViewById(d.g.img_music);
        this.hyd = (ImageView) findViewById(d.g.img_sticker);
        this.hye = (ImageView) findViewById(d.g.img_beauty);
        this.hyf = (ImageView) findViewById(d.g.img_filter);
        this.hyc.setOnClickListener(this);
        this.hyd.setOnClickListener(this);
        this.hye.setOnClickListener(this);
        this.hyf.setOnClickListener(this);
    }

    public void reset() {
        this.hyl = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hyg.setVisibility(i2);
                return;
            case 1:
                this.hyh.setVisibility(i2);
                return;
            case 2:
                this.hyi.setVisibility(i2);
                return;
            case 3:
                this.hyj.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void W(int i, boolean z) {
        switch (i) {
            case 0:
                this.hyc.setSelected(z);
                return;
            case 1:
                this.hyd.setSelected(z);
                return;
            case 2:
                this.hye.setSelected(z);
                return;
            case 3:
                this.hyf.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hyk != null) {
            int id = view.getId();
            this.hyl = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hyk.bDR();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hyk.bDS();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hyk.bDT();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hyk.bDU();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hyk = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
        if (i == 1) {
            this.hyc.setImageResource(d.f.icon_video_music);
        } else {
            this.hyc.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
