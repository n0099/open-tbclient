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
/* loaded from: classes7.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView nVk;
    private ImageView nVl;
    private ImageView nVm;
    private ImageView nVn;
    private LinearLayout nVo;
    private LinearLayout nVp;
    private LinearLayout nVq;
    private LinearLayout nVr;
    private a nVs;
    private View nVt;

    /* loaded from: classes7.dex */
    public interface a {
        void dUK();

        void dUL();

        void dUM();

        void dUN();
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
        this.nVo = (LinearLayout) findViewById(R.id.layout_music);
        this.nVp = (LinearLayout) findViewById(R.id.layout_sticker);
        this.nVq = (LinearLayout) findViewById(R.id.layout_beauty);
        this.nVr = (LinearLayout) findViewById(R.id.layout_filter);
        this.nVk = (ImageView) findViewById(R.id.img_music);
        this.nVl = (ImageView) findViewById(R.id.img_sticker);
        this.nVm = (ImageView) findViewById(R.id.img_beauty);
        this.nVn = (ImageView) findViewById(R.id.img_filter);
        this.nVk.setOnClickListener(this);
        this.nVl.setOnClickListener(this);
        this.nVm.setOnClickListener(this);
        this.nVn.setOnClickListener(this);
    }

    public void reset() {
        this.nVt = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.nVo.setVisibility(i2);
                return;
            case 1:
                this.nVp.setVisibility(i2);
                return;
            case 2:
                this.nVq.setVisibility(i2);
                return;
            case 3:
                this.nVr.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.nVk.setSelected(z);
                return;
            case 1:
                this.nVl.setSelected(z);
                return;
            case 2:
                this.nVm.setSelected(z);
                return;
            case 3:
                this.nVn.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nVs != null) {
            int id = view.getId();
            this.nVt = view;
            ar arVar = new ar("c12495");
            if (id == R.id.img_music) {
                this.nVs.dUK();
                arVar.aq("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.nVs.dUL();
                arVar.aq("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.nVs.dUM();
                arVar.aq("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.nVs.dUN();
                arVar.aq("obj_type", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    public void setListener(a aVar) {
        this.nVs = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void KR(int i) {
        if (i == 1) {
            this.nVk.setImageResource(R.drawable.icon_video_music);
        } else {
            this.nVk.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
