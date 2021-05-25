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
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.a.d;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class WalletPayResultView extends d implements IWalletPayResultView {
    public BaseActivity mActivity;
    public TextView mButtonToConsumptionPage;
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

    public WalletPayResultView(BaseActivity baseActivity, boolean z, PayConfig payConfig) {
        super(baseActivity.getPageContext());
        this.mPayResult = false;
        this.mActivity = baseActivity;
        this.mPayResult = z;
        this.mPayData = payConfig;
        initUI();
    }

    private SpannableString buildTBeanText(int i2) {
        String formatTBeanNum = BuyTBeanStringUlti.formatTBeanNum(i2);
        String str = this.mActivity.getPageContext().getPageActivity().getString(R.string.tbean_get) + "[image]" + formatTBeanNum;
        Bitmap moneyIconBitmap = CurrencySwitchUtil.getMoneyIconBitmap();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(moneyIconBitmap);
        bitmapDrawable.setBounds(0, 0, moneyIconBitmap.getWidth(), moneyIconBitmap.getHeight());
        d.a.m0.b1.d dVar = new d.a.m0.b1.d(bitmapDrawable);
        dVar.b(l.g(this.mActivity.getPageContext().getPageActivity(), R.dimen.ds4));
        dVar.c(l.g(this.mActivity.getPageContext().getPageActivity(), R.dimen.ds4));
        SpannableString spannableString = new SpannableString(str);
        BuyTBeanStringUlti.setSpan(spannableString, str, formatTBeanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
        BuyTBeanStringUlti.setSpan(spannableString, str, "[image]", dVar);
        return spannableString;
    }

    private Activity getActivity() {
        return getPageContext().getPageActivity();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initUI() {
        this.mActivity.setContentView(R.layout.wallet_pay_result_activity);
        this.mRootLayout = (LinearLayoutDetectsSoftKeyboard) this.mActivity.findViewById(R.id.buy_tbean_root_ll);
        NavigationBar navigationBar = (NavigationBar) this.mActivity.findViewById(R.id.pay_result_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setTitleText(R.string.pay_member);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayResultView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletPayResultView.this.mActivity.setResult(-1, new Intent());
                WalletPayResultView.this.mActivity.finish();
            }
        });
        this.mTBeanDialogTitle = (TextView) this.mActivity.findViewById(R.id.tbean_dialog_title);
        TextView textView = (TextView) this.mActivity.findViewById(R.id.pay_fail_rebuy_btn);
        this.mPayFailRebuyBtn = textView;
        textView.setOnClickListener(this.mActivity);
        this.mPayResultInfo = (TextView) this.mActivity.findViewById(R.id.pay_result_info);
        this.mPayResultSubInfo = (TextView) this.mActivity.findViewById(R.id.pay_result_sub_info);
        TextView textView2 = (TextView) this.mActivity.findViewById(R.id.jump_to_see_consumption_records);
        this.mButtonToConsumptionPage = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayResultView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(WalletPayResultView.this.mActivity.getPageContext().getPageActivity())));
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

    @Override // d.a.c.a.d
    public void destroy() {
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = this.mRootLayout;
        if (linearLayoutDetectsSoftKeyboard != null) {
            linearLayoutDetectsSoftKeyboard.removeAllViews();
        }
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.release();
        }
    }

    public LinearLayoutDetectsSoftKeyboard getRootLayout() {
        return this.mRootLayout;
    }

    @Override // com.baidu.tieba.wallet.pay.IWalletPayResultView
    public void onChangeSkinType(int i2) {
        this.mActivity.getLayoutMode().k(i2 == 1);
        this.mActivity.getLayoutMode().j(this.mRootLayout);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i2);
    }
}
