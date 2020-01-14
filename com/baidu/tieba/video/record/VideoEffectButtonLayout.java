package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes8.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView kCK;
    private ImageView kCL;
    private ImageView kCM;
    private ImageView kCN;
    private LinearLayout kCO;
    private LinearLayout kCP;
    private LinearLayout kCQ;
    private LinearLayout kCR;
    private a kCS;
    private View kCT;

    /* loaded from: classes8.dex */
    public interface a {
        void cQr();

        void cQs();

        void cQt();

        void cQu();
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
        this.kCO = (LinearLayout) findViewById(R.id.layout_music);
        this.kCP = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kCQ = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kCR = (LinearLayout) findViewById(R.id.layout_filter);
        this.kCK = (ImageView) findViewById(R.id.img_music);
        this.kCL = (ImageView) findViewById(R.id.img_sticker);
        this.kCM = (ImageView) findViewById(R.id.img_beauty);
        this.kCN = (ImageView) findViewById(R.id.img_filter);
        this.kCK.setOnClickListener(this);
        this.kCL.setOnClickListener(this);
        this.kCM.setOnClickListener(this);
        this.kCN.setOnClickListener(this);
    }

    public void reset() {
        this.kCT = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kCO.setVisibility(i2);
                return;
            case 1:
                this.kCP.setVisibility(i2);
                return;
            case 2:
                this.kCQ.setVisibility(i2);
                return;
            case 3:
                this.kCR.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kCK.setSelected(z);
                return;
            case 1:
                this.kCL.setSelected(z);
                return;
            case 2:
                this.kCM.setSelected(z);
                return;
            case 3:
                this.kCN.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kCS != null) {
            int id = view.getId();
            this.kCT = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kCS.cQr();
                anVar.Z("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kCS.cQs();
                anVar.Z("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kCS.cQt();
                anVar.Z("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kCS.cQu();
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kCS = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DC(int i) {
        if (i == 1) {
            this.kCK.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kCK.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
