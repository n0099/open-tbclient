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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private DialogInterface.OnCancelListener akC;
    private AlertDialog akE;
    private String akw;
    private String akx;
    private String gCI;
    private b gCJ;
    private b gCK;
    private b gCL;
    private DialogInterface.OnKeyListener gCM;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aks = -1;
    private int mIconResId = -1;
    private int gCG = d.f.btn_blue_bg;
    private int gCH = d.C0140d.cp_cont_g;
    private boolean akG = false;
    private boolean akH = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a tb(int i) {
        this.mIconResId = i;
        return this;
    }

    public a tc(int i) {
        this.gCG = i;
        return this;
    }

    public a td(int i) {
        this.gCH = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gCM = onKeyListener;
        return this;
    }

    public a te(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.akw = this.mActivity.getResources().getString(i);
            this.gCJ = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akx = this.mActivity.getResources().getString(i);
            this.gCK = bVar;
        }
        return this;
    }

    public a ma(boolean z) {
        this.akH = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a f(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.akG) {
            this.akG = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            am.i(button, this.gCG);
            am.c(button, this.gCH, 3);
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
                am.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.akw)) {
                z = false;
            } else {
                button.setText(this.akw);
                if (this.gCJ != null) {
                    button.setOnClickListener(new View$OnClickListenerC0233a(this, this.gCJ));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akx)) {
                z2 = false;
            } else {
                button2.setText(this.akx);
                if (this.gCK != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0233a(this, this.gCK));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gCI)) {
                z3 = false;
            } else {
                button3.setText(this.gCI);
                if (this.gCL != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0233a(this, this.gCL));
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

    private a mb(boolean z) {
        if (!this.akG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akE != null) {
            if (z) {
                g.a(this.akE, this.mActivity);
            } else {
                this.akE.show();
            }
        } else {
            this.akE = new AlertDialog.Builder(this.mActivity).create();
            this.akE.setCanceledOnTouchOutside(this.akH);
            if (this.akC != null) {
                this.akE.setOnCancelListener(this.akC);
            }
            if (this.gCM != null) {
                this.akE.setOnKeyListener(this.gCM);
            }
            if (z) {
                g.a(this.akE, this.mActivity);
            } else {
                this.akE.show();
            }
            Window window = this.akE.getWindow();
            if (this.aks == -1) {
                this.aks = 17;
            }
            window.setGravity(this.aks);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean x(View view) {
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

    public a brE() {
        return mb(true);
    }

    public void dismiss() {
        if (this.akE != null) {
            g.b(this.akE, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0233a implements View.OnClickListener {
        private final a gCO;
        private final b gCP;

        public View$OnClickListenerC0233a(a aVar, b bVar) {
            this.gCO = aVar;
            this.gCP = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gCP != null) {
                this.gCP.a(this.gCO);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
