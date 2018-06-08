package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hfM;
    private ImageView hfN;
    private ImageView hfO;
    private ImageView hfP;
    private LinearLayout hfQ;
    private LinearLayout hfR;
    private LinearLayout hfS;
    private LinearLayout hfT;
    private a hfU;
    private View hfV;

    /* loaded from: classes2.dex */
    public interface a {
        void bDP();

        void bDQ();

        void bDR();

        void bDS();
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
        inflate(getContext(), d.i.layout_video_effect_button, this);
        this.hfQ = (LinearLayout) findViewById(d.g.layout_music);
        this.hfR = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hfS = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hfT = (LinearLayout) findViewById(d.g.layout_filter);
        this.hfM = (ImageView) findViewById(d.g.img_music);
        this.hfN = (ImageView) findViewById(d.g.img_sticker);
        this.hfO = (ImageView) findViewById(d.g.img_beauty);
        this.hfP = (ImageView) findViewById(d.g.img_filter);
        this.hfM.setOnClickListener(this);
        this.hfN.setOnClickListener(this);
        this.hfO.setOnClickListener(this);
        this.hfP.setOnClickListener(this);
    }

    public void reset() {
        this.hfV = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hfQ.setVisibility(i2);
                return;
            case 1:
                this.hfR.setVisibility(i2);
                return;
            case 2:
                this.hfS.setVisibility(i2);
                return;
            case 3:
                this.hfT.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hfM.setSelected(z);
                return;
            case 1:
                this.hfN.setSelected(z);
                return;
            case 2:
                this.hfO.setSelected(z);
                return;
            case 3:
                this.hfP.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hfU != null) {
            int id = view.getId();
            this.hfV = view;
            am amVar = new am("c12495");
            if (id == d.g.img_music) {
                this.hfU.bDP();
                amVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hfU.bDQ();
                amVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hfU.bDR();
                amVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hfU.bDS();
                amVar.r("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.hfU = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uJ(int i) {
        if (i == 1) {
            this.hfM.setImageResource(d.f.icon_video_music);
        } else {
            this.hfM.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
