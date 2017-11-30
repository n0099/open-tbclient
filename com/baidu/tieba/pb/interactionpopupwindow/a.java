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
    private DialogInterface.OnCancelListener abv;
    private DialogInterface.OnKeyListener abw;
    private AlertDialog abx;
    protected V ePy;
    protected D ePz;
    protected Context mContext;
    protected TbPageContext mPageContext;
    private int abl = -1;
    private boolean ePx = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ePy = v;
        this.ePz = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.abx != null) {
            com.baidu.adp.lib.g.g.a(this.abx, this.mPageContext.getPageActivity());
            return;
        }
        this.abx = new AlertDialog.Builder(this.mContext).create();
        this.abx.setCanceledOnTouchOutside(aSf());
        this.abx.setCancelable(aSg());
        this.abx.setOnKeyListener(this.abw);
        if (this.abv != null) {
            this.abx.setOnCancelListener(this.abv);
        }
        com.baidu.adp.lib.g.g.a(this.abx, this.mPageContext.getPageActivity());
        if (this.abx.getWindow().getDecorView().getParent() != null) {
            Window window = this.abx.getWindow();
            if (this.abl == -1) {
                this.abl = 17;
            }
            window.setGravity(this.abl);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics o = l.o(this.mPageContext.getPageActivity());
            if (o != null) {
                int tj = tj();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = o.heightPixels - (tj * 2);
                } else {
                    attributes.width = o.widthPixels - (tj * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.ePy.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.ePy.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.abx != null) {
            com.baidu.adp.lib.g.g.b(this.abx, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.ePy != null) {
            this.ePy.a(d);
        }
    }
}
