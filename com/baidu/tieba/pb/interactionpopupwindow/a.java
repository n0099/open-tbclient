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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private AlertDialog bEB;
    private DialogInterface.OnCancelListener bEz;
    protected V hli;
    protected D hlj;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int bEo = -1;
    private boolean hlg = true;
    private boolean hlh = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hli = v;
        this.hlj = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.a(this.bEB, this.mPageContext.getPageActivity());
            return;
        }
        if (this.hlh) {
            this.bEB = new AlertDialog.Builder(this.mContext, d.k.search_dialog).create();
        } else {
            this.bEB = new AlertDialog.Builder(this.mContext).create();
        }
        this.bEB.setCanceledOnTouchOutside(aGy());
        this.bEB.setCancelable(aGz());
        this.bEB.setOnKeyListener(this.mOnKeyListener);
        if (this.bEz != null) {
            this.bEB.setOnCancelListener(this.bEz);
        }
        com.baidu.adp.lib.g.g.a(this.bEB, this.mPageContext.getPageActivity());
        if (this.bEB.getWindow().getDecorView().getParent() != null) {
            Window window = this.bEB.getWindow();
            if (this.bEo == -1) {
                this.bEo = 17;
            }
            window.setGravity(this.bEo);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int aaY = aaY();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (aaY * 2);
                } else {
                    attributes.width = s.widthPixels - (aaY * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.hli.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bc.a(this.hli.getViewGroup(), false, new bc.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.bc.a
                public boolean aA(View view) {
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
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.b(this.bEB, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.bEB != null) {
            return this.bEB.isShowing();
        }
        return false;
    }

    public a vZ(int i) {
        this.bEo = i;
        return this;
    }

    public a nb(boolean z) {
        this.hlh = z;
        return this;
    }

    public void a(D d) {
        if (this.hli != null) {
            this.hli.a(d);
        }
    }
}
