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
/* loaded from: classes17.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView mDi;
    private ImageView mDj;
    private ImageView mDk;
    private ImageView mDl;
    private LinearLayout mDm;
    private LinearLayout mDn;
    private LinearLayout mDo;
    private LinearLayout mDp;
    private a mDq;
    private View mDr;

    /* loaded from: classes17.dex */
    public interface a {
        void dDN();

        void dDO();

        void dDP();

        void dDQ();
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
        this.mDm = (LinearLayout) findViewById(R.id.layout_music);
        this.mDn = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mDo = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mDp = (LinearLayout) findViewById(R.id.layout_filter);
        this.mDi = (ImageView) findViewById(R.id.img_music);
        this.mDj = (ImageView) findViewById(R.id.img_sticker);
        this.mDk = (ImageView) findViewById(R.id.img_beauty);
        this.mDl = (ImageView) findViewById(R.id.img_filter);
        this.mDi.setOnClickListener(this);
        this.mDj.setOnClickListener(this);
        this.mDk.setOnClickListener(this);
        this.mDl.setOnClickListener(this);
    }

    public void reset() {
        this.mDr = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mDm.setVisibility(i2);
                return;
            case 1:
                this.mDn.setVisibility(i2);
                return;
            case 2:
                this.mDo.setVisibility(i2);
                return;
            case 3:
                this.mDp.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mDi.setSelected(z);
                return;
            case 1:
                this.mDj.setSelected(z);
                return;
            case 2:
                this.mDk.setSelected(z);
                return;
            case 3:
                this.mDl.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mDq != null) {
            int id = view.getId();
            this.mDr = view;
            aq aqVar = new aq("c12495");
            if (id == R.id.img_music) {
                this.mDq.dDN();
                aqVar.ai("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mDq.dDO();
                aqVar.ai("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mDq.dDP();
                aqVar.ai("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mDq.dDQ();
                aqVar.ai("obj_type", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    public void setListener(a aVar) {
        this.mDq = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Jc(int i) {
        if (i == 1) {
            this.mDi.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mDi.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
