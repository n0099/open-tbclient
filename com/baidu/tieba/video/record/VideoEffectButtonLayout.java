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
/* loaded from: classes10.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.a {
    private ImageView lIL;
    private ImageView lIM;
    private ImageView lIN;
    private ImageView lIO;
    private LinearLayout lIP;
    private LinearLayout lIQ;
    private LinearLayout lIR;
    private LinearLayout lIS;
    private a lIT;
    private View lIU;

    /* loaded from: classes10.dex */
    public interface a {
        void dku();

        void dkv();

        void dkw();

        void dkx();
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
        this.lIP = (LinearLayout) findViewById(R.id.layout_music);
        this.lIQ = (LinearLayout) findViewById(R.id.layout_sticker);
        this.lIR = (LinearLayout) findViewById(R.id.layout_beauty);
        this.lIS = (LinearLayout) findViewById(R.id.layout_filter);
        this.lIL = (ImageView) findViewById(R.id.img_music);
        this.lIM = (ImageView) findViewById(R.id.img_sticker);
        this.lIN = (ImageView) findViewById(R.id.img_beauty);
        this.lIO = (ImageView) findViewById(R.id.img_filter);
        this.lIL.setOnClickListener(this);
        this.lIM.setOnClickListener(this);
        this.lIN.setOnClickListener(this);
        this.lIO.setOnClickListener(this);
    }

    public void reset() {
        this.lIU = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.lIP.setVisibility(i2);
                return;
            case 1:
                this.lIQ.setVisibility(i2);
                return;
            case 2:
                this.lIR.setVisibility(i2);
                return;
            case 3:
                this.lIS.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.lIL.setSelected(z);
                return;
            case 1:
                this.lIM.setSelected(z);
                return;
            case 2:
                this.lIN.setSelected(z);
                return;
            case 3:
                this.lIO.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lIT != null) {
            int id = view.getId();
            this.lIU = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.lIT.dku();
                anVar.ag("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.lIT.dkv();
                anVar.ag("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.lIT.dkw();
                anVar.ag("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.lIT.dkx();
                anVar.ag("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.lIT = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Ff(int i) {
        if (i == 1) {
            this.lIL.setImageResource(R.drawable.icon_video_music);
        } else {
            this.lIL.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
