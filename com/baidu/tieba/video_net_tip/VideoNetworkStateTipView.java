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
import d.a.j0.q3.f;
/* loaded from: classes5.dex */
public class VideoNetworkStateTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22252e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22253f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22254g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22255h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f22256i;

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
            d.a.i0.l.a.u(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        }
    }

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.f22252e = 3;
        this.f22256i = new a();
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
        this.f22253f = (TextView) findViewById(R.id.play);
        TextView textView = (TextView) findViewById(R.id.free_flow);
        this.f22254g = textView;
        textView.setOnClickListener(new b());
        this.f22255h = (TextView) findViewById(R.id.play_tips);
        e(TbadkApplication.getInst().getSkinType());
    }

    public boolean d() {
        return (a() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    public void e(int i2) {
        if (this.f22252e != i2) {
            this.f22252e = i2;
            SkinManager.setViewTextColor(this.f22253f, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f22253f, R.drawable.rectangle_background_alpha80);
            SkinManager.setViewTextColor(this.f22254g, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f22254g, R.drawable.blue_rectangle_background);
            SkinManager.setViewTextColor(this.f22255h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f22255h, R.drawable.rectangle_background_alpha80);
        }
    }

    public void f() {
        setVisibility(0);
        this.f22253f.setVisibility(0);
        this.f22254g.setVisibility(0);
        this.f22255h.setVisibility(8);
    }

    public void g() {
        setVisibility(0);
        this.f22253f.setVisibility(8);
        this.f22254g.setVisibility(8);
        this.f22255h.setVisibility(0);
        e.a().removeCallbacks(this.f22256i);
        e.a().postDelayed(this.f22256i, 3000L);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f22253f.setOnClickListener(onClickListener);
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22252e = 3;
        this.f22256i = new a();
        c();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22252e = 3;
        this.f22256i = new a();
        c();
    }
}
