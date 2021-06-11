package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class BankCardInfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26109a;

    /* renamed from: b  reason: collision with root package name */
    public DivisionEditText f26110b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26111c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26112d;

    /* renamed from: e  reason: collision with root package name */
    public View f26113e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26114f;

    /* renamed from: g  reason: collision with root package name */
    public View f26115g;

    /* renamed from: h  reason: collision with root package name */
    public String f26116h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26117i;

    public BankCardInfoView(Context context) {
        super(context);
        this.f26111c = true;
        this.f26116h = null;
        this.f26117i = false;
        a();
    }

    public void ajustCompleteUi() {
        findViewById(ResUtils.id(getContext(), "line0")).setVisibility(0);
        findViewById(ResUtils.id(getContext(), "line2")).setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
    }

    public void configDetectCardNum(boolean z) {
        this.f26111c = z;
        this.f26114f.setImageResource(ResUtils.drawable(getContext(), z ? "wallet_base_camera_scan_btn_selector" : "wallet_base_delete"));
    }

    public DivisionEditText getCardNoView() {
        return this.f26110b;
    }

    public View getClearView() {
        return this.f26114f;
    }

    public String getScanCardNum() {
        return this.f26116h;
    }

    public View getTrueNameView() {
        return this.f26113e;
    }

    public void resetScanCardNum() {
        this.f26116h = null;
    }

    public void setBindcardTip(CharSequence charSequence) {
        if (this.f26109a != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f26109a.setVisibility(8);
                return;
            }
            this.f26109a.setVisibility(0);
            this.f26109a.setText(charSequence);
        }
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.f26115g.setOnClickListener(onClickListener);
    }

    public void setTipDel() {
        this.f26117i = true;
        this.f26114f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
        AccessibilityUtils.setContentDescription(this.f26114f, "清除");
    }

    public void setTipScan() {
        this.f26117i = false;
        this.f26114f.setVisibility(0);
        if (this.f26111c) {
            this.f26114f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_camera_scan_btn_selector"));
        } else if (!TextUtils.isEmpty(this.f26110b.getRealText())) {
            this.f26114f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
        } else {
            this.f26114f.setVisibility(4);
        }
        AccessibilityUtils.setContentDescription(this.f26114f, "扫描银行卡");
    }

    public void setTrueName(String str) {
        a(!TextUtils.isEmpty(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26112d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    public boolean b() {
        if (Build.VERSION.SDK_INT >= 24 && (getContext() instanceof Activity) && ((Activity) getContext()).isInMultiWindowMode()) {
            GlobalUtils.toast(getContext(), ResUtils.getString(getContext(), "wallet_base_multi_window_close"), -1, 1);
            return true;
        }
        return false;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_cardinfo_view"), this);
        this.f26109a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_tip"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "card_clear"));
        this.f26114f = imageView;
        AccessibilityUtils.setContentDescription(imageView, "扫描银行卡");
        this.f26113e = findViewById(ResUtils.id(getContext(), "card_true_name_area"));
        this.f26112d = (TextView) findViewById(ResUtils.id(getContext(), "card_true_name"));
        this.f26115g = findViewById(ResUtils.id(getContext(), "card_name_tip_img"));
        View findViewById = findViewById(ResUtils.id(getContext(), "card_area"));
        DivisionEditText divisionEditText = (DivisionEditText) findViewById.findViewById(ResUtils.id(getContext(), "ebpay_card_no_id"));
        this.f26110b = divisionEditText;
        divisionEditText.setUseSafeKeyBoard(true);
        this.f26110b.setViewType(25);
        this.f26110b.setTag(findViewById.findViewWithTag(ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag")));
        this.f26116h = null;
        ImageView imageView2 = this.f26114f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BankCardInfoView.this.f26117i) {
                        BankCardInfoView.this.f26110b.setText("");
                    } else if (LocalRouter.getInstance(BankCardInfoView.this.getContext()).isProviderExisted("bankdetection") && BankCardInfoView.this.f26111c && !BankCardInfoView.this.b()) {
                        LocalRouter.getInstance(BankCardInfoView.this.getContext()).route(BankCardInfoView.this.getContext(), new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1.1
                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i2, HashMap hashMap) {
                                if (i2 != 0) {
                                    if (i2 == 5) {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("provider", "bankdetection");
                                        hashMap2.put("action", "bankcarddetction");
                                        StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                                    }
                                } else if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                } else {
                                    BankCardInfoView.this.f26116h = (String) hashMap.get("card_num");
                                    if (BankCardInfoView.this.f26116h.equals(BankCardInfoView.this.f26110b.getRealText())) {
                                        return;
                                    }
                                    if (BankCardInfoView.this.getContext() instanceof BindCardImplActivity) {
                                        ((BindCardImplActivity) BankCardInfoView.this.getContext()).resetCardInfoState();
                                    }
                                    BankCardInfoView.this.f26110b.setText(BankCardInfoView.this.f26116h);
                                    try {
                                        BankCardInfoView.this.f26110b.setSelection(BankCardInfoView.this.f26110b.getText().toString().length());
                                        BankCardInfoView.this.f26110b.requestFocus();
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public BankCardInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26111c = true;
        this.f26116h = null;
        this.f26117i = false;
        a();
    }

    public BankCardInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26111c = true;
        this.f26116h = null;
        this.f26117i = false;
        a();
    }

    private void a(boolean z) {
        this.f26113e.setVisibility(!z ? 8 : 0);
    }
}
