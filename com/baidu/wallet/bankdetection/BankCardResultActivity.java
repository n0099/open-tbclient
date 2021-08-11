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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bankdetection.BCResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class BankCardResultActivity extends DxmPayBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f59817a;

    /* renamed from: i  reason: collision with root package name */
    public static Pattern f59818i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59819b;

    /* renamed from: c  reason: collision with root package name */
    public View f59820c;

    /* renamed from: d  reason: collision with root package name */
    public View f59821d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f59822e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText[] f59823f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f59824g;

    /* renamed from: h  reason: collision with root package name */
    public BCResult f59825h;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59826j;

    /* loaded from: classes8.dex */
    public class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BankCardResultActivity f59833a;

        public a(BankCardResultActivity bankCardResultActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bankCardResultActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59833a = bankCardResultActivity;
        }

        private int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (this.f59833a.f59823f == null) {
                    return 0;
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < this.f59833a.f59823f.length; i2++) {
                    if (this.f59833a.f59823f[i2] != null) {
                        sb.append(this.f59833a.f59823f[i2].getText().toString());
                    }
                }
                return sb.length();
            }
            return invokeV.intValue;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (TextUtils.isEmpty(charSequence) || BankCardResultActivity.f59818i.matcher(charSequence).matches()) {
                    if (i3 - i2 > 20) {
                        i3 = i2 + 20;
                    }
                    int a2 = a() + ((i3 - i2) - (i5 - i4));
                    if (a2 > 20) {
                        if (spanned.length() == 0) {
                            return null;
                        }
                        return "";
                    }
                    if (a2 > 10) {
                        this.f59833a.f59819b.setEnabled(true);
                        this.f59833a.f59819b.setTextColor(-1);
                    } else {
                        this.f59833a.f59819b.setEnabled(false);
                        this.f59833a.f59819b.setTextColor(ResUtils.getColor(this.f59833a.getActivity(), "bcd_disable_text"));
                    }
                    return charSequence.subSequence(i2, i3);
                }
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138662283, "Lcom/baidu/wallet/bankdetection/BankCardResultActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2138662283, "Lcom/baidu/wallet/bankdetection/BankCardResultActivity;");
                return;
            }
        }
        f59817a = BankCardResultActivity.class.getSimpleName();
        f59818i = Pattern.compile("\\d{1,20}");
    }

    public BankCardResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59826j = false;
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_CLOSE, "");
            b();
            setResult(1244, null);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            int id = view.getId();
            if (this.f59819b == view || ResUtils.id(getActivity(), "dialog_title_close") == id) {
                String charSequence = b().toString();
                if (this.f59819b == view) {
                    if (this.f59826j) {
                        StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_MODIFY, "");
                    } else {
                        StatHelper.bankCardDetctionDuration(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_SUCCESS, "", System.currentTimeMillis() - StatHelper.getBankCardStartTime());
                    }
                    StatisticManager.onEvent("takephotoClickNext");
                    BankcardDetectionController.getInstance().update(null, charSequence);
                    setResult(1243, null);
                    finish();
                    overridePendingTransition(0, 0);
                } else if (this.f59820c == view) {
                    StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_CLOSE, "");
                    setResult(1244, null);
                    finish();
                    overridePendingTransition(0, 0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            EventBus.getInstance().registerSticky(this, "BankCardResult", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EventBus.getInstance().unregister(this, "BankCardResult");
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            if (!"BankCardResult".equals(event.mEventKey)) {
                LogUtil.e(f59817a, "invalid bankcad result key", null);
                finish();
                overridePendingTransition(0, 0);
            }
            this.f59825h = (BCResult) event.mEventObj;
            getWindow().setSoftInputMode(2);
            Activity activity = getActivity();
            SafeScrollView safeScrollView = (SafeScrollView) LayoutInflater.from(activity).inflate(ResUtils.layout(activity, "wallet_bankcard_detection_result"), (ViewGroup) null);
            this.f59822e = safeScrollView;
            setContentView(safeScrollView);
            setSafeScrollView(this.f59822e);
            this.f59822e.post(new Runnable(this) { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BankCardResultActivity f59827a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59827a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59827a.c();
                    }
                }
            });
            this.f59819b = (TextView) findViewById(ResUtils.id(activity, "button_ok"));
            ((ImageView) this.f59822e.findViewById(ResUtils.id(activity, "card_num_img"))).setImageBitmap(this.f59825h.getDstRGBImage(false));
            this.f59824g = this.f59825h.cardNumberToString().split(" ");
            View findViewById = this.f59822e.findViewById(ResUtils.id(activity, "dialog_title_close"));
            this.f59820c = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = this.f59822e.findViewById(ResUtils.id(activity, "button_ok"));
            findViewById2.setOnClickListener(this);
            findViewById2.requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f59823f;
            if (safeKeyBoardEditTextArr == null || this.f59822e == null) {
                return;
            }
            for (SafeKeyBoardEditText safeKeyBoardEditText : safeKeyBoardEditTextArr) {
                if (safeKeyBoardEditText.isFocused()) {
                    SafeScrollView safeScrollView = this.f59822e;
                    safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, this.f59821d);
                    return;
                }
            }
        }
    }

    private CharSequence b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            StringBuilder sb = new StringBuilder();
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f59823f;
            if (safeKeyBoardEditTextArr != null && safeKeyBoardEditTextArr.length != 0 && (strArr = this.f59824g) != null && strArr.length != 0) {
                int i2 = 0;
                while (true) {
                    SafeKeyBoardEditText[] safeKeyBoardEditTextArr2 = this.f59823f;
                    if (i2 >= safeKeyBoardEditTextArr2.length) {
                        break;
                    }
                    String obj = safeKeyBoardEditTextArr2[i2].getText().toString();
                    sb.append(obj);
                    if (!this.f59826j) {
                        this.f59826j = !obj.equals(this.f59824g[i2]);
                    }
                    i2++;
                }
                if (this.f59826j) {
                    StatisticManager.onEvent("#takephotoNumchange");
                }
            }
            return sb;
        }
        return (CharSequence) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: com.dxmpay.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: com.dxmpay.wallet.base.widget.DivisionEditText */
    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.dxmpay.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.pass.ecommerce.view.LengthLimitEditText */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = getWindowManager().getDefaultDisplay().getWidth() > 480 ? 16 : 13;
            Activity activity = getActivity();
            LinearLayout linearLayout = (LinearLayout) this.f59822e.findViewById(ResUtils.id(activity, "card_num_sections"));
            this.f59821d = this.f59822e.findViewById(ResUtils.id(activity, "bcd_result_dlg"));
            ?? r12 = 0;
            InputFilter[] inputFilterArr = {new a(this)};
            int width = linearLayout.getWidth() / this.f59824g.length;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, linearLayout.getHeight());
            layoutParams.gravity = 17;
            layoutParams.weight = 1.0f;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            int i3 = 3;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((width * 3) / 4, 2);
            layoutParams3.gravity = 1;
            this.f59823f = new SafeKeyBoardEditText[this.f59824g.length];
            int color = ResUtils.color(activity, "bcd_gray3");
            int color2 = ResUtils.getColor(activity, "bcd_color_n_underline");
            int color3 = ResUtils.getColor(activity, "bcd_color_f_underline");
            int i4 = 0;
            while (i4 < this.f59824g.length) {
                this.f59823f[i4] = new SafeKeyBoardEditText(activity);
                DivisionEditText divisionEditText = this.f59823f[i4];
                SafeScrollView safeScrollView = this.f59822e;
                divisionEditText.initSafeKeyBoardParams(safeScrollView, safeScrollView, this.f59821d, r12);
                this.f59823f[i4].setFilters(inputFilterArr);
                this.f59823f[i4].setText(this.f59824g[i4]);
                this.f59823f[i4].setTextColor(color);
                this.f59823f[i4].setInputType(i3);
                this.f59823f[i4].setSingleLine();
                this.f59823f[i4].setBackgroundColor(r12);
                this.f59823f[i4].setTextSize(1, i2);
                this.f59823f[i4].setLayoutParams(layoutParams2);
                LinearLayout linearLayout2 = new LinearLayout(activity);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.addView(this.f59823f[i4]);
                View view = new View(activity);
                view.setBackgroundColor(color2);
                view.setLayoutParams(layoutParams3);
                linearLayout2.addView(view);
                int i5 = i4;
                int i6 = color2;
                this.f59823f[i5].setOnFocusChangeListener(new View.OnFocusChangeListener(this, this.f59823f[i4].getOnFocusChangeListener(), view, color3, i6) { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View.OnFocusChangeListener f59828a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ View f59829b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f59830c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f59831d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ BankCardResultActivity f59832e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, view, Integer.valueOf(color3), Integer.valueOf(i6)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59832e = this;
                        this.f59828a = r7;
                        this.f59829b = view;
                        this.f59830c = color3;
                        this.f59831d = i6;
                    }

                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view2, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                            View.OnFocusChangeListener onFocusChangeListener = this.f59828a;
                            if (onFocusChangeListener != null) {
                                onFocusChangeListener.onFocusChange(view2, z);
                            }
                            this.f59829b.setBackgroundColor(z ? this.f59830c : this.f59831d);
                        }
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
}
