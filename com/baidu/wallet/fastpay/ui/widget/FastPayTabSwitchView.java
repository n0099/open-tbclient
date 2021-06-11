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
    public RelativeLayout f24171a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f24172b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24173c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24174d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24175e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24176f;

    /* renamed from: g  reason: collision with root package name */
    public a f24177g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24178h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24179i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public FastPayTabSwitchView(Context context) {
        super(context);
        this.f24178h = true;
        this.f24179i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public boolean isFirstSelected() {
        return this.f24178h;
    }

    public void setOnTabChangedListener(a aVar) {
        this.f24177g = aVar;
    }

    public void setTabChange(boolean z) {
        int color;
        int color2;
        TextView textView = this.f24174d;
        if (z) {
            color = ResUtils.getColor(getContext(), this.f24179i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        } else {
            color = ResUtils.getColor(getContext(), this.f24179i ? "bd_wallet_black" : "wallet_fp_main_color");
        }
        textView.setTextColor(color);
        this.f24176f.setVisibility(z ? 4 : 0);
        TextView textView2 = this.f24173c;
        if (z) {
            color2 = ResUtils.getColor(getContext(), this.f24179i ? "bd_wallet_black" : "wallet_fp_main_color");
        } else {
            color2 = ResUtils.getColor(getContext(), this.f24179i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        }
        textView2.setTextColor(color2);
        this.f24175e.setVisibility(z ? 0 : 4);
    }

    private void b() {
        this.f24171a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24171a;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24173c.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24172b;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24174d.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_MOBILE_TABCLICK);
                if (FastPayTabSwitchView.this.f24178h) {
                    return;
                }
                FastPayTabSwitchView.this.f24178h = true;
                FastPayTabSwitchView.this.setTabChange(true);
                if (FastPayTabSwitchView.this.f24177g != null) {
                    FastPayTabSwitchView.this.f24177g.a();
                }
            }
        });
        this.f24172b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24172b;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24174d.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24171a;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24173c.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_DATASTREAM_CLICK);
                if (FastPayTabSwitchView.this.f24178h) {
                    FastPayTabSwitchView.this.f24178h = false;
                    FastPayTabSwitchView.this.setTabChange(false);
                    if (FastPayTabSwitchView.this.f24177g != null) {
                        FastPayTabSwitchView.this.f24177g.b();
                    }
                }
            }
        });
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), this.f24179i ? "wallet_fp_tab_switch_baiduapp" : "wallet_fp_tab_switch"), this);
        this.f24171a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_fastpay"));
        this.f24172b = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_traffic"));
        this.f24174d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_tv"));
        this.f24176f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_line"));
        this.f24173c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_tv"));
        this.f24175e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_line"));
        setTabChange(this.f24178h);
        RelativeLayout relativeLayout = this.f24171a;
        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f24173c.getText()) + "已选中");
        RelativeLayout relativeLayout2 = this.f24172b;
        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f24174d.getText()) + "未选中");
        b();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24178h = true;
        this.f24179i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24178h = true;
        this.f24179i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }
}
