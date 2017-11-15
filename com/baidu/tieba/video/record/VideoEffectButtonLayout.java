package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView gLW;
    private ImageView gLX;
    private ImageView gLY;
    private ImageView gLZ;
    private a gMa;
    private View gMb;

    /* loaded from: classes2.dex */
    public interface a {
        void bAT();

        void bAU();

        void bAV();

        void bAW();
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
        inflate(getContext(), d.h.layout_video_effect_button, this);
        this.gLW = (ImageView) findViewById(d.g.img_music);
        this.gLX = (ImageView) findViewById(d.g.img_sticker);
        this.gLY = (ImageView) findViewById(d.g.img_beauty);
        this.gLZ = (ImageView) findViewById(d.g.img_filter);
        this.gLW.setOnClickListener(this);
        this.gLX.setOnClickListener(this);
        this.gLY.setOnClickListener(this);
        this.gLZ.setOnClickListener(this);
    }

    public void reset() {
        this.gMb = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gMa != null) {
            int id = view.getId();
            this.gMb = view;
            ak akVar = new ak("c12495");
            if (id == d.g.img_music) {
                this.gMa.bAT();
                akVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.gMa.bAU();
                akVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.gMa.bAV();
                akVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.gMa.bAW();
                akVar.r("obj_type", 2);
            }
            TiebaStatic.log(akVar);
        }
    }

    public void setListener(a aVar) {
        this.gMa = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uZ(int i) {
        if (i == 1) {
            this.gLW.setImageResource(d.f.icon_video_music);
        } else {
            this.gLW.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
