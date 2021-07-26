package com.baidu.wallet.personal.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.CirclePortraitView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.banner.BannerLayoutForAd;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshListView;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.CommonUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.baidu.wallet.personal.beans.d;
import com.baidu.wallet.personal.datamodel.BannerCouponItemInfo;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import com.baidu.wallet.personal.storage.PersonalPreferenceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MyCouponListActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "MyCouponListActivity";
    public static final String EXTRA_DATA = "extra_data";
    public static final int REQUEST_CODE_COUPON_DETAIL = 1;
    public static final int REQUEST_CODE_INVALID_COUPON_DETAIL = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final String KEY;
    public final String TIMESTAMP;
    public ImageView actionBarLine;
    public BdActionBar bdActionBar;
    public int coupon_receive_timestamp;
    public View emptyBanner;
    public LinearLayout emptyUseless;
    public String getCouponUrl;
    public String isFormNewPromot;
    public boolean isHasCouponAndBanner;
    public boolean isInvaild;
    public boolean isLoading;
    public int last_coupon_receive_timestamp;
    public String latitude;
    public String longitude;
    public BaseAdapter mAdapter;
    public PullToRefreshListView mContainer;
    public BannerLayoutForAd mCouponBanner;
    public BannerLayoutForAd mCouponBanner1;
    public List<CouponList.Coupon> mCouponList;
    public int mCurrPage;
    public String mCurrrentActivityId;
    public String mCurrrentActivityType;
    @SuppressLint({"SimpleDateFormat"})
    public final SimpleDateFormat mDateFormat;
    public View mEmptyView;
    public TextView mExpire_message;
    public boolean mFirstGetCoupon;
    public TextView mHintView;
    public ImageButton mIbX;
    public ListView mListView;
    public View mLlBanner;
    public int mLoadStatus;
    public WalletBaseEmptyView mReloadView;
    public RelativeLayout mroeCouponLayout;
    public boolean needRefreshCouponlist;
    public ImageView noCouponImage;
    public TextView noCouponLint;
    public TextView noCouponText;
    public long now;
    public int recvCount;
    public PromptDialog thirdLoginTipDialog;
    public LinearLayout useless;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyCouponListActivity f27283a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f27284b;

        public a(MyCouponListActivity myCouponListActivity, ListView listView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myCouponListActivity, listView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27283a = myCouponListActivity;
            this.f27284b = LayoutInflater.from(myCouponListActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public CouponList.Coupon getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < this.f27283a.mCouponList.size()) {
                    return (CouponList.Coupon) this.f27283a.mCouponList.get(i2);
                }
                return null;
            }
            return (CouponList.Coupon) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27283a.mCouponList.size() + 1 : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 < this.f27283a.mCouponList.size() ? 0 : 1 : invokeI.intValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x02ab  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x038a  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0468  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0512  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x052c  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            c cVar;
            TextView textView;
            String string;
            int length;
            TextView textView2;
            BeanActivity beanActivity;
            String str;
            TextView textView3;
            TextView textView4;
            String str2;
            TextView textView5;
            String str3;
            TextView textView6;
            String str4;
            TextView textView7;
            String str5;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) != null) {
                return (View) invokeILL.objValue;
            }
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return view;
                }
                if (view == 0 || view.getTag() == null) {
                    int emptyHeight = this.f27283a.getEmptyHeight();
                    AbsListView.LayoutParams layoutParams = emptyHeight > 0 ? new AbsListView.LayoutParams(-1, emptyHeight) : new AbsListView.LayoutParams(-1, -1);
                    View view2 = new View(this.f27283a.mAct);
                    view2.setLayoutParams(layoutParams);
                    return view2;
                }
                return view;
            }
            CouponList.Coupon item = getItem(i2);
            if (item.isLabel) {
                if (view == null || view.getTag() != null) {
                    view = this.f27284b.inflate(ResUtils.layout(this.f27283a.mAct, "wallet_personal_coupon_label"), (ViewGroup) null);
                }
                ((TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "bd_wallet_coupon_label"))).setText(item.labelValue);
                return view;
            }
            DXMSdkSAUtils.onEventWithValues("#couponShow", Arrays.asList(item.logo_title, item.template_title));
            PayStatisticsUtil.onEventWithValues("#couponShow", Arrays.asList(item.logo_title, item.template_title));
            if (view == null || view.getTag() == null) {
                cVar = new c();
                view = this.f27284b.inflate(ResUtils.layout(this.f27283a.mAct, "wallet_personal_coupon_item1"), (ViewGroup) null);
                cVar.f27291b = (CirclePortraitView) view.findViewById(ResUtils.id(this.f27283a.mAct, "sp_logo"));
                cVar.f27292c = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "logo_title"));
                cVar.f27293d = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "couppon_maket_label"));
                cVar.f27294e = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_tempalte_title"));
                cVar.f27295f = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_use_limit"));
                cVar.f27296g = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_content"));
                cVar.f27297h = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "couppon_time_limit"));
                cVar.f27298i = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_valid_time"));
                cVar.j = (TextView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_use_now_text"));
                cVar.k = (ImageView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_use_now_img"));
                cVar.l = (ImageView) view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_new"));
                view.setTag(cVar);
                cVar.m = view.findViewById(ResUtils.id(this.f27283a.mAct, "coupn_use_now"));
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f27291b.setImageDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_qianbao_logo_for_list"));
            if (!TextUtils.isEmpty(item.logo_url)) {
                cVar.f27291b.setImageUrl(item.logo_url);
            }
            if (TextUtils.isEmpty(item.logo_title)) {
                textView = cVar.f27292c;
                string = ResUtils.getString(this.f27283a.mAct, "wallet_personal_coupon_logo_title");
            } else {
                textView = cVar.f27292c;
                string = item.logo_title;
            }
            textView.setText(string);
            if (TextUtils.isEmpty(item.marketing_label)) {
                cVar.f27293d.setVisibility(8);
            } else {
                if (item.marketing_label.length() > 7) {
                    textView7 = cVar.f27293d;
                    str5 = item.marketing_label.substring(0, 7);
                } else {
                    textView7 = cVar.f27293d;
                    str5 = item.marketing_label;
                }
                textView7.setText(str5);
                cVar.f27293d.setVisibility(0);
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.f27283a.mAct, 40.0f));
            AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.f27283a.mAct, 30.0f));
            StyleSpan styleSpan = new StyleSpan(1);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.discount_content_v2);
            if (TextUtils.isEmpty(item.discount_content_v2_unit)) {
                length = spannableStringBuilder.length();
            } else if (item.discount_content_v2.length() > 7) {
                spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
                cVar.f27296g.setText(spannableStringBuilder);
                cVar.f27294e.setText(item.template_title);
                cVar.f27295f.setText(item.use_limit_v2);
                if (item.source_type == 1) {
                    textView2 = cVar.f27296g;
                    beanActivity = this.f27283a.mAct;
                    str = "wallet_coupon_red";
                } else {
                    textView2 = cVar.f27296g;
                    beanActivity = this.f27283a.mAct;
                    str = "wallet_coupon_blue";
                }
                textView2.setTextColor(ResUtils.getColor(beanActivity, str));
                if (TextUtils.isEmpty(item.date_message_expire)) {
                    cVar.f27297h.setSingleLine(true);
                    cVar.f27297h.setEllipsize(TextUtils.TruncateAt.END);
                    if (item.date_message_expire.length() > 7) {
                        textView6 = cVar.f27297h;
                        str4 = item.date_message_expire.substring(0, 7);
                    } else {
                        textView6 = cVar.f27297h;
                        str4 = item.date_message_expire;
                    }
                    textView6.setText(str4);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(this.f27283a.mAct, 89.5f), DisplayUtils.dip2px(this.f27283a.mAct, 16.5f));
                    layoutParams2.setMargins(0, DisplayUtils.dip2px(this.f27283a.mAct, 6.0f), 0, 0);
                    cVar.f27297h.setLayoutParams(layoutParams2);
                    cVar.f27297h.setGravity(17);
                    cVar.f27297h.setPadding(DisplayUtils.dip2px(this.f27283a.mAct, 13.0f), DisplayUtils.dip2px(this.f27283a.mAct, 1.0f), DisplayUtils.dip2px(this.f27283a.mAct, 6.0f), DisplayUtils.dip2px(this.f27283a.mAct, 0.5f));
                    cVar.f27297h.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_date_message_expire"));
                    cVar.f27297h.setBackgroundResource(ResUtils.drawable(this.f27283a.mAct, "wallet_personal_coupon_daojishi"));
                    cVar.f27297h.setTextSize(1, 11.0f);
                    cVar.f27298i.setVisibility(8);
                } else {
                    if (TextUtils.isEmpty(item.date_not_started)) {
                        cVar.f27297h.setText(item.date_message_v2);
                        cVar.f27297h.setTextSize(1, 11.0f);
                        cVar.f27297h.setBackgroundDrawable(null);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.setMargins(0, DisplayUtils.dip2px(this.f27283a, 6.0f), 0, 0);
                        cVar.f27297h.setPadding(0, 0, 0, 0);
                        cVar.f27297h.setLayoutParams(layoutParams3);
                        cVar.f27298i.setVisibility(8);
                        cVar.f27297h.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_txt_999999"));
                        textView3 = cVar.f27297h;
                    } else {
                        cVar.f27297h.setPadding(0, 0, 0, 0);
                        if (item.date_not_started.length() > 4) {
                            textView4 = cVar.f27297h;
                            str2 = item.date_not_started.substring(0, 4);
                        } else {
                            textView4 = cVar.f27297h;
                            str2 = item.date_not_started;
                        }
                        textView4.setText(str2);
                        cVar.f27297h.setTextSize(1, 10.0f);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.setMargins(0, DisplayUtils.dip2px(this.f27283a, 4.0f), 0, 0);
                        cVar.f27297h.setBackgroundDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_xianshiduan_bg"));
                        cVar.f27297h.setLayoutParams(layoutParams4);
                        cVar.f27297h.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_txt_999999"));
                        cVar.f27297h.setVisibility(0);
                        cVar.f27298i.setText(item.date_message_v2);
                        textView3 = cVar.f27298i;
                    }
                    textView3.setVisibility(0);
                }
                if (!TextUtils.isEmpty(item.scene_service_label)) {
                    if (item.scene_service_label.length() > 6) {
                        textView5 = cVar.j;
                        str3 = item.scene_service_label.substring(0, 6);
                    } else {
                        textView5 = cVar.j;
                        str3 = item.scene_service_label;
                    }
                    textView5.setText(str3);
                }
                if (TextUtils.isEmpty(item.date_not_started) || (item.app_scene_service == null && TextUtils.isEmpty(item.scene_service))) {
                    cVar.j.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_txt_disable"));
                    cVar.k.setImageDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_triangle_grey"));
                    cVar.m.setClickable(false);
                } else {
                    cVar.j.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_btn_txt_blue"));
                    cVar.k.setImageDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_triangle"));
                    cVar.m.setBackgroundDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_list_btn_background"));
                    cVar.m.setOnClickListener(new View.OnClickListener(this, item) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ CouponList.Coupon f27285a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f27286b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, item};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27286b = this;
                            this.f27285a = item;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BaiduWalletDelegate baiduWalletDelegate;
                            BeanActivity beanActivity2;
                            String str6;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                if (this.f27286b.f27283a.coupon_receive_timestamp > this.f27286b.f27283a.last_coupon_receive_timestamp) {
                                    MyCouponListActivity myCouponListActivity = this.f27286b.f27283a;
                                    myCouponListActivity.last_coupon_receive_timestamp = myCouponListActivity.coupon_receive_timestamp;
                                    MyCouponListActivity myCouponListActivity2 = this.f27286b.f27283a;
                                    SharedPreferencesUtils.setParam(myCouponListActivity2.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(myCouponListActivity2.last_coupon_receive_timestamp));
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("template_num", this.f27285a.template_num);
                                    jSONObject.put("coupon_num", this.f27285a.coupon_num);
                                    jSONObject.put("card_type", this.f27285a.card_type);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                DXMSdkSAUtils.onEventWithValues("CouponListToUseBtnClick", Arrays.asList(jSONObject.toString()));
                                PayStatisticsUtil.onEventWithValue("CouponListToUseBtnClick", jSONObject.toString());
                                CouponList.Coupon coupon = this.f27285a;
                                CouponList.Coupon.AppSceneService appSceneService = coupon.app_scene_service;
                                if (appSceneService != null) {
                                    if (appSceneService.f27247android > 0) {
                                        this.f27286b.f27283a.needRefreshCouponlist = true;
                                        BaiduWalletServiceController.getInstance().gotoWalletService(this.f27286b.f27283a.mAct, this.f27285a.app_scene_service.f27247android, "");
                                        return;
                                    } else if (TextUtils.isEmpty(appSceneService.url)) {
                                        return;
                                    } else {
                                        this.f27286b.f27283a.needRefreshCouponlist = true;
                                        baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                        beanActivity2 = this.f27286b.f27283a.mAct;
                                        str6 = this.f27285a.app_scene_service.url;
                                    }
                                } else if (TextUtils.isEmpty(coupon.scene_service)) {
                                    return;
                                } else {
                                    this.f27286b.f27283a.needRefreshCouponlist = true;
                                    baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                    beanActivity2 = this.f27286b.f27283a.mAct;
                                    str6 = this.f27285a.scene_service;
                                }
                                baiduWalletDelegate.openH5Module(beanActivity2, str6, true);
                            }
                        }
                    });
                }
                if (item.coupon_receive_timestamp > this.f27283a.last_coupon_receive_timestamp) {
                    cVar.l.setVisibility(8);
                    return view;
                }
                cVar.l.setBackgroundResource(ResUtils.drawable(this.f27283a.mAct, "wallet_personal_coupon_new"));
                cVar.l.setVisibility(0);
                return view;
            } else {
                spannableStringBuilder.append((CharSequence) item.discount_content_v2_unit);
                if (TextUtils.equals("%", item.discount_content_v2_unit)) {
                    spannableStringBuilder.setSpan(absoluteSizeSpan2, 0, 1, 18);
                    spannableStringBuilder.setSpan(absoluteSizeSpan, 1, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                    spannableStringBuilder.setSpan(styleSpan, 1, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                } else {
                    spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                }
                length = spannableStringBuilder.length() - item.discount_content_v2_unit.length();
            }
            spannableStringBuilder.setSpan(styleSpan, 0, length, 18);
            cVar.f27296g.setText(spannableStringBuilder);
            cVar.f27294e.setText(item.template_title);
            cVar.f27295f.setText(item.use_limit_v2);
            if (item.source_type == 1) {
            }
            textView2.setTextColor(ResUtils.getColor(beanActivity, str));
            if (TextUtils.isEmpty(item.date_message_expire)) {
            }
            if (!TextUtils.isEmpty(item.scene_service_label)) {
            }
            if (TextUtils.isEmpty(item.date_not_started)) {
            }
            cVar.j.setTextColor(ResUtils.getColor(this.f27283a.mAct, "wallet_coupon_txt_disable"));
            cVar.k.setImageDrawable(ResUtils.getDrawable(this.f27283a.mAct, "wallet_personal_coupon_triangle_grey"));
            cVar.m.setClickable(false);
            if (item.coupon_receive_timestamp > this.f27283a.last_coupon_receive_timestamp) {
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f27287a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MyCouponListActivity f27288b;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f27289c;

        public b(MyCouponListActivity myCouponListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myCouponListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27288b = myCouponListActivity;
            this.f27289c = LayoutInflater.from(myCouponListActivity.mAct);
        }

        private void b(int i2) {
            ImageView imageView;
            BeanActivity beanActivity;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
                if (i2 == 0) {
                    imageView = this.f27287a.l;
                    beanActivity = this.f27288b.mAct;
                    str = "wallet_personal_coupon_expired";
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        imageView = this.f27287a.l;
                        beanActivity = this.f27288b.mAct;
                        str = "wallet_personal_coupon_disabled";
                    }
                    this.f27287a.l.setVisibility(0);
                } else {
                    imageView = this.f27287a.l;
                    beanActivity = this.f27288b.mAct;
                    str = "wallet_personal_coupon_used";
                }
                imageView.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
                this.f27287a.l.setVisibility(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public CouponList.Coupon getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (CouponList.Coupon) this.f27288b.mCouponList.get(i2) : (CouponList.Coupon) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27288b.mCouponList.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0253  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x027c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0280  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            TextView textView;
            String string;
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                CouponList.Coupon item = getItem(i2);
                if (view == null || view.getTag() == null) {
                    this.f27287a = new c();
                    view = this.f27289c.inflate(ResUtils.layout(this.f27288b.mAct, "wallet_personal_coupon_item1"), (ViewGroup) null);
                    this.f27287a.f27291b = (CirclePortraitView) view.findViewById(ResUtils.id(this.f27288b.mAct, "sp_logo"));
                    this.f27287a.f27292c = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "logo_title"));
                    this.f27287a.f27293d = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "couppon_maket_label"));
                    this.f27287a.f27294e = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "coupn_tempalte_title"));
                    this.f27287a.f27295f = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "coupn_use_limit"));
                    this.f27287a.f27296g = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "coupn_content"));
                    this.f27287a.f27296g.setTextColor(ResUtils.getColor(this.f27288b.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
                    this.f27287a.f27298i = (TextView) view.findViewById(ResUtils.id(this.f27288b.mAct, "couppon_time_limit"));
                    this.f27287a.f27298i.setTextColor(ResUtils.getColor(this.f27288b.mAct, "wallet_coupon_txt_999999"));
                    this.f27287a.l = (ImageView) view.findViewById(ResUtils.id(this.f27288b.mAct, "coupn_used"));
                    this.f27287a.m = view.findViewById(ResUtils.id(this.f27288b.mAct, "coupn_use_now"));
                    this.f27287a.m.setVisibility(8);
                    view.setTag(this.f27287a);
                } else {
                    this.f27287a = (c) view.getTag();
                }
                this.f27287a.f27291b.setImageDrawable(ResUtils.getDrawable(this.f27288b.mAct, "wallet_personal_coupon_qianbao_logo_for_list"));
                if (TextUtils.isEmpty(item.logo_title)) {
                    textView = this.f27287a.f27292c;
                    string = ResUtils.getString(this.f27288b.mAct, "wallet_personal_coupon_logo_title");
                } else {
                    textView = this.f27287a.f27292c;
                    string = item.logo_title;
                }
                textView.setText(string);
                if (!TextUtils.isEmpty(item.logo_url)) {
                    this.f27287a.f27291b.setImageUrl(item.logo_url);
                }
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                this.f27287a.f27291b.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                this.f27287a.f27293d.setVisibility(8);
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.f27288b.mAct, 40.0f));
                AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.f27288b.mAct, 30.0f));
                StyleSpan styleSpan = new StyleSpan(1);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.discount_content_v2);
                if (TextUtils.isEmpty(item.discount_content_v2_unit)) {
                    length = spannableStringBuilder.length();
                } else if (item.discount_content_v2.length() > 7) {
                    spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
                    this.f27287a.f27296g.setText(spannableStringBuilder);
                    this.f27287a.f27294e.setText(item.template_title);
                    this.f27287a.f27295f.setText(item.use_limit_v2);
                    if (TextUtils.isEmpty(item.date_message)) {
                        this.f27287a.f27298i.setVisibility(0);
                        this.f27287a.f27298i.setText(item.date_message);
                    } else {
                        this.f27287a.f27298i.setVisibility(8);
                    }
                    switch (item.status) {
                        case 3:
                        case 8:
                        case 9:
                        case 10:
                            b(1);
                            break;
                        case 4:
                            b(0);
                            break;
                        case 5:
                        case 6:
                        case 7:
                            b(2);
                            break;
                    }
                    return view;
                } else {
                    spannableStringBuilder.append((CharSequence) item.discount_content_v2_unit);
                    if (TextUtils.equals("%", item.discount_content_v2_unit)) {
                        spannableStringBuilder.setSpan(absoluteSizeSpan2, 0, 1, 18);
                        spannableStringBuilder.setSpan(absoluteSizeSpan, 1, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                        spannableStringBuilder.setSpan(styleSpan, 1, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                    } else {
                        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length() - item.discount_content_v2_unit.length(), 18);
                    }
                    length = spannableStringBuilder.length() - item.discount_content_v2_unit.length();
                }
                spannableStringBuilder.setSpan(styleSpan, 0, length, 18);
                this.f27287a.f27296g.setText(spannableStringBuilder);
                this.f27287a.f27294e.setText(item.template_title);
                this.f27287a.f27295f.setText(item.use_limit_v2);
                if (TextUtils.isEmpty(item.date_message)) {
                }
                switch (item.status) {
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyCouponListActivity f27290a;

        /* renamed from: b  reason: collision with root package name */
        public CirclePortraitView f27291b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27292c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27293d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27294e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f27295f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27296g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f27297h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f27298i;
        public TextView j;
        public ImageView k;
        public ImageView l;
        public View m;

        public c(MyCouponListActivity myCouponListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myCouponListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27290a = myCouponListActivity;
        }
    }

    public MyCouponListActivity() {
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
        this.TIMESTAMP = "coupon_recive_timestamp";
        this.KEY = "last_coupon_receive_timestamp_key";
        this.mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        this.mCurrrentActivityId = "";
        this.mCurrrentActivityType = "";
        this.last_coupon_receive_timestamp = 0;
        this.getCouponUrl = null;
        this.mCurrPage = 0;
        this.mLoadStatus = 0;
        this.isLoading = false;
        this.longitude = "";
        this.latitude = "";
        this.recvCount = 0;
        this.mHintView = null;
        this.useless = null;
        this.emptyUseless = null;
        this.mFirstGetCoupon = true;
        this.needRefreshCouponlist = false;
        this.isFormNewPromot = "";
        this.isHasCouponAndBanner = true;
        this.isInvaild = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEmptyHeight() {
        InterceptResult invokeV;
        int i2;
        int i3;
        ListAdapter adapter;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            int displayHeight = DisplayUtils.getDisplayHeight(this.mAct);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            if (this.mCouponBanner1.isShown()) {
                this.mCouponBanner1.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = this.mCouponBanner1.getMeasuredHeight();
            } else {
                i2 = 0;
            }
            if (this.mCouponList.size() > 0) {
                if (this.isHasCouponAndBanner) {
                    adapter = this.mListView.getAdapter();
                    i4 = 2;
                } else {
                    adapter = this.mListView.getAdapter();
                    i4 = 1;
                }
                View view = adapter.getView(i4, null, this.mListView);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = view.getMeasuredHeight();
            } else {
                i3 = 0;
            }
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            int size = ((((displayHeight - (i3 * this.mCouponList.size())) - DisplayUtils.dip2px(this.mAct, 50.0f)) - DisplayUtils.dip2px(this.mAct, 50.0f)) - i2) - (identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0);
            int dip2px = DisplayUtils.dip2px(this.mAct, 40.0f);
            if (size > dip2px) {
                return size - dip2px;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private void handleEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (!TextUtils.isEmpty(this.getCouponUrl)) {
                this.mEmptyView.findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_get")).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ MyCouponListActivity f27280a;

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
                        this.f27280a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f27280a.getCouponUrl)) {
                            return;
                        }
                        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                        MyCouponListActivity myCouponListActivity = this.f27280a;
                        baiduWalletDelegate.openH5Module(myCouponListActivity.mAct, myCouponListActivity.getCouponUrl, true);
                    }
                });
            }
            if (this.isInvaild) {
                this.noCouponImage.setImageDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_empty"));
                this.noCouponText.setText(ResUtils.getString(this.mAct, "wallet_personal_coupon_invalid_no_coupon_text"));
                this.noCouponLint.setText(ResUtils.getString(this.mAct, "wallet_personal_coupon_invalid_no_coupon_lint"));
            }
        }
    }

    private void hideEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mEmptyView.setVisibility(8);
            this.mReloadView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public void queryCoupon(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || getActivity() == null) {
            return;
        }
        LogUtil.d("BDWalletContentFragement. queryCoupon. curr page = " + this.mCurrPage);
        if (z) {
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        }
        this.isLoading = true;
        com.baidu.wallet.personal.beans.b a2 = com.baidu.wallet.personal.beans.b.a();
        BeanActivity beanActivity = this.mAct;
        d dVar = (d) a2.getBean(beanActivity, 515, BEAN_TAG + hashCode());
        dVar.a(String.valueOf(this.mCurrPage));
        dVar.b(this.isFormNewPromot);
        if (this.isInvaild) {
            dVar.c("2");
        }
        dVar.a(this.mCurrrentActivityId, this.mCurrrentActivityType, str, str2);
        dVar.setResponseCallback(this);
        dVar.execBean();
        this.now = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmptyView(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, str) == null) || this.mEmptyView == null || getActivity() == null) {
            return;
        }
        int i2 = this.mLoadStatus;
        if (i2 == 3) {
            this.mReloadView.setVisibility(0);
            WalletBaseEmptyView walletBaseEmptyView = this.mReloadView;
            int drawable = ResUtils.drawable(this.mAct, "wallet_base_no_net");
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mAct, "wallet_base_no_network");
            }
            walletBaseEmptyView.showTip1_NextBtn(drawable, str, ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27278a;

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
                    this.f27278a = this;
                }

                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27278a.queryCoupon(true, null, null);
                    }
                }
            });
        } else if (i2 == 2) {
            this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(this.mAct, "wallet_base_no_net"), ResUtils.getString(this.mAct, "wallet_base_no_network"), ResUtils.getString(this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27279a;

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
                    this.f27279a = this;
                }

                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27279a.queryCoupon(true, null, null);
                    }
                }
            });
            this.mReloadView.setVisibility(0);
        } else {
            this.mEmptyView.setVisibility(0);
            if (!this.isInvaild) {
                this.emptyUseless.setVisibility(0);
            }
            handleEmptyView();
        }
        this.mCouponList.clear();
        this.recvCount = 0;
        this.mAdapter.notifyDataSetChanged();
    }

    private void updateData(CouponListResponse couponListResponse) {
        BannerCouponItemInfo[] bannerCouponItemInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, this, couponListResponse) == null) || couponListResponse == null) {
            return;
        }
        CouponList[] couponListArr = couponListResponse.coupon_list;
        if (couponListArr == null || couponListArr.length < 1) {
            if (this.isInvaild || (bannerCouponItemInfoArr = couponListResponse.banner_ad_info) == null) {
                return;
            }
            this.mCouponBanner.setConfigData(bannerCouponItemInfoArr);
            this.mCouponBanner.setVisibility(0);
            return;
        }
        if (!this.isInvaild) {
            this.mCouponBanner.setVisibility(8);
            BannerCouponItemInfo[] bannerCouponItemInfoArr2 = couponListResponse.banner_ad_info;
            if (bannerCouponItemInfoArr2 != null) {
                this.mCouponBanner1.setConfigData(bannerCouponItemInfoArr2);
                this.mCouponBanner1.setMaiDianDataKey("CouponListClickBanner");
                this.mCouponBanner1.setVisibility(0);
                if (!this.isHasCouponAndBanner) {
                    this.mListView.addHeaderView(this.mCouponBanner1);
                    this.isHasCouponAndBanner = true;
                }
            } else if (this.isHasCouponAndBanner) {
                this.mListView.removeHeaderView(this.mCouponBanner1);
                this.mCouponBanner1.setVisibility(8);
                this.isHasCouponAndBanner = false;
            }
        }
        int i2 = 0;
        while (true) {
            CouponList[] couponListArr2 = couponListResponse.coupon_list;
            if (i2 >= couponListArr2.length) {
                return;
            }
            String str = couponListArr2[i2].label;
            if (couponListArr2[i2].coupons != null && couponListArr2[i2].coupons.length > 0) {
                int i3 = 0;
                while (true) {
                    CouponList[] couponListArr3 = couponListResponse.coupon_list;
                    if (i3 < couponListArr3[i2].coupons.length) {
                        if (couponListArr3[i2].coupons[i3].coupon_receive_timestamp > this.coupon_receive_timestamp && !this.isInvaild) {
                            this.coupon_receive_timestamp = couponListArr3[i2].coupons[i3].coupon_receive_timestamp;
                        }
                        CouponList[] couponListArr4 = couponListResponse.coupon_list;
                        couponListArr4[i2].coupons[i3].labelValue = str;
                        this.mCouponList.add(couponListArr4[i2].coupons[i3]);
                        this.recvCount++;
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            DXMSdkSAUtils.onEventWithValues("CouponListRequestFail", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
            PayStatisticsUtil.onEventWithValue("CouponListRequestFail", (System.currentTimeMillis() - this.now) + "");
            BeanActivity beanActivity = this.mAct;
            if (beanActivity == null) {
                return;
            }
            WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
            if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27274a;

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
                    this.f27274a = this;
                }

                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallFail(int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                        this.f27274a.mAct.finish();
                    }
                }

                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallSuccess(int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                        this.f27274a.queryCoupon(true, null, null);
                    }
                }
            })) {
                return;
            }
            super.handleFailure(i2, i3, str);
            if (i3 == 5003) {
                this.mLoadStatus = 1;
                showEmptyView(null);
                if (WalletLoginHelper.getInstance().isPassLogin()) {
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                    AccountManager.getInstance(this.mAct.getApplicationContext()).logout();
                    if (!TextUtils.isEmpty(str)) {
                        GlobalUtils.toast(this.mAct, str);
                    }
                    finish();
                }
            } else if (this.mCurrPage != 0) {
                this.mContainer.onPullUpRefreshComplete();
            } else if (i3 < 0) {
                this.mLoadStatus = 2;
                showEmptyView(null);
            } else {
                this.mLoadStatus = 3;
                showEmptyView(str);
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            DXMSdkSAUtils.onEventWithValues("CouponListRequestSuccess", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
            PayStatisticsUtil.onEventWithValue("CouponListRequestSuccess", (System.currentTimeMillis() - this.now) + "");
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            if (i2 != 515 || this.mAct == null || str == null || !(obj instanceof CouponListResponse)) {
                return;
            }
            hideEmptyView();
            this.mContainer.setLastUpdatedLabel(String.format(ResUtils.getString(this.mAct, "bd_wallet_refresh_time"), this.mDateFormat.format(Calendar.getInstance().getTime())));
            this.mContainer.onPullUpRefreshComplete();
            this.mContainer.onPullDownRefreshComplete();
            CouponListResponse couponListResponse = (CouponListResponse) obj;
            if (this.bdActionBar != null) {
                CouponListResponse.CodeCoupon codeCoupon = couponListResponse.code_equity;
                if (codeCoupon == null || TextUtils.isEmpty(codeCoupon.desc) || TextUtils.isEmpty(couponListResponse.code_equity.url)) {
                    this.bdActionBar.setRightNotifyZone1Visibility(8);
                } else {
                    this.bdActionBar.setRightNotifyText(couponListResponse.code_equity.desc);
                    this.bdActionBar.setRightNotifyZone1Visibility(0);
                    this.bdActionBar.setRightNotifyTextColor(-16777216);
                    this.bdActionBar.setRightNotifyTextSize(12);
                    this.bdActionBar.setRightNotifyImg(ResUtils.getDrawable(getActivity(), "wallet_personal_code_coupon_triangle"));
                    CommonUtils.setPressedAlpha(this.bdActionBar.getRightNotifyZone1());
                    this.bdActionBar.setRightNotifyZone1ClickListener(new View.OnClickListener(this, couponListResponse) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ CouponListResponse f27281a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ MyCouponListActivity f27282b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, couponListResponse};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27282b = this;
                            this.f27281a = couponListResponse;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                BaiduWalletDelegate.getInstance().openH5Module(this.f27282b.getActivity(), this.f27281a.code_equity.url);
                            }
                        }
                    });
                }
            }
            this.mLoadStatus = 0;
            this.getCouponUrl = couponListResponse.empty_url;
            CouponList[] couponListArr = couponListResponse.coupon_list;
            if (!(couponListArr != null && couponListArr.length > 0 && couponListResponse.total_count > 0)) {
                BannerCouponItemInfo[] bannerCouponItemInfoArr = couponListResponse.banner_ad_info;
                if (bannerCouponItemInfoArr != null && !this.isInvaild) {
                    this.mCouponBanner.setConfigData(bannerCouponItemInfoArr);
                    this.mCouponBanner.setMaiDianDataKey("CouponListClickBanner");
                    this.mCouponBanner.setVisibility(0);
                }
                if (this.mCurrPage == 0) {
                    showEmptyView(null);
                    PersonalPreferenceManager.setPersonalBannerFirst(this.mAct, false);
                    this.mLlBanner.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.mCurrPage == 0) {
                this.mCouponList.clear();
                this.recvCount = 0;
            }
            this.mCurrPage++;
            updateData(couponListResponse);
            LogUtil.d("queryRecords. handleMessage. list size = " + this.recvCount);
            this.mAdapter.notifyDataSetChanged();
            boolean z = this.recvCount < couponListResponse.total_count;
            this.mContainer.setHasMoreData(z);
            if (z || this.mHintView != null) {
                TextView textView = this.mHintView;
                if (!z) {
                    if (textView != null) {
                        textView.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (textView != null) {
                    this.mHintView = null;
                }
                linearLayout = this.useless;
                if (linearLayout == null) {
                    return;
                }
            } else if (this.useless == null) {
                TextView textView2 = (TextView) findViewById(ResUtils.id(this.mAct, "bd_wallet_loadmore_text"));
                this.mHintView = textView2;
                textView2.setVisibility(8);
                linearLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_useless"));
                this.useless = linearLayout;
                if (!this.isInvaild) {
                    linearLayout.setVisibility(0);
                    this.useless.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ MyCouponListActivity f27273a;

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
                            this.f27273a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                Intent intent = new Intent(this.f27273a.mAct, MyCouponListActivity.class);
                                intent.putExtra("IsInvaildCouponList", true);
                                intent.putExtra("LONGITUDE", this.f27273a.longitude);
                                intent.putExtra("LATITUDE", this.f27273a.latitude);
                                this.f27273a.mAct.startActivityForResult(intent, 2);
                                BaiduWalletUtils.startActivityAnim(this.f27273a.mAct);
                            }
                        }
                    });
                    return;
                }
            } else {
                findViewById(ResUtils.id(this.mAct, "bd_wallet_loadmore_text")).setVisibility(8);
                if (!this.isInvaild) {
                    this.useless.setVisibility(0);
                    return;
                }
                linearLayout = this.useless;
            }
            linearLayout.setVisibility(8);
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PersonalPreferenceManager.setPersonalBannerFirst(this.mAct, false);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "title_bottom_seperator"));
            this.actionBarLine = imageView;
            imageView.setVisibility(8);
            this.mFirstGetCoupon = true;
            PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) findViewById(ResUtils.id(this.mAct, "bd_wallet_pull_up_view"));
            this.mContainer = pullToRefreshListView;
            pullToRefreshListView.setPullLoadEnabled(false);
            this.mContainer.setPullRefreshEnabled(true);
            this.mContainer.setScrollLoadEnabled(true);
            this.mListView = this.mContainer.getRefreshableView();
            findViewById(ResUtils.id(this.mAct, "top_divider")).setVisibility(8);
            this.mListView.setBackgroundColor(ResUtils.getColor(this.mAct, "bd_extend_wallet_text_gray4"));
            this.mListView.setAlwaysDrawnWithCacheEnabled(true);
            this.mListView.setCacheColorHint(ResUtils.getColor(this.mAct, "bd_extend_wallet_text_gray4"));
            this.mListView.setDivider(new ColorDrawable(ResUtils.getColor(this.mAct, "bd_extend_wallet_text_gray4")));
            this.mListView.setFadingEdgeLength(0);
            this.mListView.setFooterDividersEnabled(false);
            this.mListView.setHeaderDividersEnabled(false);
            this.mListView.setSelector(new ColorDrawable(ResUtils.getColor(this.mAct, "bd_extend_wallet_text_gray4")));
            if (this.isInvaild) {
                initHomeActionBar("wallet_personal_coupon_invalid");
            } else {
                initHomeActionBar("bd_wallet_tab_coupon");
                this.bdActionBar = getBdActionBar();
            }
            View findViewById = findViewById(ResUtils.id(this.mAct, "bd_wallet_empty_coupon"));
            this.mEmptyView = findViewById;
            this.noCouponImage = (ImageView) findViewById.findViewById(ResUtils.id(this.mAct, "wallet_no_coupon"));
            this.noCouponText = (TextView) this.mEmptyView.findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_nocoupon"));
            this.noCouponLint = (TextView) this.mEmptyView.findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_gowalk"));
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "bd_wallet_empty_useless"));
            this.emptyUseless = linearLayout;
            linearLayout.setGravity(80);
            this.emptyUseless.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27272a;

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
                    this.f27272a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        Intent intent = new Intent(this.f27272a.mAct, MyCouponListActivity.class);
                        intent.putExtra("IsInvaildCouponList", true);
                        intent.putExtra("LONGITUDE", this.f27272a.longitude);
                        intent.putExtra("Latitude", this.f27272a.latitude);
                        this.f27272a.mAct.startActivityForResult(intent, 2);
                        BaiduWalletUtils.startActivityAnim(this.f27272a.mAct);
                    }
                }
            });
            this.mReloadView = (WalletBaseEmptyView) findViewById(ResUtils.id(this.mAct, "wallet_coupon_reload_view"));
            this.mLlBanner = findViewById(ResUtils.id(this.mAct, "wallet_pay_pp_top_banner_ll"));
            ImageButton imageButton = (ImageButton) findViewById(ResUtils.id(this.mAct, "wallet_pay_pp_top_banner_ib"));
            this.mIbX = imageButton;
            imageButton.setOnClickListener(this);
            if (!PersonalPreferenceManager.isPersonalBannerFirst(this.mAct) || WalletLoginHelper.getInstance().getLoginData() == null) {
                this.mLlBanner.setVisibility(8);
            } else {
                this.mLlBanner.setVisibility(0);
            }
            this.mCouponBanner = (BannerLayoutForAd) findViewById(ResUtils.id(this.mAct, "coupon_banner"));
            View inflate = LayoutInflater.from(this.mAct).inflate(ResUtils.layout(this.mAct, "wallet_base_personal_coupon_list_banner"), (ViewGroup) null);
            this.emptyBanner = inflate.findViewById(ResUtils.id(this.mAct, "empty_banner"));
            this.mCouponBanner1 = (BannerLayoutForAd) inflate.findViewById(ResUtils.id(this.mAct, "coupon_banner_hascoupon"));
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            if (this.isInvaild) {
                this.mAdapter = new b();
                this.mCouponBanner.setVisibility(8);
                this.isHasCouponAndBanner = false;
            } else {
                this.mCouponBanner1.setLayoutParams(layoutParams);
                this.mListView.addHeaderView(this.mCouponBanner1);
                this.mAdapter = new a(this.mListView);
            }
            this.emptyBanner.setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtils.dip2px(this.mAct, 7.5f)));
            this.mListView.addHeaderView(this.emptyBanner);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            PassUtil.onCreate();
            this.mContainer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27275a;

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
                    this.f27275a = this;
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, pullToRefreshBase) == null) {
                        this.f27275a.mCurrPage = 0;
                        LogUtil.d("onActivityCreated. onRefresh. curr page = " + this.f27275a.mCurrPage);
                        this.f27275a.queryCoupon(false, null, null);
                    }
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                        LogUtil.d("onActivityCreated. onRefresh. curr page = " + this.f27275a.mCurrPage);
                        this.f27275a.queryCoupon(false, null, null);
                    }
                }
            });
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27276a;

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
                    this.f27276a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f27276a.getActivity() == null || CheckUtils.isFastDoubleClick()) {
                        return;
                    }
                    if (this.f27276a.isHasCouponAndBanner) {
                        if (i2 < 2) {
                            return;
                        }
                        i3 = i2 - 2;
                    } else if (i2 == 0) {
                        return;
                    } else {
                        i3 = i2 - 1;
                    }
                    CouponList.Coupon coupon = (CouponList.Coupon) this.f27276a.mAdapter.getItem(i3);
                    if (coupon == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(this.f27276a.mAct, MyCouponDetailActivity.class);
                    if (this.f27276a.isInvaild) {
                        intent.putExtra("isInvaild", true);
                    }
                    intent.putExtra("cardType", coupon.card_type);
                    intent.putExtra("couponNum", coupon.coupon_num);
                    intent.putExtra("templateNum", coupon.template_num);
                    intent.putExtra("longitude", this.f27276a.longitude);
                    intent.putExtra("latitude", this.f27276a.latitude);
                    if (this.f27276a.coupon_receive_timestamp > this.f27276a.last_coupon_receive_timestamp) {
                        MyCouponListActivity myCouponListActivity = this.f27276a;
                        myCouponListActivity.last_coupon_receive_timestamp = myCouponListActivity.coupon_receive_timestamp;
                        MyCouponListActivity myCouponListActivity2 = this.f27276a;
                        SharedPreferencesUtils.setParam(myCouponListActivity2.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(myCouponListActivity2.last_coupon_receive_timestamp));
                    }
                    this.f27276a.startActivityForResult(intent, 1);
                }
            });
            if (this.isLoading) {
                return;
            }
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(this.mAct, new ILoginBackListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MyCouponListActivity f27277a;

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
                    this.f27277a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f27277a.mLoadStatus = 1;
                        this.f27277a.showEmptyView(null);
                        if (i2 == 603 && WalletLoginHelper.getInstance().isPassLogin()) {
                            WalletLoginHelper.getInstance().handlerWalletError(5003);
                            AccountManager.getInstance(this.f27277a.mAct.getApplicationContext()).logout();
                            if (!TextUtils.isEmpty(str)) {
                                GlobalUtils.toast(this.f27277a.mAct, str);
                            }
                            this.f27277a.finish();
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f27277a.queryCoupon(true, null, null);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1 && i3 == 0) {
                this.mCurrPage = 0;
                this.recvCount = 0;
                queryCoupon(true, null, null);
            }
            if (i2 == 2) {
                this.mCurrPage = 0;
                this.recvCount = 0;
                queryCoupon(true, null, null);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.mIbX) {
                PersonalPreferenceManager.setPersonalBannerFirst(this.mAct, false);
                this.mLlBanner.setVisibility(8);
            } else if (view == this.mroeCouponLayout) {
                String obj = view.getTag(ResUtils.id(this.mAct, "more_tv")) != null ? view.getTag(ResUtils.id(this.mAct, "more_tv")).toString() : "";
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                DXMSdkSAUtils.onEvent("bCouponClickMore");
                PayStatisticsUtil.onEvent("bCouponClickMore");
                this.needRefreshCouponlist = true;
                BaiduWalletDelegate.getInstance().openH5Module(this.mAct, obj, true);
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_list"));
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("extra_data");
                if (TextUtils.isEmpty(stringExtra)) {
                    boolean booleanExtra = intent.getBooleanExtra("IsInvaildCouponList", false);
                    this.isInvaild = booleanExtra;
                    if (booleanExtra) {
                        this.longitude = intent.getStringExtra("LONGITUDE");
                        this.latitude = intent.getStringExtra("LATITUDE");
                    }
                } else {
                    setLocation(stringExtra);
                }
            }
            if (!this.isInvaild) {
                int intValue = ((Integer) SharedPreferencesUtils.getParam(this.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", 0)).intValue();
                this.last_coupon_receive_timestamp = intValue;
                this.coupon_receive_timestamp = intValue;
            }
            this.mCouponList = new ArrayList();
            initView();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.coupon_receive_timestamp;
            if (i2 > this.last_coupon_receive_timestamp && !this.isInvaild) {
                this.last_coupon_receive_timestamp = i2;
                SharedPreferencesUtils.setParam(this.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(i2));
            }
            BeanManager beanManager = BeanManager.getInstance();
            beanManager.removeAllBeans(BEAN_TAG + hashCode());
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.needRefreshCouponlist) {
                this.mCurrPage = 0;
                queryCoupon(true, null, null);
                this.needRefreshCouponlist = false;
            }
            BaseAdapter baseAdapter = this.mAdapter;
            if (baseAdapter != null) {
                baseAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setLocation(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("&");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].contains("longitude")) {
                String[] split2 = split[i2].split("=");
                if (split2.length > 0) {
                    this.longitude = split2[1];
                }
            } else if (split[i2].contains("latitude")) {
                String[] split3 = split[i2].split("=");
                if (split3.length > 0) {
                    this.latitude = split3[1];
                }
            } else if (split[i2].contains("is_from_new_prompt")) {
                String[] split4 = split[i2].split("=");
                if (split4.length > 0) {
                    this.isFormNewPromot = split4[1];
                }
            }
        }
    }
}
