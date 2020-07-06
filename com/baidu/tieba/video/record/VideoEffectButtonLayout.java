package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.i;
/* loaded from: classes10.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView mdN;
    private ImageView mdO;
    private ImageView mdP;
    private ImageView mdQ;
    private LinearLayout mdR;
    private LinearLayout mdS;
    private LinearLayout mdT;
    private LinearLayout mdU;
    private a mdV;
    private View mdW;

    /* loaded from: classes10.dex */
    public interface a {
        void doZ();

        void dpa();

        void dpb();

        void dpc();
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
        this.mdR = (LinearLayout) findViewById(R.id.layout_music);
        this.mdS = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mdT = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mdU = (LinearLayout) findViewById(R.id.layout_filter);
        this.mdN = (ImageView) findViewById(R.id.img_music);
        this.mdO = (ImageView) findViewById(R.id.img_sticker);
        this.mdP = (ImageView) findViewById(R.id.img_beauty);
        this.mdQ = (ImageView) findViewById(R.id.img_filter);
        this.mdN.setOnClickListener(this);
        this.mdO.setOnClickListener(this);
        this.mdP.setOnClickListener(this);
        this.mdQ.setOnClickListener(this);
    }

    public void reset() {
        this.mdW = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mdR.setVisibility(i2);
                return;
            case 1:
                this.mdS.setVisibility(i2);
                return;
            case 2:
                this.mdT.setVisibility(i2);
                return;
            case 3:
                this.mdU.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mdN.setSelected(z);
                return;
            case 1:
                this.mdO.setSelected(z);
                return;
            case 2:
                this.mdP.setSelected(z);
                return;
            case 3:
                this.mdQ.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mdV != null) {
            int id = view.getId();
            this.mdW = view;
            ao aoVar = new ao("c12495");
            if (id == R.id.img_music) {
                this.mdV.doZ();
                aoVar.ag("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mdV.dpa();
                aoVar.ag("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mdV.dpb();
                aoVar.ag("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mdV.dpc();
                aoVar.ag("obj_type", 2);
            }
            TiebaStatic.log(aoVar);
        }
    }

    public void setListener(a aVar) {
        this.mdV = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Gk(int i) {
        if (i == 1) {
            this.mdN.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mdN.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
