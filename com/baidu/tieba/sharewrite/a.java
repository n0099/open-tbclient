package com.baidu.tieba.sharewrite;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private DialogInterface.OnCancelListener acA;
    private AlertDialog acC;
    private String acu;
    private String acv;
    private String gmj;
    private b gmk;
    private b gml;
    private b gmm;
    private DialogInterface.OnKeyListener gmn;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int acq = -1;
    private int mIconResId = -1;
    private int gmh = d.f.btn_blue_bg;
    private int gmi = d.C0126d.cp_cont_g;
    private boolean acE = false;
    private boolean acF = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a sH(int i) {
        this.mIconResId = i;
        return this;
    }

    public a sI(int i) {
        this.gmh = i;
        return this;
    }

    public a sJ(int i) {
        this.gmi = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gmn = onKeyListener;
        return this;
    }

    public a sK(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.acu = this.mActivity.getResources().getString(i);
            this.gmk = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.acv = this.mActivity.getResources().getString(i);
            this.gml = bVar;
        }
        return this;
    }

    public a lY(boolean z) {
        this.acF = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a g(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.acE) {
            this.acE = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            ak.i(button, this.gmh);
            ak.c(button, this.gmi, 3);
            Button button2 = (Button) this.mRootView.findViewById(d.g.no);
            Button button3 = (Button) this.mRootView.findViewById(d.g.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.mIconResId != -1) {
                ak.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.acu)) {
                z = false;
            } else {
                button.setText(this.acu);
                if (this.gmk != null) {
                    button.setOnClickListener(new View$OnClickListenerC0214a(this, this.gmk));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.acv)) {
                z2 = false;
            } else {
                button2.setText(this.acv);
                if (this.gml != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0214a(this, this.gml));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gmj)) {
                z3 = false;
            } else {
                button3.setText(this.gmj);
                if (this.gmm != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0214a(this, this.gmm));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().u(this.mRootView);
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
        layoutParams.width = g(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private a lZ(boolean z) {
        if (!this.acE) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acC != null) {
            if (z) {
                g.a(this.acC, this.mActivity);
            } else {
                this.acC.show();
            }
        } else {
            this.acC = new AlertDialog.Builder(this.mActivity).create();
            this.acC.setCanceledOnTouchOutside(this.acF);
            if (this.acA != null) {
                this.acC.setOnCancelListener(this.acA);
            }
            if (this.gmn != null) {
                this.acC.setOnKeyListener(this.gmn);
            }
            if (z) {
                g.a(this.acC, this.mActivity);
            } else {
                this.acC.show();
            }
            Window window = this.acC.getWindow();
            if (this.acq == -1) {
                this.acq = 17;
            }
            window.setGravity(this.acq);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            az.a(this.mRootView, false, new az.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.az.a
                public boolean x(View view2) {
                    if (view2 instanceof EditText) {
                        atomicBoolean.set(true);
                        return true;
                    }
                    return false;
                }
            });
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public a bnB() {
        return lZ(true);
    }

    public void dismiss() {
        if (this.acC != null) {
            g.b(this.acC, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0214a implements View.OnClickListener {
        private final a gmp;
        private final b gmq;

        public View$OnClickListenerC0214a(a aVar, b bVar) {
            this.gmp = aVar;
            this.gmq = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.gmq != null) {
                this.gmq.a(this.gmp);
            }
        }
    }

    private int g(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
