package com.baidu.tieba.wallet.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.d;
import b.a.e.a.f;
import b.a.e.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class WalletPayResultView extends d implements IWalletPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity mActivity;
    public TextView mButtonToConsumptionPage;
    public RelativeLayout mDialogWrapper;
    public View mLineView;
    public NavigationBar mNavigationBar;
    public PayConfig mPayData;
    public TextView mPayFailRebuyBtn;
    public ScrollView mPayLayout;
    public boolean mPayResult;
    public ImageView mPayResultIcon;
    public TextView mPayResultInfo;
    public TextView mPayResultSubInfo;
    public LinearLayoutDetectsSoftKeyboard mRootLayout;
    public TextView mTBeanDialogTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletPayResultView(BaseActivity baseActivity, boolean z, PayConfig payConfig) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, Boolean.valueOf(z), payConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPayResult = false;
        this.mActivity = baseActivity;
        this.mPayResult = z;
        this.mPayData = payConfig;
        initUI();
    }

    private SpannableString buildTBeanText(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            String formatTBeanNum = BuyTBeanStringUlti.formatTBeanNum(i2);
            String str = this.mActivity.getPageContext().getPageActivity().getString(R.string.tbean_get) + "[image]" + formatTBeanNum;
            Bitmap moneyIconBitmap = CurrencySwitchUtil.getMoneyIconBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(moneyIconBitmap);
            bitmapDrawable.setBounds(0, 0, moneyIconBitmap.getWidth(), moneyIconBitmap.getHeight());
            b.a.q0.e1.d dVar = new b.a.q0.e1.d(bitmapDrawable);
            dVar.b(l.g(this.mActivity.getPageContext().getPageActivity(), R.dimen.ds4));
            dVar.c(l.g(this.mActivity.getPageContext().getPageActivity(), R.dimen.ds4));
            SpannableString spannableString = new SpannableString(str);
            BuyTBeanStringUlti.setSpan(spannableString, str, formatTBeanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            BuyTBeanStringUlti.setSpan(spannableString, str, "[image]", dVar);
            return spannableString;
        }
        return (SpannableString) invokeI.objValue;
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mActivity.setContentView(R.layout.wallet_pay_result_activity);
            this.mRootLayout = (LinearLayoutDetectsSoftKeyboard) this.mActivity.findViewById(R.id.buy_tbean_root_ll);
            NavigationBar navigationBar = (NavigationBar) this.mActivity.findViewById(R.id.pay_result_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setTitleText(R.string.pay_member);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayResultView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayResultView this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.mActivity.setResult(-1, new Intent());
                        this.this$0.mActivity.finish();
                    }
                }
            });
            this.mTBeanDialogTitle = (TextView) this.mActivity.findViewById(R.id.tbean_dialog_title);
            this.mDialogWrapper = (RelativeLayout) this.mActivity.findViewById(R.id.tbean_dialog_wrapper);
            this.mLineView = this.mActivity.findViewById(R.id.title_divider_line);
            TextView textView = (TextView) this.mActivity.findViewById(R.id.pay_fail_rebuy_btn);
            this.mPayFailRebuyBtn = textView;
            textView.setOnClickListener(this.mActivity);
            this.mPayResultInfo = (TextView) this.mActivity.findViewById(R.id.pay_result_info);
            this.mPayResultSubInfo = (TextView) this.mActivity.findViewById(R.id.pay_result_sub_info);
            TextView textView2 = (TextView) this.mActivity.findViewById(R.id.jump_to_see_consumption_records);
            this.mButtonToConsumptionPage = textView2;
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayResultView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayResultView this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(this.this$0.mActivity.getPageContext().getPageActivity())));
                    }
                }
            });
            this.mPayResultIcon = (ImageView) this.mActivity.findViewById(R.id.pay_result_icon);
            SkinManager.setViewTextColor(this.mPayResultInfo, R.color.CAM_X0105, 1);
            if (this.mPayData.getPayType() == 1) {
                this.mNavigationBar.setTitleText(R.string.pay_member);
                this.mTBeanDialogTitle.setText(R.string.pay_member);
                if (this.mPayResult) {
                    this.mPayResultInfo.setText(R.string.buy_result_success);
                    this.mPayResultSubInfo.setText(getActivity().getString(R.string.member_success_result_info, new Object[]{this.mPayData.getPropsMon()}));
                    this.mPayResultIcon.setImageResource(R.drawable.icon_send_ok);
                    return;
                }
                this.mPayResultInfo.setText(R.string.buy_result_fail);
                this.mPayResultSubInfo.setText(R.string.buy_result_sub_info_fail);
                SkinManager.setViewTextColor(this.mPayResultSubInfo, R.color.CAM_X0105, 1);
                this.mPayFailRebuyBtn.setVisibility(0);
                this.mPayResultIcon.setImageResource(R.drawable.icon_send_error);
            } else if (this.mPayData.getPayType() == 2) {
                this.mNavigationBar.setTitleText(R.string.pay_tbean_get);
                this.mTBeanDialogTitle.setText(R.string.pay_tbean_get);
                if (this.mPayResult) {
                    this.mPayResultInfo.setText(R.string.buy_result_success);
                    this.mPayResultSubInfo.setText(buildTBeanText(this.mPayData.getTBeanNum()));
                    this.mPayResultIcon.setImageResource(R.drawable.icon_send_ok);
                    return;
                }
                this.mPayResultInfo.setText(R.string.buy_result_fail);
                this.mPayResultSubInfo.setText(R.string.buy_result_sub_info_fail);
                SkinManager.setViewTextColor(this.mPayResultSubInfo, R.color.CAM_X0105, 1);
                this.mPayFailRebuyBtn.setVisibility(0);
                this.mPayResultIcon.setImageResource(R.drawable.icon_send_error);
            }
        }
    }

    @Override // b.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = this.mRootLayout;
            if (linearLayoutDetectsSoftKeyboard != null) {
                linearLayoutDetectsSoftKeyboard.removeAllViews();
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.release();
            }
        }
    }

    public LinearLayoutDetectsSoftKeyboard getRootLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRootLayout : (LinearLayoutDetectsSoftKeyboard) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wallet.pay.IWalletPayResultView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mActivity.getLayoutMode().k(i2 == 1);
            this.mActivity.getLayoutMode().j(this.mRootLayout);
            this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mDialogWrapper, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mLineView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mTBeanDialogTitle, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mPayResultInfo, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mPayResultSubInfo, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mButtonToConsumptionPage, R.color.CAM_X0304);
            SkinManager.setBackgroundResource(this.mButtonToConsumptionPage, R.drawable.order_id_text_bg);
            SkinManager.setViewTextColor(this.mPayFailRebuyBtn, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.mPayFailRebuyBtn, R.drawable.btn_corner_buy_selector);
        }
    }
}
