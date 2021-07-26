package com.baidu.wallet.fastpay.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.CustomAutoTextView;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import com.baidu.wallet.base.widget.FlowLayout;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.base.widget.PhoneHistoryFixView;
import com.baidu.wallet.base.widget.banner.BannerLayoutForAd;
import com.baidu.wallet.base.widget.compromtion.CommonPromotionView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.core.utils.contacts.ContactAssociationAdapter;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import com.baidu.wallet.fastpay.FastPayCallBackManager;
import com.baidu.wallet.fastpay.beans.FastPayBeanFactory;
import com.baidu.wallet.fastpay.beans.c;
import com.baidu.wallet.fastpay.beans.d;
import com.baidu.wallet.fastpay.datamodel.BannerChargeItemInfo;
import com.baidu.wallet.fastpay.datamodel.FastPayFacePromotionInfoResponse;
import com.baidu.wallet.fastpay.datamodel.GetBindMobileResponse;
import com.baidu.wallet.fastpay.datamodel.MenuItemInfo;
import com.baidu.wallet.fastpay.datamodel.MoreServiceItemInfo;
import com.baidu.wallet.fastpay.datamodel.PriceInfo;
import com.baidu.wallet.fastpay.datamodel.PromotionInfoResponse;
import com.baidu.wallet.fastpay.datamodel.QueryLocationResponse;
import com.baidu.wallet.fastpay.sdk.BaiduTraffic;
import com.baidu.wallet.fastpay.sdk.a;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.utils.AccessibilityUtils;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ChargeActivity extends BeanActivity implements View.OnClickListener, PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener, PhoneContactsMananger.LoadAddressInfoListener, a.b, ContactPermissionUtil.OnContactPermissionPhoneSelectListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public FlowLayout C;
    public boolean D;
    public final int E;
    public BdMenu F;
    public ArrayList<MenuItemInfo> G;
    public int H;
    public int I;
    public BdMenuItem.OnItemClickListener J;
    public LoginBackListenerProxy K;
    public long L;

    /* renamed from: a  reason: collision with root package name */
    public CustomAutoTextView f25017a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25018b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25019c;

    /* renamed from: d  reason: collision with root package name */
    public FlowLayout f25020d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f25021e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25022f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f25023g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f25024h;

    /* renamed from: i  reason: collision with root package name */
    public ContactAssociationAdapter f25025i;
    public boolean j;
    public StringBuilder k;
    public boolean l;
    public d m;
    public RelativeLayout n;
    public View o;
    public ScrollView p;
    public BdActionBar q;
    public QueryLocationResponse r;
    public RelativeLayout s;
    public PriceInfo[] t;
    public PriceInfo[] u;
    public PriceInfo v;
    public String w;
    public String x;
    public PhoneHistoryFixView y;
    public BannerLayoutForAd z;

    public ChargeActivity() {
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
        this.j = false;
        this.l = false;
        this.t = new PriceInfo[]{new PriceInfo(Constants.DEFAULT_UIN, null, null), new PriceInfo("2000", null, null), new PriceInfo("3000", null, null), new PriceInfo("5000", null, null), new PriceInfo("10000", null, null), new PriceInfo("20000", null, null), new PriceInfo("30000", null, null), new PriceInfo("50000", null, null)};
        this.w = "";
        this.x = "";
        this.D = true;
        this.E = 4;
        this.G = new ArrayList<>();
        this.J = new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChargeActivity f25026a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f25026a = this;
            }

            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem) {
                MenuItemInfo menuItemInfo;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem) == null) || bdMenuItem == null || bdMenuItem.getItemId() >= this.f25026a.G.size() || (menuItemInfo = (MenuItemInfo) this.f25026a.G.get(bdMenuItem.getItemId())) == null) {
                    return;
                }
                DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24959a, Arrays.asList(menuItemInfo.title));
                PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24959a, menuItemInfo.title);
                int i4 = menuItemInfo.link_type;
                if (i4 != 1) {
                    if (i4 == 3 && TextUtils.equals(Constants.VIA_REPORT_TYPE_START_WAP, menuItemInfo.link_url)) {
                        this.f25026a.j();
                        return;
                    }
                    return;
                }
                WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this.f25026a, new ILoginBackListener(this, menuItemInfo) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ MenuItemInfo f25027a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f25028b;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr = {this, menuItemInfo};
                            interceptable3.invokeUnInit(65536, newInitContext2);
                            int i5 = newInitContext2.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext2.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f25028b = this;
                        this.f25027a = menuItemInfo;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i5, String str) {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i5, str) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i5, String str) {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, str) == null) {
                            BaiduWalletDelegate.getInstance().openH5Module(this.f25028b.f25026a.mAct, this.f25027a.link_url, false);
                        }
                    }
                }));
            }
        };
    }

    public String buildTipMsg(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (strArr == null) {
                return "";
            }
            for (String str : strArr) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m == null) {
            return;
        }
        BeanManager.getInstance().removeBean(this.m);
    }

    public void displayHistoryList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            ArrayList<String> arrayList = this.f25024h;
            if (arrayList != null && arrayList.size() > 0) {
                this.y.setListViewState(z, true);
                if (z) {
                    this.y.displayHistoryData(this.f25024h);
                    return;
                }
                return;
            }
            this.y.setListViewState(false, true);
        }
    }

    public int getNavigationBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) || this.mAct == null) {
            return;
        }
        if (i2 != 45315) {
            if (i2 == 45316) {
                this.w = "";
                e();
                ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25057a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25057a = this;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallFail(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            this.f25057a.mAct.finish();
                        }
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallSuccess(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                            this.f25057a.d();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.q.setRightImgZone2NotifyVisibility(0);
        this.q.setRightImgZone2Visibility(8);
        this.q.setRightImgZone2Enable(false);
        this.q.setRightImgZone2NotifyText(ResUtils.getString(this.mAct, "wallet_fp_charge_record"));
        b((PromotionInfoResponse) null);
        BannerLayoutForAd bannerLayoutForAd = this.z;
        if (bannerLayoutForAd != null) {
            bannerLayoutForAd.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) || this.mAct == null) {
            return;
        }
        if (i2 == 45315) {
            if (obj instanceof PromotionInfoResponse) {
                PromotionInfoResponse promotionInfoResponse = (PromotionInfoResponse) obj;
                b(promotionInfoResponse);
                a(c(promotionInfoResponse), promotionInfoResponse);
                a(promotionInfoResponse);
            }
        } else if (i2 == 45316) {
            if (obj instanceof GetBindMobileResponse) {
                GetBindMobileResponse getBindMobileResponse = (GetBindMobileResponse) obj;
                if (!TextUtils.isEmpty(getBindMobileResponse.mobile)) {
                    String expressMobile = getBindMobileResponse.getExpressMobile();
                    this.w = expressMobile;
                    this.x = TextUtils.isEmpty(expressMobile) ? "" : this.w;
                    String str2 = getBindMobileResponse.area_operator;
                    if (!TextUtils.isEmpty(str2)) {
                        updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), str2);
                        updateTipText(1, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
                    } else {
                        updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(ResUtils.getString(this.mAct, "wallet_fp_wrong_number")));
                        updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
                        a((QueryLocationResponse) null);
                    }
                    a(a(getBindMobileResponse));
                    this.l = false;
                    if (this.w == null) {
                        this.w = "";
                    }
                } else {
                    this.w = "";
                }
            } else {
                this.w = "";
            }
            e();
        }
    }

    public boolean isFastDoubleClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.L;
            LogUtil.logd("timeD=" + j);
            if (0 >= j || j >= 5000) {
                this.L = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlyme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            if (i2 != 240) {
                if (i2 == 40968) {
                    WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                    return;
                } else {
                    super.onActivityResult(i2, i3, intent);
                    return;
                }
            }
            BaiduWalletUtils.finishActivityAnim(this.mAct);
            if (i3 != -1 || intent == null || intent.getData() == null) {
                return;
            }
            ContactPermissionUtil.handleContactsSelectedActivityResult(this.mAct, intent, 16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.f25022f) {
                DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24960b);
                PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24960b);
                g();
                return;
            }
            CustomAutoTextView customAutoTextView = this.f25017a;
            if (view == customAutoTextView) {
                customAutoTextView.setCursorVisible(true);
                if (TextUtils.isDigitsOnly(this.f25017a.getText().toString()) || this.j) {
                    return;
                }
                this.j = true;
                this.f25021e.setImageResource(ResUtils.drawable(this.mAct, "wallet_fp_contacts_close_selector"));
                AccessibilityUtils.setContentDescription(this.f25021e, "清除");
            }
        }
    }

    @Override // com.baidu.wallet.utils.ContactPermissionUtil.OnContactPermissionPhoneSelectListener
    public void onContactPermissionPhoneSelect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f25017a.setText(str);
            this.f25017a.setSelection(str.length());
            this.D = false;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 17)
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onCreateView. bundle = " + bundle);
            super.onCreate(bundle);
            com.baidu.wallet.fastpay.sdk.a.a().a((Context) this.mAct, false, 0);
            setContentView(ResUtils.layout(this.mAct, "wallet_fp_charge"));
            this.H = (int) (DisplayUtils.getDisplayHeight(this.mAct) * 0.032d);
            this.I = (int) (DisplayUtils.getDisplayHeight(this.mAct) * 0.14d);
            k();
            ArrayList<String> a2 = com.baidu.wallet.fastpay.b.a.a(this.mAct);
            this.f25024h = a2;
            if (a2 == null) {
                this.f25024h = new ArrayList<>();
            }
            this.f25023g = (FrameLayout) findViewById(ResUtils.id(this.mAct, "wallet_promotion"));
            this.f25017a = (CustomAutoTextView) findViewById(ResUtils.id(this.mAct, "wallet_phone"));
            a();
            this.f25017a.setImeOptions(6);
            this.f25017a.setDropDownBackgroundResource(ResUtils.drawable(this.mAct, "wallet_base_auto_bg_input_translucent"));
            this.f25025i = new ContactAssociationAdapter(this.mAct, true);
            this.s = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_face_operator_maintaining"));
            FlowLayout flowLayout = (FlowLayout) findViewById(ResUtils.id(this.mAct, "wallet_face_layout"));
            this.f25020d = flowLayout;
            flowLayout.setHorizontalSpacing(DisplayUtils.dip2px(this.mAct, 10.0f));
            this.f25020d.setVerticalSpacing(DisplayUtils.dip2px(this.mAct, -1.5f));
            this.f25020d.setHorizontalChildNum(3);
            this.f25020d.setChildViewHeight(DisplayUtils.dip2px(this.mAct, 78.0f));
            this.n = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_display_translucent"));
            this.f25021e = (ImageView) findViewById(ResUtils.id(this.mAct, "wallet_contacts"));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_fp_rl_contacts"));
            this.f25022f = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f25018b = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_operator"));
            this.f25019c = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_host"));
            this.p = (ScrollView) findViewById(ResUtils.id(this.mAct, "wallet_mobile_sv_charge"));
            TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_fp_text"));
            this.A = textView;
            textView.setVisibility(0);
            this.B = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_fp_more_service"));
            FlowLayout flowLayout2 = (FlowLayout) findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item"));
            this.C = flowLayout2;
            flowLayout2.setHorizontalChildNum(4);
            this.C.setHorizontalSpacing(DisplayUtils.dip2px(this.mAct, 0.5f));
            this.C.setVerticalSpacing(DisplayUtils.dip2px(this.mAct, 1.5f));
            this.C.setChildViewHeight(DisplayUtils.dip2px(this.mAct, 70.0f));
            this.o = findViewById(ResUtils.id(this.mAct, "wallet_mobile_bottom_line"));
            this.k = new StringBuilder();
            PhoneHistoryFixView phoneHistoryFixView = (PhoneHistoryFixView) findViewById(ResUtils.id(this.mAct, "wallet_charge_fix_view"));
            this.y = phoneHistoryFixView;
            phoneHistoryFixView.setOnPhoneHistoryFixViewClickListener(this);
            this.y.setInputNumberHasSpace(true);
            this.z = (BannerLayoutForAd) findViewById(ResUtils.id(this.mAct, "charge_banner"));
            this.y.getmListView().setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25031a;

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
                    this.f25031a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        this.f25031a.p.requestDisallowInterceptTouchEvent(true);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.n.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25038a;

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
                    this.f25038a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.f25038a.f25017a != null) {
                            ChargeActivity chargeActivity = this.f25038a;
                            GlobalUtils.hideInputMethod(chargeActivity.mAct, chargeActivity.f25017a);
                        }
                        if (this.f25038a.y.isShown()) {
                            this.f25038a.displayHistoryList(false);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.f25017a.addTextChangedListener(new TextWatcher(this, new Filter.FilterListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25039a;

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
                    this.f25039a = this;
                }

                @Override // android.widget.Filter.FilterListener
                public void onFilterComplete(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        if (i2 > 0) {
                            this.f25039a.n.setVisibility(0);
                        } else {
                            this.f25039a.n.setVisibility(8);
                        }
                        this.f25039a.y.displayContactInfoData(this.f25039a.f25025i.getContractInfo());
                    }
                }
            }) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Filter.FilterListener f25040a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25041b;

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
                    this.f25041b = this;
                    this.f25040a = r7;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "afterTextChanged. s = " + editable.toString());
                        if (this.f25041b.k.toString().replace(" ", "").equals(editable.toString().replace(" ", ""))) {
                            return;
                        }
                        if (this.f25041b.f25017a.getText().length() != 0) {
                            if (this.f25041b.f25017a.getText().length() >= 4 && this.f25041b.f25017a.getText().length() < 13) {
                                this.f25041b.f25025i.getFilter().filter(this.f25041b.f25017a.getText(), this.f25040a);
                            } else {
                                this.f25041b.displayHistoryList(false);
                            }
                        } else {
                            this.f25041b.displayHistoryList(true);
                        }
                        if (!TextUtils.isEmpty(this.f25041b.x) && editable.toString().equals(this.f25041b.x)) {
                            this.f25041b.b();
                            return;
                        }
                        this.f25041b.x = "";
                        if (this.f25041b.k.length() == 13 && editable.length() < 13) {
                            this.f25041b.f25018b.setText("");
                            this.f25041b.f25019c.setText("");
                            this.f25041b.a((QueryLocationResponse) null);
                        }
                        this.f25041b.k.delete(0, this.f25041b.k.length());
                        this.f25041b.k.append(this.f25041b.f25017a.getText().toString());
                        this.f25041b.i();
                        if (this.f25041b.k.length() != 13) {
                            if (this.f25041b.l) {
                                return;
                            }
                            this.f25041b.f();
                            return;
                        }
                        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "afterTextChanged. mobile = " + ((Object) this.f25041b.k));
                        String replace = this.f25041b.f25017a.getText().toString().replace(" ", "");
                        if (!com.baidu.wallet.fastpay.sdk.a.a().a(replace)) {
                            this.f25041b.a(false);
                            this.f25041b.a((QueryLocationResponse) null);
                        } else {
                            ChargeActivity chargeActivity = this.f25041b;
                            chargeActivity.mDialogMsg = "";
                            if (chargeActivity.j) {
                                this.f25041b.j = false;
                                this.f25041b.f25021e.setImageResource(ResUtils.drawable(this.f25041b.mAct, "wallet_base_fp_contacts_selector1"));
                                AccessibilityUtils.setContentDescription(this.f25041b.f25021e, "通讯录");
                            }
                            this.f25041b.f25017a.setCursorVisible(false);
                            this.f25041b.a(replace);
                            GlobalUtils.hideKeyboard(this.f25041b.mAct.getActivity());
                        }
                        if (this.f25041b.f25024h.contains(this.f25041b.k.toString()) || this.f25041b.k.toString().equals(this.f25041b.w)) {
                            return;
                        }
                        PhoneContactsMananger.getInstance(this.f25041b.mAct.getApplicationContext()).loadFixPhoneList(this.f25041b.k.toString(), 1, true, this.f25041b);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "beforeTextChanged. s = " + charSequence.toString());
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onTextChanged. s = " + charSequence.toString());
                    }
                }
            });
            this.p.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25042a;

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
                    this.f25042a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.f25042a.f25017a != null) {
                            ChargeActivity chargeActivity = this.f25042a;
                            GlobalUtils.hideInputMethod(chargeActivity.mAct, chargeActivity.f25017a);
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.f25017a.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25047a;

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
                    this.f25047a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.f25047a.D) {
                            this.f25047a.f25017a.setText("");
                            this.f25047a.f25017a.setCursorVisible(true);
                            this.f25047a.D = false;
                            return false;
                        } else if (this.f25047a.f25017a.getText().length() == 0) {
                            this.f25047a.i();
                            if (!this.f25047a.y.isShow()) {
                                this.f25047a.displayHistoryList(true);
                            }
                            return false;
                        } else {
                            List<ContractInfo> contractInfo = this.f25047a.f25025i.getContractInfo();
                            if (this.f25047a.f25017a.getText().length() != 13 && contractInfo.size() > 0) {
                                this.f25047a.n.setVisibility(0);
                                this.f25047a.y.displayContactInfoData(contractInfo);
                            }
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.f25017a.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25048a;

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
                    this.f25048a = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                        if (this.f25048a.D) {
                            this.f25048a.f25017a.setText("");
                            this.f25048a.f25017a.setCursorVisible(true);
                            return;
                        }
                        this.f25048a.o.setBackgroundColor(ResUtils.getColor(this.f25048a.mAct, z ? "wallet_fp_divide_line_5d667a" : "wallet_fp_divide_line_E9EDF7"));
                        this.f25048a.f25017a.setCursorVisible(z);
                        if (!z || this.f25048a.j || TextUtils.isDigitsOnly(this.f25048a.f25017a.getText().toString())) {
                            return;
                        }
                        ChargeActivity chargeActivity = this.f25048a;
                        if (chargeActivity.mAct == null) {
                            return;
                        }
                        chargeActivity.j = true;
                        this.f25048a.f25021e.setImageResource(ResUtils.drawable(this.f25048a.mAct, "wallet_fp_contacts_close_selector"));
                        AccessibilityUtils.setContentDescription(this.f25048a.f25021e, "清除");
                    }
                }
            });
            this.f25017a.setOnClickListener(this);
            a((QueryLocationResponse) null);
            d();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onCreateDalog. id = " + i2);
            if (i2 != 16) {
                return super.onCreateDialog(i2);
            }
            return new SelectNumberDialog(this.mAct);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            BeanManager.getInstance().removeAllBeans("ChargeActivity");
            PhoneContactsMananger.getInstance(this.mAct.getApplicationContext()).reset();
            ContactPermissionUtil.restListener();
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.fastpay.sdk.a.b
    public void onFastPayFail(int i2, int i3, a.C0265a c0265a) {
        BeanActivity beanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, c0265a) == null) || (beanActivity = this.mAct) == null) {
            return;
        }
        beanActivity.runOnUiThread(new Runnable(this, i2, i3, c0265a) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f25050a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f25051b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a.C0265a f25052c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ChargeActivity f25053d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), c0265a};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25053d = this;
                this.f25050a = i2;
                this.f25051b = i3;
                this.f25052c = c0265a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f25053d.a(this.f25050a, this.f25051b, this.f25052c);
                }
            }
        });
    }

    @Override // com.baidu.wallet.fastpay.sdk.a.b
    public void onFastPaySuccess(int i2, int i3, Object obj) {
        BeanActivity beanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, obj) == null) || (beanActivity = this.mAct) == null) {
            return;
        }
        beanActivity.runOnUiThread(new Runnable(this, i2, i3, obj) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f25043a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f25044b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f25045c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ChargeActivity f25046d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), obj};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25046d = this;
                this.f25043a = i2;
                this.f25044b = i3;
                this.f25045c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f25046d.a(this.f25043a, this.f25044b, this.f25045c);
                }
            }
        });
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoListener
    public void onFixPhoneList(String str, List<ContractInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, list) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewClickClearHistory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PromptDialog promptDialog = new PromptDialog(this);
            promptDialog.hideTitle();
            promptDialog.setMessage(ResUtils.getString(this.mAct, "wallet_fp_clear_history_list"));
            promptDialog.setPositiveBtn(new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f25034a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25035b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25035b = this;
                    this.f25034a = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f25035b.f25024h = new ArrayList();
                        com.baidu.wallet.fastpay.b.a.b(this.f25035b.mAct);
                        this.f25034a.dismiss();
                    }
                }
            });
            promptDialog.setNegativeBtn(new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f25036a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25037b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25037b = this;
                    this.f25036a = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f25037b.i();
                        this.f25037b.displayHistoryList(true);
                        this.f25036a.dismiss();
                    }
                }
            });
            promptDialog.show();
        }
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewClickListViewItemAndSetText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f25017a.setText(str);
            CustomAutoTextView customAutoTextView = this.f25017a;
            customAutoTextView.setSelection(customAutoTextView.length());
        }
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewDisplayHistoryViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoListener
    public void onLoadFastPayPhoneInfo(String str, ContractInfo contractInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, contractInfo) == null) || TextUtils.isEmpty(str) || str.trim().equals(this.w)) {
            return;
        }
        if (contractInfo != null) {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), (TextUtils.isEmpty(contractInfo.getName()) || TextUtils.equals(contractInfo.getName().replace(" ", ""), this.f25017a.getText().toString().replace(" ", ""))) ? buildTipMsg(this.f25019c.getText().toString()) : buildTipMsg(contractInfo.getName(), " | ", this.f25019c.getText().toString()));
            updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), "");
            return;
        }
        updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(ResUtils.getString(this.mAct, "wallet_fp_exclude_contacts"), " | ", this.f25019c.getText().toString()));
        updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), "");
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, dialog) == null) {
            com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onPrepareDialog. id = " + i2);
            if (i2 == 0) {
                ((LoadingDialog) dialog).setMessage(this.mDialogMsg);
            } else if (i2 == 16) {
                ContactPermissionUtil.prepareSelectNumberDialog(this.mAct, i2, dialog);
            } else if (137 == i2) {
                ContactPermissionUtil.prepareContactPromptDialog(i2, dialog, this.mAct);
            } else if (i2 == 4642) {
                ContactPermissionUtil.preparePhoneNotCorrectDialog(i2, dialog, this.mAct);
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048599, this, i2, strArr, iArr) == null) && i2 == 16) {
            ContactAssociationAdapter contactAssociationAdapter = this.f25025i;
            if (contactAssociationAdapter != null) {
                contactAssociationAdapter.loadPhoneContact();
            }
            ContactPermissionUtil.handleOnReadContactPermissionsResult(strArr, iArr, this.mAct, 240, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) || bundle == null) {
            return;
        }
        Serializable serializable = bundle.getSerializable("mRealPricInfos");
        if (serializable != null && (serializable instanceof PriceInfo[])) {
            this.u = (PriceInfo[]) serializable;
        }
        String string = bundle.getString("mobile");
        if (!TextUtils.isEmpty(string)) {
            this.k = new StringBuilder(string);
        } else {
            this.k = new StringBuilder();
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            c();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.wallet.fastpay.datamodel.PriceInfo[], java.io.Serializable] */
    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            bundle.putString("mobile", this.k.toString());
            bundle.putSerializable("mRealPricInfos", this.u);
            super.onSaveInstanceState(bundle);
        }
    }

    public void setPriceUnused(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_layout")).setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_fp_bg_face_unable"));
            ((TextView) view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face"))).setTextColor(ResUtils.getColor(getActivity(), "wallet_fp_face_item_unused_edge"));
            ((TextView) view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price"))).setTextColor(ResUtils.getColor(getActivity(), "wallet_fp_unused_face_item_edge"));
        }
    }

    public void updateTipText(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, str) == null) {
            if (i2 == 1) {
                this.f25018b.setTextColor(i3);
                this.f25018b.setText(str);
            } else if (i2 != 2) {
                this.f25018b.setTextColor(i3);
                this.f25018b.setText(str);
            } else {
                this.f25019c.setTextColor(i3);
                this.f25019c.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(this.mAct, new ILoginBackListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25049a;

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
                    this.f25049a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f25049a.e();
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        WalletGlobalUtils.safeShowDialog(this.f25049a.mAct, -1, "");
                        com.baidu.wallet.fastpay.beans.a aVar = (com.baidu.wallet.fastpay.beans.a) FastPayBeanFactory.getInstance().getBean((Context) this.f25049a.mAct, FastPayBeanFactory.BEAN_ID_BIND_INFO, "ChargeActivity");
                        aVar.setResponseCallback(this.f25049a);
                        aVar.execBean();
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            if (!TextUtils.isEmpty(this.w)) {
                if (this.w.length() > 13) {
                    this.f25017a.setText(this.w.substring(0, 13));
                } else {
                    this.f25017a.setText(this.w);
                }
            } else if (!this.f25024h.isEmpty()) {
                String str = this.f25024h.get(0);
                if (str.length() > 13) {
                    this.f25017a.setText(str.substring(0, 13));
                } else {
                    this.f25017a.setText(str);
                }
            } else {
                this.f25017a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
                GlobalUtils.showInputMethod(this.mAct, this.f25017a);
                this.mAct.getWindow().setSoftInputMode(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.f25017a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
            this.f25018b.setText("");
            this.l = true;
        }
    }

    @SuppressLint({"UseCheckPermission"})
    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, this) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (this.j) {
            this.f25017a.setText("");
            this.f25018b.setText("");
            GlobalUtils.showInputMethod(this.mAct, this.f25017a);
            return;
        }
        ContactPermissionUtil.checkIsHasContactPermission(this.mAct, 16, 240, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            this.K = new LoginBackListenerProxy(this.mAct, new ILoginBackListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ChargeActivity f25058a;

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
                    this.f25058a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(this.f25058a.K);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f25058a.u == null) {
                        return;
                    }
                    ChargeActivity chargeActivity = this.f25058a;
                    chargeActivity.mDialogMsg = ResUtils.getString(chargeActivity.mAct, "ebpay_safe_handle");
                    WalletGlobalUtils.safeShowDialog(this.f25058a.mAct, 0, "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("param_key_face_value", this.f25058a.v.face);
                    hashMap.put("key_mobile", this.f25058a.f25017a.getText().toString().replace(" ", ""));
                    hashMap.put("param_key_price", this.f25058a.v.sell_price);
                    hashMap.put(com.baidu.wallet.api.Constants.USER_TYPE_KEY, String.valueOf(WalletLoginHelper.getInstance().getLoginType()));
                    hashMap.put(com.baidu.wallet.api.Constants.TOKEN_VALUE_KEY, WalletLoginHelper.getInstance().getLoginToken());
                    com.baidu.wallet.fastpay.sdk.a.a().a(2, hashMap, this.f25058a);
                    if (this.f25058a.f25024h == null) {
                        this.f25058a.f25024h = new ArrayList();
                    }
                    if (!this.f25058a.f25024h.contains(this.f25058a.f25017a.getText().toString())) {
                        this.f25058a.f25024h.add(0, this.f25058a.f25017a.getText().toString());
                    }
                    ChargeActivity chargeActivity2 = this.f25058a;
                    com.baidu.wallet.fastpay.b.a.a(chargeActivity2.mAct, chargeActivity2.f25017a.getText().toString());
                }
            });
            WalletLoginHelper.getInstance().login(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            if (this.k.length() > 0) {
                if (this.j) {
                    return;
                }
                this.j = true;
                this.f25021e.setImageResource(ResUtils.drawable(this.mAct, "wallet_fp_contacts_close_selector"));
                AccessibilityUtils.setContentDescription(this.f25021e, "清除");
            } else if (this.j) {
                this.j = false;
                this.f25021e.setImageResource(ResUtils.drawable(this.mAct, "wallet_base_fp_contacts_selector1"));
                AccessibilityUtils.setContentDescription(this.f25021e, "通讯录");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65580, this) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this, new ILoginBackListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChargeActivity f25059a;

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
                this.f25059a = this;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(com.baidu.wallet.api.Constants.ORDERTYPE_FLAG, 2);
                        jSONObject.put(com.baidu.wallet.api.Constants.ORDER_LIST_TITLE, ResUtils.getString(this.f25059a.getActivity(), "bd_wallet_tab_bill_from_mobile"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    BaiduWalletServiceController.getInstance().gotoWalletService(this.f25059a.mAct, Constants.VIA_REPORT_TYPE_START_WAP, jSONObject.toString());
                }
            }
        }));
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
            this.q = bdActionBar;
            if (bdActionBar != null) {
                bdActionBar.setTitle(ResUtils.string(this.mAct, "wallet_base_phone_charge"));
                this.q.setRightImgZone2NotifyClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25060a;

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
                        this.f25060a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24962d);
                            PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24962d);
                            this.f25060a.j();
                        }
                    }
                });
                this.q.setLeftImgZone2NotifyText(ResUtils.getString(this.mAct, "wallet_fp_return"), 14.0f);
                this.q.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25029a;

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
                        this.f25029a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24963e);
                            PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24963e);
                            GlobalUtils.hideKeyboard(this.f25029a.mAct.getActivity());
                            this.f25029a.finish();
                        }
                    }
                });
                BdActionBar bdActionBar2 = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
                this.q = bdActionBar2;
                bdActionBar2.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_base_overflow"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
                this.q.setRightImgZone2OnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25030a;

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
                        this.f25030a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f25030a.F.show();
                        }
                    }
                });
                this.q.setRightImgZone2Visibility(8);
                CustomerServiceMenu customerServiceMenu = new CustomerServiceMenu(this.q.getRightZoneView(), CustomerServiceMenu.TRANSFER_RECORD);
                this.F = customerServiceMenu;
                customerServiceMenu.setMenuItemClickListener(this.J);
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            c cVar = (c) FastPayBeanFactory.getInstance().getBean((Context) this.mAct, FastPayBeanFactory.BEAN_ID_PROMOTION_INFO, "ChargeActivity");
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
            this.k.append(this.f25017a.getText().toString());
            i();
            if (this.k.length() == 13) {
                if (!BaiduTraffic.a().a(this.f25017a.getText().toString().replace(" ", ""))) {
                    a(false);
                    c(true);
                } else {
                    this.mDialogMsg = "";
                    if (this.j) {
                        this.j = false;
                        this.f25021e.setImageResource(ResUtils.drawable(this.mAct, "wallet_base_fp_contacts_selector1"));
                        AccessibilityUtils.setContentDescription(this.f25021e, "通讯录");
                    }
                    this.f25017a.setCursorVisible(false);
                    GlobalUtils.hideKeyboard(this.mAct.getActivity());
                }
                if (this.f25024h.contains(this.k.toString()) || this.k.toString().equals(this.w)) {
                    return;
                }
                PhoneContactsMananger.getInstance(this.mAct.getApplicationContext()).loadFixPhoneList(this.k.toString(), 1, true, this);
            } else if (this.l) {
            } else {
                f();
            }
        }
    }

    private boolean c(PromotionInfoResponse promotionInfoResponse) {
        InterceptResult invokeL;
        FlowLayout flowLayout;
        MoreServiceItemInfo[] moreServiceItemInfoArr;
        MoreServiceItemInfo[] moreServiceItemInfoArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, promotionInfoResponse)) == null) {
            if (this.B != null && (flowLayout = this.C) != null) {
                if (promotionInfoResponse != null && (moreServiceItemInfoArr = promotionInfoResponse.additional_services) != null && moreServiceItemInfoArr.length != 0) {
                    flowLayout.removeAllViews();
                    boolean z = false;
                    for (MoreServiceItemInfo moreServiceItemInfo : promotionInfoResponse.additional_services) {
                        if (moreServiceItemInfo != null) {
                            View inflate = LayoutInflater.from(this.mAct).inflate(ResUtils.layout(this.mAct, "wallet_fp_service_item"), (ViewGroup) null);
                            if (!TextUtils.isEmpty(moreServiceItemInfo.title) && !TextUtils.isEmpty(moreServiceItemInfo.img_url) && !TextUtils.isEmpty(moreServiceItemInfo.link_url)) {
                                ((TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_name"))).setText(moreServiceItemInfo.title);
                                ((NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_logo"))).setImageUrl(moreServiceItemInfo.img_url);
                                if (!TextUtils.isEmpty(moreServiceItemInfo.has_corner) && TextUtils.equals(moreServiceItemInfo.has_corner, "2") && !TextUtils.isEmpty(moreServiceItemInfo.corner_url)) {
                                    ((NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_discount"))).setImageUrl(moreServiceItemInfo.corner_url);
                                }
                                inflate.setOnClickListener(new View.OnClickListener(this, moreServiceItemInfo) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.5
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ MoreServiceItemInfo f25055a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ ChargeActivity f25056b;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, moreServiceItemInfo};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f25056b = this;
                                        this.f25055a = moreServiceItemInfo;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                            DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24961c, Arrays.asList(this.f25055a.title));
                                            PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24961c, this.f25055a.title);
                                            int i2 = this.f25055a.link_type;
                                            if (i2 == 1) {
                                                BaiduWalletDelegate.getInstance().openH5Module(this.f25056b.mAct, this.f25055a.link_url);
                                            } else if (i2 != 3) {
                                                BaiduWalletDelegate.getInstance().openH5Module(this.f25056b.mAct, this.f25055a.link_url);
                                            } else {
                                                BaiduWalletServiceController.getInstance().gotoWalletService(this.f25056b.mAct, this.f25055a.link_url, (String) null);
                                            }
                                        }
                                    }
                                });
                                this.C.addView(inflate);
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        this.B.setVisibility(0);
                        this.C.setVisibility(0);
                    } else {
                        this.B.setVisibility(8);
                        this.C.setVisibility(8);
                    }
                    return z;
                }
                this.B.setVisibility(8);
                this.C.setVisibility(8);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(PromotionInfoResponse promotionInfoResponse) {
        MenuItemInfo[] menuItemInfoArr;
        MenuItemInfo[] menuItemInfoArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, promotionInfoResponse) == null) {
            if (promotionInfoResponse != null && (menuItemInfoArr = promotionInfoResponse.help_menu) != null && menuItemInfoArr.length != 0) {
                this.G.clear();
                this.F.removeAllItem();
                int i2 = 0;
                for (MenuItemInfo menuItemInfo : promotionInfoResponse.help_menu) {
                    if (menuItemInfo != null && !TextUtils.isEmpty(menuItemInfo.title) && !TextUtils.isEmpty(menuItemInfo.img_url) && !TextUtils.isEmpty(menuItemInfo.link_url)) {
                        this.F.add(i2, menuItemInfo.title, menuItemInfo.img_url);
                        this.G.add(menuItemInfo);
                        i2++;
                    }
                }
                if (i2 > 0) {
                    this.q.setRightImgZone2NotifyVisibility(8);
                    this.q.setRightImgZone2Visibility(0);
                    this.q.setRightImgZone2Enable(true);
                    this.F.notifyMenuSetChanged();
                    return;
                }
                this.q.setRightImgZone2NotifyVisibility(0);
                this.q.setRightImgZone2Visibility(8);
                this.q.setRightImgZone2Enable(false);
                return;
            }
            this.q.setRightImgZone2NotifyText(ResUtils.getString(this.mAct, "wallet_fp_charge_record"));
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            SpannableString spannableString = new SpannableString(ResUtils.getString(this.mAct, "wallet_fp_mobile_hint"));
            spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(22.0f, this.mAct.getResources().getDisplayMetrics().scaledDensity)), 0, spannableString.length(), 33);
            this.f25017a.setHint(spannableString);
        }
    }

    private void b(PromotionInfoResponse promotionInfoResponse) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, promotionInfoResponse) == null) || (frameLayout = this.f25023g) == null) {
            return;
        }
        if (promotionInfoResponse == null) {
            frameLayout.setVisibility(8);
        } else if (TextUtils.isEmpty(promotionInfoResponse.promotion_txt)) {
            this.f25023g.setVisibility(8);
        } else {
            CommonPromotionView createAdapterView = new a(getActivity(), promotionInfoResponse).createAdapterView(getActivity());
            if (createAdapterView == null) {
                return;
            }
            this.f25023g.addView(createAdapterView, new FrameLayout.LayoutParams(-1, -2));
            this.f25023g.setVisibility(0);
        }
    }

    private void c(boolean z) {
        PriceInfo[] priceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, this, z) == null) {
            LayoutInflater from = LayoutInflater.from(this.mAct);
            for (PriceInfo priceInfo : this.t) {
                View inflate = from.inflate(ResUtils.layout(this.mAct, "wallet_fp_face_item"), (ViewGroup) null);
                inflate.setEnabled(false);
                inflate.setSelected(false);
                TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face"));
                if (!TextUtils.isEmpty(priceInfo.face) && priceInfo.face.length() > 2) {
                    String string = ResUtils.getString(this.mAct, "wallet_fp_price");
                    String str = priceInfo.face;
                    textView.setText(new SpannableString(String.format(string, str.substring(0, str.length() - 2))));
                    textView.setEnabled(false);
                }
                if (z) {
                    inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price")).setVisibility(8);
                } else {
                    inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price")).setEnabled(false);
                    ((TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price"))).setText(ResUtils.getString(this.mAct, "wallet_fp_lack_good"));
                }
                this.f25020d.addView(inflate);
            }
            this.f25020d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(65546, this, i2, i3, obj) == null) || this.mAct == null) {
            return;
        }
        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "handleFastPaySuccess. request id = " + i2 + ", sub id = " + i3 + ", response = " + obj);
        if (i2 != 1) {
            if (i2 == 2) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                if (i3 == 1 && obj != null && (obj instanceof FastPayCallBackManager.PayStateModle) && ((FastPayCallBackManager.PayStateModle) obj).statecode == 3) {
                    BeanActivity beanActivity = this.mAct;
                    GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "ebpay_paying_2"));
                    return;
                }
                return;
            }
            return;
        }
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (obj == null || !(obj instanceof QueryLocationResponse)) {
            return;
        }
        QueryLocationResponse queryLocationResponse = (QueryLocationResponse) obj;
        this.r = queryLocationResponse;
        updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), queryLocationResponse.area_operator);
        updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), "");
        PhoneContactsMananger.getInstance(this.mAct.getApplicationContext()).loadPayphoneInfo(this.k.toString(), this);
        a(this.r);
        this.l = false;
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            if (!z || this.s.getVisibility() == 0) {
                if (!z && this.s.getVisibility() == 0) {
                    this.A.setVisibility(8);
                    return;
                }
                this.s.setVisibility(z ? 8 : 0);
                this.A.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, a.C0265a c0265a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(65545, this, i2, i3, c0265a) == null) || this.mAct == null) {
            return;
        }
        if (BeanConstants.DEBUG) {
            com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onFail. requestId = " + i2 + ", sub id = " + i3 + ", error code = " + c0265a.f25013a + ", msg = " + c0265a.f25014b);
        }
        if (i2 != 1) {
            if (i2 == 2) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                int i4 = c0265a.f25013a;
                if (i4 != 5140 && i4 != 5139) {
                    if (i4 == 5003) {
                        WalletLoginHelper.getInstance().handlerWalletError(5003);
                        AccountManager.getInstance(this.mAct).logout();
                        WalletLoginHelper.getInstance().logout(false);
                    }
                    GlobalUtils.toast(this.mAct, c0265a.f25014b);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("sdk_from", "1");
                hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, c0265a.f25013a == 5140 ? "9" : "0");
                BaiduPayDelegate.getInstance().doRNAuth(this.mAct, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25054a;

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
                        this.f25054a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i5, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, str) == null) {
                            if (i5 == 0) {
                                this.f25054a.h();
                            } else {
                                GlobalUtils.toast(this.f25054a.mAct, str);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        this.x = "";
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        int i5 = c0265a.f25013a;
        if (i5 == -4) {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0265a.f25014b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        } else if (19030 == i5) {
            a(true);
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0265a.f25014b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        } else {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0265a.f25014b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        }
    }

    private void a(boolean z, PromotionInfoResponse promotionInfoResponse) {
        BannerLayoutForAd bannerLayoutForAd;
        BannerChargeItemInfo[] bannerChargeItemInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65555, this, z, promotionInfoResponse) == null) || (bannerLayoutForAd = this.z) == null) {
            return;
        }
        if (promotionInfoResponse != null && (bannerChargeItemInfoArr = promotionInfoResponse.promotion_banner) != null && bannerChargeItemInfoArr.length > 0) {
            bannerLayoutForAd.setVisibility(0);
            this.z.setMarginLeftAndRight(DisplayUtils.dip2px(this.mAct, 15.0f), DisplayUtils.dip2px(this.mAct, 15.0f));
            this.z.setConfigData(promotionInfoResponse.promotion_banner);
            this.z.setMaiDianDataKey("mobileRechargeClickBanner");
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            if (z) {
                layoutParams.setMargins(0, this.H, 0, DisplayUtils.dip2px(this.mAct, 10.0f));
                return;
            } else {
                layoutParams.setMargins(0, this.I, 0, DisplayUtils.dip2px(this.mAct, 10.0f));
                return;
            }
        }
        this.z.setVisibility(8);
    }

    private QueryLocationResponse a(GetBindMobileResponse getBindMobileResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, getBindMobileResponse)) == null) {
            QueryLocationResponse queryLocationResponse = new QueryLocationResponse();
            this.r = queryLocationResponse;
            if (getBindMobileResponse != null) {
                queryLocationResponse.area = getBindMobileResponse.area;
                queryLocationResponse.area_operator = getBindMobileResponse.area_operator;
                queryLocationResponse.is_huodong_price = getBindMobileResponse.is_huodong_price;
                queryLocationResponse.operator = getBindMobileResponse.operator;
                PriceInfo[] priceInfoArr = getBindMobileResponse.price_info;
                if (priceInfoArr != null) {
                    queryLocationResponse.price_info = priceInfoArr;
                }
                FastPayFacePromotionInfoResponse[] fastPayFacePromotionInfoResponseArr = getBindMobileResponse.promotion_info;
                if (fastPayFacePromotionInfoResponseArr != null) {
                    this.r.promotion_info = fastPayFacePromotionInfoResponseArr;
                }
                return this.r;
            }
            return null;
        }
        return (QueryLocationResponse) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            this.l = false;
            this.f25017a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
            if (z || TextUtils.isEmpty(this.f25017a.getText().toString()) || this.f25017a.getText().toString().length() < 13) {
                return;
            }
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(ResUtils.getString(this.mAct, "wallet_fp_wrong_number")));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QueryLocationResponse queryLocationResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, queryLocationResponse) == null) {
            ViewGroup viewGroup = null;
            this.u = null;
            if (queryLocationResponse != null) {
                this.u = queryLocationResponse.price_info;
            }
            if (this.u == null) {
                b(true);
                this.f25020d.setVisibility(0);
                this.f25020d.removeAllViews();
                if (queryLocationResponse == null) {
                    c(true);
                    return;
                } else {
                    c(false);
                    return;
                }
            }
            this.f25017a.setCursorVisible(false);
            PriceInfo[] priceInfoArr = this.u;
            if (priceInfoArr.length <= 0) {
                b(false);
                this.f25020d.setVisibility(8);
                return;
            }
            this.u = a(priceInfoArr);
            b(true);
            this.f25020d.setVisibility(0);
            this.f25020d.removeAllViews();
            int length = this.u.length;
            FastPayFacePromotionInfoResponse[] fastPayFacePromotionInfoResponseArr = queryLocationResponse.promotion_info;
            int i2 = 0;
            while (i2 < length) {
                View inflate = LayoutInflater.from(this.mAct).inflate(ResUtils.layout(this.mAct, "wallet_fp_face_item"), viewGroup);
                inflate.setEnabled(true);
                TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face"));
                TextView textView2 = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price"));
                String str = this.u[i2].face;
                if (!TextUtils.isEmpty(str) && str.length() > 2) {
                    String string = ResUtils.getString(this.mAct, "wallet_fp_price");
                    PriceInfo[] priceInfoArr2 = this.u;
                    SpannableString spannableString = new SpannableString(String.format(string, priceInfoArr2[i2].face.substring(0, priceInfoArr2[i2].face.length() - 2)));
                    textView.setText(spannableString);
                    textView2.setText(spannableString);
                }
                if (!TextUtils.isEmpty(this.u[i2].sell_price)) {
                    textView2.setText(new SpannableString(String.format(ResUtils.getString(this.mAct, "wallet_fp_sell_price"), new BigDecimal(this.u[i2].sell_price).multiply(BigDecimal.valueOf(0.01d)))));
                } else {
                    textView2.setText(ResUtils.getString(this.mAct, "wallet_fp_lack_good"));
                }
                NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face_discount"));
                if (fastPayFacePromotionInfoResponseArr != null && fastPayFacePromotionInfoResponseArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= fastPayFacePromotionInfoResponseArr.length) {
                            break;
                        }
                        String str2 = fastPayFacePromotionInfoResponseArr[i3].face;
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equals(str)) {
                            netImageView.setImageUrl(fastPayFacePromotionInfoResponseArr[i3].icon);
                            netImageView.setVisibility(0);
                            break;
                        }
                        i3++;
                    }
                }
                inflate.setOnClickListener(new View.OnClickListener(this, str) { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f25032a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ChargeActivity f25033b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25033b = this;
                        this.f25032a = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str3;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f25033b.isFastDoubleClick()) {
                            return;
                        }
                        try {
                            str3 = new BigDecimal(this.f25032a).divide(new BigDecimal(100), 6).toPlainString();
                        } catch (Exception unused) {
                            str3 = "";
                        }
                        DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24964f, Arrays.asList(str3));
                        PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24964f, str3);
                        this.f25033b.f25017a.setCursorVisible(false);
                        GlobalUtils.hideKeyboard(this.f25033b.mAct.getActivity());
                        if (this.f25033b.j) {
                            this.f25033b.j = false;
                            this.f25033b.f25021e.setImageResource(ResUtils.drawable(this.f25033b.mAct, "wallet_base_fp_contacts_selector1"));
                            AccessibilityUtils.setContentDescription(this.f25033b.f25021e, "通讯录");
                        }
                        this.f25033b.v = (PriceInfo) view.getTag();
                        if (this.f25033b.v.isExist) {
                            this.f25033b.h();
                        }
                    }
                });
                inflate.setTag(this.u[i2]);
                if (!this.u[i2].isExist) {
                    setPriceUnused(inflate);
                }
                this.f25020d.addView(inflate);
                i2++;
                viewGroup = null;
            }
        }
    }

    private PriceInfo[] a(PriceInfo[] priceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, priceInfoArr)) == null) {
            PriceInfo[] priceInfoArr2 = {new PriceInfo(Constants.DEFAULT_UIN, null, null), new PriceInfo("2000", null, null), new PriceInfo("3000", null, null), new PriceInfo("5000", null, null), new PriceInfo("10000", null, null), new PriceInfo("20000", null, null), new PriceInfo("30000", null, null), new PriceInfo("50000", null, null)};
            for (PriceInfo priceInfo : priceInfoArr) {
                for (int i2 = 0; i2 < 8; i2++) {
                    PriceInfo priceInfo2 = priceInfoArr2[i2];
                    if (priceInfo.equals(priceInfo2)) {
                        priceInfo2.sell_price = priceInfo.sell_price;
                        priceInfo2.discount = priceInfo.discount;
                        priceInfo2.isExist = true;
                    }
                }
            }
            return priceInfoArr2;
        }
        return (PriceInfo[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, str) == null) || this.mAct == null) {
            return;
        }
        String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
        this.x = formatPhoneNumber;
        if (formatPhoneNumber == null) {
            this.x = "";
        }
        WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        if (this.m == null) {
            this.m = (d) FastPayBeanFactory.getInstance().getBean((Context) this.mAct, FastPayBeanFactory.BEAN_ID_QUERY_LOCATION, "ChargeActivity");
        }
        com.baidu.wallet.fastpay.sdk.a.a().a(this.m, 1, str, this);
    }
}
