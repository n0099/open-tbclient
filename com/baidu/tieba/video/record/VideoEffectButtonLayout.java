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
/* loaded from: classes17.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView mCP;
    private ImageView mCQ;
    private ImageView mCR;
    private ImageView mCS;
    private LinearLayout mCT;
    private LinearLayout mCU;
    private LinearLayout mCV;
    private LinearLayout mCW;
    private a mCX;
    private View mCY;

    /* loaded from: classes17.dex */
    public interface a {
        void dDE();

        void dDF();

        void dDG();

        void dDH();
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
        this.mCT = (LinearLayout) findViewById(R.id.layout_music);
        this.mCU = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mCV = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mCW = (LinearLayout) findViewById(R.id.layout_filter);
        this.mCP = (ImageView) findViewById(R.id.img_music);
        this.mCQ = (ImageView) findViewById(R.id.img_sticker);
        this.mCR = (ImageView) findViewById(R.id.img_beauty);
        this.mCS = (ImageView) findViewById(R.id.img_filter);
        this.mCP.setOnClickListener(this);
        this.mCQ.setOnClickListener(this);
        this.mCR.setOnClickListener(this);
        this.mCS.setOnClickListener(this);
    }

    public void reset() {
        this.mCY = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mCT.setVisibility(i2);
                return;
            case 1:
                this.mCU.setVisibility(i2);
                return;
            case 2:
                this.mCV.setVisibility(i2);
                return;
            case 3:
                this.mCW.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mCP.setSelected(z);
                return;
            case 1:
                this.mCQ.setSelected(z);
                return;
            case 2:
                this.mCR.setSelected(z);
                return;
            case 3:
                this.mCS.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mCX != null) {
            int id = view.getId();
            this.mCY = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.mCX.dDE();
                aqVar.ai("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mCX.dDF();
                aqVar.ai("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mCX.dDG();
                aqVar.ai("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mCX.dDH();
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.mCX = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Jc(int i) {
        if (i == 1) {
            this.mCP.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mCP.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
