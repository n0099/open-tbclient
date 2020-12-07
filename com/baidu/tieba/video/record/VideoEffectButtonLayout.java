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
    private ImageView nKg;
    private ImageView nKh;
    private ImageView nKi;
    private ImageView nKj;
    private LinearLayout nKk;
    private LinearLayout nKl;
    private LinearLayout nKm;
    private LinearLayout nKn;
    private a nKo;
    private View nKp;

    /* loaded from: classes23.dex */
    public interface a {
        void dWw();

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
        this.nKk = (LinearLayout) findViewById(R.id.layout_music);
        this.nKl = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nKm = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nKn = (LinearLayout) findViewById(R.id.layout_filter);
        this.nKg = (ImageView) findViewById(R.id.img_music);
        this.nKh = (ImageView) findViewById(R.id.img_sticker);
        this.nKi = (ImageView) findViewById(R.id.img_beauty);
        this.nKj = (ImageView) findViewById(R.id.img_filter);
        this.nKg.setOnClickListener(this);
        this.nKh.setOnClickListener(this);
        this.nKi.setOnClickListener(this);
        this.nKj.setOnClickListener(this);
    }

    public void reset() {
        this.nKp = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nKk.setVisibility(i2);
                return;
            case 1:
                this.nKl.setVisibility(i2);
                return;
            case 2:
                this.nKm.setVisibility(i2);
                return;
            case 3:
                this.nKn.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nKg.setSelected(z);
                return;
            case 1:
                this.nKh.setSelected(z);
                return;
            case 2:
                this.nKi.setSelected(z);
                return;
            case 3:
                this.nKj.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nKo != null) {
            int id = view.getId();
            this.nKp = view;
            ar arVar = new ar("c12495");
            if (id == R.id.img_music) {
                this.nKo.dWw();
                arVar.al("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nKo.dWx();
                arVar.al("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nKo.dWy();
                arVar.al("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nKo.dWz();
                arVar.al("obj_type", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    public void setListener(a aVar) {
        this.nKo = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Mm(int i) {
        if (i == 1) {
            this.nKg.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nKg.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
