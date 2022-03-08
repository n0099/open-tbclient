package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.b.a;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.widget.c;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes6.dex */
public class NewBindCardMainActivity extends PayBaseActivity implements View.OnClickListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "NewBindCardMainActivity";
    public static final String BIND_CARD_NUMBER = "bindCardNumber";
    public static final int CARD_DATE_LENGTH = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public LinearLayout C;
    public LinearLayout D;
    public LinearLayout E;
    public LinearLayout F;
    public LinearLayout G;
    public DivisionEditText H;
    public DivisionEditText I;
    public NetImageView J;
    public View K;
    public View L;
    public View M;
    public View N;
    public View O;
    public View P;
    public CheckBox Q;
    public String R;
    public String S;
    public String T;
    public GetCardInfoResponse.CertificateTypeInfo[] U;
    public GetCardInfoResponse.CertificateTypeInfo V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public c Z;
    public ViewGroup a;
    public boolean aa;
    public a ab;
    public String ac;

    /* renamed from: b  reason: collision with root package name */
    public SafeScrollView f50397b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50398c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50399d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50400e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50401f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50402g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50403h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50404i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f50405j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public RelativeLayout n;
    public ImageView o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public SafeKeyBoardEditText u;
    public SafeKeyBoardEditText v;
    public SafeKeyBoardEditText w;
    public SafeKeyBoardEditText x;
    public LinearLayout y;
    public LinearLayout z;

    public NewBindCardMainActivity() {
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
        this.W = true;
        this.X = true;
        this.Y = true;
        this.aa = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        SafeScrollView safeScrollView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.ab.a(this.s, motionEvent)) {
                    h();
                } else if (this.ab.a(this.o, motionEvent)) {
                    this.ab.a(this.u, this.o);
                } else if (this.ab.a(this.q, motionEvent)) {
                    this.ab.a(this.w, this.q);
                } else if (this.ab.a(this.r, motionEvent)) {
                    this.ab.a(this.x, this.r);
                } else if (!this.ab.a(this.t, motionEvent) && (safeScrollView = this.f50397b) != null && safeScrollView.isShouldHideInput(getCurrentFocus(), motionEvent)) {
                    if (this.f50397b.isPopupWindowShowing()) {
                        i();
                    } else {
                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
                        }
                        this.L.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_E0EA"));
                        this.u.clearFocus();
                    }
                    this.ab.c(this.u, this.o);
                    this.ab.c(this.I, this.s);
                    this.ab.c(this.w, this.q);
                    this.ab.c(this.x, this.r);
                    this.t.setVisibility(8);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) && i2 == 5) {
            if (i3 == -8) {
                if (TextUtils.isEmpty(str)) {
                    str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                }
                GlobalUtils.toast(this, str);
                return;
            }
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, 12, "");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) && i2 == 5) {
            this.ab.a(i2, obj, str);
        }
    }

    public void initBankCardInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            this.H.setEnabled(false);
            this.H.setText(this.R);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                this.z.setVisibility(0);
                this.J.setImageUrl(str);
                TextView textView = this.f50400e;
                textView.setText(str2 + " " + str3);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void initBindCardUi(String str, UserData.UserModel.DisplayFlag displayFlag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, displayFlag) == null) {
            this.S = str;
            if (!TextUtils.isEmpty(str)) {
                this.Y = true;
                this.u.setText(this.S);
            }
            this.ab.a(this.u);
            if (displayFlag != null) {
                if ("1".equals(displayFlag.true_name)) {
                    this.C.setVisibility(8);
                } else if ("2".equals(displayFlag.true_name)) {
                    this.C.setVisibility(0);
                    this.u.setEnabled(false);
                    this.u.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
                } else if ("3".equals(displayFlag.true_name)) {
                    this.C.setVisibility(0);
                    this.u.setEnabled(true);
                    this.u.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                }
                if ("1".equals(displayFlag.certificate_type)) {
                    this.p.setVisibility(8);
                    this.t.setVisibility(8);
                } else if ("2".equals(displayFlag.certificate_type)) {
                    this.y.setVisibility(0);
                    this.p.setVisibility(8);
                    this.t.setVisibility(8);
                } else if ("3".equals(displayFlag.certificate_type)) {
                    this.y.setVisibility(0);
                    this.p.setVisibility(0);
                    if (TextUtils.isEmpty(this.v.getText())) {
                        this.t.setVisibility(8);
                    } else {
                        this.t.setVisibility(0);
                    }
                }
                if ("1".equals(displayFlag.certificate_code)) {
                    this.y.setVisibility(8);
                    this.t.setVisibility(8);
                } else if ("2".equals(displayFlag.certificate_code)) {
                    this.y.setVisibility(0);
                    this.v.setEnabled(false);
                    this.v.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
                    this.t.setVisibility(8);
                } else if ("3".equals(displayFlag.certificate_code)) {
                    this.y.setVisibility(0);
                    this.v.setEnabled(true);
                    this.v.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                    SafeKeyBoardEditText safeKeyBoardEditText = this.v;
                    safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.f50397b, safeKeyBoardEditText, false);
                    if (TextUtils.isEmpty(this.v.getText())) {
                        this.t.setVisibility(8);
                    } else {
                        this.t.setVisibility(0);
                    }
                }
                if ("1".equals(displayFlag.mobile)) {
                    this.n.setVisibility(8);
                    this.K.setVisibility(8);
                    this.B.setVisibility(8);
                } else if ("2".equals(displayFlag.mobile)) {
                    this.n.setVisibility(0);
                    this.K.setVisibility(8);
                    this.I.setEnabled(false);
                    this.I.setFormatEnable(false);
                    this.I.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_667A"));
                    this.I.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                } else if ("3".equals(displayFlag.mobile)) {
                    this.n.setVisibility(0);
                    this.K.setVisibility(8);
                    this.I.setEnabled(true);
                    this.I.setFormatEnable(true);
                    this.I.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                    this.I.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                    DivisionEditText divisionEditText = this.I;
                    divisionEditText.initSafeKeyBoardParams(this.a, this.f50397b, divisionEditText, false);
                }
            }
        }
    }

    public void initCardDateAndCvv2(GetCardInfoResponse.CardItemRequired cardItemRequired) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cardItemRequired) == null) {
            if (cardItemRequired != null) {
                if ("1".equals(cardItemRequired.valid_date)) {
                    this.D.setVisibility(0);
                    SafeKeyBoardEditText safeKeyBoardEditText = this.w;
                    safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.f50397b, safeKeyBoardEditText, false);
                } else {
                    this.D.setVisibility(8);
                }
                if ("1".equals(cardItemRequired.valid_code)) {
                    this.E.setVisibility(0);
                    SafeKeyBoardEditText safeKeyBoardEditText2 = this.x;
                    safeKeyBoardEditText2.initSafeKeyBoardParams(this.a, this.f50397b, safeKeyBoardEditText2, false);
                    return;
                }
                this.E.setVisibility(8);
                return;
            }
            this.D.setVisibility(8);
            this.E.setVisibility(8);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (this.m == view) {
                onBackPressed();
            } else if (this.A == view) {
                if (this.p.getVisibility() == 0) {
                    a(PayStatServiceEvent.NEW_CERTIFICATE_TYPE_DIALOG);
                    g();
                }
            } else if (this.G == view) {
                a(PayStatServiceEvent.NEW_CLICK_BIND_CARD);
                if (this.Q.isChecked()) {
                    f();
                } else {
                    WalletGlobalUtils.safeShowDialog(this, 32, "");
                }
            } else if (this.B == view) {
                if (TextUtils.isEmpty(this.f50401f.getText().toString().trim())) {
                    return;
                }
                this.X = true;
                this.aa = true;
                this.I.setText(this.f50401f.getText().toString());
                this.aa = false;
                this.ab.a(this.I);
                DivisionEditText divisionEditText = this.I;
                divisionEditText.setSelection(divisionEditText.getText().toString().length());
                this.I.requestFocus();
                this.B.setVisibility(8);
            } else if (this.o == view) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_name_tip");
                WalletGlobalUtils.safeShowDialog(this, 14, "");
            } else if (this.s == view) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_mobile_tip");
                WalletGlobalUtils.safeShowDialog(this, 13, "");
            } else if (this.q == view) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "new_bindcard_date_tip");
                WalletGlobalUtils.safeShowDialog(this, 56, "");
            } else if (this.r == view) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_cvv2_tip");
                WalletGlobalUtils.safeShowDialog(this, 2, "");
            } else {
                ImageView imageView = this.t;
                if (imageView == view && imageView.getVisibility() == 0) {
                    this.v.setText("");
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.wallet_cashdesk_new_bind_card_main_activity);
            a a = com.baidu.wallet.newbindcard.a.a.a(80, this);
            this.ab = a;
            if (a == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity Presenter is null", false);
                finishWithoutAnim();
                return;
            }
            a.a(bundle);
            this.ab.a();
            this.R = getIntent().getStringExtra(BIND_CARD_NUMBER);
            a();
            a(PayStatServiceEvent.NEW_ENTER_BIND_CARD_PAGE);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 != 2) {
                if (i2 != 32) {
                    if (i2 != 56) {
                        switch (i2) {
                            case 12:
                                break;
                            case 13:
                            case 14:
                                break;
                            default:
                                return super.onCreateDialog(i2);
                        }
                    }
                    return new PromptTipDialog(this);
                }
                return new PromptDialog(this);
            }
            return new PromptImageDialog(this);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BeanManager.getInstance().removeAllBeans(BEAN_TAG);
            c cVar = this.Z;
            if (cVar != null) {
                cVar.dismiss();
                this.Z.a();
                this.Z = null;
            }
            i();
            a aVar = this.ab;
            if (aVar != null) {
                aVar.j();
                this.ab = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view, z) == null) {
            if (view == this.u) {
                this.ab.a(this.L, z ? 1 : 0);
                this.ab.a(this.u, this.o);
                if (z) {
                    this.ab.c(this.I, this.s);
                    this.ab.c(this.w, this.q);
                    this.ab.c(this.x, this.r);
                    this.t.setVisibility(8);
                    return;
                }
                return;
            }
            SafeKeyBoardEditText safeKeyBoardEditText = this.v;
            if (view == safeKeyBoardEditText) {
                if (z) {
                    if (safeKeyBoardEditText.isEnabled() && !TextUtils.isEmpty(this.v.getText())) {
                        this.t.setVisibility(0);
                    } else {
                        this.t.setVisibility(8);
                    }
                    this.f50404i.setVisibility(8);
                    this.ab.a(this.M, 1);
                    this.ab.c(this.I, this.s);
                    this.ab.c(this.w, this.q);
                    this.ab.c(this.x, this.r);
                } else if (this.ab.a(this.y, safeKeyBoardEditText, this.V, this.W) && !TextUtils.isEmpty(this.v.getText())) {
                    this.f50404i.setVisibility(0);
                    this.ab.a(this.M, 2);
                } else {
                    this.f50404i.setVisibility(8);
                    this.ab.a(this.M, 0);
                }
            } else if (view == this.H) {
                this.ab.a(this.N, z ? 1 : 0);
            } else {
                SafeKeyBoardEditText safeKeyBoardEditText2 = this.w;
                if (view == safeKeyBoardEditText2) {
                    this.ab.a(safeKeyBoardEditText2, this.q);
                    if (z) {
                        this.k.setVisibility(8);
                        this.t.setVisibility(8);
                        this.ab.a(this.O, 1);
                        this.ab.c(this.I, this.s);
                        this.ab.c(this.u, this.o);
                        this.ab.c(this.x, this.r);
                        return;
                    } else if (this.ab.a(this.D, this.w) && !TextUtils.isEmpty(this.w.getText())) {
                        this.k.setVisibility(0);
                        this.ab.a(this.O, 2);
                        return;
                    } else {
                        this.k.setVisibility(8);
                        this.ab.a(this.O, 0);
                        return;
                    }
                }
                SafeKeyBoardEditText safeKeyBoardEditText3 = this.x;
                if (view == safeKeyBoardEditText3) {
                    this.ab.a(safeKeyBoardEditText3, this.r);
                    if (z) {
                        this.l.setVisibility(8);
                        this.t.setVisibility(8);
                        this.ab.a(this.P, 1);
                        this.ab.c(this.I, this.s);
                        this.ab.c(this.u, this.o);
                        this.ab.c(this.w, this.q);
                    } else if (this.ab.b(this.E, this.x) && !TextUtils.isEmpty(this.x.getText())) {
                        this.l.setVisibility(0);
                        this.ab.a(this.P, 2);
                    } else {
                        this.l.setVisibility(8);
                        this.ab.a(this.P, 0);
                    }
                } else if (view == this.I) {
                    h();
                    if (z) {
                        if (TextUtils.isEmpty(this.I.getRealText())) {
                            d();
                            this.ab.a(this.K, 1);
                        } else {
                            this.B.setVisibility(8);
                            this.K.setVisibility(8);
                        }
                        this.ab.c(this.u, this.o);
                        this.ab.c(this.w, this.q);
                        this.ab.c(this.x, this.r);
                        this.f50405j.setVisibility(8);
                        this.t.setVisibility(8);
                    } else if (!this.ab.a(this.n, this.I, this.X) || TextUtils.isEmpty(this.I.getText())) {
                    } else {
                        this.K.setVisibility(0);
                        this.f50405j.setVisibility(0);
                        this.ab.a(this.K, 2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, dialog) == null) {
            if (i2 == 2) {
                PromptImageDialog promptImageDialog = (PromptImageDialog) dialog;
                promptImageDialog.setMessage(this.mDialogMsg);
                a(PayStatServiceEvent.NEW_SHOW_CVV_DIALOG);
                promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_cvv2_tip_title"));
                promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_cvv"));
            } else if (i2 == 32) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
                promptDialog.setMessage("请确认您已经阅读并同意相关协议内容");
                promptDialog.setCanceledOnTouchOutside(false);
                a(PayStatServiceEvent.NEW_SHOW_PROTOCOL_DIALOG);
                promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewBindCardMainActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.Q.setChecked(false);
                            this.a.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL_DIALOG_CANCEL);
                            WalletGlobalUtils.safeDismissDialog(this.a, 32);
                        }
                    }
                });
                promptDialog.setPositiveBtn("已确认同意", new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewBindCardMainActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.Q.setChecked(true);
                            this.a.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL_DIALOG_COMIT);
                            WalletGlobalUtils.safeDismissDialog(this.a, 32);
                            this.a.f();
                        }
                    }
                });
            } else if (i2 != 56) {
                switch (i2) {
                    case 12:
                        PromptDialog promptDialog2 = (PromptDialog) dialog;
                        promptDialog2.setMessage(this.mDialogMsg);
                        promptDialog2.setCanceledOnTouchOutside(false);
                        a(PayStatServiceEvent.NEW_CARD_CHECK_ERR_DIALOG);
                        promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.11
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NewBindCardMainActivity a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    this.a.a(PayStatServiceEvent.NEW_CARD_CHECK_ERR_CLICK);
                                    WalletGlobalUtils.safeDismissDialog(this.a, 12);
                                }
                            }
                        });
                        promptDialog2.hideNegativeButton();
                        return;
                    case 13:
                        PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
                        promptTipDialog.setMessage(this.mDialogMsg);
                        a(PayStatServiceEvent.NEW_SHOW_PHONE_DIALOG);
                        promptTipDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_bank_phone"));
                        return;
                    case 14:
                        PromptTipDialog promptTipDialog2 = (PromptTipDialog) dialog;
                        promptTipDialog2.setMessage(this.mDialogMsg);
                        a(PayStatServiceEvent.NEW_SHOW_NAME_DIALOG);
                        promptTipDialog2.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_name_title"));
                        return;
                    default:
                        super.onPrepareDialog(i2, dialog);
                        return;
                }
            } else {
                a(PayStatServiceEvent.NEW_SHOW_DATE_DIALOG);
                PromptTipDialog promptTipDialog3 = (PromptTipDialog) dialog;
                promptTipDialog3.setMessage(this.mDialogMsg);
                promptTipDialog3.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_date_tip_title"));
            }
        }
    }

    public void setBindCardProtocol(GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, protocolPlatformInfo) == null) {
            if (protocolPlatformInfo != null) {
                this.Q.setChecked(protocolPlatformInfo.isProtocolCheckedDefault());
                if (protocolPlatformInfo != null && !TextUtils.isEmpty(protocolPlatformInfo.prefix) && !TextUtils.isEmpty(protocolPlatformInfo.prefix)) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
                    spannableStringBuilder.append((CharSequence) (protocolPlatformInfo.prefix + " "));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
                    spannableStringBuilder.append((CharSequence) "《");
                    spannableStringBuilder.append((CharSequence) protocolPlatformInfo.main_title);
                    spannableStringBuilder.append((CharSequence) "》");
                    spannableStringBuilder.setSpan(new ClickableSpan(this, protocolPlatformInfo) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ GetCardInfoResponse.ProtocolPlatformInfo a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ NewBindCardMainActivity f50406b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, protocolPlatformInfo};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f50406b = this;
                            this.a = protocolPlatformInfo;
                        }

                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            String obj;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f50406b.a(PayStatServiceEvent.NEW_CLICK_PROTOCOL);
                                Intent intent = new Intent(this.f50406b.getActivity(), BindCardProtocolActivity.class);
                                if (NewBindCardEntry.getInstance().getBindCategory() != null) {
                                    intent.putExtra("baidu.wallet.from", NewBindCardEntry.getInstance().getBindCategory().name());
                                } else {
                                    intent.putExtra("baidu.wallet.from", PayRequestCache.BindCategory.Initiative.name());
                                }
                                intent.putExtra(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, this.a.snapshotId);
                                if (TextUtils.isEmpty(this.f50406b.S)) {
                                    obj = this.f50406b.u.getText().toString();
                                } else {
                                    obj = this.f50406b.S;
                                }
                                intent.putExtra(BindCardProtocolActivity.TRUE_NAME, obj);
                                intent.putExtra("identity_code", this.f50406b.v.getText().toString());
                                intent.putExtra("mobile", this.f50406b.I.getText().toString());
                                intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, this.f50406b.T);
                                intent.putExtra("card_no", this.f50406b.R);
                                this.f50406b.startActivityWithoutAnim(intent);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                                textPaint.setColor(ResUtils.getColor(this.f50406b.getActivity(), "dxm_wallet_base_color_clickable"));
                            }
                        }
                    }, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
                    this.f50402g.setEnabled(true);
                    this.f50402g.setMovementMethod(LinkMovementMethod.getInstance());
                    this.f50402g.setHintTextColor(-1);
                    this.f50402g.setText(spannableStringBuilder);
                    return;
                }
                this.F.setVisibility(8);
                return;
            }
            this.F.setVisibility(8);
        }
    }

    public void setCertificateCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.W = true;
                this.v.setText(str);
                SafeKeyBoardEditText safeKeyBoardEditText = this.v;
                safeKeyBoardEditText.setSelection(safeKeyBoardEditText.getText().toString().length());
            } else {
                this.W = false;
                this.v.setText("");
            }
            this.ab.a(this.v);
        }
    }

    public void setCertificateType(String str, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048591, this, str, certificateTypeInfoArr) != null) {
            return;
        }
        this.T = str;
        this.U = certificateTypeInfoArr;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = this.U;
            this.V = certificateTypeInfoArr2[0];
            this.f50399d.setText(certificateTypeInfoArr2[0].description);
            this.ab.a(this.v, this.U[0].type);
            return;
        }
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr3 = this.U;
        if (certificateTypeInfoArr3 == null || certificateTypeInfoArr3.length <= 0) {
            return;
        }
        while (true) {
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr4 = this.U;
            if (i2 >= certificateTypeInfoArr4.length) {
                return;
            }
            if (this.T.equals(certificateTypeInfoArr4[i2].type)) {
                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr5 = this.U;
                this.V = certificateTypeInfoArr5[i2];
                this.f50399d.setText(certificateTypeInfoArr5[i2].description);
                this.ab.a(this.v, this.U[i2].type);
                return;
            }
            i2++;
        }
    }

    public void setPhoneTip(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            this.ac = str;
            d();
            if (i2 == 0) {
                this.f50403h.setText("点击填入您的手机号");
            } else {
                this.f50403h.setText("点击填入您的登录手机号");
            }
            this.f50401f.setText(str);
        }
    }

    public void setUserPhone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.X = true;
                this.I.setText(str);
                this.B.setVisibility(8);
                this.K.setVisibility(8);
                DivisionEditText divisionEditText = this.I;
                divisionEditText.setSelection(divisionEditText.getText().toString().length());
            } else {
                this.X = false;
                this.I.setText("");
                if (this.I.hasFocus()) {
                    d();
                }
            }
            this.ab.a(this.I);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (TextUtils.isEmpty(this.ac)) {
                this.B.setVisibility(8);
                this.K.setVisibility(8);
                return;
            }
            this.B.setVisibility(0);
            this.K.setVisibility(0);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.u.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NewBindCardMainActivity a;

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
                    this.a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.a.ab.a(this.a.u);
                        this.a.ab.a(this.a.u, this.a.o);
                        this.a.Y = false;
                        this.a.c();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.v.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NewBindCardMainActivity a;

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
                    this.a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.a.ab.a(this.a.v);
                        if (TextUtils.isEmpty(this.a.v.getText())) {
                            this.a.t.setVisibility(8);
                        } else {
                            this.a.t.setVisibility(0);
                            this.a.ab.b(this.a.v, this.a.t);
                        }
                        this.a.W = false;
                        this.a.c();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.I.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NewBindCardMainActivity a;

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
                    this.a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.a.X = false;
                        this.a.h();
                        if (TextUtils.isEmpty(this.a.I.getRealText())) {
                            this.a.ab.a(this.a.I);
                            this.a.d();
                            this.a.ab.a(this.a.K, 1);
                        } else {
                            this.a.ab.a(this.a.I);
                            this.a.B.setVisibility(8);
                            this.a.K.setVisibility(8);
                            if (this.a.I.getRealText().contains("*")) {
                                if (!this.a.aa) {
                                    this.a.I.setText("");
                                }
                                this.a.X = true;
                                this.a.ab.a(this.a.I);
                                if (this.a.I.getRealText().length() < 11) {
                                    this.a.G.setEnabled(false);
                                    return;
                                }
                            }
                        }
                        this.a.c();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.w.addTextChangedListener(new TextWatcher(this, new StringBuilder()) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StringBuilder a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NewBindCardMainActivity f50407b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50407b = this;
                    this.a = r7;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.f50407b.ab.a(this.f50407b.w);
                        this.f50407b.ab.a(this.f50407b.w, this.f50407b.q);
                        this.f50407b.c();
                        if (TextUtils.isEmpty(this.f50407b.w.getText())) {
                            return;
                        }
                        String obj = this.f50407b.w.getText().toString();
                        if (this.a.toString().equals(obj)) {
                            return;
                        }
                        StringBuilder sb = this.a;
                        sb.delete(0, sb.length());
                        this.a.append(obj.replace("/", ""));
                        if (this.a.length() > 2) {
                            this.a.insert(2, "/");
                        }
                        this.f50407b.w.setText(this.a);
                        this.f50407b.w.setSelection(this.a.length());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.x.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NewBindCardMainActivity a;

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
                    this.a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.a.ab.a(this.a.x);
                        this.a.ab.a(this.a.x, this.a.r);
                        this.a.c();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            String trim = this.Y ? this.S : this.u.getText().toString().trim();
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.V;
            this.ab.a(trim, certificateTypeInfo != null ? certificateTypeInfo.type : "", this.v.getText().toString().trim(), this.I.getRealText(), !TextUtils.isEmpty(this.w.getText()) ? this.w.getText().toString().trim().replaceAll("/", "") : "", this.x.getText().toString().trim());
        }
    }

    private void g() {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (certificateTypeInfoArr = this.U) == null || certificateTypeInfoArr.length <= 0) {
            return;
        }
        i();
        if (this.Z == null) {
            this.Z = new c(this);
        }
        if (this.Z.isShowing()) {
            this.Z.dismiss();
        }
        this.Z.a(this.U);
        this.Z.a(this.a);
        a(0.3f);
        this.Z.a(new c.a(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewBindCardMainActivity a;

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
                this.a = this;
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.c.a
            public void a(View view, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, view, certificateTypeInfo, i2) == null) {
                    this.a.V = certificateTypeInfo;
                    if (certificateTypeInfo != null) {
                        com.baidu.wallet.newbindcard.c.a.a(PayStatServiceEvent.NEW_CLICK_CERTIFICATE_TYPE, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), com.baidu.wallet.newbindcard.c.a.c(), com.baidu.wallet.newbindcard.c.a.d(), certificateTypeInfo.type);
                        this.a.ab.a(this.a.v, certificateTypeInfo.type);
                        this.a.f50399d.setText(certificateTypeInfo.description);
                    }
                }
            }
        });
        this.Z.setOnDismissListener(new PopupWindow.OnDismissListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewBindCardMainActivity a;

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
                this.a = this;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.a(PayStatServiceEvent.NEW_CLOSE_CERTIFICATE_TYPE_DIALOG);
                    this.a.a(1.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (!TextUtils.isEmpty(this.I.getRealText()) && this.I.isEnabled() && this.I.hasFocus()) {
                this.ab.b(this.I, this.s);
            } else {
                this.ab.c(this.I, this.s);
            }
        }
    }

    private void i() {
        SafeScrollView safeScrollView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && (safeScrollView = this.f50397b) != null && safeScrollView.isPopupWindowShowing()) {
            this.v.clearFocus();
            this.I.clearFocus();
            this.w.clearFocus();
            this.x.clearFocus();
            this.f50397b.dismissKeyBoard();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.v.setUseSafeKeyBoard(true);
            this.v.setUseKeyX(true);
            this.H.setUseSafeKeyBoard(true);
            this.H.setViewType(25);
            this.u.setUseSafeKeyBoard(false);
            this.u.setUseKeyX(false);
            this.I.setUseSafeKeyBoard(true);
            this.I.setViewType(13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.C.getVisibility() == 0 && this.u.isEnabled()) {
                if (TextUtils.isEmpty(this.u.getText())) {
                    this.G.setEnabled(false);
                    return;
                } else if (!CheckUtils.isUserNameAvailable(this.u.getText().toString().trim())) {
                    this.G.setEnabled(false);
                    return;
                }
            }
            if (this.ab.a(this.y, this.v, this.V, this.W)) {
                if (TextUtils.isEmpty(this.v.getText())) {
                    this.G.setEnabled(false);
                    return;
                }
                if ("1".equals(this.V.type) && this.v.getText().toString().trim().length() == 18) {
                    this.f50404i.setVisibility(0);
                    this.ab.a(this.M, 2);
                } else {
                    this.f50404i.setVisibility(8);
                    this.ab.a(this.M, 1);
                }
                this.G.setEnabled(false);
            } else if (this.ab.a(this.D, this.w)) {
                if (!TextUtils.isEmpty(this.w.getText())) {
                    if (this.w.getText().length() == 5) {
                        this.k.setVisibility(0);
                        this.ab.a(this.O, 2);
                    } else {
                        this.k.setVisibility(8);
                        this.ab.a(this.O, 1);
                    }
                }
                this.G.setEnabled(false);
            } else if (this.ab.b(this.E, this.x)) {
                this.G.setEnabled(false);
            } else if (this.ab.a(this.n, this.I, this.X)) {
                if (!TextUtils.isEmpty(this.I.getRealText())) {
                    if (this.I.getRealText().length() == 11) {
                        this.K.setVisibility(0);
                        this.f50405j.setVisibility(0);
                        this.ab.a(this.K, 2);
                    } else {
                        this.f50405j.setVisibility(8);
                    }
                }
                this.G.setEnabled(false);
            } else {
                this.G.setEnabled(true);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a = (ViewGroup) findViewById(R.id.new_bind_card_main_activity);
            this.f50397b = (SafeScrollView) findViewById(R.id.scroll_bindcard_main);
            this.f50398c = (TextView) findViewById(R.id.tv_red_button_txt);
            this.m = (RelativeLayout) findViewById(R.id.title_left_imgzone2);
            this.C = (LinearLayout) findViewById(R.id.lin_user_name);
            this.o = (ImageView) findViewById(R.id.iv_new_bind_card_name_tip_icon);
            this.u = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_user_name);
            this.y = (LinearLayout) findViewById(R.id.lin_user_id_card);
            this.A = (LinearLayout) findViewById(R.id.lin_user_type);
            this.f50399d = (TextView) findViewById(R.id.tv_user_type);
            this.p = (ImageView) findViewById(R.id.iv_user_type_icon);
            this.v = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_user_id_card);
            this.H = (DivisionEditText) findViewById(R.id.et_new_bank_card_no);
            this.z = (LinearLayout) findViewById(R.id.lin_new_bank_card_info);
            this.J = (NetImageView) findViewById(R.id.iv_new_bankinfo_logo);
            this.f50400e = (TextView) findViewById(R.id.tv_new_bankinfo_name);
            this.D = (LinearLayout) findViewById(R.id.lin_bind_card_date);
            this.q = (ImageView) findViewById(R.id.iv_new_bind_card_date_icon);
            this.w = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_date);
            this.E = (LinearLayout) findViewById(R.id.lin_bind_card_cvv2);
            this.r = (ImageView) findViewById(R.id.iv_new_bind_card_cvv2_icon);
            this.x = (SafeKeyBoardEditText) findViewById(R.id.et_new_bind_card_cvv2);
            this.n = (RelativeLayout) findViewById(R.id.relative_bind_card_phone);
            this.s = (ImageView) findViewById(R.id.iv_new_bind_card_phone_icon);
            this.I = (DivisionEditText) findViewById(R.id.et_new_bank_card_phone);
            this.f50401f = (TextView) findViewById(R.id.tv_bind_card_phone_tip);
            this.Q = (CheckBox) findViewById(R.id.cb_new_bind_card_protocol);
            this.f50402g = (TextView) findViewById(R.id.tv_new_bind_card_protocol);
            this.B = (LinearLayout) findViewById(R.id.lin_bind_card_phone_tip);
            this.F = (LinearLayout) findViewById(R.id.lin_bind_card_protocol);
            this.G = (LinearLayout) findViewById(R.id.btn_new_bank_card_submit);
            this.L = findViewById(R.id.view_line_user_name);
            this.M = findViewById(R.id.view_line_user_idcard);
            this.N = findViewById(R.id.view_line_bank_card);
            this.O = findViewById(R.id.view_line_card_date);
            this.P = findViewById(R.id.view_line_card_cvv2);
            this.K = findViewById(R.id.view_bind_card_phone_line);
            this.f50403h = (TextView) findViewById(R.id.tv_login_user_phone_tip);
            this.f50404i = (TextView) findViewById(R.id.tv_user_type_err);
            this.f50405j = (TextView) findViewById(R.id.tv_phone_err);
            this.k = (TextView) findViewById(R.id.tv_card_date_err);
            this.l = (TextView) findViewById(R.id.tv_card_cvv2_err);
            this.t = (ImageView) findViewById(R.id.iv_new_bind_card_user_clear_icon);
            this.G.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.B.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.f50398c.setText("确认");
            if (this.ab.k()) {
                this.G.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
            } else {
                this.G.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
            }
            b();
            this.ab.b();
            this.ab.c();
            this.ab.d();
            this.ab.e();
            this.ab.f();
            this.ab.h();
            c();
            this.ab.i();
            this.ab.g();
            this.u.setOnMyFocusChangeListener(this);
            this.v.setOnMyFocusChangeListener(this);
            this.H.setOnMyFocusChangeListener(this);
            this.w.setOnMyFocusChangeListener(this);
            this.x.setOnMyFocusChangeListener(this);
            this.I.setOnMyFocusChangeListener(this);
            e();
            this.ab.a(this.u, this.o);
            h();
            this.ab.a(this.w, this.q);
            this.ab.a(this.x, this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f2) == null) {
            getWindow().addFlags(2);
            this.a.setAlpha(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            com.baidu.wallet.newbindcard.c.a.a(str, com.baidu.wallet.newbindcard.c.a.a(), com.baidu.wallet.newbindcard.c.a.b(), com.baidu.wallet.newbindcard.c.a.c(), com.baidu.wallet.newbindcard.c.a.d());
        }
    }
}
