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
/* loaded from: classes10.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView kDT;
    private ImageView kDU;
    private ImageView kDV;
    private ImageView kDW;
    private LinearLayout kDX;
    private LinearLayout kDY;
    private LinearLayout kDZ;
    private LinearLayout kEa;
    private a kEb;
    private View kEc;

    /* loaded from: classes10.dex */
    public interface a {
        void cRN();

        void cRO();

        void cRP();

        void cRQ();
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
        this.kDX = (LinearLayout) findViewById(R.id.layout_music);
        this.kDY = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kDZ = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kEa = (LinearLayout) findViewById(R.id.layout_filter);
        this.kDT = (ImageView) findViewById(R.id.img_music);
        this.kDU = (ImageView) findViewById(R.id.img_sticker);
        this.kDV = (ImageView) findViewById(R.id.img_beauty);
        this.kDW = (ImageView) findViewById(R.id.img_filter);
        this.kDT.setOnClickListener(this);
        this.kDU.setOnClickListener(this);
        this.kDV.setOnClickListener(this);
        this.kDW.setOnClickListener(this);
    }

    public void reset() {
        this.kEc = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kDX.setVisibility(i2);
                return;
            case 1:
                this.kDY.setVisibility(i2);
                return;
            case 2:
                this.kDZ.setVisibility(i2);
                return;
            case 3:
                this.kEa.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kDT.setSelected(z);
                return;
            case 1:
                this.kDU.setSelected(z);
                return;
            case 2:
                this.kDV.setSelected(z);
                return;
            case 3:
                this.kDW.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kEb != null) {
            int id = view.getId();
            this.kEc = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kEb.cRN();
                anVar.X("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kEb.cRO();
                anVar.X("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kEb.cRP();
                anVar.X("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kEb.cRQ();
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kEb = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DI(int i) {
        if (i == 1) {
            this.kDT.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kDT.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
