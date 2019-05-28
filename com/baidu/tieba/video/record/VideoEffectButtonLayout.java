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
    private ImageView jwG;
    private ImageView jwH;
    private ImageView jwI;
    private ImageView jwJ;
    private LinearLayout jwK;
    private LinearLayout jwL;
    private LinearLayout jwM;
    private LinearLayout jwN;
    private a jwO;
    private View jwP;

    /* loaded from: classes5.dex */
    public interface a {
        void ctJ();

        void ctK();

        void ctL();

        void ctM();
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
        this.jwK = (LinearLayout) findViewById(R.id.layout_music);
        this.jwL = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jwM = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jwN = (LinearLayout) findViewById(R.id.layout_filter);
        this.jwG = (ImageView) findViewById(R.id.img_music);
        this.jwH = (ImageView) findViewById(R.id.img_sticker);
        this.jwI = (ImageView) findViewById(R.id.img_beauty);
        this.jwJ = (ImageView) findViewById(R.id.img_filter);
        this.jwG.setOnClickListener(this);
        this.jwH.setOnClickListener(this);
        this.jwI.setOnClickListener(this);
        this.jwJ.setOnClickListener(this);
    }

    public void reset() {
        this.jwP = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jwK.setVisibility(i2);
                return;
            case 1:
                this.jwL.setVisibility(i2);
                return;
            case 2:
                this.jwM.setVisibility(i2);
                return;
            case 3:
                this.jwN.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jwG.setSelected(z);
                return;
            case 1:
                this.jwH.setSelected(z);
                return;
            case 2:
                this.jwI.setSelected(z);
                return;
            case 3:
                this.jwJ.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jwO != null) {
            int id = view.getId();
            this.jwP = view;
            am amVar = new am("c12495");
            if (id == R.id.img_music) {
                this.jwO.ctJ();
                amVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jwO.ctK();
                amVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jwO.ctL();
                amVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jwO.ctM();
                amVar.P("obj_type", 2);
            }
            TiebaStatic.log(amVar);
        }
    }

    public void setListener(a aVar) {
        this.jwO = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void BJ(int i) {
        if (i == 1) {
            this.jwG.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jwG.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
