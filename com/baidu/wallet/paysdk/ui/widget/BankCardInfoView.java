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
    public TextView f26030a;

    /* renamed from: b  reason: collision with root package name */
    public DivisionEditText f26031b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26032c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26033d;

    /* renamed from: e  reason: collision with root package name */
    public View f26034e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26035f;

    /* renamed from: g  reason: collision with root package name */
    public View f26036g;

    /* renamed from: h  reason: collision with root package name */
    public String f26037h;
    public boolean i;

    public BankCardInfoView(Context context) {
        super(context);
        this.f26032c = true;
        this.f26037h = null;
        this.i = false;
        a();
    }

    public void ajustCompleteUi() {
        findViewById(ResUtils.id(getContext(), "line0")).setVisibility(0);
        findViewById(ResUtils.id(getContext(), "line2")).setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
    }

    public void configDetectCardNum(boolean z) {
        this.f26032c = z;
        this.f26035f.setImageResource(ResUtils.drawable(getContext(), z ? "wallet_base_camera_scan_btn_selector" : "wallet_base_delete"));
    }

    public DivisionEditText getCardNoView() {
        return this.f26031b;
    }

    public View getClearView() {
        return this.f26035f;
    }

    public String getScanCardNum() {
        return this.f26037h;
    }

    public View getTrueNameView() {
        return this.f26034e;
    }

    public void resetScanCardNum() {
        this.f26037h = null;
    }

    public void setBindcardTip(CharSequence charSequence) {
        if (this.f26030a != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f26030a.setVisibility(8);
                return;
            }
            this.f26030a.setVisibility(0);
            this.f26030a.setText(charSequence);
        }
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.f26036g.setOnClickListener(onClickListener);
    }

    public void setTipDel() {
        this.i = true;
        this.f26035f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
        AccessibilityUtils.setContentDescription(this.f26035f, "清除");
    }

    public void setTipScan() {
        this.i = false;
        this.f26035f.setVisibility(0);
        if (this.f26032c) {
            this.f26035f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_camera_scan_btn_selector"));
        } else if (!TextUtils.isEmpty(this.f26031b.getRealText())) {
            this.f26035f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
        } else {
            this.f26035f.setVisibility(4);
        }
        AccessibilityUtils.setContentDescription(this.f26035f, "扫描银行卡");
    }

    public void setTrueName(String str) {
        a(!TextUtils.isEmpty(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26033d.setText(str);
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
        this.f26030a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_tip"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "card_clear"));
        this.f26035f = imageView;
        AccessibilityUtils.setContentDescription(imageView, "扫描银行卡");
        this.f26034e = findViewById(ResUtils.id(getContext(), "card_true_name_area"));
        this.f26033d = (TextView) findViewById(ResUtils.id(getContext(), "card_true_name"));
        this.f26036g = findViewById(ResUtils.id(getContext(), "card_name_tip_img"));
        View findViewById = findViewById(ResUtils.id(getContext(), "card_area"));
        DivisionEditText divisionEditText = (DivisionEditText) findViewById.findViewById(ResUtils.id(getContext(), "ebpay_card_no_id"));
        this.f26031b = divisionEditText;
        divisionEditText.setUseSafeKeyBoard(true);
        this.f26031b.setViewType(25);
        this.f26031b.setTag(findViewById.findViewWithTag(ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag")));
        this.f26037h = null;
        ImageView imageView2 = this.f26035f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BankCardInfoView.this.i) {
                        BankCardInfoView.this.f26031b.setText("");
                    } else if (LocalRouter.getInstance(BankCardInfoView.this.getContext()).isProviderExisted("bankdetection") && BankCardInfoView.this.f26032c && !BankCardInfoView.this.b()) {
                        LocalRouter.getInstance(BankCardInfoView.this.getContext()).route(BankCardInfoView.this.getContext(), new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1.1
                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i, HashMap hashMap) {
                                if (i != 0) {
                                    if (i == 5) {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("provider", "bankdetection");
                                        hashMap2.put("action", "bankcarddetction");
                                        StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                                    }
                                } else if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                } else {
                                    BankCardInfoView.this.f26037h = (String) hashMap.get("card_num");
                                    if (BankCardInfoView.this.f26037h.equals(BankCardInfoView.this.f26031b.getRealText())) {
                                        return;
                                    }
                                    if (BankCardInfoView.this.getContext() instanceof BindCardImplActivity) {
                                        ((BindCardImplActivity) BankCardInfoView.this.getContext()).resetCardInfoState();
                                    }
                                    BankCardInfoView.this.f26031b.setText(BankCardInfoView.this.f26037h);
                                    try {
                                        BankCardInfoView.this.f26031b.setSelection(BankCardInfoView.this.f26031b.getText().toString().length());
                                        BankCardInfoView.this.f26031b.requestFocus();
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
        this.f26032c = true;
        this.f26037h = null;
        this.i = false;
        a();
    }

    public BankCardInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26032c = true;
        this.f26037h = null;
        this.i = false;
        a();
    }

    private void a(boolean z) {
        this.f26034e.setVisibility(!z ? 8 : 0);
    }
}
