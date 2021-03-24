package com.baidu.wallet.core.beans;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdContextMenuView;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {
    public static final String TAG = "BaseActivity";
    public BeanActivity mAct;
    public Handler mHandler = null;

    /* loaded from: classes5.dex */
    public class ActionBarMenu extends BdMenu {
        public static final int MENU_ITEM_INDEX_LOGOUT = 35;

        public ActionBarMenu(View view) {
            super(view);
            add(35, ResUtils.string(this.mContext, "bd_wallet_logout"));
            setDismissOnClick(true);
        }

        @Override // com.baidu.wallet.base.widget.BdMenu
        public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
            ((BdContextMenuView) view).layoutMenu(list);
        }

        @Override // com.baidu.wallet.base.widget.BdMenu
        public View getMenuView(Context context) {
            return new BdContextMenuView(context);
        }

        @Override // com.baidu.wallet.base.widget.BdMenu
        public void showMenu(PopupWindow popupWindow) {
            popupWindow.showAsDropDown(this.mViewToAttach);
        }
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(getMainLooper());
        }
        return this.mHandler;
    }

    public BdActionBar getBdActionBar() {
        return (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
    }

    public void handleFailure(int i, int i2, String str) {
        if (i2 == 5003) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
            AccountManager.getInstance(getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (i2 == -2) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i2 == -3) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i2 == -4) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        } else if (i2 == -8) {
            WalletGlobalUtils.safeShowDialog(this, 11, "");
        } else {
            this.mDialogMsg = str;
            if (TextUtils.isEmpty(str)) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "fp_get_data_fail");
            }
            GlobalUtils.toast(getActivity(), this.mDialogMsg);
        }
    }

    public abstract void handleResponse(int i, Object obj, String str);

    public void initActionBar(String str) {
        initActionBarWithActualTitleValue(ResUtils.getString(getActivity(), str));
    }

    public void initActionBarWithActualTitleValue(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.core.beans.BeanActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
                    BeanActivity.this.onBackPressed();
                }
            });
        }
    }

    public void initHomeActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(getActivity(), str));
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.core.beans.BeanActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BeanActivity.this.getActivity());
                    BeanActivity.this.onBackPressed();
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i, final int i2, final String str) {
        LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i + ", err code = " + i2 + ", err msg = " + str);
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.core.beans.BeanActivity.4
            @Override // java.lang.Runnable
            public void run() {
                BeanActivity beanActivity = BeanActivity.this;
                if (beanActivity.mAct != null) {
                    beanActivity.handleFailure(i, i2, str);
                }
            }
        });
    }

    public void onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        handleFailure(i, i2, str);
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i, final Object obj, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.core.beans.BeanActivity.3
            @Override // java.lang.Runnable
            public void run() {
                BeanActivity beanActivity = BeanActivity.this;
                if (beanActivity.mAct != null) {
                    beanActivity.handleResponse(i, obj, str);
                }
            }
        });
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAct = this;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
    }
}
