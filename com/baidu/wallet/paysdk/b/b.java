package com.baidu.wallet.paysdk.b;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.aa;
import com.baidu.wallet.paysdk.beans.t;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public t f25139a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.h f25140b;

    /* renamed from: c  reason: collision with root package name */
    public aa f25141c;

    /* renamed from: d  reason: collision with root package name */
    public BindCardBaseActivity f25142d;

    /* renamed from: e  reason: collision with root package name */
    public BindFastRequest f25143e;
    public int r = 4;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25144f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25145g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25146h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25147i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public GetCardInfoResponse.CertificateTypeInfo s = null;

    public CharSequence A() {
        String string = ResUtils.getString(this.f25142d, "wallet_base_string_safeguard_entry");
        int indexOf = string.indexOf(ResUtils.getString(this.f25142d, "wallet_base_string_safeguard_click"));
        int length = string.length();
        if (-1 == indexOf) {
            return string;
        }
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.baidu.wallet.paysdk.b.b.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                b.this.B();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ResUtils.getColor(this.f25142d, "wallet_base_color_clickable"));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(clickableSpan, indexOf, length, 17);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, length, 17);
        return spannableStringBuilder;
    }

    public void B() {
        String[] stringArray = ResUtils.getStringArray(this.f25142d, "wallet_base_safeguard_tips");
        if (stringArray == null || 2 > stringArray.length) {
            return;
        }
        String str = stringArray[0];
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < stringArray.length - 1; i2++) {
            sb.append(stringArray[i2]);
        }
        String str2 = stringArray[stringArray.length - 1];
        final PromptTipDialog promptTipDialog = new PromptTipDialog(this.f25142d);
        promptTipDialog.setTitleMessage(str);
        promptTipDialog.setMessage(sb.toString());
        promptTipDialog.setButtonMessage(str2);
        promptTipDialog.setDefaultBtnListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                promptTipDialog.dismiss();
            }
        });
        promptTipDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean C() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String D() {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean E() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean F() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a() {
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(BindFastRequest bindFastRequest) {
        this.f25143e = bindFastRequest;
    }

    public void a(String... strArr) {
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void b(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        this.s = certificateTypeInfo;
    }

    public void b(String... strArr) {
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean b() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String c() {
        return "";
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void c(String... strArr) {
        if (this.f25140b == null) {
            this.f25140b = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f25142d, 5, BindCardBaseActivity.BEAN_TAG);
        }
        this.f25140b.setResponseCallback(this.f25142d);
        StatisticManager.onEventStart(StatServiceEvent.TIME_SMS);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
        PayStatisticsUtil.onEvent(StatServiceEvent.GET_SMS_CODE);
        b(strArr);
        this.f25140b.a(this.f25143e);
        this.f25140b.execBean();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void d(String... strArr) {
        if (this.f25139a == null) {
            this.f25139a = (t) PayBeanFactory.getInstance().getBean((Context) this.f25142d, 4, BindCardBaseActivity.BEAN_TAG);
        }
        this.f25139a.a(this.f25143e);
        this.f25139a.setResponseCallback(this.f25142d);
        a(strArr);
        PayStatisticsUtil.onEventStart(StatServiceEvent.GET_CARD_INFO);
        this.f25139a.execBean();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean d() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean e() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void f() {
        if (this.f25139a != null) {
            BeanManager.getInstance().removeBean(this.f25139a);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean g() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().getFormatUserName());
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String h() {
        return PayDataCache.getInstance().getUserName();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean i() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean j() {
        return this.f25145g;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean k() {
        return this.f25144f || this.m;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean l() {
        return this.f25146h || this.l;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean m() {
        return this.f25147i || this.o;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean n() {
        return this.j || this.n;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void o() {
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String p() {
        return ResUtils.getString(this.f25142d, "ebpay_card_tip");
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean q() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void r() {
        int i2;
        ErrorContentResponse errorContentResponse;
        if ((this instanceof g) || (this instanceof h)) {
            BindFastRequest bindFastRequest = this.f25143e;
            if (bindFastRequest != null && (errorContentResponse = bindFastRequest.mCardInfoUpdateContent) != null) {
                this.m = errorContentResponse.isNeedValidCode();
                this.l = this.f25143e.mCardInfoUpdateContent.isNeedValidDate();
                this.n = this.f25143e.mCardInfoUpdateContent.isNeedPhoneNum();
                this.o = this.f25143e.mCardInfoUpdateContent.isNeedId();
                this.p = this.f25143e.mCardInfoUpdateContent.isNeedType();
                ErrorContentResponse errorContentResponse2 = this.f25143e.mCardInfoUpdateContent;
                GetCardInfoResponse.CardItemRequired cardItemRequired = errorContentResponse2.card_item_required;
                if (cardItemRequired != null) {
                    this.f25144f = this.f25144f || errorContentResponse2.needUpdate(cardItemRequired.valid_code);
                    this.f25146h = this.f25146h || this.f25143e.mCardInfoUpdateContent.needUpdate(cardItemRequired.valid_date);
                    this.f25145g = this.f25145g || this.f25143e.mCardInfoUpdateContent.needUpdate(cardItemRequired.true_name);
                    this.k = this.k || this.f25143e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_type);
                    this.f25147i = this.f25147i || this.f25143e.mCardInfoUpdateContent.needUpdate(cardItemRequired.certificate_code);
                    this.j = this.j || this.f25143e.mCardInfoUpdateContent.needUpdate(cardItemRequired.mobile);
                }
            }
            BindCardBaseActivity bindCardBaseActivity = this.f25142d;
            if (bindCardBaseActivity != null) {
                if (bindCardBaseActivity.isShowWithHalfScreeen()) {
                    BindCardImplActivity bindCardImplActivity = (BindCardImplActivity) this.f25142d;
                    BankCvv2InfoView bankCvv2InfoView = bindCardImplActivity.mBankCvv2InfoView;
                    BankUserInfoView bankUserInfoView = bindCardImplActivity.mBankUserInfoView;
                    if (this.f25144f) {
                        bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (this.f25146h) {
                        i2++;
                        bankCvv2InfoView.getDateInputView().getEditableText().toString();
                    }
                    if (this.f25147i) {
                        i2++;
                        bankUserInfoView.getIdEditText().getEditableText().toString();
                    }
                    if (this.j) {
                        i2++;
                        bankUserInfoView.getMobileEditText().getEditableText().toString();
                    }
                    if (2 < i2 || this.f25145g) {
                        Intent intent = new Intent();
                        intent.putExtra("halfScreen", this.f25145g ? 0 : i2);
                        intent.putExtra("reasonForChangeCardItem", 2);
                        bindCardImplActivity.updateUiMode(intent);
                    }
                }
                this.f25142d.updateBankTitleInfo(null, true);
                this.f25142d.updateCvv2Info(this.m, this.l, this.n);
                this.f25142d.updateCardElement(k(), l(), j(), m(), n());
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean s() {
        BindFastRequest bindFastRequest = this.f25143e;
        return (bindFastRequest == null || bindFastRequest.mCardInfoUpdateContent == null) ? false : true;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean t() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a u() {
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

    @Override // com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        BindFastRequest bindFastRequest = this.f25143e;
        if (bindFastRequest != null) {
            if (bindFastRequest.getmBankInfo() != null && this.f25143e.getmBankInfo().channel_info != null) {
                return this.f25143e.getmBankInfo().channel_info.certificate_type_info;
            }
            if (this.f25143e.getmBondCard() != null) {
                return this.f25143e.getmBondCard().certificate_type_info;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo w() {
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

    @Override // com.baidu.wallet.paysdk.b.j
    public int x() {
        if (v() == null) {
            return 0;
        }
        return v().length;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public boolean y() {
        return PayDataCache.getInstance().isShowDetection();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public ArrayList<CharSequence> z() {
        ArrayList<CharSequence> arrayList = new ArrayList<>();
        arrayList.add(A());
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(String str) {
        LogUtil.d(j.q, "执行查询银行卡的归属银行");
        if (this.f25141c == null) {
            this.f25141c = (aa) PayBeanFactory.getInstance().getBean((Context) this.f25142d, 7, BindCardBaseActivity.BEAN_TAG);
        }
        this.f25141c.setResponseCallback(this.f25142d);
        this.f25141c.a(str);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_BIN);
        this.f25141c.execBean();
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public void a(BindCardBaseActivity bindCardBaseActivity) {
        this.f25142d = bindCardBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public String[] a(int i2) {
        String[] strArr = new String[2];
        String string = ResUtils.getString(this.f25142d, "bd_wallet_bind_card_first");
        if (i2 == 0) {
            string = ResUtils.getString(this.f25142d, "bd_wallet_bind_card_first");
        } else if (i2 == 1) {
            string = ResUtils.getString(this.f25142d, "bd_wallet_bind_card_second");
        }
        String string2 = ResUtils.getString(this.f25142d, "ebpay_pay_checkcard");
        if (i2 == 0) {
            string2 = ResUtils.getString(this.f25142d, "ebpay_pay_checkcard");
        } else if (i2 == 1) {
            string2 = ResUtils.getString(this.f25142d, "ebpay_pay_next");
        }
        strArr[0] = string;
        strArr[1] = string2;
        return strArr;
    }

    @Override // com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
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

    public boolean a(String str, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        if (certificateTypeInfoArr != null && certificateTypeInfoArr.length > 0 && !TextUtils.isEmpty(str)) {
            for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo : certificateTypeInfoArr) {
                if (certificateTypeInfo != null && str.equals(certificateTypeInfo.type)) {
                    return true;
                }
            }
        }
        return false;
    }
}
