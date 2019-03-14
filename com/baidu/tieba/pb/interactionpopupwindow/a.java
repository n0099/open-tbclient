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
    private DialogInterface.OnCancelListener bEB;
    private AlertDialog bED;
    private int bEq = -1;
    private boolean hlf = true;
    private boolean hlg = false;
    protected V hlh;
    protected D hli;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hlh = v;
        this.hli = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.bED != null) {
            com.baidu.adp.lib.g.g.a(this.bED, this.mPageContext.getPageActivity());
            return;
        }
        if (this.hlg) {
            this.bED = new AlertDialog.Builder(this.mContext, d.k.search_dialog).create();
        } else {
            this.bED = new AlertDialog.Builder(this.mContext).create();
        }
        this.bED.setCanceledOnTouchOutside(aGx());
        this.bED.setCancelable(aGy());
        this.bED.setOnKeyListener(this.mOnKeyListener);
        if (this.bEB != null) {
            this.bED.setOnCancelListener(this.bEB);
        }
        com.baidu.adp.lib.g.g.a(this.bED, this.mPageContext.getPageActivity());
        if (this.bED.getWindow().getDecorView().getParent() != null) {
            Window window = this.bED.getWindow();
            if (this.bEq == -1) {
                this.bEq = 17;
            }
            window.setGravity(this.bEq);
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
            window.setContentView(this.hlh.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bc.a(this.hlh.getViewGroup(), false, new bc.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.bED != null) {
            com.baidu.adp.lib.g.g.b(this.bED, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.bED != null) {
            return this.bED.isShowing();
        }
        return false;
    }

    public a vZ(int i) {
        this.bEq = i;
        return this;
    }

    public a nb(boolean z) {
        this.hlg = z;
        return this;
    }

    public void a(D d) {
        if (this.hlh != null) {
            this.hlh.a(d);
        }
    }
}
