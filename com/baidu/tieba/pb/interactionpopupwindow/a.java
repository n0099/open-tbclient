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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener aPN;
    private AlertDialog aPO;
    protected V fDh;
    protected D fDi;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int aPD = -1;
    private boolean fDg = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fDh = v;
        this.fDi = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.a(this.aPO, this.mPageContext.getPageActivity());
            return;
        }
        this.aPO = new AlertDialog.Builder(this.mContext).create();
        this.aPO.setCanceledOnTouchOutside(aZB());
        this.aPO.setCancelable(aZC());
        this.aPO.setOnKeyListener(this.mOnKeyListener);
        if (this.aPN != null) {
            this.aPO.setOnCancelListener(this.aPN);
        }
        com.baidu.adp.lib.g.g.a(this.aPO, this.mPageContext.getPageActivity());
        if (this.aPO.getWindow().getDecorView().getParent() != null) {
            Window window = this.aPO.getWindow();
            if (this.aPD == -1) {
                this.aPD = 17;
            }
            window.setGravity(this.aPD);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int AH = AH();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (AH * 2);
                } else {
                    attributes.width = o.widthPixels - (AH * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fDh.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.fDh.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ax.a
                public boolean aP(View view) {
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
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.b(this.aPO, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.fDh != null) {
            this.fDh.a(d);
        }
    }
}
