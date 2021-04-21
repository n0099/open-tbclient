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
    public RelativeLayout f24144a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f24145b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24146c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24147d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24148e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24149f;

    /* renamed from: g  reason: collision with root package name */
    public a f24150g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24151h;
    public boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public FastPayTabSwitchView(Context context) {
        super(context);
        this.f24151h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public boolean isFirstSelected() {
        return this.f24151h;
    }

    public void setOnTabChangedListener(a aVar) {
        this.f24150g = aVar;
    }

    public void setTabChange(boolean z) {
        int color;
        int color2;
        TextView textView = this.f24147d;
        if (z) {
            color = ResUtils.getColor(getContext(), this.i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        } else {
            color = ResUtils.getColor(getContext(), this.i ? "bd_wallet_black" : "wallet_fp_main_color");
        }
        textView.setTextColor(color);
        this.f24149f.setVisibility(z ? 4 : 0);
        TextView textView2 = this.f24146c;
        if (z) {
            color2 = ResUtils.getColor(getContext(), this.i ? "bd_wallet_black" : "wallet_fp_main_color");
        } else {
            color2 = ResUtils.getColor(getContext(), this.i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
        }
        textView2.setTextColor(color2);
        this.f24148e.setVisibility(z ? 0 : 4);
    }

    private void b() {
        this.f24144a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24144a;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24146c.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24145b;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24147d.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_MOBILE_TABCLICK);
                if (FastPayTabSwitchView.this.f24151h) {
                    return;
                }
                FastPayTabSwitchView.this.f24151h = true;
                FastPayTabSwitchView.this.setTabChange(true);
                if (FastPayTabSwitchView.this.f24150g != null) {
                    FastPayTabSwitchView.this.f24150g.a();
                }
            }
        });
        this.f24145b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RelativeLayout relativeLayout = FastPayTabSwitchView.this.f24145b;
                AccessibilityUtils.setContentDescription(relativeLayout, ((Object) FastPayTabSwitchView.this.f24147d.getText()) + "已选中");
                RelativeLayout relativeLayout2 = FastPayTabSwitchView.this.f24144a;
                AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) FastPayTabSwitchView.this.f24146c.getText()) + "未选中");
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_DATASTREAM_CLICK);
                if (FastPayTabSwitchView.this.f24151h) {
                    FastPayTabSwitchView.this.f24151h = false;
                    FastPayTabSwitchView.this.setTabChange(false);
                    if (FastPayTabSwitchView.this.f24150g != null) {
                        FastPayTabSwitchView.this.f24150g.b();
                    }
                }
            }
        });
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), this.i ? "wallet_fp_tab_switch_baiduapp" : "wallet_fp_tab_switch"), this);
        this.f24144a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_fastpay"));
        this.f24145b = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_traffic"));
        this.f24147d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_tv"));
        this.f24149f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_line"));
        this.f24146c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_tv"));
        this.f24148e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_line"));
        setTabChange(this.f24151h);
        RelativeLayout relativeLayout = this.f24144a;
        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f24146c.getText()) + "已选中");
        RelativeLayout relativeLayout2 = this.f24145b;
        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f24147d.getText()) + "未选中");
        b();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24151h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }

    public FastPayTabSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24151h = true;
        this.i = BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_KUANG);
        a();
    }
}
