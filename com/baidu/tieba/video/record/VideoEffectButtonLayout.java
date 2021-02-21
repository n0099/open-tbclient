package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes8.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nTf;
    private ImageView nTg;
    private ImageView nTh;
    private ImageView nTi;
    private LinearLayout nTj;
    private LinearLayout nTk;
    private LinearLayout nTl;
    private LinearLayout nTm;
    private a nTn;
    private View nTo;

    /* loaded from: classes8.dex */
    public interface a {
        void dUC();

        void dUD();

        void dUE();

        void dUF();
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
        this.nTj = (LinearLayout) findViewById(R.id.layout_music);
        this.nTk = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nTl = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nTm = (LinearLayout) findViewById(R.id.layout_filter);
        this.nTf = (ImageView) findViewById(R.id.img_music);
        this.nTg = (ImageView) findViewById(R.id.img_sticker);
        this.nTh = (ImageView) findViewById(R.id.img_beauty);
        this.nTi = (ImageView) findViewById(R.id.img_filter);
        this.nTf.setOnClickListener(this);
        this.nTg.setOnClickListener(this);
        this.nTh.setOnClickListener(this);
        this.nTi.setOnClickListener(this);
    }

    public void reset() {
        this.nTo = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nTj.setVisibility(i2);
                return;
            case 1:
                this.nTk.setVisibility(i2);
                return;
            case 2:
                this.nTl.setVisibility(i2);
                return;
            case 3:
                this.nTm.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nTf.setSelected(z);
                return;
            case 1:
                this.nTg.setSelected(z);
                return;
            case 2:
                this.nTh.setSelected(z);
                return;
            case 3:
                this.nTi.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nTn != null) {
            int id = view.getId();
            this.nTo = view;
            ar arVar = new ar("c12495");
            if (id == R.id.img_music) {
                this.nTn.dUC();
                arVar.ap("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nTn.dUD();
                arVar.ap("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nTn.dUE();
                arVar.ap("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nTn.dUF();
                arVar.ap("obj_type", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    public void setListener(a aVar) {
        this.nTn = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KM(int i) {
        if (i == 1) {
            this.nTf.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nTf.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
