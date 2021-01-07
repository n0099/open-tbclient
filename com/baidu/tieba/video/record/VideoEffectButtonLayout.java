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
    private ImageView nNC;
    private ImageView nND;
    private ImageView nNE;
    private ImageView nNF;
    private LinearLayout nNG;
    private LinearLayout nNH;
    private LinearLayout nNI;
    private LinearLayout nNJ;
    private a nNK;
    private View nNL;

    /* loaded from: classes8.dex */
    public interface a {
        void dWb();

        void dWc();

        void dWd();

        void dWe();
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
        this.nNG = (LinearLayout) findViewById(R.id.layout_music);
        this.nNH = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nNI = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nNJ = (LinearLayout) findViewById(R.id.layout_filter);
        this.nNC = (ImageView) findViewById(R.id.img_music);
        this.nND = (ImageView) findViewById(R.id.img_sticker);
        this.nNE = (ImageView) findViewById(R.id.img_beauty);
        this.nNF = (ImageView) findViewById(R.id.img_filter);
        this.nNC.setOnClickListener(this);
        this.nND.setOnClickListener(this);
        this.nNE.setOnClickListener(this);
        this.nNF.setOnClickListener(this);
    }

    public void reset() {
        this.nNL = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nNG.setVisibility(i2);
                return;
            case 1:
                this.nNH.setVisibility(i2);
                return;
            case 2:
                this.nNI.setVisibility(i2);
                return;
            case 3:
                this.nNJ.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nNC.setSelected(z);
                return;
            case 1:
                this.nND.setSelected(z);
                return;
            case 2:
                this.nNE.setSelected(z);
                return;
            case 3:
                this.nNF.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nNK != null) {
            int id = view.getId();
            this.nNL = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.nNK.dWb();
                aqVar.an("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nNK.dWc();
                aqVar.an("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nNK.dWd();
                aqVar.an("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nNK.dWe();
                aqVar.an("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.nNK = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void LZ(int i) {
        if (i == 1) {
            this.nNC.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nNC.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
