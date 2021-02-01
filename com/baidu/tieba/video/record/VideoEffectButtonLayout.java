package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes8.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nSF;
    private ImageView nSG;
    private ImageView nSH;
    private ImageView nSI;
    private LinearLayout nSJ;
    private LinearLayout nSK;
    private LinearLayout nSL;
    private LinearLayout nSM;
    private a nSN;
    private View nSO;

    /* loaded from: classes8.dex */
    public interface a {
        void dUu();

        void dUv();

        void dUw();

        void dUx();
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
        this.nSJ = (LinearLayout) findViewById(R.id.layout_music);
        this.nSK = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nSL = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nSM = (LinearLayout) findViewById(R.id.layout_filter);
        this.nSF = (ImageView) findViewById(R.id.img_music);
        this.nSG = (ImageView) findViewById(R.id.img_sticker);
        this.nSH = (ImageView) findViewById(R.id.img_beauty);
        this.nSI = (ImageView) findViewById(R.id.img_filter);
        this.nSF.setOnClickListener(this);
        this.nSG.setOnClickListener(this);
        this.nSH.setOnClickListener(this);
        this.nSI.setOnClickListener(this);
    }

    public void reset() {
        this.nSO = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nSJ.setVisibility(i2);
                return;
            case 1:
                this.nSK.setVisibility(i2);
                return;
            case 2:
                this.nSL.setVisibility(i2);
                return;
            case 3:
                this.nSM.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nSF.setSelected(z);
                return;
            case 1:
                this.nSG.setSelected(z);
                return;
            case 2:
                this.nSH.setSelected(z);
                return;
            case 3:
                this.nSI.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nSN != null) {
            int id = view.getId();
            this.nSO = view;
            ar arVar = new ar("c12495");
            if (id == R.id.img_music) {
                this.nSN.dUu();
                arVar.ap("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nSN.dUv();
                arVar.ap("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nSN.dUw();
                arVar.ap("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nSN.dUx();
                arVar.ap("obj_type", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    public void setListener(a aVar) {
        this.nSN = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KM(int i) {
        if (i == 1) {
            this.nSF.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nSF.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
