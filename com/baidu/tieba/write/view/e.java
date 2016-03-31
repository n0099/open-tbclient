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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String Wp;
    private String Wq;
    private DialogInterface.OnCancelListener Wv;
    private AlertDialog Wx;
    private final ViewGroup Wy;
    private String eKc;
    private b eKd;
    private b eKe;
    private b eKf;
    private DialogInterface.OnKeyListener eKg;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Wm = -1;
    private int Xe = -1;
    private int eKa = t.f.btn_blue_bg;
    private int eKb = t.d.cp_cont_g;
    private boolean WA = false;
    private boolean WB = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e qz(int i) {
        this.Xe = i;
        return this;
    }

    public e qA(int i) {
        this.eKa = i;
        return this;
    }

    public e qB(int i) {
        this.eKb = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.eKg = onKeyListener;
        return this;
    }

    public e qC(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wp = this.mActivity.getResources().getString(i);
            this.eKd = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
            this.eKe = bVar;
        }
        return this;
    }

    public e jq(boolean z) {
        this.WB = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.Wy = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e g(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.WA) {
            this.WA = true;
            c(hVar);
            TextView textView = (TextView) this.Wy.findViewById(t.g.title);
            LinearLayout linearLayout = (LinearLayout) this.Wy.findViewById(t.g.content);
            ImageView imageView = (ImageView) this.Wy.findViewById(t.g.bdalert_icon);
            TextView textView2 = (TextView) this.Wy.findViewById(t.g.message);
            Button button = (Button) this.Wy.findViewById(t.g.yes);
            at.k(button, this.eKa);
            at.b(button, this.eKb, 3);
            Button button2 = (Button) this.Wy.findViewById(t.g.no);
            Button button3 = (Button) this.Wy.findViewById(t.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Xe != -1) {
                at.c(imageView, this.Xe);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Wp)) {
                z = false;
            } else {
                button.setText(this.Wp);
                if (this.eKd != null) {
                    button.setOnClickListener(new a(this, this.eKd));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wq)) {
                z2 = false;
            } else {
                button2.setText(this.Wq);
                if (this.eKe != null) {
                    button2.setOnClickListener(new a(this, this.eKe));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.eKc)) {
                z3 = false;
            } else {
                button3.setText(this.eKc);
                if (this.eKf != null) {
                    button3.setOnClickListener(new a(this, this.eKf));
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
            ((TbPageContext) hVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wy);
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

    private e jr(boolean z) {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wx != null) {
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Wx, this.mActivity);
            } else {
                this.Wx.show();
            }
        } else {
            this.Wx = new AlertDialog.Builder(this.mActivity).create();
            this.Wx.setCanceledOnTouchOutside(this.WB);
            if (this.Wv != null) {
                this.Wx.setOnCancelListener(this.Wv);
            }
            if (this.eKg != null) {
                this.Wx.setOnKeyListener(this.eKg);
            }
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Wx, this.mActivity);
            } else {
                this.Wx.show();
            }
            Window window = this.Wx.getWindow();
            if (this.Wm == -1) {
                this.Wm = 17;
            }
            window.setGravity(this.Wm);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.Wy);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bl.a(this.Wy, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e bas() {
        return jr(true);
    }

    public void dismiss() {
        if (this.Wx != null) {
            com.baidu.adp.lib.h.j.b(this.Wx, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e eKi;
        private final b eKj;

        public a(e eVar, b bVar) {
            this.eKi = eVar;
            this.eKj = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.eKj != null) {
                this.eKj.a(this.eKi);
            }
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
