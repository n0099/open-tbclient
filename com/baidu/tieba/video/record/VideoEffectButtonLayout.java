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
/* loaded from: classes22.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView mMV;
    private ImageView mMW;
    private ImageView mMX;
    private ImageView mMY;
    private LinearLayout mMZ;
    private LinearLayout mNa;
    private LinearLayout mNb;
    private LinearLayout mNc;
    private a mNd;
    private View mNe;

    /* loaded from: classes22.dex */
    public interface a {
        void dHH();

        void dHI();

        void dHJ();

        void dHK();
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
        this.mMZ = (LinearLayout) findViewById(R.id.layout_music);
        this.mNa = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mNb = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mNc = (LinearLayout) findViewById(R.id.layout_filter);
        this.mMV = (ImageView) findViewById(R.id.img_music);
        this.mMW = (ImageView) findViewById(R.id.img_sticker);
        this.mMX = (ImageView) findViewById(R.id.img_beauty);
        this.mMY = (ImageView) findViewById(R.id.img_filter);
        this.mMV.setOnClickListener(this);
        this.mMW.setOnClickListener(this);
        this.mMX.setOnClickListener(this);
        this.mMY.setOnClickListener(this);
    }

    public void reset() {
        this.mNe = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mMZ.setVisibility(i2);
                return;
            case 1:
                this.mNa.setVisibility(i2);
                return;
            case 2:
                this.mNb.setVisibility(i2);
                return;
            case 3:
                this.mNc.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mMV.setSelected(z);
                return;
            case 1:
                this.mMW.setSelected(z);
                return;
            case 2:
                this.mMX.setSelected(z);
                return;
            case 3:
                this.mMY.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mNd != null) {
            int id = view.getId();
            this.mNe = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.mNd.dHH();
                aqVar.ai("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mNd.dHI();
                aqVar.ai("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mNd.dHJ();
                aqVar.ai("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mNd.dHK();
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.mNd = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void JG(int i) {
        if (i == 1) {
            this.mMV.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mMV.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
