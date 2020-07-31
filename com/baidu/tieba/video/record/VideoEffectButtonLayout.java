package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes17.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView mld;
    private ImageView mle;
    private ImageView mlf;
    private ImageView mlg;
    private LinearLayout mlh;
    private LinearLayout mli;
    private LinearLayout mlj;
    private LinearLayout mlk;
    private a mll;
    private View mlm;

    /* loaded from: classes17.dex */
    public interface a {
        void dsi();

        void dsj();

        void dsk();

        void dsl();
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
        this.mlh = (LinearLayout) findViewById(R.id.layout_music);
        this.mli = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mlj = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mlk = (LinearLayout) findViewById(R.id.layout_filter);
        this.mld = (ImageView) findViewById(R.id.img_music);
        this.mle = (ImageView) findViewById(R.id.img_sticker);
        this.mlf = (ImageView) findViewById(R.id.img_beauty);
        this.mlg = (ImageView) findViewById(R.id.img_filter);
        this.mld.setOnClickListener(this);
        this.mle.setOnClickListener(this);
        this.mlf.setOnClickListener(this);
        this.mlg.setOnClickListener(this);
    }

    public void reset() {
        this.mlm = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mlh.setVisibility(i2);
                return;
            case 1:
                this.mli.setVisibility(i2);
                return;
            case 2:
                this.mlj.setVisibility(i2);
                return;
            case 3:
                this.mlk.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mld.setSelected(z);
                return;
            case 1:
                this.mle.setSelected(z);
                return;
            case 2:
                this.mlf.setSelected(z);
                return;
            case 3:
                this.mlg.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mll != null) {
            int id = view.getId();
            this.mlm = view;
            ap apVar = new ap("c12495");
            if (id == R.id.img_music) {
                this.mll.dsi();
                apVar.ah("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mll.dsj();
                apVar.ah("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mll.dsk();
                apVar.ah("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mll.dsl();
                apVar.ah("obj_type", 2);
            }
            TiebaStatic.log(apVar);
        }
    }

    public void setListener(a aVar) {
        this.mll = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void GG(int i) {
        if (i == 1) {
            this.mld.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mld.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
