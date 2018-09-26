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
    private DialogInterface.OnCancelListener ani;
    private AlertDialog ank;
    protected V fBo;
    protected D fBp;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int amY = -1;
    private boolean fBn = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fBo = v;
        this.fBp = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.a(this.ank, this.mPageContext.getPageActivity());
            return;
        }
        this.ank = new AlertDialog.Builder(this.mContext).create();
        this.ank.setCanceledOnTouchOutside(aaE());
        this.ank.setCancelable(aaF());
        this.ank.setOnKeyListener(this.mOnKeyListener);
        if (this.ani != null) {
            this.ank.setOnCancelListener(this.ani);
        }
        com.baidu.adp.lib.g.g.a(this.ank, this.mPageContext.getPageActivity());
        if (this.ank.getWindow().getDecorView().getParent() != null) {
            Window window = this.ank.getWindow();
            if (this.amY == -1) {
                this.amY = 17;
            }
            window.setGravity(this.amY);
            window.setBackgroundDrawableResource(e.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int yk = yk();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (yk * 2);
                } else {
                    attributes.width = s.widthPixels - (yk * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fBo.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fBo.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.b(this.ank, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.ank != null) {
            return this.ank.isShowing();
        }
        return false;
    }

    public a qP(int i) {
        this.amY = i;
        return this;
    }

    public void a(D d) {
        if (this.fBo != null) {
            this.fBo.a(d);
        }
    }
}
