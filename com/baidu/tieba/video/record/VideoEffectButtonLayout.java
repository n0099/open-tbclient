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
    private ImageView mdK;
    private ImageView mdL;
    private ImageView mdM;
    private ImageView mdN;
    private LinearLayout mdO;
    private LinearLayout mdP;
    private LinearLayout mdQ;
    private LinearLayout mdR;
    private a mdS;
    private View mdT;

    /* loaded from: classes10.dex */
    public interface a {
        void doV();

        void doW();

        void doX();

        void doY();
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
        this.mdO = (LinearLayout) findViewById(R.id.layout_music);
        this.mdP = (LinearLayout) findViewById(R.id.layout_sticker);
        this.mdQ = (LinearLayout) findViewById(R.id.layout_beauty);
        this.mdR = (LinearLayout) findViewById(R.id.layout_filter);
        this.mdK = (ImageView) findViewById(R.id.img_music);
        this.mdL = (ImageView) findViewById(R.id.img_sticker);
        this.mdM = (ImageView) findViewById(R.id.img_beauty);
        this.mdN = (ImageView) findViewById(R.id.img_filter);
        this.mdK.setOnClickListener(this);
        this.mdL.setOnClickListener(this);
        this.mdM.setOnClickListener(this);
        this.mdN.setOnClickListener(this);
    }

    public void reset() {
        this.mdT = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.mdO.setVisibility(i2);
                return;
            case 1:
                this.mdP.setVisibility(i2);
                return;
            case 2:
                this.mdQ.setVisibility(i2);
                return;
            case 3:
                this.mdR.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.mdK.setSelected(z);
                return;
            case 1:
                this.mdL.setSelected(z);
                return;
            case 2:
                this.mdM.setSelected(z);
                return;
            case 3:
                this.mdN.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mdS != null) {
            int id = view.getId();
            this.mdT = view;
            ao aoVar = new ao("c12495");
            if (id == R.id.img_music) {
                this.mdS.doV();
                aoVar.ag("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.mdS.doW();
                aoVar.ag("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.mdS.doX();
                aoVar.ag("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.mdS.doY();
                aoVar.ag("obj_type", 2);
            }
            TiebaStatic.log(aoVar);
        }
    }

    public void setListener(a aVar) {
        this.mdS = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Gk(int i) {
        if (i == 1) {
            this.mdK.setImageResource(R.drawable.icon_video_music);
        } else {
            this.mdK.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
