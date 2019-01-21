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
    private DialogInterface.OnCancelListener awU;
    private AlertDialog awW;
    protected V fUW;
    protected D fUX;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int awK = -1;
    private boolean fUU = true;
    private boolean fUV = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fUW = v;
        this.fUX = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.a(this.awW, this.mPageContext.getPageActivity());
            return;
        }
        if (this.fUV) {
            this.awW = new AlertDialog.Builder(this.mContext, e.k.search_dialog).create();
        } else {
            this.awW = new AlertDialog.Builder(this.mContext).create();
        }
        this.awW.setCanceledOnTouchOutside(afC());
        this.awW.setCancelable(afD());
        this.awW.setOnKeyListener(this.mOnKeyListener);
        if (this.awU != null) {
            this.awW.setOnCancelListener(this.awU);
        }
        com.baidu.adp.lib.g.g.a(this.awW, this.mPageContext.getPageActivity());
        if (this.awW.getWindow().getDecorView().getParent() != null) {
            Window window = this.awW.getWindow();
            if (this.awK == -1) {
                this.awK = 17;
            }
            window.setGravity(this.awK);
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
            window.setContentView(this.fUW.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fUW.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.b(this.awW, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.awW != null) {
            return this.awW.isShowing();
        }
        return false;
    }

    public a sr(int i) {
        this.awK = i;
        return this;
    }

    public a kB(boolean z) {
        this.fUV = z;
        return this;
    }

    public void a(D d) {
        if (this.fUW != null) {
            this.fUW.a(d);
        }
    }
}
