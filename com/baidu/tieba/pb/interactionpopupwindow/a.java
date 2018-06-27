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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener ald;
    private AlertDialog alf;
    protected V ftB;
    protected D ftC;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int akT = -1;
    private boolean ftA = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ftB = v;
        this.ftC = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.a(this.alf, this.mPageContext.getPageActivity());
            return;
        }
        this.alf = new AlertDialog.Builder(this.mContext).create();
        this.alf.setCanceledOnTouchOutside(YE());
        this.alf.setCancelable(YF());
        this.alf.setOnKeyListener(this.mOnKeyListener);
        if (this.ald != null) {
            this.alf.setOnCancelListener(this.ald);
        }
        com.baidu.adp.lib.g.g.a(this.alf, this.mPageContext.getPageActivity());
        if (this.alf.getWindow().getDecorView().getParent() != null) {
            Window window = this.alf.getWindow();
            if (this.akT == -1) {
                this.akT = 17;
            }
            window.setGravity(this.akT);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics p = l.p(this.mPageContext.getPageActivity());
            if (p != null) {
                int xm = xm();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = p.heightPixels - (xm * 2);
                } else {
                    attributes.width = p.widthPixels - (xm * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.ftB.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.ftB.getViewGroup(), false, new bb.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.bb.a
                public boolean x(View view) {
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
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.b(this.alf, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.alf != null) {
            return this.alf.isShowing();
        }
        return false;
    }

    public a qr(int i) {
        this.akT = i;
        return this;
    }

    public void a(D d) {
        if (this.ftB != null) {
            this.ftB.a(d);
        }
    }
}
