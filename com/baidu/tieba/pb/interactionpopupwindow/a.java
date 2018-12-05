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
    private DialogInterface.OnCancelListener awq;
    private AlertDialog aws;
    protected V fRg;
    protected D fRh;
    protected Context mContext;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int awg = -1;
    private boolean fRe = true;
    private boolean fRf = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fRg = v;
        this.fRh = d;
        a(d);
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public void show() {
        if (this.aws != null) {
            com.baidu.adp.lib.g.g.a(this.aws, this.mPageContext.getPageActivity());
            return;
        }
        if (this.fRf) {
            this.aws = new AlertDialog.Builder(this.mContext, e.k.search_dialog).create();
        } else {
            this.aws = new AlertDialog.Builder(this.mContext).create();
        }
        this.aws.setCanceledOnTouchOutside(aeW());
        this.aws.setCancelable(aeX());
        this.aws.setOnKeyListener(this.mOnKeyListener);
        if (this.awq != null) {
            this.aws.setOnCancelListener(this.awq);
        }
        com.baidu.adp.lib.g.g.a(this.aws, this.mPageContext.getPageActivity());
        if (this.aws.getWindow().getDecorView().getParent() != null) {
            Window window = this.aws.getWindow();
            if (this.awg == -1) {
                this.awg = 17;
            }
            window.setGravity(this.awg);
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
            window.setContentView(this.fRg.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.fRg.getViewGroup(), false, new ba.a() { // from class: com.baidu.tieba.pb.interactionpopupwindow.a.1
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
        if (this.aws != null) {
            com.baidu.adp.lib.g.g.b(this.aws, this.mPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean isShowing() {
        if (this.aws != null) {
            return this.aws.isShowing();
        }
        return false;
    }

    public a sa(int i) {
        this.awg = i;
        return this;
    }

    public a ky(boolean z) {
        this.fRf = z;
        return this;
    }

    public void a(D d) {
        if (this.fRg != null) {
            this.fRg.a(d);
        }
    }
}
