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
    private ImageView kDH;
    private ImageView kDI;
    private ImageView kDJ;
    private ImageView kDK;
    private LinearLayout kDL;
    private LinearLayout kDM;
    private LinearLayout kDN;
    private LinearLayout kDO;
    private a kDP;
    private View kDQ;

    /* loaded from: classes10.dex */
    public interface a {
        void cRM();

        void cRN();

        void cRO();

        void cRP();
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
        this.kDL = (LinearLayout) findViewById(R.id.layout_music);
        this.kDM = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kDN = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kDO = (LinearLayout) findViewById(R.id.layout_filter);
        this.kDH = (ImageView) findViewById(R.id.img_music);
        this.kDI = (ImageView) findViewById(R.id.img_sticker);
        this.kDJ = (ImageView) findViewById(R.id.img_beauty);
        this.kDK = (ImageView) findViewById(R.id.img_filter);
        this.kDH.setOnClickListener(this);
        this.kDI.setOnClickListener(this);
        this.kDJ.setOnClickListener(this);
        this.kDK.setOnClickListener(this);
    }

    public void reset() {
        this.kDQ = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kDL.setVisibility(i2);
                return;
            case 1:
                this.kDM.setVisibility(i2);
                return;
            case 2:
                this.kDN.setVisibility(i2);
                return;
            case 3:
                this.kDO.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kDH.setSelected(z);
                return;
            case 1:
                this.kDI.setSelected(z);
                return;
            case 2:
                this.kDJ.setSelected(z);
                return;
            case 3:
                this.kDK.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kDP != null) {
            int id = view.getId();
            this.kDQ = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kDP.cRM();
                anVar.X("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kDP.cRN();
                anVar.X("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kDP.cRO();
                anVar.X("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kDP.cRP();
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kDP = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DI(int i) {
        if (i == 1) {
            this.kDH.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kDH.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
