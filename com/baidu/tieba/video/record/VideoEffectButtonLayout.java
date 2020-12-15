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
/* loaded from: classes23.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nKi;
    private ImageView nKj;
    private ImageView nKk;
    private ImageView nKl;
    private LinearLayout nKm;
    private LinearLayout nKn;
    private LinearLayout nKo;
    private LinearLayout nKp;
    private a nKq;
    private View nKr;

    /* loaded from: classes23.dex */
    public interface a {
        void dWA();

        void dWx();

        void dWy();

        void dWz();
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
        this.nKm = (LinearLayout) findViewById(R.id.layout_music);
        this.nKn = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nKo = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nKp = (LinearLayout) findViewById(R.id.layout_filter);
        this.nKi = (ImageView) findViewById(R.id.img_music);
        this.nKj = (ImageView) findViewById(R.id.img_sticker);
        this.nKk = (ImageView) findViewById(R.id.img_beauty);
        this.nKl = (ImageView) findViewById(R.id.img_filter);
        this.nKi.setOnClickListener(this);
        this.nKj.setOnClickListener(this);
        this.nKk.setOnClickListener(this);
        this.nKl.setOnClickListener(this);
    }

    public void reset() {
        this.nKr = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nKm.setVisibility(i2);
                return;
            case 1:
                this.nKn.setVisibility(i2);
                return;
            case 2:
                this.nKo.setVisibility(i2);
                return;
            case 3:
                this.nKp.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nKi.setSelected(z);
                return;
            case 1:
                this.nKj.setSelected(z);
                return;
            case 2:
                this.nKk.setSelected(z);
                return;
            case 3:
                this.nKl.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nKq != null) {
            int id = view.getId();
            this.nKr = view;
            ar arVar = new ar("c12495");
            if (id == R.id.img_music) {
                this.nKq.dWx();
                arVar.al("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nKq.dWy();
                arVar.al("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nKq.dWz();
                arVar.al("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nKq.dWA();
                arVar.al("obj_type", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    public void setListener(a aVar) {
        this.nKq = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Mm(int i) {
        if (i == 1) {
            this.nKi.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nKi.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
