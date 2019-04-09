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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener bEF;
    private int bEu = -1;
    private boolean hkT = true;
    private boolean hkU = false;
    protected V hkV;
    protected D hkW;
    protected Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hkV = v;
        this.hkW = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.a(this.mDialog, this.mPageContext.getPageActivity());
            return;
        }
        if (this.hkU) {
            this.mDialog = new AlertDialog.Builder(this.mContext, d.k.search_dialog).create();
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(aGw());
        this.mDialog.setCancelable(aGx());
        this.mDialog.setOnKeyListener(this.mOnKeyListener);
        if (this.bEF != null) {
            this.mDialog.setOnCancelListener(this.bEF);
        }
        com.baidu.adp.lib.g.g.a(this.mDialog, this.mPageContext.getPageActivity());
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.bEu == -1) {
                this.bEu = 17;
            }
            window.setGravity(this.bEu);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int aaV = aaV();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (aaV * 2);
                } else {
                    attributes.width = s.widthPixels - (aaV * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.hkV.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bc.a(this.hkV.getViewGroup(), false, new bc.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.bc.a
                public boolean aA(View view) {
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
            com.baidu.adp.lib.g.g.b(this.mDialog, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public a vV(int i) {
        this.bEu = i;
        return this;
    }

    public a nb(boolean z) {
        this.hkU = z;
        return this;
    }

    public void a(D d) {
        if (this.hkV != null) {
            this.hkV.a(d);
        }
    }
}
