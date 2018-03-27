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
    private DialogInterface.OnCancelListener aRd;
    private AlertDialog aRe;
    protected V fIE;
    protected D fIF;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int aQT = -1;
    private boolean fID = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fIE = v;
        this.fIF = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aRe != null) {
            com.baidu.adp.lib.g.g.a(this.aRe, this.mPageContext.getPageActivity());
            return;
        }
        this.aRe = new AlertDialog.Builder(this.mContext).create();
        this.aRe.setCanceledOnTouchOutside(bbr());
        this.aRe.setCancelable(bbs());
        this.aRe.setOnKeyListener(this.mOnKeyListener);
        if (this.aRd != null) {
            this.aRe.setOnCancelListener(this.aRd);
        }
        com.baidu.adp.lib.g.g.a(this.aRe, this.mPageContext.getPageActivity());
        if (this.aRe.getWindow().getDecorView().getParent() != null) {
            Window window = this.aRe.getWindow();
            if (this.aQT == -1) {
                this.aQT = 17;
            }
            window.setGravity(this.aQT);
            window.setBackgroundDrawableResource(d.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.mPageContext.getPageActivity());
            if (q != null) {
                int AU = AU();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = q.heightPixels - (AU * 2);
                } else {
                    attributes.width = q.widthPixels - (AU * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fIE.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ay.a(this.fIE.getViewGroup(), false, new ay.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.aRe != null) {
            com.baidu.adp.lib.g.g.b(this.aRe, this.mPageContext.getPageActivity());
        }
    }

    public void a(D d) {
        if (this.fIE != null) {
            this.fIE.a(d);
        }
    }
}
