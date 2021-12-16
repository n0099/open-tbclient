package com.baidu.wallet.bankdetection.ocr.ui;

import android.app.Activity;
import android.graphics.Bitmap;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.bankdetection.BankcardDetectionController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class DxmOcrBankCardResultActivity extends DxmPayBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Pattern f52467h;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public View f52468b;

    /* renamed from: c  reason: collision with root package name */
    public View f52469c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f52470d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52471e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText[] f52472f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f52473g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52474i;

    /* loaded from: classes13.dex */
    public class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DxmOcrBankCardResultActivity a;

        public a(DxmOcrBankCardResultActivity dxmOcrBankCardResultActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dxmOcrBankCardResultActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dxmOcrBankCardResultActivity;
        }

        private int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (this.a.f52472f == null) {
                    return 0;
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < this.a.f52472f.length; i2++) {
                    if (this.a.f52472f[i2] != null) {
                        sb.append(this.a.f52472f[i2].getText().toString());
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
                if (TextUtils.isEmpty(charSequence) || DxmOcrBankCardResultActivity.f52467h.matcher(charSequence).matches()) {
                    if (i3 - i2 > 20) {
                        i3 = i2 + 20;
                    }
                    int a = a() + ((i3 - i2) - (i5 - i4));
                    if (a > 20) {
                        if (spanned.length() == 0) {
                            return null;
                        }
                        return "";
                    }
                    if (a > 10) {
                        this.a.a.setEnabled(true);
                        this.a.a.setTextColor(-1);
                    } else {
                        this.a.a.setEnabled(false);
                        this.a.a.setTextColor(ResUtils.getColor(this.a.getActivity(), "bcd_disable_text"));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(162740770, "Lcom/baidu/wallet/bankdetection/ocr/ui/DxmOcrBankCardResultActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(162740770, "Lcom/baidu/wallet/bankdetection/ocr/ui/DxmOcrBankCardResultActivity;");
                return;
            }
        }
        f52467h = Pattern.compile("\\d{1,20}");
    }

    public DxmOcrBankCardResultActivity() {
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
        this.f52474i = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: com.dxmpay.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: com.dxmpay.wallet.base.widget.DivisionEditText */
    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.dxmpay.wallet.base.widget.SafeKeyBoardEditText[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.pass.ecommerce.view.LengthLimitEditText */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = getWindowManager().getDefaultDisplay().getWidth() > 480 ? 15 : 13;
            Activity activity = getActivity();
            LinearLayout linearLayout = (LinearLayout) this.f52470d.findViewById(ResUtils.id(activity, "card_num_sections"));
            this.f52469c = this.f52470d.findViewById(ResUtils.id(activity, "bcd_result_dlg"));
            ?? r12 = 0;
            InputFilter[] inputFilterArr = {new a(this)};
            int width = linearLayout.getWidth() / this.f52473g.length;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, linearLayout.getHeight());
            layoutParams.gravity = 17;
            layoutParams.weight = 1.0f;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            int i3 = 3;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((width * 3) / 4, 2);
            layoutParams3.gravity = 1;
            this.f52472f = new SafeKeyBoardEditText[this.f52473g.length];
            int color = ResUtils.color(activity, "bcd_gray3");
            int color2 = ResUtils.getColor(activity, "bcd_color_n_underline");
            int color3 = ResUtils.getColor(activity, "bcd_color_f_underline");
            int i4 = 0;
            while (i4 < this.f52473g.length) {
                this.f52472f[i4] = new SafeKeyBoardEditText(activity);
                DivisionEditText divisionEditText = this.f52472f[i4];
                SafeScrollView safeScrollView = this.f52470d;
                divisionEditText.initSafeKeyBoardParams(safeScrollView, safeScrollView, this.f52469c, r12);
                this.f52472f[i4].setFilters(inputFilterArr);
                this.f52472f[i4].setText(this.f52473g[i4]);
                this.f52472f[i4].setTextColor(color);
                this.f52472f[i4].setInputType(i3);
                this.f52472f[i4].setSingleLine();
                this.f52472f[i4].setBackgroundColor(r12);
                this.f52472f[i4].setTextSize(1, i2);
                this.f52472f[i4].setLayoutParams(layoutParams2);
                LinearLayout linearLayout2 = new LinearLayout(activity);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.addView(this.f52472f[i4]);
                View view = new View(activity);
                view.setBackgroundColor(color2);
                view.setLayoutParams(layoutParams3);
                linearLayout2.addView(view);
                int i5 = i4;
                int i6 = color2;
                this.f52472f[i5].setOnFocusChangeListener(new View.OnFocusChangeListener(this, this.f52472f[i4].getOnFocusChangeListener(), view, color3, i6) { // from class: com.baidu.wallet.bankdetection.ocr.ui.DxmOcrBankCardResultActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View.OnFocusChangeListener a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ View f52475b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f52476c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f52477d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DxmOcrBankCardResultActivity f52478e;

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
                        this.f52478e = this;
                        this.a = r7;
                        this.f52475b = view;
                        this.f52476c = color3;
                        this.f52477d = i6;
                    }

                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view2, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                            View.OnFocusChangeListener onFocusChangeListener = this.a;
                            if (onFocusChangeListener != null) {
                                onFocusChangeListener.onFocusChange(view2, z);
                            }
                            this.f52475b.setBackgroundColor(z ? this.f52476c : this.f52477d);
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
            c();
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
            if (this.a == view || ResUtils.id(getActivity(), "dialog_title_close") == id) {
                String charSequence = c().toString();
                if (this.a == view) {
                    if (this.f52474i) {
                        StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_MODIFY, "");
                    } else {
                        StatHelper.bankCardDetctionDuration(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_SUCCESS, "", System.currentTimeMillis() - StatHelper.getBankCardStartTime());
                    }
                    StatisticManager.onEvent("takephotoClickNext");
                    BankcardDetectionController.getInstance().update(null, charSequence);
                    setResult(1243, null);
                    finish();
                    overridePendingTransition(0, 0);
                } else if (this.f52468b == view) {
                    StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_RESULT_CLOSE, "");
                    setResult(1244, null);
                    finish();
                    overridePendingTransition(0, 0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            getWindow().setSoftInputMode(2);
            Activity activity = getActivity();
            SafeScrollView safeScrollView = (SafeScrollView) LayoutInflater.from(activity).inflate(ResUtils.layout(activity, "wallet_bankcard_detection_result"), (ViewGroup) null);
            this.f52470d = safeScrollView;
            setContentView(safeScrollView);
            setSafeScrollView(this.f52470d);
            this.a = (TextView) findViewById(ResUtils.id(activity, "button_ok"));
            View findViewById = this.f52470d.findViewById(ResUtils.id(activity, "dialog_title_close"));
            this.f52468b = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = this.f52470d.findViewById(ResUtils.id(activity, "button_ok"));
            findViewById2.setOnClickListener(this);
            findViewById2.requestFocus();
            this.f52471e = (ImageView) this.f52470d.findViewById(ResUtils.id(activity, "card_num_img"));
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            com.baidu.wallet.bankdetection.ocr.a.a.a().d();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f52472f;
            if (safeKeyBoardEditTextArr == null || this.f52470d == null) {
                return;
            }
            for (SafeKeyBoardEditText safeKeyBoardEditText : safeKeyBoardEditTextArr) {
                if (safeKeyBoardEditText.isFocused()) {
                    SafeScrollView safeScrollView = this.f52470d;
                    safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, this.f52469c);
                    return;
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (strArr = this.f52473g) == null || strArr.length <= 0) {
                return;
            }
            int length = strArr.length - 1;
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f52472f;
            safeKeyBoardEditTextArr[length].setSelection(safeKeyBoardEditTextArr[length].getText().toString().length());
            this.f52472f[length].requestFocus();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            Bitmap b2 = com.baidu.wallet.bankdetection.ocr.a.a.a().b();
            if (b2 == null) {
                finish();
                overridePendingTransition(0, 0);
                return;
            }
            this.f52471e.setImageBitmap(b2);
            String c2 = com.baidu.wallet.bankdetection.ocr.a.a.a().c();
            if (!TextUtils.isEmpty(c2)) {
                int length = c2.trim().length();
                int i2 = length / 4;
                boolean z = length % 4 == 0;
                if (z) {
                    this.f52473g = new String[i2];
                } else {
                    this.f52473g = new String[i2 + 1];
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = i3 * 4;
                    this.f52473g[i3] = c2.subSequence(i4, i4 + 4).toString();
                }
                if (!z) {
                    this.f52473g[i2] = c2.subSequence(i2 * 4, length).toString();
                }
            }
            this.f52470d.post(new Runnable(this) { // from class: com.baidu.wallet.bankdetection.ocr.ui.DxmOcrBankCardResultActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DxmOcrBankCardResultActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.d();
                    }
                }
            });
        }
    }

    private CharSequence c() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            StringBuilder sb = new StringBuilder();
            SafeKeyBoardEditText[] safeKeyBoardEditTextArr = this.f52472f;
            if (safeKeyBoardEditTextArr != null && safeKeyBoardEditTextArr.length != 0 && (strArr = this.f52473g) != null && strArr.length != 0) {
                int i2 = 0;
                while (true) {
                    SafeKeyBoardEditText[] safeKeyBoardEditTextArr2 = this.f52472f;
                    if (i2 >= safeKeyBoardEditTextArr2.length) {
                        break;
                    }
                    String obj = safeKeyBoardEditTextArr2[i2].getText().toString();
                    sb.append(obj);
                    if (!this.f52474i) {
                        this.f52474i = !obj.equals(this.f52473g[i2]);
                    }
                    i2++;
                }
                if (this.f52474i) {
                    StatisticManager.onEvent("#takephotoNumchange");
                }
            }
            return sb;
        }
        return (CharSequence) invokeV.objValue;
    }
}
