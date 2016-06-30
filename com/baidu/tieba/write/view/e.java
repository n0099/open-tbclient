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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String RR;
    private String RT;
    private DialogInterface.OnCancelListener RY;
    private AlertDialog Sa;
    private final ViewGroup Sb;
    private String fGv;
    private b fGw;
    private b fGx;
    private b fGy;
    private DialogInterface.OnKeyListener fGz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int RO = -1;
    private int SJ = -1;
    private int fGt = u.f.btn_blue_bg;
    private int fGu = u.d.cp_cont_g;
    private boolean Sd = false;
    private boolean Se = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e sk(int i) {
        this.SJ = i;
        return this;
    }

    public e sl(int i) {
        this.fGt = i;
        return this;
    }

    public e sm(int i) {
        this.fGu = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.fGz = onKeyListener;
        return this;
    }

    public e sn(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.RR = this.mActivity.getResources().getString(i);
            this.fGw = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.RT = this.mActivity.getResources().getString(i);
            this.fGx = bVar;
        }
        return this;
    }

    public e li(boolean z) {
        this.Se = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.Sb = (ViewGroup) LayoutInflater.from(activity).inflate(u.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e g(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Sd) {
            this.Sd = true;
            c(hVar);
            TextView textView = (TextView) this.Sb.findViewById(u.g.title);
            LinearLayout linearLayout = (LinearLayout) this.Sb.findViewById(u.g.content);
            ImageView imageView = (ImageView) this.Sb.findViewById(u.g.bdalert_icon);
            TextView textView2 = (TextView) this.Sb.findViewById(u.g.message);
            Button button = (Button) this.Sb.findViewById(u.g.yes);
            av.k(button, this.fGt);
            av.c(button, this.fGu, 3);
            Button button2 = (Button) this.Sb.findViewById(u.g.no);
            Button button3 = (Button) this.Sb.findViewById(u.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.SJ != -1) {
                av.c(imageView, this.SJ);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.RR)) {
                z = false;
            } else {
                button.setText(this.RR);
                if (this.fGw != null) {
                    button.setOnClickListener(new a(this, this.fGw));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.RT)) {
                z2 = false;
            } else {
                button2.setText(this.RT);
                if (this.fGx != null) {
                    button2.setOnClickListener(new a(this, this.fGx));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.fGv)) {
                z3 = false;
            } else {
                button3.setText(this.fGv);
                if (this.fGy != null) {
                    button3.setOnClickListener(new a(this, this.fGy));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.Sb);
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

    private e lj(boolean z) {
        if (!this.Sd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Sa != null) {
            if (z) {
                j.a(this.Sa, this.mActivity);
            } else {
                this.Sa.show();
            }
        } else {
            this.Sa = new AlertDialog.Builder(this.mActivity).create();
            this.Sa.setCanceledOnTouchOutside(this.Se);
            if (this.RY != null) {
                this.Sa.setOnCancelListener(this.RY);
            }
            if (this.fGz != null) {
                this.Sa.setOnKeyListener(this.fGz);
            }
            if (z) {
                j.a(this.Sa, this.mActivity);
            } else {
                this.Sa.show();
            }
            Window window = this.Sa.getWindow();
            if (this.RO == -1) {
                this.RO = 17;
            }
            window.setGravity(this.RO);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.Sb);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bn.a(this.Sb, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e bli() {
        return lj(true);
    }

    public void dismiss() {
        if (this.Sa != null) {
            j.b(this.Sa, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e fGB;
        private final b fGC;

        public a(e eVar, b bVar) {
            this.fGB = eVar;
            this.fGC = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fGC != null) {
                this.fGC.a(this.fGB);
            }
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
