package com.baidu.wallet.fastpay.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.utils.AccessibilityUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class FastPayTabSwitchView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f24136a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f24137b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24138c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24139d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24140e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24141f;

    /* renamed from: g  reason: collision with root package name */
    public a f24142g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24143h;
    public boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public FastPayTabSwitchView(Context context) {
        super(context);
        this.f24143h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public boolean isFirstSelected() {
        return this.f24143h;
    }

    public void setOnTabChangedListener(a aVar) {
        this.f24142g = aVar;
    }

    public void setTabChange(boolean z) {
        int color;
        int color2;
        TextView textView = this.f24139d;
        if (z) {
            color = ResUtils.getColor(getContext(), this.i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        } else {
            color = ResUtils.getColor(getContext(), this.i ? "bd_wallet_black" : "wallet_fp_main_color");
        }
        textView.setTextColor(color);
        this.f24141f.setVisibility(z ? 4 : 0);
        TextView textView2 = this.f24138c;
        if (z) {
            color2 = ResUtils.getColor(getContext(), this.i ? "bd_wallet_black" : "wallet_fp_main_color");
        } else {
            color2 = ResUtils.getColor(getContext(), this.i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        }
        textView2.setTextColor(color2);
        this.f24140e.setVisibility(z ? 0 : 4);
    }

    private void b() {
        this.f24136a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24136a;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24138c.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24137b;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24139d.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_MOBILE_TABCLICK);
                if (FastPayTabSwitchView.this.f24143h) {
                    return;
                }
                FastPayTabSwitchView.this.f24143h = true;
                FastPayTabSwitchView.this.setTabChange(true);
                if (FastPayTabSwitchView.this.f24142g != null) {
                    FastPayTabSwitchView.this.f24142g.a();
                }
            }
        });
        this.f24137b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24137b;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24139d.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24136a;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24138c.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_DATASTREAM_CLICK);
                if (FastPayTabSwitchView.this.f24143h) {
                    FastPayTabSwitchView.this.f24143h = false;
                    FastPayTabSwitchView.this.setTabChange(false);
                    if (FastPayTabSwitchView.this.f24142g != null) {
                        FastPayTabSwitchView.this.f24142g.b();
                    }
                }
            }
        });
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), this.i ? "wallet_fp_tab_switch_baiduapp" : "wallet_fp_tab_switch"), this);
        this.f24136a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_fastpay"));
        this.f24137b = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_traffic"));
        this.f24139d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_tv"));
        this.f24141f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_line"));
        this.f24138c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_tv"));
        this.f24140e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_line"));
        setTabChange(this.f24143h);
        RelativeLayout relativeLayout = this.f24136a;
        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f24138c.getText()) + "已选中");
        RelativeLayout relativeLayout2 = this.f24137b;
        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f24139d.getText()) + "未选中");
        b();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24143h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24143h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }
}
