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
    private DialogInterface.OnCancelListener aPM;
    private AlertDialog aPN;
    protected V fEH;
    protected D fEI;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int aPC = -1;
    private boolean fEG = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fEH = v;
        this.fEI = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aPN != null) {
            com.baidu.adp.lib.g.g.a(this.aPN, this.mPageContext.getPageActivity());
            return;
        }
        this.aPN = new AlertDialog.Builder(this.mContext).create();
        this.aPN.setCanceledOnTouchOutside(aZF());
        this.aPN.setCancelable(aZG());
        this.aPN.setOnKeyListener(this.mOnKeyListener);
        if (this.aPM != null) {
            this.aPN.setOnCancelListener(this.aPM);
        }
        com.baidu.adp.lib.g.g.a(this.aPN, this.mPageContext.getPageActivity());
        if (this.aPN.getWindow().getDecorView().getParent() != null) {
            Window window = this.aPN.getWindow();
            if (this.aPC == -1) {
                this.aPC = 17;
            }
            window.setGravity(this.aPC);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int Az = Az();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (Az * 2);
                } else {
                    attributes.width = o.widthPixels - (Az * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fEH.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.fEH.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.aPN != null) {
            com.baidu.adp.lib.g.g.b(this.aPN, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.fEH != null) {
            this.fEH.a(d);
        }
    }
}
