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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener awT;
    private AlertDialog awV;
    protected V fUV;
    protected D fUW;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int awJ = -1;
    private boolean fUT = true;
    private boolean fUU = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fUV = v;
        this.fUW = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.awV != null) {
            com.baidu.adp.lib.g.g.a(this.awV, this.mPageContext.getPageActivity());
            return;
        }
        if (this.fUU) {
            this.awV = new AlertDialog.Builder(this.mContext, e.k.search_dialog).create();
        } else {
            this.awV = new AlertDialog.Builder(this.mContext).create();
        }
        this.awV.setCanceledOnTouchOutside(afC());
        this.awV.setCancelable(afD());
        this.awV.setOnKeyListener(this.mOnKeyListener);
        if (this.awT != null) {
            this.awV.setOnCancelListener(this.awT);
        }
        com.baidu.adp.lib.g.g.a(this.awV, this.mPageContext.getPageActivity());
        if (this.awV.getWindow().getDecorView().getParent() != null) {
            Window window = this.awV.getWindow();
            if (this.awJ == -1) {
                this.awJ = 17;
            }
            window.setGravity(this.awJ);
            window.setBackgroundDrawableResource(e.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int BR = BR();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (BR * 2);
                } else {
                    attributes.width = s.widthPixels - (BR * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fUV.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fUV.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean H(View view) {
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
        if (this.awV != null) {
            com.baidu.adp.lib.g.g.b(this.awV, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.awV != null) {
            return this.awV.isShowing();
        }
        return false;
    }

    public a sr(int i) {
        this.awJ = i;
        return this;
    }

    public a kB(boolean z) {
        this.fUU = z;
        return this;
    }

    public void a(D d) {
        if (this.fUV != null) {
            this.fUV.a(d);
        }
    }
}
