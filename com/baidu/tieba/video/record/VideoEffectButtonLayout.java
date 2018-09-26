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
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hsX;
    private ImageView hsY;
    private ImageView hsZ;
    private ImageView hta;
    private LinearLayout htb;
    private LinearLayout htc;
    private LinearLayout htd;
    private LinearLayout hte;
    private a htf;
    private View htg;

    /* loaded from: classes2.dex */
    public interface a {
        void bFQ();

        void bFR();

        void bFS();

        void bFT();
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
        this.htb = (LinearLayout) findViewById(e.g.layout_music);
        this.htc = (LinearLayout) findViewById(e.g.layout_sticker);
        this.htd = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hte = (LinearLayout) findViewById(e.g.layout_filter);
        this.hsX = (ImageView) findViewById(e.g.img_music);
        this.hsY = (ImageView) findViewById(e.g.img_sticker);
        this.hsZ = (ImageView) findViewById(e.g.img_beauty);
        this.hta = (ImageView) findViewById(e.g.img_filter);
        this.hsX.setOnClickListener(this);
        this.hsY.setOnClickListener(this);
        this.hsZ.setOnClickListener(this);
        this.hta.setOnClickListener(this);
    }

    public void reset() {
        this.htg = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.htb.setVisibility(i2);
                return;
            case 1:
                this.htc.setVisibility(i2);
                return;
            case 2:
                this.htd.setVisibility(i2);
                return;
            case 3:
                this.hte.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hsX.setSelected(z);
                return;
            case 1:
                this.hsY.setSelected(z);
                return;
            case 2:
                this.hsZ.setSelected(z);
                return;
            case 3:
                this.hta.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.htf != null) {
            int id = view.getId();
            this.htg = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.htf.bFQ();
                amVar.w("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.htf.bFR();
                amVar.w("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.htf.bFS();
                amVar.w("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.htf.bFT();
                amVar.w("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.htf = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void vq(int i) {
        if (i == 1) {
            this.hsX.setImageResource(e.f.icon_video_music);
        } else {
            this.hsX.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
