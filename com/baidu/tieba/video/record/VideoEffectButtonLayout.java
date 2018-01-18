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
    private ImageView hwj;
    private ImageView hwk;
    private ImageView hwl;
    private ImageView hwm;
    private LinearLayout hwn;
    private LinearLayout hwo;
    private LinearLayout hwp;
    private LinearLayout hwq;
    private a hwr;
    private View hws;

    /* loaded from: classes2.dex */
    public interface a {
        void bDd();

        void bDe();

        void bDf();

        void bDg();
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
        this.hwn = (LinearLayout) findViewById(d.g.layout_music);
        this.hwo = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hwp = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hwq = (LinearLayout) findViewById(d.g.layout_filter);
        this.hwj = (ImageView) findViewById(d.g.img_music);
        this.hwk = (ImageView) findViewById(d.g.img_sticker);
        this.hwl = (ImageView) findViewById(d.g.img_beauty);
        this.hwm = (ImageView) findViewById(d.g.img_filter);
        this.hwj.setOnClickListener(this);
        this.hwk.setOnClickListener(this);
        this.hwl.setOnClickListener(this);
        this.hwm.setOnClickListener(this);
    }

    public void reset() {
        this.hws = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hwn.setVisibility(i2);
                return;
            case 1:
                this.hwo.setVisibility(i2);
                return;
            case 2:
                this.hwp.setVisibility(i2);
                return;
            case 3:
                this.hwq.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void Q(int i, boolean z) {
        switch (i) {
            case 0:
                this.hwj.setSelected(z);
                return;
            case 1:
                this.hwk.setSelected(z);
                return;
            case 2:
                this.hwl.setSelected(z);
                return;
            case 3:
                this.hwm.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hwr != null) {
            int id = view.getId();
            this.hws = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.hwr.bDd();
                akVar.s("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hwr.bDe();
                akVar.s("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hwr.bDf();
                akVar.s("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hwr.bDg();
                akVar.s("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.hwr = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void wV(int i) {
        if (i == 1) {
            this.hwj.setImageResource(d.f.icon_video_music);
        } else {
            this.hwj.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
