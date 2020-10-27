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
    private ImageView npd;
    private ImageView npe;
    private ImageView npf;
    private ImageView npg;
    private LinearLayout nph;
    private LinearLayout npi;
    private LinearLayout npj;
    private LinearLayout npk;
    private a npl;
    private View npm;

    /* loaded from: classes23.dex */
    public interface a {
        void dOB();

        void dOC();

        void dOD();

        void dOE();
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
        this.nph = (LinearLayout) findViewById(R.id.layout_music);
        this.npi = (LinearLayout) findViewById(R.id.layout_sticker);
        this.npj = (LinearLayout) findViewById(R.id.layout_beauty);
        this.npk = (LinearLayout) findViewById(R.id.layout_filter);
        this.npd = (ImageView) findViewById(R.id.img_music);
        this.npe = (ImageView) findViewById(R.id.img_sticker);
        this.npf = (ImageView) findViewById(R.id.img_beauty);
        this.npg = (ImageView) findViewById(R.id.img_filter);
        this.npd.setOnClickListener(this);
        this.npe.setOnClickListener(this);
        this.npf.setOnClickListener(this);
        this.npg.setOnClickListener(this);
    }

    public void reset() {
        this.npm = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nph.setVisibility(i2);
                return;
            case 1:
                this.npi.setVisibility(i2);
                return;
            case 2:
                this.npj.setVisibility(i2);
                return;
            case 3:
                this.npk.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.npd.setSelected(z);
                return;
            case 1:
                this.npe.setSelected(z);
                return;
            case 2:
                this.npf.setSelected(z);
                return;
            case 3:
                this.npg.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.npl != null) {
            int id = view.getId();
            this.npm = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.npl.dOB();
                aqVar.aj("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.npl.dOC();
                aqVar.aj("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.npl.dOD();
                aqVar.aj("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.npl.dOE();
                aqVar.aj("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.npl = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KE(int i) {
        if (i == 1) {
            this.npd.setImageResource(R.drawable.icon_video_music);
        } else {
            this.npd.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
