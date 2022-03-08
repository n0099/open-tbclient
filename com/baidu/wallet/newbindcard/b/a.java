package com.baidu.wallet.newbindcard.b;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public NewBindCardMainActivity f50371b;

    public a(NewBindCardMainActivity newBindCardMainActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newBindCardMainActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50371b = newBindCardMainActivity;
    }

    private Handler l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.a == null) {
                this.a = new Handler(this.f50371b.getMainLooper());
            }
            return this.a;
        }
        return (Handler) invokeV.objValue;
    }

    private int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String format = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(format) && format.length() == 4) {
                try {
                    return Integer.parseInt(format.substring(2, 4));
                } catch (Exception unused) {
                }
            }
            return 18;
        }
        return invokeV.intValue;
    }

    public abstract void a();

    public abstract void a(int i2, int i3, String str);

    public abstract void a(int i2, Object obj, String str);

    public abstract void a(Bundle bundle);

    public void a(View view, int i2) {
        int color;
        float dimension;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 == 1) {
            color = ResUtils.getColor(this.f50371b, "wallet_cashdesk_new_bind_card_2222");
            dimension = ResUtils.getDimension(this.f50371b, "wallet_cashdesk_new_bind_card_hasfocus_line_size");
        } else if (i2 == 2) {
            color = ResUtils.getColor(this.f50371b, "wallet_cashdesk_new_bind_card_5050");
            dimension = ResUtils.getDimension(this.f50371b, "wallet_cashdesk_new_bind_card_line_error_size");
        } else {
            color = ResUtils.getColor(this.f50371b, "wallet_cashdesk_new_bind_card_E0EA");
            dimension = ResUtils.getDimension(this.f50371b, "wallet_cashdesk_new_bind_card_line_size");
        }
        int i3 = (int) dimension;
        view.setBackgroundColor(color);
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public abstract void a(String str, String str2, String str3, String str4, String str5, String str6);

    public abstract void b();

    public boolean b(View view, SafeKeyBoardEditText safeKeyBoardEditText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, safeKeyBoardEditText)) == null) {
            if (view.getVisibility() == 0 && safeKeyBoardEditText.isEnabled()) {
                if (TextUtils.isEmpty(safeKeyBoardEditText.getText())) {
                    return true;
                }
                return !CheckUtils.isBandCardEndAvailable(safeKeyBoardEditText.getText().toString());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract void c();

    public void c(SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, safeKeyBoardEditText, imageView) == null) || safeKeyBoardEditText == null || imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.wallet_cashdesk_new_bind_card_tip_icon);
        imageView.setOnClickListener(this.f50371b);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.a = null;
            }
            this.f50371b = null;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? "walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || BeanConstants.CHANNEL_ID_WALLET_APP_PRO.equalsIgnoreCase(BeanConstants.CHANNEL_ID) : invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, str) == null) {
            l().post(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.newbindcard.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f50375b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f50376c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f50377d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50377d = this;
                    this.a = i2;
                    this.f50375b = i3;
                    this.f50376c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f50377d.a(this.a, this.f50375b, this.f50376c);
                    }
                }
            });
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048603, this, i2, obj, str) == null) {
            l().post(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.newbindcard.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f50372b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f50373c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f50374d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50374d = this;
                    this.a = i2;
                    this.f50372b = obj;
                    this.f50373c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f50374d.a(this.a, this.f50372b, this.f50373c);
                    }
                }
            });
        }
    }

    public void b(SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, safeKeyBoardEditText, imageView) == null) || safeKeyBoardEditText == null || imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.dxm_wallet_base_delete);
        imageView.setOnClickListener(new View.OnClickListener(this, safeKeyBoardEditText) { // from class: com.baidu.wallet.newbindcard.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SafeKeyBoardEditText a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f50378b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, safeKeyBoardEditText};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50378b = this;
                this.a = safeKeyBoardEditText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.setText("");
                }
            }
        });
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, safeKeyBoardEditText, str) == null) || safeKeyBoardEditText == null) {
            return;
        }
        if ("1".equals(str)) {
            List<IEditTextPasteFilter> editTextPasteFilters = safeKeyBoardEditText.getEditTextPasteFilters();
            if (editTextPasteFilters != null) {
                editTextPasteFilters.clear();
                editTextPasteFilters.add(new IDCardEditTextPasteFilter());
            }
            safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
            safeKeyBoardEditText.setUseSafeKeyBoard(true);
            safeKeyBoardEditText.setUseKeyX(true);
            return;
        }
        List<IEditTextPasteFilter> editTextPasteFilters2 = safeKeyBoardEditText.getEditTextPasteFilters();
        if (editTextPasteFilters2 != null) {
            editTextPasteFilters2.clear();
            editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
        }
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});
        safeKeyBoardEditText.setUseSafeKeyBoard(false);
        safeKeyBoardEditText.setUseKeyX(false);
    }

    public void a(EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, editText) == null) || editText == null) {
            return;
        }
        if (editText.getText() != null && editText.getText().length() > 0) {
            editText.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            editText.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public boolean a(View view, SafeKeyBoardEditText safeKeyBoardEditText) {
        InterceptResult invokeLL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, safeKeyBoardEditText)) == null) {
            if (view.getVisibility() == 0 && safeKeyBoardEditText.isEnabled()) {
                if (TextUtils.isEmpty(safeKeyBoardEditText.getText())) {
                    return true;
                }
                String obj = safeKeyBoardEditText.getText().toString();
                if (!TextUtils.isEmpty(obj) && obj.length() == 5) {
                    try {
                        if (!TextUtils.isEmpty(obj) && ((parseInt = Integer.parseInt(obj.substring(0, 2))) <= 0 || parseInt > 12)) {
                            return true;
                        }
                        if (Integer.parseInt(obj.substring(3, 5)) < m()) {
                        }
                    } catch (Exception unused) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean a(View view, DivisionEditText divisionEditText, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, view, divisionEditText, z)) == null) ? view.getVisibility() == 0 && divisionEditText.isEnabled() && !z && !CheckUtils.isMobileAvailable(divisionEditText.getRealText()) : invokeLLZ.booleanValue;
    }

    public boolean a(View view, SafeKeyBoardEditText safeKeyBoardEditText, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{view, safeKeyBoardEditText, certificateTypeInfo, Boolean.valueOf(z)})) == null) ? (view.getVisibility() != 0 || !safeKeyBoardEditText.isEnabled() || certificateTypeInfo == null || z || certificateTypeInfo.getValidator().a(safeKeyBoardEditText.getText())) ? false : true : invokeCommon.booleanValue;
    }

    public void a(SafeKeyBoardEditText safeKeyBoardEditText, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, safeKeyBoardEditText, imageView) == null) || safeKeyBoardEditText == null || imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(safeKeyBoardEditText.getText()) && safeKeyBoardEditText.isEnabled() && safeKeyBoardEditText.hasFocus()) {
            b(safeKeyBoardEditText, imageView);
        } else {
            c(safeKeyBoardEditText, imageView);
        }
    }

    public boolean a(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, motionEvent)) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            return motionEvent.getX() >= ((float) i2) && motionEvent.getX() <= ((float) (i2 + view.getWidth())) && motionEvent.getY() >= ((float) i3) && motionEvent.getY() <= ((float) (i3 + view.getHeight()));
        }
        return invokeLL.booleanValue;
    }
}
