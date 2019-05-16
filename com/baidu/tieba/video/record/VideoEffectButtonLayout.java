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
    private ImageView jwF;
    private ImageView jwG;
    private ImageView jwH;
    private ImageView jwI;
    private LinearLayout jwJ;
    private LinearLayout jwK;
    private LinearLayout jwL;
    private LinearLayout jwM;
    private a jwN;
    private View jwO;

    /* loaded from: classes5.dex */
    public interface a {
        void ctH();

        void ctI();

        void ctJ();

        void ctK();
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
        this.jwJ = (LinearLayout) findViewById(R.id.layout_music);
        this.jwK = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jwL = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jwM = (LinearLayout) findViewById(R.id.layout_filter);
        this.jwF = (ImageView) findViewById(R.id.img_music);
        this.jwG = (ImageView) findViewById(R.id.img_sticker);
        this.jwH = (ImageView) findViewById(R.id.img_beauty);
        this.jwI = (ImageView) findViewById(R.id.img_filter);
        this.jwF.setOnClickListener(this);
        this.jwG.setOnClickListener(this);
        this.jwH.setOnClickListener(this);
        this.jwI.setOnClickListener(this);
    }

    public void reset() {
        this.jwO = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jwJ.setVisibility(i2);
                return;
            case 1:
                this.jwK.setVisibility(i2);
                return;
            case 2:
                this.jwL.setVisibility(i2);
                return;
            case 3:
                this.jwM.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jwF.setSelected(z);
                return;
            case 1:
                this.jwG.setSelected(z);
                return;
            case 2:
                this.jwH.setSelected(z);
                return;
            case 3:
                this.jwI.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jwN != null) {
            int id = view.getId();
            this.jwO = view;
            am amVar = new am("c12495");
            if (id == R.id.img_music) {
                this.jwN.ctH();
                amVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jwN.ctI();
                amVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jwN.ctJ();
                amVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jwN.ctK();
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.jwN = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void BJ(int i) {
        if (i == 1) {
            this.jwF.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jwF.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
