package com.baidu.tieba.write.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bs;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private String Rb;
    private String Rc;
    private String Rd;
    private DialogInterface.OnCancelListener Rh;
    private i cwo;
    private i cwp;
    private i cwq;
    private DialogInterface.OnKeyListener cwr;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Ra = -1;
    private int RF = -1;
    private int cwm = u.btn_blue_bg;
    private int cwn = s.cp_cont_g;
    private boolean Rj = false;
    private boolean Rk = true;

    public f iX(int i) {
        this.RF = i;
        return this;
    }

    public f iY(int i) {
        this.cwm = i;
        return this;
    }

    public f iZ(int i) {
        this.cwn = i;
        return this;
    }

    public f a(DialogInterface.OnKeyListener onKeyListener) {
        this.cwr = onKeyListener;
        return this;
    }

    public f ja(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public f a(int i, i iVar) {
        if (this.mActivity != null) {
            this.Rb = this.mActivity.getResources().getString(i);
            this.cwo = iVar;
        }
        return this;
    }

    public f b(int i, i iVar) {
        if (this.mActivity != null) {
            this.Rc = this.mActivity.getResources().getString(i);
            this.cwp = iVar;
        }
        return this;
    }

    public f fh(boolean z) {
        this.Rk = z;
        return this;
    }

    public f(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(activity, w.dialog_icon_bdalert, null);
    }

    public f f(j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Rj) {
            this.Rj = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(v.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(v.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(v.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(v.message);
            Button button = (Button) this.mRootView.findViewById(v.yes);
            ba.i((View) button, this.cwm);
            ba.b(button, this.cwn, 3);
            Button button2 = (Button) this.mRootView.findViewById(v.no);
            Button button3 = (Button) this.mRootView.findViewById(v.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.RF != -1) {
                ba.c(imageView, this.RF);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Rb)) {
                z = false;
            } else {
                button.setText(this.Rb);
                if (this.cwo != null) {
                    button.setOnClickListener(new h(this, this, this.cwo));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Rc)) {
                z2 = false;
            } else {
                button2.setText(this.Rc);
                if (this.cwp != null) {
                    button2.setOnClickListener(new h(this, this, this.cwp));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Rd)) {
                z3 = false;
            } else {
                button3.setText(this.Rd);
                if (this.cwq != null) {
                    button3.setOnClickListener(new h(this, this, this.cwq));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this.mRootView);
        }
    }

    private void a(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        boolean[] zArr = {z2, z, z3};
        Button[] buttonArr = {button2, button, button3};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (zArr[i]) {
                arrayList.add(buttonArr[i]);
                buttonArr[i].setVisibility(0);
            } else {
                buttonArr[i].setVisibility(8);
            }
        }
        if (arrayList.size() == 3) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                a((Button) arrayList.get(i3), 0, i3 == 2 ? 0 : 20);
                i2 = i3 + 1;
            }
        }
        if (arrayList.size() == 2) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 2) {
                    break;
                }
                a((Button) arrayList.get(i5), 0, i5 == 1 ? 0 : 20);
                i4 = i5 + 1;
            }
        }
        if (arrayList.size() == 1) {
            a((Button) arrayList.get(0), 0, 0);
        }
    }

    private void a(Button button, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = b(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private f fi(boolean z) {
        if (!this.Rj) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.Rk);
            if (this.Rh != null) {
                this.mDialog.setOnCancelListener(this.Rh);
            }
            if (this.cwr != null) {
                this.mDialog.setOnKeyListener(this.cwr);
            }
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Ra == -1) {
                this.Ra = 17;
            }
            window.setGravity(this.Ra);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bs.a(this.mRootView, false, new g(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public f aqK() {
        return fi(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            k.b(this.mDialog, this.mActivity);
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
