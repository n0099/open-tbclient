package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes8.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nND;
    private ImageView nNE;
    private ImageView nNF;
    private ImageView nNG;
    private LinearLayout nNH;
    private LinearLayout nNI;
    private LinearLayout nNJ;
    private LinearLayout nNK;
    private a nNL;
    private View nNM;

    /* loaded from: classes8.dex */
    public interface a {
        void dWa();

        void dWb();

        void dWc();

        void dWd();
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
        inflate(getContext(), R.layout.layout_video_effect_button, this);
        this.nNH = (LinearLayout) findViewById(R.id.layout_music);
        this.nNI = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nNJ = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nNK = (LinearLayout) findViewById(R.id.layout_filter);
        this.nND = (ImageView) findViewById(R.id.img_music);
        this.nNE = (ImageView) findViewById(R.id.img_sticker);
        this.nNF = (ImageView) findViewById(R.id.img_beauty);
        this.nNG = (ImageView) findViewById(R.id.img_filter);
        this.nND.setOnClickListener(this);
        this.nNE.setOnClickListener(this);
        this.nNF.setOnClickListener(this);
        this.nNG.setOnClickListener(this);
    }

    public void reset() {
        this.nNM = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nNH.setVisibility(i2);
                return;
            case 1:
                this.nNI.setVisibility(i2);
                return;
            case 2:
                this.nNJ.setVisibility(i2);
                return;
            case 3:
                this.nNK.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nND.setSelected(z);
                return;
            case 1:
                this.nNE.setSelected(z);
                return;
            case 2:
                this.nNF.setSelected(z);
                return;
            case 3:
                this.nNG.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nNL != null) {
            int id = view.getId();
            this.nNM = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.nNL.dWa();
                aqVar.an("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nNL.dWb();
                aqVar.an("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nNL.dWc();
                aqVar.an("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nNL.dWd();
                aqVar.an("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.nNL = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void LZ(int i) {
        if (i == 1) {
            this.nND.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nND.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
