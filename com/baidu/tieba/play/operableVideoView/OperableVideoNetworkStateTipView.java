package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.f0.m.a;
import d.a.j0.r.f0.m.c;
import d.a.k0.q3.f;
/* loaded from: classes5.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f20041e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f20042f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20043g;

    /* renamed from: h  reason: collision with root package name */
    public String f20044h;

    public OperableVideoNetworkStateTipView(Context context) {
        super(context);
        c();
    }

    public void a(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20042f.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds62);
        } else {
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds52);
            layoutParams.topMargin = 0;
        }
        this.f20042f.setLayoutParams(layoutParams);
    }

    public boolean b() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public final void c() {
        LinearLayout.inflate(getContext(), getLayoutR(), this);
        this.f20041e = (TBSpecificationBtn) findViewById(R.id.play);
        this.f20042f = (TBSpecificationBtn) findViewById(R.id.free_flow);
        c cVar = new c();
        cVar.r();
        cVar.i(R.drawable.ic_icon_pure_video_play12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        cVar.g(l.g(getContext(), R.dimen.tbds32));
        this.f20041e.setText(getResources().getString(R.string.video_flow_play));
        this.f20041e.setTextSize(R.dimen.tbds36);
        this.f20041e.setConfig(cVar);
        a aVar = new a();
        this.f20042f.setText(getResources().getString(R.string.video_open_free_data));
        this.f20042f.setTextSize(R.dimen.tbds36);
        this.f20042f.setConfig(aVar);
        this.f20041e.setOnClickListener(this);
        this.f20042f.setOnClickListener(this);
        setOnClickListener(this);
    }

    public boolean d() {
        return (b() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.x()) ? false : true;
    }

    public int getLayoutR() {
        return R.layout.operable_video_network_state_tip;
    }

    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.free_flow) {
            d.a.j0.l.a.u(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        } else if (view.getId() == R.id.play) {
            setHasAgreeToPlay(true);
            View.OnClickListener onClickListener = this.f20043g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK).param("obj_locate", 2).param("tid", this.f20044h));
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.f20043g = onClickListener;
    }

    public void setTid(String str) {
        this.f20044h = str;
    }

    public void setVideoDuration(int i2) {
    }

    public void setVideoLength(long j) {
        if (j <= 0) {
            return;
        }
        this.f20041e.setText(String.format(getResources().getString(R.string.video_data), StringHelper.getFormatSize(j)));
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
