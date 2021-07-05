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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.bankdetection.BCResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class BankCardResultActivity extends DxmPayBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23806a;

    /* renamed from: i  reason: collision with root package name */
    public static Pattern f23807i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23808b;

    /* renamed from: c  reason: collision with root package name */
    public View f23809c;

    /* renamed from: d  reason: collision with root package name */
    public View f23810d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f23811e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText[] f23812f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f23813g;

    /* renamed from: h  reason: collision with root package name */
    public BCResult f23814h;

    /* loaded from: classes6.dex */
    public class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BankCardResultActivity f23821a;

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
            this.f23821a = bankCardResultActivity;
        }

        private int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (this.f23821a.f23812f == null) {
                    return 0;
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < this.f23821a.f23812f.length; i2++) {
                    if (this.f23821a.f23812f[i2] != null) {
                        sb.append(this.f23821a.f23812f[i2].getText().toString());
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
                if (TextUtils.isEmpty(charSequence) || BankCardResultActivity.f23807i.matcher(charSequence).matches()) {
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
                        this.f23821a.f23808b.setEnabled(true);
                        this.f23821a.f23808b.setTextColor(-1);
                    } else {
                        this.f23821a.f23808b.setEnabled(false);
                        this.f23821a.f23808b.setTextColor(ResUtils.getColor(this.f23821a.getActivity(), "bcd_disable_text"));
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
        f23806a = BankCardResultActivity.class.getSimpleName();
        f23807i = Pattern.compile("\\d{1,20}");
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
            }
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            setResult(CameraBaseActivity.ResultCodeStay, null);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            int id = view.getId();
            if (this.f23808b == view || ResUtils.id(getActivity(), "dialog_title_close") == id) {
                String charSequence = b().toString();
                if (this.f23808b == view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.STAT_CLICKNEXT);
                    BankcardDetectionController.getInstance().update(null, charSequence);
                    setResult(CameraBaseActivity.ResultCodeExit, null);
                    finish();
                    overridePendingTransition(0, 0);
                } else if (this.f23809c == view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.STAT_DISAGREE);
                    setResult(CameraBaseActivity.ResultCodeStay, null);
                    finish();
                    overridePendingTransition(0, 0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            EventBus.getInstance().registerSticky(this, "BankCardResult", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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
                LogUtil.e(f23806a, "invalid bankcad result key", null);
                finish();
                overridePendingTransition(0, 0);
            }
            this.f23814h = (BCResult) event.mEventObj;
            getWindow().setSoftInputMode(2);
            Activity activity = getActivity();
            SafeScrollView safeScrollView = (SafeScrollView) LayoutInflater.from(activity).inflate(ResUtils.layout(activity, "wallet_bankcard_detection_result"), (ViewGroup) null);
            this.f23811e = safeScrollView;
            setContentView(safeScrollView);
            setSafeScrollView(this.f23811e);
            this.f23811e.post(new Runnable(this) { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BankCardResultActivity f23815a;

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
                    this.f23815a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f23815a.c();
                    }
                }
            });
            this.f23808b = (TextView) findViewById(ResUtils.id(activity, "button_ok"));
            ((ImageView) this.f23811e.findViewById(ResUtils.id(activity, "card_num_img"))).setImageBitmap(this.f23814h.getDstRGBImage(false));
            this.f23813g = this.f23814h.cardNumberToString().split(" ");
            View findViewById = this.f23811e.findViewById(ResUtils.id(activity, "dialog_title_close"));
            this.f23809c = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = this.f23811e.findViewById(ResUtils.id(activity, "button_ok"));
            findViewById2.setOnClickListener(this);
            findViewById2.requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f23812f;
            if (safeKeyBoardEditTextArr == null || this.f23811e == null) {
                return;
            }
            for (SafeKeyBoardEditText safeKeyBoardEditText : safeKeyBoardEditTextArr) {
                if (safeKeyBoardEditText.isFocused()) {
                    SafeScrollView safeScrollView = this.f23811e;
                    safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, this.f23810d);
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
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f23812f;
            if (safeKeyBoardEditTextArr != null && safeKeyBoardEditTextArr.length != 0 && (strArr = this.f23813g) != null && strArr.length != 0) {
                int i2 = 0;
                boolean z = false;
                while (true) {
                    SafeKeyBoardEditText[] safeKeyBoardEditTextArr2 = this.f23812f;
                    if (i2 >= safeKeyBoardEditTextArr2.length) {
                        break;
                    }
                    String obj = safeKeyBoardEditTextArr2[i2].getText().toString();
                    sb.append(obj);
                    if (!z) {
                        z = !obj.equals(this.f23813g[i2]);
                    }
                    i2++;
                }
                if (z) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.STAT_NUMCHANGE);
                }
            }
            return sb;
        }
        return (CharSequence) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: com.baidu.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: com.baidu.wallet.base.widget.DivisionEditText */
    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.pass.ecommerce.view.LengthLimitEditText */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = getWindowManager().getDefaultDisplay().getWidth() > 480 ? 16 : 13;
            Activity activity = getActivity();
            LinearLayout linearLayout = (LinearLayout) this.f23811e.findViewById(ResUtils.id(activity, "card_num_sections"));
            this.f23810d = this.f23811e.findViewById(ResUtils.id(activity, "bcd_result_dlg"));
            ?? r12 = 0;
            InputFilter[] inputFilterArr = {new a(this)};
            int width = linearLayout.getWidth() / this.f23813g.length;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, linearLayout.getHeight());
            layoutParams.gravity = 17;
            layoutParams.weight = 1.0f;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            int i3 = 3;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((width * 3) / 4, 2);
            layoutParams3.gravity = 1;
            this.f23812f = new SafeKeyBoardEditText[this.f23813g.length];
            int color = ResUtils.color(activity, "bcd_gray3");
            int color2 = ResUtils.getColor(activity, "bcd_color_n_underline");
            int color3 = ResUtils.getColor(activity, "bcd_color_f_underline");
            int i4 = 0;
            while (i4 < this.f23813g.length) {
                this.f23812f[i4] = new SafeKeyBoardEditText(activity);
                DivisionEditText divisionEditText = this.f23812f[i4];
                SafeScrollView safeScrollView = this.f23811e;
                divisionEditText.initSafeKeyBoardParams(safeScrollView, safeScrollView, this.f23810d, r12);
                this.f23812f[i4].setFilters(inputFilterArr);
                this.f23812f[i4].setText(this.f23813g[i4]);
                this.f23812f[i4].setTextColor(color);
                this.f23812f[i4].setInputType(i3);
                this.f23812f[i4].setSingleLine();
                this.f23812f[i4].setBackgroundColor(r12);
                this.f23812f[i4].setTextSize(1, i2);
                this.f23812f[i4].setLayoutParams(layoutParams2);
                LinearLayout linearLayout2 = new LinearLayout(activity);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.addView(this.f23812f[i4]);
                View view = new View(activity);
                view.setBackgroundColor(color2);
                view.setLayoutParams(layoutParams3);
                linearLayout2.addView(view);
                int i5 = i4;
                int i6 = color2;
                this.f23812f[i5].setOnFocusChangeListener(new View.OnFocusChangeListener(this, this.f23812f[i4].getOnFocusChangeListener(), view, color3, i6) { // from class: com.baidu.wallet.bankdetection.BankCardResultActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View.OnFocusChangeListener f23816a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ View f23817b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f23818c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f23819d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ BankCardResultActivity f23820e;

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
                        this.f23820e = this;
                        this.f23816a = r7;
                        this.f23817b = view;
                        this.f23818c = color3;
                        this.f23819d = i6;
                    }

                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view2, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                            View.OnFocusChangeListener onFocusChangeListener = this.f23816a;
                            if (onFocusChangeListener != null) {
                                onFocusChangeListener.onFocusChange(view2, z);
                            }
                            this.f23817b.setBackgroundColor(z ? this.f23818c : this.f23819d);
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
