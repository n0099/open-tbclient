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
    private DialogInterface.OnCancelListener asQ;
    private AlertDialog asS;
    protected V fKq;
    protected D fKr;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int asG = -1;
    private boolean fKo = true;
    private boolean fKp = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fKq = v;
        this.fKr = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.asS != null) {
            com.baidu.adp.lib.g.g.a(this.asS, this.mPageContext.getPageActivity());
            return;
        }
        if (this.fKp) {
            this.asS = new AlertDialog.Builder(this.mContext, e.k.search_dialog).create();
        } else {
            this.asS = new AlertDialog.Builder(this.mContext).create();
        }
        this.asS.setCanceledOnTouchOutside(adQ());
        this.asS.setCancelable(adR());
        this.asS.setOnKeyListener(this.mOnKeyListener);
        if (this.asQ != null) {
            this.asS.setOnCancelListener(this.asQ);
        }
        com.baidu.adp.lib.g.g.a(this.asS, this.mPageContext.getPageActivity());
        if (this.asS.getWindow().getDecorView().getParent() != null) {
            Window window = this.asS.getWindow();
            if (this.asG == -1) {
                this.asG = 17;
            }
            window.setGravity(this.asG);
            window.setBackgroundDrawableResource(e.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics s = l.s(this.mPageContext.getPageActivity());
            if (s != null) {
                int AA = AA();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = s.heightPixels - (AA * 2);
                } else {
                    attributes.width = s.widthPixels - (AA * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.fKq.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fKq.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.asS != null) {
            com.baidu.adp.lib.g.g.b(this.asS, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.asS != null) {
            return this.asS.isShowing();
        }
        return false;
    }

    public a rG(int i) {
        this.asG = i;
        return this;
    }

    public a kv(boolean z) {
        this.fKp = z;
        return this;
    }

    public void a(D d) {
        if (this.fKq != null) {
            this.fKq.a(d);
        }
    }
}
