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
import com.baidu.adp.lib.h.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String RA;
    private DialogInterface.OnCancelListener RF;
    private AlertDialog RH;
    private final ViewGroup RI;
    private String Rz;
    private String faS;
    private b faT;
    private b faU;
    private b faV;
    private DialogInterface.OnKeyListener faW;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Rw = -1;
    private int Ss = -1;
    private int faQ = t.f.btn_blue_bg;
    private int faR = t.d.cp_cont_g;
    private boolean RK = false;
    private boolean RL = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e qT(int i) {
        this.Ss = i;
        return this;
    }

    public e qU(int i) {
        this.faQ = i;
        return this;
    }

    public e qV(int i) {
        this.faR = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.faW = onKeyListener;
        return this;
    }

    public e qW(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Rz = this.mActivity.getResources().getString(i);
            this.faT = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.RA = this.mActivity.getResources().getString(i);
            this.faU = bVar;
        }
        return this;
    }

    public e kw(boolean z) {
        this.RL = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.RI = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e g(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.RK) {
            this.RK = true;
            c(hVar);
            TextView textView = (TextView) this.RI.findViewById(t.g.title);
            LinearLayout linearLayout = (LinearLayout) this.RI.findViewById(t.g.content);
            ImageView imageView = (ImageView) this.RI.findViewById(t.g.bdalert_icon);
            TextView textView2 = (TextView) this.RI.findViewById(t.g.message);
            Button button = (Button) this.RI.findViewById(t.g.yes);
            at.k(button, this.faQ);
            at.c(button, this.faR, 3);
            Button button2 = (Button) this.RI.findViewById(t.g.no);
            Button button3 = (Button) this.RI.findViewById(t.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Ss != -1) {
                at.c(imageView, this.Ss);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Rz)) {
                z = false;
            } else {
                button.setText(this.Rz);
                if (this.faT != null) {
                    button.setOnClickListener(new a(this, this.faT));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.RA)) {
                z2 = false;
            } else {
                button2.setText(this.RA);
                if (this.faU != null) {
                    button2.setOnClickListener(new a(this, this.faU));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.faS)) {
                z3 = false;
            } else {
                button3.setText(this.faS);
                if (this.faV != null) {
                    button3.setOnClickListener(new a(this, this.faV));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.RI);
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

    private e kx(boolean z) {
        if (!this.RK) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.RH != null) {
            if (z) {
                j.a(this.RH, this.mActivity);
            } else {
                this.RH.show();
            }
        } else {
            this.RH = new AlertDialog.Builder(this.mActivity).create();
            this.RH.setCanceledOnTouchOutside(this.RL);
            if (this.RF != null) {
                this.RH.setOnCancelListener(this.RF);
            }
            if (this.faW != null) {
                this.RH.setOnKeyListener(this.faW);
            }
            if (z) {
                j.a(this.RH, this.mActivity);
            } else {
                this.RH.show();
            }
            Window window = this.RH.getWindow();
            if (this.Rw == -1) {
                this.Rw = 17;
            }
            window.setGravity(this.Rw);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.RI);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bl.a(this.RI, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e bcM() {
        return kx(true);
    }

    public void dismiss() {
        if (this.RH != null) {
            j.b(this.RH, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e faY;
        private final b faZ;

        public a(e eVar, b bVar) {
            this.faY = eVar;
            this.faZ = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.faZ != null) {
                this.faZ.a(this.faY);
            }
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
