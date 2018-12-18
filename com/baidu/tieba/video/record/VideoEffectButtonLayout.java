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
    private ImageView hJh;
    private ImageView hJi;
    private ImageView hJj;
    private ImageView hJk;
    private LinearLayout hJl;
    private LinearLayout hJm;
    private LinearLayout hJn;
    private LinearLayout hJo;
    private a hJp;
    private View hJq;

    /* loaded from: classes5.dex */
    public interface a {
        void bKG();

        void bKH();

        void bKI();

        void bKJ();
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
        this.hJl = (LinearLayout) findViewById(e.g.layout_music);
        this.hJm = (LinearLayout) findViewById(e.g.layout_sticker);
        this.hJn = (LinearLayout) findViewById(e.g.layout_beauty);
        this.hJo = (LinearLayout) findViewById(e.g.layout_filter);
        this.hJh = (ImageView) findViewById(e.g.img_music);
        this.hJi = (ImageView) findViewById(e.g.img_sticker);
        this.hJj = (ImageView) findViewById(e.g.img_beauty);
        this.hJk = (ImageView) findViewById(e.g.img_filter);
        this.hJh.setOnClickListener(this);
        this.hJi.setOnClickListener(this);
        this.hJj.setOnClickListener(this);
        this.hJk.setOnClickListener(this);
    }

    public void reset() {
        this.hJq = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hJl.setVisibility(i2);
                return;
            case 1:
                this.hJm.setVisibility(i2);
                return;
            case 2:
                this.hJn.setVisibility(i2);
                return;
            case 3:
                this.hJo.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hJh.setSelected(z);
                return;
            case 1:
                this.hJi.setSelected(z);
                return;
            case 2:
                this.hJj.setSelected(z);
                return;
            case 3:
                this.hJk.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hJp != null) {
            int id = view.getId();
            this.hJq = view;
            am amVar = new am("c12495");
            if (id == e.g.img_music) {
                this.hJp.bKG();
                amVar.x("obj_type", 6);
            } else if (id == e.g.img_sticker) {
                this.hJp.bKH();
                amVar.x("obj_type", 4);
            } else if (id == e.g.img_beauty) {
                this.hJp.bKI();
                amVar.x("obj_type", 3);
            } else if (id == e.g.img_filter) {
                this.hJp.bKJ();
                amVar.x("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hJp = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void wD(int i) {
        if (i == 1) {
            this.hJh.setImageResource(e.f.icon_video_music);
        } else {
            this.hJh.setImageResource(e.f.icon_video_music_disable);
        }
    }
}
