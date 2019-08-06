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
    private ImageView jDZ;
    private ImageView jEa;
    private ImageView jEb;
    private ImageView jEc;
    private LinearLayout jEd;
    private LinearLayout jEe;
    private LinearLayout jEf;
    private LinearLayout jEg;
    private a jEh;
    private View jEi;

    /* loaded from: classes5.dex */
    public interface a {
        void cwT();

        void cwU();

        void cwV();

        void cwW();
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
        this.jEd = (LinearLayout) findViewById(R.id.layout_music);
        this.jEe = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jEf = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jEg = (LinearLayout) findViewById(R.id.layout_filter);
        this.jDZ = (ImageView) findViewById(R.id.img_music);
        this.jEa = (ImageView) findViewById(R.id.img_sticker);
        this.jEb = (ImageView) findViewById(R.id.img_beauty);
        this.jEc = (ImageView) findViewById(R.id.img_filter);
        this.jDZ.setOnClickListener(this);
        this.jEa.setOnClickListener(this);
        this.jEb.setOnClickListener(this);
        this.jEc.setOnClickListener(this);
    }

    public void reset() {
        this.jEi = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jEd.setVisibility(i2);
                return;
            case 1:
                this.jEe.setVisibility(i2);
                return;
            case 2:
                this.jEf.setVisibility(i2);
                return;
            case 3:
                this.jEg.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jDZ.setSelected(z);
                return;
            case 1:
                this.jEa.setSelected(z);
                return;
            case 2:
                this.jEb.setSelected(z);
                return;
            case 3:
                this.jEc.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jEh != null) {
            int id = view.getId();
            this.jEi = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.jEh.cwT();
                anVar.P("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jEh.cwU();
                anVar.P("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jEh.cwV();
                anVar.P("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jEh.cwW();
                anVar.P("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.jEh = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Cs(int i) {
        if (i == 1) {
            this.jDZ.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jDZ.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
