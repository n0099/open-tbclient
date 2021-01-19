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
/* loaded from: classes7.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nIY;
    private ImageView nIZ;
    private ImageView nJa;
    private ImageView nJb;
    private LinearLayout nJc;
    private LinearLayout nJd;
    private LinearLayout nJe;
    private LinearLayout nJf;
    private a nJg;
    private View nJh;

    /* loaded from: classes7.dex */
    public interface a {
        void dSj();

        void dSk();

        void dSl();

        void dSm();
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
        this.nJc = (LinearLayout) findViewById(R.id.layout_music);
        this.nJd = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nJe = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nJf = (LinearLayout) findViewById(R.id.layout_filter);
        this.nIY = (ImageView) findViewById(R.id.img_music);
        this.nIZ = (ImageView) findViewById(R.id.img_sticker);
        this.nJa = (ImageView) findViewById(R.id.img_beauty);
        this.nJb = (ImageView) findViewById(R.id.img_filter);
        this.nIY.setOnClickListener(this);
        this.nIZ.setOnClickListener(this);
        this.nJa.setOnClickListener(this);
        this.nJb.setOnClickListener(this);
    }

    public void reset() {
        this.nJh = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nJc.setVisibility(i2);
                return;
            case 1:
                this.nJd.setVisibility(i2);
                return;
            case 2:
                this.nJe.setVisibility(i2);
                return;
            case 3:
                this.nJf.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nIY.setSelected(z);
                return;
            case 1:
                this.nIZ.setSelected(z);
                return;
            case 2:
                this.nJa.setSelected(z);
                return;
            case 3:
                this.nJb.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nJg != null) {
            int id = view.getId();
            this.nJh = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.nJg.dSj();
                aqVar.an("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nJg.dSk();
                aqVar.an("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nJg.dSl();
                aqVar.an("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nJg.dSm();
                aqVar.an("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.nJg = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Ks(int i) {
        if (i == 1) {
            this.nIY.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nIY.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
