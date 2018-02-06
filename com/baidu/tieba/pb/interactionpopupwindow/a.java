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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    private DialogInterface.OnCancelListener aRm;
    private AlertDialog aRn;
    protected D fIA;
    protected V fIz;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int aRc = -1;
    private boolean fIy = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fIz = v;
        this.fIA = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.a(this.aRn, this.mPageContext.getPageActivity());
            return;
        }
        this.aRn = new AlertDialog.Builder(this.mContext).create();
        this.aRn.setCanceledOnTouchOutside(bbr());
        this.aRn.setCancelable(bbs());
        this.aRn.setOnKeyListener(this.mOnKeyListener);
        if (this.aRm != null) {
            this.aRn.setOnCancelListener(this.aRm);
        }
        com.baidu.adp.lib.g.g.a(this.aRn, this.mPageContext.getPageActivity());
        if (this.aRn.getWindow().getDecorView().getParent() != null) {
            Window window = this.aRn.getWindow();
            if (this.aRc == -1) {
                this.aRc = 17;
            }
            window.setGravity(this.aRc);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.mPageContext.getPageActivity());
            if (q != null) {
                int AT = AT();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = q.heightPixels - (AT * 2);
                } else {
                    attributes.width = q.widthPixels - (AT * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fIz.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ay.a(this.fIz.getViewGroup(), false, new ay.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.tbadk.core.util.ay.a
                public boolean aP(View view) {
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
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.b(this.aRn, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.fIz != null) {
            this.fIz.a(d);
        }
    }
}
