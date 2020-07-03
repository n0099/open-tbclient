package com.baidu.tieba.live.tbean;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.image.loader.ImageLoaderManager;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdRoundedImageView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.live.tbean.AbsBuyTBeanView;
import com.baidu.tieba.live.tbean.adapter.BuyTBeanFullGridAdapter;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.data.UserDefineTbeanWrapperData;
import com.baidu.tieba.live.tbean.view.WalletPayResultView;
import com.baidu.webkit.internal.ETAG;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BuyTBeanFullView extends AbsBuyTBeanView {
    private Activity activity;
    private LinearLayout buyBeanCustomLayout;
    private BuyTBeanController buyTBeanController;
    private TBeanEditText editCustomPrice;
    private String exchangeHomePageUrl;
    private boolean isFromLive;
    private boolean isInputShowing;
    private boolean isTBeanNotEnough;
    private boolean isTranslucent;
    private LinearLayout layoutExchange;
    private RelativeLayout mActivitiyRootRl;
    private ImageView mBack;
    private BuyTBeanFullGridAdapter mBuyTBeanAdapter;
    private LinearLayout mBuyTBeanRootLayout;
    private RelativeLayout mContainer;
    private RelativeLayout mCustomBeanSubmitRoot;
    private BuyTBeanModel mData;
    private AbsBuyTBeanView.OnPayClickListener mOnPayClickListener;
    private String mOtherParams;
    private WalletPayResultView mResultView;
    private TextWatcher mTextWatcher;
    private TextView mTvTitle;
    private BdGridView mTypeListview;
    private TbPageContext tbPageContext;
    private TextView tvCustomBeanNum;
    private TextView tvCustomSubmit;
    private TextView tvCustomSubmitHint;
    private TextView tvExchangeContent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuyTBeanFullView(TbPageContext<?> tbPageContext, BuyTBeanController buyTBeanController, boolean z, boolean z2, boolean z3) {
        super(tbPageContext, buyTBeanController, z, z2, z3);
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                long j = JavaTypesHelper.toLong(BuyTBeanFullView.this.editCustomPrice.getText().toString(), 0L);
                if (editable.toString().startsWith("0")) {
                    BuyTBeanFullView.this.editCustomPrice.setText("");
                    j = 0;
                }
                if (j == 0) {
                    BuyTBeanFullView.this.editCustomPrice.setTypeface(Typeface.defaultFromStyle(0));
                } else {
                    BuyTBeanFullView.this.editCustomPrice.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (j <= 0 || j > 200000) {
                    if (BuyTBeanFullView.this.tvCustomSubmit != null) {
                        BuyTBeanFullView.this.tvCustomSubmit.setEnabled(false);
                        BuyTBeanFullView.this.tvCustomSubmit.setClickable(false);
                    }
                    if (j > 200000) {
                        BuyTBeanFullView.this.tvCustomSubmitHint.setVisibility(0);
                        return;
                    }
                } else {
                    BuyTBeanFullView.this.tvCustomSubmitHint.setVisibility(8);
                    if (BuyTBeanFullView.this.tvCustomSubmit != null) {
                        BuyTBeanFullView.this.tvCustomSubmit.setEnabled(true);
                        BuyTBeanFullView.this.tvCustomSubmit.setClickable(true);
                    }
                }
                if (j <= 0) {
                    BuyTBeanFullView.this.tvCustomBeanNum.setText(a.i.sdk_tbn_user_define_init_value);
                    return;
                }
                long j2 = j * 1000;
                if (j2 < 10000) {
                    BuyTBeanFullView.this.tvCustomBeanNum.setText(StringHelper.formatTosepara(j2));
                } else {
                    BuyTBeanFullView.this.tvCustomBeanNum.setText(BuyTBeanFullView.formatTBeanNum(j2));
                }
            }
        };
        this.tbPageContext = tbPageContext;
        this.activity = tbPageContext.getPageActivity();
        this.buyTBeanController = buyTBeanController;
        this.isFromLive = z;
        this.isTranslucent = z2;
        this.isTBeanNotEnough = z3;
        initUI();
    }

    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initUI() {
        String str;
        this.activity.setContentView(a.h.sdk_tbn_buy_tbean_full_activity);
        View findViewById = this.activity.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.mActivitiyRootRl = (RelativeLayout) this.activity.findViewById(a.g.buy_tbean_activity_root);
        this.mBuyTBeanRootLayout = (LinearLayout) this.activity.findViewById(a.g.buy_tbean_root_ll);
        FrameLayout frameLayout = (FrameLayout) this.activity.findViewById(a.g.tbean_dialog_wrapper_container);
        this.mTvTitle = (TextView) this.activity.findViewById(a.g.tv_title);
        if (this.isTBeanNotEnough) {
            this.mTvTitle.setText(getPageContext().getPageActivity().getString(a.i.sdk_tbn_get_tdou_not_enough));
        } else {
            this.mTvTitle.setText(getPageContext().getPageActivity().getString(a.i.sdk_tbn_get_tdou));
        }
        this.mBack = (ImageView) this.activity.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(this.buyTBeanController);
        this.mContainer = (RelativeLayout) this.activity.findViewById(a.g.container);
        this.mTypeListview = (BdGridView) this.activity.findViewById(a.g.listview);
        this.mResultView = (WalletPayResultView) this.activity.findViewById(a.g.pay_result_root);
        final BdRoundedImageView bdRoundedImageView = (BdRoundedImageView) this.activity.findViewById(a.g.tbean_ad);
        this.editCustomPrice = (TBeanEditText) this.activity.findViewById(a.g.edit_custom_bean_price);
        this.tvCustomBeanNum = (TextView) this.activity.findViewById(a.g.tv_custome_bean_num);
        this.mCustomBeanSubmitRoot = (RelativeLayout) this.activity.findViewById(a.g.confirm_btn_root);
        this.tvCustomSubmit = (TextView) this.activity.findViewById(a.g.tv_user_define_confirm_submit);
        this.tvCustomSubmitHint = (TextView) this.activity.findViewById(a.g.tv_user_define_hint);
        this.buyBeanCustomLayout = (LinearLayout) this.mActivitiyRootRl.findViewById(a.g.buy_bean_custom_layout);
        this.layoutExchange = (LinearLayout) this.mBuyTBeanRootLayout.findViewById(a.g.exchange_bean);
        this.tvExchangeContent = (TextView) this.mBuyTBeanRootLayout.findViewById(a.g.tv_exchange_bean);
        this.mActivitiyRootRl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (BuyTBeanFullView.this.isInputShowing) {
                    BdUtilHelper.hideSoftKeyPad(BuyTBeanFullView.this.activity, BuyTBeanFullView.this.editCustomPrice);
                    return false;
                }
                return false;
            }
        });
        this.editCustomPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    BuyTBeanFullView.this.mTypeListview.setVisibility(8);
                    LogManager.getCommonLogger().doClickBuyTBeanCustomLog(null, BuyTBeanFullView.this.mOtherParams, null);
                    BuyTBeanFullView.this.layoutExchange.setVisibility(8);
                    LogManager.getCommonLogger().doClickBuyTBeanCustomLog(null, null, null);
                }
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO), String.class);
        if (runTask != null && !TextUtils.isEmpty((CharSequence) runTask.getData())) {
            try {
                JSONObject jSONObject = new JSONObject((String) runTask.getData());
                String optString = jSONObject.optString("photo_url");
                final String optString2 = jSONObject.optString("resource_url");
                String optString3 = jSONObject.optString("general_exchange_homepage_url");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    ImageLoaderManager.getInstance().buildImageLoader().loadImage(optString, new IImageLoaderListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.3
                        @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener
                        public void onLoadComplete(String str2, Bitmap bitmap) {
                            bdRoundedImageView.setImageBitmap(bitmap);
                        }
                    });
                    bdRoundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UrlManager.getInstance().dealOneLink(BuyTBeanFullView.this.tbPageContext, new String[]{optString2});
                            LogManager.getCommonLogger().doClickBuyTBeanResourceLog(null, BuyTBeanFullView.this.mOtherParams, null);
                        }
                    });
                    bdRoundedImageView.setVisibility(0);
                }
                if (!TextUtils.isEmpty(optString3) && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    refreshExchangeView();
                    this.tvExchangeContent.setText("兑换T豆");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        str = TbadkCoreApplication.APP_ID_QUANMIN;
                    } else if (!TbadkCoreApplication.getInst().isHaokan()) {
                        str = "";
                    } else {
                        str = "haokan";
                    }
                    final String str2 = optString3 + (optString3.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "_client_type=2&subapp_type=" + str + "&from=" + (this.isFromLive ? "live" : "other");
                    this.layoutExchange.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            UrlManager.getInstance().dealOneLink(BuyTBeanFullView.this.tbPageContext, new String[]{str2});
                        }
                    });
                    this.exchangeHomePageUrl = optString3;
                    refreshExchangeView();
                }
                bdRoundedImageView.post(new Runnable() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bdRoundedImageView.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = (int) (((BuyTBeanFullView.this.activity.getResources().getDisplayMetrics().widthPixels - layoutParams2.leftMargin) - layoutParams2.rightMargin) * 0.18666666666666668d);
                            bdRoundedImageView.setLayoutParams(layoutParams2);
                        }
                    }
                });
                LogManager.getCommonLogger().doDisplayBuyTBeanResourceLog(null, this.mOtherParams, null);
            } catch (JSONException e) {
                bdRoundedImageView.setVisibility(8);
            }
        }
        this.mResultView.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof Boolean) {
                    if (((Boolean) view.getTag()).booleanValue()) {
                        BuyTBeanFullView.this.buyTBeanController.processClose();
                    } else {
                        BuyTBeanFullView.this.hidePayResultView();
                    }
                }
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.activity).inflate(a.h.sdk_tbn_buy_tbean_full_floating_window_top_bar, (ViewGroup) frameLayout, false);
        frameLayout.addView(relativeLayout);
        ((TextView) relativeLayout.findViewById(a.g.tbean_get_introduce)).setOnClickListener(this.buyTBeanController);
        ((ImageView) relativeLayout.findViewById(a.g.tbean_dialog_close_btn)).setOnClickListener(this.buyTBeanController);
        this.mBuyTBeanAdapter = new BuyTBeanFullGridAdapter(this.tbPageContext, this.activity);
        this.mTypeListview.setAdapter((ListAdapter) this.mBuyTBeanAdapter);
        initListener();
    }

    private void refreshExchangeView() {
        if (!TextUtils.isEmpty(this.exchangeHomePageUrl) && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
            this.layoutExchange.setVisibility(0);
        } else {
            this.layoutExchange.setVisibility(8);
        }
    }

    private void initListener() {
        this.mTypeListview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IconInfoData iconInfoData;
                Object item = BuyTBeanFullView.this.mBuyTBeanAdapter.getItem(i);
                if (!(item instanceof IconInfoData)) {
                    iconInfoData = null;
                } else {
                    iconInfoData = (IconInfoData) item;
                }
                if (BuyTBeanFullView.this.mOnPayClickListener != null && iconInfoData != null && BuyTBeanFullView.this.mData != null && BuyTBeanFullView.this.mData.getCommodityList() != null) {
                    for (IAdapterData iAdapterData : BuyTBeanFullView.this.mData.getCommodityList()) {
                        if ((iAdapterData instanceof IconInfoWrapperData) && iconInfoData == ((IconInfoWrapperData) iAdapterData).info) {
                            BuyTBeanFullView.this.mOnPayClickListener.onClick(iAdapterData, BuyTBeanFullView.this.mData.getUserInfo());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void setOnPayClickListener(AbsBuyTBeanView.OnPayClickListener onPayClickListener) {
        this.mOnPayClickListener = onPayClickListener;
    }

    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void setData(BuyTBeanModel buyTBeanModel) {
        if (buyTBeanModel == null || ListUtils.isEmpty(buyTBeanModel.getCommodityList())) {
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.sdk_tbn_no_data_tip);
            return;
        }
        this.mData = buyTBeanModel;
        this.mActivitiyRootRl.setVisibility(0);
        this.mBuyTBeanAdapter.setIconInfoDatas(buyTBeanModel.getCommodityList());
        final UserDefineTbeanWrapperData userDefineTbeanWrapperData = buyTBeanModel.getUserDefineTbeanWrapperData();
        if (buyTBeanModel.isShowUserDifineTBeanItem() && userDefineTbeanWrapperData != null) {
            this.editCustomPrice.addTextChangedListener(this.mTextWatcher);
            this.editCustomPrice.setTypeface(Typeface.defaultFromStyle(0));
            this.tvCustomSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BuyTBeanFullView.this.buyTBeanController != null) {
                        int i = JavaTypesHelper.toInt(BuyTBeanFullView.this.editCustomPrice.getText().toString(), 0);
                        if (i != 0) {
                            BuyTBeanFullView.this.buyTBeanController.payForTbean(userDefineTbeanWrapperData.mData.productId, userDefineTbeanWrapperData.mData.icon_id, i, i, TBeanUtil.getTBeanNum(userDefineTbeanWrapperData.userInfo, i * 1000, userDefineTbeanWrapperData.mSetting) * 1, userDefineTbeanWrapperData.mData.pic_url, userDefineTbeanWrapperData.mData.duration, userDefineTbeanWrapperData.mData.name);
                        } else {
                            return;
                        }
                    }
                    TiebaInitialize.log(TbeanStatisticKey.BUY_BIG_TBEAN_PAY_BUTTON);
                    BdUtilHelper.hideSoftKeyPad(BuyTBeanFullView.this.activity, BuyTBeanFullView.this.editCustomPrice);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatTBeanNum(long j) {
        double doubleValue = new BigDecimal((j / 10000.0d) + "").setScale(1, RoundingMode.HALF_UP).doubleValue();
        return doubleValue % 1.0d == 0.0d ? StringHelper.formatTosepara((int) doubleValue) + "万" : doubleValue + "万";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public View getRootView() {
        return this.mBuyTBeanRootLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void showContainerView() {
        if (this.mContainer != null && this.mContainer.getVisibility() != 0) {
            this.mContainer.setVisibility(0);
        }
        if (this.buyBeanCustomLayout != null && this.buyBeanCustomLayout.getVisibility() != 0) {
            this.buyBeanCustomLayout.setVisibility(0);
        }
        if (this.layoutExchange != null && this.layoutExchange.getVisibility() != 0) {
            refreshExchangeView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void showRootView() {
        if (this.mActivitiyRootRl != null && this.mActivitiyRootRl.getVisibility() != 0) {
            this.mActivitiyRootRl.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void hideRootView() {
        if (this.mActivitiyRootRl != null && this.mActivitiyRootRl.getVisibility() != 8) {
            this.mActivitiyRootRl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void hideContainerView() {
        if (this.mContainer != null && this.mContainer.getVisibility() != 8) {
            this.mContainer.setVisibility(8);
        }
        if (this.buyBeanCustomLayout != null && this.buyBeanCustomLayout.getVisibility() != 8) {
            this.buyBeanCustomLayout.setVisibility(8);
        }
        if (this.layoutExchange != null && this.layoutExchange.getVisibility() != 8) {
            this.layoutExchange.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.mCustomBeanSubmitRoot.setVisibility(0);
            this.mTypeListview.setVisibility(8);
            this.mResultView.setVisibility(8);
            this.layoutExchange.setVisibility(8);
        } else {
            this.editCustomPrice.clearFocus();
            if (this.mResultView.getVisibility() == 8) {
                this.mTypeListview.setVisibility(0);
                this.buyBeanCustomLayout.setVisibility(0);
            }
            refreshExchangeView();
            this.mCustomBeanSubmitRoot.setVisibility(8);
        }
        this.isInputShowing = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void showPayResultView(boolean z, int i, CustomData customData) {
        this.mResultView.updateResult(z, i, customData);
        this.mResultView.setVisibility(0);
        this.mTypeListview.setVisibility(8);
        this.layoutExchange.setVisibility(8);
        this.buyBeanCustomLayout.setVisibility(8);
        this.mCustomBeanSubmitRoot.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView
    public void hidePayResultView() {
        if (this.mResultView.getVisibility() == 0) {
            this.mResultView.setVisibility(8);
            this.mCustomBeanSubmitRoot.setVisibility(8);
            this.mTypeListview.setVisibility(0);
            this.buyBeanCustomLayout.setVisibility(0);
            refreshExchangeView();
        }
    }
}
