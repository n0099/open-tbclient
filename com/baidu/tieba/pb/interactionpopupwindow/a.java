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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener akE;
    private AlertDialog akG;
    private int aku = -1;
    private boolean fpH = true;
    protected V fpI;
    protected D fpJ;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fpI = v;
        this.fpJ = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.akG != null) {
            com.baidu.adp.lib.g.g.a(this.akG, this.mPageContext.getPageActivity());
            return;
        }
        this.akG = new AlertDialog.Builder(this.mContext).create();
        this.akG.setCanceledOnTouchOutside(XZ());
        this.akG.setCancelable(Ya());
        this.akG.setOnKeyListener(this.mOnKeyListener);
        if (this.akE != null) {
            this.akG.setOnCancelListener(this.akE);
        }
        com.baidu.adp.lib.g.g.a(this.akG, this.mPageContext.getPageActivity());
        if (this.akG.getWindow().getDecorView().getParent() != null) {
            Window window = this.akG.getWindow();
            if (this.aku == -1) {
                this.aku = 17;
            }
            window.setGravity(this.aku);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics p = l.p(this.mPageContext.getPageActivity());
            if (p != null) {
                int wZ = wZ();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = p.heightPixels - (wZ * 2);
                } else {
                    attributes.width = p.widthPixels - (wZ * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fpI.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fpI.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
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
        if (this.akG != null) {
            com.baidu.adp.lib.g.g.b(this.akG, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.akG != null) {
            return this.akG.isShowing();
        }
        return false;
    }

    public a qk(int i) {
        this.aku = i;
        return this;
    }

    public void a(D d) {
        if (this.fpI != null) {
            this.fpI.a(d);
        }
    }
}
