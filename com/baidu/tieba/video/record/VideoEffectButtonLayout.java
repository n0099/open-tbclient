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
    private ImageView kFA;
    private ImageView kFB;
    private ImageView kFC;
    private ImageView kFD;
    private LinearLayout kFE;
    private LinearLayout kFF;
    private LinearLayout kFG;
    private LinearLayout kFH;
    private a kFI;
    private View kFJ;

    /* loaded from: classes10.dex */
    public interface a {
        void cSh();

        void cSi();

        void cSj();

        void cSk();
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
        this.kFE = (LinearLayout) findViewById(R.id.layout_music);
        this.kFF = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kFG = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kFH = (LinearLayout) findViewById(R.id.layout_filter);
        this.kFA = (ImageView) findViewById(R.id.img_music);
        this.kFB = (ImageView) findViewById(R.id.img_sticker);
        this.kFC = (ImageView) findViewById(R.id.img_beauty);
        this.kFD = (ImageView) findViewById(R.id.img_filter);
        this.kFA.setOnClickListener(this);
        this.kFB.setOnClickListener(this);
        this.kFC.setOnClickListener(this);
        this.kFD.setOnClickListener(this);
    }

    public void reset() {
        this.kFJ = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kFE.setVisibility(i2);
                return;
            case 1:
                this.kFF.setVisibility(i2);
                return;
            case 2:
                this.kFG.setVisibility(i2);
                return;
            case 3:
                this.kFH.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kFA.setSelected(z);
                return;
            case 1:
                this.kFB.setSelected(z);
                return;
            case 2:
                this.kFC.setSelected(z);
                return;
            case 3:
                this.kFD.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kFI != null) {
            int id = view.getId();
            this.kFJ = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kFI.cSh();
                anVar.X("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kFI.cSi();
                anVar.X("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kFI.cSj();
                anVar.X("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kFI.cSk();
                anVar.X("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kFI = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void DQ(int i) {
        if (i == 1) {
            this.kFA.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kFA.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
