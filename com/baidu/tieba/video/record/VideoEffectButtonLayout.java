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
/* loaded from: classes7.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView kzd;
    private ImageView kze;
    private ImageView kzf;
    private ImageView kzg;
    private LinearLayout kzh;
    private LinearLayout kzi;
    private LinearLayout kzj;
    private LinearLayout kzk;
    private a kzl;
    private View kzm;

    /* loaded from: classes7.dex */
    public interface a {
        void cPm();

        void cPn();

        void cPo();

        void cPp();
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
        this.kzh = (LinearLayout) findViewById(R.id.layout_music);
        this.kzi = (LinearLayout) findViewById(R.id.layout_sticker);
        this.kzj = (LinearLayout) findViewById(R.id.layout_beauty);
        this.kzk = (LinearLayout) findViewById(R.id.layout_filter);
        this.kzd = (ImageView) findViewById(R.id.img_music);
        this.kze = (ImageView) findViewById(R.id.img_sticker);
        this.kzf = (ImageView) findViewById(R.id.img_beauty);
        this.kzg = (ImageView) findViewById(R.id.img_filter);
        this.kzd.setOnClickListener(this);
        this.kze.setOnClickListener(this);
        this.kzf.setOnClickListener(this);
        this.kzg.setOnClickListener(this);
    }

    public void reset() {
        this.kzm = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.kzh.setVisibility(i2);
                return;
            case 1:
                this.kzi.setVisibility(i2);
                return;
            case 2:
                this.kzj.setVisibility(i2);
                return;
            case 3:
                this.kzk.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.kzd.setSelected(z);
                return;
            case 1:
                this.kze.setSelected(z);
                return;
            case 2:
                this.kzf.setSelected(z);
                return;
            case 3:
                this.kzg.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kzl != null) {
            int id = view.getId();
            this.kzm = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.kzl.cPm();
                anVar.Z("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.kzl.cPn();
                anVar.Z("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.kzl.cPo();
                anVar.Z("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.kzl.cPp();
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.kzl = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Dw(int i) {
        if (i == 1) {
            this.kzd.setImageResource(R.drawable.icon_video_music);
        } else {
            this.kzd.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
