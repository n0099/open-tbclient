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
    private String XH;
    private String XK;
    private String XL;
    private DialogInterface.OnCancelListener XQ;
    private AlertDialog XR;
    private String dVn;
    private b dVo;
    private b dVp;
    private b dVq;
    private DialogInterface.OnKeyListener dVr;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int XG = -1;
    private int Yw = -1;
    private int dVl = n.f.btn_blue_bg;
    private int dVm = n.d.cp_cont_g;
    private boolean XT = false;
    private boolean XU = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e ol(int i) {
        this.Yw = i;
        return this;
    }

    public e om(int i) {
        this.dVl = i;
        return this;
    }

    public e on(int i) {
        this.dVm = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.dVr = onKeyListener;
        return this;
    }

    public e oo(int i) {
        if (this.mActivity != null) {
            this.XH = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.XK = this.mActivity.getResources().getString(i);
            this.dVo = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.XL = this.mActivity.getResources().getString(i);
            this.dVp = bVar;
        }
        return this;
    }

    public e hP(boolean z) {
        this.XU = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.XT) {
            this.XT = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(n.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(n.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(n.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(n.g.message);
            Button button = (Button) this.mRootView.findViewById(n.g.yes);
            as.i((View) button, this.dVl);
            as.b(button, this.dVm, 3);
            Button button2 = (Button) this.mRootView.findViewById(n.g.no);
            Button button3 = (Button) this.mRootView.findViewById(n.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Yw != -1) {
                as.c(imageView, this.Yw);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.XH)) {
                textView2.setText(this.XH);
            }
            if (TextUtils.isEmpty(this.XK)) {
                z = false;
            } else {
                button.setText(this.XK);
                if (this.dVo != null) {
                    button.setOnClickListener(new a(this, this.dVo));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.XL)) {
                z2 = false;
            } else {
                button2.setText(this.XL);
                if (this.dVp != null) {
                    button2.setOnClickListener(new a(this, this.dVp));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.dVn)) {
                z3 = false;
            } else {
                button3.setText(this.dVn);
                if (this.dVq != null) {
                    button3.setOnClickListener(new a(this, this.dVq));
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

    private e hQ(boolean z) {
        if (!this.XT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.XR != null) {
            if (z) {
                com.baidu.adp.lib.h.j.a(this.XR, this.mActivity);
            } else {
                this.XR.show();
            }
        } else {
            this.XR = new AlertDialog.Builder(this.mActivity).create();
            this.XR.setCanceledOnTouchOutside(this.XU);
            if (this.XQ != null) {
                this.XR.setOnCancelListener(this.XQ);
            }
            if (this.dVr != null) {
                this.XR.setOnKeyListener(this.dVr);
            }
            if (z) {
                com.baidu.adp.lib.h.j.a(this.XR, this.mActivity);
            } else {
                this.XR.show();
            }
            Window window = this.XR.getWindow();
            if (this.XG == -1) {
                this.XG = 17;
            }
            window.setGravity(this.XG);
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

    public e aKX() {
        return hQ(true);
    }

    public void dismiss() {
        if (this.XR != null) {
            com.baidu.adp.lib.h.j.b(this.XR, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e dVt;
        private final b dVu;

        public a(e eVar, b bVar) {
            this.dVt = eVar;
            this.dVu = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dVu != null) {
                this.dVu.a(this.dVt);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
