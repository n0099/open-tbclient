package com.baidu.tieba.wallet.pay;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class NewWalletPayResultView implements IWalletPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WalletPayResultActivity mActivity;
    public TextView mLeftBtn;
    public TextView mMoneyPrefix;
    public TextView mOrderIdView;
    public LinearLayout mOrderLayout;
    public TextView mOrderPrefix;
    public LinearLayout mPanelLayout;
    public PayConfig mPayData;
    public TextView mPayMoney;
    public boolean mPayResult;
    public TextView mPayTime;
    public TextView mPayTimePrefix;
    public TextView mProductPrefix;
    public TextView mProductView;
    public ImageView mResultIcon;
    public TextView mResultText;
    public TextView mRightView;
    public TextView mTitleView;

    public NewWalletPayResultView(WalletPayResultActivity walletPayResultActivity, boolean z, PayConfig payConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {walletPayResultActivity, Boolean.valueOf(z), payConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = walletPayResultActivity;
        this.mPayResult = z;
        this.mPayData = payConfig;
        initView();
        onBindData();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mActivity.setContentView(R.layout.new_wallet_pay_result_layout);
            this.mPanelLayout = (LinearLayout) this.mActivity.findViewById(R.id.buy_result_panel_layout);
            this.mResultIcon = (ImageView) this.mActivity.findViewById(R.id.buy_result_icon);
            this.mResultText = (TextView) this.mActivity.findViewById(R.id.buy_result_text_tip);
            this.mPayMoney = (TextView) this.mActivity.findViewById(R.id.buy_result_pay_money);
            this.mPayTime = (TextView) this.mActivity.findViewById(R.id.buy_result_pay_time);
            this.mProductView = (TextView) this.mActivity.findViewById(R.id.buy_result_product);
            TextView textView = (TextView) this.mActivity.findViewById(R.id.buy_result_left_btn);
            this.mLeftBtn = textView;
            textView.setOnClickListener(this.mActivity);
            TextView textView2 = (TextView) this.mActivity.findViewById(R.id.buy_result_right_btn);
            this.mRightView = textView2;
            textView2.setOnClickListener(this.mActivity);
            this.mOrderLayout = (LinearLayout) this.mActivity.findViewById(R.id.buy_result_order_id_layout);
            this.mOrderIdView = (TextView) this.mActivity.findViewById(R.id.buy_result_order_id);
            this.mTitleView = (TextView) this.mActivity.findViewById(R.id.buy_result_title);
            this.mOrderPrefix = (TextView) this.mActivity.findViewById(R.id.buy_result_order_prefix);
            this.mPayTimePrefix = (TextView) this.mActivity.findViewById(R.id.buy_result_pay_time_prefix);
            this.mProductPrefix = (TextView) this.mActivity.findViewById(R.id.buy_result_product_prefix);
            this.mMoneyPrefix = (TextView) this.mActivity.findViewById(R.id.buy_result_pay_money_prefix);
        }
    }

    private void onBindData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.mPayResult) {
                this.mResultIcon.setImageResource(R.drawable.icon_send_ok);
                this.mResultText.setText(R.string.buy_result_pay_success);
                this.mLeftBtn.setText(R.string.buy_result_open_order);
                this.mRightView.setText(R.string.buy_result_complete);
                this.mRightView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.buy_result_btn_selector));
                this.mOrderLayout.setVisibility(0);
            } else {
                this.mResultIcon.setImageResource(R.drawable.icon_send_error);
                this.mResultText.setText(R.string.buy_result_pay_error);
                this.mLeftBtn.setText(R.string.buy_result_cancle);
                this.mRightView.setText(R.string.buy_result_retry);
                this.mRightView.setTextColor(this.mActivity.getResources().getColor(R.color.CAM_X0101));
                this.mRightView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.buy_result_retry_btn_selector));
                this.mOrderLayout.setVisibility(8);
            }
            PayConfig payConfig = this.mPayData;
            if (payConfig != null) {
                this.mPayMoney.setText(payConfig.getMoney());
                this.mProductView.setText(StringHelper.formatTosepara(this.mPayData.getTBeanNum()));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.tbds46);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.mProductView.setCompoundDrawablePadding(this.mActivity.getResources().getDimensionPixelSize(R.dimen.tbds12));
                this.mProductView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                if (this.mPayResult) {
                    this.mOrderIdView.setText(this.mPayData.mOrderInfo);
                }
                this.mPayTime.setText(StringHelper.long2String(this.mPayData.orderCompleteTime, "yyyy年MM月dd HH:mm"));
            }
        }
    }

    public TextView getLeftBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLeftBtn : (TextView) invokeV.objValue;
    }

    public TextView getRightView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRightView : (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wallet.pay.IWalletPayResultView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.mResultText, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mPayMoney, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mOrderIdView, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mOrderPrefix, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.mPayTimePrefix, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.mPayTime, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.mProductPrefix, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.mMoneyPrefix, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.mLeftBtn, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundResource(this.mLeftBtn, R.drawable.buy_result_btn_selector, i2);
            if (this.mPayResult) {
                SkinManager.setViewTextColor(this.mRightView, R.color.CAM_X0105, 1, i2);
                SkinManager.setBackgroundResource(this.mRightView, R.drawable.buy_result_btn_selector, i2);
            } else {
                SkinManager.setViewTextColor(this.mRightView, R.color.CAM_X0101, 1, i2);
            }
            SkinManager.setBackgroundResource(this.mPanelLayout, R.drawable.buy_result_dialog_bg, i2);
        }
    }
}
