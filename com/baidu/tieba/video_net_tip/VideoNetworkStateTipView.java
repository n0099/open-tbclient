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
import d.a.n0.r3.f;
/* loaded from: classes5.dex */
public class VideoNetworkStateTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21503e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21504f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21505g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21506h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f21507i;

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
            d.a.m0.l.a.u(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.f21503e = 3;
        this.f21507i = new a();
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
        this.f21504f = (TextView) findViewById(R.id.play);
        TextView textView = (TextView) findViewById(R.id.free_flow);
        this.f21505g = textView;
        textView.setOnClickListener(new b());
        this.f21506h = (TextView) findViewById(R.id.play_tips);
        e(TbadkApplication.getInst().getSkinType());
    }

    public boolean d() {
        return (a() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    public void e(int i2) {
        if (this.f21503e != i2) {
            this.f21503e = i2;
            SkinManager.setViewTextColor(this.f21504f, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21504f, R.drawable.rectangle_background_alpha80);
            SkinManager.setViewTextColor(this.f21505g, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21505g, R.drawable.blue_rectangle_background);
            SkinManager.setViewTextColor(this.f21506h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21506h, R.drawable.rectangle_background_alpha80);
        }
    }

    public void f() {
        setVisibility(0);
        this.f21504f.setVisibility(0);
        this.f21505g.setVisibility(0);
        this.f21506h.setVisibility(8);
    }

    public void g() {
        setVisibility(0);
        this.f21504f.setVisibility(8);
        this.f21505g.setVisibility(8);
        this.f21506h.setVisibility(0);
        e.a().removeCallbacks(this.f21507i);
        e.a().postDelayed(this.f21507i, 3000L);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f21504f.setOnClickListener(onClickListener);
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21503e = 3;
        this.f21507i = new a();
        c();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21503e = 3;
        this.f21507i = new a();
        c();
    }
}
