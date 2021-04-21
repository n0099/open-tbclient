package com.baidu.wallet.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes5.dex */
public abstract class BaseActionBarActivity extends BeanActivity {
    public BdActionBar mBdActionBar;
    public FrameLayout mContentLayout;
    public View mContentView;
    public IErrorViewDelegate mErrorViewDelegate;

    /* loaded from: classes5.dex */
    public class ErrorViewDelegate implements IErrorViewDelegate {

        /* renamed from: a  reason: collision with root package name */
        public WalletBaseEmptyView f23887a;

        public ErrorViewDelegate() {
            WalletBaseEmptyView walletBaseEmptyView = new WalletBaseEmptyView(BaseActionBarActivity.this.getActivity());
            this.f23887a = walletBaseEmptyView;
            walletBaseEmptyView.setVisibility(8);
            BaseActionBarActivity.this.mContentLayout.addView(this.f23887a);
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showContentView() {
            BaseActionBarActivity.this.mContentView.setVisibility(0);
            this.f23887a.setVisibility(8);
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            this.f23887a.setVisibility(0);
            BaseActionBarActivity.this.mContentView.setVisibility(8);
            this.f23887a.showTip1_Tip2_NextBtn(ResUtils.drawable(BaseActionBarActivity.this.mAct, "wallet_base_no_net"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(BaseActionBarActivity.this.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            this.f23887a.setVisibility(0);
            BaseActionBarActivity.this.mContentView.setVisibility(8);
            this.f23887a.showTip1_NextBtn(ResUtils.drawable(BaseActionBarActivity.this.mAct, "wallet_base_no_net"), ResUtils.getString(BaseActionBarActivity.this.mAct, "wallet_base_no_network"), ResUtils.getString(BaseActionBarActivity.this.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
        }
    }

    /* loaded from: classes5.dex */
    public interface IErrorViewDelegate {
        void showContentView();

        void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);

        void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);
    }

    private IErrorViewDelegate createErrorViewDelegate() {
        return new ErrorViewDelegate();
    }

    public void closeLoadingDialog() {
        WalletGlobalUtils.safeDismissDialog(this, 0);
    }

    public <T> T findViewByIdExt(int i) {
        return (T) findViewById(i);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public BdActionBar getBdActionBar() {
        return this.mBdActionBar;
    }

    public FrameLayout getContentLayout() {
        return this.mContentLayout;
    }

    public IErrorViewDelegate getErrorViewDelegate() {
        return this.mErrorViewDelegate;
    }

    public abstract void init(View view);

    public void initBdActionBar() {
        BdActionBar bdActionBar = this.mBdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActionBarActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BaseActionBarActivity.this.getActivity());
                    BaseActionBarActivity.this.onBackPressed();
                }
            });
        }
    }

    public boolean isStrEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    public abstract int onBindLayoutId();

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getApplicationContext(), "wallet_base_title_activity"));
        this.mBdActionBar = (BdActionBar) findViewByIdExt(ResUtils.id(getApplicationContext(), "bdactionbar"));
        this.mContentLayout = (FrameLayout) findViewByIdExt(ResUtils.id(getApplicationContext(), "content_frame_layout"));
        View inflate = LayoutInflater.from(this).inflate(onBindLayoutId(), (ViewGroup) null);
        this.mContentView = inflate;
        this.mContentLayout.addView(inflate);
        initBdActionBar();
        init(this.mContentLayout);
        this.mErrorViewDelegate = createErrorViewDelegate();
    }

    public void showLoadingDialog() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
    }

    public void showThemeDialog(CharSequence charSequence, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final PromptDialog promptDialog = new PromptDialog(this.mAct);
        promptDialog.setMessage(charSequence);
        promptDialog.setNegativeBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActionBarActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "wallet_varify_quick"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActionBarActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener3 = onClickListener2;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }
}
