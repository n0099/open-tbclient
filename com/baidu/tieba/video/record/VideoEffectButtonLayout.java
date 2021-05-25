package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.n0.r3.m.i;
/* loaded from: classes5.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, i.b {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21375e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21376f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21377g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21378h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f21379i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public a m;
    public View n;

    /* loaded from: classes5.dex */
    public interface a {
        void onClickBeauty();

        void onClickFilter();

        void onClickMusic();

        void onClickSticker();
    }

    public VideoEffectButtonLayout(Context context) {
        super(context);
        b();
    }

    @Override // d.a.n0.r3.m.i.b
    public void a(int i2) {
        if (i2 == 1) {
            this.f21375e.setImageResource(R.drawable.icon_video_music);
        } else {
            this.f21375e.setImageResource(R.drawable.icon_video_music_disable);
        }
    }

    public final void b() {
        LinearLayout.inflate(getContext(), R.layout.layout_video_effect_button, this);
        this.f21379i = (LinearLayout) findViewById(R.id.layout_music);
        this.j = (LinearLayout) findViewById(R.id.layout_sticker);
        this.k = (LinearLayout) findViewById(R.id.layout_beauty);
        this.l = (LinearLayout) findViewById(R.id.layout_filter);
        this.f21375e = (ImageView) findViewById(R.id.img_music);
        this.f21376f = (ImageView) findViewById(R.id.img_sticker);
        this.f21377g = (ImageView) findViewById(R.id.img_beauty);
        this.f21378h = (ImageView) findViewById(R.id.img_filter);
        this.f21375e.setOnClickListener(this);
        this.f21376f.setOnClickListener(this);
        this.f21377g.setOnClickListener(this);
        this.f21378h.setOnClickListener(this);
    }

    public void c() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == null) {
            return;
        }
        int id = view.getId();
        this.n = view;
        StatisticItem statisticItem = new StatisticItem("c12495");
        if (id == R.id.img_music) {
            this.m.onClickMusic();
            statisticItem.param("obj_type", 6);
        } else if (id == R.id.img_sticker) {
            this.m.onClickSticker();
            statisticItem.param("obj_type", 4);
        } else if (id == R.id.img_beauty) {
            this.m.onClickBeauty();
            statisticItem.param("obj_type", 3);
        } else if (id == R.id.img_filter) {
            this.m.onClickFilter();
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void setListener(a aVar) {
        this.m = aVar;
    }

    public void setViewChoosed(int i2, boolean z) {
        if (i2 == 0) {
            this.f21375e.setSelected(z);
        } else if (i2 == 1) {
            this.f21376f.setSelected(z);
        } else if (i2 == 2) {
            this.f21377g.setSelected(z);
        } else if (i2 != 3) {
        } else {
            this.f21378h.setSelected(z);
        }
    }

    public void setViewVisibility(int i2, int i3) {
        if (i2 == 0) {
            this.f21379i.setVisibility(i3);
        } else if (i2 == 1) {
            this.j.setVisibility(i3);
        } else if (i2 == 2) {
            this.k.setVisibility(i3);
        } else if (i2 != 3) {
        } else {
            this.l.setVisibility(i3);
        }
    }

    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
