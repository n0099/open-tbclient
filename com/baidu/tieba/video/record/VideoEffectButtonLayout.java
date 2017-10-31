package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView gKO;
    private ImageView gKP;
    private ImageView gKQ;
    private ImageView gKR;
    private a gKS;
    private View gKT;

    /* loaded from: classes2.dex */
    public interface a {
        void bAH();

        void bAI();

        void bAJ();

        void bAK();
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
        this.gKO = (ImageView) findViewById(d.g.img_music);
        this.gKP = (ImageView) findViewById(d.g.img_sticker);
        this.gKQ = (ImageView) findViewById(d.g.img_beauty);
        this.gKR = (ImageView) findViewById(d.g.img_filter);
        this.gKO.setOnClickListener(this);
        this.gKP.setOnClickListener(this);
        this.gKQ.setOnClickListener(this);
        this.gKR.setOnClickListener(this);
    }

    public void reset() {
        this.gKT = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gKS != null) {
            int id = view.getId();
            this.gKT = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.gKS.bAH();
                akVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gKS.bAI();
                akVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gKS.bAJ();
                akVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gKS.bAK();
                akVar.r("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.gKS = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uV(int i) {
        if (i == 1) {
            this.gKO.setImageResource(d.f.icon_video_music);
        } else {
            this.gKO.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
