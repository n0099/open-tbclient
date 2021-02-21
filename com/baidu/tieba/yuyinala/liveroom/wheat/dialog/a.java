package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public abstract class a {
    private DialogInterface.OnDismissListener bJu;
    private DialogInterface.OnCancelListener mCancelListenr;
    protected Activity mContext;
    private AlertDialog mDialog;
    private View mView;
    protected TbPageContext oGE;
    private boolean bJw = false;
    private boolean bJx = false;
    private int mDialogGravity = -1;

    protected abstract boolean Ss();

    protected abstract boolean St();

    protected abstract int getDialogMargin();

    protected abstract View getView();

    protected abstract void initData();

    public a(TbPageContext tbPageContext) {
        this.oGE = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public a(Activity activity) {
        this.mContext = activity;
    }

    public void show() {
        if (this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mContext);
            return;
        }
        if (this.bJw) {
            if (this.bJx) {
                this.mDialog = new AlertDialog.Builder(this.mContext, a.i.sdk_search_dialog_from_bottom_in).create();
            } else {
                this.mDialog = new AlertDialog.Builder(this.mContext, a.i.sdk_search_dialog).create();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(Ss());
        this.mDialog.setCancelable(St());
        if (this.mCancelListenr != null) {
            this.mDialog.setOnCancelListener(this.mCancelListenr);
        }
        if (this.bJu != null) {
            this.mDialog.setOnDismissListener(this.bJu);
        }
        ShowUtil.showDialog(this.mDialog, this.mContext);
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics screenSize = BdUtilHelper.getScreenSize(this.mContext);
            if (screenSize != null) {
                int dialogMargin = getDialogMargin();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = screenSize.heightPixels - (dialogMargin * 2);
                } else {
                    attributes.width = screenSize.widthPixels - (dialogMargin * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            this.mView = getView();
            window.setContentView(this.mView);
            initData();
        }
    }

    @Nullable
    public final <T extends View> T findViewById(@IdRes int i) {
        if (this.mView == null || i == -1) {
            return null;
        }
        return (T) this.mView.findViewById(i);
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public void dismiss() {
        if (this.mDialog != null) {
            ShowUtil.dismissDialog(this.mDialog, this.mContext);
        }
    }

    public a g(DialogInterface.OnDismissListener onDismissListener) {
        this.bJu = onDismissListener;
        return this;
    }

    public a Mx(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public a Ai(boolean z) {
        this.bJw = z;
        return this;
    }

    public a Aj(boolean z) {
        this.bJx = z;
        return this;
    }
}
