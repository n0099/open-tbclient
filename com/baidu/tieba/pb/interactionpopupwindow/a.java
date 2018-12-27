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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener awr;
    private AlertDialog awt;
    protected V fTY;
    protected D fTZ;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int awh = -1;
    private boolean fTW = true;
    private boolean fTX = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fTY = v;
        this.fTZ = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.awt != null) {
            com.baidu.adp.lib.g.g.a(this.awt, this.mPageContext.getPageActivity());
            return;
        }
        if (this.fTX) {
            this.awt = new AlertDialog.Builder(this.mContext, e.k.search_dialog).create();
        } else {
            this.awt = new AlertDialog.Builder(this.mContext).create();
        }
        this.awt.setCanceledOnTouchOutside(aff());
        this.awt.setCancelable(afg());
        this.awt.setOnKeyListener(this.mOnKeyListener);
        if (this.awr != null) {
            this.awt.setOnCancelListener(this.awr);
        }
        com.baidu.adp.lib.g.g.a(this.awt, this.mPageContext.getPageActivity());
        if (this.awt.getWindow().getDecorView().getParent() != null) {
            Window window = this.awt.getWindow();
            if (this.awh == -1) {
                this.awh = 17;
            }
            window.setGravity(this.awh);
            window.setBackgroundDrawableResource(e.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int BE = BE();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (BE * 2);
                } else {
                    attributes.width = s.widthPixels - (BE * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fTY.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fTY.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean H(View view) {
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
        if (this.awt != null) {
            com.baidu.adp.lib.g.g.b(this.awt, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.awt != null) {
            return this.awt.isShowing();
        }
        return false;
    }

    public a sn(int i) {
        this.awh = i;
        return this;
    }

    public a kB(boolean z) {
        this.fTX = z;
        return this;
    }

    public void a(D d) {
        if (this.fTY != null) {
            this.fTY.a(d);
        }
    }
}
