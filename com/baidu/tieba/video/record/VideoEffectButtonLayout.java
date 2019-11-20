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
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private LinearLayout jFA;
    private LinearLayout jFB;
    private a jFC;
    private View jFD;
    private ImageView jFu;
    private ImageView jFv;
    private ImageView jFw;
    private ImageView jFx;
    private LinearLayout jFy;
    private LinearLayout jFz;

    /* loaded from: classes5.dex */
    public interface a {
        void cvv();

        void cvw();

        void cvx();

        void cvy();
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
        this.jFy = (LinearLayout) findViewById(R.id.layout_music);
        this.jFz = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jFA = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jFB = (LinearLayout) findViewById(R.id.layout_filter);
        this.jFu = (ImageView) findViewById(R.id.img_music);
        this.jFv = (ImageView) findViewById(R.id.img_sticker);
        this.jFw = (ImageView) findViewById(R.id.img_beauty);
        this.jFx = (ImageView) findViewById(R.id.img_filter);
        this.jFu.setOnClickListener(this);
        this.jFv.setOnClickListener(this);
        this.jFw.setOnClickListener(this);
        this.jFx.setOnClickListener(this);
    }

    public void reset() {
        this.jFD = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jFy.setVisibility(i2);
                return;
            case 1:
                this.jFz.setVisibility(i2);
                return;
            case 2:
                this.jFA.setVisibility(i2);
                return;
            case 3:
                this.jFB.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jFu.setSelected(z);
                return;
            case 1:
                this.jFv.setSelected(z);
                return;
            case 2:
                this.jFw.setSelected(z);
                return;
            case 3:
                this.jFx.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jFC != null) {
            int id = view.getId();
            this.jFD = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.jFC.cvv();
                anVar.O("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jFC.cvw();
                anVar.O("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jFC.cvx();
                anVar.O("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jFC.cvy();
                anVar.O("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.jFC = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Bb(int i) {
        if (i == 1) {
            this.jFu.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jFu.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
