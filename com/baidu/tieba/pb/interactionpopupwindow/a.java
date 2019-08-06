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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener bNf;
    protected V hJF;
    protected D hJG;
    protected Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int bMT = -1;
    private boolean hJD = true;
    private boolean hJE = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hJF = v;
        this.hJG = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.a(this.mDialog, this.mPageContext.getPageActivity());
            return;
        }
        if (this.hJE) {
            this.mDialog = new AlertDialog.Builder(this.mContext, R.style.search_dialog).create();
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(aOx());
        this.mDialog.setCancelable(aOy());
        this.mDialog.setOnKeyListener(this.mOnKeyListener);
        if (this.bNf != null) {
            this.mDialog.setOnCancelListener(this.bNf);
        }
        com.baidu.adp.lib.g.g.a(this.mDialog, this.mPageContext.getPageActivity());
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.bMT == -1) {
                this.bMT = 17;
            }
            window.setGravity(this.bMT);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics v = l.v(this.mPageContext.getPageActivity());
            if (v != null) {
                int agJ = agJ();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = v.heightPixels - (agJ * 2);
                } else {
                    attributes.width = v.widthPixels - (agJ * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.hJF.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bd.a(this.hJF.getViewGroup(), false, new bd.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.bd.a
                public boolean aI(View view) {
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

    public a xH(int i) {
        this.bMT = i;
        return this;
    }

    public a of(boolean z) {
        this.hJE = z;
        return this;
    }

    public void a(D d) {
        if (this.hJF != null) {
            this.hJF.a(d);
        }
    }
}
