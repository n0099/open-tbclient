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
    private ImageView gWL;
    private ImageView gWM;
    private ImageView gWN;
    private ImageView gWO;
    private LinearLayout gWP;
    private LinearLayout gWQ;
    private LinearLayout gWR;
    private LinearLayout gWS;
    private a gWT;
    private View gWU;

    /* loaded from: classes2.dex */
    public interface a {
        void bDA();

        void bDx();

        void bDy();

        void bDz();
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
        this.gWP = (LinearLayout) findViewById(d.g.layout_music);
        this.gWQ = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gWR = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gWS = (LinearLayout) findViewById(d.g.layout_filter);
        this.gWL = (ImageView) findViewById(d.g.img_music);
        this.gWM = (ImageView) findViewById(d.g.img_sticker);
        this.gWN = (ImageView) findViewById(d.g.img_beauty);
        this.gWO = (ImageView) findViewById(d.g.img_filter);
        this.gWL.setOnClickListener(this);
        this.gWM.setOnClickListener(this);
        this.gWN.setOnClickListener(this);
        this.gWO.setOnClickListener(this);
    }

    public void reset() {
        this.gWU = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gWP.setVisibility(i2);
                return;
            case 1:
                this.gWQ.setVisibility(i2);
                return;
            case 2:
                this.gWR.setVisibility(i2);
                return;
            case 3:
                this.gWS.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void F(int i, boolean z) {
        switch (i) {
            case 0:
                this.gWL.setSelected(z);
                return;
            case 1:
                this.gWM.setSelected(z);
                return;
            case 2:
                this.gWN.setSelected(z);
                return;
            case 3:
                this.gWO.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gWT != null) {
            int id = view.getId();
            this.gWU = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.gWT.bDx();
                akVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gWT.bDy();
                akVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gWT.bDz();
                akVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gWT.bDA();
                akVar.r("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.gWT = aVar;
    }

    @Override // com.baidu.tieba.video.record.j.a
    public void vs(int i) {
        if (i == 1) {
            this.gWL.setImageResource(d.f.icon_video_music);
        } else {
            this.gWL.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
