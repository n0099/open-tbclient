package com.baidu.tieba.pb.interactionpopupwindow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    protected V lHH;
    protected D lHI;
    private DialogInterface.OnCancelListener mCancelListenr;
    protected Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int mDialogGravity = -1;
    private boolean bKx = true;
    private boolean bKy = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.lHH = v;
        this.lHI = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.showDialog(this.mDialog, this.mPageContext.getPageActivity());
            return;
        }
        if (this.bKy) {
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.search_dialog).create();
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(UD());
        this.mDialog.setCancelable(UE());
        this.mDialog.setOnKeyListener(this.mOnKeyListener);
        if (this.mCancelListenr != null) {
            this.mDialog.setOnCancelListener(this.mCancelListenr);
        }
        com.baidu.adp.lib.f.g.showDialog(this.mDialog, this.mPageContext.getPageActivity());
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics screenSize = l.getScreenSize(this.mPageContext.getPageActivity());
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
            window.setContentView(this.lHH.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bg.a(this.lHH.getViewGroup(), false, new bg.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.bg.a
                public boolean bs(View view) {
                    if (view instanceof EditText) {
                        atomicBoolean.set(true);
                        return true;
                    }
                    return false;
                }
            });
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.lHH != null) {
            this.lHH.a(d);
        }
    }
}
