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
/* loaded from: classes23.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView ncB;
    private ImageView ncC;
    private ImageView ncD;
    private ImageView ncE;
    private LinearLayout ncF;
    private LinearLayout ncG;
    private LinearLayout ncH;
    private LinearLayout ncI;
    private a ncJ;
    private View ncK;

    /* loaded from: classes23.dex */
    public interface a {
        void dLt();

        void dLu();

        void dLv();

        void dLw();
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
        this.ncF = (LinearLayout) findViewById(R.id.layout_music);
        this.ncG = (LinearLayout) findViewById(R.id.layout_sticker);
        this.ncH = (LinearLayout) findViewById(R.id.layout_beauty);
        this.ncI = (LinearLayout) findViewById(R.id.layout_filter);
        this.ncB = (ImageView) findViewById(R.id.img_music);
        this.ncC = (ImageView) findViewById(R.id.img_sticker);
        this.ncD = (ImageView) findViewById(R.id.img_beauty);
        this.ncE = (ImageView) findViewById(R.id.img_filter);
        this.ncB.setOnClickListener(this);
        this.ncC.setOnClickListener(this);
        this.ncD.setOnClickListener(this);
        this.ncE.setOnClickListener(this);
    }

    public void reset() {
        this.ncK = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.ncF.setVisibility(i2);
                return;
            case 1:
                this.ncG.setVisibility(i2);
                return;
            case 2:
                this.ncH.setVisibility(i2);
                return;
            case 3:
                this.ncI.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.ncB.setSelected(z);
                return;
            case 1:
                this.ncC.setSelected(z);
                return;
            case 2:
                this.ncD.setSelected(z);
                return;
            case 3:
                this.ncE.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ncJ != null) {
            int id = view.getId();
            this.ncK = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.ncJ.dLt();
                aqVar.aj("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.ncJ.dLu();
                aqVar.aj("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.ncJ.dLv();
                aqVar.aj("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.ncJ.dLw();
                aqVar.aj("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.ncJ = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Km(int i) {
        if (i == 1) {
            this.ncB.setImageResource(R.drawable.icon_video_music);
        } else {
            this.ncB.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
