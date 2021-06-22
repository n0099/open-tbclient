package com.baidu.tieba.video_net_tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.c.e.p.j;
import d.a.o0.r3.f;
/* loaded from: classes5.dex */
public class VideoNetworkStateTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21585e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21586f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21587g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21588h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f21589i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoNetworkStateTipView.this.b();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.l.a.u(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.f21585e = 3;
        this.f21589i = new a();
        c();
    }

    public boolean a() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void b() {
        setVisibility(8);
    }

    public final void c() {
        RelativeLayout.inflate(getContext(), R.layout.video_network_state_tip, this);
        this.f21586f = (TextView) findViewById(R.id.play);
        TextView textView = (TextView) findViewById(R.id.free_flow);
        this.f21587g = textView;
        textView.setOnClickListener(new b());
        this.f21588h = (TextView) findViewById(R.id.play_tips);
        e(TbadkApplication.getInst().getSkinType());
    }

    public boolean d() {
        return (a() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    public void e(int i2) {
        if (this.f21585e != i2) {
            this.f21585e = i2;
            SkinManager.setViewTextColor(this.f21586f, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21586f, R.drawable.rectangle_background_alpha80);
            SkinManager.setViewTextColor(this.f21587g, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21587g, R.drawable.blue_rectangle_background);
            SkinManager.setViewTextColor(this.f21588h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21588h, R.drawable.rectangle_background_alpha80);
        }
    }

    public void f() {
        setVisibility(0);
        this.f21586f.setVisibility(0);
        this.f21587g.setVisibility(0);
        this.f21588h.setVisibility(8);
    }

    public void g() {
        setVisibility(0);
        this.f21586f.setVisibility(8);
        this.f21587g.setVisibility(8);
        this.f21588h.setVisibility(0);
        e.a().removeCallbacks(this.f21589i);
        e.a().postDelayed(this.f21589i, 3000L);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f21586f.setOnClickListener(onClickListener);
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21585e = 3;
        this.f21589i = new a();
        c();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21585e = 3;
        this.f21589i = new a();
        c();
    }
}
