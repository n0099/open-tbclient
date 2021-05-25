package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.CouponListPresenter;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class CouponListActivity extends HalfScreenBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f25681a;

    /* renamed from: b  reason: collision with root package name */
    public View f25682b;
    public CouponListContract.Presenter mPresenter;

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_coupon_list"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
    }

    public void initData() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        this.mPresenter.calcPayamount(null);
    }

    public void initView() {
        this.mActionBar.setVisibility(0);
        this.mLeftImg.setOnClickListener(this);
        this.mRightTxt.setVisibility(8);
        TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "couponlist_title"));
        this.mTitle = textView;
        textView.setBackgroundColor(ResUtils.getColor(this.mAct, "ebpay_white"));
        this.mTitle.setText(ResUtils.getString(getActivity(), "ebpay_select_coupon"));
        this.f25681a = (ViewGroup) findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_container"));
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mHalfScreenContainer.isClickable()) {
            EventBus eventBus = EventBus.getInstance();
            EventBus eventBus2 = EventBus.getInstance();
            eventBus.getClass();
            eventBus2.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", null));
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CouponListPresenter couponListPresenter = new CouponListPresenter(this);
        this.mPresenter = couponListPresenter;
        couponListPresenter.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CouponListContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onDestroy();
            this.mPresenter = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        CouponListContract.Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void returnToPreviousPage() {
        finishWithoutAnim();
    }

    public void revertItemView() {
        View view = this.f25682b;
        if (view != null) {
            a((ProgressBar) view.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar")), (ImageView) this.f25682b.findViewById(ResUtils.id(this, "coupon_select")), false);
        }
        this.f25682b = null;
    }

    public void setPageClickable(boolean z) {
        this.mHalfScreenContainer.setClickable(z);
    }

    public void showLoading(int i2) {
        WalletGlobalUtils.safeShowDialog(this, i2, "");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(ArrayList<CouponListPresenter.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f25682b = null;
        setPageClickable(true);
        this.f25681a.removeAllViews();
        int dimension = (int) ResUtils.getDimension(this.mAct, "bd_wallet_coupon_height");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View a2 = a(arrayList.get(i2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimension);
            if (i2 == arrayList.size() - 1) {
                layoutParams.bottomMargin = DisplayUtils.dip2px(this, 5.0f);
            }
            a2.setLayoutParams(layoutParams);
            this.f25681a.addView(a2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(CouponListContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProgressBar progressBar, ImageView imageView, boolean z) {
        if (z) {
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
            return;
        }
        progressBar.setVisibility(8);
        imageView.setVisibility(0);
    }

    private View a(CouponListPresenter.a aVar) {
        final View inflate = LayoutInflater.from(this).inflate(ResUtils.layout(this, "wallet_cashdesk_coupon_item_view"), (ViewGroup) null);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar"));
        final ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(this, "coupon_select"));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.CouponListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CouponListActivity.this.f25682b = inflate;
                CouponListPresenter.a aVar2 = (CouponListPresenter.a) view.getTag();
                if (aVar2.f25368g) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_COUPON);
                    CouponListActivity.this.a(progressBar, imageView, true);
                    CouponListActivity.this.mPresenter.calcPayamount(aVar2);
                    return;
                }
                GlobalUtils.toast(CouponListActivity.this, aVar2.f25367f);
            }
        });
        a(progressBar, imageView, false);
        ((NetImageView) inflate.findViewById(ResUtils.id(this, "ebpay_coupon_logo"))).setImageUrl(aVar.f25362a);
        ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_name"))).setText(aVar.f25365d);
        ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_tip"))).setText(aVar.f25366e);
        TextView textView = (TextView) inflate.findViewById(ResUtils.id(this, "coupon_disable_reason"));
        if (!TextUtils.isEmpty(aVar.f25367f)) {
            textView.setVisibility(0);
            textView.setText(aVar.f25367f);
        } else {
            textView.setVisibility(8);
        }
        if (aVar.f25368g) {
            imageView.setSelected(aVar.f25369h);
            inflate.setTag(aVar);
            a(inflate, true);
        } else {
            imageView.setSelected(false);
            inflate.setTag(aVar);
            a(inflate, false);
        }
        return inflate;
    }

    private void a(View view, boolean z) {
        if (z) {
            ViewHelper.setAlpha(view, 1.0f);
        } else {
            ViewHelper.setAlpha(view, 0.4f);
        }
    }
}
