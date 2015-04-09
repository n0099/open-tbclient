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
    private String Rd;
    private String Re;
    private String Rf;
    private DialogInterface.OnCancelListener Rj;
    private i cwE;
    private i cwF;
    private i cwG;
    private DialogInterface.OnKeyListener cwH;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Rc = -1;
    private int RH = -1;
    private int cwC = u.btn_blue_bg;
    private int cwD = s.cp_cont_g;
    private boolean Rl = false;
    private boolean Rm = true;

    public f ja(int i) {
        this.RH = i;
        return this;
    }

    public f jb(int i) {
        this.cwC = i;
        return this;
    }

    public f jc(int i) {
        this.cwD = i;
        return this;
    }

    public f a(DialogInterface.OnKeyListener onKeyListener) {
        this.cwH = onKeyListener;
        return this;
    }

    public f jd(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public f a(int i, i iVar) {
        if (this.mActivity != null) {
            this.Rd = this.mActivity.getResources().getString(i);
            this.cwE = iVar;
        }
        return this;
    }

    public f b(int i, i iVar) {
        if (this.mActivity != null) {
            this.Re = this.mActivity.getResources().getString(i);
            this.cwF = iVar;
        }
        return this;
    }

    public f ff(boolean z) {
        this.Rm = z;
        return this;
    }

    public f(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(activity, w.dialog_icon_bdalert, null);
    }

    public f f(com.baidu.adp.base.j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Rl) {
            this.Rl = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(v.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(v.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(v.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(v.message);
            Button button = (Button) this.mRootView.findViewById(v.yes);
            ba.i((View) button, this.cwC);
            ba.b(button, this.cwD, 3);
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
            if (this.RH != -1) {
                ba.c(imageView, this.RH);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Rd)) {
                z = false;
            } else {
                button.setText(this.Rd);
                if (this.cwE != null) {
                    button.setOnClickListener(new h(this, this, this.cwE));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Re)) {
                z2 = false;
            } else {
                button2.setText(this.Re);
                if (this.cwF != null) {
                    button2.setOnClickListener(new h(this, this, this.cwF));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Rf)) {
                z3 = false;
            } else {
                button3.setText(this.Rf);
                if (this.cwG != null) {
                    button3.setOnClickListener(new h(this, this, this.cwG));
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

    private f fg(boolean z) {
        if (!this.Rl) {
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
            this.mDialog.setCanceledOnTouchOutside(this.Rm);
            if (this.Rj != null) {
                this.mDialog.setOnCancelListener(this.Rj);
            }
            if (this.cwH != null) {
                this.mDialog.setOnKeyListener(this.cwH);
            }
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Rc == -1) {
                this.Rc = 17;
            }
            window.setGravity(this.Rc);
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

    public f aqZ() {
        return fg(true);
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
