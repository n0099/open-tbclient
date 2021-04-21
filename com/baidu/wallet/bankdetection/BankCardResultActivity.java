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
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class BankCardResultActivity extends DxmPayBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23190a = BankCardResultActivity.class.getSimpleName();
    public static Pattern i = Pattern.compile("\\d{1,20}");

    /* renamed from: b  reason: collision with root package name */
    public TextView f23191b;

    /* renamed from: c  reason: collision with root package name */
    public View f23192c;

    /* renamed from: d  reason: collision with root package name */
    public View f23193d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f23194e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText[] f23195f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f23196g;

    /* renamed from: h  reason: collision with root package name */
    public BCResult f23197h;

    /* loaded from: classes5.dex */
    public class a implements InputFilter {
        public a() {
        }

        private int a() {
            if (BankCardResultActivity.this.f23195f == null) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < BankCardResultActivity.this.f23195f.length; i++) {
                if (BankCardResultActivity.this.f23195f[i] != null) {
                    sb.append(BankCardResultActivity.this.f23195f[i].getText().toString());
                }
            }
            return sb.length();
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (TextUtils.isEmpty(charSequence) || BankCardResultActivity.i.matcher(charSequence).matches()) {
                if (i2 - i > 20) {
                    i2 = i + 20;
                }
                int a2 = a() + ((i2 - i) - (i4 - i3));
                if (a2 > 20) {
                    if (spanned.length() == 0) {
                        return null;
                    }
                    return "";
                }
                if (a2 > 10) {
                    BankCardResultActivity.this.f23191b.setEnabled(true);
                    BankCardResultActivity.this.f23191b.setTextColor(-1);
                } else {
                    BankCardResultActivity.this.f23191b.setEnabled(false);
                    BankCardResultActivity.this.f23191b.setTextColor(ResUtils.getColor(BankCardResultActivity.this.getActivity(), "bcd_disable_text"));
                }
                return charSequence.subSequence(i, i2);
            }
            return "";
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        b();
        setResult(CameraBaseActivity.ResultCodeStay, null);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.f23191b == view || ResUtils.id(getActivity(), "dialog_title_close") == id) {
            String charSequence = b().toString();
            if (this.f23191b == view) {
                PayStatisticsUtil.onEvent(StatServiceEvent.STAT_CLICKNEXT);
                BankcardDetectionController.getInstance().update(null, charSequence);
                setResult(CameraBaseActivity.ResultCodeExit, null);
                finish();
                overridePendingTransition(0, 0);
            } else if (this.f23192c == view) {
                PayStatisticsUtil.onEvent(StatServiceEvent.STAT_DISAGREE);
                setResult(CameraBaseActivity.ResultCodeStay, null);
                finish();
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        EventBus.getInstance().registerSticky(this, "BankCardResult", 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.getInstance().unregister(this, "BankCardResult");
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (!"BankCardResult".equals(event.mEventKey)) {
            LogUtil.e(f23190a, "invalid bankcad result key", null);
            finish();
            overridePendingTransition(0, 0);
        }
        this.f23197h = (BCResult) event.mEventObj;
        getWindow().setSoftInputMode(2);
        Activity activity = getActivity();
        SafeScrollView safeScrollView = (SafeScrollView) LayoutInflater.from(activity).inflate(ResUtils.layout(activity, "wallet_bankcard_detection_result"), (ViewGroup) null);
        this.f23194e = safeScrollView;
        setContentView(safeScrollView);
        setSafeScrollView(this.f23194e);
        this.f23194e.post(new Runnable() { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.1
            @Override // java.lang.Runnable
            public void run() {
                BankCardResultActivity.this.c();
            }
        });
        this.f23191b = (TextView) findViewById(ResUtils.id(activity, "button_ok"));
        ((ImageView) this.f23194e.findViewById(ResUtils.id(activity, "card_num_img"))).setImageBitmap(this.f23197h.getDstRGBImage(false));
        this.f23196g = this.f23197h.cardNumberToString().split(" ");
        View findViewById = this.f23194e.findViewById(ResUtils.id(activity, "dialog_title_close"));
        this.f23192c = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.f23194e.findViewById(ResUtils.id(activity, "button_ok"));
        findViewById2.setOnClickListener(this);
        findViewById2.requestFocus();
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f23195f;
        if (safeKeyBoardEditTextArr == null || this.f23194e == null) {
            return;
        }
        for (SafeKeyBoardEditText safeKeyBoardEditText : safeKeyBoardEditTextArr) {
            if (safeKeyBoardEditText.isFocused()) {
                SafeScrollView safeScrollView = this.f23194e;
                safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, this.f23193d);
                return;
            }
        }
    }

    private CharSequence b() {
        String[] strArr;
        StringBuilder sb = new StringBuilder();
        SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f23195f;
        if (safeKeyBoardEditTextArr != null && safeKeyBoardEditTextArr.length != 0 && (strArr = this.f23196g) != null && strArr.length != 0) {
            int i2 = 0;
            boolean z = false;
            while (true) {
                SafeKeyBoardEditText[] safeKeyBoardEditTextArr2 = this.f23195f;
                if (i2 >= safeKeyBoardEditTextArr2.length) {
                    break;
                }
                String obj = safeKeyBoardEditTextArr2[i2].getText().toString();
                sb.append(obj);
                if (!z) {
                    z = !obj.equals(this.f23196g[i2]);
                }
                i2++;
            }
            if (z) {
                PayStatisticsUtil.onEvent(StatServiceEvent.STAT_NUMCHANGE);
            }
        }
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: com.baidu.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.wallet.base.widget.DivisionEditText */
    /* JADX DEBUG: Multi-variable search result rejected for r0v34, resolved type: com.baidu.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.pass.ecommerce.view.LengthLimitEditText */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public void c() {
        int i2 = getWindowManager().getDefaultDisplay().getWidth() > 480 ? 16 : 13;
        Activity activity = getActivity();
        LinearLayout linearLayout = (LinearLayout) this.f23194e.findViewById(ResUtils.id(activity, "card_num_sections"));
        this.f23193d = this.f23194e.findViewById(ResUtils.id(activity, "bcd_result_dlg"));
        ?? r12 = 0;
        InputFilter[] inputFilterArr = {new a()};
        int width = linearLayout.getWidth() / this.f23196g.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, linearLayout.getHeight());
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        int i3 = 3;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((width * 3) / 4, 2);
        layoutParams3.gravity = 1;
        this.f23195f = new SafeKeyBoardEditText[this.f23196g.length];
        int color = ResUtils.color(activity, "bcd_gray3");
        int color2 = ResUtils.getColor(activity, "bcd_color_n_underline");
        final int color3 = ResUtils.getColor(activity, "bcd_color_f_underline");
        int i4 = 0;
        while (i4 < this.f23196g.length) {
            this.f23195f[i4] = new SafeKeyBoardEditText(activity);
            DivisionEditText divisionEditText = this.f23195f[i4];
            SafeScrollView safeScrollView = this.f23194e;
            divisionEditText.initSafeKeyBoardParams(safeScrollView, safeScrollView, this.f23193d, r12);
            this.f23195f[i4].setFilters(inputFilterArr);
            this.f23195f[i4].setText(this.f23196g[i4]);
            this.f23195f[i4].setTextColor(color);
            this.f23195f[i4].setInputType(i3);
            this.f23195f[i4].setSingleLine();
            this.f23195f[i4].setBackgroundColor(r12);
            this.f23195f[i4].setTextSize(1, i2);
            this.f23195f[i4].setLayoutParams(layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(activity);
            linearLayout2.setOrientation(1);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.addView(this.f23195f[i4]);
            final View view = new View(activity);
            view.setBackgroundColor(color2);
            view.setLayoutParams(layoutParams3);
            linearLayout2.addView(view);
            final View.OnFocusChangeListener onFocusChangeListener = this.f23195f[i4].getOnFocusChangeListener();
            int i5 = i4;
            final int i6 = color2;
            this.f23195f[i5].setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z) {
                    View.OnFocusChangeListener onFocusChangeListener2 = onFocusChangeListener;
                    if (onFocusChangeListener2 != null) {
                        onFocusChangeListener2.onFocusChange(view2, z);
                    }
                    view.setBackgroundColor(z ? color3 : i6);
                }
            });
            linearLayout.addView(linearLayout2);
            i4 = i5 + 1;
            color = color;
            color2 = i6;
            i3 = 3;
            r12 = 0;
        }
    }
}
