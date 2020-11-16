package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public abstract class a {
    private DialogInterface.OnDismissListener bAA;
    protected Activity bMo;
    private DialogInterface.OnCancelListener mCancelListenr;
    private AlertDialog mDialog;
    private View mView;
    protected TbPageContext oey;
    private boolean bAC = false;
    private boolean bAD = false;
    private int mDialogGravity = -1;

    protected abstract boolean Ra();

    protected abstract boolean Rb();

    protected abstract int getDialogMargin();

    protected abstract View getView();

    protected abstract void initData();

    public a(TbPageContext tbPageContext) {
        this.oey = tbPageContext;
        this.bMo = tbPageContext.getPageActivity();
    }

    public a(Activity activity) {
        this.bMo = activity;
    }

    public void show() {
        if (this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.bMo);
            return;
        }
        if (this.bAC) {
            if (this.bAD) {
                this.mDialog = new AlertDialog.Builder(this.bMo, a.i.sdk_search_dialog_from_bottom_in).create();
            } else {
                this.mDialog = new AlertDialog.Builder(this.bMo, a.i.sdk_search_dialog).create();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.bMo).create();
        }
        this.mDialog.setCanceledOnTouchOutside(Ra());
        this.mDialog.setCancelable(Rb());
        if (this.mCancelListenr != null) {
            this.mDialog.setOnCancelListener(this.mCancelListenr);
        }
        if (this.bAA != null) {
            this.mDialog.setOnDismissListener(this.bAA);
        }
        ShowUtil.showDialog(this.mDialog, this.bMo);
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
            DisplayMetrics screenSize = BdUtilHelper.getScreenSize(this.bMo);
            if (screenSize != null) {
                int dialogMargin = getDialogMargin();
                if (UtilHelper.getRealScreenOrientation(this.bMo) == 2) {
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
            ShowUtil.dismissDialog(this.mDialog, this.bMo);
        }
    }

    public a g(DialogInterface.OnDismissListener onDismissListener) {
        this.bAA = onDismissListener;
        return this;
    }

    public a MZ(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public a zo(boolean z) {
        this.bAC = z;
        return this;
    }

    public a zp(boolean z) {
        this.bAD = z;
        return this;
    }
}
