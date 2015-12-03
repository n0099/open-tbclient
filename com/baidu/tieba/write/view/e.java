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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String Xf;
    private String Xh;
    private String Xi;
    private DialogInterface.OnCancelListener Xn;
    private AlertDialog Xo;
    private String dNO;
    private b dNP;
    private b dNQ;
    private b dNR;
    private DialogInterface.OnKeyListener dNS;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Xe = -1;
    private int XT = -1;
    private int dNM = n.e.btn_blue_bg;
    private int dNN = n.c.cp_cont_g;
    private boolean Xq = false;
    private boolean Xr = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e nt(int i) {
        this.XT = i;
        return this;
    }

    public e nu(int i) {
        this.dNM = i;
        return this;
    }

    public e nv(int i) {
        this.dNN = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.dNS = onKeyListener;
        return this;
    }

    public e nw(int i) {
        if (this.mActivity != null) {
            this.Xf = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Xh = this.mActivity.getResources().getString(i);
            this.dNP = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Xi = this.mActivity.getResources().getString(i);
            this.dNQ = bVar;
        }
        return this;
    }

    public e hG(boolean z) {
        this.Xr = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.g.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Xq) {
            this.Xq = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(n.f.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(n.f.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(n.f.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(n.f.message);
            Button button = (Button) this.mRootView.findViewById(n.f.yes);
            as.i((View) button, this.dNM);
            as.b(button, this.dNN, 3);
            Button button2 = (Button) this.mRootView.findViewById(n.f.no);
            Button button3 = (Button) this.mRootView.findViewById(n.f.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.XT != -1) {
                as.c(imageView, this.XT);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.Xf)) {
                textView2.setText(this.Xf);
            }
            if (TextUtils.isEmpty(this.Xh)) {
                z = false;
            } else {
                button.setText(this.Xh);
                if (this.dNP != null) {
                    button.setOnClickListener(new a(this, this.dNP));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Xi)) {
                z2 = false;
            } else {
                button2.setText(this.Xi);
                if (this.dNQ != null) {
                    button2.setOnClickListener(new a(this, this.dNQ));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.dNO)) {
                z3 = false;
            } else {
                button3.setText(this.dNO);
                if (this.dNR != null) {
                    button3.setOnClickListener(new a(this, this.dNR));
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
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
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

    private e hH(boolean z) {
        if (!this.Xq) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Xo != null) {
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Xo, this.mActivity);
            } else {
                this.Xo.show();
            }
        } else {
            this.Xo = new AlertDialog.Builder(this.mActivity).create();
            this.Xo.setCanceledOnTouchOutside(this.Xr);
            if (this.Xn != null) {
                this.Xo.setOnCancelListener(this.Xn);
            }
            if (this.dNS != null) {
                this.Xo.setOnKeyListener(this.dNS);
            }
            if (z) {
                com.baidu.adp.lib.h.j.a(this.Xo, this.mActivity);
            } else {
                this.Xo.show();
            }
            Window window = this.Xo.getWindow();
            if (this.Xe == -1) {
                this.Xe = 17;
            }
            window.setGravity(this.Xe);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bj.a(this.mRootView, false, (bj.a) new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e aIC() {
        return hH(true);
    }

    public void dismiss() {
        if (this.Xo != null) {
            com.baidu.adp.lib.h.j.b(this.Xo, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e dNU;
        private final b dNV;

        public a(e eVar, b bVar) {
            this.dNU = eVar;
            this.dNV = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dNV != null) {
                this.dNV.a(this.dNU);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
