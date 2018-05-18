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
    private ImageView gUl;
    private ImageView gUm;
    private ImageView gUn;
    private ImageView gUo;
    private LinearLayout gUp;
    private LinearLayout gUq;
    private LinearLayout gUr;
    private LinearLayout gUs;
    private a gUt;
    private View gUu;

    /* loaded from: classes2.dex */
    public interface a {
        void byJ();

        void byK();

        void byL();

        void byM();
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
        this.gUp = (LinearLayout) findViewById(d.g.layout_music);
        this.gUq = (LinearLayout) findViewById(d.g.layout_sticker);
        this.gUr = (LinearLayout) findViewById(d.g.layout_beauty);
        this.gUs = (LinearLayout) findViewById(d.g.layout_filter);
        this.gUl = (ImageView) findViewById(d.g.img_music);
        this.gUm = (ImageView) findViewById(d.g.img_sticker);
        this.gUn = (ImageView) findViewById(d.g.img_beauty);
        this.gUo = (ImageView) findViewById(d.g.img_filter);
        this.gUl.setOnClickListener(this);
        this.gUm.setOnClickListener(this);
        this.gUn.setOnClickListener(this);
        this.gUo.setOnClickListener(this);
    }

    public void reset() {
        this.gUu = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.gUp.setVisibility(i2);
                return;
            case 1:
                this.gUq.setVisibility(i2);
                return;
            case 2:
                this.gUr.setVisibility(i2);
                return;
            case 3:
                this.gUs.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.gUl.setSelected(z);
                return;
            case 1:
                this.gUm.setSelected(z);
                return;
            case 2:
                this.gUn.setSelected(z);
                return;
            case 3:
                this.gUo.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.gUt != null) {
            int id = view2.getId();
            this.gUu = view2;
            al alVar = new al("c12495");
            if (id == d.g.img_music) {
                this.gUt.byJ();
                alVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gUt.byK();
                alVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gUt.byL();
                alVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gUt.byM();
                alVar.r("obj_type", 2);
            }
            TiebaStatic.log(alVar);
        }
    }

    public void setListener(a aVar) {
        this.gUt = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uw(int i) {
        if (i == 1) {
            this.gUl.setImageResource(d.f.icon_video_music);
        } else {
            this.gUl.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
