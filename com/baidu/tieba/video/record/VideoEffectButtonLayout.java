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
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hAk;
    private ImageView hAl;
    private ImageView hAm;
    private ImageView hAn;
    private LinearLayout hAo;
    private LinearLayout hAp;
    private LinearLayout hAq;
    private LinearLayout hAr;
    private a hAs;
    private View hAt;

    /* loaded from: classes5.dex */
    public interface a {
        void bJd();

        void bJe();

        void bJf();

        void bJg();
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
        this.hAo = (LinearLayout) findViewById(e.g.layout_music);
        this.hAp = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hAq = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hAr = (LinearLayout) findViewById(e.g.layout_filter);
        this.hAk = (ImageView) findViewById(e.g.img_music);
        this.hAl = (ImageView) findViewById(e.g.img_sticker);
        this.hAm = (ImageView) findViewById(e.g.img_beauty);
        this.hAn = (ImageView) findViewById(e.g.img_filter);
        this.hAk.setOnClickListener(this);
        this.hAl.setOnClickListener(this);
        this.hAm.setOnClickListener(this);
        this.hAn.setOnClickListener(this);
    }

    public void reset() {
        this.hAt = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hAo.setVisibility(i2);
                return;
            case 1:
                this.hAp.setVisibility(i2);
                return;
            case 2:
                this.hAq.setVisibility(i2);
                return;
            case 3:
                this.hAr.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hAk.setSelected(z);
                return;
            case 1:
                this.hAl.setSelected(z);
                return;
            case 2:
                this.hAm.setSelected(z);
                return;
            case 3:
                this.hAn.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hAs != null) {
            int id = view.getId();
            this.hAt = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hAs.bJd();
                amVar.x("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hAs.bJe();
                amVar.x("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hAs.bJf();
                amVar.x("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hAs.bJg();
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hAs = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void vN(int i) {
        if (i == 1) {
            this.hAk.setImageResource(e.f.icon_video_music);
        } else {
            this.hAk.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
