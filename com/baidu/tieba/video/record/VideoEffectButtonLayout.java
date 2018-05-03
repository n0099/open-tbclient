package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView gTh;
    private ImageView gTi;
    private ImageView gTj;
    private ImageView gTk;
    private LinearLayout gTl;
    private LinearLayout gTm;
    private LinearLayout gTn;
    private LinearLayout gTo;
    private a gTp;
    private View gTq;

    /* loaded from: classes2.dex */
    public interface a {
        void byL();

        void byM();

        void byN();

        void byO();
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
        this.gTl = (LinearLayout) findViewById(d.g.layout_music);
        this.gTm = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gTn = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gTo = (LinearLayout) findViewById(d.g.layout_filter);
        this.gTh = (ImageView) findViewById(d.g.img_music);
        this.gTi = (ImageView) findViewById(d.g.img_sticker);
        this.gTj = (ImageView) findViewById(d.g.img_beauty);
        this.gTk = (ImageView) findViewById(d.g.img_filter);
        this.gTh.setOnClickListener(this);
        this.gTi.setOnClickListener(this);
        this.gTj.setOnClickListener(this);
        this.gTk.setOnClickListener(this);
    }

    public void reset() {
        this.gTq = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gTl.setVisibility(i2);
                return;
            case 1:
                this.gTm.setVisibility(i2);
                return;
            case 2:
                this.gTn.setVisibility(i2);
                return;
            case 3:
                this.gTo.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.gTh.setSelected(z);
                return;
            case 1:
                this.gTi.setSelected(z);
                return;
            case 2:
                this.gTj.setSelected(z);
                return;
            case 3:
                this.gTk.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.gTp != null) {
            int id = view2.getId();
            this.gTq = view2;
            al alVar = new al("c12495");
            if (id == d.g.img_music) {
                this.gTp.byL();
                alVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gTp.byM();
                alVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gTp.byN();
                alVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gTp.byO();
                alVar.r("obj_type", 2);
            }
            TiebaStatic.log(alVar);
        }
    }

    public void setListener(a aVar) {
        this.gTp = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void ux(int i) {
        if (i == 1) {
            this.gTh.setImageResource(d.f.icon_video_music);
        } else {
            this.gTh.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
