package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hli;
    private ImageView hlj;
    private ImageView hlk;
    private ImageView hll;
    private LinearLayout hlm;
    private LinearLayout hln;
    private LinearLayout hlo;
    private LinearLayout hlp;
    private a hlq;
    private View hlr;

    /* loaded from: classes2.dex */
    public interface a {
        void bDb();

        void bDc();

        void bDd();

        void bDe();
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
        inflate(getContext(), f.h.layout_video_effect_button, this);
        this.hlm = (LinearLayout) findViewById(f.g.layout_music);
        this.hln = (LinearLayout) findViewById(f.g.layout_sticker);
        this.hlo = (LinearLayout) findViewById(f.g.layout_beauty);
        this.hlp = (LinearLayout) findViewById(f.g.layout_filter);
        this.hli = (ImageView) findViewById(f.g.img_music);
        this.hlj = (ImageView) findViewById(f.g.img_sticker);
        this.hlk = (ImageView) findViewById(f.g.img_beauty);
        this.hll = (ImageView) findViewById(f.g.img_filter);
        this.hli.setOnClickListener(this);
        this.hlj.setOnClickListener(this);
        this.hlk.setOnClickListener(this);
        this.hll.setOnClickListener(this);
    }

    public void reset() {
        this.hlr = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hlm.setVisibility(i2);
                return;
            case 1:
                this.hln.setVisibility(i2);
                return;
            case 2:
                this.hlo.setVisibility(i2);
                return;
            case 3:
                this.hlp.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hli.setSelected(z);
                return;
            case 1:
                this.hlj.setSelected(z);
                return;
            case 2:
                this.hlk.setSelected(z);
                return;
            case 3:
                this.hll.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hlq != null) {
            int id = view.getId();
            this.hlr = view;
            an anVar = new an("c12495");
            if (id == f.g.img_music) {
                this.hlq.bDb();
                anVar.r("obj_type", 6);
            } else if (id == f.g.img_sticker) {
                this.hlq.bDc();
                anVar.r("obj_type", 4);
            } else if (id == f.g.img_beauty) {
                this.hlq.bDd();
                anVar.r("obj_type", 3);
            } else if (id == f.g.img_filter) {
                this.hlq.bDe();
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.hlq = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uQ(int i) {
        if (i == 1) {
            this.hli.setImageResource(f.C0146f.icon_video_music);
        } else {
            this.hli.setImageResource(f.C0146f.icon_video_music_disable);
        }
    }
}
