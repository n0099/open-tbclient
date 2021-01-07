package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.bankdetection.BCResult;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class BankCardResultActivity extends DxmPayBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5927a = BankCardResultActivity.class.getSimpleName();
    private static Pattern i = Pattern.compile("\\d{1,20}");

    /* renamed from: b  reason: collision with root package name */
    private TextView f5928b;
    private View c;
    private View d;
    private SafeScrollView e;
    private SafeKeyBoardEditText[] f;
    private String[] g;
    private BCResult h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        EventBus.getInstance().registerSticky(this, "BankCardResult", 0, EventBus.ThreadMode.MainThread);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.f5928b == view || ResUtils.id(getActivity(), "dialog_title_close") == id) {
            String charSequence = b().toString();
            if (this.f5928b == view) {
                PayStatisticsUtil.onEvent("takephotoClickNext");
                BankcardDetectionController.getInstance().update(null, charSequence);
                setResult(1243, null);
                finish();
                overridePendingTransition(0, 0);
            } else if (this.c == view) {
                PayStatisticsUtil.onEvent("cancelBankCardDetectionPopView");
                setResult(1244, null);
                finish();
                overridePendingTransition(0, 0);
            }
        }
    }

    private CharSequence b() {
        StringBuilder sb = new StringBuilder();
        if (this.f == null || this.f.length == 0 || this.g == null || this.g.length == 0) {
            return sb;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.f.length; i2++) {
            String obj = this.f[i2].getText().toString();
            sb.append(obj);
            if (!z) {
                z = !obj.equals(this.g[i2]);
            }
        }
        if (z) {
            PayStatisticsUtil.onEvent("#takephotoNumchange");
        }
        return sb;
    }

    public void onBackPressed() {
        b();
        setResult(1244, null);
        finish();
        overridePendingTransition(0, 0);
    }

    public void onResume() {
        SafeKeyBoardEditText[] safeKeyBoardEditTextArr;
        super.onResume();
        if (this.f != null && this.e != null) {
            for (SafeKeyBoardEditText safeKeyBoardEditText : this.f) {
                if (safeKeyBoardEditText.isFocused()) {
                    this.e.showKeyBoard(this.e, safeKeyBoardEditText, this.d);
                    return;
                }
            }
        }
    }

    public void onDestroy() {
        EventBus.getInstance().unregister(this, "BankCardResult");
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (!"BankCardResult".equals(event.mEventKey)) {
            LogUtil.e(f5927a, "invalid bankcad result key", (Throwable) null);
            finish();
            overridePendingTransition(0, 0);
        }
        this.h = (BCResult) event.mEventObj;
        getWindow().setSoftInputMode(2);
        Activity activity = getActivity();
        this.e = LayoutInflater.from(activity).inflate(ResUtils.layout(activity, "wallet_bankcard_detection_result"), (ViewGroup) null);
        setContentView(this.e);
        setSafeScrollView(this.e);
        this.e.post(new Runnable() { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.1
            @Override // java.lang.Runnable
            public void run() {
                BankCardResultActivity.this.c();
            }
        });
        this.f5928b = (TextView) findViewById(ResUtils.id(activity, "button_ok"));
        ((ImageView) this.e.findViewById(ResUtils.id(activity, "card_num_img"))).setImageBitmap(this.h.getDstRGBImage(false));
        this.g = this.h.cardNumberToString().split(" ");
        this.c = this.e.findViewById(ResUtils.id(activity, "dialog_title_close"));
        this.c.setOnClickListener(this);
        View findViewById = this.e.findViewById(ResUtils.id(activity, "button_ok"));
        findViewById.setOnClickListener(this);
        findViewById.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i2 = getWindowManager().getDefaultDisplay().getWidth() > 480 ? 16 : 13;
        Activity activity = getActivity();
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(ResUtils.id(activity, "card_num_sections"));
        this.d = this.e.findViewById(ResUtils.id(activity, "bcd_result_dlg"));
        InputFilter[] inputFilterArr = {new a()};
        int width = linearLayout.getWidth() / this.g.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, linearLayout.getHeight());
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((width * 3) / 4, 2);
        layoutParams3.gravity = 1;
        this.f = new SafeKeyBoardEditText[this.g.length];
        int color = ResUtils.color(activity, "bcd_gray3");
        final int color2 = ResUtils.getColor(activity, "bcd_color_n_underline");
        final int color3 = ResUtils.getColor(activity, "bcd_color_f_underline");
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.g.length) {
                this.f[i4] = new SafeKeyBoardEditText(activity);
                this.f[i4].initSafeKeyBoardParams(this.e, this.e, this.d, false);
                this.f[i4].setFilters(inputFilterArr);
                this.f[i4].setText(this.g[i4]);
                this.f[i4].setTextColor(color);
                this.f[i4].setInputType(3);
                this.f[i4].setSingleLine();
                this.f[i4].setBackgroundColor(0);
                this.f[i4].setTextSize(1, i2);
                this.f[i4].setLayoutParams(layoutParams2);
                LinearLayout linearLayout2 = new LinearLayout(activity);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.addView(this.f[i4]);
                final View view = new View(activity);
                view.setBackgroundColor(color2);
                view.setLayoutParams(layoutParams3);
                linearLayout2.addView(view);
                final View.OnFocusChangeListener onFocusChangeListener = this.f[i4].getOnFocusChangeListener();
                this.f[i4].setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.2
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view2, boolean z) {
                        if (onFocusChangeListener != null) {
                            onFocusChangeListener.onFocusChange(view2, z);
                        }
                        view.setBackgroundColor(z ? color3 : color2);
                    }
                });
                linearLayout.addView(linearLayout2);
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements InputFilter {
        a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (!TextUtils.isEmpty(charSequence) && !BankCardResultActivity.i.matcher(charSequence).matches()) {
                return "";
            }
            if (i2 - i > 20) {
                i2 = i + 20;
            }
            int a2 = a();
            int i5 = (i2 - i) - (i4 - i3);
            if (a2 + i5 > 20) {
                if (spanned.length() == 0) {
                    return null;
                }
                return "";
            }
            if (a2 + i5 > 10) {
                BankCardResultActivity.this.f5928b.setEnabled(true);
                BankCardResultActivity.this.f5928b.setTextColor(-1);
            } else {
                BankCardResultActivity.this.f5928b.setEnabled(false);
                BankCardResultActivity.this.f5928b.setTextColor(ResUtils.getColor(BankCardResultActivity.this.getActivity(), "bcd_disable_text"));
            }
            return charSequence.subSequence(i, i2);
        }

        private int a() {
            if (BankCardResultActivity.this.f == null) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < BankCardResultActivity.this.f.length; i++) {
                if (BankCardResultActivity.this.f[i] != null) {
                    sb.append(BankCardResultActivity.this.f[i].getText().toString());
                }
            }
            return sb.length();
        }
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }
}
