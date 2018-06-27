package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.i;
/* loaded from: classes2.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView hjT;
    private ImageView hjU;
    private ImageView hjV;
    private ImageView hjW;
    private LinearLayout hjX;
    private LinearLayout hjY;
    private LinearLayout hjZ;
    private LinearLayout hka;
    private a hkb;
    private View hkc;

    /* loaded from: classes2.dex */
    public interface a {
        void bEp();

        void bEq();

        void bEr();

        void bEs();
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
        inflate(getContext(), d.i.layout_video_effect_button, this);
        this.hjX = (LinearLayout) findViewById(d.g.layout_music);
        this.hjY = (LinearLayout) findViewById(d.g.layout_sticker);
        this.hjZ = (LinearLayout) findViewById(d.g.layout_beauty);
        this.hka = (LinearLayout) findViewById(d.g.layout_filter);
        this.hjT = (ImageView) findViewById(d.g.img_music);
        this.hjU = (ImageView) findViewById(d.g.img_sticker);
        this.hjV = (ImageView) findViewById(d.g.img_beauty);
        this.hjW = (ImageView) findViewById(d.g.img_filter);
        this.hjT.setOnClickListener(this);
        this.hjU.setOnClickListener(this);
        this.hjV.setOnClickListener(this);
        this.hjW.setOnClickListener(this);
    }

    public void reset() {
        this.hkc = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.hjX.setVisibility(i2);
                return;
            case 1:
                this.hjY.setVisibility(i2);
                return;
            case 2:
                this.hjZ.setVisibility(i2);
                return;
            case 3:
                this.hka.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.hjT.setSelected(z);
                return;
            case 1:
                this.hjU.setSelected(z);
                return;
            case 2:
                this.hjV.setSelected(z);
                return;
            case 3:
                this.hjW.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hkb != null) {
            int id = view.getId();
            this.hkc = view;
            an anVar = new an("c12495");
            if (id == d.g.img_music) {
                this.hkb.bEp();
                anVar.r("obj_type", 6);
            } else if (id == d.g.img_sticker) {
                this.hkb.bEq();
                anVar.r("obj_type", 4);
            } else if (id == d.g.img_beauty) {
                this.hkb.bEr();
                anVar.r("obj_type", 3);
            } else if (id == d.g.img_filter) {
                this.hkb.bEs();
                anVar.r("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.hkb = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void uR(int i) {
        if (i == 1) {
            this.hjT.setImageResource(d.f.icon_video_music);
        } else {
            this.hjT.setImageResource(d.f.icon_video_music_disable);
        }
    }
}
