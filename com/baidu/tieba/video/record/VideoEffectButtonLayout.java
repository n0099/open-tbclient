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
    private ImageView jGl;
    private ImageView jGm;
    private ImageView jGn;
    private ImageView jGo;
    private LinearLayout jGp;
    private LinearLayout jGq;
    private LinearLayout jGr;
    private LinearLayout jGs;
    private a jGt;
    private View jGu;

    /* loaded from: classes5.dex */
    public interface a {
        void cvA();

        void cvx();

        void cvy();

        void cvz();
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
        this.jGp = (LinearLayout) findViewById(R.id.layout_music);
        this.jGq = (LinearLayout) findViewById(R.id.layout_sticker);
        this.jGr = (LinearLayout) findViewById(R.id.layout_beauty);
        this.jGs = (LinearLayout) findViewById(R.id.layout_filter);
        this.jGl = (ImageView) findViewById(R.id.img_music);
        this.jGm = (ImageView) findViewById(R.id.img_sticker);
        this.jGn = (ImageView) findViewById(R.id.img_beauty);
        this.jGo = (ImageView) findViewById(R.id.img_filter);
        this.jGl.setOnClickListener(this);
        this.jGm.setOnClickListener(this);
        this.jGn.setOnClickListener(this);
        this.jGo.setOnClickListener(this);
    }

    public void reset() {
        this.jGu = null;
    }

    public void setViewVisibility(int i, int i2) {
        switch (i) {
            case 0:
                this.jGp.setVisibility(i2);
                return;
            case 1:
                this.jGq.setVisibility(i2);
                return;
            case 2:
                this.jGr.setVisibility(i2);
                return;
            case 3:
                this.jGs.setVisibility(i2);
                return;
            default:
                return;
        }
    }

    public void setViewChoosed(int i, boolean z) {
        switch (i) {
            case 0:
                this.jGl.setSelected(z);
                return;
            case 1:
                this.jGm.setSelected(z);
                return;
            case 2:
                this.jGn.setSelected(z);
                return;
            case 3:
                this.jGo.setSelected(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jGt != null) {
            int id = view.getId();
            this.jGu = view;
            an anVar = new an("c12495");
            if (id == R.id.img_music) {
                this.jGt.cvx();
                anVar.O("obj_type", 6);
            } else if (id == R.id.img_sticker) {
                this.jGt.cvy();
                anVar.O("obj_type", 4);
            } else if (id == R.id.img_beauty) {
                this.jGt.cvz();
                anVar.O("obj_type", 3);
            } else if (id == R.id.img_filter) {
                this.jGt.cvA();
                anVar.O("obj_type", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    public void setListener(a aVar) {
        this.jGt = aVar;
    }

    @Override // com.baidu.tieba.video.record.i.a
    public void Bc(int i) {
        if (i == 1) {
            this.jGl.setImageResource(R.drawable.icon_video_music);
        } else {
            this.jGl.setImageResource(R.drawable.icon_video_music_disable);
        }
    }
}
