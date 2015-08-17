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
import com.baidu.adp.base.h;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String Wo;
    private String Wp;
    private String Wq;
    private DialogInterface.OnCancelListener Wv;
    private AlertDialog Ww;
    private String cSL;
    private b cSM;
    private b cSN;
    private b cSO;
    private DialogInterface.OnKeyListener cSP;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wn = -1;
    private int Xa = -1;
    private int cSJ = i.e.btn_blue_bg;
    private int cSK = i.c.cp_cont_g;
    private boolean Wy = false;
    private boolean Wz = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e kr(int i) {
        this.Xa = i;
        return this;
    }

    public e ks(int i) {
        this.cSJ = i;
        return this;
    }

    public e kt(int i) {
        this.cSK = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.cSP = onKeyListener;
        return this;
    }

    public e ku(int i) {
        if (this.mActivity != null) {
            this.Wo = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wp = this.mActivity.getResources().getString(i);
            this.cSM = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
            this.cSN = bVar;
        }
        return this;
    }

    public e fV(boolean z) {
        this.Wz = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Wy) {
            this.Wy = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(i.f.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(i.f.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(i.f.message);
            Button button = (Button) this.mRootView.findViewById(i.f.yes);
            al.i((View) button, this.cSJ);
            al.b(button, this.cSK, 3);
            Button button2 = (Button) this.mRootView.findViewById(i.f.no);
            Button button3 = (Button) this.mRootView.findViewById(i.f.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Xa != -1) {
                al.c(imageView, this.Xa);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.Wo)) {
                textView2.setText(this.Wo);
            }
            if (TextUtils.isEmpty(this.Wp)) {
                z = false;
            } else {
                button.setText(this.Wp);
                if (this.cSM != null) {
                    button.setOnClickListener(new a(this, this.cSM));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wq)) {
                z2 = false;
            } else {
                button2.setText(this.Wq);
                if (this.cSN != null) {
                    button2.setOnClickListener(new a(this, this.cSN));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.cSL)) {
                z3 = false;
            } else {
                button3.setText(this.cSL);
                if (this.cSO != null) {
                    button3.setOnClickListener(new a(this, this.cSO));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
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

    private e fW(boolean z) {
        if (!this.Wy) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Ww != null) {
            if (z) {
                j.a(this.Ww, this.mActivity);
            } else {
                this.Ww.show();
            }
        } else {
            this.Ww = new AlertDialog.Builder(this.mActivity).create();
            this.Ww.setCanceledOnTouchOutside(this.Wz);
            if (this.Wv != null) {
                this.Ww.setOnCancelListener(this.Wv);
            }
            if (this.cSP != null) {
                this.Ww.setOnKeyListener(this.cSP);
            }
            if (z) {
                j.a(this.Ww, this.mActivity);
            } else {
                this.Ww.show();
            }
            Window window = this.Ww.getWindow();
            if (this.Wn == -1) {
                this.Wn = 17;
            }
            window.setGravity(this.Wn);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.mRootView, false, (bb.a) new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e auH() {
        return fW(true);
    }

    public void dismiss() {
        if (this.Ww != null) {
            j.b(this.Ww, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e cSR;
        private final b cSS;

        public a(e eVar, b bVar) {
            this.cSR = eVar;
            this.cSS = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cSS != null) {
                this.cSS.a(this.cSR);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
