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
import com.baidu.apollon.base.widget.CirclePortraitView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
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
    public static final String BEAN_TAG = "MyCouponListActivity";
    public static final String EXTRA_DATA = "extra_data";
    public static final int REQUEST_CODE_COUPON_DETAIL = 1;
    public static final int REQUEST_CODE_INVALID_COUPON_DETAIL = 2;
    public ImageView actionBarLine;
    public BdActionBar bdActionBar;
    public int coupon_receive_timestamp;
    public View emptyBanner;
    public BaseAdapter mAdapter;
    public PullToRefreshListView mContainer;
    public BannerLayoutForAd mCouponBanner;
    public BannerLayoutForAd mCouponBanner1;
    public List<CouponList.Coupon> mCouponList;
    public View mEmptyView;
    public TextView mExpire_message;
    public ImageButton mIbX;
    public ListView mListView;
    public View mLlBanner;
    public WalletBaseEmptyView mReloadView;
    public RelativeLayout mroeCouponLayout;
    public ImageView noCouponImage;
    public TextView noCouponLint;
    public TextView noCouponText;
    public long now;
    public PromptDialog thirdLoginTipDialog;
    public final String TIMESTAMP = "coupon_recive_timestamp";
    public final String KEY = "last_coupon_receive_timestamp_key";
    @SuppressLint({"SimpleDateFormat"})
    public final SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
    public String mCurrrentActivityId = "";
    public String mCurrrentActivityType = "";
    public int last_coupon_receive_timestamp = 0;
    public String getCouponUrl = null;
    public int mCurrPage = 0;
    public int mLoadStatus = 0;
    public boolean isLoading = false;
    public String longitude = "";
    public String latitude = "";
    public int recvCount = 0;
    public TextView mHintView = null;
    public LinearLayout useless = null;
    public LinearLayout emptyUseless = null;
    public boolean mFirstGetCoupon = true;
    public boolean needRefreshCouponlist = false;
    public String isFormNewPromot = "";
    public boolean isHasCouponAndBanner = true;
    public boolean isInvaild = false;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f26615b;

        public a(ListView listView) {
            this.f26615b = LayoutInflater.from(MyCouponListActivity.this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public CouponList.Coupon getItem(int i) {
            if (i < MyCouponListActivity.this.mCouponList.size()) {
                return (CouponList.Coupon) MyCouponListActivity.this.mCouponList.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MyCouponListActivity.this.mCouponList.size() + 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return i < MyCouponListActivity.this.mCouponList.size() ? 0 : 1;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0298  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x02a3  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x02c0  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x037f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x045b  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0500  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0519  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i, View view, ViewGroup viewGroup) {
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
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return view;
                }
                if (view == 0 || view.getTag() == null) {
                    int emptyHeight = MyCouponListActivity.this.getEmptyHeight();
                    AbsListView.LayoutParams layoutParams = emptyHeight > 0 ? new AbsListView.LayoutParams(-1, emptyHeight) : new AbsListView.LayoutParams(-1, -1);
                    View view2 = new View(MyCouponListActivity.this.mAct);
                    view2.setLayoutParams(layoutParams);
                    return view2;
                }
                return view;
            }
            final CouponList.Coupon item = getItem(i);
            if (item.isLabel) {
                if (view == null || view.getTag() != null) {
                    view = this.f26615b.inflate(ResUtils.layout(MyCouponListActivity.this.mAct, "wallet_personal_coupon_label"), (ViewGroup) null);
                }
                ((TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "bd_wallet_coupon_label"))).setText(item.labelValue);
                return view;
            }
            DXMSdkSAUtils.onEventWithValues("#couponShow", Arrays.asList(item.logo_title, item.template_title));
            PayStatisticsUtil.onEventWithValues("#couponShow", Arrays.asList(item.logo_title, item.template_title));
            if (view == null || view.getTag() == null) {
                cVar = new c();
                view = this.f26615b.inflate(ResUtils.layout(MyCouponListActivity.this.mAct, "wallet_personal_coupon_item1"), (ViewGroup) null);
                cVar.f26622b = (CirclePortraitView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "sp_logo"));
                cVar.f26623c = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "logo_title"));
                cVar.f26624d = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "couppon_maket_label"));
                cVar.f26625e = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_tempalte_title"));
                cVar.f26626f = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_limit"));
                cVar.f26627g = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_content"));
                cVar.f26628h = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "couppon_time_limit"));
                cVar.i = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_valid_time"));
                cVar.j = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_now_text"));
                cVar.k = (ImageView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_now_img"));
                cVar.l = (ImageView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_new"));
                view.setTag(cVar);
                cVar.m = view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_now"));
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f26622b.setImageDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_qianbao_logo_for_list"));
            if (!TextUtils.isEmpty(item.logo_url)) {
                cVar.f26622b.setImageUrl(item.logo_url);
            }
            if (TextUtils.isEmpty(item.logo_title)) {
                textView = cVar.f26623c;
                string = ResUtils.getString(MyCouponListActivity.this.mAct, "wallet_personal_coupon_logo_title");
            } else {
                textView = cVar.f26623c;
                string = item.logo_title;
            }
            textView.setText(string);
            if (TextUtils.isEmpty(item.marketing_label)) {
                cVar.f26624d.setVisibility(8);
            } else {
                if (item.marketing_label.length() > 7) {
                    textView7 = cVar.f26624d;
                    str5 = item.marketing_label.substring(0, 7);
                } else {
                    textView7 = cVar.f26624d;
                    str5 = item.marketing_label;
                }
                textView7.setText(str5);
                cVar.f26624d.setVisibility(0);
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 40.0f));
            AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 30.0f));
            StyleSpan styleSpan = new StyleSpan(1);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.discount_content_v2);
            if (TextUtils.isEmpty(item.discount_content_v2_unit)) {
                length = spannableStringBuilder.length();
            } else if (item.discount_content_v2.length() > 7) {
                spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
                cVar.f26627g.setText(spannableStringBuilder);
                cVar.f26625e.setText(item.template_title);
                cVar.f26626f.setText(item.use_limit_v2);
                if (item.source_type == 1) {
                    textView2 = cVar.f26627g;
                    beanActivity = MyCouponListActivity.this.mAct;
                    str = "wallet_coupon_red";
                } else {
                    textView2 = cVar.f26627g;
                    beanActivity = MyCouponListActivity.this.mAct;
                    str = "wallet_coupon_blue";
                }
                textView2.setTextColor(ResUtils.getColor(beanActivity, str));
                if (TextUtils.isEmpty(item.date_message_expire)) {
                    cVar.f26628h.setSingleLine(true);
                    cVar.f26628h.setEllipsize(TextUtils.TruncateAt.END);
                    if (item.date_message_expire.length() > 7) {
                        textView6 = cVar.f26628h;
                        str4 = item.date_message_expire.substring(0, 7);
                    } else {
                        textView6 = cVar.f26628h;
                        str4 = item.date_message_expire;
                    }
                    textView6.setText(str4);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 89.5f), DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 16.5f));
                    layoutParams2.setMargins(0, DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 6.0f), 0, 0);
                    cVar.f26628h.setLayoutParams(layoutParams2);
                    cVar.f26628h.setGravity(17);
                    cVar.f26628h.setPadding(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 13.0f), DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 1.0f), DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 6.0f), DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 0.5f));
                    cVar.f26628h.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_date_message_expire"));
                    cVar.f26628h.setBackgroundResource(ResUtils.drawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_daojishi"));
                    cVar.f26628h.setTextSize(1, 11.0f);
                    cVar.i.setVisibility(8);
                } else {
                    if (TextUtils.isEmpty(item.date_not_started)) {
                        cVar.f26628h.setText(item.date_message_v2);
                        cVar.f26628h.setTextSize(1, 11.0f);
                        cVar.f26628h.setBackgroundDrawable(null);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.setMargins(0, DisplayUtils.dip2px(MyCouponListActivity.this, 6.0f), 0, 0);
                        cVar.f26628h.setPadding(0, 0, 0, 0);
                        cVar.f26628h.setLayoutParams(layoutParams3);
                        cVar.i.setVisibility(8);
                        cVar.f26628h.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_txt_999999"));
                        textView3 = cVar.f26628h;
                    } else {
                        cVar.f26628h.setPadding(0, 0, 0, 0);
                        if (item.date_not_started.length() > 4) {
                            textView4 = cVar.f26628h;
                            str2 = item.date_not_started.substring(0, 4);
                        } else {
                            textView4 = cVar.f26628h;
                            str2 = item.date_not_started;
                        }
                        textView4.setText(str2);
                        cVar.f26628h.setTextSize(1, 10.0f);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.setMargins(0, DisplayUtils.dip2px(MyCouponListActivity.this, 4.0f), 0, 0);
                        cVar.f26628h.setBackgroundDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_xianshiduan_bg"));
                        cVar.f26628h.setLayoutParams(layoutParams4);
                        cVar.f26628h.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_txt_999999"));
                        cVar.f26628h.setVisibility(0);
                        cVar.i.setText(item.date_message_v2);
                        textView3 = cVar.i;
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
                    cVar.j.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_txt_disable"));
                    cVar.k.setImageDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_triangle_grey"));
                    cVar.m.setClickable(false);
                } else {
                    cVar.j.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_btn_txt_blue"));
                    cVar.k.setImageDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_triangle"));
                    cVar.m.setBackgroundDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_list_btn_background"));
                    cVar.m.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.a.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BaiduWalletDelegate baiduWalletDelegate;
                            BeanActivity beanActivity2;
                            String str6;
                            if (MyCouponListActivity.this.coupon_receive_timestamp > MyCouponListActivity.this.last_coupon_receive_timestamp) {
                                MyCouponListActivity myCouponListActivity = MyCouponListActivity.this;
                                myCouponListActivity.last_coupon_receive_timestamp = myCouponListActivity.coupon_receive_timestamp;
                                MyCouponListActivity myCouponListActivity2 = MyCouponListActivity.this;
                                SharedPreferencesUtils.setParam(myCouponListActivity2.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(myCouponListActivity2.last_coupon_receive_timestamp));
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("template_num", item.template_num);
                                jSONObject.put("coupon_num", item.coupon_num);
                                jSONObject.put("card_type", item.card_type);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            DXMSdkSAUtils.onEventWithValues("CouponListToUseBtnClick", Arrays.asList(jSONObject.toString()));
                            PayStatisticsUtil.onEventWithValue("CouponListToUseBtnClick", jSONObject.toString());
                            CouponList.Coupon coupon = item;
                            CouponList.Coupon.AppSceneService appSceneService = coupon.app_scene_service;
                            if (appSceneService != null) {
                                if (appSceneService.f26579android > 0) {
                                    MyCouponListActivity.this.needRefreshCouponlist = true;
                                    BaiduWalletServiceController.getInstance().gotoWalletService(MyCouponListActivity.this.mAct, item.app_scene_service.f26579android, "");
                                    return;
                                } else if (TextUtils.isEmpty(appSceneService.url)) {
                                    return;
                                } else {
                                    MyCouponListActivity.this.needRefreshCouponlist = true;
                                    baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                    beanActivity2 = MyCouponListActivity.this.mAct;
                                    str6 = item.app_scene_service.url;
                                }
                            } else if (TextUtils.isEmpty(coupon.scene_service)) {
                                return;
                            } else {
                                MyCouponListActivity.this.needRefreshCouponlist = true;
                                baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                beanActivity2 = MyCouponListActivity.this.mAct;
                                str6 = item.scene_service;
                            }
                            baiduWalletDelegate.openH5Module(beanActivity2, str6, true);
                        }
                    });
                }
                if (item.coupon_receive_timestamp > MyCouponListActivity.this.last_coupon_receive_timestamp) {
                    cVar.l.setVisibility(8);
                    return view;
                }
                cVar.l.setBackgroundResource(ResUtils.drawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_new"));
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
            cVar.f26627g.setText(spannableStringBuilder);
            cVar.f26625e.setText(item.template_title);
            cVar.f26626f.setText(item.use_limit_v2);
            if (item.source_type == 1) {
            }
            textView2.setTextColor(ResUtils.getColor(beanActivity, str));
            if (TextUtils.isEmpty(item.date_message_expire)) {
            }
            if (!TextUtils.isEmpty(item.scene_service_label)) {
            }
            if (TextUtils.isEmpty(item.date_not_started)) {
            }
            cVar.j.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_txt_disable"));
            cVar.k.setImageDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_triangle_grey"));
            cVar.m.setClickable(false);
            if (item.coupon_receive_timestamp > MyCouponListActivity.this.last_coupon_receive_timestamp) {
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public c f26618a;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f26620c;

        public b() {
            this.f26620c = LayoutInflater.from(MyCouponListActivity.this.mAct);
        }

        private void b(int i) {
            ImageView imageView;
            BeanActivity beanActivity;
            String str;
            if (i == 0) {
                imageView = this.f26618a.l;
                beanActivity = MyCouponListActivity.this.mAct;
                str = "wallet_personal_coupon_expired";
            } else if (i != 1) {
                if (i == 2) {
                    imageView = this.f26618a.l;
                    beanActivity = MyCouponListActivity.this.mAct;
                    str = "wallet_personal_coupon_disabled";
                }
                this.f26618a.l.setVisibility(0);
            } else {
                imageView = this.f26618a.l;
                beanActivity = MyCouponListActivity.this.mAct;
                str = "wallet_personal_coupon_used";
            }
            imageView.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
            this.f26618a.l.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public CouponList.Coupon getItem(int i) {
            return (CouponList.Coupon) MyCouponListActivity.this.mCouponList.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MyCouponListActivity.this.mCouponList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x025f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x026f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0273  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0277  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            String string;
            int length;
            CouponList.Coupon item = getItem(i);
            if (view == null || view.getTag() == null) {
                this.f26618a = new c();
                view = this.f26620c.inflate(ResUtils.layout(MyCouponListActivity.this.mAct, "wallet_personal_coupon_item1"), (ViewGroup) null);
                this.f26618a.f26622b = (CirclePortraitView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "sp_logo"));
                this.f26618a.f26623c = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "logo_title"));
                this.f26618a.f26624d = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "couppon_maket_label"));
                this.f26618a.f26625e = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_tempalte_title"));
                this.f26618a.f26626f = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_limit"));
                this.f26618a.f26627g = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_content"));
                this.f26618a.f26627g.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
                this.f26618a.i = (TextView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "couppon_time_limit"));
                this.f26618a.i.setTextColor(ResUtils.getColor(MyCouponListActivity.this.mAct, "wallet_coupon_txt_999999"));
                this.f26618a.l = (ImageView) view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_used"));
                this.f26618a.m = view.findViewById(ResUtils.id(MyCouponListActivity.this.mAct, "coupn_use_now"));
                this.f26618a.m.setVisibility(8);
                view.setTag(this.f26618a);
            } else {
                this.f26618a = (c) view.getTag();
            }
            this.f26618a.f26622b.setImageDrawable(ResUtils.getDrawable(MyCouponListActivity.this.mAct, "wallet_personal_coupon_qianbao_logo_for_list"));
            if (TextUtils.isEmpty(item.logo_title)) {
                textView = this.f26618a.f26623c;
                string = ResUtils.getString(MyCouponListActivity.this.mAct, "wallet_personal_coupon_logo_title");
            } else {
                textView = this.f26618a.f26623c;
                string = item.logo_title;
            }
            textView.setText(string);
            if (!TextUtils.isEmpty(item.logo_url)) {
                this.f26618a.f26622b.setImageUrl(item.logo_url);
            }
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.f26618a.f26622b.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            this.f26618a.f26624d.setVisibility(8);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 40.0f));
            AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(DisplayUtils.dip2px(MyCouponListActivity.this.mAct, 30.0f));
            StyleSpan styleSpan = new StyleSpan(1);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.discount_content_v2);
            if (TextUtils.isEmpty(item.discount_content_v2_unit)) {
                length = spannableStringBuilder.length();
            } else if (item.discount_content_v2.length() > 7) {
                spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
                this.f26618a.f26627g.setText(spannableStringBuilder);
                this.f26618a.f26625e.setText(item.template_title);
                this.f26618a.f26626f.setText(item.use_limit_v2);
                if (TextUtils.isEmpty(item.date_message)) {
                    this.f26618a.i.setVisibility(0);
                    this.f26618a.i.setText(item.date_message);
                } else {
                    this.f26618a.i.setVisibility(8);
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
            this.f26618a.f26627g.setText(spannableStringBuilder);
            this.f26618a.f26625e.setText(item.template_title);
            this.f26618a.f26626f.setText(item.use_limit_v2);
            if (TextUtils.isEmpty(item.date_message)) {
            }
            switch (item.status) {
            }
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public CirclePortraitView f26622b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26623c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26624d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f26625e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f26626f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26627g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26628h;
        public TextView i;
        public TextView j;
        public ImageView k;
        public ImageView l;
        public View m;

        public c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEmptyHeight() {
        int i;
        int i2;
        ListAdapter adapter;
        int i3;
        int displayHeight = DisplayUtils.getDisplayHeight(this.mAct);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (this.mCouponBanner1.isShown()) {
            this.mCouponBanner1.measure(makeMeasureSpec, makeMeasureSpec2);
            i = this.mCouponBanner1.getMeasuredHeight();
        } else {
            i = 0;
        }
        if (this.mCouponList.size() > 0) {
            if (this.isHasCouponAndBanner) {
                adapter = this.mListView.getAdapter();
                i3 = 2;
            } else {
                adapter = this.mListView.getAdapter();
                i3 = 1;
            }
            View view = adapter.getView(i3, null, this.mListView);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = view.getMeasuredHeight();
        } else {
            i2 = 0;
        }
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int size = ((((displayHeight - (i2 * this.mCouponList.size())) - DisplayUtils.dip2px(this.mAct, 50.0f)) - DisplayUtils.dip2px(this.mAct, 50.0f)) - i) - (identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0);
        int dip2px = DisplayUtils.dip2px(this.mAct, 40.0f);
        if (size > dip2px) {
            return size - dip2px;
        }
        return 0;
    }

    private void handleEmptyView() {
        if (!TextUtils.isEmpty(this.getCouponUrl)) {
            this.mEmptyView.findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_get")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TextUtils.isEmpty(MyCouponListActivity.this.getCouponUrl)) {
                        return;
                    }
                    BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                    MyCouponListActivity myCouponListActivity = MyCouponListActivity.this;
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

    private void hideEmptyView() {
        this.mEmptyView.setVisibility(8);
        this.mReloadView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public void queryCoupon(boolean z, String str, String str2) {
        if (getActivity() == null) {
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
        if (this.mEmptyView == null || getActivity() == null) {
            return;
        }
        int i = this.mLoadStatus;
        if (i == 3) {
            this.mReloadView.setVisibility(0);
            WalletBaseEmptyView walletBaseEmptyView = this.mReloadView;
            int drawable = ResUtils.drawable(this.mAct, "wallet_base_no_net");
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mAct, "wallet_base_no_network");
            }
            walletBaseEmptyView.showTip1_NextBtn(drawable, str, ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.6
                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    MyCouponListActivity.this.queryCoupon(true, null, null);
                }
            });
        } else if (i == 2) {
            this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(this.mAct, "wallet_base_no_net"), ResUtils.getString(this.mAct, "wallet_base_no_network"), ResUtils.getString(this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.7
                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    MyCouponListActivity.this.queryCoupon(true, null, null);
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
        if (couponListResponse == null) {
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
        int i = 0;
        while (true) {
            CouponList[] couponListArr2 = couponListResponse.coupon_list;
            if (i >= couponListArr2.length) {
                return;
            }
            String str = couponListArr2[i].label;
            if (couponListArr2[i].coupons != null && couponListArr2[i].coupons.length > 0) {
                int i2 = 0;
                while (true) {
                    CouponList[] couponListArr3 = couponListResponse.coupon_list;
                    if (i2 < couponListArr3[i].coupons.length) {
                        if (couponListArr3[i].coupons[i2].coupon_receive_timestamp > this.coupon_receive_timestamp && !this.isInvaild) {
                            this.coupon_receive_timestamp = couponListArr3[i].coupons[i2].coupon_receive_timestamp;
                        }
                        CouponList[] couponListArr4 = couponListResponse.coupon_list;
                        couponListArr4[i].coupons[i2].labelValue = str;
                        this.mCouponList.add(couponListArr4[i].coupons[i2]);
                        this.recvCount++;
                        i2++;
                    }
                }
            }
            i++;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        DXMSdkSAUtils.onEventWithValues("CouponListRequestFail", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
        PayStatisticsUtil.onEventWithValue("CouponListRequestFail", (System.currentTimeMillis() - this.now) + "");
        BeanActivity beanActivity = this.mAct;
        if (beanActivity == null) {
            return;
        }
        WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
        if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i2, str, new WalletApiExtListener.ThirdPartyLoginListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.2
            @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
            public void onCallFail(int i3, String str2) {
                MyCouponListActivity.this.mAct.finish();
            }

            @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
            public void onCallSuccess(int i3, String str2) {
                MyCouponListActivity.this.queryCoupon(true, null, null);
            }
        })) {
            return;
        }
        super.handleFailure(i, i2, str);
        if (i2 == 5003) {
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
        } else if (i2 < 0) {
            this.mLoadStatus = 2;
            showEmptyView(null);
        } else {
            this.mLoadStatus = 3;
            showEmptyView(str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        LinearLayout linearLayout;
        DXMSdkSAUtils.onEventWithValues("CouponListRequestSuccess", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
        PayStatisticsUtil.onEventWithValue("CouponListRequestSuccess", (System.currentTimeMillis() - this.now) + "");
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (i != 515 || this.mAct == null || str == null || !(obj instanceof CouponListResponse)) {
            return;
        }
        hideEmptyView();
        this.mContainer.setLastUpdatedLabel(String.format(ResUtils.getString(this.mAct, "bd_wallet_refresh_time"), this.mDateFormat.format(Calendar.getInstance().getTime())));
        this.mContainer.onPullUpRefreshComplete();
        this.mContainer.onPullDownRefreshComplete();
        final CouponListResponse couponListResponse = (CouponListResponse) obj;
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
                this.bdActionBar.setRightNotifyZone1ClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BaiduWalletDelegate.getInstance().openH5Module(MyCouponListActivity.this.getActivity(), couponListResponse.code_equity.url);
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
                this.useless.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(MyCouponListActivity.this.mAct, MyCouponListActivity.class);
                        intent.putExtra("IsInvaildCouponList", true);
                        intent.putExtra("LONGITUDE", MyCouponListActivity.this.longitude);
                        intent.putExtra("LATITUDE", MyCouponListActivity.this.latitude);
                        MyCouponListActivity.this.mAct.startActivityForResult(intent, 2);
                        BaiduWalletUtils.startActivityAnim(MyCouponListActivity.this.mAct);
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

    public void initView() {
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
        this.emptyUseless.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MyCouponListActivity.this.mAct, MyCouponListActivity.class);
                intent.putExtra("IsInvaildCouponList", true);
                intent.putExtra("LONGITUDE", MyCouponListActivity.this.longitude);
                intent.putExtra("Latitude", MyCouponListActivity.this.latitude);
                MyCouponListActivity.this.mAct.startActivityForResult(intent, 2);
                BaiduWalletUtils.startActivityAnim(MyCouponListActivity.this.mAct);
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
        this.mContainer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.3
            @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                MyCouponListActivity.this.mCurrPage = 0;
                LogUtil.d("onActivityCreated. onRefresh. curr page = " + MyCouponListActivity.this.mCurrPage);
                MyCouponListActivity.this.queryCoupon(false, null, null);
            }

            @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                LogUtil.d("onActivityCreated. onRefresh. curr page = " + MyCouponListActivity.this.mCurrPage);
                MyCouponListActivity.this.queryCoupon(false, null, null);
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2;
                if (MyCouponListActivity.this.getActivity() == null || CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (MyCouponListActivity.this.isHasCouponAndBanner) {
                    if (i < 2) {
                        return;
                    }
                    i2 = i - 2;
                } else if (i == 0) {
                    return;
                } else {
                    i2 = i - 1;
                }
                CouponList.Coupon coupon = (CouponList.Coupon) MyCouponListActivity.this.mAdapter.getItem(i2);
                if (coupon == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(MyCouponListActivity.this.mAct, MyCouponDetailActivity.class);
                if (MyCouponListActivity.this.isInvaild) {
                    intent.putExtra("isInvaild", true);
                }
                intent.putExtra("cardType", coupon.card_type);
                intent.putExtra("couponNum", coupon.coupon_num);
                intent.putExtra("templateNum", coupon.template_num);
                intent.putExtra("longitude", MyCouponListActivity.this.longitude);
                intent.putExtra("latitude", MyCouponListActivity.this.latitude);
                if (MyCouponListActivity.this.coupon_receive_timestamp > MyCouponListActivity.this.last_coupon_receive_timestamp) {
                    MyCouponListActivity myCouponListActivity = MyCouponListActivity.this;
                    myCouponListActivity.last_coupon_receive_timestamp = myCouponListActivity.coupon_receive_timestamp;
                    MyCouponListActivity myCouponListActivity2 = MyCouponListActivity.this;
                    SharedPreferencesUtils.setParam(myCouponListActivity2.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(myCouponListActivity2.last_coupon_receive_timestamp));
                }
                MyCouponListActivity.this.startActivityForResult(intent, 1);
            }
        });
        if (this.isLoading) {
            return;
        }
        WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(this.mAct, new ILoginBackListener() { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.5
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                MyCouponListActivity.this.mLoadStatus = 1;
                MyCouponListActivity.this.showEmptyView(null);
                if (i == 603 && WalletLoginHelper.getInstance().isPassLogin()) {
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                    AccountManager.getInstance(MyCouponListActivity.this.mAct.getApplicationContext()).logout();
                    if (!TextUtils.isEmpty(str)) {
                        GlobalUtils.toast(MyCouponListActivity.this.mAct, str);
                    }
                    MyCouponListActivity.this.finish();
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                MyCouponListActivity.this.queryCoupon(true, null, null);
            }
        }));
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 0) {
            this.mCurrPage = 0;
            this.recvCount = 0;
            queryCoupon(true, null, null);
        }
        if (i == 2) {
            this.mCurrPage = 0;
            this.recvCount = 0;
            queryCoupon(true, null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        int i = this.coupon_receive_timestamp;
        if (i > this.last_coupon_receive_timestamp && !this.isInvaild) {
            this.last_coupon_receive_timestamp = i;
            SharedPreferencesUtils.setParam(this.mAct, "coupon_recive_timestamp", "last_coupon_receive_timestamp_key", Integer.valueOf(i));
        }
        BeanManager beanManager = BeanManager.getInstance();
        beanManager.removeAllBeans(BEAN_TAG + hashCode());
        super.onDestroy();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
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

    public void setLocation(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("&");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("longitude")) {
                String[] split2 = split[i].split("=");
                if (split2.length > 0) {
                    this.longitude = split2[1];
                }
            } else if (split[i].contains("latitude")) {
                String[] split3 = split[i].split("=");
                if (split3.length > 0) {
                    this.latitude = split3[1];
                }
            } else if (split[i].contains("is_from_new_prompt")) {
                String[] split4 = split[i].split("=");
                if (split4.length > 0) {
                    this.isFormNewPromot = split4[1];
                }
            }
        }
    }
}
