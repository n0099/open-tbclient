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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
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
    public TextView A;
    public TextView B;
    public FlowLayout C;
    public BdMenu F;
    public int H;
    public int I;
    public LoginBackListenerProxy K;
    public long L;

    /* renamed from: a  reason: collision with root package name */
    public CustomAutoTextView f24090a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24091b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24092c;

    /* renamed from: d  reason: collision with root package name */
    public FlowLayout f24093d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24094e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f24095f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f24096g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f24097h;
    public ContactAssociationAdapter i;
    public StringBuilder k;
    public d m;
    public RelativeLayout n;
    public View o;
    public ScrollView p;
    public BdActionBar q;
    public QueryLocationResponse r;
    public RelativeLayout s;
    public PriceInfo[] u;
    public PriceInfo v;
    public PhoneHistoryFixView y;
    public BannerLayoutForAd z;
    public boolean j = false;
    public boolean l = false;
    public PriceInfo[] t = {new PriceInfo(Constants.DEFAULT_UIN, null, null), new PriceInfo("2000", null, null), new PriceInfo("3000", null, null), new PriceInfo("5000", null, null), new PriceInfo("10000", null, null), new PriceInfo("20000", null, null), new PriceInfo("30000", null, null), new PriceInfo("50000", null, null)};
    public String w = "";
    public String x = "";
    public boolean D = true;
    public final int E = 4;
    public ArrayList<MenuItemInfo> G = new ArrayList<>();
    public BdMenuItem.OnItemClickListener J = new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.1
        @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
        public void onClick(BdMenuItem bdMenuItem) {
            final MenuItemInfo menuItemInfo;
            if (bdMenuItem == null || bdMenuItem.getItemId() >= ChargeActivity.this.G.size() || (menuItemInfo = (MenuItemInfo) ChargeActivity.this.G.get(bdMenuItem.getItemId())) == null) {
                return;
            }
            DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24032a, Arrays.asList(menuItemInfo.title));
            PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24032a, menuItemInfo.title);
            int i = menuItemInfo.link_type;
            if (i != 1) {
                if (i == 3 && TextUtils.equals(Constants.VIA_REPORT_TYPE_START_WAP, menuItemInfo.link_url)) {
                    ChargeActivity.this.j();
                    return;
                }
                return;
            }
            WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(ChargeActivity.this, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.1.1
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    BaiduWalletDelegate.getInstance().openH5Module(ChargeActivity.this.mAct, menuItemInfo.link_url, false);
                }
            }));
        }
    };

    public String buildTipMsg(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void cancleRequest() {
        if (this.m != null) {
            BeanManager.getInstance().removeBean(this.m);
        }
    }

    public void displayHistoryList(boolean z) {
        ArrayList<String> arrayList = this.f24097h;
        if (arrayList != null && arrayList.size() > 0) {
            this.y.setListViewState(z, true);
            if (z) {
                this.y.displayHistoryData(this.f24097h);
                return;
            }
            return;
        }
        this.y.setListViewState(false, true);
    }

    public int getNavigationBarHeight(Context context) {
        if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return 0;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        if (this.mAct == null) {
            return;
        }
        if (i != 45315) {
            if (i == 45316) {
                this.w = "";
                e();
                ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i2, str, new WalletApiExtListener.ThirdPartyLoginListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.6
                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallFail(int i3, String str2) {
                        ChargeActivity.this.mAct.finish();
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                    public void onCallSuccess(int i3, String str2) {
                        ChargeActivity.this.d();
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
    public void handleResponse(int i, Object obj, String str) {
        if (this.mAct == null) {
            return;
        }
        if (i == 45315) {
            if (obj instanceof PromotionInfoResponse) {
                PromotionInfoResponse promotionInfoResponse = (PromotionInfoResponse) obj;
                b(promotionInfoResponse);
                a(c(promotionInfoResponse), promotionInfoResponse);
                a(promotionInfoResponse);
            }
        } else if (i == 45316) {
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
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.L;
        LogUtil.logd("timeD=" + j);
        if (0 >= j || j >= 5000) {
            this.L = currentTimeMillis;
            return false;
        }
        return true;
    }

    public boolean isFlyme() {
        try {
            return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 240) {
            if (i == 40968) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                return;
            } else {
                super.onActivityResult(i, i2, intent);
                return;
            }
        }
        BaiduWalletUtils.finishActivityAnim(this.mAct);
        if (i2 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        ContactPermissionUtil.handleContactsSelectedActivityResult(this.mAct, intent, 16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f24095f) {
            DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24033b);
            PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24033b);
            g();
            return;
        }
        CustomAutoTextView customAutoTextView = this.f24090a;
        if (view == customAutoTextView) {
            customAutoTextView.setCursorVisible(true);
            if (TextUtils.isDigitsOnly(this.f24090a.getText().toString()) || this.j) {
                return;
            }
            this.j = true;
            this.f24094e.setImageResource(ResUtils.drawable(this.mAct, "wallet_fp_contacts_close_selector"));
            AccessibilityUtils.setContentDescription(this.f24094e, "清除");
        }
    }

    @Override // com.baidu.wallet.utils.ContactPermissionUtil.OnContactPermissionPhoneSelectListener
    public void onContactPermissionPhoneSelect(String str) {
        this.f24090a.setText(str);
        this.f24090a.setSelection(str.length());
        this.D = false;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 17)
    public void onCreate(Bundle bundle) {
        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onCreateView. bundle = " + bundle);
        super.onCreate(bundle);
        com.baidu.wallet.fastpay.sdk.a.a().a((Context) this.mAct, false, 0);
        setContentView(ResUtils.layout(this.mAct, "wallet_fp_charge"));
        this.H = (int) (DisplayUtils.getDisplayHeight(this.mAct) * 0.032d);
        this.I = (int) (DisplayUtils.getDisplayHeight(this.mAct) * 0.14d);
        k();
        ArrayList<String> a2 = com.baidu.wallet.fastpay.b.a.a(this.mAct);
        this.f24097h = a2;
        if (a2 == null) {
            this.f24097h = new ArrayList<>();
        }
        this.f24096g = (FrameLayout) findViewById(ResUtils.id(this.mAct, "wallet_promotion"));
        this.f24090a = (CustomAutoTextView) findViewById(ResUtils.id(this.mAct, "wallet_phone"));
        a();
        this.f24090a.setImeOptions(6);
        this.f24090a.setDropDownBackgroundResource(ResUtils.drawable(this.mAct, "wallet_base_auto_bg_input_translucent"));
        this.i = new ContactAssociationAdapter(this.mAct, true);
        this.s = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_face_operator_maintaining"));
        FlowLayout flowLayout = (FlowLayout) findViewById(ResUtils.id(this.mAct, "wallet_face_layout"));
        this.f24093d = flowLayout;
        flowLayout.setHorizontalSpacing(DisplayUtils.dip2px(this.mAct, 10.0f));
        this.f24093d.setVerticalSpacing(DisplayUtils.dip2px(this.mAct, -1.5f));
        this.f24093d.setHorizontalChildNum(3);
        this.f24093d.setChildViewHeight(DisplayUtils.dip2px(this.mAct, 78.0f));
        this.n = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_display_translucent"));
        this.f24094e = (ImageView) findViewById(ResUtils.id(this.mAct, "wallet_contacts"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "wallet_fp_rl_contacts"));
        this.f24095f = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f24091b = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_operator"));
        this.f24092c = (TextView) findViewById(ResUtils.id(this.mAct, "wallet_host"));
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
        this.y.getmListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ChargeActivity.this.p.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        this.n.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ChargeActivity.this.f24090a != null) {
                    ChargeActivity chargeActivity = ChargeActivity.this;
                    GlobalUtils.hideInputMethod(chargeActivity.mAct, chargeActivity.f24090a);
                }
                if (ChargeActivity.this.y.isShown()) {
                    ChargeActivity.this.displayHistoryList(false);
                }
                return false;
            }
        });
        final Filter.FilterListener filterListener = new Filter.FilterListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.17
            @Override // android.widget.Filter.FilterListener
            public void onFilterComplete(int i) {
                if (i > 0) {
                    ChargeActivity.this.n.setVisibility(0);
                } else {
                    ChargeActivity.this.n.setVisibility(8);
                }
                ChargeActivity.this.y.displayContactInfoData(ChargeActivity.this.i.getContractInfo());
            }
        };
        this.f24090a.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.18
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "afterTextChanged. s = " + editable.toString());
                if (ChargeActivity.this.k.toString().replace(" ", "").equals(editable.toString().replace(" ", ""))) {
                    return;
                }
                if (ChargeActivity.this.f24090a.getText().length() != 0) {
                    if (ChargeActivity.this.f24090a.getText().length() >= 4 && ChargeActivity.this.f24090a.getText().length() < 13) {
                        ChargeActivity.this.i.getFilter().filter(ChargeActivity.this.f24090a.getText(), filterListener);
                    } else {
                        ChargeActivity.this.displayHistoryList(false);
                    }
                } else {
                    ChargeActivity.this.displayHistoryList(true);
                }
                if (!TextUtils.isEmpty(ChargeActivity.this.x) && editable.toString().equals(ChargeActivity.this.x)) {
                    ChargeActivity.this.b();
                    return;
                }
                ChargeActivity.this.x = "";
                if (ChargeActivity.this.k.length() == 13 && editable.length() < 13) {
                    ChargeActivity.this.f24091b.setText("");
                    ChargeActivity.this.f24092c.setText("");
                    ChargeActivity.this.a((QueryLocationResponse) null);
                }
                ChargeActivity.this.k.delete(0, ChargeActivity.this.k.length());
                ChargeActivity.this.k.append(ChargeActivity.this.f24090a.getText().toString());
                ChargeActivity.this.i();
                if (ChargeActivity.this.k.length() != 13) {
                    if (ChargeActivity.this.l) {
                        return;
                    }
                    ChargeActivity.this.f();
                    return;
                }
                com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "afterTextChanged. mobile = " + ((Object) ChargeActivity.this.k));
                String replace = ChargeActivity.this.f24090a.getText().toString().replace(" ", "");
                if (!com.baidu.wallet.fastpay.sdk.a.a().a(replace)) {
                    ChargeActivity.this.a(false);
                    ChargeActivity.this.a((QueryLocationResponse) null);
                } else {
                    ChargeActivity chargeActivity = ChargeActivity.this;
                    chargeActivity.mDialogMsg = "";
                    if (chargeActivity.j) {
                        ChargeActivity.this.j = false;
                        ChargeActivity.this.f24094e.setImageResource(ResUtils.drawable(ChargeActivity.this.mAct, "wallet_base_fp_contacts_selector1"));
                        AccessibilityUtils.setContentDescription(ChargeActivity.this.f24094e, "通讯录");
                    }
                    ChargeActivity.this.f24090a.setCursorVisible(false);
                    ChargeActivity.this.a(replace);
                    GlobalUtils.hideKeyboard(ChargeActivity.this.mAct.getActivity());
                }
                if (ChargeActivity.this.f24097h.contains(ChargeActivity.this.k.toString()) || ChargeActivity.this.k.toString().equals(ChargeActivity.this.w)) {
                    return;
                }
                PhoneContactsMananger.getInstance(ChargeActivity.this.mAct.getApplicationContext()).loadFixPhoneList(ChargeActivity.this.k.toString(), 1, true, ChargeActivity.this);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "beforeTextChanged. s = " + charSequence.toString());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onTextChanged. s = " + charSequence.toString());
            }
        });
        this.p.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ChargeActivity.this.f24090a != null) {
                    ChargeActivity chargeActivity = ChargeActivity.this;
                    GlobalUtils.hideInputMethod(chargeActivity.mAct, chargeActivity.f24090a);
                    return false;
                }
                return false;
            }
        });
        this.f24090a.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ChargeActivity.this.D) {
                    ChargeActivity.this.f24090a.setText("");
                    ChargeActivity.this.f24090a.setCursorVisible(true);
                    ChargeActivity.this.D = false;
                    return false;
                } else if (ChargeActivity.this.f24090a.getText().length() == 0) {
                    ChargeActivity.this.i();
                    if (!ChargeActivity.this.y.isShow()) {
                        ChargeActivity.this.displayHistoryList(true);
                    }
                    return false;
                } else {
                    List<ContractInfo> contractInfo = ChargeActivity.this.i.getContractInfo();
                    if (ChargeActivity.this.f24090a.getText().length() != 13 && contractInfo.size() > 0) {
                        ChargeActivity.this.n.setVisibility(0);
                        ChargeActivity.this.y.displayContactInfoData(contractInfo);
                    }
                    return false;
                }
            }
        });
        this.f24090a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.21
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (ChargeActivity.this.D) {
                    ChargeActivity.this.f24090a.setText("");
                    ChargeActivity.this.f24090a.setCursorVisible(true);
                    return;
                }
                ChargeActivity.this.o.setBackgroundColor(ResUtils.getColor(ChargeActivity.this.mAct, z ? "wallet_fp_divide_line_5d667a" : "wallet_fp_divide_line_E9EDF7"));
                ChargeActivity.this.f24090a.setCursorVisible(z);
                if (!z || ChargeActivity.this.j || TextUtils.isDigitsOnly(ChargeActivity.this.f24090a.getText().toString())) {
                    return;
                }
                ChargeActivity chargeActivity = ChargeActivity.this;
                if (chargeActivity.mAct == null) {
                    return;
                }
                chargeActivity.j = true;
                ChargeActivity.this.f24094e.setImageResource(ResUtils.drawable(ChargeActivity.this.mAct, "wallet_fp_contacts_close_selector"));
                AccessibilityUtils.setContentDescription(ChargeActivity.this.f24094e, "清除");
            }
        });
        this.f24090a.setOnClickListener(this);
        a((QueryLocationResponse) null);
        d();
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onCreateDalog. id = " + i);
        if (i != 16) {
            return super.onCreateDialog(i);
        }
        return new SelectNumberDialog(this.mAct);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans("ChargeActivity");
        PhoneContactsMananger.getInstance(this.mAct.getApplicationContext()).reset();
        ContactPermissionUtil.restListener();
        super.onDestroy();
    }

    @Override // com.baidu.wallet.fastpay.sdk.a.b
    public void onFastPayFail(final int i, final int i2, final a.C0248a c0248a) {
        BeanActivity beanActivity = this.mAct;
        if (beanActivity == null) {
            return;
        }
        beanActivity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ChargeActivity.this.a(i, i2, c0248a);
            }
        });
    }

    @Override // com.baidu.wallet.fastpay.sdk.a.b
    public void onFastPaySuccess(final int i, final int i2, final Object obj) {
        BeanActivity beanActivity = this.mAct;
        if (beanActivity == null) {
            return;
        }
        beanActivity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ChargeActivity.this.a(i, i2, obj);
            }
        });
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoListener
    public void onFixPhoneList(String str, List<ContractInfo> list) {
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewClickClearHistory() {
        final PromptDialog promptDialog = new PromptDialog(this);
        promptDialog.hideTitle();
        promptDialog.setMessage(ResUtils.getString(this.mAct, "wallet_fp_clear_history_list"));
        promptDialog.setPositiveBtn(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChargeActivity.this.f24097h = new ArrayList();
                com.baidu.wallet.fastpay.b.a.b(ChargeActivity.this.mAct);
                promptDialog.dismiss();
            }
        });
        promptDialog.setNegativeBtn(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChargeActivity.this.i();
                ChargeActivity.this.displayHistoryList(true);
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewClickListViewItemAndSetText(String str) {
        this.f24090a.setText(str);
        CustomAutoTextView customAutoTextView = this.f24090a;
        customAutoTextView.setSelection(customAutoTextView.length());
    }

    @Override // com.baidu.wallet.base.widget.PhoneHistoryFixView.OnPhoneHistoryFixViewClickListener
    public void onFixViewDisplayHistoryViews(boolean z) {
        this.n.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoListener
    public void onLoadFastPayPhoneInfo(String str, ContractInfo contractInfo) {
        if (TextUtils.isEmpty(str) || str.trim().equals(this.w)) {
            return;
        }
        if (contractInfo != null) {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), (TextUtils.isEmpty(contractInfo.getName()) || TextUtils.equals(contractInfo.getName().replace(" ", ""), this.f24090a.getText().toString().replace(" ", ""))) ? buildTipMsg(this.f24092c.getText().toString()) : buildTipMsg(contractInfo.getName(), " | ", this.f24092c.getText().toString()));
            updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), "");
            return;
        }
        updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(ResUtils.getString(this.mAct, "wallet_fp_exclude_contacts"), " | ", this.f24092c.getText().toString()));
        updateTipText(2, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_color"), "");
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onPrepareDialog. id = " + i);
        if (i == 0) {
            ((LoadingDialog) dialog).setMessage(this.mDialogMsg);
        } else if (i == 16) {
            ContactPermissionUtil.prepareSelectNumberDialog(this.mAct, i, dialog);
        } else if (137 == i) {
            ContactPermissionUtil.prepareContactPromptDialog(i, dialog, this.mAct);
        } else if (i == 4642) {
            ContactPermissionUtil.preparePhoneNotCorrectDialog(i, dialog, this.mAct);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 16) {
            ContactAssociationAdapter contactAssociationAdapter = this.i;
            if (contactAssociationAdapter != null) {
                contactAssociationAdapter.loadPhoneContact();
            }
            ContactPermissionUtil.handleOnReadContactPermissionsResult(strArr, iArr, this.mAct, 240, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
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
        super.onResume();
        c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.wallet.fastpay.datamodel.PriceInfo[], java.io.Serializable] */
    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("mobile", this.k.toString());
        bundle.putSerializable("mRealPricInfos", this.u);
        super.onSaveInstanceState(bundle);
    }

    public void setPriceUnused(View view) {
        view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_layout")).setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_fp_bg_face_unable"));
        ((TextView) view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face"))).setTextColor(ResUtils.getColor(getActivity(), "wallet_fp_face_item_unused_edge"));
        ((TextView) view.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price"))).setTextColor(ResUtils.getColor(getActivity(), "wallet_fp_unused_face_item_edge"));
    }

    public void updateTipText(int i, int i2, String str) {
        if (i == 1) {
            this.f24091b.setTextColor(i2);
            this.f24091b.setText(str);
        } else if (i != 2) {
            this.f24091b.setTextColor(i2);
            this.f24091b.setText(str);
        } else {
            this.f24092c.setTextColor(i2);
            this.f24092c.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(this.mAct, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.22
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                ChargeActivity.this.e();
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                WalletGlobalUtils.safeShowDialog(ChargeActivity.this.mAct, -1, "");
                com.baidu.wallet.fastpay.beans.a aVar = (com.baidu.wallet.fastpay.beans.a) FastPayBeanFactory.getInstance().getBean((Context) ChargeActivity.this.mAct, FastPayBeanFactory.BEAN_ID_BIND_INFO, "ChargeActivity");
                aVar.setResponseCallback(ChargeActivity.this);
                aVar.execBean();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (!TextUtils.isEmpty(this.w)) {
            if (this.w.length() > 13) {
                this.f24090a.setText(this.w.substring(0, 13));
            } else {
                this.f24090a.setText(this.w);
            }
        } else if (!this.f24097h.isEmpty()) {
            String str = this.f24097h.get(0);
            if (str.length() > 13) {
                this.f24090a.setText(str.substring(0, 13));
            } else {
                this.f24090a.setText(str);
            }
        } else {
            this.f24090a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
            GlobalUtils.showInputMethod(this.mAct, this.f24090a);
            this.mAct.getWindow().setSoftInputMode(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f24090a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
        this.f24091b.setText("");
        this.l = true;
    }

    @SuppressLint({"UseCheckPermission"})
    private void g() {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (this.j) {
            this.f24090a.setText("");
            this.f24091b.setText("");
            GlobalUtils.showInputMethod(this.mAct, this.f24090a);
            return;
        }
        ContactPermissionUtil.checkIsHasContactPermission(this.mAct, 16, 240, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.K = new LoginBackListenerProxy(this.mAct, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.7
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(ChargeActivity.this.K);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                if (ChargeActivity.this.u != null) {
                    ChargeActivity chargeActivity = ChargeActivity.this;
                    chargeActivity.mDialogMsg = ResUtils.getString(chargeActivity.mAct, "ebpay_safe_handle");
                    WalletGlobalUtils.safeShowDialog(ChargeActivity.this.mAct, 0, "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("param_key_face_value", ChargeActivity.this.v.face);
                    hashMap.put("key_mobile", ChargeActivity.this.f24090a.getText().toString().replace(" ", ""));
                    hashMap.put("param_key_price", ChargeActivity.this.v.sell_price);
                    hashMap.put(com.baidu.wallet.api.Constants.USER_TYPE_KEY, String.valueOf(WalletLoginHelper.getInstance().getLoginType()));
                    hashMap.put(com.baidu.wallet.api.Constants.TOKEN_VALUE_KEY, WalletLoginHelper.getInstance().getLoginToken());
                    com.baidu.wallet.fastpay.sdk.a.a().a(2, hashMap, ChargeActivity.this);
                    if (ChargeActivity.this.f24097h == null) {
                        ChargeActivity.this.f24097h = new ArrayList();
                    }
                    if (!ChargeActivity.this.f24097h.contains(ChargeActivity.this.f24090a.getText().toString())) {
                        ChargeActivity.this.f24097h.add(0, ChargeActivity.this.f24090a.getText().toString());
                    }
                    ChargeActivity chargeActivity2 = ChargeActivity.this;
                    com.baidu.wallet.fastpay.b.a.a(chargeActivity2.mAct, chargeActivity2.f24090a.getText().toString());
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.k.length() > 0) {
            if (this.j) {
                return;
            }
            this.j = true;
            this.f24094e.setImageResource(ResUtils.drawable(this.mAct, "wallet_fp_contacts_close_selector"));
            AccessibilityUtils.setContentDescription(this.f24094e, "清除");
        } else if (this.j) {
            this.j = false;
            this.f24094e.setImageResource(ResUtils.drawable(this.mAct, "wallet_base_fp_contacts_selector1"));
            AccessibilityUtils.setContentDescription(this.f24094e, "通讯录");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.8
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.baidu.wallet.api.Constants.ORDERTYPE_FLAG, 2);
                    jSONObject.put(com.baidu.wallet.api.Constants.ORDER_LIST_TITLE, ResUtils.getString(ChargeActivity.this.getActivity(), "bd_wallet_tab_bill_from_mobile"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                BaiduWalletServiceController.getInstance().gotoWalletService(ChargeActivity.this.mAct, Constants.VIA_REPORT_TYPE_START_WAP, jSONObject.toString());
            }
        }));
    }

    private void k() {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
        this.q = bdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(this.mAct, "wallet_base_phone_charge"));
            this.q.setRightImgZone2NotifyClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24035d);
                    PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24035d);
                    ChargeActivity.this.j();
                }
            });
            this.q.setLeftImgZone2NotifyText(ResUtils.getString(this.mAct, "wallet_fp_return"), 14.0f);
            this.q.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DXMSdkSAUtils.onEvent(com.baidu.wallet.fastpay.a.a.f24036e);
                    PayStatisticsUtil.onEvent(com.baidu.wallet.fastpay.a.a.f24036e);
                    GlobalUtils.hideKeyboard(ChargeActivity.this.mAct.getActivity());
                    ChargeActivity.this.finish();
                }
            });
            BdActionBar bdActionBar2 = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
            this.q = bdActionBar2;
            bdActionBar2.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_base_overflow"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
            this.q.setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChargeActivity.this.F.show();
                }
            });
            this.q.setRightImgZone2Visibility(8);
            CustomerServiceMenu customerServiceMenu = new CustomerServiceMenu(this.q.getRightZoneView(), CustomerServiceMenu.TRANSFER_RECORD);
            this.F = customerServiceMenu;
            customerServiceMenu.setMenuItemClickListener(this.J);
        }
    }

    private void c() {
        c cVar = (c) FastPayBeanFactory.getInstance().getBean((Context) this.mAct, FastPayBeanFactory.BEAN_ID_PROMOTION_INFO, "ChargeActivity");
        cVar.setResponseCallback(this);
        cVar.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = this.k;
        sb.delete(0, sb.length());
        this.k.append(this.f24090a.getText().toString());
        i();
        if (this.k.length() == 13) {
            if (!BaiduTraffic.a().a(this.f24090a.getText().toString().replace(" ", ""))) {
                a(false);
                c(true);
            } else {
                this.mDialogMsg = "";
                if (this.j) {
                    this.j = false;
                    this.f24094e.setImageResource(ResUtils.drawable(this.mAct, "wallet_base_fp_contacts_selector1"));
                    AccessibilityUtils.setContentDescription(this.f24094e, "通讯录");
                }
                this.f24090a.setCursorVisible(false);
                GlobalUtils.hideKeyboard(this.mAct.getActivity());
            }
            if (this.f24097h.contains(this.k.toString()) || this.k.toString().equals(this.w)) {
                return;
            }
            PhoneContactsMananger.getInstance(this.mAct.getApplicationContext()).loadFixPhoneList(this.k.toString(), 1, true, this);
        } else if (this.l) {
        } else {
            f();
        }
    }

    private boolean c(PromotionInfoResponse promotionInfoResponse) {
        FlowLayout flowLayout;
        MoreServiceItemInfo[] moreServiceItemInfoArr;
        MoreServiceItemInfo[] moreServiceItemInfoArr2;
        if (this.B != null && (flowLayout = this.C) != null) {
            if (promotionInfoResponse != null && (moreServiceItemInfoArr = promotionInfoResponse.additional_services) != null && moreServiceItemInfoArr.length != 0) {
                flowLayout.removeAllViews();
                boolean z = false;
                for (final MoreServiceItemInfo moreServiceItemInfo : promotionInfoResponse.additional_services) {
                    if (moreServiceItemInfo != null) {
                        View inflate = LayoutInflater.from(this.mAct).inflate(ResUtils.layout(this.mAct, "wallet_fp_service_item"), (ViewGroup) null);
                        if (!TextUtils.isEmpty(moreServiceItemInfo.title) && !TextUtils.isEmpty(moreServiceItemInfo.img_url) && !TextUtils.isEmpty(moreServiceItemInfo.link_url)) {
                            ((TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_name"))).setText(moreServiceItemInfo.title);
                            ((NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_logo"))).setImageUrl(moreServiceItemInfo.img_url);
                            if (!TextUtils.isEmpty(moreServiceItemInfo.has_corner) && TextUtils.equals(moreServiceItemInfo.has_corner, "2") && !TextUtils.isEmpty(moreServiceItemInfo.corner_url)) {
                                ((NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_service_item_discount"))).setImageUrl(moreServiceItemInfo.corner_url);
                            }
                            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.5
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24034c, Arrays.asList(moreServiceItemInfo.title));
                                    PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24034c, moreServiceItemInfo.title);
                                    int i = moreServiceItemInfo.link_type;
                                    if (i == 1) {
                                        BaiduWalletDelegate.getInstance().openH5Module(ChargeActivity.this.mAct, moreServiceItemInfo.link_url);
                                    } else if (i != 3) {
                                        BaiduWalletDelegate.getInstance().openH5Module(ChargeActivity.this.mAct, moreServiceItemInfo.link_url);
                                    } else {
                                        BaiduWalletServiceController.getInstance().gotoWalletService(ChargeActivity.this.mAct, moreServiceItemInfo.link_url, (String) null);
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

    private void a(PromotionInfoResponse promotionInfoResponse) {
        MenuItemInfo[] menuItemInfoArr;
        MenuItemInfo[] menuItemInfoArr2;
        if (promotionInfoResponse != null && (menuItemInfoArr = promotionInfoResponse.help_menu) != null && menuItemInfoArr.length != 0) {
            this.G.clear();
            this.F.removeAllItem();
            int i = 0;
            for (MenuItemInfo menuItemInfo : promotionInfoResponse.help_menu) {
                if (menuItemInfo != null && !TextUtils.isEmpty(menuItemInfo.title) && !TextUtils.isEmpty(menuItemInfo.img_url) && !TextUtils.isEmpty(menuItemInfo.link_url)) {
                    this.F.add(i, menuItemInfo.title, menuItemInfo.img_url);
                    this.G.add(menuItemInfo);
                    i++;
                }
            }
            if (i > 0) {
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

    private void a() {
        SpannableString spannableString = new SpannableString(ResUtils.getString(this.mAct, "wallet_fp_mobile_hint"));
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(22.0f, this.mAct.getResources().getDisplayMetrics().scaledDensity)), 0, spannableString.length(), 33);
        this.f24090a.setHint(spannableString);
    }

    private void b(PromotionInfoResponse promotionInfoResponse) {
        FrameLayout frameLayout = this.f24096g;
        if (frameLayout == null) {
            return;
        }
        if (promotionInfoResponse == null) {
            frameLayout.setVisibility(8);
        } else if (TextUtils.isEmpty(promotionInfoResponse.promotion_txt)) {
            this.f24096g.setVisibility(8);
        } else {
            CommonPromotionView createAdapterView = new a(getActivity(), promotionInfoResponse).createAdapterView(getActivity());
            if (createAdapterView == null) {
                return;
            }
            this.f24096g.addView(createAdapterView, new FrameLayout.LayoutParams(-1, -2));
            this.f24096g.setVisibility(0);
        }
    }

    private void c(boolean z) {
        PriceInfo[] priceInfoArr;
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
            this.f24093d.addView(inflate);
        }
        this.f24093d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Object obj) {
        if (this.mAct == null) {
            return;
        }
        com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "handleFastPaySuccess. request id = " + i + ", sub id = " + i2 + ", response = " + obj);
        if (i != 1) {
            if (i == 2) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                if (i2 == 1 && obj != null && (obj instanceof FastPayCallBackManager.PayStateModle) && ((FastPayCallBackManager.PayStateModle) obj).statecode == 3) {
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
        if (!z || this.s.getVisibility() == 0) {
            if (!z && this.s.getVisibility() == 0) {
                this.A.setVisibility(8);
                return;
            }
            this.s.setVisibility(z ? 8 : 0);
            this.A.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, a.C0248a c0248a) {
        if (this.mAct == null) {
            return;
        }
        if (BeanConstants.DEBUG) {
            com.baidu.wallet.core.utils.LogUtil.d("ChargerFragment", "onFail. requestId = " + i + ", sub id = " + i2 + ", error code = " + c0248a.f24086a + ", msg = " + c0248a.f24087b);
        }
        if (i != 1) {
            if (i == 2) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                int i3 = c0248a.f24086a;
                if (i3 != 5140 && i3 != 5139) {
                    if (i3 == 5003) {
                        WalletLoginHelper.getInstance().handlerWalletError(5003);
                        AccountManager.getInstance(this.mAct).logout();
                        WalletLoginHelper.getInstance().logout(false);
                    }
                    GlobalUtils.toast(this.mAct, c0248a.f24087b);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("sdk_from", "1");
                hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, c0248a.f24086a == 5140 ? HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9 : "0");
                BaiduPayDelegate.getInstance().doRNAuth(this.mAct, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.4
                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str) {
                        if (i4 == 0) {
                            ChargeActivity.this.h();
                        } else {
                            GlobalUtils.toast(ChargeActivity.this.mAct, str);
                        }
                    }
                });
                return;
            }
            return;
        }
        this.x = "";
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        int i4 = c0248a.f24086a;
        if (i4 == -4) {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0248a.f24087b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        } else if (19030 == i4) {
            a(true);
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0248a.f24087b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        } else {
            updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(c0248a.f24087b));
            updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
            a((QueryLocationResponse) null);
        }
    }

    private void a(boolean z, PromotionInfoResponse promotionInfoResponse) {
        BannerChargeItemInfo[] bannerChargeItemInfoArr;
        BannerLayoutForAd bannerLayoutForAd = this.z;
        if (bannerLayoutForAd == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.l = false;
        this.f24090a.setPadding(DisplayUtils.dip2px(this.mAct, 15.0f), 0, 0, 0);
        if (z || TextUtils.isEmpty(this.f24090a.getText().toString()) || this.f24090a.getText().toString().length() < 13) {
            return;
        }
        updateTipText(1, ResUtils.getColor(this.mAct, "wallet_fp_tip_text_error_color"), buildTipMsg(ResUtils.getString(this.mAct, "wallet_fp_wrong_number")));
        updateTipText(2, ResUtils.getColor(this.mAct, "bd_wallet_text_gray"), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QueryLocationResponse queryLocationResponse) {
        ViewGroup viewGroup = null;
        this.u = null;
        if (queryLocationResponse != null) {
            this.u = queryLocationResponse.price_info;
        }
        if (this.u == null) {
            b(true);
            this.f24093d.setVisibility(0);
            this.f24093d.removeAllViews();
            if (queryLocationResponse == null) {
                c(true);
                return;
            } else {
                c(false);
                return;
            }
        }
        this.f24090a.setCursorVisible(false);
        PriceInfo[] priceInfoArr = this.u;
        if (priceInfoArr.length <= 0) {
            b(false);
            this.f24093d.setVisibility(8);
            return;
        }
        this.u = a(priceInfoArr);
        b(true);
        this.f24093d.setVisibility(0);
        this.f24093d.removeAllViews();
        int length = this.u.length;
        FastPayFacePromotionInfoResponse[] fastPayFacePromotionInfoResponseArr = queryLocationResponse.promotion_info;
        int i = 0;
        while (i < length) {
            View inflate = LayoutInflater.from(this.mAct).inflate(ResUtils.layout(this.mAct, "wallet_fp_face_item"), viewGroup);
            inflate.setEnabled(true);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face"));
            TextView textView2 = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_price"));
            final String str = this.u[i].face;
            if (!TextUtils.isEmpty(str) && str.length() > 2) {
                String string = ResUtils.getString(this.mAct, "wallet_fp_price");
                PriceInfo[] priceInfoArr2 = this.u;
                SpannableString spannableString = new SpannableString(String.format(string, priceInfoArr2[i].face.substring(0, priceInfoArr2[i].face.length() - 2)));
                textView.setText(spannableString);
                textView2.setText(spannableString);
            }
            if (!TextUtils.isEmpty(this.u[i].sell_price)) {
                textView2.setText(new SpannableString(String.format(ResUtils.getString(this.mAct, "wallet_fp_sell_price"), new BigDecimal(this.u[i].sell_price).multiply(BigDecimal.valueOf(0.01d)))));
            } else {
                textView2.setText(ResUtils.getString(this.mAct, "wallet_fp_lack_good"));
            }
            NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(this.mAct, "wallet_fp_item_face_discount"));
            if (fastPayFacePromotionInfoResponseArr != null && fastPayFacePromotionInfoResponseArr.length > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= fastPayFacePromotionInfoResponseArr.length) {
                        break;
                    }
                    String str2 = fastPayFacePromotionInfoResponseArr[i2].face;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equals(str)) {
                        netImageView.setImageUrl(fastPayFacePromotionInfoResponseArr[i2].icon);
                        netImageView.setVisibility(0);
                        break;
                    }
                    i2++;
                }
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.ChargeActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str3;
                    if (ChargeActivity.this.isFastDoubleClick()) {
                        return;
                    }
                    try {
                        str3 = new BigDecimal(str).divide(new BigDecimal(100), 6).toPlainString();
                    } catch (Exception unused) {
                        str3 = "";
                    }
                    DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24037f, Arrays.asList(str3));
                    PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24037f, str3);
                    ChargeActivity.this.f24090a.setCursorVisible(false);
                    GlobalUtils.hideKeyboard(ChargeActivity.this.mAct.getActivity());
                    if (ChargeActivity.this.j) {
                        ChargeActivity.this.j = false;
                        ChargeActivity.this.f24094e.setImageResource(ResUtils.drawable(ChargeActivity.this.mAct, "wallet_base_fp_contacts_selector1"));
                        AccessibilityUtils.setContentDescription(ChargeActivity.this.f24094e, "通讯录");
                    }
                    ChargeActivity.this.v = (PriceInfo) view.getTag();
                    if (ChargeActivity.this.v.isExist) {
                        ChargeActivity.this.h();
                    }
                }
            });
            inflate.setTag(this.u[i]);
            if (!this.u[i].isExist) {
                setPriceUnused(inflate);
            }
            this.f24093d.addView(inflate);
            i++;
            viewGroup = null;
        }
    }

    private PriceInfo[] a(PriceInfo[] priceInfoArr) {
        PriceInfo[] priceInfoArr2 = {new PriceInfo(Constants.DEFAULT_UIN, null, null), new PriceInfo("2000", null, null), new PriceInfo("3000", null, null), new PriceInfo("5000", null, null), new PriceInfo("10000", null, null), new PriceInfo("20000", null, null), new PriceInfo("30000", null, null), new PriceInfo("50000", null, null)};
        for (PriceInfo priceInfo : priceInfoArr) {
            for (int i = 0; i < 8; i++) {
                PriceInfo priceInfo2 = priceInfoArr2[i];
                if (priceInfo.equals(priceInfo2)) {
                    priceInfo2.sell_price = priceInfo.sell_price;
                    priceInfo2.discount = priceInfo.discount;
                    priceInfo2.isExist = true;
                }
            }
        }
        return priceInfoArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.mAct == null) {
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
