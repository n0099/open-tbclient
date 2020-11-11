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
/* loaded from: classes23.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nuY;
    private ImageView nuZ;
    private ImageView nva;
    private ImageView nvb;
    private LinearLayout nvc;
    private LinearLayout nvd;
    private LinearLayout nve;
    private LinearLayout nvf;
    private a nvg;
    private View nvh;

    /* loaded from: classes23.dex */
    public interface a {
        void dRd();

        void dRe();

        void dRf();

        void dRg();
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
        this.nvc = (LinearLayout) findViewById(R.id.layout_music);
        this.nvd = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nve = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nvf = (LinearLayout) findViewById(R.id.layout_filter);
        this.nuY = (ImageView) findViewById(R.id.img_music);
        this.nuZ = (ImageView) findViewById(R.id.img_sticker);
        this.nva = (ImageView) findViewById(R.id.img_beauty);
        this.nvb = (ImageView) findViewById(R.id.img_filter);
        this.nuY.setOnClickListener(this);
        this.nuZ.setOnClickListener(this);
        this.nva.setOnClickListener(this);
        this.nvb.setOnClickListener(this);
    }

    public void reset() {
        this.nvh = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nvc.setVisibility(i2);
                return;
            case 1:
                this.nvd.setVisibility(i2);
                return;
            case 2:
                this.nve.setVisibility(i2);
                return;
            case 3:
                this.nvf.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nuY.setSelected(z);
                return;
            case 1:
                this.nuZ.setSelected(z);
                return;
            case 2:
                this.nva.setSelected(z);
                return;
            case 3:
                this.nvb.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nvg != null) {
            int id = view.getId();
            this.nvh = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.nvg.dRd();
                aqVar.al("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nvg.dRe();
                aqVar.al("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nvg.dRf();
                aqVar.al("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nvg.dRg();
                aqVar.al("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.nvg = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KR(int i) {
        if (i == 1) {
            this.nuY.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nuY.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
