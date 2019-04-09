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
    private ImageView jdL;
    private ImageView jdM;
    private ImageView jdN;
    private ImageView jdO;
    private LinearLayout jdP;
    private LinearLayout jdQ;
    private LinearLayout jdR;
    private LinearLayout jdS;
    private a jdT;
    private View jdU;

    /* loaded from: classes5.dex */
    public interface a {
        void clE();

        void clF();

        void clG();

        void clH();
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
        this.jdP = (LinearLayout) findViewById(d.g.layout_music);
        this.jdQ = (LinearLayout) findViewById(d.g.layout_sticker);
        this.jdR = (LinearLayout) findViewById(d.g.layout_beauty);
        this.jdS = (LinearLayout) findViewById(d.g.layout_filter);
        this.jdL = (ImageView) findViewById(d.g.img_music);
        this.jdM = (ImageView) findViewById(d.g.img_sticker);
        this.jdN = (ImageView) findViewById(d.g.img_beauty);
        this.jdO = (ImageView) findViewById(d.g.img_filter);
        this.jdL.setOnClickListener(this);
        this.jdM.setOnClickListener(this);
        this.jdN.setOnClickListener(this);
        this.jdO.setOnClickListener(this);
    }

    public void reset() {
        this.jdU = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jdP.setVisibility(i2);
                return;
            case 1:
                this.jdQ.setVisibility(i2);
                return;
            case 2:
                this.jdR.setVisibility(i2);
                return;
            case 3:
                this.jdS.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jdL.setSelected(z);
                return;
            case 1:
                this.jdM.setSelected(z);
                return;
            case 2:
                this.jdN.setSelected(z);
                return;
            case 3:
                this.jdO.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jdT != null) {
            int id = view.getId();
            this.jdU = view;
            am amVar = new am("c12495");
            if (id == d.g.img_music) {
                this.jdT.clE();
                amVar.T("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.jdT.clF();
                amVar.T("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.jdT.clG();
                amVar.T("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.jdT.clH();
                amVar.T("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.jdT = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void AB(int i) {
        if (i == 1) {
            this.jdL.setImageResource(d.f.icon_video_music);
        } else {
            this.jdL.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
