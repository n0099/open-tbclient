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
    private ImageView lJT;
    private ImageView lJU;
    private ImageView lJV;
    private ImageView lJW;
    private LinearLayout lJX;
    private LinearLayout lJY;
    private LinearLayout lJZ;
    private LinearLayout lKa;
    private a lKb;
    private View lKc;

    /* loaded from: classes10.dex */
    public interface a {
        void dkJ();

        void dkK();

        void dkL();

        void dkM();
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
        this.lJX = (LinearLayout) findViewById(R.id.layout_music);
        this.lJY = (LinearLayout) findViewById(R.id.layout_sticker);
        this.lJZ = (LinearLayout) findViewById(R.id.layout_beauty);
        this.lKa = (LinearLayout) findViewById(R.id.layout_filter);
        this.lJT = (ImageView) findViewById(R.id.img_music);
        this.lJU = (ImageView) findViewById(R.id.img_sticker);
        this.lJV = (ImageView) findViewById(R.id.img_beauty);
        this.lJW = (ImageView) findViewById(R.id.img_filter);
        this.lJT.setOnClickListener(this);
        this.lJU.setOnClickListener(this);
        this.lJV.setOnClickListener(this);
        this.lJW.setOnClickListener(this);
    }

    public void reset() {
        this.lKc = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.lJX.setVisibility(i2);
                return;
            case 1:
                this.lJY.setVisibility(i2);
                return;
            case 2:
                this.lJZ.setVisibility(i2);
                return;
            case 3:
                this.lKa.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.lJT.setSelected(z);
                return;
            case 1:
                this.lJU.setSelected(z);
                return;
            case 2:
                this.lJV.setSelected(z);
                return;
            case 3:
                this.lJW.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lKb != null) {
            int id = view.getId();
            this.lKc = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.lKb.dkJ();
                anVar.ag("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.lKb.dkK();
                anVar.ag("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.lKb.dkL();
                anVar.ag("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.lKb.dkM();
                anVar.ag("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.lKb = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Fh(int i) {
        if (i == 1) {
            this.lJT.setImageResource(R.drawable.icon_video_music);
        } else {
            this.lJT.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
