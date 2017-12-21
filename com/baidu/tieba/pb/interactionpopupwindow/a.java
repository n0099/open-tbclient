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
    private DialogInterface.OnCancelListener abr;
    private DialogInterface.OnKeyListener abt;
    private AlertDialog abu;
    protected V eQG;
    protected D eQH;
    protected Context mContext;
    protected TbPageContext mPageContext;
    private int abi = -1;
    private boolean eQF = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eQG = v;
        this.eQH = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.abu != null) {
            com.baidu.adp.lib.g.g.a(this.abu, this.mPageContext.getPageActivity());
            return;
        }
        this.abu = new AlertDialog.Builder(this.mContext).create();
        this.abu.setCanceledOnTouchOutside(aSo());
        this.abu.setCancelable(aSp());
        this.abu.setOnKeyListener(this.abt);
        if (this.abr != null) {
            this.abu.setOnCancelListener(this.abr);
        }
        com.baidu.adp.lib.g.g.a(this.abu, this.mPageContext.getPageActivity());
        if (this.abu.getWindow().getDecorView().getParent() != null) {
            Window window = this.abu.getWindow();
            if (this.abi == -1) {
                this.abi = 17;
            }
            window.setGravity(this.abi);
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
            window.setContentView(this.eQG.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ax.a(this.eQG.getViewGroup(), false, new ax.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.abu != null) {
            com.baidu.adp.lib.g.g.b(this.abu, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.eQG != null) {
            this.eQG.a(d);
        }
    }
}
