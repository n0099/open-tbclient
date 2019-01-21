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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private String awO;
    private String awP;
    private DialogInterface.OnCancelListener awU;
    private AlertDialog awW;
    private String heo;
    private b hep;
    private b heq;
    private b her;
    private DialogInterface.OnKeyListener hes;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int awK = -1;
    private int mIconResId = -1;
    private int hem = e.f.btn_blue_bg;
    private int hen = e.d.cp_cont_g;
    private boolean awY = false;
    private boolean awZ = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a vd(int i) {
        this.mIconResId = i;
        return this;
    }

    public a ve(int i) {
        this.hem = i;
        return this;
    }

    public a vf(int i) {
        this.hen = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.hes = onKeyListener;
        return this;
    }

    public a vg(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.awO = this.mActivity.getResources().getString(i);
            this.hep = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.awP = this.mActivity.getResources().getString(i);
            this.heq = bVar;
        }
        return this;
    }

    public a ng(boolean z) {
        this.awZ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a f(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.awY) {
            this.awY = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(e.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(e.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(e.g.message);
            Button button = (Button) this.mRootView.findViewById(e.g.yes);
            al.i(button, this.hem);
            al.c(button, this.hen, 3);
            Button button2 = (Button) this.mRootView.findViewById(e.g.no);
            Button button3 = (Button) this.mRootView.findViewById(e.g.cancel);
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
                al.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.awO)) {
                z = false;
            } else {
                button.setText(this.awO);
                if (this.hep != null) {
                    button.setOnClickListener(new View$OnClickListenerC0313a(this, this.hep));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.awP)) {
                z2 = false;
            } else {
                button2.setText(this.awP);
                if (this.heq != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0313a(this, this.heq));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.heo)) {
                z3 = false;
            } else {
                button3.setText(this.heo);
                if (this.her != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0313a(this, this.her));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
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
        layoutParams.width = dipToPx(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private a nh(boolean z) {
        if (!this.awY) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awW != null) {
            if (z) {
                g.a(this.awW, this.mActivity);
            } else {
                this.awW.show();
            }
        } else {
            this.awW = new AlertDialog.Builder(this.mActivity).create();
            this.awW.setCanceledOnTouchOutside(this.awZ);
            if (this.awU != null) {
                this.awW.setOnCancelListener(this.awU);
            }
            if (this.hes != null) {
                this.awW.setOnKeyListener(this.hes);
            }
            if (z) {
                g.a(this.awW, this.mActivity);
            } else {
                this.awW.show();
            }
            Window window = this.awW.getWindow();
            if (this.awK == -1) {
                this.awK = 17;
            }
            window.setGravity(this.awK);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean H(View view) {
                    if (view instanceof EditText) {
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

    public a bAn() {
        return nh(true);
    }

    public void dismiss() {
        if (this.awW != null) {
            g.b(this.awW, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0313a implements View.OnClickListener {
        private final a heu;
        private final b hev;

        public View$OnClickListenerC0313a(a aVar, b bVar) {
            this.heu = aVar;
            this.hev = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.hev != null) {
                this.hev.a(this.heu);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
