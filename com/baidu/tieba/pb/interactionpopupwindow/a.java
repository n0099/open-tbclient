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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener acA;
    private AlertDialog acC;
    private int acq = -1;
    private boolean fek = true;
    protected V fel;
    protected D fem;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fel = v;
        this.fem = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.a(this.acC, this.mPageContext.getPageActivity());
            return;
        }
        this.acC = new AlertDialog.Builder(this.mContext).create();
        this.acC.setCanceledOnTouchOutside(UA());
        this.acC.setCancelable(UB());
        this.acC.setOnKeyListener(this.mOnKeyListener);
        if (this.acA != null) {
            this.acC.setOnCancelListener(this.acA);
        }
        com.baidu.adp.lib.g.g.a(this.acC, this.mPageContext.getPageActivity());
        if (this.acC.getWindow().getDecorView().getParent() != null) {
            Window window = this.acC.getWindow();
            if (this.acq == -1) {
                this.acq = 17;
            }
            window.setGravity(this.acq);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.mPageContext.getPageActivity());
            if (q != null) {
                int tB = tB();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = q.heightPixels - (tB * 2);
                } else {
                    attributes.width = q.widthPixels - (tB * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fel.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            az.a(this.fel.getViewGroup(), false, new az.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.az.a
                public boolean x(View view2) {
                    if (view2 instanceof EditText) {
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
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.b(this.acC, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.acC != null) {
            return this.acC.isShowing();
        }
        return false;
    }

    public a pY(int i) {
        this.acq = i;
        return this;
    }

    public void a(D d) {
        if (this.fel != null) {
            this.fel.a(d);
        }
    }
}
