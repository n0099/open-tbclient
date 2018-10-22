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
    private DialogInterface.OnCancelListener asd;
    private AlertDialog asf;
    protected V fIR;
    protected D fIS;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int arT = -1;
    private boolean fIQ = true;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fIR = v;
        this.fIS = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.asf != null) {
            com.baidu.adp.lib.g.g.a(this.asf, this.mPageContext.getPageActivity());
            return;
        }
        this.asf = new AlertDialog.Builder(this.mContext).create();
        this.asf.setCanceledOnTouchOutside(aem());
        this.asf.setCancelable(aen());
        this.asf.setOnKeyListener(this.mOnKeyListener);
        if (this.asd != null) {
            this.asf.setOnCancelListener(this.asd);
        }
        com.baidu.adp.lib.g.g.a(this.asf, this.mPageContext.getPageActivity());
        if (this.asf.getWindow().getDecorView().getParent() != null) {
            Window window = this.asf.getWindow();
            if (this.arT == -1) {
                this.arT = 17;
            }
            window.setGravity(this.arT);
            window.setBackgroundDrawableResource(e.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int At = At();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (At * 2);
                } else {
                    attributes.width = s.widthPixels - (At * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fIR.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fIR.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.asf != null) {
            com.baidu.adp.lib.g.g.b(this.asf, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.asf != null) {
            return this.asf.isShowing();
        }
        return false;
    }

    public a rn(int i) {
        this.arT = i;
        return this;
    }

    public void a(D d) {
        if (this.fIR != null) {
            this.fIR.a(d);
        }
    }
}
