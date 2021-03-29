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
import d.b.b.e.m.e;
import d.b.b.e.p.j;
import d.b.i0.p3.f;
/* loaded from: classes5.dex */
public class VideoNetworkStateTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21921e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21922f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21923g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21924h;
    public Runnable i;

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
            d.b.h0.l.a.u(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.f21921e = 3;
        this.i = new a();
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
        this.f21922f = (TextView) findViewById(R.id.play);
        TextView textView = (TextView) findViewById(R.id.free_flow);
        this.f21923g = textView;
        textView.setOnClickListener(new b());
        this.f21924h = (TextView) findViewById(R.id.play_tips);
        e(TbadkApplication.getInst().getSkinType());
    }

    public boolean d() {
        return (a() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    public void e(int i) {
        if (this.f21921e != i) {
            this.f21921e = i;
            SkinManager.setViewTextColor(this.f21922f, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21922f, R.drawable.rectangle_background_alpha80);
            SkinManager.setViewTextColor(this.f21923g, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21923g, R.drawable.blue_rectangle_background);
            SkinManager.setViewTextColor(this.f21924h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21924h, R.drawable.rectangle_background_alpha80);
        }
    }

    public void f() {
        setVisibility(0);
        this.f21922f.setVisibility(0);
        this.f21923g.setVisibility(0);
        this.f21924h.setVisibility(8);
    }

    public void g() {
        setVisibility(0);
        this.f21922f.setVisibility(8);
        this.f21923g.setVisibility(8);
        this.f21924h.setVisibility(0);
        e.a().removeCallbacks(this.i);
        e.a().postDelayed(this.i, 3000L);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f21922f.setOnClickListener(onClickListener);
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21921e = 3;
        this.i = new a();
        c();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21921e = 3;
        this.i = new a();
        c();
    }
}
