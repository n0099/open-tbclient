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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener akC;
    private AlertDialog akE;
    private int aks = -1;
    private boolean ftE = true;
    protected V ftF;
    protected D ftG;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ftF = v;
        this.ftG = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.a(this.akE, this.mPageContext.getPageActivity());
            return;
        }
        this.akE = new AlertDialog.Builder(this.mContext).create();
        this.akE.setCanceledOnTouchOutside(YR());
        this.akE.setCancelable(YS());
        this.akE.setOnKeyListener(this.mOnKeyListener);
        if (this.akC != null) {
            this.akE.setOnCancelListener(this.akC);
        }
        com.baidu.adp.lib.g.g.a(this.akE, this.mPageContext.getPageActivity());
        if (this.akE.getWindow().getDecorView().getParent() != null) {
            Window window = this.akE.getWindow();
            if (this.aks == -1) {
                this.aks = 17;
            }
            window.setGravity(this.aks);
            window.setBackgroundDrawableResource(f.C0146f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int xd = xd();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (xd * 2);
                } else {
                    attributes.width = o.widthPixels - (xd * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.ftF.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.ftF.getViewGroup(), false, new bb.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.b(this.akE, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.akE != null) {
            return this.akE.isShowing();
        }
        return false;
    }

    public a qo(int i) {
        this.aks = i;
        return this;
    }

    public void a(D d) {
        if (this.ftF != null) {
            this.ftF.a(d);
        }
    }
}
