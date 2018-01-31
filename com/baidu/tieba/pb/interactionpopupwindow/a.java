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
    private DialogInterface.OnCancelListener aPP;
    private AlertDialog aPQ;
    protected V fFc;
    protected D fFd;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int aPF = -1;
    private boolean fFb = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fFc = v;
        this.fFd = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aPQ != null) {
            com.baidu.adp.lib.g.g.a(this.aPQ, this.mPageContext.getPageActivity());
            return;
        }
        this.aPQ = new AlertDialog.Builder(this.mContext).create();
        this.aPQ.setCanceledOnTouchOutside(aZK());
        this.aPQ.setCancelable(aZL());
        this.aPQ.setOnKeyListener(this.mOnKeyListener);
        if (this.aPP != null) {
            this.aPQ.setOnCancelListener(this.aPP);
        }
        com.baidu.adp.lib.g.g.a(this.aPQ, this.mPageContext.getPageActivity());
        if (this.aPQ.getWindow().getDecorView().getParent() != null) {
            Window window = this.aPQ.getWindow();
            if (this.aPF == -1) {
                this.aPF = 17;
            }
            window.setGravity(this.aPF);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int AA = AA();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (AA * 2);
                } else {
                    attributes.width = o.widthPixels - (AA * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fFc.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.fFc.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.aPQ != null) {
            com.baidu.adp.lib.g.g.b(this.aPQ, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.fFc != null) {
            this.fFc.a(d);
        }
    }
}
