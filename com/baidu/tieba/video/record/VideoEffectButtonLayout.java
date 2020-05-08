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
    private ImageView lqg;
    private ImageView lqh;
    private ImageView lqi;
    private ImageView lqj;
    private LinearLayout lqk;
    private LinearLayout lql;
    private LinearLayout lqm;
    private LinearLayout lqn;
    private a lqo;
    private View lqp;

    /* loaded from: classes10.dex */
    public interface a {
        void ddf();

        void ddg();

        void ddh();

        void ddi();
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
        this.lqk = (LinearLayout) findViewById(R.id.layout_music);
        this.lql = (LinearLayout) findViewById(R.id.layout_sticker);
        this.lqm = (LinearLayout) findViewById(R.id.layout_beauty);
        this.lqn = (LinearLayout) findViewById(R.id.layout_filter);
        this.lqg = (ImageView) findViewById(R.id.img_music);
        this.lqh = (ImageView) findViewById(R.id.img_sticker);
        this.lqi = (ImageView) findViewById(R.id.img_beauty);
        this.lqj = (ImageView) findViewById(R.id.img_filter);
        this.lqg.setOnClickListener(this);
        this.lqh.setOnClickListener(this);
        this.lqi.setOnClickListener(this);
        this.lqj.setOnClickListener(this);
    }

    public void reset() {
        this.lqp = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.lqk.setVisibility(i2);
                return;
            case 1:
                this.lql.setVisibility(i2);
                return;
            case 2:
                this.lqm.setVisibility(i2);
                return;
            case 3:
                this.lqn.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.lqg.setSelected(z);
                return;
            case 1:
                this.lqh.setSelected(z);
                return;
            case 2:
                this.lqi.setSelected(z);
                return;
            case 3:
                this.lqj.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lqo != null) {
            int id = view.getId();
            this.lqp = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.lqo.ddf();
                anVar.af("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.lqo.ddg();
                anVar.af("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.lqo.ddh();
                anVar.af("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.lqo.ddi();
                anVar.af("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.lqo = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Eu(int i) {
        if (i == 1) {
            this.lqg.setImageResource(R.drawable.icon_video_music);
        } else {
            this.lqg.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
