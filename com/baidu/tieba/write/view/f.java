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
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.util.bs;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    private DialogInterface.OnCancelListener RF;
    private String Ry;
    private String Rz;
    private String cAU;
    private i cAV;
    private i cAW;
    private i cAX;
    private DialogInterface.OnKeyListener cAY;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Rx = -1;
    private int Sg = -1;
    private int cAS = p.btn_blue_bg;
    private int cAT = n.cp_cont_g;
    private boolean RH = false;
    private boolean RI = true;

    public f jw(int i) {
        this.Sg = i;
        return this;
    }

    public f jx(int i) {
        this.cAS = i;
        return this;
    }

    public f jy(int i) {
        this.cAT = i;
        return this;
    }

    public f a(DialogInterface.OnKeyListener onKeyListener) {
        this.cAY = onKeyListener;
        return this;
    }

    public f jz(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public f a(int i, i iVar) {
        if (this.mActivity != null) {
            this.Ry = this.mActivity.getResources().getString(i);
            this.cAV = iVar;
        }
        return this;
    }

    public f b(int i, i iVar) {
        if (this.mActivity != null) {
            this.Rz = this.mActivity.getResources().getString(i);
            this.cAW = iVar;
        }
        return this;
    }

    public f fB(boolean z) {
        this.RI = z;
        return this;
    }

    public f(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hr().inflate(activity, r.dialog_icon_bdalert, null);
    }

    public f f(com.baidu.adp.base.j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.RH) {
            this.RH = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(q.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(q.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(q.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(q.message);
            Button button = (Button) this.mRootView.findViewById(q.yes);
            ay.i((View) button, this.cAS);
            ay.b(button, this.cAT, 3);
            Button button2 = (Button) this.mRootView.findViewById(q.no);
            Button button3 = (Button) this.mRootView.findViewById(q.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Sg != -1) {
                ay.c(imageView, this.Sg);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Ry)) {
                z = false;
            } else {
                button.setText(this.Ry);
                if (this.cAV != null) {
                    button.setOnClickListener(new h(this, this, this.cAV));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Rz)) {
                z2 = false;
            } else {
                button2.setText(this.Rz);
                if (this.cAW != null) {
                    button2.setOnClickListener(new h(this, this, this.cAW));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.cAU)) {
                z3 = false;
            } else {
                button3.setText(this.cAU);
                if (this.cAX != null) {
                    button3.setOnClickListener(new h(this, this, this.cAX));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this.mRootView);
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

    private f fC(boolean z) {
        if (!this.RH) {
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
            this.mDialog.setCanceledOnTouchOutside(this.RI);
            if (this.RF != null) {
                this.mDialog.setOnCancelListener(this.RF);
            }
            if (this.cAY != null) {
                this.mDialog.setOnKeyListener(this.cAY);
            }
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Rx == -1) {
                this.Rx = 17;
            }
            window.setGravity(this.Rx);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bq.a(this.mRootView, false, (bs) new g(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public f asP() {
        return fC(true);
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
