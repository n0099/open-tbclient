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
    private AlertDialog acB;
    private DialogInterface.OnCancelListener acz;
    protected V fdh;
    protected D fdi;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int acp = -1;
    private boolean fdg = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fdh = v;
        this.fdi = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.acB != null) {
            com.baidu.adp.lib.g.g.a(this.acB, this.mPageContext.getPageActivity());
            return;
        }
        this.acB = new AlertDialog.Builder(this.mContext).create();
        this.acB.setCanceledOnTouchOutside(Ux());
        this.acB.setCancelable(Uy());
        this.acB.setOnKeyListener(this.mOnKeyListener);
        if (this.acz != null) {
            this.acB.setOnCancelListener(this.acz);
        }
        com.baidu.adp.lib.g.g.a(this.acB, this.mPageContext.getPageActivity());
        if (this.acB.getWindow().getDecorView().getParent() != null) {
            Window window = this.acB.getWindow();
            if (this.acp == -1) {
                this.acp = 17;
            }
            window.setGravity(this.acp);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.mPageContext.getPageActivity());
            if (q != null) {
                int tC = tC();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = q.heightPixels - (tC * 2);
                } else {
                    attributes.width = q.widthPixels - (tC * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fdh.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            az.a(this.fdh.getViewGroup(), false, new az.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.acB != null) {
            com.baidu.adp.lib.g.g.b(this.acB, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.acB != null) {
            return this.acB.isShowing();
        }
        return false;
    }

    public a qa(int i) {
        this.acp = i;
        return this;
    }

    public void a(D d) {
        if (this.fdh != null) {
            this.fdh.a(d);
        }
    }
}
