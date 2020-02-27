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
    private ImageView kDF;
    private ImageView kDG;
    private ImageView kDH;
    private ImageView kDI;
    private LinearLayout kDJ;
    private LinearLayout kDK;
    private LinearLayout kDL;
    private LinearLayout kDM;
    private a kDN;
    private View kDO;

    /* loaded from: classes10.dex */
    public interface a {
        void cRK();

        void cRL();

        void cRM();

        void cRN();
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
        this.kDJ = (LinearLayout) findViewById(R.id.layout_music);
        this.kDK = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kDL = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kDM = (LinearLayout) findViewById(R.id.layout_filter);
        this.kDF = (ImageView) findViewById(R.id.img_music);
        this.kDG = (ImageView) findViewById(R.id.img_sticker);
        this.kDH = (ImageView) findViewById(R.id.img_beauty);
        this.kDI = (ImageView) findViewById(R.id.img_filter);
        this.kDF.setOnClickListener(this);
        this.kDG.setOnClickListener(this);
        this.kDH.setOnClickListener(this);
        this.kDI.setOnClickListener(this);
    }

    public void reset() {
        this.kDO = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kDJ.setVisibility(i2);
                return;
            case 1:
                this.kDK.setVisibility(i2);
                return;
            case 2:
                this.kDL.setVisibility(i2);
                return;
            case 3:
                this.kDM.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kDF.setSelected(z);
                return;
            case 1:
                this.kDG.setSelected(z);
                return;
            case 2:
                this.kDH.setSelected(z);
                return;
            case 3:
                this.kDI.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kDN != null) {
            int id = view.getId();
            this.kDO = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kDN.cRK();
                anVar.X("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kDN.cRL();
                anVar.X("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kDN.cRM();
                anVar.X("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kDN.cRN();
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kDN = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DI(int i) {
        if (i == 1) {
            this.kDF.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kDF.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
