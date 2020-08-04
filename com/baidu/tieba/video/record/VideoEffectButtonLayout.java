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
    private ImageView mlf;
    private ImageView mlg;
    private ImageView mlh;
    private ImageView mli;
    private LinearLayout mlj;
    private LinearLayout mlk;
    private LinearLayout mll;
    private LinearLayout mlm;
    private a mln;
    private View mlo;

    /* loaded from: classes17.dex */
    public interface a {
        void dsj();

        void dsk();

        void dsl();

        void dsm();
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
        this.mlj = (LinearLayout) findViewById(R.id.layout_music);
        this.mlk = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mll = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mlm = (LinearLayout) findViewById(R.id.layout_filter);
        this.mlf = (ImageView) findViewById(R.id.img_music);
        this.mlg = (ImageView) findViewById(R.id.img_sticker);
        this.mlh = (ImageView) findViewById(R.id.img_beauty);
        this.mli = (ImageView) findViewById(R.id.img_filter);
        this.mlf.setOnClickListener(this);
        this.mlg.setOnClickListener(this);
        this.mlh.setOnClickListener(this);
        this.mli.setOnClickListener(this);
    }

    public void reset() {
        this.mlo = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mlj.setVisibility(i2);
                return;
            case 1:
                this.mlk.setVisibility(i2);
                return;
            case 2:
                this.mll.setVisibility(i2);
                return;
            case 3:
                this.mlm.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mlf.setSelected(z);
                return;
            case 1:
                this.mlg.setSelected(z);
                return;
            case 2:
                this.mlh.setSelected(z);
                return;
            case 3:
                this.mli.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mln != null) {
            int id = view.getId();
            this.mlo = view;
            ap apVar = new ap("c12495");
            if (id == R.id.img_music) {
                this.mln.dsj();
                apVar.ah("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mln.dsk();
                apVar.ah("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mln.dsl();
                apVar.ah("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mln.dsm();
                apVar.ah("obj_type", 2);
            }
            TiebaStatic.log(apVar);
        }
    }

    public void setListener(a aVar) {
        this.mln = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void GG(int i) {
        if (i == 1) {
            this.mlf.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mlf.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
