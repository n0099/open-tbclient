package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hlh;
    private ImageView hli;
    private ImageView hlj;
    private ImageView hlk;
    private LinearLayout hll;
    private LinearLayout hlm;
    private LinearLayout hln;
    private LinearLayout hlo;
    private a hlp;
    private View hlq;

    /* loaded from: classes2.dex */
    public interface a {
        void bCZ();

        void bDa();

        void bDb();

        void bDc();
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
        this.hll = (LinearLayout) findViewById(d.g.layout_music);
        this.hlm = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hln = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hlo = (LinearLayout) findViewById(d.g.layout_filter);
        this.hlh = (ImageView) findViewById(d.g.img_music);
        this.hli = (ImageView) findViewById(d.g.img_sticker);
        this.hlj = (ImageView) findViewById(d.g.img_beauty);
        this.hlk = (ImageView) findViewById(d.g.img_filter);
        this.hlh.setOnClickListener(this);
        this.hli.setOnClickListener(this);
        this.hlj.setOnClickListener(this);
        this.hlk.setOnClickListener(this);
    }

    public void reset() {
        this.hlq = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hll.setVisibility(i2);
                return;
            case 1:
                this.hlm.setVisibility(i2);
                return;
            case 2:
                this.hln.setVisibility(i2);
                return;
            case 3:
                this.hlo.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hlh.setSelected(z);
                return;
            case 1:
                this.hli.setSelected(z);
                return;
            case 2:
                this.hlj.setSelected(z);
                return;
            case 3:
                this.hlk.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hlp != null) {
            int id = view.getId();
            this.hlq = view;
            an anVar = new an("c12495");
            if (id == d.g.img_music) {
                this.hlp.bCZ();
                anVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hlp.bDa();
                anVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hlp.bDb();
                anVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hlp.bDc();
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.hlp = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uQ(int i) {
        if (i == 1) {
            this.hlh.setImageResource(d.f.icon_video_music);
        } else {
            this.hlh.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
