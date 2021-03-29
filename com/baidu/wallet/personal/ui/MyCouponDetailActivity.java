package com.baidu.wallet.personal.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.CirclePortraitView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.beans.b;
import com.baidu.wallet.personal.beans.c;
import com.baidu.wallet.personal.datamodel.CouponDetailResponse;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MyCouponDetailActivity extends BeanActivity {
    public static final String BEAN_TAG = "MyCouponDetailActivity";
    public ImageView actionBarLine;
    public int cardType;
    public TextView couponName;
    public String couponNum;
    public TextView dateTip;
    public TextView discountContent;
    public ImageView invalidCouponImg;
    public TextView invalidCouponTime;
    public ClipData mClipData;
    public ClipboardManager mClipboardManager;
    public CouponDetailResponse mDetail;
    public WalletBaseEmptyView mReloadView;
    public long now;
    public TextView serviceLabel1;
    public TextView serviceLabel2;
    public CirclePortraitView spLogo;
    public TextView spName;
    public String templateNum;
    public View useButton;
    public TextView useInfo;
    public TextView useLimt;
    public String longitude = "";
    public String latitude = "";
    public boolean needRefresh = false;
    public int mLoadStatus = -1;
    public boolean isShowBtn = false;
    public boolean isInvalid = false;

    private void populateLabels() {
        List<CouponDetailResponse.MarketingLabelDetail> validLabels = this.mDetail.getValidLabels();
        if (validLabels.size() > 0) {
            TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_market_label1"));
            textView.setText(validLabels.get(0).label_name);
            textView.setVisibility(0);
        }
        if (validLabels.size() > 1) {
            TextView textView2 = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_market_label2"));
            textView2.setText(validLabels.get(1).label_name);
            textView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryDetail(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (z) {
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
        }
        c cVar = (c) b.a().getBean(this.mAct, 516, BEAN_TAG);
        cVar.a(this.cardType);
        cVar.a(this.couponNum);
        cVar.b(this.templateNum);
        cVar.a(this.longitude, this.latitude);
        cVar.setResponseCallback(this);
        cVar.execBean();
        this.now = System.currentTimeMillis();
    }

    private void setStatusImage(int i) {
        ImageView imageView;
        BeanActivity beanActivity;
        String str;
        if (i == 0) {
            imageView = this.invalidCouponImg;
            beanActivity = this.mAct;
            str = "wallet_personal_coupon_expired";
        } else if (i != 1) {
            if (i == 2) {
                imageView = this.invalidCouponImg;
                beanActivity = this.mAct;
                str = "wallet_personal_coupon_disabled";
            }
            this.invalidCouponImg.setVisibility(0);
        } else {
            imageView = this.invalidCouponImg;
            beanActivity = this.mAct;
            str = "wallet_personal_coupon_used";
        }
        imageView.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
        this.invalidCouponImg.setVisibility(0);
    }

    private void showEmptyView(String str) {
        this.mReloadView.setVisibility(0);
        int i = this.mLoadStatus;
        if (i != 3) {
            if (i == 2) {
                this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(this.mAct, "wallet_base_no_net"), ResUtils.getString(this.mAct, "wallet_base_no_network"), ResUtils.getString(this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.4
                    @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                    public void onBtnClick() {
                        MyCouponDetailActivity.this.queryDetail(true);
                    }
                });
                return;
            }
            return;
        }
        WalletBaseEmptyView walletBaseEmptyView = this.mReloadView;
        int drawable = ResUtils.drawable(this.mAct, "wallet_base_no_net");
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.mAct, "wallet_base_no_network");
        }
        walletBaseEmptyView.showTip1_NextBtn(drawable, str, ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.3
            @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
            public void onBtnClick() {
                MyCouponDetailActivity.this.queryDetail(true);
            }
        });
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        DXMSdkSAUtils.onEventWithValues("CouponDetailRequestFail", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
        PayStatisticsUtil.onEventWithValue("CouponDetailRequestFail", (System.currentTimeMillis() - this.now) + "");
        if (this.mAct == null) {
            return;
        }
        super.handleFailure(i, i2, str);
        WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.mAct, "bd_wallet_coupon_detail_fail");
        }
        if (i2 < 0) {
            this.mLoadStatus = 2;
            showEmptyView(null);
            return;
        }
        this.mLoadStatus = 3;
        showEmptyView(str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        DXMSdkSAUtils.onEventWithValues("CouponDetailRequestSuccess", Arrays.asList((System.currentTimeMillis() - this.now) + ""));
        PayStatisticsUtil.onEventWithValue("CouponDetailRequestSuccess", (System.currentTimeMillis() - this.now) + "");
        BeanActivity beanActivity = this.mAct;
        if (beanActivity == null) {
            return;
        }
        WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
        if (i == 516) {
            this.mReloadView.setVisibility(8);
            CouponDetailResponse couponDetailResponse = (CouponDetailResponse) obj;
            this.mDetail = couponDetailResponse;
            if (couponDetailResponse != null) {
                initView();
            } else {
                GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "bd_wallet_coupon_detail_fail"));
            }
        }
    }

    public void initView() {
        TextView textView;
        String string;
        TextView textView2;
        String string2;
        TextView textView3;
        String string3;
        TextView textView4;
        String string4;
        int length;
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "title_bottom_seperator"));
        this.actionBarLine = imageView;
        imageView.setVisibility(8);
        this.spLogo = (CirclePortraitView) findViewById(ResUtils.id(this.mAct, "coupn_detail_splogo"));
        this.spName = (TextView) findViewById(ResUtils.id(this.mAct, "coupn_detail_logo_title"));
        this.discountContent = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_discount_content1"));
        this.couponName = (TextView) findViewById(ResUtils.id(this.mAct, "coupn_detail_template_title"));
        this.serviceLabel1 = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scene_service_label1"));
        this.serviceLabel2 = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scene_service_label2"));
        this.dateTip = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_use_date_message"));
        this.useLimt = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_use_limit_detail"));
        this.useInfo = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_coupon_detail"));
        this.useButton = findViewById(ResUtils.id(this.mAct, "coupon_detail_btn"));
        this.spLogo.setImageDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_qianbao_logo_for_detail"));
        this.invalidCouponTime = (TextView) findViewById(ResUtils.id(this.mAct, "invalid_coupon_use_info"));
        this.invalidCouponImg = (ImageView) findViewById(ResUtils.id(this.mAct, "coupon_use_img"));
        if (this.isInvalid) {
            this.discountContent.setTextColor(ResUtils.getColor(this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
            this.couponName.setTextColor(ResUtils.getColor(this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
            this.spLogo.setImageDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_qianbao_logo_for_detail"));
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.spLogo.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            this.useButton.setVisibility(8);
            if (!TextUtils.isEmpty(this.mDetail.date_message)) {
                this.invalidCouponTime.setVisibility(0);
                this.invalidCouponTime.setText(this.mDetail.date_message);
            }
            switch (this.mDetail.status) {
                case 3:
                case 8:
                case 9:
                case 10:
                    setStatusImage(1);
                    break;
                case 4:
                    setStatusImage(0);
                    break;
                case 5:
                case 6:
                case 7:
                    setStatusImage(2);
                    break;
            }
            findViewById(ResUtils.id(this.mAct, "coupon_detail_down")).setPadding(0, 0, 0, 0);
        } else if (this.mDetail.source_type != 1) {
            this.discountContent.setTextColor(ResUtils.getColor(this.mAct, "wallet_coupon_detail_red"));
            this.useButton.setBackgroundDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_detail_btn_red_background"));
        } else {
            this.discountContent.setTextColor(ResUtils.getColor(this.mAct, "wallet_coupon_detail_blue"));
            this.useButton.setBackgroundDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_detail_btn_blue_background"));
            findViewById(ResUtils.id(this.mAct, "coupon_detail_up")).setBackgroundDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_detail_blue_up"));
            View findViewById = findViewById(ResUtils.id(this.mAct, "coupon_detail_down"));
            findViewById.setBackgroundDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_detail_blue_down"));
            findViewById.setPadding(0, 0, 0, DisplayUtils.dip2px(this.mAct, 71.0f));
        }
        if (!TextUtils.isEmpty(this.mDetail.logo_url)) {
            this.spLogo.setImageUrl(this.mDetail.logo_url);
        }
        if (TextUtils.isEmpty(this.mDetail.logo_title)) {
            textView = this.spName;
            string = ResUtils.getString(this.mAct, "wallet_personal_coupon_logo_title");
        } else {
            textView = this.spName;
            string = this.mDetail.logo_title;
        }
        textView.setText(string);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.mAct, 30.0f));
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.mAct, 37.0f));
        AbsoluteSizeSpan absoluteSizeSpan3 = new AbsoluteSizeSpan(DisplayUtils.dip2px(this.mAct, 50.0f));
        StyleSpan styleSpan = new StyleSpan(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mDetail.discount_content_v2);
        if (TextUtils.isEmpty(this.mDetail.discount_content_v2_unit)) {
            spannableStringBuilder.setSpan(styleSpan, 0, spannableStringBuilder.length(), 18);
            spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
        } else {
            if (this.mDetail.discount_content_v2.length() > 12) {
                length = spannableStringBuilder.length();
            } else {
                spannableStringBuilder.append((CharSequence) this.mDetail.discount_content_v2_unit);
                if (TextUtils.equals("%", this.mDetail.discount_content_v2_unit)) {
                    spannableStringBuilder.setSpan(absoluteSizeSpan2, 0, 1, 18);
                    spannableStringBuilder.setSpan(absoluteSizeSpan3, 1, spannableStringBuilder.length() - this.mDetail.discount_content_v2_unit.length(), 18);
                    spannableStringBuilder.setSpan(styleSpan, 1, spannableStringBuilder.length() - this.mDetail.discount_content_v2_unit.length(), 18);
                } else {
                    spannableStringBuilder.setSpan(styleSpan, 0, spannableStringBuilder.length() - this.mDetail.discount_content_v2_unit.length(), 18);
                    spannableStringBuilder.setSpan(absoluteSizeSpan, spannableStringBuilder.length() - this.mDetail.discount_content_v2_unit.length(), spannableStringBuilder.length(), 18);
                    length = spannableStringBuilder.length() - this.mDetail.discount_content_v2_unit.length();
                }
            }
            spannableStringBuilder.setSpan(absoluteSizeSpan3, 0, length, 18);
        }
        this.discountContent.setText(spannableStringBuilder);
        this.couponName.setText(this.mDetail.template_title);
        populateLabels();
        if (!TextUtils.isEmpty(this.mDetail.display_coupon_num)) {
            findViewById(ResUtils.id(this.mAct, "coupon_detail_exchange")).setVisibility(0);
            ((TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_scene_service_label"))).setText(this.mDetail.display_coupon_num);
            TextView textView5 = (TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_btn_copy"));
            if (this.isInvalid) {
                textView5.setTextColor(ResUtils.getColor(this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
                textView5.setClickable(false);
            } else {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MyCouponDetailActivity myCouponDetailActivity = MyCouponDetailActivity.this;
                        myCouponDetailActivity.mClipboardManager = (ClipboardManager) myCouponDetailActivity.getSystemService("clipboard");
                        MyCouponDetailActivity myCouponDetailActivity2 = MyCouponDetailActivity.this;
                        myCouponDetailActivity2.mClipData = ClipData.newPlainText(ResUtils.getString(myCouponDetailActivity2.mAct, "wallet_personal_coupon_detail_copy_lable"), MyCouponDetailActivity.this.mDetail.display_coupon_num);
                        MyCouponDetailActivity.this.mClipboardManager.setPrimaryClip(MyCouponDetailActivity.this.mClipData);
                        BeanActivity beanActivity = MyCouponDetailActivity.this.mAct;
                        GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "wallet_personal_coupon_detail_copy_success"));
                    }
                });
            }
        } else if (this.isInvalid) {
            ((LinearLayout.LayoutParams) this.invalidCouponTime.getLayoutParams()).setMargins(0, DisplayUtils.dip2px(this.mAct, 5.0f), 0, DisplayUtils.dip2px(this.mAct, 40.0f));
            this.invalidCouponTime.invalidate();
        }
        if (!this.isInvalid) {
            CouponDetailResponse couponDetailResponse = this.mDetail;
            if (couponDetailResponse.is_started) {
                CouponDetailResponse.AppSceneService appSceneService = couponDetailResponse.app_scene_service;
                if (appSceneService == null ? !((TextUtils.isEmpty(couponDetailResponse.sdk_para) || !this.mDetail.sdk_para.contains("type:1")) && TextUtils.isEmpty(this.mDetail.scene_service)) : !(appSceneService.f26579android <= 0 && TextUtils.isEmpty(appSceneService.url))) {
                    this.isShowBtn = true;
                }
                if (this.isShowBtn) {
                    if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                        textView4 = this.serviceLabel1;
                        string4 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                    } else {
                        textView4 = this.serviceLabel1;
                        string4 = this.mDetail.scene_service_label;
                    }
                    textView4.setText(string4);
                    this.serviceLabel1.setVisibility(0);
                    this.serviceLabel2.setVisibility(8);
                    this.dateTip.setVisibility(8);
                    this.useButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BaiduWalletDelegate baiduWalletDelegate;
                            BeanActivity beanActivity;
                            String str;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("template_num", MyCouponDetailActivity.this.mDetail.template_num);
                                jSONObject.put("coupon_num", MyCouponDetailActivity.this.mDetail.coupon_num);
                                jSONObject.put("card_type", MyCouponDetailActivity.this.mDetail.card_type);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            DXMSdkSAUtils.onEventWithValues("CouponDetailToUseBtnClick", Arrays.asList(jSONObject.toString()));
                            PayStatisticsUtil.onEventWithValue("CouponDetailToUseBtnClick", jSONObject.toString());
                            if (MyCouponDetailActivity.this.mDetail.app_scene_service != null) {
                                if (MyCouponDetailActivity.this.mDetail.app_scene_service.f26579android > 0) {
                                    MyCouponDetailActivity.this.needRefresh = true;
                                    BaiduWalletServiceController baiduWalletServiceController = BaiduWalletServiceController.getInstance();
                                    MyCouponDetailActivity myCouponDetailActivity = MyCouponDetailActivity.this;
                                    baiduWalletServiceController.gotoWalletService(myCouponDetailActivity.mAct, myCouponDetailActivity.mDetail.app_scene_service.f26579android, "");
                                    return;
                                } else if (TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.app_scene_service.url)) {
                                    return;
                                } else {
                                    MyCouponDetailActivity.this.needRefresh = true;
                                    baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                    MyCouponDetailActivity myCouponDetailActivity2 = MyCouponDetailActivity.this;
                                    beanActivity = myCouponDetailActivity2.mAct;
                                    str = myCouponDetailActivity2.mDetail.app_scene_service.url;
                                }
                            } else if (!TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.sdk_para) && MyCouponDetailActivity.this.mDetail.sdk_para.contains("type:1")) {
                                MyCouponDetailActivity.this.needRefresh = true;
                                DXMSdkSAUtils.onEvent("couponDetailButtonClick");
                                PayStatisticsUtil.onEvent("couponDetailButtonClick");
                                BaiduWalletServiceController baiduWalletServiceController2 = BaiduWalletServiceController.getInstance();
                                BeanActivity beanActivity2 = MyCouponDetailActivity.this.mAct;
                                baiduWalletServiceController2.gotoWalletService(beanActivity2, "512", MyCouponDetailActivity.this.mDetail.qrcode_choose + "");
                                return;
                            } else if (TextUtils.isEmpty(MyCouponDetailActivity.this.mDetail.scene_service)) {
                                return;
                            } else {
                                MyCouponDetailActivity.this.needRefresh = true;
                                MyCouponDetailActivity.this.isShowBtn = true;
                                DXMSdkSAUtils.onEvent("couponDetailButtonClick");
                                PayStatisticsUtil.onEvent("couponDetailButtonClick");
                                baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                MyCouponDetailActivity myCouponDetailActivity3 = MyCouponDetailActivity.this;
                                beanActivity = myCouponDetailActivity3.mAct;
                                str = myCouponDetailActivity3.mDetail.scene_service;
                            }
                            baiduWalletDelegate.openH5Module(beanActivity, str, true);
                        }
                    });
                } else if (TextUtils.isEmpty(this.mDetail.use_date_message)) {
                    if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                        textView2 = this.serviceLabel1;
                        string2 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                    } else {
                        textView2 = this.serviceLabel1;
                        string2 = this.mDetail.scene_service_label;
                    }
                    textView2.setText(string2);
                    this.serviceLabel1.setVisibility(0);
                    this.serviceLabel2.setVisibility(8);
                    this.dateTip.setVisibility(8);
                } else {
                    this.serviceLabel1.setVisibility(8);
                    if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                        textView3 = this.serviceLabel2;
                        string3 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                    } else {
                        textView3 = this.serviceLabel2;
                        string3 = this.mDetail.scene_service_label;
                    }
                    textView3.setText(string3);
                    this.serviceLabel2.setVisibility(0);
                    this.dateTip.setText(this.mDetail.use_date_message);
                    this.dateTip.setVisibility(0);
                }
            } else if (TextUtils.isEmpty(couponDetailResponse.use_date_message)) {
                if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                    textView2 = this.serviceLabel1;
                    string2 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                } else {
                    textView2 = this.serviceLabel1;
                    string2 = this.mDetail.scene_service_label;
                }
                textView2.setText(string2);
                this.serviceLabel1.setVisibility(0);
                this.serviceLabel2.setVisibility(8);
                this.dateTip.setVisibility(8);
            } else {
                this.serviceLabel1.setVisibility(8);
                if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                    textView3 = this.serviceLabel2;
                    string3 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                } else {
                    textView3 = this.serviceLabel2;
                    string3 = this.mDetail.scene_service_label;
                }
                textView3.setText(string3);
                this.serviceLabel2.setVisibility(0);
                this.dateTip.setText(this.mDetail.use_date_message);
                this.dateTip.setVisibility(0);
            }
            this.useButton.setClickable(false);
            this.useButton.setBackgroundDrawable(ResUtils.getDrawable(this.mAct, "wallet_personal_coupon_detail_btn_unuseable"));
        }
        if (TextUtils.isEmpty(this.mDetail.use_limit_detail)) {
            this.useLimt.setVisibility(8);
        } else {
            this.useLimt.setText(Html.fromHtml(this.mDetail.use_limit_detail));
            this.useLimt.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.mDetail.coupon_detail)) {
            this.useInfo.setVisibility(8);
        } else {
            this.useInfo.setText(Html.fromHtml(this.mDetail.coupon_detail));
        }
        if (TextUtils.isEmpty(this.mDetail.use_limit_detail) || TextUtils.isEmpty(this.mDetail.coupon_detail)) {
            findViewById(ResUtils.id(this.mAct, "coupon_detail_useinfo_line")).setVisibility(8);
        } else {
            findViewById(ResUtils.id(this.mAct, "coupon_detail_useinfo_line")).setVisibility(0);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_detail1"));
        Intent intent = getIntent();
        if (intent != null) {
            this.cardType = intent.getIntExtra("cardType", 0);
            this.couponNum = intent.getStringExtra("couponNum");
            this.templateNum = intent.getStringExtra("templateNum");
            this.longitude = intent.getStringExtra("longitude");
            this.latitude = intent.getStringExtra("latitude");
            this.isInvalid = intent.getBooleanExtra("isInvaild", false);
        }
        initActionBar("bd_wallet_coupon_detail");
        this.mReloadView = (WalletBaseEmptyView) findViewById(ResUtils.id(this.mAct, "wallet_personal_reload_view"));
        queryDetail(true);
        setResult(0);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        super.onDestroy();
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.needRefresh) {
            queryDetail(true);
            this.needRefresh = false;
        }
    }
}
