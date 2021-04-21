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
import d.b.c.e.m.e;
import d.b.c.e.p.j;
import d.b.j0.q3.f;
/* loaded from: classes5.dex */
public class VideoNetworkStateTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21614e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21615f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21616g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21617h;
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
            d.b.i0.l.a.u(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.f21614e = 3;
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
        this.f21615f = (TextView) findViewById(R.id.play);
        TextView textView = (TextView) findViewById(R.id.free_flow);
        this.f21616g = textView;
        textView.setOnClickListener(new b());
        this.f21617h = (TextView) findViewById(R.id.play_tips);
        e(TbadkApplication.getInst().getSkinType());
    }

    public boolean d() {
        return (a() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    public void e(int i) {
        if (this.f21614e != i) {
            this.f21614e = i;
            SkinManager.setViewTextColor(this.f21615f, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21615f, R.drawable.rectangle_background_alpha80);
            SkinManager.setViewTextColor(this.f21616g, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21616g, R.drawable.blue_rectangle_background);
            SkinManager.setViewTextColor(this.f21617h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f21617h, R.drawable.rectangle_background_alpha80);
        }
    }

    public void f() {
        setVisibility(0);
        this.f21615f.setVisibility(0);
        this.f21616g.setVisibility(0);
        this.f21617h.setVisibility(8);
    }

    public void g() {
        setVisibility(0);
        this.f21615f.setVisibility(8);
        this.f21616g.setVisibility(8);
        this.f21617h.setVisibility(0);
        e.a().removeCallbacks(this.i);
        e.a().postDelayed(this.i, 3000L);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f21615f.setOnClickListener(onClickListener);
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21614e = 3;
        this.i = new a();
        c();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21614e = 3;
        this.i = new a();
        c();
    }
}
