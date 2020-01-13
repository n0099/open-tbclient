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
    private ImageView kCF;
    private ImageView kCG;
    private ImageView kCH;
    private ImageView kCI;
    private LinearLayout kCJ;
    private LinearLayout kCK;
    private LinearLayout kCL;
    private LinearLayout kCM;
    private a kCN;
    private View kCO;

    /* loaded from: classes8.dex */
    public interface a {
        void cQp();

        void cQq();

        void cQr();

        void cQs();
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
        this.kCJ = (LinearLayout) findViewById(R.id.layout_music);
        this.kCK = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kCL = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kCM = (LinearLayout) findViewById(R.id.layout_filter);
        this.kCF = (ImageView) findViewById(R.id.img_music);
        this.kCG = (ImageView) findViewById(R.id.img_sticker);
        this.kCH = (ImageView) findViewById(R.id.img_beauty);
        this.kCI = (ImageView) findViewById(R.id.img_filter);
        this.kCF.setOnClickListener(this);
        this.kCG.setOnClickListener(this);
        this.kCH.setOnClickListener(this);
        this.kCI.setOnClickListener(this);
    }

    public void reset() {
        this.kCO = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kCJ.setVisibility(i2);
                return;
            case 1:
                this.kCK.setVisibility(i2);
                return;
            case 2:
                this.kCL.setVisibility(i2);
                return;
            case 3:
                this.kCM.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kCF.setSelected(z);
                return;
            case 1:
                this.kCG.setSelected(z);
                return;
            case 2:
                this.kCH.setSelected(z);
                return;
            case 3:
                this.kCI.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kCN != null) {
            int id = view.getId();
            this.kCO = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kCN.cQp();
                anVar.Z("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kCN.cQq();
                anVar.Z("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kCN.cQr();
                anVar.Z("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kCN.cQs();
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kCN = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DC(int i) {
        if (i == 1) {
            this.kCF.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kCF.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
