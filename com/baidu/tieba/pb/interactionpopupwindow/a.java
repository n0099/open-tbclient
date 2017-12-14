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
    private DialogInterface.OnCancelListener abo;
    private DialogInterface.OnKeyListener abp;
    private AlertDialog abq;
    protected V eQB;
    protected D eQC;
    protected Context mContext;
    protected TbPageContext mPageContext;
    private int abf = -1;
    private boolean eQA = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eQB = v;
        this.eQC = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.abq != null) {
            com.baidu.adp.lib.g.g.a(this.abq, this.mPageContext.getPageActivity());
            return;
        }
        this.abq = new AlertDialog.Builder(this.mContext).create();
        this.abq.setCanceledOnTouchOutside(aSo());
        this.abq.setCancelable(aSp());
        this.abq.setOnKeyListener(this.abp);
        if (this.abo != null) {
            this.abq.setOnCancelListener(this.abo);
        }
        com.baidu.adp.lib.g.g.a(this.abq, this.mPageContext.getPageActivity());
        if (this.abq.getWindow().getDecorView().getParent() != null) {
            Window window = this.abq.getWindow();
            if (this.abf == -1) {
                this.abf = 17;
            }
            window.setGravity(this.abf);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int tg = tg();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (tg * 2);
                } else {
                    attributes.width = o.widthPixels - (tg * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.eQB.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.eQB.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ax.a
                public boolean w(View view) {
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
        if (this.abq != null) {
            com.baidu.adp.lib.g.g.b(this.abq, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.eQB != null) {
            this.eQB.a(d);
        }
    }
}
