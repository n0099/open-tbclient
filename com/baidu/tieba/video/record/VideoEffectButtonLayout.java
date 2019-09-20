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
    private LinearLayout jGA;
    private LinearLayout jGB;
    private LinearLayout jGC;
    private a jGD;
    private View jGE;
    private ImageView jGv;
    private ImageView jGw;
    private ImageView jGx;
    private ImageView jGy;
    private LinearLayout jGz;

    /* loaded from: classes5.dex */
    public interface a {
        void cxH();

        void cxI();

        void cxJ();

        void cxK();
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
        this.jGz = (LinearLayout) findViewById(R.id.layout_music);
        this.jGA = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jGB = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jGC = (LinearLayout) findViewById(R.id.layout_filter);
        this.jGv = (ImageView) findViewById(R.id.img_music);
        this.jGw = (ImageView) findViewById(R.id.img_sticker);
        this.jGx = (ImageView) findViewById(R.id.img_beauty);
        this.jGy = (ImageView) findViewById(R.id.img_filter);
        this.jGv.setOnClickListener(this);
        this.jGw.setOnClickListener(this);
        this.jGx.setOnClickListener(this);
        this.jGy.setOnClickListener(this);
    }

    public void reset() {
        this.jGE = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jGz.setVisibility(i2);
                return;
            case 1:
                this.jGA.setVisibility(i2);
                return;
            case 2:
                this.jGB.setVisibility(i2);
                return;
            case 3:
                this.jGC.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jGv.setSelected(z);
                return;
            case 1:
                this.jGw.setSelected(z);
                return;
            case 2:
                this.jGx.setSelected(z);
                return;
            case 3:
                this.jGy.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jGD != null) {
            int id = view.getId();
            this.jGE = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.jGD.cxH();
                anVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jGD.cxI();
                anVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jGD.cxJ();
                anVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jGD.cxK();
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.jGD = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Cw(int i) {
        if (i == 1) {
            this.jGv.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jGv.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
