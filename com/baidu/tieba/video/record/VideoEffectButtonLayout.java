package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView jwJ;
    private ImageView jwK;
    private ImageView jwL;
    private ImageView jwM;
    private LinearLayout jwN;
    private LinearLayout jwO;
    private LinearLayout jwP;
    private LinearLayout jwQ;
    private a jwR;
    private View jwS;

    /* loaded from: classes5.dex */
    public interface a {
        void ctI();

        void ctJ();

        void ctK();

        void ctL();
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
        this.jwN = (LinearLayout) findViewById(R.id.layout_music);
        this.jwO = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jwP = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jwQ = (LinearLayout) findViewById(R.id.layout_filter);
        this.jwJ = (ImageView) findViewById(R.id.img_music);
        this.jwK = (ImageView) findViewById(R.id.img_sticker);
        this.jwL = (ImageView) findViewById(R.id.img_beauty);
        this.jwM = (ImageView) findViewById(R.id.img_filter);
        this.jwJ.setOnClickListener(this);
        this.jwK.setOnClickListener(this);
        this.jwL.setOnClickListener(this);
        this.jwM.setOnClickListener(this);
    }

    public void reset() {
        this.jwS = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jwN.setVisibility(i2);
                return;
            case 1:
                this.jwO.setVisibility(i2);
                return;
            case 2:
                this.jwP.setVisibility(i2);
                return;
            case 3:
                this.jwQ.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jwJ.setSelected(z);
                return;
            case 1:
                this.jwK.setSelected(z);
                return;
            case 2:
                this.jwL.setSelected(z);
                return;
            case 3:
                this.jwM.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jwR != null) {
            int id = view.getId();
            this.jwS = view;
            am amVar = new am("c12495");
            if (id == R.id.img_music) {
                this.jwR.ctI();
                amVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jwR.ctJ();
                amVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jwR.ctK();
                amVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jwR.ctL();
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.jwR = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void BJ(int i) {
        if (i == 1) {
            this.jwJ.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jwJ.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
