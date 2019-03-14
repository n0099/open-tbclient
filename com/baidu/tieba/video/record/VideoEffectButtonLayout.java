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
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView jdW;
    private ImageView jdX;
    private ImageView jdY;
    private ImageView jdZ;
    private LinearLayout jea;
    private LinearLayout jeb;
    private LinearLayout jec;
    private LinearLayout jed;
    private a jee;
    private View jef;

    /* loaded from: classes5.dex */
    public interface a {
        void clG();

        void clH();

        void clI();

        void clJ();
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
        this.jea = (LinearLayout) findViewById(d.g.layout_music);
        this.jeb = (LinearLayout) findViewById(d.g.layout_sticker);
        this.jec = (LinearLayout) findViewById(d.g.layout_beauty);
        this.jed = (LinearLayout) findViewById(d.g.layout_filter);
        this.jdW = (ImageView) findViewById(d.g.img_music);
        this.jdX = (ImageView) findViewById(d.g.img_sticker);
        this.jdY = (ImageView) findViewById(d.g.img_beauty);
        this.jdZ = (ImageView) findViewById(d.g.img_filter);
        this.jdW.setOnClickListener(this);
        this.jdX.setOnClickListener(this);
        this.jdY.setOnClickListener(this);
        this.jdZ.setOnClickListener(this);
    }

    public void reset() {
        this.jef = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jea.setVisibility(i2);
                return;
            case 1:
                this.jeb.setVisibility(i2);
                return;
            case 2:
                this.jec.setVisibility(i2);
                return;
            case 3:
                this.jed.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jdW.setSelected(z);
                return;
            case 1:
                this.jdX.setSelected(z);
                return;
            case 2:
                this.jdY.setSelected(z);
                return;
            case 3:
                this.jdZ.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jee != null) {
            int id = view.getId();
            this.jef = view;
            am amVar = new am("c12495");
            if (id == d.g.img_music) {
                this.jee.clG();
                amVar.T("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.jee.clH();
                amVar.T("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.jee.clI();
                amVar.T("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.jee.clJ();
                amVar.T("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.jee = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void AF(int i) {
        if (i == 1) {
            this.jdW.setImageResource(d.f.icon_video_music);
        } else {
            this.jdW.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
