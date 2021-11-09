package com.baidu.wallet.paysdk.b;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.r;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public r f59520a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.g f59521b;

    /* renamed from: c  reason: collision with root package name */
    public y f59522c;

    /* renamed from: d  reason: collision with root package name */
    public BindCardBaseActivity f59523d;

    /* renamed from: e  reason: collision with root package name */
    public BindFastRequest f59524e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59525f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59526g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59527h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59528i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int r;
    public GetCardInfoResponse.CertificateTypeInfo s;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 4;
        this.f59525f = false;
        this.f59526g = false;
        this.f59527h = false;
        this.f59528i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.s = null;
    }

    public CharSequence A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = ResUtils.getString(this.f59523d, "wallet_base_string_safeguard_entry");
            int indexOf = string.indexOf(ResUtils.getString(this.f59523d, "wallet_base_string_safeguard_click"));
            int length = string.length();
            if (-1 == indexOf) {
                return string;
            }
            ClickableSpan clickableSpan = new ClickableSpan(this) { // from class: com.baidu.wallet.paysdk.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f59529a;

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
                    this.f59529a = this;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f59529a.B();
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                        textPaint.setUnderlineText(false);
                    }
                }
            };
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ResUtils.getColor(this.f59523d, "dxm_wallet_base_color_clickable"));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(clickableSpan, indexOf, length, 17);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, length, 17);
            return spannableStringBuilder;
        }
        return (CharSequence) invokeV.objValue;
    }

    public void B() {
        String[] stringArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (stringArray = ResUtils.getStringArray(this.f59523d, "wallet_base_safeguard_tips")) == null || 2 > stringArray.length) {
            return;
        }
        String str = stringArray[0];
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < stringArray.length - 1; i2++) {
            sb.append(stringArray[i2]);
        }
        String str2 = stringArray[stringArray.length - 1];
        PromptTipDialog promptTipDialog = new PromptTipDialog(this.f59523d);
        promptTipDialog.setTitleMessage(str);
        promptTipDialog.setMessage(sb.toString());
        promptTipDialog.setButtonMessage(str2);
        promptTipDialog.setDefaultBtnListener(new View.OnClickListener(this, promptTipDialog) { // from class: com.baidu.wallet.paysdk.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PromptTipDialog f59530a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f59531b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, promptTipDialog};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59531b = this;
                this.f59530a = promptTipDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f59530a.dismiss();
                }
            }
        });
        promptTipDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bindFastRequest) == null) {
            this.f59524e = bindFastRequest;
        }
    }

    public void a(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, strArr) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void b(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, certificateTypeInfo) == null) {
            this.s = certificateTypeInfo;
        }
    }

    public void b(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, strArr) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void c(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, strArr) == null) {
            if (this.f59521b == null) {
                this.f59521b = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f59523d, 5, BindCardBaseActivity.BEAN_TAG);
            }
            this.f59521b.setResponseCallback(this.f59523d);
            StatisticManager.onEvent("callCardCheck");
            b(strArr);
            this.f59521b.a(this.f59524e);
            this.f59521b.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void d(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, strArr) == null) {
            if (this.f59520a == null) {
                this.f59520a = (r) PayBeanFactory.getInstance().getBean((Context) this.f59523d, 4, BindCardBaseActivity.BEAN_TAG);
            }
            this.f59520a.a(this.f59524e);
            this.f59520a.setResponseCallback(this.f59523d);
            a(strArr);
            StatisticManager.onEventStart("getCardInfo");
            this.f59520a.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.f59520a == null) {
            return;
        }
        BeanManager.getInstance().removeBean(this.f59520a);
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? !TextUtils.isEmpty(PayDataCache.getInstance().getFormatUserName()) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? PayDataCache.getInstance().getUserName() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f59526g : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f59525f || this.m : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f59527h || this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f59528i || this.o : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.j || this.n : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? ResUtils.getString(this.f59523d, "ebpay_card_tip") : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void r() {
        int i2;
        ErrorContentResponse errorContentResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if ((this instanceof g) || (this instanceof h)) {
                BindFastRequest bindFastRequest = this.f59524e;
                if (bindFastRequest != null && (errorContentResponse = bindFastRequest.mCardInfoUpdateContent) != null) {
                    this.m = errorContentResponse.isNeedValidCode();
                    this.l = this.f59524e.mCardInfoUpdateContent.isNeedValidDate();
                    this.n = this.f59524e.mCardInfoUpdateContent.isNeedPhoneNum();
                    this.o = this.f59524e.mCardInfoUpdateContent.isNeedId();
                    this.p = this.f59524e.mCardInfoUpdateContent.isNeedType();
                    ErrorContentResponse errorContentResponse2 = this.f59524e.mCardInfoUpdateContent;
                    GetCardInfoResponse.CardItemRequired cardItemRequired = errorContentResponse2.card_item_required;
                    if (cardItemRequired != null) {
                        this.f59525f = this.f59525f || errorContentResponse2.needUpdate(cardItemRequired.valid_code);
                        this.f59527h = this.f59527h || this.f59524e.mCardInfoUpdateContent.needUpdate(cardItemRequired.valid_date);
                        this.f59526g = this.f59526g || this.f59524e.mCardInfoUpdateContent.needUpdate(cardItemRequired.true_name);
                        this.k = this.k || this.f59524e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_type);
                        this.f59528i = this.f59528i || this.f59524e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_code);
                        this.j = this.j || this.f59524e.mCardInfoUpdateContent.needUpdate(cardItemRequired.mobile);
                    }
                }
                BindCardBaseActivity bindCardBaseActivity = this.f59523d;
                if (bindCardBaseActivity != null) {
                    if (bindCardBaseActivity.isShowWithHalfScreeen()) {
                        BindCardImplActivity bindCardImplActivity = (BindCardImplActivity) this.f59523d;
                        BankCvv2InfoView bankCvv2InfoView = bindCardImplActivity.mBankCvv2InfoView;
                        BankUserInfoView bankUserInfoView = bindCardImplActivity.mBankUserInfoView;
                        if (this.f59525f) {
                            bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (this.f59527h) {
                            i2++;
                            bankCvv2InfoView.getDateInputView().getEditableText().toString();
                        }
                        if (this.f59528i) {
                            i2++;
                            bankUserInfoView.getIdEditText().getEditableText().toString();
                        }
                        if (this.j) {
                            i2++;
                            bankUserInfoView.getMobileEditText().getEditableText().toString();
                        }
                        if (2 < i2 || this.f59526g) {
                            Intent intent = new Intent();
                            intent.putExtra("halfScreen", this.f59526g ? 0 : i2);
                            intent.putExtra("reasonForChangeCardItem", 2);
                            bindCardImplActivity.updateUiMode(intent);
                        }
                    }
                    this.f59523d.updateBankTitleInfo(null, true);
                    this.f59523d.updateCvv2Info(this.m, this.l, this.n);
                    this.f59523d.updateCardElement(k(), l(), j(), m(), n());
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            BindFastRequest bindFastRequest = this.f59524e;
            return (bindFastRequest == null || bindFastRequest.mCardInfoUpdateContent == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.baidu.wallet.paysdk.datamodel.a aVar = new com.baidu.wallet.paysdk.datamodel.a();
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo != null) {
                aVar.a(userInfo.mobile_number);
                UserData.UserModel.DisplayFlag displayFlag = userInfo.display_flag;
                if (displayFlag != null) {
                    aVar.b(displayFlag.getMobileFlag());
                }
            }
            return aVar;
        }
        return (com.baidu.wallet.paysdk.datamodel.a) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            BindFastRequest bindFastRequest = this.f59524e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f59524e.getmBankInfo().channel_info != null) {
                    return this.f59524e.getmBankInfo().channel_info.certificate_type_info;
                }
                if (this.f59524e.getmBondCard() != null) {
                    return this.f59524e.getmBondCard().certificate_type_info;
                }
                return null;
            }
            return null;
        }
        return (GetCardInfoResponse.CertificateTypeInfo[]) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.s;
            if (certificateTypeInfo != null) {
                return certificateTypeInfo;
            }
            GetCardInfoResponse.CertificateTypeInfo[] v = v();
            if (v == null || v.length <= 0) {
                return null;
            }
            String certificateType = PayDataCache.getInstance().getCertificateType();
            if (a(certificateType, v)) {
                for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo2 : v) {
                    if (certificateTypeInfo2 != null && certificateType.equals(certificateTypeInfo2.type)) {
                        this.s = certificateTypeInfo2;
                        return certificateTypeInfo2;
                    }
                }
                return null;
            }
            this.s = v[0];
            return v[0];
        }
        return (GetCardInfoResponse.CertificateTypeInfo) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (v() == null) {
                return 0;
            }
            return v().length;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? PayDataCache.getInstance().isShowDetection() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public ArrayList<CharSequence> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ArrayList<CharSequence> arrayList = new ArrayList<>();
            arrayList.add(A());
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (this.f59522c == null) {
                this.f59522c = (y) PayBeanFactory.getInstance().getBean((Context) this.f59523d, 7, BindCardBaseActivity.BEAN_TAG);
            }
            this.f59522c.setResponseCallback(this.f59523d);
            this.f59522c.a(str);
            this.f59522c.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(BindCardBaseActivity bindCardBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bindCardBaseActivity) == null) {
            this.f59523d = bindCardBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            String[] strArr = new String[2];
            String string = ResUtils.getString(this.f59523d, "bd_wallet_bind_card_first");
            if (i2 == 0) {
                string = ResUtils.getString(this.f59523d, "bd_wallet_bind_card_first");
            } else if (i2 == 1) {
                string = ResUtils.getString(this.f59523d, "bd_wallet_bind_card_second");
            }
            String string2 = ResUtils.getString(this.f59523d, "ebpay_pay_checkcard");
            if (i2 == 0) {
                string2 = ResUtils.getString(this.f59523d, "ebpay_pay_checkcard");
            } else if (i2 == 1) {
                string2 = ResUtils.getString(this.f59523d, "dxm_ebpay_pay_next");
            }
            strArr[0] = string;
            strArr[1] = string2;
            return strArr;
        }
        return (String[]) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, certificateTypeInfo)) == null) {
            if (certificateTypeInfo == null) {
                com.baidu.wallet.paysdk.datamodel.a aVar = new com.baidu.wallet.paysdk.datamodel.a();
                UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
                if (userInfo != null) {
                    aVar.a(PayDataCache.getInstance().getUserId());
                    UserData.UserModel.DisplayFlag displayFlag = userInfo.display_flag;
                    if (displayFlag != null) {
                        aVar.b(displayFlag.getCodeFlag());
                    }
                }
                return aVar;
            }
            boolean a2 = a(certificateTypeInfo.type, v());
            int x = x();
            com.baidu.wallet.paysdk.datamodel.a aVar2 = new com.baidu.wallet.paysdk.datamodel.a();
            UserData.UserModel userInfo2 = PayDataCache.getInstance().getUserInfo();
            if (userInfo2 != null) {
                if (certificateTypeInfo.type.equals(PayDataCache.getInstance().getCertificateType())) {
                    aVar2.a(PayDataCache.getInstance().getUserId());
                } else {
                    aVar2.a("");
                }
                UserData.UserModel.DisplayFlag displayFlag2 = userInfo2.display_flag;
                if (x <= 1 || !a2) {
                    if (displayFlag2 != null) {
                        aVar2.b(displayFlag2.getCodeFlag());
                    }
                } else if (certificateTypeInfo.type.equals(PayDataCache.getInstance().getCertificateType())) {
                    if (displayFlag2 != null) {
                        aVar2.b(displayFlag2.getCodeFlag());
                    }
                } else if (displayFlag2 != null) {
                    aVar2.b("4");
                }
            }
            return aVar2;
        }
        return (com.baidu.wallet.paysdk.datamodel.a) invokeL.objValue;
    }

    public boolean a(String str, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, certificateTypeInfoArr)) == null) {
            if (certificateTypeInfoArr != null && certificateTypeInfoArr.length > 0 && !TextUtils.isEmpty(str)) {
                for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo : certificateTypeInfoArr) {
                    if (certificateTypeInfo != null && str.equals(certificateTypeInfo.type)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
