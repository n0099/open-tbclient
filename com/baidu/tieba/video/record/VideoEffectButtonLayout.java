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
    private ImageView lqc;
    private ImageView lqd;
    private ImageView lqe;
    private ImageView lqf;
    private LinearLayout lqg;
    private LinearLayout lqh;
    private LinearLayout lqi;
    private LinearLayout lqj;
    private a lqk;
    private View lql;

    /* loaded from: classes10.dex */
    public interface a {
        void ddi();

        void ddj();

        void ddk();

        void ddl();
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
        this.lqg = (LinearLayout) findViewById(R.id.layout_music);
        this.lqh = (LinearLayout) findViewById(R.id.layout_sticker);
        this.lqi = (LinearLayout) findViewById(R.id.layout_beauty);
        this.lqj = (LinearLayout) findViewById(R.id.layout_filter);
        this.lqc = (ImageView) findViewById(R.id.img_music);
        this.lqd = (ImageView) findViewById(R.id.img_sticker);
        this.lqe = (ImageView) findViewById(R.id.img_beauty);
        this.lqf = (ImageView) findViewById(R.id.img_filter);
        this.lqc.setOnClickListener(this);
        this.lqd.setOnClickListener(this);
        this.lqe.setOnClickListener(this);
        this.lqf.setOnClickListener(this);
    }

    public void reset() {
        this.lql = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.lqg.setVisibility(i2);
                return;
            case 1:
                this.lqh.setVisibility(i2);
                return;
            case 2:
                this.lqi.setVisibility(i2);
                return;
            case 3:
                this.lqj.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.lqc.setSelected(z);
                return;
            case 1:
                this.lqd.setSelected(z);
                return;
            case 2:
                this.lqe.setSelected(z);
                return;
            case 3:
                this.lqf.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lqk != null) {
            int id = view.getId();
            this.lql = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.lqk.ddi();
                anVar.af("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.lqk.ddj();
                anVar.af("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.lqk.ddk();
                anVar.af("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.lqk.ddl();
                anVar.af("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.lqk = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Eu(int i) {
        if (i == 1) {
            this.lqc.setImageResource(R.drawable.icon_video_music);
        } else {
            this.lqc.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
