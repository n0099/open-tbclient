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
    private ImageView gTk;
    private ImageView gTl;
    private ImageView gTm;
    private ImageView gTn;
    private LinearLayout gTo;
    private LinearLayout gTp;
    private LinearLayout gTq;
    private LinearLayout gTr;
    private a gTs;
    private View gTt;

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
        this.gTo = (LinearLayout) findViewById(d.g.layout_music);
        this.gTp = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gTq = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gTr = (LinearLayout) findViewById(d.g.layout_filter);
        this.gTk = (ImageView) findViewById(d.g.img_music);
        this.gTl = (ImageView) findViewById(d.g.img_sticker);
        this.gTm = (ImageView) findViewById(d.g.img_beauty);
        this.gTn = (ImageView) findViewById(d.g.img_filter);
        this.gTk.setOnClickListener(this);
        this.gTl.setOnClickListener(this);
        this.gTm.setOnClickListener(this);
        this.gTn.setOnClickListener(this);
    }

    public void reset() {
        this.gTt = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gTo.setVisibility(i2);
                return;
            case 1:
                this.gTp.setVisibility(i2);
                return;
            case 2:
                this.gTq.setVisibility(i2);
                return;
            case 3:
                this.gTr.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.gTk.setSelected(z);
                return;
            case 1:
                this.gTl.setSelected(z);
                return;
            case 2:
                this.gTm.setSelected(z);
                return;
            case 3:
                this.gTn.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.gTs != null) {
            int id = view2.getId();
            this.gTt = view2;
            al alVar = new al("c12495");
            if (id == d.g.img_music) {
                this.gTs.byL();
                alVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gTs.byM();
                alVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gTs.byN();
                alVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gTs.byO();
                alVar.r("obj_type", 2);
            }
            TiebaStatic.log(alVar);
        }
    }

    public void setListener(a aVar) {
        this.gTs = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uy(int i) {
        if (i == 1) {
            this.gTk.setImageResource(d.f.icon_video_music);
        } else {
            this.gTk.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
