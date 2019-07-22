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
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView jCS;
    private ImageView jCT;
    private ImageView jCU;
    private ImageView jCV;
    private LinearLayout jCW;
    private LinearLayout jCX;
    private LinearLayout jCY;
    private LinearLayout jCZ;
    private a jDa;
    private View jDb;

    /* loaded from: classes5.dex */
    public interface a {
        void cwA();

        void cwx();

        void cwy();

        void cwz();
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
        this.jCW = (LinearLayout) findViewById(R.id.layout_music);
        this.jCX = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jCY = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jCZ = (LinearLayout) findViewById(R.id.layout_filter);
        this.jCS = (ImageView) findViewById(R.id.img_music);
        this.jCT = (ImageView) findViewById(R.id.img_sticker);
        this.jCU = (ImageView) findViewById(R.id.img_beauty);
        this.jCV = (ImageView) findViewById(R.id.img_filter);
        this.jCS.setOnClickListener(this);
        this.jCT.setOnClickListener(this);
        this.jCU.setOnClickListener(this);
        this.jCV.setOnClickListener(this);
    }

    public void reset() {
        this.jDb = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jCW.setVisibility(i2);
                return;
            case 1:
                this.jCX.setVisibility(i2);
                return;
            case 2:
                this.jCY.setVisibility(i2);
                return;
            case 3:
                this.jCZ.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jCS.setSelected(z);
                return;
            case 1:
                this.jCT.setSelected(z);
                return;
            case 2:
                this.jCU.setSelected(z);
                return;
            case 3:
                this.jCV.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jDa != null) {
            int id = view.getId();
            this.jDb = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.jDa.cwx();
                anVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jDa.cwy();
                anVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jDa.cwz();
                anVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jDa.cwA();
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.jDa = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Cq(int i) {
        if (i == 1) {
            this.jCS.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jCS.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
