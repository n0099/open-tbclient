package com.baidu.tieba.write.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String XT;
    private String XW;
    private String XX;
    private DialogInterface.OnCancelListener Yc;
    private AlertDialog Yd;
    private final ViewGroup Ye;
    private String eqg;
    private b eqh;
    private b eqi;
    private b eqj;
    private DialogInterface.OnKeyListener eqk;
    protected final Activity mActivity;
    private View mContentView;
    private String mTitle;
    private int XS = -1;
    private int YM = -1;
    private int eqe = t.f.btn_blue_bg;
    private int eqf = t.d.cp_cont_g;
    private boolean Yg = false;
    private boolean Yh = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e pG(int i) {
        this.YM = i;
        return this;
    }

    public e pH(int i) {
        this.eqe = i;
        return this;
    }

    public e pI(int i) {
        this.eqf = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.eqk = onKeyListener;
        return this;
    }

    public e pJ(int i) {
        if (this.mActivity != null) {
            this.XT = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.XW = this.mActivity.getResources().getString(i);
            this.eqh = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.XX = this.mActivity.getResources().getString(i);
            this.eqi = bVar;
        }
        return this;
    }

    public e iA(boolean z) {
        this.Yh = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.Ye = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Yg) {
            this.Yg = true;
            c(hVar);
            TextView textView = (TextView) this.Ye.findViewById(t.g.title);
            LinearLayout linearLayout = (LinearLayout) this.Ye.findViewById(t.g.content);
            ImageView imageView = (ImageView) this.Ye.findViewById(t.g.bdalert_icon);
            TextView textView2 = (TextView) this.Ye.findViewById(t.g.message);
            Button button = (Button) this.Ye.findViewById(t.g.yes);
            ar.k(button, this.eqe);
            ar.b(button, this.eqf, 3);
            Button button2 = (Button) this.Ye.findViewById(t.g.no);
            Button button3 = (Button) this.Ye.findViewById(t.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.YM != -1) {
                ar.c(imageView, this.YM);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.XT)) {
                textView2.setText(this.XT);
            }
            if (TextUtils.isEmpty(this.XW)) {
                z = false;
            } else {
                button.setText(this.XW);
                if (this.eqh != null) {
                    button.setOnClickListener(new a(this, this.eqh));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.XX)) {
                z2 = false;
            } else {
                button2.setText(this.XX);
                if (this.eqi != null) {
                    button2.setOnClickListener(new a(this, this.eqi));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.eqg)) {
                z3 = false;
            } else {
                button3.setText(this.eqg);
                if (this.eqj != null) {
                    button3.setOnClickListener(new a(this, this.eqj));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Ye);
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
        layoutParams.width = c(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private e iB(boolean z) {
        if (!this.Yg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Yd != null) {
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Yd, this.mActivity);
            } else {
                this.Yd.show();
            }
        } else {
            this.Yd = new AlertDialog.Builder(this.mActivity).create();
            this.Yd.setCanceledOnTouchOutside(this.Yh);
            if (this.Yc != null) {
                this.Yd.setOnCancelListener(this.Yc);
            }
            if (this.eqk != null) {
                this.Yd.setOnKeyListener(this.eqk);
            }
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Yd, this.mActivity);
            } else {
                this.Yd.show();
            }
            Window window = this.Yd.getWindow();
            if (this.XS == -1) {
                this.XS = 17;
            }
            window.setGravity(this.XS);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.Ye);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bi.a(this.Ye, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e aTS() {
        return iB(true);
    }

    public void dismiss() {
        if (this.Yd != null) {
            com.baidu.adp.lib.h.j.b(this.Yd, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e eqm;
        private final b eqn;

        public a(e eVar, b bVar) {
            this.eqm = eVar;
            this.eqn = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.eqn != null) {
                this.eqn.a(this.eqm);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
